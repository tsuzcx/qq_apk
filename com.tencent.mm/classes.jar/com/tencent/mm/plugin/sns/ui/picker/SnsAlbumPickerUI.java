package com.tencent.mm.plugin.sns.ui.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.b;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ar.a;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "downLoadCallback", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;", "getDownLoadCallback", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;", "mAlbumRv", "Landroidx/recyclerview/widget/RecyclerView;", "getMAlbumRv", "()Landroidx/recyclerview/widget/RecyclerView;", "mAlbumRv$delegate", "Lkotlin/Lazy;", "mFinderContextId", "", "mHasMore", "", "mIsCancelCurDownload", "mIsDataFetching", "mIsFinishing", "mIsFromFinderAddMedia", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mLoadingLoop", "", "mNextBtn", "Landroid/widget/Button;", "getMNextBtn", "()Landroid/widget/Button;", "mNextBtn$delegate", "mPageInTimeStamp", "", "mPostId", "mSelfName", "getMSelfName", "()Ljava/lang/String;", "mSelfName$delegate", "mSnsAlbumPickerAdapter", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;", "getMSnsAlbumPickerAdapter", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;", "mSnsAlbumPickerAdapter$delegate", "mSnsServer", "Lcom/tencent/mm/plugin/sns/model/SnsLogic$SnsServer;", "mSnsSource", "mStateDataTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getMStateDataTv", "()Landroid/widget/TextView;", "mStateDataTv$delegate", "mUserName", "snsEventCallback", "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$snsEventCallback$1", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$snsEventCallback$1;", "snsFileSaveHelper", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper;", "getSnsFileSaveHelper", "()Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper;", "snsFileSaveHelper$delegate", "updateAdapterRunnable", "Ljava/lang/Runnable;", "checkNetworkState", "", "enterMMRecordVLogUI", "filePathList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isAllPhoto", "enterPreviewSnsAlbumItem", "localId", "mediaId", "fetchFirstPageRemoteSnsAlbumData", "fetchNextPageRemoteSnsAlbumData", "getCustomBounceId", "getLayoutId", "getNextButtonText", "selectedCount", "getSnsServerType", "handleIntent", "hideMaterialLoadingDialog", "initActionBar", "initPickerAdapter", "initSnsAlbumNavigationBar", "initSnsAlbumNextButton", "initSnsAlbumRecyclerView", "initViews", "isNeedAutoLoopDataFetch", "isNextButtonEnable", "count", "makeInstanceSnsListPickerAdapter", "onActivityResult", "requestCode", "resultCode", "intent", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onMediaGeneratedEnterFinderPostUI", "context", "Landroid/content/Context;", "model", "Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;", "extData", "onResume", "printlnIOnPullSnsInfo", "pullSns", "Lcom/tencent/mm/plugin/sns/api/IOnPullSns;", "sourceTag", "showLoadingMoreFooter", "showMaterialLoadingDialog", "text", "startDownloadMedia", "selectItemList", "", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsPickerMediaInfo;", "updateAdapterData", "updateNextButtonState", "updateRvState", "Companion", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SnsAlbumPickerUI
  extends MMActivity
{
  public static final SnsAlbumPickerUI.a RSp;
  private boolean KzR;
  private ar.a REp;
  private int RHW;
  private w RSB;
  private final j RSC;
  private final j RSD;
  private final Runnable RSE;
  final a.b RSF;
  private final p RSG;
  private boolean RSq;
  private final j RSr;
  private String RSs;
  private String RSt;
  private long RSu;
  private boolean RSv;
  private boolean RSw;
  private final j RSx;
  private final j RSy;
  private final j RSz;
  private boolean Rzf;
  private int Rzm;
  private String luk;
  
  static
  {
    AppMethodBeat.i(308945);
    RSp = new SnsAlbumPickerUI.a((byte)0);
    AppMethodBeat.o(308945);
  }
  
  public SnsAlbumPickerUI()
  {
    AppMethodBeat.i(308768);
    this.RSr = k.cm((kotlin.g.a.a)SnsAlbumPickerUI.l.RSI);
    this.luk = "";
    this.KzR = true;
    this.RSs = "";
    this.RSt = "";
    this.RSx = k.cm((kotlin.g.a.a)new j(this));
    this.RSy = k.cm((kotlin.g.a.a)new k(this));
    this.RSz = k.cm((kotlin.g.a.a)new n(this));
    this.RSC = k.cm((kotlin.g.a.a)new m(this));
    this.RSD = k.cm((kotlin.g.a.a)new q(this));
    this.RSE = new SnsAlbumPickerUI..ExternalSyntheticLambda2(this);
    this.RSF = ((a.b)new b(this));
    this.RSG = new p(this);
    AppMethodBeat.o(308768);
  }
  
  private static final void a(SnsAlbumPickerUI paramSnsAlbumPickerUI)
  {
    AppMethodBeat.i(308851);
    s.u(paramSnsAlbumPickerUI, "this$0");
    if (paramSnsAlbumPickerUI.Rzf)
    {
      Log.d("MicroMsg.SnsAlbumPickerUI", "firstPageLoadRunnable: too fast that it finish");
      AppMethodBeat.o(308851);
      return;
    }
    ar.a locala = paramSnsAlbumPickerUI.REp;
    if (locala != null) {
      locala.a(2, paramSnsAlbumPickerUI.luk, (k.a)paramSnsAlbumPickerUI.RSG);
    }
    locala = paramSnsAlbumPickerUI.REp;
    if (locala != null)
    {
      String str = paramSnsAlbumPickerUI.luk;
      s.p(paramSnsAlbumPickerUI.luk, paramSnsAlbumPickerUI.hrG());
      locala.a(2, str, s.p(paramSnsAlbumPickerUI.luk, paramSnsAlbumPickerUI.hrG()), paramSnsAlbumPickerUI.Rzm);
    }
    AppMethodBeat.o(308851);
  }
  
  private static final void a(SnsAlbumPickerUI paramSnsAlbumPickerUI, View paramView)
  {
    AppMethodBeat.i(308864);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramSnsAlbumPickerUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramSnsAlbumPickerUI, "this$0");
    paramSnsAlbumPickerUI.kW(paramSnsAlbumPickerUI.hrK().hrn());
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(308864);
  }
  
  private static final boolean a(SnsAlbumPickerUI paramSnsAlbumPickerUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(308847);
    s.u(paramSnsAlbumPickerUI, "this$0");
    paramSnsAlbumPickerUI.onBackPressed();
    AppMethodBeat.o(308847);
    return true;
  }
  
  private final void amA(int paramInt)
  {
    AppMethodBeat.i(308809);
    hrI().setEnabled(amB(paramInt));
    Button localButton = hrI();
    String str;
    if (paramInt > 0) {
      str = getContext().getResources().getString(b.j.app_nextstep) + '(' + paramInt + ')';
    }
    for (;;)
    {
      localButton.setText((CharSequence)str);
      AppMethodBeat.o(308809);
      return;
      str = getContext().getResources().getString(b.j.app_nextstep);
      s.s(str, "context.resources.getString(R.string.app_nextstep)");
    }
  }
  
  private static boolean amB(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt <= 9) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void b(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel, Bundle paramBundle)
  {
    AppMethodBeat.i(308842);
    Intent localIntent2 = getIntent();
    Intent localIntent1;
    Object localObject1;
    if (paramCaptureVideoNormalModel != null)
    {
      localIntent1 = new Intent();
      if (this.RSv) {
        localIntent1.putExtras(localIntent2);
      }
      com.tencent.mm.ae.d.a(localIntent1, paramBundle, "ORIGIN_MUSIC_PATH");
      com.tencent.mm.ae.d.a(localIntent1, paramBundle, "ORIGIN_BGM_URL");
      com.tencent.mm.ae.d.b(localIntent1, paramBundle, "MEDIA_IS_MUTE");
      com.tencent.mm.ae.d.b(localIntent1, paramBundle, "MUSIC_IS_MUTE");
      com.tencent.mm.ae.d.c(localIntent1, paramBundle, "SOUND_TRACK_TYPE");
      com.tencent.mm.ae.d.a(localIntent1, paramBundle, "MUSIC_FEED_ID");
      if (paramBundle != null)
      {
        localObject1 = paramBundle.getByteArray("MEDIA_EXTRA_MUSIC");
        if (localObject1 != null) {
          localIntent1.putExtra("MEDIA_EXTRA_MUSIC", (byte[])localObject1);
        }
        localObject1 = paramBundle.getByteArray("ORIGIN_MUSIC_INFO");
        if (localObject1 != null) {
          localIntent1.putExtra("ORIGIN_MUSIC_INFO", (byte[])localObject1);
        }
        localObject1 = paramBundle.getParcelableArrayList("KEY_POST_HALF_RECT_LIST");
        if (localObject1 != null) {
          localIntent1.putExtra("KEY_POST_HALF_RECT_LIST", (Serializable)localObject1);
        }
      }
      localObject1 = (ArrayList)paramCaptureVideoNormalModel.gHE().J("KEY_IMAGE_QUALITY_INT_ARRAY", new ArrayList());
      Object localObject2 = paramCaptureVideoNormalModel.NHM;
      int i;
      if (localObject2 != null) {
        if (!((Collection)localObject2).isEmpty())
        {
          i = 1;
          if (1 != i) {
            break label323;
          }
          i = 1;
        }
      }
      label323:
      for (;;)
      {
        label231:
        if (i != 0)
        {
          localIntent1.putExtra("postType", 2);
          localObject2 = paramCaptureVideoNormalModel.NHM;
          s.s(localObject2, "model.multiImagePath");
          Object localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          for (;;)
          {
            if (((Iterator)localObject3).hasNext())
            {
              ((Collection)localObject2).add((String)((Iterator)localObject3).next());
              continue;
              i = 0;
              break;
              i = 0;
              break label231;
            }
          }
          localIntent1.putExtra("postMediaList", (Serializable)localObject2);
          localObject2 = paramCaptureVideoNormalModel.NHM;
          s.s(localObject2, "model.multiImagePath");
          localObject3 = (Iterable)localObject2;
          localObject2 = (Collection)new ArrayList();
          localObject3 = ((Iterable)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ((Iterator)localObject3).next();
            ((Collection)localObject2).add(Integer.valueOf(2));
          }
          localIntent1.putExtra("postTypeList", (Serializable)localObject2);
          localIntent1.putExtra("postThumbList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.thumbPath }));
          if ((localObject1 != null) && (((ArrayList)localObject1).size() == paramCaptureVideoNormalModel.NHM.size())) {
            localIntent1.putExtra("key_post_media_quality_list", (Serializable)localObject1);
          }
          com.tencent.mm.ae.d.d(localIntent1, paramBundle, "KEY_POST_HALF_IMAGE_LIST");
        }
      }
    }
    for (;;)
    {
      localIntent1.putExtra("post_id", this.RSs);
      localIntent1.putExtra("edit_id", (String)paramCaptureVideoNormalModel.gHE().J("KEY_MULTI_MEDIA_EDIT_ID_STRING", ""));
      localIntent1.putExtra("key_finder_post_from", localIntent2.getIntExtra("key_finder_post_from", -1));
      localIntent1.addFlags(67108864);
      localIntent1.setClassName((Context)this, "com.tencent.mm.plugin.finder.ui.FinderPostUI");
      paramCaptureVideoNormalModel = com.tencent.mm.plugin.sns.statistics.c.QDu;
      com.tencent.mm.plugin.sns.statistics.c.c(1, System.currentTimeMillis() - this.RSu, 1, this.RSt);
      paramCaptureVideoNormalModel = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent1);
      com.tencent.mm.hellhoundlib.a.a.b(this, paramCaptureVideoNormalModel.aYi(), "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI", "onMediaGeneratedEnterFinderPostUI", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)paramCaptureVideoNormalModel.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI", "onMediaGeneratedEnterFinderPostUI", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/jumper/CaptureDataManager$CaptureVideoNormalModel;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      finish();
      AppMethodBeat.o(308842);
      return;
      localIntent1.putExtra("postType", 4);
      localIntent1.putExtra("postMediaList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.videoPath }));
      localIntent1.putExtra("postTypeList", (Serializable)p.al(new Integer[] { Integer.valueOf(4) }));
      localIntent1.putExtra("postThumbList", (Serializable)p.al(new String[] { paramCaptureVideoNormalModel.thumbPath }));
      if ((localObject1 != null) && (((ArrayList)localObject1).size() == 1)) {
        localIntent1.putExtra("key_post_media_quality_list", (Serializable)localObject1);
      }
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getByteArray("video_composition");
        if (paramBundle != null) {
          localIntent1.putExtra("video_composition", paramBundle);
        }
      }
    }
  }
  
  private static final void b(SnsAlbumPickerUI paramSnsAlbumPickerUI)
  {
    AppMethodBeat.i(308855);
    s.u(paramSnsAlbumPickerUI, "this$0");
    paramSnsAlbumPickerUI.hrK().hrq();
    AppMethodBeat.o(308855);
  }
  
  private static final void c(SnsAlbumPickerUI paramSnsAlbumPickerUI)
  {
    AppMethodBeat.i(308859);
    s.u(paramSnsAlbumPickerUI, "this$0");
    paramSnsAlbumPickerUI.RSq = true;
    ar.a locala = paramSnsAlbumPickerUI.REp;
    if (locala != null)
    {
      String str = paramSnsAlbumPickerUI.luk;
      s.p(paramSnsAlbumPickerUI.luk, paramSnsAlbumPickerUI.hrG());
      locala.b(2, str, s.p(paramSnsAlbumPickerUI.luk, paramSnsAlbumPickerUI.hrG()), paramSnsAlbumPickerUI.Rzm);
    }
    AppMethodBeat.o(308859);
  }
  
  private static final void d(SnsAlbumPickerUI paramSnsAlbumPickerUI)
  {
    AppMethodBeat.i(308869);
    s.u(paramSnsAlbumPickerUI, "this$0");
    if (paramSnsAlbumPickerUI.KzR)
    {
      paramSnsAlbumPickerUI = paramSnsAlbumPickerUI.hrK();
      if (!((Collection)paramSnsAlbumPickerUI.hro()).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramSnsAlbumPickerUI.hrm();
        if (!e.c((g)p.oM(paramSnsAlbumPickerUI.hro()))) {
          break;
        }
        paramSnsAlbumPickerUI = paramSnsAlbumPickerUI.RRz;
        if (paramSnsAlbumPickerUI != null) {
          paramSnsAlbumPickerUI.invoke();
        }
        AppMethodBeat.o(308869);
        return;
      }
      if ((paramSnsAlbumPickerUI.hro().isEmpty()) || (paramSnsAlbumPickerUI.hrz().RRR))
      {
        AppMethodBeat.o(308869);
        return;
      }
      List localList = paramSnsAlbumPickerUI.hro();
      paramSnsAlbumPickerUI.hrm();
      localList.add(e.hrA());
      paramSnsAlbumPickerUI.fW(paramSnsAlbumPickerUI.hro().size() - 1);
      paramSnsAlbumPickerUI = paramSnsAlbumPickerUI.RRz;
      if (paramSnsAlbumPickerUI != null) {
        paramSnsAlbumPickerUI.invoke();
      }
    }
    AppMethodBeat.o(308869);
  }
  
  private final String hrG()
  {
    AppMethodBeat.i(308774);
    Object localObject = this.RSr.getValue();
    s.s(localObject, "<get-mSelfName>(...)");
    localObject = (String)localObject;
    AppMethodBeat.o(308774);
    return localObject;
  }
  
  private final RecyclerView hrH()
  {
    AppMethodBeat.i(308781);
    Object localObject = this.RSx.getValue();
    s.s(localObject, "<get-mAlbumRv>(...)");
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(308781);
    return localObject;
  }
  
  private final Button hrI()
  {
    AppMethodBeat.i(308788);
    Object localObject = this.RSy.getValue();
    s.s(localObject, "<get-mNextBtn>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(308788);
    return localObject;
  }
  
  private final TextView hrJ()
  {
    AppMethodBeat.i(308791);
    TextView localTextView = (TextView)this.RSz.getValue();
    AppMethodBeat.o(308791);
    return localTextView;
  }
  
  private final c hrK()
  {
    AppMethodBeat.i(308796);
    c localc = (c)this.RSC.getValue();
    AppMethodBeat.o(308796);
    return localc;
  }
  
  private final a hrL()
  {
    AppMethodBeat.i(308803);
    a locala = (a)this.RSD.getValue();
    AppMethodBeat.o(308803);
    return locala;
  }
  
  private void kW(List<g> paramList)
  {
    AppMethodBeat.i(308828);
    s.u(paramList, "selectItemList");
    Object localObject1 = getContext().getResources().getString(b.j.sns_album_picker_material_in_preparation);
    this.RSB = w.a((Context)getContext(), (CharSequence)localObject1, true, 3, (DialogInterface.OnCancelListener)new o(this));
    localObject1 = hrL();
    s.u(paramList, "snsMediaInfoList");
    ((a)localObject1).hrj().clear();
    ((a)localObject1).hrj().addAll((Collection)paramList);
    ((a)localObject1).hrk().clear();
    ((a)localObject1).RRg = ((Map)new LinkedHashMap(((a)localObject1).hrj().size()));
    ((a)localObject1).RRd = true;
    Object localObject2 = al.hgw();
    ((com.tencent.mm.plugin.sns.model.c)localObject2).a(((a)localObject1).RRi);
    s.s(localObject2, "downLoadManger");
    ((a)localObject1).RRh = ((com.tencent.mm.plugin.sns.model.c)localObject2);
    localObject2 = paramList.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (g)((Iterator)localObject2).next();
      if (((g)localObject3).Qsr.vhJ == 6) {}
      for (paramList = ".mp4";; paramList = ".jpg")
      {
        paramList = as.mh(((g)localObject3).Qsr.Id, paramList);
        Map localMap = ((a)localObject1).RRg;
        if (localMap == null) {
          break;
        }
        localObject3 = ((g)localObject3).Qsr.Id;
        s.s(localObject3, "info.mediaObj.Id");
        s.s(paramList, "destFilePath");
        localMap.put(localObject3, paramList);
        break;
      }
    }
    a.a((a)localObject1);
    AppMethodBeat.o(308828);
  }
  
  public final int getCustomBounceId()
  {
    return b.f.media_in_sns_rv;
  }
  
  public final int getLayoutId()
  {
    return b.g.picker_sns_album_ui_layout;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(308993);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.d("MicroMsg.SnsAlbumPickerUI", "onActivityResult result=%s request=%s intent=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramIntent });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(308993);
      return;
    case 8: 
      if (paramIntent == null)
      {
        paramIntent = null;
        label89:
        localObject = paramIntent;
        if (paramIntent == null) {
          localObject = new ArrayList();
        }
        if (((Collection)localObject).isEmpty()) {
          break label175;
        }
      }
      label175:
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        paramIntent = hrK().bG((ArrayList)localObject);
        kW(paramIntent);
        hrK().kU(paramIntent);
        amA(paramIntent.size());
        AppMethodBeat.o(308993);
        return;
        paramIntent = paramIntent.getStringArrayListExtra("sns_album_select_mediaobj_id_list");
        break label89;
      }
    }
    com.tencent.mm.plugin.sns.statistics.c localc = com.tencent.mm.plugin.sns.statistics.c.QDu;
    com.tencent.mm.plugin.sns.statistics.c.aZj(this.RSt);
    if (paramIntent == null) {}
    for (paramIntent = (Intent)localObject;; paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO"))
    {
      b(paramIntent, CaptureDataManager.NHH.rnY);
      break;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(309000);
    com.tencent.mm.plugin.sns.statistics.c localc = com.tencent.mm.plugin.sns.statistics.c.QDu;
    com.tencent.mm.plugin.sns.statistics.c.c(1, System.currentTimeMillis() - this.RSu, 0, this.RSt);
    super.onBackPressed();
    AppMethodBeat.o(309000);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(308976);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("key_finder_post_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      paramBundle = new StringBuilder();
      h.baC();
      paramBundle = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
    }
    this.RSs = paramBundle;
    localObject = getIntent().getStringExtra("key_finder_context_id");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.RSt = paramBundle;
    this.RSv = getIntent().getBooleanExtra("album_from_finder_add_media", false);
    localObject = getIntent().getStringExtra("sns_userName");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = hrG();
    }
    this.luk = paramBundle;
    setMMTitle(getContext().getResources().getString(b.j.sns_album_title));
    setBackBtn(new SnsAlbumPickerUI..ExternalSyntheticLambda0(this), b.e.actionbar_dark_close_selector);
    setActionbarColor(getResources().getColor(b.c.gallery_dark_mode_color));
    showActionbarLine();
    setNavigationbarColor(getResources().getColor(b.c.gallery_dark_mode_color));
    localObject = this.REp;
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = al.hgr();
    }
    this.REp = paramBundle;
    paramBundle = hrH();
    localObject = new GridLayoutManager(4);
    ((GridLayoutManager)localObject).bWq = ((GridLayoutManager.b)new SnsAlbumPickerUI.h(this));
    ah localah = ah.aiuX;
    paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject);
    paramBundle = getContext();
    s.s(paramBundle, "context");
    paramBundle = new b.a((Context)paramBundle);
    int i = b.d.sns_album_picker_item_padding;
    paramBundle.HNT = paramBundle.mResources.getDimensionPixelSize(i);
    i = b.d.sns_album_picker_item_padding;
    paramBundle.HNU = paramBundle.mResources.getDimensionPixelSize(i);
    paramBundle.HNS = false;
    paramBundle = paramBundle.amw(2).amw(4);
    paramBundle = new b(paramBundle.HNT, paramBundle.HNU, paramBundle.mColor, paramBundle.HNS, paramBundle.RRo);
    hrH().a((RecyclerView.h)paramBundle);
    hrH().a((RecyclerView.l)new i(this));
    paramBundle = new SnsAlbumPickerUI..ExternalSyntheticLambda4(this);
    hrH().postDelayed(paramBundle, 0L);
    hrK().setUserName(this.luk);
    hrK().RRy = ((kotlin.g.a.a)new c(this));
    hrK().RRv = ((c.d)new SnsAlbumPickerUI.d(this));
    hrK().RRw = ((c.c)new SnsAlbumPickerUI.e(this));
    hrK().RRx = ((c.b)new SnsAlbumPickerUI.f(this));
    hrK().RRz = ((kotlin.g.a.a)new SnsAlbumPickerUI.g(this));
    hrH().setAdapter((RecyclerView.a)hrK());
    hrI().setEnabled(amB(hrK().hrn().size()));
    hrI().setOnClickListener(new SnsAlbumPickerUI..ExternalSyntheticLambda1(this));
    if (!NetStatusUtil.isConnected((Context)getContext())) {
      aa.makeText((Context)getContext(), b.j.net_warn_no_network, 0).show();
    }
    paramBundle = com.tencent.mm.plugin.sns.statistics.c.QDu;
    com.tencent.mm.plugin.sns.statistics.c.aZj(this.RSt);
    AppMethodBeat.o(308976);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(308986);
    super.onDestroy();
    this.Rzf = true;
    al.hgr().aYz(this.luk);
    al.fAG().removeCallbacks(this.RSE);
    if (h.baC().aZN())
    {
      ar.a locala = this.REp;
      if (locala != null) {
        locala.a((k.a)this.RSG, 2);
      }
    }
    hrL().hrl();
    AppMethodBeat.o(308986);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(308982);
    super.onResume();
    this.RSu = System.currentTimeMillis();
    AppMethodBeat.o(308982);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$downLoadCallback$1", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper$IOnSnsAlbumFileSaveCallback;", "onCompleted", "", "snsStoragePathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "isAllPhoto", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.b
  {
    b(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
    
    public final void l(ArrayList<String> paramArrayList, boolean paramBoolean)
    {
      AppMethodBeat.i(308728);
      s.u(paramArrayList, "snsStoragePathList");
      SnsAlbumPickerUI.n(this.RSH);
      if (!SnsAlbumPickerUI.o(this.RSH))
      {
        SnsAlbumPickerUI.a(this.RSH, paramArrayList, paramBoolean);
        if (paramArrayList.isEmpty()) {
          aa.makeText((Context)this.RSH.getContext(), b.j.sns_album_picker_material_failed_preparation, 0).show();
        }
        AppMethodBeat.o(308728);
        return;
      }
      SnsAlbumPickerUI localSnsAlbumPickerUI = this.RSH;
      if (!SnsAlbumPickerUI.o(this.RSH)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        SnsAlbumPickerUI.a(localSnsAlbumPickerUI, paramBoolean);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$initSnsAlbumRecyclerView$2", "Lcom/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener;", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends com.tencent.mm.plugin.sns.ui.album.d
  {
    i(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
    
    private static final void u(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      AppMethodBeat.i(308714);
      s.u(paramSnsAlbumPickerUI, "this$0");
      if (SnsAlbumPickerUI.h(paramSnsAlbumPickerUI) == null) {
        SnsAlbumPickerUI.a(paramSnsAlbumPickerUI, al.hgr());
      }
      if ((!SnsAlbumPickerUI.f(paramSnsAlbumPickerUI)) && (SnsAlbumPickerUI.e(paramSnsAlbumPickerUI))) {
        SnsAlbumPickerUI.i(paramSnsAlbumPickerUI);
      }
      AppMethodBeat.o(308714);
    }
    
    public final void onLoadMore()
    {
      AppMethodBeat.i(308742);
      SnsAlbumPickerUI.g(this.RSH).post(new SnsAlbumPickerUI.i..ExternalSyntheticLambda0(this.RSH));
      AppMethodBeat.o(308742);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(308732);
      s.u(paramRecyclerView, "recyclerView");
      SnsAlbumPickerUI localSnsAlbumPickerUI = this.RSH;
      if ((!SnsAlbumPickerUI.e(this.RSH)) || (!SnsAlbumPickerUI.f(this.RSH))) {}
      for (boolean bool = true;; bool = false)
      {
        localSnsAlbumPickerUI.setBounceEnabled(bool);
        paramRecyclerView = paramRecyclerView.getLayoutManager();
        if (paramRecyclerView != null) {
          break;
        }
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        AppMethodBeat.o(308732);
        throw paramRecyclerView;
      }
      paramRecyclerView = (GridLayoutManager)paramRecyclerView;
      if (paramRecyclerView.Jx() == paramRecyclerView.getItemCount() - 1) {
        onLoadMore();
      }
      AppMethodBeat.o(308732);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<RecyclerView>
  {
    j(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<Button>
  {
    k(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerListAdapter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements kotlin.g.a.a<c>
  {
    m(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements kotlin.g.a.a<TextView>
  {
    n(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$showMaterialLoadingDialog$1", "Landroid/content/DialogInterface$OnCancelListener;", "onCancel", "", "dialog", "Landroid/content/DialogInterface;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class o
    implements DialogInterface.OnCancelListener
  {
    o(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
    
    public final void onCancel(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(308686);
      SnsAlbumPickerUI.a(this.RSH, true);
      SnsAlbumPickerUI.l(this.RSH).hrl();
      AppMethodBeat.o(308686);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerUI$snsEventCallback$1", "Lcom/tencent/mm/plugin/sns/api/ISnsServer$ISnsEvent;", "onFpSetSize", "", "respMinSeq", "", "isOnRecentErr", "", "recentErrType", "", "pullSns", "Lcom/tencent/mm/plugin/sns/api/IOnPullSns;", "onNpAddSize", "onOtherAddSize", "respMaxSeq", "firstPage", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class p
    implements k.a
  {
    p(SnsAlbumPickerUI paramSnsAlbumPickerUI) {}
    
    private static final void a(SnsAlbumPickerUI paramSnsAlbumPickerUI, com.tencent.mm.plugin.sns.c.b paramb)
    {
      AppMethodBeat.i(308674);
      s.u(paramSnsAlbumPickerUI, "this$0");
      s.u(paramb, "$pullSns");
      SnsAlbumPickerUI.j(paramSnsAlbumPickerUI).Ev(paramb.hdV());
      AppMethodBeat.o(308674);
    }
    
    private static final void b(SnsAlbumPickerUI paramSnsAlbumPickerUI, com.tencent.mm.plugin.sns.c.b paramb)
    {
      AppMethodBeat.i(308679);
      s.u(paramSnsAlbumPickerUI, "this$0");
      s.u(paramb, "$pullSns");
      SnsAlbumPickerUI.j(paramSnsAlbumPickerUI).Ev(paramb.hdV());
      AppMethodBeat.o(308679);
    }
    
    public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, com.tencent.mm.plugin.sns.c.b paramb, boolean paramBoolean2)
    {
      AppMethodBeat.i(308718);
      Log.d("MicroMsg.SnsAlbumPickerUI", "onOtherAddSize: respMaxSeq = " + paramString1 + ",respMinSeq = " + paramString2 + ", isOnRecentErr = " + paramBoolean1 + " ,recentErrType = " + paramInt + " ,firstPage = " + paramBoolean2);
      al.fAG().removeCallbacks(SnsAlbumPickerUI.r(this.RSH));
      AppMethodBeat.o(308718);
    }
    
    public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
    {
      AppMethodBeat.i(308699);
      s.u(paramString, "respMinSeq");
      s.u(paramb, "pullSns");
      Object localObject = this.RSH;
      SnsAlbumPickerUI.b((SnsAlbumPickerUI)localObject, SnsAlbumPickerUI.p((SnsAlbumPickerUI)localObject) + 1);
      SnsAlbumPickerUI.j(this.RSH).baQ(paramString);
      localObject = SnsAlbumPickerUI.j(this.RSH).hrz().RHs;
      Log.i("MicroMsg.SnsAlbumPickerUI", "onFpSetSize , respMinSeq=" + paramString + " , currentLimitSeq=" + (String)localObject + " pullSns.isDownAll = " + paramb.hdV());
      c localc = SnsAlbumPickerUI.j(this.RSH);
      String str = paramb.heb();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localc.bbh((String)localObject);
      SnsAlbumPickerUI.j(this.RSH).bbi(paramString);
      SnsAlbumPickerUI.j(this.RSH).hrq();
      if ((paramBoolean) || (!Util.isNullOrNil(paramb.heb())))
      {
        SnsAlbumPickerUI.j(this.RSH).Ev(true);
        AppMethodBeat.o(308699);
        return;
      }
      if (paramb.hea() != 0L)
      {
        h.baE().ban().set(at.a.acPN, Long.valueOf(paramb.hea()));
        SnsAlbumPickerUI.j(this.RSH).vr(paramb.hea());
      }
      SnsAlbumPickerUI.g(this.RSH).postDelayed(new SnsAlbumPickerUI.p..ExternalSyntheticLambda0(this.RSH, paramb), 1000L);
      paramString = this.RSH;
      if (!paramb.hdV()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        SnsAlbumPickerUI.b(paramString, paramBoolean);
        if ((SnsAlbumPickerUI.e(this.RSH)) && (SnsAlbumPickerUI.q(this.RSH))) {
          SnsAlbumPickerUI.i(this.RSH);
        }
        AppMethodBeat.o(308699);
        return;
      }
    }
    
    public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
    {
      AppMethodBeat.i(308710);
      s.u(paramString, "respMinSeq");
      s.u(paramb, "pullSns");
      al.fAG().removeCallbacks(SnsAlbumPickerUI.r(this.RSH));
      SnsAlbumPickerUI.s(this.RSH);
      Object localObject1 = this.RSH;
      SnsAlbumPickerUI.b((SnsAlbumPickerUI)localObject1, SnsAlbumPickerUI.p((SnsAlbumPickerUI)localObject1) + 1);
      SnsAlbumPickerUI.j(this.RSH).baQ(paramString);
      c localc = SnsAlbumPickerUI.j(this.RSH);
      Object localObject2 = paramb.heb();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localc.bbh((String)localObject1);
      localObject1 = SnsAlbumPickerUI.j(this.RSH).hrz().RHs;
      Log.i("MicroMsg.SnsAlbumPickerUI", "onNpAddSize , respMinSeq=" + paramString + " , currentLimitSeq=" + (String)localObject1 + " , isDownAll=" + paramb.hdV());
      if (paramBoolean)
      {
        SnsAlbumPickerUI.j(this.RSH).Ev(true);
        AppMethodBeat.o(308710);
        return;
      }
      if (paramb.hea() != 0L)
      {
        h.baE().ban().set(at.a.acPN, Long.valueOf(paramb.hea()));
        SnsAlbumPickerUI.j(this.RSH).vr(paramb.hea());
      }
      SnsAlbumPickerUI.g(this.RSH).postDelayed(new SnsAlbumPickerUI.p..ExternalSyntheticLambda1(this.RSH, paramb), 1000L);
      localObject2 = this.RSH;
      if (!paramb.hdV()) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        SnsAlbumPickerUI.b((SnsAlbumPickerUI)localObject2, paramBoolean);
        if ((!SnsAlbumPickerUI.e(this.RSH)) || (s.p(paramString, localObject1))) {
          break;
        }
        SnsAlbumPickerUI.j(this.RSH).bbi(paramString);
        SnsAlbumPickerUI.j(this.RSH).hrq();
        if (!SnsAlbumPickerUI.q(this.RSH)) {
          break label377;
        }
        SnsAlbumPickerUI.i(this.RSH);
        AppMethodBeat.o(308710);
        return;
      }
      this.RSH.setBounceEnabled(true);
      SnsAlbumPickerUI.t(this.RSH);
      label377:
      AppMethodBeat.o(308710);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerDownloadHelper;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends u
    implements kotlin.g.a.a<a>
  {
    q(SnsAlbumPickerUI paramSnsAlbumPickerUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.SnsAlbumPickerUI
 * JD-Core Version:    0.7.0.1
 */