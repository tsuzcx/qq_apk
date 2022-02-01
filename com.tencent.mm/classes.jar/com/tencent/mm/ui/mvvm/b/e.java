package com.tencent.mm.ui.mvvm.b;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.mvvm.a.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/SelectContactRecommendChatroomUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "currentSearchTask", "Lcom/tencent/mm/plugin/fts/api/model/BaseFTSTask;", "currentSearchTask2", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "Lkotlin/Lazy;", "isContact", "", "username", "", "liveListUIC", "Lcom/tencent/mm/ui/mvvm/uic/SelectContactLiveListApiUIC;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "recommendSearchChatroom", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;", "startRecommend", "Companion", "SearchResultListener", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.mvvmbase.a
{
  public static final e.a afBC;
  private c DHR;
  private c afBD;
  private final j rdm;
  
  static
  {
    AppMethodBeat.i(250650);
    afBC = new e.a((byte)0);
    AppMethodBeat.o(250650);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(250596);
    this.rdm = kotlin.k.cm((kotlin.g.a.a)e.c.afBF);
    AppMethodBeat.o(250596);
  }
  
  private final void b(i parami)
  {
    AppMethodBeat.i(250608);
    Log.i("MicroMsg.SelectContact.SelectContactRecommendChatroomUIC", "start recommendSearchChatroom");
    b localb = new b((kotlin.g.a.b)new f(this));
    com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
    locall.HtD.addAll((Collection)parami.MR(false));
    parami = parami.afAS;
    if (parami != null)
    {
      parami = parami.values();
      if (parami != null)
      {
        parami = ((Iterable)parami).iterator();
        while (parami.hasNext())
        {
          Object localObject1 = ((m)parami.next()).HtF;
          s.s(localObject1, "result.resultList");
          Object localObject2 = (Iterable)localObject1;
          localObject1 = (Collection)new ArrayList();
          localObject2 = ((Iterable)localObject2).iterator();
          int j = 0;
          if (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = ((Iterator)localObject2).next();
            if (j < 0) {
              p.kkW();
            }
            int i;
            if (j >= 0) {
              if (j <= 5) {
                i = 1;
              }
            }
            for (;;)
            {
              if (i != 0) {
                ((Collection)localObject1).add(localObject3);
              }
              j += 1;
              break;
              i = 0;
              continue;
              i = 0;
            }
          }
          localObject1 = (List)localObject1;
          locall.HtD.add(p.a((Iterable)localObject1, (CharSequence)",", null, null, 0, null, (kotlin.g.a.b)e.afBG, 30));
        }
      }
    }
    locall.qRb = 8;
    locall.HtB = ((Comparator)com.tencent.mm.plugin.fts.a.c.b.Hue);
    locall.handler = getHandler();
    locall.Htz = 3;
    locall.HtC = ((com.tencent.mm.plugin.fts.a.l)localb);
    this.DHR = ((n)h.az(n.class)).search(11, locall);
    AppMethodBeat.o(250608);
  }
  
  private final MMHandler getHandler()
  {
    AppMethodBeat.i(250603);
    MMHandler localMMHandler = (MMHandler)this.rdm.getValue();
    AppMethodBeat.o(250603);
    return localMMHandler;
  }
  
  private final d jBV()
  {
    AppMethodBeat.i(250615);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = (d)com.tencent.mm.ui.component.k.d(getActivity()).cq(d.class);
    AppMethodBeat.o(250615);
    return localObject;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(250659);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new d(this));
      }
    }
    AppMethodBeat.o(250659);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/mvvm/uic/SelectContactRecommendChatroomUIC$SearchResultListener;", "Lcom/tencent/mm/plugin/fts/api/IFTSResultListener;", "handler", "Lkotlin/Function1;", "", "", "Lkotlin/ParameterName;", "name", "commonChatroomList", "", "(Lcom/tencent/mm/ui/mvvm/uic/SelectContactRecommendChatroomUIC;Lkotlin/jvm/functions/Function1;)V", "getHandler", "()Lkotlin/jvm/functions/Function1;", "onFTSSearchEnd", "ftsResult", "Lcom/tencent/mm/plugin/fts/api/model/FTSResult;", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.plugin.fts.a.l
  {
    private final kotlin.g.a.b<List<String>, ah> rIX;
    
    public b()
    {
      AppMethodBeat.i(250558);
      this.rIX = localObject;
      AppMethodBeat.o(250558);
    }
    
    public final void b(m paramm)
    {
      AppMethodBeat.i(250568);
      if (paramm != null)
      {
        Object localObject1 = e.this;
        if (((s.p(e.b((e)localObject1), paramm.HtE)) || (s.p(e.c((e)localObject1), paramm.HtE))) && (paramm.resultCode == 0))
        {
          localObject1 = this.rIX;
          paramm = paramm.HtF;
          s.s(paramm, "result.resultList");
          Object localObject2 = (Iterable)paramm;
          paramm = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            paramm.add(((o)((Iterator)localObject2).next()).Hsz);
          }
          ((kotlin.g.a.b)localObject1).invoke((List)paramm);
        }
      }
      AppMethodBeat.o(250568);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<i, ah>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/fts/api/model/MatchInfo;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<o, CharSequence>
  {
    public static final e afBG;
    
    static
    {
      AppMethodBeat.i(250555);
      afBG = new e();
      AppMethodBeat.o(250555);
    }
    
    e()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<List<? extends String>, ah>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<List<? extends String>, ah>
  {
    g(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<List<? extends String>, ah>
  {
    h(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.mvvm.b.e
 * JD-Core Version:    0.7.0.1
 */