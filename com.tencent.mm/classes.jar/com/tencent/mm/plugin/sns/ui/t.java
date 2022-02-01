package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.b.d.i;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "Lcom/tencent/mm/plugin/sns/ui/IWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "appId", "", "appName", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "layout", "Landroid/view/View;", "mSessionId", "needReport", "", "publisherId", "thumb", "Landroid/widget/ImageView;", "title", "beforeCommit", "checkLocation", "commit", "isPrivated", "", "syncFlag", "token", "Lorg/scribe/model/Token;", "desc", "withList", "", "location", "Lcom/tencent/mm/protocal/protobuf/Location;", "groupList", "Ljava/util/LinkedList;", "", "parseterLen", "isBlackGroup", "groupUser", "pContentType", "Lcom/tencent/mm/pointers/PInt;", "canvasInfo", "ContactTagCount", "TempUserCount", "enableNext", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleronDestroy", "hanlerOnSave", "outState", "initView", "needAutoDraft", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "plugin-sns_release"})
public final class t
  implements ad
{
  private d EpQ;
  private String appId;
  private String appName;
  private String eam;
  private MMActivity gte;
  private ImageView mEx;
  private String mSessionId;
  private View sc;
  private boolean thE;
  private String title;
  
  public t(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(201815);
    this.title = "";
    this.gte = paramMMActivity;
    AppMethodBeat.o(201815);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(201814);
    paramLinkedList = this.gte;
    if (paramLinkedList == null) {
      p.btv("context");
    }
    paramLinkedList = new bf(34, (Context)paramLinkedList);
    if (this.EpQ != null) {
      paramLinkedList.a(this.EpQ);
    }
    if (paramPInt == null) {
      p.hyc();
    }
    paramPInt.value = paramLinkedList.getContentType();
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
      paramLinkedList.YF(4);
    }
    paramLinkedList.aPB(this.title).aPw(paramString1);
    paramString1 = this.gte;
    if (paramString1 == null) {
      p.btv("context");
    }
    if (paramString1 == null) {
      p.hyc();
    }
    paramLinkedList.aPz(Util.nullAs(paramString1.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.fbU().YI(paramInt1);
    if (paramBoolean) {
      paramLinkedList.YL(1);
    }
    for (;;)
    {
      paramLinkedList.gR(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          ebm localebm = new ebm();
          localebm.UserName = paramPInt;
          paramString1.add(localebm);
        }
      }
      paramLinkedList.YL(0);
    }
    if (parami != null) {
      paramLinkedList.kl(parami.token, parami.Mte);
    }
    paramLinkedList.bq(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.aPC(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.aPD(Util.nullAs(this.appName, ""));
    }
    paramLinkedList.a(paramcjy);
    paramLinkedList.aPy(paramString2);
    paramLinkedList.aPH(this.eam);
    paramLinkedList.setSessionId(this.mSessionId);
    paramInt1 = paramLinkedList.commit();
    if (this.thE) {
      e.DUQ.DVC = paramInt1;
    }
    com.tencent.mm.plugin.sns.model.aj.faK().eZn();
    parami = this.gte;
    if (parami == null) {
      p.btv("context");
    }
    parami.finish();
    AppMethodBeat.o(201814);
    return false;
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(201813);
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    if (paramBundle == null) {
      p.hyc();
    }
    paramBundle = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_title"), "");
    p.g(paramBundle, "Util.nullAs(context!!.in…dUI.KSnsUploadTitle), \"\")");
    this.title = paramBundle;
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    this.eam = Util.nullAs(paramBundle.getIntent().getStringExtra("KPublisherId"), "");
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    this.mSessionId = Util.nullAs(paramBundle.getIntent().getStringExtra("reportSessionId"), "");
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    this.appId = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_appid"), "");
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    this.appName = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_appname"), "");
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    this.thE = paramBundle.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    paramBundle = e.DUQ;
    Object localObject = this.gte;
    if (localObject == null) {
      p.btv("context");
    }
    paramBundle.Aqq = ((MMActivity)localObject).getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.gte;
    if (paramBundle == null) {
      p.btv("context");
    }
    paramBundle = paramBundle.getIntent().getStringExtra("ksnsupload_finder_live_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderLive", null);
      if (paramBundle != null)
      {
        this.EpQ = new d();
        localObject = this.EpQ;
        if (localObject == null) {
          p.hyc();
        }
        ((d)localObject).j("", paramBundle);
      }
    }
    AppMethodBeat.o(201813);
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return this.EpQ != null;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(201812);
    Object localObject1 = this.gte;
    if (localObject1 == null) {
      p.btv("context");
    }
    localObject1 = aa.jQ((Context)localObject1).inflate(2131496435, null);
    p.g(localObject1, "MMLayoutInflater.getInfl…s_finder_live_item, null)");
    this.sc = ((View)localObject1);
    localObject1 = this.sc;
    if (localObject1 == null) {
      p.btv("layout");
    }
    this.mEx = ((ImageView)((View)localObject1).findViewById(2131308127));
    axf localaxf;
    int i;
    Object localObject2;
    if (this.EpQ != null)
    {
      localObject1 = this.EpQ;
      if (localObject1 == null) {
        p.hyc();
      }
      if (((d)localObject1).jlf != null)
      {
        localObject1 = this.EpQ;
        if (localObject1 == null) {
          p.hyc();
        }
        localaxf = ((d)localObject1).jlf;
        localObject1 = this.gte;
        if (localObject1 == null) {
          p.btv("context");
        }
        localObject1 = ap.ha((Context)localObject1);
        i = localObject1[0];
        int j = localObject1[1];
        localObject1 = this.gte;
        if (localObject1 == null) {
          p.btv("context");
        }
        localObject1 = n.a(i, j, (Context)localObject1, false);
        localObject2 = (Integer)((Pair)localObject1).first;
        i = (int)(((Number)((Pair)localObject1).first).floatValue() * 3.5F / 3.0F);
        p.g(localObject2, "smallSide");
        localObject1 = new ViewGroup.LayoutParams(((Integer)localObject2).intValue(), i);
        localObject2 = this.sc;
        if (localObject2 == null) {
          p.btv("layout");
        }
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.sc;
        if (localObject1 == null) {
          p.btv("layout");
        }
        ((View)localObject1).requestLayout();
        localObject1 = "";
        localObject2 = (CharSequence)localaxf.coverUrl;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label357;
        }
        i = 1;
        if (i != 0) {
          break label362;
        }
        localObject1 = localaxf.coverUrl;
        p.g(localObject1, "shareObject.coverUrl");
      }
    }
    label412:
    for (;;)
    {
      ((com.tencent.mm.plugin.i.a.aj)g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage((String)localObject1, this.mEx);
      localObject1 = this.sc;
      if (localObject1 == null) {
        p.btv("layout");
      }
      AppMethodBeat.o(201812);
      return localObject1;
      label357:
      i = 0;
      break;
      label362:
      localObject2 = (CharSequence)localaxf.headUrl;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label412;
        }
        localObject1 = localaxf.headUrl;
        p.g(localObject1, "shareObject.headUrl");
        break;
      }
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.t
 * JD-Core Version:    0.7.0.1
 */