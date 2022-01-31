package com.tencent.mm.ui.widget.textview;

import android.text.Layout;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.ArrayList;

final class a$2
  implements View.OnLongClickListener
{
  a$2(a parama) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(138207);
    ak.d("SelectableTextHelper", "onLongClick.", new Object[0]);
    this.ANs.ANh = false;
    int j;
    if (this.ANs.AMU != null)
    {
      this.ANs.ANl = true;
      this.ANs.ANm = false;
      this.ANs.ANn = false;
      Object localObject2 = b.fz(this.ANs.AMT);
      if ((localObject2 instanceof SpannableString))
      {
        localObject1 = this.ANs;
        localObject2 = (SpannableString)localObject2;
        ((a)localObject1).ANr = new ArrayList();
        i = 0;
        if (i < ((SpannableString)localObject2).length())
        {
          j = ((SpannableString)localObject2).nextSpanTransition(i, ((SpannableString)localObject2).length(), ImageSpan.class);
          Object localObject3 = (ImageSpan[])((SpannableString)localObject2).getSpans(i, j, ImageSpan.class);
          if (1 == localObject3.length)
          {
            localObject3 = new a.c((a)localObject1);
            ((a.c)localObject3).start = i;
            ((a.c)localObject3).end = j;
            ((a)localObject1).ANr.add(localObject3);
          }
          for (;;)
          {
            ak.d("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
            i = j;
            break;
            ak.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject3.length) });
          }
        }
        ak.d("SelectableTextHelper", ((a)localObject1).ANr.toString(), new Object[0]);
      }
      this.ANs.dPP();
      if ((this.ANs.ANf > 0) && (this.ANs.ANf < b.fz(this.ANs.AMT).length()))
      {
        a.a(this.ANs, this.ANs.ANf);
        this.ANs.ANj = false;
        this.ANs.ANk = false;
        this.ANs.dPW();
        this.ANs.dPS();
      }
      for (;;)
      {
        AppMethodBeat.o(138207);
        return true;
        a.a(this.ANs, b.fz(this.ANs.AMT).length());
        this.ANs.ANj = true;
        this.ANs.ANk = false;
        this.ANs.dPS();
        this.ANs.AMU.eX(paramView);
      }
    }
    this.ANs.ANl = false;
    paramView = this.ANs;
    int k = this.ANs.AMY;
    int i = this.ANs.AMZ;
    Object localObject1 = paramView.AMT;
    if ((localObject1 instanceof NeatTextView))
    {
      localObject1 = ((NeatTextView)localObject1).getLayout();
      if (localObject1 == null) {
        break label590;
      }
      i = ((com.tencent.neattextview.textview.layout.a)localObject1).ii(k, i);
    }
    for (;;)
    {
      paramView.hY(i, i + 1);
      this.ANs.dPP();
      this.ANs.ANj = false;
      this.ANs.ANk = false;
      this.ANs.dPW();
      this.ANs.dPS();
      break;
      if ((localObject1 instanceof TextView))
      {
        localObject1 = ((TextView)localObject1).getLayout();
        if (localObject1 != null)
        {
          j = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(i), k);
          i = j;
          if ((int)((Layout)localObject1).getPrimaryHorizontal(j) > k) {
            i = ((Layout)localObject1).getOffsetToLeftOf(j);
          }
        }
        else
        {
          i = -1;
        }
      }
      else
      {
        label590:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.a.2
 * JD-Core Version:    0.7.0.1
 */