package com.tencent.mm.plugin.sns.storage.a;

import android.text.TextUtils;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.a.a.b.a;
import com.tencent.mm.plugin.sns.storage.a.a.b.b;
import com.tencent.mm.plugin.sns.storage.a.a.b.c;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.e;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/cover/SnsCoverViewModel;", "Lcom/tencent/mm/ui/component/CoroutineViewModel;", "()V", "TAG", "", "requestSet", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "userCover", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/sns/storage/SnsCover;", "clearCoverData", "", "cover", "sameId", "", "finderShareObject2FinderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "shareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "getUserCover", "updateSnsCoverInfo", "snsObject", "Lcom/tencent/mm/protocal/protobuf/SnsObject;", "updateUserCoverFromDetail", "objId", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  public final x<com.tencent.mm.plugin.sns.storage.q> QZH;
  private final HashSet<Long> QZI;
  private final String TAG;
  
  public a()
  {
    AppMethodBeat.i(306677);
    this.TAG = "MicroMsg.SnsCoverViewModel";
    this.QZH = new x();
    this.QZI = new HashSet();
    AppMethodBeat.o(306677);
  }
  
  private static void b(com.tencent.mm.plugin.sns.storage.q paramq, boolean paramBoolean)
  {
    AppMethodBeat.i(306694);
    if (!paramBoolean)
    {
      y.deleteFile(paramq.field_localThumb);
      paramq.field_localThumb = "";
    }
    y.deleteFile(paramq.field_localImage);
    y.deleteFile(paramq.field_cacheVideo);
    paramq.field_cacheVideo = paramq.field_localVideo;
    paramq.field_localImage = "";
    paramq.field_localVideo = "";
    AppMethodBeat.o(306694);
  }
  
  private final com.tencent.mm.plugin.sns.storage.q j(SnsObject paramSnsObject)
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(306687);
    Log.i(this.TAG, s.X("snsdetail xml ", w.b(paramSnsObject.ObjectDesc)));
    Object localObject1 = new SnsObject();
    try
    {
      ((SnsObject)localObject1).parseFrom(paramSnsObject.toByteArray());
      ap.h((SnsObject)localObject1);
      localObject1 = al.hgG();
      localObject2 = paramSnsObject.Username;
      s.s(localObject2, "snsObject.Username");
      localObject1 = ((r)localObject1).aZM((String)localObject2);
      ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_userName = paramSnsObject.Username;
      if (((com.tencent.mm.plugin.sns.storage.q)localObject1).field_snsBgId != paramSnsObject.Id)
      {
        bool1 = true;
        label106:
        Log.i(this.TAG, "differentId:" + bool1 + " cover.field_success:" + ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_success);
        if ((bool1) || (!((com.tencent.mm.plugin.sns.storage.q)localObject1).field_success))
        {
          localObject2 = com.tencent.mm.modelsns.o.Pm(w.b(paramSnsObject.ObjectDesc));
          ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_snsBgId = paramSnsObject.Id;
          ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_isLike = false;
          ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_success = true;
          if (((TimeLineObject)localObject2).ContentObj.hKU == null) {
            break label419;
          }
          Log.i(this.TAG, "update cover info to finder,type:%d", new Object[] { Integer.valueOf(((TimeLineObject)localObject2).ContentObj.hKU.GfT) });
          if (((TimeLineObject)localObject2).ContentObj.hKU.GfT != 4) {
            break label390;
          }
          ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_type = 3;
          label249:
          if (bool1) {
            break label414;
          }
          bool1 = bool2;
          label256:
          b((com.tencent.mm.plugin.sns.storage.q)localObject1, bool1);
        }
      }
    }
    catch (IOException localIOException)
    {
      try
      {
        ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_thumbUrl = ((bvj)((TimeLineObject)localObject2).ContentObj.hKU.mediaList.getFirst()).thumbUrl;
        paramSnsObject = ((TimeLineObject)localObject2).ContentObj.hKU;
        s.s(paramSnsObject, "timeLineObj.ContentObj.finderShareObject");
        Object localObject2 = new FinderObject();
        ((FinderObject)localObject2).id = t.aXD(paramSnsObject.objectId);
        ((FinderObject)localObject2).objectNonceId = paramSnsObject.objectNonceId;
        ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_finderObject = ((FinderObject)localObject2).toByteArray();
        label343:
        label499:
        int i;
        label390:
        label414:
        label419:
        label584:
        label626:
        do
        {
          al.hgG().a((com.tencent.mm.plugin.sns.storage.q)localObject1, false);
          AppMethodBeat.o(306687);
          return localObject1;
          localIOException = localIOException;
          Log.printErrStackTrace(this.TAG, (Throwable)localIOException, "SnsObject parseFrom error", new Object[0]);
          break;
          bool1 = false;
          break label106;
          if (localIOException.ContentObj.hKU.GfT != 2) {
            break label249;
          }
          ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_type = 4;
          break label249;
          bool1 = false;
          break label256;
          paramSnsObject = localIOException.ContentObj.Zpr;
          s.s(paramSnsObject, "timeLineObj.ContentObj.MediaObjList");
          paramSnsObject = (List)paramSnsObject;
          if (paramSnsObject.size() > 1) {
            kotlin.a.p.a(paramSnsObject, (Comparator)new a());
          }
          paramSnsObject = localIOException.ContentObj.Zpr;
          s.s(paramSnsObject, "timeLineObj.ContentObj.MediaObjList");
          paramSnsObject = (List)paramSnsObject;
          ListIterator localListIterator2 = paramSnsObject.listIterator(paramSnsObject.size());
          if (!localListIterator2.hasPrevious()) {
            break label726;
          }
          paramSnsObject = localListIterator2.previous();
          if (((dmz)paramSnsObject).vhJ != 2) {
            break label721;
          }
          i = 1;
          if (i == 0) {
            break label724;
          }
          paramSnsObject = (dmz)paramSnsObject;
          if (paramSnsObject != null)
          {
            Log.i(this.TAG, "update cover info to MMSNS_DATA_PHOTO");
            ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_type = 1;
            ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_imageBgUrl = paramSnsObject.Url;
            ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_thumbUrl = paramSnsObject.aaTl;
            if (bool1) {
              break label731;
            }
            bool2 = true;
            b((com.tencent.mm.plugin.sns.storage.q)localObject1, bool2);
          }
          paramSnsObject = localIOException.ContentObj.Zpr;
          s.s(paramSnsObject, "timeLineObj.ContentObj.MediaObjList");
          paramSnsObject = (List)paramSnsObject;
          ListIterator localListIterator1 = paramSnsObject.listIterator(paramSnsObject.size());
          if (!localListIterator1.hasPrevious()) {
            break label742;
          }
          paramSnsObject = localListIterator1.previous();
          if (((dmz)paramSnsObject).vhJ != 6) {
            break label737;
          }
          i = 1;
          if (i == 0) {
            break label740;
          }
          paramSnsObject = (dmz)paramSnsObject;
        } while (paramSnsObject == null);
        label530:
        label534:
        Log.i(this.TAG, "update cover info to MMSNS_DATA_SIGHT");
        label658:
        label662:
        ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_type = 2;
        ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_videoBgUrl = paramSnsObject.Url;
        ((com.tencent.mm.plugin.sns.storage.q)localObject1).field_thumbUrl = paramSnsObject.aaTl;
        if (!bool1) {}
        for (boolean bool1 = bool3;; bool1 = false)
        {
          b((com.tencent.mm.plugin.sns.storage.q)localObject1, bool1);
          break;
          label721:
          i = 0;
          break label530;
          label724:
          break label499;
          label726:
          paramSnsObject = null;
          break label534;
          label731:
          bool2 = false;
          break label584;
          label737:
          i = 0;
          break label658;
          label740:
          break label626;
          label742:
          paramSnsObject = null;
          break label662;
        }
      }
      catch (IOException paramSnsObject)
      {
        break label343;
      }
    }
  }
  
  public final void vp(final long paramLong)
  {
    AppMethodBeat.i(306711);
    e.launch$default((e)this, null, null, (kotlin.g.a.m)new b(this, paramLong, null), 3, null);
    AppMethodBeat.o(306711);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
  public static final class a<T>
    implements Comparator
  {
    public final int compare(T paramT1, T paramT2)
    {
      AppMethodBeat.i(306667);
      int i = kotlin.b.a.b((Comparable)Float.valueOf(((dmz)paramT1).aaTn.aaUc), (Comparable)Float.valueOf(((dmz)paramT2).aaTn.aaUc));
      AppMethodBeat.o(306667);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements kotlin.g.a.m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(a parama, long paramLong, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(306674);
      paramObject = (kotlin.d.d)new b(this.QZJ, paramLong, paramd);
      AppMethodBeat.o(306674);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(306669);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(306669);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Log.i(a.a(this.QZJ), s.X("updateUserCoverFromDetail ", t.uA(paramLong)));
        if ((a.b(this.QZJ).contains(kotlin.d.b.a.b.BF(paramLong))) || (paramLong == 0L))
        {
          Log.i(a.a(this.QZJ), "request is doing!");
          paramObject = ah.aiuX;
          AppMethodBeat.o(306669);
          return paramObject;
        }
        a.b(this.QZJ).add(kotlin.d.b.a.b.BF(paramLong));
        paramObject = kotlinx.coroutines.b.m.a(kotlinx.coroutines.b.o.d((g)new c((g)new b(kotlinx.coroutines.b.p.e(j.y((kotlin.g.a.m)new k(paramLong, this.QZJ)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(306697);
            paramAnonymousd = new 1(this.QZK, this.QZJ, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousObject;
            paramAnonymousObject = (kotlin.d.d)paramAnonymousd;
            AppMethodBeat.o(306697);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(306690);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            Object localObject1;
            Object localObject2;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(306690);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (h)this.L$0;
              localObject1 = new com.tencent.mm.plugin.sns.storage.a.a.a(this.QZK);
              localObject2 = (kotlin.d.d)this;
              this.L$0 = paramAnonymousObject;
              this.label = 1;
              kotlinx.coroutines.q localq = new kotlinx.coroutines.q(kotlin.d.a.b.au((kotlin.d.d)localObject2), 1);
              localq.kBA();
              kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localq;
              localp.bg((kotlin.g.a.b)new b.b(((com.tencent.mm.plugin.sns.storage.a.a.b)localObject1).bFJ().g((com.tencent.mm.vending.c.a)new b.c((com.tencent.mm.plugin.sns.storage.a.a.b)localObject1, localp))));
              localObject1 = localq.getResult();
              if (localObject1 == kotlin.d.a.a.aiwj) {
                s.u(localObject2, "frame");
              }
              if (localObject1 == locala)
              {
                AppMethodBeat.o(306690);
                return locala;
              }
              break;
            case 1: 
              localObject2 = (h)this.L$0;
              ResultKt.throwOnFailure(paramAnonymousObject);
              localObject1 = paramAnonymousObject;
              paramAnonymousObject = localObject2;
            }
            for (;;)
            {
              localObject1 = (fel)localObject1;
              localObject2 = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
              com.tencent.mm.plugin.sns.cover.c.b.b(((fel)localObject1).abDT);
              localObject1 = ((fel)localObject1).abDT;
              s.s(localObject1, "resp.Object");
              localObject2 = (kotlin.d.d)this;
              this.L$0 = null;
              this.label = 2;
              if (paramAnonymousObject.a(localObject1, (kotlin.d.d)localObject2) == locala)
              {
                AppMethodBeat.o(306690);
                return locala;
                ResultKt.throwOnFailure(paramAnonymousObject);
              }
              Log.i(a.a(this.QZJ), "updateUserCoverFromDetail emit resp");
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(306690);
              return paramAnonymousObject;
            }
          }
        }), (kotlin.g.a.q)new k(paramLong, this.QZJ)
        {
          int label;
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(306691);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(306691);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = (Throwable)this.L$0;
            if ((paramAnonymousObject instanceof b.a))
            {
              localObject = com.tencent.mm.plugin.sns.cover.c.b.Qmn;
              com.tencent.mm.plugin.sns.cover.c.b.i(this.QZK, ((b.a)paramAnonymousObject).errorCode, paramAnonymousObject.getMessage());
            }
            Log.printErrStackTrace(a.a(this.QZJ), paramAnonymousObject, s.X("GetSnsObjectDetailCgi error id:", kotlin.d.b.a.b.BF(this.QZK)), new Object[0]);
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(306691);
            return paramAnonymousObject;
          }
        }), this.QZJ), this.QZJ), (kotlin.g.a.q)new k(this.QZJ, paramLong)
        {
          int label;
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(306683);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(306683);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            Log.i(a.a(this.QZJ), s.X("onCompletion:", t.uA(this.QZK)));
            a.b(this.QZJ).remove(kotlin.d.b.a.b.BF(this.QZK));
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(306683);
            return paramAnonymousObject;
          }
        }), (kotlin.d.f)bg.kCi());
        h localh = (h)new a();
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (paramObject.a(localh, locald) == locala)
        {
          AppMethodBeat.o(306669);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(306669);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements h<com.tencent.mm.plugin.sns.storage.q>
    {
      public final Object a(com.tencent.mm.plugin.sns.storage.q paramq, kotlin.d.d<? super ah> paramd)
      {
        return ah.aiuX;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements g<SnsObject>
    {
      public b(g paramg, a parama) {}
      
      public final Object a(h paramh, kotlin.d.d paramd)
      {
        AppMethodBeat.i(306665);
        paramh = this.bLp.a((h)new h()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(306705);
            Object localObject1;
            if ((paramAnonymousd instanceof 1))
            {
              localObject1 = (1)paramAnonymousd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(306707);
                    this.result = paramAnonymous2Object;
                    this.label |= 0x80000000;
                    paramAnonymous2Object = this.QZL.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(306707);
                    return paramAnonymous2Object;
                  }
                })
            {
              localObject2 = paramAnonymousd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramAnonymousd.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(306705);
                throw paramAnonymousObject;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.bLr;
            SnsObject localSnsObject = (SnsObject)paramAnonymousObject;
            Log.i(a.a(this.QZJ), s.X("updateUserCoverFromDetail userName:", localSnsObject.Username));
            int i;
            if (!TextUtils.isEmpty((CharSequence)localSnsObject.Username)) {
              i = 1;
            }
            while (i != 0)
            {
              paramAnonymousd.label = 1;
              if (((h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
              {
                AppMethodBeat.o(306705);
                return localObject1;
                i = 0;
                continue;
                ResultKt.throwOnFailure(localObject2);
              }
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(306705);
            return paramAnonymousObject;
          }
        }, paramd);
        if (paramh == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(306665);
          return paramh;
        }
        paramh = ah.aiuX;
        AppMethodBeat.o(306665);
        return paramh;
      }
    }
    
    @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements g<com.tencent.mm.plugin.sns.storage.q>
    {
      public c(g paramg, a parama) {}
      
      public final Object a(h paramh, kotlin.d.d paramd)
      {
        AppMethodBeat.i(306663);
        paramh = this.bLp.a((h)new h()
        {
          public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
          {
            AppMethodBeat.i(306672);
            Object localObject1;
            if ((paramAnonymousd instanceof 1))
            {
              localObject1 = (1)paramAnonymousd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(306681);
                    this.result = paramAnonymous2Object;
                    this.label |= 0x80000000;
                    paramAnonymous2Object = this.QZM.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(306681);
                    return paramAnonymous2Object;
                  }
                })
            {
              localObject2 = paramAnonymousd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramAnonymousd.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(306672);
                throw paramAnonymousObject;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.bLr;
            paramAnonymousObject = (SnsObject)paramAnonymousObject;
            paramAnonymousObject = a.a(this.QZJ, paramAnonymousObject);
            paramAnonymousd.label = 1;
            if (((h)localObject2).a(paramAnonymousObject, paramAnonymousd) == localObject1)
            {
              AppMethodBeat.o(306672);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(306672);
            return paramAnonymousObject;
          }
        }, paramd);
        if (paramh == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(306663);
          return paramh;
        }
        paramh = ah.aiuX;
        AppMethodBeat.o(306663);
        return paramh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.a.a
 * JD-Core Version:    0.7.0.1
 */