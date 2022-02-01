package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.c;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  private static f FCm;
  String kmK = "";
  String mFileName = "";
  public String mFilePath = "";
  public int pat = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    FCm = new f();
    AppMethodBeat.o(109560);
  }
  
  public static void E(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(109558);
    Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
    localIntent.setPackage("com.tencent.mtt");
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("id", 1);
      if (!paramBoolean) {}
      for (boolean bool = true;; bool = false)
      {
        localJSONObject.put("isShow", bool);
        localJSONArray.put(localJSONObject);
        localJSONObject = new JSONObject();
        localJSONObject.put("id", 2);
        localJSONObject.put("isShow", paramBoolean);
        localJSONArray.put(localJSONObject);
        localIntent.putExtra("menuItems", localJSONArray.toString());
        paramContext.sendBroadcast(localIntent);
        AppMethodBeat.o(109558);
        return;
      }
      return;
    }
    catch (Exception paramContext)
    {
      ae.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "updateQbFloatBallMenu() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(109558);
    }
  }
  
  private static String aIj(String paramString)
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
        ae.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "get file name error " + paramString.getMessage());
        paramString = " ";
        continue;
        int i = 0;
      }
    }
    paramString = paramString.substring(i, paramString.length());
    AppMethodBeat.o(109557);
    return paramString;
  }
  
  public static String aaw(String paramString)
  {
    AppMethodBeat.i(109556);
    paramString = o.aaw(aIj(paramString));
    AppMethodBeat.o(109556);
    return paramString;
  }
  
  private void fiR()
  {
    AppMethodBeat.i(109554);
    Integer localInteger2 = d.Xd(this.kmK);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = d.Xd("unknown");
    }
    this.nLK.mdM = localInteger1.intValue();
    if (bu.isNullOrNil(this.nLK.name))
    {
      if (bu.isNullOrNil(this.mFileName)) {
        this.mFileName = aIj(this.mFilePath);
      }
      this.nLK.name = this.mFileName;
    }
    bLz();
    AppMethodBeat.o(109554);
  }
  
  public static f fiS()
  {
    return FCm;
  }
  
  private void fiT()
  {
    AppMethodBeat.i(109559);
    bLD().nLC = 4;
    bLD().nLB = this.pat;
    bLz();
    AppMethodBeat.o(109559);
  }
  
  public final void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    j(paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109551);
  }
  
  public final boolean aOP(String paramString)
  {
    AppMethodBeat.i(109555);
    BallInfo localBallInfo = new BallInfo(4, b.Xc(paramString));
    paramString = null;
    if (this.nLM != null) {
      paramString = this.nLM.i(localBallInfo);
    }
    if (paramString != null)
    {
      ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "ifExistFloatBall, ball already exists, replace current ball");
      AppMethodBeat.o(109555);
      return true;
    }
    AppMethodBeat.o(109555);
    return false;
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public final boolean bhi()
  {
    return true;
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(109549);
    ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhl();
    AppMethodBeat.o(109549);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(109550);
    ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhm();
    E(ak.getContext(), false);
    AppMethodBeat.o(109550);
  }
  
  public final boolean bhq()
  {
    return true;
  }
  
  public final void fiU()
  {
    AppMethodBeat.i(217553);
    if ((this.nLM != null) && (this.nLK != null) && (this.nLK.beN == 4))
    {
      ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.nLM.bKV()), Integer.valueOf(this.nLK.beN) });
      long l1 = this.nLM.bKW();
      long l2 = System.currentTimeMillis();
      this.nLM.ts(0L);
      ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bLq()) });
      if ((d.G(l1, l2)) && (bLq())) {
        bLC();
      }
    }
    AppMethodBeat.o(217553);
  }
  
  public final void iS(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.nLM != null) {
      this.nLM.iS(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109552);
    ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.ac(4, b.Xc(paramString1));
    this.mFilePath = paramString1;
    this.kmK = paramString2;
    this.mFileName = paramString3;
    this.pat = paramInt;
    fiT();
    if (this.nLK.ioY != null)
    {
      this.nLK.ioY.putBoolean("ifAppAttachDownloadUI", false);
      this.nLK.ioY.putString("filePath", paramString1);
      this.nLK.ioY.putString("fileExt", paramString2);
      this.nLK.ioY.putInt("sence", paramInt);
      bLz();
    }
    fiR();
    AppMethodBeat.o(109552);
  }
  
  public final void o(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(217552);
    if (paramBoolean)
    {
      ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      iV(false);
      if (!bLv())
      {
        FloatBallProxyUI.a(ak.getContext(), this.nLK, bLq(), this.nLN);
        AppMethodBeat.o(217552);
        return;
      }
      bLy();
      bKY();
      Context localContext = ak.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(217552);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(217552);
        return;
      }
    }
    ae.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bLx();
    AppMethodBeat.o(217552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */