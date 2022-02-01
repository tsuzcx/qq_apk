package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.i.a.ak;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.a.k;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m.a;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bottomMask", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBottomMask", "()Landroid/view/View;", "bottomMask$delegate", "Lkotlin/Lazy;", "collapseButton", "getCollapseButton", "collapseButton$delegate", "collapseLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "getCollapseLayout", "()Lcom/tencent/mm/ui/blur/BlurView;", "collapseLayout$delegate", "copyrightFromTv", "Landroid/widget/TextView;", "getCopyrightFromTv", "()Landroid/widget/TextView;", "copyrightFromTv$delegate", "copyrightInfoLayout", "getCopyrightInfoLayout", "()Landroid/view/ViewGroup;", "copyrightInfoLayout$delegate", "copyrightIv", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getCopyrightIv", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "copyrightIv$delegate", "coverIv", "Lcom/tencent/mm/ui/MMImageView;", "getCoverIv", "()Lcom/tencent/mm/ui/MMImageView;", "coverIv$delegate", "defaultCoverIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getDefaultCoverIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "defaultCoverIv$delegate", "dialogRootLayout", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getDialogRootLayout", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "dialogRootLayout$delegate", "effector", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvBitmapEffector;", "isShow", "", "layoutHeight", "", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutWidth", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getParent", "singerTv", "getSingerTv", "singerTv$delegate", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoFullScreenRoot", "getSongInfoFullScreenRoot", "songInfoFullScreenRoot$delegate", "songNameTv", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "getSongNameTv", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "songNameTv$delegate", "specialInfoLayout", "getSpecialInfoLayout", "specialInfoLayout$delegate", "specialInfoTv", "getSpecialInfoTv", "specialInfoTv$delegate", "statusButton", "Landroid/widget/Button;", "getStatusButton", "()Landroid/widget/Button;", "statusButton$delegate", "statusButtonBlurLayout", "getStatusButtonBlurLayout", "statusButtonBlurLayout$delegate", "topGradientMask", "getTopGradientMask", "topGradientMask$delegate", "verifyInfo", "", "getDate", "hide", "", "passParameters", "reset", "show", "updateMv", "Companion", "plugin-mv_release"})
@SuppressLint({"ResourceType"})
public final class f
{
  public static final a AyX;
  public static final String TAG;
  public axy Aqo;
  private final kotlin.f AyF;
  private final kotlin.f AyG;
  private final kotlin.f AyH;
  private final kotlin.f AyI;
  private final kotlin.f AyJ;
  private final kotlin.f AyK;
  private final kotlin.f AyL;
  private final kotlin.f AyM;
  private final kotlin.f AyN;
  public final kotlin.f AyO;
  private final kotlin.f AyP;
  private final kotlin.f AyQ;
  private final kotlin.f AyR;
  private final kotlin.f AyS;
  private final kotlin.f AyT;
  private final kotlin.f AyU;
  private final kotlin.f AyV;
  private b AyW;
  public e Ayc;
  public boolean dEF;
  public String fuN;
  public final ViewGroup parent;
  private int uZu;
  public int uZv;
  
  static
  {
    AppMethodBeat.i(257654);
    AyX = new a((byte)0);
    TAG = "MicroMsg.Mv.MusicMvSongInfoDialog@" + AyX.hashCode();
    AppMethodBeat.o(257654);
  }
  
