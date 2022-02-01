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
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.order.a.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.Preference;

public final class d
  extends Preference
{
  String mName;
  View.OnClickListener mOnClickListener;
  private View mView;
  String rcG;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66808);
    this.mView = null;
    setLayoutResource(2131495436);
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
    ImageView localImageView = (ImageView)paramView.findViewById(2131304368);
    TextView localTextView = (TextView)paramView.findViewById(2131304369);
    localImageView.setImageBitmap(null);
    if (!Util.isNullOrNil(this.rcG))
    {
      Object localObject = new c.a();
      b.eBa();
      ((c.a)localObject).prefixPath = b.eeA();
      ((c.a)localObject).jbf = true;
      ((c.a)localObject).hZF = true;
      ((c.a)localObject).iaT = true;
      localObject = ((c.a)localObject).bdv();
      q.bcV().a(this.rcG, localImageView, (c)localObject);
    }
    localTextView.setText(this.mName);
    paramView.findViewById(2131304367).setOnClickListener(this.mOnClickListener);
    AppMethodBeat.o(66810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.ui.a.d
 * JD-Core Version:    0.7.0.1
 */