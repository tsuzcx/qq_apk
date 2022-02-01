package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.mg.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.ui.view.MarqueeLyricView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.z;
import d.g.b.p;
import d.k.j;
import java.util.ArrayList;

public class FloatBallMusicLyricView
  extends LinearLayout
{
  public c kzS;
  private a wAD;
  private TextView wCm;
  private MarqueeLyricView wCn;
  private com.tencent.mm.plugin.music.model.b wCo;
  private int wCp;
  public d.a wxZ;
  
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
    AppMethodBeat.i(220690);
    this.wAD = null;
    this.wCo = null;
    this.wCp = -1;
    this.wxZ = new d.a()
    {
      public final void fa(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(220685);
        if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
          ar.f(new FloatBallMusicLyricView.2(FloatBallMusicLyricView.this, paramAnonymousInt1));
        }
        AppMethodBeat.o(220685);
      }
    };
    this.kzS = new c() {};
    z.jV(paramContext).inflate(2131496277, this, true);
    this.wCm = ((TextView)findViewById(2131307881));
    this.wCn = ((MarqueeLyricView)findViewById(2131307880));
    onResume();
    AppMethodBeat.o(220690);
  }
  
  private static boolean dwV()
  {
    AppMethodBeat.i(220692);
    if (1 == ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qOX, 0))
    {
      AppMethodBeat.o(220692);
      return true;
    }
    AppMethodBeat.o(220692);
    return false;
  }
  
  private boolean dwW()
  {
    AppMethodBeat.i(220697);
    if ((this.wCo == null) || (this.wCo.wAq.size() <= 2))
    {
      AppMethodBeat.o(220697);
      return true;
    }
    AppMethodBeat.o(220697);
    return false;
  }
  
  private void i(a parama)
  {
    AppMethodBeat.i(220696);
    if (!dwV())
    {
      this.wCn.setVisibility(8);
      AppMethodBeat.o(220696);
      return;
    }
    this.wCo = com.tencent.mm.plugin.music.model.f.dwu().h(parama);
    if (dwW())
    {
      this.wCn.setVisibility(8);
      AppMethodBeat.o(220696);
      return;
    }
    this.wCp = -1;
    this.wCn.setLyricObj(this.wCo);
    this.wCn.setVisibility(0);
    AppMethodBeat.o(220696);
  }
  
  private void setMusicLyric(String paramString)
  {
    AppMethodBeat.i(220695);
    ae.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", new Object[] { paramString });
    if (this.wCn != null)
    {
      this.wAD = ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).dwe();
      if (this.wAD == null)
      {
        this.wCn.setVisibility(8);
        AppMethodBeat.o(220695);
        return;
      }
      if (bu.isNullOrNil(this.wAD.field_songHAlbumUrl))
      {
        this.wCn.setVisibility(8);
        ((e)com.tencent.mm.plugin.music.f.c.b.aQ(e.class)).a(this.wAD, false, false);
        AppMethodBeat.o(220695);
        return;
      }
      i(this.wAD);
    }
    AppMethodBeat.o(220695);
  }
  
  private void setMusicTitle(String paramString)
  {
    AppMethodBeat.i(220693);
    if (this.wCm != null) {
      this.wCm.setText(paramString);
    }
    AppMethodBeat.o(220693);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(220691);
    this.kzS.alive();
    k.dwp().dwc().a(this.wxZ);
    AppMethodBeat.o(220691);
  }
  
  public void setMusicWrapper(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(220694);
    setMusicTitle(paramf.ikb);
    setMusicLyric(paramf.iki);
    AppMethodBeat.o(220694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView
 * JD-Core Version:    0.7.0.1
 */