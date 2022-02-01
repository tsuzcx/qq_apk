package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends FloatBallHelper
{
  private static h Rww;
  private String mFileName = "";
  private String mFilePath = "";
  private String qia = "";
  public int tOb = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    Rww = new h();
    AppMethodBeat.o(109560);
  }
  
  private static String bkf(String paramString)
  {
    AppMethodBeat.i(109557);
    try
    {
      int j = paramString.lastIndexOf('/') + 1;
      if (j < 0) {
        break label79;
      }
      i = j;
      if (j != paramString.length()) {}
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "get file name error " + paramString.getMessage());
        paramString = " ";
        continue;
        int i = 0;
      }
    }
    paramString = paramString.substring(i, paramString.length());
    AppMethodBeat.o(109557);
    return paramString;
  }
  
  public static h hny()
  {
    return Rww;
  }
  
  public final void D(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(246689);
    if (paramBoolean)
    {
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      le(false);
      if (!cvB())
      {
        FloatBallProxyUI.a(MMApplicationContext.getContext(), 1, this.rYE, bOb(), this.rYH);
        AppMethodBeat.o(246689);
        return;
      }
      cvF();
      cvb();
      Context localContext = MMApplicationContext.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(246689);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(246689);
        return;
      }
    }
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    cvE();
    AppMethodBeat.o(246689);
  }
  
  public final void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, "", Integer.valueOf(paramInt) });
    super.I(4, com.tencent.mm.plugin.ball.f.b.aoC(paramString1));
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.mFileName = "";
    this.tOb = paramInt;
    cvL().kqZ = 4;
    cvL().rYx = this.tOb;
    cvG();
    if (this.rYE.mab != null)
    {
      this.rYE.mab.putBoolean("ifAppAttachDownloadUI", false);
      this.rYE.mab.putString("filePath", paramString1);
      this.rYE.mab.putString("fileExt", paramString2);
      this.rYE.mab.putInt("sence", paramInt);
      cvG();
    }
    paramString2 = d.aoD(this.qia);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = d.aoD("unknown");
    }
    this.rYE.qpN = paramString1.intValue();
    if (Util.isNullOrNil(this.rYE.name))
    {
      if (Util.isNullOrNil(this.mFileName)) {
        this.mFileName = bkf(this.mFilePath);
      }
      this.rYE.name = this.mFileName;
    }
    cvG();
    AppMethodBeat.o(109551);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public final boolean aOh()
  {
    return true;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(109549);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aOi();
    AppMethodBeat.o(109549);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(109550);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bNW();
    Context localContext = MMApplicationContext.getContext();
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
    localIntent.setPackage("com.tencent.mtt");
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", 1);
      localJSONObject.put("isShow", true);
      localJSONArray.put(localJSONObject);
      localJSONObject = new JSONObject();
      localJSONObject.put("id", 2);
      localJSONObject.put("isShow", false);
      localJSONArray.put(localJSONObject);
      localIntent.putExtra("menuItems", localJSONArray.toString());
      localContext.sendBroadcast(localIntent);
      AppMethodBeat.o(109550);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "updateQbFloatBallMenu() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
      AppMethodBeat.o(109550);
    }
  }
  
  public final boolean bOb()
  {
    return true;
  }
  
  public final void hnz()
  {
    AppMethodBeat.i(246692);
    if ((this.rYG != null) && (this.rYE != null) && (this.rYE.aOl == 4))
    {
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.rYG.cuY()), Integer.valueOf(this.rYE.aOl) });
      long l1 = this.rYG.cuZ();
      long l2 = System.currentTimeMillis();
      this.rYG.HL(0L);
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bOb()) });
      if ((d.M(l1, l2)) && (bOb())) {
        cvJ();
      }
    }
    AppMethodBeat.o(246692);
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.rYG != null) {
      this.rYG.lb(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.h
 * JD-Core Version:    0.7.0.1
 */