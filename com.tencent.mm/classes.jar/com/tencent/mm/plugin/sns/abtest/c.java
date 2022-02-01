package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static String PKO;
  private static Set<Long> PKP;
  private static View.OnClickListener PKQ;
  private static boolean PKd;
  private static IListener PKm;
  
  static
  {
    AppMethodBeat.i(94961);
    PKO = "0";
    PKP = new HashSet();
    PKm = new SellerABTestManager.1(com.tencent.mm.app.f.hfK);
    PKd = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (PKd)
    {
      paramBaseViewHolder.RLg = false;
      paramBaseViewHolder.RLe = ((ViewStub)paramView.findViewById(b.f.sns_post_hate_stub));
      paramBaseViewHolder.RLe.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void gZw()
  {
    AppMethodBeat.i(94956);
    if (g.bDR().Km("6") != null)
    {
      PKO = g.bDR().Km("6").value;
      Log.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { PKO });
      PKd = true;
      PKm.alive();
      PKQ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94955);
          Object localObject = new b();
          ((b)localObject).cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
          if ((paramAnonymousView.getTag() instanceof SnsInfo))
          {
            localObject = (SnsInfo)paramAnonymousView.getTag();
            if ((localObject != null) && (!Util.isNullOrNil(((SnsInfo)localObject).getSnsId()))) {
              c.access$200(paramAnonymousView.getContext(), ((SnsInfo)localObject).getSnsId());
            }
          }
          a.a(this, "com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(94955);
        }
      };
    }
    AppMethodBeat.o(94956);
  }
  
  public static void gZx()
  {
    AppMethodBeat.i(94957);
    PKQ = null;
    PKm.dead();
    if (PKd)
    {
      g.bDR().Km("6").nAz = 2L;
      g.bDR().Km("6").result = PKP.size();
      com.tencent.mm.model.a.f.a(g.bDR().Km("6"));
      Log.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), PKP.size() });
    }
    PKO = "0";
    PKd = false;
    PKP.clear();
    AppMethodBeat.o(94957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */