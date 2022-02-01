package com.tencent.mm.plugin.teenmode.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.e;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ctk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.g.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/ui/BindGuardianUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeDataChangedListener;", "()V", "bindBtn", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "getBindBtn", "()Landroid/widget/Button;", "bindBtn$delegate", "Lkotlin/Lazy;", "guardianContact", "Lcom/tencent/mm/storage/Contact;", "unbindBtn", "getUnbindBtn", "unbindBtn$delegate", "getLayoutId", "", "hideErrorTip", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDataChanged", "onDestroy", "pickNewPerson", "showErrorTip", "errMsg", "", "unbind", "updateView", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class BindGuardianUI
  extends MMActivity
  implements com.tencent.mm.plugin.teenmode.a.g
{
  public static final BindGuardianUI.a Tah;
  private final j SZT;
  private final j Tai;
  private au Taj;
  
  static
  {
    AppMethodBeat.i(279398);
    Tah = new BindGuardianUI.a((byte)0);
    AppMethodBeat.o(279398);
  }
  
  public BindGuardianUI()
  {
    AppMethodBeat.i(279315);
    this.SZT = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Tai = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Taj = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
    AppMethodBeat.o(279315);
  }
  
  private final void Df(String paramString)
  {
    AppMethodBeat.i(279332);
    TextView localTextView = (TextView)findViewById(a.d.error_tip);
    localTextView.setVisibility(0);
    if (paramString == null)
    {
      paramString = getString(a.g.app_err_server_busy_tip);
      s.s(paramString, "getString(R.string.app_err_server_busy_tip)");
    }
    for (;;)
    {
      localTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(279332);
      return;
    }
  }
  
  private static final ah a(com.tencent.mm.ui.base.w paramw, BindGuardianUI paramBindGuardianUI, b.a parama)
  {
    AppMethodBeat.i(279392);
    s.u(paramBindGuardianUI, "this$0");
    paramw.dismiss();
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      paramw = paramBindGuardianUI.Taj;
      s.checkNotNull(paramw);
      paramw = ab.Jg(paramw.field_username);
      paramw.setType(paramw.field_type & (com.tencent.mm.contact.d.aSB() ^ 0xFFFFFFFF));
      ab.O(paramw);
      com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)BindGuardianUI.f.Tam);
    }
    for (;;)
    {
      paramw = ah.aiuX;
      AppMethodBeat.o(279392);
      return paramw;
      paramBindGuardianUI.Df(parama.errMsg);
    }
  }
  
  private static final ah a(com.tencent.mm.ui.base.w paramw, BindGuardianUI paramBindGuardianUI, String paramString, b.a parama)
  {
    AppMethodBeat.i(279387);
    s.u(paramBindGuardianUI, "this$0");
    paramw.dismiss();
    if ((parama.errCode == 0) && (parama.errType == 0))
    {
      paramw = new com.tencent.mm.plugin.finder.view.custom.dialog.a.a((Context)paramBindGuardianUI);
      paramw.fI(paramString).aCJ(s.X(paramBindGuardianUI.getString(a.g.teen_mode_authorization_prefix), paramBindGuardianUI.getString(a.g.SXi))).x(Boolean.TRUE).UL(a.g.app_send);
      paramw.a(new BindGuardianUI..ExternalSyntheticLambda4(paramBindGuardianUI, paramString, parama));
      paramw.pRv.show();
    }
    for (;;)
    {
      paramw = ah.aiuX;
      AppMethodBeat.o(279387);
      return paramw;
      paramBindGuardianUI.Df(parama.errMsg);
    }
  }
  
  private static final void a(Button paramButton, BindGuardianUI paramBindGuardianUI, View paramView)
  {
    AppMethodBeat.i(279370);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramButton);
    localb.cH(paramBindGuardianUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/BindGuardianUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBindGuardianUI, "this$0");
    paramView = new g.a(paramButton.getContext());
    paramView.bf((CharSequence)paramBindGuardianUI.getString(a.g.SXl)).bDE(paramBindGuardianUI.getString(a.g.SXk)).aEX(a.g.SXm).aEY(paramButton.getContext().getResources().getColor(com.tencent.mm.plugin.teenmode.a.a.red_text_color));
    paramView.c(new BindGuardianUI..ExternalSyntheticLambda5(paramBindGuardianUI)).show();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/BindGuardianUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279370);
  }
  
  private static final void a(BindGuardianUI paramBindGuardianUI, View paramView)
  {
    AppMethodBeat.i(279359);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBindGuardianUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/BindGuardianUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBindGuardianUI, "this$0");
    paramView = new Intent();
    paramView.putExtra("list_attr", com.tencent.mm.ui.contact.w.ow(com.tencent.mm.ui.contact.w.affo, 64));
    paramView.putExtra("list_type", 1);
    paramView.putExtra("titile", paramBindGuardianUI.getString(a.g.SXb));
    paramView.putExtra("show_too_many_member", false);
    paramView.putExtra("without_openim", true);
    paramView.putExtra("scene", 6);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(z.bAM());
    paramView.putExtra("block_contact", p.a((Iterable)localObject, (CharSequence)",", null, null, 0, null, (kotlin.g.a.b)BindGuardianUI.e.Tal, 30));
    com.tencent.mm.br.c.d((Context)paramBindGuardianUI, ".ui.contact.SelectContactUI", paramView, 101);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/BindGuardianUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279359);
  }
  
  private static final void a(BindGuardianUI paramBindGuardianUI, String paramString1, b.a parama, boolean paramBoolean, String paramString2, int paramInt)
  {
    AppMethodBeat.i(279383);
    s.u(paramBindGuardianUI, "this$0");
    if (paramBoolean)
    {
      k.b localb = new k.b();
      localb.title = paramBindGuardianUI.getString(a.g.SXi);
      localb.description = paramBindGuardianUI.getString(a.g.SXe);
      localb.username = paramString1;
      localb.type = 83;
      localb.url = "https://support.weixin.qq.com/update/";
      localb.thumburl = "http://wxapp.tc.qq.com/251/20304/stodownload?m=adb36df21d075a4c2148a2c0fc361304&filekey=30450201010420301e020200fb0402535a0410adb36df21d075a4c2148a2c0fc3613040202188a041e000000046274667300000001310000000861707073746f72650000000131&hy=SZ&storeid=32303231303932383030353631353030303362636238303062633631346565633763333930613030303030306662&dotrans=0&sourceflag=1&bizid=1023&adaptivelytrans=0";
      com.tencent.mm.message.a.c localc = new com.tencent.mm.message.a.c();
      localc.nVG = ((ctk)parama.ott).Njp;
      localb.a((com.tencent.mm.message.f)localc);
      w.a.bwq().a(localb, "", "", paramString1, "", null);
      ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a((Context)paramBindGuardianUI.getContext(), paramString1, z.bAM(), ((ctk)parama.ott).Njp, cn.bDu());
      parama = (CharSequence)paramString2;
      if ((parama != null) && (!n.bp(parama))) {
        break label235;
      }
    }
    label235:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        com.tencent.mm.plugin.messenger.a.g.gaI().ap(paramString1, paramString2, ab.IX(paramString1));
      }
      com.tencent.mm.ae.d.a(200L, (kotlin.g.a.a)new c(paramBindGuardianUI));
      AppMethodBeat.o(279383);
      return;
    }
  }
  
  private static final void a(BindGuardianUI paramBindGuardianUI, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(279364);
    s.u(paramBindGuardianUI, "this$0");
    if (paramBoolean)
    {
      paramString = com.tencent.mm.ui.base.k.a((Context)paramBindGuardianUI, paramBindGuardianUI.getContext().getString(a.g.loading_tips_1), false, null);
      paramString.show();
      paramBindGuardianUI.hEY();
      Object localObject = paramBindGuardianUI.Taj;
      s.checkNotNull(localObject);
      localObject = ((az)localObject).field_username;
      s.s(localObject, "guardianContact!!.username");
      new com.tencent.mm.plugin.teenmode.b.h((String)localObject).bFJ().a((com.tencent.mm.vending.e.b)paramBindGuardianUI).b(new BindGuardianUI..ExternalSyntheticLambda6(paramString, paramBindGuardianUI));
    }
    AppMethodBeat.o(279364);
  }
  
  private static final boolean a(BindGuardianUI paramBindGuardianUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(279345);
    s.u(paramBindGuardianUI, "this$0");
    paramBindGuardianUI.finish();
    AppMethodBeat.o(279345);
    return true;
  }
  
  private static final void b(BindGuardianUI paramBindGuardianUI, View paramView)
  {
    AppMethodBeat.i(279377);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramBindGuardianUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/teenmode/ui/BindGuardianUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBindGuardianUI, "this$0");
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a((Activity)paramBindGuardianUI, 101, 2147483647, s.X("just_test_key", Long.valueOf(System.currentTimeMillis())), "JustTitle", "Just Digest", "\n                        <msg><appmsg appid=\"\" sdkver=\"0\"><title>美团跑腿</title><des></des><username></username><action>view</action><type>0</type><showtype>0</showtype><content></content><url></url><lowurl></lowurl><forwardflag>0</forwardflag><dataurl></dataurl><lowdataurl></lowdataurl><contentattr>0</contentattr><streamvideo><streamvideourl></streamvideourl><streamvideototaltime>0</streamvideototaltime><streamvideotitle></streamvideotitle><streamvideowording></streamvideowording><streamvideoweburl></streamvideoweburl><streamvideothumburl></streamvideothumburl><streamvideoaduxinfo></streamvideoaduxinfo><streamvideopublishid></streamvideopublishid></streamvideo><canvasPageItem><canvasPageXml><![CDATA[]]></canvasPageXml></canvasPageItem><appattach><totallen>0</totallen><attachid></attachid><cdnattachurl></cdnattachurl><emoticonmd5></emoticonmd5><aeskey></aeskey><fileext></fileext><islargefilemsg>0</islargefilemsg></appattach><extinfo></extinfo><androidsource>0</androidsource><thumburl>http://wx.qlogo.cn/mmhead/Q3auHgzwzM5LS29rtX6tAvwm43zm5fkoMRiabdOp2pMBe00bZLZxvFg/96</thumburl><mediatagname></mediatagname><messageaction><![CDATA[]]></messageaction><messageext><![CDATA[]]></messageext><emoticongift><packageflag>0</packageflag><packageid></packageid></emoticongift><emoticonshared><packageflag>0</packageflag><packageid></packageid></emoticonshared><designershared><designeruin>0</designeruin><designername>null</designername><designerrediretcturl>null</designerrediretcturl></designershared><emotionpageshared><tid>0</tid><title>null</title><desc>null</desc><iconUrl>null</iconUrl><secondUrl>null</secondUrl><pageType>0</pageType></emotionpageshared><webviewshared><shareUrlOriginal></shareUrlOriginal><shareUrlOpen></shareUrlOpen><jsAppId></jsAppId><publisherId></publisherId></webviewshared><template_id></template_id><md5></md5><weappinfo><username>gh_c043a7a7fc9e@app</username><appid>wx84d3c06952bb4072</appid><version>178</version><appservicetype>0</appservicetype><secflagforsinglepagemode>0</secflagforsinglepagemode><videopageinfo><thumbwidth>0</thumbwidth><thumbheight>0</thumbheight><fromopensdk>0</fromopensdk></videopageinfo></weappinfo><statextstr></statextstr><musicShareItem><musicDuration>0</musicDuration></musicShareItem><finderLiveProductShare><finderLiveID></finderLiveID><finderUsername></finderUsername><finderObjectID></finderObjectID><finderNonceID></finderNonceID><liveStatus></liveStatus><appId></appId><pagePath></pagePath><productId></productId><coverUrl></coverUrl><productTitle></productTitle><marketPrice><![CDATA[0]]></marketPrice><sellingPrice><![CDATA[0]]></sellingPrice><platformHeadImg></platformHeadImg><platformName></platformName><shopWindowId></shopWindowId></finderLiveProductShare><findernamecard><username></username><avatar><![CDATA[]]></avatar><nickname></nickname><auth_job></auth_job><auth_icon>0</auth_icon><auth_icon_url></auth_icon_url></findernamecard><finderGuarantee><scene><![CDATA[0]]></scene></finderGuarantee><directshare>0</directshare><gamecenter><namecard><iconUrl></iconUrl><name></name><desc></desc><tail></tail><jumpUrl></jumpUrl></namecard></gamecenter><patMsg><chatUser></chatUser><records><recordNum>0</recordNum></records></patMsg><secretmsg><issecretmsg>0</issecretmsg></secretmsg><websearch><rec_category>0</rec_category><channelId>0</channelId></websearch></appmsg></msg>\n                        ", true, null);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/teenmode/ui/BindGuardianUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(279377);
  }
  
  private final Button hES()
  {
    AppMethodBeat.i(279320);
    Button localButton = (Button)this.SZT.getValue();
    AppMethodBeat.o(279320);
    return localButton;
  }
  
  private final Button hEX()
  {
    AppMethodBeat.i(279324);
    Button localButton = (Button)this.Tai.getValue();
    AppMethodBeat.o(279324);
    return localButton;
  }
  
  private final void hEY()
  {
    AppMethodBeat.i(279337);
    ((TextView)findViewById(a.d.error_tip)).setVisibility(8);
    AppMethodBeat.o(279337);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.e.SWv;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(279443);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 101) && (paramInt2 == -1) && (paramIntent != null))
    {
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      Object localObject = (CharSequence)paramIntent;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
      for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0)
      {
        AppMethodBeat.o(279443);
        return;
      }
      localObject = com.tencent.mm.ui.base.k.a((Context)this, getContext().getString(a.g.loading_tips_1), false, null);
      ((com.tencent.mm.ui.base.w)localObject).show();
      hEY();
      s.checkNotNull(paramIntent);
      new com.tencent.mm.plugin.teenmode.b.g(paramIntent).bFJ().a((com.tencent.mm.vending.e.b)this).b(new BindGuardianUI..ExternalSyntheticLambda7((com.tencent.mm.ui.base.w)localObject, this, paramIntent));
    }
    AppMethodBeat.o(279443);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279432);
    super.onCreate(paramBundle);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.teenmode.a.a.white));
    setBackBtn(new BindGuardianUI..ExternalSyntheticLambda0(this));
    updateView();
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a((com.tencent.mm.plugin.teenmode.a.g)this);
    AppMethodBeat.o(279432);
  }
  
  public final void onDataChanged()
  {
    AppMethodBeat.i(279446);
    this.Taj = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).hEu();
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(279446);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279435);
    ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).b((com.tencent.mm.plugin.teenmode.a.g)this);
    super.onDestroy();
    AppMethodBeat.o(279435);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void updateView()
  {
    AppMethodBeat.i(279441);
    Object localObject2;
    if (this.Taj == null)
    {
      localObject1 = hES();
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new BindGuardianUI..ExternalSyntheticLambda2(this));
      if (this.Taj == null) {
        break label250;
      }
      localObject2 = (TextView)findViewById(a.d.desc);
      int i = a.g.SXc;
      localObject1 = this.Taj;
      if (localObject1 != null) {
        break label226;
      }
      localObject1 = null;
      label68:
      ((TextView)localObject2).setText((CharSequence)getString(i, new Object[] { localObject1 }));
      ((LinearLayout)findViewById(a.d.SVu)).setVisibility(0);
      localObject2 = (ImageView)findViewById(a.d.SVJ);
      localObject1 = this.Taj;
      if (localObject1 != null) {
        break label234;
      }
      localObject1 = null;
      label124:
      a.b.g((ImageView)localObject2, (String)localObject1);
      localObject2 = (TextView)findViewById(a.d.SVM);
      localObject1 = this.Taj;
      if (localObject1 != null) {
        break label242;
      }
    }
    label226:
    label234:
    label242:
    for (Object localObject1 = null;; localObject1 = ((au)localObject1).aSV())
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      if (!BuildInfo.DEBUG) {
        break label296;
      }
      localObject1 = (TextView)findViewById(a.d.SWh);
      ((TextView)localObject1).setVisibility(0);
      ((TextView)localObject1).setOnClickListener(new BindGuardianUI..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(279441);
      return;
      localObject1 = hEX();
      ((Button)localObject1).setVisibility(0);
      ((Button)localObject1).setOnClickListener(new BindGuardianUI..ExternalSyntheticLambda1((Button)localObject1, this));
      break;
      localObject1 = ((au)localObject1).aSV();
      break label68;
      localObject1 = ((az)localObject1).field_username;
      break label124;
    }
    label250:
    ((TextView)findViewById(a.d.desc)).setText(a.g.SXj);
    ((LinearLayout)findViewById(a.d.SVu)).setVisibility(8);
    ((TextView)findViewById(a.d.SWh)).setVisibility(8);
    label296:
    AppMethodBeat.o(279441);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(BindGuardianUI paramBindGuardianUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(BindGuardianUI paramBindGuardianUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(BindGuardianUI paramBindGuardianUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<Button>
  {
    g(BindGuardianUI paramBindGuardianUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.ui.BindGuardianUI
 * JD-Core Version:    0.7.0.1
 */