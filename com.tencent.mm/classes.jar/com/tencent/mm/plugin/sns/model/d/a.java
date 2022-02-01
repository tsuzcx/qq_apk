package com.tencent.mm.plugin.sns.model.d;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.c.i;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/withta/SnsImageLoader;", "", "()V", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a QAN;
  
  static
  {
    AppMethodBeat.i(309611);
    QAN = new a((byte)0);
    AppMethodBeat.o(309611);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/withta/SnsImageLoader$Companion;", "", "()V", "TAG", "", "getBitmap", "Landroid/graphics/Bitmap;", "snsId", "mediaId", "thumb", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageFromMedia", "media", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "requestThumb", "(Lcom/tencent/mm/protocal/protobuf/MediaObj;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImageFromUrl", "url", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getImagePath", "getImagePathFromMedia", "getMedia", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static Object a(final dmz paramdmz, boolean paramBoolean, d<? super String> paramd)
    {
      AppMethodBeat.i(309604);
      paramdmz = l.a((f)bg.kCi(), (m)new c(paramBoolean, paramdmz, null), paramd);
      AppMethodBeat.o(309604);
      return paramdmz;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super Bitmap>, Object>
    {
      int label;
      
      a(dmz paramdmz, boolean paramBoolean, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(309633);
        paramObject = (d)new a(this.mrU, this.mrR, paramd);
        AppMethodBeat.o(309633);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(309628);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(309628);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = a.QAN;
          paramObject = this.mrU;
          boolean bool = this.mrR;
          Object localObject = (d)this;
          this.label = 1;
          localObject = a.a.a(paramObject, bool, (d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(309628);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (String)paramObject;
        if (y.ZC(paramObject))
        {
          if (this.mrR)
          {
            paramObject = com.tencent.mm.plugin.sns.c.q.Qkh.a(this.mrU);
            AppMethodBeat.o(309628);
            return paramObject;
          }
          paramObject = com.tencent.mm.plugin.sns.c.q.Qkh.lS(paramObject, this.mrU.Id);
          AppMethodBeat.o(309628);
          return paramObject;
        }
        AppMethodBeat.o(309628);
        return null;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends k
      implements m<aq, d<? super String>, Object>
    {
      int label;
      
      b(String paramString1, String paramString2, boolean paramBoolean, d<? super b> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(309637);
        paramObject = (d)new b(this.mrP, this.mrQ, this.mrR, paramd);
        AppMethodBeat.o(309637);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(309631);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(309631);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = a.QAN;
          Object localObject = this.mrP;
          String str = this.mrQ;
          s.u(localObject, "snsId");
          s.u(str, "mediaId");
          paramObject = al.hgB().aZK((String)localObject);
          if (paramObject == null)
          {
            Log.e("MicroMsg.SnsImageLoader", s.X("Couldn't find SnsInfo, snsId=", localObject));
            paramObject = null;
          }
          while (paramObject == null)
          {
            Log.e("MicroMsg.SnsImageLoader", "getImagePath snsId:" + this.mrP + " mediaId:" + this.mrQ);
            AppMethodBeat.o(309631);
            return null;
            paramObject = paramObject.getTimeLine();
            if (paramObject == null) {
              paramObject = null;
            }
            for (;;)
            {
              if (paramObject == null)
              {
                Log.e("MicroMsg.SnsImageLoader", "Couldn't find media, snsId=" + (String)localObject + ", mediaId=" + str);
                paramObject = null;
                break;
                paramObject = paramObject.ContentObj;
                if (paramObject == null)
                {
                  paramObject = null;
                }
                else
                {
                  paramObject = paramObject.Zpr;
                  if (paramObject == null)
                  {
                    paramObject = null;
                  }
                  else
                  {
                    Iterator localIterator = ((Iterable)paramObject).iterator();
                    do
                    {
                      if (!localIterator.hasNext()) {
                        break;
                      }
                      paramObject = localIterator.next();
                    } while (!s.p(((dmz)paramObject).Id, str));
                    for (;;)
                    {
                      paramObject = (dmz)paramObject;
                      break;
                      paramObject = null;
                    }
                  }
                }
              }
            }
          }
          localObject = a.QAN;
          boolean bool = this.mrR;
          localObject = (d)this;
          this.label = 1;
          localObject = a.a.a(paramObject, bool, (d)localObject);
          paramObject = localObject;
          if (localObject == locala)
          {
            AppMethodBeat.o(309631);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = (String)paramObject;
        if (y.ZC(paramObject))
        {
          AppMethodBeat.o(309631);
          return paramObject;
        }
        Log.e("MicroMsg.SnsImageLoader", "getImagePath snsId:" + this.mrP + " mediaId:" + this.mrQ + " requestThumb:" + this.mrR + " path is null");
        AppMethodBeat.o(309631);
        return null;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends k
      implements m<aq, d<? super String>, Object>
    {
      Object L$0;
      Object Uf;
      Object VC;
      int label;
      
      c(boolean paramBoolean, dmz paramdmz, d<? super c> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(309648);
        paramObject = (d)new c(this.mrR, paramdmz, paramd);
        AppMethodBeat.o(309648);
        return paramObject;
      }
      
      public final Object invokeSuspend(final Object paramObject)
      {
        AppMethodBeat.i(309641);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        label123:
        Object localObject2;
        label148:
        int i;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(309641);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          if (this.mrR)
          {
            paramObject = t.d(paramdmz);
            if (!this.mrR) {
              break label123;
            }
          }
          for (paramObject = g.r(paramdmz);; paramObject = y.n(s.X(as.mg(al.getAccSnsPath(), paramdmz.Id), paramObject), false))
          {
            if (!y.ZC(paramObject)) {
              break label148;
            }
            Log.e("MicroMsg.SnsImageLoader", s.X("getImagePathFromMedia fileExists path:", paramObject));
            AppMethodBeat.o(309641);
            return paramObject;
            paramObject = t.k(paramdmz);
            break;
          }
          localObject2 = new com.tencent.mm.plugin.sns.data.p(paramdmz);
          if (this.mrR)
          {
            ((com.tencent.mm.plugin.sns.data.p)localObject2).QnY = 1;
            if (paramdmz.vhJ != 6) {
              break label393;
            }
            i = 5;
          }
          break;
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.sns.data.p)localObject2).hOG = paramdmz.Id;
          Object localObject1 = al.hgw();
          Log.i("MicroMsg.SnsImageLoader", s.X("start downloading mediaId=", paramdmz.Id));
          ((c)localObject1).a(paramdmz, i, (com.tencent.mm.plugin.sns.data.p)localObject2, br.adjZ);
          dmz localdmz = paramdmz;
          this.L$0 = paramObject;
          this.Uf = localObject1;
          this.VC = localdmz;
          this.label = 1;
          localObject2 = new kotlinx.coroutines.q(kotlin.d.a.b.au((d)this), 1);
          ((kotlinx.coroutines.q)localObject2).kBA();
          final kotlinx.coroutines.p localp = (kotlinx.coroutines.p)localObject2;
          paramObject = new b(localdmz, paramObject, (c)localObject1, localp);
          ((c)localObject1).a((c.b)paramObject);
          localp.bg((kotlin.g.a.b)new a((c)localObject1, paramObject));
          localObject1 = ((kotlinx.coroutines.q)localObject2).getResult();
          if (localObject1 == kotlin.d.a.a.aiwj) {
            s.u((d)this, "frame");
          }
          paramObject = localObject1;
          if (localObject1 == locala)
          {
            AppMethodBeat.o(309641);
            return locala;
            ((com.tencent.mm.plugin.sns.data.p)localObject2).QnY = 3;
            i = 2;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          else
          {
            AppMethodBeat.o(309641);
            return paramObject;
            label393:
            i = 1;
          }
        }
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.b<Throwable, ah>
      {
        a(c paramc, a.a.c.b paramb)
        {
          super();
        }
      }
      
      @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/model/withta/SnsImageLoader$Companion$getImagePathFromMedia$2$1$listener$1", "Lcom/tencent/mm/plugin/sns/model/DownloadManager$IOnDownloadListener;", "onImageFinish", "", "mediaId", "", "isOk", "", "onSetbg", "onSightFinish", "onThumbFinish", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
      public static final class b
        implements c.b
      {
        b(dmz paramdmz, String paramString, c paramc, kotlinx.coroutines.p<? super String> paramp) {}
        
        public final void EE(String paramString)
        {
          AppMethodBeat.i(309602);
          s.u(paramString, "mediaId");
          if (s.p(paramString, this.mrU.Id))
          {
            Log.i("MicroMsg.SnsImageLoader", s.X("onThumbFinish: ", paramObject));
            this.mrS.b((c.b)this);
            paramString = (d)localp;
            String str = paramObject;
            Result.Companion localCompanion = Result.Companion;
            paramString.resumeWith(Result.constructor-impl(str));
          }
          AppMethodBeat.o(309602);
        }
        
        public final void aXr() {}
        
        public final void w(String paramString, boolean paramBoolean)
        {
          AppMethodBeat.i(309610);
          if (s.p(paramString, this.mrU.Id))
          {
            this.mrS.b((c.b)this);
            paramString = (d)localp;
            String str = paramObject;
            Result.Companion localCompanion = Result.Companion;
            paramString.resumeWith(Result.constructor-impl(str));
          }
          AppMethodBeat.o(309610);
        }
        
        public final void x(String paramString, boolean paramBoolean)
        {
          AppMethodBeat.i(309621);
          Log.i("MicroMsg.SnsImageLoader", s.X("onSightFinish: ", paramString));
          AppMethodBeat.o(309621);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d.a
 * JD-Core Version:    0.7.0.1
 */