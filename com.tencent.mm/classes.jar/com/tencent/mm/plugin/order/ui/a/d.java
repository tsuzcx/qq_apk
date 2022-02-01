package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  String mName;
  View.OnClickListener mOnClickListener;
  private View mView;
  String oyz;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66808);
    this.mView = null;
    setLayoutResource(2131494707);
    AppMethodBeat.o(66808);
  }
  
  public final View getView(View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66809);
    if (this.mView == null) {
      this.mView = onCreateView(paramViewGroup);
    }
    onBindView(this.mView);
    paramView = this.mView;
    AppMethodBeat.o(66809);
    return paramView;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(66810);
    super.onBindView(paramView);
    ImageView localImageView = (ImageView)paramView.findViewById(2131302029);
    TextView localTextView = (TextView)paramView.findViewById(2131302030);
    localImageView.setImageBitmap(null);
    if (!bt.isNullOrNil(this.oyz))
    {
      Object localObject = new c.a();
      b.cZY();
      ((c.a)localObject).prefixPath = b.cKR();
      ((c.a)localObject).hjU = true;
      ((c.a)localObject).gjA = true;
      ((c.a)localObject).gkG = true;
      localObject = ((c.a)localObject).azc();
      o.ayJ().a(this.oyz, localImageView, (c)localObject);
    }
    localTextView.setText(this.mName);
    paramView.findViewById(2131302028).setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(66810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.d
 * JD-Core Version:    0.7.0.1
 */