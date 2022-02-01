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
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference
  extends Preference
{
  private Context context;
  private boolean uwW;
  List<g> xsD;
  AdapterView.OnItemClickListener zSC;
  private AdapterView.OnItemClickListener zSD;
  private View.OnClickListener zSE;
  private int zSF;
  private int zSG;
  b zSV;
  
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
    this.zSC = null;
    this.zSD = null;
    this.zSE = null;
    this.uwW = false;
    this.zSG = 0;
    this.context = paramContext;
    setLayoutResource(2131493087);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.zSF = paramContext.getInt(0, 8);
    this.uwW = paramContext.getBoolean(1, false);
    this.zSG = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29177);
  }
  
  public final g Ra(int paramInt)
  {
    AppMethodBeat.i(29179);
    if ((paramInt < 0) || (paramInt >= this.zSV.getCount()))
    {
      AppMethodBeat.o(29179);
      return null;
    }
    g localg = (g)this.zSV.getItem(paramInt);
    AppMethodBeat.o(29179);
    return localg;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(29178);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131300620);
    if (localMMGridView == null)
    {
      AppMethodBeat.o(29178);
      return;
    }
    this.zSV = new b(this.context, this.xsD);
    ap.dny().remove(this.zSV);
    ap.dny().add(this.zSV);
    localMMGridView.setAdapter(this.zSV);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29175);
        if (ServicePreference.a(ServicePreference.this).GF(paramAnonymousInt))
        {
          ServicePreference.a(ServicePreference.this).rX(false);
          AppMethodBeat.o(29175);
          return;
        }
        if (ServicePreference.a(ServicePreference.this).zSy)
        {
          if (ServicePreference.b(ServicePreference.this) != null)
          {
            ServicePreference.b(ServicePreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
            AppMethodBeat.o(29175);
          }
        }
        else if (ServicePreference.c(ServicePreference.this) != null) {
          ServicePreference.c(ServicePreference.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(29175);
      }
    });
    if (this.uwW) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29176);
          paramAnonymousAdapterView = ServicePreference.this;
          if (paramAnonymousAdapterView.zSV != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.zSV;
            if (paramAnonymousAdapterView.zSV.zSy) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.rX(bool);
            AppMethodBeat.o(29176);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131299477);
    if (this.zSV.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.zSG);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131297574);
      paramView.setVisibility(this.zSF);
      paramView.setOnClickListener(this.zSE);
      AppMethodBeat.o(29178);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29181);
    if (this.zSV != null) {
      ap.dny().remove(this.zSV);
    }
    AppMethodBeat.o(29181);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29180);
    if (this.zSV != null) {
      ap.dny().add(this.zSV);
    }
    AppMethodBeat.o(29180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference
 * JD-Core Version:    0.7.0.1
 */