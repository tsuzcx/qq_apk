package com.tencent.mm.plugin.ringtone.uic;

import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.g;
import com.tencent.mm.plugin.ringtone.b.g.d;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.ab;
import com.tencent.mm.protocal.protobuf.a.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/uic/RingtoneSearchDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "hashContinue", "", "mMaxOffset", "", "queryString", "", "getQueryString", "()Ljava/lang/String;", "setQueryString", "(Ljava/lang/String;)V", "recommendJob", "Lkotlinx/coroutines/Job;", "getRecommendJob", "()Lkotlinx/coroutines/Job;", "setRecommendJob", "(Lkotlinx/coroutines/Job;)V", "requestCgi", "Lcom/tencent/mm/plugin/ringtone/model/GetSearchRingBackCgi;", "getRequestCgi", "()Lcom/tencent/mm/plugin/ringtone/model/GetSearchRingBackCgi;", "setRequestCgi", "(Lcom/tencent/mm/plugin/ringtone/model/GetSearchRingBackCgi;)V", "ringtoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/ringtone/SearchRingBackInfo;", "Lkotlin/collections/ArrayList;", "getRingtoneItems", "()Ljava/util/ArrayList;", "setRingtoneItems", "(Ljava/util/ArrayList;)V", "searchJob", "clearData", "", "doRingtoneSearch", "str", "loadMore", "firstLoad", "onDestroy", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends UIComponent
{
  public static final i.a OFq;
  private cb MmH;
  String NTq;
  ArrayList<ab> OFr;
  private cb OFs;
  boolean OFt;
  private com.tencent.mm.plugin.ringtone.f.e OFu;
  private int bS;
  
  static
  {
    AppMethodBeat.i(273424);
    OFq = new i.a((byte)0);
    AppMethodBeat.o(273424);
  }
  
  public i(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(273335);
    this.OFr = new ArrayList();
    this.OFt = true;
    this.bS = -1;
    AppMethodBeat.o(273335);
  }
  
  public final void BQ(boolean paramBoolean)
  {
    AppMethodBeat.i(273458);
    Object localObject1 = this.NTq;
    if (localObject1 == null)
    {
      AppMethodBeat.o(273458);
      return;
    }
    if (!this.OFt)
    {
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((a)com.tencent.mm.ui.component.k.d(getActivity()).q(a.class)).gOO();
      AppMethodBeat.o(273458);
      return;
    }
    if (paramBoolean)
    {
      localObject2 = com.tencent.mm.ui.component.k.aeZF;
      localObject2 = ((a)com.tencent.mm.ui.component.k.d(getActivity()).q(a.class)).OEB;
      if (localObject2 != null) {
        j.a(((g)localObject2).OCd, null, null, (kotlin.g.a.m)new g.d((g)localObject2, null), 3);
      }
    }
    Object localObject2 = this.MmH;
    if ((localObject2 != null) && (((cb)localObject2).isActive() == true)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.MmH = j.a(getLifecycleScope(), null, null, (kotlin.g.a.m)new b(this, (String)localObject1, null), 3);
      }
      AppMethodBeat.o(273458);
      return;
    }
  }
  
  public final void bs(ArrayList<ab> paramArrayList)
  {
    AppMethodBeat.i(273436);
    s.u(paramArrayList, "<set-?>");
    this.OFr = paramArrayList;
    AppMethodBeat.o(273436);
  }
  
  public final void clearData()
  {
    AppMethodBeat.i(273467);
    this.bS = 0;
    this.NTq = "";
    this.OFt = false;
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    ((a)com.tencent.mm.ui.component.k.d(getActivity()).q(a.class)).gOw();
    localObject = this.OFs;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    AppMethodBeat.o(273467);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(273483);
    super.onDestroy();
    Object localObject = this.MmH;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    localObject = this.OFu;
    if (localObject != null) {
      ((com.tencent.mm.plugin.ringtone.f.e)localObject).cancel();
    }
    this.OFr.clear();
    AppMethodBeat.o(273483);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(i parami, String paramString, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(273300);
      paramd = new b(this.OFv, this.OFw, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(273300);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(273295);
      Object localObject3 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(273295);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (aq)this.L$0;
        localObject1 = paramObject;
      }
      try
      {
        localObject2 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = paramObject;
        long l = ((m)com.tencent.mm.ui.component.k.d(this.OFv.getActivity()).q(m.class)).OFI;
        localObject1 = paramObject;
        localObject2 = (com.tencent.mm.am.b)new com.tencent.mm.plugin.ringtone.f.e(this.OFw, i.b(this.OFv) + 1, String.valueOf(l));
        localObject1 = paramObject;
        localObject4 = (d)this;
        localObject1 = paramObject;
        this.L$0 = paramObject;
        localObject1 = paramObject;
        this.label = 1;
        localObject1 = paramObject;
        localObject2 = com.tencent.mm.af.b.a((com.tencent.mm.am.b)localObject2, (d)localObject4);
        localObject1 = localObject2;
        if (localObject1 != localObject3) {
          break label534;
        }
        AppMethodBeat.o(273295);
        return localObject3;
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          try
          {
            localObject1 = (ad)localObject1;
            Log.e("MicroMsg.RingtoneSearchDataUIC", "GetSearchRingBackCgi success in RingtoneSearchMgr");
            if (localObject1 == null) {
              continue;
            }
            localObject2 = this.OFv;
            i.a((i)localObject2, ((ad)localObject1).aavs);
            localObject3 = new ArrayList();
            localObject1 = ((ad)localObject1).acja;
            s.s(localObject1, "it.Infos");
            localObject1 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject4 = (ab)((Iterator)localObject1).next();
            if ((i.b((i)localObject2) == -1) || (i.b((i)localObject2) < ((ab)localObject4).YYs)) {
              i.a((i)localObject2, ((ab)localObject4).YYs);
            }
            ((ArrayList)localObject3).add(localObject4);
            localObject4 = com.tencent.mm.ui.component.k.aeZF;
            ((m)com.tencent.mm.ui.component.k.d(((i)localObject2).getActivity()).q(m.class)).cy();
            continue;
            paramObject = paramObject;
            paramObject = localObject1;
          }
          catch (Exception localException)
          {
            Object localObject2;
            Object localObject4;
            continue;
          }
          Log.e("MicroMsg.RingtoneSearchDataUIC", "GetSearchRingBackCgi failed in RingtoneSearchMgr");
          i.a(this.OFv, false);
          this.OFv.bs(new ArrayList());
          localObject1 = null;
        }
        ((i)localObject2).bs((ArrayList)localObject3);
        localObject1 = new ArrayList();
        localObject3 = ((Iterable)((i)localObject2).OFr).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((ab)((Iterator)localObject3).next()).aciQ;
          if (localObject4 != null) {
            ((ArrayList)localObject1).add(new com.tencent.mm.plugin.ringtone.b.e((aa)localObject4));
          }
        }
        if (!ar.a(paramObject)) {
          break label518;
        }
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        ((a)com.tencent.mm.ui.component.k.d(((i)localObject2).getActivity()).q(a.class)).bq((ArrayList)localObject1);
        paramObject = ah.aiuX;
        AppMethodBeat.o(273295);
        return paramObject;
      }
      localObject2 = (aq)this.L$0;
      Object localObject1 = localObject2;
      ResultKt.throwOnFailure(paramObject);
      localObject1 = paramObject;
      paramObject = localObject2;
      label518:
      label534:
      for (;;) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.uic.i
 * JD-Core Version:    0.7.0.1
 */