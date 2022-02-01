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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  boolean wAO;
  aq wAz;
  final int wCJ;
  final int wCK;
  HashMap<Integer, View> wCL;
  com.tencent.mm.plugin.music.model.d wCM;
  int wCN;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.wCJ = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 26);
    this.wCK = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 260);
    this.wAz = new aq(Looper.getMainLooper());
    this.wCL = new HashMap();
    this.wCM = new com.tencent.mm.plugin.music.model.d();
    this.wCM.wAx = this;
    this.scene = paramInt;
    this.wAO = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final void Mh(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.wCL.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131494984, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.wCP = ((MusicItemLayout)paramView.findViewById(2131302603));
      paramViewGroup.wCU = ((TextView)paramView.findViewById(2131302606));
      paramViewGroup.wCW = ((LyricView)paramView.findViewById(2131301968));
      paramViewGroup.wCQ = paramView.findViewById(2131296535);
      paramViewGroup.wCR = paramView.findViewById(2131296536);
      paramViewGroup.wCS = paramView.findViewById(2131296537);
      paramViewGroup.wCT = ((CdnImageView)paramView.findViewById(2131296534));
      paramViewGroup.wCV = ((TextView)paramView.findViewById(2131302617));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwg();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      ae.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = f.dwu().atW((String)((List)localObject).get(i));
      this.wCL.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.b((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.wCL.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.wAD.field_musicId.equals(parama.field_musicId))
      {
        ae.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.wAD.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.wCP.setBackgroundColor(i);
        locala.wCW.setLyricColor(j);
        locala.wCT.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.wCR.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.wCS.setBackgroundDrawable(localPaintDrawable);
        locala.wCU.setTextColor(j);
        locala.wCV.setTextColor(j);
        ((MusicMainUI)this.context).k(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void ap(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.this.wCL.get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).wCW.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int dwY()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).dwg().size();
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
    com.tencent.mm.plugin.music.model.e.a wAD;
    MusicItemLayout wCP;
    View wCQ;
    View wCR;
    View wCS;
    CdnImageView wCT;
    TextView wCU;
    TextView wCV;
    LyricView wCW;
    boolean wCX;
    private Animation.AnimationListener wCY;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.wCY = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.wCX = false;
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
        ae.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
        this.wAD = parama;
        if (bu.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).a(parama, b.this.wAO, true);
        }
        this.wCP.setTag(this);
        if (((com.tencent.mm.plugin.music.model.e.a(parama)) && (b.this.scene != 3)) || (bu.isNullOrNil(parama.field_songSinger))) {
          break label227;
        }
        this.wCV.setText(parama.field_songSinger);
        this.wCV.setVisibility(0);
      }
      for (;;)
      {
        this.wCU.setText(parama.field_songName);
        this.wCU.setTag(parama.field_songName);
        this.wCW.setLyricObj(f.dwu().a(parama, b.this.wAO));
        if ((!com.tencent.mm.plugin.music.model.e.a(parama)) || (b.this.wAO)) {
          this.wCW.setCurrentTime(1L);
        }
        dxa();
        b.this.wCM.a(parama, this.wCT, b.this.context, paramBoolean, b.this.wAO);
        AppMethodBeat.o(63218);
        return;
        label227:
        this.wCV.setVisibility(8);
      }
    }
    
    public final boolean dwZ()
    {
      return this.mode == 2;
    }
    
    public final void dxa()
    {
      AppMethodBeat.i(63219);
      if ((this.wCX) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.gO(3, b.this.scene);
      if (b.this.wCN == 0)
      {
        b.this.wCN = this.wCQ.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.wCN);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.wCQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.wBq = true;
      com.tencent.mm.plugin.music.model.d.e.dwD();
      this.mode = 1;
      this.wCX = true;
      Object localObject = new b.a.a(this, this.wCW, b.this.wCJ);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.wCY);
      this.wCW.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
    
    public final void dxb()
    {
      AppMethodBeat.i(63220);
      if ((this.wCX) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.gO(2, b.this.scene);
      if (b.this.wCN == 0)
      {
        b.this.wCN = this.wCQ.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.wCN);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.wCQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.wBq = true;
      com.tencent.mm.plugin.music.model.d.e.dwD();
      this.mode = 2;
      this.wCX = true;
      Object localObject = new b.a.a(this, this.wCW, b.this.wCK);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.wCY);
      this.wCW.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void dxc()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.wBq = true;
      com.tencent.mm.plugin.music.model.d.e.dwD();
      if (this.mode == 1)
      {
        dxb();
        AppMethodBeat.o(63221);
        return;
      }
      dxa();
      AppMethodBeat.o(63221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */