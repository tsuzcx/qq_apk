package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.n;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference
  extends Preference
{
  private Context context;
  List<f> nUB;
  AdapterView.OnItemClickListener pwZ = null;
  private AdapterView.OnItemClickListener pxa = null;
  private View.OnClickListener pxb = null;
  private int pxc;
  private boolean pxd = false;
  private int pxe = 0;
  b pxt;
  
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
    this.context = paramContext;
    setLayoutResource(R.i.app_preference);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.n.AppPreference);
    this.pxc = paramContext.getInt(R.n.AppPreference_btn_visibility, 8);
    this.pxd = paramContext.getBoolean(R.n.AppPreference_can_delete, false);
    this.pxe = paramContext.getResourceId(R.n.AppPreference_empty_wording, 0);
    paramContext.recycle();
  }
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    MMGridView localMMGridView = (MMGridView)paramView.findViewById(R.h.gridview);
    if (localMMGridView == null) {
      return;
    }
    this.pxt = new b(this.context, this.nUB);
    ap.brn().d(this.pxt);
    ap.brn().c(this.pxt);
    localMMGridView.setAdapter(this.pxt);
    localMMGridView.setOnItemClickListener(new ServicePreference.1(this));
    if (this.pxd) {
      localMMGridView.setOnItemLongClickListener(new ServicePreference.2(this));
    }
    TextView localTextView = (TextView)paramView.findViewById(R.h.empty_tv);
    if (this.pxt.getCount() == 0)
    {
      localTextView.setVisibility(0);
      localTextView.setText(this.pxe);
      localMMGridView.setVisibility(8);
    }
    for (;;)
    {
      paramView = (Button)paramView.findViewById(R.h.btn);
      paramView.setVisibility(this.pxc);
      paramView.setOnClickListener(this.pxb);
      return;
      localTextView.setVisibility(8);
      localMMGridView.setVisibility(0);
    }
  }
  
  public final void onPause()
  {
    if (this.pxt != null) {
      ap.brn().d(this.pxt);
    }
  }
  
  public final void onResume()
  {
    if (this.pxt != null) {
      ap.brn().c(this.pxt);
    }
  }
  
  public final f zn(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.pxt.getCount())) {
      return null;
    }
    return (f)this.pxt.getItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.ServicePreference
 * JD-Core Version:    0.7.0.1
 */