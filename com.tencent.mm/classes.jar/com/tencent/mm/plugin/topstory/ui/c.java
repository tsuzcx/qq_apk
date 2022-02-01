package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ws;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.dnx;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public boolean BrN;
  public boolean BrO;
  public boolean BrP;
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(125864);
    if (com.tencent.mm.sdk.platformtools.ad.getLogLevel() > 1)
    {
      AppMethodBeat.o(125864);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(125864);
      return true;
    }
    paramString = paramArrayOfString[1];
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(125864);
      return true;
      if (!paramString.equals("ch")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("cu")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("st")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("mn")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("cr")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("rd")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("rdcl")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("clrv")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("cmtrd")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("cntrd")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("info")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("ct")) {
        break;
      }
      i = 11;
      break;
      if (!paramString.equals("dp")) {
        break;
      }
      i = 12;
      break;
      if (!paramString.equals("cst")) {
        break;
      }
      i = 13;
      break;
      if (!paramString.equals("cledu")) {
        break;
      }
      i = 14;
      break;
      g.ajC().ajl().set(al.a.IDS, "");
      continue;
      paramContext = new ws();
      paramContext.dLb.actionType = 2;
      com.tencent.mm.sdk.b.a.IbL.l(paramContext);
      continue;
      this.BrN = true;
      continue;
      this.BrO = true;
      continue;
      this.BrP = true;
      continue;
      paramContext = new dnx();
      paramContext.msgId = System.currentTimeMillis();
      paramContext.text = "测试测试";
      try
      {
        paramContext.DCv = Integer.valueOf(paramArrayOfString[2]).intValue();
        paramContext.type = Integer.valueOf(paramArrayOfString[3]).intValue();
        paramContext.HBU = System.currentTimeMillis();
        paramContext.ioS = 300L;
        paramContext.HBS = (System.currentTimeMillis() / 1000L);
        paramContext.DCx = 1;
        if (paramContext.type == 8)
        {
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
          com.tencent.mm.plugin.topstory.b.c(paramContext);
        }
      }
      catch (Exception paramArrayOfString)
      {
        for (;;)
        {
          paramContext.DCv = 2;
          paramContext.type = 1;
        }
        if (paramContext.type == 7)
        {
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().b(paramContext);
          continue;
        }
        if (paramContext.type == 10)
        {
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().l("111111", "{\"globalId\":\"assistant_my_colike\"}", System.currentTimeMillis() / 1000L);
          continue;
        }
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().a(paramContext);
      }
      continue;
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().SR(1);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().SR(7);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().SR(8);
      g.ajC().ajl().set(al.a.ICX, Long.valueOf(0L));
      g.ajC().ajl().set(al.a.ICY, Long.valueOf(0L));
      g.ajC().ajl().set(al.a.ICZ, Integer.valueOf(0));
      continue;
      g.ajC().ajl().set(al.a.IEz, Long.valueOf(0L));
      g.ajC().ajl().fqc();
      continue;
      paramArrayOfString = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().eot();
      if (paramArrayOfString != null)
      {
        paramContext = aj.getContext();
        paramString = new StringBuilder("count:").append(((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().eor()).append("cmt: ");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        paramArrayOfString = paramString.append(com.tencent.mm.plugin.topstory.b.e(paramArrayOfString)).append("ts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.eow(), 0).show();
      }
      else
      {
        paramContext = aj.getContext();
        paramArrayOfString = new StringBuilder("no cmtrdts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.eow(), 0).show();
        continue;
        paramContext = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().BqD;
        if (paramContext != null)
        {
          paramArrayOfString = aj.getContext();
          paramString = new StringBuilder("cnt: ");
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
          t.makeText(paramArrayOfString, com.tencent.mm.plugin.topstory.b.e(paramContext), 0).show();
        }
        else
        {
          t.makeText(aj.getContext(), "no cntrd", 0).show();
          continue;
          try
          {
            paramArrayOfString = i.aYq(com.tencent.mm.loader.j.b.arU() + "topstory/trace.info");
            paramString = new TextView(paramContext);
            paramString.setText(paramArrayOfString);
            paramString.setGravity(19);
            paramString.setTextSize(1, 10.0F);
            paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            paramString.setTextColor(paramContext.getResources().getColor(2131099732));
            paramString.setTypeface(Typeface.MONOSPACE);
            i = paramContext.getResources().getDimensionPixelSize(2131165480);
            paramString.setPadding(i, i, i, i);
            paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
            h.a(paramContext, null, paramString, null);
          }
          catch (Exception paramContext) {}
          continue;
          i.cZ(com.tencent.mm.plugin.websearch.api.ad.Wc(1).eMw(), true);
          paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          paramArrayOfString = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahp(), "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)paramContext.mq(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          continue;
          paramArrayOfString = new Intent(aj.getContext(), TopStoryDebugUI.class);
          paramContext = aj.getContext();
          paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.ahp(), "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramArrayOfString.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          g.ajC().ajl().set(al.a.IEp, Integer.valueOf(0));
          g.ajC().ajl().set(al.a.IEq, Integer.valueOf(0));
          continue;
          g.ajC().ajl().set(al.a.IDe, Integer.valueOf(0));
          g.ajC().ajl().fqc();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */