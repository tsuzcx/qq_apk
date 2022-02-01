package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.l.c;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
  extends Preference
{
  List<a.a> GUp;
  private Context mContext;
  private View mView;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51840);
    this.mView = null;
    this.mContext = null;
    this.GUp = null;
    this.mContext = paramContext;
    setLayoutResource(l.g.IEo);
    AppMethodBeat.o(51840);
  }
  
  public final View c(View paramView, ViewGroup paramViewGroup)
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
    paramView = (GridView)this.mView.findViewById(l.f.ICK);
    b localb = new b();
    paramView.setAdapter(localb);
    if (this.GUp != null) {
      localb.hj(this.GUp);
    }
    AppMethodBeat.o(51842);
  }
  
  final class b
    extends BaseAdapter
    implements u.a
  {
    private Map<String, WeakReference<ImageView>> IQr;
    private int IQu;
    private List<a.a> IQv;
    private LayoutInflater mInflater;
    
    public b()
    {
      AppMethodBeat.i(51834);
      this.IQv = new ArrayList();
      this.IQr = new HashMap();
      this.mInflater = null;
      this.mInflater = LayoutInflater.from(g.a(g.this));
      u.a(this);
      this.IQu = g.a(g.this).getResources().getColor(l.c.IBU);
      AppMethodBeat.o(51834);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51836);
      int i = this.IQv.size();
      AppMethodBeat.o(51836);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(51837);
      Object localObject = this.IQv.get(paramInt);
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
        paramView = this.mInflater.inflate(l.g.IEp, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.IOE = ((ImageView)paramView.findViewById(l.f.ICI));
        paramViewGroup.mMA = ((TextView)paramView.findViewById(l.f.ICH));
        paramView.setTag(paramViewGroup);
        locala = (a.a)this.IQv.get(paramInt);
        localObject = u.a(new g.a(locala.iconUrl));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label220;
        }
        paramViewGroup.IOE.setImageBitmap((Bitmap)localObject);
        paramViewGroup.IOE.setBackgroundColor(0);
      }
      for (;;)
      {
        localObject = locala.IKm;
        paramViewGroup.IOE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51832);
            b localb = new b();
            localb.bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new n(this.uDF, locala.IKl, locala.type, this.uDF, g.b.this.getCount(), locala.fwp);
            h.aGY().a(paramAnonymousView, 0);
            if (!Util.isNullOrNil(this.uDF))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_Product_ID", this.uDF);
              c.b(g.this.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
            }
            a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51832);
          }
        });
        paramViewGroup.IOE.setTag(locala.iconUrl);
        this.IQr.put(locala.iconUrl, new WeakReference(paramViewGroup.IOE));
        paramViewGroup.mMA.setText(locala.name);
        AppMethodBeat.o(51838);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label220:
        paramViewGroup.IOE.setBackgroundColor(this.IQu);
        paramViewGroup.IOE.setImageBitmap(null);
      }
    }
    
    public final void hj(List<a.a> paramList)
    {
      AppMethodBeat.i(51835);
      this.IQr.clear();
      this.IQv.clear();
      this.IQv = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(51835);
    }
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51839);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!Util.isNullOrNil(paramString)))
      {
        Log.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(paramString)));
        if ((WeakReference)this.IQr.get(paramString) != null)
        {
          final ImageView localImageView = (ImageView)((WeakReference)this.IQr.get(paramString)).get();
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
      ImageView IOE;
      TextView mMA;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g
 * JD-Core Version:    0.7.0.1
 */