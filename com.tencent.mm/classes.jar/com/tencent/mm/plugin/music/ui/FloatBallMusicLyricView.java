package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.mx.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
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
import com.tencent.mm.ui.aa;
import java.util.ArrayList;

public class FloatBallMusicLyricView
  extends LinearLayout
{
  public d.a AhI;
  private a AkC;
  private TextView Amt;
  private MarqueeLyricView Amu;
  private com.tencent.mm.plugin.music.model.e Amv;
  private int Amw;
  public IListener lEl;
  
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
    AppMethodBeat.i(219860);
    this.AkC = null;
    this.Amv = null;
    this.Amw = -1;
    this.AhI = new d.a()
    {
      public final void fn(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(219855);
        if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
          MMHandlerThread.postToMainThread(new FloatBallMusicLyricView.2(FloatBallMusicLyricView.this, paramAnonymousInt1));
        }
        AppMethodBeat.o(219855);
      }
    };
    this.lEl = new IListener() {};
    aa.jQ(paramContext).inflate(2131494697, this, true);
    this.Amt = ((TextView)findViewById(2131305115));
    this.Amu = ((MarqueeLyricView)findViewById(2131305098));
    onResume();
    AppMethodBeat.o(219860);
  }
  
  private static boolean evb()
  {
    AppMethodBeat.i(219862);
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_PURPLE))
    {
      AppMethodBeat.o(219862);
      return true;
    }
    if (1 == ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sme, 0))
    {
      AppMethodBeat.o(219862);
      return true;
    }
    AppMethodBeat.o(219862);
    return false;
  }
  
  private boolean evc()
  {
    AppMethodBeat.i(219867);
    if ((this.Amv == null) || (this.Amv.Akn.size() <= 2))
    {
      AppMethodBeat.o(219867);
      return true;
    }
    AppMethodBeat.o(219867);
    return false;
  }
  
  private void j(a parama)
  {
    AppMethodBeat.i(219866);
    if (!evb())
    {
      this.Amu.setVisibility(8);
      AppMethodBeat.o(219866);
      return;
    }
    this.Amv = o.euD().i(parama);
    if (evc())
    {
      this.Amu.setVisibility(8);
      AppMethodBeat.o(219866);
      return;
    }
    this.Amw = -1;
    this.Amu.setLyricObj(this.Amv);
    this.Amu.setVisibility(0);
    AppMethodBeat.o(219866);
  }
  
  private void setMusicLyric(String paramString)
  {
    AppMethodBeat.i(219865);
    Log.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", new Object[] { paramString });
    if (this.Amu != null)
    {
      this.AkC = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY();
      if (this.AkC == null)
      {
        this.Amu.setVisibility(8);
        AppMethodBeat.o(219865);
        return;
      }
      if (Util.isNullOrNil(this.AkC.field_songHAlbumUrl))
      {
        this.Amu.setVisibility(8);
        ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).a(this.AkC, false, false);
        AppMethodBeat.o(219865);
        return;
      }
      j(this.AkC);
    }
    AppMethodBeat.o(219865);
  }
  
  private void setMusicTitle(String paramString)
  {
    AppMethodBeat.i(219863);
    if (this.Amt != null) {
      this.Amt.setText(paramString);
    }
    AppMethodBeat.o(219863);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(219861);
    this.lEl.alive();
    k.euj().etW().b(this.AhI);
    AppMethodBeat.o(219861);
  }
  
  public void setMusicWrapper(f paramf)
  {
    AppMethodBeat.i(219864);
    setMusicTitle(paramf.jeX);
    setMusicLyric(paramf.jfe);
    AppMethodBeat.o(219864);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView
 * JD-Core Version:    0.7.0.1
 */