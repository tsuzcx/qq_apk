package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
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
  MMHandler FRC;
  private boolean FSb;
  private final int FUo;
  private final int FUp;
  HashMap<Integer, View> FUq;
  i FUr;
  private int FUs;
  int count;
  private int scene;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.FUo = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 26);
    this.FUp = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 260);
    this.FRC = new MMHandler(Looper.getMainLooper());
    this.FUq = new HashMap();
    this.FUr = new i();
    this.FUr.FRA = this;
    this.scene = paramInt;
    this.FSb = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(a.g.music_item, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.FUu = ((MusicItemLayout)paramView.findViewById(a.e.music_item_bg));
      paramViewGroup.FUz = ((TextView)paramView.findViewById(a.e.music_name_tv));
      paramViewGroup.FUB = ((LyricView)paramView.findViewById(a.e.lyric_view));
      paramViewGroup.FUv = paramView.findViewById(a.e.album_bg_area);
      paramViewGroup.FUw = paramView.findViewById(a.e.album_bg_mask1);
      paramViewGroup.FUx = paramView.findViewById(a.e.album_bg_mask2);
      paramViewGroup.FUy = ((CdnImageView)paramView.findViewById(a.e.album_bg));
      paramViewGroup.FUA = ((TextView)paramView.findViewById(a.e.music_singer_tv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fek();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      Log.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = o.feW().aSm((String)((List)localObject).get(i));
      this.FUq.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.b((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.FUq.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.FRG.field_musicId.equals(parama.field_musicId))
      {
        Log.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.FRG.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.FUu.setBackgroundColor(i);
        locala.FUB.setLyricColor(j);
        locala.FUy.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.FUw.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.FUx.setBackgroundDrawable(localPaintDrawable);
        locala.FUz.setTextColor(j);
        locala.FUA.setTextColor(j);
        ((MusicMainUI)this.context).l(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void aE(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.a(b.this).get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).FUB.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int bAR()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fek().size();
    AppMethodBeat.o(63225);
    return i;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final void yy(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.FUq.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final class a
  {
    com.tencent.mm.plugin.music.model.e.a FRG;
    TextView FUA;
    LyricView FUB;
    boolean FUC;
    private Animation.AnimationListener FUD;
    MusicItemLayout FUu;
    View FUv;
    View FUw;
    View FUx;
    CdnImageView FUy;
    TextView FUz;
    private int mode;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.FUD = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.FUC = false;
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
        this.FRG = parama;
        if (Util.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).a(parama, b.b(b.this), true);
        }
        this.FUu.setTag(this);
        if (((m.a(parama)) && (b.c(b.this) != 3)) || (Util.isNullOrNil(parama.field_songSinger))) {
          break label227;
        }
        this.FUA.setText(parama.field_songSinger);
        this.FUA.setVisibility(0);
      }
      for (;;)
      {
        this.FUz.setText(parama.field_songName);
        this.FUz.setTag(parama.field_songName);
        this.FUB.setLyricObj(o.feW().a(parama, b.b(b.this)));
        if ((!m.a(parama)) || (b.b(b.this))) {
          this.FUB.setCurrentTime(1L);
        }
        ffB();
        b.d(b.this).a(parama, this.FUy, b.this.context, paramBoolean, b.b(b.this));
        AppMethodBeat.o(63218);
        return;
        label227:
        this.FUA.setVisibility(8);
      }
    }
    
    public final boolean ffA()
    {
      return this.mode == 2;
    }
    
    public final void ffB()
    {
      AppMethodBeat.i(63219);
      if ((this.FUC) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.iy(3, b.c(b.this));
      if (b.e(b.this) == 0)
      {
        b.a(b.this, this.FUv.getMeasuredHeight());
        localObject = new LinearLayout.LayoutParams(-1, b.e(b.this));
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.FUv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.FSF = true;
      com.tencent.mm.plugin.music.model.d.e.ffe();
      this.mode = 1;
      this.FUC = true;
      Object localObject = new b.a.a(this, this.FUB, b.f(b.this));
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.FUD);
      this.FUB.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
    
    public final void ffC()
    {
      AppMethodBeat.i(63220);
      if ((this.FUC) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.iy(2, b.c(b.this));
      if (b.e(b.this) == 0)
      {
        b.a(b.this, this.FUv.getMeasuredHeight());
        localObject = new LinearLayout.LayoutParams(-1, b.e(b.this));
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.FUv.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.FSF = true;
      com.tencent.mm.plugin.music.model.d.e.ffe();
      this.mode = 2;
      this.FUC = true;
      Object localObject = new b.a.a(this, this.FUB, b.g(b.this));
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.FUD);
      this.FUB.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void ffD()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.FSF = true;
      com.tencent.mm.plugin.music.model.d.e.ffe();
      if (this.mode == 1)
      {
        ffC();
        AppMethodBeat.o(63221);
        return;
      }
      ffB();
      AppMethodBeat.o(63221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */