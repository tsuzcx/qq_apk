package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.a.g;
import com.tencent.mm.plugin.music.model.i;
import com.tencent.mm.plugin.music.model.i.a;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends d
  implements i.a
{
  private boolean LMW;
  MMHandler LMx;
  private final int LPo;
  private final int LPp;
  HashMap<Integer, View> LPq;
  i LPr;
  private int LPs;
  int count;
  private int scene;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.LPo = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 26);
    this.LPp = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 260);
    this.LMx = new MMHandler(Looper.getMainLooper());
    this.LPq = new HashMap();
    this.LPr = new i();
    this.LPr.LMu = this;
    this.scene = paramInt;
    this.LMW = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(a.g.music_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.LPu = ((MusicItemLayout)paramView.findViewById(a.e.music_item_bg));
      paramViewGroup.LPz = ((TextView)paramView.findViewById(a.e.music_name_tv));
      paramViewGroup.LPB = ((LyricView)paramView.findViewById(a.e.lyric_view));
      paramViewGroup.LPv = paramView.findViewById(a.e.album_bg_area);
      paramViewGroup.LPw = paramView.findViewById(a.e.album_bg_mask1);
      paramViewGroup.LPx = paramView.findViewById(a.e.album_bg_mask2);
      paramViewGroup.LPy = ((CdnImageView)paramView.findViewById(a.e.album_bg));
      paramViewGroup.LPA = ((TextView)paramView.findViewById(a.e.music_singer_tv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnn();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      Log.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = o.god().aPg((String)((List)localObject).get(i));
      this.LPq.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.b((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.LPq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.LMB.field_musicId.equals(parama.field_musicId))
      {
        Log.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.LMB.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.LPu.setBackgroundColor(i);
        locala.LPB.setLyricColor(j);
        locala.LPy.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.LPw.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.LPx.setBackgroundDrawable(localPaintDrawable);
        locala.LPz.setTextColor(j);
        locala.LPA.setTextColor(j);
        ((MusicMainUI)this.context).k(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void aL(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.a(b.this).get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).LPB.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int bZC()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnn().size();
    AppMethodBeat.o(63225);
    return i;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final void yG(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.LPq.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final class a
  {
    com.tencent.mm.plugin.music.model.e.a LMB;
    TextView LPA;
    LyricView LPB;
    boolean LPC;
    private Animation.AnimationListener LPD;
    MusicItemLayout LPu;
    View LPv;
    View LPw;
    View LPx;
    CdnImageView LPy;
    TextView LPz;
    private int mode;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.LPD = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.LPC = false;
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
      AppMethodBeat.o(63217);
    }
    
    public final void b(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(63218);
      if (parama != null)
      {
        Log.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
        this.LMB = parama;
        if (Util.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).a(parama, b.b(b.this), true);
        }
        this.LPu.setTag(this);
        if (((m.a(parama)) && (b.c(b.this) != 3)) || (Util.isNullOrNil(parama.field_songSinger))) {
          break label227;
        }
        this.LPA.setText(parama.field_songSinger);
        this.LPA.setVisibility(0);
      }
      for (;;)
      {
        this.LPz.setText(parama.field_songName);
        this.LPz.setTag(parama.field_songName);
        this.LPB.setLyricObj(o.god().a(parama, b.b(b.this)));
        if ((!m.a(parama)) || (b.b(b.this))) {
          this.LPB.setCurrentTime(1L);
        }
        goP();
        b.d(b.this).a(parama, this.LPy, b.this.context, paramBoolean, b.b(b.this));
        AppMethodBeat.o(63218);
        return;
        label227:
        this.LPA.setVisibility(8);
      }
    }
    
    public final boolean goO()
    {
      return this.mode == 2;
    }
    
    public final void goP()
    {
      AppMethodBeat.i(63219);
      if ((this.LPC) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.kc(3, b.c(b.this));
      if (b.e(b.this) == 0)
      {
        b.a(b.this, this.LPv.getMeasuredHeight());
        localObject = new LinearLayout.LayoutParams(-1, b.e(b.this));
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.LPv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.LNB = true;
      com.tencent.mm.plugin.music.model.d.e.gon();
      this.mode = 1;
      this.LPC = true;
      Object localObject = new b.a.a(this, this.LPB, b.f(b.this));
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.LPD);
      this.LPB.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
    
    public final void goQ()
    {
      AppMethodBeat.i(63220);
      if ((this.LPC) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.kc(2, b.c(b.this));
      if (b.e(b.this) == 0)
      {
        b.a(b.this, this.LPv.getMeasuredHeight());
        localObject = new LinearLayout.LayoutParams(-1, b.e(b.this));
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.LPv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.LNB = true;
      com.tencent.mm.plugin.music.model.d.e.gon();
      this.mode = 2;
      this.LPC = true;
      Object localObject = new b.a.a(this, this.LPB, b.g(b.this));
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.LPD);
      this.LPB.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void goR()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.LNB = true;
      com.tencent.mm.plugin.music.model.d.e.gon();
      if (this.mode == 1)
      {
        goQ();
        AppMethodBeat.o(63221);
        return;
      }
      goP();
      AppMethodBeat.o(63221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */