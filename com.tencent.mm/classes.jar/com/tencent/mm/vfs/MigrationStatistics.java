package com.tencent.mm.vfs;

import android.os.CancellationSignal;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.vfs.a.a;
import com.tencent.mm.vfs.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

final class MigrationStatistics
{
  private static final String[] agyh = { "Download", "attachment", "image", "image2", "record", "video", "voice2" };
  private static final String[] agyi = { ".planCache", "CheckResUpdate_1", "CronetCache", "configlist", "jscache", "jsengine", "surface", "mmslot", "tmpScanLicense", "webservice", "CDNTemp", "test_writable", "xlogtest_writable", ".planCache", ".tmp", "AudioRecord", "CDNTemp", "CheckResUpdate", "CheckResUpdate_1", "ClickFlow", "CronetCache", "Diagnostic", "Download", "FailMsgFileCache", "Game", "Handler", "ProcessDetector", "SQLTrace", "ThumbVideoCache", "WebCanvasPkg", "WebviewCache", "appbrand", "avatar", "browser", "card", "configlist", "crash", "diskcache", "download", "egg_spring", "exdevice", "facedir", "fts", "game", "hbstoryvideo", "hilive", "imagecache", "jscache", "jsengine", "surface", "last_avatar_dir", "mail", "mapsdk", "mmslot", "music", "recovery", "regioncode", "taxi_icon", "temp_video_cache", "test_writable", "tmpScanLicense", "trace", "video", "vusericon", "wagamefiles", "wallet", "wallet", "wallet_images", "webcompt", "webservice", "webview_tmpl", "wenote", "wepkg", "wvtemp", "wxacache", "wxafiles", "wxanewfiles", "wxauto", "wxvideocache", "wxvideotmp", "xlog", "xlogtest_writable" };
  private static final String[] agyj = { "LuckyMoney", "ProcessDetect", "appbrand", "audio", "bizimg", "bizmsg", "boots", "cdn", "dbback", "draft", "emoji", "favoffline", "favorite", "game", "live", "mailapp", "multitask", "music", "normsg", "oneday", "openapi", "openim", "package", "patmsg", "recbiz", "remark", "scanner", "secdata", "selectrecord", "sfs", "shakemusic", "story", "subvideo", "syncFile", "taskbar", "textstatus", "videovideoCompressTmp", "videovideoCompressTmpThumb", "voice", "wenote" };
  
  static void e(k.a parama)
  {
    AppMethodBeat.i(238110);
    parama.b("@MigrationStatistics", new MigrationStatisticsFileSystem((byte)0));
    AppMethodBeat.o(238110);
  }
  
  static final class MigrationStatisticsFileSystem
    extends m
    implements FileSystem
  {
    public static final Parcelable.Creator<MigrationStatisticsFileSystem> CREATOR;
    
    static
    {
      AppMethodBeat.i(238168);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(238168);
    }
    
    private void a(List<String> paramList, String paramString, final FileSystem.b paramb, final String[] paramArrayOfString, CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238164);
      paramList = new a(paramList, new a.a() {});
      long l = 0L;
      int i = 0;
      int j = 0;
      paramList = paramList.iterator();
      int k = 0;
      while (paramList.hasNext())
      {
        paramb = (j)paramList.next();
        k += 1;
        if ((k & 0xF) == 0) {
          paramCancellationSignal.throwIfCanceled();
        }
        l += paramb.agxf;
        if (paramb.agxh) {
          j += 1;
        } else {
          i += 1;
        }
      }
      f.Ozc.b(21388, new Object[] { paramString, Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(238164);
    }
    
    public final void a(CancellationSignal paramCancellationSignal)
    {
      AppMethodBeat.i(238179);
      if (!g.jKh())
      {
        AppMethodBeat.o(238179);
        return;
      }
      Object localObject1 = b.jKe();
      Object localObject2 = new HashSet();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject1).next();
        ((Set)localObject2).add((String)((Pair)localObject3).first);
        ((Set)localObject2).add((String)((Pair)localObject3).second);
      }
      paramCancellationSignal.throwIfCanceled();
      Object localObject3 = new ArrayList();
      final ArrayList localArrayList1 = new ArrayList();
      final ArrayList localArrayList2 = new ArrayList();
      final FileSystem.b localb = new NativeFileSystem("${storage}/tencent/MicroMsg").cO(k.kMs().kMx());
      localObject1 = localb.bDW("");
      if (localObject1 == null) {
        localObject1 = Collections.emptyList();
      }
      for (;;)
      {
        localObject1 = new a((Iterable)localObject1, new a.a() {});
        long l = 0L;
        int i = 0;
        int j = 0;
        localObject1 = ((Iterable)localObject1).iterator();
        int k = 0;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (j)((Iterator)localObject1).next();
          k += 1;
          if ((k & 0xF) == 0) {
            paramCancellationSignal.throwIfCanceled();
          }
          l += ((j)localObject2).agxf;
          if (((j)localObject2).agxh) {
            j += 1;
          } else {
            i += 1;
          }
        }
        f.Ozc.b(21388, new Object[] { "@@Remained_NonAccount", Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        a((List)localObject3, "@@Remained_KnownAccount_C2C", localb, MigrationStatistics.dOh(), paramCancellationSignal);
        a((List)localObject3, "@@Remained_KnownAccount", localb, MigrationStatistics.jKD(), paramCancellationSignal);
        a(localArrayList1, "@@Remained_UnknownAccount_C2C", localb, MigrationStatistics.dOh(), paramCancellationSignal);
        a(localArrayList1, "@@Remained_UnknownAccount", localb, MigrationStatistics.jKD(), paramCancellationSignal);
        a(localArrayList2, "@@Remained_DroppedAccount_C2C", localb, MigrationStatistics.dOh(), paramCancellationSignal);
        a(localArrayList2, "@@Remained_DroppedAccount", localb, MigrationStatistics.jKD(), paramCancellationSignal);
        AppMethodBeat.o(238179);
        return;
      }
    }
    
    public final int describeContents()
    {
      return 0;
    }
    
    public final FileSystem jKa()
    {
      return this;
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.MigrationStatistics
 * JD-Core Version:    0.7.0.1
 */