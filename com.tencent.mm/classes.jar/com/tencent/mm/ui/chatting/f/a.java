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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> HZP;
  private static boolean HZQ;
  private static long HZR;
  private static com.tencent.mm.plugin.ball.c.f jPm;
  private String jPj = "";
  private String mFilePath = "";
  private int oqw = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    HZP = localHashSet;
    localHashSet.add("app_type");
    HZP.add("app_media_id");
    HZP.add("app_msg_id");
    HZP.add("app_show_share");
    HZP.add("scene");
    jPm = new g()
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
    HZQ = false;
    HZR = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void cVE()
  {
    AppMethodBeat.i(35863);
    com.tencent.mm.sdk.b.a.GpY.b(new c() {});
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new e(paramString).exists();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final boolean bcV()
  {
    AppMethodBeat.i(35858);
    if ((!bs.isNullOrNil(this.mFilePath)) && (!i.eA(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final boolean bcW()
  {
    return true;
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(35859);
    ac.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bcZ();
    if ((this.ngF != null) && (this.ngF.getActivity() != null)) {
      this.ngF.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void bda()
  {
    AppMethodBeat.i(35860);
    ac.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bda();
    AppMethodBeat.o(35860);
  }
  
  public final boolean bde()
  {
    return true;
  }
  
  public final void h(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35861);
    ac.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.jPj = paramString2;
    this.oqw = paramInt;
    super.aa(4, b.ST(paramString1));
    bGv().nfG = 4;
    bGv().nfF = this.oqw;
    bGr();
    if (this.nfN.hSN != null)
    {
      this.nfN.hSN.putString("filePath", paramString1);
      if (paramBoolean)
      {
        if (this.ngF.getIntent() != null)
        {
          com.tencent.mm.plugin.ball.f.a.b(this.ngF.getIntent(), this.nfN.hSN, HZP);
          this.nfN.hSN.putBoolean("ifAppAttachDownloadUI", true);
          bGr();
          AppMethodBeat.o(35861);
        }
      }
      else
      {
        this.nfN.hSN.putBoolean("ifAppAttachDownloadUI", false);
        this.nfN.hSN.putString("fileExt", paramString2);
        this.nfN.hSN.putInt("sence", paramInt);
        bGr();
      }
    }
    AppMethodBeat.o(35861);
  }
  
  public final void lP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(35862);
    Integer localInteger = d.SU(paramString1);
    paramString1 = localInteger;
    if (localInteger == null) {
      paramString1 = d.SU("unknown");
    }
    this.nfN.lzV = paramString1.intValue();
    if (bs.isNullOrNil(this.nfN.name)) {
      this.nfN.name = paramString2;
    }
    bGr();
    AppMethodBeat.o(35862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.f.a
 * JD-Core Version:    0.7.0.1
 */