package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.h.b;
import d.d.a.a;
import d.d.b.a.f;
import d.g.a.m;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.ad;
import kotlinx.coroutines.cg;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"})
public class s
{
  public static final a LqE;
  private static final String TAG = "MicroMsg.SourceMaterial";
  int LqD;
  int height;
  private int type;
  int width;
  
  static
  {
    AppMethodBeat.i(200865);
    LqE = new a((byte)0);
    TAG = "MicroMsg.SourceMaterial";
    AppMethodBeat.o(200865);
  }
  
  private s(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.LqD = 0;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
  public static final class a
  {
    /* Error */
    static int aVS(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_1
      //   4: ldc 62
      //   6: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: invokestatic 74	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   13: astore_0
      //   14: aload_0
      //   15: ifnull +84 -> 99
      //   18: aload_0
      //   19: checkcast 76	java/io/Closeable
      //   22: astore_3
      //   23: new 78	android/support/d/a
      //   26: dup
      //   27: aload_3
      //   28: checkcast 80	java/io/InputStream
      //   31: invokespecial 83	android/support/d/a:<init>	(Ljava/io/InputStream;)V
      //   34: astore_0
      //   35: getstatic 89	d/y:JfV	Ld/y;
      //   38: astore 4
      //   40: aload_3
      //   41: aconst_null
      //   42: invokestatic 94	d/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   45: aload_0
      //   46: ifnull +13 -> 59
      //   49: aload_0
      //   50: ldc 96
      //   52: invokevirtual 99	android/support/d/a:l	(Ljava/lang/String;)I
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
      //   38	1	4	localy	d.y
      // Exception table:
      //   from	to	target	type
      //   23	40	78	java/lang/Throwable
      //   79	86	86	finally
      //   23	40	156	finally
    }
    
    public static ab aVT(String paramString)
    {
      AppMethodBeat.i(200864);
      k.h(paramString, "path");
      for (;;)
      {
        try
        {
          Object localObject = r.LqC;
          localObject = r.aVP(paramString);
          if (localObject == null) {
            continue;
          }
          i = ((r.a)localObject).width;
          j = ((r.a)localObject).height;
          l = ((r.a)localObject).duration;
          k = ((r.a)localObject).dwp;
          if (k == 90) {
            break label115;
          }
          if (k != 270) {
            break label112;
          }
        }
        catch (Exception paramString)
        {
          long l;
          b.printErrStackTrace(s.access$getTAG$cp(), (Throwable)paramString, "createVideoSource error", new Object[0]);
          AppMethodBeat.o(200864);
          return null;
        }
        paramString = new ab(i, j, paramString, l);
        AppMethodBeat.o(200864);
        return paramString;
        label112:
        continue;
        label115:
        int k = i;
        int i = j;
        int j = k;
      }
    }
    
    @f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2", f="SourceMaterial.kt", l={151}, m="invokeSuspend")
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends d.d.b.a.j
      implements m<ad, d.d.d<? super List<? extends y>>, Object>
    {
      int label;
      private ad mTa;
      Object mTb;
      Object nfO;
      
      a(List paramList, d.d.d paramd)
      {
        super();
      }
      
      public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
      {
        AppMethodBeat.i(200861);
        k.h(paramd, "completion");
        paramd = new a(this.LqF, paramd);
        paramd.mTa = ((ad)paramObject);
        AppMethodBeat.o(200861);
        return paramd;
      }
      
      public final Object cP(Object paramObject)
      {
        AppMethodBeat.i(200860);
        Object localObject2 = a.JgJ;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(200860);
          throw paramObject;
        case 0: 
          paramObject = this.mTa;
          localObject3 = (Iterable)this.LqF;
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(kotlinx.coroutines.d.b(paramObject, null, (m)new a((s)((Iterator)localObject3).next(), null), 3));
          }
          localObject1 = (List)localObject1;
          localObject3 = (Collection)localObject1;
          this.mTb = paramObject;
          this.nfO = localObject1;
          this.label = 1;
          localObject1 = cg.a((Collection)localObject3, this);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(200860);
            return localObject2;
          }
          break;
        }
        paramObject = (Iterable)paramObject;
        k.h(paramObject, "$this$filterNotNull");
        Object localObject1 = (List)d.a.j.a(paramObject, (Collection)new ArrayList());
        paramObject = (Iterable)localObject1;
        int i = 0;
        localObject2 = paramObject.iterator();
        long l1 = 0L;
        if (((Iterator)localObject2).hasNext())
        {
          paramObject = ((Iterator)localObject2).next();
          if (i < 0) {
            d.a.j.fvx();
          }
          localObject3 = (y)paramObject;
          int j = ((Number)Integer.valueOf(i)).intValue();
          paramObject = (s)this.LqF.get(j);
          switch (((y)localObject3).type)
          {
          default: 
            b.i(s.access$getTAG$cp(), "unknown track type:" + ((y)localObject3).type);
            label358:
            if ((paramObject.width > 1080) || (paramObject.height > 1280))
            {
              float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
              ((y)localObject3).Lrr = ((int)(paramObject.width / f));
              ((y)localObject3).Lrs = ((int)(paramObject.height / f));
              ((y)localObject3).Lrt = f;
            }
            break;
          }
          for (;;)
          {
            l1 = ((y)localObject3).cuR() + l1;
            i += 1;
            break;
            if (paramObject == null)
            {
              paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
              AppMethodBeat.o(200860);
              throw paramObject;
            }
            paramObject = (s)paramObject;
            if (((ab)paramObject).duration > 60000L) {}
            for (long l2 = 60000L;; l2 = ((ab)paramObject).duration)
            {
              ((y)localObject3).bxw = l1;
              ((y)localObject3).gnO = (l1 + l2);
              ((y)localObject3).Lro = 0L;
              ((y)localObject3).Lrp = l2;
              ((y)localObject3).Lrq = ((ab)paramObject).duration;
              ((y)localObject3).Lrv.type = 2;
              ((y)localObject3).Lrv.originDuration = ((ab)paramObject).duration;
              ((y)localObject3).Lrv.targetDuration = ((ab)paramObject).duration;
              break;
            }
            if (paramObject == null)
            {
              paramObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
              AppMethodBeat.o(200860);
              throw paramObject;
            }
            paramObject = (s)paramObject;
            ((y)localObject3).bxw = l1;
            ((y)localObject3).gnO = (4000L + l1);
            ((y)localObject3).Lro = 0L;
            ((y)localObject3).Lrp = 4000L;
            ((y)localObject3).Lrq = 4000L;
            ((y)localObject3).Lrv.type = 1;
            ((y)localObject3).Lrv.originDuration = 4000L;
            ((y)localObject3).Lrv.targetDuration = 4000L;
            break label358;
            ((y)localObject3).Lrr = paramObject.width;
            ((y)localObject3).Lrs = paramObject.height;
          }
        }
        AppMethodBeat.o(200860);
        return localObject1;
      }
      
