package com.tencent.mm.plugin.sns.ui.picker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.br;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper;", "", "callback", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;", "(Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;", "downLoadFinishCallback", "Lcom/tencent/mm/plugin/sns/model/DownloadManager$IOnDownloadListener;", "getDownLoadFinishCallback", "()Lcom/tencent/mm/plugin/sns/model/DownloadManager$IOnDownloadListener;", "downloadManager", "Lcom/tencent/mm/plugin/sns/model/DownloadManager;", "filePathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getFilePathList", "()Ljava/util/ArrayList;", "filePathList$delegate", "Lkotlin/Lazy;", "isAllPhoto", "", "mediaIdPathMap", "", "taskQueue", "", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "getTaskQueue", "()Ljava/util/List;", "taskQueue$delegate", "doSnsFileSaveTask", "", "fileStoragePath", "downLoadSnsMediaFileList", "snsMediaInfoList", "", "downloadSnsImageByCdn", "snsId", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/MediaObj;", "downloadSnsMedia", "snsInfo", "Lcom/tencent/mm/plugin/sns/storage/SnsInfo;", "downloadSnsVideoByCdn", "finishAllSnsMediaDownLoad", "getDownLoadManager", "removeDownLoadManagerState", "Companion", "IOnSnsAlbumFileSaveCallback", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a RRb;
  private final b RRc;
  boolean RRd;
  private final j RRe;
  private final j RRf;
  Map<String, String> RRg;
  c RRh;
  final c.b RRi;
  
  static
  {
    AppMethodBeat.i(308795);
    RRb = new a.a((byte)0);
    AppMethodBeat.o(308795);
  }
  
  public a(b paramb)
  {
    AppMethodBeat.i(308760);
    this.RRc = paramb;
    this.RRd = true;
    this.RRe = k.cm((kotlin.g.a.a)a.e.RRl);
    this.RRf = k.cm((kotlin.g.a.a)a.d.RRk);
    this.RRi = ((c.b)new c(this));
    AppMethodBeat.o(308760);
  }
  
  private final void bbf(String paramString)
  {
    int i = 1;
    AppMethodBeat.i(308778);
    if ((!s.p(paramString, "")) && (!hrk().contains(paramString))) {
      hrk().add(paramString);
    }
    if (hrj().size() > 0)
    {
      paramString = (g)hrj().remove(0);
      Object localObject = paramString.RSO;
      dmz localdmz = paramString.Qsr;
      if (((SnsInfo)localObject).getTimeLine() != null)
      {
        paramString = this.RRg;
        if (paramString == null) {
          paramString = "";
        }
        for (;;)
        {
          if (localdmz.vhJ == 6) {
            this.RRd = false;
          }
          if ((s.p(paramString, "")) || (!y.ZC(paramString))) {
            break label191;
          }
          Log.d("MicroMsg.SnsAlbumPickerDownloadHelper", "file exists ，targetFilePath = " + paramString + " , \nurlMD5 = " + localdmz.aaTs + ' ');
          break;
          paramString = (String)paramString.get(localdmz.Id);
          if (paramString == null) {
            paramString = "";
          }
        }
        label191:
        if (localdmz.vhJ != 6)
        {
          paramString = ((SnsInfo)localObject).getSnsId();
          s.s(paramString, "snsInfo.snsId");
          localObject = br.adkd;
          localc = this.RRh;
          if ((localc != null) && (true == localc.a(localdmz, 10, null, (br)localObject, paramString))) {}
          while (i != 0)
          {
            Log.i("MicroMsg.SnsAlbumPickerDownloadHelper", "addDownLoadSns = true Image media.id:" + localdmz.Id + "  mediaObj.Type = " + localdmz.vhJ + " url: " + localdmz.Url);
            AppMethodBeat.o(308778);
            return;
            i = 0;
          }
          Log.i("MicroMsg.SnsAlbumPickerDownloadHelper", "addDownLoadSns = false Image media.id:" + localdmz.Id + "  media.Type = " + localdmz.vhJ + " url: " + localdmz.Url);
          AppMethodBeat.o(308778);
          return;
        }
        paramString = ((SnsInfo)localObject).getSnsId();
        s.s(paramString, "snsInfo.snsId");
        localObject = br.adkd;
        c localc = this.RRh;
        if ((localc != null) && (true == localc.a(localdmz, 10, null, (br)localObject, paramString))) {}
        for (i = 1; i != 0; i = 0)
        {
          Log.i("MicroMsg.SnsAlbumPickerDownloadHelper", "addDownLoadSns = true Sight media.id:" + localdmz.Id + "  mediaType = " + localdmz.mediaType + "  mediaObj.Type = " + localdmz.vhJ + " url: " + localdmz.Url);
          AppMethodBeat.o(308778);
          return;
        }
        Log.i("MicroMsg.SnsAlbumPickerDownloadHelper", "addDownLoadSns = false Sight media.id:" + localdmz.Id + "  mediaType = " + localdmz.mediaType + "  media.Type = " + localdmz.vhJ + " url: " + localdmz.Url);
      }
      AppMethodBeat.o(308778);
      return;
    }
    hrl();
    paramString = this.RRc;
    if (paramString != null) {
      paramString.l(hrk(), this.RRd);
    }
    AppMethodBeat.o(308778);
  }
  
  final List<g> hrj()
  {
    AppMethodBeat.i(308801);
    List localList = (List)this.RRe.getValue();
    AppMethodBeat.o(308801);
    return localList;
  }
  
  final ArrayList<String> hrk()
  {
    AppMethodBeat.i(308807);
    ArrayList localArrayList = (ArrayList)this.RRf.getValue();
    AppMethodBeat.o(308807);
    return localArrayList;
  }
  
  public final void hrl()
  {
    AppMethodBeat.i(308813);
    c localc = this.RRh;
    if (localc != null) {
      localc.b(this.RRi);
    }
    localc = this.RRh;
    if (localc != null) {
      localc.hfA();
    }
    localc = this.RRh;
    if (localc != null) {
      localc.hfB();
    }
    AppMethodBeat.o(308813);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;", "", "onCompleted", "", "snsStoragePathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isAllPhoto", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void l(ArrayList<String> paramArrayList, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$downLoadFinishCallback$1", "Lcom/tencent/mm/plugin/sns/model/DownloadManager$IOnDownloadListener;", "onImageFinish", "", "mediaId", "", "isOk", "", "onSetbg", "onSightFinish", "onThumbFinish", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c.b
  {
    c(a parama) {}
    
    public final void EE(String paramString)
    {
      AppMethodBeat.i(308729);
      s.u(paramString, "mediaId");
      Log.d("MicroMsg.SnsAlbumPickerDownloadHelper", "IOnDownloadListener onThumbFinish mediaId = " + paramString + " } ");
      AppMethodBeat.o(308729);
    }
    
    public final void aXr() {}
    
    public final void w(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(308738);
      s.u(paramString, "mediaId");
      Object localObject = a.b(this.RRj);
      if (localObject == null) {
        paramString = "";
      }
      while ((paramBoolean) && (!s.p(paramString, "")))
      {
        a.a(this.RRj, paramString);
        AppMethodBeat.o(308738);
        return;
        localObject = (String)((Map)localObject).get(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
      }
      a.a(this.RRj);
      AppMethodBeat.o(308738);
    }
    
    public final void x(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(308744);
      s.u(paramString, "mediaId");
      Object localObject = a.b(this.RRj);
      if (localObject == null) {
        paramString = "";
      }
      while ((paramBoolean) && (!s.p(paramString, "")))
      {
        a.a(this.RRj, paramString);
        AppMethodBeat.o(308744);
        return;
        localObject = (String)((Map)localObject).get(paramString);
        paramString = (String)localObject;
        if (localObject == null) {
          paramString = "";
        }
      }
      a.a(this.RRj);
      AppMethodBeat.o(308744);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.a
 * JD-Core Version:    0.7.0.1
 */