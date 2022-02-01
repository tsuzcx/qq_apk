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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends q
{
  Context mContext;
  private List<String> xcY;
  private ArrayList<b> xdt;
  private boolean xdu;
  a xdv;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.xdu = false;
    this.xdv = null;
    this.mContext = paramContext;
    this.xcY = null;
    setData(this.xcY);
    AppMethodBeat.o(66978);
  }
  
  private void dDl()
  {
    AppMethodBeat.i(66979);
    if (this.xdt == null) {
      this.xdt = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.xcY.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.xdt.add(localb);
      }
      this.xdt.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    ae.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.xdt != null) {
      paramViewGroup.removeView(((b)this.xdt.get(paramInt)).dxD);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.xcY == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.xdu)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.xcY.size();
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
    if (this.xdt != null)
    {
      ae.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.xdt.get(paramInt)).dxD, 0);
      paramViewGroup = ((b)this.xdt.get(paramInt)).dxD;
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
        this.xcY = paramList;
      }
      dDl();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void dDh();
  }
  
  final class b
    implements u.a
  {
    public ImageView dxD;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.dxD = null;
      this.url = paramString;
      this.dxD = ((ImageView)((LayoutInflater)g.this.mContext.getSystemService("layout_inflater")).inflate(2131495119, null));
      paramString = u.a(new c(paramString));
      this.dxD.setImageBitmap(paramString);
      this.dxD.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.this.xdv != null) {
            g.this.xdv.dDh();
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
        ae.d("MicroMsg.MallProductImageAdapter", bool);
        if (this.url != null) {
          break;
        }
        AppMethodBeat.o(66977);
        return;
      }
      if (paramString.equals(this.url)) {
        this.dxD.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.dxD.setImageBitmap(paramBitmap);
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