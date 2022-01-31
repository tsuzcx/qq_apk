package com.tencent.mm.plugin.sns.ui.d;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class b$36
  implements View.OnClickListener
{
  b$36(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(40298);
    if (!(paramView.getTag() instanceof String))
    {
      AppMethodBeat.o(40298);
      return;
    }
    paramView = (String)paramView.getTag();
    paramView = ag.cpf().abv(paramView);
    if (paramView == null)
    {
      AppMethodBeat.o(40298);
      return;
    }
    if (paramView.Ex(32))
    {
      ab.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
      paramView = b.a(this.skd, paramView);
      if (paramView == null)
      {
        ab.e("MicroMsg.TimelineClickListener", "the adInfo is null");
        AppMethodBeat.o(40298);
        return;
      }
      if (bo.isNullOrNil(paramView.rpr))
      {
        ab.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
        AppMethodBeat.o(40298);
        return;
      }
      ab.i("MicroMsg.TimelineClickListener", "open webview url : " + paramView.rpr);
      Intent localIntent = new Intent();
      localIntent.putExtra("jsapiargs", new Bundle());
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("rawUrl", i.gg(paramView.rpr, paramView.cFe));
      com.tencent.mm.plugin.sns.c.a.gmO.i(localIntent, this.skd.activity);
      AppMethodBeat.o(40298);
      return;
    }
    AppMethodBeat.o(40298);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.b.36
 * JD-Core Version:    0.7.0.1
 */