package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference
  extends Preference
{
  private Context context;
  private boolean ovS;
  List<f> qIG;
  AdapterView.OnItemClickListener sYO;
  private AdapterView.OnItemClickListener sYP;
  private View.OnClickListener sYQ;
  private int sYR;
  private int sYS;
  b sZh;
  
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
    AppMethodBeat.i(25485);
    this.sYO = null;
    this.sYP = null;
    this.sYQ = null;
    this.ovS = false;
    this.sYS = 0;
    this.context = paramContext;
    setLayoutResource(2130968761);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.a.AppPreference);
    this.sYR = paramContext.getInt(0, 8);
    this.ovS = paramContext.getBoolean(1, false);
    this.sYS = paramContext.getResourceId(2, 0);
    paramContext.recycle();
    AppMethodBeat.o(25485);
  }
  
  public final f Gn(int paramInt)
  {
    AppMethodBeat.i(25487);
    if ((paramInt < 0) || (paramInt >= this.sZh.getCount()))
    {
      AppMethodBeat.o(25487);
      return null;
    }
    f localf = (f)this.sZh.getItem(paramInt);
    AppMethodBeat.o(25487);
    return localf;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(25486);
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(2131821494);
    if (localMMGridView == null)
    {
      AppMethodBeat.o(25486);
      return;
    }
    this.sZh = new b(this.context, this.qIG);
    al.cac().remove(this.sZh);
    al.cac().add(this.sZh);
    localMMGridView.setAdapter(this.sZh);
    localMMGridView.setOnItemClickListener(new ServicePreference.1(this));
    if (this.ovS) {
      localMMGridView.setOnItemLongClickListener(new ServicePreference.2(this));
    }
    TextView localTextView = (TextView)paramView.findViewById(2131821495);
    if (this.sZh.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.sYS);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(2131821496);
      paramView.setVisibility(this.sYR);
      paramView.setOnClickListener(this.sYQ);
      AppMethodBeat.o(25486);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(25489);
    if (this.sZh != null) {
      al.cac().remove(this.sZh);
    }
    AppMethodBeat.o(25489);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(25488);
    if (this.sZh != null) {
      al.cac().add(this.sZh);
    }
    AppMethodBeat.o(25488);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference
 * JD-Core Version:    0.7.0.1
 */