package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class n
{
  static final class a
    extends c.a
  {
    public int vBZ = 0;
    public ImageView vDd;
    public TextView vDe;
    public TextView vDf;
    
    public final a dU(View paramView)
    {
      super.dN(paramView);
      this.dsz = ((TextView)this.kKz.findViewById(R.h.chatting_time_tv));
      this.khV = ((CheckBox)this.kKz.findViewById(R.h.chatting_checkbox));
      this.hoY = this.kKz.findViewById(R.h.chatting_maskview);
      this.nSa = ((TextView)this.kKz.findViewById(R.h.chatting_user_tv));
      this.vDd = ((ImageView)this.kKz.findViewById(R.h.appmsg_remittance_icon));
      this.vDe = ((TextView)this.kKz.findViewById(R.h.appmsg_remittance_title));
      this.vDf = ((TextView)this.kKz.findViewById(R.h.appmsg_remittance_desc));
      this.vBZ = c.gT(ae.getContext());
      this.vDf.setTypeface(((b)g.r(b.class)).dO(this.kKz.getContext()));
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.n
 * JD-Core Version:    0.7.0.1
 */