      public final Object n(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(200862);
        paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
        AppMethodBeat.o(200862);
        return paramObject1;
      }
      
      @f(c="com.tencent.mm.plugin.vlog.model.SourceMaterial$Companion$asyncSourceToTrackList$2$requests$1$1", f="SourceMaterial.kt", l={150}, m="invokeSuspend")
      @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
      static final class a
        extends d.d.b.a.j
        implements m<ad, d.d.d<? super y>, Object>
      {
        int label;
        private ad mTa;
        Object mTb;
        
        a(s params, d.d.d paramd)
        {
          super();
        }
        
        public final d.d.d<d.y> a(Object paramObject, d.d.d<?> paramd)
        {
          AppMethodBeat.i(200858);
          k.h(paramd, "completion");
          paramd = new a(this.LqG, paramd);
          paramd.mTa = ((ad)paramObject);
          AppMethodBeat.o(200858);
          return paramd;
        }
        
        public final Object cP(Object paramObject)
        {
          AppMethodBeat.i(200857);
          a locala = a.JgJ;
          Object localObject = paramObject;
          switch (this.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(200857);
            throw paramObject;
          case 0: 
            paramObject = this.mTa;
            localObject = s.LqE;
            localObject = this.LqG;
            this.mTb = paramObject;
            this.label = 1;
            if ((localObject instanceof ab)) {
              paramObject = new y(((ab)localObject).path, 2, ((s)localObject).LqD);
            }
            for (;;)
            {
              localObject = paramObject;
              if (paramObject != locala) {
                break;
              }
              AppMethodBeat.o(200857);
              return locala;
              if ((localObject instanceof o)) {
                paramObject = new y(((o)localObject).path, 1, ((s)localObject).LqD);
              } else {
                paramObject = null;
              }
            }
          }
          AppMethodBeat.o(200857);
          return localObject;
        }
        
        public final Object n(Object paramObject1, Object paramObject2)
        {
          AppMethodBeat.i(200859);
          paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cP(d.y.JfV);
          AppMethodBeat.o(200859);
          return paramObject1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.s
 * JD-Core Version:    0.7.0.1
 */