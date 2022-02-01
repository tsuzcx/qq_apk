package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.videocomposition.b.a;
import com.tencent.mm.videocomposition.e;
import d.d.a.a;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ah;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"})
public class s
{
  public static final a BXA;
  private static final String TAG = "MicroMsg.SourceMaterial";
  int BXz;
  int height;
  private int type;
  int width;
  
  static
  {
    AppMethodBeat.i(191214);
    BXA = new a((byte)0);
    TAG = "MicroMsg.SourceMaterial";
    AppMethodBeat.o(191214);
  }
  
  private s(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.BXz = 0;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
  public static final class a
  {
    /* Error */
    static int aEF(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_1
      //   4: ldc 62
      //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: invokestatic 74	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
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
      //   35: getstatic 89	d/z:Nhr	Ld/z;
      //   38: astore 4
      //   40: aload_3
      //   41: aconst_null
      //   42: invokestatic 94	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
      //   89: invokestatic 94	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
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
      //   38	1	4	localz	z
      // Exception table:
      //   from	to	target	type
      //   23	40	78	java/lang/Throwable
      //   79	86	86	finally
      //   23	40	156	finally
    }
    
    public static ac aEG(String paramString)
    {
      AppMethodBeat.i(191213);
      p.h(paramString, "path");
      for (;;)
      {
        try
        {
          MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.BXt.aED(paramString);
          if (locala == null) {
            continue;
          }
          i = locala.width;
          j = locala.height;
          l = locala.duration;
          k = locala.dHi;
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
          com.tencent.mm.audio.mix.h.b.printErrStackTrace(s.access$getTAG$cp(), (Throwable)paramString, "createVideoSource error", new Object[0]);
          AppMethodBeat.o(191213);
          return null;
        }
        paramString = new ac(i, j, paramString, l);
        AppMethodBeat.o(191213);
        return paramString;
        label110:
        continue;
        label113:
        int k = i;
        int i = j;
        int j = k;
      }
    }
    
    @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2", f="SourceMaterial.kt", gkn={157}, m="invokeSuspend")
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends d.d.b.a.j
      implements m<ah, d.d.d<? super List<? extends w>>, Object>
    {
      int label;
      Object ocA;
      private ah ocz;
      Object oqW;
      
      a(List paramList, d.d.d paramd)
      {
        super();
      }
      
      public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(191210);
        p.h(paramd, "completion");
        paramd = new a(this.BXB, paramd);
        paramd.ocz = ((ah)paramObject);
        AppMethodBeat.o(191210);
        return paramd;
      }
      
      public final Object cR(Object paramObject)
      {
        AppMethodBeat.i(191209);
        Object localObject2 = a.Nif;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(191209);
          throw paramObject;
        case 0: 
          paramObject = this.ocz;
          localObject3 = (Iterable)this.BXB;
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(kotlinx.coroutines.f.a(paramObject, null, (m)new a((s)((Iterator)localObject3).next(), null), 3));
          }
          localObject1 = (List)localObject1;
          localObject3 = (Collection)localObject1;
          this.ocA = paramObject;
          this.oqW = localObject1;
          this.label = 1;
          localObject1 = kotlinx.coroutines.d.a((Collection)localObject3, this);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(191209);
            return localObject2;
          }
          break;
        }
        paramObject = (Iterable)paramObject;
        p.h(paramObject, "$this$filterNotNull");
        Object localObject1 = (List)d.a.j.a(paramObject, (Collection)new ArrayList());
        paramObject = (Iterable)localObject1;
        int i = 0;
        localObject2 = paramObject.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramObject = ((Iterator)localObject2).next();
          int j = i + 1;
          if (i < 0) {
            d.a.j.gkd();
          }
          localObject3 = (w)paramObject;
          i = ((Number)Integer.valueOf(i)).intValue();
          paramObject = (s)this.BXB.get(i);
          long l2;
          long l1;
          switch (((w)localObject3).type)
          {
          default: 
            l2 = 0L;
            com.tencent.mm.audio.mix.h.b.i(s.access$getTAG$cp(), "unknown track type:" + ((w)localObject3).type);
            l1 = 0L;
          }
          for (;;)
          {
            ((w)localObject3).BI(0L);
            ((w)localObject3).BJ(l2);
            ((w)localObject3).BXU.originDuration = l1;
            ((w)localObject3).BXU.targetDuration = l1;
            if ((paramObject.width <= 1080) && (paramObject.height <= 1280)) {
              break label620;
            }
            float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
            ((w)localObject3).BXQ = ((int)(paramObject.width / f));
            ((w)localObject3).BXR = ((int)(paramObject.height / f));
            ((w)localObject3).BXS = f;
            i = j;
            break;
            if (paramObject == null)
            {
              paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
              AppMethodBeat.o(191209);
              throw paramObject;
            }
            paramObject = (s)paramObject;
            if (((ac)paramObject).duration > 60000L) {}
            for (l1 = 60000L;; l1 = ((ac)paramObject).duration)
            {
              long l3 = ((ac)paramObject).duration;
              ((w)localObject3).BXU.type = 2;
              l2 = l1;
              l1 = l3;
              break;
            }
            if (paramObject == null)
            {
              paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
              AppMethodBeat.o(191209);
              throw paramObject;
            }
            paramObject = (s)paramObject;
            l2 = 4000L;
            ((w)localObject3).BXU.type = 1;
            l1 = 4000L;
          }
          label620:
          ((w)localObject3).BXQ = paramObject.width;
          ((w)localObject3).BXR = paramObject.height;
          i = j;
        }
        paramObject = com.tencent.mm.videocomposition.b.LJo;
        localObject2 = (Iterable)localObject1;
        paramObject = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramObject.add(((w)((Iterator)localObject2).next()).BXV);
        }
        b.a.iW((List)paramObject);
        AppMethodBeat.o(191209);
        return localObject1;
      }
      
      public final Object p(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(191211);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cR(z.Nhr);
        AppMethodBeat.o(191211);
        return paramObject1;
      }
      
      @d.d.b.a.f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2$requests$1$1", f="SourceMaterial.kt", gkn={156}, m="invokeSuspend")
      @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
      static final class a
        extends d.d.b.a.j
        implements m<ah, d.d.d<? super w>, Object>
      {
        int label;
        Object ocA;
        private ah ocz;
        
        a(s params, d.d.d paramd)
        {
          super();
        }
        
        public final d.d.d<z> a(Object paramObject, d.d.d<?> paramd)
        {
          AppMethodBeat.i(191207);
          p.h(paramd, "completion");
          paramd = new a(this.BXC, paramd);
          paramd.ocz = ((ah)paramObject);
          AppMethodBeat.o(191207);
          return paramd;
        }
        
        public final Object cR(Object paramObject)
        {
          AppMethodBeat.i(191206);
          a locala = a.Nif;
          Object localObject = paramObject;
          switch (this.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(191206);
            throw paramObject;
          case 0: 
            paramObject = this.ocz;
            localObject = s.BXA;
            localObject = this.BXC;
            this.ocA = paramObject;
            this.label = 1;
            if ((localObject instanceof ac))
            {
              paramObject = new w(((ac)localObject).path, 2, ((s)localObject).BXz);
              localObject = paramObject.BXV;
              e.LJs.b((com.tencent.mm.videocomposition.b)localObject);
            }
            for (;;)
            {
              localObject = paramObject;
              if (paramObject != locala) {
                break;
              }
              AppMethodBeat.o(191206);
              return locala;
              if ((localObject instanceof k))
              {
                paramObject = new w(((k)localObject).path, 1, ((s)localObject).BXz);
                localObject = paramObject.BXV;
                e.LJs.b((com.tencent.mm.videocomposition.b)localObject);
              }
              else
              {
                paramObject = null;
              }
            }
          }
          AppMethodBeat.o(191206);
          return localObject;
        }
        
        public final Object p(Object paramObject1, Object paramObject2)
        {
          AppMethodBeat.i(191208);
          paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cR(z.Nhr);
          AppMethodBeat.o(191208);
          return paramObject1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.s
 * JD-Core Version:    0.7.0.1
 */