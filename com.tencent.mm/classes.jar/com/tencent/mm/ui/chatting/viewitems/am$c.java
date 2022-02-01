package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.List;

final class am$c
  extends c.a
{
  TextView aeNs;
  am.f aeSe;
  am.h aeSf;
  am.e aeSg;
  am.i aeSh;
  am.d aeSi;
  am.g aeSj;
  LinearLayout vMH;
  List<am.a> vMK;
  
  am$c()
  {
    AppMethodBeat.i(37133);
    this.aeSe = new am.f();
    this.vMK = new ArrayList();
    this.aeSf = new am.h();
    this.aeSg = new am.e();
    this.aeSh = new am.i();
    this.aeSi = new am.d();
    this.aeSj = new am.g();
    AppMethodBeat.o(37133);
  }
  
  public final View getMainContainerView()
  {
    return this.vMH;
  }
  
  public final c.a lL(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.vMH;
    am.a locala = new am.a();
    locala.vJU = paramView;
    locala.plj = paramView.findViewById(R.h.top_line);
    locala.yBS = paramView.findViewById(R.h.content_ll);
    locala.vIW = ((MMNeat7extView)paramView.findViewById(R.h.title));
    locala.vMo = ((TextView)paramView.findViewById(R.h.summary));
    locala.vMp = paramView.findViewById(R.h.cover_area);
    locala.vIK = ((ImageView)paramView.findViewById(R.h.cover));
    locala.vMs = ((ImageView)paramView.findViewById(R.h.play_icon));
    locala.vMr = ((ImageView)paramView.findViewById(R.h.fzb));
    locala.vMq = paramView.findViewById(R.h.biz_slot_voice_layout);
    locala.vNo = ((ImageView)paramView.findViewById(R.h.pic_icon));
    locala.aeSd = ((TextView)paramView.findViewById(R.h.pic_num));
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.vMK.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.am.c
 * JD-Core Version:    0.7.0.1
 */