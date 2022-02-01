package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.f.a.np;
import com.tencent.mm.f.a.np.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.plugin.music.ui.view.MarqueeLyricView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import java.util.ArrayList;

public class FloatBallMusicLyricView
  extends LinearLayout
{
  public d.a FOE;
  private a FRG;
  private MarqueeLyricView FTA;
  private com.tencent.mm.plugin.music.model.e FTB;
  private int FTC;
  private TextView FTz;
  public IListener ozM;
  
  public FloatBallMusicLyricView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatBallMusicLyricView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatBallMusicLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FloatBallMusicLyricView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(259703);
    this.FRG = null;
    this.FTB = null;
    this.FTC = -1;
    this.FOE = new d.a()
    {
      public final void fK(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(260117);
        if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
          MMHandlerThread.postToMainThread(new FloatBallMusicLyricView.2(FloatBallMusicLyricView.this, paramAnonymousInt1));
        }
        AppMethodBeat.o(260117);
      }
    };
    this.ozM = new IListener() {};
    ad.kS(paramContext).inflate(a.g.float_ball_music_lyric_view, this, true);
    this.FTz = ((TextView)findViewById(a.e.music_title));
    this.FTA = ((MarqueeLyricView)findViewById(a.e.music_lyric));
    onResume();
    AppMethodBeat.o(259703);
  }
  
  private static boolean ffv()
  {
    AppMethodBeat.i(259705);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(259705);
      return true;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWT, 0))
    {
      AppMethodBeat.o(259705);
      return true;
    }
    AppMethodBeat.o(259705);
    return false;
  }
  
  private boolean ffw()
  {
    AppMethodBeat.i(259711);
    if ((this.FTB == null) || (this.FTB.FRr.size() <= 2))
    {
      AppMethodBeat.o(259711);
      return true;
    }
    AppMethodBeat.o(259711);
    return false;
  }
  
  private void j(a parama)
  {
    AppMethodBeat.i(259710);
    if (!ffv())
    {
      this.FTA.setVisibility(8);
      AppMethodBeat.o(259710);
      return;
    }
    this.FTB = o.feW().i(parama);
    if (ffw())
    {
      this.FTA.setVisibility(8);
      AppMethodBeat.o(259710);
      return;
    }
    this.FTC = -1;
    this.FTA.setLyricObj(this.FTB);
    this.FTA.setVisibility(0);
    AppMethodBeat.o(259710);
  }
  
  private void setMusicLyric(String paramString)
  {
    AppMethodBeat.i(259708);
    Log.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", new Object[] { paramString });
    if (this.FTA != null)
    {
      this.FRG = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei();
      if (this.FRG == null)
      {
        this.FTA.setVisibility(8);
        AppMethodBeat.o(259708);
        return;
      }
      if (Util.isNullOrNil(this.FRG.field_songHAlbumUrl))
      {
        this.FTA.setVisibility(8);
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).a(this.FRG, false, false);
        AppMethodBeat.o(259708);
        return;
      }
      j(this.FRG);
    }
    AppMethodBeat.o(259708);
  }
  
  private void setMusicTitle(String paramString)
  {
    AppMethodBeat.i(259706);
    if (this.FTz != null) {
      this.FTz.setText(paramString);
    }
    AppMethodBeat.o(259706);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(259704);
    this.ozM.alive();
    k.fet().feg().a(this.FOE);
    AppMethodBeat.o(259704);
  }
  
  public void setMusicWrapper(f paramf)
  {
    AppMethodBeat.i(259707);
    setMusicTitle(paramf.lVv);
    setMusicLyric(paramf.lVC);
    AppMethodBeat.o(259707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView
 * JD-Core Version:    0.7.0.1
 */