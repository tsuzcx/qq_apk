package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.h.a.rz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.b;
import com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

public final class c
  implements com.tencent.mm.pluginsdk.cmd.a
{
  public boolean pDG;
  public boolean pDH;
  public boolean pDI;
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int i = -1;
    if (y.getLogLevel() > 1) {
      return false;
    }
    if (paramArrayOfString.length < 2) {
      return true;
    }
    Object localObject = paramArrayOfString[1];
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
      return true;
      if (!((String)localObject).equals("ch")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("cu")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("st")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("mn")) {
        break;
      }
      i = 3;
      break;
      if (!((String)localObject).equals("cr")) {
        break;
      }
      i = 4;
      break;
      if (!((String)localObject).equals("rd")) {
        break;
      }
      i = 5;
      break;
      if (!((String)localObject).equals("info")) {
        break;
      }
      i = 6;
      break;
      if (!((String)localObject).equals("ct")) {
        break;
      }
      i = 7;
      break;
      if (!((String)localObject).equals("dp")) {
        break;
      }
      i = 8;
      break;
      if (!((String)localObject).equals("cst")) {
        break;
      }
      i = 9;
      break;
      g.DP().Dz().c(ac.a.uzv, "");
      continue;
      paramContext = new rz();
      paramContext.cbC.actionType = 2;
      com.tencent.mm.sdk.b.a.udP.m(paramContext);
      continue;
      this.pDG = true;
      continue;
      this.pDH = true;
      continue;
      this.pDI = true;
      continue;
      paramContext = new byd();
      paramContext.bVP = paramArrayOfString[2];
      paramContext.text = "测试测试";
      paramContext.type = 1;
      try
      {
        paramContext.qUS = Integer.valueOf(paramArrayOfString[3]).intValue();
        paramContext.tOj = System.currentTimeMillis();
        paramContext.eCv = 30L;
        paramContext.tOh = System.currentTimeMillis();
        ((PluginTopStory)g.t(PluginTopStory.class)).getRedDotMgr().a(paramContext);
      }
      catch (Exception paramArrayOfString)
      {
        for (;;)
        {
          paramContext.qUS = 2;
        }
      }
      try
      {
        paramArrayOfString = com.tencent.mm.vfs.e.bP(com.tencent.mm.compatible.util.e.bkH + "topstory/trace.info");
        localObject = new TextView(paramContext);
        ((TextView)localObject).setText(paramArrayOfString);
        ((TextView)localObject).setGravity(19);
        ((TextView)localObject).setTextSize(1, 10.0F);
        ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((TextView)localObject).setTextColor(-16711936);
        ((TextView)localObject).setTypeface(Typeface.MONOSPACE);
        i = paramContext.getResources().getDimensionPixelSize(b.b.LargePadding);
        ((TextView)localObject).setPadding(i, i, i, i);
        ((TextView)localObject).setMovementMethod(ScrollingMovementMethod.getInstance());
        h.a(paramContext, null, (View)localObject, null);
      }
      catch (Exception paramContext) {}
      continue;
      com.tencent.mm.vfs.e.K(aa.Bn(1).aoA(), true);
      Process.killProcess(Process.myPid());
      continue;
      paramContext = new Intent(ae.getContext(), TopStoryDebugUI.class);
      ae.getContext().startActivity(paramContext);
      continue;
      g.DP().Dz().c(ac.a.uzN, Integer.valueOf(0));
      g.DP().Dz().c(ac.a.uzO, Integer.valueOf(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.c
 * JD-Core Version:    0.7.0.1
 */