  public f(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(257653);
    this.parent = paramViewGroup;
    this.AyF = kotlin.g.ah((kotlin.g.a.a)new o(this));
    this.AyG = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.AyH = kotlin.g.ah((kotlin.g.a.a)new b(this));
    this.AyI = kotlin.g.ah((kotlin.g.a.a)new u(this));
    this.AyJ = kotlin.g.ah((kotlin.g.a.a)new p(this));
    this.AyK = kotlin.g.ah((kotlin.g.a.a)new n(this));
    this.AyL = kotlin.g.ah((kotlin.g.a.a)new h(this));
    this.AyM = kotlin.g.ah((kotlin.g.a.a)new i(this));
    this.AyN = kotlin.g.ah((kotlin.g.a.a)new q(this));
    this.AyO = kotlin.g.ah((kotlin.g.a.a)new r(this));
    this.AyP = kotlin.g.ah((kotlin.g.a.a)new t(this));
    this.AyQ = kotlin.g.ah((kotlin.g.a.a)new s(this));
    this.AyR = kotlin.g.ah((kotlin.g.a.a)new f(this));
    this.AyS = kotlin.g.ah((kotlin.g.a.a)new g(this));
    this.AyT = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.AyU = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.AyV = kotlin.g.ah((kotlin.g.a.a)new c(this));
    int i = com.tencent.mm.cb.a.aG(this.parent.getContext(), 2131165290);
    paramViewGroup = ao.gx(this.parent.getContext());
    i = paramViewGroup.x + i;
    Object localObject1 = ewB();
    p.g(localObject1, "dialogRootLayout");
    localObject1 = ((RoundCornerRelativeLayout)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).height = i;
    Object localObject2 = ewB();
    p.g(localObject2, "dialogRootLayout");
    ((RoundCornerRelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    float f = com.tencent.mm.cb.a.fromDPToPix(this.parent.getContext(), 24);
    ewB().s(0.0F, 0.0F, f, f);
    this.uZv = i;
    this.uZu = paramViewGroup.x;
    ewJ().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(257614);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        paramAnonymousView = com.tencent.mm.ui.component.a.PRN;
        paramAnonymousView = this.AyY.parent.getContext();
        p.g(paramAnonymousView, "parent.context");
        paramAnonymousView = ((MusicMvDataUIC)com.tencent.mm.ui.component.a.ko(paramAnonymousView).get(MusicMvDataUIC.class)).Aqo;
        localObject1 = com.tencent.mm.ui.component.a.PRN;
        localObject1 = this.AyY.parent.getContext();
        p.g(localObject1, "parent.context");
        ((MusicMvMainUIC)com.tencent.mm.ui.component.a.ko((Context)localObject1).get(MusicMvMainUIC.class)).c(paramAnonymousView);
        localObject1 = f.g(this.AyY);
        if ((paramAnonymousView != null) && (localObject1 != null))
        {
          Object localObject2 = k.Aql;
          localObject2 = this.AyY.parent.getContext();
          p.g(localObject2, "parent.context");
          k.a((Context)localObject2, paramAnonymousView, (e)localObject1, 2);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257614);
      }
    });
    localObject1 = ewA();
    p.g(localObject1, "songInfoFullScreenRoot");
    ((ViewGroup)localObject1).setVisibility(8);
    localObject1 = ewB();
    p.g(localObject1, "dialogRootLayout");
    ((RoundCornerRelativeLayout)localObject1).setTranslationY(-1.0F * this.uZv);
    Log.i(TAG, "init layout height:" + i + ", screenSize:" + paramViewGroup);
    paramViewGroup = ewG();
    p.g(paramViewGroup, "coverIv");
    paramViewGroup = paramViewGroup.getDrawable();
    localObject1 = ewH();
    if (localObject1 != null) {
      ((BlurView)localObject1).L((ViewGroup)ewB()).F(paramViewGroup).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(((BlurView)localObject1).getContext())).cw(30.0F).gMr().cv(com.tencent.mm.cb.a.aG(((BlurView)localObject1).getContext(), 2131165314)).gMs().alW(Color.parseColor("#61D2D2D2"));
    }
    localObject1 = ewM();
    if (localObject1 != null) {
      ((BlurView)localObject1).L((ViewGroup)ewB()).F(paramViewGroup).b((com.tencent.mm.ui.blur.b)new com.tencent.mm.ui.blur.f(((BlurView)localObject1).getContext())).cw(50.0F).gMr().cv(com.tencent.mm.cb.a.aG(((BlurView)localObject1).getContext(), 2131165314)).gMs().alW(Color.parseColor("#61D2D2D2"));
    }
    paramViewGroup = ewD();
    p.g(paramViewGroup, "topGradientMask");
    paramViewGroup = paramViewGroup.getLayoutParams();
    paramViewGroup.height = ((int)(this.uZv * 0.3D));
    localObject1 = ewD();
    p.g(localObject1, "topGradientMask");
    ((View)localObject1).setLayoutParams(paramViewGroup);
    paramViewGroup = ewC();
    p.g(paramViewGroup, "bottomMask");
    paramViewGroup.setAlpha(0.0F);
    ewI().setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(257615);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        axy localaxy = f.i(this.AyY);
        e locale = f.g(this.AyY);
        Object localObject3 = f.h(this.AyY);
        i locali;
        label253:
        Activity localActivity;
        label256:
        m.a locala;
        r localr;
        StringBuilder localStringBuilder;
        Object localObject2;
        if ((localaxy != null) && (locale != null) && (localObject3 != null))
        {
          paramAnonymousView = localaxy.Djf;
          localObject1 = (CharSequence)paramAnonymousView;
          int i;
          if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
          {
            i = 1;
            if (i == 0) {
              break label253;
            }
          }
          for (;;)
          {
            try
            {
              localObject1 = com.tencent.mm.plugin.mv.ui.a.ArA;
              localObject1 = com.tencent.mm.plugin.mv.ui.a.aIo("DEFAULT_TEXT_STATUS_MUSIC_THUMB_PATH");
              if (s.YS((String)localObject1)) {
                break label253;
              }
              localObject4 = this.AyY.parent.getContext();
              p.g(localObject4, "parent.context");
              BitmapUtil.saveBitmapToImage(BitmapFactory.decodeResource(((Context)localObject4).getResources(), 2131235278), 100, Bitmap.CompressFormat.PNG, (String)localObject1, true);
              paramAnonymousView = (View)localObject1;
              locali = (i)com.tencent.mm.kernel.g.af(i.class);
              localObject1 = this.AyY.parent.getContext();
              if (localObject1 != null) {
                break label256;
              }
              paramAnonymousView = new t("null cannot be cast to non-null type android.app.Activity");
              AppMethodBeat.o(257615);
              throw paramAnonymousView;
            }
            catch (Exception localException)
            {
              Log.e(f.access$getTAG$cp(), "save default text status thumb fail! " + localException.getLocalizedMessage());
            }
            i = 0;
            break;
          }
          localActivity = (Activity)localException;
          locala = new m.a().aSY("1016").aTa(paramAnonymousView).aTb("music_player@inner").aTe(localaxy.BPc).aTc(localaxy.AqO).aTd((String)localObject3);
          localr = new r();
          localr.GaO = "1";
          p.h(localaxy, "songInfo");
          p.h(locale, "musicMv");
          paramAnonymousView = new StringBuilder("\n<MusicVideoStatusOpenParams>\n");
          p.h(localaxy, "$this$toXml");
          localStringBuilder = paramAnonymousView.append(n.buv("<FinderMVSongInfo>\n    <songName>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.BPc) + "</songName>\n    <singer>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.lDR) + "</singer>\n    <musicDataUrl>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.musicDataUrl) + "</musicDataUrl>\n    <musicAppId>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.LIf) + "</musicAppId>\n    <musicWebUrl>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.LIg) + "</musicWebUrl>\n    <songId>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.AqO) + "</songId>\n    <lyric>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.LIh) + "</lyric>\n    <albumName>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.albumName) + "</albumName>\n    <albumUrl>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.Djf) + "</albumUrl>\n    <genre>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.LIi) + "</genre>\n    <publicTime>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.LIj) + "</publicTime>\n    <publicTimeS>" + com.tencent.mm.plugin.mv.ui.a.d.dG(Long.valueOf(localaxy.LIk)) + "</publicTimeS>\n    <extraInfo>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.extraInfo) + "</extraInfo>\n    <identification>" + com.tencent.mm.plugin.mv.ui.a.d.dG(localaxy.identification) + "</identification>\n    <duration>" + localaxy.duration + "</duration>\n</FinderMVSongInfo>\n")).append('\n');
          localObject2 = localaxy.Djf;
          p.h(locale, "$this$toXml");
          p.h(locale, "$this$toMusicShareObject");
          if (locale.ApM != 1) {
            break label889;
          }
          localObject3 = locale.ApE;
          paramAnonymousView = locale.ApF;
          if ((localObject3 == null) || (paramAnonymousView == null)) {
            break label1052;
          }
          long l = ((Number)localObject3).longValue();
          if (l == 0L) {
            break label1057;
          }
          localObject3 = new css();
          ((css)localObject3).Ktn = com.tencent.mm.ac.d.zs(l);
          ((css)localObject3).Kto = paramAnonymousView;
          Object localObject4 = locale.coverUrl;
          paramAnonymousView = (View)localObject4;
          if (localObject4 == null) {
            paramAnonymousView = (View)localObject2;
          }
          ((css)localObject3).Ktp = paramAnonymousView;
          ((css)localObject3).Ktq = locale.ApG;
          paramAnonymousView = (View)localObject3;
        }
        for (;;)
        {
          localObject2 = paramAnonymousView;
          if (paramAnonymousView == null) {
            localObject2 = new css();
          }
          paramAnonymousView = ak.a((css)localObject2);
          p.g(paramAnonymousView, "MusicMvShareParser.makeC…sicShareObject(albumUrl))");
          localr.GaQ = n.buv(paramAnonymousView + "\n</MusicVideoStatusOpenParams>");
          locali.a(localActivity, locala.hE(j.listOf(localr)).fvy().fvz());
          paramAnonymousView = k.Aql;
          paramAnonymousView = this.AyY.parent.getContext();
          p.g(paramAnonymousView, "parent.context");
          k.a(paramAnonymousView, localaxy, locale, 3);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(257615);
          return;
          label889:
          if (locale.ApM == 4)
          {
            localObject3 = locale.ApP;
            if (localObject3 != null)
            {
              localObject2 = new css();
              ((css)localObject2).Ktn = com.tencent.mm.ac.d.zs(((FinderObject)localObject3).id);
              ((css)localObject2).Kto = ((FinderObject)localObject3).objectNonceId;
              paramAnonymousView = ((FinderObject)localObject3).objectDesc;
              if (paramAnonymousView != null)
              {
                paramAnonymousView = paramAnonymousView.media;
                if (paramAnonymousView != null)
                {
                  paramAnonymousView = (FinderMedia)j.kt((List)paramAnonymousView);
                  if (paramAnonymousView == null) {}
                }
              }
              for (paramAnonymousView = paramAnonymousView.thumbUrl + paramAnonymousView.thumb_url_token;; paramAnonymousView = null)
              {
                ((css)localObject2).Ktp = paramAnonymousView;
                paramAnonymousView = ((FinderObject)localObject3).contact;
                if (paramAnonymousView != null)
                {
                  localObject3 = paramAnonymousView.nickname;
                  paramAnonymousView = (View)localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  paramAnonymousView = "";
                }
                ((css)localObject2).Ktq = paramAnonymousView;
                paramAnonymousView = (View)localObject2;
                break;
              }
            }
          }
          label1052:
          paramAnonymousView = null;
          continue;
          label1057:
          paramAnonymousView = null;
        }
      }
    });
    ((View)this.AyV.getValue()).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(257616);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.AyY.hide();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257616);
      }
    });
    paramViewGroup = new SpannableString((CharSequence)this.parent.getContext().getString(2131763039));
    i = n.a((CharSequence)paramViewGroup, "{music}", 0, false, 6);
    localObject1 = this.parent.getContext();
    p.g(localObject1, "parent.context");
    localObject1 = ((Context)localObject1).getResources().getDrawable(2131690721);
    p.g(localObject1, "drawable");
    int j = ((Drawable)localObject1).getIntrinsicWidth();
    int k = com.tencent.mm.cb.a.aG(this.parent.getContext(), 2131165297);
    f = 1.0F * k / j;
    localObject1 = this.parent.getContext();
    p.g(localObject1, "parent.context");
    localObject1 = com.tencent.mm.svg.a.a.a(((Context)localObject1).getResources(), 2131690721, f);
    localObject2 = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    p.g(localObject1, "scaleDrawable");
    ((Drawable)localObject1).setColorFilter((ColorFilter)localObject2);
    ((Drawable)localObject1).setBounds(0, 0, k, k);
    paramViewGroup.setSpan(new a((Drawable)localObject1), i, "{music}".length() + i, 17);
    localObject1 = ewI();
    p.g(localObject1, "statusButton");
    ((Button)localObject1).setText((CharSequence)paramViewGroup);
    this.dEF = false;
    AppMethodBeat.o(257653);
  }
  
  public static String d(axy paramaxy)
  {
    AppMethodBeat.i(257652);
    Object localObject;
    int i;
    try
    {
      localObject = (CharSequence)paramaxy.LIj;
      if (localObject == null) {
        break label234;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label239;
      }
    }
    catch (Exception paramaxy)
    {
      SimpleDateFormat localSimpleDateFormat;
      String str;
      Log.printErrStackTrace(TAG, (Throwable)paramaxy, "parse public time error", new Object[0]);
    }
    if (i == 0)
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
      str = paramaxy.LIj;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = localSimpleDateFormat.parse((String)localObject);
      if (localObject != null)
      {
        paramaxy = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format((Date)localObject);
        p.g(paramaxy, "targetSdf.format(date)");
        AppMethodBeat.o(257652);
        return paramaxy;
      }
      localObject = paramaxy.LIj;
      paramaxy = (axy)localObject;
      if (localObject == null) {
        paramaxy = "";
      }
      AppMethodBeat.o(257652);
      return paramaxy;
    }
    label234:
    label239:
    label244:
    label247:
    for (;;)
    {
      AppMethodBeat.o(257652);
      return "";
      if (paramaxy.LIk > 0L)
      {
        paramaxy = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(paramaxy.LIk * 1000L));
        localObject = (CharSequence)paramaxy;
        if (localObject != null) {
          if (((CharSequence)localObject).length() == 0) {
            break label244;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label247;
          }
          AppMethodBeat.o(257652);
          return paramaxy;
          i = 0;
          continue;
          i = 1;
          break;
          i = 0;
          break;
          i = 1;
        }
      }
    }
  }
  
  private final View ewD()
  {
    AppMethodBeat.i(257641);
    View localView = (View)this.AyI.getValue();
    AppMethodBeat.o(257641);
    return localView;
  }
  
  private final Button ewI()
  {
    AppMethodBeat.i(257646);
    Button localButton = (Button)this.AyQ.getValue();
    AppMethodBeat.o(257646);
    return localButton;
  }
  
  private final BlurView ewM()
  {
    AppMethodBeat.i(257650);
    BlurView localBlurView = (BlurView)this.AyU.getValue();
    AppMethodBeat.o(257650);
    return localBlurView;
  }
  
  public final ViewGroup ewA()
  {
    AppMethodBeat.i(257638);
    ViewGroup localViewGroup = (ViewGroup)this.AyF.getValue();
    AppMethodBeat.o(257638);
    return localViewGroup;
  }
  
  public final RoundCornerRelativeLayout ewB()
  {
    AppMethodBeat.i(257639);
    RoundCornerRelativeLayout localRoundCornerRelativeLayout = (RoundCornerRelativeLayout)this.AyG.getValue();
    AppMethodBeat.o(257639);
    return localRoundCornerRelativeLayout;
  }
  
  public final View ewC()
  {
    AppMethodBeat.i(257640);
    View localView = (View)this.AyH.getValue();
    AppMethodBeat.o(257640);
    return localView;
  }
  
  public final MusicMvMarqueeTextView ewE()
  {
    AppMethodBeat.i(257642);
    MusicMvMarqueeTextView localMusicMvMarqueeTextView = (MusicMvMarqueeTextView)this.AyJ.getValue();
    AppMethodBeat.o(257642);
    return localMusicMvMarqueeTextView;
  }
  
  public final TextView ewF()
  {
    AppMethodBeat.i(257643);
    TextView localTextView = (TextView)this.AyK.getValue();
    AppMethodBeat.o(257643);
    return localTextView;
  }
  
  public final MMImageView ewG()
  {
    AppMethodBeat.i(257644);
    MMImageView localMMImageView = (MMImageView)this.AyL.getValue();
    AppMethodBeat.o(257644);
    return localMMImageView;
  }
  
  public final BlurView ewH()
  {
    AppMethodBeat.i(257645);
    BlurView localBlurView = (BlurView)this.AyP.getValue();
    AppMethodBeat.o(257645);
    return localBlurView;
  }
  
  public final ViewGroup ewJ()
  {
    AppMethodBeat.i(257647);
    ViewGroup localViewGroup = (ViewGroup)this.AyR.getValue();
    AppMethodBeat.o(257647);
    return localViewGroup;
  }
  
  public final MMRoundCornerImageView ewK()
  {
    AppMethodBeat.i(257648);
    MMRoundCornerImageView localMMRoundCornerImageView = (MMRoundCornerImageView)this.AyS.getValue();
    AppMethodBeat.o(257648);
    return localMMRoundCornerImageView;
  }
  
  public final TextView ewL()
  {
    AppMethodBeat.i(257649);
    TextView localTextView = (TextView)this.AyT.getValue();
    AppMethodBeat.o(257649);
    return localTextView;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(257651);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder("hide song info dialog, isShow:").append(this.dEF).append(", translateY:");
    RoundCornerRelativeLayout localRoundCornerRelativeLayout = ewB();
    p.g(localRoundCornerRelativeLayout, "dialogRootLayout");
    Log.i(str, localRoundCornerRelativeLayout.getTranslationY());
    if (this.dEF)
    {
      Log.i(TAG, "do hide");
      ewB().animate().translationY(-1.0F * this.uZv).setDuration(300L).setListener((Animator.AnimatorListener)new k(this)).start();
      ewC().animate().alpha(0.0F).setDuration(300L);
    }
    AppMethodBeat.o(257651);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$Companion;", "", "()V", "ACTION_JUMP_APP", "", "ACTION_SET_STATUS", "ACTION_SHOW", "REQUEST_SET_MUSIC_STATUS", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<View>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<View>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<BlurView>
  {
    d(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<TextView>
  {
    e(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    f(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<MMRoundCornerImageView>
  {
    g(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/MMImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<MMImageView>
  {
    h(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<WeImageView>
  {
    i(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<RoundCornerRelativeLayout>
  {
    j(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
  public static final class k
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(257626);
      Log.i(f.access$getTAG$cp(), "onHide animate end");
      paramAnimator = f.a(this.AyY);
      p.g(paramAnimator, "songInfoFullScreenRoot");
      paramAnimator.setVisibility(8);
      f.a(this.AyY, false);
      AppMethodBeat.o(257626);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$show$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
  public static final class m
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(257629);
      Log.i(f.access$getTAG$cp(), "onShow animate end");
      f.a(this.AyY, true);
      AppMethodBeat.o(257629);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends q
    implements kotlin.g.a.a<TextView>
  {
    n(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    o(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends q
    implements kotlin.g.a.a<MusicMvMarqueeTextView>
  {
    p(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends q
    implements kotlin.g.a.a<ViewGroup>
  {
    q(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends q
    implements kotlin.g.a.a<MusicMvMarqueeTextView>
  {
    r(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends q
    implements kotlin.g.a.a<Button>
  {
    s(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends q
    implements kotlin.g.a.a<BlurView>
  {
    t(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends q
    implements kotlin.g.a.a<View>
  {
    u(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.f
 * JD-Core Version:    0.7.0.1
 */