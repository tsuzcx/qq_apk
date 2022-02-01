package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.i;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.ak.a;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class TextStatusEditActivity$ab
  implements Runnable
{
  TextStatusEditActivity$ab(TextStatusEditActivity paramTextStatusEditActivity) {}
  
  public final void run()
  {
    AppMethodBeat.i(235982);
    Object localObject1 = this.MMz.MLF;
    Object localObject3;
    int n;
    int i1;
    int k;
    int j;
    Object localObject5;
    int i2;
    int i3;
    int i;
    int m;
    label317:
    Object localObject6;
    Object localObject2;
    if (localObject1 != null)
    {
      Object localObject4;
      int i4;
      for (;;)
      {
        try
        {
          if (!this.MMz.isFinishing())
          {
            localObject3 = new int[2];
            ((View)localObject1).getLocationInWindow((int[])localObject3);
            localObject4 = this.MMz.MMa;
            if (localObject4 != null) {
              ((e)localObject4).Bbj = localObject3[0];
            }
            localObject3 = this.MMz.MMa;
            if (localObject3 != null) {
              ((e)localObject3).Gr = a.fromDPToPix((Context)this.MMz, 12);
            }
            localObject3 = this.MMz.MMa;
            if (localObject3 == null) {
              break label563;
            }
            p.k(localObject1, "anchor");
            if (!((e)localObject3).Bbh)
            {
              ((e)localObject3).getContentView().measure(0, 0);
              ((e)localObject3).Bbh = true;
            }
            localObject4 = ((e)localObject3).getContentView();
            p.j(localObject4, "contentView");
            n = ((View)localObject4).getMeasuredWidth();
            localObject4 = ((e)localObject3).getContentView();
            p.j(localObject4, "contentView");
            i1 = ((View)localObject4).getMeasuredHeight();
            localObject4 = new int[2];
            ((View)localObject1).getLocationInWindow((int[])localObject4);
            k = localObject4[0] + (((View)localObject1).getWidth() - n) / 2;
            j = localObject4[1] - i1;
            localObject5 = ak.kU(((e)localObject3).context);
            i2 = ((ak.a)localObject5).width;
            i3 = ((ak.a)localObject5).height;
            i = i2 - ((e)localObject3).Bbj - n;
            m = ((e)localObject3).Bbj + 0;
            i4 = ((e)localObject3).Bbj;
            if (k <= i) {
              break label317;
            }
            localObject5 = ((e)localObject3).Bbf.getLayoutParams();
            if (localObject5 != null) {
              break;
            }
            localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(235982);
            throw ((Throwable)localObject1);
          }
        }
        catch (Throwable localThrowable)
        {
          AppMethodBeat.o(235982);
          return;
        }
        i = k;
        if (k < m) {
          i = m;
        }
      }
      localObject5 = (RelativeLayout.LayoutParams)localObject5;
      localObject6 = ((e)localObject3).Bbg.getLayoutParams();
      if (localObject6 == null)
      {
        localObject2 = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        AppMethodBeat.o(235982);
        throw ((Throwable)localObject2);
      }
      localObject6 = (RelativeLayout.LayoutParams)localObject6;
      ((RelativeLayout.LayoutParams)localObject5).setMarginStart(localObject4[0] + ((View)localObject2).getWidth() / 2 - i - ((e)localObject3).Bbf.getMeasuredWidth() / 2);
      if (j > i3 - i1 - i4)
      {
        if (((e)localObject3).MJy == e.b.MJB) {
          break label657;
        }
        ((RelativeLayout.LayoutParams)localObject6).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject5).addRule(3, b.e.menu_content);
        ((e)localObject3).Bbf.setRotation(((e)localObject3).Bbf.getRotation() + 180.0F);
        ((e)localObject3).MJy = e.b.MJB;
      }
    }
    label657:
    for (;;)
    {
      ((e)localObject3).setAnimationStyle(b.i.Gac);
      ((e)localObject3).showAtLocation((View)localObject2, 0, i, j);
      localObject2 = af.aaBG;
      p.j(String.format("popX:%s, popY:%s, sw:%s, sh:%s, pw:%s, ph:%s", Arrays.copyOf(new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(n), Integer.valueOf(i1) }, 6)), "java.lang.String.format(format, *args)");
      label563:
      com.tencent.mm.plugin.textstatus.a.t.glc();
      AppMethodBeat.o(235982);
      return;
      if (((e)localObject3).MJy != e.b.MJC)
      {
        ((RelativeLayout.LayoutParams)localObject5).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject6).addRule(3, b.e.v_arrow);
        ((e)localObject3).Bbf.setRotation(((e)localObject3).Bbf.getRotation() + 180.0F);
        ((e)localObject3).MJy = e.b.MJC;
      }
      k = ((View)localObject2).getHeight();
      m = ((e)localObject3).Gr;
      j = k + i1 + m + j;
      continue;
      AppMethodBeat.o(235982);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.ab
 * JD-Core Version:    0.7.0.1
 */