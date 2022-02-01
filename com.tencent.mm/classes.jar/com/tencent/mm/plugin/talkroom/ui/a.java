package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.p;

public final class a
{
  private static final int[] jxw = { 2131230948, 2131230949, 2131230950, 2131230951, 2131230952, 2131230953, 2131230954 };
  private static final int[] tfe = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private p FQS;
  private TextView FQT;
  private ImageView FQU;
  private View FQV;
  private int Ftf;
  private Context context;
  private final MMHandler qPx;
  private View teY;
  private View teZ;
  private ImageView tfa;
  private View tfc;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(29571);
    this.qPx = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29570);
        super.handleMessage(paramAnonymousMessage);
        a.a(a.this).dismiss();
        AppMethodBeat.o(29570);
      }
    };
    this.context = paramContext;
    this.Ftf = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, 180.0F);
    this.FQS = new p(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131496849, null), -1, -2);
    this.tfa = ((ImageView)this.FQS.getContentView().findViewById(2131309978));
    this.tfc = this.FQS.getContentView().findViewById(2131309981);
    this.FQT = ((TextView)this.FQS.getContentView().findViewById(2131309983));
    this.FQU = ((ImageView)this.FQS.getContentView().findViewById(2131309982));
    this.FQV = this.FQS.getContentView().findViewById(2131309984);
    this.teY = this.FQS.getContentView().findViewById(2131309985);
    this.teZ = this.FQS.getContentView().findViewById(2131309986);
    AppMethodBeat.o(29571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */