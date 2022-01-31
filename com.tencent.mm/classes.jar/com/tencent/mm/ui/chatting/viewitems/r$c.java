package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import java.util.ArrayList;
import java.util.List;

final class r$c
  extends c.a
{
  LinearLayout ifV;
  List<r.a> ifY = new ArrayList();
  TextView vBz;
  r.e vDA = new r.e();
  r.i vDB = new r.i();
  r.d vDC = new r.d();
  r.g vDD = new r.g();
  r.f vDy = new r.f();
  r.h vDz = new r.h();
  
  public final c.a dW(View paramView)
  {
    LinearLayout localLinearLayout = this.ifV;
    r.a locala = new r.a();
    locala.ifA = paramView;
    locala.ifB = paramView.findViewById(R.h.top_line);
    locala.ifC = paramView.findViewById(R.h.content_ll);
    locala.fcy = ((TextView)paramView.findViewById(R.h.title));
    locala.ifE = ((TextView)paramView.findViewById(R.h.summary));
    locala.ifF = paramView.findViewById(R.h.cover_area);
    locala.ifG = ((ImageView)paramView.findViewById(R.h.cover));
    locala.ifH = ((ImageView)paramView.findViewById(R.h.play_icon));
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.ifY.add(locala);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.c
 * JD-Core Version:    0.7.0.1
 */