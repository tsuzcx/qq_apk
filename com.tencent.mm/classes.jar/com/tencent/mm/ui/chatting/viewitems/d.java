package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.p.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.websearch.api.ab;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

public final class d
{
  private static boolean sdw = false;
  
  protected static void a(TextView paramTextView, j.b paramb)
  {
    AppMethodBeat.i(32859);
    switch (paramb.fjh)
    {
    default: 
      paramTextView.setText(2131296630);
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      AppMethodBeat.o(32859);
      return;
      paramTextView.setText(2131296857);
      continue;
      paramTextView.setText(2131296856);
    }
  }
  
  private static boolean g(j.b paramb)
  {
    AppMethodBeat.i(32860);
    paramb = (ab)paramb.R(ab.class);
    if ((paramb != null) && (!bo.isNullOrNil(paramb.uJi)))
    {
      AppMethodBeat.o(32860);
      return true;
    }
    AppMethodBeat.o(32860);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d
 * JD-Core Version:    0.7.0.1
 */