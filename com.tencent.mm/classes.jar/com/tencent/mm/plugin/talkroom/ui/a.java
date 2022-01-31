package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.o;

public final class a
{
  private static final int[] gcA = { 2130837689, 2130837690, 2130837691, 2130837692, 2130837693, 2130837694, 2130837695 };
  private static final int[] mwW = { 0, 15, 30, 45, 60, 75, 90, 100 };
  private Context context;
  private View mwO;
  private View mwP;
  private ImageView mwQ;
  private View mwS;
  private final ak mwX;
  private int sDa;
  private o tdq;
  private TextView tdr;
  private ImageView tds;
  private View tdt;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(25889);
    this.mwX = new a.1(this);
    this.context = paramContext;
    this.sDa = BackwardSupportUtil.b.b(paramContext, 180.0F);
    this.tdq = new o(((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130971099, null), -1, -2);
    this.mwQ = ((ImageView)this.tdq.getContentView().findViewById(2131824074));
    this.mwS = this.tdq.getContentView().findViewById(2131824076);
    this.tdr = ((TextView)this.tdq.getContentView().findViewById(2131824078));
    this.tds = ((ImageView)this.tdq.getContentView().findViewById(2131824077));
    this.tdt = this.tdq.getContentView().findViewById(2131828796);
    this.mwO = this.tdq.getContentView().findViewById(2131824071);
    this.mwP = this.tdq.getContentView().findViewById(2131824079);
    AppMethodBeat.o(25889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.ui.a
 * JD-Core Version:    0.7.0.1
 */