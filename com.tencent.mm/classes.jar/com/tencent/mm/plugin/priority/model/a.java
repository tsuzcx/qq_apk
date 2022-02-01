package com.tencent.mm.plugin.priority.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.protocal.protobuf.cwb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static boolean xaH = false;
  
  private static void D(Context paramContext, String paramString)
  {
    AppMethodBeat.i(87798);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(paramContext.getResources().getColor(2131099732));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165480);
    localTextView.setPadding(i, i, i, i);
    h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(87798);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(87797);
    if (ae.getLogLevel() > 1)
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
      ae.i("MicroMsg.Priority.PriorityCommand", "copydb");
      g.ajS();
      paramContext = w.B(new k(g.ajR().cachePath, "MicroMsgPriority.db").fTh());
      o.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
      o.mF(paramContext, "/sdcard/tencent/MicroMsg/Download/priority.db");
      continue;
      ae.i("MicroMsg.Priority.PriorityCommand", "deletedb");
      g.ajS();
      o.deleteFile(w.B(new k(g.ajR().cachePath, "MicroMsgPriority.db").fTh()));
      paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahE(), "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      ae.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", new Object[] { paramArrayOfString[2] });
      for (;;)
      {
        try
        {
          if (!paramArrayOfString[2].equals("1")) {
            break label426;
          }
          bool = true;
          xaH = bool;
        }
        catch (Exception paramContext)
        {
          xaH = false;
        }
        break;
        label426:
        boolean bool = false;
      }
      if ((paramArrayOfString.length > 2) && (x.wb(paramString)))
      {
        paramString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iF(paramString, paramArrayOfString[2]);
        paramArrayOfString = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[] { paramArrayOfString[2], ((b)g.ab(b.class)).zP(paramArrayOfString[2]), Double.valueOf(paramString[0]), Double.valueOf(paramString[1]), Double.valueOf(paramString[2]) });
        ae.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
        D(paramContext, paramArrayOfString);
      }
      else
      {
        localObject = new StringBuffer();
        if (x.wb(paramString))
        {
          paramArrayOfString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iF(paramString, "@all");
          paramString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().avM(paramString).iterator();
          while (paramString.hasNext())
          {
            cwb localcwb = (cwb)paramString.next();
            ((StringBuffer)localObject).append("\n");
            ((StringBuffer)localObject).append(((b)g.ab(b.class)).zP(localcwb.HGP));
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(localcwb.HGP);
            ((StringBuffer)localObject).append("][");
            ((StringBuffer)localObject).append(i.formatTime("yyyy-MM-dd", localcwb.HGQ / 1000L));
            ((StringBuffer)localObject).append("]");
            ((StringBuffer)localObject).append(String.format("%.2f %.2f %.2f %d", new Object[] { Float.valueOf(localcwb.HGX), Float.valueOf(localcwb.HGY), Float.valueOf(localcwb.HGZ), Integer.valueOf(localcwb.HGV) }));
          }
        }
        for (;;)
        {
          paramArrayOfString = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[] { Double.valueOf(paramArrayOfString[0]), Double.valueOf(paramArrayOfString[1]), Double.valueOf(paramArrayOfString[2]), ((StringBuffer)localObject).toString() });
          ae.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
          D(paramContext, paramArrayOfString);
          break;
          paramArrayOfString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().iF(paramString, paramString);
        }
        try
        {
          long l = Long.valueOf(paramArrayOfString[2]).longValue();
          ae.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", new Object[] { Long.valueOf(l) });
          g.ajR().ajA().set(am.a.ILG, Long.valueOf(l));
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