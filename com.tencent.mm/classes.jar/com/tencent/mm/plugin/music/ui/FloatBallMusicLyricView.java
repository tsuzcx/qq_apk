package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.ui.view.MarqueeLyricView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.k.h;
import java.util.ArrayList;

public class FloatBallMusicLyricView
  extends LinearLayout
{
  public c kwD;
  public d.a wiu;
  private a wkU;
  private TextView wmD;
  private MarqueeLyricView wmE;
  private com.tencent.mm.plugin.music.model.b wmF;
  private int wmG;
  
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
    AppMethodBeat.i(192477);
    this.wkU = null;
    this.wmF = null;
    this.wmG = -1;
    this.wiu = new d.a()
    {
      public final void eZ(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(192472);
        if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
          com.tencent.mm.sdk.platformtools.aq.f(new FloatBallMusicLyricView.2(FloatBallMusicLyricView.this, paramAnonymousInt1));
        }
        AppMethodBeat.o(192472);
      }
    };
    this.kwD = new c() {};
    z.jO(paramContext).inflate(2131496277, this, true);
    this.wmD = ((TextView)findViewById(2131307881));
    this.wmE = ((MarqueeLyricView)findViewById(2131307880));
    onResume();
    AppMethodBeat.o(192477);
  }
  
  private static boolean dtG()
  {
    AppMethodBeat.i(192479);
    if (1 == ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHr, 0))
    {
      AppMethodBeat.o(192479);
      return true;
    }
    AppMethodBeat.o(192479);
    return false;
  }
  
  private boolean dtH()
  {
    AppMethodBeat.i(192484);
    if ((this.wmF == null) || (this.wmF.wkH.size() <= 2))
    {
      AppMethodBeat.o(192484);
      return true;
    }
    AppMethodBeat.o(192484);
    return false;
  }
  
  private void i(a parama)
  {
    AppMethodBeat.i(192483);
    if (!dtG())
    {
      this.wmE.setVisibility(8);
      AppMethodBeat.o(192483);
      return;
    }
    this.wmF = com.tencent.mm.plugin.music.model.f.dtf().h(parama);
    if (dtH())
    {
      this.wmE.setVisibility(8);
      AppMethodBeat.o(192483);
      return;
    }
    this.wmG = -1;
    this.wmE.setLyricObj(this.wmF);
    this.wmE.setVisibility(0);
    AppMethodBeat.o(192483);
  }
  
  private void setMusicLyric(String paramString)
  {
    AppMethodBeat.i(192482);
    ad.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", new Object[] { paramString });
    if (this.wmE != null)
    {
      this.wkU = ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).dsP();
      if (this.wkU == null)
      {
        this.wmE.setVisibility(8);
        AppMethodBeat.o(192482);
        return;
      }
      if (bt.isNullOrNil(this.wkU.field_songHAlbumUrl))
      {
        this.wmE.setVisibility(8);
        ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).a(this.wkU, false, false);
        AppMethodBeat.o(192482);
        return;
      }
      i(this.wkU);
    }
    AppMethodBeat.o(192482);
  }
  
  private void setMusicTitle(String paramString)
  {
    AppMethodBeat.i(192480);
    if (this.wmD != null) {
      this.wmD.setText(paramString);
    }
    AppMethodBeat.o(192480);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(192478);
    this.kwD.alive();
    k.dta().dsN().a(this.wiu);
    AppMethodBeat.o(192478);
  }
  
  public void setMusicWrapper(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(192481);
    setMusicTitle(paramf.ihi);
    setMusicLyric(paramf.ihp);
    AppMethodBeat.o(192481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView
 * JD-Core Version:    0.7.0.1
 */