package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.n;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements h.b
{
  private View.OnClickListener bTw;
  com.tencent.mm.ui.widget.b.d mAF;
  View.OnLongClickListener mAd;
  private ListView mListView;
  Map<String, a.a> mwr;
  private com.tencent.mm.sdk.b.c mwt;
  h.a pZw;
  int qaf;
  
  public a(h.a parama, ListView paramListView)
  {
    AppMethodBeat.i(24345);
    this.mwr = new HashMap();
    this.bTw = new a.1(this);
    this.mAd = new a.2(this);
    this.mwt = new a.5(this);
    this.pZw = parama;
    this.mListView = paramListView;
    com.tencent.mm.sdk.b.a.ymk.c(this.mwt);
    AppMethodBeat.o(24345);
  }
  
  public final void a(View paramView, int paramInt, b paramb, Object paramObject)
  {
    AppMethodBeat.i(153635);
    paramView = (ImageView)paramView.findViewById(2131827108);
    paramView.setTag(paramb);
    paramView.setOnClickListener(this.bTw);
    if (paramb.dataType == 1) {
      paramView.setOnLongClickListener(this.mAd);
    }
    paramObject = new h.a.b();
    if (paramb.dataType == 0) {
      paramObject.pZy = paramb.cpO;
    }
    for (;;)
    {
      paramObject.cuL = paramb.cuL;
      paramObject.cuO = true;
      paramObject.maxWidth = this.qaf;
      Bitmap localBitmap = this.pZw.a(paramObject);
      if (localBitmap == null) {
        break;
      }
      ab.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[] { paramObject.cuL.mBq, localBitmap });
      a(paramView, localBitmap, 2131231298, paramb.cuL.mBq);
      AppMethodBeat.o(153635);
      return;
      if (paramb.dataType == 1) {
        paramObject.pZy = paramb.mCk.field_localId;
      }
    }
    com.tencent.mm.sdk.g.d.ysn.aj(new a.4(this, paramb, paramView));
    AppMethodBeat.o(153635);
  }
  
  final void a(ImageView paramImageView, Bitmap paramBitmap, int paramInt, String paramString)
  {
    AppMethodBeat.i(24348);
    if (!((b)paramImageView.getTag()).cuL.mBq.equals(paramString))
    {
      ab.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[] { paramString, paramImageView.getTag() });
      AppMethodBeat.o(24348);
      return;
    }
    if (paramBitmap == null)
    {
      paramBitmap = paramImageView.getLayoutParams();
      paramBitmap.height = 200;
      paramBitmap.width = 280;
      paramImageView.setImageResource(paramInt);
      paramImageView.setBackgroundResource(2131690207);
      AppMethodBeat.o(24348);
      return;
    }
    ab.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()), Integer.valueOf(paramImageView.getWidth()), Integer.valueOf(paramImageView.getHeight()) });
    paramString = paramImageView.getLayoutParams();
    paramInt = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f;
    if (i >= paramInt)
    {
      f = i / paramInt;
      if (f <= 2.5D) {
        break label449;
      }
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, (paramBitmap.getHeight() - (int)(paramBitmap.getWidth() * 2.5F)) / 2, paramBitmap.getWidth(), (int)(paramBitmap.getWidth() * 2.5F));
      f = 2.5F;
    }
    label449:
    for (;;)
    {
      if (f <= 2.0F)
      {
        paramInt = com.tencent.mm.cb.a.ap(paramImageView.getContext(), 2131427520);
        i = (int)(paramInt / f);
      }
      for (;;)
      {
        paramString.width = i;
        paramString.height = paramInt;
        paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        n.x(paramImageView, i, paramInt);
        if (paramImageView.getLayerType() == 1) {
          this.mListView.setLayerType(1, null);
        }
        paramImageView.setImageBitmap(paramBitmap);
        paramImageView.setBackgroundResource(0);
        AppMethodBeat.o(24348);
        return;
        i = com.tencent.mm.cb.a.ap(paramImageView.getContext(), 2131427522);
        paramInt = (int)(i * f);
      }
      f = paramInt / i;
      if (f > 2.5D)
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, (paramBitmap.getWidth() - (int)(paramBitmap.getHeight() * 2.5F)) / 2, 0, (int)(paramBitmap.getHeight() * 2.5F), paramBitmap.getHeight());
        f = 2.5F;
      }
      for (;;)
      {
        if (f <= 2.0F)
        {
          i = com.tencent.mm.cb.a.ap(paramImageView.getContext(), 2131427520);
          paramInt = (int)(i / f);
          break;
        }
        paramInt = com.tencent.mm.cb.a.ap(paramImageView.getContext(), 2131427522);
        i = (int)(paramInt * f);
        break;
      }
    }
  }
  
  public final View createView(Context paramContext)
  {
    AppMethodBeat.i(24346);
    View localView = View.inflate(paramContext, 2130970540, null);
    this.qaf = com.tencent.mm.cb.a.fromDPToPix(paramContext, 200);
    AppMethodBeat.o(24346);
    return localView;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(24349);
    com.tencent.mm.sdk.b.a.ymk.d(this.mwt);
    AppMethodBeat.o(24349);
  }
  
  public final void pause() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.ui.b.a
 * JD-Core Version:    0.7.0.1
 */