package com.tencent.mm.pluginsdk.ui.tools.b.a.b;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.plugin.gallery.b.h;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.model.r;
import com.tencent.mm.plugin.gallery.model.r.c;
import com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderRecyclerView;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "activity", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "getActivity", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter;", "checkMediaStorage", "", "firstVisibleItem", "", "fromUser", "", "lastVisibleItem", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "getListener", "()Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "setListener", "(Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;)V", "loadingState", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$LoadingState;", "mOnItemClickListener", "mQueryTicket", "", "querySource", "queryType", "selectLimit", "selectType", "selectedItemChangeListener", "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$selectedItemChangeListener$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$selectedItemChangeListener$1;", "sendBtnTick", "startPerformance", "startSelectTime", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "tipDialog", "Landroid/app/ProgressDialog;", "toUser", "validVideoSuffixSet", "Ljava/util/HashSet;", "wxRView", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView;", "checkInitValidVideoSuffix", "", "checkSelectedVideo", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "filterNonExistMedia", "mediaItems", "", "generateOneQueryTicket", "getMediaPos", "oldPos", "allItems", "", "getSelectedItemCount", "()Ljava/lang/Integer;", "getSendFileList", "Ljava/util/ArrayList;", "initQueryInfo", "savedInstanceState", "Landroid/os/Bundle;", "initView", "isVisible", "notifyMM", "position", "select", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onDestroy", "onMediaClick", "itemView", "Landroid/view/View;", "itemViewType", "onQueryMediaFinished", "Ljava/util/LinkedList;", "ticket", "isFirstNotify", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "queryMedia", "setVisibility", "visibility", "updateOptionMenuText", "updateSendPhotoCount", "count", "videoCheckSuffixSupportedError", "path", "checkQt", "videoEnableCheck", "Companion", "LoadingState", "NotifyMediaItemsChanged", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements l.c
{
  public static final a.a Yvg;
  public static long start;
  private int GzH;
  private long HMF;
  public long HMG;
  public final int HMO;
  public boolean HMP;
  private volatile long HMR;
  private r.c HMZ;
  private final com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d Yva;
  public final FileSelectorUI Yvh;
  public PinnedHeaderRecyclerView Yvi;
  public com.tencent.mm.pluginsdk.ui.tools.b.a.a.a Yvj;
  public volatile a.b Yvk;
  public com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d Yvl;
  private final g Yvm;
  public String hQQ;
  private int lyw;
  public ProgressDialog lzP;
  public final int mpb;
  private final int selectType;
  public String toUser;
  private int uRj;
  private int vBs;
  
  static
  {
    AppMethodBeat.i(245876);
    Yvg = new a.a((byte)0);
    AppMethodBeat.o(245876);
  }
  
  public a(FileSelectorUI paramFileSelectorUI)
  {
    AppMethodBeat.i(245810);
    this.Yvh = paramFileSelectorUI;
    this.mpb = 26;
    this.HMO = 3;
    this.HMR = -1L;
    this.selectType = 3;
    this.HMZ = r.c.HIl;
    this.vBs = -1;
    this.uRj = -1;
    this.Yvm = new g(this);
    this.Yva = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d)new f(this));
    AppMethodBeat.o(245810);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(245822);
    kotlin.g.b.s.u(parama, "this$0");
    Log.d("FS.AlbumFileUIC", "onCreate, post delay, dialog show.");
    if (a.b.Yvo != parama.Yvk)
    {
      parama = parama.lzP;
      if (parama != null) {
        parama.show();
      }
    }
    AppMethodBeat.o(245822);
  }
  
  private static void ie(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(245816);
    long l = System.currentTimeMillis();
    Log.d("FS.AlbumFileUIC", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!y.ZC(localMediaItem.Gcc))
      {
        Log.w("FS.AlbumFileUIC", "filter non exist media: %s.", new Object[] { localMediaItem.Gcc });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    Log.d("FS.AlbumFileUIC", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(245816);
  }
  
  public final void WH(int paramInt)
  {
    AppMethodBeat.i(245890);
    paramInt = this.Yvh.iNV() + paramInt;
    if (paramInt == 0)
    {
      this.Yvh.enableOptionMenu(false);
      this.Yvh.updateOptionMenuText(1, this.Yvh.getString(R.l.app_send));
      AppMethodBeat.o(245890);
      return;
    }
    this.Yvh.enableOptionMenu(true);
    this.Yvh.updateOptionMenuText(1, this.Yvh.getString(R.l.app_send) + '(' + paramInt + "/9)");
    AppMethodBeat.o(245890);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(245902);
    if (paramLong != this.HMR)
    {
      Log.w("FS.AlbumFileUIC", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.HMR) });
      Log.w("FS.AlbumFileUIC", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(245902);
      return;
    }
    if (paramLinkedList == null)
    {
      Log.e("FS.AlbumFileUIC", "onQueryMediaFinished, null == mediaItems");
      AppMethodBeat.o(245902);
      return;
    }
    Object localObject = this.Yvj;
    if (localObject == null)
    {
      localObject = null;
      Log.d("FS.AlbumFileUIC", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), localObject, Integer.valueOf(paramLinkedList.size()) });
      localObject = this.Yvj;
      if (localObject != null)
      {
        if ((!paramBoolean) && (((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject).MaJ.size() <= paramLinkedList.size())) {
          break label344;
        }
        ie((List)paramLinkedList);
        label165:
        paramLinkedList = new LinkedList((Collection)paramLinkedList);
        if (this.Yvj != null) {
          break label378;
        }
      }
    }
    label344:
    label378:
    for (boolean bool = true;; bool = false)
    {
      Log.i("FS.AlbumFileUIC", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      if (this.Yvj != null)
      {
        localObject = new c();
        ((c)localObject).HNp = new WeakReference(this.Yvj);
        ((c)localObject).HNq = new WeakReference(this.lzP);
        ((c)localObject).HNs = new WeakReference(this.Yvi);
        ((c)localObject).HNt = paramLinkedList;
        ((c)localObject).HNu = paramBoolean;
        if (a.b.Yvn == this.Yvk) {
          this.Yvk = a.b.Yvo;
        }
        e.fAo().postToMainThread((Runnable)localObject);
      }
      AppMethodBeat.o(245902);
      return;
      localObject = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject).MaJ.size());
      break;
      localObject = paramLinkedList.subList(((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject).MaJ.size(), paramLinkedList.size());
      kotlin.g.b.s.s(localObject, "mediaItems.subList(it.mediaCount, mediaItems.size)");
      ie((List)localObject);
      break label165;
    }
  }
  
  public final void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(245892);
    if ((!Util.isNullOrNil(this.hQQ)) && (!kotlin.g.b.s.p("medianote", this.toUser)))
    {
      if (Util.currentTicks() - this.HMF < 1000L)
      {
        Log.w("FS.AlbumFileUIC", "sendImg btn event frequency limit");
        AppMethodBeat.o(245892);
        return;
      }
      Log.i("FS.AlbumFileUIC", "notifyMM switch to SendImgProxyUI");
      Object localObject = this.Yvj;
      if (localObject == null)
      {
        localObject = null;
        if ((localObject == null) || (((GalleryItem.MediaItem)localObject).getType() != 2)) {
          break label143;
        }
        paramInt = 1;
        label92:
        if (paramInt != 0) {
          break label157;
        }
        if (localObject != null) {
          break label148;
        }
      }
      for (localObject = null;; localObject = ((GalleryItem.MediaItem)localObject).Gcc)
      {
        label143:
        label148:
        try
        {
          h.b((String)localObject, this.toUser, false, paramBoolean);
          AppMethodBeat.o(245892);
          return;
        }
        catch (Exception localException) {}
        localObject = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject).MaJ.get(paramInt);
        kotlin.g.b.s.s(localObject, "allMediaItems[position]");
        localObject = (GalleryItem.MediaItem)localObject;
        break;
        paramInt = 0;
        break label92;
      }
    }
    label157:
    AppMethodBeat.o(245892);
  }
  
  public final void fBr()
  {
    AppMethodBeat.i(245896);
    com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.nNV).bwi();
    com.tencent.mm.plugin.gallery.a.a.HFE.setScene(this.mpb);
    Log.i("FS.AlbumFileUIC", "start queryMediaInAlbums %s", new Object[] { this });
    e.fAn().a((l.c)this);
    this.HMR = System.currentTimeMillis();
    e.fAn().aI("", this.HMR);
    Object localObject = this.Yvi;
    if (localObject != null) {
      ((PinnedHeaderRecyclerView)localObject).postDelayed(new a..ExternalSyntheticLambda0(this), 300L);
    }
    localObject = r.HIe;
    r.fAT().a((m)new o());
    localObject = r.HIe;
    r.fAT().a((m)new com.tencent.mm.plugin.gallery.model.s());
    AppMethodBeat.o(245896);
  }
  
  public final ArrayList<String> iOR()
  {
    AppMethodBeat.i(245885);
    e.fAt();
    Object localObject1 = this.Yvj;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).fBk().size() == 0)
      {
        Log.i("FS.AlbumFileUIC", "selectedMediaPaths.size is 0, return");
        this.Yvh.setResult(-2);
        AppMethodBeat.o(245885);
        return null;
      }
      if (Util.currentTicks() - this.HMF < 1000L)
      {
        Log.w("FS.AlbumFileUIC", "sendImg btn event frequency limit");
        AppMethodBeat.o(245885);
        return null;
      }
      this.HMF = Util.currentTicks();
      Object localObject2 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).HLB;
      localObject1 = (List)new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
        if (((GalleryItem.MediaItem)localObject3).getType() == 1)
        {
          if ((kotlin.g.b.s.p(((GalleryItem.MediaItem)localObject3).mMimeType, "edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject3).HHI)))
          {
            localObject3 = ((GalleryItem.MediaItem)localObject3).HHI;
            kotlin.g.b.s.s(localObject3, "selectedItem.tmpEditPath");
            ((List)localObject1).add(localObject3);
          }
          else
          {
            localObject3 = ((GalleryItem.MediaItem)localObject3).Gcc;
            kotlin.g.b.s.s(localObject3, "selectedItem.originalPath");
            ((List)localObject1).add(localObject3);
          }
        }
        else if (((GalleryItem.MediaItem)localObject3).getType() == 2)
        {
          localObject3 = ((GalleryItem.MediaItem)localObject3).Gcc;
          kotlin.g.b.s.s(localObject3, "selectedItem.originalPath");
          ((List)localObject1).add(localObject3);
        }
      }
      localObject1 = (ArrayList)localObject1;
      AppMethodBeat.o(245885);
      return localObject1;
    }
    AppMethodBeat.o(245885);
    return null;
  }
  
  public final Integer iOS()
  {
    AppMethodBeat.i(245887);
    com.tencent.mm.pluginsdk.ui.tools.b.a.a.a locala = this.Yvj;
    if (locala == null)
    {
      AppMethodBeat.o(245887);
      return null;
    }
    int i = locala.HLB.size();
    AppMethodBeat.o(245887);
    return Integer.valueOf(i);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245893);
    Object localObject1 = this.Yvh.getIntent().getExtras();
    if (localObject1 != null)
    {
      localObject2 = ((Bundle)localObject1).keySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Log.d("FS.AlbumFileUIC", "key=%s | value=%s", new Object[] { str, ((Bundle)localObject1).get(str) });
      }
    }
    Log.e("FS.AlbumFileUIC", "initView, oops! no extras data!");
    this.GzH = this.Yvh.getIntent().getIntExtra("max_select_count", 9);
    this.Yvi = ((PinnedHeaderRecyclerView)this.Yvh.findViewById(R.h.fOc));
    this.Yvj = new com.tencent.mm.pluginsdk.ui.tools.b.a.a.a(this.Yvh, (com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.c)this.Yvm);
    localObject1 = this.Yvi;
    if (localObject1 != null) {
      ((PinnedHeaderRecyclerView)localObject1).setAdapter((RecyclerView.a)this.Yvj);
    }
    this.Yvh.getContext();
    localObject1 = new GridLayoutManager(3);
    ((GridLayoutManager)localObject1).bWq = ((GridLayoutManager.b)new d(this));
    Object localObject2 = this.Yvi;
    if (localObject2 != null) {
      ((PinnedHeaderRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    }
    localObject2 = this.Yvi;
    if (localObject2 != null) {
      ((RecyclerView)localObject2).a((RecyclerView.h)new com.tencent.mm.pluginsdk.ui.pin.c());
    }
    localObject2 = this.Yvi;
    if (localObject2 != null) {
      ((PinnedHeaderRecyclerView)localObject2).a((RecyclerView.l)new e(this, (GridLayoutManager)localObject1));
    }
    localObject1 = this.Yvj;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).Yva = this.Yva;
    }
    localObject1 = this.Yvj;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).HLz = this.GzH;
    }
    Log.i("FS.AlbumFileUIC", kotlin.g.b.s.X("limit count = ", Integer.valueOf(this.GzH)));
    AppMethodBeat.o(245893);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(245882);
    PinnedHeaderRecyclerView localPinnedHeaderRecyclerView = this.Yvi;
    if (localPinnedHeaderRecyclerView != null) {
      localPinnedHeaderRecyclerView.setVisibility(paramInt);
    }
    AppMethodBeat.o(245882);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$NotifyMediaItemsChanged;", "Ljava/lang/Runnable;", "()V", "adapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter;", "getAdapterRef", "()Ljava/lang/ref/WeakReference;", "setAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "dialogRef", "Landroid/app/ProgressDialog;", "getDialogRef", "setDialogRef", "galleryRef", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView;", "getGalleryRef", "setGalleryRef", "isSwitchAlbum", "", "()Z", "setSwitchAlbum", "(Z)V", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getMediaItems", "()Ljava/util/LinkedList;", "setMediaItems", "(Ljava/util/LinkedList;)V", "run", "", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    implements Runnable
  {
    WeakReference<com.tencent.mm.pluginsdk.ui.tools.b.a.a.a> HNp;
    WeakReference<ProgressDialog> HNq;
    WeakReference<PinnedHeaderRecyclerView> HNs;
    LinkedList<GalleryItem.MediaItem> HNt;
    boolean HNu;
    
    public final void run()
    {
      Object localObject3 = null;
      AppMethodBeat.i(245811);
      if (this.HNt == null)
      {
        localObject1 = Integer.valueOf(-1);
        Log.d("FS.AlbumFileUIC", "on NotifyMediaItemsChanged, size %d", new Object[] { localObject1 });
        localObject1 = a.Yvg;
        localObject1 = this.HNt;
        if (localObject1 != null) {
          break label110;
        }
        Log.e("FS.AlbumFileUIC", "[filterEditMediaItem] mMediaItems is null!");
      }
      label110:
      int i;
      Object localObject5;
      for (;;)
      {
        if (this.HNp != null) {
          break label312;
        }
        Log.w("FS.AlbumFileUIC", "null == adapterRef");
        AppMethodBeat.o(245811);
        return;
        localObject1 = this.HNt;
        if (localObject1 == null)
        {
          localObject1 = null;
          break;
        }
        localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
        break;
        localObject2 = e.fAq();
        if ((localObject2 == null) || (((HashSet)localObject2).isEmpty()))
        {
          Log.i("FS.AlbumFileUIC", "editedMediaSet is invalid.");
        }
        else
        {
          long l = System.currentTimeMillis();
          Log.i("FS.AlbumFileUIC", "[filterEditMediaItem] size:%s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()) });
          localObject2 = ((HashSet)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject4 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            i = ((LinkedList)localObject1).indexOf(localObject4);
            if (-1 == i) {
              break;
            }
            localObject5 = ((LinkedList)localObject1).get(i);
            kotlin.g.b.s.s(localObject5, "mMediaItems[i]");
            localObject5 = (GalleryItem.MediaItem)localObject5;
            if ((kotlin.g.b.s.p(((GalleryItem.MediaItem)localObject4).mMimeType, "edit")) && (!kotlin.g.b.s.p(((GalleryItem.MediaItem)localObject5).mMimeType, "edit")))
            {
              Log.d("FS.AlbumFileUIC", "item:%s, editItem:%s", new Object[] { localObject5, localObject4 });
              ((LinkedList)localObject1).set(i, localObject4);
            }
          }
          Log.d("FS.AlbumFileUIC", "[filterEditMediaItem] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      label312:
      Object localObject1 = this.HNp;
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = (com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)((WeakReference)localObject1).get())
      {
        Log.w("FS.AlbumFileUIC", "null == adapter");
        AppMethodBeat.o(245811);
        return;
      }
      if (this.HNs == null)
      {
        AppMethodBeat.o(245811);
        return;
      }
      Object localObject2 = this.HNs;
      if (localObject2 == null) {}
      for (localObject2 = null; localObject2 == null; localObject2 = (PinnedHeaderRecyclerView)((WeakReference)localObject2).get())
      {
        AppMethodBeat.o(245811);
        return;
      }
      Log.d("FS.AlbumFileUIC", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.HNu) });
      if (this.HNq == null)
      {
        AppMethodBeat.o(245811);
        return;
      }
      Object localObject4 = this.HNt;
      if (localObject4 != null)
      {
        localObject5 = r.HIe;
        r.fAT().ia((List)localObject4);
        if (!this.HNu) {
          break label718;
        }
        this.HNu = false;
        localObject5 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject5).aYi(), "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((PinnedHeaderRecyclerView)localObject2).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject5).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        kotlin.g.b.s.u(localObject4, "mediaItems");
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ.clear();
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ.addAll((Collection)((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).mC((List)localObject4));
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
        localObject2 = r.HIe;
        localObject2 = r.fAT();
        localObject5 = r.c.HIl;
        if (((LinkedList)localObject4).size() > 32)
        {
          i = 32;
          ((r)localObject2).a((r.c)localObject5, 0, i, ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ.size());
        }
      }
      else
      {
        label645:
        localObject1 = this.HNq;
        if (localObject1 != null) {
          break label866;
        }
      }
      label718:
      label866:
      for (localObject1 = localObject3;; localObject1 = (ProgressDialog)((WeakReference)localObject1).get())
      {
        if ((localObject1 != null) && (((ProgressDialog)localObject1).isShowing()))
        {
          ((ProgressDialog)localObject1).dismiss();
          Log.i("FS.AlbumFileUIC", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - a.grw()) });
        }
        AppMethodBeat.o(245811);
        return;
        i = ((LinkedList)localObject4).size();
        break;
        kotlin.g.b.s.u(localObject4, "mediaItems");
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ = com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.mB((List)((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ);
        i = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ.size();
        int j = ((LinkedList)localObject4).size();
        if (i >= j) {
          break label645;
        }
        localObject2 = new ArrayList();
        localObject4 = ((LinkedList)localObject4).subList(i, j).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (GalleryItem.MediaItem)((Iterator)localObject4).next();
          if (localObject5 != null) {
            ((ArrayList)localObject2).add(localObject5);
          }
        }
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ.addAll((Collection)localObject2);
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).mC((List)((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).MaJ);
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
        break label645;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(245814);
      String str = kotlin.g.b.s.X(super.toString(), "|NotifyMediaItemsChanged");
      AppMethodBeat.o(245814);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends GridLayoutManager.b
  {
    d(a parama) {}
    
    public final int fJ(int paramInt)
    {
      AppMethodBeat.i(245804);
      com.tencent.mm.pluginsdk.ui.tools.b.a.a.a locala = a.b(this.Yvq);
      if ((locala != null) && (locala.awR(paramInt)))
      {
        AppMethodBeat.o(245804);
        return 3;
      }
      AppMethodBeat.o(245804);
      return 1;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    e(a parama, GridLayoutManager paramGridLayoutManager) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245819);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      Log.d("FS.AlbumFileUIC", "scroll state[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (1 == paramInt) {
        e.fAm().fAh();
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(245819);
          return;
          if (paramInt != 0) {
            break;
          }
          a.a(this.Yvq, this.Yvr.Ju());
          a.b(this.Yvq, this.Yvr.Jw());
          Log.d("FS.AlbumFileUIC", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(a.c(this.Yvq)), Integer.valueOf(a.d(this.Yvq)) });
          paramRecyclerView = a.b(this.Yvq);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.MaJ.size();
            paramRecyclerView = this.Yvq;
            localObject = r.HIe;
            r.fAT().a(r.c.HIl, a.c(paramRecyclerView), a.d(paramRecyclerView), paramInt);
          }
        }
      } while (2 != paramInt);
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, a.e(this.Yvq));
      paramRecyclerView = this.Yvq;
      boolean bool = WXHardCoderJNI.hcAlbumScrollEnable;
      int i = WXHardCoderJNI.hcAlbumScrollDelay;
      int j = WXHardCoderJNI.hcAlbumScrollCPU;
      int k = WXHardCoderJNI.hcAlbumScrollIO;
      if (WXHardCoderJNI.hcAlbumScrollThr) {}
      for (paramInt = Process.myTid();; paramInt = 0)
      {
        a.c(paramRecyclerView, WXHardCoderJNI.startPerformance(bool, i, j, k, paramInt, WXHardCoderJNI.hcAlbumScrollTimeout, 702, WXHardCoderJNI.hcAlbumScrollAction, "FS.AlbumFileUIC"));
        break;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245826);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      paramInt1 = this.Yvr.Ju();
      int i = this.Yvr.Jw();
      Log.d("FS.AlbumFileUIC", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(a.c(this.Yvq)), Integer.valueOf(a.d(this.Yvq)) });
      if ((a.c(this.Yvq) != paramInt1) || (a.d(this.Yvq) != i))
      {
        a.a(this.Yvq, paramInt1);
        a.b(this.Yvq, i);
        localObject = new ArrayList();
        paramInt1 = a.c(this.Yvq);
        i = a.d(this.Yvq);
        if (paramInt1 > i) {}
      }
      for (;;)
      {
        paramRecyclerView = a.b(this.Yvq);
        if (paramRecyclerView == null)
        {
          paramRecyclerView = null;
          if ((paramRecyclerView != null) && (!Util.isNullOrNil(paramRecyclerView.bud()))) {
            ((ArrayList)localObject).add(h.a(paramRecyclerView.bud(), null, -1));
          }
          if (paramInt1 != i) {
            break label414;
          }
          Log.d("FS.AlbumFileUIC", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
          e.fAm().hZ((List)localObject);
          if (paramInt2 != 0)
          {
            if (paramInt2 >= 0) {
              break label401;
            }
            a.a(this.Yvq, r.c.HIm);
          }
        }
        for (;;)
        {
          Log.d("FS.AlbumFileUIC", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramInt2), a.f(this.Yvq) });
          paramRecyclerView = a.b(this.Yvq);
          if (paramRecyclerView != null)
          {
            paramInt1 = paramRecyclerView.MaJ.size();
            paramRecyclerView = this.Yvq;
            localObject = r.HIe;
            r.fAT().a(a.f(paramRecyclerView), a.c(paramRecyclerView), a.d(paramRecyclerView), paramInt1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(245826);
          return;
          paramRecyclerView = paramRecyclerView.WF(paramInt1);
          break;
          label401:
          a.a(this.Yvq, r.c.HIn);
        }
        label414:
        paramInt1 += 1;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$mOnItemClickListener$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "onItemSelect", "isChecked", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d
  {
    f(a parama) {}
    
    public final void a(int paramInt1, View paramView, int paramInt2)
    {
      AppMethodBeat.i(245813);
      if (paramInt2 == 1)
      {
        a.e(this.Yvq, paramInt1);
        com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d locald = this.Yvq.Yvl;
        if (locald != null) {
          locald.a(paramInt1, paramView, paramInt2);
        }
      }
      AppMethodBeat.o(245813);
    }
    
    public final void cv(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(245821);
      com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d locald = this.Yvq.Yvl;
      if (locald != null) {
        locald.cv(paramInt, paramBoolean);
      }
      AppMethodBeat.o(245821);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$selectedItemChangeListener$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$IOnSelectItemChanged;", "onSelectItemChanged", "", "selectedCount", "", "position", "selectPosition", "type", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.c
  {
    g(a parama) {}
    
    public final void aG(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject2 = null;
      AppMethodBeat.i(245832);
      Object localObject1 = a.b(this.Yvq);
      if (localObject1 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).WF(paramInt2))
      {
        AppMethodBeat.o(245832);
        return;
      }
      if (paramInt3 == 0) {
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          com.tencent.mm.plugin.gallery.a.a.HFE.au(((GalleryItem.MediaItem)localObject1).Gcc, a.g(this.Yvq), paramInt2);
          a.d(this.Yvq, paramInt1);
          this.Yvq.bc(paramInt2, true);
          localObject1 = a.b(this.Yvq);
          if (localObject1 != null) {
            break label292;
          }
        }
      }
      label292:
      for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).fBk())
      {
        if (!Util.isNullOrNil((List)localObject1)) {
          break label302;
        }
        AppMethodBeat.o(245832);
        return;
        if (((GalleryItem.MediaItem)localObject1).getType() == 2)
        {
          if (!a.a(this.Yvq, (GalleryItem.MediaItem)localObject1))
          {
            com.tencent.mm.pluginsdk.ui.tools.b.a.a.a locala = a.b(this.Yvq);
            if (locala == null) {
              break;
            }
            locala.i((GalleryItem.MediaItem)localObject1);
            break;
          }
          com.tencent.mm.plugin.gallery.a.a.HFE.au(((GalleryItem.MediaItem)localObject1).Gcc, a.g(this.Yvq), paramInt2);
          a.d(this.Yvq, paramInt1);
          this.Yvq.bc(paramInt2, true);
          break;
        }
        com.tencent.mm.plugin.gallery.a.a.HFE.au(((GalleryItem.MediaItem)localObject1).Gcc, a.g(this.Yvq), paramInt2);
        a.d(this.Yvq, paramInt1);
        this.Yvq.bc(paramInt2, true);
        break;
        com.tencent.mm.plugin.gallery.a.a.HFE.au(((GalleryItem.MediaItem)localObject1).Gcc, a.g(this.Yvq), paramInt2);
        a.d(this.Yvq, paramInt1);
        this.Yvq.bc(paramInt2, false);
        break;
      }
      label302:
      localObject1 = a.b(this.Yvq);
      if (localObject1 == null) {}
      for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).fBk())
      {
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject1 = ((ArrayList)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (ImgUtil.isGif((String)((Iterator)localObject1).next()));
        AppMethodBeat.o(245832);
        return;
      }
      AppMethodBeat.o(245832);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a.b.a
 * JD-Core Version:    0.7.0.1
 */