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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference
  extends Preference
{
  List<g> Dcn;
  b FML;
  AdapterView.OnItemClickListener FMs;
  private AdapterView.OnItemClickListener FMt;
  private View.OnClickListener FMu;
  private int FMv;
  private int FMw;
  private Context context;
  private boolean zgH;
  
  public ServicePreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ServicePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ServicePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(29177);
    this.FMs = null;
    this.FMt = null;
    this.FMu = null;
    this.zgH = false;
    this.FMw = 0;
    this.context = paramContext;
    setLayoutResource(2131493129);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.FMv = paramContext.getInt(0, 8);
    this.zgH = paramContext.getBoolean(1, false);
    this.FMw = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29177);
  }
  
  public final g abn(int paramInt)
  {
    AppMethodBeat.i(29179);
    if ((paramInt < 0) || (paramInt >= this.FML.getCount()))
    {
      AppMethodBeat.o(29179);
      return null;
    }
    g localg = (g)this.FML.getItem(paramInt);
    AppMethodBeat.o(29179);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29178);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131302175);
    if (localMMGridView == null)
    {
      AppMethodBeat.o(29178);
      return;
    }
    this.FML = new b(this.context, this.Dcn);
    ao.eAS().remove(this.FML);
    ao.eAS().add(this.FML);
    localMMGridView.setAdapter(this.FML);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29175);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/subapp/ui/openapi/ServicePreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        if (ServicePreference.a(ServicePreference.this).Ox(paramAnonymousInt))
        {
          ServicePreference.a(ServicePreference.this).we(false);
          a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServicePreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(29175);
          return;
        }
        if (ServicePreference.a(ServicePreference.this).FMo) {
          if (ServicePreference.b(ServicePreference.this) != null) {
            ServicePreference.b(ServicePreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          }
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/subapp/ui/openapi/ServicePreference$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(29175);
          return;
          if (ServicePreference.c(ServicePreference.this) != null) {
            ServicePreference.c(ServicePreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          }
        }
      }
    });
    if (this.zgH) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29176);
          paramAnonymousAdapterView = ServicePreference.this;
          if (paramAnonymousAdapterView.FML != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.FML;
            if (paramAnonymousAdapterView.FML.FMo) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.we(bool);
            AppMethodBeat.o(29176);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131300110);
    if (this.FML.getCount() == 0)
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
      AppMethodBeat.o(29178);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29181);
    if (this.FML != null) {
      ao.eAS().remove(this.FML);
    }
    AppMethodBeat.o(29181);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29180);
    if (this.FML != null) {
      ao.eAS().add(this.FML);
    }
    AppMethodBeat.o(29180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference
 * JD-Core Version:    0.7.0.1
 */