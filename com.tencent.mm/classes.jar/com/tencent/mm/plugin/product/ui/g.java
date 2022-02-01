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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends q
{
  Context mContext;
  a vGA;
  private List<String> vGe;
  private ArrayList<b> vGy;
  private boolean vGz;
  
  public g(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(66978);
    this.vGz = false;
    this.vGA = null;
    this.mContext = paramContext;
    this.vGe = null;
    setData(this.vGe);
    AppMethodBeat.o(66978);
  }
  
  private void dps()
  {
    AppMethodBeat.i(66979);
    if (this.vGy == null) {
      this.vGy = new ArrayList();
    }
    for (;;)
    {
      Iterator localIterator = this.vGe.iterator();
      while (localIterator.hasNext())
      {
        b localb = new b((String)localIterator.next());
        this.vGy.add(localb);
      }
      this.vGy.clear();
    }
    AppMethodBeat.o(66979);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(66982);
    ac.d("MicroMsg.MallProductImageAdapter", "destroy item");
    if (this.vGy != null) {
      paramViewGroup.removeView(((b)this.vGy.get(paramInt)).dkL);
    }
    AppMethodBeat.o(66982);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66981);
    if (this.vGe == null)
    {
      AppMethodBeat.o(66981);
      return 0;
    }
    if (this.vGz)
    {
      AppMethodBeat.o(66981);
      return 2147483647;
    }
    int i = this.vGe.size();
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
    if (this.vGy != null)
    {
      ac.d("MicroMsg.MallProductImageAdapter", "data valid");
      paramViewGroup.addView(((b)this.vGy.get(paramInt)).dkL, 0);
      paramViewGroup = ((b)this.vGy.get(paramInt)).dkL;
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
        this.vGe = paramList;
      }
      dps();
    }
    AppMethodBeat.o(66980);
  }
  
  public static abstract interface a
  {
    public abstract void dpo();
  }
  
  final class b
    implements u.a
  {
    public ImageView dkL;
    public String url;
    
    public b(String paramString)
    {
      AppMethodBeat.i(66976);
      this.dkL = null;
      this.url = paramString;
      this.dkL = ((ImageView)((LayoutInflater)g.this.mContext.getSystemService("layout_inflater")).inflate(2131495119, null));
      paramString = u.a(new c(paramString));
      this.dkL.setImageBitmap(paramString);
      this.dkL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(66974);
          ac.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
          if (g.this.vGA != null) {
            g.this.vGA.dpo();
          }
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
        ac.d("MicroMsg.MallProductImageAdapter", bool);
        if (this.url != null) {
          break;
        }
        AppMethodBeat.o(66977);
        return;
      }
      if (paramString.equals(this.url)) {
        this.dkL.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66975);
            g.b.this.dkL.setImageBitmap(paramBitmap);
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