package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.i;

final class o
  extends i
  implements DialogInterface
{
  private boolean gKc;
  private View jaX;
  private TextView jhF;
  private Context mContext;
  Button usy;
  private LinearLayout zaf;
  TextView zag;
  private TextView zah;
  LinearLayout zai;
  private LinearLayout zaj;
  
  public o(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(29538);
    this.mContext = paramContext;
    this.zaf = ((LinearLayout)w.hM(this.mContext).inflate(2130970143, null));
    this.usy = ((Button)this.zaf.findViewById(2131822981));
    this.jhF = ((TextView)this.zaf.findViewById(2131826145));
    this.zag = ((TextView)this.zaf.findViewById(2131826150));
    this.zah = ((TextView)this.zaf.findViewById(2131822986));
    this.jaX = this.zaf.findViewById(2131826144);
    this.zai = ((LinearLayout)this.zaf.findViewById(2131824644));
    this.zaj = ((LinearLayout)this.zaf.findViewById(2131826151));
    setCanceledOnTouchOutside(true);
    AppMethodBeat.o(29538);
  }
  
  private void dCo()
  {
    AppMethodBeat.i(29542);
    if (this.zag != null) {
      this.zag.setTextColor(this.zag.getContext().getResources().getColor(2131689956));
    }
    AppMethodBeat.o(29542);
  }
  
  public final void dCp()
  {
    AppMethodBeat.i(29544);
    super.setCancelable(true);
    AppMethodBeat.o(29544);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(29546);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29537);
          o.this.dismiss();
          AppMethodBeat.o(29537);
        }
      });
      ab.e("MicroMsg.LiteDependDialog", bo.dtY().toString());
      AppMethodBeat.o(29546);
      return;
    }
    try
    {
      super.dismiss();
      AppMethodBeat.o(29546);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.LiteDependDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(29546);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29539);
    super.onCreate(paramBundle);
    setContentView(this.zaf);
    AppMethodBeat.o(29539);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(29543);
    super.setCancelable(paramBoolean);
    this.gKc = paramBoolean;
    setCanceledOnTouchOutside(this.gKc);
    AppMethodBeat.o(29543);
  }
  
  public final void setTitle(int paramInt)
  {
    AppMethodBeat.i(29541);
    this.jaX.setVisibility(0);
    this.jhF.setVisibility(0);
    this.jhF.setMaxLines(2);
    this.jhF.setText(paramInt);
    dCo();
    AppMethodBeat.o(29541);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(29540);
    this.jaX.setVisibility(0);
    this.jhF.setVisibility(0);
    this.jhF.setMaxLines(2);
    this.jhF.setText(paramCharSequence);
    dCo();
    AppMethodBeat.o(29540);
  }
  
  public final void show()
  {
    AppMethodBeat.i(29545);
    try
    {
      super.show();
      AppMethodBeat.o(29545);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.LiteDependDialog", localException, "", new Object[0]);
      AppMethodBeat.o(29545);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.o
 * JD-Core Version:    0.7.0.1
 */