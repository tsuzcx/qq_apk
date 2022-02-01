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
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
  extends Preference
{
  private Context mContext;
  private View mView;
  List<a.a> uxc;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51840);
    this.mView = null;
    this.mContext = null;
    this.uxc = null;
    this.mContext = paramContext;
    setLayoutResource(2131495116);
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
    paramView = (GridView)this.mView.findViewById(2131301987);
    b localb = new b();
    paramView.setAdapter(localb);
    if (this.uxc != null) {
      localb.setItemList(this.uxc);
    }
    AppMethodBeat.o(51842);
  }
  
  final class b
    extends BaseAdapter
    implements u.a
  {
    private LayoutInflater mInflater;
    private Map<String, WeakReference<ImageView>> vSp;
    private int vSs;
    private List<a.a> vSt;
    
    public b()
    {
      AppMethodBeat.i(51834);
      this.vSt = new ArrayList();
      this.vSp = new HashMap();
      this.mInflater = null;
      this.mInflater = LayoutInflater.from(g.a(g.this));
      u.a(this);
      this.vSs = g.a(g.this).getResources().getColor(2131100481);
      AppMethodBeat.o(51834);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51836);
      int i = this.vSt.size();
      AppMethodBeat.o(51836);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(51837);
      Object localObject = this.vSt.get(paramInt);
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
        paramView = this.mInflater.inflate(2131495117, paramViewGroup, false);
        paramViewGroup = new a();
        paramViewGroup.vQE = ((ImageView)paramView.findViewById(2131300614));
        paramViewGroup.kFd = ((TextView)paramView.findViewById(2131300613));
        paramView.setTag(paramViewGroup);
        locala = (a.a)this.vSt.get(paramInt);
        localObject = u.a(new g.a(locala.iconUrl));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label217;
        }
        paramViewGroup.vQE.setImageBitmap((Bitmap)localObject);
        paramViewGroup.vQE.setBackgroundColor(0);
      }
      for (;;)
      {
        localObject = locala.vOa;
        paramViewGroup.vQE.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51832);
            paramAnonymousView = new k(this.owo, locala.vNZ, locala.type, this.owo, g.b.this.getCount(), locala.dcz);
            com.tencent.mm.kernel.g.aeS().a(paramAnonymousView, 0);
            if (!bt.isNullOrNil(this.owo))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_Product_ID", this.owo);
              d.b(g.this.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
            }
            AppMethodBeat.o(51832);
          }
        });
        paramViewGroup.vQE.setTag(locala.iconUrl);
        this.vSp.put(locala.iconUrl, new WeakReference(paramViewGroup.vQE));
        paramViewGroup.kFd.setText(locala.name);
        AppMethodBeat.o(51838);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label217:
        paramViewGroup.vQE.setBackgroundColor(this.vSs);
        paramViewGroup.vQE.setImageBitmap(null);
      }
    }
    
    public final void l(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51839);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bt.isNullOrNil(paramString)))
      {
        ad.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(paramString)));
        if ((WeakReference)this.vSp.get(paramString) != null)
        {
          final ImageView localImageView = (ImageView)((WeakReference)this.vSp.get(paramString)).get();
          if ((localImageView != null) && (paramString.equals((String)localImageView.getTag()))) {
            aq.f(new Runnable()
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
    
    public final void setItemList(List<a.a> paramList)
    {
      AppMethodBeat.i(51835);
      this.vSp.clear();
      this.vSt.clear();
      this.vSt = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(51835);
    }
    
    final class a
    {
      TextView kFd;
      ImageView vQE;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g
 * JD-Core Version:    0.7.0.1
 */