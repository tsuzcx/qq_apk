package com.tencent.mm.plugin.priority.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.b.a;
import com.tencent.mm.plugin.priority.b.b;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.protocal.protobuf.dyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static boolean GSh = false;
  
  private static void F(Context paramContext, String paramString)
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
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
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
      com.tencent.mm.kernel.h.aHH();
      paramContext = new q(com.tencent.mm.kernel.h.aHG().cachePath, "MicroMsgPriority.db").bOF();
      u.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
      u.on(paramContext, "/sdcard/tencent/MicroMsg/Download/priority.db");
      continue;
      Log.i("MicroMsg.Priority.PriorityCommand", "deletedb");
      com.tencent.mm.kernel.h.aHH();
      u.deleteFile(new q(com.tencent.mm.kernel.h.aHG().cachePath, "MicroMsgPriority.db").bOF());
      paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.b(paramArrayOfString, paramContext.aFh(), "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramArrayOfString, "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      Log.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", new Object[] { paramArrayOfString[2] });
      for (;;)
      {
        try
        {
          if (!paramArrayOfString[2].equals("1")) {
            break label420;
          }
          bool = true;
          GSh = bool;
        }
        catch (Exception paramContext)
        {
          GSh = false;
        }
        break;
        label420:
        boolean bool = false;
      }
      if ((paramArrayOfString.length > 2) && (ab.Lj(paramString)))
      {
        paramString = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jD(paramString, paramArrayOfString[2]);
        paramArrayOfString = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[] { paramArrayOfString[2], ((b)com.tencent.mm.kernel.h.ae(b.class)).PJ(paramArrayOfString[2]), Double.valueOf(paramString[0]), Double.valueOf(paramString[1]), Double.valueOf(paramString[2]) });
        Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
        F(paramContext, paramArrayOfString);
      }
      else
      {
        localObject = new StringBuffer();
        if (ab.Lj(paramString))
        {
          paramArrayOfString = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jD(paramString, "@all");
          paramString = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().aUB(paramString).iterator();
          while (paramString.hasNext())
          {
            dyq localdyq = (dyq)paramString.next();
            ((StringBuffer)localObject).append("\n");
            ((StringBuffer)localObject).append(((b)com.tencent.mm.kernel.h.ae(b.class)).PJ(localdyq.Ueg));
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(localdyq.Ueg);
            ((StringBuffer)localObject).append("][");
            ((StringBuffer)localObject).append(com.tencent.mm.pluginsdk.j.f.formatTime("yyyy-MM-dd", localdyq.Ueh / 1000L));
            ((StringBuffer)localObject).append("]");
            ((StringBuffer)localObject).append(String.format("%.2f %.2f %.2f %d", new Object[] { Float.valueOf(localdyq.Ueo), Float.valueOf(localdyq.Uep), Float.valueOf(localdyq.Ueq), Integer.valueOf(localdyq.Uem) }));
          }
        }
        for (;;)
        {
          paramArrayOfString = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[] { Double.valueOf(paramArrayOfString[0]), Double.valueOf(paramArrayOfString[1]), Double.valueOf(paramArrayOfString[2]), ((StringBuffer)localObject).toString() });
          Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
          F(paramContext, paramArrayOfString);
          break;
          paramArrayOfString = ((PluginPriority)com.tencent.mm.kernel.h.ag(PluginPriority.class)).getC2CMsgImgUsageStorage().jD(paramString, paramString);
        }
        try
        {
          long l = Long.valueOf(paramArrayOfString[2]).longValue();
          Log.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", new Object[] { Long.valueOf(l) });
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VhI, Long.valueOf(l));
        }
        catch (Exception paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.model.a
 * JD-Core Version:    0.7.0.1
 */