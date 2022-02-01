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
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends androidx.viewpager.widget.a
{
  private List<String> MSa;
  private ArrayList<b> MSv;
  private boolean MSw;
  a MSx;
  private Context mContext;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.MSw = false;
    this.MSx = null;
    this.mContext = paramContext;
    this.MSa = null;
    setData(this.MSa);
    AppMethodBeat.o(66978);
  }
  
  private void gAA()
  {
    AppMethodBeat.i(66979);
    if (this.MSv == null) {
      this.MSv = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.MSa.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.MSv.add(localb);
      }
      this.MSv.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    Log.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.MSv != null) {
      paramViewGroup.removeView(((b)this.MSv.get(paramInt)).hNV);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.MSa == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.MSw)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.MSa.size();
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
    if (this.MSv != null)
    {
      Log.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.MSv.get(paramInt)).hNV, 0);
      paramViewGroup = ((b)this.MSv.get(paramInt)).hNV;
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
        this.MSa = paramList;
      }
      gAA();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void gAw();
  }
  
  final class b
    implements r.a
  {
    public ImageView hNV;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.hNV = null;
      this.url = paramString;
      this.hNV = ((ImageView)((LayoutInflater)g.a(g.this).getSystemService("layout_inflater")).inflate(a.g.product_image_item, null));
      paramString = r.a(new c(paramString));
      this.hNV.setImageBitmap(paramString);
      this.hNV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.b(g.this) != null) {
            g.b(g.this).gAw();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(66974);
        }
      });
      r.a(this);
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
        this.hNV.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.hNV.setImageBitmap(paramBitmap);
            AppMethodBeat.o(66975);
          }
        });
      }
      AppMethodBeat.o(66977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g
 * JD-Core Version:    0.7.0.1
 */