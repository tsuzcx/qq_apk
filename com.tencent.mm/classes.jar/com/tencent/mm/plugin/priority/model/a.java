package com.tencent.mm.plugin.priority.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.model.a.c.d;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.List;

public final class a
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public static boolean uuU = false;
  
  private static void E(Context paramContext, String paramString)
  {
    AppMethodBeat.i(87798);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(paramString);
    localTextView.setGravity(19);
    localTextView.setTextSize(1, 10.0F);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setTextColor(ao.aD(paramContext, 2130968584));
    localTextView.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131165480);
    localTextView.setPadding(i, i, i, i);
    com.tencent.mm.ui.base.h.a(paramContext, null, localTextView, null);
    AppMethodBeat.o(87798);
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(87797);
    if (ad.getLogLevel() > 1)
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
      ad.i("MicroMsg.Priority.PriorityCommand", "copydb");
      g.afC();
      paramContext = q.B(new com.tencent.mm.vfs.e(g.afB().cachePath, "MicroMsgPriority.db").fhU());
      i.deleteFile("/sdcard/tencent/MicroMsg/Download/priority.db");
      i.lC(paramContext, "/sdcard/tencent/MicroMsg/Download/priority.db");
      continue;
      ad.i("MicroMsg.Priority.PriorityCommand", "deletedb");
      g.afC();
      i.deleteFile(q.B(new com.tencent.mm.vfs.e(g.afB().cachePath, "MicroMsgPriority.db").fhU()));
      Process.killProcess(Process.myPid());
      continue;
      ad.i("MicroMsg.Priority.PriorityCommand", "enabledebug %s", new Object[] { paramArrayOfString[2] });
      for (;;)
      {
        try
        {
          if (!paramArrayOfString[2].equals("1")) {
            break label360;
          }
          bool = true;
          uuU = bool;
        }
        catch (Exception paramContext)
        {
          uuU = false;
        }
        break;
        label360:
        boolean bool = false;
      }
      if ((paramArrayOfString.length > 2) && (w.pF(paramString)))
      {
        paramString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hS(paramString, paramArrayOfString[2]);
        paramArrayOfString = String.format("%s\n%s\n DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f", new Object[] { paramArrayOfString[2], ((b)g.ab(b.class)).sh(paramArrayOfString[2]), Double.valueOf(paramString[0]), Double.valueOf(paramString[1]), Double.valueOf(paramString[2]) });
        ad.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
        E(paramContext, paramArrayOfString);
      }
      else
      {
        localObject = new StringBuffer();
        if (w.pF(paramString))
        {
          paramArrayOfString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hS(paramString, "@all");
          paramString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().aks(paramString).iterator();
          while (paramString.hasNext())
          {
            ckv localckv = (ckv)paramString.next();
            ((StringBuffer)localObject).append("\n");
            ((StringBuffer)localObject).append(((b)g.ab(b.class)).sh(localckv.Egc));
            ((StringBuffer)localObject).append("[");
            ((StringBuffer)localObject).append(localckv.Egc);
            ((StringBuffer)localObject).append("][");
            ((StringBuffer)localObject).append(com.tencent.mm.pluginsdk.g.h.formatTime("yyyy-MM-dd", localckv.Egd / 1000L));
            ((StringBuffer)localObject).append("]");
            ((StringBuffer)localObject).append(String.format("%.2f %.2f %.2f %d", new Object[] { Float.valueOf(localckv.Egk), Float.valueOf(localckv.Egl), Float.valueOf(localckv.Egm), Integer.valueOf(localckv.Egi) }));
          }
        }
        for (;;)
        {
          paramArrayOfString = String.format("DayClickRate: %.2f\nWeekClickRate: %.2f\nMonthClickRate: %.2f%s", new Object[] { Double.valueOf(paramArrayOfString[0]), Double.valueOf(paramArrayOfString[1]), Double.valueOf(paramArrayOfString[2]), ((StringBuffer)localObject).toString() });
          ad.i("MicroMsg.Priority.PriorityCommand", "printrate %s", new Object[] { paramArrayOfString });
          E(paramContext, paramArrayOfString);
          break;
          paramArrayOfString = ((PluginPriority)g.ad(PluginPriority.class)).getC2CMsgImgUsageStorage().hS(paramString, paramString);
        }
        try
        {
          long l = Long.valueOf(paramArrayOfString[2]).longValue();
          ad.i("MicroMsg.Priority.PriorityCommand", "currentCount %d", new Object[] { Long.valueOf(l) });
          g.afB().afk().set(ae.a.Fhd, Long.valueOf(l));
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