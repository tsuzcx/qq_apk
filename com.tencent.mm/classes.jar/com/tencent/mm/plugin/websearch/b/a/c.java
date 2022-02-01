package com.tencent.mm.plugin.websearch.b.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.rw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.websearch.api.as;
import com.tencent.mm.plugin.websearch.ui.a.b;
import com.tencent.mm.plugin.websearch.ui.a.d;
import com.tencent.mm.plugin.websearch.ui.a.e;
import com.tencent.mm.plugin.websearch.ui.a.g;
import com.tencent.mm.plugin.websearch.ui.a.h;
import com.tencent.mm.plugin.websearch.webview.WebSearchWebView;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.cry;
import com.tencent.mm.protocal.protobuf.eva;
import com.tencent.mm.protocal.protobuf.evb;
import com.tencent.mm.protocal.protobuf.evj;
import com.tencent.mm.protocal.protobuf.evm;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.protocal.protobuf.evo;
import com.tencent.mm.protocal.protobuf.ewe;
import com.tencent.mm.protocal.protobuf.ewj;
import com.tencent.mm.protocal.protobuf.ewk;
import com.tencent.mm.protocal.protobuf.flp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "listener", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;)V", "TAG", "", "dialogView", "Landroid/view/View;", "getHomeContext", "()Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;", "setHomeContext", "(Lcom/tencent/mm/protocal/protobuf/TagSearchHomeContext;)V", "getListener", "()Lcom/tencent/mm/plugin/websearch/tagsearch/ui/ITagSearchDialogListener;", "mainTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMainTab;", "moreTab", "Lcom/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchMoreTab;", "moreTabShow", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "initContentView", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEndSearchShareCgi", "shareContent", "Lcom/tencent/mm/protocal/protobuf/GetSearchShareResponse;", "cropBitmap", "Landroid/graphics/Bitmap;", "query", "onSharedEnd", "onStartSearchShareCgi", "id", "share", "startMoreTab", "moreContext", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends androidx.appcompat.app.e
{
  private final String TAG;
  private boolean WqE;
  private flp WqT;
  final a WqU;
  private d WqV;
  private e WqW;
  private View plv;
  private com.tencent.mm.ui.base.w psR;
  
  public c(Context paramContext, flp paramflp, a parama)
  {
    super(paramContext, a.h.TagSearchDialog);
    AppMethodBeat.i(315413);
    this.WqT = paramflp;
    this.WqU = parama;
    this.TAG = "MicroMsg.WebSearch.TagSearchDialog";
    AppMethodBeat.o(315413);
  }
  
  private static final void a(k.b paramb, ewj paramewj, c paramc, cry paramcry, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3)
  {
    AppMethodBeat.i(315437);
    kotlin.g.b.s.u(paramb, "$content");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramcry, "$shareContent");
    paramString2 = BitmapUtil.Bitmap2Bytes(paramBitmap);
    w.a.bwq().a(paramb, paramewj.muA, "", paramc.WqT.talker, "", paramString2);
    paramc.b(paramcry, paramString1);
    AppMethodBeat.o(315437);
  }
  
  private static final void a(c paramc, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(315431);
    kotlin.g.b.s.u(paramc, "this$0");
    paramDialogInterface = paramc.WqV;
    if (paramDialogInterface != null)
    {
      Log.i(paramDialogInterface.TAG, "dismiss dialog");
      paramDialogInterface.WqT.hAB = paramDialogInterface.FWg.getInEditTextQuery();
      paramDialogInterface.WqU.onDismiss();
      paramDialogInterface.Wrb.destroy();
      paramDialogInterface.Wrc.removeJavascriptInterface("tagWebSearchJSApi");
      paramDialogInterface.Wrc.destroy();
    }
    paramc = paramc.WqW;
    if (paramc != null)
    {
      paramc.Wrb.destroy();
      paramc.Wrc.removeJavascriptInterface("tagWebSearchJSApi");
      paramc.Wrc.destroy();
    }
    AppMethodBeat.o(315431);
  }
  
  private static final void a(c paramc, View paramView)
  {
    AppMethodBeat.i(315424);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramc);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315424);
  }
  
  private static final boolean a(c paramc, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(315422);
    kotlin.g.b.s.u(paramc, "this$0");
    paramc.dismiss();
    AppMethodBeat.o(315422);
    return true;
  }
  
  private static final void b(c paramc, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(315433);
    kotlin.g.b.s.u(paramc, "this$0");
    paramDialogInterface = paramc.WqV;
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.Wrb;
      if (paramDialogInterface != null) {
        paramDialogInterface.iqA();
      }
    }
    paramc = paramc.WqW;
    if (paramc != null)
    {
      paramc = paramc.Wrb;
      if (paramc != null) {
        paramc.iqA();
      }
    }
    AppMethodBeat.o(315433);
  }
  
  private void b(cry paramcry, String paramString)
  {
    long l = 2L;
    AppMethodBeat.i(315418);
    kotlin.g.b.s.u(paramcry, "shareContent");
    Object localObject = this.psR;
    if (localObject != null) {
      ((com.tencent.mm.ui.base.w)localObject).dismiss();
    }
    this.WqU.a(paramcry);
    dismiss();
    rw localrw = new rw();
    localrw.izR = cn.getSyncServerTimeSecond();
    localrw.ioV = 2L;
    localrw.aIX();
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    localrw.yD((String)localObject);
    if (au.bwE(this.WqT.talker)) {}
    for (;;)
    {
      localrw.jwH = l;
      localrw.yE(this.WqT.talker);
      localObject = paramcry.aayg.SessionId;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localrw.yF(paramString);
      localObject = paramcry.aayg.aayf;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localrw.yG(paramString);
      localObject = paramcry.aayg.aaye;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localrw.yH(paramString);
      localObject = paramcry.aayg.abyG;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      localrw.yI(paramString);
      localrw.jwR = paramcry.aayg.abmA;
      localrw.jwQ = paramcry.aayg.IKW;
      localrw.bMH();
      as.a((com.tencent.mm.plugin.report.a)localrw);
      AppMethodBeat.o(315418);
      return;
      l = 1L;
    }
  }
  
  private static final void x(View paramView1, View paramView2)
  {
    AppMethodBeat.i(315428);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramView1, "$view");
    paramView2 = (FTSEditTextView)paramView1.findViewById(a.d.fts_edittext);
    if (paramView2 != null) {
      paramView2.aWT();
    }
    paramView1 = (FTSEditTextView)paramView1.findViewById(a.d.fts_edittext);
    if (paramView1 != null) {
      paramView1.showVKB();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/websearch/tagsearch/ui/TagSearchDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(315428);
  }
  
  public final void a(final cry paramcry, final Bitmap paramBitmap, final String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(315485);
    kotlin.g.b.s.u(paramcry, "shareContent");
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("onSearchShare BusinessType:").append(paramcry.aayg.IKW).append(" SubType:").append(paramcry.aayg.abmA).append(" BrandFeed:");
    if (paramcry.aayh != null)
    {
      bool1 = true;
      localStringBuilder = localStringBuilder.append(bool1).append(" WeappFeed:");
      if (paramcry.aayj == null) {
        break label272;
      }
      bool1 = true;
      label101:
      localStringBuilder = localStringBuilder.append(bool1).append(" WeappProfile:");
      if (paramcry.aayk == null) {
        break label278;
      }
      bool1 = true;
      label126:
      localStringBuilder = localStringBuilder.append(bool1).append(" BrandProfile:");
      if (paramcry.aayi == null) {
        break label284;
      }
      bool1 = true;
      label151:
      localStringBuilder = localStringBuilder.append(bool1).append(" FinderFeed:");
      if (paramcry.aaym == null) {
        break label290;
      }
      bool1 = true;
      label176:
      localStringBuilder = localStringBuilder.append(bool1).append(" FinderProfile:");
      if (paramcry.aayl == null) {
        break label296;
      }
      bool1 = true;
      label201:
      localStringBuilder = localStringBuilder.append(bool1).append(" Emoticon:");
      if (paramcry.aayn == null) {
        break label302;
      }
    }
    label272:
    label278:
    label284:
    label290:
    label296:
    label302:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Log.i(str, bool1);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramcry, paramBitmap, paramString));
      AppMethodBeat.o(315485);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label101;
      bool1 = false;
      break label126;
      bool1 = false;
      break label151;
      bool1 = false;
      break label176;
      bool1 = false;
      break label201;
    }
  }
  
  public final void b(cry paramcry, Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(315494);
    kotlin.g.b.s.u(paramcry, "shareContent");
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (paramcry.aaym != null)
    {
      paramBitmap = new k.b();
      localObject1 = new com.tencent.mm.plugin.findersdk.a.f();
      Object localObject4 = paramcry.aaym;
      localObject2 = new bvl();
      ((bvl)localObject2).objectId = ((evn)localObject4).abyo;
      ((bvl)localObject2).objectNonceId = ((evn)localObject4).abyr;
      ((bvl)localObject2).GfT = ((evn)localObject4).abyp;
      ((bvl)localObject2).avatar = ((evn)localObject4).abyq;
      ((bvl)localObject2).nickname = ((evn)localObject4).vhX;
      ((bvl)localObject2).desc = ((evn)localObject4).hAP;
      ((bvl)localObject2).hGP = ((evn)localObject4).Idy.size();
      localObject3 = ((bvl)localObject2).mediaList;
      localObject4 = ((evn)localObject4).Idy;
      kotlin.g.b.s.s(localObject4, "feedObject.MediaList");
      Object localObject5 = (Iterable)localObject4;
      localObject4 = (Collection)new ArrayList(p.a((Iterable)localObject5, 10));
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        evo localevo = (evo)((Iterator)localObject5).next();
        bvj localbvj = new bvj();
        localbvj.mediaType = localevo.Idt;
        localbvj.url = String.valueOf(localevo.Url);
        localbvj.thumbUrl = localevo.ThumbUrl;
        localbvj.width = localevo.Width;
        localbvj.height = localevo.Height;
        localbvj.aacR = localevo.abyt;
        ((Collection)localObject4).add(localbvj);
      }
      ((LinkedList)localObject3).addAll((Collection)localObject4);
      ((com.tencent.mm.plugin.findersdk.a.f)localObject1).c((bvl)localObject2);
      paramBitmap.a((com.tencent.mm.message.f)localObject1);
      paramBitmap.type = 51;
      paramBitmap.title = MMApplicationContext.getContext().getString(a.g.low_version_upgrade_tip);
      paramBitmap.url = MMApplicationContext.getContext().getString(a.g.low_version_upgrade_url);
      w.a.bwq().a(paramBitmap, "", "", this.WqT.talker, "", null);
      b(paramcry, paramString);
      AppMethodBeat.o(315494);
      return;
    }
    if (paramcry.aayl != null)
    {
      localObject2 = new k.b();
      localObject3 = new com.tencent.mm.plugin.findersdk.a.e();
      localObject1 = paramcry.aayl.UserName;
      paramBitmap = (Bitmap)localObject1;
      if (localObject1 == null) {
        paramBitmap = "";
      }
      ((com.tencent.mm.plugin.findersdk.a.e)localObject3).setUsername(paramBitmap);
      localObject1 = paramcry.aayl.vhX;
      paramBitmap = (Bitmap)localObject1;
      if (localObject1 == null) {
        paramBitmap = "";
      }
      ((com.tencent.mm.plugin.findersdk.a.e)localObject3).setNickname(paramBitmap);
      localObject1 = paramcry.aayl.abyn;
      paramBitmap = (Bitmap)localObject1;
      if (localObject1 == null) {
        paramBitmap = "";
      }
      ((com.tencent.mm.plugin.findersdk.a.e)localObject3).aDb(paramBitmap);
      localObject1 = paramcry.aayl.abym;
      paramBitmap = (Bitmap)localObject1;
      if (localObject1 == null) {
        paramBitmap = "";
      }
      ((com.tencent.mm.plugin.findersdk.a.e)localObject3).aDa(paramBitmap);
      localObject1 = paramcry.aayl.ZuK;
      paramBitmap = (Bitmap)localObject1;
      if (localObject1 == null) {
        paramBitmap = "";
      }
      ((com.tencent.mm.plugin.findersdk.a.e)localObject3).setAvatar(paramBitmap);
      ((k.b)localObject2).a((com.tencent.mm.message.f)localObject3);
      ((k.b)localObject2).type = 50;
      ((k.b)localObject2).title = MMApplicationContext.getContext().getString(a.g.low_version_upgrade_tip);
      ((k.b)localObject2).url = MMApplicationContext.getContext().getString(a.g.low_version_upgrade_url);
      w.a.bwq().a((k.b)localObject2, "", "", this.WqT.talker, "", null);
      b(paramcry, paramString);
      AppMethodBeat.o(315494);
      return;
    }
    if (paramcry.aayh != null)
    {
      paramBitmap = new k.b();
      paramBitmap.title = paramcry.aayh.hAP;
      paramBitmap.thumburl = paramcry.aayh.ThumbUrl;
      paramBitmap.url = paramcry.aayh.MpP;
      paramBitmap.description = paramcry.aayh.IGG;
      paramBitmap.action = "view";
      paramBitmap.nRg = 3;
      paramBitmap.iaa = paramcry.aayh.abxQ;
      paramBitmap.iab = paramcry.aayh.abxR;
      paramBitmap.type = 5;
      localObject1 = new com.tencent.mm.message.e();
      ((com.tencent.mm.message.e)localObject1).nQm = 0;
      paramBitmap.a((com.tencent.mm.message.f)localObject1);
      w.a.bwq().a(paramBitmap, "", "", this.WqT.talker, "", null);
      b(paramcry, paramString);
      AppMethodBeat.o(315494);
      return;
    }
    if (paramcry.aayi != null)
    {
      paramBitmap = paramcry.aayi;
      localObject1 = am.aixg;
      paramBitmap = String.format("<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>", Arrays.copyOf(new Object[] { Util.escapeStringForXml(paramBitmap.Username), Util.escapeStringForXml(paramBitmap.vhX), Util.escapeStringForXml(paramBitmap.abxM), Util.escapeStringForXml(paramBitmap.abxL), Util.escapeStringForXml(""), Integer.valueOf(0), Util.escapeStringForXml(paramBitmap.pSg), Util.escapeStringForXml(paramBitmap.pSh), Util.escapeStringForXml(paramBitmap.pSi), Integer.valueOf(0), Integer.valueOf(paramBitmap.pSf), Integer.valueOf(paramBitmap.aaMm), "", paramBitmap.IHW, Util.escapeStringForXml(paramBitmap.pSo) }, 15));
      kotlin.g.b.s.s(paramBitmap, "java.lang.String.format(format, *args)");
      com.tencent.mm.plugin.messenger.a.g.gaI().g(paramcry.aayi.Username, this.WqT.talker, paramBitmap, au.bwE(this.WqT.talker));
      b(paramcry, paramString);
      AppMethodBeat.o(315494);
      return;
    }
    if (paramcry.aayj != null)
    {
      localObject1 = paramcry.aayj;
      localObject2 = new k.b();
      ((k.b)localObject2).title = ((ewj)localObject1).IGG;
      ((k.b)localObject2).nTD = ((ewj)localObject1).UserName;
      ((k.b)localObject2).nTC = ((ewj)localObject1).IcT;
      ((k.b)localObject2).nTE = ((ewj)localObject1).muA;
      ((k.b)localObject2).nTW = 0;
      ((k.b)localObject2).nTX = ((ewj)localObject1).crz;
      ((k.b)localObject2).nTF = 2;
      ((k.b)localObject2).url = ((com.tencent.mm.plugin.appbrand.service.g)h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).UC(((ewj)localObject1).muA);
      ((k.b)localObject2).nTY = ((ewj)localObject1).abyL;
      ((k.b)localObject2).iag = ("wxapp_" + ((ewj)localObject1).muA + ((ewj)localObject1).IcT);
      ((k.b)localObject2).iaa = ((ewj)localObject1).UserName;
      ((k.b)localObject2).iab = ((ewj)localObject1).hAP;
      ((k.b)localObject2).a((com.tencent.mm.message.f)new com.tencent.mm.message.a());
      ((k.b)localObject2).type = 33;
      if (!TextUtils.isEmpty((CharSequence)((ewj)localObject1).ThumbUrl))
      {
        r.bKd().a(((ewj)localObject1).ThumbUrl, new c..ExternalSyntheticLambda5((k.b)localObject2, (ewj)localObject1, this, paramcry, paramString));
        AppMethodBeat.o(315494);
        return;
      }
      paramBitmap = BitmapUtil.Bitmap2Bytes(paramBitmap);
      w.a.bwq().a((k.b)localObject2, ((ewj)localObject1).muA, "", this.WqT.talker, "", paramBitmap);
      b(paramcry, paramString);
      AppMethodBeat.o(315494);
      return;
    }
    if (paramcry.aayk != null)
    {
      paramBitmap = new k.b();
      paramBitmap.title = paramcry.aayk.abxR;
      paramBitmap.type = 33;
      paramBitmap.nTD = paramcry.aayk.UserName;
      paramBitmap.nTE = paramcry.aayk.muA;
      paramBitmap.nTF = 1;
      paramBitmap.iag = kotlin.g.b.s.X("wxapp_", paramcry.aayk.muA);
      paramBitmap.thumburl = paramcry.aayk.ThumbUrl;
      localObject1 = am.aixg;
      localObject1 = String.format(Locale.US, "https://mp.weixin.qq.com/mp/waerrpage?appid=%s&type=upgrade&upgradetype=%d#wechat_redirect", Arrays.copyOf(new Object[] { paramcry.aayk.muA, Integer.valueOf(3) }, 2));
      kotlin.g.b.s.s(localObject1, "java.lang.String.format(locale, format, *args)");
      paramBitmap.url = ((String)localObject1);
      paramBitmap.iaa = paramcry.aayk.UserName;
      paramBitmap.iab = paramcry.aayk.abxR;
      localObject1 = new com.tencent.mm.message.a();
      ((com.tencent.mm.message.a)localObject1).nOX = 0;
      paramBitmap.a((com.tencent.mm.message.f)localObject1);
      w.a.bwq().a(paramBitmap, paramcry.aayk.muA, paramcry.aayk.abxR, this.WqT.talker, null, null);
      b(paramcry, paramString);
      AppMethodBeat.o(315494);
      return;
    }
    if (paramcry.aayn != null)
    {
      paramBitmap = (j)h.ax(j.class);
      getContext();
      paramBitmap.G(this.WqT.talker, paramcry.aayn.toByteArray());
      b(paramcry, paramString);
    }
    AppMethodBeat.o(315494);
  }
  
  public final void biF(String paramString)
  {
    AppMethodBeat.i(315477);
    kotlin.g.b.s.u(paramString, "id");
    if (this.psR == null) {
      this.psR = com.tencent.mm.ui.base.w.a(getContext(), (CharSequence)getContext().getString(a.g.loading_tips), true, 0, new c..ExternalSyntheticLambda0(this));
    }
    paramString = this.psR;
    if ((paramString != null) && (!paramString.isShowing())) {
      paramString.show();
    }
    AppMethodBeat.o(315477);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(315496);
    if (this.WqE)
    {
      Object localObject = this.plv;
      if (localObject != null)
      {
        localObject = (TextView)((View)localObject).findViewById(a.d.title_tv);
        if (localObject != null) {
          ((TextView)localObject).setText(a.g.tag_search_title);
        }
      }
      localObject = this.plv;
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(a.d.close_btn);
        if (localObject != null)
        {
          localObject = ((View)localObject).animate();
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).rotation(0.0F);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setDuration(200L);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
      localObject = this.WqW;
      if (localObject != null)
      {
        int i = com.tencent.mm.cd.a.ms(((e)localObject).getActivityContext());
        ((e)localObject).WqO.animate().translationX(i).setDuration(300L).start();
      }
      this.WqE = false;
      AppMethodBeat.o(315496);
      return;
    }
    dismiss();
    AppMethodBeat.o(315496);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(315472);
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -1);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.5F);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(a.h.BottomToTopSlowAnimation);
    }
    paramBundle = LayoutInflater.from(getContext()).inflate(a.e.tag_search_dialog, null, false);
    kotlin.g.b.s.s(paramBundle, "from(context).inflate(R.…arch_dialog, null, false)");
    setContentView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
    paramBundle.findViewById(a.d.empty_area_view).setOnTouchListener(new c..ExternalSyntheticLambda4(this));
    paramBundle.findViewById(a.d.close_btn).setOnClickListener(new c..ExternalSyntheticLambda3(this));
    ((ImageView)paramBundle.findViewById(a.d.search_icon)).setOnClickListener(new c..ExternalSyntheticLambda2(paramBundle));
    ((TextView)paramBundle.findViewById(a.d.title_tv)).setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.b.GroupTitleTextSize) * com.tencent.mm.cd.a.jO(getContext()));
    this.WqV = new d(this, this.WqT, this.WqU, paramBundle);
    setOnDismissListener(new c..ExternalSyntheticLambda1(this));
    setCancelable(true);
    this.plv = paramBundle;
    AppMethodBeat.o(315472);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(c paramc, cry paramcry, Bitmap paramBitmap, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(c paramc, flp paramflp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.b.a.c
 * JD-Core Version:    0.7.0.1
 */