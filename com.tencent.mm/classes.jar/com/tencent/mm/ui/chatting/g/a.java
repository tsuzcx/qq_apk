package com.tencent.mm.ui.chatting.g;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.g;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> JPe;
  private static boolean JPf;
  private static long JPg;
  private static com.tencent.mm.plugin.ball.c.f kjw;
  private String kju = "";
  private String mFilePath = "";
  private int oTR = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    JPe = localHashSet;
    localHashSet.add("app_type");
    JPe.add("app_media_id");
    JPe.add("app_msg_id");
    JPe.add("app_show_share");
    JPe.add("scene");
    kjw = new g()
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
    JPf = false;
    JPg = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void deP()
  {
    AppMethodBeat.i(35863);
    com.tencent.mm.sdk.b.a.IbL.b(new a.2());
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new e(paramString).exists();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final boolean bgA()
  {
    return true;
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(35859);
    ad.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgD();
    if ((this.nHb != null) && (this.nHb.getActivity() != null)) {
      this.nHb.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(35860);
    ad.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bgE();
    AppMethodBeat.o(35860);
  }
  
  public final boolean bgI()
  {
    return true;
  }
  
  public final boolean bgz()
  {
    AppMethodBeat.i(35858);
    if ((!bt.isNullOrNil(this.mFilePath)) && (!i.fv(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final void h(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35861);
    ad.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.kju = paramString2;
    this.oTR = paramInt;
    super.ac(4, b.Wq(paramString1));
    bKG().nGc = 4;
    bKG().nGb = this.oTR;
    bKC();
    if (this.nGj.ime != null)
    {
      this.nGj.ime.putString("filePath", paramString1);
      if (paramBoolean)
      {
        if (this.nHb.getIntent() != null)
        {
          com.tencent.mm.plugin.ball.f.a.b(this.nHb.getIntent(), this.nGj.ime, JPe);
          this.nGj.ime.putBoolean("ifAppAttachDownloadUI", true);
          bKC();
          AppMethodBeat.o(35861);
        }
      }
      else
      {
        this.nGj.ime.putBoolean("ifAppAttachDownloadUI", false);
        this.nGj.ime.putString("fileExt", paramString2);
        this.nGj.ime.putInt("sence", paramInt);
        bKC();
      }
    }
    AppMethodBeat.o(35861);
  }
  
  public final void mn(String paramString1, String paramString2)
  {
    AppMethodBeat.i(35862);
    Integer localInteger = d.Wr(paramString1);
    paramString1 = localInteger;
    if (localInteger == null) {
      paramString1 = d.Wr("unknown");
    }
    this.nGj.lZt = paramString1.intValue();
    if (bt.isNullOrNil(this.nGj.name)) {
      this.nGj.name = paramString2;
    }
    bKC();
    AppMethodBeat.o(35862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */