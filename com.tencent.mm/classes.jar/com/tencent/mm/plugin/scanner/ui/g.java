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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.scanner.model.a.a;
import com.tencent.mm.plugin.scanner.model.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
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
  List<a.a> xcP;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51840);
    this.mView = null;
    this.mContext = null;
    this.xcP = null;
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
    if (this.xcP != null) {
      localb.fF(this.xcP);
    }
    AppMethodBeat.o(51842);
  }
  
  final class b
    extends BaseAdapter
    implements u.a
  {
    private LayoutInflater mInflater;
    private Map<String, WeakReference<ImageView>> yHc;
    private int yHf;
    private List<a.a> yHg;
    
    public b()
    {
      AppMethodBeat.i(51834);
      this.yHg = new ArrayList();
      this.yHc = new HashMap();
      this.mInflater = null;
      this.mInflater = LayoutInflater.from(g.a(g.this));
      u.a(this);
      this.yHf = g.a(g.this).getResources().getColor(2131100481);
      AppMethodBeat.o(51834);
    }
    
    public final void fF(List<a.a> paramList)
    {
      AppMethodBeat.i(51835);
      this.yHc.clear();
      this.yHg.clear();
      this.yHg = paramList;
      notifyDataSetChanged();
      AppMethodBeat.o(51835);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(51836);
      int i = this.yHg.size();
      AppMethodBeat.o(51836);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(51837);
      Object localObject = this.yHg.get(paramInt);
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
        paramViewGroup.yFm = ((ImageView)paramView.findViewById(2131300614));
        paramViewGroup.lHT = ((TextView)paramView.findViewById(2131300613));
        paramView.setTag(paramViewGroup);
        locala = (a.a)this.yHg.get(paramInt);
        localObject = u.a(new g.a(locala.iconUrl));
        if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
          break label217;
        }
        paramViewGroup.yFm.setImageBitmap((Bitmap)localObject);
        paramViewGroup.yFm.setBackgroundColor(0);
      }
      for (;;)
      {
        localObject = locala.yCe;
        paramViewGroup.yFm.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(51832);
            b localb = new b();
            localb.bd(paramAnonymousView);
            a.b("com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = new n(this.pKc, locala.yCd, locala.type, this.pKc, g.b.this.getCount(), locala.dmr);
            com.tencent.mm.kernel.g.ajj().a(paramAnonymousView, 0);
            if (!bu.isNullOrNil(this.pKc))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("key_Product_ID", this.pKc);
              d.b(g.this.mContext, "scanner", ".ui.ProductUI", paramAnonymousView);
            }
            a.a(this, "com/tencent/mm/plugin/scanner/ui/ProductGridPreference$ProductGridAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(51832);
          }
        });
        paramViewGroup.yFm.setTag(locala.iconUrl);
        this.yHc.put(locala.iconUrl, new WeakReference(paramViewGroup.yFm));
        paramViewGroup.lHT.setText(locala.name);
        AppMethodBeat.o(51838);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label217:
        paramViewGroup.yFm.setBackgroundColor(this.yHf);
        paramViewGroup.yFm.setImageBitmap(null);
      }
    }
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(51839);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (!bu.isNullOrNil(paramString)))
      {
        ae.v("MicroMsg.ProductGridPreference", "On get pic, notifyKey=".concat(String.valueOf(paramString)));
        if ((WeakReference)this.yHc.get(paramString) != null)
        {
          final ImageView localImageView = (ImageView)((WeakReference)this.yHc.get(paramString)).get();
          if ((localImageView != null) && (paramString.equals((String)localImageView.getTag()))) {
            ar.f(new Runnable()
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
      TextView lHT;
      ImageView yFm;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.g
 * JD-Core Version:    0.7.0.1
 */