package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.o;

public final class a
{
  private static final int[] hFs = { 2131230925, 2131230926, 2131230927, 2131230928, 2131230929, 2131230930, 2131230931 };
  private static final int[] qeI = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private Context context;
  private final ap oms;
  private View qeB;
  private View qeC;
  private ImageView qeD;
  private View qeF;
  private o yJL;
  private TextView yJM;
  private ImageView yJN;
  private View yJO;
  private int ylT;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(29571);
    this.oms = new ap()
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
    this.ylT = BackwardSupportUtil.b.g(paramContext, 180.0F);
    this.yJL = new o(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495869, null), -1, -2);
    this.qeD = ((ImageView)this.yJL.getContentView().findViewById(2131306518));
    this.qeF = this.yJL.getContentView().findViewById(2131306521);
    this.yJM = ((TextView)this.yJL.getContentView().findViewById(2131306523));
    this.yJN = ((ImageView)this.yJL.getContentView().findViewById(2131306522));
    this.yJO = this.yJL.getContentView().findViewById(2131306524);
    this.qeB = this.yJL.getContentView().findViewById(2131306525);
    this.qeC = this.yJL.getContentView().findViewById(2131306526);
    AppMethodBeat.o(29571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */