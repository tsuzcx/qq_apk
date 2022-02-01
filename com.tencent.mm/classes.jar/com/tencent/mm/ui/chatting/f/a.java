package com.tencent.mm.ui.chatting.f;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> GzU;
  private static boolean GzV;
  private static long GzW;
  private static com.tencent.mm.plugin.ball.c.f jpa;
  private String joX = "";
  private String mFilePath = "";
  private int nNu = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    GzU = localHashSet;
    localHashSet.add("app_type");
    GzU.add("app_media_id");
    GzU.add("app_msg_id");
    GzU.add("app_show_share");
    GzU.add("scene");
    jpa = new g()
    {
      public final void c(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(35856);
        a.b(paramAnonymousBallInfo);
        AppMethodBeat.o(35856);
      }
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
      
      public final void e(BallInfo paramAnonymousBallInfo) {}
    };
    GzV = false;
    GzW = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void cIt()
  {
    AppMethodBeat.i(35863);
    com.tencent.mm.sdk.b.a.ESL.b(new c() {});
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new e(paramString).exists();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final boolean aVX()
  {
    AppMethodBeat.i(35858);
    if ((!bt.isNullOrNil(this.mFilePath)) && (!i.eK(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final boolean aVY()
  {
    return true;
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(35859);
    ad.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWb();
    if ((this.mEA != null) && (this.mEA.getActivity() != null)) {
      this.mEA.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void aWc()
  {
    AppMethodBeat.i(35860);
    ad.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aWc();
    AppMethodBeat.o(35860);
  }
  
  public final boolean aWg()
  {
    return true;
  }
  
  public final void h(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35861);
    ad.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.joX = paramString2;
    this.nNu = paramInt;
    super.Z(4, b.OJ(paramString1));
    bzz().mDz = 4;
    bzz().mDy = this.nNu;
    bzv();
    if (this.mDH.hsl != null)
    {
      this.mDH.hsl.putString("filePath", paramString1);
      if (paramBoolean)
      {
        if (this.mEA.getIntent() != null)
        {
          com.tencent.mm.plugin.ball.f.a.b(this.mEA.getIntent(), this.mDH.hsl, GzU);
          this.mDH.hsl.putBoolean("ifAppAttachDownloadUI", true);
          bzv();
          AppMethodBeat.o(35861);
        }
      }
      else
      {
        this.mDH.hsl.putBoolean("ifAppAttachDownloadUI", false);
        this.mDH.hsl.putString("fileExt", paramString2);
        this.mDH.hsl.putInt("sence", paramInt);
        bzv();
      }
    }
    AppMethodBeat.o(35861);
  }
  
  public final void ls(String paramString1, String paramString2)
  {
    AppMethodBeat.i(35862);
    Integer localInteger = d.OK(paramString1);
    paramString1 = localInteger;
    if (localInteger == null) {
      paramString1 = d.OK("unknown");
    }
    this.mDH.kYl = paramString1.intValue();
    if (bt.isNullOrNil(this.mDH.name)) {
      this.mDH.name = paramString2;
    }
    bzv();
    AppMethodBeat.o(35862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.a
 * JD-Core Version:    0.7.0.1
 */