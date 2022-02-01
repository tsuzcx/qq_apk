package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.d.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ar;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.b.d.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "Lcom/tencent/mm/plugin/sns/ui/IWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "appId", "", "appName", "finderOlympicView", "Landroid/view/View;", "getFinderOlympicView", "()Landroid/view/View;", "setFinderOlympicView", "(Landroid/view/View;)V", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "layout", "mSessionId", "needReport", "", "publisherId", "snsType", "", "getSnsType", "()I", "thumb", "Landroid/widget/ImageView;", "title", "beforeCommit", "checkLocation", "commit", "isPrivated", "syncFlag", "token", "Lorg/scribe/model/Token;", "desc", "withList", "", "location", "Lcom/tencent/mm/protocal/protobuf/Location;", "groupList", "Ljava/util/LinkedList;", "", "parseterLen", "isBlackGroup", "groupUser", "pContentType", "Lcom/tencent/mm/pointers/PInt;", "canvasInfo", "ContactTagCount", "TempUserCount", "enableNext", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleronDestroy", "hanlerOnSave", "outState", "initView", "needAutoDraft", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPrepareCommitPack", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public class u
  implements ag
{
  private boolean Akx;
  private final int RcH;
  private d RcK;
  private String appId;
  private String appName;
  private View doN;
  private View finderOlympicView;
  private String iag;
  private MMActivity lzt;
  private String mSessionId;
  private ImageView sIV;
  private String title;
  
  public u(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(308017);
    this.title = "";
    this.RcH = 34;
    this.lzt = paramMMActivity;
    AppMethodBeat.o(308017);
  }
  
  protected void a(MMActivity paramMMActivity, bg parambg)
  {
    AppMethodBeat.i(308045);
    s.u(paramMMActivity, "context");
    s.u(parambg, "packHelper");
    AppMethodBeat.o(308045);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(308051);
    paramInt2 = hlU();
    Object localObject = this.lzt;
    paramLinkedList = (LinkedList<Long>)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramLinkedList = null;
    }
    localObject = new bg(paramInt2, (Context)paramLinkedList);
    if (this.RcK != null) {
      ((bg)localObject).a(this.RcK);
    }
    s.checkNotNull(paramPInt);
    paramPInt.value = ((bg)localObject).cIh;
    if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
      ((bg)localObject).akL(4);
    }
    ((bg)localObject).aYR(this.title).aYM(paramString1);
    paramLinkedList = this.lzt;
    paramString1 = paramLinkedList;
    if (paramLinkedList == null)
    {
      s.bIx("context");
      paramString1 = null;
    }
    ((bg)localObject).aYP(Util.nullAs(paramString1.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    ((bg)localObject).akO(paramInt1);
    if (paramBoolean) {
      ((bg)localObject).akR(1);
    }
    for (;;)
    {
      ((bg)localObject).kB(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramLinkedList = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (String)paramList1.next();
        if ((paramLinkedList != null) && (!paramLinkedList.contains(paramList2)))
        {
          paramPInt = new ffw();
          paramPInt.UserName = paramList2;
          paramString1.add(paramPInt);
        }
      }
      ((bg)localObject).akR(0);
    }
    if (parami != null) {
      ((bg)localObject).mm(parami.token, parami.aaTQ);
    }
    ((bg)localObject).bU(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      ((bg)localObject).aYS(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      ((bg)localObject).aYT(Util.nullAs(this.appName, ""));
    }
    ((bg)localObject).a(paramdjv);
    ((bg)localObject).aYO(paramString2);
    ((bg)localObject).aYX(this.iag);
    ((bg)localObject).setSessionId(this.mSessionId);
    paramString1 = this.lzt;
    parami = paramString1;
    if (paramString1 == null)
    {
      s.bIx("context");
      parami = null;
    }
    a(parami, (bg)localObject);
    paramInt1 = ((bg)localObject).FW();
    if (this.Akx) {
      j.QFS.QGG = paramInt1;
    }
    al.hgx().hej();
    paramString1 = this.lzt;
    parami = paramString1;
    if (paramString1 == null)
    {
      s.bIx("context");
      parami = null;
    }
    parami.finish();
    AppMethodBeat.o(308051);
    return false;
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(308041);
    Object localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    paramBundle = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_title"), "");
    s.s(paramBundle, "nullAs(context!!.intent.…dUI.KSnsUploadTitle), \"\")");
    this.title = paramBundle;
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    this.iag = Util.nullAs(paramBundle.getIntent().getStringExtra("KPublisherId"), "");
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    this.mSessionId = Util.nullAs(paramBundle.getIntent().getStringExtra("reportSessionId"), "");
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    this.appId = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_appid"), "");
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    this.appName = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_appname"), "");
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    this.Akx = paramBundle.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    j localj = j.QFS;
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    localj.LYR = paramBundle.getIntent().getLongExtra("finder_feed_id", 0L);
    localObject = this.lzt;
    paramBundle = (Bundle)localObject;
    if (localObject == null)
    {
      s.bIx("context");
      paramBundle = null;
    }
    paramBundle = paramBundle.getIntent().getStringExtra("ksnsupload_finder_live_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderLive", null);
      if (paramBundle != null)
      {
        this.RcK = new d();
        localObject = this.RcK;
        s.checkNotNull(localObject);
        ((d)localObject).i("", paramBundle);
      }
    }
    AppMethodBeat.o(308041);
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return this.RcK != null;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(308033);
    Object localObject2 = this.lzt;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("context");
      localObject1 = null;
    }
    localObject1 = af.mU((Context)localObject1).inflate(b.g.sns_finder_live_item, null);
    s.s(localObject1, "getInflater(context).inf…s_finder_live_item, null)");
    this.doN = ((View)localObject1);
    localObject2 = this.doN;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("layout");
      localObject1 = null;
    }
    this.sIV = ((ImageView)((View)localObject1).findViewById(b.f.sns_finder_media_thumb));
    localObject2 = this.doN;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("layout");
      localObject1 = null;
    }
    this.finderOlympicView = ((View)localObject1).findViewById(b.f.finder_olympic_invite_view);
    bmr localbmr;
    int i;
    Object localObject3;
    if (this.RcK != null)
    {
      localObject1 = this.RcK;
      s.checkNotNull(localObject1);
      if (((d)localObject1).oUb != null)
      {
        localObject1 = this.RcK;
        s.checkNotNull(localObject1);
        localbmr = ((d)localObject1).oUb;
        localObject2 = this.lzt;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("context");
          localObject1 = null;
        }
        localObject1 = ar.jR((Context)localObject1);
        i = localObject1[0];
        int j = localObject1[1];
        localObject2 = this.lzt;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("context");
          localObject1 = null;
        }
        localObject1 = o.a(i, j, (Context)localObject1, false);
        Integer localInteger = (Integer)((Pair)localObject1).first;
        i = (int)(((Number)((Pair)localObject1).first).floatValue() * 3.5F / 3.0F);
        s.s(localInteger, "smallSide");
        localObject3 = new ViewGroup.LayoutParams(localInteger.intValue(), i);
        localObject2 = this.doN;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("layout");
          localObject1 = null;
        }
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject2 = this.doN;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("layout");
          localObject1 = null;
        }
        ((View)localObject1).requestLayout();
        localObject1 = "";
        localObject2 = (CharSequence)localbmr.coverUrl;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label963;
        }
        i = 1;
        if (i != 0) {
          break label968;
        }
        localObject2 = localbmr.coverUrl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        label388:
        ((cn)h.az(cn.class)).loadImage((String)localObject1, this.sIV);
        localObject3 = (b)h.az(b.class);
        localObject2 = this.doN;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("layout");
          localObject1 = null;
        }
        ((b)localObject3).setFinderLiveTagText(((View)localObject1).findViewById(b.f.finder_live_icon), localbmr.ZVl);
        localObject1 = (CharSequence)localbmr.ZVq;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1025;
        }
        i = 1;
        label483:
        if (i != 0) {
          break label1071;
        }
        localObject1 = (CharSequence)localbmr.eventId;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label1030;
        }
        i = 1;
        label511:
        if ((i != 0) || (!s.p(localbmr.eventId, "1"))) {
          break label1071;
        }
        localObject1 = this.finderOlympicView;
        if (localObject1 != null)
        {
          localObject2 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_bg);
          s.s(localObject2, "it.findViewById(R.id.finder_olympic_invite_bg)");
          localObject2 = (ImageView)localObject2;
          localObject3 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_icon);
          s.s(localObject3, "it.findViewById(R.id.finder_olympic_invite_icon)");
          localObject3 = (ImageView)localObject3;
          ((b)h.az(b.class)).loadOlympicsImage((ImageView)localObject2, com.tencent.d.a.a.a.b.b.j.ahpn, b.e.finder_olympic_live_share_bg);
          ((b)h.az(b.class)).loadOlympicsImage((ImageView)localObject3, com.tencent.d.a.a.a.b.b.j.ahpo, b.e.finder_olympic_live_share_icon);
          localObject2 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_text);
          s.s(localObject2, "it.findViewById(R.id.finder_olympic_invite_text)");
          localObject3 = (TextView)localObject2;
          ((TextView)localObject3).setTextSize(1, 14.0F);
          localObject2 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_name);
          s.s(localObject2, "it.findViewById(R.id.finder_olympic_invite_name)");
          localObject2 = (TextView)localObject2;
          ((TextView)localObject2).setTextSize(1, 14.0F);
          localObject1 = ((View)localObject1).findViewById(b.f.finder_olympic_invite_you);
          s.s(localObject1, "it.findViewById(R.id.finder_olympic_invite_you)");
          localObject1 = (TextView)localObject1;
          ((TextView)localObject1).setTextSize(1, 15.0F);
          aw.a((Paint)((TextView)localObject3).getPaint(), 0.8F);
          aw.a((Paint)((TextView)localObject2).getPaint(), 0.8F);
          aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
          localObject1 = (CharSequence)localbmr.ZVr;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label1035;
          }
          i = 1;
          label789:
          if (i == 0) {
            break label1040;
          }
          ((TextView)localObject2).setVisibility(8);
          label800:
          localObject1 = MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.sns.b.j.finder_olympic_invite_text_3, new Object[] { localbmr.ZVq });
          s.s(localObject1, "getContext().resources.g…, shareObject.relayIndex)");
          i = localInteger.intValue();
          j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12);
          localObject2 = n.bV((String)localObject1, "\n", "");
          if (new StaticLayout((CharSequence)localObject2, 0, ((String)localObject2).length(), ((TextView)localObject3).getPaint(), i - j * 2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true).getLineCount() > 1) {
            break label1111;
          }
          localObject1 = localObject2;
        }
      }
    }
    label963:
    label968:
    label1103:
    label1111:
    for (;;)
    {
      ((TextView)localObject3).setText((CharSequence)localObject1);
      localObject1 = this.finderOlympicView;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      localObject1 = this.sIV;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(8);
      }
      for (;;)
      {
        localObject1 = this.doN;
        if (localObject1 != null) {
          break label1103;
        }
        s.bIx("layout");
        AppMethodBeat.o(308033);
        return null;
        i = 0;
        break;
        localObject2 = (CharSequence)localbmr.headUrl;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1023;
          }
          localObject2 = localbmr.headUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          break;
        }
        label1023:
        break label388;
        i = 0;
        break label483;
        i = 0;
        break label511;
        i = 0;
        break label789;
        ((TextView)localObject2).setText((CharSequence)p.b(MMApplicationContext.getContext(), (CharSequence)localbmr.ZVr));
        ((TextView)localObject2).setVisibility(0);
        break label800;
        localObject1 = this.finderOlympicView;
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        localObject1 = this.sIV;
        if (localObject1 != null) {
          ((ImageView)localObject1).setVisibility(0);
        }
      }
      AppMethodBeat.o(308033);
      return localObject1;
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    return false;
  }
  
  protected int hlU()
  {
    return this.RcH;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */