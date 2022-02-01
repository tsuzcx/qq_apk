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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends q
{
  private List<String> BaA;
  private ArrayList<b> BaV;
  private boolean BaW;
  a BaX;
  Context mContext;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.BaW = false;
    this.BaX = null;
    this.mContext = paramContext;
    this.BaA = null;
    setData(this.BaA);
    AppMethodBeat.o(66978);
  }
  
  private void eDD()
  {
    AppMethodBeat.i(66979);
    if (this.BaV == null) {
      this.BaV = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.BaA.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.BaV.add(localb);
      }
      this.BaV.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    Log.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.BaV != null) {
      paramViewGroup.removeView(((b)this.BaV.get(paramInt)).dPk);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.BaA == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.BaW)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.BaA.size();
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
    if (this.BaV != null)
    {
      Log.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.BaV.get(paramInt)).dPk, 0);
      paramViewGroup = ((b)this.BaV.get(paramInt)).dPk;
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
        this.BaA = paramList;
      }
      eDD();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void eDz();
  }
  
  final class b
    implements u.a
  {
    public ImageView dPk;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.dPk = null;
      this.url = paramString;
      this.dPk = ((ImageView)((LayoutInflater)g.this.mContext.getSystemService("layout_inflater")).inflate(2131495962, null));
      paramString = u.a(new c(paramString));
      this.dPk.setImageBitmap(paramString);
      this.dPk.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/product/ui/MallProductImageAdapter$ViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.this.BaX != null) {
            g.this.BaX.eDz();
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
        Log.d("MicroMsg.MallProductImageAdapter", bool);
        if (this.url != null) {
          break;
        }
        AppMethodBeat.o(66977);
        return;
      }
      if (paramString.equals(this.url)) {
        this.dPk.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.dPk.setImageBitmap(paramBitmap);
            AppMethodBeat.o(66975);
          }
        });
      }
      AppMethodBeat.o(66977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g
 * JD-Core Version:    0.7.0.1
 */