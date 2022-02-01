package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.p.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.e;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.o;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
  extends Preference
{
  List<a.a> MRS;
  private Context mContext;
  private View mView;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51840);
    this.mView = null;
    this.mContext = null;
    this.MRS = null;
    this.mContext = paramContext;
    setLayoutResource(l.g.OKr);
    AppMethodBeat.o(51840);
  }
  
  public final View b(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(51841);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(51841);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(51842);
    super.onBindView(paramView);
    paramView = (GridView)this.mView.findViewById(l.f.OIL);
    b localb = new b();
    paramView.setAdapter(localb);
    if (this.MRS != null) {
      localb.kj(this.MRS);
    }
    AppMethodBeat.o(51842);
  }
  
  static final class a
    implements p
  {
    private String mPicUrl = null;
    
    public a(String paramString)
    {
      this.mPicUrl = paramString;
    }
    
    public final Bitmap a(Bitmap paramBitmap, p.a parama, String paramString)
    {
      AppMethodBeat.i(51830);
      if (p.a.pAS == parama) {}
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, bTC(), false);
        AppMethodBeat.o(51830);
        return paramBitmap;
      }
      catch (IOException parama)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.ProductGridPreference", parama, "", new Object[0]);
        }
      }
    }
    
    public final void a(p.a parama) {}
    
    public final p.b bTB()
    {
      return null;
    }
    
    public final String bTC()
    {
      AppMethodBeat.i(51829);
      String str = o.gPw().lG(this.mPicUrl, "@S");
      AppMethodBeat.o(51829);
      return str;
    }
    
    public final String bTD()
    {
      return this.mPicUrl;
    }
    
    public final String bTE()
    {
      return this.mPicUrl;
    }
    
    public final boolean bTF()
    {
      return false;
    }
    
    public final boolean bTG()
    {
      return false;
    }
    
    public final Bitmap bTH()
    {
      AppMethodBeat.i(51831);
      if (MMApplicationContext.getContext() == null)
      {
        AppMethodBeat.o(51831);
        return null;
      }
      Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), l.e.nosdcard_chatting_bg);
      AppMethodBeat.o(51831);
      return localBitmap;
    }
    
    public final void bTI() {}
    
    public final void bTJ() {}
    
    public final String getCacheKey()
    {
      return this.mPicUrl;
    }
  }
  
  final class b
    extends BaseAdapter
    implements r.a
  {
    private Map<String, WeakReference<ImageView>> OZn;
    private int OZq;
    private List<a.a> OZr;
    private LayoutInflater mInflater;
    
    public b()
    {
      AppMethodBeat.i(51834);
      this.OZr = new ArrayList();
      this.OZn = new HashMap();
      this.mInflater = null;
      this.mInflater = LayoutInflater.from(g.a(g.this));
      r.a(this);
      this.OZq = g.a(g.this).getResources().getColor(l.c.OHW);
      AppMethodBeat.o(51834);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51836);
      int i = this.OZr.size();
      AppMethodBeat.o(51836);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(51837);
      Object localObject = this.OZr.get(paramInt);
      AppMethodBeat.o(51837);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(51838);
      final a.a locala;
      Object localObject;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(l.g.OKs, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.OXg = ((ImageView)paramView.findViewById(l.f.OIJ));
        paramViewGroup.pJi = ((TextView)paramView.findViewById(l.f.OII));
        paramView.setTag(paramViewGroup);
        locala = (a.a)this.OZr.get(paramInt);
        localObject = r.a(new g.a(locala.iconUrl));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label220;
        }
        paramViewGroup.OXg.setImageBitmap((Bitmap)localObject);
        paramViewGroup.OXg.setBackgroundColor(0);
      }
      for (;;)
      {
        localObject = locala.productid;
        paramViewGroup.OXg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51832);
            b localb = new b();
            localb.cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new v(this.xLX, locala.OQV, locala.type, this.xLX, g.b.this.getCount(), locala.hAN);
            h.aZW().a(paramAnonymousView, 0);
            if (!Util.isNullOrNil(this.xLX))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_Product_ID", this.xLX);
              c.b(g.this.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
            }
            a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51832);
          }
        });
        paramViewGroup.OXg.setTag(locala.iconUrl);
        this.OZn.put(locala.iconUrl, new WeakReference(paramViewGroup.OXg));
        paramViewGroup.pJi.setText(locala.name);
        AppMethodBeat.o(51838);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label220:
        paramViewGroup.OXg.setBackgroundColor(this.OZq);
        paramViewGroup.OXg.setImageBitmap(null);
      }
    }
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51839);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!Util.isNullOrNil(paramString)))
      {
        Log.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(paramString)));
        if ((WeakReference)this.OZn.get(paramString) != null)
        {
          final ImageView localImageView = (ImageView)((WeakReference)this.OZn.get(paramString)).get();
          if ((localImageView != null) && (paramString.equals((String)localImageView.getTag()))) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(51833);
                localImageView.setImageBitmap(paramBitmap);
                localImageView.setBackgroundColor(0);
                AppMethodBeat.o(51833);
              }
            });
          }
        }
      }
      AppMethodBeat.o(51839);
    }
    
    public final void kj(List<a.a> paramList)
    {
      AppMethodBeat.i(51835);
      this.OZn.clear();
      this.OZr.clear();
      this.OZr = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(51835);
    }
    
    final class a
    {
      ImageView OXg;
      TextView pJi;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g
 * JD-Core Version:    0.7.0.1
 */