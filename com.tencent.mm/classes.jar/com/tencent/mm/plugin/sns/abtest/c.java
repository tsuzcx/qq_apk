package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static boolean yVW;
  private static String yWH;
  private static Set<Long> yWI;
  private static View.OnClickListener yWJ;
  private static com.tencent.mm.sdk.b.c yWf;
  
  static
  {
    AppMethodBeat.i(94961);
    yWH = "0";
    yWI = new HashSet();
    yWf = new com.tencent.mm.sdk.b.c() {};
    yVW = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (yVW)
    {
      paramBaseViewHolder.AvD = false;
      paramBaseViewHolder.AvB = ((ViewStub)paramView.findViewById(2131305042));
      paramBaseViewHolder.AvB.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void dRc()
  {
    AppMethodBeat.i(94956);
    if (g.aCR().BE("6") != null)
    {
      yWH = g.aCR().BE("6").value;
      ad.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { yWH });
      yVW = true;
      com.tencent.mm.sdk.b.a.IbL.c(yWf);
      yWJ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94955);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
          if ((paramAnonymousView.getTag() instanceof p))
          {
            localObject = (p)paramAnonymousView.getTag();
            if ((localObject != null) && (!bt.isNullOrNil(((p)localObject).getSnsId()))) {
              c.R(paramAnonymousView.getContext(), ((p)localObject).getSnsId());
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(94955);
        }
      };
    }
    AppMethodBeat.o(94956);
  }
  
  public static void dRd()
  {
    AppMethodBeat.i(94957);
    yWJ = null;
    com.tencent.mm.sdk.b.a.IbL.d(yWf);
    if (yVW)
    {
      g.aCR().BE("6").hki = 2L;
      g.aCR().BE("6").result = yWI.size();
      f.a(g.aCR().BE("6"));
      ad.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), yWI.size() });
    }
    yWH = "0";
    yVW = false;
    yWI.clear();
    AppMethodBeat.o(94957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */