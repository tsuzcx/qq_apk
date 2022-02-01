package com.tencent.mm.ui.chatting.component;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class ag$b
  extends RecyclerView.v
{
  static final c lCf;
  LinearLayout aetJ;
  TextView aetd;
  View lBX;
  ImageView lPb;
  
  static
  {
    AppMethodBeat.i(179874);
    c.a locala1 = new c.a();
    locala1.oKB = R.k.app_brand_app_default_icon_for_tail;
    c.a locala2 = locala1.eG(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.nrc = true;
    locala2.oKp = true;
    locala2.oKn = true;
    lCf = locala1.bKx();
    AppMethodBeat.o(179874);
  }
  
  public ag$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(179873);
    this.lBX = paramView;
    this.aetJ = ((LinearLayout)paramView.findViewById(R.h.gaw));
    this.lPb = ((ImageView)paramView.findViewById(R.h.gax));
    this.aetd = ((TextView)paramView.findViewById(R.h.gay));
    AppMethodBeat.o(179873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.ag.b
 * JD-Core Version:    0.7.0.1
 */