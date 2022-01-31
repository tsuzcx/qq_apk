package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.music.model.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends d
  implements c.a
{
  int count;
  final int mBt = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 26);
  final int mBu = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 260);
  HashMap<Integer, View> mBv = new HashMap();
  c mBw = new c();
  int mBx;
  boolean mzI;
  ah mzt = new ah(Looper.getMainLooper());
  int scene;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.mBw.mzr = this;
    this.scene = paramInt;
    this.mzI = paramBoolean;
  }
  
  public final void H(int paramInt, long paramLong)
  {
    ai.d(new b.1(this, paramInt, paramLong));
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(a.e.music_item, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.mBA = ((MusicItemLayout)paramView.findViewById(a.d.music_item_bg));
      paramViewGroup.mBF = ((TextView)paramView.findViewById(a.d.music_name_tv));
      paramViewGroup.mBH = ((LyricView)paramView.findViewById(a.d.lyric_view));
      paramViewGroup.mBB = paramView.findViewById(a.d.album_bg_area);
      paramViewGroup.mBC = paramView.findViewById(a.d.album_bg_mask1);
      paramViewGroup.mBD = paramView.findViewById(a.d.album_bg_mask2);
      paramViewGroup.mBE = ((CdnImageView)paramView.findViewById(a.d.album_bg));
      paramViewGroup.mBG = ((TextView)paramView.findViewById(a.d.music_singer_tv));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bnc();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      y.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = com.tencent.mm.plugin.music.model.e.bnq().JE((String)((List)localObject).get(i));
      this.mBv.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.c((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      return paramView;
      paramViewGroup = (b.a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    Iterator localIterator = this.mBv.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.mzx.field_musicId.equals(parama.field_musicId))
      {
        y.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.mzx.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.mBA.setBackgroundColor(i);
        locala.mBH.setLyricColor(j);
        locala.mBE.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.mBC.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.mBD.setBackgroundDrawable(localPaintDrawable);
        locala.mBF.setTextColor(j);
        locala.mBG.setTextColor(j);
        ((MusicMainUI)this.context).g(parama);
      }
    }
  }
  
  public final int bnQ()
  {
    return ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.Q(com.tencent.mm.plugin.music.e.e.class)).bnc().size();
  }
  
  public final int getCount()
  {
    return this.count;
  }
  
  public final void uY(int paramInt)
  {
    this.mBv.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */