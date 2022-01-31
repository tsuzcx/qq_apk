package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.protocal.protobuf.lh;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;

public final class NewBizInfoMessagePreference$a
  extends RecyclerView.a<NewBizInfoMessagePreference.a.a>
{
  private static final int IMAGE_WIDTH;
  private static int pDN;
  private static int pDO;
  private static int pDP;
  private static int pDQ;
  private static int pDR;
  private static int pDS;
  private MMActivity cmc;
  private ad contact;
  protected lg pDM;
  private int pDT;
  
  static
  {
    AppMethodBeat.i(23889);
    pDN = a.fromDPToPix(ah.getContext(), 6);
    IMAGE_WIDTH = ah.getResources().getDimensionPixelSize(2131427858);
    pDO = a.fromDPToPix(ah.getContext(), 4);
    pDP = 13;
    pDQ = a.fromDPToPix(ah.getContext(), 1);
    pDR = a.fromDPToPix(ah.getContext(), 8);
    pDS = 13;
    AppMethodBeat.o(23889);
  }
  
  public final int getItemCount()
  {
    int i = 0;
    AppMethodBeat.i(23886);
    if ((this.pDM == null) || (this.pDM.wzA == null))
    {
      AppMethodBeat.o(23886);
      return 0;
    }
    int j = c.cB(this.pDM.wzA);
    if (this.pDM.wzB.wzD == 0) {
      i = 1;
    }
    AppMethodBeat.o(23886);
    return i + j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a
 * JD-Core Version:    0.7.0.1
 */