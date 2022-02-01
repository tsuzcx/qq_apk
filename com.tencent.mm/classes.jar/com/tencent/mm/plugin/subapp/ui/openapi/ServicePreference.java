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
  private boolean toE;
  List<g> whn;
  b yFH;
  AdapterView.OnItemClickListener yFo;
  private AdapterView.OnItemClickListener yFp;
  private View.OnClickListener yFq;
  private int yFr;
  private int yFs;
  
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
    this.yFo = null;
    this.yFp = null;
    this.yFq = null;
    this.toE = false;
    this.yFs = 0;
    this.context = paramContext;
    setLayoutResource(2131493087);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.yFr = paramContext.getInt(0, 8);
    this.toE = paramContext.getBoolean(1, false);
    this.yFs = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(29177);
  }
  
  public final g OU(int paramInt)
  {
    AppMethodBeat.i(29179);
    if ((paramInt < 0) || (paramInt >= this.yFH.getCount()))
    {
      AppMethodBeat.o(29179);
      return null;
    }
    g localg = (g)this.yFH.getItem(paramInt);
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
    this.yFH = new b(this.context, this.whn);
    ap.cZQ().remove(this.yFH);
    ap.cZQ().add(this.yFH);
    localMMGridView.setAdapter(this.yFH);
    localMMGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(29175);
        if (ServicePreference.a(ServicePreference.this).EJ(paramAnonymousInt))
        {
          ServicePreference.a(ServicePreference.this).qZ(false);
          AppMethodBeat.o(29175);
          return;
        }
        if (ServicePreference.a(ServicePreference.this).yFk)
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
    if (this.toE) {
      localMMGridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(29176);
          paramAnonymousAdapterView = ServicePreference.this;
          if (paramAnonymousAdapterView.yFH != null)
          {
            paramAnonymousView = paramAnonymousAdapterView.yFH;
            if (paramAnonymousAdapterView.yFH.yFk) {
              break label50;
            }
          }
          label50:
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.qZ(bool);
            AppMethodBeat.o(29176);
            return true;
          }
        }
      });
    }
    TextView localTextView = (TextView)paramView.findViewById(2131299477);
    if (this.yFH.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.yFs);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131297574);
      paramView.setVisibility(this.yFr);
      paramView.setOnClickListener(this.yFq);
      AppMethodBeat.o(29178);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(29181);
    if (this.yFH != null) {
      ap.cZQ().remove(this.yFH);
    }
    AppMethodBeat.o(29181);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(29180);
    if (this.yFH != null) {
      ap.cZQ().add(this.yFH);
    }
    AppMethodBeat.o(29180);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference
 * JD-Core Version:    0.7.0.1
 */