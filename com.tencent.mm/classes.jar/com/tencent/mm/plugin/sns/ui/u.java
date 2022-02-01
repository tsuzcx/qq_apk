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
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.k.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ao;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.b.d.i;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sns/ui/FinderLiveWidget;", "Lcom/tencent/mm/plugin/sns/ui/IWidget;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "appId", "", "appName", "finderShareObject", "Lcom/tencent/mm/modelsns/SnsFinderShareLive;", "layout", "Landroid/view/View;", "mSessionId", "needReport", "", "publisherId", "snsType", "", "getSnsType", "()I", "thumb", "Landroid/widget/ImageView;", "title", "beforeCommit", "checkLocation", "commit", "isPrivated", "syncFlag", "token", "Lorg/scribe/model/Token;", "desc", "withList", "", "location", "Lcom/tencent/mm/protocal/protobuf/Location;", "groupList", "Ljava/util/LinkedList;", "", "parseterLen", "isBlackGroup", "groupUser", "pContentType", "Lcom/tencent/mm/pointers/PInt;", "canvasInfo", "ContactTagCount", "TempUserCount", "enableNext", "handlerOnCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "handleronDestroy", "hanlerOnSave", "outState", "initView", "needAutoDraft", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onPrepareCommitPack", "packHelper", "Lcom/tencent/mm/plugin/sns/model/UploadPackHelper;", "plugin-sns_release"})
public class u
  implements af
{
  private final int KCZ;
  private d KDd;
  private String appId;
  private String appName;
  private View bvK;
  private String fUj;
  private MMActivity iXq;
  private String mSessionId;
  private ImageView pDJ;
  private String title;
  private boolean wNV;
  
  public u(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(197999);
    this.title = "";
    this.KCZ = 34;
    this.iXq = paramMMActivity;
    AppMethodBeat.o(197999);
  }
  
  protected void a(MMActivity paramMMActivity, be parambe)
  {
    AppMethodBeat.i(197964);
    p.k(paramMMActivity, "context");
    p.k(parambe, "packHelper");
    AppMethodBeat.o(197964);
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(197993);
    paramInt2 = fTB();
    paramLinkedList = this.iXq;
    if (paramLinkedList == null) {
      p.bGy("context");
    }
    paramLinkedList = new be(paramInt2, (Context)paramLinkedList);
    if (this.KDd != null) {
      paramLinkedList.a(this.KDd);
    }
    if (paramPInt == null) {
      p.iCn();
    }
    paramPInt.value = paramLinkedList.fPM();
    if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
      paramLinkedList.afW(4);
    }
    paramLinkedList.bax(this.title).bas(paramString1);
    paramString1 = this.iXq;
    if (paramString1 == null) {
      p.bGy("context");
    }
    if (paramString1 == null) {
      p.iCn();
    }
    paramLinkedList.bav(Util.nullAs(paramString1.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
    paramLinkedList.fPN().afZ(paramInt1);
    if (paramBoolean) {
      paramLinkedList.agc(1);
    }
    for (;;)
    {
      paramLinkedList.hA(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          elm localelm = new elm();
          localelm.UserName = paramPInt;
          paramString1.add(localelm);
        }
      }
      paramLinkedList.agc(0);
    }
    if (parami != null) {
      paramLinkedList.kG(parami.token, parami.TEk);
    }
    paramLinkedList.bL(paramString1);
    if (!Util.isNullOrNil(this.appId)) {
      paramLinkedList.bay(this.appId);
    }
    if (!Util.isNullOrNil(this.appName)) {
      paramLinkedList.baz(Util.nullAs(this.appName, ""));
    }
    paramLinkedList.a(paramcst);
    paramLinkedList.bau(paramString2);
    paramLinkedList.baD(this.fUj);
    paramLinkedList.setSessionId(this.mSessionId);
    parami = this.iXq;
    if (parami == null) {
      p.bGy("context");
    }
    a(parami, paramLinkedList);
    paramInt1 = paramLinkedList.in();
    if (this.wNV) {
      g.Kia.KiM = paramInt1;
    }
    aj.fOE().fNd();
    parami = this.iXq;
    if (parami == null) {
      p.bGy("context");
    }
    parami.finish();
    AppMethodBeat.o(197993);
    return false;
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(197961);
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    if (paramBundle == null) {
      p.iCn();
    }
    paramBundle = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_title"), "");
    p.j(paramBundle, "Util.nullAs(context!!.in…dUI.KSnsUploadTitle), \"\")");
    this.title = paramBundle;
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    this.fUj = Util.nullAs(paramBundle.getIntent().getStringExtra("KPublisherId"), "");
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    this.mSessionId = Util.nullAs(paramBundle.getIntent().getStringExtra("reportSessionId"), "");
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    this.appId = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_appid"), "");
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    this.appName = Util.nullAs(paramBundle.getIntent().getStringExtra("Ksnsupload_appname"), "");
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    this.wNV = paramBundle.getIntent().getBooleanExtra("ksnsupload_finder_need_report", false);
    paramBundle = g.Kia;
    Object localObject = this.iXq;
    if (localObject == null) {
      p.bGy("context");
    }
    paramBundle.Gdf = ((MMActivity)localObject).getIntent().getLongExtra("finder_feed_id", 0L);
    paramBundle = this.iXq;
    if (paramBundle == null) {
      p.bGy("context");
    }
    paramBundle = paramBundle.getIntent().getStringExtra("ksnsupload_finder_live_xml");
    if (!Util.isNullOrNil(paramBundle))
    {
      paramBundle = XmlParser.parseXml(paramBundle, "finderLive", null);
      if (paramBundle != null)
      {
        this.KDd = new d();
        localObject = this.KDd;
        if (localObject == null) {
          p.iCn();
        }
        ((d)localObject).i("", paramBundle);
      }
    }
    AppMethodBeat.o(197961);
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    return false;
  }
  
  protected int fTB()
  {
    return this.KCZ;
  }
  
  public final boolean fTw()
  {
    return this.KDd != null;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(197947);
    Object localObject1 = this.iXq;
    if (localObject1 == null) {
      p.bGy("context");
    }
    localObject1 = ad.kS((Context)localObject1).inflate(i.g.sns_finder_live_item, null);
    p.j(localObject1, "MMLayoutInflater.getInfl…s_finder_live_item, null)");
    this.bvK = ((View)localObject1);
    localObject1 = this.bvK;
    if (localObject1 == null) {
      p.bGy("layout");
    }
    this.pDJ = ((ImageView)((View)localObject1).findViewById(i.f.sns_finder_media_thumb));
    Object localObject2;
    int i;
    Object localObject3;
    if (this.KDd != null)
    {
      localObject1 = this.KDd;
      if (localObject1 == null) {
        p.iCn();
      }
      if (((d)localObject1).mbh != null)
      {
        localObject1 = this.KDd;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject2 = ((d)localObject1).mbh;
        localObject1 = this.iXq;
        if (localObject1 == null) {
          p.bGy("context");
        }
        localObject1 = ao.ib((Context)localObject1);
        i = localObject1[0];
        int j = localObject1[1];
        localObject1 = this.iXq;
        if (localObject1 == null) {
          p.bGy("context");
        }
        localObject1 = o.a(i, j, (Context)localObject1, false);
        localObject3 = (Integer)((Pair)localObject1).first;
        i = (int)(((Number)((Pair)localObject1).first).floatValue() * 3.5F / 3.0F);
        p.j(localObject3, "smallSide");
        localObject1 = new ViewGroup.LayoutParams(((Integer)localObject3).intValue(), i);
        localObject3 = this.bvK;
        if (localObject3 == null) {
          p.bGy("layout");
        }
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = this.bvK;
        if (localObject1 == null) {
          p.bGy("layout");
        }
        ((View)localObject1).requestLayout();
        localObject1 = "";
        localObject3 = (CharSequence)((bcp)localObject2).coverUrl;
        if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
          break label362;
        }
        i = 1;
        if (i != 0) {
          break label367;
        }
        localObject2 = ((bcp)localObject2).coverUrl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    label422:
    for (;;)
    {
      ((ak)h.ag(ak.class)).loadImage((String)localObject1, this.pDJ);
      localObject1 = this.bvK;
      if (localObject1 == null) {
        p.bGy("layout");
      }
      AppMethodBeat.o(197947);
      return localObject1;
      label362:
      i = 0;
      break;
      label367:
      localObject3 = (CharSequence)((bcp)localObject2).headUrl;
      if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label422;
        }
        localObject2 = ((bcp)localObject2).headUrl;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        break;
      }
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */