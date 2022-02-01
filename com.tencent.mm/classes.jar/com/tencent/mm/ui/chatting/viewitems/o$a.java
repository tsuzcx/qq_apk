package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class o$a
  extends c.a
{
  public int PJa;
  ImageView PKt;
  TextView PKu;
  TextView PKv;
  TextView gvw;
  public ImageView tickIV;
  
  public final a K(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.create(paramView);
    this.PKt = ((ImageView)this.convertView.findViewById(2131298398));
    this.timeTV = ((TextView)this.convertView.findViewById(2131298558));
    this.PKu = ((TextView)this.convertView.findViewById(2131298562));
    this.PKv = ((TextView)this.convertView.findViewById(2131298567));
    this.gvw = ((TextView)this.convertView.findViewById(2131298528));
    this.userTV = ((TextView)this.convertView.findViewById(2131298566));
    this.clickArea = this.convertView.findViewById(2131298411);
    this.maskView = this.convertView.findViewById(2131298508);
    if (paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
      this.tickIV = ((ImageView)paramView.findViewById(2131298556));
    }
    this.PJa = c.kl(MMApplicationContext.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.a
 * JD-Core Version:    0.7.0.1
 */