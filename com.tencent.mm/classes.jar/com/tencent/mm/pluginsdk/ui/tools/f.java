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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  private static f DEH;
  String jPj = "";
  String mFileName = "";
  public String mFilePath = "";
  public int oqw = 0;
  
  static
  {
    AppMethodBeat.i(109560);
    DEH = new f();
    AppMethodBeat.o(109560);
  }
  
  public static void C(Context paramContext, boolean paramBoolean)
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
      ac.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "updateQbFloatBallMenu() Exception:%s %s", new Object[] { paramContext.getClass().getSimpleName(), paramContext.getMessage() });
      AppMethodBeat.o(109558);
    }
  }
  
  public static String VW(String paramString)
  {
    AppMethodBeat.i(109556);
    paramString = i.VW(aBs(paramString));
    AppMethodBeat.o(109556);
    return paramString;
  }
  
  private static String aBs(String paramString)
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
        ac.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "get file name error " + paramString.getMessage());
        paramString = " ";
        continue;
        int i = 0;
      }
    }
    paramString = paramString.substring(i, paramString.length());
    AppMethodBeat.o(109557);
    return paramString;
  }
  
  private void ePZ()
  {
    AppMethodBeat.i(109554);
    Integer localInteger2 = d.SU(this.jPj);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = d.SU("unknown");
    }
    this.nfN.lzV = localInteger1.intValue();
    if (bs.isNullOrNil(this.nfN.name))
    {
      if (bs.isNullOrNil(this.mFileName)) {
        this.mFileName = aBs(this.mFilePath);
      }
      this.nfN.name = this.mFileName;
    }
    bGr();
    AppMethodBeat.o(109554);
  }
  
  public static f eQa()
  {
    return DEH;
  }
  
  private void eQb()
  {
    AppMethodBeat.i(109559);
    bGv().nfG = 4;
    bGv().nfF = this.oqw;
    bGr();
    AppMethodBeat.o(109559);
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(109551);
    j(paramString1, paramString2, "", paramInt);
    AppMethodBeat.o(109551);
  }
  
  public final boolean aHQ(String paramString)
  {
    AppMethodBeat.i(109555);
    BallInfo localBallInfo = new BallInfo(4, b.ST(paramString));
    paramString = null;
    if (this.nfP != null) {
      paramString = this.nfP.h(localBallInfo);
    }
    if (paramString != null)
    {
      ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "ifExistFloatBall, ball already exists, replace current ball");
      AppMethodBeat.o(109555);
      return true;
    }
    AppMethodBeat.o(109555);
    return false;
  }
  
  public final boolean bcV()
  {
    return false;
  }
  
  public final boolean bcW()
  {
    return true;
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(109549);
    ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bcZ();
    AppMethodBeat.o(109549);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(109550);
    ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bda();
    C(ai.getContext(), false);
    AppMethodBeat.o(109550);
  }
  
  public final boolean bde()
  {
    return true;
  }
  
  public final void eQc()
  {
    AppMethodBeat.i(207478);
    if ((this.nfP != null) && (this.nfN != null) && (this.nfN.aUt == 4))
    {
      ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", new Object[] { Boolean.valueOf(this.nfP.bFN()), Integer.valueOf(this.nfN.aUt) });
      long l1 = this.nfP.bFO();
      long l2 = System.currentTimeMillis();
      this.nfP.rf(0L);
      ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Boolean.valueOf(bGi()) });
      if ((d.H(l1, l2)) && (bGi())) {
        bGu();
      }
    }
    AppMethodBeat.o(207478);
  }
  
  public final void ga(boolean paramBoolean)
  {
    AppMethodBeat.i(109548);
    if (paramBoolean)
    {
      ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
      iN(false);
      if (!bGn())
      {
        FloatBallProxyUI.a(ai.getContext(), this.nfN, bGi(), new FloatBallProxyUI.a()
        {
          public final void xt(int paramAnonymousInt)
          {
            AppMethodBeat.i(109547);
            ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, can not add ball, callback:%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
            if (paramAnonymousInt == 1)
            {
              ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, show float menu view");
              f.this.a(f.a(f.this));
            }
            AppMethodBeat.o(109547);
          }
        });
        AppMethodBeat.o(109548);
        return;
      }
      bGq();
      bFQ();
      Context localContext = ai.getContext();
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
        ac.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(109548);
        return;
      }
    }
    ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
    bGp();
    AppMethodBeat.o(109548);
  }
  
  public final void iK(boolean paramBoolean)
  {
    AppMethodBeat.i(109553);
    if (this.nfP != null) {
      this.nfP.iK(paramBoolean);
    }
    AppMethodBeat.o(109553);
  }
  
  public final void j(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    AppMethodBeat.i(109552);
    ac.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", new Object[] { paramString1, paramString2, paramString3, Integer.valueOf(paramInt) });
    super.aa(4, b.ST(paramString1));
    this.mFilePath = paramString1;
    this.jPj = paramString2;
    this.mFileName = paramString3;
    this.oqw = paramInt;
    eQb();
    if (this.nfN.hSN != null)
    {
      this.nfN.hSN.putBoolean("ifAppAttachDownloadUI", false);
      this.nfN.hSN.putString("filePath", paramString1);
      this.nfN.hSN.putString("fileExt", paramString2);
      this.nfN.hSN.putInt("sence", paramInt);
      bGr();
    }
    ePZ();
    AppMethodBeat.o(109552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.f
 * JD-Core Version:    0.7.0.1
 */