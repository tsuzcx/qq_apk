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
import com.tencent.mm.R.h;
import com.tencent.mm.R.n;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference
  extends Preference
{
  private boolean KGh;
  int SHO;
  a SHQ;
  AdapterView.OnItemClickListener SHR;
  AdapterView.OnItemClickListener SHS;
  private View.OnClickListener SHT;
  private int SHU;
  private int SHV;
  private Context context;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29137);
    this.SHR = null;
    this.SHS = null;
    this.SHT = null;
    this.SHO = 0;
    this.KGh = false;
    this.SHV = 0;
    this.context = paramContext;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.gZK);
    this.SHU = paramContext.getInt(R.n.gZL, 8);
    this.KGh = paramContext.getBoolean(R.n.gZM, false);
    this.SHV = paramContext.getResourceId(R.n.gZN, 0);
    paramContext.recycle();
    AppMethodBeat.o(29137);
  }
  
  public final g anJ(int paramInt)
  {
    AppMethodBeat.i(29139);
    if ((paramInt < 0) || (paramInt >= this.SHQ.getCount()))
    {
      AppMethodBeat.o(29139);
      return null;
    }
    g localg = (g)this.SHQ.getItem(paramInt);
    AppMethodBeat.o(29139);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29138);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(R.h.fJm);
    this.SHQ = new a(this.context, this.SHO);
    localMMGridView.setAdapter(this.SHQ);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29135);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (AppPreference.a(AppPreference.this).XL(paramAnonymousInt))
        {
          AppPreference.a(AppPreference.this).Fb(false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/AppPreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(29135);
          return;
        }
        if (AppPreference.a(AppPreference.this).SHN) {
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
    if (this.KGh) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29136);
          paramAnonymousAdapterView = AppPreference.this;
          if (paramAnonymousAdapterView.SHQ != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.SHQ;
            if (paramAnonymousAdapterView.SHQ.SHN) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.Fb(bool);
            AppMethodBeat.o(29136);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(R.h.empty_tv);
    if (this.SHQ.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.SHV);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(R.h.btn);
      paramView.setVisibility(this.SHU);
      paramView.setOnClickListener(this.SHT);
      AppMethodBeat.o(29138);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29141);
    if (this.SHQ != null) {
      as.gxn().remove(this.SHQ);
    }
    AppMethodBeat.o(29141);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29140);
    if (this.SHQ != null) {
      as.gxn().add(this.SHQ);
    }
    AppMethodBeat.o(29140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */