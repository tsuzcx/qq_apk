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
  boolean AkV;
  MMHandler Aky;
  final int Anh;
  final int Ani;
  HashMap<Integer, View> Anj;
  i Ank;
  int Anl;
  int count;
  int scene;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(63222);
    this.Anh = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 26);
    this.Ani = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 260);
    this.Aky = new MMHandler(Looper.getMainLooper());
    this.Anj = new HashMap();
    this.Ank = new i();
    this.Ank.Akw = this;
    this.scene = paramInt;
    this.AkV = paramBoolean;
    AppMethodBeat.o(63222);
  }
  
  public final void Te(int paramInt)
  {
    AppMethodBeat.i(63224);
    this.Anj.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(63224);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(63223);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2131495772, paramViewGroup, false);
      paramViewGroup = new a();
      paramViewGroup.Ann = ((MusicItemLayout)paramView.findViewById(2131305095));
      paramViewGroup.Ant = ((TextView)paramView.findViewById(2131305101));
      paramViewGroup.Anv = ((LyricView)paramView.findViewById(2131304298));
      paramViewGroup.Ano = paramView.findViewById(2131296611);
      paramViewGroup.Anp = paramView.findViewById(2131296612);
      paramViewGroup.Anq = paramView.findViewById(2131296613);
      paramViewGroup.Ans = ((CdnImageView)paramView.findViewById(2131296610));
      paramViewGroup.Anu = ((TextView)paramView.findViewById(2131305112));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eua();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      Log.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = o.euD().aHW((String)((List)localObject).get(i));
      this.Anj.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.b((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(63223);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(63227);
    Iterator localIterator = this.Anj.entrySet().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.AkC.field_musicId.equals(parama.field_musicId))
      {
        Log.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.AkC.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.Ann.setBackgroundColor(i);
        locala.Anv.setLyricColor(j);
        locala.Ans.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.Anp.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.Anq.setBackgroundDrawable(localPaintDrawable);
        locala.Ant.setTextColor(j);
        locala.Anu.setTextColor(j);
        ((MusicMainUI)this.context).l(parama);
      }
    }
    AppMethodBeat.o(63227);
  }
  
  public final void av(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(63226);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(63211);
        View localView = (View)b.this.Anj.get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).Anv.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(63211);
      }
    });
    AppMethodBeat.o(63226);
  }
  
  public final int evg()
  {
    AppMethodBeat.i(63225);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).eua().size();
    AppMethodBeat.o(63225);
    return i;
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final class a
  {
    com.tencent.mm.plugin.music.model.e.a AkC;
    MusicItemLayout Ann;
    View Ano;
    View Anp;
    View Anq;
    CdnImageView Ans;
    TextView Ant;
    TextView Anu;
    LyricView Anv;
    boolean Anw;
    private Animation.AnimationListener Anx;
    private int mode;
    
    public a()
    {
      AppMethodBeat.i(63217);
      this.mode = 1;
      this.Anx = new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          b.a.this.Anw = false;
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
        this.AkC = parama;
        if (Util.isNullOrNil(parama.field_songHAlbumUrl)) {
          ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).a(parama, b.this.AkV, true);
        }
        this.Ann.setTag(this);
        if (((m.a(parama)) && (b.this.scene != 3)) || (Util.isNullOrNil(parama.field_songSinger))) {
          break label227;
        }
        this.Anu.setText(parama.field_songSinger);
        this.Anu.setVisibility(0);
      }
      for (;;)
      {
        this.Ant.setText(parama.field_songName);
        this.Ant.setTag(parama.field_songName);
        this.Anv.setLyricObj(o.euD().a(parama, b.this.AkV));
        if ((!m.a(parama)) || (b.this.AkV)) {
          this.Anv.setCurrentTime(1L);
        }
        evi();
        b.this.Ank.a(parama, this.Ans, b.this.context, paramBoolean, b.this.AkV);
        AppMethodBeat.o(63218);
        return;
        label227:
        this.Anu.setVisibility(8);
      }
    }
    
    public final boolean evh()
    {
      return this.mode == 2;
    }
    
    public final void evi()
    {
      AppMethodBeat.i(63219);
      if ((this.Anw) || (this.mode == 1))
      {
        AppMethodBeat.o(63219);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.hu(3, b.this.scene);
      if (b.this.Anl == 0)
      {
        b.this.Anl = this.Ano.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.Anl);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.Ano.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.Aly = true;
      com.tencent.mm.plugin.music.model.d.e.euL();
      this.mode = 1;
      this.Anw = true;
      Object localObject = new b.a.a(this, this.Anv, b.this.Anh);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.Anx);
      this.Anv.startAnimation((Animation)localObject);
      AppMethodBeat.o(63219);
    }
    
    public final void evj()
    {
      AppMethodBeat.i(63220);
      if ((this.Anw) || (this.mode == 2))
      {
        AppMethodBeat.o(63220);
        return;
      }
      com.tencent.mm.plugin.music.model.d.e.hu(2, b.this.scene);
      if (b.this.Anl == 0)
      {
        b.this.Anl = this.Ano.getMeasuredHeight();
        localObject = new LinearLayout.LayoutParams(-1, b.this.Anl);
        ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
        this.Ano.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      com.tencent.mm.plugin.music.model.d.e.Aly = true;
      com.tencent.mm.plugin.music.model.d.e.euL();
      this.mode = 2;
      this.Anw = true;
      Object localObject = new b.a.a(this, this.Anv, b.this.Ani);
      ((b.a.a)localObject).setDuration(500L);
      ((b.a.a)localObject).setAnimationListener(this.Anx);
      this.Anv.startAnimation((Animation)localObject);
      AppMethodBeat.o(63220);
    }
    
    public final void evk()
    {
      AppMethodBeat.i(63221);
      com.tencent.mm.plugin.music.model.d.e.Aly = true;
      com.tencent.mm.plugin.music.model.d.e.euL();
      if (this.mode == 1)
      {
        evj();
        AppMethodBeat.o(63221);
        return;
      }
      evi();
      AppMethodBeat.o(63221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */