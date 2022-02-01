package com.tencent.mm.ui.chatting.floatball;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.e
{
  private static long Jfc;
  private static final Set<String> aeAc;
  private static boolean aeAd;
  private static com.tencent.mm.plugin.ball.c.e roL;
  private String mFilePath = "";
  private String tmM = "";
  private int wRr = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    aeAc = localHashSet;
    localHashSet.add("app_type");
    aeAc.add("app_media_id");
    aeAc.add("app_msg_id");
    aeAc.add("app_show_share");
    aeAc.add("scene");
    roL = new com.tencent.mm.plugin.ball.c.f()
    {
      public final void b(BallInfo paramAnonymousBallInfo)
      {
        AppMethodBeat.i(35856);
        a.a(paramAnonymousBallInfo);
        AppMethodBeat.o(35856);
      }
      
      public final void c(BallInfo paramAnonymousBallInfo) {}
      
      public final void d(BallInfo paramAnonymousBallInfo) {}
    };
    aeAd = false;
    Jfc = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void fSy()
  {
    AppMethodBeat.i(35863);
    new FilesPageFloatBallHelper.2(com.tencent.mm.app.f.hfK).alive();
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new u(paramString).jKS();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final boolean bhU()
  {
    AppMethodBeat.i(35858);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!y.ZC(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(35859);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bhV();
    if ((this.vkT != null) && (this.vkT.getActivity() != null)) {
      this.vkT.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void coj()
  {
    AppMethodBeat.i(35860);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.coj();
    AppMethodBeat.o(35860);
  }
  
  public final boolean cop()
  {
    return true;
  }
  
  public final void d(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(35861);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.tmM = paramString2;
    this.wRr = paramInt;
    super.J(4, b.ahY(paramString1));
    cYv().mUU = 4;
    cYv().vjN = this.wRr;
    cYr();
    if (this.vjV.oSS != null)
    {
      this.vjV.oSS.putString("filePath", paramString1);
      if (paramBoolean)
      {
        if (this.vkT.getIntent() != null)
        {
          com.tencent.mm.plugin.ball.f.a.b(this.vkT.getIntent(), this.vjV.oSS, aeAc);
          this.vjV.oSS.putBoolean("ifAppAttachDownloadUI", true);
          cYr();
          AppMethodBeat.o(35861);
        }
      }
      else
      {
        this.vjV.oSS.putBoolean("ifAppAttachDownloadUI", false);
        this.vjV.oSS.putString("fileExt", paramString2);
        this.vjV.oSS.putInt("sence", paramInt);
        cYr();
      }
    }
    AppMethodBeat.o(35861);
  }
  
  public final void qa(String paramString1, String paramString2)
  {
    AppMethodBeat.i(35862);
    Integer localInteger = d.ahZ(paramString1);
    paramString1 = localInteger;
    if (localInteger == null) {
      paramString1 = d.ahZ("unknown");
    }
    this.vjV.tus = paramString1.intValue();
    if (Util.isNullOrNil(this.vjV.name)) {
      this.vjV.name = paramString2;
    }
    cYr();
    AppMethodBeat.o(35862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.floatball.a
 * JD-Core Version:    0.7.0.1
 */