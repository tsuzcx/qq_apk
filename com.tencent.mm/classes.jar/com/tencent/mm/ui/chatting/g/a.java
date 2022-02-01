package com.tencent.mm.ui.chatting.g;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Set;

public final class a
  extends com.tencent.mm.plugin.ball.service.e
{
  private static long DlT;
  private static final Set<String> WQI;
  private static boolean WQJ;
  private static com.tencent.mm.plugin.ball.c.e old;
  private String mFilePath = "";
  private String qia = "";
  private int tOb = 0;
  
  static
  {
    AppMethodBeat.i(35866);
    HashSet localHashSet = new HashSet();
    WQI = localHashSet;
    localHashSet.add("app_type");
    WQI.add("app_media_id");
    WQI.add("app_msg_id");
    WQI.add("app_show_share");
    WQI.add("scene");
    old = new a.1();
    WQJ = false;
    DlT = 0L;
    AppMethodBeat.o(35866);
  }
  
  public a(f paramf)
  {
    super(paramf);
  }
  
  public static void eKx()
  {
    AppMethodBeat.i(35863);
    EventCenter.instance.add(new a.2());
    AppMethodBeat.o(35863);
  }
  
  public static boolean isFileExist(String paramString)
  {
    AppMethodBeat.i(35864);
    boolean bool = new q(paramString).ifE();
    AppMethodBeat.o(35864);
    return bool;
  }
  
  public final void aC(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(290042);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    this.mFilePath = paramString1;
    this.qia = paramString2;
    this.tOb = paramInt;
    super.I(4, b.aoC(paramString1));
    cvL().kqZ = 4;
    cvL().rYx = this.tOb;
    cvG();
    if (this.rYE.mab != null)
    {
      this.rYE.mab.putString("filePath", paramString1);
      this.rYE.mab.putBoolean("ifAppAttachDownloadUI", false);
      this.rYE.mab.putString("fileExt", paramString2);
      this.rYE.mab.putInt("sence", paramInt);
      cvG();
    }
    AppMethodBeat.o(290042);
  }
  
  public final boolean aOg()
  {
    AppMethodBeat.i(35858);
    if ((!Util.isNullOrNil(this.mFilePath)) && (!u.agG(this.mFilePath)))
    {
      AppMethodBeat.o(35858);
      return false;
    }
    AppMethodBeat.o(35858);
    return true;
  }
  
  public final boolean aOh()
  {
    return true;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(35859);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", new Object[] { this.mFilePath });
    super.aOi();
    if ((this.rZC != null) && (this.rZC.getActivity() != null)) {
      this.rZC.getActivity().finish();
    }
    AppMethodBeat.o(35859);
  }
  
  public final void bNW()
  {
    AppMethodBeat.i(35860);
    Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", new Object[] { this.mFilePath });
    super.bNW();
    AppMethodBeat.o(35860);
  }
  
  public final boolean bOb()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */