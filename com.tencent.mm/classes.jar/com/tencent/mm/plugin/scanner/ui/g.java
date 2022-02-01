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
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.s;
import com.tencent.mm.platformtools.s.a;
import com.tencent.mm.platformtools.s.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.j;
import com.tencent.mm.plugin.scanner.model.b.a;
import com.tencent.mm.plugin.scanner.model.p;
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
  List<b.a> Bar;
  private Context mContext;
  private View mView;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51840);
    this.mView = null;
    this.mContext = null;
    this.Bar = null;
    this.mContext = paramContext;
    setLayoutResource(2131495959);
    AppMethodBeat.o(51840);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
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
    paramView = (GridView)this.mView.findViewById(2131304324);
    b localb = new b();
    paramView.setAdapter(localb);
    if (this.Bar != null) {
      localb.gD(this.Bar);
    }
    AppMethodBeat.o(51842);
  }
  
  static final class a
    implements s
  {
    private String mPicUrl = null;
    
    public a(String paramString)
    {
      this.mPicUrl = paramString;
    }
    
    public final Bitmap a(Bitmap paramBitmap, s.a parama, String paramString)
    {
      AppMethodBeat.i(51830);
      if (s.a.jNh == parama) {}
      try
      {
        BitmapUtil.saveBitmapToImage(paramBitmap, 100, Bitmap.CompressFormat.PNG, blA(), false);
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
    
    public final void a(s.a parama, String paramString) {}
    
    public final void ad(String paramString, boolean paramBoolean) {}
    
    public final String blA()
    {
      AppMethodBeat.i(51829);
      String str = j.eOR().jP(this.mPicUrl, "@S");
      AppMethodBeat.o(51829);
      return str;
    }
    
    public final String blB()
    {
      return this.mPicUrl;
    }
    
    public final String blC()
    {
      return this.mPicUrl;
    }
    
    public final boolean blD()
    {
      return false;
    }
    
    public final boolean blE()
    {
      return false;
    }
    
    public final Bitmap blF()
    {
      AppMethodBeat.i(51831);
      if (MMApplicationContext.getContext() == null)
      {
        AppMethodBeat.o(51831);
        return null;
      }
      Bitmap localBitmap = BitmapFactory.decodeResource(MMApplicationContext.getContext().getResources(), 2131234279);
      AppMethodBeat.o(51831);
      return localBitmap;
    }
    
    public final void blG() {}
    
    public final s.b blz()
    {
      return null;
    }
    
    public final String getCacheKey()
    {
      return this.mPicUrl;
    }
  }
  
  final class b
    extends BaseAdapter
    implements u.a
  {
    private Map<String, WeakReference<ImageView>> CKQ;
    private int CKT;
    private List<b.a> CKU;
    private LayoutInflater mInflater;
    
    public b()
    {
      AppMethodBeat.i(51834);
      this.CKU = new ArrayList();
      this.CKQ = new HashMap();
      this.mInflater = null;
      this.mInflater = LayoutInflater.from(g.a(g.this));
      u.a(this);
      this.CKT = g.a(g.this).getResources().getColor(2131100583);
      AppMethodBeat.o(51834);
    }
    
    public final void gD(List<b.a> paramList)
    {
      AppMethodBeat.i(51835);
      this.CKQ.clear();
      this.CKU.clear();
      this.CKU = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(51835);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51836);
      int i = this.CKU.size();
      AppMethodBeat.o(51836);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(51837);
      Object localObject = this.CKU.get(paramInt);
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
      final b.a locala;
      Object localObject;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(2131495960, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.CJe = ((ImageView)paramView.findViewById(2131302169));
        paramViewGroup.jVn = ((TextView)paramView.findViewById(2131302168));
        paramView.setTag(paramViewGroup);
        locala = (b.a)this.CKU.get(paramInt);
        localObject = u.a(new g.a(locala.iconUrl));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label217;
        }
        paramViewGroup.CJe.setImageBitmap((Bitmap)localObject);
        paramViewGroup.CJe.setBackgroundColor(0);
      }
      for (;;)
      {
        localObject = locala.CEN;
        paramViewGroup.CJe.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51832);
            b localb = new b();
            localb.bm(paramAnonymousView);
            a.b("com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = new p(this.raF, locala.CEM, locala.type, this.raF, g.b.this.getCount(), locala.dDG);
            com.tencent.mm.kernel.g.azz().a(paramAnonymousView, 0);
            if (!Util.isNullOrNil(this.raF))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_Product_ID", this.raF);
              c.b(g.this.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
            }
            a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51832);
          }
        });
        paramViewGroup.CJe.setTag(locala.iconUrl);
        this.CKQ.put(locala.iconUrl, new WeakReference(paramViewGroup.CJe));
        paramViewGroup.jVn.setText(locala.name);
        AppMethodBeat.o(51838);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label217:
        paramViewGroup.CJe.setBackgroundColor(this.CKT);
        paramViewGroup.CJe.setImageBitmap(null);
      }
    }
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51839);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!Util.isNullOrNil(paramString)))
      {
        Log.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(paramString)));
        if ((WeakReference)this.CKQ.get(paramString) != null)
        {
          final ImageView localImageView = (ImageView)((WeakReference)this.CKQ.get(paramString)).get();
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
    
    final class a
    {
      ImageView CJe;
      TextView jVn;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g
 * JD-Core Version:    0.7.0.1
 */