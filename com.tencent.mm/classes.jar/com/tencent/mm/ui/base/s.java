package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public final class s
  extends i
  implements DialogInterface
{
  private View iCk;
  private TextView jbI;
  private Context mContext;
  private int style;
  private ImageView zmW;
  
  private s(Context paramContext)
  {
    super(paramContext, 2131493886);
    AppMethodBeat.i(106866);
    this.mContext = paramContext;
    this.style = 0;
    int i = j;
    switch (this.style)
    {
    }
    for (i = j;; i = 2130970278)
    {
      this.iCk = View.inflate(this.mContext, i, null);
      this.jbI = ((TextView)this.iCk.findViewById(2131824171));
      this.zmW = ((ImageView)this.iCk.findViewById(2131820929));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(106866);
      return;
    }
  }
  
  public static s a(CharSequence paramCharSequence, Context paramContext)
  {
    AppMethodBeat.i(106868);
    s locals = new s(paramContext);
    locals.jbI.setText(paramCharSequence);
    locals.setCanceledOnTouchOutside(true);
    locals.show();
    locals.setOnDismissListener(null);
    new s.1(Looper.getMainLooper(), paramContext, locals).sendEmptyMessageDelayed(0, 1000L);
    AppMethodBeat.o(106868);
    return locals;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(106869);
    try
    {
      super.dismiss();
      AppMethodBeat.o(106869);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(106869);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106867);
    super.onCreate(paramBundle);
    setContentView(this.iCk, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(106867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.s
 * JD-Core Version:    0.7.0.1
 */