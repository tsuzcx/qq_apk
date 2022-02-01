package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.autogen.mmdata.rpt.ms;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.l.c;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.pluginsdk.ui.pin.PinnedHeaderRecyclerView;
import com.tencent.mm.pluginsdk.ui.tools.b.a.b.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.ui.y.b;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.j;>;
import java.util.Set;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.j;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(19)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/plugin/secdata/ui/MMSecDataActivity;", "()V", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "albumUIC", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;", "getAlbumUIC", "()Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;", "albumUIC$delegate", "Lkotlin/Lazy;", "dropdownItemName", "", "dropdownListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "dropdownListView", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "emptyView", "Landroid/widget/TextView;", "exitMultiTalkListener", "Lcom/tencent/mm/sdk/event/IListener;", "isFirstTextChanged", "", "isSearching", "listView", "Landroid/widget/ListView;", "mIsToScreenProfile", "onItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "reportHelper", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorReportHelper;", "scene", "", "screenProfileReadyUI", "Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "searchMask", "Landroid/view/View;", "searchViewHelper", "Lcom/tencent/mm/ui/tools/SearchViewControlKeyBoardShowHelper;", "toUserName", "doSendFile", "", "finish", "getForceOrientation", "getLayoutId", "getSelectedCount", "goToScreenProfile", "name", "path", "ext", "gotoAppAttachDownloadUI", "msgId", "", "gotoUnDownloadFavDetail", "favLocalId", "favDataId", "initDropdownListTitle", "isActionbarCenterLayoutMode", "isListAtBottom", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "cancel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "openFile", "recoverDropdownTitle", "resetItem", "item", "screenProfileByFinderLive", "screenProfileByMultiTalk", "setDropdownListClickListener", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "updateDropdownListTitle", "title", "updateState", "ChattingFileSource", "Companion", "FavFileSource", "FileDataSource", "FileSelectorAdapter", "FileSelectorReportHelper", "FileType", "FromType", "ListFavFileItem", "ListFileItem", "ListFolderItem", "ListItem", "ListTimeItem", "SdcardFileSource", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileSelectorUI
  extends MMSecDataActivity
{
  public static final FileSelectorUI.b YrG;
  private final j YrH;
  private e YrI;
  private r YrJ;
  private View YrK;
  private String YrL;
  private DropdownListView YrM;
  private DropdownListView.c YrN;
  private boolean YrO;
  private f YrP;
  private ao YrQ;
  private boolean YrR;
  private String hHa;
  private TextView njO;
  private ListView qgc;
  private int scene;
  private final IListener<?> tjd;
  private boolean vDm;
  private final AdapterView.OnItemClickListener vEc;
  
  static
  {
    AppMethodBeat.i(245757);
    YrG = new FileSelectorUI.b((byte)0);
    AppMethodBeat.o(245757);
  }
  
  public FileSelectorUI()
  {
    AppMethodBeat.i(245602);
    this.YrH = kotlin.k.cm((kotlin.g.a.a)new p(this));
    this.tjd = ((IListener)new FileSelectorUI.exitMultiTalkListener.1(this, com.tencent.mm.app.f.hfK));
    this.YrO = true;
    this.YrP = new f();
    this.vEc = new FileSelectorUI..ExternalSyntheticLambda9(this);
    AppMethodBeat.o(245602);
  }
  
  private final void Kh(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(245629);
    if (this.YrM == null) {
      kotlin.g.b.s.bIx("dropdownListView");
    }
    Object localObject3 = this.YrM;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("dropdownListView");
      localObject1 = null;
    }
    if (((DropdownListView)localObject1).wJw)
    {
      localObject3 = this.YrM;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("dropdownListView");
        localObject1 = null;
      }
      ((DropdownListView)localObject1).fBC();
      playActionBarOperationAreaAnim();
    }
    if (!paramBoolean)
    {
      localObject3 = this.YrI;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      if (((e)localObject1).iOi() != null)
      {
        localObject3 = this.YrI;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("adapter");
          localObject1 = null;
        }
        ((e)localObject1).iOh();
        localObject1 = this.YrI;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("adapter");
          localObject1 = localObject2;
        }
        for (;;)
        {
          ((e)localObject1).notifyDataSetChanged();
          AppMethodBeat.o(245629);
          return;
        }
      }
    }
    setResult(-2);
    if (paramBoolean) {
      setResult(0);
    }
    finish();
    AppMethodBeat.o(245629);
  }
  
  private static final void a(FileSelectorUI paramFileSelectorUI)
  {
    Object localObject = null;
    AppMethodBeat.i(245677);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "onAlbumChooserViewClick.");
    paramFileSelectorUI.YrN = null;
    paramFileSelectorUI.playActionBarOperationAreaAnim();
    paramFileSelectorUI = paramFileSelectorUI.YrM;
    if (paramFileSelectorUI == null)
    {
      kotlin.g.b.s.bIx("dropdownListView");
      paramFileSelectorUI = localObject;
    }
    for (;;)
    {
      paramFileSelectorUI.fBC();
      AppMethodBeat.o(245677);
      return;
    }
  }
  
  private static final void a(FileSelectorUI paramFileSelectorUI, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(245674);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFileSelectorUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramAdapterView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    paramView = paramFileSelectorUI.YrI;
    paramAdapterView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("adapter");
      paramAdapterView = null;
    }
    localObject1 = paramAdapterView.axf(paramInt);
    if (paramFileSelectorUI.YrR)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(245674);
      return;
    }
    paramAdapterView = ((FileSelectorUI.l)localObject1).YsE;
    switch (o.$EnumSwitchMapping$0[paramAdapterView.ordinal()])
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(245674);
      return;
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(245674);
      return;
      paramFileSelectorUI.YrP.Ysj.jcg = 1L;
      try
      {
        paramAdapterView = (FileSelectorUI.k)localObject1;
        if (paramAdapterView.YsD) {
          paramFileSelectorUI.pr(paramAdapterView.filePath, paramAdapterView.iOm().toString());
        }
      }
      catch (Exception paramFileSelectorUI)
      {
        Log.e("MicroMsg.FileSelectorUI", kotlin.g.b.s.X("error:", paramFileSelectorUI.getMessage()));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(245674);
        return;
      }
      if (Util.isNullOrNil(paramAdapterView.filePath))
      {
        Log.e("MicroMsg.FileSelectorUI", "can not open sub path because current path not exist");
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(245674);
        return;
      }
      localObject1 = paramAdapterView.filePath;
      if (localObject1 != null)
      {
        paramView = paramFileSelectorUI.YrI;
        paramAdapterView = paramView;
        if (paramView == null)
        {
          kotlin.g.b.s.bIx("adapter");
          paramAdapterView = null;
        }
        kotlin.g.b.s.u(localObject1, "path");
        if (paramAdapterView.Ysd == h.Yss)
        {
          paramAdapterView.Ysc.ag(new com.tencent.mm.vfs.u((String)localObject1));
          paramView = paramAdapterView.YrS.YrI;
          paramAdapterView = paramView;
          if (paramView == null)
          {
            kotlin.g.b.s.bIx("adapter");
            paramAdapterView = null;
          }
          paramAdapterView.dSD();
        }
      }
      paramAdapterView = paramFileSelectorUI.YrI;
      paramFileSelectorUI = paramAdapterView;
      if (paramAdapterView == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramFileSelectorUI = null;
      }
      paramFileSelectorUI.notifyDataSetChanged();
      continue;
      paramFileSelectorUI.YrP.Ysj.jcg = 1L;
      localObject2 = ((FileSelectorUI.j)localObject1).filePath;
      paramInt = n.g(((FileSelectorUI.j)localObject1).iOm(), ".") + 1;
      if (paramInt >= ((FileSelectorUI.j)localObject1).iOm().length())
      {
        Log.i("MicroMsg.FileSelectorUI", "open file error : file path error");
        aa.dc((Context)paramFileSelectorUI, paramFileSelectorUI.getResources().getString(R.l.gUq));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(245674);
        return;
      }
      paramAdapterView = ((FileSelectorUI.j)localObject1).iOm();
      Object localObject3 = paramAdapterView.subSequence(paramInt, paramAdapterView.length()).toString();
      if ((3 == paramFileSelectorUI.scene) && (!((FileSelectorUI.j)localObject1).YsB))
      {
        h localh = h.Ysq;
        paramView = paramFileSelectorUI.YrI;
        paramAdapterView = paramView;
        if (paramView == null)
        {
          kotlin.g.b.s.bIx("adapter");
          paramAdapterView = null;
        }
        if (localh == paramAdapterView.Ysd)
        {
          if ((n.T((String)localObject3, "ppt", true)) || (n.T((String)localObject3, "pdf", true)) || (n.T((String)localObject3, "doc", true)) || (n.T((String)localObject3, "docx", true)) || (n.T((String)localObject3, "pptx", true)))
          {
            paramLong = ((FileSelectorUI.j)localObject1).msgId;
            if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable()) {
              aa.j((Context)paramFileSelectorUI.getContext(), null);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(245674);
            return;
            paramAdapterView = new Intent();
            paramAdapterView.putExtra("scene", paramFileSelectorUI.scene);
            paramAdapterView.setClassName((Context)paramFileSelectorUI, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            paramAdapterView.putExtra("app_msg_id", paramLong);
            paramFileSelectorUI.startActivityForResult(paramAdapterView, 4);
            continue;
            aa.dc((Context)paramFileSelectorUI, paramFileSelectorUI.getResources().getString(R.l.gUr));
          }
        }
      }
      localObject3 = h.Ysr;
      paramView = paramFileSelectorUI.YrI;
      paramAdapterView = paramView;
      if (paramView == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramAdapterView = null;
      }
      if ((localObject3 == paramAdapterView.Ysd) && (!com.tencent.mm.vfs.y.ZC(((FileSelectorUI.j)localObject1).filePath)))
      {
        paramAdapterView = (FileSelectorUI.l)localObject1;
        paramLong = ((FileSelectorUI.i)paramAdapterView).localId;
        paramAdapterView = ((FileSelectorUI.i)paramAdapterView).iOk();
        paramView = new Intent();
        paramView.putExtra("key_detail_info_id", paramLong);
        paramView.putExtra("key_detail_data_id", paramAdapterView);
        paramView.putExtra("show_share", true);
        com.tencent.mm.plugin.fav.a.b.b((Context)paramFileSelectorUI.getContext(), ".ui.detail.FavoriteFileDetailUI", paramView);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(245674);
        return;
      }
      paramFileSelectorUI.pr((String)localObject2, ((FileSelectorUI.j)localObject1).iOm().toString());
    }
  }
  
  private static final boolean a(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245636);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "backBtn");
    paramFileSelectorUI.Kh(true);
    AppMethodBeat.o(245636);
    return false;
  }
  
  private static final boolean a(FileSelectorUI paramFileSelectorUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(245651);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    paramFileSelectorUI.hideVKB();
    AppMethodBeat.o(245651);
    return false;
  }
  
  private static final boolean b(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245643);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Object localObject3 = (List)new ArrayList();
    Object localObject4 = (List)new ArrayList();
    Object localObject1 = paramFileSelectorUI.YrI;
    paramMenuItem = (MenuItem)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("adapter");
      paramMenuItem = null;
    }
    paramMenuItem = paramMenuItem.YrZ.iterator();
    Object localObject5;
    while (paramMenuItem.hasNext())
    {
      localObject1 = (FileSelectorUI.j)paramMenuItem.next();
      if (((FileSelectorUI.j)localObject1).iOn() == h.Ysr)
      {
        localObject5 = paramFileSelectorUI.YrP.Ysj;
        ((ms)localObject5).jci += 1L;
        ((List)localObject4).add(localObject1);
      }
      else
      {
        ((List)localObject3).add(localObject1);
        if (((FileSelectorUI.j)localObject1).iOn() == h.Ysq)
        {
          localObject1 = paramFileSelectorUI.YrP.Ysj;
          ((ms)localObject1).jch += 1L;
        }
        else if (((FileSelectorUI.j)localObject1).iOn() == h.Yss)
        {
          localObject1 = paramFileSelectorUI.YrP.Ysj;
          ((ms)localObject1).jcj += 1L;
        }
      }
    }
    if (((List)localObject4).size() > 0)
    {
      paramMenuItem = ((List)localObject4).iterator();
      while (paramMenuItem.hasNext())
      {
        localObject4 = (FileSelectorUI.j)paramMenuItem.next();
        Object localObject6;
        try
        {
          localObject6 = (FileSelectorUI.i)localObject4;
          localObject1 = ((FileSelectorUI.j)localObject6).filePath;
          if ((!Util.isNullOrNil(((FileSelectorUI.i)localObject4).Ysw)) && (((FileSelectorUI.j)localObject4).YsA == 0)) {
            break label372;
          }
          if (((FileSelectorUI.j)localObject4).YsA != 2) {
            break label348;
          }
          int i = ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFavSizeLimitInMB(true, 8);
          com.tencent.mm.ui.base.k.cZ((Context)paramFileSelectorUI.getContext(), paramFileSelectorUI.getContext().getString(R.l.favorite_detail_illegal_trans_big_file_format, new Object[] { Integer.valueOf(i) }));
        }
        catch (ClassCastException localClassCastException)
        {
          Log.e("MicroMsg.FileSelectorUI", localClassCastException.getMessage());
        }
        continue;
        label348:
        com.tencent.mm.ui.base.k.cZ((Context)paramFileSelectorUI.getContext(), paramFileSelectorUI.getContext().getString(R.l.favorite_detail_illegal_trans_file));
        continue;
        label372:
        if ((localClassCastException == null) || (!((FileSelectorUI.j)localObject4).YsB))
        {
          Log.e("MicroMsg.FileSelectorUI", "path:" + localClassCastException + ", download:" + ((FileSelectorUI.j)localObject4).YsB);
          com.tencent.mm.ui.base.k.cZ((Context)paramFileSelectorUI.getContext(), paramFileSelectorUI.getString(R.l.Fav_NotDownload_CannotForward));
        }
        else
        {
          localObject4 = paramFileSelectorUI.hHa;
          localObject5 = ((FileSelectorUI.i)localObject6).Ysv;
          String str = ((FileSelectorUI.i)localObject6).desc;
          localObject6 = ((FileSelectorUI.i)localObject6).iOk();
          WXFileObject localWXFileObject = new WXFileObject();
          localWXFileObject.setFilePath(localClassCastException);
          localObject2 = new WXMediaMessage();
          ((WXMediaMessage)localObject2).mediaObject = localWXFileObject;
          ((WXMediaMessage)localObject2).title = ((String)localObject5);
          ((WXMediaMessage)localObject2).description = str;
          ((WXMediaMessage)localObject2).thumbData = Util.readFromFile(com.tencent.mm.plugin.fav.a.b.Ew((String)localObject6));
          ((ad)com.tencent.mm.kernel.h.ax(ad.class)).a((WXMediaMessage)localObject2, "", "", (String)localObject4);
        }
      }
    }
    paramMenuItem = (List)new ArrayList();
    Object localObject2 = paramFileSelectorUI.iNU();
    if (localObject2 != null)
    {
      localObject2 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject2).iOR();
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (String)((Iterator)localObject2).next();
          kotlin.g.b.s.s(localObject4, "item");
          paramMenuItem.add(localObject4);
          localObject4 = paramFileSelectorUI.YrP.Ysj;
          ((ms)localObject4).jco += 1L;
        }
      }
    }
    if (((List)localObject3).size() > 0)
    {
      localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileSelectorUI.j)((Iterator)localObject2).next();
        localObject4 = ((FileSelectorUI.j)localObject3).filePath;
        if (localObject4 == null) {
          Log.e("MicroMsg.FileSelectorUI", kotlin.g.b.s.X("get path fail, msgInfo:", ((FileSelectorUI.j)localObject3).iOm()));
        } else {
          paramMenuItem.add(localObject4);
        }
      }
    }
    localObject2 = new Intent();
    ((Intent)localObject2).putStringArrayListExtra("selected_file_lst", (ArrayList)paramMenuItem);
    ((Intent)localObject2).putExtra("GalleryUI_ToUser", paramFileSelectorUI.hHa);
    paramFileSelectorUI.setResult(-1, (Intent)localObject2);
    paramFileSelectorUI.YrP.Ysj.jcb = 1L;
    paramFileSelectorUI.finish();
    AppMethodBeat.o(245643);
    return true;
  }
  
  private final void bB(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(245607);
    switch (this.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(245607);
      return;
      bC(paramString1, paramString2, paramString3);
      AppMethodBeat.o(245607);
      return;
      bD(paramString1, paramString2, paramString3);
    }
  }
  
  private final void bC(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(245609);
    if (ac.ggS().geW())
    {
      setMMTitle(paramString1);
      hideActionBarOperationArea();
      removeSearchMenu();
      setBackBtn(new FileSelectorUI..ExternalSyntheticLambda2(this), a.j.actionbar_icon_dark_back);
      this.YrR = true;
      DropdownListView localDropdownListView = this.YrM;
      paramString1 = localDropdownListView;
      if (localDropdownListView == null)
      {
        kotlin.g.b.s.bIx("dropdownListView");
        paramString1 = null;
      }
      paramString1.setVisibility(4);
      paramString1 = com.tencent.mm.vfs.y.n(paramString2, false);
      if (paramString1 == null) {
        paramString1 = "";
      }
      for (;;)
      {
        if (Util.isNullOrNil(paramString1)) {
          Log.e("MicroMsg.FileSelectorUI", "goToScreenProfile, exportExternalPath is null");
        }
        paramString2 = getContext();
        kotlin.g.b.s.s(paramString2, "context");
        this.YrQ = new ao((Context)paramString2, paramString1, paramString3);
        paramString1 = this.YrQ;
        if (paramString1 != null) {
          paramString1.jqf();
        }
        paramString1 = getContentView();
        if (paramString1 != null) {
          break;
        }
        paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(245609);
        throw paramString1;
      }
      ((ViewGroup)paramString1).addView((View)this.YrQ);
      setRequestedOrientation(4);
    }
    AppMethodBeat.o(245609);
  }
  
  private final void bD(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(245613);
    setMMTitle(paramString1);
    hideActionBarOperationArea();
    removeSearchMenu();
    setBackBtn(new FileSelectorUI..ExternalSyntheticLambda1(this), a.j.actionbar_icon_dark_back);
    this.YrR = true;
    DropdownListView localDropdownListView = this.YrM;
    paramString1 = localDropdownListView;
    if (localDropdownListView == null)
    {
      kotlin.g.b.s.bIx("dropdownListView");
      paramString1 = null;
    }
    paramString1.setVisibility(4);
    paramString1 = com.tencent.mm.vfs.y.n(paramString2, false);
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString1)) {
        Log.e("MicroMsg.FileSelectorUI", "goToScreenProfile, exportExternalPath is null");
      }
      paramString2 = getContext();
      kotlin.g.b.s.s(paramString2, "context");
      this.YrQ = new ao((Context)paramString2, paramString1, paramString3, 4);
      paramString1 = this.YrQ;
      kotlin.g.b.s.checkNotNull(paramString1);
      paramString1.jqf();
      paramString1 = getContentView();
      if (paramString1 != null) {
        break;
      }
      paramString1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(245613);
      throw paramString1;
    }
    ((ViewGroup)paramString1).addView((View)this.YrQ);
    AppMethodBeat.o(245613);
  }
  
  private static final boolean c(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245659);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "backBtn");
    paramFileSelectorUI.Kh(true);
    AppMethodBeat.o(245659);
    return false;
  }
  
  private static final boolean d(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245664);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "backBtn");
    paramMenuItem = ac.ggS();
    com.tencent.threadpool.h.ahAA.bFQ("delayChecking");
    paramMenuItem.LoS = null;
    paramMenuItem.LoT.t(null);
    paramMenuItem = paramFileSelectorUI.YrQ;
    if (paramMenuItem != null) {
      paramMenuItem.release();
    }
    paramMenuItem = paramFileSelectorUI.YrQ;
    if (paramMenuItem != null) {
      paramMenuItem.removeAllViews();
    }
    paramMenuItem = paramFileSelectorUI.getContentView();
    if (paramMenuItem == null)
    {
      paramFileSelectorUI = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(245664);
      throw paramFileSelectorUI;
    }
    ((ViewGroup)paramMenuItem).removeView((View)paramFileSelectorUI.YrQ);
    paramFileSelectorUI.setBackBtn(new FileSelectorUI..ExternalSyntheticLambda4(paramFileSelectorUI), R.k.actionbar_quit_webview_icon);
    DropdownListView localDropdownListView = paramFileSelectorUI.YrM;
    paramMenuItem = localDropdownListView;
    if (localDropdownListView == null)
    {
      kotlin.g.b.s.bIx("dropdownListView");
      paramMenuItem = null;
    }
    paramMenuItem.setVisibility(0);
    paramFileSelectorUI.iNY();
    paramFileSelectorUI.iNX();
    paramFileSelectorUI.setRequestedOrientation(1);
    paramFileSelectorUI.addSearchMenu(true, (com.tencent.mm.ui.tools.s)paramFileSelectorUI.YrJ);
    paramFileSelectorUI.YrR = false;
    paramFileSelectorUI = g.LAS;
    g.gjg();
    AppMethodBeat.o(245664);
    return false;
  }
  
  private static final boolean e(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245665);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "backBtn");
    paramFileSelectorUI.Kh(true);
    AppMethodBeat.o(245665);
    return false;
  }
  
  private final void evt()
  {
    AppMethodBeat.i(245633);
    e locale = this.YrI;
    Object localObject = locale;
    if (locale == null)
    {
      kotlin.g.b.s.bIx("adapter");
      localObject = null;
    }
    int j = ((e)localObject).YrZ.size();
    localObject = iNU();
    int i;
    if (localObject == null) {
      i = 0;
    }
    for (;;)
    {
      i += j;
      if (3 == this.scene) {
        break label158;
      }
      if (i <= 0) {
        break;
      }
      updateOptionMenuText(1, getString(R.l.app_send) + '(' + i + "/9)");
      enableOptionMenu(1, true);
      AppMethodBeat.o(245633);
      return;
      localObject = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject).iOS();
      if (localObject == null) {
        i = 0;
      } else {
        i = ((Integer)localObject).intValue();
      }
    }
    updateOptionMenuText(1, getString(R.l.app_send));
    enableOptionMenu(1, false);
    label158:
    AppMethodBeat.o(245633);
  }
  
  private static final boolean f(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245669);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "backBtn");
    paramMenuItem = paramFileSelectorUI.YrQ;
    if (paramMenuItem != null) {
      paramMenuItem.removeAllViews();
    }
    paramMenuItem = paramFileSelectorUI.getContentView();
    if (paramMenuItem == null)
    {
      paramFileSelectorUI = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(245669);
      throw paramFileSelectorUI;
    }
    ((ViewGroup)paramMenuItem).removeView((View)paramFileSelectorUI.YrQ);
    paramFileSelectorUI.setBackBtn(new FileSelectorUI..ExternalSyntheticLambda6(paramFileSelectorUI), R.k.actionbar_quit_webview_icon);
    DropdownListView localDropdownListView = paramFileSelectorUI.YrM;
    paramMenuItem = localDropdownListView;
    if (localDropdownListView == null)
    {
      kotlin.g.b.s.bIx("dropdownListView");
      paramMenuItem = null;
    }
    paramMenuItem.setVisibility(0);
    paramFileSelectorUI.iNY();
    paramFileSelectorUI.iNW();
    paramFileSelectorUI.addSearchMenu(true, (com.tencent.mm.ui.tools.s)paramFileSelectorUI.YrJ);
    paramFileSelectorUI.YrR = false;
    paramFileSelectorUI = g.LAS;
    g.gjg();
    AppMethodBeat.o(245669);
    return false;
  }
  
  private static final boolean g(FileSelectorUI paramFileSelectorUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(245681);
    kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
    Log.i("MicroMsg.FileSelectorUI", "onKeyDown, go back");
    paramFileSelectorUI.Kh(true);
    AppMethodBeat.o(245681);
    return false;
  }
  
  private final com.tencent.mm.pluginsdk.ui.tools.b.a.b.a iNU()
  {
    AppMethodBeat.i(245603);
    com.tencent.mm.pluginsdk.ui.tools.b.a.b.a locala = (com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)this.YrH.getValue();
    AppMethodBeat.o(245603);
    return locala;
  }
  
  private final void iNW()
  {
    AppMethodBeat.i(245618);
    initActionBarOperationArea();
    String str = getString(R.l.gHz);
    int i = R.e.FG_0;
    initActionBarOperationAreaTxt(str, i, i, R.g.fnM, R.g.fnL);
    AppMethodBeat.o(245618);
  }
  
  private final void iNX()
  {
    AppMethodBeat.i(245622);
    initActionBarOperationArea();
    String str = this.YrL;
    if (Util.isNullOrNil(this.YrL)) {
      str = getString(R.l.gHz);
    }
    if (str != null)
    {
      int i = R.e.FG_0;
      initActionBarOperationAreaTxt(str, i, i, R.g.fnM, R.g.fnL);
    }
    AppMethodBeat.o(245622);
  }
  
  private final void iNY()
  {
    AppMethodBeat.i(245625);
    setActionBarOperationAreaClickListener(new FileSelectorUI..ExternalSyntheticLambda10(this));
    AppMethodBeat.o(245625);
  }
  
  private static final void kR(View paramView)
  {
    AppMethodBeat.i(245655);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245655);
  }
  
  private final void pr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(245604);
    if (Util.isNullOrNil(paramString1))
    {
      Log.e("MicroMsg.FileSelectorUI", "open file but file not exist");
      AppMethodBeat.o(245604);
      return;
    }
    String str = com.tencent.mm.vfs.y.alV(paramString1);
    if ((3 == this.scene) || (4 == this.scene))
    {
      if ((n.T(str, "ppt", true)) || (n.T(str, "pdf", true)) || (n.T(str, "doc", true)) || (n.T(str, "docx", true)) || (n.T(str, "pptx", true)))
      {
        if (paramString1 != null)
        {
          kotlin.g.b.s.s(str, "ext");
          bB(paramString2, paramString1, str);
          AppMethodBeat.o(245604);
        }
      }
      else
      {
        aa.dc((Context)this, getResources().getString(R.l.gUr));
        AppMethodBeat.o(245604);
      }
    }
    else {
      a.b((Activity)this, paramString1, str, 1);
    }
    AppMethodBeat.o(245604);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245828);
    super.finish();
    Object localObject2 = this.YrI;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("adapter");
      localObject1 = null;
    }
    ((e)localObject1).Ysa.iNZ();
    localObject1 = this.YrP;
    localObject2 = ((f)localObject1).Ysj;
    Object localObject3 = new StringBuffer();
    Object localObject4 = (Iterable)((f)localObject1).Ysk;
    int i = 0;
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = ((Iterator)localObject4).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      ((StringBuffer)localObject3).append((String)localObject5);
      if (i < ((f)localObject1).Ysk.size() - 1) {
        ((StringBuffer)localObject3).append("|");
      }
      i += 1;
    }
    localObject3 = ((StringBuffer)localObject3).toString();
    kotlin.g.b.s.s(localObject3, "sb.toString()");
    ((ms)localObject2).jcm = ((ms)localObject2).F("searchKeyword", (String)localObject3, true);
    ((f)localObject1).Ysj.bMH();
    localObject2 = com.tencent.mm.util.c.agsX;
    com.tencent.mm.util.c.a((com.tencent.mm.plugin.report.a)((f)localObject1).Ysj);
    AppMethodBeat.o(245828);
  }
  
  public final int getForceOrientation()
  {
    if (!this.YrR) {
      return 1;
    }
    return 4;
  }
  
  public final int getLayoutId()
  {
    return R.i.gjY;
  }
  
  public final int iNV()
  {
    AppMethodBeat.i(245809);
    e locale2 = this.YrI;
    e locale1 = locale2;
    if (locale2 == null)
    {
      kotlin.g.b.s.bIx("adapter");
      locale1 = null;
    }
    int i = locale1.YrZ.size();
    AppMethodBeat.o(245809);
    return i;
  }
  
  public final boolean isActionbarCenterLayoutMode()
  {
    return false;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245851);
    Object localObject1 = iNU();
    int i;
    if (((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvi != null)
    {
      localObject1 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvi;
      if ((localObject1 != null) && (((PinnedHeaderRecyclerView)localObject1).getVisibility() == 0))
      {
        i = 1;
        if (i == 0) {
          break label736;
        }
        localObject1 = iNU();
      }
    }
    Object localObject2;
    Object localObject3;
    Object localObject4;
    switch (paramInt2)
    {
    case -1: 
    default: 
    case 0: 
      do
      {
        AppMethodBeat.o(245851);
        return;
        i = 0;
        break;
        i = 0;
        break;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringArrayListExtra("preview_image_list");
      if (paramIntent == null) {}
      for (paramInt1 = 0;; paramInt1 = paramIntent.size())
      {
        Log.i("FS.AlbumFileUIC", "paths size: %d.", new Object[] { Integer.valueOf(paramInt1) });
        if ((paramIntent == null) || (((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvj == null)) {
          break;
        }
        localObject2 = new androidx.b.b();
        paramInt1 = 0;
        for (;;)
        {
          localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvj;
          kotlin.g.b.s.checkNotNull(localObject3);
          if (paramInt1 >= ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.size()) {
            break;
          }
          localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvj;
          kotlin.g.b.s.checkNotNull(localObject3);
          localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.get(paramInt1);
          kotlin.g.b.s.s(localObject3, "adapter!!.selectedMediaItems[i]");
          localObject3 = (GalleryItem.MediaItem)localObject3;
          localObject4 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvj;
          kotlin.g.b.s.checkNotNull(localObject4);
          paramInt2 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject4).MaJ.indexOf(localObject3);
          if (paramInt2 != -1) {
            ((androidx.b.b)localObject2).add(Integer.valueOf(paramInt2));
          }
          paramInt1 += 1;
        }
      }
      localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvj;
      if (localObject3 != null)
      {
        kotlin.g.b.s.u(paramIntent, "selectedPaths");
        Log.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s].", new Object[] { ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB });
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.clear();
        localObject4 = paramIntent.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = ((Iterator)localObject4).next();
          kotlin.g.b.s.s(localObject5, "selectedPaths");
          localObject5 = (String)localObject5;
          Object localObject6 = GalleryItem.MediaItem.a(0, 0L, (String)localObject5, "", "");
          kotlin.g.b.s.s(localObject6, "createFromType(0, 0, selectPath, \"\", \"\")");
          if (e.fAp() != null)
          {
            paramInt1 = e.fAp().indexOf(localObject6);
            if (paramInt1 >= 0)
            {
              localObject5 = e.fAp().get(paramInt1);
              kotlin.g.b.s.s(localObject5, "GalleryCore.getPreviewItems()[index]");
              localObject5 = (GalleryItem.MediaItem)localObject5;
              ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.add(localObject5);
            }
            else
            {
              Log.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
              localObject6 = ((String)localObject5).toLowerCase();
              kotlin.g.b.s.s(localObject6, "(this as java.lang.String).toLowerCase()");
              if (n.rs((String)localObject6, "mp4")) {
                ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.add(GalleryItem.MediaItem.a(2, 0L, (String)localObject5, "", ""));
              } else {
                ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.add(GalleryItem.MediaItem.a(1, 0L, (String)localObject5, "", ""));
              }
            }
          }
        }
        Log.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s].", new Object[] { ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB });
      }
      localObject3 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvj;
      if (localObject3 != null)
      {
        kotlin.g.b.s.u(localObject2, "notifiedItems");
        paramInt1 = 0;
        i = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.size() - 1;
        if (i < 0) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      paramInt2 = paramInt1 + 1;
      localObject4 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).HLB.get(paramInt1);
      kotlin.g.b.s.s(localObject4, "mSelectMediaItems[i]");
      localObject4 = (GalleryItem.MediaItem)localObject4;
      paramInt1 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).MaJ.indexOf(localObject4);
      if (paramInt1 != -1) {
        ((androidx.b.b)localObject2).add(Integer.valueOf(paramInt1));
      }
      if (paramInt2 > i)
      {
        localObject2 = ((androidx.b.b)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = ((Iterator)localObject2).next();
          kotlin.g.b.s.s(localObject4, "notifiedItems");
          ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject3).fV(((Number)localObject4).intValue());
        }
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).WH(paramIntent.size());
        AppMethodBeat.o(245851);
        return;
        Log.e("FS.AlbumFileUIC", "WTF!!!");
        ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject1).Yvh.finish();
        break;
        label736:
        if ((paramInt1 == 4) && (paramIntent != null))
        {
          localObject1 = paramIntent.getStringExtra("filePath");
          localObject2 = paramIntent.getStringExtra("fileName");
          localObject3 = paramIntent.getStringExtra("fileExt");
          if ((n.T((String)localObject3, "ppt", true)) || (n.T((String)localObject3, "pdf", true)) || (n.T((String)localObject3, "doc", true)) || (n.T((String)localObject3, "docx", true)) || (n.T((String)localObject3, "pptx", true)))
          {
            if ((localObject2 != null) && (localObject1 != null) && (localObject3 != null))
            {
              bB((String)localObject2, (String)localObject1, (String)localObject3);
              AppMethodBeat.o(245851);
            }
          }
          else
          {
            if (paramIntent.getBooleanExtra("resLoadFailed", false))
            {
              aa.dc((Context)this, getResources().getString(R.l.gHD));
              AppMethodBeat.o(245851);
              return;
            }
            aa.dc((Context)this, getResources().getString(R.l.gUr));
            AppMethodBeat.o(245851);
          }
        }
        else if (((paramInt1 != 0) || (paramInt2 != -1)) && (paramInt1 == 2))
        {
          a.a((Activity)this, paramInt1, paramInt2, paramIntent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
          aa.makeText((Context)this, R.l.file_explorer_cannot_open_file, 0).show();
        }
        AppMethodBeat.o(245851);
        return;
      }
      paramInt1 = paramInt2;
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(245817);
    kotlin.g.b.s.u(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if ((this.YrR) && (this.YrQ != null))
    {
      paramConfiguration = this.YrQ;
      if (paramConfiguration != null)
      {
        paramConfiguration.jqe();
        paramConfiguration.jqd();
      }
    }
    AppMethodBeat.o(245817);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(245807);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.hHa = getIntent().getStringExtra("TO_USER");
    this.scene = getIntent().getIntExtra("scene", 0);
    iNY();
    setBackBtn(new FileSelectorUI..ExternalSyntheticLambda3(this), R.k.actionbar_quit_webview_icon);
    if ((3 != this.scene) && (4 != this.scene))
    {
      addTextOptionMenu(1, getString(R.l.app_send), new FileSelectorUI..ExternalSyntheticLambda0(this), null, y.b.adEJ);
      iNW();
      this.YrM = ((DropdownListView)findViewById(R.h.fGr));
      paramBundle = getString(R.l.gHz);
      kotlin.g.b.s.s(paramBundle, "getString(R.string.file_explorer_title_chatting)");
      paramBundle = new DropdownListView.c(paramBundle, R.k.icons_outlined_copy, R.e.FG_0, 1);
      Object localObject1 = getString(R.l.gHA);
      kotlin.g.b.s.s(localObject1, "getString(R.string.file_explorer_title_fav)");
      localObject1 = new DropdownListView.c((String)localObject1, R.k.icons_outlined_favorites, R.e.FG_0, 2);
      Object localObject3 = getString(R.l.gHB);
      kotlin.g.b.s.s(localObject3, "getString(R.string.file_explorer_title_local)");
      localObject3 = kotlin.a.p.al(new DropdownListView.c[] { paramBundle, localObject1, new DropdownListView.c((String)localObject3, R.k.icons_outlined_folder, R.e.FG_0, 3) });
      if (3 != this.scene)
      {
        paramBundle = getString(R.l.gHy);
        kotlin.g.b.s.s(paramBundle, "getString(R.string.file_explorer_title_album)");
        ((ArrayList)localObject3).add(new DropdownListView.c(paramBundle, R.k.icons_outlined_album, R.e.FG_0, 4));
      }
      localObject1 = this.YrM;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("dropdownListView");
        paramBundle = null;
      }
      paramBundle.setItems((List)localObject3);
      paramBundle = this.YrM;
      if (paramBundle != null) {
        break label1122;
      }
      kotlin.g.b.s.bIx("dropdownListView");
      paramBundle = null;
      label336:
      paramBundle.setListener((DropdownListView.d)new r(this));
      paramBundle = this.YrM;
      if (paramBundle != null) {
        break label1125;
      }
      kotlin.g.b.s.bIx("dropdownListView");
      paramBundle = null;
      label368:
      paramBundle.setOnItemStateChanged((DropdownListView.f)new s());
      this.YrI = new e();
      this.qgc = ((ListView)findViewById(R.h.fHT));
      localObject1 = this.YrI;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramBundle = null;
      }
      paramBundle.a(h.Ysq);
      paramBundle = this.qgc;
      if (paramBundle != null) {
        break label1128;
      }
      kotlin.g.b.s.bIx("listView");
      paramBundle = null;
      label454:
      localObject3 = this.YrI;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      paramBundle.setAdapter((ListAdapter)localObject1);
      localObject1 = this.qgc;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("listView");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener(new FileSelectorUI..ExternalSyntheticLambda8(this));
      localObject1 = this.qgc;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("listView");
        paramBundle = null;
      }
      paramBundle.setOnItemClickListener(this.vEc);
      paramBundle = this.qgc;
      if (paramBundle != null) {
        break label1131;
      }
      kotlin.g.b.s.bIx("listView");
      paramBundle = null;
      label568:
      paramBundle.setOnScrollListener((AbsListView.OnScrollListener)new t(this));
      this.njO = ((TextView)findViewById(R.h.fHO));
      paramBundle = this.njO;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.qgc;
      if (paramBundle != null) {
        break label1134;
      }
      kotlin.g.b.s.bIx("listView");
      paramBundle = null;
      label629:
      paramBundle.setEmptyView((View)this.njO);
      paramBundle = iNU();
      Log.i("FS.AlbumFileUIC", "onCreate, %s.", new Object[] { paramBundle });
      localObject1 = (Activity)paramBundle.Yvh;
      paramBundle.Yvh.getString(R.l.permission_tips_title);
      localObject3 = paramBundle.Yvh.getString(R.l.gallery_permission_msg);
      paramBundle.HMP = com.tencent.mm.pluginsdk.permission.b.a((Activity)localObject1, new String[] { "android.permission.READ_EXTERNAL_STORAGE" }, 145, (String)localObject3);
      Log.i("FS.AlbumFileUIC", "checkPermission checkMediaStorage[%b]", new Object[] { Boolean.valueOf(paramBundle.HMP) });
      paramBundle.HMG = System.currentTimeMillis();
      com.tencent.mm.pluginsdk.ui.tools.b.a.b.a.start = System.currentTimeMillis();
      paramBundle.hQQ = paramBundle.Yvh.getIntent().getStringExtra("GalleryUI_FromUser");
      paramBundle.toUser = paramBundle.Yvh.getIntent().getStringExtra("GalleryUI_ToUser");
      paramBundle.lzP = ((ProgressDialog)w.a((Context)paramBundle.Yvh, (CharSequence)paramBundle.Yvh.getString(R.l.app_waiting), false));
      paramBundle.Yvk = a.b.Yvn;
      e.fAn().sfB = paramBundle.mpb;
      e.fAn().setQueryType(paramBundle.HMO);
      Log.i("FS.AlbumFileUIC", "query source: " + paramBundle.mpb + ", queryType: " + paramBundle.HMO);
      paramBundle.initView();
      if (paramBundle.HMP) {
        paramBundle.fBr();
      }
      e.fAv();
      iNU().setVisibility(8);
      iNU().Yvl = ((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d)new u(this));
      this.YrK = findViewById(R.h.fVz);
      paramBundle = this.YrK;
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
      paramBundle = this.YrK;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(FileSelectorUI..ExternalSyntheticLambda7.INSTANCE);
      }
      this.YrJ = new r();
      paramBundle = this.YrJ;
      if (paramBundle != null) {
        paramBundle.afKz = ((s.c)new v(this));
      }
      addSearchMenu(true, (com.tencent.mm.ui.tools.s)this.YrJ);
      evt();
      Log.i("MicroMsg.FileSelectorUI", kotlin.g.b.s.X("onCreate, cost:", Long.valueOf(System.currentTimeMillis() - l)));
      paramBundle = this.YrM;
      if (paramBundle != null) {
        break label1137;
      }
      kotlin.g.b.s.bIx("dropdownListView");
      paramBundle = localObject2;
    }
    label1122:
    label1125:
    label1128:
    label1131:
    label1134:
    label1137:
    for (;;)
    {
      paramBundle.setFolderAlbumDialogDismiss((DropdownListView.e)new q(this));
      com.tencent.mm.ui.a.v((TextView)findViewById(b.e.album_chooser_txt), com.tencent.mm.ck.a.d.ActionBarTextSize);
      AppMethodBeat.o(245807);
      return;
      if (EventCenter.instance.hadListened(this.tjd)) {
        break;
      }
      this.tjd.alive();
      break;
      break label336;
      break label368;
      break label454;
      break label568;
      break label629;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245831);
    super.onDestroy();
    Object localObject = iNU();
    if (localObject != null)
    {
      e.fAn().b((l.c)localObject);
      e.fAw();
    }
    this.tjd.dead();
    localObject = this.YrJ;
    if (localObject != null) {
      ((r)localObject).jyO();
    }
    AppMethodBeat.o(245831);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    DropdownListView localDropdownListView = null;
    AppMethodBeat.i(245837);
    kotlin.g.b.s.u(paramKeyEvent, "event");
    switch (paramInt)
    {
    default: 
      boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
      AppMethodBeat.o(245837);
      return bool;
    case 4: 
      Log.i("MicroMsg.FileSelectorUI", "onKeyDown back");
      if (this.YrR)
      {
        paramKeyEvent = this.YrQ;
        if (paramKeyEvent != null) {
          paramKeyEvent.release();
        }
        paramKeyEvent = this.YrQ;
        if (paramKeyEvent != null) {
          paramKeyEvent.removeAllViews();
        }
        paramKeyEvent = getContentView();
        if (paramKeyEvent == null)
        {
          paramKeyEvent = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(245837);
          throw paramKeyEvent;
        }
        ((ViewGroup)paramKeyEvent).removeView((View)this.YrQ);
        setBackBtn(new FileSelectorUI..ExternalSyntheticLambda5(this), R.k.actionbar_quit_webview_icon);
        localDropdownListView = this.YrM;
        paramKeyEvent = localDropdownListView;
        if (localDropdownListView == null)
        {
          kotlin.g.b.s.bIx("dropdownListView");
          paramKeyEvent = null;
        }
        paramKeyEvent.setVisibility(0);
        iNY();
        iNX();
        setRequestedOrientation(1);
        addSearchMenu(true, (com.tencent.mm.ui.tools.s)this.YrJ);
        paramKeyEvent = g.LAS;
        g.gjg();
        this.YrR = false;
      }
      for (;;)
      {
        AppMethodBeat.o(245837);
        return true;
        Kh(false);
      }
    }
    if (this.YrM == null) {
      kotlin.g.b.s.bIx("dropdownListView");
    }
    paramKeyEvent = this.YrM;
    if (paramKeyEvent == null)
    {
      kotlin.g.b.s.bIx("dropdownListView");
      paramKeyEvent = localDropdownListView;
    }
    for (;;)
    {
      paramKeyEvent.fBC();
      AppMethodBeat.o(245837);
      return true;
    }
  }
  
  public final void onPause()
  {
    FrameLayout localFrameLayout = null;
    AppMethodBeat.i(245823);
    super.onPause();
    if ((!isFinishing()) && (!isDestroyed()))
    {
      if (this.YrM == null) {
        kotlin.g.b.s.bIx("dropdownListView");
      }
      DropdownListView localDropdownListView = this.YrM;
      Object localObject = localDropdownListView;
      if (localDropdownListView == null)
      {
        kotlin.g.b.s.bIx("dropdownListView");
        localObject = null;
      }
      if (((DropdownListView)localObject).wJw)
      {
        localObject = this.YrM;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("dropdownListView");
          localObject = localFrameLayout;
        }
        while (!((DropdownListView)localObject).wJw)
        {
          Log.w("MicroMsg.DropdownListView", "want to close, but it was closed");
          AppMethodBeat.o(245823);
          return;
        }
        if (((DropdownListView)localObject).HOt)
        {
          Log.d("MicroMsg.DropdownListView", "want to close, but it is in animation");
          AppMethodBeat.o(245823);
          return;
        }
        localFrameLayout = ((DropdownListView)localObject).HOp;
        kotlin.g.b.s.checkNotNull(localFrameLayout);
        localFrameLayout.setVisibility(8);
        ((DropdownListView)localObject).wJw = false;
        if (((DropdownListView)localObject).Yrd != null) {
          kotlin.g.b.s.checkNotNull(((DropdownListView)localObject).Yrd);
        }
      }
    }
    AppMethodBeat.o(245823);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(245795);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.pluginsdk.ui.tools.a.a.class);
    AppMethodBeat.o(245795);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "FILE_TYPE_COUNT", "", "TAG", "", "chattingFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "favFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FavFileSource;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "fromType", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "sdcardFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "selectedFileLst", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getSelectedFileLst", "()Ljava/util/List;", "checkIsContain", "", "item", "finish", "", "getCount", "getDataSourceFrom", "getIconSrc", "name", "getItem", "position", "getItemId", "", "getItemViewType", "getListItemFromData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getParentPath", "Lcom/tencent/mm/vfs/VFSFile;", "getThumbnail", "Landroid/graphics/Bitmap;", "path", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "isAudio", "fileName", "isCompressFile", "isDoc", "isFromSDCard", "isHtml", "isImg", "isInit", "isKeynote", "isNumber", "isOfd", "isPages", "isPdf", "isPpt", "isTxt", "isVideo", "isXls", "loadData", "onBottomLoadMore", "onInit", "onLoadMoreCompleted", "onSelectorWrapperClicked", "v", "search", "content", "setDataSourceFrom", "setParentPath", "setPath", "FileViewHolder", "FolderViewHolder", "TimeViewHolder", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends BaseAdapter
  {
    private final String TAG;
    private List<FileSelectorUI.l> YrW;
    private final int YrY;
    final List<FileSelectorUI.j> YrZ;
    final FileSelectorUI.a Ysa;
    final FileSelectorUI.c Ysb;
    final FileSelectorUI.n Ysc;
    FileSelectorUI.h Ysd;
    
    public e()
    {
      AppMethodBeat.i(245764);
      this.TAG = "MicroMsg.FileSelectorAdapter";
      this.YrY = 4;
      this$1 = Collections.synchronizedList((List)new ArrayList());
      kotlin.g.b.s.s(this$1, "synchronizedList(ArrayList<ListItem>())");
      this.YrW = this$1;
      this$1 = Collections.synchronizedList((List)new ArrayList());
      kotlin.g.b.s.s(this$1, "synchronizedList(ArrayList<ListFileItem>())");
      this.YrZ = this$1;
      this.Ysa = new FileSelectorUI.a(this.YrS, this);
      this.Ysb = new FileSelectorUI.c(this.YrS, this);
      this.Ysc = new FileSelectorUI.n(this.YrS, this);
      this.Ysd = FileSelectorUI.h.Ysq;
      AppMethodBeat.o(245764);
    }
    
    private static final void a(e parame, View paramView)
    {
      AppMethodBeat.i(245848);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parame);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.s(paramView, "v");
      parame.kS(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245848);
    }
    
    private final boolean a(FileSelectorUI.j paramj)
    {
      AppMethodBeat.i(245788);
      Iterator localIterator = ((Iterable)this.YrZ).iterator();
      while (localIterator.hasNext())
      {
        FileSelectorUI.j localj = (FileSelectorUI.j)localIterator.next();
        if (localj.YsE == FileSelectorUI.g.Yso)
        {
          if ((paramj.YsE == FileSelectorUI.g.Yso) && ((paramj instanceof FileSelectorUI.k)) && (((FileSelectorUI.k)paramj).YsD))
          {
            int i;
            if (paramj.createTime == localj.createTime)
            {
              i = 1;
              label94:
              if (paramj.Ysz != localj.Ysz) {
                break label148;
              }
            }
            label148:
            for (int j = 1;; j = 0)
            {
              boolean bool = kotlin.g.b.s.p(paramj.filePath, localj.filePath);
              if ((j == 0) || (i == 0) || (!bool)) {
                break;
              }
              AppMethodBeat.o(245788);
              return true;
              i = 0;
              break label94;
            }
          }
        }
        else if ((localj.iOm() == paramj.iOm()) && (localj.createTime == paramj.createTime) && (localj.msgId == paramj.msgId))
        {
          AppMethodBeat.o(245788);
          return true;
        }
      }
      AppMethodBeat.o(245788);
      return false;
    }
    
    private static final void b(e parame, View paramView)
    {
      AppMethodBeat.i(245853);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parame);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(parame, "this$0");
      kotlin.g.b.s.s(paramView, "v");
      parame.kS(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245853);
    }
    
    private final boolean b(FileSelectorUI.h paramh)
    {
      AppMethodBeat.i(245768);
      switch (d.$EnumSwitchMapping$0[paramh.ordinal()])
      {
      default: 
        AppMethodBeat.o(245768);
        return true;
      case 1: 
        bool = this.Ysa.hasInit;
        AppMethodBeat.o(245768);
        return bool;
      case 2: 
        bool = this.Ysb.hasInit;
        AppMethodBeat.o(245768);
        return bool;
      }
      boolean bool = this.Ysc.hasInit;
      AppMethodBeat.o(245768);
      return bool;
    }
    
    private static int brA(String paramString)
    {
      AppMethodBeat.i(245791);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(245791);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if (brD(paramString))
      {
        i = R.k.app_attach_file_icon_word;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brB(paramString))
      {
        i = R.g.app_attach_file_icon_pic;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brI(paramString))
      {
        i = R.k.app_attach_file_icon_rar;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brJ(paramString))
      {
        i = R.k.app_attach_file_icon_txt;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brE(paramString))
      {
        i = R.k.app_attach_file_icon_pdf;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brF(paramString))
      {
        i = R.k.app_attach_file_icon_ppt;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brG(paramString))
      {
        i = R.k.app_attach_file_icon_excel;
        AppMethodBeat.o(245791);
        return i;
      }
      if (df(paramString))
      {
        i = R.k.app_attach_file_icon_music;
        AppMethodBeat.o(245791);
        return i;
      }
      if (isVideo(paramString))
      {
        i = R.k.app_attach_file_icon_video;
        AppMethodBeat.o(245791);
        return i;
      }
      if (eL(paramString))
      {
        i = R.k.app_attach_file_icon_webpage;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brK(paramString))
      {
        i = R.k.app_attach_file_icon_keynote;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brL(paramString))
      {
        i = R.k.app_attach_file_icon_number;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brN(paramString))
      {
        i = R.k.app_attach_file_icon_ofd;
        AppMethodBeat.o(245791);
        return i;
      }
      if (brM(paramString))
      {
        i = R.k.app_attach_file_icon_page;
        AppMethodBeat.o(245791);
        return i;
      }
      int i = R.k.app_attach_file_icon_unknow;
      AppMethodBeat.o(245791);
      return i;
    }
    
    private static boolean brB(String paramString)
    {
      AppMethodBeat.i(245794);
      kotlin.g.b.s.u(paramString, "fileName");
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((Build.VERSION.SDK_INT >= 28) && (n.rs(paramString, ".heic")))
      {
        AppMethodBeat.o(245794);
        return true;
      }
      if ((n.rs(paramString, ".bmp")) || (n.rs(paramString, ".png")) || (n.rs(paramString, ".jpg")) || (n.rs(paramString, ".jpeg")) || (n.rs(paramString, ".gif")))
      {
        AppMethodBeat.o(245794);
        return true;
      }
      AppMethodBeat.o(245794);
      return false;
    }
    
    private static boolean brD(String paramString)
    {
      AppMethodBeat.i(245805);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".doc")) || (n.rs(paramString, ".docx")) || (n.rs(paramString, "wps")))
      {
        AppMethodBeat.o(245805);
        return true;
      }
      AppMethodBeat.o(245805);
      return false;
    }
    
    private static boolean brE(String paramString)
    {
      AppMethodBeat.i(245808);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.rs(paramString, ".pdf");
      AppMethodBeat.o(245808);
      return bool;
    }
    
    private static boolean brF(String paramString)
    {
      AppMethodBeat.i(245812);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".ppt")) || (n.rs(paramString, ".pptx")))
      {
        AppMethodBeat.o(245812);
        return true;
      }
      AppMethodBeat.o(245812);
      return false;
    }
    
    private static boolean brG(String paramString)
    {
      AppMethodBeat.i(245820);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".xls")) || (n.rs(paramString, ".xlsx")))
      {
        AppMethodBeat.o(245820);
        return true;
      }
      AppMethodBeat.o(245820);
      return false;
    }
    
    private static boolean brI(String paramString)
    {
      AppMethodBeat.i(245803);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".rar")) || (n.rs(paramString, ".zip")) || (n.rs(paramString, ".7z")) || (n.rs(paramString, "tar")) || (n.rs(paramString, ".iso")))
      {
        AppMethodBeat.o(245803);
        return true;
      }
      AppMethodBeat.o(245803);
      return false;
    }
    
    private static boolean brJ(String paramString)
    {
      AppMethodBeat.i(245825);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".txt")) || (n.rs(paramString, ".rtf")))
      {
        AppMethodBeat.o(245825);
        return true;
      }
      AppMethodBeat.o(245825);
      return false;
    }
    
    private static boolean brK(String paramString)
    {
      AppMethodBeat.i(245829);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.rs(paramString, ".key");
      AppMethodBeat.o(245829);
      return bool;
    }
    
    private static boolean brL(String paramString)
    {
      AppMethodBeat.i(245835);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.rs(paramString, ".number");
      AppMethodBeat.o(245835);
      return bool;
    }
    
    private static boolean brM(String paramString)
    {
      AppMethodBeat.i(245839);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.rs(paramString, ".pages");
      AppMethodBeat.o(245839);
      return bool;
    }
    
    private static boolean brN(String paramString)
    {
      AppMethodBeat.i(245842);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.rs(paramString, ".ofd");
      AppMethodBeat.o(245842);
      return bool;
    }
    
    private final void c(FileSelectorUI.h paramh)
    {
      AppMethodBeat.i(245770);
      switch (d.$EnumSwitchMapping$0[paramh.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(245770);
        return;
        this.Ysa.iOd();
        AppMethodBeat.o(245770);
        return;
        this.Ysb.iOd();
        AppMethodBeat.o(245770);
        return;
        this.Ysc.iOd();
      }
    }
    
    private static boolean df(String paramString)
    {
      AppMethodBeat.i(245797);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".mp3")) || (n.rs(paramString, ".wma")))
      {
        AppMethodBeat.o(245797);
        return true;
      }
      AppMethodBeat.o(245797);
      return false;
    }
    
    private static boolean eL(String paramString)
    {
      AppMethodBeat.i(245830);
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.rs(paramString, ".html");
      AppMethodBeat.o(245830);
      return bool;
    }
    
    private final boolean iOj()
    {
      return FileSelectorUI.h.Yss == this.Ysd;
    }
    
    private static boolean isVideo(String paramString)
    {
      AppMethodBeat.i(245799);
      kotlin.g.b.s.u(paramString, "fileName");
      paramString = Util.nullAsNil(paramString);
      kotlin.g.b.s.s(paramString, "nullAsNil(fileName)");
      paramString = paramString.toLowerCase();
      kotlin.g.b.s.s(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.rs(paramString, ".mp4")) || (n.rs(paramString, ".rm")))
      {
        AppMethodBeat.o(245799);
        return true;
      }
      AppMethodBeat.o(245799);
      return false;
    }
    
    private final void kS(View paramView)
    {
      AppMethodBeat.i(245783);
      Object localObject1 = paramView.getTag();
      if (localObject1 == null)
      {
        paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(245783);
        throw paramView;
      }
      int i = ((Integer)localObject1).intValue();
      if (i < 5) {}
      for (int j = 1;; j = 0)
      {
        localObject1 = axf(i);
        paramView = paramView.findViewById(R.h.fLF);
        if (paramView != null) {
          break;
        }
        paramView = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        AppMethodBeat.o(245783);
        throw paramView;
      }
      paramView = (CheckBox)paramView;
      if (a((FileSelectorUI.j)localObject1))
      {
        this.YrZ.remove(localObject1);
        if (j != 0)
        {
          localObject1 = FileSelectorUI.g(this.YrS).Ysj;
          ((ms)localObject1).jck -= 1L;
          paramView.setChecked(false);
        }
      }
      for (;;)
      {
        FileSelectorUI.b(this.YrS);
        this.YrS.hideVKB();
        paramView = FileSelectorUI.f(this.YrS);
        if (paramView != null) {
          paramView.afKs = false;
        }
        AppMethodBeat.o(245783);
        return;
        localObject1 = FileSelectorUI.g(this.YrS).Ysj;
        ((ms)localObject1).jcl -= 1L;
        break;
        Object localObject2 = FileSelectorUI.e(this.YrS);
        if (localObject2 == null) {
          i = 0;
        }
        while (i + this.YrZ.size() >= 9)
        {
          aa.makeText((Context)this.YrS.getContext(), (CharSequence)this.YrS.getString(R.l.gHN, new Object[] { Integer.valueOf(9) }), 0).show();
          paramView.setChecked(false);
          AppMethodBeat.o(245783);
          return;
          localObject2 = ((com.tencent.mm.pluginsdk.ui.tools.b.a.b.a)localObject2).iOS();
          if (localObject2 == null) {
            i = 0;
          } else {
            i = ((Integer)localObject2).intValue();
          }
        }
        long l = com.tencent.mm.k.c.aRk();
        if (((FileSelectorUI.j)localObject1).Ysz >= l)
        {
          aa.makeText((Context)this.YrS.getContext(), (CharSequence)this.YrS.getString(R.l.gHM, new Object[] { Util.getSizeKB(l) }), 0).show();
          paramView.setChecked(false);
          AppMethodBeat.o(245783);
          return;
        }
        paramView.setChecked(true);
        this.YrZ.add(localObject1);
        if (j != 0)
        {
          paramView = FileSelectorUI.g(this.YrS).Ysj;
          paramView.jck += 1L;
        }
        else
        {
          paramView = FileSelectorUI.g(this.YrS).Ysj;
          paramView.jcl += 1L;
        }
      }
    }
    
    private final ArrayList<FileSelectorUI.l> mA(List<FileSelectorUI.j> paramList)
    {
      AppMethodBeat.i(245777);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = "";
      Iterator localIterator = paramList.iterator();
      paramList = (List<FileSelectorUI.j>)localObject1;
      while (localIterator.hasNext())
      {
        FileSelectorUI.j localj = (FileSelectorUI.j)localIterator.next();
        Object localObject2;
        if ((localj == null) || (FileSelectorUI.g.Ysl == localj.YsE))
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
        if (FileSelectorUI.g.Yso != localj.YsE)
        {
          localObject1 = paramList;
          if (!kotlin.g.b.s.p(paramList, localj.title))
          {
            localObject2 = new FileSelectorUI.m(this.YrS);
            ((FileSelectorUI.l)localObject2).title = localj.title;
            localObject1 = ((FileSelectorUI.l)localObject2).title;
            paramList = (List<FileSelectorUI.j>)localObject1;
            if (localObject1 == null) {
              paramList = "";
            }
            ((FileSelectorUI.m)localObject2).a(FileSelectorUI.g.Ysm);
            localArrayList.add(localObject2);
            localObject1 = paramList;
          }
        }
        localArrayList.add(localj);
        paramList = (List<FileSelectorUI.j>)localObject1;
      }
      AppMethodBeat.o(245777);
      return localArrayList;
    }
    
    public final void Dm(String paramString)
    {
      AppMethodBeat.i(245864);
      kotlin.g.b.s.u(paramString, "content");
      FileSelectorUI.h localh = this.Ysd;
      switch (d.$EnumSwitchMapping$0[localh.ordinal()])
      {
      default: 
        paramString = (List)new ArrayList();
      }
      for (;;)
      {
        this.YrW = paramString;
        notifyDataSetChanged();
        AppMethodBeat.o(245864);
        return;
        paramString = (List)mA(this.Ysa.brH(paramString));
        continue;
        paramString = (List)mA(this.Ysb.brH(paramString));
        continue;
        paramString = (List)mA(this.Ysc.brH(paramString));
      }
    }
    
    public final void a(FileSelectorUI.h paramh)
    {
      AppMethodBeat.i(245861);
      kotlin.g.b.s.u(paramh, "fromType");
      if (!b(paramh)) {
        c(paramh);
      }
      this.Ysd = paramh;
      dSD();
      AppMethodBeat.o(245861);
    }
    
    public final FileSelectorUI.l axf(int paramInt)
    {
      AppMethodBeat.i(245886);
      FileSelectorUI.l locall = (FileSelectorUI.l)this.YrW.get(paramInt);
      AppMethodBeat.o(245886);
      return locall;
    }
    
    final void dSD()
    {
      AppMethodBeat.i(245868);
      Object localObject = this.Ysd;
      switch (d.$EnumSwitchMapping$0[localObject.ordinal()])
      {
      default: 
        localObject = FileSelectorUI.q(this.YrS);
        if (localObject != null) {
          ((TextView)localObject).setText((CharSequence)"");
        }
        localObject = (List)new ArrayList();
      }
      for (;;)
      {
        this.YrW = ((List)localObject);
        notifyDataSetChanged();
        if ((this.YrW.size() <= 0) && (FileSelectorUI.h.Yst != this.Ysd))
        {
          localObject = FileSelectorUI.q(this.YrS);
          if (localObject != null) {
            ((TextView)localObject).setText((CharSequence)this.YrS.getString(R.l.gHt));
          }
          localObject = FileSelectorUI.q(this.YrS);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        AppMethodBeat.o(245868);
        return;
        localObject = (List)mA(this.Ysa.YrW);
        continue;
        localObject = (List)mA(this.Ysb.YrW);
        continue;
        localObject = (List)mA(this.Ysc.YrW);
      }
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(245883);
      int i = this.YrW.size();
      AppMethodBeat.o(245883);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(245881);
      paramInt = axf(paramInt).YsE.ordinal();
      AppMethodBeat.o(245881);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(245895);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      locall = axf(paramInt);
      localObject1 = locall.YsE;
      switch (d.avl[localObject1.ordinal()])
      {
      default: 
        Log.f(this.TAG, "impossible path, Fuck felixzhou!");
        kotlin.g.b.s.checkNotNull(paramView);
        AppMethodBeat.o(245895);
        return paramView;
      case 1: 
        if (paramView == null)
        {
          paramView = View.inflate(paramViewGroup.getContext(), R.i.gjX, null);
          paramViewGroup = new FileSelectorUI.e.c(this);
          localObject1 = paramView.findViewById(R.h.item_title);
          if (localObject1 == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.pJJ = ((TextView)localObject1);
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          paramViewGroup = paramViewGroup.pJJ;
          if (paramViewGroup != null) {
            paramViewGroup.setText((CharSequence)locall.title);
          }
          kotlin.g.b.s.checkNotNull(paramView);
          AppMethodBeat.o(245895);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.TimeViewHolder");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup = (FileSelectorUI.e.c)paramViewGroup;
        }
      case 2: 
        if (paramView == null)
        {
          localObject1 = View.inflate(paramViewGroup.getContext(), R.i.gjW, null);
          paramViewGroup = new a();
          paramView = ((View)localObject1).findViewById(R.h.fLG);
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.Yse = ((FrameLayout)paramView);
          paramView = paramViewGroup.Yse;
          if (paramView == null) {}
          for (paramView = null; paramView == null; paramView = paramView.findViewById(R.h.fLF))
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.Ysf = ((CheckBox)paramView);
          paramView = ((View)localObject1).findViewById(R.h.item_icon);
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.ttT = ((ImageView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.item_title);
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.pJJ = ((TextView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.fLI);
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.Nnr = ((TextView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.fLK);
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.timeTV = ((TextView)paramView);
          paramView = ((View)localObject1).findViewById(R.h.fLB);
          if (paramView == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup.Ysg = ((TextView)paramView);
          paramViewGroup.Ysh = ((View)localObject1).findViewById(R.h.fLE);
          if (getCount() - 1 == paramInt)
          {
            paramView = paramViewGroup.Ysh;
            if (paramView != null) {
              paramView.setVisibility(4);
            }
          }
          paramView = paramViewGroup.Yse;
          if (paramView != null) {
            paramView.setOnClickListener(new FileSelectorUI.e..ExternalSyntheticLambda0(this));
          }
          ((View)localObject1).setTag(paramViewGroup);
          paramView = (View)localObject1;
          localObject1 = paramViewGroup.pJJ;
          if (localObject1 != null) {
            ((TextView)localObject1).setText(((FileSelectorUI.j)locall).iOm());
          }
          if ((3 != FileSelectorUI.p(this.YrS)) && (4 != FileSelectorUI.p(this.YrS))) {
            break label1013;
          }
          localObject1 = paramViewGroup.Yse;
          if (localObject1 != null) {
            ((FrameLayout)localObject1).setVisibility(4);
          }
        }
        for (;;)
        {
          localObject1 = paramViewGroup.Nnr;
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = paramViewGroup.timeTV;
          if (localObject1 != null) {
            ((TextView)localObject1).setVisibility(0);
          }
          localObject1 = paramViewGroup.pJJ;
          if (localObject1 != null) {
            ((TextView)localObject1).setText(((FileSelectorUI.j)locall).iOm());
          }
          localObject1 = paramViewGroup.Nnr;
          if (localObject1 != null) {
            ((TextView)localObject1).setText((CharSequence)Util.getSizeKB(((FileSelectorUI.j)locall).Ysz));
          }
          if (((FileSelectorUI.j)locall).YsA == 2)
          {
            localObject1 = paramViewGroup.Nnr;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)(">" + ((com.tencent.mm.plugin.fav.a.ah)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.fav.a.ah.class)).getFileSizeLimitInMB(true) + "MB"));
            }
          }
          localObject1 = paramViewGroup.timeTV;
          if (localObject1 != null) {
            ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.platformtools.f.d((Context)this.YrS.getContext(), ((FileSelectorUI.j)locall).createTime, true));
          }
          localObject1 = paramViewGroup.ttT;
          if (localObject1 != null) {
            ((ImageView)localObject1).setImageResource(brA(((FileSelectorUI.j)locall).iOm().toString()));
          }
          localObject1 = paramViewGroup.Ysg;
          if (localObject1 != null) {
            ((TextView)localObject1).setText(((FileSelectorUI.j)locall).Ysx);
          }
          localObject1 = paramViewGroup.Ysf;
          if (localObject1 != null) {
            ((CheckBox)localObject1).setChecked(a((FileSelectorUI.j)locall));
          }
          paramViewGroup = paramViewGroup.Yse;
          if (paramViewGroup != null) {
            paramViewGroup.setTag(Integer.valueOf(paramInt));
          }
          kotlin.g.b.s.checkNotNull(paramView);
          AppMethodBeat.o(245895);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FileViewHolder");
            AppMethodBeat.o(245895);
            throw paramView;
          }
          paramViewGroup = (a)paramViewGroup;
          break;
          label1013:
          localObject1 = paramViewGroup.Yse;
          if (localObject1 != null) {
            ((FrameLayout)localObject1).setVisibility(0);
          }
        }
      }
      if (paramView == null)
      {
        localObject1 = View.inflate(paramViewGroup.getContext(), R.i.gkb, null);
        paramViewGroup = new b();
        paramViewGroup.Yse = ((FrameLayout)((View)localObject1).findViewById(R.h.fLG));
        paramView = paramViewGroup.Yse;
        if (paramView == null) {}
        for (paramView = null; paramView == null; paramView = paramView.findViewById(R.h.fLF))
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
          AppMethodBeat.o(245895);
          throw paramView;
        }
        paramViewGroup.Ysf = ((CheckBox)paramView);
        paramViewGroup.ttT = ((ImageView)((View)localObject1).findViewById(R.h.item_icon));
        paramViewGroup.pJJ = ((TextView)((View)localObject1).findViewById(R.h.item_title));
        paramViewGroup.Nnr = ((TextView)((View)localObject1).findViewById(R.h.fLI));
        paramViewGroup.timeTV = ((TextView)((View)localObject1).findViewById(R.h.fLK));
        paramView = paramViewGroup.Yse;
        if (paramView != null) {
          paramView.setOnClickListener(new FileSelectorUI.e..ExternalSyntheticLambda1(this));
        }
        ((View)localObject1).setTag(paramViewGroup);
        paramView = (View)localObject1;
      }
      try
      {
        localObject2 = (FileSelectorUI.k)locall;
        localObject3 = paramViewGroup.pJJ;
        if (localObject3 == null) {
          break label1941;
        }
        if (localObject2 != null) {
          break label1466;
        }
        localObject1 = null;
        label1243:
        ((TextView)localObject3).setText((CharSequence)localObject1);
      }
      catch (Exception paramViewGroup)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject3;
          label1253:
          Log.e(this.TAG, paramViewGroup.getMessage(), new Object[] { kotlin.g.b.s.X("item is ListFileItem:", Boolean.valueOf(locall instanceof FileSelectorUI.j)) });
          label1466:
          continue;
          localObject1 = paramViewGroup.Yse;
          if (localObject1 != null)
          {
            ((FrameLayout)localObject1).setVisibility(0);
            continue;
            localObject2 = ((e)localObject1).YrS.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { localObject2 }, null);
            if (localObject2 != null)
            {
              if (((Cursor)localObject2).moveToFirst())
              {
                int i = ((Cursor)localObject2).getInt(((Cursor)localObject2).getColumnIndex("_id"));
                ((Cursor)localObject2).close();
                localObject1 = MediaStore.Images.Thumbnails.getThumbnail(((e)localObject1).YrS.getContentResolver(), i, 3, null);
                continue;
              }
              ((Cursor)localObject2).close();
              break label1952;
              localObject1 = paramViewGroup.ttT;
              if (localObject1 == null) {
                continue;
              }
              ((ImageView)localObject1).setImageResource(brA(localObject3.toString()));
              continue;
              localObject1 = paramViewGroup.ttT;
              if (localObject1 == null) {
                continue;
              }
              ((ImageView)localObject1).setImageResource(brA(localObject3.toString()));
              continue;
              if (localObject2 != null) {
                continue;
              }
              localObject1 = null;
              continue;
            }
            localObject1 = null;
          }
        }
      }
      if (!((Boolean)localObject1).booleanValue())
      {
        localObject1 = paramViewGroup.ttT;
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(R.k.app_attach_file_icon_folders);
        }
        localObject1 = paramViewGroup.Yse;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.Nnr;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = paramViewGroup.timeTV;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
        localObject1 = paramViewGroup.Nnr;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)this.YrS.getString(R.l.gHs, new Object[] { Integer.valueOf(((FileSelectorUI.k)localObject2).YsC) }));
        }
      }
      for (;;)
      {
        localObject1 = paramViewGroup.Ysf;
        if (localObject1 != null) {
          ((CheckBox)localObject1).setChecked(a((FileSelectorUI.j)locall));
        }
        paramViewGroup = paramViewGroup.Yse;
        if (paramViewGroup != null) {
          paramViewGroup.setTag(Integer.valueOf(paramInt));
        }
        kotlin.g.b.s.checkNotNull(paramView);
        AppMethodBeat.o(245895);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FolderViewHolder");
          AppMethodBeat.o(245895);
          throw paramView;
        }
        paramViewGroup = (b)paramViewGroup;
        break;
        localObject1 = ((FileSelectorUI.k)localObject2).iOm();
        break label1243;
        localObject1 = Boolean.valueOf(((FileSelectorUI.k)localObject2).YsD);
        break label1253;
        if ((3 != FileSelectorUI.p(this.YrS)) && (4 != FileSelectorUI.p(this.YrS))) {
          break label1756;
        }
        localObject1 = paramViewGroup.Yse;
        if (localObject1 != null) {
          ((FrameLayout)localObject1).setVisibility(4);
        }
        localObject1 = paramViewGroup.Nnr;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = paramViewGroup.timeTV;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
        localObject1 = paramViewGroup.Nnr;
        if (localObject1 != null) {
          ((TextView)localObject1).setText((CharSequence)Util.getSizeKB(((FileSelectorUI.j)localObject2).Ysz));
        }
        localObject1 = paramViewGroup.timeTV;
        if (localObject1 != null) {
          ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.platformtools.f.d((Context)this.YrS.getContext(), ((FileSelectorUI.j)localObject2).createTime, true));
        }
        localObject3 = ((FileSelectorUI.k)localObject2).iOm();
        if (!brB(localObject3.toString())) {
          break label1914;
        }
        localObject1 = FileSelectorUI.h(this.YrS);
        if (localObject1 != null) {
          break label1958;
        }
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
        localObject2 = ((FileSelectorUI.j)localObject2).filePath;
        if (!Util.isNullOrNil((String)localObject2)) {
          break label1776;
        }
        Log.e(((e)localObject1).TAG, "getThumbnail fail, path not exist");
        break label1952;
        if (localObject1 == null) {
          break label1887;
        }
        localObject2 = paramViewGroup.ttT;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageBitmap((Bitmap)localObject1);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return this.YrY;
    }
    
    public final void iOh()
    {
      AppMethodBeat.i(245871);
      if (this.Ysd != FileSelectorUI.h.Yss)
      {
        AppMethodBeat.o(245871);
        return;
      }
      Object localObject1 = this.Ysc.iOp();
      if (localObject1 != null)
      {
        Object localObject2 = this.YrS;
        this.Ysc.ag((com.tencent.mm.vfs.u)localObject1);
        localObject2 = FileSelectorUI.h((FileSelectorUI)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("adapter");
          localObject1 = null;
        }
        ((e)localObject1).dSD();
      }
      AppMethodBeat.o(245871);
    }
    
    public final com.tencent.mm.vfs.u iOi()
    {
      AppMethodBeat.i(245875);
      if (!iOj())
      {
        AppMethodBeat.o(245875);
        return null;
      }
      com.tencent.mm.vfs.u localu = this.Ysc.iOp();
      AppMethodBeat.o(245875);
      return localu;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FileViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "fromTV", "Landroid/widget/TextView;", "getFromTV", "()Landroid/widget/TextView;", "setFromTV", "(Landroid/widget/TextView;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "lineV", "Landroid/view/View;", "getLineV", "()Landroid/view/View;", "setLineV", "(Landroid/view/View;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "getSizeTV", "setSizeTV", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    final class a
    {
      TextView Nnr;
      FrameLayout Yse;
      CheckBox Ysf;
      TextView Ysg;
      View Ysh;
      TextView pJJ;
      TextView timeTV;
      ImageView ttT;
      
      public a()
      {
        AppMethodBeat.i(245608);
        AppMethodBeat.o(245608);
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FolderViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "Landroid/widget/TextView;", "getSizeTV", "()Landroid/widget/TextView;", "setSizeTV", "(Landroid/widget/TextView;)V", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    final class b
    {
      TextView Nnr;
      FrameLayout Yse;
      CheckBox Ysf;
      TextView pJJ;
      TextView timeTV;
      ImageView ttT;
      
      public b()
      {
        AppMethodBeat.i(245570);
        AppMethodBeat.o(245570);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorReportHelper;", "", "()V", "keywordGroup", "Ljava/util/Vector;", "", "getKeywordGroup", "()Ljava/util/Vector;", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/SendFileInWidgetStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/SendFileInWidgetStruct;", "composeKeywords", "doReport", "", "onSwitch", "from", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    final ms Ysj;
    final Vector<String> Ysk;
    
    public f()
    {
      AppMethodBeat.i(245750);
      this.Ysj = new ms();
      this.Ysk = new Vector();
      AppMethodBeat.o(245750);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "", "(Ljava/lang/String;I)V", "TYPE_INVALID", "TYPE_TIME", "TYPE_FILE", "TYPE_FOLDER", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum g
  {
    static
    {
      AppMethodBeat.i(245752);
      Ysl = new g("TYPE_INVALID", 0);
      Ysm = new g("TYPE_TIME", 1);
      Ysn = new g("TYPE_FILE", 2);
      Yso = new g("TYPE_FOLDER", 3);
      Ysp = new g[] { Ysl, Ysm, Ysn, Yso };
      AppMethodBeat.o(245752);
    }
    
    private g() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "", "(Ljava/lang/String;I)V", "FROM_CHATTING", "FROM_FAV", "FROM_SDCARD", "FROM_ALBUM", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum h
  {
    static
    {
      AppMethodBeat.i(245755);
      Ysq = new h("FROM_CHATTING", 0);
      Ysr = new h("FROM_FAV", 1);
      Yss = new h("FROM_SDCARD", 2);
      Yst = new h("FROM_ALBUM", 3);
      Ysu = new h[] { Ysq, Ysr, Yss, Yst };
      AppMethodBeat.o(245755);
    }
    
    private h() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "curFile", "Lcom/tencent/mm/vfs/VFSFile;", "filterDir", "", "rootPath", "subFiles", "", "[Lcom/tencent/mm/vfs/VFSFile;", "createTargetList", "", "deduplicateFolders", "files", "([Lcom/tencent/mm/vfs/VFSFile;)[Lcom/tencent/mm/vfs/VFSFile;", "getParent", "initASync", "loadMoreAsync", "setPath", "setRoot", "root", "sort", "([Lcom/tencent/mm/vfs/VFSFile;)V", "FileSort", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class n
    extends FileSelectorUI.d
  {
    private com.tencent.mm.vfs.u Yry;
    private com.tencent.mm.vfs.u[] Yrz;
    private com.tencent.mm.vfs.u YsG;
    private boolean YsH;
    
    public n()
    {
      super(localObject);
      AppMethodBeat.i(245672);
      this.Yrz = new com.tencent.mm.vfs.u[0];
      AppMethodBeat.o(245672);
    }
    
    private static final int a(a parama1, a parama2)
    {
      AppMethodBeat.i(245694);
      int i = parama1.YsI.compareTo(parama2.YsI);
      AppMethodBeat.o(245694);
      return i;
    }
    
    private final void a(com.tencent.mm.vfs.u[] paramArrayOfu)
    {
      AppMethodBeat.i(245684);
      if (paramArrayOfu != null) {
        if (paramArrayOfu.length != 0) {
          break label26;
        }
      }
      label26:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(245684);
        return;
      }
      Object localObject2 = (List)new ArrayList();
      Object localObject1 = (List)new ArrayList();
      Iterator localIterator = kotlin.g.b.c.ao(paramArrayOfu);
      while (localIterator.hasNext())
      {
        Object localObject3 = (com.tencent.mm.vfs.u)localIterator.next();
        if (localObject3 != null)
        {
          a locala = new a();
          locala.file = ((com.tencent.mm.vfs.u)localObject3);
          locala.time = ((com.tencent.mm.vfs.u)localObject3).lastModified();
          if (((com.tencent.mm.vfs.u)localObject3).isDirectory())
          {
            localObject3 = com.tencent.mm.platformtools.f.RZ(((com.tencent.mm.vfs.u)localObject3).getName());
            kotlin.g.b.s.s(localObject3, "getFullSpell(file.name)");
            localObject3 = ((String)localObject3).toUpperCase();
            kotlin.g.b.s.s(localObject3, "(this as java.lang.String).toUpperCase()");
            kotlin.g.b.s.u(localObject3, "<set-?>");
            locala.YsI = ((String)localObject3);
            ((List)localObject2).add(locala);
          }
          else
          {
            ((List)localObject1).add(locala);
          }
        }
      }
      kotlin.a.p.a((List)localObject2, FileSelectorUI.n..ExternalSyntheticLambda2.INSTANCE);
      Collections.sort((List)localObject1, FileSelectorUI.n..ExternalSyntheticLambda3.INSTANCE);
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfu[i] = ((a)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfu[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(245684);
    }
    
    private static final boolean a(n paramn, com.tencent.mm.vfs.u paramu)
    {
      AppMethodBeat.i(245689);
      kotlin.g.b.s.u(paramn, "this$0");
      kotlin.g.b.s.u(paramu, "pathname");
      if (paramu.isHidden())
      {
        AppMethodBeat.o(245689);
        return false;
      }
      if ((!paramn.YsH) || (!paramu.isDirectory()))
      {
        AppMethodBeat.o(245689);
        return true;
      }
      AppMethodBeat.o(245689);
      return false;
    }
    
    private final void af(com.tencent.mm.vfs.u paramu)
    {
      this.YsG = paramu;
      this.YsH = false;
    }
    
    private static final int b(a parama1, a parama2)
    {
      if (parama1.time == parama2.time) {
        return 0;
      }
      if (parama1.time > parama2.time) {
        return -1;
      }
      return 1;
    }
    
    private static final boolean h(com.tencent.mm.vfs.u paramu, String paramString)
    {
      AppMethodBeat.i(245693);
      kotlin.g.b.s.u(paramString, "filename");
      if (!n.U(paramString, ".", false))
      {
        AppMethodBeat.o(245693);
        return true;
      }
      AppMethodBeat.o(245693);
      return false;
    }
    
    private final void iOo()
    {
      AppMethodBeat.i(245676);
      com.tencent.mm.vfs.u[] arrayOfu = this.Yrz;
      FileSelectorUI localFileSelectorUI;
      int k;
      int i;
      if (arrayOfu != null)
      {
        localFileSelectorUI = FileSelectorUI.this;
        k = arrayOfu.length;
        i = 0;
      }
      for (;;)
      {
        if (i < k)
        {
          Object localObject = arrayOfu[i];
          i += 1;
          if (localObject != null)
          {
            String str1 = com.tencent.mm.vfs.ah.v(((com.tencent.mm.vfs.u)localObject).jKT());
            kotlin.g.b.s.s(str1, "vFile.absolutePath");
            if (Util.isNullOrNil(str1))
            {
              Log.e("MicroMsg.FileSelectorUI", "createTargetList, folder filePath is null, filter!!");
            }
            else
            {
              FileSelectorUI.k localk = new FileSelectorUI.k(localFileSelectorUI);
              localk.a(FileSelectorUI.g.Yso);
              localk.d(FileSelectorUI.h.Yss);
              boolean bool;
              label123:
              int j;
              if (!((com.tencent.mm.vfs.u)localObject).isDirectory())
              {
                bool = true;
                localk.YsD = bool;
                String str2 = ((com.tencent.mm.vfs.u)localObject).getName();
                kotlin.g.b.s.s(str2, "vFile.name");
                localk.aO((CharSequence)str2);
                localk.filePath = str1;
                if (!((com.tencent.mm.vfs.u)localObject).isDirectory()) {
                  break label221;
                }
                localObject = ((com.tencent.mm.vfs.u)localObject).a(FileSelectorUI.n..ExternalSyntheticLambda0.INSTANCE);
                if (localObject != null) {
                  break label214;
                }
                j = 0;
                label187:
                localk.YsC = j;
              }
              for (;;)
              {
                this.YrW.add(localk);
                break;
                bool = false;
                break label123;
                label214:
                j = localObject.length;
                break label187;
                label221:
                if (((com.tencent.mm.vfs.u)localObject).jKV())
                {
                  localk.Ysz = ((com.tencent.mm.vfs.u)localObject).length();
                  localk.createTime = ((com.tencent.mm.vfs.u)localObject).lastModified();
                }
              }
            }
          }
        }
        else
        {
          AppMethodBeat.o(245676);
          return;
        }
      }
    }
    
    public final void ag(com.tencent.mm.vfs.u paramu)
    {
      Set localSet = null;
      AppMethodBeat.i(245715);
      kotlin.g.b.s.u(paramu, "curFile");
      this.Yry = paramu;
      if (this.Yry == null) {
        kotlin.g.b.s.bIx("curFile");
      }
      Object localObject1 = this.Yry;
      paramu = (com.tencent.mm.vfs.u)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("curFile");
        paramu = null;
      }
      int i;
      if (paramu.jKQ())
      {
        localObject1 = this.Yry;
        paramu = (com.tencent.mm.vfs.u)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("curFile");
          paramu = null;
        }
        if (paramu.isDirectory())
        {
          paramu = this.Yry;
          if (paramu != null) {
            break label183;
          }
          kotlin.g.b.s.bIx("curFile");
          paramu = localSet;
          this.Yrz = paramu.a(new FileSelectorUI.n..ExternalSyntheticLambda1(this));
          paramu = this.Yrz;
          if (paramu != null) {
            if (paramu != null)
            {
              if (paramu.length != 0) {
                break label186;
              }
              i = 1;
              label146:
              if (i == 0) {
                break label191;
              }
            }
          }
        }
      }
      for (;;)
      {
        this.Yrz = paramu;
        a(this.Yrz);
        this.YrW.clear();
        iOo();
        AppMethodBeat.o(245715);
        return;
        label183:
        break;
        label186:
        i = 0;
        break label146;
        label191:
        localSet = (Set)new HashSet();
        localObject1 = (List)new ArrayList();
        int k = paramu.length;
        i = 0;
        while (i < k)
        {
          Object localObject2 = paramu[i];
          int j = i + 1;
          i = j;
          if (localObject2 != null) {
            if (!localObject2.isDirectory())
            {
              ((List)localObject1).add(localObject2);
              i = j;
            }
            else
            {
              String str = com.tencent.mm.vfs.ah.v(localObject2.jKT());
              kotlin.g.b.s.s(str, "file.absolutePath");
              i = j;
              if (!localSet.contains(str))
              {
                str = com.tencent.mm.vfs.ah.v(localObject2.jKT());
                kotlin.g.b.s.s(str, "file.absolutePath");
                localSet.add(str);
                ((List)localObject1).add(localObject2);
                i = j;
              }
            }
          }
        }
        paramu = ((Collection)localObject1).toArray(new com.tencent.mm.vfs.u[0]);
        if (paramu == null)
        {
          paramu = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(245715);
          throw paramu;
        }
        paramu = (com.tencent.mm.vfs.u[])paramu;
      }
    }
    
    public final void iOd()
    {
      AppMethodBeat.i(245730);
      af(new com.tencent.mm.vfs.u(com.tencent.mm.loader.i.b.bmu()));
      ag(new com.tencent.mm.vfs.u(com.tencent.mm.loader.i.b.bmu()));
      AppMethodBeat.o(245730);
    }
    
    public final com.tencent.mm.vfs.u iOp()
    {
      Object localObject2 = null;
      AppMethodBeat.i(245724);
      com.tencent.mm.vfs.u localu = this.Yry;
      Object localObject1 = localu;
      if (localu == null)
      {
        kotlin.g.b.s.bIx("curFile");
        localObject1 = null;
      }
      int i = ((com.tencent.mm.vfs.u)localObject1).hashCode();
      localu = this.YsG;
      localObject1 = localu;
      if (localu == null)
      {
        kotlin.g.b.s.bIx("rootPath");
        localObject1 = null;
      }
      if (i == ((com.tencent.mm.vfs.u)localObject1).hashCode())
      {
        AppMethodBeat.o(245724);
        return null;
      }
      localObject1 = this.Yry;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("curFile");
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = ((com.tencent.mm.vfs.u)localObject1).jKP();
        AppMethodBeat.o(245724);
        return localObject1;
      }
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;)V", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFile", "()Lcom/tencent/mm/vfs/VFSFile;", "setFile", "(Lcom/tencent/mm/vfs/VFSFile;)V", "spell", "", "getSpell", "()Ljava/lang/String;", "setSpell", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
    final class a
    {
      String YsI;
      com.tencent.mm.vfs.u file;
      long time;
      
      public a()
      {
        AppMethodBeat.i(245756);
        this.YsI = "";
        AppMethodBeat.o(245756);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/uic/AlbumFileUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<com.tencent.mm.pluginsdk.ui.tools.b.a.b.a>
  {
    p(FileSelectorUI paramFileSelectorUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$10", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnFolderAlbumDialogDismiss;", "onChooseAlbumDialogDismiss", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class q
    implements DropdownListView.e
  {
    q(FileSelectorUI paramFileSelectorUI) {}
    
    public final void fBy()
    {
      AppMethodBeat.i(245658);
      FileSelectorUI.a(this.YrS, null);
      this.YrS.playActionBarOperationAreaAnim();
      AppMethodBeat.o(245658);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$3", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class r
    implements DropdownListView.d
  {
    r(FileSelectorUI paramFileSelectorUI) {}
    
    public final void a(DropdownListView.c paramc)
    {
      Object localObject2 = null;
      AppMethodBeat.i(245667);
      FileSelectorUI.b(this.YrS);
      FileSelectorUI.a(this.YrS, paramc);
      if ((paramc == null) || (kotlin.g.b.s.p(Util.nullAs(FileSelectorUI.c(this.YrS), ""), paramc.name)))
      {
        Log.w("MicroMsg.FileSelectorUI", "want to reset item, item is " + paramc + " or no need load data when same load");
        paramc = FileSelectorUI.i(this.YrS);
        if (paramc != null) {
          FileSelectorUI.b(this.YrS, paramc);
        }
        paramc = FileSelectorUI.j(this.YrS);
        if (paramc != null) {
          break label532;
        }
        kotlin.g.b.s.bIx("dropdownListView");
        paramc = localObject2;
      }
      label532:
      for (;;)
      {
        paramc.fBC();
        AppMethodBeat.o(245667);
        return;
        ListView localListView = FileSelectorUI.d(this.YrS);
        Object localObject1 = localListView;
        if (localListView == null)
        {
          kotlin.g.b.s.bIx("listView");
          localObject1 = null;
        }
        ((ListView)localObject1).setVisibility(0);
        FileSelectorUI.e(this.YrS).setVisibility(8);
        this.YrS.addSearchMenu(true, (com.tencent.mm.ui.tools.s)FileSelectorUI.f(this.YrS));
        localObject1 = FileSelectorUI.g(this.YrS);
        switch (paramc.type)
        {
        }
        int i;
        for (;;)
        {
          i = paramc.type;
          if (i != 1) {
            break label341;
          }
          localObject1 = FileSelectorUI.h(this.YrS);
          paramc = (DropdownListView.c)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("adapter");
            paramc = null;
          }
          paramc.a(FileSelectorUI.h.Ysq);
          break;
          localObject1 = ((FileSelectorUI.f)localObject1).Ysj;
          ((ms)localObject1).jcc += 1L;
          continue;
          localObject1 = ((FileSelectorUI.f)localObject1).Ysj;
          ((ms)localObject1).jcd += 1L;
          continue;
          localObject1 = ((FileSelectorUI.f)localObject1).Ysj;
          ((ms)localObject1).jce += 1L;
          continue;
          localObject1 = ((FileSelectorUI.f)localObject1).Ysj;
          ((ms)localObject1).jcn += 1L;
        }
        label341:
        if (i == 2)
        {
          localObject1 = FileSelectorUI.h(this.YrS);
          paramc = (DropdownListView.c)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("adapter");
            paramc = null;
          }
          paramc.a(FileSelectorUI.h.Ysr);
          break;
        }
        if (i == 3)
        {
          localObject1 = FileSelectorUI.h(this.YrS);
          paramc = (DropdownListView.c)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("adapter");
            paramc = null;
          }
          paramc.a(FileSelectorUI.h.Yss);
          break;
        }
        if (i != 4) {
          break;
        }
        localObject1 = FileSelectorUI.h(this.YrS);
        paramc = (DropdownListView.c)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("adapter");
          paramc = null;
        }
        paramc.a(FileSelectorUI.h.Yst);
        this.YrS.removeSearchMenu();
        localObject1 = FileSelectorUI.d(this.YrS);
        paramc = (DropdownListView.c)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("listView");
          paramc = null;
        }
        paramc.setVisibility(8);
        paramc = FileSelectorUI.e(this.YrS);
        if (paramc != null) {
          paramc.setVisibility(0);
        }
        paramc = FileSelectorUI.e(this.YrS);
        if (paramc == null) {
          break;
        }
        localObject1 = paramc.Yvj;
        if (localObject1 == null) {
          break;
        }
        paramc.WH(((com.tencent.mm.pluginsdk.ui.tools.b.a.a.a)localObject1).HLB.size());
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$4", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "onItemStateChanged", "", "expanded", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements DropdownListView.f
  {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$6", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    implements AbsListView.OnScrollListener
  {
    t(FileSelectorUI paramFileSelectorUI) {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(245652);
      kotlin.g.b.s.u(paramAbsListView, "view");
      AppMethodBeat.o(245652);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(245645);
      kotlin.g.b.s.u(paramAbsListView, "view");
      if (FileSelectorUI.k(this.YrS))
      {
        Log.i("MicroMsg.FileSelectorUI", "search mode, not load data");
        AppMethodBeat.o(245645);
        return;
      }
      if ((paramInt == 0) && (FileSelectorUI.l(this.YrS)))
      {
        Log.i("MicroMsg.FileSelectorUI", "will load data when it at bottom");
        Object localObject = FileSelectorUI.h(this.YrS);
        paramAbsListView = (AbsListView)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("adapter");
          paramAbsListView = null;
        }
        localObject = paramAbsListView.Ysd;
        switch (FileSelectorUI.e.d.$EnumSwitchMapping$0[localObject.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(245645);
        return;
        paramAbsListView.Ysa.iOe();
        AppMethodBeat.o(245645);
        return;
        paramAbsListView.Ysb.iOe();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$7", "Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$OnItemClickListener;", "onItemClick", "", "position", "", "itemView", "Landroid/view/View;", "itemViewType", "onItemSelect", "isChecked", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class u
    implements com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.d
  {
    u(FileSelectorUI paramFileSelectorUI) {}
    
    public final void a(int paramInt1, View paramView, int paramInt2)
    {
      AppMethodBeat.i(245657);
      FileSelectorUI.g(this.YrS).Ysj.jcg = 1L;
      AppMethodBeat.o(245657);
    }
    
    public final void cv(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(245663);
      if (paramInt < 5) {
        paramInt = 1;
      }
      while (paramBoolean) {
        if (paramInt != 0)
        {
          localms = FileSelectorUI.g(this.YrS).Ysj;
          localms.jck += 1L;
          AppMethodBeat.o(245663);
          return;
          paramInt = 0;
        }
        else
        {
          localms = FileSelectorUI.g(this.YrS).Ysj;
          localms.jcl += 1L;
          AppMethodBeat.o(245663);
          return;
        }
      }
      if (paramInt != 0)
      {
        localms = FileSelectorUI.g(this.YrS).Ysj;
        localms.jck -= 1L;
        AppMethodBeat.o(245663);
        return;
      }
      ms localms = FileSelectorUI.g(this.YrS).Ysj;
      localms.jcl -= 1L;
      AppMethodBeat.o(245663);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$9", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class v
    implements s.c
  {
    v(FileSelectorUI paramFileSelectorUI) {}
    
    private static final void r(FileSelectorUI paramFileSelectorUI)
    {
      AppMethodBeat.i(245680);
      kotlin.g.b.s.u(paramFileSelectorUI, "this$0");
      if (FileSelectorUI.h(paramFileSelectorUI) == null) {
        kotlin.g.b.s.bIx("adapter");
      }
      FileSelectorUI.e locale = FileSelectorUI.h(paramFileSelectorUI);
      paramFileSelectorUI = locale;
      if (locale == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramFileSelectorUI = null;
      }
      paramFileSelectorUI.Dm("");
      AppMethodBeat.o(245680);
    }
    
    public final boolean SN(String paramString)
    {
      AppMethodBeat.i(245692);
      kotlin.g.b.s.u(paramString, "searchText");
      AppMethodBeat.o(245692);
      return false;
    }
    
    public final void SO(String paramString)
    {
      AppMethodBeat.i(245688);
      kotlin.g.b.s.u(paramString, "searchText");
      if (!FileSelectorUI.m(this.YrS))
      {
        localObject = FileSelectorUI.n(this.YrS);
        if (localObject != null) {
          ((View)localObject).setVisibility(8);
        }
      }
      FileSelectorUI.e locale = FileSelectorUI.h(this.YrS);
      Object localObject = locale;
      if (locale == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject = null;
      }
      ((FileSelectorUI.e)localObject).Dm(paramString);
      FileSelectorUI.g(this.YrS).Ysk.add(paramString);
      FileSelectorUI.o(this.YrS);
      AppMethodBeat.o(245688);
    }
    
    public final void bWw()
    {
      AppMethodBeat.i(245696);
      FileSelectorUI.a(this.YrS, false);
      Log.d("MicroMsg.FileSelectorUI", "onQuitSearch()");
      MMHandlerThread.postToMainThread(new FileSelectorUI.v..ExternalSyntheticLambda0(this.YrS));
      this.YrS.getController().supportInvalidateOptionsMenu();
      View localView = FileSelectorUI.n(this.YrS);
      if (localView != null) {
        localView.setVisibility(8);
      }
      AppMethodBeat.o(245696);
    }
    
    public final void bWx()
    {
      Object localObject2 = null;
      AppMethodBeat.i(245702);
      DropdownListView localDropdownListView = FileSelectorUI.j(this.YrS);
      Object localObject1 = localDropdownListView;
      if (localDropdownListView == null)
      {
        kotlin.g.b.s.bIx("dropdownListView");
        localObject1 = null;
      }
      if (((DropdownListView)localObject1).wJw)
      {
        localObject1 = FileSelectorUI.j(this.YrS);
        if (localObject1 != null) {
          break label127;
        }
        kotlin.g.b.s.bIx("dropdownListView");
        localObject1 = localObject2;
      }
      label127:
      for (;;)
      {
        ((DropdownListView)localObject1).fBC();
        FileSelectorUI.a(this.YrS, true);
        localObject1 = FileSelectorUI.n(this.YrS);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        localObject1 = FileSelectorUI.f(this.YrS);
        if (localObject1 != null) {
          ((r)localObject1).afKs = true;
        }
        FileSelectorUI.g(this.YrS).Ysj.jcf = 1L;
        Log.i("MicroMsg.FileSelectorUI", "enter search");
        AppMethodBeat.o(245702);
        return;
      }
    }
    
    public final void bWy() {}
    
    public final void bWz() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI
 * JD-Core Version:    0.7.0.1
 */