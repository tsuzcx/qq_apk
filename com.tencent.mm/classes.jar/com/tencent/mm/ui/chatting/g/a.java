package com.tencent.mm.ui.chatting.g;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.f
{
  private static final Set<String> Pwp;
  private static boolean Pwq;
  private static long Pwr;
  private static e lqt;
  private String mFilePath = "";
  private String nhr = "";
  private int qpr = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    Pwp = localHashSet;
    localHashSet.add("app_type");
    Pwp.add("app_media_id");
    Pwp.add("app_msg_id");
    Pwp.add("app_show_share");
    Pwp.add("scene");
    lqt = new com.tencent.mm.plugin.ball.c.f()
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
    Pwq = false;
    Pwr = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public static void ebz()
  {
    AppMethodBeat.i(35863);
    EventCenter.instance.add(new IListener() {});
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new o(paramString).exists();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final boolean aGg()
  {
    AppMethodBeat.i(35858);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!s.YS(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final boolean aGh()
  {
    return true;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(35859);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aGi();
    if ((this.oXA != null) && (this.oXA.getActivity() != null)) {
      this.oXA.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void ay(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(258285);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.nhr = paramString2;
    this.qpr = paramInt;
    super.G(4, b.agW(paramString1));
    ciw().hDa = 4;
    ciw().oWx = this.qpr;
    cit();
    if (this.oWE.jkf != null)
    {
      this.oWE.jkf.putString("filePath", paramString1);
      this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
      this.oWE.jkf.putString("fileExt", paramString2);
      this.oWE.jkf.putInt("sence", paramInt);
      cit();
    }
    AppMethodBeat.o(258285);
  }
  
  public final void bCB()
  {
    AppMethodBeat.i(35860);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bCB();
    AppMethodBeat.o(35860);
  }
  
  public final boolean bCG()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */