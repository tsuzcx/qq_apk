package com.tencent.mm.plugin.textstatus.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.r.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.plugin.recordvideo.jumper.RecordMediaReportInfo;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.sns.ui.SnsLabelUI;
import com.tencent.mm.plugin.textstatus.PluginTextStatus;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.g.w;
import com.tencent.mm.plugin.textstatus.g.z;
import com.tencent.mm.plugin.textstatus.j.e;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.view.MaxHeightScrollView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.n.k;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "()V", "blurEffect", "Lcom/tencent/mm/xeffect/effect/BlurEffect;", "btnBack", "Landroid/view/View;", "getBtnBack", "()Landroid/view/View;", "setBtnBack", "(Landroid/view/View;)V", "btnEditFinish", "Landroid/widget/Button;", "getBtnEditFinish", "()Landroid/widget/Button;", "setBtnEditFinish", "(Landroid/widget/Button;)V", "btnOk", "getBtnOk", "setBtnOk", "btnTag", "getBtnTag", "setBtnTag", "cameraClickListener", "Landroid/view/View$OnClickListener;", "captureResult", "Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;", "getCaptureResult", "()Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;", "setCaptureResult", "(Lcom/tencent/mm/plugin/mmsight/SightCaptureResult;)V", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "curlat", "", "getCurlat", "()F", "setCurlat", "(F)V", "curlng", "getCurlng", "setCurlng", "defaultBackgroundImgId", "", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "etDesc", "Landroid/widget/EditText;", "getEtDesc", "()Landroid/widget/EditText;", "setEtDesc", "(Landroid/widget/EditText;)V", "etTextStatus", "getEtTextStatus", "setEtTextStatus", "fakeBtnOk", "getFakeBtnOk", "fakeBtnOk$delegate", "Lkotlin/Lazy;", "fakePic", "getFakePic", "setFakePic", "finishByPost", "", "globalLayoutListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListener$1;", "iconCamera", "getIconCamera", "setIconCamera", "iconPoi", "getIconPoi", "setIconPoi", "iconStatus", "getIconStatus", "setIconStatus", "iconText", "getIconText", "setIconText", "iconVisibility", "getIconVisibility", "setIconVisibility", "imgResId", "", "getImgResId", "()Ljava/lang/String;", "setImgResId", "(Ljava/lang/String;)V", "imgVideoSource", "", "isBlur", "()Z", "setBlur", "(Z)V", "ivBlur", "Landroid/widget/ImageView;", "getIvBlur", "()Landroid/widget/ImageView;", "setIvBlur", "(Landroid/widget/ImageView;)V", "ivBlurSelect", "getIvBlurSelect", "ivBlurSelect$delegate", "ivBlurText", "Landroid/widget/TextView;", "getIvBlurText", "()Landroid/widget/TextView;", "ivBlurText$delegate", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "lastKeyboardHeight", "Ljava/lang/Integer;", "lastOriBitmap", "Landroid/graphics/Bitmap;", "layoutBlurOption", "getLayoutBlurOption", "setLayoutBlurOption", "layoutEditDesc", "getLayoutEditDesc", "setLayoutEditDesc", "layoutEditToolContainer", "getLayoutEditToolContainer", "setLayoutEditToolContainer", "layoutShow", "getLayoutShow", "setLayoutShow", "layoutTopicEdit", "getLayoutTopicEdit", "setLayoutTopicEdit", "layoutVideo", "Landroid/widget/FrameLayout;", "getLayoutVideo", "()Landroid/widget/FrameLayout;", "setLayoutVideo", "(Landroid/widget/FrameLayout;)V", "locationClickListener", "mChatRoomNameList", "mLabelNameList", "mLabelRangeindex", "mOtherUserNameList", "mediaType", "getMediaType", "()I", "setMediaType", "(I)V", "pageType", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "getPageType", "()Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "setPageType", "(Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;)V", "playView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "poiId", "getPoiId", "setPoiId", "poiName", "getPoiName", "setPoiName", "scrollShow", "Lcom/tencent/mm/view/MaxHeightScrollView;", "getScrollShow", "()Lcom/tencent/mm/view/MaxHeightScrollView;", "setScrollShow", "(Lcom/tencent/mm/view/MaxHeightScrollView;)V", "setStatusParam", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "getSetStatusParam", "()Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setSetStatusParam", "(Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "style", "getStyle", "setStyle", "textClickListener", "textStatus", "getTextStatus", "setTextStatus", "textStatusTypeName", "getTextStatusTypeName", "setTextStatusTypeName", "thirdContainerLl", "Landroid/widget/LinearLayout;", "getThirdContainerLl", "()Landroid/widget/LinearLayout;", "thirdContainerLl$delegate", "thirdDescTv", "getThirdDescTv", "thirdDescTv$delegate", "thirdIconContainerFl", "getThirdIconContainerFl", "thirdIconContainerFl$delegate", "thirdThumbPath", "getThirdThumbPath", "setThirdThumbPath", "topicContainerLl", "getTopicContainerLl", "topicContainerLl$delegate", "tvCancel", "getTvCancel", "setTvCancel", "tvDesc", "getTvDesc", "setTvDesc", "(Landroid/widget/TextView;)V", "tvPoi", "getTvPoi", "setTvPoi", "tvTextStatus", "getTvTextStatus", "setTvTextStatus", "tvVisibility", "getTvVisibility", "setTvVisibility", "updateVPicCallback", "Lcom/tencent/mm/modelimage/UrlImageCacheService$ILoadCallback;", "vBack", "getVBack", "setVBack", "vCamera", "getVCamera", "vCamera$delegate", "vFake", "getVFake", "vFake$delegate", "vMask", "getVMask", "setVMask", "vPic", "getVPic", "vPic$delegate", "vPicLoadUrl", "vPoi", "getVPoi", "setVPoi", "vText", "getVText", "setVText", "vVisibility", "getVVisibility", "setVVisibility", "visibilityClickListener", "visiblityUserNames", "Ljava/util/LinkedList;", "chatRoomToUserList", "", "chatRoomNames", "doWhenLess", "", "text", "doWhenMore", "doWhenOK", "finish", "getForceOrientation", "getLayoutId", "getTextStatusSet", "handleCaptureResult", "data", "Landroid/content/Intent;", "handleFile", "fileUrl", "thumeUrl", "handleFileLocal", "filePath", "handlePoi", "requestCode", "resultCode", "handleReportData", "initBlur", "initEditPage", "labelToUserList", "", "labelNames", "onActivityResult", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onKeyboardHeightChanged", "height", "isResized", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "selectPoi", "setForegroundPic", "bitmap", "setIcon", "id", "switchPage", "page", "updateBlurStatus", "updateVPic", "path", "Companion", "PageType", "plugin-textstatus_release"})
public final class TextStatusEditActivity
  extends MMSecDataActivity
  implements c.a, com.tencent.mm.ui.tools.g
{
  private static Bitmap GeL;
  public static final a GeM;
  private float ABu;
  private com.tencent.mm.xeffect.effect.b AtN;
  private final View.OnClickListener Cfi;
  private final View.OnClickListener Cfj;
  private float Esc;
  private String EvA;
  private String EvB;
  private int Evx;
  private String Evz;
  private TextView FYd;
  TextView FYe;
  public ImageView FYh;
  private TextView FYj;
  private String FZB;
  private FrameLayout Gcu;
  private EditText GdK;
  private View GdL;
  private final kotlin.f GdM;
  private final kotlin.f GdN;
  private View GdO;
  private View GdP;
  private View GdQ;
  private View GdR;
  private View GdS;
  private View GdT;
  private View GdU;
  public EditText GdV;
  Button GdW;
  private TextView GdX;
  private final kotlin.f GdY;
  private View GdZ;
  private final e GeA;
  private String GeB;
  private final r.a GeC;
  private Integer GeD;
  private b GeE;
  private final View.OnClickListener GeF;
  private final View.OnClickListener GeG;
  private SightCaptureResult GeH;
  private LinkedList<String> GeI;
  private String GeJ;
  private String GeK;
  private ImageView Gea;
  private View Geb;
  private View Gec;
  private View Ged;
  MaxHeightScrollView Gee;
  private View Gef;
  private final kotlin.f Geg;
  private View Geh;
  private View Gei;
  public View Gej;
  private final kotlin.f Gek;
  public View Gel;
  public View Gem;
  public ImageView Gen;
  private final kotlin.f Geo;
  private final kotlin.f Gep;
  private final kotlin.f Geq;
  private final kotlin.f Ger;
  private final kotlin.f Ges;
  private String Get;
  private String Geu;
  m Gev;
  boolean Gew;
  private int Gex;
  private Bitmap Gey;
  private com.tencent.mm.videocomposition.n Gez;
  private boolean UsU;
  private long Usj;
  private com.tencent.mm.ui.tools.h gyh;
  private String kHV;
  int mediaType;
  int style;
  private VideoCompositionPlayView wbi;
  private EffectManager wet;
  
  static
  {
    AppMethodBeat.i(216562);
    GeM = new a((byte)0);
    AppMethodBeat.o(216562);
  }
  
  public TextStatusEditActivity()
  {
    AppMethodBeat.i(216561);
    this.GdM = kotlin.g.ah((kotlin.g.a.a)new ae(this));
    this.GdN = kotlin.g.ah((kotlin.g.a.a)new af(this));
    this.GdY = kotlin.g.ah((kotlin.g.a.a)new ag(this));
    this.Geg = kotlin.g.ah((kotlin.g.a.a)new ac(this));
    this.Gek = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.Geo = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.Gep = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.Geq = kotlin.g.ah((kotlin.g.a.a)new z(this));
    this.Ger = kotlin.g.ah((kotlin.g.a.a)new aa(this));
    this.Ges = kotlin.g.ah((kotlin.g.a.a)new ab(this));
    e locale = e.Ggj;
    this.Gex = e.fwL();
    this.GeA = new e(this);
    this.GeC = ((r.a)new ad(this));
    this.GeE = b.GeN;
    this.Cfj = ((View.OnClickListener)new y(this));
    this.Evz = "";
    this.EvA = "";
    this.EvB = "";
    this.GeF = ((View.OnClickListener)new ah(this));
    this.Cfi = ((View.OnClickListener)new TextStatusEditActivity.j(this));
    this.GeG = ((View.OnClickListener)new TextStatusEditActivity.c(this));
    this.GeI = new LinkedList();
    this.Esc = -1000.0F;
    this.ABu = -1000.0F;
    AppMethodBeat.o(216561);
  }
  
  private final void a(b paramb)
  {
    AppMethodBeat.i(216550);
    switch (h.haE[paramb.ordinal()])
    {
    }
    for (;;)
    {
      this.GeE = paramb;
      AppMethodBeat.o(216550);
      return;
      Object localObject = this.Gec;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.Geb;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.Ged;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = getController();
      p.g(localObject, "controller");
      ((com.tencent.mm.ui.t)localObject).gIM().show();
      continue;
      localObject = this.Gec;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      localObject = this.Geb;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = this.Ged;
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      localObject = getController();
      p.g(localObject, "controller");
      ((com.tencent.mm.ui.t)localObject).gIM().hide();
      hideVKB();
    }
  }
  
  private final void aC(Bitmap paramBitmap)
  {
    AppMethodBeat.i(216544);
    if (paramBitmap != null)
    {
      fws().setImageBitmap(paramBitmap);
      fws().setVisibility(0);
      Object localObject = this.Gcu;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(8);
      }
      localObject = com.tencent.mm.plugin.textstatus.j.f.Ggk;
      GeL = com.tencent.mm.plugin.textstatus.j.f.a(paramBitmap, (Context)this, 10.0F);
      this.Gey = paramBitmap;
    }
    AppMethodBeat.o(216544);
  }
  
  private final void fwA()
  {
    AppMethodBeat.i(216541);
    Object localObject;
    if (this.Gew)
    {
      localObject = this.Gem;
      if (localObject == null) {
        p.btv("layoutBlurOption");
      }
      ((View)localObject).setAlpha(1.0F);
      localObject = this.Gen;
      if (localObject == null) {
        p.btv("ivBlur");
      }
      ((ImageView)localObject).setVisibility(8);
      fww().setVisibility(0);
      fwx().setTextColor(getContext().getResources().getColor(2131099844));
      localObject = this.Gea;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      localObject = this.wet;
      if (localObject != null) {
        ((EffectManager)localObject).a((ad)this.AtN);
      }
      if (GeL != null)
      {
        fws().setImageBitmap(GeL);
        AppMethodBeat.o(216541);
      }
    }
    else
    {
      localObject = this.Gem;
      if (localObject == null) {
        p.btv("layoutBlurOption");
      }
      ((View)localObject).setAlpha(0.85F);
      localObject = this.Gen;
      if (localObject == null) {
        p.btv("ivBlur");
      }
      ((ImageView)localObject).setVisibility(0);
      fww().setVisibility(8);
      fwx().setTextColor(getContext().getResources().getColor(2131099678));
      localObject = this.Gea;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.wet;
      if (localObject != null) {
        ((EffectManager)localObject).hiv();
      }
      if (this.Gey != null) {
        fws().setImageBitmap(this.Gey);
      }
    }
    AppMethodBeat.o(216541);
  }
  
  private final View fwp()
  {
    AppMethodBeat.i(216526);
    View localView = (View)this.GdM.getValue();
    AppMethodBeat.o(216526);
    return localView;
  }
  
  private final View fwq()
  {
    AppMethodBeat.i(216527);
    View localView = (View)this.GdN.getValue();
    AppMethodBeat.o(216527);
    return localView;
  }
  
  private final ImageView fws()
  {
    AppMethodBeat.i(216529);
    ImageView localImageView = (ImageView)this.GdY.getValue();
    AppMethodBeat.o(216529);
    return localImageView;
  }
  
  private final View fwv()
  {
    AppMethodBeat.i(216533);
    View localView = (View)this.Gek.getValue();
    AppMethodBeat.o(216533);
    return localView;
  }
  
  private final ImageView fww()
  {
    AppMethodBeat.i(216536);
    ImageView localImageView = (ImageView)this.Geo.getValue();
    AppMethodBeat.o(216536);
    return localImageView;
  }
  
  private final TextView fwx()
  {
    AppMethodBeat.i(216537);
    TextView localTextView = (TextView)this.Gep.getValue();
    AppMethodBeat.o(216537);
    return localTextView;
  }
  
  private final LinearLayout fwy()
  {
    AppMethodBeat.i(216538);
    LinearLayout localLinearLayout = (LinearLayout)this.Geq.getValue();
    AppMethodBeat.o(216538);
    return localLinearLayout;
  }
  
  private final FrameLayout fwz()
  {
    AppMethodBeat.i(216539);
    FrameLayout localFrameLayout = (FrameLayout)this.Ges.getValue();
    AppMethodBeat.o(216539);
    return localFrameLayout;
  }
  
  private static Collection<String> hG(List<String> paramList)
  {
    AppMethodBeat.i(216554);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      HashSet localHashSet = new HashSet();
      for (;;)
      {
        if (paramList.hasNext())
        {
          localObject = (String)paramList.next();
          localObject = com.tencent.mm.plugin.label.a.a.ecg().aCK(com.tencent.mm.plugin.label.a.a.ecg().aCH((String)localObject));
          if ((localObject != null) && (((List)localObject).size() != 0)) {}
        }
        else
        {
          paramList = (Collection)new ArrayList((Collection)localHashSet);
          AppMethodBeat.o(216554);
          return paramList;
        }
        Object localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localHashSet.add((String)((Iterator)localObject).next());
        }
      }
    }
    paramList = (Collection)new ArrayList();
    AppMethodBeat.o(216554);
    return paramList;
  }
  
  private static List<String> hH(List<String> paramList)
  {
    AppMethodBeat.i(216555);
    LinkedList localLinkedList = new LinkedList();
    if (!com.tencent.mm.kernel.g.aAf().azp())
    {
      paramList = (List)localLinkedList;
      AppMethodBeat.o(216555);
      return paramList;
    }
    if (paramList == null)
    {
      paramList = (List)localLinkedList;
      AppMethodBeat.o(216555);
      return paramList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = com.tencent.mm.model.v.Id((String)paramList.next());
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          if ((!localLinkedList.contains(str)) && (ab.IS(str))) {
            localLinkedList.add(str);
          }
        }
      }
    }
    paramList = (List)localLinkedList;
    AppMethodBeat.o(216555);
    return paramList;
  }
  
  private final void i(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(216542);
    fws().setImageBitmap(paramBitmap);
    this.GeK = paramString;
    paramString = com.tencent.mm.plugin.textstatus.j.f.Ggk;
    GeL = com.tencent.mm.plugin.textstatus.j.f.a(paramBitmap, (Context)this, 10.0F);
    this.Gey = paramBitmap;
    fwA();
    AppMethodBeat.o(216542);
  }
  
  private final void setIcon(String paramString)
  {
    AppMethodBeat.i(216556);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject))) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.Get = paramString;
      paramString = SecDataUIC.CWq;
      paramString = (z)SecDataUIC.a.a((Context)this, 8, z.class);
      if (paramString != null) {
        paramString.Usd.add(this.Get);
      }
      paramString = com.tencent.mm.plugin.textstatus.j.b.GfZ;
      paramString = com.tencent.mm.plugin.textstatus.j.b.a(this.Get, null, null, 6);
      if (paramString == null) {
        break;
      }
      localObject = this.GdL;
      if (localObject == null) {
        break;
      }
      ((View)localObject).setBackground(paramString);
      AppMethodBeat.o(216556);
      return;
    }
    AppMethodBeat.o(216556);
  }
  
  public final void Tw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(216560);
    Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "Set New textStatus : " + Util.secPrint(paramString));
    hideVKB();
    paramString = this.GdV;
    if (paramString == null) {
      p.btv("etDesc");
    }
    Object localObject2 = paramString.getText();
    Object localObject1;
    Object localObject4;
    switch (this.Evx)
    {
    default: 
      paramString = null;
      localObject1 = com.tencent.mm.plugin.textstatus.f.h.d.Gaa;
      localObject1 = new com.tencent.mm.plugin.textstatus.g.v();
      localObject4 = SecDataUIC.CWq;
      localObject4 = getContext();
      p.g(localObject4, "context");
      localObject4 = (z)SecDataUIC.a.a((Context)localObject4, 8, z.class);
      if (localObject4 != null) {
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).Usb = ((z)localObject4).Usb;
      }
      ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaW = true;
      localObject4 = this.GeH;
      if (localObject4 != null)
      {
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaW = false;
        if (((SightCaptureResult)localObject4).tkD)
        {
          ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaX = ((SightCaptureResult)localObject4).zsA;
          ((com.tencent.mm.plugin.textstatus.g.v)localObject1).thumbPath = ((SightCaptureResult)localObject4).zsB;
          i = 2;
        }
      }
      break;
    }
    Object localObject5;
    Object localObject6;
    do
    {
      for (;;)
      {
        localObject4 = new com.tencent.mm.plugin.textstatus.g.g();
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).longitude = this.ABu;
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).latitude = this.Esc;
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).Gat = i;
        localObject5 = new w();
        localObject6 = e.Ggj;
        localObject6 = e.fwK().matcher((CharSequence)localObject2.toString());
        while (((Matcher)localObject6).find()) {
          ((w)localObject5).Gbc.add(((Matcher)localObject6).group(1));
        }
        paramString = this.GeI;
        break;
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaX = ((SightCaptureResult)localObject4).zsG;
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).thumbPath = ((SightCaptureResult)localObject4).zsG;
        i = 1;
      }
      localObject4 = this.Gev;
    } while (localObject4 == null);
    if ((((m)localObject4).Gah != null) && (((m)localObject4).mediaType == 1))
    {
      localObject4 = (CharSequence)((m)localObject4).thumbUrl;
      if ((localObject4 == null) || (kotlin.n.n.aL((CharSequence)localObject4)))
      {
        i = 1;
        label378:
        if (i != 0) {
          break label919;
        }
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaX = this.GeK;
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).thumbPath = this.GeK;
        ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaW = false;
      }
    }
    label919:
    for (i = 1;; i = 0)
    {
      break;
      i = 0;
      break label378;
      ((w)localObject5).Gan = String.valueOf(this.Get);
      localObject6 = this.Gev;
      if (localObject6 != null)
      {
        String str = ((m)localObject6).Gah;
        if (str != null)
        {
          ((w)localObject5).Gao = str;
          ((w)localObject5).Gap = ((m)localObject6).Gai;
          ((w)localObject5).Gbf = ((m)localObject6).fuN;
          ((w)localObject5).Gal = ((m)localObject6).iFo;
          ((w)localObject5).Gam = ((m)localObject6).Gaj;
          ((w)localObject5).Gbe = ((m)localObject6).Gak;
        }
      }
      ((com.tencent.mm.plugin.textstatus.g.g)localObject4).Gau = ((w)localObject5);
      ((com.tencent.mm.plugin.textstatus.g.g)localObject4).description = localObject2.toString();
      int j = com.tencent.mm.ui.tools.f.a(((com.tencent.mm.plugin.textstatus.g.g)localObject4).description, f.a.Qui);
      if (j > 64) {
        localObject2 = com.tencent.mm.ui.tools.f.hm(((com.tencent.mm.plugin.textstatus.g.g)localObject4).description, 64);
      }
      try
      {
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).description = ((com.tencent.mm.plugin.textstatus.g.g)localObject4).description.subSequence(0, ((String)localObject2).length()).toString();
        Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "check desc " + Util.secPrint(((com.tencent.mm.plugin.textstatus.g.g)localObject4).description) + " count:" + j);
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).Gaz = cl.aWB();
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).pRN = (((com.tencent.mm.plugin.textstatus.g.g)localObject4).Gaz + 86400);
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).GaA = this.GeJ;
        ((com.tencent.mm.plugin.textstatus.g.g)localObject4).iUX = this.kHV;
        if (this.Gew)
        {
          l = com.tencent.mm.plugin.textstatus.f.b.a.FZv.value;
          ((com.tencent.mm.plugin.textstatus.g.g)localObject4).GaB = l;
          if (!((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaW) {
            break label819;
          }
          localObject2 = e.Ggj;
          ((com.tencent.mm.plugin.textstatus.g.g)localObject4).GaC = e.abN(this.Gex);
          ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaU = ((com.tencent.mm.plugin.textstatus.g.g)localObject4);
          ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaV = paramString;
          com.tencent.mm.plugin.textstatus.f.h.d.b((com.tencent.mm.plugin.textstatus.g.v)localObject1);
          paramString = this.Gev;
          if ((paramString != null) && (paramString.Gah != null)) {
            u.u((Context)this, getString(2131755982), 2131690787);
          }
          setResult(-1);
          this.UsU = true;
          finish();
          AppMethodBeat.o(216560);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.TxtStatus.TextStatusEditActivity", "doWhenOK replace: " + localException.getMessage());
          continue;
          long l = com.tencent.mm.plugin.textstatus.f.b.a.FZu.value;
          continue;
          label819:
          Object localObject3;
          if (i == 1)
          {
            localObject3 = BitmapUtil.getImageOptions(((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaX);
            if (localObject3 != null)
            {
              ((com.tencent.mm.plugin.textstatus.g.g)localObject4).zGN = ((BitmapFactory.Options)localObject3).outWidth;
              ((com.tencent.mm.plugin.textstatus.g.g)localObject4).zGO = ((BitmapFactory.Options)localObject3).outHeight;
            }
          }
          else
          {
            localObject3 = MultiMediaVideoChecker.GyY;
            localObject5 = ((com.tencent.mm.plugin.textstatus.g.v)localObject1).GaX;
            p.g(localObject5, "uploadFilePath");
            localObject3 = ((MultiMediaVideoChecker)localObject3).aTV((String)localObject5);
            if (localObject3 != null)
            {
              ((com.tencent.mm.plugin.textstatus.g.g)localObject4).zGN = ((MultiMediaVideoChecker.a)localObject3).width;
              ((com.tencent.mm.plugin.textstatus.g.g)localObject4).zGO = ((MultiMediaVideoChecker.a)localObject3).height;
            }
          }
        }
      }
    }
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(216558);
    u.u((Context)this, getString(2131765481), 2131690820);
    paramString = SecDataUIC.CWq;
    paramString = getContext();
    p.g(paramString, "context");
    paramString = (z)SecDataUIC.a.a((Context)paramString, 8, z.class);
    if (paramString != null)
    {
      paramString.Usr = (1L + paramString.Usr);
      AppMethodBeat.o(216558);
      return;
    }
    AppMethodBeat.o(216558);
  }
  
  public final void dv(String paramString)
  {
    AppMethodBeat.i(216559);
    u.u((Context)this, getString(2131765482), 2131690820);
    paramString = SecDataUIC.CWq;
    paramString = getContext();
    p.g(paramString, "context");
    paramString = (z)SecDataUIC.a.a((Context)paramString, 8, z.class);
    if (paramString != null)
    {
      paramString.Usq = (1L + paramString.Usq);
      AppMethodBeat.o(216559);
      return;
    }
    AppMethodBeat.o(216559);
  }
  
  public final void finish()
  {
    long l2 = 1L;
    AppMethodBeat.i(216557);
    Object localObject1 = PluginTextStatus.FXb;
    PluginTextStatus.access$setSIsNeedUpdateTitle$cp(true);
    hideVKB();
    localObject1 = this.GdV;
    if (localObject1 == null) {
      p.btv("etDesc");
    }
    localObject1 = ((EditText)localObject1).getText().toString();
    Object localObject2 = this.Gev;
    if ((localObject2 != null) && (((m)localObject2).Gah != null))
    {
      Object localObject3 = SecDataUIC.CWq;
      localObject3 = getContext();
      p.g(localObject3, "context");
      localObject3 = (z)SecDataUIC.a.a((Context)localObject3, 8, z.class);
      if (localObject3 != null)
      {
        if (!Util.isNullOrNil(((m)localObject2).desc)) {
          break label304;
        }
        l1 = 0L;
        ((z)localObject3).Usn = l1;
        if (((z)localObject3).Usd.size() != 1) {
          break label327;
        }
        l1 = 1L;
        label142:
        ((z)localObject3).Uso = l1;
      }
    }
    localObject2 = SecDataUIC.CWq;
    localObject2 = getContext();
    p.g(localObject2, "context");
    localObject2 = (z)SecDataUIC.a.a((Context)localObject2, 8, z.class);
    if (localObject2 != null)
    {
      ((z)localObject2).Usk = com.tencent.mm.ui.tools.f.a((String)localObject1, f.a.Qui);
      if (!Util.isNullOrNil(this.kHV)) {
        break label332;
      }
      l1 = 0L;
      label216:
      ((z)localObject2).Usx = l1;
      if (!this.Gew) {
        break label337;
      }
    }
    label304:
    label327:
    label332:
    label337:
    for (long l1 = l2;; l1 = 0L)
    {
      ((z)localObject2).UsC = l1;
      localObject1 = SecDataUIC.CWq;
      localObject1 = getContext();
      p.g(localObject1, "context");
      localObject1 = (z)SecDataUIC.a.a((Context)localObject1, 8, z.class);
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.a(this.UsU, (z)localObject1);
      }
      super.finish();
      AppMethodBeat.o(216557);
      return;
      if (Util.isEqual(((m)localObject2).desc, (String)localObject1))
      {
        l1 = 0L;
        break;
      }
      l1 = 1L;
      break;
      l1 = 0L;
      break label142;
      l1 = 1L;
      break label216;
    }
  }
  
  public final void fwB()
  {
    AppMethodBeat.i(216552);
    Intent localIntent = new Intent();
    localIntent.putExtra("near_life_scene", 1);
    com.tencent.mm.br.c.b((Context)getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", localIntent, 10);
    AppMethodBeat.o(216552);
  }
  
  public final EditText fwr()
  {
    AppMethodBeat.i(216528);
    EditText localEditText = this.GdV;
    if (localEditText == null) {
      p.btv("etDesc");
    }
    AppMethodBeat.o(216528);
    return localEditText;
  }
  
  public final ImageView fwt()
  {
    AppMethodBeat.i(216530);
    ImageView localImageView = this.FYh;
    if (localImageView == null) {
      p.btv("vBack");
    }
    AppMethodBeat.o(216530);
    return localImageView;
  }
  
  public final View fwu()
  {
    AppMethodBeat.i(216531);
    View localView = this.Gej;
    if (localView == null) {
      p.btv("btnOk");
    }
    AppMethodBeat.o(216531);
    return localView;
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return 2131496684;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int k = 1;
    int j = 1;
    int i = 0;
    AppMethodBeat.i(216553);
    Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "onActivityResult");
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    default: 
    case 2: 
    case 3: 
      do
      {
        AppMethodBeat.o(216553);
        return;
        if (paramIntent != null)
        {
          localObject = (SightCaptureResult)paramIntent.getParcelableExtra("key_req_result");
          if (localObject == null) {
            break label741;
          }
          if (paramIntent != null)
          {
            paramIntent = (CaptureDataManager.CaptureVideoNormalModel)paramIntent.getParcelableExtra("KSEGMENTMEDIAINFO");
            if (paramIntent != null) {
              this.Usj = (((Number)paramIntent.eJJ().y("KEY_MEDIA_SOURCE_INT", Integer.valueOf(0))).intValue() + 1);
            }
          }
          this.GeH = ((SightCaptureResult)localObject);
          paramIntent = null;
          if (!((SightCaptureResult)localObject).tkD) {
            break label629;
          }
          paramIntent = ((SightCaptureResult)localObject).zsB;
          if (!((SightCaptureResult)localObject).tkD) {
            break label646;
          }
          str = ((SightCaptureResult)localObject).zsA;
          Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "[handleCaptureResult]isVideo:%s,thumbPath:%s,filePath:%s", new Object[] { Boolean.valueOf(((SightCaptureResult)localObject).tkD), paramIntent, str });
          if (!((SightCaptureResult)localObject).tkD) {
            break label656;
          }
          paramInt1 = 2;
          paramIntent = (CharSequence)str;
          paramInt2 = j;
          if (paramIntent != null)
          {
            if (!kotlin.n.n.aL(paramIntent)) {
              break label661;
            }
            paramInt2 = j;
          }
          if (paramInt2 == 0)
          {
            paramIntent = this.Gem;
            if (paramIntent == null) {
              p.btv("layoutBlurOption");
            }
            paramIntent.setVisibility(0);
            this.mediaType = paramInt1;
            if (paramInt1 != 2) {
              break label671;
            }
            Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "handle video file");
            fws().setVisibility(8);
            paramIntent = this.Gcu;
            if (paramIntent != null) {
              paramIntent.setVisibility(0);
            }
            paramIntent = this.GdZ;
            if (paramIntent == null) {
              break label666;
            }
            paramInt1 = paramIntent.getMeasuredWidth();
            paramIntent = this.GdZ;
            paramInt2 = i;
            if (paramIntent != null) {
              paramInt2 = paramIntent.getMeasuredHeight();
            }
            paramIntent = new FrameLayout.LayoutParams(paramInt1, paramInt2);
            paramIntent.gravity = 17;
            VideoCompositionPlayView localVideoCompositionPlayView = new VideoCompositionPlayView((Context)this);
            FrameLayout localFrameLayout = this.Gcu;
            if (localFrameLayout != null) {
              localFrameLayout.addView((View)localVideoCompositionPlayView, (ViewGroup.LayoutParams)paramIntent);
            }
            localVideoCompositionPlayView.post((Runnable)new TextStatusEditActivity.f(localVideoCompositionPlayView, this, paramIntent, str));
            this.wbi = localVideoCompositionPlayView;
            paramIntent = com.tencent.mm.plugin.textstatus.j.f.Ggk;
            com.tencent.mm.plugin.textstatus.j.f.B((View)this.wbi, com.tencent.mm.cb.a.fromDPToPix((Context)this, 12.0F));
          }
          fwA();
          if (!((SightCaptureResult)localObject).tkD) {
            break label683;
          }
          paramIntent = SecDataUIC.CWq;
          paramIntent = getContext();
          p.g(paramIntent, "context");
          paramIntent = (z)SecDataUIC.a.a((Context)paramIntent, 8, z.class);
          if (paramIntent != null)
          {
            paramIntent.Ush = (((SightCaptureResult)localObject).zsE * 1000L);
            paramIntent.Usi = (s.boW(((SightCaptureResult)localObject).zsB) + s.boW(((SightCaptureResult)localObject).zsA));
          }
        }
        for (;;)
        {
          paramIntent = SecDataUIC.CWq;
          paramIntent = getContext();
          p.g(paramIntent, "context");
          paramIntent = (z)SecDataUIC.a.a((Context)paramIntent, 8, z.class);
          if (paramIntent == null) {
            break label741;
          }
          paramIntent.Usj = this.Usj;
          localObject = this.Gev;
          if (localObject == null) {
            break label734;
          }
          if (((m)localObject).Gah != null) {
            paramIntent.Usp = 1L;
          }
          AppMethodBeat.o(216553);
          return;
          localObject = null;
          break;
          if (!((SightCaptureResult)localObject).zsy) {
            break label180;
          }
          paramIntent = ((SightCaptureResult)localObject).zsG;
          break label180;
          str = ((SightCaptureResult)localObject).zsG;
          break label195;
          paramInt1 = 1;
          break label238;
          paramInt2 = 0;
          break label261;
          paramInt1 = 0;
          break label341;
          aC(BitmapUtil.decodeFileWithSample(str));
          break label465;
          paramIntent = SecDataUIC.CWq;
          paramIntent = getContext();
          p.g(paramIntent, "context");
          paramIntent = (z)SecDataUIC.a.a((Context)paramIntent, 8, z.class);
          if (paramIntent != null) {
            paramIntent.Usi = s.boW(((SightCaptureResult)localObject).zsG);
          }
        }
        AppMethodBeat.o(216553);
        return;
        AppMethodBeat.o(216553);
        return;
      } while (paramInt2 != -1);
      if (paramIntent != null)
      {
        str = paramIntent.getStringExtra("STATUS_TYPE_IMG");
        localObject = str;
        if (str != null) {}
      }
      else
      {
        localObject = "";
      }
      this.Get = ((String)localObject);
      setIcon(this.Get);
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("STATUS_TYPE_NAME");
        paramIntent = (Intent)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramIntent = "";
      }
      localObject = this.FYd;
      if (localObject != null)
      {
        ((TextView)localObject).setText((CharSequence)paramIntent);
        AppMethodBeat.o(216553);
        return;
      }
      AppMethodBeat.o(216553);
      return;
    case 10: 
      label180:
      label195:
      label238:
      label629:
      Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "intent ".concat(String.valueOf(paramIntent)));
      label261:
      label341:
      label734:
      label741:
      if (paramInt2 != -1)
      {
        paramIntent = this.FYj;
        if (paramIntent != null)
        {
          paramIntent.setVisibility(8);
          AppMethodBeat.o(216553);
          return;
        }
        AppMethodBeat.o(216553);
        return;
      }
      label465:
      if (paramIntent != null)
      {
        localObject = paramIntent.getStringExtra("get_poi_name");
        str = paramIntent.getStringExtra("get_city");
        if ((!Util.isNullOrNil((String)localObject)) || (!Util.isNullOrNil(str))) {
          break label1046;
        }
      }
      label646:
      label656:
      label661:
      label666:
      label671:
      label683:
      for (localObject = null;; localObject = Util.nullAs((String)localObject, str))
      {
        this.kHV = ((String)localObject);
        this.Esc = paramIntent.getFloatExtra("get_lat", -1000.0F);
        this.ABu = paramIntent.getFloatExtra("get_lng", -1000.0F);
        this.GeJ = Util.nullAs(paramIntent.getStringExtra("get_poi_classify_id"), "");
        if (Util.isNullOrNil(this.kHV)) {
          break label1065;
        }
        paramIntent = this.FYj;
        if (paramIntent != null) {
          paramIntent.setText((CharSequence)this.kHV);
        }
        paramIntent = this.FYj;
        if (paramIntent == null) {
          break;
        }
        paramIntent.setVisibility(0);
        AppMethodBeat.o(216553);
        return;
      }
      label1046:
      AppMethodBeat.o(216553);
      return;
      label1065:
      paramIntent = this.FYj;
      if (paramIntent != null)
      {
        paramIntent.setVisibility(8);
        AppMethodBeat.o(216553);
        return;
      }
      AppMethodBeat.o(216553);
      return;
    }
    if (paramIntent == null)
    {
      AppMethodBeat.o(216553);
      return;
    }
    this.Evx = paramIntent.getIntExtra("Ktag_range_index", 0);
    String str = paramIntent.getStringExtra("Klabel_name_list");
    Object localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.Evz = ((String)localObject);
    str = paramIntent.getStringExtra("Kother_user_name_list");
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    this.EvA = ((String)localObject);
    localObject = paramIntent.getStringExtra("Kchat_room_name_list");
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = "";
    }
    this.EvB = paramIntent;
    this.GeI.clear();
    if (!Util.isNullOrNil(this.EvB))
    {
      paramIntent = (CharSequence)this.EvB;
      paramIntent = ((Collection)new k(",").q(paramIntent, 0)).toArray(new String[0]);
      if (paramIntent == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(216553);
        throw paramIntent;
      }
      paramIntent = (String[])paramIntent;
      paramIntent = j.listOf((String[])Arrays.copyOf(paramIntent, paramIntent.length));
      this.GeI.addAll((Collection)hH(paramIntent));
    }
    for (paramInt2 = k;; paramInt2 = 0)
    {
      paramInt1 = paramInt2;
      if (!Util.isNullOrNil(this.Evz))
      {
        paramIntent = (CharSequence)this.Evz;
        paramIntent = ((Collection)new k(",").q(paramIntent, 0)).toArray(new String[0]);
        if (paramIntent == null)
        {
          paramIntent = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(216553);
          throw paramIntent;
        }
        paramIntent = (String[])paramIntent;
        paramIntent = j.listOf((String[])Arrays.copyOf(paramIntent, paramIntent.length));
        this.GeI.addAll(hG(paramIntent));
        paramInt1 = paramInt2 | 0x4;
      }
      paramInt2 = paramInt1;
      if (!Util.isNullOrNil(this.EvA))
      {
        paramIntent = (CharSequence)this.EvA;
        paramIntent = ((Collection)new k(",").q(paramIntent, 0)).toArray(new String[0]);
        if (paramIntent == null)
        {
          paramIntent = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(216553);
          throw paramIntent;
        }
        paramIntent = (String[])paramIntent;
        paramIntent = j.listOf((String[])Arrays.copyOf(paramIntent, paramIntent.length));
        this.GeI.addAll((Collection)paramIntent);
        paramInt2 = paramInt1 | 0x2;
      }
      paramInt1 = paramInt2;
      switch (this.Evx)
      {
      default: 
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramIntent = SecDataUIC.CWq;
        paramIntent = getContext();
        p.g(paramIntent, "context");
        paramIntent = (z)SecDataUIC.a.a((Context)paramIntent, 8, z.class);
        if (paramIntent == null) {
          break;
        }
        paramIntent.Usz = paramInt1;
        AppMethodBeat.o(216553);
        return;
        paramIntent = this.GdX;
        if (paramIntent != null) {
          paramIntent.setText((CharSequence)getContext().getString(2131766746));
        }
        paramInt1 = 0;
        continue;
        paramIntent = this.GdX;
        paramInt1 = paramInt2;
        if (paramIntent != null)
        {
          paramIntent.setText((CharSequence)getContext().getString(2131766748));
          paramInt1 = paramInt2;
        }
      }
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(216549);
    b localb = this.GeE;
    switch (h.$EnumSwitchMapping$0[localb.ordinal()])
    {
    default: 
      super.onBackPressed();
      getContext().overridePendingTransition(2130771986, 2130772130);
      AppMethodBeat.o(216549);
      return;
    }
    a(b.GeN);
    AppMethodBeat.o(216549);
  }
  
  @SuppressLint({"ResourceType"})
  public final void onCreate(final Bundle paramBundle)
  {
    boolean bool2 = true;
    AppMethodBeat.i(216540);
    com.tencent.mm.pluginsdk.h.q((MMActivity)this);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle.setNavigationBarColor(getResources().getColor(2131099742));
    setActionbarColor(0);
    paramBundle = getWindow();
    p.g(paramBundle, "window");
    paramBundle = paramBundle.getDecorView();
    p.g(paramBundle, "window.decorView");
    paramBundle.setSystemUiVisibility(1280);
    com.tencent.mm.ui.statusbar.d.e(getWindow());
    paramBundle = getController();
    p.g(paramBundle, "controller");
    paramBundle.gIM().Q(false);
    setMMTitle("");
    hideActionbarLine();
    hideActionBarOperationArea();
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.hide();
      paramBundle = x.SXb;
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new TextStatusEditActivity.m(this));
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    ((SecDataUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(SecDataUIC.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(z.class, 8, (byte)0));
    paramBundle = SecDataUIC.CWq;
    paramBundle = (z)SecDataUIC.a.a((Context)this, 8, z.class);
    if (paramBundle != null)
    {
      paramBundle.Usb = String.valueOf(cl.aWA());
      paramBundle.enterTime = cl.aWA();
      paramBundle = x.SXb;
    }
    this.GdL = findViewById(2131302508);
    this.FYd = ((TextView)findViewById(2131309533));
    this.GdP = findViewById(2131309668);
    this.GdQ = findViewById(2131309671);
    this.GdR = findViewById(2131302484);
    this.GdT = findViewById(2131302506);
    this.GdU = findViewById(2131302513);
    paramBundle = findViewById(2131300167);
    p.g(paramBundle, "findViewById(R.id.et_desc)");
    this.GdV = ((EditText)paramBundle);
    this.FYe = ((TextView)findViewById(2131309471));
    this.GdZ = findViewById(2131300425);
    paramBundle = findViewById(2131309661);
    p.g(paramBundle, "findViewById(R.id.v_back)");
    this.FYh = ((ImageView)paramBundle);
    this.Gea = ((ImageView)findViewById(2131309666));
    this.FYj = ((TextView)findViewById(2131309512));
    this.GdX = ((TextView)findViewById(2131309545));
    this.Gcu = ((FrameLayout)findViewById(2131303103));
    this.Gef = findViewById(2131303102);
    this.Geb = findViewById(2131303099);
    this.Ged = findViewById(2131303089);
    this.Gei = findViewById(2131297852);
    paramBundle = findViewById(2131297842);
    p.g(paramBundle, "findViewById(R.id.btn_ok)");
    this.Gej = paramBundle;
    paramBundle = findViewById(2131297823);
    p.g(paramBundle, "findViewById(R.id.btn_back)");
    this.Gel = paramBundle;
    paramBundle = findViewById(2131303079);
    p.g(paramBundle, "findViewById(R.id.layout_blur_option)");
    this.Gem = paramBundle;
    paramBundle = findViewById(2131302880);
    p.g(paramBundle, "findViewById(R.id.iv_blur)");
    this.Gen = ((ImageView)paramBundle);
    paramBundle = this.FYh;
    if (paramBundle == null) {
      p.btv("vBack");
    }
    if (paramBundle != null) {
      paramBundle.post((Runnable)new TextStatusEditActivity.aj(this));
    }
    au.getStatusBarHeight((Context)this);
    au.eu((Context)this);
    au.aD((Context)this);
    Object localObject1 = getIntent().getByteArrayExtra("SET_TEXT_PARAMS");
    if (localObject1 != null)
    {
      paramBundle = new m();
      paramBundle.parseFrom((byte[])localObject1);
      localObject1 = x.SXb;
      this.Gev = paramBundle;
      paramBundle = x.SXb;
    }
    Log.i("MicroMsg.TxtStatus.TextStatusEditActivity", "[onCreate] setStatusParam:%s", new Object[] { this.Gev });
    paramBundle = this.Gev;
    label809:
    label1129:
    label1394:
    int j;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.FZB;
      this.FZB = paramBundle;
      paramBundle = this.Gev;
      if (paramBundle != null)
      {
        i = paramBundle.Gag;
        if (i != 0) {
          this.Gex = i;
        }
        localObject1 = x.SXb;
        localObject1 = SecDataUIC.CWq;
        localObject1 = (z)SecDataUIC.a.a((Context)this, 8, z.class);
        if (localObject1 != null)
        {
          ((z)localObject1).sessionId = paramBundle.sessionId;
          ((z)localObject1).UrT = paramBundle.UrT;
          if (paramBundle.enterTime != 0L) {
            break label2005;
          }
          ((z)localObject1).enterTime = cl.aWA();
          localObject1 = x.SXb;
        }
        localObject1 = paramBundle.Gah;
        if (localObject1 != null)
        {
          fwy().setVisibility(0);
          ((TextView)this.Ger.getValue()).setText((CharSequence)paramBundle.iFo);
          fwz().setVisibility(8);
          fwy().setOnClickListener((View.OnClickListener)new TextStatusEditActivity.k((String)localObject1, paramBundle, this));
          if (!Util.isNullOrNil(paramBundle.desc))
          {
            localObject2 = this.GdV;
            if (localObject2 == null) {
              p.btv("etDesc");
            }
            ((EditText)localObject2).setText((CharSequence)paramBundle.desc);
          }
          Object localObject2 = SecDataUIC.CWq;
          localObject2 = getContext();
          p.g(localObject2, "context");
          localObject2 = (z)SecDataUIC.a.a((Context)localObject2, 8, z.class);
          if (localObject2 != null)
          {
            ((z)localObject2).Usl = ((String)localObject1);
            ((z)localObject2).Usm = paramBundle.Gai;
            ((z)localObject2).iFo = paramBundle.iFo;
            ((z)localObject2).iFp = paramBundle.Gaj;
            if ((!Util.isNullOrNil(paramBundle.thumbUrl)) || (!Util.isNullOrNil(paramBundle.fileUrl))) {
              ((z)localObject2).Usj = 4L;
            }
            localObject2 = x.SXb;
          }
          com.tencent.f.h.RTc.aX((Runnable)new l((String)localObject1, paramBundle, this));
        }
      }
      paramBundle = this.GdV;
      if (paramBundle == null) {
        p.btv("etDesc");
      }
      if (Util.isNullOrNil((CharSequence)paramBundle.getText()))
      {
        paramBundle = this.GdV;
        if (paramBundle == null) {
          p.btv("etDesc");
        }
        paramBundle.post((Runnable)new TextStatusEditActivity.u(this));
      }
      paramBundle = this.Gev;
      if (paramBundle == null) {
        break label2017;
      }
      paramBundle = paramBundle.Gah;
      if (!Util.isEqual(paramBundle, "live_player@inner")) {
        break label2022;
      }
      fwp().setVisibility(8);
      fwq().setVisibility(0);
      label1156:
      paramBundle = this.Gej;
      if (paramBundle == null) {
        p.btv("btnOk");
      }
      localObject1 = this.GdV;
      if (localObject1 == null) {
        p.btv("etDesc");
      }
      localObject1 = ((EditText)localObject1).getText();
      p.g(localObject1, "etDesc.text");
      if (kotlin.n.n.aL((CharSequence)localObject1)) {
        break label2042;
      }
      bool1 = true;
      label1217:
      paramBundle.setEnabled(bool1);
      paramBundle = this.Gej;
      if (paramBundle == null) {
        p.btv("btnOk");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.v(this));
      paramBundle = this.Gej;
      if (paramBundle == null) {
        p.btv("btnOk");
      }
      if (!paramBundle.isEnabled()) {
        fwv().setVisibility(0);
      }
      fwv().setOnClickListener((View.OnClickListener)new TextStatusEditActivity.w(this));
      paramBundle = this.Gel;
      if (paramBundle == null) {
        p.btv("btnBack");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.x(this));
      paramBundle = this.FYh;
      if (paramBundle == null) {
        p.btv("vBack");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.n(this));
      paramBundle = this.Gev;
      if (paramBundle == null) {
        break label2048;
      }
      paramBundle = paramBundle.Gae;
      label1375:
      setIcon(paramBundle);
      paramBundle = this.Gev;
      if (paramBundle == null) {
        break label2053;
      }
      paramBundle = paramBundle.thumbUrl;
      localObject1 = this.Gev;
      if (localObject1 == null) {
        break label2058;
      }
      i = ((m)localObject1).mediaType;
      label1411:
      this.mediaType = i;
      if (i != 1) {
        break label2068;
      }
      localObject1 = (CharSequence)paramBundle;
      if ((localObject1 != null) && (!kotlin.n.n.aL((CharSequence)localObject1))) {
        break label2063;
      }
      j = 1;
      label1442:
      if (j == 0) {
        break label2068;
      }
      aC(BitmapUtil.getBitmapNative(this.Gex));
      paramBundle = this.Gem;
      if (paramBundle == null) {
        p.btv("layoutBlurOption");
      }
      paramBundle.setVisibility(8);
      paramBundle = this.GdK;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)this.FZB);
        paramBundle = x.SXb;
      }
      paramBundle = this.FYd;
      if (paramBundle != null)
      {
        paramBundle.setText((CharSequence)this.FZB);
        paramBundle = x.SXb;
      }
      if (!TextUtils.isEmpty((CharSequence)this.Geu))
      {
        paramBundle = this.GdK;
        if (paramBundle != null) {
          paramBundle.setHint((CharSequence)this.Geu);
        }
      }
      paramBundle = this.FYj;
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.o(this));
        paramBundle = x.SXb;
      }
      paramBundle = this.Gei;
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.p(this));
        paramBundle = x.SXb;
      }
      paramBundle = this.GdV;
      if (paramBundle == null) {
        p.btv("etDesc");
      }
      if (paramBundle != null)
      {
        paramBundle.addTextChangedListener((TextWatcher)new TextStatusEditActivity.q(this));
        paramBundle = x.SXb;
      }
      paramBundle = this.GdV;
      if (paramBundle == null) {
        p.btv("etDesc");
      }
      if (paramBundle == null) {
        break label2168;
      }
      paramBundle = paramBundle.getViewTreeObserver();
      label1677:
      paramBundle.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this.GeA);
      paramBundle = (View)this.Geg.getValue();
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.r(this));
        paramBundle = x.SXb;
      }
      paramBundle = fwp();
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener(this.GeG);
        paramBundle = x.SXb;
      }
      paramBundle = this.GdP;
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.s(this));
        paramBundle = x.SXb;
      }
      paramBundle = this.GdQ;
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener(this.GeF);
        paramBundle = x.SXb;
      }
      paramBundle = this.Gec;
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.t(this));
        paramBundle = x.SXb;
      }
      paramBundle = this.Geh;
      if (paramBundle != null)
      {
        paramBundle.setOnClickListener((View.OnClickListener)new TextStatusEditActivity.ai(this));
        paramBundle = x.SXb;
      }
      localObject1 = (CharSequence)this.FZB;
      paramBundle = this.FYd;
      if (paramBundle == null) {
        break label2173;
      }
      paramBundle = paramBundle.getText();
      if (paramBundle == null) {
        break label2173;
      }
      paramBundle = paramBundle.toString();
      label1882:
      if (TextUtils.equals((CharSequence)localObject1, (CharSequence)paramBundle)) {
        break label2178;
      }
    }
    label2048:
    label2178:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      enableOptionMenu(bool1);
      paramBundle = this.GdO;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(this.Cfj);
      }
      this.gyh = new com.tencent.mm.ui.tools.h((Activity)this);
      paramBundle = this.gyh;
      if (paramBundle != null)
      {
        paramBundle.setKeyboardHeightObserver((com.tencent.mm.ui.tools.g)this);
        paramBundle = x.SXb;
      }
      paramBundle = this.Gel;
      if (paramBundle == null) {
        p.btv("btnBack");
      }
      paramBundle = paramBundle.getLayoutParams();
      if (paramBundle != null) {
        break label2184;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
      AppMethodBeat.o(216540);
      throw paramBundle;
      paramBundle = null;
      break;
      label2005:
      ((z)localObject1).enterTime = paramBundle.enterTime;
      break label809;
      label2017:
      paramBundle = null;
      break label1129;
      label2022:
      fwp().setVisibility(0);
      fwq().setVisibility(8);
      break label1156;
      label2042:
      bool1 = false;
      break label1217;
      paramBundle = null;
      break label1375;
      label2053:
      paramBundle = null;
      break label1394;
      label2058:
      i = 1;
      break label1411;
      label2063:
      j = 0;
      break label1442;
      label2068:
      localObject1 = this.Gem;
      if (localObject1 == null) {
        p.btv("layoutBlurOption");
      }
      ((View)localObject1).setVisibility(0);
      switch (i)
      {
      case 2: 
      default: 
        break;
      case 1: 
        if (s.YS(paramBundle))
        {
          localObject1 = BitmapUtil.decodeFileWithSample(paramBundle);
          if (paramBundle == null) {
            p.hyc();
          }
          i((Bitmap)localObject1, paramBundle);
          break;
        }
        this.GeB = paramBundle;
        com.tencent.mm.av.q.bcU().a(paramBundle, this.GeC);
        break;
        label2168:
        paramBundle = null;
        break label1677;
        label2173:
        paramBundle = null;
        break label1882;
      }
    }
    label2184:
    paramBundle = (RelativeLayout.LayoutParams)paramBundle;
    int i = au.getStatusBarHeight((Context)getContext());
    paramBundle.topMargin = (at.fromDPToPix((Context)getContext(), 6) + i);
    paramBundle = this.Gem;
    if (paramBundle == null) {
      p.btv("layoutBlurOption");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new g(this));
    AppMethodBeat.o(216540);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(216543);
    super.onDestroy();
    Object localObject1 = this.wbi;
    if (localObject1 != null) {
      ((VideoCompositionPlayView)localObject1).stop();
    }
    localObject1 = this.wbi;
    if (localObject1 != null) {
      ((VideoCompositionPlayView)localObject1).release();
    }
    localObject1 = this.wet;
    if (localObject1 != null) {
      ((EffectManager)localObject1).destroy();
    }
    com.tencent.mm.av.q.bcU().b(this.GeB, this.GeC);
    GeL = null;
    this.Gey = null;
    Object localObject2 = this.Gev;
    if (localObject2 != null)
    {
      localObject1 = ((m)localObject2).Gah;
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.textstatus.i.d locald = com.tencent.mm.plugin.textstatus.i.d.Gcq;
        localObject2 = ((m)localObject2).Gak;
        p.g(localObject2, "it.jumpInfos");
        localObject2 = ((LinkedList)localObject2).getFirst();
        p.g(localObject2, "it.jumpInfos.first");
        com.tencent.mm.plugin.textstatus.i.d.b((String)localObject1, (com.tencent.mm.plugin.textstatus.g.r)localObject2);
        AppMethodBeat.o(216543);
        return;
      }
      AppMethodBeat.o(216543);
      return;
    }
    AppMethodBeat.o(216543);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(216546);
    super.onPause();
    com.tencent.mm.ui.tools.h localh = this.gyh;
    if (localh != null)
    {
      localh.close();
      AppMethodBeat.o(216546);
      return;
    }
    AppMethodBeat.o(216546);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(216551);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    if (paramArrayOfInt.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216551);
      return;
    }
    if ((paramInt == 64) && (paramArrayOfInt[0] == 0))
    {
      fwB();
      AppMethodBeat.o(216551);
      return;
    }
    if ((paramInt == 16) && (paramArrayOfInt[0] == 0))
    {
      this.GeG.onClick(new View((Context)getContext()));
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(216551);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(216545);
    super.onResume();
    com.tencent.mm.ui.tools.h localh = this.gyh;
    if (localh != null)
    {
      localh.start();
      AppMethodBeat.o(216545);
      return;
    }
    AppMethodBeat.o(216545);
  }
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(216547);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
    {
      localh = this.gyh;
      if (localh != null)
      {
        localh.start();
        AppMethodBeat.o(216547);
        return;
      }
      AppMethodBeat.o(216547);
      return;
    }
    com.tencent.mm.ui.tools.h localh = this.gyh;
    if (localh != null)
    {
      localh.close();
      AppMethodBeat.o(216547);
      return;
    }
    AppMethodBeat.o(216547);
  }
  
  public final void setBtnBack(View paramView)
  {
    AppMethodBeat.i(216534);
    p.h(paramView, "<set-?>");
    this.Gel = paramView;
    AppMethodBeat.o(216534);
  }
  
  public final void setBtnOk(View paramView)
  {
    AppMethodBeat.i(216532);
    p.h(paramView, "<set-?>");
    this.Gej = paramView;
    AppMethodBeat.o(216532);
  }
  
  public final void setBtnTag(View paramView)
  {
    this.Gei = paramView;
  }
  
  public final void setFakePic(View paramView)
  {
    this.GdZ = paramView;
  }
  
  public final void setIconCamera(View paramView)
  {
    this.GdR = paramView;
  }
  
  public final void setIconPoi(View paramView)
  {
    this.GdT = paramView;
  }
  
  public final void setIconStatus(View paramView)
  {
    this.GdL = paramView;
  }
  
  public final void setIconText(View paramView)
  {
    this.GdS = paramView;
  }
  
  public final void setIconVisibility(View paramView)
  {
    this.GdU = paramView;
  }
  
  public final void setLayoutBlurOption(View paramView)
  {
    AppMethodBeat.i(216535);
    p.h(paramView, "<set-?>");
    this.Gem = paramView;
    AppMethodBeat.o(216535);
  }
  
  public final void setLayoutEditDesc(View paramView)
  {
    this.Gec = paramView;
  }
  
  public final void setLayoutEditToolContainer(View paramView)
  {
    this.Ged = paramView;
  }
  
  public final void setLayoutShow(View paramView)
  {
    this.Geb = paramView;
  }
  
  public final void setLayoutTopicEdit(View paramView)
  {
    this.Gef = paramView;
  }
  
  public final void setTvCancel(View paramView)
  {
    this.Geh = paramView;
  }
  
  public final void setVPoi(View paramView)
  {
    this.GdP = paramView;
  }
  
  public final void setVText(View paramView)
  {
    this.GdO = paramView;
  }
  
  public final void setVVisibility(View paramView)
  {
    this.GdQ = paramView;
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = null;
    AppMethodBeat.i(216548);
    Log.d("MicroMsg.TxtStatus.TextStatusEditActivity", "keyboardHeight " + paramInt + ", " + paramBoolean);
    Object localObject = this.GeD;
    if (localObject == null)
    {
      this.GeD = Integer.valueOf(paramInt);
      if (paramInt <= 0) {
        break label211;
      }
      int i = at.aH((Context)getContext(), 2131165296);
      localObject = this.Ged;
      if (localObject != null) {
        ((View)localObject).setTranslationY(-(paramInt - i));
      }
      localObject = this.Geb;
      if (localObject == null) {
        break label205;
      }
    }
    label205:
    for (localObject = com.tencent.mm.ac.d.cn((View)localObject);; localObject = null)
    {
      View localView = this.Ged;
      if (localView != null) {
        arrayOfInt = com.tencent.mm.ac.d.cn(localView);
      }
      localView = this.Geb;
      if ((localObject == null) || (arrayOfInt == null) || (localView == null)) {
        break label281;
      }
      localView.setTranslationY((arrayOfInt[1] - localObject[1]) / 2 - localView.getMeasuredHeight() / 3);
      AppMethodBeat.o(216548);
      return;
      if (((Integer)localObject).intValue() != paramInt) {
        break;
      }
      AppMethodBeat.o(216548);
      return;
    }
    label211:
    localObject = getWindow();
    p.g(localObject, "window");
    ((Window)localObject).setNavigationBarColor(getResources().getColor(2131099742));
    localObject = this.Geb;
    if (localObject != null) {
      ((View)localObject).setTranslationY(0.0F);
    }
    localObject = this.Ged;
    if (localObject != null)
    {
      ((View)localObject).setTranslationY(0.0F);
      AppMethodBeat.o(216548);
      return;
    }
    label281:
    AppMethodBeat.o(216548);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion;", "", "()V", "EDIT_TEXT_MAX_NUM", "", "TAG", "", "lastThumbBlurBitmap", "Landroid/graphics/Bitmap;", "getLastThumbBlurBitmap", "()Landroid/graphics/Bitmap;", "setLastThumbBlurBitmap", "(Landroid/graphics/Bitmap;)V", "start", "", "context", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "startForResult", "Landroid/app/Activity;", "reqCode", "plugin-textstatus_release"})
  public static final class a
  {
    public static void b(Activity paramActivity, m paramm)
    {
      AppMethodBeat.i(216481);
      p.h(paramActivity, "context");
      Intent localIntent = new Intent((Context)paramActivity, TextStatusEditActivity.class);
      if (paramm != null) {}
      for (paramm = paramm.toByteArray();; paramm = null)
      {
        localIntent.putExtra("SET_TEXT_PARAMS", paramm);
        paramActivity.startActivityForResult(localIntent, 1);
        if (paramActivity == null) {
          break;
        }
        paramActivity.overridePendingTransition(2130772132, 2130771986);
        AppMethodBeat.o(216481);
        return;
      }
      AppMethodBeat.o(216481);
    }
    
    public static void b(Context paramContext, m paramm)
    {
      AppMethodBeat.i(216480);
      p.h(paramContext, "context");
      Intent localIntent = new Intent(paramContext, TextStatusEditActivity.class);
      if (paramm == null)
      {
        paramm = TextStatusDoWhatActivity.GdF;
        TextStatusDoWhatActivity.a.g(paramContext, null);
        AppMethodBeat.o(216480);
        return;
      }
      localIntent.putExtra("SET_TEXT_PARAMS", paramm.toByteArray());
      paramm = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramm.axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramm.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$Companion", "start", "(Landroid/content/Context;Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (!(paramContext instanceof Activity)) {
        paramContext = null;
      }
      for (;;)
      {
        paramContext = (Activity)paramContext;
        if (paramContext != null)
        {
          paramContext.overridePendingTransition(2130772132, 2130771986);
          AppMethodBeat.o(216480);
          return;
        }
        AppMethodBeat.o(216480);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    aa(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ab
    extends kotlin.g.b.q
    implements kotlin.g.a.a<FrameLayout>
  {
    ab(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    ac(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "bitmap", "Landroid/graphics/Bitmap;", "path", "onLoadImageEnd"})
  static final class ad
    implements r.a
  {
    ad(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void a(String paramString1, Bitmap paramBitmap, String paramString2)
    {
      AppMethodBeat.i(216521);
      TextStatusEditActivity.a(this.GeQ, paramBitmap, paramString2);
      AppMethodBeat.o(216521);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ae
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    ae(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class af
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    af(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ag
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    ag(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class ah
    implements View.OnClickListener
  {
    ah(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216525);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$visibilityClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = new Intent((Context)this.GeQ, SnsLabelUI.class);
      paramView.putExtra("KLabel_range_index", TextStatusEditActivity.f(this.GeQ));
      paramView.putExtra("Klabel_name_list", TextStatusEditActivity.g(this.GeQ));
      paramView.putExtra("Kother_user_name_list", TextStatusEditActivity.h(this.GeQ));
      paramView.putExtra("Kchat_room_name_list", TextStatusEditActivity.i(this.GeQ));
      paramView.putExtra("Kis_from_text_status", true);
      paramView.putExtra("k_show_private", false);
      paramView.putExtra("k_show_include", false);
      paramView.putExtra("k_sns_label_ui_style", this.GeQ.style);
      this.GeQ.startActivityForResult(paramView, 4);
      paramView = SecDataUIC.CWq;
      paramView = this.GeQ.getContext();
      p.g(paramView, "context");
      paramView = (z)SecDataUIC.a.a((Context)paramView, 8, z.class);
      if (paramView != null) {
        paramView.Usy = (1L + paramView.Usy);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$visibilityClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216525);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$PageType;", "", "(Ljava/lang/String;I)V", "MAIN", "EDT_DESC", "plugin-textstatus_release"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(216482);
      b localb1 = new b("MAIN", 0);
      GeN = localb1;
      b localb2 = new b("EDT_DESC", 1);
      GeO = localb2;
      GeP = new b[] { localb1, localb2 };
      AppMethodBeat.o(216482);
    }
    
    private b() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    d(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$globalLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-textstatus_release"})
  public static final class e
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(216492);
      this.GeQ.fwr().post((Runnable)new a(this));
      Object localObject = this.GeQ.fwr();
      if (localObject != null) {}
      for (localObject = ((EditText)localObject).getViewTreeObserver();; localObject = null)
      {
        ((ViewTreeObserver)localObject).removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        AppMethodBeat.o(216492);
        return;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(TextStatusEditActivity.e parame) {}
      
      public final void run()
      {
        AppMethodBeat.i(216491);
        this.GeR.GeQ.fwr().requestFocus();
        com.tencent.f.h.RTc.n((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216490);
            Object localObject = this.GeS.GeR.GeQ.getContext().getSystemService("input_method");
            if (localObject == null)
            {
              localObject = new kotlin.t("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
              AppMethodBeat.o(216490);
              throw ((Throwable)localObject);
            }
            ((InputMethodManager)localObject).showSoftInput((View)this.GeS.GeR.GeQ.fwr(), 0);
            AppMethodBeat.o(216490);
          }
        }, 200L);
        AppMethodBeat.o(216491);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216494);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (this.GeQ.mediaType == 0)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216494);
        return;
      }
      paramView = SecDataUIC.CWq;
      paramView = this.GeQ.getContext();
      p.g(paramView, "context");
      paramView = (z)SecDataUIC.a.a((Context)paramView, 8, z.class);
      if (paramView != null)
      {
        if (this.GeQ.Gew) {
          paramView.UsB += 1L;
        }
      }
      else
      {
        paramView = this.GeQ;
        if (this.GeQ.Gew) {
          break label179;
        }
      }
      label179:
      for (boolean bool = true;; bool = false)
      {
        paramView.Gew = bool;
        TextStatusEditActivity.d(this.GeQ);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$initBlur$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216494);
        return;
        paramView.UsA += 1L;
        break;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    h(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    i(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$onCreate$5$3$3", "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$$special$$inlined$let$lambda$2"})
  static final class l
    implements Runnable
  {
    l(String paramString, m paramm, TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void run()
    {
      AppMethodBeat.i(216501);
      Object localObject1 = new z.f();
      ((z.f)localObject1).SYG = null;
      Object localObject2 = com.tencent.mm.plugin.textstatus.i.d.Gcq;
      localObject2 = this.pAl;
      Object localObject3 = paramBundle.Gak;
      p.g(localObject3, "it.jumpInfos");
      localObject3 = ((LinkedList)localObject3).getFirst();
      p.g(localObject3, "it.jumpInfos.first");
      ((z.f)localObject1).SYG = com.tencent.mm.plugin.textstatus.i.d.a((String)localObject2, (com.tencent.mm.plugin.textstatus.g.r)localObject3, (kotlin.g.a.a)new kotlin.g.b.q((z.f)localObject1) {});
      localObject1 = (View)((z.f)localObject1).SYG;
      if (localObject1 != null)
      {
        com.tencent.f.h.RTc.aV((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216500);
            TextStatusEditActivity.a(jdField_this.GeQ).setVisibility(0);
            View localView = this.tzy;
            FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
            localLayoutParams.width = at.aH((Context)jdField_this.GeQ.getContext(), 2131165296);
            localLayoutParams.height = at.aH((Context)jdField_this.GeQ.getContext(), 2131165296);
            localView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
            TextStatusEditActivity.a(jdField_this.GeQ).addView(this.tzy);
            AppMethodBeat.o(216500);
          }
        });
        AppMethodBeat.o(216501);
        return;
      }
      AppMethodBeat.o(216501);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class y
    implements View.OnClickListener
  {
    y(TextStatusEditActivity paramTextStatusEditActivity) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(216516);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      TextStatusEditActivity.a(this.GeQ, TextStatusEditActivity.b.GeO);
      paramView = this.GeQ.fwr();
      if (paramView != null) {
        paramView.requestFocus();
      }
      MMActivity.showVKB((Activity)this.GeQ);
      paramView = this.GeQ.GdW;
      if (paramView != null) {
        paramView.setOnClickListener((View.OnClickListener)new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            Object localObject1 = null;
            AppMethodBeat.i(216515);
            Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
            localObject2 = this.GeY.GeQ.FYe;
            int i;
            if (localObject2 != null)
            {
              paramAnonymousView = this.GeY.GeQ.fwr();
              if (paramAnonymousView != null)
              {
                paramAnonymousView = paramAnonymousView.getText();
                ((TextView)localObject2).setText((CharSequence)paramAnonymousView);
              }
            }
            else
            {
              localObject2 = this.GeY.GeQ.FYe;
              paramAnonymousView = localObject1;
              if (localObject2 != null) {
                paramAnonymousView = ((TextView)localObject2).getText();
              }
              if ((paramAnonymousView != null) && (!kotlin.n.n.aL(paramAnonymousView))) {
                break label207;
              }
              i = 1;
              label123:
              if (i == 0) {
                break label212;
              }
              paramAnonymousView = this.GeY.GeQ.FYe;
              if (paramAnonymousView != null) {
                paramAnonymousView.setVisibility(8);
              }
            }
            for (;;)
            {
              this.GeY.GeQ.hideVKB((View)this.GeY.GeQ.fwr());
              TextStatusEditActivity.a(this.GeY.GeQ, TextStatusEditActivity.b.GeN);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(216515);
              return;
              paramAnonymousView = null;
              break;
              label207:
              i = 0;
              break label123;
              label212:
              paramAnonymousView = this.GeY.GeQ.FYe;
              if (paramAnonymousView != null) {
                paramAnonymousView.setVisibility(0);
              }
            }
          }
        });
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusEditActivity$textClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(216516);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class z
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayout>
  {
    z(TextStatusEditActivity paramTextStatusEditActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity
 * JD-Core Version:    0.7.0.1
 */