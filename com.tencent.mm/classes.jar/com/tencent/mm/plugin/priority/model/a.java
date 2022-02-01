package com.tencent.mm.plugin.priority.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.b.a;
import com.tencent.mm.plugin.priority.b.b;
import com.tencent.mm.plugin.priority.model.c2c.img.d;
import com.tencent.mm.protocal.protobuf.eru;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static boolean MPL = false;
  
  private static void K(Context paramContext, String paramString)
  {
    AppMethodBeat.i(87798);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(paramContext.getResources().getColor(b.a.FG_0));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(b.b.LargePadding);
    localTextView.setPadding(i, i, i, i);
    k.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(87798);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(87797);
    if (Log.getLogLevel() > 1)
    {
      AppMethodBeat.o(87797);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(87797);
      return true;
    }
    Object localObject = paramArrayOfString[1];
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(87797);
      return true;
      if (!((String)localObject).equals("copydb")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("deletedb")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("enabledebug")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("printrate")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("outlimit")) {
        break;
      }
      i = 4;
      break;
      Log.i("MicroMsg.Priority.PriorityCommand", "copydb");
      h.baF();
      paramContext = ah.v(new u(h.baE().cachePath, "MicroMsgPriority.db").jKT());
      y.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
      y.O(paramContext, "/sdcard/tencent/MicroMsg/Download/priority.db", false);
      continue;
      Log.i("MicroMsg.Priority.PriorityCommand", "deletedb");
      h.baF();
      y.deleteFile(ah.v(new u(h.baE().cachePath, "MicroMsgPriority.db").jKT()));
      paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramContext.aYi(), "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      Log.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", new Object[] { paramArrayOfString[2] });
      for (;;)
      {
        try
        {
          if (!paramArrayOfString[2].equals("1")) {
            break label427;
          }
          bool = true;
          MPL = bool;
        }
        catch (Exception paramContext)
        {
          MPL = false;
        }
        break;
        label427:
        boolean bool = false;
      }
      if ((paramArrayOfString.length > 2) && (au.bwE(paramString)))
      {
        paramString = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kX(paramString, paramArrayOfString[2]);
        paramArrayOfString = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[] { paramArrayOfString[2], ((b)h.ax(b.class)).getDisplayName(paramArrayOfString[2]), Double.valueOf(paramString[0]), Double.valueOf(paramString[1]), Double.valueOf(paramString[2]) });
        Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
        K(paramContext, paramArrayOfString);
      }
      else
      {
        localObject = new StringBuffer();
        if (au.bwE(paramString))
        {
          paramArrayOfString = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kX(paramString, "@all");
          paramString = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().aRJ(paramString).iterator();
          while (paramString.hasNext())
          {
            eru localeru = (eru)paramString.next();
            ((StringBuffer)localObject).append("\n");
            ((StringBuffer)localObject).append(((b)h.ax(b.class)).getDisplayName(localeru.abvu));
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(localeru.abvu);
            ((StringBuffer)localObject).append("][");
            ((StringBuffer)localObject).append(com.tencent.mm.pluginsdk.platformtools.f.formatTime("yyyy-MM-dd", localeru.abvv / 1000L));
            ((StringBuffer)localObject).append("]");
            ((StringBuffer)localObject).append(String.format("%.2f %.2f %.2f %d", new Object[] { Float.valueOf(localeru.abvC), Float.valueOf(localeru.abvD), Float.valueOf(localeru.abvE), Integer.valueOf(localeru.abvA) }));
          }
        }
        for (;;)
        {
          paramArrayOfString = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[] { Double.valueOf(paramArrayOfString[0]), Double.valueOf(paramArrayOfString[1]), Double.valueOf(paramArrayOfString[2]), ((StringBuffer)localObject).toString() });
          Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
          K(paramContext, paramArrayOfString);
          break;
          paramArrayOfString = ((PluginPriority)h.az(PluginPriority.class)).getC2CMsgImgUsageStorage().kX(paramString, paramString);
        }
        try
        {
          long l = Long.valueOf(paramArrayOfString[2]).longValue();
          Log.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", new Object[] { Long.valueOf(l) });
          h.baE().ban().set(at.a.acJc, Long.valueOf(l));
        }
        catch (Exception paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a
 * JD-Core Version:    0.7.0.1
 */