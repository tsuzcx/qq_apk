package com.tencent.mm.plugin.vlog.model;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.b.a;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ay;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "", "width", "", "height", "type", "fromCamera", "(IIII)V", "getFromCamera", "()I", "setFromCamera", "(I)V", "getHeight", "setHeight", "getType", "setType", "getWidth", "setWidth", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public class z
{
  private static final String TAG;
  public static final a Uai;
  int Uaj;
  int height;
  private int type;
  int width;
  
  static
  {
    AppMethodBeat.i(283543);
    Uai = new a((byte)0);
    TAG = "MicroMsg.SourceMaterial";
    AppMethodBeat.o(283543);
  }
  
  private z(int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.type = paramInt3;
    this.Uaj = 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/SourceMaterial$Companion;", "", "()V", "CropMinDuration", "", "ImageSourceDuration", "MaxHeight", "", "MaxWidth", "TAG", "", "TypeImage", "TypeVideo", "VideoTrackMaxDuration", "asyncSourceToTrackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "sources", "Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createFromPath", "paths", "types", "sourceFrom", "images", "videos", "indices", "", "createImageSource", "Lcom/tencent/mm/plugin/vlog/model/ImageSource;", "path", "createVideoSource", "Lcom/tencent/mm/plugin/vlog/model/VideoSource;", "getImageRotate", "sourceToTrack", "source", "(Lcom/tencent/mm/plugin/vlog/model/SourceMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static Object b(List<? extends z> paramList, d<? super List<ad>> paramd)
    {
      AppMethodBeat.i(283769);
      paramList = l.a((f)bg.kCi(), (m)new a(paramList, null), paramd);
      AppMethodBeat.o(283769);
      return paramList;
    }
    
    private static r bfb(String paramString)
    {
      AppMethodBeat.i(283748);
      s.u(paramString, "path");
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeFile(paramString, localOptions);
      int k = bfc(paramString);
      int j = localOptions.outWidth;
      int i = localOptions.outHeight;
      switch (k)
      {
      }
      for (;;)
      {
        paramString = new r(j, i, paramString);
        AppMethodBeat.o(283748);
        return paramString;
        j = localOptions.outHeight;
        i = localOptions.outWidth;
      }
    }
    
    private static int bfc(String paramString)
    {
      AppMethodBeat.i(283757);
      paramString = y.Lh(paramString);
      Closeable localCloseable;
      if (paramString != null) {
        localCloseable = (Closeable)paramString;
      }
      label134:
      for (;;)
      {
        try
        {
          paramString = new androidx.f.a.a((InputStream)localCloseable);
          ah localah = ah.aiuX;
          kotlin.f.b.a(localCloseable, null);
          if (paramString != null) {
            continue;
          }
          paramString = null;
        }
        finally
        {
          try
          {
            AppMethodBeat.o(283757);
            throw paramString;
          }
          finally
          {
            kotlin.f.b.a(localCloseable, paramString);
            AppMethodBeat.o(283757);
          }
          paramString = Integer.valueOf(paramString.k("Orientation", 1));
          continue;
          if (paramString.intValue() != 6) {
            continue;
          }
          AppMethodBeat.o(283757);
          return 90;
        }
        if (paramString == null)
        {
          if (paramString != null) {
            break label117;
          }
          if (paramString != null) {
            break label134;
          }
          AppMethodBeat.o(283757);
          return 0;
        }
        label117:
        if (paramString.intValue() == 3)
        {
          AppMethodBeat.o(283757);
          return 180;
          if (paramString.intValue() == 8)
          {
            AppMethodBeat.o(283757);
            return 270;
            paramString = null;
          }
        }
      }
    }
    
    private static al bfd(String paramString)
    {
      AppMethodBeat.i(283763);
      s.u(paramString, "path");
      for (;;)
      {
        int k;
        try
        {
          MultiMediaVideoChecker.a locala = MultiMediaVideoChecker.ObB.aTG(paramString);
          if (locala == null) {
            continue;
          }
          i = locala.width;
          k = locala.height;
          long l = locala.duration;
          switch (locala.hYK)
          {
          case 90: 
            paramString = new al(i, j, paramString, l);
            AppMethodBeat.o(283763);
            return paramString;
          }
        }
        catch (Exception paramString)
        {
          int i;
          com.tencent.mm.audio.mix.h.b.printErrStackTrace(z.access$getTAG$cp(), (Throwable)paramString, "createVideoSource error", new Object[0]);
          AppMethodBeat.o(283763);
          return null;
        }
        int j = i;
        i = k;
        continue;
        j = k;
      }
    }
    
    public static List<z> e(List<String> paramList, List<Integer> paramList1, List<Integer> paramList2)
    {
      AppMethodBeat.i(283743);
      s.u(paramList, "paths");
      s.u(paramList1, "types");
      s.u(paramList2, "sourceFrom");
      LinkedList localLinkedList = new LinkedList();
      paramList = ((Iterable)paramList).iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject1 = paramList.next();
        int j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        localObject1 = (String)localObject1;
        Object localObject2 = (Integer)p.ae(paramList1, i);
        if (localObject2 == null)
        {
          label95:
          localObject2 = z.Uai;
          localObject1 = bfb((String)localObject1);
          if (localObject1 != null)
          {
            ((z)localObject1).Uaj = ((Number)paramList2.get(i)).intValue();
            localLinkedList.add(localObject1);
          }
        }
        do
        {
          i = j;
          break;
          if (((Integer)localObject2).intValue() != 2) {
            break label95;
          }
          localObject2 = z.Uai;
          localObject1 = bfd((String)localObject1);
        } while (localObject1 == null);
        ((z)localObject1).Uaj = ((Number)paramList2.get(i)).intValue();
        localLinkedList.add(localObject1);
        i = j;
      }
      paramList = (List)localLinkedList;
      AppMethodBeat.o(283743);
      return paramList;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends k
      implements m<aq, d<? super List<? extends ad>>, Object>
    {
      int label;
      
      a(List<? extends z> paramList, d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final d<ah> create(Object paramObject, d<?> paramd)
      {
        AppMethodBeat.i(283399);
        paramd = new a(this.Uak, paramd);
        paramd.L$0 = paramObject;
        paramObject = (d)paramd;
        AppMethodBeat.o(283399);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(283385);
        Object localObject2 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(283385);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (aq)this.L$0;
          localObject3 = (Iterable)this.Uak;
          localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((Collection)localObject1).add(j.a(paramObject, null, (m)new a((z)((Iterator)localObject3).next(), null), 3));
          }
          localObject1 = (Collection)localObject1;
          paramObject = (d)this;
          this.label = 1;
          if (((Collection)localObject1).isEmpty()) {}
          for (paramObject = (List)ab.aivy;; paramObject = new kotlinx.coroutines.e((ay[])localObject1).e(paramObject))
          {
            localObject1 = paramObject;
            if (paramObject != localObject2) {
              break;
            }
            AppMethodBeat.o(283385);
            return localObject2;
            localObject1 = ((Collection)localObject1).toArray(new ay[0]);
            if (localObject1 == null)
            {
              paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
              AppMethodBeat.o(283385);
              throw paramObject;
            }
          }
        }
        ResultKt.throwOnFailure(paramObject);
        Object localObject1 = paramObject;
        localObject1 = p.l((Iterable)localObject1);
        paramObject = (Iterable)localObject1;
        localObject2 = this.Uak;
        int i = 0;
        Object localObject3 = paramObject.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          paramObject = ((Iterator)localObject3).next();
          int j = i + 1;
          if (i < 0) {
            p.kkW();
          }
          ad localad = (ad)paramObject;
          paramObject = (z)((List)localObject2).get(i);
          long l2;
          long l1;
          switch (localad.type)
          {
          default: 
            l2 = 0L;
            com.tencent.mm.audio.mix.h.b.i(z.access$getTAG$cp(), s.X("unknown track type:", Integer.valueOf(localad.type)));
            l1 = 0L;
          }
          for (;;)
          {
            localad.wB(0L);
            localad.wC(l2);
            localad.UaH.originDuration = l1;
            localad.UaH.targetDuration = l1;
            if ((paramObject.width <= 1080) && (paramObject.height <= 1280)) {
              break label610;
            }
            float f = Math.max(paramObject.width * 1.0F / 1080.0F, paramObject.height * 1.0F / 1280.0F);
            localad.UaC = ((int)(paramObject.width / f));
            localad.UaD = ((int)(paramObject.height / f));
            localad.UaE = f;
            i = j;
            break;
            paramObject = (z)paramObject;
            if (((al)paramObject).duration > 60000L) {}
            for (l1 = 60000L;; l1 = ((al)paramObject).duration)
            {
              long l3 = ((al)paramObject).duration;
              localad.UaH.type = 2;
              l2 = l1;
              l1 = l3;
              break;
            }
            paramObject = (z)paramObject;
            l2 = 4000L;
            localad.UaH.type = 1;
            l1 = 4000L;
          }
          label610:
          localad.UaC = paramObject.width;
          localad.UaD = paramObject.height;
          i = j;
        }
        paramObject = com.tencent.mm.videocomposition.b.agDF;
        localObject2 = (Iterable)localObject1;
        paramObject = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramObject.add(((ad)((Iterator)localObject2).next()).UaI);
        }
        b.a.lS((List)paramObject);
        AppMethodBeat.o(283385);
        return localObject1;
      }
      
      @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends k
        implements m<aq, d<? super ad>, Object>
      {
        int label;
        
        a(z paramz, d<? super a> paramd)
        {
          super(paramd);
        }
        
        public final d<ah> create(Object paramObject, d<?> paramd)
        {
          AppMethodBeat.i(283546);
          paramObject = (d)new a(this.Ual, paramd);
          AppMethodBeat.o(283546);
          return paramObject;
        }
        
        public final Object invokeSuspend(Object paramObject)
        {
          AppMethodBeat.i(283535);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(283535);
            throw paramObject;
          case 0: 
            ResultKt.throwOnFailure(paramObject);
            paramObject = z.Uai;
            paramObject = this.Ual;
            this.label = 1;
            if ((paramObject instanceof al))
            {
              paramObject = new ad(((al)paramObject).path, 2, paramObject.Uaj);
              localObject = paramObject.UaI;
              com.tencent.mm.videocomposition.e.agDJ.e((com.tencent.mm.videocomposition.b)localObject);
            }
            for (;;)
            {
              localObject = paramObject;
              if (paramObject != locala) {
                break;
              }
              AppMethodBeat.o(283535);
              return locala;
              if ((paramObject instanceof r))
              {
                paramObject = new ad(((r)paramObject).path, 1, paramObject.Uaj);
                localObject = paramObject.UaI;
                com.tencent.mm.videocomposition.e.agDJ.e((com.tencent.mm.videocomposition.b)localObject);
              }
              else
              {
                paramObject = null;
              }
            }
          }
          ResultKt.throwOnFailure(paramObject);
          Object localObject = paramObject;
          AppMethodBeat.o(283535);
          return localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.z
 * JD-Core Version:    0.7.0.1
 */