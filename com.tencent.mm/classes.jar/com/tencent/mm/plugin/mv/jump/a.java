package com.tencent.mm.plugin.mv.jump;

import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.mv.ui.open.text_status.MusicMvView;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/jump/MusicCardFeedView;", "Lcom/tencent/mm/plugin/mv/jump/MusicPullDownView;", "sourceId", "", "container", "Landroid/widget/FrameLayout;", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "musicPlayState", "", "(Ljava/lang/String;Landroid/widget/FrameLayout;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;I)V", "TAG", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isClickBackPressed", "", "()Z", "setClickBackPressed", "(Z)V", "getMusicPlayState", "()I", "setMusicPlayState", "(I)V", "beforeJumpDetail", "", "beforeJumpSource", "isInterceptMusicHandle", "onBackPressed", "onPostCloseInner", "onPostOpenInner", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends d
{
  private int LWn;
  private boolean LWo;
  private String TAG;
  
  public a(String paramString, FrameLayout paramFrameLayout, TextStatusJumpInfo paramTextStatusJumpInfo, int paramInt)
  {
    super(paramString, paramFrameLayout, paramTextStatusJumpInfo, paramInt);
    AppMethodBeat.i(286009);
    this.LWn = paramInt;
    this.TAG = "MusicCardFeedView";
    AppMethodBeat.o(286009);
  }
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  public final void gpi()
  {
    AppMethodBeat.i(286021);
    etM();
    onPostClose();
    AppMethodBeat.o(286021);
  }
  
  public final boolean gpj()
  {
    return true;
  }
  
  protected final void gpk()
  {
    AppMethodBeat.i(286036);
    zO(com.tencent.mm.aw.a.bLk());
    this.LWA = true;
    zP(false);
    boo localboo;
    Object localObject;
    dtj localdtj;
    String str;
    if (!isPlaying())
    {
      localboo = gpo();
      if (localboo != null)
      {
        localObject = ac.FLX;
        localdtj = gpn();
        str = localboo.mLQ;
        localObject = str;
        if (str == null) {
          localObject = String.valueOf(System.currentTimeMillis());
        }
        s.s(localObject, "it.songId\n              …ntTimeMillis().toString()");
        ac.a(localboo, localdtj, (String)localObject, dUD());
      }
    }
    for (;;)
    {
      Log.i(this.TAG, "onPostOpen@" + hashCode() + ' ' + gpq() + "  " + isPlaying());
      localObject = gpm();
      if (localObject != null) {
        ((MusicMvView)localObject).gqo();
      }
      sD(Util.nowSecond());
      AppMethodBeat.o(286036);
      return;
      zP(gps());
      if (gpq())
      {
        localObject = com.tencent.mm.aw.a.bLn();
        if (localObject != null)
        {
          ((f)localObject).oOY = false;
          com.tencent.mm.aw.a.b((f)localObject);
        }
        ((com.tencent.mm.aw.a.a)h.ax(com.tencent.mm.aw.a.a.class)).hj(false);
      }
      else
      {
        com.tencent.mm.aw.a.bLi();
        localboo = gpo();
        if (localboo != null)
        {
          localObject = ac.FLX;
          localdtj = gpn();
          str = localboo.mLQ;
          localObject = str;
          if (str == null) {
            localObject = String.valueOf(System.currentTimeMillis());
          }
          s.s(localObject, "it.songId\n              …ntTimeMillis().toString()");
          ac.a(localboo, localdtj, (String)localObject, dUD());
        }
      }
    }
  }
  
  protected final void gpl()
  {
    AppMethodBeat.i(286043);
    if (!this.LWA)
    {
      AppMethodBeat.o(286043);
      return;
    }
    this.LWA = false;
    boolean bool2 = gpr();
    boolean bool1;
    if (Util.secondsToNow(gpp()) >= 5L)
    {
      bool1 = true;
      if (!gpr()) {
        break label174;
      }
      j.gnw().bLi();
    }
    for (;;)
    {
      MusicMvView localMusicMvView = gpm();
      if (localMusicMvView != null) {
        localMusicMvView.gqp();
      }
      Log.i(this.TAG, "onPostClose@" + hashCode() + ' ' + bool2 + ' ' + gpq() + ' ' + bool1 + ' ' + isPlaying() + ' ' + this.LWy + ' ' + this.BuD);
      AppMethodBeat.o(286043);
      return;
      bool1 = false;
      break;
      label174:
      if ((this.LWo) && (bool1))
      {
        ((com.tencent.mm.aw.a.a)h.ax(com.tencent.mm.aw.a.a.class)).bLv();
      }
      else
      {
        this.LWy = j.gnw().gnj().gmA();
        com.tencent.mm.aw.a.bLi();
      }
    }
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(286047);
    Log.d(this.TAG, "onBackPressed");
    this.LWo = true;
    boolean bool = super.onBackPressed();
    AppMethodBeat.o(286047);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.jump.a
 * JD-Core Version:    0.7.0.1
 */