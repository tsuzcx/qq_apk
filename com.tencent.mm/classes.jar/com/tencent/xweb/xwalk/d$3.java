package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

final class d$3
  implements View.OnClickListener
{
  d$3(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154154);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/xweb/xwalk/WebDebugPage$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    this.ainW.ainP.setVisibility(8);
    paramView = this.ainW;
    Log.i("WebDebugPage", "killGPUProcess");
    paramView = (ActivityManager)paramView.mContext.getSystemService("activity");
    int i = Process.myPid();
    int j = Process.myUid();
    paramView = paramView.getRunningAppProcesses().iterator();
    while (paramView.hasNext())
    {
      localObject1 = (ActivityManager.RunningAppProcessInfo)paramView.next();
      if ((((ActivityManager.RunningAppProcessInfo)localObject1).uid == j) && (((ActivityManager.RunningAppProcessInfo)localObject1).pid != i))
      {
        Object localObject2 = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
        if ((localObject2 != null) && (((String)localObject2).contains("com.tencent.mm")) && (((ActivityManager.RunningAppProcessInfo)localObject1).processName.contains("privileged_process")))
        {
          localObject1 = c.a(((ActivityManager.RunningAppProcessInfo)localObject1).pid, new com.tencent.mm.hellhoundlib.b.a());
          localObject2 = new Object();
          com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/xweb/xwalk/WebDebugPage", "killGPUProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/xweb/xwalk/WebDebugPage", "killGPUProcess", "(Landroid/content/Context;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        }
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154154);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.3
 * JD-Core Version:    0.7.0.1
 */