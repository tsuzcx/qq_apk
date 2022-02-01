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
  private static f Cmq;
  String joX = "";
  String mFileName = "";
  public String mFilePath = "";
  public int nNu = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    Cmq = new f();
    AppMethodBeat.o(109560);
  }
  
  public static void B(Context paramContext, boolean paramBoolean)
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
  
  public static String RK(String paramString)
  {
    AppMethodBeat.i(109556);
    paramString = i.RK(awa(paramString));
    AppMethodBeat.o(109556);
    return paramString;
  }
  
  private static String awa(String paramString)
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
  
  private void eAF()
  {
    AppMethodBeat.i(109554);
    Integer localInteger2 = d.OK(this.joX);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = d.OK("unknown");
    }
    this.mDH.kYl = localInteger1.intValue();
    if (bt.isNullOrNil(this.mDH.name))
    {
      if (bt.isNullOrNil(this.mFileName)) {
        this.mFileName = awa(this.mFilePath);
      }
      this.mDH.name = this.mFileName;
    }
    bzv();
    AppMethodBeat.o(109554);
  }
  
  public static f eAG()
  {
    return Cmq;
  }
  
  private void eAH()
  {
    AppMethodBeat.i(109559);
    bzz().mDz = 4;
    bzz().mDy = this.nNu;
    bzv();
    AppMethodBeat.o(109559);
  }
  
  public final void H(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    j(paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109551);
  }
  
  public final boolean aCy(String paramString)
  {
    AppMethodBeat.i(109555);
    BallInfo localBallInfo = new BallInfo(4, b.OJ(paramString));
    paramString = null;
    if (this.mDJ != null) {
      paramString = this.mDJ.g(localBallInfo);
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
  
  public final boolean aVX()
  {
    return false;
  }
  
  public final boolean aVY()
  {
    return true;
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(109549);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWb();
    AppMethodBeat.o(109549);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(109550);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWc();
    B(aj.getContext(), false);
    AppMethodBeat.o(109550);
  }
  
  public final boolean aWg()
  {
    return true;
  }
  
  public final void eAI()
  {
    AppMethodBeat.i(192553);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.mDJ.byR()), Integer.valueOf(this.mDH.aTB) });
    if ((this.mDJ != null) && (this.mDH.aTB == 4))
    {
      long l1 = this.mDJ.byS();
      long l2 = System.currentTimeMillis();
      this.mDJ.nt(0L);
      ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bzm()) });
      if ((d.L(l1, l2)) && (bzm())) {
        bzy();
      }
    }
    AppMethodBeat.o(192553);
  }
  
  public final void fE(boolean paramBoolean)
  {
    AppMethodBeat.i(109548);
    if (paramBoolean)
    {
      ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      in(false);
      if (!bzr())
      {
        FloatBallProxyUI.a(aj.getContext(), this.mDH, bzm(), new FloatBallProxyUI.a()
        {
          public final void wC(int paramAnonymousInt)
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
      bzu();
      byU();
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
    bzt();
    AppMethodBeat.o(109548);
  }
  
  public final void ik(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.mDJ != null) {
      this.mDJ.ik(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109552);
    ad.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.Z(4, b.OJ(paramString1));
    this.mFilePath = paramString1;
    this.joX = paramString2;
    this.mFileName = paramString3;
    this.nNu = paramInt;
    eAH();
    if (this.mDH.hsl != null)
    {
      this.mDH.hsl.putBoolean("ifAppAttachDownloadUI", false);
      this.mDH.hsl.putString("filePath", paramString1);
      this.mDH.hsl.putString("fileExt", paramString2);
      this.mDH.hsl.putInt("sence", paramInt);
      bzv();
    }
    eAF();
    AppMethodBeat.o(109552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */