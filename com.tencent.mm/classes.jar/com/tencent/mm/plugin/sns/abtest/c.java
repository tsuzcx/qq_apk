package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.un;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static String zmR;
  private static Set<Long> zmS;
  private static View.OnClickListener zmT;
  private static boolean zmg;
  private static com.tencent.mm.sdk.b.c zmp;
  
  static
  {
    AppMethodBeat.i(94961);
    zmR = "0";
    zmS = new HashSet();
    zmp = new com.tencent.mm.sdk.b.c() {};
    zmg = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (zmg)
    {
      paramBaseViewHolder.AMU = false;
      paramBaseViewHolder.AMS = ((ViewStub)paramView.findViewById(2131305042));
      paramBaseViewHolder.AMS.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void dUA()
  {
    AppMethodBeat.i(94957);
    zmT = null;
    com.tencent.mm.sdk.b.a.IvT.d(zmp);
    if (zmg)
    {
      g.aDh().Cg("6").hmW = 2L;
      g.aDh().Cg("6").result = zmS.size();
      f.a(g.aDh().Cg("6"));
      ae.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), zmS.size() });
    }
    zmR = "0";
    zmg = false;
    zmS.clear();
    AppMethodBeat.o(94957);
  }
  
  public static void dUz()
  {
    AppMethodBeat.i(94956);
    if (g.aDh().Cg("6") != null)
    {
      zmR = g.aDh().Cg("6").value;
      ae.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { zmR });
      zmg = true;
      com.tencent.mm.sdk.b.a.IvT.c(zmp);
      zmT = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94955);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
          if ((paramAnonymousView.getTag() instanceof p))
          {
            localObject = (p)paramAnonymousView.getTag();
            if ((localObject != null) && (!bu.isNullOrNil(((p)localObject).getSnsId()))) {
              c.S(paramAnonymousView.getContext(), ((p)localObject).getSnsId());
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/abtest/SellerABTestManager$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(94955);
        }
      };
    }
    AppMethodBeat.o(94956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */