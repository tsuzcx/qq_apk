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
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  private static f FjN;
  String kju = "";
  String mFileName = "";
  public String mFilePath = "";
  public int oTR = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    FjN = new f();
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
      ad.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "updateQbFloatBallMenu() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(109558);
    }
  }
  
  public static String ZF(String paramString)
  {
    AppMethodBeat.i(109556);
    paramString = i.ZF(aGP(paramString));
    AppMethodBeat.o(109556);
    return paramString;
  }
  
  private static String aGP(String paramString)
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
        ad.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "get file name error " + paramString.getMessage());
        paramString = " ";
        continue;
        int i = 0;
      }
    }
    paramString = paramString.substring(i, paramString.length());
    AppMethodBeat.o(109557);
    return paramString;
  }
  
  private void ffb()
  {
    AppMethodBeat.i(109554);
    Integer localInteger2 = d.Wr(this.kju);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = d.Wr("unknown");
    }
    this.nGj.lZt = localInteger1.intValue();
    if (bt.isNullOrNil(this.nGj.name))
    {
      if (bt.isNullOrNil(this.mFileName)) {
        this.mFileName = aGP(this.mFilePath);
      }
      this.nGj.name = this.mFileName;
    }
    bKC();
    AppMethodBeat.o(109554);
  }
  
  public static f ffc()
  {
    return FjN;
  }
  
  private void ffd()
  {
    AppMethodBeat.i(109559);
    bKG().nGc = 4;
    bKG().nGb = this.oTR;
    bKC();
    AppMethodBeat.o(109559);
  }
  
  public final void J(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    j(paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109551);
  }
  
  public final boolean aNs(String paramString)
  {
    AppMethodBeat.i(109555);
    BallInfo localBallInfo = new BallInfo(4, b.Wq(paramString));
    paramString = null;
    if (this.nGl != null) {
      paramString = this.nGl.i(localBallInfo);
    }
    if (paramString != null)
    {
      ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "ifExistFloatBall, ball already exists, replace current ball");
      AppMethodBeat.o(109555);
      return true;
    }
    AppMethodBeat.o(109555);
    return false;
  }
  
  public final boolean bgA()
  {
    return true;
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(109549);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgD();
    AppMethodBeat.o(109549);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(109550);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgE();
    E(aj.getContext(), false);
    AppMethodBeat.o(109550);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final void ffe()
  {
    AppMethodBeat.i(214478);
    if ((this.nGl != null) && (this.nGj != null) && (this.nGj.beN == 4))
    {
      ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.nGl.bJX()), Integer.valueOf(this.nGj.beN) });
      long l1 = this.nGl.bJY();
      long l2 = System.currentTimeMillis();
      this.nGl.te(0L);
      ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bKt()) });
      if ((d.H(l1, l2)) && (bKt())) {
        bKF();
      }
    }
    AppMethodBeat.o(214478);
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(109548);
    if (paramBoolean)
    {
      ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      iW(false);
      if (!bKy())
      {
        FloatBallProxyUI.a(aj.getContext(), this.nGj, bKt(), new FloatBallProxyUI.a()
        {
          public final void xZ(int paramAnonymousInt)
          {
            AppMethodBeat.i(109547);
            ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, can not add ball, callback:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, show float menu view");
              f.this.a(f.a(f.this));
            }
            AppMethodBeat.o(109547);
          }
        });
        AppMethodBeat.o(109548);
        return;
      }
      bKB();
      bKa();
      Context localContext = aj.getContext();
      Intent localIntent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
      localIntent.setPackage("com.tencent.mtt");
      localIntent.putExtra("key_reader_sdk_window_close", true);
      try
      {
        localContext.sendBroadcast(localIntent);
        AppMethodBeat.o(109548);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(109548);
        return;
      }
    }
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bKA();
    AppMethodBeat.o(109548);
  }
  
  public final void iT(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.nGl != null) {
      this.nGl.iT(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109552);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.ac(4, b.Wq(paramString1));
    this.mFilePath = paramString1;
    this.kju = paramString2;
    this.mFileName = paramString3;
    this.oTR = paramInt;
    ffd();
    if (this.nGj.ime != null)
    {
      this.nGj.ime.putBoolean("ifAppAttachDownloadUI", false);
      this.nGj.ime.putString("filePath", paramString1);
      this.nGj.ime.putString("fileExt", paramString2);
      this.nGj.ime.putInt("sence", paramInt);
      bKC();
    }
    ffb();
    AppMethodBeat.o(109552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */