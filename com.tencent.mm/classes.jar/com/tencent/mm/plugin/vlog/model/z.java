package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.videocomposition.d.a;
import com.tencent.mm.videocomposition.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"})
public class z
{
  public static final a Gzf;
  private static final String TAG = "MicroMsg.SourceMaterial";
  int Gze;
  int height;
  private int type;
  int width;
  
  static
  {
    AppMethodBeat.i(190644);
    Gzf = new a((byte)0);
    TAG = "MicroMsg.SourceMaterial";
    AppMethodBeat.o(190644);
  }
  
  private z(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.Gze = 0;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
  public static final class a
  {
    /* Error */
    static int aTX(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_1
      //   4: ldc 62
      //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: invokestatic 74	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   13: astore_0
      //   14: aload_0
      //   15: ifnull +84 -> 99
      //   18: aload_0
      //   19: checkcast 76	java/io/Closeable
      //   22: astore_3
      //   23: new 78	android/support/e/a
      //   26: dup
      //   27: aload_3
      //   28: checkcast 80	java/io/InputStream
      //   31: invokespecial 83	android/support/e/a:<init>	(Ljava/io/InputStream;)V
      //   34: astore_0
      //   35: getstatic 89	kotlin/x:SXb	Lkotlin/x;
      //   38: astore 4
      //   40: aload_3
      //   41: aconst_null
      //   42: invokestatic 94	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   45: aload_0
      //   46: ifnull +13 -> 59
      //   49: aload_0
      //   50: ldc 96
      //   52: invokevirtual 99	android/support/e/a:l	(Ljava/lang/String;)I
      //   55: invokestatic 105	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   58: astore_1
      //   59: aload_1
      //   60: ifnonnull +44 -> 104
      //   63: aload_1
      //   64: ifnonnull +57 -> 121
      //   67: aload_1
      //   68: ifnonnull +70 -> 138
      //   71: ldc 62
      //   73: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   76: iconst_0
      //   77: ireturn
      //   78: astore_1
      //   79: ldc 62
      //   81: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   84: aload_1
      //   85: athrow
      //   86: astore_0
      //   87: aload_3
      //   88: aload_1
      //   89: invokestatic 94	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   92: ldc 62
      //   94: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   97: aload_0
      //   98: athrow
      //   99: aconst_null
      //   100: astore_0
      //   101: goto -56 -> 45
      //   104: aload_1
      //   105: invokevirtual 112	java/lang/Integer:intValue	()I
      //   108: bipush 6
      //   110: if_icmpne -47 -> 63
      //   113: ldc 62
      //   115: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   118: bipush 90
      //   120: ireturn
      //   121: aload_1
      //   122: invokevirtual 112	java/lang/Integer:intValue	()I
      //   125: iconst_3
      //   126: if_icmpne -59 -> 67
      //   129: ldc 62
      //   131: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   134: sipush 180
      //   137: ireturn
      //   138: aload_1
      //   139: invokevirtual 112	java/lang/Integer:intValue	()I
      //   142: bipush 8
      //   144: if_icmpne -73 -> 71
      //   147: ldc 62
      //   149: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   152: sipush 270
      //   155: ireturn
      //   156: astore_0
      //   157: aload_2
      //   158: astore_1
      //   159: goto -72 -> 87
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	162	0	paramString	String
      //   3	65	1	localInteger	Integer
      //   78	61	1	localThrowable	Throwable
      //   158	1	1	localObject1	Object
      //   1	157	2	localObject2	Object
      //   22	66	3	localCloseable	java.io.Closeable
      //   38	1	4	localx	x
      // Exception table:
      //   from	to	target	type
      //   23	40	78	java/lang/Throwable
      //   79	86	86	finally
      //   23	40	156	finally
    }
    
    public static ak aTY(String paramString)
    {
      AppMethodBeat.i(190643);
      p.h(paramString, "path");
      for (;;)
      {
        try
        {
          MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.GyY.aTV(paramString);
          if (locala == null) {
            continue;
          }
          i = locala.width;
          j = locala.height;
          l = locala.duration;
          k = locala.dYT;
          if (k == 90) {
            break label113;
          }
          if (k != 270) {
            break label110;
          }
        }
        catch (Exception paramString)
        {
          long l;
          b.printErrStackTrace(z.access$getTAG$cp(), (Throwable)paramString, "createVideoSource error", new Object[0]);
          AppMethodBeat.o(190643);
          return null;
        }
        paramString = new ak(i, j, paramString, l);
        AppMethodBeat.o(190643);
        return paramString;
        label110:
        continue;
        label113:
        int k = i;
        int i = j;
        int j = k;
      }
    }
    
    @kotlin.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2", f="SourceMaterial.kt", hxM={157}, m="invokeSuspend")
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements m<ai, kotlin.d.d<? super List<? extends ad>>, Object>
    {
      Object L$0;
      int label;
      private ai p$;
      Object pED;
      
      a(List paramList, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(190640);
        p.h(paramd, "completion");
        paramd = new a(this.Gzg, paramd);
        paramd.p$ = ((ai)paramObject);
        AppMethodBeat.o(190640);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(190641);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(190641);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(190639);
        Object localObject2 = a.SXO;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(190639);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          localObject3 = (Iterable)this.Gzg;
          localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(kotlinx.coroutines.f.a(paramObject, null, (m)new a((z)((Iterator)localObject3).next(), null), 3));
          }
          localObject1 = (List)localObject1;
          localObject3 = (Collection)localObject1;
          this.L$0 = paramObject;
          this.pED = localObject1;
          this.label = 1;
          localObject1 = kotlinx.coroutines.d.a((Collection)localObject3, this);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(190639);
            return localObject2;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        Object localObject1 = kotlin.a.j.l((Iterable)paramObject);
        paramObject = (Iterable)localObject1;
        int i = 0;
        localObject2 = paramObject.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramObject = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            kotlin.a.j.hxH();
          }
          localObject3 = (ad)paramObject;
          i = ((Number)Integer.valueOf(i)).intValue();
          paramObject = (z)this.Gzg.get(i);
          long l2;
          long l1;
          switch (((ad)localObject3).type)
          {
          default: 
            l2 = 0L;
            b.i(z.access$getTAG$cp(), "unknown track type:" + ((ad)localObject3).type);
            l1 = 0L;
          }
          for (;;)
          {
            ((ad)localObject3).KQ(0L);
            ((ad)localObject3).KR(l2);
            ((ad)localObject3).Gzz.originDuration = l1;
            ((ad)localObject3).Gzz.targetDuration = l1;
            if ((paramObject.width <= 1080) && (paramObject.height <= 1280)) {
              break label609;
            }
            float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
            ((ad)localObject3).Gzu = ((int)(paramObject.width / f));
            ((ad)localObject3).Gzv = ((int)(paramObject.height / f));
            ((ad)localObject3).Gzw = f;
            i = j;
            break;
            if (paramObject == null)
            {
              paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
              AppMethodBeat.o(190639);
              throw paramObject;
            }
            paramObject = (z)paramObject;
            if (((ak)paramObject).duration > 60000L) {}
            for (l1 = 60000L;; l1 = ((ak)paramObject).duration)
            {
              long l3 = ((ak)paramObject).duration;
              ((ad)localObject3).Gzz.type = 2;
              l2 = l1;
              l1 = l3;
              break;
            }
            if (paramObject == null)
            {
              paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
              AppMethodBeat.o(190639);
              throw paramObject;
            }
            paramObject = (z)paramObject;
            l2 = 4000L;
            ((ad)localObject3).Gzz.type = 1;
            l1 = 4000L;
          }
          label609:
          ((ad)localObject3).Gzu = paramObject.width;
          ((ad)localObject3).Gzv = paramObject.height;
          i = j;
        }
        paramObject = com.tencent.mm.videocomposition.d.Rhf;
        localObject2 = (Iterable)localObject1;
        paramObject = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramObject.add(((ad)((Iterator)localObject2).next()).GzA);
        }
        d.a.jZ((List)paramObject);
        AppMethodBeat.o(190639);
        return localObject1;
      }
      
      @kotlin.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2$requests$1$1", f="SourceMaterial.kt", hxM={156}, m="invokeSuspend")
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
      static final class a
        extends kotlin.d.b.a.j
        implements m<ai, kotlin.d.d<? super ad>, Object>
      {
        Object L$0;
        int label;
        private ai p$;
        
        a(z paramz, kotlin.d.d paramd)
        {
          super(paramd);
        }
        
        public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
        {
          AppMethodBeat.i(190637);
          p.h(paramd, "completion");
          paramd = new a(this.Gzh, paramd);
          paramd.p$ = ((ai)paramObject);
          AppMethodBeat.o(190637);
          return paramd;
        }
        
        public final Object invoke(Object paramObject1, Object paramObject2)
        {
          AppMethodBeat.i(190638);
          paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
          AppMethodBeat.o(190638);
          return paramObject1;
        }
        
        public final Object invokeSuspend(Object paramObject)
        {
          AppMethodBeat.i(190636);
          a locala = a.SXO;
          switch (this.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(190636);
            throw paramObject;
          case 0: 
            ResultKt.throwOnFailure(paramObject);
            paramObject = this.p$;
            localObject = z.Gzf;
            localObject = this.Gzh;
            this.L$0 = paramObject;
            this.label = 1;
            if ((localObject instanceof ak))
            {
              paramObject = new ad(((ak)localObject).path, 2, ((z)localObject).Gze);
              localObject = paramObject.GzA;
              i.Rhj.c((com.tencent.mm.videocomposition.d)localObject);
            }
            for (;;)
            {
              localObject = paramObject;
              if (paramObject != locala) {
                break;
              }
              AppMethodBeat.o(190636);
              return locala;
              if ((localObject instanceof r))
              {
                paramObject = new ad(((r)localObject).path, 1, ((z)localObject).Gze);
                localObject = paramObject.GzA;
                i.Rhj.c((com.tencent.mm.videocomposition.d)localObject);
              }
              else
              {
                paramObject = null;
              }
            }
          }
          ResultKt.throwOnFailure(paramObject);
          Object localObject = paramObject;
          AppMethodBeat.o(190636);
          return localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */