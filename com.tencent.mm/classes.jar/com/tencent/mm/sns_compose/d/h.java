package com.tencent.mm.sns_compose.d;

import android.net.Uri;
import coil.e.b;
import coil.g.f;
import coil.g.g;
import coil.g.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import j.p;
import j.q;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.d.d<-Lcoil.g.f;>;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sns_compose/widget/SnsCdnFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/net/Uri;", "()V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/net/Uri;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handles", "", "key", "", "sns-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  implements g<Uri>
{
  public final Object a(Uri paramUri, kotlin.d.d<? super f> paramd)
  {
    AppMethodBeat.i(235405);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    for (paramd = (kotlin.d.d<? super f>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject3 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramUri = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(235405);
        throw paramUri;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject2 = paramUri.toString();
    s.s(localObject2, "data.toString()");
    Object localObject1 = n.a((CharSequence)n.rw((String)localObject2, "//"), new String[] { "/" });
    if (((List)localObject1).size() != 4)
    {
      Log.v("SnsCdnFetcher", "url:" + (String)localObject2 + " splits:" + ((List)localObject1).size());
      paramUri = new FileNotFoundException(" Uri:" + paramUri + " split size " + ((List)localObject1).size() + ", Uri(\"sns://id/mediaId/thumb\")");
      AppMethodBeat.o(235405);
      throw paramUri;
    }
    localObject2 = com.tencent.mm.sns_compose.a.acyR;
    String str1 = (String)((List)localObject1).get(0);
    String str2 = (String)((List)localObject1).get(1);
    boolean bool = s.p(((List)localObject1).get(2), "1");
    paramd.L$0 = paramUri;
    paramd.Uf = localObject1;
    paramd.label = 1;
    localObject2 = ((com.tencent.mm.sns_compose.a)localObject2).a(str1, str2, bool, paramd);
    if (localObject2 == localObject3)
    {
      AppMethodBeat.o(235405);
      return localObject3;
      localObject2 = (List)paramd.Uf;
      localObject3 = (Uri)paramd.L$0;
      ResultKt.throwOnFailure(localObject1);
      paramUri = (Uri)localObject1;
      paramd = (kotlin.d.d<? super f>)localObject2;
      localObject1 = localObject3;
      localObject2 = paramUri;
    }
    for (;;)
    {
      paramUri = (String)localObject2;
      if ((paramUri != null) && (y.ZC(paramUri)))
      {
        paramUri = y.Lh(paramUri);
        s.s(paramUri, "openRead(path)");
        paramUri = new m(q.b(p.ah(paramUri)), (String)paramd.get(3), b.cmW);
        AppMethodBeat.o(235405);
        return paramUri;
      }
      Log.v("SnsCdnFetcher", s.X(" path is null, or file is not exists :", paramUri));
      paramUri = new FileNotFoundException(s.X(" Uri:", localObject1));
      AppMethodBeat.o(235405);
      throw paramUri;
      paramd = (kotlin.d.d<? super f>)localObject1;
      localObject1 = paramUri;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(h paramh, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(235431);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.acAo.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(235431);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sns_compose.d.h
 * JD-Core Version:    0.7.0.1
 */