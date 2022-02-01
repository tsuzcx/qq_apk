package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;

public final class s
  extends i
  implements DialogInterface
{
  private ImageView Joh;
  private View iCR;
  private Context mContext;
  private TextView nmC;
  private int style;
  
  private s(Context paramContext)
  {
    super(paramContext, 2131821728);
    AppMethodBeat.i(142226);
    this.mContext = paramContext;
    this.style = 0;
    int i = j;
    switch (this.style)
    {
    }
    for (i = j;; i = 2131494909)
    {
      this.iCR = View.inflate(this.mContext, i, null);
      this.nmC = ((TextView)this.iCR.findViewById(2131302519));
      this.Joh = ((ImageView)this.iCR.findViewById(2131300874));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(142226);
      return;
    }
  }
  
  public static s a(CharSequence paramCharSequence, final Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(142228);
    final s locals = new s(paramContext);
    locals.nmC.setText(paramCharSequence);
    locals.setCanceledOnTouchOutside(true);
    locals.show();
    locals.setOnDismissListener(paramOnDismissListener);
    new ap(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142225);
        if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
        {
          AppMethodBeat.o(142225);
          return;
        }
        locals.dismiss();
        AppMethodBeat.o(142225);
      }
    }.sendEmptyMessageDelayed(0, 1000L);
    AppMethodBeat.o(142228);
    return locals;
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(142229);
    try
    {
      super.dismiss();
      AppMethodBeat.o(142229);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142229);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142227);
    super.onCreate(paramBundle);
    setContentView(this.iCR, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.s
 * JD-Core Version:    0.7.0.1
 */