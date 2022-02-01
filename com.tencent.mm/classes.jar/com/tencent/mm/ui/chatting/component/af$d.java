package com.tencent.mm.ui.chatting.component;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.cd.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class af$d
  extends RecyclerView.v
{
  static final c lCf;
  RelativeLayout aetc;
  TextView aetd;
  RelativeLayout aete;
  RelativeLayout aetf;
  TextView aetg;
  View lBX;
  ImageView lPb;
  
  static
  {
    AppMethodBeat.i(184981);
    c.a locala1 = new c.a();
    locala1.oKB = R.k.app_brand_app_default_icon_for_tail;
    c.a locala2 = locala1.eG(a.fromDPToPix(MMApplicationContext.getContext(), 20), a.fromDPToPix(MMApplicationContext.getContext(), 20));
    locala2.nrc = true;
    locala2.oKp = true;
    locala2.oKn = true;
    lCf = locala1.bKx();
    AppMethodBeat.o(184981);
  }
  
  public af$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(184980);
    this.lBX = paramView;
    this.aetc = ((RelativeLayout)paramView.findViewById(R.h.todo_container));
    this.lPb = ((ImageView)paramView.findViewById(R.h.gan));
    this.aetd = ((TextView)paramView.findViewById(R.h.gav));
    this.aete = ((RelativeLayout)paramView.findViewById(R.h.gam));
    this.aetf = ((RelativeLayout)paramView.findViewById(R.h.gar));
    this.aetg = ((TextView)paramView.findViewById(R.h.gas));
    AppMethodBeat.o(184980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.af.d
 * JD-Core Version:    0.7.0.1
 */