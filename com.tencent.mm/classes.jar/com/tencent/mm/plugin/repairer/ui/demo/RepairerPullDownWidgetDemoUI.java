package com.tencent.mm.plugin.repairer.ui.demo;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.repairer.ui.BaseRepairerUI;
import com.tencent.mm.plugin.repairer.ui.b.c;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI;", "Lcom/tencent/mm/plugin/repairer/ui/BaseRepairerUI;", "()V", "btnOnPostClose", "Landroid/view/View;", "getBtnOnPostClose", "()Landroid/view/View;", "setBtnOnPostClose", "(Landroid/view/View;)V", "btnOnPostOpen", "getBtnOnPostOpen", "setBtnOnPostOpen", "btnOnPreClose", "getBtnOnPreClose", "setBtnOnPreClose", "btnOnPreOpen", "getBtnOnPreOpen", "setBtnOnPreOpen", "btnSetDemo", "getBtnSetDemo", "setBtnSetDemo", "btnSetFinder", "getBtnSetFinder", "btnSetFinder$delegate", "Lkotlin/Lazy;", "btnSetMusic", "getBtnSetMusic", "setBtnSetMusic", "ivBack", "Landroid/widget/ImageView;", "getIvBack", "()Landroid/widget/ImageView;", "setIvBack", "(Landroid/widget/ImageView;)V", "layoutContainer", "Landroid/widget/FrameLayout;", "getLayoutContainer", "()Landroid/widget/FrameLayout;", "setLayoutContainer", "(Landroid/widget/FrameLayout;)V", "pullDownBack", "Lcom/tencent/mm/ui/widget/IPullDownView;", "getPullDownBack", "()Lcom/tencent/mm/ui/widget/IPullDownView;", "setPullDownBack", "(Lcom/tencent/mm/ui/widget/IPullDownView;)V", "bindViewAndFakeData", "", "btn", "sourceId", "", "container", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "fakeFinderObjectInfo", "fakeMusicJumpInfo", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RepairerPullDownWidgetDemoUI
  extends BaseRepairerUI
{
  public FrameLayout Oxo;
  public View Oxp;
  public View Oxq;
  private final j Oxr;
  public View Oxs;
  public View Oxt;
  public View Oxu;
  public View Oxv;
  public ImageView Oxw;
  private com.tencent.mm.ui.widget.b Oxx;
  
  public RepairerPullDownWidgetDemoUI()
  {
    AppMethodBeat.i(278388);
    this.Oxr = k.cm((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(278388);
  }
  
  private static final void a(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI)
  {
    TextStatusJumpInfo localTextStatusJumpInfo = null;
    AppMethodBeat.i(278452);
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    Object localObject = new l();
    ((l)localObject).nDl = 0;
    ((l)localObject).ToO = 1;
    localObject = paramRepairerPullDownWidgetDemoUI.Oxp;
    if (localObject != null)
    {
      paramRepairerPullDownWidgetDemoUI.cLg();
      new TextStatusJumpInfo();
      paramRepairerPullDownWidgetDemoUI.iR((View)localObject);
      localObject = paramRepairerPullDownWidgetDemoUI.Oxq;
      if (localObject == null) {
        break label177;
      }
    }
    for (;;)
    {
      paramRepairerPullDownWidgetDemoUI.cLg();
      localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "1";
      localTextStatusJumpInfo.busiBuf = "<MusicVideoStatusOpenParams>\n<FinderMVSongInfo>\n    <songName>永不失联的爱（《小妖的金色城堡》戏剧主题曲）</songName>\n    <singer>周兴哲</singer>\n    <musicDataUrl>http://c6.y.qq.com/rsc/fcgi-bin/fcg_pyq_play.fcg?songid=&amp;songmid=004c4CEB3jfz7a&amp;songtype=1&amp;fromtag=46&amp;uin=414367047&amp;code=85A88</musicDataUrl>\n    <musicAppId>wx5aa333606550dfd5</musicAppId>\n    <musicWebUrl>https://i.y.qq.com/v8/playsong.html?platform=11&amp;appshare=android_qq&amp;appversion=10090506&amp;hosteuin=7e6PoiCloevl&amp;songmid=004c4CEB3jfz7a&amp;type=0&amp;appsongtype=1&amp;_wv=1&amp;source=weixin&amp;ADTAG=wxfshare</musicWebUrl>\n    <songId>qqmusic_202550561</songId>\n    <lyric>[ti:永不失联的爱&#x20;(原创概念版)&#x20;(《小妖的金色城堡》戏剧主题曲)]&#x0A;[ar:周兴哲]&#x0A;[al:永不失联的爱]&#x0A;[by:]&#x0A;[offset:0]&#x0A;[00:00.00]永不失联的爱&#x20;(Unbreakable&#x20;Love)&#x20;-&#x20;周兴哲&#x20;(Eric&#x20;Chou)&#x0A;[00:04.61]词：饶雪漫&#x0A;[00:09.22]曲：周兴哲&#x0A;[00:13.83]编曲：吕圣斐&#x0A;[00:18.44]制作人：袁伟翔/吕圣斐&#x0A;[00:23.05]亲爱的你躲在哪里发呆&#x0A;[00:27.31]&#x0A;[00:28.79]有什么心事还无法释怀&#x0A;[00:32.75]&#x0A;[00:34.37]我们总把人生想得太坏&#x0A;[00:38.23]&#x0A;[00:39.99]像旁人不允许我们的怪&#x0A;[00:44.09]&#x0A;[00:45.69]每一片与众不同的云彩&#x0A;[00:49.79]&#x0A;[00:51.38]都需要找到天空去存在&#x0A;[00:55.15]&#x0A;[00:56.96]我们都习惯了原地徘徊&#x0A;[01:01.18]&#x0A;[01:02.61]却无法习惯被依赖&#x0A;[01:07.05]&#x0A;[01:08.97]你给我&#x20;这一辈子都不想失联的爱&#x0A;[01:15.07]&#x0A;[01:15.60]相信爱的征途就是星辰大海&#x0A;[01:20.62]美好剧情&#x20;不会更改&#x0A;[01:25.82]是命运最好的安排&#x0A;[01:30.95]&#x0A;[01:31.50]你是我&#x0A;[01:33.30]这一辈子都不想失联的爱&#x0A;[01:37.55]&#x0A;[01:38.27]何苦残忍逼我把手轻轻放开&#x0A;[01:43.18]请快回来&#x20;想听你说&#x0A;[01:48.43]说你还在&#x0A;[01:51.75]&#x0A;[02:16.17]走过陪你看流星的天台&#x0A;[02:20.17]&#x0A;[02:21.71]熬过失去你漫长的等待&#x0A;[02:25.87]&#x0A;[02:27.36]好担心没人懂你的无奈&#x0A;[02:31.57]&#x0A;[02:32.97]离开我谁还把你当小孩&#x0A;[02:36.97]&#x0A;[02:38.79]我猜你一定也会想念我&#x0A;[02:42.81]&#x0A;[02:44.23]也怕我失落在茫茫人海&#x0A;[02:48.15]&#x0A;[02:49.90]没关系只要你肯回头望&#x0A;[02:54.05]&#x0A;[02:55.52]会发现我一直都在&#x0A;[03:00.34]&#x0A;[03:01.93]你给我&#x20;这一辈子都不想失联的爱&#x0A;[03:07.86]&#x0A;[03:08.77]你的每条讯息都是心跳节拍&#x0A;[03:13.55]每秒都想&#x20;拥你入怀&#x0A;[03:18.78]全世界你最可爱&#x0A;[03:23.87]&#x0A;[03:24.59]你是我&#x20;这一辈子都不想失联的爱&#x0A;[03:30.46]&#x0A;[03:31.08]就算你的呼吸远在千山之外&#x0A;[03:36.09]请你相信&#x20;我给的爱&#x0A;[03:41.35]值得你爱</lyric>\n    <albumName>如果雨之后</albumName>\n    <albumUrl>http://y.gtimg.cn/music/photo_new/T002R500x500M000003xoLyf0Xj3Oe_1.jpg</albumUrl>\n    <genre>Rock&#x20;摇滚</genre>\n    <publicTime></publicTime>\n    <publicTimeS>1513267200</publicTimeS>\n    <extraInfo></extraInfo>\n    <identification></identification>\n    <duration>259668</duration>\n</FinderMVSongInfo>\n<musicShareItem><mvObjectId>13537773606918162528</mvObjectId><mvNonceId>15477112920566613854</mvNonceId><mvCoverUrl>http://wxapp.tc.qq.com/251/20350/stodownload?encfilekey=XGocBFxVWK5dcyOOqpEU47RpBHQIvlhnZAn5bY8k59AkoMZb59VXcoicCFuH0s5rRCp5Z1h5hKiankTWKpgUx9ZibFQzPzclxLw4TX0HWicNo05LGEDUA4zrPSKKbUrH7Ldx8AuVNRpLeAo0RqQ97zykBSLemflAfuicgVZbiabVMjqlxlg4p3W4kLSQ&amp;adaptivelytrans=0&amp;bizid=1023&amp;dotrans=0&amp;hy=SH&amp;idx=1&amp;m=7764a411e365bbfe048f079b2d6ec8fe&amp;token=x5Y29zUxcibDL4kjgECWmgYIjC6afK7YsLITpOickQAibbibrd2icfwEBtuIlrLkGpqoN</mvCoverUrl><mvMakerFinderNickname>大型精分现场-</mvMakerFinderNickname><mvSingerName></mvSingerName><mvAlbumName></mvAlbumName><mvMusicGenre></mvMusicGenre><mvIssueDate>0</mvIssueDate><mvIdentification></mvIdentification><musicDuration>0</musicDuration><mvExtInfo>null</mvExtInfo></musicShareItem>\n</MusicVideoStatusOpenParams>";
      paramRepairerPullDownWidgetDemoUI.iR((View)localObject);
      localObject = (View)paramRepairerPullDownWidgetDemoUI.Oxr.getValue();
      paramRepairerPullDownWidgetDemoUI.cLg();
      localTextStatusJumpInfo = new TextStatusJumpInfo();
      localTextStatusJumpInfo.jumpType = "1";
      byte[] arrayOfByte = "{\"feedId\":\"13548507870956427363\",\"nickname\":\"搞笑的马姐姐\",\"mediaType\":4,\"mediaList\":[{\"mediaType\":4,\"url\":\"http:\\/\\/wxapp.tc.qq.com\\/251\\/20302\\/stodownload?encfilekey=RBfjicXSHKCOONJnTbRmmlD8cOQPXE48ibk28aQkWiaibPAGmnFwfiaicdHzFmC8Xib3lp8wQDcurfFsIeXsIrJOxZM3cgnjEIcGTrGJGFaibCribvBkJJR44jzK9rrQzfic57CbT848ojDEhMRdzxSqFkTmUP16TdvK0l6In2kibMNTKL2GkU&adaptivelytrans=0&bizid=1023&dotrans=770&hy=SH&idx=1&m=78f2191d4f3bc58cc1c3cada01d963a5&scene=0\",\"url_token\":\"&token=x5Y29zUxcibBS38aOqRFIQ87WbwiblzFWMZdS4fA6BXnzibn4thdqic58QmQ8OLUibHhwibMV4vg3Vuck\",\"thumbUrl\":\"http:\\/\\/wxapp.tc.qq.com\\/251\\/20304\\/stodownload?encfilekey=jEXicia3muM3GjTlk1Z3kYCefzc4VU4EASuOwDeckXh5Rug76ZL97cxCCpvaFtHBsGREKibHnyTyzttmgvYvrgVzfuXsoUl1hqyK7Vkna0qvyzo7icfnWniaahDQTGHlxQ4ACJsIFics7seddFBsjibc0N2iaiaibY1T3AA2AqR5dWUvforxA&adaptivelytrans=0&bizid=1023&dotrans=0&hy=SH&idx=1&m=38713687ec5f097bd8969a30b083fc46\",\"thumb_url_token\":\"&token=cztXnd9GyrHT1jF33iahtW5WKoMicnJlTUZCMdAJYQKoJ5W9KsBSCfBWd5dic7zQcCL\",\"decodeKey\":\"840422575\",\"width\":576,\"height\":1024,\"videoDuration\":20,\"mediaId\":\"finder_video_xV0_8d2f73ca02ea8d0128babfa43c63d7bc\",\"mediaPath\":\"\\/storage\\/emulated\\/0\\/Android\\/data\\/com.tencent.mm\\/MicroMsg\\/7ea3dbb6194e65c68e99b7065d4a74e8\\/finder\\/video\\/finder_video_xV0_8d2f73ca02ea8d0128babfa43c63d7bc\",\"fileFormat\":\"xV0\",\"thumbUrlToken\":\"&token=cztXnd9GyrHT1jF33iahtW5WKoMicnJlTUZCMdAJYQKoJ5W9KsBSCfBWd5dic7zQcCL\",\"thumbPath\":\"\\/storage\\/emulated\\/0\\/Android\\/data\\/com.tencent.mm\\/MicroMsg\\/7ea3dbb6194e65c68e99b7065d4a74e8\\/finder\\/image\\/finder_image_thumb_image_8d2f73ca02ea8d0128babfa43c63d7bc\"}]}".getBytes(d.UTF_8);
      s.s(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
      localTextStatusJumpInfo.busiBuf = Base64.encodeToString(arrayOfByte, 0, arrayOfByte.length, 0);
      paramRepairerPullDownWidgetDemoUI.iR((View)localObject);
      AppMethodBeat.o(278452);
      return;
      s.bIx("btnSetDemo");
      localObject = null;
      break;
      label177:
      s.bIx("btnSetMusic");
      localObject = localTextStatusJumpInfo;
    }
  }
  
  private static final void a(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI, View paramView)
  {
    AppMethodBeat.i(278467);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPullDownWidgetDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    paramRepairerPullDownWidgetDemoUI = paramRepairerPullDownWidgetDemoUI.Oxx;
    if (paramRepairerPullDownWidgetDemoUI != null) {
      paramRepairerPullDownWidgetDemoUI.etL();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278467);
  }
  
  private static final boolean a(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(278425);
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    paramRepairerPullDownWidgetDemoUI.finish();
    AppMethodBeat.o(278425);
    return true;
  }
  
  private static final void b(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI, View paramView)
  {
    AppMethodBeat.i(278478);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPullDownWidgetDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    paramRepairerPullDownWidgetDemoUI = paramRepairerPullDownWidgetDemoUI.Oxx;
    if (paramRepairerPullDownWidgetDemoUI != null) {
      paramRepairerPullDownWidgetDemoUI.etO();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278478);
  }
  
  private static final void c(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI, View paramView)
  {
    AppMethodBeat.i(278487);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPullDownWidgetDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    paramRepairerPullDownWidgetDemoUI = paramRepairerPullDownWidgetDemoUI.Oxx;
    if (paramRepairerPullDownWidgetDemoUI != null) {
      paramRepairerPullDownWidgetDemoUI.etM();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278487);
  }
  
  private FrameLayout cLg()
  {
    AppMethodBeat.i(278399);
    FrameLayout localFrameLayout = this.Oxo;
    if (localFrameLayout != null)
    {
      AppMethodBeat.o(278399);
      return localFrameLayout;
    }
    s.bIx("layoutContainer");
    AppMethodBeat.o(278399);
    return null;
  }
  
  private static final void d(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI, View paramView)
  {
    AppMethodBeat.i(278502);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPullDownWidgetDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    paramRepairerPullDownWidgetDemoUI = paramRepairerPullDownWidgetDemoUI.Oxx;
    if (paramRepairerPullDownWidgetDemoUI != null) {
      paramRepairerPullDownWidgetDemoUI.onPostClose();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278502);
  }
  
  private static final void e(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI, View paramView)
  {
    AppMethodBeat.i(278521);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRepairerPullDownWidgetDemoUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRepairerPullDownWidgetDemoUI, "this$0");
    aa.y((Context)paramRepairerPullDownWidgetDemoUI.getContext(), "已设置", 0);
    paramRepairerPullDownWidgetDemoUI.cLg().removeAllViews();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/repairer/ui/demo/RepairerPullDownWidgetDemoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(278521);
  }
  
  private final void iR(View paramView)
  {
    AppMethodBeat.i(278413);
    paramView.setOnClickListener(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda3(this));
    AppMethodBeat.o(278413);
  }
  
  public final int getLayoutId()
  {
    return b.d.OvA;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(278654);
    super.onCreate(paramBundle);
    setMMTitle("下拉背景Demo");
    setBackBtn(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda0(this));
    paramBundle = (FrameLayout)findViewById(b.c.Oum);
    s.u(paramBundle, "<set-?>");
    this.Oxo = paramBundle;
    setBtnSetDemo(findViewById(b.c.Oty));
    setBtnSetMusic(findViewById(b.c.OtA));
    setBtnOnPreOpen(findViewById(b.c.Otx));
    setBtnOnPostOpen(findViewById(b.c.Otv));
    setBtnOnPreClose(findViewById(b.c.Otw));
    setBtnOnPostClose(findViewById(b.c.Otu));
    paramBundle = (ImageView)findViewById(b.c.Oud);
    s.u(paramBundle, "<set-?>");
    this.Oxw = paramBundle;
    h.ahAA.bk(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda6(this));
    paramBundle = this.Oxs;
    label191:
    label212:
    label233:
    com.tencent.mm.modelimage.loader.a locala;
    if (paramBundle != null)
    {
      paramBundle.setOnClickListener(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda1(this));
      paramBundle = this.Oxt;
      if (paramBundle == null) {
        break label284;
      }
      paramBundle.setOnClickListener(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda5(this));
      paramBundle = this.Oxu;
      if (paramBundle == null) {
        break label295;
      }
      paramBundle.setOnClickListener(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda4(this));
      paramBundle = this.Oxv;
      if (paramBundle == null) {
        break label306;
      }
      paramBundle.setOnClickListener(new RepairerPullDownWidgetDemoUI..ExternalSyntheticLambda2(this));
      locala = r.bKe();
      paramBundle = this.Oxw;
      if (paramBundle == null) {
        break label317;
      }
    }
    for (;;)
    {
      locala.loadImage("https://www.dasouji.com/wp-content/uploads/2019/08/@93kumi93-5.jpg", paramBundle);
      AppMethodBeat.o(278654);
      return;
      s.bIx("btnOnPreOpen");
      paramBundle = null;
      break;
      label284:
      s.bIx("btnOnPostOpen");
      paramBundle = null;
      break label191;
      label295:
      s.bIx("btnOnPreClose");
      paramBundle = null;
      break label212;
      label306:
      s.bIx("btnOnPostClose");
      paramBundle = null;
      break label233;
      label317:
      s.bIx("ivBack");
      paramBundle = localObject;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setBtnOnPostClose(View paramView)
  {
    AppMethodBeat.i(278647);
    s.u(paramView, "<set-?>");
    this.Oxv = paramView;
    AppMethodBeat.o(278647);
  }
  
  public final void setBtnOnPostOpen(View paramView)
  {
    AppMethodBeat.i(278638);
    s.u(paramView, "<set-?>");
    this.Oxt = paramView;
    AppMethodBeat.o(278638);
  }
  
  public final void setBtnOnPreClose(View paramView)
  {
    AppMethodBeat.i(278643);
    s.u(paramView, "<set-?>");
    this.Oxu = paramView;
    AppMethodBeat.o(278643);
  }
  
  public final void setBtnOnPreOpen(View paramView)
  {
    AppMethodBeat.i(278634);
    s.u(paramView, "<set-?>");
    this.Oxs = paramView;
    AppMethodBeat.o(278634);
  }
  
  public final void setBtnSetDemo(View paramView)
  {
    AppMethodBeat.i(278627);
    s.u(paramView, "<set-?>");
    this.Oxp = paramView;
    AppMethodBeat.o(278627);
  }
  
  public final void setBtnSetMusic(View paramView)
  {
    AppMethodBeat.i(278633);
    s.u(paramView, "<set-?>");
    this.Oxq = paramView;
    AppMethodBeat.o(278633);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Button>
  {
    a(RepairerPullDownWidgetDemoUI paramRepairerPullDownWidgetDemoUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.RepairerPullDownWidgetDemoUI
 * JD-Core Version:    0.7.0.1
 */