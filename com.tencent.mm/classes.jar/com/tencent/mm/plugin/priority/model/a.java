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
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static boolean AYj = false;
  
  private static void D(Context paramContext, String paramString)
  {
    AppMethodBeat.i(87798);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(paramContext.getResources().getColor(2131099746));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165498);
    localTextView.setPadding(i, i, i, i);
    h.a(paramContext, null, localTextView, null);
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
      g.aAi();
      paramContext = aa.z(new o(g.aAh().cachePath, "MicroMsgPriority.db").her());
      s.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
      s.nw(paramContext, "/sdcard/tencent/MicroMsg/Download/priority.db");
      continue;
      Log.i("MicroMsg.Priority.PriorityCommand", "deletedb");
      g.aAi();
      s.deleteFile(aa.z(new o(g.aAh().cachePath, "MicroMsgPriority.db").her()));
      paramContext = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
      paramArrayOfString = new Object();
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.axQ(), "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      Process.killProcess(((Integer)paramContext.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/priority/model/PriorityCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
      continue;
      Log.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", new Object[] { paramArrayOfString[2] });
      for (;;)
      {
        try
        {
          if (!paramArrayOfString[2].equals("1")) {
            break label426;
          }
          bool = true;
          AYj = bool;
        }
        catch (Exception paramContext)
        {
          AYj = false;
        }
        break;
        label426:
        boolean bool = false;
      }
      if ((paramArrayOfString.length > 2) && (ab.Eq(paramString)))
      {
        paramString = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(paramString, paramArrayOfString[2]);
        paramArrayOfString = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[] { paramArrayOfString[2], ((b)g.af(b.class)).getDisplayName(paramArrayOfString[2]), Double.valueOf(paramString[0]), Double.valueOf(paramString[1]), Double.valueOf(paramString[2]) });
        Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
        D(paramContext, paramArrayOfString);
      }
      else
      {
        localObject = new StringBuffer();
        if (ab.Eq(paramString))
        {
          paramArrayOfString = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(paramString, "@all");
          paramString = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().aKe(paramString).iterator();
          while (paramString.hasNext())
          {
            dou localdou = (dou)paramString.next();
            ((StringBuffer)localObject).append("\n");
            ((StringBuffer)localObject).append(((b)g.af(b.class)).getDisplayName(localdou.MRZ));
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(localdou.MRZ);
            ((StringBuffer)localObject).append("][");
            ((StringBuffer)localObject).append(f.formatTime("yyyy-MM-dd", localdou.MSa / 1000L));
            ((StringBuffer)localObject).append("]");
            ((StringBuffer)localObject).append(String.format("%.2f %.2f %.2f %d", new Object[] { Float.valueOf(localdou.MSh), Float.valueOf(localdou.MSi), Float.valueOf(localdou.MSj), Integer.valueOf(localdou.MSf) }));
          }
        }
        for (;;)
        {
          paramArrayOfString = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[] { Double.valueOf(paramArrayOfString[0]), Double.valueOf(paramArrayOfString[1]), Double.valueOf(paramArrayOfString[2]), ((StringBuffer)localObject).toString() });
          Log.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
          D(paramContext, paramArrayOfString);
          break;
          paramArrayOfString = ((PluginPriority)g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(paramString, paramString);
        }
        try
        {
          long l = Long.valueOf(paramArrayOfString[2]).longValue();
          Log.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", new Object[] { Long.valueOf(l) });
          g.aAh().azQ().set(ar.a.NTI, Long.valueOf(l));
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