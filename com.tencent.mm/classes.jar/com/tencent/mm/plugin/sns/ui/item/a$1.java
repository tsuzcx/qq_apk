package com.tencent.mm.plugin.sns.ui.item;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class a$1
  implements f.a
{
  a$1(a parama, a.a parama1) {}
  
  public final void abi(String paramString)
  {
    AppMethodBeat.i(40128);
    ab.i("MiroMsg.CardAdTimeLineItem", "download img %s", new Object[] { paramString });
    if ((!bo.Q(new String[] { (String)this.shS.sfP.getTag(), paramString })) && (paramString.equals(h.gy("adId", (String)this.shS.sfP.getTag()))))
    {
      paramString = d.decodeFile(paramString, null);
      if (paramString != null)
      {
        this.shS.sfP.setVisibility(0);
        this.shS.sia.setImageBitmap(paramString);
        this.shS.sia.setVisibility(0);
      }
    }
    AppMethodBeat.o(40128);
  }
  
  public final void coe() {}
  
  public final void cqU() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.a.1
 * JD-Core Version:    0.7.0.1
 */