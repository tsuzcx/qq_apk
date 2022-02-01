package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.o;

public final class a
{
  private static final int[] iCh = { 2131230925, 2131230926, 2131230927, 2131230928, 2131230929, 2131230930, 2131230931 };
  private static final int[] rFy = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private o BGb;
  private TextView BGc;
  private ImageView BGd;
  private View BGe;
  private int Bip;
  private Context context;
  private final aq pAg;
  private View rFs;
  private View rFt;
  private ImageView rFu;
  private View rFw;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(29571);
    this.pAg = new aq()
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
    this.Bip = BackwardSupportUtil.b.h(paramContext, 180.0F);
    this.BGb = new o(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131495869, null), -1, -2);
    this.rFu = ((ImageView)this.BGb.getContentView().findViewById(2131306518));
    this.rFw = this.BGb.getContentView().findViewById(2131306521);
    this.BGc = ((TextView)this.BGb.getContentView().findViewById(2131306523));
    this.BGd = ((ImageView)this.BGb.getContentView().findViewById(2131306522));
    this.BGe = this.BGb.getContentView().findViewById(2131306524);
    this.rFs = this.BGb.getContentView().findViewById(2131306525);
    this.rFt = this.BGb.getContentView().findViewById(2131306526);
    AppMethodBeat.o(29571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */