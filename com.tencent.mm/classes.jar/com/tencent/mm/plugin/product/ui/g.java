package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends androidx.viewpager.widget.a
{
  private ArrayList<b> GUT;
  private boolean GUU;
  a GUV;
  private List<String> GUy;
  private Context mContext;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.GUU = false;
    this.GUV = null;
    this.mContext = paramContext;
    this.GUy = null;
    setData(this.GUy);
    AppMethodBeat.o(66978);
  }
  
  private void dBo()
  {
    AppMethodBeat.i(66979);
    if (this.GUT == null) {
      this.GUT = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.GUy.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.GUT.add(localb);
      }
      this.GUT.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    Log.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.GUT != null) {
      paramViewGroup.removeView(((b)this.GUT.get(paramInt)).fIv);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.GUy == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.GUU)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.GUy.size();
    AppMethodBeat.o(66981);
    return i;
  }
  
  public final int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(66983);
    if (this.GUT != null)
    {
      Log.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.GUT.get(paramInt)).fIv, 0);
      paramViewGroup = ((b)this.GUT.get(paramInt)).fIv;
      AppMethodBeat.o(66983);
      return paramViewGroup;
    }
    paramViewGroup = super.instantiateItem(paramViewGroup, paramInt);
    AppMethodBeat.o(66983);
    return paramViewGroup;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public final void setData(List<String> paramList)
  {
    AppMethodBeat.i(66980);
    if (paramList != null)
    {
      if (paramList.size() > 0) {
        this.GUy = paramList;
      }
      dBo();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void fps();
  }
  
  final class b
    implements u.a
  {
    public ImageView fIv;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.fIv = null;
      this.url = paramString;
      this.fIv = ((ImageView)((LayoutInflater)g.a(g.this).getSystemService("layout_inflater")).inflate(a.g.product_image_item, null));
      paramString = u.a(new c(paramString));
      this.fIv.setImageBitmap(paramString);
      this.fIv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.b(g.this) != null) {
            g.b(g.this).fps();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66974);
        }
      });
      u.a(this);
      AppMethodBeat.o(66976);
    }
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(66977);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.MallProductImageAdapter", bool);
        if (this.url != null) {
          break;
        }
        AppMethodBeat.o(66977);
        return;
      }
      if (paramString.equals(this.url)) {
        this.fIv.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.fIv.setImageBitmap(paramBitmap);
            AppMethodBeat.o(66975);
          }
        });
      }
      AppMethodBeat.o(66977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g
 * JD-Core Version:    0.7.0.1
 */