package com.tencent.mm.pluginsdk.ui.tools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.am.b;
import com.tencent.mm.ui.chatting.am.c;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.s.b;
import com.tencent.mm.ui.widget.AlbumChooserView.a;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import com.tencent.xweb.h;
import com.tencent.xweb.h.a;
import com.tencent.xweb.h.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.i;>;
import java.util.Map;
import java.util.Set;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(19)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "MIN_FIRST_PAGE_ITEM_COUNT", "", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "dropdownItemName", "", "dropdownListItem", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "dropdownListView", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView;", "exitMultiTalkListener", "Lcom/tencent/mm/sdk/event/IListener;", "isFirstTextChanged", "", "isSearching", "listView", "Landroid/widget/ListView;", "mIsToScreenProfile", "onItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "scene", "screenProfileReadyUI", "Lcom/tencent/mm/ui/chatting/ScreenProfileReadyUI;", "searchMask", "Landroid/view/View;", "searchViewHelper", "Lcom/tencent/mm/ui/tools/SearchViewControlKeyBoardShowHelper;", "toUserName", "doSendFile", "", "finish", "getForceOrientation", "getLayoutId", "goToScreenProfile", "name", "path", "ext", "gotoAppAttachDownloadUI", "msgId", "", "gotoUnDownloadFavDetail", "favLocalId", "favDataId", "initDropdownListTitle", "isListAtBottom", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBack", "cancel", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "openFile", "resetItem", "item", "setDropdownListClickListener", "updateDropdownListTitle", "title", "updateState", "ChattingFileSource", "Companion", "FavFileSource", "FileDataSource", "FileSelectorAdapter", "FileType", "FromType", "ListFavFileItem", "ListFileItem", "ListFolderItem", "ListItem", "ListTimeItem", "SdcardFileSource", "app_release"})
public final class FileSelectorUI
  extends MMActivity
{
  public static final FileSelectorUI.b Kuo;
  private final int Kue;
  private e Kuf;
  private r Kug;
  private View Kuh;
  private String Kui;
  private DropdownListView Kuj;
  private DropdownListView.c Kuk;
  private boolean Kul;
  private am Kum;
  private boolean Kun;
  private String dJw;
  private ListView krb;
  private final IListener<?> ndX;
  private boolean poG;
  private final AdapterView.OnItemClickListener ppw;
  private int scene;
  
  static
  {
    AppMethodBeat.i(231152);
    Kuo = new FileSelectorUI.b((byte)0);
    AppMethodBeat.o(231152);
  }
  
  public FileSelectorUI()
  {
    AppMethodBeat.i(231151);
    this.Kue = 10;
    this.ndX = ((IListener)new n(this));
    this.Kul = true;
    this.ppw = ((AdapterView.OnItemClickListener)new x(this));
    AppMethodBeat.o(231151);
  }
  
  private final void Aq(boolean paramBoolean)
  {
    AppMethodBeat.i(231149);
    Object localObject = this.Kuj;
    if (localObject == null) {
      p.btv("dropdownListView");
    }
    if (localObject != null)
    {
      localObject = this.Kuj;
      if (localObject == null) {
        p.btv("dropdownListView");
      }
      if (localObject == null) {
        p.hyc();
      }
      if (((DropdownListView)localObject).qkb)
      {
        localObject = this.Kuj;
        if (localObject == null) {
          p.btv("dropdownListView");
        }
        if (localObject == null) {
          p.hyc();
        }
        ((DropdownListView)localObject).dSg();
        playActionBarOperationAreaAnim();
      }
    }
    if (!paramBoolean)
    {
      localObject = this.Kuf;
      if (localObject == null) {
        p.btv("adapter");
      }
      if (((e)localObject).gsn() != null)
      {
        localObject = this.Kuf;
        if (localObject == null) {
          p.btv("adapter");
        }
        ((e)localObject).gsm();
        localObject = this.Kuf;
        if (localObject == null) {
          p.btv("adapter");
        }
        ((e)localObject).notifyDataSetChanged();
        AppMethodBeat.o(231149);
        return;
      }
    }
    setResult(-2);
    if (paramBoolean) {
      setResult(0);
    }
    finish();
    AppMethodBeat.o(231149);
  }
  
  private final void bm(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(231140);
    Object localObject1 = ac.eom();
    p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    if (((com.tencent.mm.plugin.multitalk.model.q)localObject1).emr())
    {
      setMMTitle(paramString1);
      hideActionBarOperationArea();
      removeSearchMenu();
      setBackBtn((MenuItem.OnMenuItemClickListener)new o(this), 2131689492);
      this.Kun = true;
      paramString1 = this.Kuj;
      if (paramString1 == null) {
        p.btv("dropdownListView");
      }
      if (paramString1 != null) {
        paramString1.setVisibility(4);
      }
      paramString1 = getContext();
      p.g(paramString1, "context");
      this.Kum = new am((Context)paramString1, paramString2, paramString3);
      paramString1 = this.Kum;
      if (paramString1 == null) {
        p.hyc();
      }
      paramString2 = paramString1.filePath;
      paramString3 = paramString1.gCr;
      p.h(paramString2, "filePath");
      p.h(paramString3, "fileExt");
      localObject1 = new File(paramString2);
      if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile())) {}
      for (;;)
      {
        paramString1 = getContentView();
        if (paramString1 != null) {
          break;
        }
        paramString1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(231140);
        throw paramString1;
        localObject1 = new HashMap();
        ((Map)localObject1).put("extra_param_disable_scale", "false");
        ((Map)localObject1).put("extra_param_bg_color", String.valueOf(Color.parseColor("#ededed")));
        ((Map)localObject1).put("extra_param_disable_finish_activity", "true");
        ((Map)localObject1).put("extra_param_set_max_scale", "3");
        ((Map)localObject1).put("extra_param_download_text_color", "-16777216");
        long l1 = paramString1.hashCode();
        long l2 = System.currentTimeMillis();
        h.c localc = h.c.Szr;
        Object localObject2 = paramString1.getContext();
        if (localObject2 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(231140);
          throw paramString1;
        }
        localObject2 = (Activity)localObject2;
        RelativeLayout localRelativeLayout = paramString1.Pko;
        if (localRelativeLayout == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(231140);
          throw paramString1;
        }
        h.a(paramString2, paramString3, String.valueOf(l1 + l2), true, (HashMap)localObject1, localc, (Activity)localObject2, (ViewGroup)localRelativeLayout, (h.a)new am.b(paramString1), (ValueCallback)new am.c(paramString1));
      }
      ((ViewGroup)paramString1).addView((View)this.Kum);
      setRequestedOrientation(4);
    }
    AppMethodBeat.o(231140);
  }
  
  private final void dmp()
  {
    AppMethodBeat.i(231150);
    e locale = this.Kuf;
    if (locale == null) {
      p.btv("adapter");
    }
    if (locale == null) {
      p.hyc();
    }
    int i = locale.Kux.size();
    if (3 != this.scene)
    {
      if (i > 0)
      {
        updateOptionMenuText(1, getString(2131755976).toString() + "(" + i + "/9)");
        enableOptionMenu(1, true);
        AppMethodBeat.o(231150);
        return;
      }
      updateOptionMenuText(1, getString(2131755976));
      enableOptionMenu(1, false);
    }
    AppMethodBeat.o(231150);
  }
  
  private final void gsf()
  {
    AppMethodBeat.i(231144);
    initActionBarOperationArea();
    initActionBarOperationAreaTxt(getString(2131759391), 2131099746, 2131099746, 2131232452, 2131232451);
    AppMethodBeat.o(231144);
  }
  
  private final void gsg()
  {
    AppMethodBeat.i(231145);
    setActionBarOperationAreaClickListener((AlbumChooserView.a)new z(this));
    AppMethodBeat.o(231145);
  }
  
  public final void finish()
  {
    AppMethodBeat.i(231143);
    super.finish();
    e locale = this.Kuf;
    if (locale == null) {
      p.btv("adapter");
    }
    locale.Kuy.gsh();
    AppMethodBeat.o(231143);
  }
  
  public final int getForceOrientation()
  {
    if (!this.Kun) {
      return 1;
    }
    return 4;
  }
  
  public final int getLayoutId()
  {
    return 2131494183;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(231148);
    if ((paramInt1 == 4) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("filePath");
      String str2 = paramIntent.getStringExtra("fileName");
      String str3 = paramIntent.getStringExtra("fileExt");
      if ((n.I(str3, "ppt", true)) || (n.I(str3, "pdf", true)) || (n.I(str3, "doc", true)) || (n.I(str3, "docx", true)) || (n.I(str3, "pptx", true)))
      {
        if (str2 == null) {
          p.hyc();
        }
        if (str1 == null) {
          p.hyc();
        }
        if (str3 == null) {
          p.hyc();
        }
        bm(str2, str1, str3);
        AppMethodBeat.o(231148);
        return;
      }
      if (paramIntent.getBooleanExtra("resLoadFailed", false))
      {
        u.cH((Context)this, getResources().getString(2131759394));
        AppMethodBeat.o(231148);
        return;
      }
      u.cH((Context)this, getResources().getString(2131765013));
      AppMethodBeat.o(231148);
      return;
    }
    if (((paramInt1 != 0) || (paramInt2 != -1)) && (paramInt1 == 2))
    {
      a.a((Activity)this, paramInt1, paramInt2, paramIntent, true, 2131758379, 2131758380, 1);
      u.makeText((Context)this, 2131759383, 0).show();
    }
    AppMethodBeat.o(231148);
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(231141);
    p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
    if ((this.Kun) && (this.Kum != null))
    {
      paramConfiguration = this.Kum;
      if (paramConfiguration == null) {
        p.hyc();
      }
      paramConfiguration.gOo();
      paramConfiguration.gOn();
    }
    AppMethodBeat.o(231141);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(231139);
    super.onCreate(paramBundle);
    long l = System.currentTimeMillis();
    this.dJw = getIntent().getStringExtra("TO_USER");
    this.scene = getIntent().getIntExtra("scene", 0);
    getController().gIL();
    getController().a((AppCompatActivity)this);
    gsg();
    setBackBtn((MenuItem.OnMenuItemClickListener)new p(this), 2131689510);
    if (3 != this.scene) {
      addTextOptionMenu(1, getString(2131755976), (MenuItem.OnMenuItemClickListener)new q(this), null, t.b.OGU);
    }
    for (;;)
    {
      gsf();
      paramBundle = findViewById(2131299805);
      p.g(paramBundle, "findViewById(R.id.dropdown_list_view)");
      this.Kuj = ((DropdownListView)paramBundle);
      paramBundle = getString(2131759391);
      p.g(paramBundle, "getString(R.string.file_explorer_title_chatting)");
      paramBundle = new DropdownListView.c(paramBundle, 2131690779, 1);
      localObject = getString(2131759392);
      p.g(localObject, "getString(R.string.file_explorer_title_fav)");
      localObject = new DropdownListView.c((String)localObject, 2131690799, 2);
      String str = getString(2131759393);
      p.g(str, "getString(R.string.file_explorer_title_local)");
      paramBundle = j.ac(new DropdownListView.c[] { paramBundle, localObject, new DropdownListView.c(str, 2131690806, 3) });
      localObject = this.Kuj;
      if (localObject == null) {
        p.btv("dropdownListView");
      }
      ((DropdownListView)localObject).setItems((List)paramBundle);
      paramBundle = this.Kuj;
      if (paramBundle == null) {
        p.btv("dropdownListView");
      }
      paramBundle.setListener((DropdownListView.d)new r(this));
      paramBundle = this.Kuj;
      if (paramBundle == null) {
        p.btv("dropdownListView");
      }
      paramBundle.setOnItemStateChanged((DropdownListView.e)new s());
      this.Kuf = new e();
      paramBundle = findViewById(2131300620);
      if (paramBundle != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(231139);
      throw paramBundle;
      if (!EventCenter.instance.hadListened(this.ndX)) {
        EventCenter.instance.addListener(this.ndX);
      }
    }
    this.krb = ((ListView)paramBundle);
    paramBundle = this.Kuf;
    if (paramBundle == null) {
      p.btv("adapter");
    }
    paramBundle.a(g.KuM);
    paramBundle = this.krb;
    if (paramBundle == null) {
      p.btv("listView");
    }
    Object localObject = this.Kuf;
    if (localObject == null) {
      p.btv("adapter");
    }
    paramBundle.setAdapter((ListAdapter)localObject);
    paramBundle = this.krb;
    if (paramBundle == null) {
      p.btv("listView");
    }
    paramBundle.setOnTouchListener((View.OnTouchListener)new t(this));
    paramBundle = this.krb;
    if (paramBundle == null) {
      p.btv("listView");
    }
    paramBundle.setOnItemClickListener(this.ppw);
    paramBundle = this.krb;
    if (paramBundle == null) {
      p.btv("listView");
    }
    paramBundle.setOnScrollListener((AbsListView.OnScrollListener)new u(this));
    paramBundle = this.krb;
    if (paramBundle == null) {
      p.btv("listView");
    }
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.setEmptyView(findViewById(2131300614));
    paramBundle = this.krb;
    if (paramBundle == null) {
      p.btv("listView");
    }
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = paramBundle.getEmptyView();
    p.g(paramBundle, "listView!!.emptyView");
    paramBundle.setVisibility(8);
    this.Kuh = findViewById(2131307407);
    paramBundle = this.Kuh;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.Kuh;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)FileSelectorUI.v.Kvi);
    }
    this.Kug = new r();
    paramBundle = this.Kug;
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle.a((s.b)new w(this));
    addSearchMenu(true, (com.tencent.mm.ui.tools.s)this.Kug);
    dmp();
    Log.i("MicroMsg.FileSelectorUI", "onCreate, cost:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(231139);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(231146);
    super.onDestroy();
    EventCenter.instance.removeListener(this.ndX);
    r localr = this.Kug;
    if (localr != null)
    {
      localr.gXP();
      AppMethodBeat.o(231146);
      return;
    }
    AppMethodBeat.o(231146);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(231147);
    p.h(paramKeyEvent, "event");
    if (paramInt == 4)
    {
      Log.i("MicroMsg.FileSelectorUI", "onKeyDown back");
      if (this.Kun)
      {
        paramKeyEvent = this.Kum;
        if (paramKeyEvent != null) {
          paramKeyEvent.removeAllViews();
        }
        paramKeyEvent = getContentView();
        if (paramKeyEvent == null)
        {
          paramKeyEvent = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(231147);
          throw paramKeyEvent;
        }
        ((ViewGroup)paramKeyEvent).removeView((View)this.Kum);
        setBackBtn((MenuItem.OnMenuItemClickListener)new y(this), 2131689510);
        paramKeyEvent = this.Kuj;
        if (paramKeyEvent == null) {
          p.btv("dropdownListView");
        }
        if (paramKeyEvent != null) {
          paramKeyEvent.setVisibility(0);
        }
        gsg();
        gsf();
        setRequestedOrientation(1);
        addSearchMenu(true, (com.tencent.mm.ui.tools.s)this.Kug);
        paramKeyEvent = com.tencent.mm.plugin.multitalk.d.f.zZd;
        com.tencent.mm.plugin.multitalk.d.f.eql();
        this.Kun = false;
      }
      for (;;)
      {
        AppMethodBeat.o(231147);
        return true;
        Aq(false);
      }
    }
    if (paramInt == 82)
    {
      paramKeyEvent = this.Kuj;
      if (paramKeyEvent == null) {
        p.btv("dropdownListView");
      }
      if (paramKeyEvent != null)
      {
        paramKeyEvent = this.Kuj;
        if (paramKeyEvent == null) {
          p.btv("dropdownListView");
        }
        if (paramKeyEvent == null) {
          p.hyc();
        }
        paramKeyEvent.dSg();
      }
      AppMethodBeat.o(231147);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(231147);
    return bool;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(231142);
    super.onPause();
    if ((!isFinishing()) && (!isDestroyed()))
    {
      DropdownListView localDropdownListView = this.Kuj;
      if (localDropdownListView == null) {
        p.btv("dropdownListView");
      }
      if (localDropdownListView != null)
      {
        localDropdownListView = this.Kuj;
        if (localDropdownListView == null) {
          p.btv("dropdownListView");
        }
        if (localDropdownListView == null) {
          p.hyc();
        }
        if (localDropdownListView.qkb)
        {
          localDropdownListView = this.Kuj;
          if (localDropdownListView == null) {
            p.btv("dropdownListView");
          }
          if (localDropdownListView == null) {
            p.hyc();
          }
          if (!localDropdownListView.qkb)
          {
            Log.w("MicroMsg.DropdownListView", "want to close, but it was closed");
            AppMethodBeat.o(231142);
            return;
          }
          if (localDropdownListView.xpW)
          {
            Log.d("MicroMsg.DropdownListView", "want to close, but it is in animation");
            AppMethodBeat.o(231142);
            return;
          }
          FrameLayout localFrameLayout = localDropdownListView.xpS;
          if (localFrameLayout == null) {
            p.hyc();
          }
          localFrameLayout.setVisibility(8);
          localDropdownListView.qkb = false;
          if ((localDropdownListView.KtA != null) && (localDropdownListView.KtA == null)) {
            p.hyc();
          }
        }
      }
    }
    AppMethodBeat.o(231142);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "Landroid/widget/BaseAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "FILE_TYPE_COUNT", "", "TAG", "", "chattingFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ChattingFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "favFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FavFileSource;", "fileList", "", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListItem;", "fromType", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "sdcardFileSource", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "selectedFileLst", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "getSelectedFileLst", "()Ljava/util/List;", "finish", "", "getCount", "getDataSourceFrom", "getIconSrc", "name", "getItem", "position", "getItemId", "", "getItemViewType", "getListItemFromData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getParentPath", "Lcom/tencent/mm/vfs/VFSFile;", "getThumbnail", "Landroid/graphics/Bitmap;", "path", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "getViewTypeCount", "isAudio", "", "fileName", "isCompressFile", "isDoc", "isFromSDCard", "isHtml", "isImg", "isInit", "isKeynote", "isNumber", "isPages", "isPdf", "isPpt", "isTxt", "isVideo", "isXls", "loadData", "onBottomLoadMore", "onInit", "onLoadMoreCompleted", "onSelectorWrapperClicked", "v", "search", "content", "setDataSourceFrom", "setParentPath", "setPath", "FileViewHolder", "FolderViewHolder", "TimeViewHolder", "app_release"})
  public final class e
    extends BaseAdapter
  {
    final FileSelectorUI.m KuA;
    FileSelectorUI.g KuB;
    private List<FileSelectorUI.k> Kuu;
    private final int Kuw;
    final List<FileSelectorUI.i> Kux;
    final FileSelectorUI.a Kuy;
    final FileSelectorUI.c Kuz;
    private final String TAG;
    
    public e()
    {
      AppMethodBeat.i(231093);
      this.TAG = "MicroMsg.FileSelectorAdapter";
      this.Kuw = 4;
      List localList = Collections.synchronizedList((List)new ArrayList());
      p.g(localList, "Collections.synchronized…st(ArrayList<ListItem>())");
      this.Kuu = localList;
      localList = Collections.synchronizedList((List)new ArrayList());
      p.g(localList, "Collections.synchronized…rrayList<ListFileItem>())");
      this.Kux = localList;
      this.Kuy = new FileSelectorUI.a(this$1, this);
      this.Kuz = new FileSelectorUI.c(this$1, this);
      this.KuA = new FileSelectorUI.m(this$1, this);
      this.KuB = FileSelectorUI.g.KuM;
      AppMethodBeat.o(231093);
    }
    
    private final boolean b(FileSelectorUI.g paramg)
    {
      AppMethodBeat.i(231068);
      switch (f.haE[paramg.ordinal()])
      {
      default: 
        paramg = new m();
        AppMethodBeat.o(231068);
        throw paramg;
      case 1: 
        bool = this.Kuy.hasInit;
        AppMethodBeat.o(231068);
        return bool;
      case 2: 
        bool = this.Kuz.hasInit;
        AppMethodBeat.o(231068);
        return bool;
      }
      boolean bool = this.KuA.hasInit;
      AppMethodBeat.o(231068);
      return bool;
    }
    
    private static boolean bfA(String paramString)
    {
      AppMethodBeat.i(231089);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231089);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.K(paramString, ".key", false);
      AppMethodBeat.o(231089);
      return bool;
    }
    
    private static boolean bfB(String paramString)
    {
      AppMethodBeat.i(231091);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231091);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.K(paramString, ".number", false);
      AppMethodBeat.o(231091);
      return bool;
    }
    
    private static boolean bfC(String paramString)
    {
      AppMethodBeat.i(231092);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231092);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.K(paramString, ".pages", false);
      AppMethodBeat.o(231092);
      return bool;
    }
    
    private static int bfq(String paramString)
    {
      AppMethodBeat.i(231079);
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231079);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if (bft(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689588;
      }
      if (bfr(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131230967;
      }
      if (bfy(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689576;
      }
      if (bfz(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689579;
      }
      if (bfu(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689571;
      }
      if (bfv(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689574;
      }
      if (bfw(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689560;
      }
      if (bx(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689567;
      }
      if (by(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689584;
      }
      if (df(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689587;
      }
      if (bfA(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689564;
      }
      if (bfB(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689569;
      }
      if (bfC(paramString))
      {
        AppMethodBeat.o(231079);
        return 2131689570;
      }
      AppMethodBeat.o(231079);
      return 2131689580;
    }
    
    public static boolean bfr(String paramString)
    {
      AppMethodBeat.i(231080);
      p.h(paramString, "fileName");
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231080);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((Build.VERSION.SDK_INT >= 28) && (n.K(paramString, ".heic", false)))
      {
        AppMethodBeat.o(231080);
        return true;
      }
      if ((n.K(paramString, ".bmp", false)) || (n.K(paramString, ".png", false)) || (n.K(paramString, ".jpg", false)) || (n.K(paramString, ".jpeg", false)) || (n.K(paramString, ".gif", false)))
      {
        AppMethodBeat.o(231080);
        return true;
      }
      AppMethodBeat.o(231080);
      return false;
    }
    
    private static boolean bft(String paramString)
    {
      AppMethodBeat.i(231084);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231084);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".doc", false)) || (n.K(paramString, ".docx", false)) || (n.K(paramString, "wps", false)))
      {
        AppMethodBeat.o(231084);
        return true;
      }
      AppMethodBeat.o(231084);
      return false;
    }
    
    private static boolean bfu(String paramString)
    {
      AppMethodBeat.i(231085);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231085);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.K(paramString, ".pdf", false);
      AppMethodBeat.o(231085);
      return bool;
    }
    
    private static boolean bfv(String paramString)
    {
      AppMethodBeat.i(231086);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231086);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".ppt", false)) || (n.K(paramString, ".pptx", false)))
      {
        AppMethodBeat.o(231086);
        return true;
      }
      AppMethodBeat.o(231086);
      return false;
    }
    
    private static boolean bfw(String paramString)
    {
      AppMethodBeat.i(231087);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231087);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".xls", false)) || (n.K(paramString, ".xlsx", false)))
      {
        AppMethodBeat.o(231087);
        return true;
      }
      AppMethodBeat.o(231087);
      return false;
    }
    
    private static boolean bfy(String paramString)
    {
      AppMethodBeat.i(231083);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231083);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".rar", false)) || (n.K(paramString, ".zip", false)) || (n.K(paramString, ".7z", false)) || (n.K(paramString, "tar", false)) || (n.K(paramString, ".iso", false)))
      {
        AppMethodBeat.o(231083);
        return true;
      }
      AppMethodBeat.o(231083);
      return false;
    }
    
    private static boolean bfz(String paramString)
    {
      AppMethodBeat.i(231088);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231088);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".txt", false)) || (n.K(paramString, ".rtf", false)))
      {
        AppMethodBeat.o(231088);
        return true;
      }
      AppMethodBeat.o(231088);
      return false;
    }
    
    private static boolean bx(String paramString)
    {
      AppMethodBeat.i(231081);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231081);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".mp3", false)) || (n.K(paramString, ".wma", false)))
      {
        AppMethodBeat.o(231081);
        return true;
      }
      AppMethodBeat.o(231081);
      return false;
    }
    
    public static boolean by(String paramString)
    {
      AppMethodBeat.i(231082);
      p.h(paramString, "fileName");
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231082);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      if ((n.K(paramString, ".mp4", false)) || (n.K(paramString, ".rm", false)))
      {
        AppMethodBeat.o(231082);
        return true;
      }
      AppMethodBeat.o(231082);
      return false;
    }
    
    private final void c(FileSelectorUI.g paramg)
    {
      AppMethodBeat.i(231070);
      switch (f.vke[paramg.ordinal()])
      {
      }
      for (;;)
      {
        AppMethodBeat.o(231070);
        return;
        this.Kuy.gsl();
        AppMethodBeat.o(231070);
        return;
        this.Kuz.gsl();
        AppMethodBeat.o(231070);
        return;
        this.KuA.gsl();
      }
    }
    
    private static boolean df(String paramString)
    {
      AppMethodBeat.i(231090);
      paramString = Util.nullAsNil(paramString);
      p.g(paramString, "Util.nullAsNil(fileName)");
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231090);
        throw paramString;
      }
      paramString = paramString.toLowerCase();
      p.g(paramString, "(this as java.lang.String).toLowerCase()");
      boolean bool = n.K(paramString, ".html", false);
      AppMethodBeat.o(231090);
      return bool;
    }
    
    private final boolean gso()
    {
      return FileSelectorUI.g.KuO == this.KuB;
    }
    
    private final ArrayList<FileSelectorUI.k> iy(List<FileSelectorUI.i> paramList)
    {
      AppMethodBeat.i(231073);
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = "";
      Iterator localIterator = ((Iterable)paramList).iterator();
      paramList = (List<FileSelectorUI.i>)localObject1;
      while (localIterator.hasNext())
      {
        FileSelectorUI.i locali = (FileSelectorUI.i)localIterator.next();
        Object localObject2;
        if ((locali == null) || (FileSelectorUI.f.KuH == locali.KuY))
        {
          localObject2 = this.TAG;
          if (locali == null) {}
          for (localObject1 = "getListItemFromData, fileItem=null";; localObject1 = "getListItemFromData, type:FileType.TYPE_INVALID")
          {
            Log.e((String)localObject2, (String)localObject1);
            break;
          }
        }
        localObject1 = paramList;
        if (FileSelectorUI.f.KuK != locali.KuY)
        {
          localObject1 = paramList;
          if ((p.j(paramList, locali.title) ^ true))
          {
            localObject2 = new FileSelectorUI.l(this.Kup);
            ((FileSelectorUI.k)localObject2).title = locali.title;
            localObject1 = ((FileSelectorUI.k)localObject2).title;
            paramList = (List<FileSelectorUI.i>)localObject1;
            if (localObject1 == null) {
              paramList = "";
            }
            ((FileSelectorUI.l)localObject2).a(FileSelectorUI.f.KuI);
            localArrayList.add(localObject2);
            localObject1 = paramList;
          }
        }
        localArrayList.add(locali);
        paramList = (List<FileSelectorUI.i>)localObject1;
      }
      AppMethodBeat.o(231073);
      return localArrayList;
    }
    
    public final void DO(String paramString)
    {
      AppMethodBeat.i(231067);
      p.h(paramString, "content");
      FileSelectorUI.g localg = this.KuB;
      switch (f.$EnumSwitchMapping$0[localg.ordinal()])
      {
      default: 
        paramString = new m();
        AppMethodBeat.o(231067);
        throw paramString;
      case 1: 
        paramString = (List)iy(this.Kuy.bfx(paramString));
      }
      for (;;)
      {
        this.Kuu = paramString;
        notifyDataSetChanged();
        AppMethodBeat.o(231067);
        return;
        paramString = (List)iy(this.Kuz.bfx(paramString));
        continue;
        paramString = (List)iy(this.KuA.bfx(paramString));
      }
    }
    
    public final void a(FileSelectorUI.g paramg)
    {
      AppMethodBeat.i(231066);
      p.h(paramg, "fromType");
      if (!b(paramg)) {
        c(paramg);
      }
      this.KuB = paramg;
      bqe();
      AppMethodBeat.o(231066);
    }
    
    public final FileSelectorUI.k aiR(int paramInt)
    {
      AppMethodBeat.i(231076);
      FileSelectorUI.k localk = (FileSelectorUI.k)this.Kuu.get(paramInt);
      AppMethodBeat.o(231076);
      return localk;
    }
    
    final void bqe()
    {
      AppMethodBeat.i(231069);
      Object localObject = this.KuB;
      switch (f.uqL[localObject.ordinal()])
      {
      default: 
        localObject = new m();
        AppMethodBeat.o(231069);
        throw ((Throwable)localObject);
      case 1: 
        localObject = (List)iy(this.Kuy.Kuu);
      }
      for (;;)
      {
        this.Kuu = ((List)localObject);
        notifyDataSetChanged();
        if (this.Kuu.size() > 0) {
          break;
        }
        localObject = FileSelectorUI.c(this.Kup).getEmptyView();
        if (localObject == null) {
          break;
        }
        ((View)localObject).setVisibility(0);
        AppMethodBeat.o(231069);
        return;
        localObject = (List)iy(this.Kuz.Kuu);
        continue;
        localObject = (List)iy(this.KuA.Kuu);
      }
      AppMethodBeat.o(231069);
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(231075);
      List localList = this.Kuu;
      if (localList == null) {
        p.hyc();
      }
      int i = localList.size();
      AppMethodBeat.o(231075);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(231074);
      paramInt = aiR(paramInt).KuY.ordinal();
      AppMethodBeat.o(231074);
      return paramInt;
    }
    
    @SuppressLint({"ResourceType"})
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(231078);
      p.h(paramViewGroup, "parent");
      FileSelectorUI.k localk = aiR(paramInt);
      Object localObject1 = localk.KuY;
      switch (f.vlj[localObject1.ordinal()])
      {
      default: 
        Log.f(this.TAG, "impossible path, Fuck felixzhou!");
        if (paramView == null) {
          p.hyc();
        }
        AppMethodBeat.o(231078);
        return paramView;
      case 1: 
        if (paramView == null)
        {
          paramView = View.inflate(paramViewGroup.getContext(), 2131494182, null);
          paramViewGroup = new c();
          localObject1 = paramView.findViewById(2131302870);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.jVO = ((TextView)localObject1);
          p.g(paramView, "convertView");
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          paramViewGroup = paramViewGroup.jVO;
          if (paramViewGroup == null) {
            p.hyc();
          }
          paramViewGroup.setText((CharSequence)localk.title);
          AppMethodBeat.o(231078);
          return paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.TimeViewHolder");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup = (c)paramViewGroup;
        }
      case 2: 
        if (paramView == null)
        {
          paramView = View.inflate(paramViewGroup.getContext(), 2131494180, null);
          paramViewGroup = new a();
          localObject1 = paramView.findViewById(2131302859);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.KuC = ((FrameLayout)localObject1);
          localObject1 = paramViewGroup.KuC;
          if (localObject1 == null) {
            p.hyc();
          }
          localObject1 = ((FrameLayout)localObject1).findViewById(2131302858);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.KuD = ((CheckBox)localObject1);
          localObject1 = paramView.findViewById(2131302812);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.nnL = ((ImageView)localObject1);
          localObject1 = paramView.findViewById(2131302870);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.jVO = ((TextView)localObject1);
          localObject1 = paramView.findViewById(2131302863);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.Bvi = ((TextView)localObject1);
          localObject1 = paramView.findViewById(2131302868);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.timeTV = ((TextView)localObject1);
          localObject1 = paramView.findViewById(2131302810);
          if (localObject1 == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup.KuE = ((TextView)localObject1);
          paramViewGroup.KuF = paramView.findViewById(2131302827);
          if (getCount() - 1 == paramInt)
          {
            localObject1 = paramViewGroup.KuF;
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(4);
            }
          }
          localObject1 = paramViewGroup.KuC;
          if (localObject1 == null) {
            p.hyc();
          }
          ((FrameLayout)localObject1).setOnClickListener((View.OnClickListener)new FileSelectorUI.e.d(this));
          p.g(paramView, "convertView");
          paramView.setTag(paramViewGroup);
        }
        for (;;)
        {
          localObject1 = paramViewGroup.jVO;
          if (localObject1 == null) {
            p.hyc();
          }
          if (localk != null) {
            break;
          }
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
          AppMethodBeat.o(231078);
          throw paramView;
          paramViewGroup = paramView.getTag();
          if (paramViewGroup == null)
          {
            paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FileViewHolder");
            AppMethodBeat.o(231078);
            throw paramView;
          }
          paramViewGroup = (a)paramViewGroup;
        }
        ((TextView)localObject1).setText(((FileSelectorUI.i)localk).gsq());
        if (3 == FileSelectorUI.b(this.Kup))
        {
          localObject1 = paramViewGroup.KuC;
          if (localObject1 == null) {
            p.hyc();
          }
          ((FrameLayout)localObject1).setVisibility(4);
        }
        for (;;)
        {
          localObject1 = paramViewGroup.Bvi;
          if (localObject1 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setVisibility(0);
          localObject1 = paramViewGroup.timeTV;
          if (localObject1 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setVisibility(0);
          localObject1 = paramViewGroup.jVO;
          if (localObject1 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setText(((FileSelectorUI.i)localk).gsq());
          localObject1 = paramViewGroup.Bvi;
          if (localObject1 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setText((CharSequence)Util.getSizeKB(((FileSelectorUI.i)localk).zGp));
          if (((FileSelectorUI.i)localk).KuU == 2)
          {
            localObject1 = paramViewGroup.Bvi;
            if (localObject1 == null) {
              p.hyc();
            }
            ((TextView)localObject1).setText((CharSequence)(">" + ((af)g.ah(af.class)).getFileSizeLimitInMB(true) + "MB"));
          }
          localObject1 = paramViewGroup.timeTV;
          if (localObject1 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.i.f.c((Context)this.Kup.getContext(), ((FileSelectorUI.i)localk).createTime, true));
          localObject1 = paramViewGroup.nnL;
          if (localObject1 == null) {
            p.hyc();
          }
          ((ImageView)localObject1).setImageResource(bfq(((FileSelectorUI.i)localk).gsq().toString()));
          localObject1 = paramViewGroup.KuE;
          if (localObject1 == null) {
            p.hyc();
          }
          ((TextView)localObject1).setText(((FileSelectorUI.i)localk).KuS);
          localObject1 = paramViewGroup.KuD;
          if (localObject1 == null) {
            p.hyc();
          }
          ((CheckBox)localObject1).setChecked(this.Kux.contains(localk));
          paramViewGroup = paramViewGroup.KuC;
          if (paramViewGroup == null) {
            p.hyc();
          }
          paramViewGroup.setTag(Integer.valueOf(paramInt));
          AppMethodBeat.o(231078);
          return paramView;
          localObject1 = paramViewGroup.KuC;
          if (localObject1 == null) {
            p.hyc();
          }
          ((FrameLayout)localObject1).setVisibility(0);
        }
      }
      if (paramView == null)
      {
        paramViewGroup = View.inflate(paramViewGroup.getContext(), 2131494700, null);
        localObject1 = new b();
        ((b)localObject1).KuC = ((FrameLayout)paramViewGroup.findViewById(2131302859));
        paramView = ((b)localObject1).KuC;
        if (paramView == null) {
          p.hyc();
        }
        paramView = paramView.findViewById(2131302858);
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type android.widget.CheckBox");
          AppMethodBeat.o(231078);
          throw paramView;
        }
        ((b)localObject1).KuD = ((CheckBox)paramView);
        ((b)localObject1).nnL = ((ImageView)paramViewGroup.findViewById(2131302812));
        ((b)localObject1).jVO = ((TextView)paramViewGroup.findViewById(2131302870));
        ((b)localObject1).Bvi = ((TextView)paramViewGroup.findViewById(2131302863));
        ((b)localObject1).timeTV = ((TextView)paramViewGroup.findViewById(2131302868));
        paramView = ((b)localObject1).KuC;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setOnClickListener((View.OnClickListener)new FileSelectorUI.e.e(this));
        p.g(paramViewGroup, "convertView");
        paramViewGroup.setTag(localObject1);
        if (localk != null) {
          break label1424;
        }
        try
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFolderItem");
          AppMethodBeat.o(231078);
          throw paramView;
        }
        catch (Exception paramView)
        {
          Log.e(this.TAG, paramView.getMessage(), new Object[] { "item is ListFileItem:" + (localk instanceof FileSelectorUI.i) });
        }
      }
      label1424:
      FileSelectorUI.j localj;
      Object localObject2;
      for (;;)
      {
        AppMethodBeat.o(231078);
        return paramViewGroup;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.FileSelectorAdapter.FolderViewHolder");
          AppMethodBeat.o(231078);
          throw paramView;
        }
        localObject1 = (b)paramViewGroup;
        paramViewGroup = paramView;
        break;
        localj = (FileSelectorUI.j)localk;
        localObject2 = ((b)localObject1).jVO;
        if (localObject2 == null) {
          p.hyc();
        }
        if (localj == null) {
          break label2057;
        }
        paramView = localj.gsq();
        ((TextView)localObject2).setText(paramView);
        if (localj == null) {
          break label2062;
        }
        paramView = Boolean.valueOf(localj.KuX);
        label1477:
        if (paramView.booleanValue()) {
          break label1656;
        }
        paramView = ((b)localObject1).nnL;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setImageResource(2131689563);
        paramView = ((b)localObject1).KuC;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setVisibility(4);
        paramView = ((b)localObject1).Bvi;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setVisibility(0);
        paramView = ((b)localObject1).timeTV;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setVisibility(8);
        paramView = ((b)localObject1).Bvi;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setText((CharSequence)this.Kup.getString(2131759385, new Object[] { Integer.valueOf(localj.KuW) }));
        label1604:
        paramView = ((b)localObject1).KuD;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setChecked(this.Kux.contains(localj));
        paramView = ((b)localObject1).KuC;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setTag(Integer.valueOf(paramInt));
      }
      label1656:
      Object localObject3;
      if (3 == FileSelectorUI.b(this.Kup))
      {
        paramView = ((b)localObject1).KuC;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setVisibility(4);
        label1685:
        paramView = ((b)localObject1).Bvi;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setVisibility(0);
        paramView = ((b)localObject1).timeTV;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setVisibility(0);
        paramView = ((b)localObject1).Bvi;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setText((CharSequence)Util.getSizeKB(localj.zGp));
        paramView = ((b)localObject1).timeTV;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setText(com.tencent.mm.pluginsdk.i.f.c((Context)this.Kup.getContext(), localj.createTime, true));
        localObject2 = localj.gsq();
        if (!bfr(localObject2.toString())) {
          break label2029;
        }
        paramView = FileSelectorUI.d(this.Kup);
        if (paramView == null) {
          break label2072;
        }
        localObject3 = localj.filePath;
        if (!Util.isNullOrNil((String)localObject3)) {
          break label1893;
        }
        Log.e(paramView.TAG, "getThumbnail fail, path not exist");
        break label2067;
      }
      for (;;)
      {
        if (paramView != null)
        {
          localObject2 = ((b)localObject1).nnL;
          if (localObject2 == null) {
            p.hyc();
          }
          ((ImageView)localObject2).setImageBitmap(paramView);
          break label1604;
          paramView = ((b)localObject1).KuC;
          if (paramView == null) {
            p.hyc();
          }
          paramView.setVisibility(0);
          break label1685;
          label1893:
          localObject3 = paramView.Kup.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[] { "_id" }, "_data=?", new String[] { localObject3 }, null);
          if (localObject3 == null) {
            break label2067;
          }
          if (((Cursor)localObject3).moveToFirst())
          {
            int i = ((Cursor)localObject3).getInt(((Cursor)localObject3).getColumnIndex("_id"));
            ((Cursor)localObject3).close();
            paramView = MediaStore.Images.Thumbnails.getThumbnail(paramView.Kup.getContentResolver(), i, 3, null);
            continue;
          }
          ((Cursor)localObject3).close();
          break label2067;
        }
        paramView = ((b)localObject1).nnL;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setImageResource(bfq(localObject2.toString()));
        break label1604;
        label2029:
        paramView = ((b)localObject1).nnL;
        if (paramView == null) {
          p.hyc();
        }
        paramView.setImageResource(bfq(localObject2.toString()));
        break label1604;
        label2057:
        paramView = null;
        break;
        label2062:
        paramView = null;
        break label1477;
        label2067:
        paramView = null;
        continue;
        label2072:
        paramView = null;
      }
    }
    
    public final int getViewTypeCount()
    {
      return this.Kuw;
    }
    
    public final void gsm()
    {
      AppMethodBeat.i(231071);
      if (this.KuB != FileSelectorUI.g.KuO)
      {
        AppMethodBeat.o(231071);
        return;
      }
      if (this.KuA.gst() == null)
      {
        AppMethodBeat.o(231071);
        return;
      }
      FileSelectorUI.m localm = this.KuA;
      o localo = this.KuA.gst();
      if (localo == null) {
        p.hyc();
      }
      localm.ad(localo);
      FileSelectorUI.d(this.Kup).bqe();
      AppMethodBeat.o(231071);
    }
    
    public final o gsn()
    {
      AppMethodBeat.i(231072);
      if (!gso())
      {
        AppMethodBeat.o(231072);
        return null;
      }
      o localo = this.KuA.gst();
      AppMethodBeat.o(231072);
      return localo;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FileViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "fromTV", "Landroid/widget/TextView;", "getFromTV", "()Landroid/widget/TextView;", "setFromTV", "(Landroid/widget/TextView;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "lineV", "Landroid/view/View;", "getLineV", "()Landroid/view/View;", "setLineV", "(Landroid/view/View;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "getSizeTV", "setSizeTV", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"})
    final class a
    {
      TextView Bvi;
      FrameLayout KuC;
      CheckBox KuD;
      TextView KuE;
      View KuF;
      TextView jVO;
      ImageView nnL;
      TextView timeTV;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$FolderViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "iconIV", "Landroid/widget/ImageView;", "getIconIV", "()Landroid/widget/ImageView;", "setIconIV", "(Landroid/widget/ImageView;)V", "selectorCB", "Landroid/widget/CheckBox;", "getSelectorCB", "()Landroid/widget/CheckBox;", "setSelectorCB", "(Landroid/widget/CheckBox;)V", "selectorWrapper", "Landroid/widget/FrameLayout;", "getSelectorWrapper", "()Landroid/widget/FrameLayout;", "setSelectorWrapper", "(Landroid/widget/FrameLayout;)V", "sizeTV", "Landroid/widget/TextView;", "getSizeTV", "()Landroid/widget/TextView;", "setSizeTV", "(Landroid/widget/TextView;)V", "timeTV", "getTimeTV", "setTimeTV", "titleTV", "getTitleTV", "setTitleTV", "app_release"})
    final class b
    {
      TextView Bvi;
      FrameLayout KuC;
      CheckBox KuD;
      TextView jVO;
      ImageView nnL;
      TextView timeTV;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter$TimeViewHolder;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "titleTV", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "setTitleTV", "(Landroid/widget/TextView;)V", "app_release"})
    final class c
    {
      TextView jVO;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileType;", "", "(Ljava/lang/String;I)V", "TYPE_INVALID", "TYPE_TIME", "TYPE_FILE", "TYPE_FOLDER", "app_release"})
  public static enum f
  {
    static
    {
      AppMethodBeat.i(231095);
      f localf1 = new f("TYPE_INVALID", 0);
      KuH = localf1;
      f localf2 = new f("TYPE_TIME", 1);
      KuI = localf2;
      f localf3 = new f("TYPE_FILE", 2);
      KuJ = localf3;
      f localf4 = new f("TYPE_FOLDER", 3);
      KuK = localf4;
      KuL = new f[] { localf1, localf2, localf3, localf4 };
      AppMethodBeat.o(231095);
    }
    
    private f() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FromType;", "", "(Ljava/lang/String;I)V", "FROM_CHATTING", "FROM_FAV", "FROM_SDCARD", "app_release"})
  public static enum g
  {
    static
    {
      AppMethodBeat.i(231098);
      g localg1 = new g("FROM_CHATTING", 0);
      KuM = localg1;
      g localg2 = new g("FROM_FAV", 1);
      KuN = localg2;
      g localg3 = new g("FROM_SDCARD", 2);
      KuO = localg3;
      KuP = new g[] { localg1, localg2, localg3 };
      AppMethodBeat.o(231098);
    }
    
    private g() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFolderItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$ListFileItem;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;)V", "isFile", "", "()Z", "setFile", "(Z)V", "subFilesCnt", "", "getSubFilesCnt", "()I", "setSubFilesCnt", "(I)V", "app_release"})
  public final class j
    extends FileSelectorUI.i
  {
    int KuW;
    boolean KuX;
    
    public j()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileDataSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "adapter", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$FileSelectorAdapter;)V", "curFile", "Lcom/tencent/mm/vfs/VFSFile;", "filterDir", "", "rootPath", "subFiles", "", "[Lcom/tencent/mm/vfs/VFSFile;", "createTargetList", "", "deduplicateFolders", "files", "([Lcom/tencent/mm/vfs/VFSFile;)[Lcom/tencent/mm/vfs/VFSFile;", "getParent", "initASync", "loadMoreAsync", "setPath", "setRoot", "root", "sort", "([Lcom/tencent/mm/vfs/VFSFile;)V", "FileSort", "app_release"})
  public final class m
    extends FileSelectorUI.d
  {
    private o KtW;
    private o[] KtX;
    private o Kva;
    boolean Kvb;
    
    public m()
    {
      super(localObject);
      AppMethodBeat.i(231118);
      this.KtX = new o[0];
      AppMethodBeat.o(231118);
    }
    
    private final void a(o[] paramArrayOfo)
    {
      AppMethodBeat.i(231116);
      if (paramArrayOfo != null) {
        if (paramArrayOfo.length != 0) {
          break label26;
        }
      }
      label26:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(231116);
        return;
      }
      Object localObject2 = (List)new ArrayList();
      Object localObject1 = (List)new ArrayList();
      int j = paramArrayOfo.length;
      i = 0;
      if (i < j)
      {
        Object localObject3 = paramArrayOfo[i];
        a locala = new a();
        locala.file = ((o)localObject3);
        if (localObject3 == null) {
          p.hyc();
        }
        locala.time = ((o)localObject3).lastModified();
        if (((o)localObject3).isDirectory())
        {
          localObject3 = com.tencent.mm.platformtools.f.Sh(((o)localObject3).getName());
          p.g(localObject3, "CnToSpell.getFullSpell(file.name)");
          if (localObject3 == null)
          {
            paramArrayOfo = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(231116);
            throw paramArrayOfo;
          }
          localObject3 = ((String)localObject3).toUpperCase();
          p.g(localObject3, "(this as java.lang.String).toUpperCase()");
          locala.Kvc = ((String)localObject3);
          ((List)localObject2).add(locala);
        }
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject1).add(locala);
        }
      }
      j.a((List)localObject2, (Comparator)d.Kvf);
      Collections.sort((List)localObject1, (Comparator)e.Kvg);
      localObject2 = ((List)localObject2).iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        paramArrayOfo[i] = ((a)((Iterator)localObject2).next()).file;
        i += 1;
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramArrayOfo[i] = ((a)((Iterator)localObject1).next()).file;
        i += 1;
      }
      AppMethodBeat.o(231116);
    }
    
    private final void ac(o paramo)
    {
      this.Kva = paramo;
      this.Kvb = false;
    }
    
    private final void gss()
    {
      AppMethodBeat.i(231114);
      o[] arrayOfo = this.KtX;
      if (arrayOfo != null)
      {
        if (arrayOfo.length != 0) {
          break label40;
        }
        i = 1;
        if (i == 0) {
          break label45;
        }
      }
      label40:
      label45:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label50;
        }
        AppMethodBeat.o(231114);
        return;
        i = 0;
        break;
      }
      label50:
      arrayOfo = this.KtX;
      if (arrayOfo == null) {
        p.hyc();
      }
      int k = arrayOfo.length;
      i = 0;
      if (i < k)
      {
        Object localObject = arrayOfo[i];
        FileSelectorUI.j localj;
        boolean bool;
        label126:
        int j;
        if (localObject != null)
        {
          localj = new FileSelectorUI.j(FileSelectorUI.this);
          localj.a(FileSelectorUI.f.KuK);
          localj.d(FileSelectorUI.g.KuO);
          if (((o)localObject).isDirectory()) {
            break label220;
          }
          bool = true;
          localj.KuX = bool;
          String str = ((o)localObject).getName();
          p.g(str, "vFile.name");
          localj.am((CharSequence)str);
          localj.filePath = ((o)localObject).getAbsolutePath();
          if (!((o)localObject).isDirectory()) {
            break label233;
          }
          localObject = ((o)localObject).a((w)FileSelectorUI.m.b.Kve);
          if (localObject != null) {
            break label226;
          }
          j = 0;
          label195:
          localj.KuW = j;
        }
        for (;;)
        {
          this.Kuu.add(localj);
          i += 1;
          break;
          label220:
          bool = false;
          break label126;
          label226:
          j = localObject.length;
          break label195;
          label233:
          if (((o)localObject).isFile())
          {
            localj.zGp = ((int)((o)localObject).length());
            localj.createTime = ((o)localObject).lastModified();
          }
        }
      }
      AppMethodBeat.o(231114);
    }
    
    public final void ad(o paramo)
    {
      AppMethodBeat.i(231113);
      p.h(paramo, "curFile");
      this.KtW = paramo;
      paramo = this.KtW;
      if (paramo == null) {
        p.btv("curFile");
      }
      int i;
      if (paramo != null)
      {
        paramo = this.KtW;
        if (paramo == null) {
          p.btv("curFile");
        }
        if (paramo == null) {
          p.hyc();
        }
        if (paramo.canRead())
        {
          paramo = this.KtW;
          if (paramo == null) {
            p.btv("curFile");
          }
          if (paramo == null) {
            p.hyc();
          }
          if (paramo.isDirectory())
          {
            paramo = this.KtW;
            if (paramo == null) {
              p.btv("curFile");
            }
            if (paramo == null) {
              p.hyc();
            }
            this.KtX = paramo.a((com.tencent.mm.vfs.q)new c(this));
            if (this.KtX == null) {
              this.KtX = new o[0];
            }
            paramo = this.KtX;
            if (paramo == null) {
              p.hyc();
            }
            if (paramo.length != 0) {
              break label240;
            }
            i = 1;
            if (i != 0) {
              break label245;
            }
            i = 1;
            label176:
            if (i != 0)
            {
              paramo = this.KtX;
              if (paramo == null) {
                p.hyc();
              }
              if (paramo != null)
              {
                if (paramo.length != 0) {
                  break label250;
                }
                i = 1;
                label203:
                if (i == 0) {
                  break label255;
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        this.KtX = paramo;
        a(this.KtX);
        this.Kuu.clear();
        gss();
        AppMethodBeat.o(231113);
        return;
        label240:
        i = 0;
        break;
        label245:
        i = 0;
        break label176;
        label250:
        i = 0;
        break label203;
        label255:
        Set localSet = (Set)new HashSet();
        List localList = (List)new ArrayList();
        int j = paramo.length;
        i = 0;
        if (i < j)
        {
          Object localObject = paramo[i];
          if (localObject == null) {
            p.hyc();
          }
          if (!localObject.isDirectory()) {
            localList.add(localObject);
          }
          for (;;)
          {
            i += 1;
            break;
            String str = localObject.getAbsolutePath();
            p.g(str, "file.absolutePath");
            if (!localSet.contains(str))
            {
              str = localObject.getAbsolutePath();
              p.g(str, "file.absolutePath");
              localSet.add(str);
              localList.add(localObject);
            }
          }
        }
        paramo = ((Collection)localList).toArray(new o[0]);
        if (paramo == null)
        {
          paramo = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(231113);
          throw paramo;
        }
        paramo = (o[])paramo;
      }
    }
    
    public final void gsl()
    {
      AppMethodBeat.i(231117);
      ac(new o(com.tencent.mm.loader.j.b.aKE()));
      ad(new o(com.tencent.mm.loader.j.b.aKE()));
      AppMethodBeat.o(231117);
    }
    
    public final o gst()
    {
      AppMethodBeat.i(231115);
      o localo = this.KtW;
      if (localo == null) {
        p.btv("curFile");
      }
      int i = localo.hashCode();
      localo = this.Kva;
      if (localo == null) {
        p.btv("rootPath");
      }
      if (i == localo.hashCode())
      {
        AppMethodBeat.o(231115);
        return null;
      }
      localo = this.KtW;
      if (localo == null) {
        p.btv("curFile");
      }
      if (localo == null) {
        p.hyc();
      }
      localo = localo.heq();
      AppMethodBeat.o(231115);
      return localo;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "", "(Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;)V", "file", "Lcom/tencent/mm/vfs/VFSFile;", "getFile", "()Lcom/tencent/mm/vfs/VFSFile;", "setFile", "(Lcom/tencent/mm/vfs/VFSFile;)V", "spell", "", "getSpell", "()Ljava/lang/String;", "setSpell", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "app_release"})
    final class a
    {
      String Kvc;
      o file;
      long time;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pathname", "Lcom/tencent/mm/vfs/VFSFile;", "accept"})
    static final class c
      implements com.tencent.mm.vfs.q
    {
      c(FileSelectorUI.m paramm) {}
      
      public final boolean accept(o paramo)
      {
        AppMethodBeat.i(231109);
        p.h(paramo, "pathname");
        if (paramo.isHidden())
        {
          AppMethodBeat.o(231109);
          return false;
        }
        String str = paramo.getName();
        p.g(str, "pathname.name");
        if (!FileSelectorUI.e.bfr(str))
        {
          str = paramo.getName();
          p.g(str, "pathname.name");
          if (!FileSelectorUI.e.by(str)) {}
        }
        else
        {
          AppMethodBeat.o(231109);
          return false;
        }
        if ((!this.Kvd.Kvb) || (!paramo.isDirectory()))
        {
          AppMethodBeat.o(231109);
          return true;
        }
        AppMethodBeat.o(231109);
        return false;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "f1", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "kotlin.jvm.PlatformType", "f2", "compare"})
    static final class d<T>
      implements Comparator<FileSelectorUI.m.a>
    {
      public static final d Kvf;
      
      static
      {
        AppMethodBeat.i(231111);
        Kvf = new d();
        AppMethodBeat.o(231111);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "f1", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource$FileSort;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$SdcardFileSource;", "Lcom/tencent/mm/pluginsdk/ui/tools/FileSelectorUI;", "kotlin.jvm.PlatformType", "f2", "compare"})
    static final class e<T>
      implements Comparator<FileSelectorUI.m.a>
    {
      public static final e Kvg;
      
      static
      {
        AppMethodBeat.i(231112);
        Kvg = new e();
        AppMethodBeat.o(231112);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$exitMultiTalkListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ExitMultiTalkRoomEvent;", "callback", "", "event", "app_release"})
  public static final class n
    extends IListener<fn>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class o
    implements MenuItem.OnMenuItemClickListener
  {
    o(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(231122);
      Log.i("MicroMsg.FileSelectorUI", "backBtn");
      paramMenuItem = FileSelectorUI.q(this.Kup);
      if (paramMenuItem != null) {
        paramMenuItem.removeAllViews();
      }
      paramMenuItem = FileSelectorUI.r(this.Kup);
      if (paramMenuItem == null)
      {
        paramMenuItem = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(231122);
        throw paramMenuItem;
      }
      ((ViewGroup)paramMenuItem).removeView((View)FileSelectorUI.q(this.Kup));
      this.Kup.setBackBtn((MenuItem.OnMenuItemClickListener)new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(231121);
          Log.i("MicroMsg.FileSelectorUI", "backBtn");
          FileSelectorUI.g(this.Kvh.Kup);
          AppMethodBeat.o(231121);
          return false;
        }
      }, 2131689510);
      paramMenuItem = FileSelectorUI.k(this.Kup);
      if (paramMenuItem != null) {
        paramMenuItem.setVisibility(0);
      }
      FileSelectorUI.s(this.Kup);
      FileSelectorUI.t(this.Kup);
      this.Kup.setRequestedOrientation(1);
      this.Kup.addSearchMenu(true, (com.tencent.mm.ui.tools.s)FileSelectorUI.f(this.Kup));
      FileSelectorUI.v(this.Kup);
      paramMenuItem = com.tencent.mm.plugin.multitalk.d.f.zZd;
      com.tencent.mm.plugin.multitalk.d.f.eql();
      AppMethodBeat.o(231122);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class p
    implements MenuItem.OnMenuItemClickListener
  {
    p(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(231123);
      Log.i("MicroMsg.FileSelectorUI", "backBtn");
      FileSelectorUI.g(this.Kup);
      AppMethodBeat.o(231123);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class q
    implements MenuItem.OnMenuItemClickListener
  {
    q(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(231124);
      FileSelectorUI.h(this.Kup);
      AppMethodBeat.o(231124);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$3", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$IOnListItemSelected;", "selected", "", "item", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$DropdownListItem;", "app_release"})
  public static final class r
    implements DropdownListView.d
  {
    public final void a(DropdownListView.c paramc)
    {
      AppMethodBeat.i(231125);
      FileSelectorUI.a(this.Kup, paramc);
      if ((paramc == null) || (p.j(Util.nullAs(FileSelectorUI.j(this.Kup), ""), paramc.name))) {
        Log.w("MicroMsg.FileSelectorUI", "want to reset item, item is " + paramc + " or no need load data when same load");
      }
      for (;;)
      {
        if (FileSelectorUI.i(this.Kup) != null)
        {
          paramc = this.Kup;
          DropdownListView.c localc = FileSelectorUI.i(this.Kup);
          if (localc == null) {
            p.hyc();
          }
          FileSelectorUI.b(paramc, localc);
        }
        FileSelectorUI.k(this.Kup).dSg();
        AppMethodBeat.o(231125);
        return;
        switch (paramc.type)
        {
        default: 
          break;
        case 1: 
          paramc = FileSelectorUI.d(this.Kup);
          if (paramc == null) {
            p.hyc();
          }
          paramc.a(FileSelectorUI.g.KuM);
          break;
        case 2: 
          paramc = FileSelectorUI.d(this.Kup);
          if (paramc == null) {
            p.hyc();
          }
          paramc.a(FileSelectorUI.g.KuN);
          break;
        case 3: 
          paramc = FileSelectorUI.d(this.Kup);
          if (paramc == null) {
            p.hyc();
          }
          paramc.a(FileSelectorUI.g.KuO);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$4", "Lcom/tencent/mm/pluginsdk/ui/tools/DropdownListView$OnItemStateChanged;", "onItemStateChanged", "", "expanded", "", "app_release"})
  public static final class s
    implements DropdownListView.e
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class t
    implements View.OnTouchListener
  {
    t(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(231126);
      this.Kup.hideVKB();
      AppMethodBeat.o(231126);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$6", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "app_release"})
  public static final class u
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(231128);
      p.h(paramAbsListView, "view");
      AppMethodBeat.o(231128);
    }
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(231127);
      p.h(paramAbsListView, "view");
      if (FileSelectorUI.l(this.Kup))
      {
        Log.i("MicroMsg.FileSelectorUI", "search mode, not load data");
        AppMethodBeat.o(231127);
        return;
      }
      if ((paramInt == 0) && (FileSelectorUI.m(this.Kup)))
      {
        Log.i("MicroMsg.FileSelectorUI", "will load data when it at bottom");
        paramAbsListView = FileSelectorUI.d(this.Kup);
        FileSelectorUI.g localg = paramAbsListView.KuB;
        switch (f.vkf[localg.ordinal()])
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(231127);
        return;
        paramAbsListView.Kuy.gsk();
        AppMethodBeat.o(231127);
        return;
        paramAbsListView.Kuz.gsk();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onCreate$8", "Lcom/tencent/mm/ui/tools/SearchViewHelper$ISearchListener;", "onClickClearText", "", "onEnterSearch", "onQuitSearch", "onSearchChange", "searchText", "", "onSearchEditTextReady", "onSearchKeyDown", "", "app_release"})
  public static final class w
    implements s.b
  {
    public final boolean SN(String paramString)
    {
      AppMethodBeat.i(231133);
      p.h(paramString, "searchText");
      AppMethodBeat.o(231133);
      return false;
    }
    
    public final void SO(String paramString)
    {
      AppMethodBeat.i(231132);
      p.h(paramString, "searchText");
      if (!FileSelectorUI.n(this.Kup))
      {
        View localView = FileSelectorUI.p(this.Kup);
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      FileSelectorUI.d(this.Kup).DO(paramString);
      FileSelectorUI.o(this.Kup);
      AppMethodBeat.o(231132);
    }
    
    public final void bnA() {}
    
    public final void bnB() {}
    
    public final void bny()
    {
      AppMethodBeat.i(231134);
      FileSelectorUI.a(this.Kup, false);
      Log.d("MicroMsg.FileSelectorUI", "onQuitSearch()");
      MMHandlerThread.postToMainThread((Runnable)new a(this));
      this.Kup.getController().supportInvalidateOptionsMenu();
      View localView = FileSelectorUI.p(this.Kup);
      if (localView != null)
      {
        localView.setVisibility(8);
        AppMethodBeat.o(231134);
        return;
      }
      AppMethodBeat.o(231134);
    }
    
    public final void bnz()
    {
      AppMethodBeat.i(231135);
      if (FileSelectorUI.k(this.Kup).qkb)
      {
        localObject = FileSelectorUI.k(this.Kup);
        if (localObject != null) {
          ((DropdownListView)localObject).dSg();
        }
      }
      FileSelectorUI.a(this.Kup, true);
      Object localObject = FileSelectorUI.p(this.Kup);
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = FileSelectorUI.f(this.Kup);
      if (localObject != null) {
        ((r)localObject).CJ(true);
      }
      Log.i("MicroMsg.FileSelectorUI", "enter search");
      AppMethodBeat.o(231135);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(FileSelectorUI.w paramw) {}
      
      public final void run()
      {
        AppMethodBeat.i(231131);
        if (FileSelectorUI.d(this.Kvj.Kup) != null) {
          FileSelectorUI.d(this.Kvj.Kup).DO("");
        }
        AppMethodBeat.o(231131);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"})
  static final class x
    implements AdapterView.OnItemClickListener
  {
    x(FileSelectorUI paramFileSelectorUI) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(231136);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAdapterView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramLong);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramAdapterView = FileSelectorUI.d(this.Kup);
      if (paramAdapterView == null) {
        p.hyc();
      }
      paramAdapterView = paramAdapterView.aiR(paramInt);
      if (FileSelectorUI.u(this.Kup))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(231136);
        return;
      }
      paramView = paramAdapterView.KuY;
      switch (g.$EnumSwitchMapping$0[paramView.ordinal()])
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(231136);
        return;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(231136);
        return;
        if (paramAdapterView == null) {
          try
          {
            paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFolderItem");
            AppMethodBeat.o(231136);
            throw paramAdapterView;
          }
          catch (Exception paramAdapterView)
          {
            Log.e("MicroMsg.FileSelectorUI", "error:" + paramAdapterView.getMessage());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(231136);
            return;
          }
        }
        paramView = (FileSelectorUI.j)paramAdapterView;
        if (paramView.KuX)
        {
          FileSelectorUI.a(this.Kup, paramView.filePath, paramView.gsq().toString());
        }
        else
        {
          if (Util.isNullOrNil(paramView.filePath))
          {
            Log.e("MicroMsg.FileSelectorUI", "can not open sub path because current path not exist");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(231136);
            return;
          }
          paramAdapterView = FileSelectorUI.d(this.Kup);
          paramView = paramView.filePath;
          if (paramView == null) {
            p.hyc();
          }
          p.h(paramView, "path");
          if (paramAdapterView.KuB == FileSelectorUI.g.KuO)
          {
            paramAdapterView.KuA.ad(new o(paramView));
            FileSelectorUI.d(paramAdapterView.Kup).bqe();
          }
          FileSelectorUI.d(this.Kup).notifyDataSetChanged();
          continue;
          if (paramAdapterView == null)
          {
            paramAdapterView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI.ListFileItem");
            AppMethodBeat.o(231136);
            throw paramAdapterView;
          }
          paramView = ((FileSelectorUI.i)paramAdapterView).filePath;
          paramInt = n.g(((FileSelectorUI.i)paramAdapterView).gsq(), ".") + 1;
          if (paramInt >= ((FileSelectorUI.i)paramAdapterView).gsq().length())
          {
            Log.i("MicroMsg.FileSelectorUI", "open file error : file path error");
            u.cH((Context)this.Kup, this.Kup.getResources().getString(2131765013));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(231136);
            return;
          }
          localObject = ((FileSelectorUI.i)paramAdapterView).gsq();
          localObject = ((CharSequence)localObject).subSequence(paramInt, ((CharSequence)localObject).length()).toString();
          if ((3 == FileSelectorUI.b(this.Kup)) && (!((FileSelectorUI.i)paramAdapterView).KuV) && (FileSelectorUI.g.KuM == FileSelectorUI.d(this.Kup).KuB))
          {
            if ((n.I((String)localObject, "ppt", true)) || (n.I((String)localObject, "pdf", true)) || (n.I((String)localObject, "doc", true)) || (n.I((String)localObject, "docx", true)) || (n.I((String)localObject, "pptx", true))) {
              FileSelectorUI.a(this.Kup, ((FileSelectorUI.i)paramAdapterView).msgId);
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(231136);
              return;
              u.cH((Context)this.Kup, this.Kup.getResources().getString(2131765013));
            }
          }
          if ((FileSelectorUI.g.KuN == FileSelectorUI.d(this.Kup).KuB) && (!com.tencent.mm.vfs.s.YS(((FileSelectorUI.i)paramAdapterView).filePath)))
          {
            paramAdapterView = (FileSelectorUI.k)paramAdapterView;
            FileSelectorUI.a(this.Kup, ((FileSelectorUI.h)paramAdapterView).localId, ((FileSelectorUI.h)paramAdapterView).gsp());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/tools/FileSelectorUI$onItemClickListener$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(231136);
            return;
          }
          FileSelectorUI.a(this.Kup, paramView, ((FileSelectorUI.i)paramAdapterView).gsq().toString());
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class y
    implements MenuItem.OnMenuItemClickListener
  {
    y(FileSelectorUI paramFileSelectorUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(231137);
      Log.i("MicroMsg.FileSelectorUI", "onKeyDown, go back");
      FileSelectorUI.g(this.Kup);
      AppMethodBeat.o(231137);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onAlbumChooserViewClick"})
  static final class z
    implements AlbumChooserView.a
  {
    z(FileSelectorUI paramFileSelectorUI) {}
    
    public final void dSb()
    {
      AppMethodBeat.i(231138);
      Log.i("MicroMsg.FileSelectorUI", "onAlbumChooserViewClick.");
      FileSelectorUI.a(this.Kup, null);
      this.Kup.playActionBarOperationAreaAnim();
      DropdownListView localDropdownListView = FileSelectorUI.k(this.Kup);
      if (localDropdownListView == null) {
        p.hyc();
      }
      localDropdownListView.dSg();
      AppMethodBeat.o(231138);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.FileSelectorUI
 * JD-Core Version:    0.7.0.1
 */