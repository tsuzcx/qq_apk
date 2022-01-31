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
import com.tencent.mm.R.n;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;

public class AppPreference
  extends Preference
{
  private Context context;
  int pwW = 0;
  a pwY;
  AdapterView.OnItemClickListener pwZ = null;
  AdapterView.OnItemClickListener pxa = null;
  private View.OnClickListener pxb = null;
  private int pxc;
  private boolean pxd = false;
  private int pxe = 0;
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
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
    this.pwY = new a(this.context, this.pwW);
    localMMGridView.setAdapter(this.pwY);
    localMMGridView.setOnItemClickListener(new AppPreference.1(this));
    if (this.pxd) {
      localMMGridView.setOnItemLongClickListener(new AppPreference.2(this));
    }
    TextView localTextView = (TextView)paramView.findViewById(R.h.empty_tv);
    if (this.pwY.getCount() == 0)
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
    if (this.pwY != null) {
      ap.brn().d(this.pwY);
    }
  }
  
  public final void onResume()
  {
    if (this.pwY != null) {
      ap.brn().c(this.pwY);
    }
  }
  
  public final f zn(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.pwY.getCount())) {
      return null;
    }
    return (f)this.pwY.getItem(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.openapi.AppPreference
 * JD-Core Version:    0.7.0.1
 */