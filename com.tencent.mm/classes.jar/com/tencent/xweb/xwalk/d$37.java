package com.tencent.xweb.xwalk;

import android.app.AlertDialog.Builder;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.xweb.b.h;

final class d$37
  implements View.OnClickListener
{
  d$37(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(154194);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    a.b("com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    paramView = this.SGe;
    localObject1 = new h(Environment.getExternalStorageDirectory());
    ((h)localObject1).htu();
    localObject1 = ((h)localObject1).getPath() + "/xweb_dump";
    try
    {
      localObject2 = new h((String)localObject1);
      localObject3 = ((h)localObject2).htu();
      if (localObject3.length != 0) {
        break label137;
      }
      paramView.dQ("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        paramView.dQ("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
        continue;
        int i = 0;
        for (;;)
        {
          if (i >= localObject3.length) {
            break label263;
          }
          if (localObject3[i].getName().endsWith(".zip"))
          {
            localObject2 = localObject3[i].getAbsolutePath();
            localObject3 = localObject3[i].getName();
            new AlertDialog.Builder(paramView.SzQ).setTitle("提示").setMessage("确定加载:" + (String)localObject3 + "?").setPositiveButton("确定", new d.47(paramView, localException, (String)localObject2)).setNegativeButton("取消", new d.46(paramView)).show();
            break;
          }
          i += 1;
        }
        paramView.dQ("web_dump目录下没有.zip文件", true);
      }
    }
    a.a(this, "com/tencent/xweb/xwalk/WebDebugPage$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(154194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.d.37
 * JD-Core Version:    0.7.0.1
 */