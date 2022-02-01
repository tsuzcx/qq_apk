package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference
  extends Preference
{
  int Bke;
  a Bkg;
  AdapterView.OnItemClickListener Bkh;
  AdapterView.OnItemClickListener Bki;
  private View.OnClickListener Bkj;
  private int Bkk;
  private int Bkl;
  private Context context;
  private boolean vzz;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29137);
    this.Bkh = null;
    this.Bki = null;
    this.Bkj = null;
    this.Bke = 0;
    this.vzz = false;
    this.Bkl = 0;
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.Bkk = paramContext.getInt(0, 8);
    this.vzz = paramContext.getBoolean(1, false);
    this.Bkl = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29137);
  }
  
  public final g SK(int paramInt)
  {
    AppMethodBeat.i(29139);
    if ((paramInt < 0) || (paramInt >= this.Bkg.getCount()))
    {
      AppMethodBeat.o(29139);
      return null;
    }
    g localg = (g)this.Bkg.getItem(paramInt);
    AppMethodBeat.o(29139);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29138);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131300620);
    this.Bkg = new a(this.context, this.Bke);
    localMMGridView.setAdapter(this.Bkg);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29135);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (AppPreference.a(AppPreference.this).HY(paramAnonymousInt))
        {
          AppPreference.a(AppPreference.this).sD(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(29135);
          return;
        }
        if (AppPreference.a(AppPreference.this).Bkd) {
          if (AppPreference.b(AppPreference.this) != null) {
            AppPreference.b(AppPreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(29135);
          return;
          if (AppPreference.c(AppPreference.this) != null) {
            AppPreference.c(AppPreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          }
        }
      }
    });
    if (this.vzz) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29136);
          paramAnonymousAdapterView = AppPreference.this;
          if (paramAnonymousAdapterView.Bkg != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.Bkg;
            if (paramAnonymousAdapterView.Bkg.Bkd) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.sD(bool);
            AppMethodBeat.o(29136);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131299477);
    if (this.Bkg.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.Bkl);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131297574);
      paramView.setVisibility(this.Bkk);
      paramView.setOnClickListener(this.Bkj);
      AppMethodBeat.o(29138);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29141);
    if (this.Bkg != null) {
      ao.dxQ().remove(this.Bkg);
    }
    AppMethodBeat.o(29141);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29140);
    if (this.Bkg != null) {
      ao.dxQ().add(this.Bkg);
    }
    AppMethodBeat.o(29140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */