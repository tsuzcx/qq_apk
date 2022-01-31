package com.tencent.mm.plugin.story.ui.view.editor;

import a.f.a.b;
import a.f.a.m;
import a.f.b.j;
import a.f.b.k;
import a.l;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.t.a;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.story.c.a.a.a;
import com.tencent.mm.plugin.story.d.b.a;
import com.tencent.mm.plugin.story.d.b.b;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView.c;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo;
import com.tencent.mm.plugin.story.model.audio.AudioCacheInfo.a;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.plugin.story.ui.view.editor.item.g;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.protocal.protobuf.baz;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_CLICK_LIMIT_TIME", "", "DEFAULT_NOTIFY_MOMENT_DURATION", "TAG", "", "addAudioCheckView", "Landroid/widget/ImageView;", "addAudioView", "addEmojiView", "addLocation", "addLocationCheckView", "addTextView", "addTipGroup", "Landroid/view/View;", "addTipView", "Landroid/widget/TextView;", "audioPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView;", "blueCheckDrawable", "Landroid/graphics/drawable/Drawable;", "blueColor", "clickTime", "controlGroupPanel", "Landroid/view/ViewGroup;", "controlPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorControlPanel;", "emojiPanel", "Lcom/tencent/mm/media/editor/panel/EditorEmojiPanel;", "fakeVideoPlayView", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView;", "fakeVideoPlayViewCallback", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Callback;", "getFakeVideoPlayViewCallback", "()Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView$Callback;", "favoriteTip", "hasMixed", "", "inputPanel", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorInputView;", "isNotifyMoment", "isSetFavorite", "itemContainer", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/EditorItemContainer;", "menuDialog", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorMoreDialog;", "mixView", "moreBtn", "navigationBarHeight", "pendingTextItem", "Lcom/tencent/mm/plugin/story/ui/view/editor/item/TextItemView;", "poiService", "Lcom/tencent/mm/plugin/story/api/ICheckLifePoi;", "presenter", "Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;", "setPresenter", "(Lcom/tencent/mm/plugin/story/contract/EditorContract$IPresenter;)V", "reportArg", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$ReportInfo;", "showLocation", "snsTip", "storyImageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "storyLocation", "Lcom/tencent/mm/protocal/protobuf/StoryLocation;", "tipBgColor", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getTipDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setTipDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "tipFgColor", "tipText", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView$videoCallBack$1;", "videoLoopEndTime", "", "videoLoopStartTime", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "videoPreparedCallback", "Lkotlin/Function0;", "", "back", "checkFavorite", "checkLocation", "checkMoment", "destroy", "getItemContainer", "getLocation", "getLocationResult", "data", "Landroid/content/Intent;", "getMusicRequestId", "getVideoPlayView", "initAudioPanel", "initSafeArea", "initSmileyPanel", "isShow", "isShowAudioPanel", "isShowSmileyPanel", "isShowTextEditor", "onActivityResult", "requestCode", "resultCode", "onPause", "onResume", "reportDirectly", "location", "reset", "setFavStory", "setMusicPlayer", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "setNotifySns", "setVisibility", "visibility", "setup", "videoPath", "imageList", "startTime", "endTime", "isPhotoToVideo", "config", "Lcom/tencent/mm/plugin/story/config/EditorConfig;", "showAddTipWithConfig", "toggleAudioPanel", "show", "toggleSmileyPanel", "toggleTextEditor", "text", "textColor", "textBgColor", "mode", "updateTipLayout", "Companion", "ReportInfo", "plugin-story_release"})
public final class EditorView
  extends RelativeLayout
  implements b.b
{
  public static final EditorView.a sQh;
  public final String TAG;
  private boolean hOG;
  private long iHv;
  private a.f.a.a<y> lzk;
  private final VideoPlayerTextureView oKC;
  final com.tencent.mm.media.editor.b.a qbH;
  private final EditorInputView qbL;
  private g qbP;
  private final EditorAudioView qdz;
  private final ImageView rLZ;
  private boolean sAA;
  private final View sOZ;
  public b.a sPA;
  private final StoryFakeVideoPlayView sPB;
  private final ArrayList<String> sPC;
  private final View sPD;
  private final ImageView sPE;
  private final ImageView sPF;
  private final ImageView sPG;
  private final ImageView sPH;
  private final ViewGroup sPI;
  private final ImageView sPJ;
  public final ImageView sPK;
  private final EditorControlPanel sPL;
  public final EditorItemContainer sPM;
  private final ImageView sPN;
  private final ImageView sPO;
  private final TextView sPP;
  private double sPQ;
  private double sPR;
  public final chj sPS;
  private final int sPT;
  private final Drawable sPU;
  private final long sPV;
  private final long sPW;
  private boolean sPX;
  private boolean sPY;
  private int sPZ;
  private c sQa;
  private CharSequence sQb;
  private int sQc;
  private int sQd;
  private final StoryFakeVideoPlayView.a sQe;
  public EditorView.b sQf;
  private final EditorView.k sQg;
  private p tipDialog;
  
  static
  {
    AppMethodBeat.i(110612);
    sQh = new EditorView.a((byte)0);
    AppMethodBeat.o(110612);
  }
  
  public EditorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110611);
    AppMethodBeat.o(110611);
  }
  
  public EditorView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110610);
    this.TAG = "MicroMsg.EditorView";
    this.sPC = new ArrayList();
    this.sPS = new chj();
    this.hOG = true;
    this.sPV = 2000L;
    this.sPW = 3000L;
    this.sAA = true;
    this.sQc = -1;
    View.inflate(paramContext, 2130970948, (ViewGroup)this);
    this.sPT = getResources().getColor(2131689507);
    this.sPU = paramContext.getResources().getDrawable(2131231866);
    paramAttributeSet = findViewById(2131828396);
    j.p(paramAttributeSet, "findViewById(R.id.editor_video_play_view)");
    this.oKC = ((VideoPlayerTextureView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828397);
    j.p(paramAttributeSet, "findViewById(R.id.fake_video_textureview)");
    this.sPB = ((StoryFakeVideoPlayView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828398);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_control_panel)");
    this.sPL = ((EditorControlPanel)paramAttributeSet);
    paramAttributeSet = findViewById(2131828382);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_emoji)");
    this.sPE = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828383);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_text)");
    this.sPF = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828385);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_audio)");
    this.sPG = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828387);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_location)");
    this.sPH = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828386);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_audio_check)");
    this.sPJ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828388);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_location_check)");
    this.sPK = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828379);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_control_layout)");
    this.sPI = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = findViewById(2131828378);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_tip_view)");
    this.sPP = ((TextView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828377);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_add_tip_group)");
    this.sOZ = paramAttributeSet;
    paramAttributeSet = findViewById(2131828380);
    j.p(paramAttributeSet, "findViewById(R.id.editor_mix)");
    this.sPD = paramAttributeSet;
    paramAttributeSet = findViewById(2131823571);
    j.p(paramAttributeSet, "findViewById(R.id.editor_item_container)");
    this.sPM = ((EditorItemContainer)paramAttributeSet);
    paramAttributeSet = findViewById(2131823514);
    j.p(paramAttributeSet, "findViewById(R.id.change_text_root)");
    this.qbL = ((EditorInputView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828399);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_audio_panel)");
    this.qdz = ((EditorAudioView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828373);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_more)");
    this.rLZ = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828374);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_fav_tip)");
    this.sPN = ((ImageView)paramAttributeSet);
    paramAttributeSet = findViewById(2131828375);
    j.p(paramAttributeSet, "findViewById(R.id.story_editor_sns_tip)");
    this.sPO = ((ImageView)paramAttributeSet);
    cFN();
    this.sPN.setImageDrawable(aj.g(paramContext, 2131231475, -1));
    this.sPO.setImageDrawable(aj.g(paramContext, 2131231462, -1));
    this.rLZ.setImageDrawable(aj.g(paramContext, 2131231463, -1));
    label637:
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    if (!com.tencent.mm.plugin.story.c.a.a.srz.czD())
    {
      this.rLZ.setVisibility(8);
      paramAttributeSet = this.sPG;
      if (!((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srM) {
        break label1286;
      }
      paramInt = 0;
      paramAttributeSet.setVisibility(paramInt);
      this.sPE.setOnClickListener((View.OnClickListener)new EditorView.1(this));
      this.sPF.setOnClickListener((View.OnClickListener)new EditorView.8(this));
      this.sPG.setOnClickListener((View.OnClickListener)new EditorView.9(this));
      this.sPM.setItemChangeListener((m)new EditorView.10(this));
      this.sPM.setOnLocationClick((View.OnClickListener)new EditorView.11(this));
      this.sPM.setOnTextClick((View.OnClickListener)new EditorView.12(this));
      this.sPM.setOnTipClick((View.OnClickListener)new EditorView.13(this));
      this.sPH.setOnClickListener((View.OnClickListener)new EditorView.14(this));
      this.sPP.setOnClickListener((View.OnClickListener)new EditorView.15(this));
      this.sPD.setOnClickListener((View.OnClickListener)new EditorView.2(this));
      paramAttributeSet = (ImageView)findViewById(2131828372);
      paramAttributeSet.setOnClickListener((View.OnClickListener)new EditorView.3(this));
      this.rLZ.setOnClickListener((View.OnClickListener)new EditorView.4(this, paramContext));
      this.sPM.setDeleteStateListener((b)new EditorView.5(this));
      this.qbL.setOnVisibleChangeCallback((b)new EditorView.6(this));
      this.qbL.setCallback((EditorInputView.a)new EditorView.7(this));
      this.qbH = new com.tencent.mm.media.editor.b.a(paramContext, (ViewGroup)this);
      this.qbH.eTl = ((b)new g(this));
      this.qbH.a((t.a)new EditorView.h(this));
      this.qdz.setOnVisibleChangeCallback((b)new EditorView.e(this));
      this.qdz.setCallback((EditorAudioView.a)new f(this));
      this.sPE.setImageDrawable(aj.g(paramContext, 2131231476, -1));
      this.sPF.setImageDrawable(aj.g(paramContext, 2131231477, -1));
      this.sPG.setImageDrawable(aj.g(paramContext, 2131231464, -1));
      this.sPH.setImageDrawable(aj.g(paramContext, 2131231458, -1));
      paramAttributeSet.setImageDrawable(aj.g(paramContext, 2131231470, -1));
      this.sPK.setImageDrawable(this.sPU);
      this.sPJ.setImageDrawable(this.sPU);
      this.sPK.setVisibility(8);
      this.sPJ.setVisibility(8);
      this.sPZ = am.fx(paramContext);
      paramContext = am.hQ(getContext());
      paramInt = paramContext.y;
      int i = paramContext.x;
      f1 = paramInt / i;
      f2 = paramInt;
      paramContext = com.tencent.mm.plugin.story.h.a.sFV;
      f2 /= com.tencent.mm.plugin.story.h.a.cEs();
      f3 = (i - f2) / 2.0F;
      f4 = i;
      paramContext = com.tencent.mm.plugin.story.h.a.sFV;
      f4 *= com.tencent.mm.plugin.story.h.a.cEr();
      f5 = (paramInt - f4) / 2.0F;
      paramContext = com.tencent.mm.plugin.story.h.a.sFV;
      if (f1 > com.tencent.mm.plugin.story.h.a.cEr()) {
        break label1292;
      }
      this.qbL.bi(f3);
      this.sPM.ag(f2, f3);
    }
    for (;;)
    {
      this.sQe = ((StoryFakeVideoPlayView.a)new EditorView.c(this));
      this.sQg = new EditorView.k(this);
      AppMethodBeat.o(110610);
      return;
      this.rLZ.setVisibility(0);
      break;
      label1286:
      paramInt = 8;
      break label637;
      label1292:
      paramContext = com.tencent.mm.plugin.story.h.a.sFV;
      if (f1 >= com.tencent.mm.plugin.story.h.a.cEs())
      {
        this.sPM.ah(f4, f5);
      }
      else
      {
        this.qbL.bi(f3);
        this.sPM.ag(f2, f3);
        this.sPM.ah(f4, f5);
      }
    }
  }
  
  private final void cFN()
  {
    AppMethodBeat.i(151241);
    if (((a.a)com.tencent.mm.plugin.story.c.a.a.srz.Uw()).srF)
    {
      this.sOZ.setVisibility(0);
      AppMethodBeat.o(151241);
      return;
    }
    this.sOZ.setVisibility(8);
    AppMethodBeat.o(151241);
  }
  
  public final boolean Pk()
  {
    AppMethodBeat.i(110601);
    if (getVisibility() == 0)
    {
      AppMethodBeat.o(110601);
      return true;
    }
    AppMethodBeat.o(110601);
    return false;
  }
  
  public final void a(String paramString, ArrayList<String> paramArrayList, long paramLong1, long paramLong2, boolean paramBoolean, com.tencent.mm.plugin.story.c.a parama, a.f.a.a<y> parama1)
  {
    AppMethodBeat.i(151239);
    j.q(paramString, "videoPath");
    j.q(paramArrayList, "imageList");
    j.q(parama, "config");
    this.lzk = parama1;
    if (!bo.isNullOrNil(paramString))
    {
      this.oKC.setVideoCallback((e.a)this.sQg);
      this.oKC.setVideoPath(paramString);
      this.oKC.setAlpha(0.0F);
      this.oKC.setVisibility(0);
      this.sPB.setVisibility(8);
      this.sPB.setAlpha(0.0F);
      if (!paramBoolean) {
        break label236;
      }
      this.sPJ.setVisibility(0);
    }
    for (;;)
    {
      this.sPQ = (paramLong1 / 1000.0D);
      this.sPR = (paramLong2 / 1000.0D);
      this.sPC.clear();
      this.sPC.addAll((Collection)paramArrayList);
      this.qdz.a(paramString, paramArrayList, paramLong1, paramLong2, paramBoolean, parama);
      this.hOG = false;
      this.sPM.i((a.f.a.a)EditorView.j.sQn);
      this.sPM.cFR();
      AppMethodBeat.o(151239);
      return;
      this.sPB.setVisibility(0);
      this.oKC.setVisibility(8);
      this.sPB.setCallback(this.sQe);
      this.sPB.T(paramArrayList);
      break;
      label236:
      this.sPJ.setVisibility(8);
    }
  }
  
  public final void a(boolean paramBoolean, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(151240);
    if (paramBoolean)
    {
      this.qbL.mode = paramInt3;
      this.qbL.setShow(true);
      this.qbL.f(paramCharSequence, paramInt1, paramInt2);
      AppMethodBeat.o(151240);
      return;
    }
    this.qbL.setShow(false);
    AppMethodBeat.o(151240);
  }
  
  public final void cFL()
  {
    AppMethodBeat.i(110598);
    Intent localIntent = new Intent();
    if (this.sPM.cFS()) {
      localIntent.putExtra("get_poi_classify_id", this.sPS.xpN);
    }
    localIntent.putExtra("get_poi_from_scene", "story");
    localIntent.putExtra("get_city", this.sPS.gwR);
    localIntent.putExtra("poi_show_none", true);
    localIntent.putExtra("select_radio_icon_color", "#0E9CE6");
    d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 1003);
    AppMethodBeat.o(110598);
  }
  
  public final void cFM()
  {
    AppMethodBeat.i(151238);
    if (this.sPM.cFQ())
    {
      this.sPM.j(this.sQb, this.sQc, this.sQd);
      AppMethodBeat.o(151238);
      return;
    }
    int j = this.sPM.getLocationItemHeight();
    if (j == 0) {}
    Object localObject;
    for (int i = 0;; i = al.fromDPToPix(getContext(), 24))
    {
      localObject = this.sOZ.getLayoutParams();
      if (localObject != null) {
        break;
      }
      localObject = new a.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(151238);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = (i + al.fromDPToPix(getContext(), 44) + j);
    AppMethodBeat.o(151238);
  }
  
  public final boolean czN()
  {
    AppMethodBeat.i(110603);
    if (this.qbL.getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      EditorInputView.b localb = EditorInputView.sPo;
      a(false, null, 0, 0, EditorInputView.cFJ());
      AppMethodBeat.o(110603);
      return true;
    }
    if (this.qbH.Pk())
    {
      gT(false);
      AppMethodBeat.o(110603);
      return true;
    }
    if (this.qdz.Pk())
    {
      this.qdz.back();
      AppMethodBeat.o(110603);
      return true;
    }
    this.sPB.stop();
    AppMethodBeat.o(110603);
    return false;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(110607);
    this.oKC.stop();
    this.sPB.stop();
    this.qbH.eys.destroy();
    EditorAudioView localEditorAudioView = this.qdz;
    ab.i(localEditorAudioView.TAG, "destroy");
    localEditorAudioView.sOv = true;
    AppMethodBeat.o(110607);
  }
  
  public final void gT(boolean paramBoolean)
  {
    AppMethodBeat.i(110604);
    if (paramBoolean)
    {
      this.qbH.setShow(true);
      AppMethodBeat.o(110604);
      return;
    }
    this.qbH.setShow(false);
    AppMethodBeat.o(110604);
  }
  
  public final StoryFakeVideoPlayView.a getFakeVideoPlayViewCallback()
  {
    return this.sQe;
  }
  
  public final EditorItemContainer getItemContainer()
  {
    return this.sPM;
  }
  
  public final chj getLocation()
  {
    AppMethodBeat.i(110599);
    if (this.hOG)
    {
      localchj = this.sPS;
      AppMethodBeat.o(110599);
      return localchj;
    }
    chj localchj = new chj();
    AppMethodBeat.o(110599);
    return localchj;
  }
  
  public final long getMusicRequestId()
  {
    AppMethodBeat.i(110609);
    long l = this.qdz.getMusicRequestId();
    AppMethodBeat.o(110609);
    return l;
  }
  
  public final b.a getPresenter()
  {
    AppMethodBeat.i(110595);
    b.a locala = this.sPA;
    if (locala == null) {
      j.ays("presenter");
    }
    AppMethodBeat.o(110595);
    return locala;
  }
  
  public final p getTipDialog()
  {
    return this.tipDialog;
  }
  
  public final VideoPlayerTextureView getVideoPlayView()
  {
    return this.oKC;
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(151236);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.sPB;
    ab.i(StoryFakeVideoPlayView.TAG, "pause");
    localStoryFakeVideoPlayView.stt = StoryFakeVideoPlayView.c.stD;
    AppMethodBeat.o(151236);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(151237);
    if (this.sPC.size() > 0) {
      this.sPB.resume();
    }
    AppMethodBeat.o(151237);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(110606);
    this.sQb = null;
    this.sAA = true;
    this.sPX = false;
    this.sPM.reset();
    Object localObject = this.qdz;
    ((EditorAudioView)localObject).qaU = false;
    ((EditorAudioView)localObject).sOt = true;
    ((EditorAudioView)localObject).sOu = false;
    ((EditorAudioView)localObject).sOg.setImageDrawable(aj.g(((EditorAudioView)localObject).getContext(), 2131232141, -1));
    ((EditorAudioView)localObject).sOh.setImageDrawable(aj.g(((EditorAudioView)localObject).getContext(), 2131232141, -1));
    ((EditorAudioView)localObject).sOi.setImageDrawable(aj.g(((EditorAudioView)localObject).getContext(), 2131232142, -1));
    ((EditorAudioView)localObject).sOj.setVisibility(0);
    ((EditorAudioView)localObject).sOk.setVisibility(0);
    if (((EditorAudioView)localObject).srg) {
      ((EditorAudioView)localObject).sOl.setVisibility(0);
    }
    for (;;)
    {
      ((EditorAudioView)localObject).sOo.reset();
      this.sPC.clear();
      this.hOG = false;
      localObject = this.sPP;
      Context localContext = getContext();
      j.p(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131304138));
      cFN();
      localObject = this.sOZ.getLayoutParams();
      if (localObject != null) {
        break;
      }
      localObject = new a.v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(110606);
      throw ((Throwable)localObject);
      ((EditorAudioView)localObject).sOl.setVisibility(8);
    }
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = al.fromDPToPix(getContext(), 44);
    this.sPK.setVisibility(8);
    this.sPJ.setVisibility(8);
    this.sPO.setVisibility(8);
    this.sPN.setVisibility(8);
    this.sPM.i((a.f.a.a)EditorView.i.sQm);
    this.sPM.cFR();
    this.sPY = false;
    AppMethodBeat.o(110606);
  }
  
  public final void setMusicPlayer(com.google.android.exoplayer2.v paramv)
  {
    AppMethodBeat.i(110597);
    j.q(paramv, "player");
    this.qdz.setMusicPlayer(paramv);
    AppMethodBeat.o(110597);
  }
  
  public final void setPresenter(b.a parama)
  {
    AppMethodBeat.i(110596);
    j.q(parama, "<set-?>");
    this.sPA = parama;
    AppMethodBeat.o(110596);
  }
  
  public final void setTipDialog(p paramp)
  {
    this.tipDialog = paramp;
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(110608);
    super.setVisibility(paramInt);
    this.oKC.setVisibility(paramInt);
    this.sPB.setVisibility(paramInt);
    AppMethodBeat.o(110608);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/story/ui/view/editor/EditorView$initAudioPanel$2", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorAudioView$AudioCallback;", "cancel", "", "confirm", "onAudioSelected", "info", "Lcom/tencent/mm/plugin/story/model/audio/AudioCacheInfo;", "onLyricsSelected", "visible", "", "lyricsInfos", "", "Lcom/tencent/mm/protocal/protobuf/LyricsItemInfo;", "pauseAudio", "toggleOrigin", "remove", "plugin-story_release"})
  public static final class f
    implements EditorAudioView.a
  {
    public final void a(AudioCacheInfo paramAudioCacheInfo)
    {
      AppMethodBeat.i(110584);
      if (EditorView.d(this.sQi))
      {
        AppMethodBeat.o(110584);
        return;
      }
      int i;
      AudioCacheInfo.a locala;
      if (paramAudioCacheInfo != null)
      {
        i = paramAudioCacheInfo.type;
        locala = AudioCacheInfo.swC;
        if (i == AudioCacheInfo.cBt()) {}
      }
      else
      {
        if (paramAudioCacheInfo == null) {
          break label105;
        }
        i = paramAudioCacheInfo.type;
        locala = AudioCacheInfo.swC;
        if (i != AudioCacheInfo.cBv()) {
          break label105;
        }
      }
      this.sQi.getPresenter().c(paramAudioCacheInfo);
      EditorView.f(this.sQi).setVisibility(0);
      for (;;)
      {
        if (paramAudioCacheInfo == null) {
          EditorView.c(this.sQi).cFR();
        }
        AppMethodBeat.o(110584);
        return;
        label105:
        this.sQi.getPresenter().pauseAudio();
        EditorView.f(this.sQi).setVisibility(8);
      }
    }
    
    public final void b(boolean paramBoolean, List<? extends baz> paramList)
    {
      AppMethodBeat.i(151235);
      j.q(paramList, "lyricsInfos");
      if (paramBoolean)
      {
        if (EditorView.c(this.sQi).sQJ != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          EditorItemContainer localEditorItemContainer = EditorView.c(this.sQi);
          j.q(paramList, "lyricsItemInfos");
          if (localEditorItemContainer.sQJ != null)
          {
            localEditorItemContainer.cFR();
            localEditorItemContainer.dK(paramList);
          }
          AppMethodBeat.o(151235);
          return;
        }
        EditorView.c(this.sQi).dK(paramList);
        AppMethodBeat.o(151235);
        return;
      }
      EditorView.c(this.sQi).cFR();
      AppMethodBeat.o(151235);
    }
    
    public final void kt(boolean paramBoolean)
    {
      AppMethodBeat.i(110585);
      this.sQi.getPresenter().lQ(paramBoolean);
      AppMethodBeat.o(110585);
    }
    
    public final void pauseAudio()
    {
      AppMethodBeat.i(110583);
      this.sQi.getPresenter().pauseAudio();
      AppMethodBeat.o(110583);
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends k
    implements b<Boolean, y>
  {
    g(EditorView paramEditorView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.editor.EditorView
 * JD-Core Version:    0.7.0.1
 */