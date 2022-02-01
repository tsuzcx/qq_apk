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
  ap tWK;
  boolean tWZ;
  final int tYM;
  final int tYN;
  HashMap<Integer, View> tYO;
  com.tencent.mm.plugin.music.model.d tYP;
  int tYQ;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.tYM = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 26);
    this.tYN = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 260);
    this.tWK = new ap(Looper.getMainLooper());
    this.tYO = new HashMap();
    this.tYP = new com.tencent.mm.plugin.music.model.d();
    this.tYP.tWI = this;
    this.scene = paramInt;
    this.tWZ = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final void Ib(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.tYO.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131494984, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.tYT = ((MusicItemLayout)paramView.findViewById(2131302603));
      paramViewGroup.tYY = ((TextView)paramView.findViewById(2131302606));
      paramViewGroup.tZa = ((LyricView)paramView.findViewById(2131301968));
      paramViewGroup.tYU = paramView.findViewById(2131296535);
      paramViewGroup.tYV = paramView.findViewById(2131296536);
      paramViewGroup.tYW = paramView.findViewById(2131296537);
      paramViewGroup.tYX = ((CdnImageView)paramView.findViewById(2131296534));
      paramViewGroup.tYZ = ((TextView)paramView.findViewById(2131302617));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUZ();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      ad.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = f.cVn().aiP((String)((List)localObject).get(i));
      this.tYO.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.d((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.tYO.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.tWO.field_musicId.equals(parama.field_musicId))
      {
        ad.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.tWO.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.tYT.setBackgroundColor(i);
        locala.tZa.setLyricColor(j);
        locala.tYX.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.tYV.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.tYW.setBackgroundDrawable(localPaintDrawable);
        locala.tYY.setTextColor(j);
        locala.tYZ.setTextColor(j);
        ((MusicMainUI)this.context).i(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void am(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.this.tYO.get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).tZa.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int cVP()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).cUZ().size();
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
    com.tencent.mm.plugin.music.model.e.a tWO;
    MusicItemLayout tYT;
    View tYU;
    View tYV;
    View tYW;
    CdnImageView tYX;
    TextView tYY;
    TextView tYZ;
    LyricView tZa;
    boolean tZb;
    private Animation.AnimationListener tZc;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.tZc = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.tZb = false;
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      };
      AppMethodBeat.o(63217);
    }
    
    public final boolean cVQ()
    {
      return this.mode == 2;
    }
    
    public final void cVR()
    {
      AppMethodBeat.i(63219);
      if ((this.tZb) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.go(3, b.this.scene);
      if (b.this.tYQ == 0)
      {
        b.this.tYQ = this.tYU.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.tYQ);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.tYU.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.tXA = true;
      com.tencent.mm.plugin.music.model.d.e.cVw();
      this.mode = 1;
      this.tZb = true;
      Object localObject = new b.a.a(this, this.tZa, b.this.tYM);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.tZc);
      this.tZa.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
    
    public final void cVS()
    {
      AppMethodBeat.i(63220);
      if ((this.tZb) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.go(2, b.this.scene);
      if (b.this.tYQ == 0)
      {
        b.this.tYQ = this.tYU.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.tYQ);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.tYU.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.tXA = true;
      com.tencent.mm.plugin.music.model.d.e.cVw();
      this.mode = 2;
      this.tZb = true;
      Object localObject = new b.a.a(this, this.tZa, b.this.tYN);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.tZc);
      this.tZa.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void cVT()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.tXA = true;
      com.tencent.mm.plugin.music.model.d.e.cVw();
      if (this.mode == 1)
      {
        cVS();
        AppMethodBeat.o(63221);
        return;
      }
      cVR();
      AppMethodBeat.o(63221);
    }
    
    public final void d(com.tencent.mm.plugin.music.model.e.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(63218);
      if (parama != null)
      {
        ad.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
        this.tWO = parama;
        if (bt.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aP(com.tencent.mm.plugin.music.e.e.class)).a(parama, b.this.tWZ);
        }
        this.tYT.setTag(this);
        if (((com.tencent.mm.plugin.music.model.e.a(parama)) && (b.this.scene != 3)) || (bt.isNullOrNil(parama.field_songSinger))) {
          break label226;
        }
        this.tYZ.setText(parama.field_songSinger);
        this.tYZ.setVisibility(0);
      }
      for (;;)
      {
        this.tYY.setText(parama.field_songName);
        this.tYY.setTag(parama.field_songName);
        this.tZa.setLyricObj(f.cVn().b(parama, b.this.tWZ));
        if ((!com.tencent.mm.plugin.music.model.e.a(parama)) || (b.this.tWZ)) {
          this.tZa.setCurrentTime(1L);
        }
        cVR();
        b.this.tYP.a(parama, this.tYX, b.this.context, paramBoolean, b.this.tWZ);
        AppMethodBeat.o(63218);
        return;
        label226:
        this.tYZ.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */