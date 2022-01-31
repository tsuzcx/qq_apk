package com.tencent.mm.plugin.sns.ui.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class BaseTimeLineItem$2
  implements f.a
{
  BaseTimeLineItem$2(BaseTimeLineItem paramBaseTimeLineItem, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(40116);
    ab.i("MicroMsg.BaseTimeLineItem", "download img %s", new Object[] { paramString });
    String str = (String)this.rFH.sgM.getTag(2131820667);
    if ((!bo.Q(new String[] { str, paramString })) && (paramString.equals(h.gy("adId", str))))
    {
      paramString = j.rac.getBitmap(paramString);
      if (paramString != null) {
        this.rFH.sgM.setImageBitmap(paramString);
      }
    }
    AppMethodBeat.o(40116);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.2
 * JD-Core Version:    0.7.0.1
 */