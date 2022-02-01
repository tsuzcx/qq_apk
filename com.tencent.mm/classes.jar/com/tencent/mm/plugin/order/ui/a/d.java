package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  String mName;
  View.OnClickListener mOnClickListener;
  private View mView;
  String pbZ;
  
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
    if (!bs.isNullOrNil(this.pbZ))
    {
      Object localObject = new c.a();
      b.dnG();
      ((c.a)localObject).prefixPath = b.cYx();
      ((c.a)localObject).hKx = true;
      ((c.a)localObject).gKm = true;
      ((c.a)localObject).gLt = true;
      localObject = ((c.a)localObject).aFT();
      o.aFB().a(this.pbZ, localImageView, (c)localObject);
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