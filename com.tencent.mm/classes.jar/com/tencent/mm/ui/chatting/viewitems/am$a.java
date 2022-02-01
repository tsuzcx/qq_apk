package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class am$a
  extends c.a
{
  ImageView PIn;
  public int PJa;
  ImageView PKt;
  TextView PKu;
  TextView PKv;
  TextView gvw;
  
  public final c.a G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37176);
    super.create(paramView);
    this.PKt = ((ImageView)paramView.findViewById(2131298398));
    this.timeTV = ((TextView)paramView.findViewById(2131298558));
    this.PKu = ((TextView)paramView.findViewById(2131298562));
    this.PKv = ((TextView)paramView.findViewById(2131298567));
    this.gvw = ((TextView)paramView.findViewById(2131298528));
    this.userTV = ((TextView)paramView.findViewById(2131298566));
    this.clickArea = paramView.findViewById(2131298411);
    this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
    this.maskView = paramView.findViewById(2131298508);
    if (!paramBoolean)
    {
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.PIn = ((ImageView)paramView.findViewById(2131298556));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
    }
    this.PJa = c.kl(MMApplicationContext.getContext());
    AppMethodBeat.o(37176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.a
 * JD-Core Version:    0.7.0.1
 */