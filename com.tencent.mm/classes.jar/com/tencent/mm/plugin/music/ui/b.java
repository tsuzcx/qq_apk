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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.c;
import com.tencent.mm.plugin.music.model.c.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
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
  boolean oZO;
  ak oZz;
  HashMap<Integer, View> pbA;
  c pbB;
  int pbC;
  final int pby;
  final int pbz;
  int scene;
  
  public b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(105083);
    this.pby = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 26);
    this.pbz = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 260);
    this.oZz = new ak(Looper.getMainLooper());
    this.pbA = new HashMap();
    this.pbB = new c();
    this.pbB.oZx = this;
    this.scene = paramInt;
    this.oZO = paramBoolean;
    AppMethodBeat.o(105083);
  }
  
  public final void Ay(int paramInt)
  {
    AppMethodBeat.i(105085);
    this.pbA.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(105085);
  }
  
  public final void X(final int paramInt, final long paramLong)
  {
    AppMethodBeat.i(105087);
    al.d(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(105072);
        View localView = (View)b.this.pbA.get(Integer.valueOf(paramInt));
        if (localView != null) {
          ((b.a)localView.getTag()).pbM.setCurrentTime(paramLong);
        }
        AppMethodBeat.o(105072);
      }
    });
    AppMethodBeat.o(105087);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(105084);
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.context).inflate(2130970328, paramViewGroup, false);
      paramViewGroup = new b.a(this);
      paramViewGroup.pbF = ((MusicItemLayout)paramView.findViewById(2131826449));
      paramViewGroup.pbK = ((TextView)paramView.findViewById(2131826454));
      paramViewGroup.pbM = ((LyricView)paramView.findViewById(2131826456));
      paramViewGroup.pbG = paramView.findViewById(2131826450);
      paramViewGroup.pbH = paramView.findViewById(2131826452);
      paramViewGroup.pbI = paramView.findViewById(2131826453);
      paramViewGroup.pbJ = ((CdnImageView)paramView.findViewById(2131826451));
      paramViewGroup.pbL = ((TextView)paramView.findViewById(2131826455));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      Object localObject = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVy();
      int j = (paramInt - 100000) % ((List)localObject).size();
      int i = j;
      if (j < 0) {
        i = j + ((List)localObject).size();
      }
      ab.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[] { Integer.valueOf(i) });
      localObject = com.tencent.mm.plugin.music.model.e.bVM().VC((String)((List)localObject).get(i));
      this.pbA.put(Integer.valueOf(paramInt), paramView);
      paramViewGroup.d((com.tencent.mm.plugin.music.model.e.a)localObject, false);
      AppMethodBeat.o(105084);
      return paramView;
      paramViewGroup = (b.a)paramView.getTag();
    }
  }
  
  public final void a(com.tencent.mm.plugin.music.model.e.a parama, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(105088);
    Iterator localIterator = this.pbA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b.a locala = (b.a)((View)((Map.Entry)localIterator.next()).getValue()).getTag();
      if (locala.oZD.field_musicId.equals(parama.field_musicId))
      {
        ab.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[] { locala.oZD.field_songName });
        int i = paramArrayOfInt[0];
        int j = paramArrayOfInt[1];
        locala.pbF.setBackgroundColor(i);
        locala.pbM.setLyricColor(j);
        locala.pbJ.setBackgroundColor(i);
        Object localObject = new b.a.1(locala, i);
        PaintDrawable localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.pbH.setBackgroundDrawable(localPaintDrawable);
        localObject = new b.a.2(locala, i & 0xFFFFFF | 0x55000000);
        localPaintDrawable = new PaintDrawable();
        localPaintDrawable.setShape(new RectShape());
        localPaintDrawable.setShaderFactory((ShapeDrawable.ShaderFactory)localObject);
        locala.pbI.setBackgroundDrawable(localPaintDrawable);
        locala.pbK.setTextColor(j);
        locala.pbL.setTextColor(j);
        ((MusicMainUI)this.context).i(parama);
      }
    }
    AppMethodBeat.o(105088);
  }
  
  public final int bWn()
  {
    AppMethodBeat.i(105086);
    int i = ((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.am(com.tencent.mm.plugin.music.e.e.class)).bVy().size();
    AppMethodBeat.o(105086);
    return i;
  }
  
  public final int getCount()
  {
    return this.count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.b
 * JD-Core Version:    0.7.0.1
 */