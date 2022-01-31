package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.R.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class NewBizInfoMessagePreference$a
  extends RecyclerView.a<NewBizInfoMessagePreference.a.a>
{
  private static final int IMAGE_WIDTH = ae.getResources().getDimensionPixelSize(R.f.SmallerIconSize);
  private static int mZS = a.fromDPToPix(ae.getContext(), 6);
  private static int mZT = a.fromDPToPix(ae.getContext(), 4);
  private static int mZU = 13;
  private static int mZV = a.fromDPToPix(ae.getContext(), 1);
  private static int mZW = a.fromDPToPix(ae.getContext(), 8);
  private static int mZX = 13;
  private MMActivity bER;
  private List<b> mZR = new ArrayList();
  
  public NewBizInfoMessagePreference$a(MMActivity paramMMActivity, List<b> paramList)
  {
    this.bER = paramMMActivity;
    this.mZR = paramList;
  }
  
  public final int getItemCount()
  {
    if (this.mZR == null) {
      return 0;
    }
    return this.mZR.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoMessagePreference.a
 * JD-Core Version:    0.7.0.1
 */