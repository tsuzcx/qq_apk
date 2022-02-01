package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.q;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends q
{
  Context mContext;
  private ArrayList<b> wNF;
  private boolean wNG;
  a wNH;
  private List<String> wNk;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.wNG = false;
    this.wNH = null;
    this.mContext = paramContext;
    this.wNk = null;
    setData(this.wNk);
    AppMethodBeat.o(66978);
  }
  
  private void dzU()
  {
    AppMethodBeat.i(66979);
    if (this.wNF == null) {
      this.wNF = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.wNk.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.wNF.add(localb);
      }
      this.wNF.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    ad.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.wNF != null) {
      paramViewGroup.removeView(((b)this.wNF.get(paramInt)).dwy);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.wNk == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.wNG)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.wNk.size();
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
    if (this.wNF != null)
    {
      ad.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.wNF.get(paramInt)).dwy, 0);
      paramViewGroup = ((b)this.wNF.get(paramInt)).dwy;
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
        this.wNk = paramList;
      }
      dzU();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void dzQ();
  }
  
  final class b
    implements u.a
  {
    public ImageView dwy;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.dwy = null;
      this.url = paramString;
      this.dwy = ((ImageView)((LayoutInflater)g.this.mContext.getSystemService("layout_inflater")).inflate(2131495119, null));
      paramString = u.a(new c(paramString));
      this.dwy.setImageBitmap(paramString);
      this.dwy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.this.wNH != null) {
            g.this.wNH.dzQ();
          }
          a.a(this, "com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        ad.d("MicroMsg.MallProductImageAdapter", bool);
        if (this.url != null) {
          break;
        }
        AppMethodBeat.o(66977);
        return;
      }
      if (paramString.equals(this.url)) {
        this.dwy.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.dwy.setImageBitmap(paramBitmap);
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