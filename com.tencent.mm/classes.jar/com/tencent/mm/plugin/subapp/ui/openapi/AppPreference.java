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
  int FMp;
  a FMr;
  AdapterView.OnItemClickListener FMs;
  AdapterView.OnItemClickListener FMt;
  private View.OnClickListener FMu;
  private int FMv;
  private int FMw;
  private Context context;
  private boolean zgH;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29137);
    this.FMs = null;
    this.FMt = null;
    this.FMu = null;
    this.FMp = 0;
    this.zgH = false;
    this.FMw = 0;
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.FMv = paramContext.getInt(0, 8);
    this.zgH = paramContext.getBoolean(1, false);
    this.FMw = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29137);
  }
  
  public final g abn(int paramInt)
  {
    AppMethodBeat.i(29139);
    if ((paramInt < 0) || (paramInt >= this.FMr.getCount()))
    {
      AppMethodBeat.o(29139);
      return null;
    }
    g localg = (g)this.FMr.getItem(paramInt);
    AppMethodBeat.o(29139);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29138);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131302175);
    this.FMr = new a(this.context, this.FMp);
    localMMGridView.setAdapter(this.FMr);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29135);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (AppPreference.a(AppPreference.this).Ox(paramAnonymousInt))
        {
          AppPreference.a(AppPreference.this).we(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(29135);
          return;
        }
        if (AppPreference.a(AppPreference.this).FMo) {
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
    if (this.zgH) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29136);
          paramAnonymousAdapterView = AppPreference.this;
          if (paramAnonymousAdapterView.FMr != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.FMr;
            if (paramAnonymousAdapterView.FMr.FMo) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.we(bool);
            AppMethodBeat.o(29136);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131300110);
    if (this.FMr.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.FMw);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131297813);
      paramView.setVisibility(this.FMv);
      paramView.setOnClickListener(this.FMu);
      AppMethodBeat.o(29138);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29141);
    if (this.FMr != null) {
      ao.eAS().remove(this.FMr);
    }
    AppMethodBeat.o(29141);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29140);
    if (this.FMr != null) {
      ao.eAS().add(this.FMr);
    }
    AppMethodBeat.o(29140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */