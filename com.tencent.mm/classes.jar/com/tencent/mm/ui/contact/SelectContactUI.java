package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.g.b.a.et;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.cf;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.n.e;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.y.a;
import com.tencent.mm.ui.z;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SelectContactUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.al.f, com.tencent.mm.ui.tools.g
{
  private long JMa;
  private int Kjz;
  private int KoT;
  private boolean KoU;
  private a KoV;
  private int KpA;
  private int KpB;
  private boolean KpC;
  private boolean KpD;
  private boolean KpE;
  private Pair<Long, Boolean> KpF;
  private com.tencent.mm.i.d KpG;
  private ArrayList<String> KpH;
  private boolean KpI;
  private boolean KpJ;
  private boolean KpK;
  private String KpL;
  private com.tencent.mm.sdk.b.c<qg> KpM;
  private b KpN;
  private boolean KpO;
  private boolean KpP;
  private HashMap<String, String> KpQ;
  private TextView Kpd;
  private TextView Kpe;
  private TextView Kpf;
  private TextView Kpg;
  private TextView Kph;
  private TextView Kpi;
  private List<String> Kpj;
  private Map<String, Integer> Kpk;
  private boolean Kpl;
  private boolean Kpm;
  private String Kpn;
  private String Kpo;
  private boolean Kpp;
  private int Kpq;
  private RelativeLayout Kpr;
  private LinearLayout Kps;
  private ImageView Kpt;
  private ImageView Kpu;
  private ImageView Kpv;
  private ProgressBar Kpw;
  private TextView Kpx;
  private Button Kpy;
  private boolean Kpz;
  private ProgressDialog fMu;
  private String fPi;
  private com.tencent.mm.ui.tools.h fQT;
  private List<String> fSL;
  private String nch;
  private int requestCode;
  private g.a rfR;
  private String title;
  private int uCd;
  private String uWA;
  private List<String> vIm;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.Kpk = new HashMap();
    this.KpA = 0;
    this.KpB = 0;
    this.KpC = false;
    this.KpD = false;
    this.KpE = true;
    this.KpF = new Pair(Long.valueOf(-1L), Boolean.FALSE);
    this.JMa = -1L;
    this.KpH = null;
    this.KoU = true;
    this.KpK = false;
    this.KpM = new com.tencent.mm.sdk.b.c() {};
    this.KpN = new b(this, (byte)0);
    this.KpO = false;
    this.KpP = false;
    this.KpQ = new HashMap();
    this.rfR = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194576);
        if (paramAnonymousInt == -21005)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(194576);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd);
          SelectContactUI.a(SelectContactUI.this, false);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] result:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(com.tencent.mm.vfs.i.deleteFile((String)SelectContactUI.E(SelectContactUI.this).get(paramAnonymousString))) });
          SelectContactUI.k(SelectContactUI.this);
          com.tencent.mm.plugin.selectrecord.b.a.dNa().zf(cf.aCK());
          AppMethodBeat.o(194576);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SelectContactUI", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd.field_retCode, "cdn ret error");
          AppMethodBeat.o(194576);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.SelectContactUI", "start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, 0, "cdn start error");
          AppMethodBeat.o(194576);
          return 0;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null) {
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SelectContactUI", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
        }
        AppMethodBeat.o(194576);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.KoV = new a();
    AppMethodBeat.o(37994);
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!ba.ajx())
    {
      AppMethodBeat.o(38020);
      return localLinkedList;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(38020);
      return localLinkedList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ba.aBQ();
      am localam = com.tencent.mm.model.c.azp().Bf(str);
      paramList = str;
      if (localam != null)
      {
        paramList = str;
        if ((int)localam.gfj != 0) {
          paramList = localam.adv();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private void W(int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(194595);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt), bt.bI(paramString1, "") });
    this.KpD = true;
    this.KpC = false;
    fIv();
    com.tencent.e.h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194578);
        SelectContactUI localSelectContactUI = SelectContactUI.this;
        if (bt.isNullOrNil(paramString2)) {}
        for (String str = SelectContactUI.this.getString(2131767121);; str = paramString2)
        {
          com.tencent.mm.ui.base.h.a(localSelectContactUI, str, "", SelectContactUI.this.getString(2131766205), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(194577);
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
              AppMethodBeat.o(194577);
            }
          });
          AppMethodBeat.o(194578);
          return;
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.dNa().zf(cf.aCK());
    com.tencent.mm.plugin.selectrecord.b.a.dNa().dNe();
    AppMethodBeat.o(194595);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(38006);
    if ((u.hasAttr(this.KoT, 64)) && (this.vIm.size() > 0))
    {
      aWU(getString(2131755779) + "(" + this.vIm.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.KoT, 262144)) && (this.vIm.size() < i))
      {
        yo(false);
        AppMethodBeat.o(38006);
        return;
      }
      yo(true);
      AppMethodBeat.o(38006);
      return;
    }
    if ((u.hasAttr(this.KoT, 64)) && (u.hasAttr(this.KoT, 4194304)))
    {
      aWU(getString(2131755779));
      yo(true);
      AppMethodBeat.o(38006);
      return;
    }
    aWU(getString(2131755779));
    yo(false);
    AppMethodBeat.o(38006);
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = z.jO(this).inflate(2131494420, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(2131298778);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    AppMethodBeat.o(38003);
    return paramOnClickListener;
  }
  
  private void a(final com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(38011);
    parama.d(new com.tencent.mm.roomsdk.a.b.c() {});
    getString(2131755906);
    parama.a(this, getString(2131760674), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(194574);
        SelectContactUI.D(SelectContactUI.this);
        parama.cancel();
        AppMethodBeat.o(194574);
      }
    });
    aeq(2);
    AppMethodBeat.o(38011);
  }
  
  private void aWU(String paramString)
  {
    AppMethodBeat.i(194588);
    if (this.Kpq == 1)
    {
      updateOptionMenuText(1, paramString);
      AppMethodBeat.o(194588);
      return;
    }
    this.Kpy.setText(paramString);
    AppMethodBeat.o(194588);
  }
  
  private void aWV(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.Kpj.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.vIm.contains(paramString))
    {
      this.vIm.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (fId() == fIe()) {
          break label311;
        }
        ((c)fIe()).Kkr.reset();
        fIe().Zh();
        this.Kna.ciQ();
        hideVKB();
      }
      label108:
      if (!(fId() instanceof v)) {
        break label339;
      }
      String str = ((v)fId()).fIc();
      if (this.vIo != null) {
        this.vIo.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.vIo.aMx(paramString);
      AppMethodBeat.o(38018);
      return;
      this.vIm.add(paramString);
      if ((fId() instanceof v))
      {
        if (((v)fId()).fIs())
        {
          this.Kpk.put(paramString, Integer.valueOf(((v)fId()).aWR(paramString)));
          i = 0;
          break;
        }
        this.Kpk.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (fId() == fIe())
      {
        if (((c)fIe()).aWL(paramString))
        {
          this.Kpk.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.Kpk.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label311:
      if ((i == 0) && (!((c)fIe()).aWL(paramString))) {
        break label108;
      }
      fIe().Zh();
      break label108;
      label339:
      fIk();
    }
  }
  
  private static String aWW(String paramString)
  {
    AppMethodBeat.i(194591);
    if (bt.isNullOrNil(paramString))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "xml is null");
      AppMethodBeat.o(194591);
      return null;
    }
    String str = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
    if (!com.tencent.mm.vfs.i.fv(str)) {
      com.tencent.mm.vfs.i.aYg(str);
    }
    try
    {
      str = str + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      if (com.tencent.mm.vfs.i.fv(str)) {
        com.tencent.mm.vfs.i.deleteFile(str);
      }
      paramString = paramString.getBytes();
      com.tencent.mm.vfs.i.f(str, paramString, paramString.length);
      paramString = com.tencent.mm.plugin.selectrecord.b.a.dNa();
      long l = com.tencent.mm.vfs.i.aYo(str);
      paramString.yBX.eiS = l;
      AppMethodBeat.o(194591);
      return str;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.SelectContactUI", paramString, "", new Object[0]);
      AppMethodBeat.o(194591);
    }
    return null;
  }
  
  private com.tencent.mm.i.g aWX(String paramString)
  {
    AppMethodBeat.i(194592);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.dNR = true;
    localg.fJj = this.rfR;
    localg.field_mediaId = afX(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fIw;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 0;
    localg.field_bzScene = 0;
    this.KpQ.put(localg.field_mediaId, localg.field_fullpath);
    AppMethodBeat.o(194592);
    return localg;
  }
  
  private void aeq(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.KpP)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.KpP = true;
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      int i;
      int k;
      int m;
      int n;
      int i1;
      int j;
      switch (this.scene)
      {
      case 4: 
      case 5: 
      case 6: 
      default: 
        i = 0;
        k = 0;
        m = 0;
        n = 0;
        i1 = 0;
        localObject = this.vIm.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.Kpk.containsKey(str)) {
          switch (((Integer)this.Kpk.get(str)).intValue())
          {
          }
        }
        break;
      }
      for (;;)
      {
        break label107;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        k += 1;
        break label107;
        n += 1;
        break label107;
        m += 1;
        break label107;
        i1 += 1;
        break label107;
        j += 1;
      }
      label257:
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(fId().fHH()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.g.yhR.f(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(fId().fHH()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.Kpj);
      ((List)localObject).addAll(this.vIm);
      w.iA((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private static String afX(String paramString)
  {
    AppMethodBeat.i(194593);
    paramString = com.tencent.mm.b.g.getMessageDigest((bt.HI() + ", " + paramString).getBytes());
    AppMethodBeat.o(194593);
    return paramString;
  }
  
  private void cT(int paramInt, String paramString)
  {
    AppMethodBeat.i(194594);
    W(paramInt, paramString, "");
    AppMethodBeat.o(194594);
  }
  
  private void fIu()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.KoU) && ((this.Kjz == 1) || (this.Kjz == 0))) {
      if (this.Kpj == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.Kpj.size();; i = 0)
    {
      if (this.vIm != null) {
        j = this.vIm.size();
      }
      int k = bt.aRe(com.tencent.mm.n.g.acA().getValue("ChatRoomInviteStartCount"));
      this.KoV.e(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void fIv()
  {
    AppMethodBeat.i(194589);
    com.tencent.e.h.LTJ.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194569);
        if (SelectContactUI.u(SelectContactUI.this))
        {
          if (SelectContactUI.v(SelectContactUI.this) == 0)
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(8);
            SelectContactUI.y(SelectContactUI.this).setVisibility(8);
            SelectContactUI.z(SelectContactUI.this).setVisibility(0);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099734));
            SelectContactUI.A(SelectContactUI.this).setText(2131767156);
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131235070));
            AppMethodBeat.o(194569);
            return;
          }
          if (SelectContactUI.t(SelectContactUI.this))
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(0);
            SelectContactUI.y(SelectContactUI.this).setVisibility(8);
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099700));
            SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(2131767164, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131235071));
            AppMethodBeat.o(194569);
            return;
          }
          if (SelectContactUI.s(SelectContactUI.this))
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(8);
            SelectContactUI.y(SelectContactUI.this).setVisibility(0);
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099700));
            SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(2131767164, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131235071));
            AppMethodBeat.o(194569);
            return;
          }
          SelectContactUI.w(SelectContactUI.this).setVisibility(0);
          SelectContactUI.x(SelectContactUI.this).setVisibility(8);
          SelectContactUI.y(SelectContactUI.this).setVisibility(8);
          SelectContactUI.z(SelectContactUI.this).setVisibility(8);
          SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099700));
          SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(2131767164, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
          SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131235071));
        }
        AppMethodBeat.o(194569);
      }
    });
    AppMethodBeat.o(194589);
  }
  
  private void fIw()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = yp(true);
    localArrayList.remove(com.tencent.mm.model.u.aAm());
    if (localArrayList.size() > 0)
    {
      this.fMu = com.tencent.mm.ui.base.h.b(getContext(), getString(2131761075), false, null);
      ba.ajF().ay(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void fIx()
  {
    AppMethodBeat.i(38010);
    Object localObject = yp(false);
    ((ArrayList)localObject).remove(com.tencent.mm.model.u.aAm());
    final String str = bt.m((List)localObject, ",");
    if (!bt.hj((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(2131760621), "", getString(2131760620), getString(2131760619), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194570);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "return the result,and create new label");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(194570);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194571);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "return the result");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(194571);
        }
      });
      AppMethodBeat.o(38010);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Select_Contact", str);
    ((Intent)localObject).putExtra("Select_Conv_User", str);
    ((Intent)localObject).putExtra("Select_Contact", str);
    ((Intent)localObject).putExtra("Select_Contacts_To_Create_New_Label", str);
    setResult(0, (Intent)localObject);
    finish();
    AppMethodBeat.o(38010);
  }
  
  private void fIy()
  {
    AppMethodBeat.i(194590);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "uploadRecordXml");
    ba.aBQ();
    Object localObject = com.tencent.mm.model.c.azs().xY(((Long)this.KpF.first).longValue());
    if (((ei)localObject).field_content == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "uploadRecordXml msgInfo.getContent() is null");
      AppMethodBeat.o(194590);
      return;
    }
    localObject = aWW(((ei)localObject).field_content);
    if (bt.isNullOrNil((String)localObject))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "uploadRecordXml filePath is null");
      AppMethodBeat.o(194590);
      return;
    }
    com.tencent.mm.i.g localg = aWX((String)localObject);
    if (!com.tencent.mm.ao.f.aGI().f(localg))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
      cT(0, "add to cdn failed");
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "uploadRecordXml filePath：%s", new Object[] { localObject });
    AppMethodBeat.o(194590);
  }
  
  private boolean iB(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (u.hasAttr(this.KoT, 65536))
    {
      String str = iD(paramList);
      this.KpJ = true;
      com.tencent.mm.ui.base.h.a(getContext(), str, null, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194563);
          SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, paramList));
          AppMethodBeat.o(194563);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(194564);
          SelectContactUI.b(SelectContactUI.this, false);
          AppMethodBeat.o(194564);
        }
      });
      bool = this.KpJ;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = iC(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean iC(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (bt.isNullOrNil(this.Kpn)) {
        this.Kpn = bt.m(paramList, ",");
      }
      for (;;)
      {
        bool = com.tencent.mm.model.w.vF(this.Kpo);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.Kpn);
        paramList.putExtra("received_card_name", this.Kpo);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!bt.isNullOrNil(this.Kpo)) {
          break;
        }
        this.Kpo = bt.m(paramList, ",");
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.Kpn, this.Kpo });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = yp(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.u.aAm());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (bt.isNullOrNil(str)) {
          break label847;
        }
        if ((((ArrayList)localObject).contains(str)) || (com.tencent.mm.model.u.aAm().equals(str))) {
          break label228;
        }
        ba.aBQ();
        am localam = com.tencent.mm.model.c.azp().Bf(str);
        if ((localam == null) || ((int)localam.gfj == 0) || (!com.tencent.mm.o.b.lM(localam.field_type))) {
          break label847;
        }
        aWV(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label847:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        Zm();
        fId().notifyDataSetChanged();
        break;
      }
      fIx();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Recommend Friends");
        ad.a(getContext(), this.Kpo, paramList);
        break;
      }
      if (u.hasAttr(this.KoT, 16384))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = bt.m(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        if (this.KpG != null)
        {
          paramList = new ChatroomInfoUI.LocalHistoryInfo();
          paramList.fileid = this.KpG.field_fileId;
          paramList.aeskey = this.KpG.field_aesKey;
          paramList.filemd5 = this.KpG.field_filemd5;
          paramList.fNA = ((int)this.KpG.field_fileLength);
          paramList.fNB = this.KpB;
          ((Intent)localObject).putExtra("select_record_msg_info", paramList);
          if (this.KpF == null) {
            break label627;
          }
        }
        label627:
        for (long l = ((Long)this.KpF.first).longValue();; l = 0L)
        {
          ((Intent)localObject).putExtra("select_record_fake_msg_id", l);
          ((Intent)localObject).putExtra("label_source", this.uWA);
          if (this.requestCode == 1) {
            bool = true;
          }
          ((Intent)localObject).putExtra("Is_Chatroom", bool);
          setResult(-1, (Intent)localObject);
          finish();
          break;
        }
      }
      if (getIntent().getBooleanExtra("shareImage", false))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Share Image");
        fIw();
        break;
      }
      if (paramList.size() > 0)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        paramList = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.ahp(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aeq(3);
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String iD(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(2131762980, new Object[] { com.tencent.mm.model.v.zf((String)paramList.get(0)) });
    }
    label62:
    do
    {
      AppMethodBeat.o(38019);
      return localObject;
      localObject = localStringBuilder;
    } while (paramList.size() <= 1);
    localObject = getString(2131755888);
    localStringBuilder = new StringBuilder();
    int i = 0;
    for (;;)
    {
      if (i < paramList.size())
      {
        if (i == 3) {
          localStringBuilder.append("...");
        }
      }
      else
      {
        localObject = getString(2131762980, new Object[] { localStringBuilder.toString() });
        break;
      }
      localStringBuilder.append(com.tencent.mm.model.v.zf((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  private void yo(boolean paramBoolean)
  {
    AppMethodBeat.i(194587);
    if (this.Kpq == 1)
    {
      enableOptionMenu(1, paramBoolean);
      AppMethodBeat.o(194587);
      return;
    }
    this.Kpy.setEnabled(paramBoolean);
    AppMethodBeat.o(194587);
  }
  
  private ArrayList<String> yp(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.vIm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.w.zB((String)localObject)))
      {
        localObject = com.tencent.mm.model.q.yR((String)localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localHashSet.add((String)((Iterator)localObject).next());
          }
        }
      }
      else
      {
        localHashSet.add(localObject);
      }
    }
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38007);
    return localArrayList;
  }
  
  private ArrayList<String> yq(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.vIm.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (com.tencent.mm.model.w.zB((String)localObject)))
      {
        localObject = com.tencent.mm.model.q.yR((String)localObject);
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            localHashSet.add((String)((Iterator)localObject).next());
          }
        }
      }
      else
      {
        localHashSet.add(localObject);
      }
    }
    localHashSet.addAll(this.Kpj);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.vIm.remove(paramString);
      if (!(fId() instanceof v)) {
        break label65;
      }
      paramString = ((v)fId()).fIc();
      this.vIo.getInputText().setText(paramString);
    }
    for (;;)
    {
      Zm();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((fId() instanceof c)) {
        fIe().Zh();
      } else {
        fId().notifyDataSetChanged();
      }
    }
  }
  
  protected final void Zd()
  {
    AppMethodBeat.i(37997);
    super.Zd();
    this.KoT = getIntent().getIntExtra("list_attr", u.Knw);
    this.title = getIntent().getStringExtra("titile");
    this.nch = getIntent().getStringExtra("sub_title");
    this.Kjz = getIntent().getIntExtra("list_type", -1);
    this.KoU = getIntent().getBooleanExtra("show_too_many_member", true);
    this.uWA = getIntent().getStringExtra("label_source");
    if ((u.hasAttr(this.KoT, 256)) && (com.tencent.mm.model.w.aBi().size() == 0)) {
      u.jU(this.KoT, 256);
    }
    this.Kpl = getIntent().getBooleanExtra("Add_SendCard", false);
    this.Kpm = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.Kpl) || (this.Kpm))
    {
      this.Kpn = bt.bI(getIntent().getStringExtra("be_send_card_name"), "");
      this.Kpo = bt.bI(getIntent().getStringExtra("received_card_name"), "");
    }
    this.Kpp = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.Kpz = getIntent().getBooleanExtra("is_select_record_msg_mode", false);
    this.Kpq = getIntent().getIntExtra("menu_mode", 1);
    this.fPi = getIntent().getStringExtra("chatroomName");
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "mRoomId：%s", new Object[] { bt.bI(this.fPi, "") });
    this.fSL = new ArrayList();
    this.vIm = new LinkedList();
    this.Kpj = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.Kpj.addAll(bt.U(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bt.isNullOrNil((String)localObject)) {
      this.vIm.addAll(bt.U(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bt.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bt.U(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.fIp());
    ((HashSet)localObject).addAll(u.fIq());
    if (!u.hasAttr(this.KoT, 268435456)) {
      ((HashSet)localObject).add(com.tencent.mm.model.u.aAm());
    }
    if (this.Kpl) {
      ((HashSet)localObject).removeAll(u.fIp());
    }
    this.fSL.add("gh_3dfda90e39d6");
    this.fSL.addAll((Collection)localObject);
    fIu();
    AppMethodBeat.o(37997);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(38002);
    super.a(paramListView, paramInt);
    Object localObject;
    final int i;
    int j;
    label328:
    int m;
    final int k;
    if (u.hasAttr(this.KoT, 256))
    {
      if (this.Kpd == null)
      {
        View.OnClickListener local23 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37982);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            localObject = new Intent();
            ((Intent)localObject).setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            ((Intent)localObject).putExtra("group_select_type", true);
            boolean bool = u.hasAttr(SelectContactUI.n(SelectContactUI.this), 16384);
            ((Intent)localObject).putExtra("group_select_need_result", bool);
            if (bool) {
              if (SelectContactUI.o(SelectContactUI.this) == 14)
              {
                ((Intent)localObject).putExtra("group_multi_select", true);
                ((Intent)localObject).putExtra("already_select_contact", bt.m(SelectContactUI.p(SelectContactUI.this), ","));
                ((Intent)localObject).putExtra("max_limit_num", SelectContactUI.this.getIntent().getIntExtra("max_limit_num", 9));
                SelectContactUI.this.startActivityForResult((Intent)localObject, 4);
              }
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37982);
              return;
              SelectContactUI.this.startActivityForResult((Intent)localObject, 0);
              continue;
              paramAnonymousView = SelectContactUI.this;
              localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        };
        if (this.Kjz == 14)
        {
          localObject = getString(2131755225);
          this.Kpd = a(paramListView, local23, (String)localObject);
        }
      }
      else
      {
        this.Kpd.setVisibility(paramInt);
      }
    }
    else
    {
      if (u.hasAttr(this.KoT, 512))
      {
        if (this.Kpe == null) {
          this.Kpe = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37983);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              com.tencent.mm.plugin.report.service.g.yhR.f(11140, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.bs.d.Q(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37983);
            }
          }, getString(2131759100));
        }
        this.Kpe.setVisibility(paramInt);
      }
      if (u.hasAttr(this.KoT, 1024))
      {
        if (this.Kpf == null) {
          this.Kpf = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(194580);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              paramAnonymousView = new Intent();
              paramAnonymousView.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
              paramAnonymousView.putExtra("group_select_type", false);
              SelectContactUI.this.startActivityForResult(paramAnonymousView, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194580);
            }
          }, getString(2131755205));
        }
        this.Kpf.setVisibility(paramInt);
      }
      if (u.hasAttr(this.KoT, 2048))
      {
        if (this.Kph == null) {
          this.Kph = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(194581);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("list_attr", 16384);
              com.tencent.mm.bs.d.b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", paramAnonymousView, 2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(194581);
            }
          }, getString(2131755219));
        }
        this.Kph.setVisibility(paramInt);
        this.Kph.setTextSize(16.0F * com.tencent.mm.cc.a.eb(this.Kph.getContext()));
      }
      if (u.hasAttr(this.KoT, 524288)) {
        if (this.Kpg == null)
        {
          localObject = "";
          i = getIntent().getIntExtra("topstory_import_type", 0);
          j = 2131755209;
          if (i != 1) {
            break label636;
          }
          localObject = com.tencent.mm.plugin.sns.b.o.zbV.zu(5L);
          if (!bt.hj((List)localObject)) {
            break label625;
          }
          i = 0;
          localObject = bt.m((List)localObject, ",");
          j = 2131755209;
          m = 2131755210;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.Kpg = a(paramListView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194560);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          com.tencent.mm.ui.base.h.e(SelectContactUI.this, SelectContactUI.this.getString(i, new Object[] { Integer.valueOf(k) }), "", SelectContactUI.this.getString(2131755206), SelectContactUI.this.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(194559);
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.2.this.KpU);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(194559);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(194560);
        }
      }, getString(j));
      this.Kpg.setTag(Integer.valueOf(k));
      localObject = this.Kpg.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.Kpg.setVisibility(8);
      }
      for (;;)
      {
        if (u.hasAttr(this.KoT, 16777216))
        {
          if (this.Kpi == null)
          {
            ba.aBQ();
            localObject = com.tencent.mm.model.c.azp().fqs();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.Kpi = a(paramListView, new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(194562);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
                  paramAnonymousView = new Intent(SelectContactUI.this.getIntent());
                  paramAnonymousView.setClass(SelectContactUI.this.getContext(), OpenIMSelectContactUI.class);
                  paramAnonymousView.removeExtra("titile");
                  paramAnonymousView.putExtra("openim_appid", "3552365301");
                  localObject = new ArrayList();
                  Iterator localIterator = SelectContactUI.q(SelectContactUI.this).iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    if (am.aSQ(str)) {
                      ((ArrayList)localObject).add(str);
                    }
                  }
                  paramAnonymousView.putExtra("already_select_contact", bt.m((List)localObject, ","));
                  SelectContactUI.this.startActivityForResult(paramAnonymousView, 5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(194562);
                }
              }, "");
              paramListView = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a("3552365301", "openim_acct_type_title", com.tencent.mm.openim.a.b.a.iHt);
              this.Kpi.setVisibility(paramInt);
              this.Kpi.setText(paramListView);
            }
          }
          if (this.Kpi != null) {
            this.Kpi.setVisibility(paramInt);
          }
        }
        if ((!u.hasAttr(this.KoT, 16777216)) || (this.Kpi == null)) {
          break label707;
        }
        this.Kpi.setBackgroundResource(2131231820);
        AppMethodBeat.o(38002);
        return;
        localObject = getString(2131755204);
        break;
        label625:
        i = ((List)localObject).size();
        break label328;
        label636:
        if (i != 2) {
          break label855;
        }
        localObject = com.tencent.mm.pluginsdk.i.d.fas();
        if (bt.hj((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = bt.m((List)localObject, ",");
          j = 2131755207;
          m = 2131755208;
          k = i;
          i = m;
          break;
        }
        this.Kpg.setVisibility(paramInt);
      }
      label707:
      if (u.hasAttr(this.KoT, 2048))
      {
        if (this.Kph != null)
        {
          this.Kph.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.KoT, 1024))
      {
        if (this.Kpf != null)
        {
          this.Kpf.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.KoT, 512))
      {
        if (this.Kpe != null)
        {
          this.Kpe.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if ((u.hasAttr(this.KoT, 256)) && (this.Kpd != null)) {
        this.Kpd.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(38002);
      return;
      label855:
      i = 2131755210;
      k = 0;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38014);
    boolean bool;
    if ((parama.KmP) && (parama.contact != null))
    {
      bool = this.vIm.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.KmQ) && (parama.contact != null))
    {
      bool = this.vIm.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof com.tencent.mm.ui.contact.a.k))
    {
      bool = this.vIm.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final boolean aRu()
  {
    return false;
  }
  
  protected final boolean aRv()
  {
    return true;
  }
  
  protected final String aRw()
  {
    return this.title;
  }
  
  protected final q aRx()
  {
    boolean bool2 = false;
    AppMethodBeat.i(38000);
    Object localObject = new c.a();
    ((c.a)localObject).Kkv = u.hasAttr(this.KoT, 16);
    ((c.a)localObject).Kku = u.hasAttr(this.KoT, 32);
    ((c.a)localObject).Kky = getIntent().getBooleanExtra("create_group_recommend", false);
    boolean bool1;
    if (!u.hasAttr(this.KoT, 4))
    {
      bool1 = true;
      ((c.a)localObject).Kkw = bool1;
      if (u.hasAttr(this.KoT, 1)) {
        break label367;
      }
      bool1 = true;
      label93:
      ((c.a)localObject).Kkx = bool1;
      ((c.a)localObject).Kkz = u.hasAttr(this.KoT, 128);
      ((c.a)localObject).KkA = u.hasAttr(this.KoT, 1048576);
      ((c.a)localObject).KkD = u.hasAttr(this.KoT, 256);
      if (((c.a)localObject).KkD) {
        ((c.a)localObject).KkE = getIntent().getStringExtra("custom_contact");
      }
      if (((c.a)localObject).Kkz)
      {
        this.KpK = true;
        ((c.a)localObject).KkB = getIntent().getStringExtra("wechat_sport_contact");
        ((c.a)localObject).KkC = getIntent().getStringExtra("wechat_sport_recent_like");
        this.KpL = ((c.a)localObject).KkB;
      }
      if (!u.fIr()) {
        break label372;
      }
    }
    label367:
    label372:
    for (((c.a)localObject).KiP = "@all.contact.without.chatroom.without.openim";; ((c.a)localObject).KiP = "@all.contact.without.chatroom.without.openim.without.openimfavour")
    {
      if ((this.scene == 6) || (this.scene == 5)) {
        ((c.a)localObject).KiP = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
        ((c.a)localObject).KiP = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      List localList1 = this.Kpj;
      List localList2 = this.vIm;
      List localList3 = this.fSL;
      boolean bool3 = u.hasAttr(this.KoT, 1);
      boolean bool4 = u.hasAttr(this.KoT, 64);
      bool1 = bool2;
      if (this.Kjz == 15) {
        bool1 = true;
      }
      localObject = new c(this, localList1, localList2, localList3, bool3, bool4, (c.a)localObject, bool1);
      AppMethodBeat.o(38000);
      return localObject;
      bool1 = false;
      break;
      bool1 = false;
      break label93;
    }
  }
  
  protected final o aRy()
  {
    AppMethodBeat.i(38001);
    if (this.KpK)
    {
      localObject = new t(this, this.fSL, u.hasAttr(this.KoT, 64), this.KpL);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new v(this, this.Kpj, this.vIm, this.fSL, u.hasAttr(this.KoT, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new s(this, this.fSL, u.hasAttr(this.KoT, 64), this.scene);
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  protected final void apt(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.g.yhR.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(yp(u.hasAttr(this.KoT, 8192)));
    paramString.addAll(this.Kpj);
    localIntent.putExtra("always_select_contact", bt.m(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", bt.m(new ArrayList(paramString), ","));
    if (u.hasAttr(this.KoT, 64))
    {
      localIntent.putExtra("list_attr", u.I(new int[] { 16384, 64, 131072 }));
      if (this.Kjz == 14) {
        localIntent.putExtra("max_limit_num", getIntent().getIntExtra("max_limit_num", 2147483647));
      }
    }
    for (;;)
    {
      startActivityForResult(localIntent, 3);
      AppMethodBeat.o(38022);
      return;
      localIntent.putExtra("list_attr", 16384);
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38015);
    if ((parama.KmP) && (parama.contact != null))
    {
      if (u.hasAttr(this.KoT, 536870912))
      {
        bool = parama.contact.adp();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.Kpj.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  public final int[] djJ()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!u.hasAttr(this.KoT, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!u.hasAttr(this.KoT, 4)) {
      localArrayList.add(Integer.valueOf(131075));
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    AppMethodBeat.o(38016);
    return arrayOfInt;
  }
  
  protected final boolean dlz()
  {
    return !this.KpK;
  }
  
  public void initView()
  {
    AppMethodBeat.i(194585);
    super.initView();
    this.Kpr = ((RelativeLayout)findViewById(2131308411));
    this.Kps = ((LinearLayout)findViewById(2131308410));
    this.Kpy = ((Button)findViewById(2131300102));
    this.Kpt = ((ImageView)findViewById(2131308413));
    this.Kpu = ((ImageView)findViewById(2131308415));
    this.Kpv = ((ImageView)findViewById(2131308412));
    this.Kpw = ((ProgressBar)findViewById(2131308392));
    this.Kpx = ((TextView)findViewById(2131308414));
    this.Kps.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37978);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "click selectRecordMsgBt %s", new Object[] { bt.bI(SelectContactUI.d(SelectContactUI.this), "") });
        SelectContactUI.this.hideVKB();
        paramAnonymousView = new Intent().putExtra("Chat_User", SelectContactUI.d(SelectContactUI.this)).putExtra("finish_direct", true).putExtra("key_record_msg_select", true).putExtra("key_record_msg_select_introduce", SelectContactUI.g(SelectContactUI.this)).putExtra("key_record_select_min_msg_id", SelectContactUI.f(SelectContactUI.this)).putExtra("key_record_select_msg_num", SelectContactUI.e(SelectContactUI.this));
        if (SelectContactUI.h(SelectContactUI.this) != null) {
          paramAnonymousView.putStringArrayListExtra("key_record_select_msg_black_list", SelectContactUI.h(SelectContactUI.this));
        }
        com.tencent.mm.bs.d.c(SelectContactUI.this, ".ui.chatting.ChattingUI", paramAnonymousView, 6);
        SelectContactUI.i(SelectContactUI.this);
        com.tencent.mm.plugin.selectrecord.b.a.dNa().yBX.eiB = 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37978);
      }
    });
    this.Kpu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "click warn to retry");
        SelectContactUI.a(SelectContactUI.this, null);
        SelectContactUI.j(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, true);
        SelectContactUI.k(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, com.tencent.mm.ui.chatting.k.l(SelectContactUI.this, "msginfo@fakeuser", true));
        if (!((Boolean)SelectContactUI.a(SelectContactUI.this).second).booleanValue()) {
          SelectContactUI.l(SelectContactUI.this).alive();
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
          paramAnonymousView.yCh += 1;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "click warn to retry, msgId:%s direct:%s", new Object[] { SelectContactUI.a(SelectContactUI.this).first, SelectContactUI.a(SelectContactUI.this).second });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37979);
          return;
          SelectContactUI.b(SelectContactUI.this);
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.dNb();
    Object localObject = com.tencent.mm.plugin.selectrecord.b.a.dNa();
    String str = this.fPi;
    et localet = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).yBX;
    localet.eir = localet.t("RoomId", str, true);
    localObject = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).yBX;
    int i;
    if (com.tencent.mm.model.w.zn(str))
    {
      i = 1;
      ((et)localObject).eiV = i;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qGW, 0);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.recordSelect.SelectRecordConfig", "canSelectRecordInAddRoomMembers() sw:%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label380;
      }
      i = 1;
      label250:
      if ((i == 0) || (!com.tencent.mm.model.w.zk(this.fPi)) || (com.tencent.mm.model.w.zn(this.fPi)) || (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().aqx(this.fPi) <= 0L)) {
        break label385;
      }
      this.Kps.setVisibility(0);
      com.tencent.mm.plugin.selectrecord.b.a.dNa().qL(true);
      if (this.xfg != null) {
        this.Kpr.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194579);
            int i = SelectContactUI.m(SelectContactUI.this).getHeight();
            if (i > 0)
            {
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)SelectContactUI.this.xfg.getLayoutParams();
              localLayoutParams.bottomMargin = i;
              SelectContactUI.this.xfg.setLayoutParams(localLayoutParams);
            }
            AppMethodBeat.o(194579);
          }
        });
      }
    }
    for (;;)
    {
      if (this.Kpq == 2)
      {
        this.fQT = new com.tencent.mm.ui.tools.h(this);
        this.fQT.KIP = this;
      }
      AppMethodBeat.o(194585);
      return;
      i = 0;
      break;
      label380:
      i = 0;
      break label250;
      label385:
      this.Kps.setVisibility(8);
      com.tencent.mm.plugin.selectrecord.b.a.dNa().qL(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38021);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.requestCode = paramInt1;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38021);
      return;
    }
    switch (paramInt1)
    {
    }
    label563:
    do
    {
      Object localObject1;
      String str1;
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(38021);
            return;
            paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          } while (bt.isNullOrNil(paramIntent));
          iB(bt.U(new String[] { paramIntent }));
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          localObject1 = this.vIm.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            this.vIo.aMy(str1);
          }
          this.vIm.clear();
          if (!bt.isNullOrNil(paramIntent)) {
            this.vIm.addAll(bt.U(paramIntent.split(",")));
          }
          paramIntent = this.vIm.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.vIo.aMz((String)localObject1);
          }
          Zm();
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Contact");
        } while (bt.isNullOrNil(paramIntent));
        iB(bt.U(paramIntent.split(",")));
        AppMethodBeat.o(38021);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bt.isNullOrNil(paramIntent)) {
        iB(bt.U(new String[] { paramIntent }));
      }
      AppMethodBeat.o(38021);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bt.isNullOrNil(paramIntent))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38021);
        return;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      if (u.hasAttr(this.KoT, 64))
      {
        paramIntent = paramIntent.split(",");
        paramInt2 = paramIntent.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject1 = paramIntent[paramInt1];
          if (this.vIm.add(localObject1)) {
            this.vIo.aMx((String)localObject1);
          }
          paramInt1 += 1;
        }
        Zm();
        fId().notifyDataSetChanged();
        AppMethodBeat.o(38021);
        return;
      }
      iB(bt.U(new String[] { paramIntent }));
      AppMethodBeat.o(38021);
      return;
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("Select_Contact");
        localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
        if (bt.isNullOrNil(str1))
        {
          paramIntent = null;
          if (!bt.isNullOrNil((String)localObject1)) {
            break label642;
          }
          localObject1 = null;
        }
        Object localObject2;
        for (;;)
        {
          if (paramIntent != null)
          {
            if (this.vIo != null)
            {
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  String str2 = (String)((Iterator)localObject2).next();
                  if (!this.vIm.contains(str2))
                  {
                    this.vIo.aMx(str2);
                    continue;
                    paramIntent = bt.lO(str1, ",");
                    break;
                    localObject1 = bt.lO((String)localObject1, ",");
                    break label563;
                  }
                }
              }
            }
            this.vIm.addAll(paramIntent);
          }
        }
        if (localObject1 != null)
        {
          if (this.vIo != null)
          {
            paramIntent = ((List)localObject1).iterator();
            while (paramIntent.hasNext())
            {
              localObject2 = (String)paramIntent.next();
              this.vIo.aMx((String)localObject2);
            }
          }
          this.vIm.removeAll((Collection)localObject1);
        }
        fId().notifyDataSetChanged();
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
          iB(bt.U(new String[] { str1 }));
        }
      }
      Zm();
      AppMethodBeat.o(38021);
      return;
    } while (paramIntent == null);
    label642:
    this.KpA = paramIntent.getIntExtra("select_record_msg_num", 0);
    this.KpB = this.KpA;
    this.KpH = paramIntent.getStringArrayListExtra("key_select_record_msg_black_list");
    this.KpG = null;
    this.KpD = false;
    if (this.KpA == 0)
    {
      this.KpC = false;
      fIv();
    }
    for (;;)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.a.dNa();
      long l = this.KpB;
      paramIntent.yBX.eiE = l;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "GET_SELECT_RECORD_MSG selectMsgNum:%s actualSelectMsgNum:%s msgId:%s direct:%s", new Object[] { Integer.valueOf(this.KpA), Integer.valueOf(this.KpB), this.KpF.first, this.KpF.second });
      break;
      this.KpC = true;
      this.JMa = paramIntent.getLongExtra("select_record_min_msg_id", -1L);
      if ((com.tencent.mm.ui.chatting.k.fBm() > 0) && (com.tencent.mm.ui.chatting.k.fBm() < this.KpA)) {
        this.KpB = com.tencent.mm.ui.chatting.k.fBm();
      }
      fIv();
      com.tencent.mm.plugin.selectrecord.b.a.dNa().yCf = cf.aCK();
      this.KpF = com.tencent.mm.ui.chatting.k.c(this, "msginfo@fakeuser", true, this.fPi);
      if (!((Boolean)this.KpF.second).booleanValue()) {
        this.KpM.alive();
      } else {
        fIy();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "create!");
    ba.aiU().a(30, this);
    ba.aiU().a(138, this);
    if (!bt.isNullOrNil(this.nch)) {
      setMMSubTitle(this.nch);
    }
    int i;
    if (u.hasAttr(this.KoT, 64))
    {
      if (this.Kpq == 1)
      {
        this.Kpr.setVisibility(8);
        addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(194565);
            boolean bool = SelectContactUI.r(SelectContactUI.this);
            AppMethodBeat.o(194565);
            return bool;
          }
        }, null, s.b.JbS);
      }
    }
    else
    {
      Zm();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(194572);
          SelectContactUI.this.hideVKB();
          SelectContactUI.this.finish();
          if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            aq.o(SelectContactUI.c(SelectContactUI.this), 80L);
          }
          AppMethodBeat.o(194572);
          return true;
        }
      });
      if ((this.Kjz != 15) && (this.vIo != null)) {
        this.vIo.hd(this.vIm);
      }
      if (getIntent().getBooleanExtra("create_group_recommend", false)) {
        switch (this.scene)
        {
        case 4: 
        case 5: 
        case 6: 
        default: 
          i = 0;
        }
      }
    }
    for (;;)
    {
      w.Koj = i;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(37995);
      return;
      this.Kpr.setVisibility(0);
      this.Kpy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(194568);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (SelectContactUI.s(SelectContactUI.this))
          {
            com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(2131767122), "", SelectContactUI.this.getString(2131766205), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(194566);
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                AppMethodBeat.o(194566);
              }
            });
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
            paramAnonymousView.yCj += 1;
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(194568);
            return;
            if (SelectContactUI.t(SelectContactUI.this))
            {
              com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(2131767121), "", SelectContactUI.this.getString(2131766205), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(194567);
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "initMenu(upload fail) click i know");
                  AppMethodBeat.o(194567);
                }
              });
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dNa();
              paramAnonymousView.yCk += 1;
              com.tencent.mm.plugin.selectrecord.b.a.dNa().dNe();
            }
            else
            {
              SelectContactUI.r(SelectContactUI.this);
            }
          }
        }
      });
      break;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37996);
    this.KpM.dead();
    ba.aiU().b(30, this);
    ba.aiU().b(138, this);
    aeq(1);
    w.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(194584);
    super.onPause();
    if (this.fQT != null) {
      this.fQT.close();
    }
    AppMethodBeat.o(194584);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(194582);
    super.onResume();
    if (this.fQT != null) {
      this.fQT.start();
    }
    AppMethodBeat.o(194582);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(38013);
    if (this.fMu != null)
    {
      this.fMu.dismiss();
      this.fMu = null;
    }
    if (!bt.jh(this))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if (y.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bt.isNullOrNil(paramString))) {
        Toast.makeText(this, paramString, 1).show();
      }
      AppMethodBeat.o(38013);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38013);
      return;
      fId().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(194583);
    super.onWindowFocusChanged(paramBoolean);
    if (this.fQT != null) {
      this.fQT.start();
    }
    AppMethodBeat.at(this, paramBoolean);
    AppMethodBeat.o(194583);
  }
  
  public final void rg(int paramInt)
  {
    AppMethodBeat.i(37998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37998);
      return;
    }
    Object localObject1 = fId().aen(i);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37998);
      return;
    }
    if ((localObject1 instanceof com.tencent.mm.ui.contact.a.k))
    {
      if (u.hasAttr(this.KoT, 16384))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("Select_Contact", "");
        ((Intent)localObject1).putExtra("Select_Conv_User", "");
        ((Intent)localObject1).putExtra("Select_Contact", "");
        setResult(-1, (Intent)localObject1);
        finish();
      }
      AppMethodBeat.o(37998);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject1).contact == null)
    {
      AppMethodBeat.o(37998);
      return;
    }
    if (((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(37998);
      return;
    }
    localObject1 = ((com.tencent.mm.ui.contact.a.a)localObject1).contact.field_username;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { localObject1 });
    if (u.hasAttr(this.KoT, 64))
    {
      Object localObject2;
      if ((com.tencent.mm.model.w.vF((String)localObject1)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        localObject2 = new Intent(this, ChattingUI.class);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        aeq(3);
        AppMethodBeat.o(37998);
        return;
      }
      if ((u.hasAttr(this.KoT, 131072)) && (this.vIm.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.Kpj.contains(localObject1))
        {
          fIk();
          if (!this.vIm.contains(localObject1)) {
            break label481;
          }
          this.vIo.aMx((String)localObject1);
          this.vIm.remove(localObject1);
        }
      }
      for (;;)
      {
        Zm();
        fIu();
        fIe().notifyDataSetChanged();
        AppMethodBeat.o(37998);
        return;
        label481:
        localObject2 = getIntent().getStringExtra("too_many_member_tip_string");
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject1 = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), (String)localObject1, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        aWV((String)localObject1);
      }
    }
    iB(bt.U(new String[] { localObject1 }));
    AppMethodBeat.o(37998);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194586);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.KpO == paramBoolean; paramBoolean = false)
    {
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SelectContactUI", "onKeyboardHeightChanged repeat");
      AppMethodBeat.o(194586);
      return;
    }
    if (this.uCd == 0) {
      this.uCd = paramInt;
    }
    if (paramBoolean) {
      if (this.Kpr.getTranslationY() != 0.0F) {
        this.Kpr.setTranslationY(0.0F);
      }
    }
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.Kpr, "translationY", new float[] { this.Kpr.getTranslationY(), this.Kpr.getTranslationY() - this.uCd });; localObjectAnimator = ObjectAnimator.ofFloat(this.Kpr, "translationY", new float[] { this.Kpr.getTranslationY(), this.Kpr.getTranslationY() + this.uCd }))
    {
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setInterpolator(new android.support.v4.view.b.b());
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(194561);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(194561);
        }
      });
      localObjectAnimator.start();
      this.KpO = paramBoolean;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.SelectContactUI", "height:%s moveHeight:%s isKeyboardShow:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uCd), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(194586);
      return;
    }
  }
  
  static final class a
  {
    private AlphaAnimation Kqc;
    private AlphaAnimation Kqd;
    boolean Kqe = false;
    TextView lZb;
    
    final void bl(Activity paramActivity)
    {
      AppMethodBeat.i(37989);
      if (this.lZb == null) {
        this.lZb = ((TextView)paramActivity.findViewById(2131304506));
      }
      if (this.lZb.getVisibility() == 8)
      {
        AppMethodBeat.o(37989);
        return;
      }
      if (this.Kqd == null)
      {
        this.Kqd = new AlphaAnimation(1.0F, 0.0F);
        this.Kqd.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(37987);
            SelectContactUI.a.this.lZb.setVisibility(8);
            AppMethodBeat.o(37987);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      this.Kqd.setDuration(300L);
      if (this.Kqc != null) {
        this.Kqc.cancel();
      }
      this.lZb.startAnimation(this.Kqd);
      AppMethodBeat.o(37989);
    }
    
    public final void e(final Activity paramActivity, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37988);
      if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.Kqe))
      {
        if (this.lZb == null) {
          this.lZb = ((TextView)paramActivity.findViewById(2131304506));
        }
        if (this.lZb.getVisibility() != 0)
        {
          this.lZb.setText(2131762573);
          this.lZb.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37986);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              SelectContactUI.a.this.Kqe = true;
              SelectContactUI.a.this.bl(paramActivity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37986);
            }
          });
          if (this.Kqc == null) {
            this.Kqc = new AlphaAnimation(0.0F, 1.0F);
          }
          this.Kqc.setDuration(300L);
          if (this.Kqd != null) {
            this.Kqd.cancel();
          }
          this.lZb.setVisibility(0);
          this.lZb.startAnimation(this.Kqc);
        }
        AppMethodBeat.o(37988);
        return;
      }
      if (paramInt1 < paramInt2)
      {
        bl(paramActivity);
        this.Kqe = false;
      }
      AppMethodBeat.o(37988);
    }
  }
  
  static final class b
    implements Runnable
  {
    private WeakReference<SelectContactUI> cya;
    
    private b(SelectContactUI paramSelectContactUI)
    {
      AppMethodBeat.i(37990);
      this.cya = new WeakReference(paramSelectContactUI);
      AppMethodBeat.o(37990);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37991);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cya.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37991);
        return;
      }
      localSelectContactUI.moveTaskToBack(true);
      AppMethodBeat.o(37991);
    }
  }
  
  static final class c
    implements Runnable
  {
    private ArrayList<String> Kqg;
    private WeakReference<SelectContactUI> cya;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.cya = new WeakReference(paramSelectContactUI);
      this.Kqg = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cya.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = com.tencent.mm.model.u.aAm();
      Iterator localIterator = this.Kqg.iterator();
      int i = 0;
      Object localObject1 = null;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (com.tencent.mm.model.w.vF((String)localObject2))
        {
          j = 1;
          label94:
          i += j;
          o.e locale = com.tencent.mm.modelmulti.o.a(o.d.ifX).pk(4);
          locale.dyU = str;
          locale.toUser = ((String)localObject2);
          locale.ibF = localSelectContactUI.getIntent().getStringExtra("shareImagePath");
          locale.hZz = 0;
          locale.igd = null;
          locale.dxr = 0;
          locale.hZI = "";
          locale.thumbPath = "";
          locale.igg = true;
          locale.igf = 2131231564;
          locale.thumbPath = ((String)localObject1);
          locale.igc = 11;
          localObject2 = locale.aJv();
          ((o.b)localObject2).execute();
          localObject2 = (com.tencent.mm.aw.n)((o.b)localObject2).ifV;
          if (((com.tencent.mm.aw.n)localObject2).aIr() == null) {
            break label332;
          }
          localObject1 = ((com.tencent.mm.aw.n)localObject2).aIr().field_imgPath;
        }
      }
      label332:
      for (;;)
      {
        break;
        j = 0;
        break label94;
        SelectContactUI.C(localSelectContactUI).dismiss();
        localObject1 = new Intent();
        ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.Kqg);
        localSelectContactUI.setResult(-1, (Intent)localObject1);
        com.tencent.mm.plugin.report.service.g.yhR.f(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Kqg.size() - i), Integer.valueOf(i) });
        localSelectContactUI.finish();
        AppMethodBeat.o(37993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */