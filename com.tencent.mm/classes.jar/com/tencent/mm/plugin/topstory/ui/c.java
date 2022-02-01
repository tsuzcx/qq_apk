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
import com.tencent.mm.g.a.vz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public boolean Aab;
  public boolean Aac;
  public boolean Aad;
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(125864);
    if (ac.getLogLevel() > 1)
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
      g.agR().agA().set(ah.a.GRo, "");
      continue;
      paramContext = new vz();
      paramContext.dyP.actionType = 2;
      com.tencent.mm.sdk.b.a.GpY.l(paramContext);
      continue;
      this.Aab = true;
      continue;
      this.Aac = true;
      continue;
      this.Aad = true;
      continue;
      paramContext = new dii();
      paramContext.dtG = System.currentTimeMillis();
      paramContext.text = "测试测试";
      try
      {
        paramContext.BZz = Integer.valueOf(paramArrayOfString[2]).intValue();
        paramContext.type = Integer.valueOf(paramArrayOfString[3]).intValue();
        paramContext.FRo = System.currentTimeMillis();
        paramContext.hVx = 300L;
        paramContext.FRm = (System.currentTimeMillis() / 1000L);
        paramContext.BZB = 1;
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
          paramContext.BZz = 2;
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
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Rh(1);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Rh(7);
      ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().Rh(8);
      g.agR().agA().set(ah.a.GQA, Long.valueOf(0L));
      g.agR().agA().set(ah.a.GQB, Long.valueOf(0L));
      g.agR().agA().set(ah.a.GQC, Integer.valueOf(0));
      continue;
      g.agR().agA().set(ah.a.GRV, Long.valueOf(0L));
      g.agR().agA().faa();
      continue;
      paramArrayOfString = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().ecc();
      if (paramArrayOfString != null)
      {
        paramContext = ai.getContext();
        paramString = new StringBuilder("count:").append(((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().eca()).append("cmt: ");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        paramArrayOfString = paramString.append(com.tencent.mm.plugin.topstory.b.e(paramArrayOfString)).append("ts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.ecf(), 0).show();
      }
      else
      {
        paramContext = ai.getContext();
        paramArrayOfString = new StringBuilder("no cmtrdts:");
        ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, com.tencent.mm.plugin.topstory.b.ecf(), 0).show();
        continue;
        paramContext = ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr().zYR;
        if (paramContext != null)
        {
          paramArrayOfString = ai.getContext();
          paramString = new StringBuilder("cnt: ");
          ((PluginTopStory)g.ad(PluginTopStory.class)).getRedDotMgr();
          t.makeText(paramArrayOfString, com.tencent.mm.plugin.topstory.b.e(paramContext), 0).show();
        }
        else
        {
          t.makeText(ai.getContext(), "no cntrd", 0).show();
          continue;
          try
          {
            paramArrayOfString = i.aSr(com.tencent.mm.loader.j.b.aph() + "topstory/trace.info");
            paramString = new TextView(paramContext);
            paramString.setText(paramArrayOfString);
            paramString.setGravity(19);
            paramString.setTextSize(1, 10.0F);
            paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            paramString.setTextColor(ao.aJ(paramContext, 2130968584));
            paramString.setTypeface(Typeface.MONOSPACE);
            i = paramContext.getResources().getDimensionPixelSize(2131165480);
            paramString.setPadding(i, i, i, i);
            paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
            h.a(paramContext, null, paramString, null);
          }
          catch (Exception paramContext) {}
          continue;
          i.cU(z.Uj(1).exF(), true);
          Process.killProcess(Process.myPid());
          continue;
          paramArrayOfString = new Intent(ai.getContext(), TopStoryDebugUI.class);
          paramContext = ai.getContext();
          paramArrayOfString = new com.tencent.mm.hellhoundlib.b.a().ba(paramArrayOfString);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramArrayOfString.aeD(), "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramArrayOfString.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/topstory/ui/TopStoryCommand", "processCommand", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          continue;
          g.agR().agA().set(ah.a.GRL, Integer.valueOf(0));
          g.agR().agA().set(ah.a.GRM, Integer.valueOf(0));
          continue;
          g.agR().agA().set(ah.a.GQH, Integer.valueOf(0));
          g.agR().agA().faa();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */