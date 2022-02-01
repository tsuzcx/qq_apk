package com.tencent.mm.plugin.vlog.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.videocomposition.b.a;
import com.tencent.mm.videocomposition.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.g;
import kotlinx.coroutines.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"})
public class z
{
  public static final a NmH;
  private static final String TAG = "MicroMsg.SourceMaterial";
  int NmG;
  int height;
  private int type;
  int width;
  
  static
  {
    AppMethodBeat.i(252087);
    NmH = new a((byte)0);
    TAG = "MicroMsg.SourceMaterial";
    AppMethodBeat.o(252087);
  }
  
  private z(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.NmG = 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"})
  public static final class a
  {
    public static Object a(List<? extends z> paramList, kotlin.d.d<? super List<ad>> paramd)
    {
      AppMethodBeat.i(245695);
      paramList = i.a((f)bc.iRs(), (m)new a(paramList, null), paramd);
      AppMethodBeat.o(245695);
      return paramList;
    }
    
    private static r bfu(String paramString)
    {
      AppMethodBeat.i(245692);
      p.k(paramString, "path");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(paramString, localOptions);
      int k = bfv(paramString);
      int j = localOptions.outWidth;
      int i = localOptions.outHeight;
      if ((k == 90) || (k == 270))
      {
        j = localOptions.outHeight;
        i = localOptions.outWidth;
      }
      paramString = new r(j, i, paramString);
      AppMethodBeat.o(245692);
      return paramString;
    }
    
    /* Error */
    private static int bfv(String paramString)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_2
      //   2: aconst_null
      //   3: astore_1
      //   4: ldc 130
      //   6: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: invokestatic 136	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
      //   13: astore_0
      //   14: aload_0
      //   15: ifnull +85 -> 100
      //   18: aload_0
      //   19: checkcast 138	java/io/Closeable
      //   22: astore_3
      //   23: new 140	androidx/e/a/a
      //   26: dup
      //   27: aload_3
      //   28: checkcast 142	java/io/InputStream
      //   31: invokespecial 145	androidx/e/a/a:<init>	(Ljava/io/InputStream;)V
      //   34: astore_0
      //   35: getstatic 151	kotlin/x:aazN	Lkotlin/x;
      //   38: astore 4
      //   40: aload_3
      //   41: aconst_null
      //   42: invokestatic 156	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   45: aload_0
      //   46: ifnull +14 -> 60
      //   49: aload_0
      //   50: ldc 158
      //   52: iconst_1
      //   53: invokevirtual 161	androidx/e/a/a:i	(Ljava/lang/String;I)I
      //   56: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   59: astore_1
      //   60: aload_1
      //   61: ifnonnull +44 -> 105
      //   64: aload_1
      //   65: ifnonnull +57 -> 122
      //   68: aload_1
      //   69: ifnonnull +70 -> 139
      //   72: ldc 130
      //   74: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   77: iconst_0
      //   78: ireturn
      //   79: astore_1
      //   80: ldc 130
      //   82: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   85: aload_1
      //   86: athrow
      //   87: astore_0
      //   88: aload_3
      //   89: aload_1
      //   90: invokestatic 156	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
      //   93: ldc 130
      //   95: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   98: aload_0
      //   99: athrow
      //   100: aconst_null
      //   101: astore_0
      //   102: goto -57 -> 45
      //   105: aload_1
      //   106: invokevirtual 171	java/lang/Integer:intValue	()I
      //   109: bipush 6
      //   111: if_icmpne -47 -> 64
      //   114: ldc 130
      //   116: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   119: bipush 90
      //   121: ireturn
      //   122: aload_1
      //   123: invokevirtual 171	java/lang/Integer:intValue	()I
      //   126: iconst_3
      //   127: if_icmpne -59 -> 68
      //   130: ldc 130
      //   132: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   135: sipush 180
      //   138: ireturn
      //   139: aload_1
      //   140: invokevirtual 171	java/lang/Integer:intValue	()I
      //   143: bipush 8
      //   145: if_icmpne -73 -> 72
      //   148: ldc 130
      //   150: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   153: sipush 270
      //   156: ireturn
      //   157: astore_0
      //   158: aload_2
      //   159: astore_1
      //   160: goto -72 -> 88
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	paramString	String
      //   3	66	1	localInteger	Integer
      //   79	61	1	localThrowable	Throwable
      //   159	1	1	localObject1	Object
      //   1	158	2	localObject2	Object
      //   22	67	3	localCloseable	java.io.Closeable
      //   38	1	4	localx	x
      // Exception table:
      //   from	to	target	type
      //   23	40	79	java/lang/Throwable
      //   80	87	87	finally
      //   23	40	157	finally
    }
    
    private static ak bfw(String paramString)
    {
      AppMethodBeat.i(245694);
      p.k(paramString, "path");
      for (;;)
      {
        try
        {
          MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.NmA.bfs(paramString);
          if (locala == null) {
            continue;
          }
          i = locala.width;
          j = locala.height;
          l = locala.duration;
          k = locala.fSM;
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
          com.tencent.mm.audio.mix.h.b.printErrStackTrace(z.access$getTAG$cp(), (Throwable)paramString, "createVideoSource error", new Object[0]);
          AppMethodBeat.o(245694);
          return null;
        }
        paramString = new ak(i, j, paramString, l);
        AppMethodBeat.o(245694);
        return paramString;
        label110:
        continue;
        label113:
        int k = i;
        int i = j;
        int j = k;
      }
    }
    
    public static List<z> e(List<String> paramList, List<Integer> paramList1, List<Integer> paramList2)
    {
      AppMethodBeat.i(245691);
      p.k(paramList, "paths");
      p.k(paramList1, "types");
      p.k(paramList2, "sourceFrom");
      LinkedList localLinkedList = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject1 = paramList.next();
        int j = i + 1;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject1 = (String)localObject1;
        Object localObject2 = (Integer)kotlin.a.j.M(paramList1, i);
        if (localObject2 == null) {}
        while (((Integer)localObject2).intValue() != 2)
        {
          localObject2 = z.NmH;
          localObject1 = bfu((String)localObject1);
          ((z)localObject1).NmG = ((Number)paramList2.get(i)).intValue();
          localLinkedList.add(localObject1);
          i = j;
          break;
        }
        localObject2 = z.NmH;
        localObject1 = bfw((String)localObject1);
        if (localObject1 != null)
        {
          ((z)localObject1).NmG = ((Number)paramList2.get(i)).intValue();
          localLinkedList.add(localObject1);
          i = j;
        }
        else
        {
          i = j;
        }
      }
      paramList = (List)localLinkedList;
      AppMethodBeat.o(245691);
      return paramList;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements m<kotlinx.coroutines.ak, kotlin.d.d<? super List<? extends ad>>, Object>
    {
      Object L$0;
      int label;
      Object oDA;
      private kotlinx.coroutines.ak p$;
      
      a(List paramList, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(246082);
        p.k(paramd, "completion");
        paramd = new a(this.NmI, paramd);
        paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
        AppMethodBeat.o(246082);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(246084);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(246084);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(246078);
        Object localObject2 = a.aaAA;
        Object localObject3;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(246078);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = this.p$;
          localObject3 = (Iterable)this.NmI;
          localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(g.a(paramObject, null, (m)new a((z)((Iterator)localObject3).next(), null), 3));
          }
          localObject1 = (List)localObject1;
          localObject3 = (Collection)localObject1;
          this.L$0 = paramObject;
          this.oDA = localObject1;
          this.label = 1;
          localObject1 = kotlinx.coroutines.d.a((Collection)localObject3, this);
          paramObject = localObject1;
          if (localObject1 == localObject2)
          {
            AppMethodBeat.o(246078);
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
            kotlin.a.j.iBO();
          }
          localObject3 = (ad)paramObject;
          i = ((Number)Integer.valueOf(i)).intValue();
          paramObject = (z)this.NmI.get(i);
          long l2;
          long l1;
          switch (((ad)localObject3).type)
          {
          default: 
            l2 = 0L;
            com.tencent.mm.audio.mix.h.b.i(z.access$getTAG$cp(), "unknown track type:" + ((ad)localObject3).type);
            l1 = 0L;
          }
          for (;;)
          {
            ((ad)localObject3).Sn(0L);
            ((ad)localObject3).So(l2);
            ((ad)localObject3).Nnf.originDuration = l1;
            ((ad)localObject3).Nnf.targetDuration = l1;
            if ((paramObject.width <= 1080) && (paramObject.height <= 1280)) {
              break label609;
            }
            float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
            ((ad)localObject3).Nna = ((int)(paramObject.width / f));
            ((ad)localObject3).Nnb = ((int)(paramObject.height / f));
            ((ad)localObject3).Nnc = f;
            i = j;
            break;
            if (paramObject == null)
            {
              paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.VideoSource");
              AppMethodBeat.o(246078);
              throw paramObject;
            }
            paramObject = (z)paramObject;
            if (((ak)paramObject).duration > 60000L) {}
            for (l1 = 60000L;; l1 = ((ak)paramObject).duration)
            {
              long l3 = ((ak)paramObject).duration;
              ((ad)localObject3).Nnf.type = 2;
              l2 = l1;
              l1 = l3;
              break;
            }
            if (paramObject == null)
            {
              paramObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.vlog.model.ImageSource");
              AppMethodBeat.o(246078);
              throw paramObject;
            }
            paramObject = (z)paramObject;
            l2 = 4000L;
            ((ad)localObject3).Nnf.type = 1;
            l1 = 4000L;
          }
          label609:
          ((ad)localObject3).Nna = paramObject.width;
          ((ad)localObject3).Nnb = paramObject.height;
          i = j;
        }
        paramObject = com.tencent.mm.videocomposition.b.YHY;
        localObject2 = (Iterable)localObject1;
        paramObject = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramObject.add(((ad)((Iterator)localObject2).next()).Nng);
        }
        b.a.iK((List)paramObject);
        AppMethodBeat.o(246078);
        return localObject1;
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
      static final class a
        extends kotlin.d.b.a.j
        implements m<kotlinx.coroutines.ak, kotlin.d.d<? super ad>, Object>
      {
        Object L$0;
        int label;
        private kotlinx.coroutines.ak p$;
        
        a(z paramz, kotlin.d.d paramd)
        {
          super(paramd);
        }
        
        public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
        {
          AppMethodBeat.i(235207);
          p.k(paramd, "completion");
          paramd = new a(this.NmJ, paramd);
          paramd.p$ = ((kotlinx.coroutines.ak)paramObject);
          AppMethodBeat.o(235207);
          return paramd;
        }
        
        public final Object invoke(Object paramObject1, Object paramObject2)
        {
          AppMethodBeat.i(235208);
          paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
          AppMethodBeat.o(235208);
          return paramObject1;
        }
        
        public final Object invokeSuspend(Object paramObject)
        {
          AppMethodBeat.i(235205);
          a locala = a.aaAA;
          switch (this.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(235205);
            throw paramObject;
          case 0: 
            ResultKt.throwOnFailure(paramObject);
            paramObject = this.p$;
            localObject = z.NmH;
            localObject = this.NmJ;
            this.L$0 = paramObject;
            this.label = 1;
            if ((localObject instanceof ak))
            {
              paramObject = new ad(((ak)localObject).path, 2, ((z)localObject).NmG);
              localObject = paramObject.Nng;
              e.YIc.e((com.tencent.mm.videocomposition.b)localObject);
            }
            for (;;)
            {
              localObject = paramObject;
              if (paramObject != locala) {
                break;
              }
              AppMethodBeat.o(235205);
              return locala;
              if ((localObject instanceof r))
              {
                paramObject = new ad(((r)localObject).path, 1, ((z)localObject).NmG);
                localObject = paramObject.Nng;
                e.YIc.e((com.tencent.mm.videocomposition.b)localObject);
              }
              else
              {
                paramObject = null;
              }
            }
          }
          ResultKt.throwOnFailure(paramObject);
          Object localObject = paramObject;
          AppMethodBeat.o(235205);
          return localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */