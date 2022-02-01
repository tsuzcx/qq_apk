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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  boolean vfK;
  ao vfv;
  final int vhF;
  final int vhG;
  HashMap<Integer, View> vhH;
  com.tencent.mm.plugin.music.model.d vhI;
  int vhJ;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.vhF = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 26);
    this.vhG = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 260);
    this.vfv = new ao(Looper.getMainLooper());
    this.vhH = new HashMap();
    this.vhI = new com.tencent.mm.plugin.music.model.d();
    this.vhI.vft = this;
    this.scene = paramInt;
    this.vfK = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final void Ka(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.vhH.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131494984, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.vhL = ((MusicItemLayout)paramView.findViewById(2131302603));
      paramViewGroup.vhQ = ((TextView)paramView.findViewById(2131302606));
      paramViewGroup.vhS = ((LyricView)paramView.findViewById(2131301968));
      paramViewGroup.vhM = paramView.findViewById(2131296535);
      paramViewGroup.vhN = paramView.findViewById(2131296536);
      paramViewGroup.vhO = paramView.findViewById(2131296537);
      paramViewGroup.vhP = ((CdnImageView)paramView.findViewById(2131296534));
      paramViewGroup.vhR = ((TextView)paramView.findViewById(2131302617));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diF();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      ac.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = f.diT().anK((String)((List)localObject).get(i));
      this.vhH.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.b((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.vhH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.vfz.field_musicId.equals(parama.field_musicId))
      {
        ac.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.vfz.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.vhL.setBackgroundColor(i);
        locala.vhS.setLyricColor(j);
        locala.vhP.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.vhN.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.vhO.setBackgroundDrawable(localPaintDrawable);
        locala.vhQ.setTextColor(j);
        locala.vhR.setTextColor(j);
        ((MusicMainUI)this.context).k(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void ak(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.this.vhH.get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).vhS.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int djx()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).diF().size();
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
    com.tencent.mm.plugin.music.model.e.a vfz;
    MusicItemLayout vhL;
    View vhM;
    View vhN;
    View vhO;
    CdnImageView vhP;
    TextView vhQ;
    TextView vhR;
    LyricView vhS;
    boolean vhT;
    private Animation.AnimationListener vhU;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.vhU = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.vhT = false;
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
        ac.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[] { parama.field_songName });
        this.vfz = parama;
        if (bs.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aQ(com.tencent.mm.plugin.music.e.e.class)).a(parama, b.this.vfK, true);
        }
        this.vhL.setTag(this);
        if (((com.tencent.mm.plugin.music.model.e.a(parama)) && (b.this.scene != 3)) || (bs.isNullOrNil(parama.field_songSinger))) {
          break label227;
        }
        this.vhR.setText(parama.field_songSinger);
        this.vhR.setVisibility(0);
      }
      for (;;)
      {
        this.vhQ.setText(parama.field_songName);
        this.vhQ.setTag(parama.field_songName);
        this.vhS.setLyricObj(f.diT().a(parama, b.this.vfK));
        if ((!com.tencent.mm.plugin.music.model.e.a(parama)) || (b.this.vfK)) {
          this.vhS.setCurrentTime(1L);
        }
        djz();
        b.this.vhI.a(parama, this.vhP, b.this.context, paramBoolean, b.this.vfK);
        AppMethodBeat.o(63218);
        return;
        label227:
        this.vhR.setVisibility(8);
      }
    }
    
    public final void djA()
    {
      AppMethodBeat.i(63220);
      if ((this.vhT) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.gv(2, b.this.scene);
      if (b.this.vhJ == 0)
      {
        b.this.vhJ = this.vhM.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.vhJ);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.vhM.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.vgm = true;
      com.tencent.mm.plugin.music.model.d.e.djc();
      this.mode = 2;
      this.vhT = true;
      Object localObject = new b.a.a(this, this.vhS, b.this.vhG);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.vhU);
      this.vhS.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void djB()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.vgm = true;
      com.tencent.mm.plugin.music.model.d.e.djc();
      if (this.mode == 1)
      {
        djA();
        AppMethodBeat.o(63221);
        return;
      }
      djz();
      AppMethodBeat.o(63221);
    }
    
    public final boolean djy()
    {
      return this.mode == 2;
    }
    
    public final void djz()
    {
      AppMethodBeat.i(63219);
      if ((this.vhT) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.gv(3, b.this.scene);
      if (b.this.vhJ == 0)
      {
        b.this.vhJ = this.vhM.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.vhJ);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.vhM.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.vgm = true;
      com.tencent.mm.plugin.music.model.d.e.djc();
      this.mode = 1;
      this.vhT = true;
      Object localObject = new b.a.a(this, this.vhS, b.this.vhF);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.vhU);
      this.vhS.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */