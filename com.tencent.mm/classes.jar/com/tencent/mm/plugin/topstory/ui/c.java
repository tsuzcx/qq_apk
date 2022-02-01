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
import com.tencent.mm.g.a.vo;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.protocal.protobuf.dcv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public boolean yMj;
  public boolean yMk;
  public boolean yMl;
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(125864);
    if (ad.getLogLevel() > 1)
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
      g.afB().afk().set(ae.a.Ftu, "");
      continue;
      paramContext = new vo();
      paramContext.dBb.actionType = 2;
      com.tencent.mm.sdk.b.a.ESL.l(paramContext);
      continue;
      this.yMj = true;
      continue;
      this.yMk = true;
      continue;
      this.yMl = true;
      continue;
      paramContext = new dcv();
      paramContext.dvT = System.currentTimeMillis();
      paramContext.text = "测试测试";
      try
      {
        paramContext.AHi = Integer.valueOf(paramArrayOfString[2]).intValue();
        paramContext.type = Integer.valueOf(paramArrayOfString[3]).intValue();
        paramContext.Eun = System.currentTimeMillis();
        paramContext.huV = 300L;
        paramContext.Eul = (System.currentTimeMillis() / 1000L);
        paramContext.AHk = 1;
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
          paramContext.AHi = 2;
          paramContext.type = 1;
        }
        if (paramContext.type == 7)
        {
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().b(paramContext);
          continue;
        }
        if (paramContext.type == 10)
        {
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().x("111111", "{\"globalId\":\"assistant_my_colike\"}", System.currentTimeMillis() / 1000L);
          continue;
        }
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().a(paramContext);
      }
      continue;
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Pb(1);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Pb(7);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Pb(8);
      g.afB().afk().set(ae.a.FsI, Long.valueOf(0L));
      g.afB().afk().set(ae.a.FsJ, Long.valueOf(0L));
      g.afB().afk().set(ae.a.FsK, Integer.valueOf(0));
      continue;
      g.afB().afk().set(ae.a.Fub, Long.valueOf(0L));
      g.afB().afk().eKy();
      continue;
      paramArrayOfString = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().dNC();
      if (paramArrayOfString != null)
      {
        paramContext = aj.getContext();
        paramString = new StringBuilder("count:").append(((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().dNA()).append("cmt: ");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        paramArrayOfString = paramString.append(com.tencent.mm.plugin.topstory.b.e(paramArrayOfString)).append("ts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.dNF(), 0).show();
      }
      else
      {
        paramContext = aj.getContext();
        paramArrayOfString = new StringBuilder("no cmtrdts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.dNF(), 0).show();
        continue;
        paramContext = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().yKY;
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
            paramArrayOfString = i.aMP(com.tencent.mm.loader.j.b.aih() + "topstory/trace.info");
            paramString = new TextView(paramContext);
            paramString.setText(paramArrayOfString);
            paramString.setGravity(19);
            paramString.setTextSize(1, 10.0F);
            paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            paramString.setTextColor(ao.aD(paramContext, 2130968584));
            paramString.setTypeface(Typeface.MONOSPACE);
            i = paramContext.getResources().getDimensionPixelSize(2131165480);
            paramString.setPadding(i, i, i, i);
            paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
            h.a(paramContext, null, paramString, null);
          }
          catch (Exception paramContext) {}
          continue;
          i.cO(aa.RZ(1).eil(), true);
          Process.killProcess(Process.myPid());
          continue;
          paramArrayOfString = new Intent(aj.getContext(), TopStoryDebugUI.class);
          paramContext = aj.getContext();
          paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().bd(paramArrayOfString);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.adn(), "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramArrayOfString.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          g.afB().afk().set(ae.a.FtR, Integer.valueOf(0));
          g.afB().afk().set(ae.a.FtS, Integer.valueOf(0));
          continue;
          g.afB().afk().set(ae.a.FsP, Integer.valueOf(0));
          g.afB().afk().eKy();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */