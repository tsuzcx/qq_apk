package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;

public final class s
  extends i
  implements DialogInterface
{
  private ImageView JIW;
  private View iFK;
  private Context mContext;
  private TextView nrM;
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
      this.iFK = View.inflate(this.mContext, i, null);
      this.nrM = ((TextView)this.iFK.findViewById(2131302519));
      this.JIW = ((ImageView)this.iFK.findViewById(2131300874));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(142226);
      return;
    }
  }
  
  public static s a(CharSequence paramCharSequence, final Context paramContext)
  {
    AppMethodBeat.i(193727);
    final s locals = new s(paramContext);
    locals.nrM.setText(paramCharSequence);
    locals.setCanceledOnTouchOutside(true);
    locals.show();
    locals.setOnDismissListener(null);
    new aq(Looper.getMainLooper())
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
    AppMethodBeat.o(193727);
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
      ae.e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142229);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142227);
    super.onCreate(paramBundle);
    setContentView(this.iFK, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.s
 * JD-Core Version:    0.7.0.1
 */