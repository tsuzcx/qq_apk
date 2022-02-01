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
  private ArrayList<b> uxF;
  private boolean uxG;
  a uxH;
  private List<String> uxl;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.uxG = false;
    this.uxH = null;
    this.mContext = paramContext;
    this.uxl = null;
    setData(this.uxl);
    AppMethodBeat.o(66978);
  }
  
  private void dbK()
  {
    AppMethodBeat.i(66979);
    if (this.uxF == null) {
      this.uxF = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.uxl.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.uxF.add(localb);
      }
      this.uxF.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    ad.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.uxF != null) {
      paramViewGroup.removeView(((b)this.uxF.get(paramInt)).dnd);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.uxl == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.uxG)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.uxl.size();
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
    if (this.uxF != null)
    {
      ad.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.uxF.get(paramInt)).dnd, 0);
      paramViewGroup = ((b)this.uxF.get(paramInt)).dnd;
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
        this.uxl = paramList;
      }
      dbK();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void dbG();
  }
  
  final class b
    implements u.a
  {
    public ImageView dnd;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.dnd = null;
      this.url = paramString;
      this.dnd = ((ImageView)((LayoutInflater)g.this.mContext.getSystemService("layout_inflater")).inflate(2131495119, null));
      paramString = u.a(new c(paramString));
      this.dnd.setImageBitmap(paramString);
      this.dnd.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          ad.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.this.uxH != null) {
            g.this.uxH.dbG();
          }
          AppMethodBeat.o(66974);
        }
      });
      u.a(this);
      AppMethodBeat.o(66976);
    }
    
    public final void l(String paramString, final Bitmap paramBitmap)
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
        this.dnd.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.dnd.setImageBitmap(paramBitmap);
            AppMethodBeat.o(66975);
          }
        });
      }
      AppMethodBeat.o(66977);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.g
 * JD-Core Version:    0.7.0.1
 */