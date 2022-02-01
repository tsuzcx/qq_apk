package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.autogen.a.ox.a;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.e.a.d;
import com.tencent.mm.plugin.music.e.a.d.a;
import com.tencent.mm.plugin.music.e.c.b;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.plugin.music.ui.view.MarqueeLyricView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
import java.util.ArrayList;

public class FloatBallMusicLyricView
  extends LinearLayout
{
  public d.a LJz;
  private a LMB;
  private com.tencent.mm.plugin.music.model.e LOA;
  private int LOB;
  private TextView LOy;
  private MarqueeLyricView LOz;
  public IListener rDF;
  
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
    AppMethodBeat.i(270971);
    this.LMB = null;
    this.LOA = null;
    this.LOB = -1;
    this.LJz = new d.a()
    {
      public final void onProgress(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(270944);
        if ((paramAnonymousInt1 >= 0) && (paramAnonymousInt2 > 0)) {
          MMHandlerThread.postToMainThread(new FloatBallMusicLyricView.2(FloatBallMusicLyricView.this, paramAnonymousInt1));
        }
        AppMethodBeat.o(270944);
      }
    };
    this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
    af.mU(paramContext).inflate(a.g.float_ball_music_lyric_view, this, true);
    this.LOy = ((TextView)findViewById(a.e.music_title));
    this.LOz = ((MarqueeLyricView)findViewById(a.e.music_lyric));
    onResume();
    AppMethodBeat.o(270971);
  }
  
  private void goK()
  {
    AppMethodBeat.i(270987);
    this.LOz.setVisibility(8);
    AppMethodBeat.o(270987);
  }
  
  private void setMusicLyric(String paramString)
  {
    AppMethodBeat.i(270982);
    Log.i("MicroMsg.FloatBallMusicLyricView", "alvinluo setMusicLyric: %s", new Object[] { paramString });
    if (this.LOz != null)
    {
      this.LMB = ((com.tencent.mm.plugin.music.logic.e)b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
      if (this.LMB == null)
      {
        this.LOz.setVisibility(8);
        AppMethodBeat.o(270982);
        return;
      }
      if (Util.isNullOrNil(this.LMB.field_songHAlbumUrl))
      {
        this.LOz.setVisibility(8);
        ((com.tencent.mm.plugin.music.logic.e)b.bU(com.tencent.mm.plugin.music.logic.e.class)).a(this.LMB, false, false);
        AppMethodBeat.o(270982);
        return;
      }
      goK();
    }
    AppMethodBeat.o(270982);
  }
  
  private void setMusicTitle(String paramString)
  {
    AppMethodBeat.i(270974);
    if (this.LOy != null) {
      this.LOy.setText(paramString);
    }
    AppMethodBeat.o(270974);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(271024);
    this.rDF.alive();
    j.gnw().gnj().a(this.LJz);
    AppMethodBeat.o(271024);
  }
  
  public void setMusicWrapper(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(271031);
    setMusicTitle(paramf.oOx);
    setMusicLyric(paramf.oOE);
    AppMethodBeat.o(271031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.FloatBallMusicLyricView
 * JD-Core Version:    0.7.0.1
 */