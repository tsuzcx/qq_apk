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
import com.tencent.mm.g.a.tq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.b;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public boolean tfA;
  public boolean tfB;
  public boolean tfC;
  
  public final boolean a(Context paramContext, String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(1528);
    if (ab.getLogLevel() > 1)
    {
      AppMethodBeat.o(1528);
      return false;
    }
    if (paramArrayOfString.length < 2)
    {
      AppMethodBeat.o(1528);
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
      AppMethodBeat.o(1528);
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
      g.RL().Ru().set(ac.a.yKj, "");
      continue;
      paramContext = new tq();
      paramContext.cKf.actionType = 2;
      com.tencent.mm.sdk.b.a.ymk.l(paramContext);
      continue;
      this.tfA = true;
      continue;
      this.tfB = true;
      continue;
      this.tfC = true;
      continue;
      paramContext = new cku();
      paramContext.cDC = System.currentTimeMillis();
      paramContext.text = "测试测试";
      try
      {
        paramContext.uKd = Integer.valueOf(paramArrayOfString[2]).intValue();
        paramContext.type = Integer.valueOf(paramArrayOfString[3]).intValue();
        paramContext.xUJ = System.currentTimeMillis();
        paramContext.fSm = 300L;
        paramContext.xUH = (System.currentTimeMillis() / 1000L);
        paramContext.uKf = 1;
        if (paramContext.type == 8)
        {
          ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr();
          b.aed("testmsgid000");
        }
      }
      catch (Exception paramArrayOfString)
      {
        for (;;)
        {
          paramContext.uKd = 2;
          paramContext.type = 1;
        }
        if (paramContext.type == 7)
        {
          ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().b(paramContext);
          continue;
        }
        if (paramContext.type == 10)
        {
          ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().o("111111", "{\"globalId\":\"assistant_my_colike\"}", System.currentTimeMillis() / 1000L);
          continue;
        }
        ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().a(paramContext);
      }
      continue;
      ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().Gu(1);
      ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().Gu(7);
      ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().Gu(8);
      g.RL().Ru().set(ac.a.yJz, Long.valueOf(0L));
      g.RL().Ru().set(ac.a.yJA, Long.valueOf(0L));
      g.RL().Ru().set(ac.a.yJB, Integer.valueOf(0));
      continue;
      g.RL().Ru().set(ac.a.yKO, Long.valueOf(0L));
      g.RL().Ru().dww();
      continue;
      paramArrayOfString = ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().cIg();
      if (paramArrayOfString != null)
      {
        paramContext = ah.getContext();
        paramString = new StringBuilder("count:").append(((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().cIe()).append("cmt: ");
        ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr();
        paramArrayOfString = paramString.append(b.d(paramArrayOfString)).append("ts:");
        ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, b.cIj(), 0).show();
      }
      else
      {
        paramContext = ah.getContext();
        paramArrayOfString = new StringBuilder("no cmtrdts:");
        ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr();
        t.makeText(paramContext, b.cIj(), 0).show();
        continue;
        paramContext = ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr().teB;
        if (paramContext != null)
        {
          paramArrayOfString = ah.getContext();
          paramString = new StringBuilder("cnt: ");
          ((PluginTopStory)g.G(PluginTopStory.class)).getRedDotMgr();
          t.makeText(paramArrayOfString, b.d(paramContext), 0).show();
        }
        else
        {
          t.makeText(ah.getContext(), "no cntrd", 0).show();
          continue;
          try
          {
            paramArrayOfString = com.tencent.mm.vfs.e.cS(com.tencent.mm.compatible.util.e.eQz + "topstory/trace.info");
            paramString = new TextView(paramContext);
            paramString.setText(paramArrayOfString);
            paramString.setGravity(19);
            paramString.setTextSize(1, 10.0F);
            paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            paramString.setTextColor(-16711936);
            paramString.setTypeface(Typeface.MONOSPACE);
            i = paramContext.getResources().getDimensionPixelSize(2131427772);
            paramString.setPadding(i, i, i, i);
            paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
            h.a(paramContext, null, paramString, null);
          }
          catch (Exception paramContext) {}
          continue;
          com.tencent.mm.vfs.e.O(aa.Ja(1).aLw(), true);
          Process.killProcess(Process.myPid());
          continue;
          paramContext = new Intent(ah.getContext(), TopStoryDebugUI.class);
          ah.getContext().startActivity(paramContext);
          continue;
          g.RL().Ru().set(ac.a.yKF, Integer.valueOf(0));
          g.RL().Ru().set(ac.a.yKG, Integer.valueOf(0));
          continue;
          g.RL().Ru().set(ac.a.yJG, Integer.valueOf(0));
          g.RL().Ru().dww();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */