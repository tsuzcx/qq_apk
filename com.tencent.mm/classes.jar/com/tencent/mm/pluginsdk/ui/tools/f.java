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

public final class f
  extends FloatBallHelper
{
  private static f YsK;
  private String mFileName = "";
  private String mFilePath = "";
  private String tmM = "";
  public int wRr = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    YsK = new f();
    AppMethodBeat.o(109560);
  }
  
  private static String bjP(String paramString)
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
  
  public static f iOq()
  {
    return YsK;
  }
  
  public final void B(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(245556);
    if (paramBoolean)
    {
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      mr(false);
      if (!cYm())
      {
        FloatBallProxyUI.a(MMApplicationContext.getContext(), 1, this.vjV, cYg(), this.vjY);
        AppMethodBeat.o(245556);
        return;
      }
      cYq();
      cXL();
      Context localContext = MMApplicationContext.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(245556);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(245556);
        return;
      }
    }
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    cYp();
    AppMethodBeat.o(245556);
  }
  
  public final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, "", Integer.valueOf(paramInt) });
    super.J(4, com.tencent.mm.plugin.ball.f.b.ahY(paramString1));
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.mFileName = "";
    this.wRr = paramInt;
    cYv().mUU = 4;
    cYv().vjN = this.wRr;
    cYr();
    if (this.vjV.oSS != null)
    {
      this.vjV.oSS.putBoolean("ifAppAttachDownloadUI", false);
      this.vjV.oSS.putString("filePath", paramString1);
      this.vjV.oSS.putString("fileExt", paramString2);
      this.vjV.oSS.putInt("sence", paramInt);
      cYr();
    }
    paramString2 = d.ahZ(this.tmM);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = d.ahZ("unknown");
    }
    this.vjV.tus = paramString1.intValue();
    if (Util.isNullOrNil(this.vjV.name))
    {
      if (Util.isNullOrNil(this.mFileName)) {
        this.mFileName = bjP(this.mFilePath);
      }
      this.vjV.name = this.mFileName;
    }
    cYr();
    AppMethodBeat.o(109551);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(109549);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhV();
    AppMethodBeat.o(109549);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(109550);
    Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.coj();
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
  
  public final boolean cop()
  {
    return true;
  }
  
  public final void iOr()
  {
    AppMethodBeat.i(245566);
    if ((this.vjX != null) && (this.vjV != null) && (this.vjV.cIh == 4))
    {
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.vjX.cXI()), Integer.valueOf(this.vjV.cIh) });
      long l1 = this.vjX.cXJ();
      long l2 = System.currentTimeMillis();
      this.vjX.kc(0L);
      Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(cYg()) });
      if ((d.ak(l1, l2)) && (cYg())) {
        cYu();
      }
    }
    AppMethodBeat.o(245566);
  }
  
  public final void mo(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.vjX != null) {
      this.vjX.mo(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */