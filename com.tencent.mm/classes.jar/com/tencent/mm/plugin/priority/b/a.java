package com.tencent.mm.plugin.priority.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.b.a.d;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static boolean pto = false;
  
  private static void E(Context paramContext, String paramString)
  {
    AppMethodBeat.i(54887);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(-16711936);
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131427772);
    localTextView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(54887);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(54886);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(54886);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(54886);
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
      AppMethodBeat.o(54886);
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
      ab.i("MicroMsg.Priority.PriorityCommand", "copydb");
      g.RM();
      paramContext = new File(g.RL().cachePath, "MicroMsgPriority.db").getAbsolutePath();
      com.tencent.mm.vfs.e.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
      com.tencent.mm.vfs.e.C(paramContext, "/sdcard/tencent/MicroMsg/Download/priority.db");
      continue;
      ab.i("MicroMsg.Priority.PriorityCommand", "deletedb");
      g.RM();
      com.tencent.mm.vfs.e.deleteFile(new File(g.RL().cachePath, "MicroMsgPriority.db").getAbsolutePath());
      Process.killProcess(Process.myPid());
      continue;
      ab.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", new Object[] { paramArrayOfString[2] });
      for (;;)
      {
        try
        {
          if (!paramArrayOfString[2].equals("1")) {
            break label354;
          }
          bool = true;
          pto = bool;
        }
        catch (Exception paramContext)
        {
          pto = false;
        }
        break;
        label354:
        boolean bool = false;
      }
      if ((paramArrayOfString.length > 2) && (t.lA(paramString)))
      {
        paramString = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fL(paramString, paramArrayOfString[2]);
        paramArrayOfString = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[] { paramArrayOfString[2], ((b)g.E(b.class)).nE(paramArrayOfString[2]), Double.valueOf(paramString[0]), Double.valueOf(paramString[1]), Double.valueOf(paramString[2]) });
        ab.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
        E(paramContext, paramArrayOfString);
      }
      else
      {
        localObject = new StringBuffer();
        if (t.lA(paramString))
        {
          paramArrayOfString = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fL(paramString, "@all");
          paramString = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().WU(paramString).iterator();
          while (paramString.hasNext())
          {
            awh localawh = (awh)paramString.next();
            ((StringBuffer)localObject).append("\n");
            ((StringBuffer)localObject).append(((b)g.E(b.class)).nE(localawh.xlH));
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(localawh.xlH);
            ((StringBuffer)localObject).append("][");
            ((StringBuffer)localObject).append(com.tencent.mm.pluginsdk.f.h.formatTime("yyyy-MM-dd", localawh.xlI / 1000L));
            ((StringBuffer)localObject).append("]");
            ((StringBuffer)localObject).append(String.format("%.2f %.2f %.2f %d", new Object[] { Float.valueOf(localawh.xlP), Float.valueOf(localawh.xlQ), Float.valueOf(localawh.xlR), Integer.valueOf(localawh.xlN) }));
          }
        }
        for (;;)
        {
          paramArrayOfString = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[] { Double.valueOf(paramArrayOfString[0]), Double.valueOf(paramArrayOfString[1]), Double.valueOf(paramArrayOfString[2]), ((StringBuffer)localObject).toString() });
          ab.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
          E(paramContext, paramArrayOfString);
          break;
          paramArrayOfString = ((PluginPriority)g.G(PluginPriority.class)).getC2CMsgImgUsageStorage().fL(paramString, paramString);
        }
        try
        {
          long l = Long.valueOf(paramArrayOfString[2]).longValue();
          ab.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", new Object[] { Long.valueOf(l) });
          g.RL().Ru().set(ac.a.yyI, Long.valueOf(l));
        }
        catch (Exception paramContext) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.priority.b.a
 * JD-Core Version:    0.7.0.1
 */