package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

final class z$1
  implements View.OnClickListener
{
  z$1(z paramz) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(38275);
    if (!bo.isNullOrNil(this.rHT.rHS))
    {
      AppMethodBeat.o(38275);
      return;
    }
    Object localObject = v.aae().z(this.rHT.mSessionId, true);
    if (((v.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
    {
      int i = ((v.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
      int j = ((v.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
      if ((i == 5) && (j == 1))
      {
        ab.i("MicroMsg.LinkWidget", "goto native video");
        localObject = new Intent();
        ((Intent)localObject).putExtras(this.rHT.cmc.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
        paramView = paramView.findViewById(2131825855);
        if (paramView != null)
        {
          i = paramView.getWidth();
          j = paramView.getHeight();
          int[] arrayOfInt = new int[2];
          paramView.getLocationInWindow(arrayOfInt);
          ((Intent)localObject).putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
        }
        ((Intent)localObject).addFlags(268435456);
        d.b(ah.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
        AppMethodBeat.o(38275);
        return;
      }
    }
    ab.i("MicroMsg.LinkWidget", "adlink url " + this.rHT.link);
    paramView = new Intent();
    paramView.putExtra("rawUrl", this.rHT.link);
    a.gmO.i(paramView, this.rHT.cmc);
    AppMethodBeat.o(38275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z.1
 * JD-Core Version:    0.7.0.1
 */