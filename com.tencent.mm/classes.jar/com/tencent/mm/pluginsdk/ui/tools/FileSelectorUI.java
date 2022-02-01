package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.f.b.a.kb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.i.c;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderRecyclerView;
import com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.d;
import com.tencent.mm.pluginsdk.ui.tools.a.a.b.a.b;
import com.tencent.mm.pluginsdk.ui.tools.a.a.b.a.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.t.b;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.util.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.j;>;
import java.util.Set;
import java.util.Vector;
import kotlin.g;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(19)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "()V", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "albumUIC", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;", "getAlbumUIC", "()Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;", "albumUIC$delegate", "Lkotlin/Lazy;", "dropdownItemName", "", "dropdownListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "dropdownListView", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "emptyView", "Landroid/widget/TextView;", "exitMultiTalkListener", "Lcom/tencent/mm/sdk/event/IListener;", "isFirstTextChanged", "", "isSearching", "listView", "Landroid/widget/ListView;", "mIsToScreenProfile", "onItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "reportHelper", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorReportHelper;", "scene", "", "screenProfileReadyUI", "Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "searchMask", "Landroid/view/View;", "searchViewHelper", "Lcom/tencent/mm/ui/tools/SearchViewControlKeyBoardShowHelper;", "toUserName", "doSendFile", "", "finish", "getForceOrientation", "getLayoutId", "getSelectedCount", "goToScreenProfile", "name", "path", "ext", "gotoAppAttachDownloadUI", "msgId", "", "gotoUnDownloadFavDetail", "favLocalId", "favDataId", "initDropdownListTitle", "isActionbarCenterLayoutMode", "isListAtBottom", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "cancel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "openFile", "recoverDropdownTitle", "resetItem", "item", "screenProfileByFinderLive", "screenProfileByMultiTalk", "setDropdownListClickListener", "updateDropdownListTitle", "title", "updateState", "ChattingFileSource", "Companion", "FavFileSource", "FileDataSource", "FileSelectorAdapter", "FileSelectorReportHelper", "FileType", "FromType", "ListFavFileItem", "ListFileItem", "ListFolderItem", "ListItem", "ListTimeItem", "SdcardFileSource", "app_release"})
public final class FileSelectorUI
  extends MMSecDataActivity
{
  public static final FileSelectorUI.b Rvv;
  private final kotlin.f Rvk;
  private e Rvl;
  private com.tencent.mm.ui.tools.s Rvm;
  private View Rvn;
  private String Rvo;
  private DropdownListView Rvp;
  private DropdownListView.c Rvq;
  private boolean Rvr;
  private f Rvs;
  private am Rvt;
  private boolean Rvu;
  private String fCl;
  private TextView kGU;
  private ListView niO;
  private final IListener<?> qeo;
  private int scene;
  private boolean sxF;
  private final AdapterView.OnItemClickListener syv;
  
  static
  {
    AppMethodBeat.i(280778);
    Rvv = new FileSelectorUI.b((byte)0);
    AppMethodBeat.o(280778);
  }
  
  public FileSelectorUI()
  {
    AppMethodBeat.i(280776);
    this.Rvk = g.ar((kotlin.g.a.a)new FileSelectorUI.o(this));
    this.qeo = ((IListener)new FileSelectorUI.p(this));
    this.Rvr = true;
    this.Rvs = new f();
    this.syv = ((AdapterView.OnItemClickListener)new z(this));
    AppMethodBeat.o(280776);
  }
  
  private final void Ev(boolean paramBoolean)
  {
    AppMethodBeat.i(280773);
    Object localObject = this.Rvp;
    if (localObject == null) {
      kotlin.g.b.p.bGy("dropdownListView");
    }
    if (localObject != null)
    {
      localObject = this.Rvp;
      if (localObject == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      if (localObject == null) {
        break label157;
      }
    }
    label157:
    for (localObject = Boolean.valueOf(((DropdownListView)localObject).tFX);; localObject = null)
    {
      if (((Boolean)localObject).booleanValue())
      {
        localObject = this.Rvp;
        if (localObject == null) {
          kotlin.g.b.p.bGy("dropdownListView");
        }
        if (localObject != null) {
          ((DropdownListView)localObject).euH();
        }
        playActionBarOperationAreaAnim();
      }
      if (paramBoolean) {
        break;
      }
      localObject = this.Rvl;
      if (localObject == null) {
        kotlin.g.b.p.bGy("adapter");
      }
      if (((e)localObject).hnq() == null) {
        break;
      }
      localObject = this.Rvl;
      if (localObject == null) {
        kotlin.g.b.p.bGy("adapter");
      }
      ((e)localObject).hnp();
      localObject = this.Rvl;
      if (localObject == null) {
        kotlin.g.b.p.bGy("adapter");
      }
      ((e)localObject).notifyDataSetChanged();
      AppMethodBeat.o(280773);
      return;
    }
    setResult(-2);
    if (paramBoolean) {
      setResult(0);
    }
    finish();
    AppMethodBeat.o(280773);
  }
  
  private final void bh(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(280754);
    switch (this.scene)
    {
    default: 
      AppMethodBeat.o(280754);
      return;
    case 3: 
      com.tencent.mm.plugin.multitalk.model.q localq = ad.eYc();
      kotlin.g.b.p.j(localq, "SubCoreMultiTalk.getMultiTalkManager()");
      if (localq.eWf())
      {
        setMMTitle(paramString1);
        hideActionBarOperationArea();
        removeSearchMenu();
        setBackBtn((MenuItem.OnMenuItemClickListener)new ac(this), a.j.actionbar_icon_dark_back);
        this.Rvu = true;
        paramString1 = this.Rvp;
        if (paramString1 == null) {
          kotlin.g.b.p.bGy("dropdownListView");
        }
        if (paramString1 != null) {
          paramString1.setVisibility(4);
        }
        paramString1 = u.n(paramString2, false);
        if (paramString1 != null) {
          break label444;
        }
        paramString1 = "";
      }
      break;
    }
    label444:
    for (;;)
    {
      kotlin.g.b.p.j(paramString1, "VFSFileOp.exportExternalPath(path, false) ?: \"\"");
      if (Util.isNullOrNil(paramString1)) {
        Log.e("MicroMsg.FileSelectorUI", "goToScreenProfile, exportExternalPath is null");
      }
      paramString2 = getContext();
      kotlin.g.b.p.j(paramString2, "context");
      this.Rvt = new am((Context)paramString2, paramString1, paramString3);
      paramString1 = this.Rvt;
      if (paramString1 != null) {
        paramString1.hNz();
      }
      paramString1 = getContentView();
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(280754);
        throw paramString1;
      }
      ((ViewGroup)paramString1).addView((View)this.Rvt);
      setRequestedOrientation(4);
      AppMethodBeat.o(280754);
      return;
      setMMTitle(paramString1);
      hideActionBarOperationArea();
      removeSearchMenu();
      setBackBtn((MenuItem.OnMenuItemClickListener)new ab(this), a.j.actionbar_icon_dark_back);
      this.Rvu = true;
      paramString1 = this.Rvp;
      if (paramString1 == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      if (paramString1 != null) {
        paramString1.setVisibility(4);
      }
      paramString1 = u.n(paramString2, false);
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        kotlin.g.b.p.j(paramString1, "VFSFileOp.exportExternalPath(path, false) ?: \"\"");
        if (Util.isNullOrNil(paramString1)) {
          Log.e("MicroMsg.FileSelectorUI", "goToScreenProfile, exportExternalPath is null");
        }
        paramString2 = getContext();
        kotlin.g.b.p.j(paramString2, "context");
        this.Rvt = new am((Context)paramString2, paramString1, paramString3, 4);
        paramString1 = this.Rvt;
        if (paramString1 == null) {
          kotlin.g.b.p.iCn();
        }
        paramString1.hNz();
        paramString1 = getContentView();
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(280754);
          throw paramString1;
        }
        ((ViewGroup)paramString1).addView((View)this.Rvt);
        break;
      }
    }
  }
  
  private final void dFf()
  {
    AppMethodBeat.i(280775);
    Object localObject = this.Rvl;
    if (localObject == null) {
      kotlin.g.b.p.bGy("adapter");
    }
    int j = ((e)localObject).RvE.size();
    localObject = hne();
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject).hoa();
      if (localObject == null) {}
    }
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      i += j;
      if (3 == this.scene) {
        break label150;
      }
      if (i <= 0) {
        break;
      }
      updateOptionMenuText(1, getString(R.l.app_send).toString() + "(" + i + "/9)");
      enableOptionMenu(1, true);
      AppMethodBeat.o(280775);
      return;
    }
    updateOptionMenuText(1, getString(R.l.app_send));
    enableOptionMenu(1, false);
    label150:
    AppMethodBeat.o(280775);
  }
  
  private final com.tencent.mm.pluginsdk.ui.tools.a.a.b.a hne()
  {
    AppMethodBeat.i(280750);
    com.tencent.mm.pluginsdk.ui.tools.a.a.b.a locala = (com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)this.Rvk.getValue();
    AppMethodBeat.o(280750);
    return locala;
  }
  
  private final void hng()
  {
    AppMethodBeat.i(280760);
    initActionBarOperationArea();
    String str = getString(R.l.eEG);
    int i = R.e.FG_0;
    initActionBarOperationAreaTxt(str, i, i, R.g.dny, R.g.dnx);
    AppMethodBeat.o(280760);
  }
  
  private final void hnh()
  {
    AppMethodBeat.i(280761);
    initActionBarOperationArea();
    String str = this.Rvo;
    if (Util.isNullOrNil(this.Rvo)) {
      str = getString(R.l.eEG);
    }
    if (str != null)
    {
      int i = R.e.FG_0;
      initActionBarOperationAreaTxt(str, i, i, R.g.dny, R.g.dnx);
    }
    AppMethodBeat.o(280761);
  }
  
  private final void hni()
  {
    AppMethodBeat.i(280763);
    setActionBarOperationAreaClickListener((AlbumChooserView.a)new ad(this));
    AppMethodBeat.o(280763);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(280758);
    super.finish();
    Object localObject1 = this.Rvl;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("adapter");
    }
    ((e)localObject1).RvF.hnj();
    localObject1 = this.Rvs;
    Object localObject2 = ((f)localObject1).RvO;
    Object localObject3 = new StringBuffer();
    Object localObject4 = (Iterable)((f)localObject1).RvP;
    int i = 0;
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = ((Iterator)localObject4).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      ((StringBuffer)localObject3).append((String)localObject5);
      if (i < ((f)localObject1).RvP.size() - 1) {
        ((StringBuffer)localObject3).append("|");
      }
      i += 1;
    }
    localObject3 = ((StringBuffer)localObject3).toString();
    kotlin.g.b.p.j(localObject3, "sb.toString()");
    ((kb)localObject2).AZ((String)localObject3);
    ((f)localObject1).RvO.bpa();
    localObject2 = c.Yyz;
    c.a((com.tencent.mm.plugin.report.a)((f)localObject1).RvO);
    AppMethodBeat.o(280758);
  }
  
  public final int getForceOrientation()
  {
    if (!this.Rvu) {
      return 1;
    }
    return 4;
  }
  
  public final int getLayoutId()
  {
    return R.i.ehc;
  }
  
  public final int hnf()
  {
    AppMethodBeat.i(280753);
    e locale = this.Rvl;
    if (locale == null) {
      kotlin.g.b.p.bGy("adapter");
    }
    int i = locale.RvE.size();
    AppMethodBeat.o(280753);
    return i;
  }
  
  public final boolean isActionbarCenterLayoutMode()
  {
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(280771);
    Object localObject1 = hne();
    int i;
    if (((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyK != null)
    {
      localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyK;
      if ((localObject1 != null) && (((PinnedHeaderRecyclerView)localObject1).getVisibility() == 0))
      {
        i = 1;
        if (i == 0) {
          break label749;
        }
        localObject1 = hne();
        switch (paramInt2)
        {
        }
      }
    }
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      AppMethodBeat.o(280771);
      return;
      i = 0;
      break;
      i = 0;
      break;
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getStringArrayListExtra("preview_image_list");
        if (localObject2 != null) {}
        Object localObject4;
        for (paramIntent = Integer.valueOf(((ArrayList)localObject2).size());; paramIntent = Integer.valueOf(0))
        {
          Log.i("FS.AlbumFileUIC", "paths size: %d.", new Object[] { paramIntent });
          if ((localObject2 == null) || (((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyL == null)) {
            break;
          }
          paramIntent = new androidx.b.b();
          paramInt1 = 0;
          for (;;)
          {
            localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyL;
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            if (paramInt1 >= ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.size()) {
              break;
            }
            localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyL;
            if (localObject3 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.get(paramInt1);
            kotlin.g.b.p.j(localObject3, "adapter!!.selectedMediaItems[i]");
            localObject3 = (GalleryItem.MediaItem)localObject3;
            localObject4 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyL;
            if (localObject4 == null) {
              kotlin.g.b.p.iCn();
            }
            paramInt2 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject4).Gfp.indexOf(localObject3);
            if (paramInt2 != -1) {
              paramIntent.add(Integer.valueOf(paramInt2));
            }
            paramInt1 += 1;
          }
        }
        localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyL;
        if (localObject3 != null)
        {
          kotlin.g.b.p.k(localObject2, "selectedPaths");
          Log.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH });
          ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.clear();
          localObject4 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = (String)((Iterator)localObject4).next();
            Object localObject6 = GalleryItem.MediaItem.a(0, 0L, (String)localObject5, "", "");
            kotlin.g.b.p.j(localObject6, "GalleryItem.MediaItem.cr…0, 0, selectPath, \"\", \"\")");
            if (e.etn() != null)
            {
              paramInt1 = e.etn().indexOf(localObject6);
              if (paramInt1 >= 0)
              {
                localObject5 = e.etn().get(paramInt1);
                kotlin.g.b.p.j(localObject5, "GalleryCore.getPreviewItems()[index]");
                localObject5 = (GalleryItem.MediaItem)localObject5;
                ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.add(localObject5);
              }
              else
              {
                Log.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                if (localObject5 == null)
                {
                  paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(280771);
                  throw paramIntent;
                }
                localObject6 = ((String)localObject5).toLowerCase();
                kotlin.g.b.p.j(localObject6, "(this as java.lang.String).toLowerCase()");
                if (n.pu((String)localObject6, "mp4")) {
                  ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject5, "", ""));
                } else {
                  ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject5, "", ""));
                }
              }
            }
          }
          Log.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH });
        }
        localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyL;
        if (localObject3 != null)
        {
          kotlin.g.b.p.k(paramIntent, "notifiedItems");
          paramInt1 = 0;
          paramInt2 = ((Collection)((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH).size();
          while (paramInt1 < paramInt2)
          {
            localObject4 = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).BZH.get(paramInt1);
            kotlin.g.b.p.j(localObject4, "mSelectMediaItems[i]");
            localObject4 = (GalleryItem.MediaItem)localObject4;
            i = ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).Gfp.indexOf(localObject4);
            if (i != -1) {
              paramIntent.add(Integer.valueOf(i));
            }
            paramInt1 += 1;
          }
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext()) {
            ((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject3).cL(((Number)paramIntent.next()).intValue());
          }
        }
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).Ta(((ArrayList)localObject2).size());
        AppMethodBeat.o(280771);
        return;
        Log.e("FS.AlbumFileUIC", "WTF!!!");
        ((com.tencent.mm.pluginsdk.ui.tools.a.a.b.a)localObject1).RyP.finish();
      }
    }
    label749:
    if ((paramInt1 == 4) && (paramIntent != null))
    {
      localObject1 = paramIntent.getStringExtra("filePath");
      localObject2 = paramIntent.getStringExtra("fileName");
      localObject3 = paramIntent.getStringExtra("fileExt");
      if ((n.L((String)localObject3, "ppt", true)) || (n.L((String)localObject3, "pdf", true)) || (n.L((String)localObject3, "doc", true)) || (n.L((String)localObject3, "docx", true)) || (n.L((String)localObject3, "pptx", true)))
      {
        if ((localObject2 != null) && (localObject1 != null) && (localObject3 != null))
        {
          bh((String)localObject2, (String)localObject1, (String)localObject3);
          AppMethodBeat.o(280771);
        }
      }
      else
      {
        if (paramIntent.getBooleanExtra("resLoadFailed", false))
        {
          com.tencent.mm.ui.base.w.cS((Context)this, getResources().getString(R.l.eEK));
          AppMethodBeat.o(280771);
          return;
        }
        com.tencent.mm.ui.base.w.cS((Context)this, getResources().getString(R.l.eRL));
        AppMethodBeat.o(280771);
      }
    }
    else if (((paramInt1 != 0) || (paramInt2 != -1)) && (paramInt1 == 2))
    {
      a.a((Activity)this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
      com.tencent.mm.ui.base.w.makeText((Context)this, R.l.file_explorer_cannot_open_file, 0).show();
    }
    AppMethodBeat.o(280771);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(280755);
    kotlin.g.b.p.k(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if ((this.Rvu) && (this.Rvt != null))
    {
      paramConfiguration = this.Rvt;
      if (paramConfiguration != null)
      {
        paramConfiguration.hNy();
        paramConfiguration.hNx();
        AppMethodBeat.o(280755);
        return;
      }
    }
    AppMethodBeat.o(280755);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(280752);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.fCl = getIntent().getStringExtra("TO_USER");
    this.scene = getIntent().getIntExtra("scene", 0);
    hni();
    setBackBtn((MenuItem.OnMenuItemClickListener)new q(this), R.k.actionbar_quit_webview_icon);
    if ((3 != this.scene) && (4 != this.scene)) {
      addTextOptionMenu(1, getString(R.l.app_send), (MenuItem.OnMenuItemClickListener)new r(this), null, w.b.Wao);
    }
    for (;;)
    {
      hng();
      paramBundle = findViewById(R.h.dFn);
      kotlin.g.b.p.j(paramBundle, "findViewById(R.id.dropdown_list_view)");
      this.Rvp = ((DropdownListView)paramBundle);
      paramBundle = getString(R.l.eEG);
      kotlin.g.b.p.j(paramBundle, "getString(R.string.file_explorer_title_chatting)");
      paramBundle = new DropdownListView.c(paramBundle, R.k.icons_outlined_copy, R.e.FG_0, 1);
      localObject = getString(R.l.eEH);
      kotlin.g.b.p.j(localObject, "getString(R.string.file_explorer_title_fav)");
      localObject = new DropdownListView.c((String)localObject, R.k.icons_outlined_favorites, R.e.FG_0, 2);
      str1 = getString(R.l.eEI);
      kotlin.g.b.p.j(str1, "getString(R.string.file_explorer_title_local)");
      paramBundle = kotlin.a.j.ag(new DropdownListView.c[] { paramBundle, localObject, new DropdownListView.c(str1, R.k.icons_outlined_folder, R.e.FG_0, 3) });
      if (3 != this.scene)
      {
        localObject = getString(R.l.eEF);
        kotlin.g.b.p.j(localObject, "getString(R.string.file_explorer_title_album)");
        paramBundle.add(new DropdownListView.c((String)localObject, R.k.icons_outlined_album, R.e.FG_0, 4));
      }
      localObject = this.Rvp;
      if (localObject == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      ((DropdownListView)localObject).setItems((List)paramBundle);
      paramBundle = this.Rvp;
      if (paramBundle == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      paramBundle.setListener((DropdownListView.d)new s(this));
      paramBundle = this.Rvp;
      if (paramBundle == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      paramBundle.setOnItemStateChanged((DropdownListView.e)new t());
      this.Rvl = new e();
      paramBundle = findViewById(R.h.dGM);
      if (paramBundle != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(280752);
      throw paramBundle;
      if (!EventCenter.instance.hadListened(this.qeo)) {
        EventCenter.instance.addListener(this.qeo);
      }
    }
    this.niO = ((ListView)paramBundle);
    paramBundle = this.Rvl;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("adapter");
    }
    paramBundle.a(h.RvV);
    paramBundle = this.niO;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("listView");
    }
    Object localObject = this.Rvl;
    if (localObject == null) {
      kotlin.g.b.p.bGy("adapter");
    }
    paramBundle.setAdapter((ListAdapter)localObject);
    paramBundle = this.niO;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("listView");
    }
    paramBundle.setOnTouchListener((View.OnTouchListener)new u(this));
    paramBundle = this.niO;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("listView");
    }
    paramBundle.setOnItemClickListener(this.syv);
    paramBundle = this.niO;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("listView");
    }
    paramBundle.setOnScrollListener((AbsListView.OnScrollListener)new v(this));
    this.kGU = ((TextView)findViewById(R.h.dGH));
    paramBundle = this.kGU;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.niO;
    if (paramBundle == null) {
      kotlin.g.b.p.bGy("listView");
    }
    if (paramBundle != null) {
      paramBundle.setEmptyView((View)this.kGU);
    }
    paramBundle = hne();
    Log.i("FS.AlbumFileUIC", "onCreate, %s.", new Object[] { paramBundle });
    localObject = (Activity)paramBundle.RyP;
    String str1 = paramBundle.RyP.getString(R.l.permission_tips_title);
    String str2 = paramBundle.RyP.getString(R.l.gallery_permission_msg);
    paramBundle.CaN = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, str1, str2);
    Log.i("FS.AlbumFileUIC", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(paramBundle.CaN) });
    paramBundle.CaE = System.currentTimeMillis();
    com.tencent.mm.pluginsdk.ui.tools.a.a.b.a.start = System.currentTimeMillis();
    paramBundle.fLi = paramBundle.RyP.getIntent().getStringExtra("GalleryUI_FromUser");
    paramBundle.toUser = paramBundle.RyP.getIntent().getStringExtra("GalleryUI_ToUser");
    paramBundle.iXX = ((ProgressDialog)com.tencent.mm.ui.base.s.a((Context)paramBundle.RyP, (CharSequence)paramBundle.RyP.getString(R.l.app_waiting), false));
    paramBundle.RyM = a.b.RyR;
    localObject = e.etl();
    kotlin.g.b.p.j(localObject, "GalleryCore.getMediaQueryService()");
    ((o)localObject).SU(paramBundle.jQj);
    localObject = e.etl();
    kotlin.g.b.p.j(localObject, "GalleryCore.getMediaQueryService()");
    ((o)localObject).setQueryType(paramBundle.CaM);
    Log.i("FS.AlbumFileUIC", "query source: " + paramBundle.jQj + ", queryType: " + paramBundle.CaM);
    paramBundle.initView();
    if (paramBundle.CaN)
    {
      com.tencent.mm.memory.a.a.b.c(com.tencent.mm.memory.a.a.b.ljk).bbn();
      com.tencent.mm.plugin.gallery.a.esQ().setScene(paramBundle.jQj);
      Log.i("FS.AlbumFileUIC", "start queryMediaInAlbums %s", new Object[] { paramBundle });
      e.etl().a((i.c)paramBundle);
      paramBundle.CaP = com.tencent.mm.pluginsdk.ui.tools.a.a.b.a.hob();
      e.etl().ax("", paramBundle.CaP);
      localObject = paramBundle.RyK;
      if (localObject != null) {
        ((PinnedHeaderRecyclerView)localObject).postDelayed((Runnable)new a.g(paramBundle), 300L);
      }
      paramBundle = com.tencent.mm.plugin.gallery.model.p.BVL;
      com.tencent.mm.plugin.gallery.model.p.etV().a((com.tencent.mm.plugin.gallery.model.j)new com.tencent.mm.plugin.gallery.model.l());
      paramBundle = com.tencent.mm.plugin.gallery.model.p.BVL;
      com.tencent.mm.plugin.gallery.model.p.etV().a((com.tencent.mm.plugin.gallery.model.j)new com.tencent.mm.plugin.gallery.model.q());
    }
    e.ett();
    hne().setVisibility(8);
    hne().RyN = ((a.d)new w(this));
    this.Rvn = findViewById(R.h.dTr);
    paramBundle = this.Rvn;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.Rvn;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)FileSelectorUI.x.Rws);
    }
    this.Rvm = new com.tencent.mm.ui.tools.s();
    paramBundle = this.Rvm;
    if (paramBundle != null) {
      paramBundle.a((t.b)new y(this));
    }
    addSearchMenu(true, (com.tencent.mm.ui.tools.t)this.Rvm);
    dFf();
    Log.i("MicroMsg.FileSelectorUI", "onCreate, cost:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(280752);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(280765);
    super.onDestroy();
    Object localObject = hne();
    if (localObject != null) {
      e.etl().b((i.c)localObject);
    }
    EventCenter.instance.removeListener(this.qeo);
    localObject = this.Rvm;
    if (localObject != null)
    {
      ((com.tencent.mm.ui.tools.s)localObject).hVb();
      AppMethodBeat.o(280765);
      return;
    }
    AppMethodBeat.o(280765);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(280767);
    kotlin.g.b.p.k(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      Log.i("MicroMsg.FileSelectorUI", "onKeyDown back");
      if (this.Rvu)
      {
        paramKeyEvent = this.Rvt;
        if (paramKeyEvent != null) {
          paramKeyEvent.release();
        }
        paramKeyEvent = this.Rvt;
        if (paramKeyEvent != null) {
          paramKeyEvent.removeAllViews();
        }
        paramKeyEvent = getContentView();
        if (paramKeyEvent == null)
        {
          paramKeyEvent = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(280767);
          throw paramKeyEvent;
        }
        ((ViewGroup)paramKeyEvent).removeView((View)this.Rvt);
        setBackBtn((MenuItem.OnMenuItemClickListener)new aa(this), R.k.actionbar_quit_webview_icon);
        paramKeyEvent = this.Rvp;
        if (paramKeyEvent == null) {
          kotlin.g.b.p.bGy("dropdownListView");
        }
        if (paramKeyEvent != null) {
          paramKeyEvent.setVisibility(0);
        }
        hni();
        hnh();
        setRequestedOrientation(1);
        addSearchMenu(true, (com.tencent.mm.ui.tools.t)this.Rvm);
        paramKeyEvent = com.tencent.mm.plugin.multitalk.d.f.FEQ;
        com.tencent.mm.plugin.multitalk.d.f.fab();
        this.Rvu = false;
      }
      for (;;)
      {
        AppMethodBeat.o(280767);
        return true;
        Ev(false);
      }
    }
    if (paramInt == 82)
    {
      paramKeyEvent = this.Rvp;
      if (paramKeyEvent == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      if (paramKeyEvent != null)
      {
        paramKeyEvent = this.Rvp;
        if (paramKeyEvent == null) {
          kotlin.g.b.p.bGy("dropdownListView");
        }
        if (paramKeyEvent != null) {
          paramKeyEvent.euH();
        }
      }
      AppMethodBeat.o(280767);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(280767);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(280756);
    super.onPause();
    if ((!isFinishing()) && (!isDestroyed()))
    {
      Object localObject = this.Rvp;
      if (localObject == null) {
        kotlin.g.b.p.bGy("dropdownListView");
      }
      if (localObject != null)
      {
        localObject = this.Rvp;
        if (localObject == null) {
          kotlin.g.b.p.bGy("dropdownListView");
        }
        if (localObject != null) {
          localObject = Boolean.valueOf(((DropdownListView)localObject).tFX);
        }
        while (((Boolean)localObject).booleanValue())
        {
          localObject = this.Rvp;
          if (localObject == null) {
            kotlin.g.b.p.bGy("dropdownListView");
          }
          if (localObject != null) {
            if (!((DropdownListView)localObject).tFX)
            {
              Log.w("MicroMsg.DropdownListView", "want to close, but it was closed");
              AppMethodBeat.o(280756);
              return;
              localObject = null;
            }
            else
            {
              if (((DropdownListView)localObject).Ccr)
              {
                Log.d("MicroMsg.DropdownListView", "want to close, but it is in animation");
                AppMethodBeat.o(280756);
                return;
              }
              FrameLayout localFrameLayout = ((DropdownListView)localObject).Ccn;
              if (localFrameLayout == null) {
                kotlin.g.b.p.iCn();
              }
              localFrameLayout.setVisibility(8);
              ((DropdownListView)localObject).tFX = false;
              if ((((DropdownListView)localObject).RuH != null) && (((DropdownListView)localObject).RuH == null)) {
                kotlin.g.b.p.iCn();
              }
              AppMethodBeat.o(280756);
              return;
            }
          }
        }
      }
    }
    AppMethodBeat.o(280756);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class aa
    implements MenuItem.OnMenuItemClickListener
  {
    aa(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(266177);
      Log.i("MicroMsg.FileSelectorUI", "onKeyDown, go back");
      FileSelectorUI.h(this.Rvw);
      AppMethodBeat.o(266177);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ab
    implements MenuItem.OnMenuItemClickListener
  {
    ab(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(214029);
      Log.i("MicroMsg.FileSelectorUI", "backBtn");
      paramMenuItem = FileSelectorUI.s(this.Rvw);
      if (paramMenuItem != null) {
        paramMenuItem.removeAllViews();
      }
      paramMenuItem = FileSelectorUI.t(this.Rvw);
      if (paramMenuItem == null)
      {
        paramMenuItem = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(214029);
        throw paramMenuItem;
      }
      ((ViewGroup)paramMenuItem).removeView((View)FileSelectorUI.s(this.Rvw));
      this.Rvw.setBackBtn((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(283248);
          Log.i("MicroMsg.FileSelectorUI", "backBtn");
          FileSelectorUI.h(this.Rwu.Rvw);
          AppMethodBeat.o(283248);
          return false;
        }
      }, R.k.actionbar_quit_webview_icon);
      paramMenuItem = FileSelectorUI.m(this.Rvw);
      if (paramMenuItem != null) {
        paramMenuItem.setVisibility(0);
      }
      FileSelectorUI.u(this.Rvw);
      FileSelectorUI.y(this.Rvw);
      this.Rvw.addSearchMenu(true, (com.tencent.mm.ui.tools.t)FileSelectorUI.g(this.Rvw));
      FileSelectorUI.x(this.Rvw);
      paramMenuItem = com.tencent.mm.plugin.multitalk.d.f.FEQ;
      com.tencent.mm.plugin.multitalk.d.f.fab();
      AppMethodBeat.o(214029);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class ac
    implements MenuItem.OnMenuItemClickListener
  {
    ac(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(289486);
      Log.i("MicroMsg.FileSelectorUI", "backBtn");
      ad.eYc().release();
      paramMenuItem = FileSelectorUI.s(this.Rvw);
      if (paramMenuItem != null) {
        paramMenuItem.release();
      }
      paramMenuItem = FileSelectorUI.s(this.Rvw);
      if (paramMenuItem != null) {
        paramMenuItem.removeAllViews();
      }
      paramMenuItem = FileSelectorUI.t(this.Rvw);
      if (paramMenuItem == null)
      {
        paramMenuItem = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(289486);
        throw paramMenuItem;
      }
      ((ViewGroup)paramMenuItem).removeView((View)FileSelectorUI.s(this.Rvw));
      this.Rvw.setBackBtn((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(290076);
          Log.i("MicroMsg.FileSelectorUI", "backBtn");
          FileSelectorUI.h(this.Rwv.Rvw);
          AppMethodBeat.o(290076);
          return false;
        }
      }, R.k.actionbar_quit_webview_icon);
      paramMenuItem = FileSelectorUI.m(this.Rvw);
      if (paramMenuItem != null) {
        paramMenuItem.setVisibility(0);
      }
      FileSelectorUI.u(this.Rvw);
      FileSelectorUI.v(this.Rvw);
      this.Rvw.setRequestedOrientation(1);
      this.Rvw.addSearchMenu(true, (com.tencent.mm.ui.tools.t)FileSelectorUI.g(this.Rvw));
      FileSelectorUI.x(this.Rvw);
      paramMenuItem = com.tencent.mm.plugin.multitalk.d.f.FEQ;
      com.tencent.mm.plugin.multitalk.d.f.fab();
      AppMethodBeat.o(289486);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onAlbumChooserViewClick"})
  static final class ad
    implements AlbumChooserView.a
  {
    ad(FileSelectorUI paramFileSelectorUI) {}
    
    public final void euC()
    {
      AppMethodBeat.i(276899);
      Log.i("MicroMsg.FileSelectorUI", "onAlbumChooserViewClick.");
      FileSelectorUI.a(this.Rvw, null);
      this.Rvw.playActionBarOperationAreaAnim();
      DropdownListView localDropdownListView = FileSelectorUI.m(this.Rvw);
      if (localDropdownListView != null)
      {
        localDropdownListView.euH();
        AppMethodBeat.o(276899);
        return;
      }
      AppMethodBeat.o(276899);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "FILE_TYPE_COUNT", "", "TAG", "", "chattingFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "favFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FavFileSource;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "fromType", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "sdcardFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "selectedFileLst", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getSelectedFileLst", "()Ljava/util/List;", "finish", "", "getCount", "getDataSourceFrom", "getIconSrc", "name", "getItem", "position", "getItemId", "", "getItemViewType", "getListItemFromData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getParentPath", "Lcom/tencent/mm/vfs/VFSFile;", "getThumbnail", "Landroid/graphics/Bitmap;", "path", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "isAudio", "", "fileName", "isCompressFile", "isDoc", "isFromSDCard", "isHtml", "isImg", "isInit", "isKeynote", "isNumber", "isPages", "isPdf", "isPpt", "isTxt", "isVideo", "isXls", "loadData", "onBottomLoadMore", "onInit", "onLoadMoreCompleted", "onSelectorWrapperClicked", "v", "search", "content", "setDataSourceFrom", "setParentPath", "setPath", "FileViewHolder", "FolderViewHolder", "TimeViewHolder", "app_release"})
  public final class e
    extends BaseAdapter
  {
    private List<FileSelectorUI.l> RvB;
    private final int RvD;
    final List<FileSelectorUI.j> RvE;
    final FileSelectorUI.a RvF;
    final FileSelectorUI.c RvG;
    final FileSelectorUI.n RvH;
    FileSelectorUI.h RvI;
    private final String TAG;
    
    public e()
    {
      AppMethodBeat.i(281967);
      this.TAG = "MicroMsg.FileSelectorAdapter";
      this.RvD = 4;
      List localList = Collections.synchronizedList((List)new ArrayList());
      kotlin.g.b.p.j(localList, "Collections.synchronized…st(ArrayList<ListItem>())");
      this.RvB = localList;
      localList = Collections.synchronizedList((List)new ArrayList());
      kotlin.g.b.p.j(localList, "Collections.synchronized…rrayList<ListFileItem>())");
      this.RvE = localList;
      this.RvF = new FileSelectorUI.a(this$1, this);
      this.RvG = new FileSelectorUI.c(this$1, this);
      this.RvH = new FileSelectorUI.n(this$1, this);
      this.RvI = FileSelectorUI.h.RvV;
      AppMethodBeat.o(281967);
    }
    
    private final boolean b(FileSelectorUI.h paramh)
    {
      AppMethodBeat.i(281936);
      switch (f.jLJ[paramh.ordinal()])
      {
      default: 
        AppMethodBeat.o(281936);
        return true;
      case 1: 
        bool = this.RvF.hasInit;
        AppMethodBeat.o(281936);
        return bool;
      case 2: 
        bool = this.RvG.hasInit;
        AppMethodBeat.o(281936);
        return bool;
      }
      boolean bool = this.RvH.hasInit;
      AppMethodBeat.o(281936);
      return bool;
    }
    
    private static boolean bI(String paramString)
    {
      AppMethodBeat.i(281953);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281953);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".mp3")) || (n.pu(paramString, ".wma")))
      {
        AppMethodBeat.o(281953);
        return true;
      }
      AppMethodBeat.o(281953);
      return false;
    }
    
    private static boolean bJ(String paramString)
    {
      AppMethodBeat.i(281954);
      kotlin.g.b.p.k(paramString, "fileName");
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281954);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".mp4")) || (n.pu(paramString, ".rm")))
      {
        AppMethodBeat.o(281954);
        return true;
      }
      AppMethodBeat.o(281954);
      return false;
    }
    
    private static int brL(String paramString)
    {
      AppMethodBeat.i(281951);
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281951);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if (brO(paramString))
      {
        i = R.k.app_attach_file_icon_word;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brM(paramString))
      {
        i = R.g.app_attach_file_icon_pic;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brT(paramString))
      {
        i = R.k.app_attach_file_icon_rar;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brU(paramString))
      {
        i = R.k.app_attach_file_icon_txt;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brP(paramString))
      {
        i = R.k.app_attach_file_icon_pdf;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brQ(paramString))
      {
        i = R.k.app_attach_file_icon_ppt;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brR(paramString))
      {
        i = R.k.app_attach_file_icon_excel;
        AppMethodBeat.o(281951);
        return i;
      }
      if (bI(paramString))
      {
        i = R.k.app_attach_file_icon_music;
        AppMethodBeat.o(281951);
        return i;
      }
      if (bJ(paramString))
      {
        i = R.k.app_attach_file_icon_video;
        AppMethodBeat.o(281951);
        return i;
      }
      if (dA(paramString))
      {
        i = R.k.app_attach_file_icon_webpage;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brV(paramString))
      {
        i = R.k.app_attach_file_icon_keynote;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brW(paramString))
      {
        i = R.k.app_attach_file_icon_number;
        AppMethodBeat.o(281951);
        return i;
      }
      if (brX(paramString))
      {
        i = R.k.app_attach_file_icon_page;
        AppMethodBeat.o(281951);
        return i;
      }
      int i = R.k.app_attach_file_icon_unknow;
      AppMethodBeat.o(281951);
      return i;
    }
    
    private static boolean brM(String paramString)
    {
      AppMethodBeat.i(281952);
      kotlin.g.b.p.k(paramString, "fileName");
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281952);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((Build.VERSION.SDK_INT >= 28) && (n.pu(paramString, ".heic")))
      {
        AppMethodBeat.o(281952);
        return true;
      }
      if ((n.pu(paramString, ".bmp")) || (n.pu(paramString, ".png")) || (n.pu(paramString, ".jpg")) || (n.pu(paramString, ".jpeg")) || (n.pu(paramString, ".gif")))
      {
        AppMethodBeat.o(281952);
        return true;
      }
      AppMethodBeat.o(281952);
      return false;
    }
    
    private static boolean brO(String paramString)
    {
      AppMethodBeat.i(281956);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281956);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".doc")) || (n.pu(paramString, ".docx")) || (n.pu(paramString, "wps")))
      {
        AppMethodBeat.o(281956);
        return true;
      }
      AppMethodBeat.o(281956);
      return false;
    }
    
    private static boolean brP(String paramString)
    {
      AppMethodBeat.i(281957);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281957);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.pu(paramString, ".pdf");
      AppMethodBeat.o(281957);
      return bool;
    }
    
    private static boolean brQ(String paramString)
    {
      AppMethodBeat.i(281958);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281958);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".ppt")) || (n.pu(paramString, ".pptx")))
      {
        AppMethodBeat.o(281958);
        return true;
      }
      AppMethodBeat.o(281958);
      return false;
    }
    
    private static boolean brR(String paramString)
    {
      AppMethodBeat.i(281960);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281960);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".xls")) || (n.pu(paramString, ".xlsx")))
      {
        AppMethodBeat.o(281960);
        return true;
      }
      AppMethodBeat.o(281960);
      return false;
    }
    
    private static boolean brT(String paramString)
    {
      AppMethodBeat.i(281955);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281955);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".rar")) || (n.pu(paramString, ".zip")) || (n.pu(paramString, ".7z")) || (n.pu(paramString, "tar")) || (n.pu(paramString, ".iso")))
      {
        AppMethodBeat.o(281955);
        return true;
      }
      AppMethodBeat.o(281955);
      return false;
    }
    
    private static boolean brU(String paramString)
    {
      AppMethodBeat.i(281962);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281962);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.pu(paramString, ".txt")) || (n.pu(paramString, ".rtf")))
      {
        AppMethodBeat.o(281962);
        return true;
      }
      AppMethodBeat.o(281962);
      return false;
    }
    
    private static boolean brV(String paramString)
    {
      AppMethodBeat.i(281963);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281963);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.pu(paramString, ".key");
      AppMethodBeat.o(281963);
      return bool;
    }
    
    private static boolean brW(String paramString)
    {
      AppMethodBeat.i(281965);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281965);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.pu(paramString, ".number");
      AppMethodBeat.o(281965);
      return bool;
    }
    
    private static boolean brX(String paramString)
    {
      AppMethodBeat.i(281966);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281966);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.pu(paramString, ".pages");
      AppMethodBeat.o(281966);
      return bool;
    }
    
    private final void c(FileSelectorUI.h paramh)
    {
      AppMethodBeat.i(281939);
      switch (f.yBk[paramh.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(281939);
        return;
        this.RvF.hnn();
        AppMethodBeat.o(281939);
        return;
        this.RvG.hnn();
        AppMethodBeat.o(281939);
        return;
        this.RvH.hnn();
      }
    }
    
    private static boolean dA(String paramString)
    {
      AppMethodBeat.i(281964);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.p.j(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(281964);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.pu(paramString, ".html");
      AppMethodBeat.o(281964);
      return bool;
    }
    
    private final boolean hnr()
    {
      return FileSelectorUI.h.RvX == this.RvI;
    }
    
    private final ArrayList<FileSelectorUI.l> jp(List<FileSelectorUI.j> paramList)
    {
      AppMethodBeat.i(281942);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = "";
      Iterator localIterator = ((Iterable)paramList).iterator();
      paramList = (List<FileSelectorUI.j>)localObject1;
      while (localIterator.hasNext())
      {
        FileSelectorUI.j localj = (FileSelectorUI.j)localIterator.next();
        Object localObject2;
        if ((localj == null) || (FileSelectorUI.g.RvQ == localj.Rwj))
        {
          localObject2 = this.TAG;
          if (localj == null) {}
          for (localObject1 = "getListItemFromData, fileItem=null";; localObject1 = "getListItemFromData, type:FileType.TYPE_INVALID")
          {
            Log.e((String)localObject2, (String)localObject1);
            break;
          }
        }
        localObject1 = paramList;
        if (FileSelectorUI.g.RvT != localj.Rwj)
        {
          localObject1 = paramList;
          if ((kotlin.g.b.p.h(paramList, localj.title) ^ true))
          {
            localObject2 = new FileSelectorUI.m(this.Rvw);
            ((FileSelectorUI.l)localObject2).title = localj.title;
            localObject1 = ((FileSelectorUI.l)localObject2).title;
            paramList = (List<FileSelectorUI.j>)localObject1;
            if (localObject1 == null) {
              paramList = "";
            }
            ((FileSelectorUI.m)localObject2).a(FileSelectorUI.g.RvR);
            localArrayList.add(localObject2);
            localObject1 = paramList;
          }
        }
        localArrayList.add(localj);
        paramList = (List<FileSelectorUI.j>)localObject1;
      }
      AppMethodBeat.o(281942);
      return localArrayList;
    }
    
    public final void KG(String paramString)
    {
      AppMethodBeat.i(281935);
      kotlin.g.b.p.k(paramString, "content");
      FileSelectorUI.h localh = this.RvI;
      switch (f.$EnumSwitchMapping$0[localh.ordinal()])
      {
      default: 
        paramString = (List)new ArrayList();
      }
      for (;;)
      {
        this.RvB = paramString;
        notifyDataSetChanged();
        AppMethodBeat.o(281935);
        return;
        paramString = (List)jp(this.RvF.brS(paramString));
        continue;
        paramString = (List)jp(this.RvG.brS(paramString));
        continue;
        paramString = (List)jp(this.RvH.brS(paramString));
      }
    }
    
    public final void a(FileSelectorUI.h paramh)
    {
      AppMethodBeat.i(281934);
      kotlin.g.b.p.k(paramh, "fromType");
      if (!b(paramh)) {
        c(paramh);
      }
      this.RvI = paramh;
      dlN();
      AppMethodBeat.o(281934);
    }
    
    public final FileSelectorUI.l aqZ(int paramInt)
    {
      AppMethodBeat.i(281945);
      FileSelectorUI.l locall = (FileSelectorUI.l)this.RvB.get(paramInt);
      AppMethodBeat.o(281945);
      return locall;
    }
    
    final void dlN()
    {
      AppMethodBeat.i(281938);
      Object localObject = this.RvI;
      switch (f.tKM[localObject.ordinal()])
      {
      default: 
        localObject = FileSelectorUI.b(this.Rvw);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)"");
        }
        localObject = (List)new ArrayList();
      }
      for (;;)
      {
        this.RvB = ((List)localObject);
        notifyDataSetChanged();
        if ((this.RvB.size() > 0) || (FileSelectorUI.h.RvY == this.RvI)) {
          break;
        }
        localObject = FileSelectorUI.b(this.Rvw);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)this.Rvw.getString(R.l.eEA));
        }
        localObject = FileSelectorUI.b(this.Rvw);
        if (localObject == null) {
          break;
        }
        ((TextView)localObject).setVisibility(0);
        AppMethodBeat.o(281938);
        return;
        localObject = (List)jp(this.RvF.RvB);
        continue;
        localObject = (List)jp(this.RvG.RvB);
        continue;
        localObject = (List)jp(this.RvH.RvB);
      }
      AppMethodBeat.o(281938);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(281944);
      int i = this.RvB.size();
      AppMethodBeat.o(281944);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(281943);
      paramInt = aqZ(paramInt).Rwj.ordinal();
      AppMethodBeat.o(281943);
      return paramInt;
    }
    
    @SuppressLint({"ResourceType"})
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(281948);
      kotlin.g.b.p.k(paramViewGroup, "parent");
      FileSelectorUI.l locall = aqZ(paramInt);
      Object localObject1 = locall.Rwj;
      switch (f.yBm[localObject1.ordinal()])
      {
      default: 
        Log.f(this.TAG, "impossible path, Fuck felixzhou!");
        if (paramView == null) {
          kotlin.g.b.p.iCn();
        }
        AppMethodBeat.o(281948);
        return paramView;
      case 1: 
        if (paramView == null)
        {
          paramView = View.inflate(paramViewGroup.getContext(), R.i.ehb, null);
          paramViewGroup = new c();
          localObject1 = paramView.findViewById(R.h.item_title);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.mNb = ((TextView)localObject1);
          kotlin.g.b.p.j(paramView, "convertView");
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          paramViewGroup = paramViewGroup.mNb;
          if (paramViewGroup != null) {
            paramViewGroup.setText((CharSequence)locall.title);
          }
          AppMethodBeat.o(281948);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.TimeViewHolder");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup = (c)paramViewGroup;
        }
      case 2: 
        if (paramView == null)
        {
          localObject1 = View.inflate(paramViewGroup.getContext(), R.i.eha, null);
          paramViewGroup = new a();
          paramView = ((View)localObject1).findViewById(R.h.dKl);
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.RvJ = ((FrameLayout)paramView);
          paramView = paramViewGroup.RvJ;
          if (paramView != null) {}
          for (paramView = paramView.findViewById(R.h.dKk); paramView == null; paramView = null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.RvK = ((CheckBox)paramView);
          paramView = ((View)localObject1).findViewById(R.h.item_icon);
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.qps = ((ImageView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.item_title);
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.mNb = ((TextView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.dKn);
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.HpD = ((TextView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.dKp);
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.timeTV = ((TextView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.dKg);
          if (paramView == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup.RvL = ((TextView)paramView);
          paramViewGroup.RvM = ((View)localObject1).findViewById(R.h.dKj);
          if (getCount() - 1 == paramInt)
          {
            paramView = paramViewGroup.RvM;
            if (paramView != null) {
              paramView.setVisibility(4);
            }
          }
          paramView = paramViewGroup.RvJ;
          if (paramView != null) {
            paramView.setOnClickListener((View.OnClickListener)new d(this));
          }
          kotlin.g.b.p.j(localObject1, "convertView");
          ((View)localObject1).setTag(paramViewGroup);
          paramView = (View)localObject1;
        }
        for (;;)
        {
          localObject1 = paramViewGroup.mNb;
          if (localObject1 == null) {
            break label712;
          }
          if (locall != null) {
            break;
          }
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
          AppMethodBeat.o(281948);
          throw paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FileViewHolder");
            AppMethodBeat.o(281948);
            throw paramView;
          }
          paramViewGroup = (a)paramViewGroup;
        }
        ((TextView)localObject1).setText(((FileSelectorUI.j)locall).hnu());
        label712:
        if ((3 == FileSelectorUI.a(this.Rvw)) || (4 == FileSelectorUI.a(this.Rvw)))
        {
          localObject1 = paramViewGroup.RvJ;
          if (localObject1 != null) {
            ((FrameLayout)localObject1).setVisibility(4);
          }
        }
        for (;;)
        {
          localObject1 = paramViewGroup.HpD;
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = paramViewGroup.timeTV;
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = paramViewGroup.mNb;
          if (localObject1 == null) {
            break label853;
          }
          if (locall != null) {
            break;
          }
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
          AppMethodBeat.o(281948);
          throw paramView;
          localObject1 = paramViewGroup.RvJ;
          if (localObject1 != null) {
            ((FrameLayout)localObject1).setVisibility(0);
          }
        }
        ((TextView)localObject1).setText(((FileSelectorUI.j)locall).hnu());
        label853:
        localObject1 = paramViewGroup.HpD;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)Util.getSizeKB(((FileSelectorUI.j)locall).Rwe));
        }
        if (((FileSelectorUI.j)locall).Rwf == 2)
        {
          localObject1 = paramViewGroup.HpD;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)(">" + ((ag)h.ag(ag.class)).getFileSizeLimitInMB(true) + "MB"));
          }
        }
        localObject1 = paramViewGroup.timeTV;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.j.f.d((Context)this.Rvw.getContext(), ((FileSelectorUI.j)locall).createTime, true));
        }
        localObject1 = paramViewGroup.qps;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(brL(((FileSelectorUI.j)locall).hnu().toString()));
        }
        localObject1 = paramViewGroup.RvL;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(((FileSelectorUI.j)locall).Rwc);
        }
        localObject1 = paramViewGroup.RvK;
        if (localObject1 != null) {
          ((CheckBox)localObject1).setChecked(this.RvE.contains(locall));
        }
        paramViewGroup = paramViewGroup.RvJ;
        if (paramViewGroup != null) {
          paramViewGroup.setTag(Integer.valueOf(paramInt));
        }
        AppMethodBeat.o(281948);
        return paramView;
      }
      if (paramView == null)
      {
        paramViewGroup = View.inflate(paramViewGroup.getContext(), R.i.ehg, null);
        localObject1 = new b();
        ((b)localObject1).RvJ = ((FrameLayout)paramViewGroup.findViewById(R.h.dKl));
        paramView = ((b)localObject1).RvJ;
        if (paramView != null) {}
        for (paramView = paramView.findViewById(R.h.dKk); paramView == null; paramView = null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
          AppMethodBeat.o(281948);
          throw paramView;
        }
        ((b)localObject1).RvK = ((CheckBox)paramView);
        ((b)localObject1).qps = ((ImageView)paramViewGroup.findViewById(R.h.item_icon));
        ((b)localObject1).mNb = ((TextView)paramViewGroup.findViewById(R.h.item_title));
        ((b)localObject1).HpD = ((TextView)paramViewGroup.findViewById(R.h.dKn));
        ((b)localObject1).timeTV = ((TextView)paramViewGroup.findViewById(R.h.dKp));
        paramView = ((b)localObject1).RvJ;
        if (paramView != null) {
          paramView.setOnClickListener((View.OnClickListener)new e(this));
        }
        kotlin.g.b.p.j(paramViewGroup, "convertView");
        paramViewGroup.setTag(localObject1);
        if (locall != null) {
          break label1399;
        }
        try
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFolderItem");
          AppMethodBeat.o(281948);
          throw paramView;
        }
        catch (Exception paramView)
        {
          Log.e(this.TAG, paramView.getMessage(), new Object[] { "item is ListFileItem:" + (locall instanceof FileSelectorUI.j) });
        }
      }
      label1399:
      FileSelectorUI.k localk;
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(281948);
        return paramViewGroup;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FolderViewHolder");
          AppMethodBeat.o(281948);
          throw paramView;
        }
        localObject1 = (b)paramViewGroup;
        paramViewGroup = paramView;
        break;
        localk = (FileSelectorUI.k)locall;
        localObject2 = ((b)localObject1).mNb;
        if (localObject2 != null)
        {
          if (localk == null) {
            break label1991;
          }
          paramView = localk.hnu();
          ((TextView)localObject2).setText(paramView);
        }
        if (localk == null) {
          break label1996;
        }
        paramView = Boolean.valueOf(localk.Rwi);
        label1449:
        if (paramView.booleanValue()) {
          break label1607;
        }
        paramView = ((b)localObject1).qps;
        if (paramView != null) {
          paramView.setImageResource(R.k.app_attach_file_icon_folders);
        }
        paramView = ((b)localObject1).RvJ;
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        paramView = ((b)localObject1).HpD;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = ((b)localObject1).timeTV;
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        paramView = ((b)localObject1).HpD;
        if (paramView != null) {
          paramView.setText((CharSequence)this.Rvw.getString(R.l.eEz, new Object[] { Integer.valueOf(localk.Rwh) }));
        }
        label1561:
        paramView = ((b)localObject1).RvK;
        if (paramView != null) {
          paramView.setChecked(this.RvE.contains(localk));
        }
        paramView = ((b)localObject1).RvJ;
        if (paramView != null) {
          paramView.setTag(Integer.valueOf(paramInt));
        }
      }
      label1607:
      label1644:
      Object localObject3;
      if ((3 == FileSelectorUI.a(this.Rvw)) || (4 == FileSelectorUI.a(this.Rvw)))
      {
        paramView = ((b)localObject1).RvJ;
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        paramView = ((b)localObject1).HpD;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = ((b)localObject1).timeTV;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = ((b)localObject1).HpD;
        if (paramView != null) {
          paramView.setText((CharSequence)Util.getSizeKB(localk.Rwe));
        }
        paramView = ((b)localObject1).timeTV;
        if (paramView != null) {
          paramView.setText(com.tencent.mm.pluginsdk.j.f.d((Context)this.Rvw.getContext(), localk.createTime, true));
        }
        localObject2 = localk.hnu();
        if (!brM(localObject2.toString())) {
          break label1966;
        }
        paramView = FileSelectorUI.c(this.Rvw);
        if (paramView == null) {
          break label2006;
        }
        localObject3 = localk.filePath;
        if (!Util.isNullOrNil((String)localObject3)) {
          break label1833;
        }
        Log.e(paramView.TAG, "getThumbnail fail, path not exist");
        break label2001;
      }
      for (;;)
      {
        if (paramView != null)
        {
          localObject2 = ((b)localObject1).qps;
          if (localObject2 == null) {
            break label1561;
          }
          ((ImageView)localObject2).setImageBitmap(paramView);
          break label1561;
          paramView = ((b)localObject1).RvJ;
          if (paramView == null) {
            break label1644;
          }
          paramView.setVisibility(0);
          break label1644;
          label1833:
          localObject3 = paramView.Rvw.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { localObject3 }, null);
          if (localObject3 == null) {
            break label2001;
          }
          if (((Cursor)localObject3).moveToFirst())
          {
            int i = ((Cursor)localObject3).getInt(((Cursor)localObject3).getColumnIndex("_id"));
            ((Cursor)localObject3).close();
            paramView = MediaStore.Images.Thumbnails.getThumbnail(paramView.Rvw.getContentResolver(), i, 3, null);
            continue;
          }
          ((Cursor)localObject3).close();
          break label2001;
        }
        paramView = ((b)localObject1).qps;
        if (paramView == null) {
          break label1561;
        }
        paramView.setImageResource(brL(localObject2.toString()));
        break label1561;
        label1966:
        paramView = ((b)localObject1).qps;
        if (paramView == null) {
          break label1561;
        }
        paramView.setImageResource(brL(localObject2.toString()));
        break label1561;
        label1991:
        paramView = null;
        break;
        label1996:
        paramView = null;
        break label1449;
        label2001:
        paramView = null;
        continue;
        label2006:
        paramView = null;
      }
    }
    
    public final int getViewTypeCount()
    {
      return this.RvD;
    }
    
    public final void hnp()
    {
      AppMethodBeat.i(281940);
      if (this.RvI != FileSelectorUI.h.RvX)
      {
        AppMethodBeat.o(281940);
        return;
      }
      com.tencent.mm.vfs.q localq = this.RvH.hnx();
      if (localq != null)
      {
        this.RvH.ad(localq);
        FileSelectorUI.c(this.Rvw).dlN();
        AppMethodBeat.o(281940);
        return;
      }
      AppMethodBeat.o(281940);
    }
    
    public final com.tencent.mm.vfs.q hnq()
    {
      AppMethodBeat.i(281941);
      if (!hnr())
      {
        AppMethodBeat.o(281941);
        return null;
      }
      com.tencent.mm.vfs.q localq = this.RvH.hnx();
      AppMethodBeat.o(281941);
      return localq;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FileViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "fromTV", "Landroid/widget/TextView;", "getFromTV", "()Landroid/widget/TextView;", "setFromTV", "(Landroid/widget/TextView;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "lineV", "Landroid/view/View;", "getLineV", "()Landroid/view/View;", "setLineV", "(Landroid/view/View;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "getSizeTV", "setSizeTV", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"})
    final class a
    {
      TextView HpD;
      FrameLayout RvJ;
      CheckBox RvK;
      TextView RvL;
      View RvM;
      TextView mNb;
      ImageView qps;
      TextView timeTV;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FolderViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "Landroid/widget/TextView;", "getSizeTV", "()Landroid/widget/TextView;", "setSizeTV", "(Landroid/widget/TextView;)V", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"})
    final class b
    {
      TextView HpD;
      FrameLayout RvJ;
      CheckBox RvK;
      TextView mNb;
      ImageView qps;
      TextView timeTV;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$TimeViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "titleTV", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "setTitleTV", "(Landroid/widget/TextView;)V", "app_release"})
    final class c
    {
      TextView mNb;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d
      implements View.OnClickListener
    {
      d(FileSelectorUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(249467);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = this.RvN;
        kotlin.g.b.p.j(paramView, "v");
        FileSelectorUI.e.a((FileSelectorUI.e)localObject, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(249467);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(FileSelectorUI.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(199487);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = this.RvN;
        kotlin.g.b.p.j(paramView, "v");
        FileSelectorUI.e.a((FileSelectorUI.e)localObject, paramView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$getView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(199487);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorReportHelper;", "", "()V", "keywordGroup", "Ljava/util/Vector;", "", "getKeywordGroup", "()Ljava/util/Vector;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/SendFileInWidgetStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/SendFileInWidgetStruct;", "composeKeywords", "doReport", "", "onSwitch", "from", "", "app_release"})
  public static final class f
  {
    final kb RvO;
    final Vector<String> RvP;
    
    public f()
    {
      AppMethodBeat.i(264706);
      this.RvO = new kb();
      this.RvP = new Vector();
      AppMethodBeat.o(264706);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "", "(Ljava/lang/String;I)V", "TYPE_INVALID", "TYPE_TIME", "TYPE_FILE", "TYPE_FOLDER", "app_release"})
  public static enum g
  {
    static
    {
      AppMethodBeat.i(278295);
      g localg1 = new g("TYPE_INVALID", 0);
      RvQ = localg1;
      g localg2 = new g("TYPE_TIME", 1);
      RvR = localg2;
      g localg3 = new g("TYPE_FILE", 2);
      RvS = localg3;
      g localg4 = new g("TYPE_FOLDER", 3);
      RvT = localg4;
      RvU = new g[] { localg1, localg2, localg3, localg4 };
      AppMethodBeat.o(278295);
    }
    
    private g() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "", "(Ljava/lang/String;I)V", "FROM_CHATTING", "FROM_FAV", "FROM_SDCARD", "FROM_ALBUM", "app_release"})
  public static enum h
  {
    static
    {
      AppMethodBeat.i(292046);
      h localh1 = new h("FROM_CHATTING", 0);
      RvV = localh1;
      h localh2 = new h("FROM_FAV", 1);
      RvW = localh2;
      h localh3 = new h("FROM_SDCARD", 2);
      RvX = localh3;
      h localh4 = new h("FROM_ALBUM", 3);
      RvY = localh4;
      RvZ = new h[] { localh1, localh2, localh3, localh4 };
      AppMethodBeat.o(292046);
    }
    
    private h() {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "curFile", "Lcom/tencent/mm/vfs/VFSFile;", "filterDir", "", "rootPath", "subFiles", "", "[Lcom/tencent/mm/vfs/VFSFile;", "createTargetList", "", "deduplicateFolders", "files", "([Lcom/tencent/mm/vfs/VFSFile;)[Lcom/tencent/mm/vfs/VFSFile;", "getParent", "initASync", "loadMoreAsync", "setPath", "setRoot", "root", "sort", "([Lcom/tencent/mm/vfs/VFSFile;)V", "FileSort", "app_release"})
  public final class n
    extends FileSelectorUI.d
  {
    private com.tencent.mm.vfs.q Rvc;
    private com.tencent.mm.vfs.q[] Rvd;
    private com.tencent.mm.vfs.q Rwl;
    boolean Rwm;
    
    public n()
    {
      super(localObject);
      AppMethodBeat.i(200779);
      this.Rvd = new com.tencent.mm.vfs.q[0];
      AppMethodBeat.o(200779);
    }
    
    private final void a(com.tencent.mm.vfs.q[] paramArrayOfq)
    {
      AppMethodBeat.i(200776);
      if (paramArrayOfq != null) {
        if (paramArrayOfq.length != 0) {
          break label26;
        }
      }
      label26:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(200776);
        return;
      }
      Object localObject2 = (List)new ArrayList();
      Object localObject1 = (List)new ArrayList();
      int j = paramArrayOfq.length;
      i = 0;
      if (i < j)
      {
        Object localObject3 = paramArrayOfq[i];
        a locala;
        if (localObject3 != null)
        {
          locala = new a();
          locala.file = ((com.tencent.mm.vfs.q)localObject3);
          locala.time = ((com.tencent.mm.vfs.q)localObject3).lastModified();
          if (!((com.tencent.mm.vfs.q)localObject3).isDirectory()) {
            break label194;
          }
          localObject3 = com.tencent.mm.platformtools.f.ZJ(((com.tencent.mm.vfs.q)localObject3).getName());
          kotlin.g.b.p.j(localObject3, "CnToSpell.getFullSpell(file.name)");
          if (localObject3 == null)
          {
            paramArrayOfq = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(200776);
            throw paramArrayOfq;
          }
          localObject3 = ((String)localObject3).toUpperCase();
          kotlin.g.b.p.j(localObject3, "(this as java.lang.String).toUpperCase()");
          kotlin.g.b.p.k(localObject3, "<set-?>");
          locala.Rwn = ((String)localObject3);
          ((List)localObject2).add(locala);
        }
        for (;;)
        {
          i += 1;
          break;
          label194:
          ((List)localObject1).add(locala);
        }
      }
      kotlin.a.j.a((List)localObject2, (Comparator)d.Rwq);
      Collections.sort((List)localObject1, (Comparator)e.Rwr);
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfq[i] = ((a)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfq[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(200776);
    }
    
    private final void ac(com.tencent.mm.vfs.q paramq)
    {
      this.Rwl = paramq;
      this.Rwm = false;
    }
    
    private final void hnw()
    {
      AppMethodBeat.i(200771);
      com.tencent.mm.vfs.q[] arrayOfq = this.Rvd;
      if (arrayOfq != null)
      {
        int k = arrayOfq.length;
        int i = 0;
        while (i < k)
        {
          Object localObject = arrayOfq[i];
          String str1;
          if (localObject != null)
          {
            str1 = ((com.tencent.mm.vfs.q)localObject).bOF();
            kotlin.g.b.p.j(str1, "vFile.absolutePath");
            if (Util.isNullOrNil(str1)) {
              Log.e("MicroMsg.FileSelectorUI", "createTargetList, folder filePath is null, filter!!");
            }
          }
          else
          {
            i += 1;
            continue;
          }
          FileSelectorUI.k localk = new FileSelectorUI.k(FileSelectorUI.this);
          localk.a(FileSelectorUI.g.RvT);
          localk.d(FileSelectorUI.h.RvX);
          boolean bool;
          label114:
          int j;
          if (!((com.tencent.mm.vfs.q)localObject).isDirectory())
          {
            bool = true;
            localk.Rwi = bool;
            String str2 = ((com.tencent.mm.vfs.q)localObject).getName();
            kotlin.g.b.p.j(str2, "vFile.name");
            localk.aA((CharSequence)str2);
            localk.filePath = str1;
            if (!((com.tencent.mm.vfs.q)localObject).isDirectory()) {
              break label214;
            }
            localObject = ((com.tencent.mm.vfs.q)localObject).a((z)FileSelectorUI.n.b.Rwp);
            if (localObject != null) {
              break label207;
            }
            j = 0;
            label180:
            localk.Rwh = j;
          }
          for (;;)
          {
            this.RvB.add(localk);
            break;
            bool = false;
            break label114;
            label207:
            j = localObject.length;
            break label180;
            label214:
            if (((com.tencent.mm.vfs.q)localObject).ifH())
            {
              localk.Rwe = ((com.tencent.mm.vfs.q)localObject).length();
              localk.createTime = ((com.tencent.mm.vfs.q)localObject).lastModified();
            }
          }
        }
        AppMethodBeat.o(200771);
        return;
      }
      AppMethodBeat.o(200771);
    }
    
    public final void ad(com.tencent.mm.vfs.q paramq)
    {
      Set localSet = null;
      AppMethodBeat.i(200762);
      kotlin.g.b.p.k(paramq, "curFile");
      this.Rvc = paramq;
      paramq = this.Rvc;
      if (paramq == null) {
        kotlin.g.b.p.bGy("curFile");
      }
      label101:
      Object localObject1;
      int i;
      if (paramq != null)
      {
        paramq = this.Rvc;
        if (paramq == null) {
          kotlin.g.b.p.bGy("curFile");
        }
        if (paramq == null) {
          break label212;
        }
        paramq = Boolean.valueOf(paramq.ifC());
        if (paramq.booleanValue())
        {
          paramq = this.Rvc;
          if (paramq == null) {
            kotlin.g.b.p.bGy("curFile");
          }
          if (paramq == null) {
            break label217;
          }
          paramq = Boolean.valueOf(paramq.isDirectory());
          if (paramq.booleanValue())
          {
            localObject1 = this.Rvc;
            if (localObject1 == null) {
              kotlin.g.b.p.bGy("curFile");
            }
            paramq = localSet;
            if (localObject1 != null) {
              paramq = ((com.tencent.mm.vfs.q)localObject1).a((com.tencent.mm.vfs.s)new c(this));
            }
            this.Rvd = paramq;
            paramq = this.Rvd;
            if (paramq != null) {
              if (paramq != null)
              {
                if (paramq.length != 0) {
                  break label222;
                }
                i = 1;
                label175:
                if (i == 0) {
                  break label227;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.Rvd = paramq;
        a(this.Rvd);
        this.RvB.clear();
        hnw();
        AppMethodBeat.o(200762);
        return;
        label212:
        paramq = null;
        break;
        label217:
        paramq = null;
        break label101;
        label222:
        i = 0;
        break label175;
        label227:
        localSet = (Set)new HashSet();
        localObject1 = (List)new ArrayList();
        int j = paramq.length;
        i = 0;
        if (i < j)
        {
          Object localObject2 = paramq[i];
          if (localObject2 != null)
          {
            if (localObject2.isDirectory()) {
              break label296;
            }
            ((List)localObject1).add(localObject2);
          }
          for (;;)
          {
            i += 1;
            break;
            label296:
            String str = localObject2.bOF();
            kotlin.g.b.p.j(str, "file.absolutePath");
            if (!localSet.contains(str))
            {
              str = localObject2.bOF();
              kotlin.g.b.p.j(str, "file.absolutePath");
              localSet.add(str);
              ((List)localObject1).add(localObject2);
            }
          }
        }
        paramq = ((Collection)localObject1).toArray(new com.tencent.mm.vfs.q[0]);
        if (paramq == null)
        {
          paramq = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(200762);
          throw paramq;
        }
        paramq = (com.tencent.mm.vfs.q[])paramq;
      }
    }
    
    public final void hnn()
    {
      AppMethodBeat.i(200777);
      ac(new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSG()));
      ad(new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSG()));
      AppMethodBeat.o(200777);
    }
    
    public final com.tencent.mm.vfs.q hnx()
    {
      AppMethodBeat.i(200773);
      com.tencent.mm.vfs.q localq = this.Rvc;
      if (localq == null) {
        kotlin.g.b.p.bGy("curFile");
      }
      int i = localq.hashCode();
      localq = this.Rwl;
      if (localq == null) {
        kotlin.g.b.p.bGy("rootPath");
      }
      if (i == localq.hashCode())
      {
        AppMethodBeat.o(200773);
        return null;
      }
      localq = this.Rvc;
      if (localq == null) {
        kotlin.g.b.p.bGy("curFile");
      }
      if (localq != null)
      {
        localq = localq.ifB();
        AppMethodBeat.o(200773);
        return localq;
      }
      AppMethodBeat.o(200773);
      return null;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;)V", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFile", "()Lcom/tencent/mm/vfs/VFSFile;", "setFile", "(Lcom/tencent/mm/vfs/VFSFile;)V", "spell", "", "getSpell", "()Ljava/lang/String;", "setSpell", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "app_release"})
    final class a
    {
      String Rwn = "";
      com.tencent.mm.vfs.q file;
      long time;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pathname", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
    static final class c
      implements com.tencent.mm.vfs.s
    {
      c(FileSelectorUI.n paramn) {}
      
      public final boolean accept(com.tencent.mm.vfs.q paramq)
      {
        AppMethodBeat.i(289503);
        kotlin.g.b.p.k(paramq, "pathname");
        if (paramq.isHidden())
        {
          AppMethodBeat.o(289503);
          return false;
        }
        if ((!this.Rwo.Rwm) || (!paramq.isDirectory()))
        {
          AppMethodBeat.o(289503);
          return true;
        }
        AppMethodBeat.o(289503);
        return false;
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "f1", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "kotlin.jvm.PlatformType", "f2", "compare"})
    static final class d<T>
      implements Comparator<FileSelectorUI.n.a>
    {
      public static final d Rwq;
      
      static
      {
        AppMethodBeat.i(288323);
        Rwq = new d();
        AppMethodBeat.o(288323);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "f1", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "kotlin.jvm.PlatformType", "f2", "compare"})
    static final class e<T>
      implements Comparator<FileSelectorUI.n.a>
    {
      public static final e Rwr;
      
      static
      {
        AppMethodBeat.i(284508);
        Rwr = new e();
        AppMethodBeat.o(284508);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(285442);
      Log.i("MicroMsg.FileSelectorUI", "backBtn");
      FileSelectorUI.h(this.Rvw);
      AppMethodBeat.o(285442);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class r
    implements MenuItem.OnMenuItemClickListener
  {
    r(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(279562);
      FileSelectorUI.i(this.Rvw);
      AppMethodBeat.o(279562);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$3", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"})
  public static final class s
    implements DropdownListView.d
  {
    public final void a(DropdownListView.c paramc)
    {
      AppMethodBeat.i(283444);
      FileSelectorUI.f(this.Rvw);
      FileSelectorUI.a(this.Rvw, paramc);
      if ((paramc == null) || (kotlin.g.b.p.h(Util.nullAs(FileSelectorUI.k(this.Rvw), ""), paramc.name))) {
        Log.w("MicroMsg.FileSelectorUI", "want to reset item, item is " + paramc + " or no need load data when same load");
      }
      for (;;)
      {
        paramc = FileSelectorUI.j(this.Rvw);
        if (paramc != null) {
          FileSelectorUI.b(this.Rvw, paramc);
        }
        FileSelectorUI.m(this.Rvw).euH();
        AppMethodBeat.o(283444);
        return;
        Object localObject = FileSelectorUI.l(this.Rvw);
        if (localObject != null) {
          ((ListView)localObject).setVisibility(0);
        }
        FileSelectorUI.e(this.Rvw).setVisibility(8);
        this.Rvw.addSearchMenu(true, (com.tencent.mm.ui.tools.t)FileSelectorUI.g(this.Rvw));
        localObject = FileSelectorUI.d(this.Rvw);
        switch (paramc.type)
        {
        }
        for (;;)
        {
          switch (paramc.type)
          {
          default: 
            break;
          case 1: 
            paramc = FileSelectorUI.c(this.Rvw);
            if (paramc == null) {
              break;
            }
            paramc.a(FileSelectorUI.h.RvV);
            break;
            localObject = ((FileSelectorUI.f)localObject).RvO;
            ((kb)localObject).uE(((kb)localObject).amj() + 1L);
            continue;
            localObject = ((FileSelectorUI.f)localObject).RvO;
            ((kb)localObject).uF(((kb)localObject).amk() + 1L);
            continue;
            localObject = ((FileSelectorUI.f)localObject).RvO;
            ((kb)localObject).uG(((kb)localObject).aml() + 1L);
            continue;
            localObject = ((FileSelectorUI.f)localObject).RvO;
            ((kb)localObject).uM(((kb)localObject).amt() + 1L);
          }
        }
        paramc = FileSelectorUI.c(this.Rvw);
        if (paramc != null)
        {
          paramc.a(FileSelectorUI.h.RvW);
          continue;
          paramc = FileSelectorUI.c(this.Rvw);
          if (paramc != null)
          {
            paramc.a(FileSelectorUI.h.RvX);
            continue;
            paramc = FileSelectorUI.c(this.Rvw);
            if (paramc != null) {
              paramc.a(FileSelectorUI.h.RvY);
            }
            this.Rvw.removeSearchMenu();
            paramc = FileSelectorUI.l(this.Rvw);
            if (paramc != null) {
              paramc.setVisibility(8);
            }
            paramc = FileSelectorUI.e(this.Rvw);
            if (paramc != null) {
              paramc.setVisibility(0);
            }
            paramc = FileSelectorUI.e(this.Rvw);
            if (paramc != null)
            {
              localObject = paramc.RyL;
              if (localObject != null) {
                paramc.Ta(((com.tencent.mm.pluginsdk.ui.tools.a.a.a.a)localObject).BZH.size());
              }
            }
          }
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$4", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "onItemStateChanged", "", "expanded", "", "app_release"})
  public static final class t
    implements DropdownListView.e
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class u
    implements View.OnTouchListener
  {
    u(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(254658);
      this.Rvw.hideVKB();
      AppMethodBeat.o(254658);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$6", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "app_release"})
  public static final class v
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(276805);
      kotlin.g.b.p.k(paramAbsListView, "view");
      AppMethodBeat.o(276805);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(276804);
      kotlin.g.b.p.k(paramAbsListView, "view");
      if (FileSelectorUI.n(this.Rvw))
      {
        Log.i("MicroMsg.FileSelectorUI", "search mode, not load data");
        AppMethodBeat.o(276804);
        return;
      }
      if ((paramInt == 0) && (FileSelectorUI.o(this.Rvw)))
      {
        Log.i("MicroMsg.FileSelectorUI", "will load data when it at bottom");
        paramAbsListView = FileSelectorUI.c(this.Rvw);
        FileSelectorUI.h localh = paramAbsListView.RvI;
        switch (f.yBl[localh.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(276804);
        return;
        paramAbsListView.RvF.hnm();
        AppMethodBeat.o(276804);
        return;
        paramAbsListView.RvG.hnm();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$7", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "onItemSelect", "isChecked", "", "app_release"})
  public static final class w
    implements a.d
  {
    public final void a(int paramInt1, View paramView, int paramInt2)
    {
      AppMethodBeat.i(200720);
      FileSelectorUI.d(this.Rvw).RvO.amn();
      AppMethodBeat.o(200720);
    }
    
    public final void bN(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(200724);
      if (paramInt < 5) {
        paramInt = 1;
      }
      while (paramBoolean) {
        if (paramInt != 0)
        {
          localkb = FileSelectorUI.d(this.Rvw).RvO;
          localkb.uK(localkb.amr() + 1L);
          AppMethodBeat.o(200724);
          return;
          paramInt = 0;
        }
        else
        {
          localkb = FileSelectorUI.d(this.Rvw).RvO;
          localkb.uL(localkb.ams() + 1L);
          AppMethodBeat.o(200724);
          return;
        }
      }
      if (paramInt != 0)
      {
        localkb = FileSelectorUI.d(this.Rvw).RvO;
        localkb.uK(localkb.amr() - 1L);
        AppMethodBeat.o(200724);
        return;
      }
      kb localkb = FileSelectorUI.d(this.Rvw).RvO;
      localkb.uL(localkb.ams() - 1L);
      AppMethodBeat.o(200724);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$9", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "app_release"})
  public static final class y
    implements t.b
  {
    public final boolean aat(String paramString)
    {
      AppMethodBeat.i(288045);
      kotlin.g.b.p.k(paramString, "searchText");
      AppMethodBeat.o(288045);
      return false;
    }
    
    public final void aau(String paramString)
    {
      AppMethodBeat.i(288044);
      kotlin.g.b.p.k(paramString, "searchText");
      if (!FileSelectorUI.p(this.Rvw))
      {
        View localView = FileSelectorUI.r(this.Rvw);
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      FileSelectorUI.c(this.Rvw).KG(paramString);
      FileSelectorUI.d(this.Rvw).RvP.add(paramString);
      FileSelectorUI.q(this.Rvw);
      AppMethodBeat.o(288044);
    }
    
    public final void bxH()
    {
      AppMethodBeat.i(288046);
      FileSelectorUI.a(this.Rvw, false);
      Log.d("MicroMsg.FileSelectorUI", "onQuitSearch()");
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      this.Rvw.getController().supportInvalidateOptionsMenu();
      View localView = FileSelectorUI.r(this.Rvw);
      if (localView != null)
      {
        localView.setVisibility(8);
        AppMethodBeat.o(288046);
        return;
      }
      AppMethodBeat.o(288046);
    }
    
    public final void bxI()
    {
      AppMethodBeat.i(288047);
      if (FileSelectorUI.m(this.Rvw).tFX)
      {
        localObject = FileSelectorUI.m(this.Rvw);
        if (localObject != null) {
          ((DropdownListView)localObject).euH();
        }
      }
      FileSelectorUI.a(this.Rvw, true);
      Object localObject = FileSelectorUI.r(this.Rvw);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = FileSelectorUI.g(this.Rvw);
      if (localObject != null) {
        ((com.tencent.mm.ui.tools.s)localObject).Hd(true);
      }
      FileSelectorUI.d(this.Rvw).RvO.amm();
      Log.i("MicroMsg.FileSelectorUI", "enter search");
      AppMethodBeat.o(288047);
    }
    
    public final void bxJ() {}
    
    public final void bxK() {}
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FileSelectorUI.y paramy) {}
      
      public final void run()
      {
        AppMethodBeat.i(273257);
        if (FileSelectorUI.c(this.Rwt.Rvw) != null) {
          FileSelectorUI.c(this.Rwt.Rvw).KG("");
        }
        AppMethodBeat.o(273257);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"})
  static final class z
    implements AdapterView.OnItemClickListener
  {
    z(FileSelectorUI paramFileSelectorUI) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(219279);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAdapterView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramLong);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramAdapterView = FileSelectorUI.c(this.Rvw);
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.aqZ(paramInt); FileSelectorUI.w(this.Rvw); paramAdapterView = null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(219279);
        return;
      }
      paramView = paramAdapterView.Rwj;
      switch (g.$EnumSwitchMapping$0[paramView.ordinal()])
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(219279);
        return;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(219279);
        return;
        FileSelectorUI.d(this.Rvw).RvO.amn();
        if (paramAdapterView == null) {
          try
          {
            paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFolderItem");
            AppMethodBeat.o(219279);
            throw paramAdapterView;
          }
          catch (Exception paramAdapterView)
          {
            Log.e("MicroMsg.FileSelectorUI", "error:" + paramAdapterView.getMessage());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(219279);
            return;
          }
        }
        paramAdapterView = (FileSelectorUI.k)paramAdapterView;
        if (paramAdapterView.Rwi)
        {
          FileSelectorUI.a(this.Rvw, paramAdapterView.filePath, paramAdapterView.hnu().toString());
        }
        else
        {
          if (Util.isNullOrNil(paramAdapterView.filePath))
          {
            Log.e("MicroMsg.FileSelectorUI", "can not open sub path because current path not exist");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(219279);
            return;
          }
          paramAdapterView = paramAdapterView.filePath;
          if (paramAdapterView != null)
          {
            paramView = FileSelectorUI.c(this.Rvw);
            kotlin.g.b.p.k(paramAdapterView, "path");
            if (paramView.RvI == FileSelectorUI.h.RvX)
            {
              paramView.RvH.ad(new com.tencent.mm.vfs.q(paramAdapterView));
              FileSelectorUI.c(paramView.Rvw).dlN();
            }
          }
          FileSelectorUI.c(this.Rvw).notifyDataSetChanged();
          continue;
          FileSelectorUI.d(this.Rvw).RvO.amn();
          if (paramAdapterView == null)
          {
            paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
            AppMethodBeat.o(219279);
            throw paramAdapterView;
          }
          paramView = ((FileSelectorUI.j)paramAdapterView).filePath;
          paramInt = n.g(((FileSelectorUI.j)paramAdapterView).hnu(), ".") + 1;
          if (paramInt >= ((FileSelectorUI.j)paramAdapterView).hnu().length())
          {
            Log.i("MicroMsg.FileSelectorUI", "open file error : file path error");
            com.tencent.mm.ui.base.w.cS((Context)this.Rvw, this.Rvw.getResources().getString(R.l.eRK));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(219279);
            return;
          }
          localObject = ((FileSelectorUI.j)paramAdapterView).hnu();
          localObject = ((CharSequence)localObject).subSequence(paramInt, ((CharSequence)localObject).length()).toString();
          if ((3 == FileSelectorUI.a(this.Rvw)) && (!((FileSelectorUI.j)paramAdapterView).Rwg) && (FileSelectorUI.h.RvV == FileSelectorUI.c(this.Rvw).RvI))
          {
            if ((n.L((String)localObject, "ppt", true)) || (n.L((String)localObject, "pdf", true)) || (n.L((String)localObject, "doc", true)) || (n.L((String)localObject, "docx", true)) || (n.L((String)localObject, "pptx", true))) {
              FileSelectorUI.a(this.Rvw, ((FileSelectorUI.j)paramAdapterView).msgId);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(219279);
              return;
              com.tencent.mm.ui.base.w.cS((Context)this.Rvw, this.Rvw.getResources().getString(R.l.eRL));
            }
          }
          if ((FileSelectorUI.h.RvW == FileSelectorUI.c(this.Rvw).RvI) && (!u.agG(((FileSelectorUI.j)paramAdapterView).filePath)))
          {
            paramAdapterView = (FileSelectorUI.l)paramAdapterView;
            FileSelectorUI.a(this.Rvw, ((FileSelectorUI.i)paramAdapterView).localId, ((FileSelectorUI.i)paramAdapterView).hns());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(219279);
            return;
          }
          FileSelectorUI.a(this.Rvw, paramView, ((FileSelectorUI.j)paramAdapterView).hnu().toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI
 * JD-Core Version:    0.7.0.1
 */