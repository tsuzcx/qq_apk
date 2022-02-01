package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQMusicCacheCleanupFileSystem
  extends AbstractFileSystem
{
  public static final Parcelable.Creator<QQMusicCacheCleanupFileSystem> CREATOR;
  protected final FileSystem agvG;
  
  static
  {
    AppMethodBeat.i(238420);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(238420);
  }
  
  protected QQMusicCacheCleanupFileSystem(Parcel paramParcel)
  {
    AppMethodBeat.i(238415);
    ah.a(paramParcel, QQMusicCacheCleanupFileSystem.class, 1);
    this.agvG = ((FileSystem)paramParcel.readParcelable(QQMusicCacheCleanupFileSystem.class.getClassLoader()));
    AppMethodBeat.o(238415);
  }
  
  public QQMusicCacheCleanupFileSystem(FileSystem paramFileSystem)
  {
    this.agvG = paramFileSystem;
  }
  
  public String toString()
  {
    AppMethodBeat.i(238429);
    String str = "QQMusicCacheGC [" + this.agvG.toString() + ']';
    AppMethodBeat.o(238429);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(238425);
    ah.b(paramParcel, QQMusicCacheCleanupFileSystem.class, 1);
    paramParcel.writeParcelable(this.agvG, paramInt);
    AppMethodBeat.o(238425);
  }
  
  public static final class a
    implements s.a
  {
    public final void a(String paramString, FileSystem paramFileSystem, int paramInt, Map<String, Object> paramMap)
    {
      AppMethodBeat.i(238115);
      com.tencent.mm.plugin.report.f.Ozc.b(22046, new Object[] { paramString, paramMap.get("deletedFiles"), paramMap.get("deletedSize"), paramMap.get("keptFiles"), paramMap.get("keptSize"), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(-1), Integer.valueOf(-1) });
      AppMethodBeat.o(238115);
    }
  }
  
  protected final class b
    extends f
  {
    protected final FileSystem.b agwv;
    protected final List<FileSystem.b> agxd;
    
    protected b(FileSystem.b paramb)
    {
      AppMethodBeat.i(238112);
      this.agwv = paramb;
      this.agxd = Collections.singletonList(paramb);
      AppMethodBeat.o(238112);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238120);
      long l1 = ah.bEx("qq-music-cache-clean");
      if (l1 < 1209600000L) {
        Log.i("VFS.QQMusicCacheCleanupFileSystem", "Image cleanup interval not match, skip cleanup. %d / %d", new Object[] { Long.valueOf(l1), Long.valueOf(1209600000L) });
      }
      for (;;)
      {
        paramCancellationSignal.throwIfCanceled();
        super.a(paramCancellationSignal);
        AppMethodBeat.o(238120);
        return;
        int i = 0;
        long l2 = 0L;
        l1 = 0L;
        Object localObject2 = bDW("");
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Collections.emptyList();
        }
        localObject2 = Pattern.compile("mediaHttpCommonPlayer[0-9]+tmp");
        localObject1 = ((Iterable)localObject1).iterator();
        int j = 0;
        while (((Iterator)localObject1).hasNext())
        {
          j localj = (j)((Iterator)localObject1).next();
          if (!localj.agxh)
          {
            if (((Pattern)localObject2).matcher(localj.name).matches())
            {
              localj.NP(true);
              i += 1;
              l2 += localj.agxf;
            }
            for (;;)
            {
              paramCancellationSignal.throwIfCanceled();
              break;
              j += 1;
              l1 = localj.agxf + l1;
            }
          }
        }
        Log.i("VFS.QQMusicCacheCleanupFileSystem", " > deletedFiles: %d, deletedSize: %d\n > keptFiles: %d, keptSize: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j), Long.valueOf(l1) });
        QQMusicCacheCleanupFileSystem.this.l(2, new Object[] { "deletedFiles", Integer.valueOf(i), "deletedSize", Long.valueOf(l2), "keptFiles", Integer.valueOf(j), "keptSize", Long.valueOf(l1) });
        ah.bEw("qq-music-cache-clean");
      }
    }
    
    public final FileSystem jKa()
    {
      return QQMusicCacheCleanupFileSystem.this;
    }
    
    public final List<FileSystem.b> jKf()
    {
      return this.agxd;
    }
    
    public final FileSystem.b jk(String paramString, int paramInt)
    {
      return this.agwv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.QQMusicCacheCleanupFileSystem
 * JD-Core Version:    0.7.0.1
 */