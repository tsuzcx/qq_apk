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
import com.tencent.mm.plugin.music.model.d.a;
import com.tencent.mm.plugin.music.model.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends com.tencent.mm.ui.base.d
  implements d.a
{
  int count;
  int scene;
  ap wkQ;
  boolean wlf;
  final int wna;
  final int wnb;
  HashMap<Integer, View> wnc;
  com.tencent.mm.plugin.music.model.d wnd;
  int wne;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.wna = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 26);
    this.wnb = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 260);
    this.wkQ = new ap(Looper.getMainLooper());
    this.wnc = new HashMap();
    this.wnd = new com.tencent.mm.plugin.music.model.d();
    this.wnd.wkO = this;
    this.scene = paramInt;
    this.wlf = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final void LC(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.wnc.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131494984, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.wng = ((MusicItemLayout)paramView.findViewById(2131302603));
      paramViewGroup.wnl = ((TextView)paramView.findViewById(2131302606));
      paramViewGroup.wnn = ((LyricView)paramView.findViewById(2131301968));
      paramViewGroup.wnh = paramView.findViewById(2131296535);
      paramViewGroup.wni = paramView.findViewById(2131296536);
      paramViewGroup.wnj = paramView.findViewById(2131296537);
      paramViewGroup.wnk = ((CdnImageView)paramView.findViewById(2131296534));
      paramViewGroup.wnm = ((TextView)paramView.findViewById(2131302617));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsR();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      ad.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = f.dtf().asJ((String)((List)localObject).get(i));
      this.wnc.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.b((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.wnc.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.wkU.field_musicId.equals(parama.field_musicId))
      {
        ad.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.wkU.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.wng.setBackgroundColor(i);
        locala.wnn.setLyricColor(j);
        locala.wnk.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.wni.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.wnj.setBackgroundDrawable(localPaintDrawable);
        locala.wnl.setTextColor(j);
        locala.wnm.setTextColor(j);
        ((MusicMainUI)this.context).k(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void ap(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.this.wnc.get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).wnn.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int dtJ()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dsR().size();
    AppMethodBeat.o(63225);
    return i;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final class a
  {
    private int mode;
    com.tencent.mm.plugin.music.model.e.a wkU;
    MusicItemLayout wng;
    View wnh;
    View wni;
    View wnj;
    CdnImageView wnk;
    TextView wnl;
    TextView wnm;
    LyricView wnn;
    boolean wno;
    private Animation.AnimationListener wnp;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.wnp = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.wno = false;
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
        ad.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
        this.wkU = parama;
        if (bt.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).a(parama, b.this.wlf, true);
        }
        this.wng.setTag(this);
        if (((com.tencent.mm.plugin.music.model.e.a(parama)) && (b.this.scene != 3)) || (bt.isNullOrNil(parama.field_songSinger))) {
          break label227;
        }
        this.wnm.setText(parama.field_songSinger);
        this.wnm.setVisibility(0);
      }
      for (;;)
      {
        this.wnl.setText(parama.field_songName);
        this.wnl.setTag(parama.field_songName);
        this.wnn.setLyricObj(f.dtf().a(parama, b.this.wlf));
        if ((!com.tencent.mm.plugin.music.model.e.a(parama)) || (b.this.wlf)) {
          this.wnn.setCurrentTime(1L);
        }
        dtL();
        b.this.wnd.a(parama, this.wnk, b.this.context, paramBoolean, b.this.wlf);
        AppMethodBeat.o(63218);
        return;
        label227:
        this.wnm.setVisibility(8);
      }
    }
    
    public final boolean dtK()
    {
      return this.mode == 2;
    }
    
    public final void dtL()
    {
      AppMethodBeat.i(63219);
      if ((this.wno) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.gN(3, b.this.scene);
      if (b.this.wne == 0)
      {
        b.this.wne = this.wnh.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.wne);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.wnh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.wlH = true;
      com.tencent.mm.plugin.music.model.d.e.dto();
      this.mode = 1;
      this.wno = true;
      Object localObject = new b.a.a(this, this.wnn, b.this.wna);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.wnp);
      this.wnn.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
    
    public final void dtM()
    {
      AppMethodBeat.i(63220);
      if ((this.wno) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.gN(2, b.this.scene);
      if (b.this.wne == 0)
      {
        b.this.wne = this.wnh.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.wne);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.wnh.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.wlH = true;
      com.tencent.mm.plugin.music.model.d.e.dto();
      this.mode = 2;
      this.wno = true;
      Object localObject = new b.a.a(this, this.wnn, b.this.wnb);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.wnp);
      this.wnn.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void dtN()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.wlH = true;
      com.tencent.mm.plugin.music.model.d.e.dto();
      if (this.mode == 1)
      {
        dtM();
        AppMethodBeat.o(63221);
        return;
      }
      dtL();
      AppMethodBeat.o(63221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */