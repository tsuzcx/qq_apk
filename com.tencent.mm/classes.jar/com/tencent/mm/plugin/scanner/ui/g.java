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
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  List<a.a> vFV;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51840);
    this.mView = null;
    this.mContext = null;
    this.vFV = null;
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
    if (this.vFV != null) {
      localb.fk(this.vFV);
    }
    AppMethodBeat.o(51842);
  }
  
  final class b
    extends BaseAdapter
    implements u.a
  {
    private LayoutInflater mInflater;
    private Map<String, WeakReference<ImageView>> xda;
    private int xdd;
    private List<a.a> xde;
    
    public b()
    {
      AppMethodBeat.i(51834);
      this.xde = new ArrayList();
      this.xda = new HashMap();
      this.mInflater = null;
      this.mInflater = LayoutInflater.from(g.a(g.this));
      u.a(this);
      this.xdd = g.a(g.this).getResources().getColor(2131100481);
      AppMethodBeat.o(51834);
    }
    
    public final void fk(List<a.a> paramList)
    {
      AppMethodBeat.i(51835);
      this.xda.clear();
      this.xde.clear();
      this.xde = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(51835);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51836);
      int i = this.xde.size();
      AppMethodBeat.o(51836);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(51837);
      Object localObject = this.xde.get(paramInt);
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
        paramViewGroup.xbm = ((ImageView)paramView.findViewById(2131300614));
        paramViewGroup.lgw = ((TextView)paramView.findViewById(2131300613));
        paramView.setTag(paramViewGroup);
        locala = (a.a)this.xde.get(paramInt);
        localObject = u.a(new g.a(locala.iconUrl));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label217;
        }
        paramViewGroup.xbm.setImageBitmap((Bitmap)localObject);
        paramViewGroup.xbm.setBackgroundColor(0);
      }
      for (;;)
      {
        localObject = locala.wYw;
        paramViewGroup.xbm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51832);
            paramAnonymousView = new k(this.oZO, locala.wYv, locala.type, this.oZO, g.b.this.getCount(), locala.cZX);
            com.tencent.mm.kernel.g.agi().a(paramAnonymousView, 0);
            if (!bs.isNullOrNil(this.oZO))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_Product_ID", this.oZO);
              d.b(g.this.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
            }
            AppMethodBeat.o(51832);
          }
        });
        paramViewGroup.xbm.setTag(locala.iconUrl);
        this.xda.put(locala.iconUrl, new WeakReference(paramViewGroup.xbm));
        paramViewGroup.lgw.setText(locala.name);
        AppMethodBeat.o(51838);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label217:
        paramViewGroup.xbm.setBackgroundColor(this.xdd);
        paramViewGroup.xbm.setImageBitmap(null);
      }
    }
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51839);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bs.isNullOrNil(paramString)))
      {
        ac.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(paramString)));
        if ((WeakReference)this.xda.get(paramString) != null)
        {
          final ImageView localImageView = (ImageView)((WeakReference)this.xda.get(paramString)).get();
          if ((localImageView != null) && (paramString.equals((String)localImageView.getTag()))) {
            ap.f(new Runnable()
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
      TextView lgw;
      ImageView xbm;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g
 * JD-Core Version:    0.7.0.1
 */