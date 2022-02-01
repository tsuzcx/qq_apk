package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aa
  extends a
{
  private static aa UtU;
  private String mFileName = "";
  private String mFilePath = "";
  private String nhr = "";
  public int qpr = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    UtU = new aa();
    AppMethodBeat.o(109560);
  }
  
  private static String aYk(String paramString)
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
  
  public static aa heb()
  {
    return UtU;
  }
  
  public final void Dw(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.oWG != null) {
      this.oWG.Dw(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, "", Integer.valueOf(paramInt) });
    super.G(4, com.tencent.mm.plugin.ball.f.b.agW(paramString1));
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.mFileName = "";
    this.qpr = paramInt;
    ciw().hDa = 4;
    ciw().oWx = this.qpr;
    cit();
    if (this.oWE.jkf != null)
    {
      this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
      this.oWE.jkf.putString("filePath", paramString1);
      this.oWE.jkf.putString("fileExt", paramString2);
      this.oWE.jkf.putInt("sence", paramInt);
      cit();
    }
    paramString2 = d.agX(this.nhr);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = d.agX("unknown");
    }
    this.oWE.noe = paramString1.intValue();
    if (Util.isNullOrNil(this.oWE.name))
    {
      if (Util.isNullOrNil(this.mFileName)) {
        this.mFileName = aYk(this.mFilePath);
      }
      this.oWE.name = this.mFileName;
    }
    cit();
    AppMethodBeat.o(109551);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public final boolean aGh()
  {
    return true;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(109549);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aGi();
    AppMethodBeat.o(109549);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(109550);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bCB();
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
  
  public final boolean bCG()
  {
    return true;
  }
  
  public final void hRt()
  {
    AppMethodBeat.i(258706);
    if ((this.oWG != null) && (this.oWE != null) && (this.oWE.beK == 4))
    {
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.oWG.chO()), Integer.valueOf(this.oWE.beK) });
      long l1 = this.oWG.fvY();
      long l2 = System.currentTimeMillis();
      this.oWG.By(0L);
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(cij()) });
      if ((d.aG(l1, l2)) && (cij())) {
        gcO();
      }
    }
    AppMethodBeat.o(258706);
  }
  
  public final void y(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(258705);
    if (paramBoolean)
    {
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      jT(false);
      if (!cio())
      {
        FloatBallProxyUI.a(MMApplicationContext.getContext(), 1, this.oWE, cij(), this.oWH);
        AppMethodBeat.o(258705);
        return;
      }
      cis();
      fwa();
      Context localContext = MMApplicationContext.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(258705);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(258705);
        return;
      }
    }
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    cir();
    AppMethodBeat.o(258705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.aa
 * JD-Core Version:    0.7.0.1
 */