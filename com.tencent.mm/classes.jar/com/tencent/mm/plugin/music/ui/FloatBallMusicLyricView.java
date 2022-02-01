package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.lw.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.ui.view.MarqueeLyricView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.z;
import d.k.h;
import java.util.ArrayList;

public class FloatBallMusicLyricView
  extends LinearLayout
{
  public c kce;
  public d.a vcY;
  private a vfz;
  private TextView vhi;
  private MarqueeLyricView vhj;
  private com.tencent.mm.plugin.music.model.b vhk;
  private int vhl;
  
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
    AppMethodBeat.i(195619);
    this.vfz = null;
    this.vhk = null;
    this.vhl = -1;
    this.vcY = new d.a()
    {
      public final void eV(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(195614);
        if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
          ap.f(new FloatBallMusicLyricView.2(FloatBallMusicLyricView.this, paramAnonymousInt1));
        }
        AppMethodBeat.o(195614);
      }
    };
    this.kce = new c() {};
    z.jD(paramContext).inflate(2131496277, this, true);
    this.vhi = ((TextView)findViewById(2131307881));
    this.vhj = ((MarqueeLyricView)findViewById(2131307880));
    onResume();
    AppMethodBeat.o(195619);
  }
  
  private static boolean dju()
  {
    AppMethodBeat.i(195621);
    if (1 == ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.qbO, 0))
    {
      AppMethodBeat.o(195621);
      return true;
    }
    AppMethodBeat.o(195621);
    return false;
  }
  
  private boolean djv()
  {
    AppMethodBeat.i(195626);
    if ((this.vhk == null) || (this.vhk.vfm.size() <= 2))
    {
      AppMethodBeat.o(195626);
      return true;
    }
    AppMethodBeat.o(195626);
    return false;
  }
  
  private void i(a parama)
  {
    AppMethodBeat.i(195625);
    if (!dju())
    {
      this.vhj.setVisibility(8);
      AppMethodBeat.o(195625);
      return;
    }
    this.vhk = com.tencent.mm.plugin.music.model.f.diT().h(parama);
    if (djv())
    {
      this.vhj.setVisibility(8);
      AppMethodBeat.o(195625);
      return;
    }
    this.vhl = -1;
    this.vhj.setLyricObj(this.vhk);
    this.vhj.setVisibility(0);
    AppMethodBeat.o(195625);
  }
  
  private void setMusicLyric(String paramString)
  {
    AppMethodBeat.i(195624);
    ac.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", new Object[] { paramString });
    if (this.vhj != null)
    {
      this.vfz = ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).diD();
      if (this.vfz == null)
      {
        this.vhj.setVisibility(8);
        AppMethodBeat.o(195624);
        return;
      }
      if (bs.isNullOrNil(this.vfz.field_songHAlbumUrl))
      {
        this.vhj.setVisibility(8);
        ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).a(this.vfz, false, false);
        AppMethodBeat.o(195624);
        return;
      }
      i(this.vfz);
    }
    AppMethodBeat.o(195624);
  }
  
  private void setMusicTitle(String paramString)
  {
    AppMethodBeat.i(195622);
    if (this.vhi != null) {
      this.vhi.setText(paramString);
    }
    AppMethodBeat.o(195622);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(195620);
    this.kce.alive();
    com.tencent.mm.plugin.music.e.k.diO().diB().a(this.vcY);
    AppMethodBeat.o(195620);
  }
  
  public void setMusicWrapper(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(195623);
    setMusicTitle(paramf.hNU);
    setMusicLyric(paramf.hOb);
    AppMethodBeat.o(195623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView
 * JD-Core Version:    0.7.0.1
 */