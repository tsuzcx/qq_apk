package com.tencent.mm.pluginsdk.ui.tools.a.a.b;

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
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.p.c;
import com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderRecyclerView;
import com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;", "Lcom/tencent/mm/plugin/gallery/model/IMediaQuery$IQueryMediaInAlbumFinished;", "activity", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "getActivity", "()Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter;", "checkMediaStorage", "", "firstVisibleItem", "", "fromUser", "", "lastVisibleItem", "listener", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "getListener", "()Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "setListener", "(Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;)V", "loadingState", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$LoadingState;", "mOnItemClickListener", "mQueryTicket", "", "querySource", "queryType", "selectLimit", "selectType", "selectedItemChangeListener", "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$selectedItemChangeListener$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$selectedItemChangeListener$1;", "sendBtnTick", "startPerformance", "startSelectTime", "state", "Lcom/tencent/mm/plugin/gallery/model/PreLoadManager$State;", "tipDialog", "Landroid/app/ProgressDialog;", "toUser", "validVideoSuffixSet", "Ljava/util/HashSet;", "wxRView", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView;", "checkInitValidVideoSuffix", "", "checkSelectedVideo", "item", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "filterNonExistMedia", "mediaItems", "", "generateOneQueryTicket", "getSelectedItemCount", "()Ljava/lang/Integer;", "getSendFileList", "Ljava/util/ArrayList;", "initQueryInfo", "savedInstanceState", "Landroid/os/Bundle;", "initView", "isVisible", "notifyMM", "position", "select", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "onDestroy", "onMediaClick", "itemView", "Landroid/view/View;", "itemViewType", "onQueryMediaFinished", "Ljava/util/LinkedList;", "ticket", "isFirstNotify", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "queryMedia", "setVisibility", "visibility", "updateOptionMenuText", "updateSendPhotoCount", "count", "videoCheckSuffixSupportedError", "path", "checkQt", "videoEnableCheck", "Companion", "LoadingState", "NotifyMediaItemsChanged", "app_release"})
public final class a
  implements i.c
{
  public static final a.a RyQ;
  public static long start;
  private int AYg;
  private long CaD;
  public long CaE;
  public final int CaM;
  public boolean CaN;
  public volatile long CaP;
  private p.c CaX;
  private final com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d RyA;
  public PinnedHeaderRecyclerView RyK;
  public com.tencent.mm.pluginsdk.ui.tools.a.a.a.a RyL;
  public volatile a.b RyM;
  public com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d RyN;
  private final h RyO;
  public final FileSelectorUI RyP;
  public String fLi;
  private int iWt;
  public ProgressDialog iXX;
  public final int jQj;
  private int rFX;
  private final int selectType;
  private int svC;
  public String toUser;
  
  static
  {
    AppMethodBeat.i(201616);
    RyQ = new a.a((byte)0);
    AppMethodBeat.o(201616);
  }
  
  public a(FileSelectorUI paramFileSelectorUI)
  {
    AppMethodBeat.i(201615);
    this.RyP = paramFileSelectorUI;
    this.jQj = 26;
    this.CaM = 3;
    this.CaP = -1L;
    this.selectType = 3;
    this.CaX = p.c.BVO;
    this.svC = -1;
    this.rFX = -1;
    this.RyO = new h(this);
    this.RyA = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d)new f(this));
    AppMethodBeat.o(201615);
  }
  
  private static void fo(List<GalleryItem.MediaItem> paramList)
  {
    AppMethodBeat.i(201609);
    long l = System.currentTimeMillis();
    Log.d("FS.AlbumFileUIC", "filterNonExistMedia size: %s.", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject = new LinkedList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)localIterator.next();
      if (!u.agG(localMediaItem.etI()))
      {
        Log.w("FS.AlbumFileUIC", "filter non exist media: %s.", new Object[] { localMediaItem.etI() });
        ((LinkedList)localObject).add(localMediaItem);
      }
    }
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramList.remove((GalleryItem.MediaItem)((Iterator)localObject).next());
    }
    Log.d("FS.AlbumFileUIC", "filterNonExistMedia cost: %s.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(201609);
  }
  
  public static long hob()
  {
    AppMethodBeat.i(201581);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(201581);
    return l;
  }
  
  public final void Ta(int paramInt)
  {
    AppMethodBeat.i(201560);
    paramInt = this.RyP.hnf() + paramInt;
    if (paramInt == 0)
    {
      this.RyP.enableOptionMenu(false);
      this.RyP.updateOptionMenuText(1, this.RyP.getString(R.l.app_send));
      AppMethodBeat.o(201560);
      return;
    }
    this.RyP.enableOptionMenu(true);
    this.RyP.updateOptionMenuText(1, this.RyP.getString(R.l.app_send) + "(" + paramInt + "/9)");
    AppMethodBeat.o(201560);
  }
  
  public final void aD(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201570);
    if ((!Util.isNullOrNil(this.fLi)) && ((kotlin.g.b.p.h("medianote", this.toUser) ^ true)))
    {
      if (Util.currentTicks() - this.CaD < 1000L)
      {
        Log.w("FS.AlbumFileUIC", "sendImg btn event frequency limit");
        AppMethodBeat.o(201570);
        return;
      }
      Log.i("FS.AlbumFileUIC", "notifyMM switch to SendImgProxyUI");
      Object localObject = this.RyL;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject).Gfp.get(paramInt);
        kotlin.g.b.p.j(localObject, "allMediaItems[position]");
        localObject = (GalleryItem.MediaItem)localObject;
        if ((localObject != null) && (((GalleryItem.MediaItem)localObject).getType() == 2)) {
          break label148;
        }
        if (localObject == null) {
          break label142;
        }
      }
      for (;;)
      {
        label142:
        try
        {
          localObject = ((GalleryItem.MediaItem)localObject).AAz;
          com.tencent.mm.plugin.gallery.a.e.b((String)localObject, this.toUser, false, paramBoolean);
          AppMethodBeat.o(201570);
          return;
        }
        catch (Exception localException) {}
        localObject = null;
        break;
        localObject = null;
      }
    }
    label148:
    AppMethodBeat.o(201570);
  }
  
  public final void b(LinkedList<GalleryItem.MediaItem> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(201599);
    if (paramLong != this.CaP)
    {
      Log.w("FS.AlbumFileUIC", "%s %s, not my query, ignore.", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.CaP) });
      Log.w("FS.AlbumFileUIC", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
      AppMethodBeat.o(201599);
      return;
    }
    if (paramLinkedList == null)
    {
      Log.e("FS.AlbumFileUIC", "onQueryMediaFinished, null == mediaItems");
      AppMethodBeat.o(201599);
      return;
    }
    Object localObject = this.RyL;
    if (localObject != null)
    {
      localObject = Integer.valueOf(((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject).Gfp.size());
      Log.d("FS.AlbumFileUIC", "onQueryMediaFinished: %s %s %s.", new Object[] { Boolean.valueOf(paramBoolean), localObject, Integer.valueOf(paramLinkedList.size()) });
      localObject = this.RyL;
      if (localObject == null) {
        break label384;
      }
      if ((!paramBoolean) && (((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject).Gfp.size() <= paramLinkedList.size())) {
        break label344;
      }
      fo((List)paramLinkedList);
      label175:
      paramLinkedList = new LinkedList((Collection)paramLinkedList);
      if (this.RyL != null) {
        break label378;
      }
    }
    label344:
    label378:
    for (boolean bool = true;; bool = false)
    {
      Log.i("FS.AlbumFileUIC", "[onQueryMediaFinished] adapter is null?:%s %s", new Object[] { Boolean.valueOf(bool), Util.getStack().toString() });
      if (this.RyL != null)
      {
        localObject = new c();
        ((c)localObject).Cbn = new WeakReference(this.RyL);
        ((c)localObject).Cbo = new WeakReference(this.iXX);
        ((c)localObject).Cbq = new WeakReference(this.RyK);
        ((c)localObject).Cbr = paramLinkedList;
        ((c)localObject).Cbs = paramBoolean;
        if (a.b.RyR == this.RyM) {
          this.RyM = a.b.RyS;
        }
        com.tencent.mm.plugin.gallery.model.e.etm().postToMainThread((Runnable)localObject);
      }
      AppMethodBeat.o(201599);
      return;
      localObject = null;
      break;
      localObject = paramLinkedList.subList(((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject).Gfp.size(), paramLinkedList.size());
      kotlin.g.b.p.j(localObject, "mediaItems.subList(it.mediaCount, mediaItems.size)");
      fo((List)localObject);
      break label175;
    }
    label384:
    AppMethodBeat.o(201599);
  }
  
  public final ArrayList<String> hnZ()
  {
    AppMethodBeat.i(201554);
    com.tencent.mm.plugin.gallery.model.e.etr();
    Object localObject1 = this.RyL;
    if (localObject1 != null)
    {
      if (((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).eun().size() == 0)
      {
        Log.i("FS.AlbumFileUIC", "selectedMediaPaths.size is 0, return");
        this.RyP.setResult(-2);
        AppMethodBeat.o(201554);
        return null;
      }
      if (Util.currentTicks() - this.CaD < 1000L)
      {
        Log.w("FS.AlbumFileUIC", "sendImg btn event frequency limit");
        AppMethodBeat.o(201554);
        return null;
      }
      this.CaD = Util.currentTicks();
      Object localObject2 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).BZH;
      localObject1 = (List)new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
        kotlin.g.b.p.j(localObject3, "selectedItem");
        if (((GalleryItem.MediaItem)localObject3).getType() == 1)
        {
          if ((kotlin.g.b.p.h(((GalleryItem.MediaItem)localObject3).getMimeType(), "edit")) && (!Util.isNullOrNil(((GalleryItem.MediaItem)localObject3).BVk)))
          {
            localObject3 = ((GalleryItem.MediaItem)localObject3).etM();
            kotlin.g.b.p.j(localObject3, "selectedItem.tmpEditPath");
            ((List)localObject1).add(localObject3);
          }
          else
          {
            localObject3 = ((GalleryItem.MediaItem)localObject3).etI();
            kotlin.g.b.p.j(localObject3, "selectedItem.originalPath");
            ((List)localObject1).add(localObject3);
          }
        }
        else if (((GalleryItem.MediaItem)localObject3).getType() == 2)
        {
          localObject3 = ((GalleryItem.MediaItem)localObject3).etI();
          kotlin.g.b.p.j(localObject3, "selectedItem.originalPath");
          ((List)localObject1).add(localObject3);
        }
      }
      localObject1 = (ArrayList)localObject1;
      AppMethodBeat.o(201554);
      return localObject1;
    }
    AppMethodBeat.o(201554);
    return null;
  }
  
  public final Integer hoa()
  {
    AppMethodBeat.i(201556);
    com.tencent.mm.pluginsdk.ui.tools.a.a.a.a locala = this.RyL;
    if (locala != null)
    {
      int i = locala.BZH.size();
      AppMethodBeat.o(201556);
      return Integer.valueOf(i);
    }
    AppMethodBeat.o(201556);
    return null;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201580);
    Object localObject1 = this.RyP.getIntent();
    kotlin.g.b.p.j(localObject1, "activity.intent");
    localObject1 = ((Intent)localObject1).getExtras();
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
    this.AYg = this.RyP.getIntent().getIntExtra("max_select_count", 9);
    this.RyK = ((PinnedHeaderRecyclerView)this.RyP.findViewById(R.h.dMt));
    this.RyL = new com.tencent.mm.pluginsdk.ui.tools.a.a.a.a(this.RyP, (com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.c)this.RyO);
    localObject1 = this.RyK;
    if (localObject1 != null) {
      ((PinnedHeaderRecyclerView)localObject1).setAdapter((RecyclerView.a)this.RyL);
    }
    this.RyP.getContext();
    localObject1 = new GridLayoutManager(3);
    ((GridLayoutManager)localObject1).a((GridLayoutManager.b)new d(this));
    Object localObject2 = this.RyK;
    if (localObject2 != null) {
      ((PinnedHeaderRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    }
    localObject2 = this.RyK;
    if (localObject2 != null) {
      ((PinnedHeaderRecyclerView)localObject2).b((RecyclerView.h)new com.tencent.mm.pluginsdk.ui.pin.c());
    }
    localObject2 = this.RyK;
    if (localObject2 != null) {
      ((PinnedHeaderRecyclerView)localObject2).a((RecyclerView.l)new e(this, (GridLayoutManager)localObject1));
    }
    localObject1 = this.RyL;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).RyA = this.RyA;
    }
    localObject1 = this.RyL;
    if (localObject1 != null) {
      ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).BZF = this.AYg;
    }
    Log.i("FS.AlbumFileUIC", "limit count = " + this.AYg);
    AppMethodBeat.o(201580);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(201543);
    PinnedHeaderRecyclerView localPinnedHeaderRecyclerView = this.RyK;
    if (localPinnedHeaderRecyclerView != null)
    {
      localPinnedHeaderRecyclerView.setVisibility(paramInt);
      AppMethodBeat.o(201543);
      return;
    }
    AppMethodBeat.o(201543);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$NotifyMediaItemsChanged;", "Ljava/lang/Runnable;", "()V", "adapterRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter;", "getAdapterRef", "()Ljava/lang/ref/WeakReference;", "setAdapterRef", "(Ljava/lang/ref/WeakReference;)V", "dialogRef", "Landroid/app/ProgressDialog;", "getDialogRef", "setDialogRef", "galleryRef", "Lcom/tencent/mm/pluginsdk/ui/pin/PinnedHeaderRecyclerView;", "getGalleryRef", "setGalleryRef", "isSwitchAlbum", "", "()Z", "setSwitchAlbum", "(Z)V", "mediaItems", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "getMediaItems", "()Ljava/util/LinkedList;", "setMediaItems", "(Ljava/util/LinkedList;)V", "run", "", "toString", "", "app_release"})
  static final class c
    implements Runnable
  {
    WeakReference<com.tencent.mm.pluginsdk.ui.tools.a.a.a.a> Cbn;
    WeakReference<ProgressDialog> Cbo;
    WeakReference<PinnedHeaderRecyclerView> Cbq;
    LinkedList<GalleryItem.MediaItem> Cbr;
    boolean Cbs;
    
    public final void run()
    {
      AppMethodBeat.i(287200);
      if (this.Cbr == null)
      {
        localObject1 = Integer.valueOf(-1);
        Log.d("FS.AlbumFileUIC", "on NotifyMediaItemsChanged, size %d", new Object[] { localObject1 });
        localObject1 = a.RyQ;
        localObject1 = this.Cbr;
        if (localObject1 != null) {
          break label107;
        }
        Log.e("FS.AlbumFileUIC", "[filterEditMediaItem] mMediaItems is null!");
      }
      label107:
      Object localObject3;
      int i;
      Object localObject4;
      for (;;)
      {
        if (this.Cbn != null) {
          break label316;
        }
        Log.w("FS.AlbumFileUIC", "null == adapterRef");
        AppMethodBeat.o(287200);
        return;
        localObject1 = this.Cbr;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((LinkedList)localObject1).size());
          break;
        }
        localObject1 = null;
        break;
        localObject2 = com.tencent.mm.plugin.gallery.model.e.eto();
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
            localObject3 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
            i = ((LinkedList)localObject1).indexOf(localObject3);
            if (-1 == i) {
              break;
            }
            localObject4 = ((LinkedList)localObject1).get(i);
            kotlin.g.b.p.j(localObject4, "mMediaItems[i]");
            localObject4 = (GalleryItem.MediaItem)localObject4;
            if ((localObject4 != null) && (kotlin.g.b.p.h(((GalleryItem.MediaItem)localObject3).mMimeType, "edit")) && ((kotlin.g.b.p.h(((GalleryItem.MediaItem)localObject4).mMimeType, "edit") ^ true)))
            {
              Log.d("FS.AlbumFileUIC", "item:%s, editItem:%s", new Object[] { localObject4, localObject3 });
              ((LinkedList)localObject1).set(i, localObject3);
            }
          }
          Log.d("FS.AlbumFileUIC", "[filterEditMediaItem] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        }
      }
      label316:
      Object localObject1 = this.Cbn;
      if (localObject1 != null) {}
      for (localObject1 = (com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)((WeakReference)localObject1).get(); localObject1 == null; localObject1 = null)
      {
        Log.w("FS.AlbumFileUIC", "null == adapter");
        AppMethodBeat.o(287200);
        return;
      }
      if (this.Cbq == null)
      {
        AppMethodBeat.o(287200);
        return;
      }
      Object localObject2 = this.Cbq;
      if (localObject2 != null)
      {
        localObject3 = (PinnedHeaderRecyclerView)((WeakReference)localObject2).get();
        if (localObject3 != null) {}
      }
      else
      {
        AppMethodBeat.o(287200);
        return;
      }
      kotlin.g.b.p.j(localObject3, "galleryRef?.get() ?: return");
      Log.d("FS.AlbumFileUIC", "isSwitchAlbum: %s.", new Object[] { Boolean.valueOf(this.Cbs) });
      if (this.Cbo == null)
      {
        AppMethodBeat.o(287200);
        return;
      }
      localObject2 = this.Cbr;
      if (localObject2 != null)
      {
        localObject4 = com.tencent.mm.plugin.gallery.model.p.BVL;
        com.tencent.mm.plugin.gallery.model.p.etV().fk((List)localObject2);
        if (!this.Cbs) {
          break label724;
        }
        this.Cbs = false;
        localObject4 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localObject3, ((com.tencent.mm.hellhoundlib.b.a)localObject4).aFh(), "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        ((PinnedHeaderRecyclerView)localObject3).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject4).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localObject3, "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$NotifyMediaItemsChanged", "run", "()V", "Undefined", "scrollToPosition", "(I)V");
        kotlin.g.b.p.k(localObject2, "mediaItems");
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp.clear();
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp.addAll((Collection)((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).jq((List)localObject2));
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).notifyDataSetChanged();
        localObject3 = com.tencent.mm.plugin.gallery.model.p.BVL;
        localObject3 = com.tencent.mm.plugin.gallery.model.p.etV();
        localObject4 = p.c.BVO;
        if (((LinkedList)localObject2).size() > 32)
        {
          i = 32;
          ((com.tencent.mm.plugin.gallery.model.p)localObject3).a((p.c)localObject4, 0, i, ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp.size());
        }
      }
      else
      {
        label645:
        localObject1 = this.Cbo;
        if (localObject1 == null) {
          break label934;
        }
      }
      label934:
      for (localObject1 = (ProgressDialog)((WeakReference)localObject1).get();; localObject1 = null)
      {
        if ((localObject1 != null) && (((ProgressDialog)localObject1).isShowing()))
        {
          ((ProgressDialog)localObject1).dismiss();
          Log.i("FS.AlbumFileUIC", "[NotifyMediaItemsChanged] cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - a.fhI()) });
        }
        AppMethodBeat.o(287200);
        return;
        i = ((LinkedList)localObject2).size();
        break;
        label724:
        kotlin.g.b.p.k(localObject2, "mediaItems");
        localObject3 = (List)((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp;
        localObject4 = new ArrayList();
        int j = ((Collection)localObject3).size();
        i = 0;
        while (i < j)
        {
          GalleryItem.MediaItem localMediaItem = (GalleryItem.MediaItem)((List)localObject3).get(i);
          if (5 != localMediaItem.getType()) {
            ((ArrayList)localObject4).add(localMediaItem);
          }
          i += 1;
        }
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp = ((ArrayList)localObject4);
        i = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp.size();
        j = ((LinkedList)localObject2).size();
        if (i >= j) {
          break label645;
        }
        localObject3 = new ArrayList();
        localObject2 = ((LinkedList)localObject2).subList(i, j).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (GalleryItem.MediaItem)((Iterator)localObject2).next();
          if (localObject4 != null) {
            ((ArrayList)localObject3).add(localObject4);
          }
        }
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp.addAll((Collection)localObject3);
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).jq((List)((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).Gfp);
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).notifyDataSetChanged();
        break label645;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(287201);
      String str = super.toString() + "|NotifyMediaItemsChanged";
      AppMethodBeat.o(287201);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$1", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "getSpanSize", "", "position", "app_release"})
  public static final class d
    extends GridLayoutManager.b
  {
    public final int cx(int paramInt)
    {
      AppMethodBeat.i(286738);
      com.tencent.mm.pluginsdk.ui.tools.a.a.a.a locala = a.a(this.RyU);
      if ((locala != null) && (locala.aqL(paramInt)))
      {
        AppMethodBeat.o(286738);
        return 3;
      }
      AppMethodBeat.o(286738);
      return 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "app_release"})
  public static final class e
    extends RecyclerView.l
  {
    e(GridLayoutManager paramGridLayoutManager) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(274820);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      Log.d("FS.AlbumFileUIC", "scroll state[%d]", new Object[] { Integer.valueOf(paramInt) });
      if (1 == paramInt) {
        com.tencent.mm.plugin.gallery.model.e.etk().etf();
      }
      do
      {
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(274820);
          return;
          if (paramInt != 0) {
            break;
          }
          a.a(this.RyU, this.RyV.kJ());
          a.b(this.RyU, this.RyV.kL());
          Log.d("FS.AlbumFileUIC", "cancelTask logic, firstVisibleItem: %s lastVisibleItem: %s.", new Object[] { Integer.valueOf(a.b(this.RyU)), Integer.valueOf(a.c(this.RyU)) });
          paramRecyclerView = a.a(this.RyU);
          if (paramRecyclerView != null)
          {
            paramInt = paramRecyclerView.Gfp.size();
            paramRecyclerView = com.tencent.mm.plugin.gallery.model.p.BVL;
            com.tencent.mm.plugin.gallery.model.p.etV().a(p.c.BVO, a.b(this.RyU), a.c(this.RyU), paramInt);
          }
        }
      } while (2 != paramInt);
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcAlbumScrollEnable, a.d(this.RyU));
      paramRecyclerView = this.RyU;
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
      AppMethodBeat.i(274821);
      Object localObject = new b();
      ((b)localObject).bn(paramRecyclerView);
      ((b)localObject).sg(paramInt1);
      ((b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject).aFi());
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      paramInt1 = this.RyV.kJ();
      int i = this.RyV.kL();
      Log.d("FS.AlbumFileUIC", "pennqin, onScrolled, %s %s %s %s.", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(i), Integer.valueOf(a.b(this.RyU)), Integer.valueOf(a.c(this.RyU)) });
      if ((a.b(this.RyU) != paramInt1) || (a.c(this.RyU) != i))
      {
        a.a(this.RyU, paramInt1);
        a.b(this.RyU, i);
        localObject = new ArrayList();
        paramInt1 = a.b(this.RyU);
        i = a.c(this.RyU);
        if (paramInt1 <= i)
        {
          paramRecyclerView = a.a(this.RyU);
          if (paramRecyclerView != null) {}
          for (paramRecyclerView = paramRecyclerView.SY(paramInt1);; paramRecyclerView = null)
          {
            if ((paramRecyclerView != null) && (!Util.isNullOrNil(paramRecyclerView.aZe()))) {
              ((ArrayList)localObject).add(com.tencent.mm.plugin.gallery.a.e.a(paramRecyclerView.aZe(), null, -1));
            }
            if (paramInt1 == i) {
              break label261;
            }
            paramInt1 += 1;
            break;
          }
        }
        label261:
        Log.d("FS.AlbumFileUIC", "cancelTask, legalPaths size: %s.", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
        com.tencent.mm.plugin.gallery.model.e.etk().fj((List)localObject);
        if (paramInt2 != 0)
        {
          if (paramInt2 >= 0) {
            break label411;
          }
          a.a(this.RyU, p.c.BVP);
        }
      }
      for (;;)
      {
        Log.d("FS.AlbumFileUIC", "onScrolled, dy: %s state: %s.", new Object[] { Integer.valueOf(paramInt2), a.e(this.RyU) });
        paramRecyclerView = a.a(this.RyU);
        if (paramRecyclerView != null)
        {
          paramInt1 = paramRecyclerView.Gfp.size();
          paramRecyclerView = com.tencent.mm.plugin.gallery.model.p.BVL;
          com.tencent.mm.plugin.gallery.model.p.etV().a(a.e(this.RyU), a.b(this.RyU), a.c(this.RyU), paramInt1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$initView$2", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(274821);
        return;
        label411:
        a.a(this.RyU, p.c.BVQ);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$mOnItemClickListener$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "onItemSelect", "isChecked", "", "app_release"})
  public static final class f
    implements com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d
  {
    public final void a(int paramInt1, View paramView, int paramInt2)
    {
      AppMethodBeat.i(276888);
      switch (paramInt2)
      {
      }
      com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d locald;
      do
      {
        AppMethodBeat.o(276888);
        return;
        a.e(this.RyU, paramInt1);
        locald = this.RyU.RyN;
      } while (locald == null);
      locald.a(paramInt1, paramView, paramInt2);
      AppMethodBeat.o(276888);
    }
    
    public final void bN(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(276889);
      com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d locald = this.RyU.RyN;
      if (locald != null)
      {
        locald.bN(paramInt, paramBoolean);
        AppMethodBeat.o(276889);
        return;
      }
      AppMethodBeat.o(276889);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class g
    implements Runnable
  {
    public g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(292362);
      Log.d("FS.AlbumFileUIC", "onCreate, post delay, dialog show.");
      if (a.b.RyS != a.f(this.RyU))
      {
        ProgressDialog localProgressDialog = a.g(this.RyU);
        if (localProgressDialog != null)
        {
          localProgressDialog.show();
          AppMethodBeat.o(292362);
          return;
        }
      }
      AppMethodBeat.o(292362);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC$selectedItemChangeListener$1", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$IOnSelectItemChanged;", "onSelectItemChanged", "", "selectedCount", "", "position", "selectPosition", "type", "app_release"})
  public static final class h
    implements com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.c
  {
    public final void ak(int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject2 = null;
      AppMethodBeat.i(282893);
      Object localObject1 = a.a(this.RyU);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).SY(paramInt2);
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(282893);
        return;
      }
      if (paramInt3 == 0) {
        if (((GalleryItem.MediaItem)localObject1).getType() == 1)
        {
          com.tencent.mm.plugin.gallery.a.esQ().an(((GalleryItem.MediaItem)localObject1).AAz, a.h(this.RyU), paramInt2);
          a.d(this.RyU, paramInt1);
          this.RyU.aD(paramInt2, true);
          localObject1 = a.a(this.RyU);
          if (localObject1 == null) {
            break label290;
          }
        }
      }
      label290:
      for (localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject1).eun();; localObject1 = null)
      {
        if (!Util.isNullOrNil((List)localObject1)) {
          break label296;
        }
        AppMethodBeat.o(282893);
        return;
        if (((GalleryItem.MediaItem)localObject1).getType() == 2)
        {
          if (!a.a(this.RyU, (GalleryItem.MediaItem)localObject1))
          {
            locala = a.a(this.RyU);
            if (locala == null) {
              break;
            }
            locala.j((GalleryItem.MediaItem)localObject1);
            break;
          }
          com.tencent.mm.plugin.gallery.a.esQ().an(((GalleryItem.MediaItem)localObject1).AAz, a.h(this.RyU), paramInt2);
          a.d(this.RyU, paramInt1);
          this.RyU.aD(paramInt2, true);
          break;
        }
        com.tencent.mm.plugin.gallery.a.esQ().an(((GalleryItem.MediaItem)localObject1).AAz, a.h(this.RyU), paramInt2);
        a.d(this.RyU, paramInt1);
        this.RyU.aD(paramInt2, true);
        break;
        com.tencent.mm.plugin.gallery.a.esQ().an(((GalleryItem.MediaItem)localObject1).AAz, a.h(this.RyU), paramInt2);
        a.d(this.RyU, paramInt1);
        this.RyU.aD(paramInt2, false);
        break;
      }
      label296:
      com.tencent.mm.pluginsdk.ui.tools.a.a.a.a locala = a.a(this.RyU);
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = locala.eun();
      }
      if (localObject1 == null) {
        kotlin.g.b.p.iCn();
      }
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (!ImgUtil.isGif((String)((Iterator)localObject1).next()))
        {
          AppMethodBeat.o(282893);
          return;
        }
      }
      AppMethodBeat.o(282893);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */