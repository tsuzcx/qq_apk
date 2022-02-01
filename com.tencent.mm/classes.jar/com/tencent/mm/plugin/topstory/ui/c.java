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
import com.tencent.mm.g.a.ww;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.dou;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.o;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public boolean BJm;
  public boolean BJn;
  public boolean BJo;
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(125864);
    if (ae.getLogLevel() > 1)
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
      g.ajR().ajA().set(am.a.IYs, "");
      continue;
      paramContext = new ww();
      paramContext.dMq.actionType = 2;
      com.tencent.mm.sdk.b.a.IvT.l(paramContext);
      continue;
      this.BJm = true;
      continue;
      this.BJn = true;
      continue;
      this.BJo = true;
      continue;
      paramContext = new dou();
      paramContext.msgId = System.currentTimeMillis();
      paramContext.text = "测试测试";
      try
      {
        paramContext.DUs = Integer.valueOf(paramArrayOfString[2]).intValue();
        paramContext.type = Integer.valueOf(paramArrayOfString[3]).intValue();
        paramContext.HVH = System.currentTimeMillis();
        paramContext.irN = 300L;
        paramContext.HVF = (System.currentTimeMillis() / 1000L);
        paramContext.DUu = 1;
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
          paramContext.DUs = 2;
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
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Ty(1);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Ty(7);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Ty(8);
      g.ajR().ajA().set(am.a.IXx, Long.valueOf(0L));
      g.ajR().ajA().set(am.a.IXy, Long.valueOf(0L));
      g.ajR().ajA().set(am.a.IXz, Integer.valueOf(0));
      continue;
      g.ajR().ajA().set(am.a.IYZ, Long.valueOf(0L));
      g.ajR().ajA().fuc();
      continue;
      paramArrayOfString = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().esa();
      if (paramArrayOfString != null)
      {
        paramContext = ak.getContext();
        paramString = new StringBuilder("count:").append(((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().erY()).append("cmt: ");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        paramArrayOfString = paramString.append(com.tencent.mm.plugin.topstory.b.e(paramArrayOfString)).append("ts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.esd(), 0).show();
      }
      else
      {
        paramContext = ak.getContext();
        paramArrayOfString = new StringBuilder("no cmtrdts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.esd(), 0).show();
        continue;
        paramContext = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().BIc;
        if (paramContext != null)
        {
          paramArrayOfString = ak.getContext();
          paramString = new StringBuilder("cnt: ");
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
          t.makeText(paramArrayOfString, com.tencent.mm.plugin.topstory.b.e(paramContext), 0).show();
        }
        else
        {
          t.makeText(ak.getContext(), "no cntrd", 0).show();
          continue;
          try
          {
            paramArrayOfString = o.aZT(com.tencent.mm.loader.j.b.asj() + "topstory/trace.info");
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
          o.dd(ad.WJ(1).eQf(), true);
          paramContext = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
          paramArrayOfString = new Object();
          com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, paramContext.ahE(), "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          Process.killProcess(((Integer)paramContext.mt(0)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(paramArrayOfString, "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "android/os/Process_EXEC_", "killProcess", "(I)V");
          continue;
          paramArrayOfString = new Intent(ak.getContext(), TopStoryDebugUI.class);
          paramContext = ak.getContext();
          paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bc(paramArrayOfString);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.ahE(), "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramArrayOfString.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          g.ajR().ajA().set(am.a.IYP, Integer.valueOf(0));
          g.ajR().ajA().set(am.a.IYQ, Integer.valueOf(0));
          continue;
          g.ajR().ajA().set(am.a.IXE, Integer.valueOf(0));
          g.ajR().ajA().fuc();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */