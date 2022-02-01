package com.tencent.mm.ui.chatting.g;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> Kkq;
  private static boolean Kkr;
  private static long Kks;
  private static com.tencent.mm.plugin.ball.c.f kmM;
  private String kmK = "";
  private String mFilePath = "";
  private int pat = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    Kkq = localHashSet;
    localHashSet.add("app_type");
    Kkq.add("app_media_id");
    Kkq.add("app_msg_id");
    Kkq.add("app_show_share");
    Kkq.add("scene");
    kmM = new g()
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
    Kkr = false;
    Kks = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void dhH()
  {
    AppMethodBeat.i(35863);
    com.tencent.mm.sdk.b.a.IvT.b(new c() {});
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new k(paramString).exists();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final boolean bhh()
  {
    AppMethodBeat.i(35858);
    if ((!bu.isNullOrNil(this.mFilePath)) && (!o.fB(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final boolean bhi()
  {
    return true;
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(35859);
    ae.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhl();
    if ((this.nME != null) && (this.nME.getActivity() != null)) {
      this.nME.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void bhm()
  {
    AppMethodBeat.i(35860);
    ae.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhm();
    AppMethodBeat.o(35860);
  }
  
  public final boolean bhq()
  {
    return true;
  }
  
  public final void h(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35861);
    ae.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.kmK = paramString2;
    this.pat = paramInt;
    super.ac(4, b.Xc(paramString1));
    bLD().nLC = 4;
    bLD().nLB = this.pat;
    bLz();
    if (this.nLK.ioY != null)
    {
      this.nLK.ioY.putString("filePath", paramString1);
      if (paramBoolean)
      {
        if (this.nME.getIntent() != null)
        {
          com.tencent.mm.plugin.ball.f.a.b(this.nME.getIntent(), this.nLK.ioY, Kkq);
          this.nLK.ioY.putBoolean("ifAppAttachDownloadUI", true);
          bLz();
          AppMethodBeat.o(35861);
        }
      }
      else
      {
        this.nLK.ioY.putBoolean("ifAppAttachDownloadUI", false);
        this.nLK.ioY.putString("fileExt", paramString2);
        this.nLK.ioY.putInt("sence", paramInt);
        bLz();
      }
    }
    AppMethodBeat.o(35861);
  }
  
  public final void mu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(35862);
    Integer localInteger = d.Xd(paramString1);
    paramString1 = localInteger;
    if (localInteger == null) {
      paramString1 = d.Xd("unknown");
    }
    this.nLK.mdM = paramString1.intValue();
    if (bu.isNullOrNil(this.nLK.name)) {
      this.nLK.name = paramString2;
    }
    bLz();
    AppMethodBeat.o(35862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */