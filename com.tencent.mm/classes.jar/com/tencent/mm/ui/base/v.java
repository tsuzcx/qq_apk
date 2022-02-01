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
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class v
  extends i
  implements DialogInterface
{
  private ImageView WmZ;
  private Context mContext;
  private View mrI;
  private TextView rEb;
  private int style;
  
  private v(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext, paramInt1);
    AppMethodBeat.i(224550);
    this.mContext = paramContext;
    this.style = paramInt2;
    switch (this.style)
    {
    default: 
      paramInt1 = a.h.mm_tips_dialog;
    }
    for (;;)
    {
      this.mrI = View.inflate(this.mContext, paramInt1, null);
      this.rEb = ((TextView)this.mrI.findViewById(a.g.msg));
      this.WmZ = ((ImageView)this.mrI.findViewById(a.g.icon));
      setCanceledOnTouchOutside(true);
      AppMethodBeat.o(224550);
      return;
      paramInt1 = a.h.mm_tips_dialog;
      continue;
      paramInt1 = a.h.mm_tips_dialog_with_bg;
      continue;
      paramInt1 = a.h.mm_small_tips_dialog;
    }
  }
  
  public static v a(CharSequence paramCharSequence, final Context paramContext, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(224567);
    int i;
    switch (paramInt)
    {
    default: 
      i = a.l.mmtipsdialog;
    }
    for (;;)
    {
      final v localv = new v(paramContext, i, paramInt);
      localv.rEb.setText(paramCharSequence);
      localv.setCanceledOnTouchOutside(true);
      localv.show();
      localv.setOnDismissListener(paramOnDismissListener);
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
          localv.dismiss();
          AppMethodBeat.o(142225);
        }
      }.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(224567);
      return localv;
      i = a.l.mmtipsdialog;
      continue;
      i = a.l.mmalertdialog;
      continue;
      i = a.l.mmtipsdialog;
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
    setContentView(this.mrI, new LinearLayout.LayoutParams(-1, -1));
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.height = -2;
    onWindowAttributesChanged(paramBundle);
    AppMethodBeat.o(142227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.base.v
 * JD-Core Version:    0.7.0.1
 */