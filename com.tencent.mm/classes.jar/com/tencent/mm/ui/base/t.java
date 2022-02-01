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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class t
  extends i
  implements DialogInterface
{
  private ImageView OTM;
  private View jBN;
  private Context mContext;
  private TextView oBs;
  private int style;
  
  private t(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(205240);
    this.mContext = paramContext;
    this.style = paramInt2;
    paramInt1 = i;
    switch (this.style)
    {
    default: 
      paramInt1 = i;
    }
    for (;;)
    {
      this.jBN = View.inflate(this.mContext, paramInt1, null);
      this.oBs = ((TextView)this.jBN.findViewById(2131304947));
      this.OTM = ((ImageView)this.jBN.findViewById(2131302468));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(205240);
      return;
      paramInt1 = 2131495648;
      continue;
      paramInt1 = 2131495642;
    }
  }
  
  public static t a(CharSequence paramCharSequence, final Context paramContext, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    int j = 2131821777;
    AppMethodBeat.i(205241);
    int i = j;
    switch (paramInt)
    {
    }
    for (i = j;; i = 2131821772)
    {
      final t localt = new t(paramContext, i, paramInt);
      localt.oBs.setText(paramCharSequence);
      localt.setCanceledOnTouchOutside(true);
      localt.show();
      localt.setOnDismissListener(paramOnDismissListener);
      new MMHandler(Looper.getMainLooper())
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(142225);
          if (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing()))
          {
            AppMethodBeat.o(142225);
            return;
          }
          localt.dismiss();
          AppMethodBeat.o(142225);
        }
      }.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(205241);
      return localt;
    }
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
      Log.e("MicroMsg.MMTipsDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142229);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142227);
    super.onCreate(paramBundle);
    setContentView(this.jBN, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */