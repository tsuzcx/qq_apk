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
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.b.a.ev;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.r;
import com.tencent.mm.model.x;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.n.e;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.k;
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
  implements com.tencent.mm.ak.f, com.tencent.mm.ui.tools.g
{
  private int KFT;
  private TextView KLA;
  private TextView KLB;
  private TextView KLC;
  private List<String> KLD;
  private Map<String, Integer> KLE;
  private boolean KLF;
  private boolean KLG;
  private String KLH;
  private String KLI;
  private boolean KLJ;
  private int KLK;
  private RelativeLayout KLL;
  private LinearLayout KLM;
  private ImageView KLN;
  private ImageView KLO;
  private ImageView KLP;
  private ProgressBar KLQ;
  private TextView KLR;
  private Button KLS;
  private boolean KLT;
  private int KLU;
  private int KLV;
  private boolean KLW;
  private boolean KLX;
  private boolean KLY;
  private Pair<Long, Boolean> KLZ;
  private int KLn;
  private boolean KLo;
  private a KLp;
  private TextView KLx;
  private TextView KLy;
  private TextView KLz;
  private com.tencent.mm.i.d KMa;
  private ArrayList<String> KMb;
  private boolean KMc;
  private boolean KMd;
  private boolean KMe;
  private String KMf;
  private com.tencent.mm.sdk.b.c<qh> KMg;
  private b KMh;
  private boolean KMi;
  private boolean KMj;
  private HashMap<String, String> KMk;
  private long KgW;
  private ProgressDialog fOC;
  private String fRo;
  private com.tencent.mm.ui.tools.h fSZ;
  private List<String> fUR;
  private String nhq;
  private int requestCode;
  private g.a rnU;
  private String title;
  private int uNI;
  private List<String> vUq;
  private String vio;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.KLE = new HashMap();
    this.KLU = 0;
    this.KLV = 0;
    this.KLW = false;
    this.KLX = false;
    this.KLY = true;
    this.KLZ = new Pair(Long.valueOf(-1L), Boolean.FALSE);
    this.KgW = -1L;
    this.KMb = null;
    this.KLo = true;
    this.KMe = false;
    this.KMg = new com.tencent.mm.sdk.b.c() {};
    this.KMh = new b(this, (byte)0);
    this.KMi = false;
    this.KMj = false;
    this.KMk = new HashMap();
    this.rnU = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187977);
        if (paramAnonymousInt == -21005)
        {
          ae.i("MicroMsg.SelectContactUI", "ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(187977);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd);
          SelectContactUI.a(SelectContactUI.this, false);
          ae.i("MicroMsg.SelectContactUI", "sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] result:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(com.tencent.mm.vfs.o.deleteFile((String)SelectContactUI.E(SelectContactUI.this).get(paramAnonymousString))) });
          SelectContactUI.k(SelectContactUI.this);
          com.tencent.mm.plugin.selectrecord.b.a.dQt().zC(ch.aDa());
          AppMethodBeat.o(187977);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          ae.w("MicroMsg.SelectContactUI", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd.field_retCode, "cdn ret error");
          AppMethodBeat.o(187977);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          ae.w("MicroMsg.SelectContactUI", "start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, 0, "cdn start error");
          AppMethodBeat.o(187977);
          return 0;
        }
        ae.i("MicroMsg.SelectContactUI", "on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null) {
          ae.d("MicroMsg.SelectContactUI", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
        }
        AppMethodBeat.o(187977);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.KLp = new a();
    AppMethodBeat.o(37994);
  }
  
  private static List<String> P(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!bc.ajM())
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
      bc.aCg();
      an localan = com.tencent.mm.model.c.azF().BH(str);
      paramList = str;
      if (localan != null)
      {
        paramList = str;
        if ((int)localan.ght != 0) {
          paramList = localan.adG();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private void W(int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(187996);
    ae.i("MicroMsg.SelectContactUI", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt), bu.bI(paramString1, "") });
    this.KLX = true;
    this.KLW = false;
    fMN();
    com.tencent.e.h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187979);
        SelectContactUI localSelectContactUI = SelectContactUI.this;
        if (bu.isNullOrNil(paramString2)) {}
        for (String str = SelectContactUI.this.getString(2131767121);; str = paramString2)
        {
          com.tencent.mm.ui.base.h.a(localSelectContactUI, str, "", SelectContactUI.this.getString(2131766205), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(187978);
              ae.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
              AppMethodBeat.o(187978);
            }
          });
          AppMethodBeat.o(187979);
          return;
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.dQt().zC(ch.aDa());
    com.tencent.mm.plugin.selectrecord.b.a.dQt().dQx();
    AppMethodBeat.o(187996);
  }
  
  private void Zv()
  {
    AppMethodBeat.i(38006);
    if ((u.hasAttr(this.KLn, 64)) && (this.vUq.size() > 0))
    {
      aYv(getString(2131755779) + "(" + this.vUq.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.KLn, 262144)) && (this.vUq.size() < i))
      {
        yB(false);
        AppMethodBeat.o(38006);
        return;
      }
      yB(true);
      AppMethodBeat.o(38006);
      return;
    }
    if ((u.hasAttr(this.KLn, 64)) && (u.hasAttr(this.KLn, 4194304)))
    {
      aYv(getString(2131755779));
      yB(true);
      AppMethodBeat.o(38006);
      return;
    }
    aYv(getString(2131755779));
    yB(false);
    AppMethodBeat.o(38006);
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = z.jV(this).inflate(2131494420, null);
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
        AppMethodBeat.i(187975);
        SelectContactUI.D(SelectContactUI.this);
        parama.cancel();
        AppMethodBeat.o(187975);
      }
    });
    aeZ(2);
    AppMethodBeat.o(38011);
  }
  
  private void aYv(String paramString)
  {
    AppMethodBeat.i(187989);
    if (this.KLK == 1)
    {
      updateOptionMenuText(1, paramString);
      AppMethodBeat.o(187989);
      return;
    }
    this.KLS.setText(paramString);
    AppMethodBeat.o(187989);
  }
  
  private void aYw(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.KLD.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.vUq.contains(paramString))
    {
      this.vUq.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (fMv() == fMw()) {
          break label311;
        }
        ((c)fMw()).KGL.reset();
        fMw().Zq();
        this.KJu.ckg();
        hideVKB();
      }
      label108:
      if (!(fMv() instanceof v)) {
        break label339;
      }
      String str = ((v)fMv()).fMu();
      if (this.vUs != null) {
        this.vUs.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.vUs.aNT(paramString);
      AppMethodBeat.o(38018);
      return;
      this.vUq.add(paramString);
      if ((fMv() instanceof v))
      {
        if (((v)fMv()).fMK())
        {
          this.KLE.put(paramString, Integer.valueOf(((v)fMv()).aYs(paramString)));
          i = 0;
          break;
        }
        this.KLE.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (fMv() == fMw())
      {
        if (((c)fMw()).aYm(paramString))
        {
          this.KLE.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.KLE.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label311:
      if ((i == 0) && (!((c)fMw()).aYm(paramString))) {
        break label108;
      }
      fMw().Zq();
      break label108;
      label339:
      fMC();
    }
  }
  
  private static String aYx(String paramString)
  {
    AppMethodBeat.i(187992);
    if (bu.isNullOrNil(paramString))
    {
      ae.e("MicroMsg.SelectContactUI", "xml is null");
      AppMethodBeat.o(187992);
      return null;
    }
    String str = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
    if (!com.tencent.mm.vfs.o.fB(str)) {
      com.tencent.mm.vfs.o.aZI(str);
    }
    try
    {
      str = str + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      if (com.tencent.mm.vfs.o.fB(str)) {
        com.tencent.mm.vfs.o.deleteFile(str);
      }
      paramString = paramString.getBytes();
      com.tencent.mm.vfs.o.f(str, paramString, paramString.length);
      paramString = com.tencent.mm.plugin.selectrecord.b.a.dQt();
      long l = com.tencent.mm.vfs.o.aZR(str);
      paramString.yRY.ekA = l;
      AppMethodBeat.o(187992);
      return str;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.SelectContactUI", paramString, "", new Object[0]);
      AppMethodBeat.o(187992);
    }
    return null;
  }
  
  private com.tencent.mm.i.g aYy(String paramString)
  {
    AppMethodBeat.i(187993);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.dPh = true;
    localg.fLm = this.rnU;
    localg.field_mediaId = agT(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.fKA;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 0;
    localg.field_bzScene = 0;
    this.KMk.put(localg.field_mediaId, localg.field_fullpath);
    AppMethodBeat.o(187993);
    return localg;
  }
  
  private void aeZ(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.KMj)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.KMj = true;
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
        localObject = this.vUq.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.KLE.containsKey(str)) {
          switch (((Integer)this.KLE.get(str)).intValue())
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
      ae.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(fMv().fLZ()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.g.yxI.f(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(fMv().fLZ()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.KLD);
      ((List)localObject).addAll(this.vUq);
      w.iK((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private static String agT(String paramString)
  {
    AppMethodBeat.i(187994);
    paramString = com.tencent.mm.b.g.getMessageDigest((bu.HQ() + ", " + paramString).getBytes());
    AppMethodBeat.o(187994);
    return paramString;
  }
  
  private void cT(int paramInt, String paramString)
  {
    AppMethodBeat.i(187995);
    W(paramInt, paramString, "");
    AppMethodBeat.o(187995);
  }
  
  private void fMM()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.KLo) && ((this.KFT == 1) || (this.KFT == 0))) {
      if (this.KLD == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.KLD.size();; i = 0)
    {
      if (this.vUq != null) {
        j = this.vUq.size();
      }
      int k = bu.aSB(com.tencent.mm.n.g.acL().getValue("ChatRoomInviteStartCount"));
      this.KLp.e(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void fMN()
  {
    AppMethodBeat.i(187990);
    com.tencent.e.h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187970);
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
            AppMethodBeat.o(187970);
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
            AppMethodBeat.o(187970);
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
            AppMethodBeat.o(187970);
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
        AppMethodBeat.o(187970);
      }
    });
    AppMethodBeat.o(187990);
  }
  
  private void fMO()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = yC(true);
    localArrayList.remove(com.tencent.mm.model.v.aAC());
    if (localArrayList.size() > 0)
    {
      this.fOC = com.tencent.mm.ui.base.h.b(getContext(), getString(2131761075), false, null);
      bc.ajU().aw(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void fMP()
  {
    AppMethodBeat.i(38010);
    Object localObject = yC(false);
    ((ArrayList)localObject).remove(com.tencent.mm.model.v.aAC());
    final String str = bu.m((List)localObject, ",");
    if (!bu.ht((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(2131760621), "", getString(2131760620), getString(2131760619), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187971);
          ae.i("MicroMsg.SelectContactUI", "return the result,and create new label");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(187971);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187972);
          ae.i("MicroMsg.SelectContactUI", "return the result");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(187972);
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
  
  private void fMQ()
  {
    AppMethodBeat.i(187991);
    ae.i("MicroMsg.SelectContactUI", "uploadRecordXml");
    bc.aCg();
    Object localObject = com.tencent.mm.model.c.azI().ys(((Long)this.KLZ.first).longValue());
    if (((ei)localObject).field_content == null)
    {
      ae.e("MicroMsg.SelectContactUI", "uploadRecordXml msgInfo.getContent() is null");
      AppMethodBeat.o(187991);
      return;
    }
    localObject = aYx(((ei)localObject).field_content);
    if (bu.isNullOrNil((String)localObject))
    {
      ae.e("MicroMsg.SelectContactUI", "uploadRecordXml filePath is null");
      AppMethodBeat.o(187991);
      return;
    }
    com.tencent.mm.i.g localg = aYy((String)localObject);
    if (!com.tencent.mm.an.f.aGZ().f(localg))
    {
      ae.e("MicroMsg.SelectContactUI", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
      cT(0, "add to cdn failed");
    }
    ae.i("MicroMsg.SelectContactUI", "uploadRecordXml filePath：%s", new Object[] { localObject });
    AppMethodBeat.o(187991);
  }
  
  private boolean iL(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    ae.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (u.hasAttr(this.KLn, 65536))
    {
      String str = iN(paramList);
      this.KMd = true;
      com.tencent.mm.ui.base.h.a(getContext(), str, null, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187964);
          SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, paramList));
          AppMethodBeat.o(187964);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187965);
          SelectContactUI.b(SelectContactUI.this, false);
          AppMethodBeat.o(187965);
        }
      });
      bool = this.KMd;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = iM(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean iM(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (bu.isNullOrNil(this.KLH)) {
        this.KLH = bu.m(paramList, ",");
      }
      for (;;)
      {
        bool = x.wb(this.KLI);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.KLH);
        paramList.putExtra("received_card_name", this.KLI);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!bu.isNullOrNil(this.KLI)) {
          break;
        }
        this.KLI = bu.m(paramList, ",");
      }
      ae.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.KLH, this.KLI });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      ae.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = yC(false);
      ((ArrayList)localObject).remove(com.tencent.mm.model.v.aAC());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (bu.isNullOrNil(str)) {
          break label847;
        }
        if ((((ArrayList)localObject).contains(str)) || (com.tencent.mm.model.v.aAC().equals(str))) {
          break label228;
        }
        bc.aCg();
        an localan = com.tencent.mm.model.c.azF().BH(str);
        if ((localan == null) || ((int)localan.ght == 0) || (!com.tencent.mm.contact.c.lO(localan.field_type))) {
          break label847;
        }
        aYw(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label847:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        Zv();
        fMv().notifyDataSetChanged();
        break;
      }
      fMP();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        ae.i("MicroMsg.SelectContactUI", "Recommend Friends");
        ad.a(getContext(), this.KLI, paramList);
        break;
      }
      if (u.hasAttr(this.KLn, 16384))
      {
        ae.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = bu.m(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        if (this.KMa != null)
        {
          paramList = new ChatroomInfoUI.LocalHistoryInfo();
          paramList.fileid = this.KMa.field_fileId;
          paramList.aeskey = this.KMa.field_aesKey;
          paramList.filemd5 = this.KMa.field_filemd5;
          paramList.fPH = ((int)this.KMa.field_fileLength);
          paramList.fPI = this.KLV;
          ((Intent)localObject).putExtra("select_record_msg_info", paramList);
          if (this.KLZ == null) {
            break label627;
          }
        }
        label627:
        for (long l = ((Long)this.KLZ.first).longValue();; l = 0L)
        {
          ((Intent)localObject).putExtra("select_record_fake_msg_id", l);
          ((Intent)localObject).putExtra("label_source", this.vio);
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
        ae.i("MicroMsg.SelectContactUI", "Share Image");
        fMO();
        break;
      }
      if (paramList.size() > 0)
      {
        ae.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        paramList = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.ahE(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aeZ(3);
        break;
      }
      ae.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String iN(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(2131762980, new Object[] { com.tencent.mm.model.w.zP((String)paramList.get(0)) });
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
      localStringBuilder.append(com.tencent.mm.model.w.zP((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  private void yB(boolean paramBoolean)
  {
    AppMethodBeat.i(187988);
    if (this.KLK == 1)
    {
      enableOptionMenu(1, paramBoolean);
      AppMethodBeat.o(187988);
      return;
    }
    this.KLS.setEnabled(paramBoolean);
    AppMethodBeat.o(187988);
  }
  
  private ArrayList<String> yC(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.vUq.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (x.Al((String)localObject)))
      {
        localObject = r.zB((String)localObject);
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
  
  private ArrayList<String> yD(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.vUq.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (x.Al((String)localObject)))
      {
        localObject = r.zB((String)localObject);
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
    localHashSet.addAll(this.KLD);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  public final void Q(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.vUq.remove(paramString);
      if (!(fMv() instanceof v)) {
        break label65;
      }
      paramString = ((v)fMv()).fMu();
      this.vUs.getInputText().setText(paramString);
    }
    for (;;)
    {
      Zv();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((fMv() instanceof c)) {
        fMw().Zq();
      } else {
        fMv().notifyDataSetChanged();
      }
    }
  }
  
  protected final void Zm()
  {
    AppMethodBeat.i(37997);
    super.Zm();
    this.KLn = getIntent().getIntExtra("list_attr", u.KJQ);
    this.title = getIntent().getStringExtra("titile");
    this.nhq = getIntent().getStringExtra("sub_title");
    this.KFT = getIntent().getIntExtra("list_type", -1);
    this.KLo = getIntent().getBooleanExtra("show_too_many_member", true);
    this.vio = getIntent().getStringExtra("label_source");
    if ((u.hasAttr(this.KLn, 256)) && (x.aBy().size() == 0)) {
      u.kb(this.KLn, 256);
    }
    this.KLF = getIntent().getBooleanExtra("Add_SendCard", false);
    this.KLG = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.KLF) || (this.KLG))
    {
      this.KLH = bu.bI(getIntent().getStringExtra("be_send_card_name"), "");
      this.KLI = bu.bI(getIntent().getStringExtra("received_card_name"), "");
    }
    this.KLJ = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.KLT = getIntent().getBooleanExtra("is_select_record_msg_mode", false);
    this.KLK = getIntent().getIntExtra("menu_mode", 1);
    this.fRo = getIntent().getStringExtra("chatroomName");
    ae.i("MicroMsg.SelectContactUI", "mRoomId：%s", new Object[] { bu.bI(this.fRo, "") });
    this.fUR = new ArrayList();
    this.vUq = new LinkedList();
    this.KLD = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!bu.isNullOrNil((String)localObject)) {
      this.KLD.addAll(bu.U(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!bu.isNullOrNil((String)localObject)) {
      this.vUq.addAll(bu.U(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!bu.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(bu.U(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.fMH());
    ((HashSet)localObject).addAll(u.fMI());
    if (!u.hasAttr(this.KLn, 268435456)) {
      ((HashSet)localObject).add(com.tencent.mm.model.v.aAC());
    }
    if (this.KLF) {
      ((HashSet)localObject).removeAll(u.fMH());
    }
    this.fUR.add("gh_3dfda90e39d6");
    this.fUR.addAll((Collection)localObject);
    fMM();
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
    if (u.hasAttr(this.KLn, 256))
    {
      if (this.KLx == null)
      {
        View.OnClickListener local23 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37982);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            localObject = new Intent();
            ((Intent)localObject).setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
            ((Intent)localObject).putExtra("group_select_type", true);
            boolean bool = u.hasAttr(SelectContactUI.n(SelectContactUI.this), 16384);
            ((Intent)localObject).putExtra("group_select_need_result", bool);
            if (bool) {
              if (SelectContactUI.o(SelectContactUI.this) == 14)
              {
                ((Intent)localObject).putExtra("group_multi_select", true);
                ((Intent)localObject).putExtra("already_select_contact", bu.m(SelectContactUI.p(SelectContactUI.this), ","));
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
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, "com/tencent/mm/ui/contact/SelectContactUI$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        };
        if (this.KFT == 14)
        {
          localObject = getString(2131755225);
          this.KLx = a(paramListView, local23, (String)localObject);
        }
      }
      else
      {
        this.KLx.setVisibility(paramInt);
      }
    }
    else
    {
      if (u.hasAttr(this.KLn, 512))
      {
        if (this.KLy == null) {
          this.KLy = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37983);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              com.tencent.mm.plugin.report.service.g.yxI.f(11140, new Object[] { Integer.valueOf(0) });
              com.tencent.mm.br.d.Q(SelectContactUI.this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37983);
            }
          }, getString(2131759100));
        }
        this.KLy.setVisibility(paramInt);
      }
      if (u.hasAttr(this.KLn, 1024))
      {
        if (this.KLz == null) {
          this.KLz = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(187981);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              paramAnonymousView = new Intent();
              paramAnonymousView.setClassName(SelectContactUI.this, "com.tencent.mm.ui.contact.GroupCardSelectUI");
              paramAnonymousView.putExtra("group_select_type", false);
              SelectContactUI.this.startActivityForResult(paramAnonymousView, 1);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(187981);
            }
          }, getString(2131755205));
        }
        this.KLz.setVisibility(paramInt);
      }
      if (u.hasAttr(this.KLn, 2048))
      {
        if (this.KLB == null) {
          this.KLB = a(paramListView, new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(187982);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("list_attr", 16384);
              com.tencent.mm.br.d.b(SelectContactUI.this, "brandservice", ".ui.BrandServiceIndexUI", paramAnonymousView, 2);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(187982);
            }
          }, getString(2131755219));
        }
        this.KLB.setVisibility(paramInt);
        this.KLB.setTextSize(16.0F * com.tencent.mm.cb.a.ef(this.KLB.getContext()));
      }
      if (u.hasAttr(this.KLn, 524288)) {
        if (this.KLA == null)
        {
          localObject = "";
          i = getIntent().getIntExtra("topstory_import_type", 0);
          j = 2131755209;
          if (i != 1) {
            break label636;
          }
          localObject = com.tencent.mm.plugin.sns.b.o.zsy.zT(5L);
          if (!bu.ht((List)localObject)) {
            break label625;
          }
          i = 0;
          localObject = bu.m((List)localObject, ",");
          j = 2131755209;
          m = 2131755210;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.KLA = a(paramListView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187961);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          com.tencent.mm.ui.base.h.e(SelectContactUI.this, SelectContactUI.this.getString(i, new Object[] { Integer.valueOf(k) }), "", SelectContactUI.this.getString(2131755206), SelectContactUI.this.getString(2131755691), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(187960);
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.2.this.KMo);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(187960);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187961);
        }
      }, getString(j));
      this.KLA.setTag(Integer.valueOf(k));
      localObject = this.KLA.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.KLA.setVisibility(8);
      }
      for (;;)
      {
        if (u.hasAttr(this.KLn, 16777216))
        {
          if (this.KLC == null)
          {
            bc.aCg();
            localObject = com.tencent.mm.model.c.azF().fus();
            ae.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.KLC = a(paramListView, new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(187963);
                  Object localObject = new com.tencent.mm.hellhoundlib.b.b();
                  ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
                  paramAnonymousView = new Intent(SelectContactUI.this.getIntent());
                  paramAnonymousView.setClass(SelectContactUI.this.getContext(), OpenIMSelectContactUI.class);
                  paramAnonymousView.removeExtra("titile");
                  paramAnonymousView.putExtra("openim_appid", "3552365301");
                  localObject = new ArrayList();
                  Iterator localIterator = SelectContactUI.q(SelectContactUI.this).iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    if (an.aUq(str)) {
                      ((ArrayList)localObject).add(str);
                    }
                  }
                  paramAnonymousView.putExtra("already_select_contact", bu.m((List)localObject, ","));
                  SelectContactUI.this.startActivityForResult(paramAnonymousView, 5);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(187963);
                }
              }, "");
              paramListView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a("3552365301", "openim_acct_type_title", a.a.iKm);
              this.KLC.setVisibility(paramInt);
              this.KLC.setText(paramListView);
            }
          }
          if (this.KLC != null) {
            this.KLC.setVisibility(paramInt);
          }
        }
        if ((!u.hasAttr(this.KLn, 16777216)) || (this.KLC == null)) {
          break label707;
        }
        this.KLC.setBackgroundResource(2131231820);
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
        localObject = com.tencent.mm.pluginsdk.i.d.feg();
        if (bu.ht((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = bu.m((List)localObject, ",");
          j = 2131755207;
          m = 2131755208;
          k = i;
          i = m;
          break;
        }
        this.KLA.setVisibility(paramInt);
      }
      label707:
      if (u.hasAttr(this.KLn, 2048))
      {
        if (this.KLB != null)
        {
          this.KLB.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.KLn, 1024))
      {
        if (this.KLz != null)
        {
          this.KLz.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.KLn, 512))
      {
        if (this.KLy != null)
        {
          this.KLy.setBackgroundResource(2131231820);
          AppMethodBeat.o(38002);
        }
      }
      else if ((u.hasAttr(this.KLn, 256)) && (this.KLx != null)) {
        this.KLx.setBackgroundResource(2131231820);
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
    if ((parama.KJj) && (parama.contact != null))
    {
      bool = this.vUq.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.KJk) && (parama.contact != null))
    {
      bool = this.vUq.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.vUq.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final boolean aRT()
  {
    return false;
  }
  
  protected final boolean aRU()
  {
    return true;
  }
  
  protected final String aRV()
  {
    return this.title;
  }
  
  protected final q aRW()
  {
    boolean bool2 = false;
    AppMethodBeat.i(38000);
    Object localObject = new c.a();
    ((c.a)localObject).KGP = u.hasAttr(this.KLn, 16);
    ((c.a)localObject).KGO = u.hasAttr(this.KLn, 32);
    ((c.a)localObject).KGS = getIntent().getBooleanExtra("create_group_recommend", false);
    boolean bool1;
    if (!u.hasAttr(this.KLn, 4))
    {
      bool1 = true;
      ((c.a)localObject).KGQ = bool1;
      if (u.hasAttr(this.KLn, 1)) {
        break label367;
      }
      bool1 = true;
      label93:
      ((c.a)localObject).KGR = bool1;
      ((c.a)localObject).KGT = u.hasAttr(this.KLn, 128);
      ((c.a)localObject).KGU = u.hasAttr(this.KLn, 1048576);
      ((c.a)localObject).KGX = u.hasAttr(this.KLn, 256);
      if (((c.a)localObject).KGX) {
        ((c.a)localObject).KGY = getIntent().getStringExtra("custom_contact");
      }
      if (((c.a)localObject).KGT)
      {
        this.KMe = true;
        ((c.a)localObject).KGV = getIntent().getStringExtra("wechat_sport_contact");
        ((c.a)localObject).KGW = getIntent().getStringExtra("wechat_sport_recent_like");
        this.KMf = ((c.a)localObject).KGV;
      }
      if (!u.fMJ()) {
        break label372;
      }
    }
    label367:
    label372:
    for (((c.a)localObject).KFj = "@all.contact.without.chatroom.without.openim";; ((c.a)localObject).KFj = "@all.contact.without.chatroom.without.openim.without.openimfavour")
    {
      if ((this.scene == 6) || (this.scene == 5)) {
        ((c.a)localObject).KFj = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
        ((c.a)localObject).KFj = "@all.contact.without.chatroom.without.openim.without.openimfavour";
      }
      List localList1 = this.KLD;
      List localList2 = this.vUq;
      List localList3 = this.fUR;
      boolean bool3 = u.hasAttr(this.KLn, 1);
      boolean bool4 = u.hasAttr(this.KLn, 64);
      bool1 = bool2;
      if (this.KFT == 15) {
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
  
  protected final o aRX()
  {
    AppMethodBeat.i(38001);
    if (this.KMe)
    {
      localObject = new t(this, this.fUR, u.hasAttr(this.KLn, 64), this.KMf);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new v(this, this.KLD, this.vUq, this.fUR, u.hasAttr(this.KLn, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new s(this, this.fUR, u.hasAttr(this.KLn, 64), this.scene);
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  protected final void aqy(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.g.yxI.f(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(yC(u.hasAttr(this.KLn, 8192)));
    paramString.addAll(this.KLD);
    localIntent.putExtra("always_select_contact", bu.m(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", bu.m(new ArrayList(paramString), ","));
    if (u.hasAttr(this.KLn, 64))
    {
      localIntent.putExtra("list_attr", u.J(new int[] { 16384, 64, 131072 }));
      if (this.KFT == 14) {
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
    if ((parama.KJj) && (parama.contact != null))
    {
      if (u.hasAttr(this.KLn, 536870912))
      {
        bool = parama.contact.adA();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.KLD.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  public final int[] dmI()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!u.hasAttr(this.KLn, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!u.hasAttr(this.KLn, 4)) {
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
  
  protected final boolean doz()
  {
    return !this.KMe;
  }
  
  public void initView()
  {
    AppMethodBeat.i(187986);
    super.initView();
    this.KLL = ((RelativeLayout)findViewById(2131308411));
    this.KLM = ((LinearLayout)findViewById(2131308410));
    this.KLS = ((Button)findViewById(2131300102));
    this.KLN = ((ImageView)findViewById(2131308413));
    this.KLO = ((ImageView)findViewById(2131308415));
    this.KLP = ((ImageView)findViewById(2131308412));
    this.KLQ = ((ProgressBar)findViewById(2131308392));
    this.KLR = ((TextView)findViewById(2131308414));
    this.KLM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37978);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SelectContactUI", "click selectRecordMsgBt %s", new Object[] { bu.bI(SelectContactUI.d(SelectContactUI.this), "") });
        SelectContactUI.this.hideVKB();
        paramAnonymousView = new Intent().putExtra("Chat_User", SelectContactUI.d(SelectContactUI.this)).putExtra("finish_direct", true).putExtra("key_record_msg_select", true).putExtra("key_record_msg_select_introduce", SelectContactUI.g(SelectContactUI.this)).putExtra("key_record_select_min_msg_id", SelectContactUI.f(SelectContactUI.this)).putExtra("key_record_select_msg_num", SelectContactUI.e(SelectContactUI.this));
        if (SelectContactUI.h(SelectContactUI.this) != null) {
          paramAnonymousView.putStringArrayListExtra("key_record_select_msg_black_list", SelectContactUI.h(SelectContactUI.this));
        }
        com.tencent.mm.br.d.c(SelectContactUI.this, ".ui.chatting.ChattingUI", paramAnonymousView, 6);
        SelectContactUI.i(SelectContactUI.this);
        com.tencent.mm.plugin.selectrecord.b.a.dQt().yRY.ekl = 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37978);
      }
    });
    this.KLO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SelectContactUI", "click warn to retry");
        SelectContactUI.a(SelectContactUI.this, null);
        SelectContactUI.j(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, true);
        SelectContactUI.k(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, com.tencent.mm.ui.chatting.l.m(SelectContactUI.this, "msginfo@fakeuser", true));
        if (!((Boolean)SelectContactUI.a(SelectContactUI.this).second).booleanValue()) {
          SelectContactUI.l(SelectContactUI.this).alive();
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
          paramAnonymousView.ySi += 1;
          ae.i("MicroMsg.SelectContactUI", "click warn to retry, msgId:%s direct:%s", new Object[] { SelectContactUI.a(SelectContactUI.this).first, SelectContactUI.a(SelectContactUI.this).second });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37979);
          return;
          SelectContactUI.b(SelectContactUI.this);
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.dQu();
    Object localObject = com.tencent.mm.plugin.selectrecord.b.a.dQt();
    String str = this.fRo;
    ev localev = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).yRY;
    localev.ekb = localev.t("RoomId", str, true);
    localObject = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).yRY;
    int i;
    if (x.zX(str))
    {
      i = 1;
      ((ev)localObject).ekD = i;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qOC, 0);
      ae.d("MicroMsg.recordSelect.SelectRecordConfig", "canSelectRecordInAddRoomMembers() sw:%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label380;
      }
      i = 1;
      label250:
      if ((i == 0) || (!x.zU(this.fRo)) || (x.zX(this.fRo)) || (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arC(this.fRo) <= 0L)) {
        break label385;
      }
      this.KLM.setVisibility(0);
      com.tencent.mm.plugin.selectrecord.b.a.dQt().qS(true);
      if (this.xuY != null) {
        this.KLL.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187980);
            int i = SelectContactUI.m(SelectContactUI.this).getHeight();
            if (i > 0)
            {
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)SelectContactUI.this.xuY.getLayoutParams();
              localLayoutParams.bottomMargin = i;
              SelectContactUI.this.xuY.setLayoutParams(localLayoutParams);
            }
            AppMethodBeat.o(187980);
          }
        });
      }
    }
    for (;;)
    {
      if (this.KLK == 2)
      {
        this.fSZ = new com.tencent.mm.ui.tools.h(this);
        this.fSZ.Lfj = this;
      }
      AppMethodBeat.o(187986);
      return;
      i = 0;
      break;
      label380:
      i = 0;
      break label250;
      label385:
      this.KLM.setVisibility(8);
      com.tencent.mm.plugin.selectrecord.b.a.dQt().qS(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38021);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.requestCode = paramInt1;
    ae.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
          } while (bu.isNullOrNil(paramIntent));
          iL(bu.U(new String[] { paramIntent }));
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          localObject1 = this.vUq.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            this.vUs.aNU(str1);
          }
          this.vUq.clear();
          if (!bu.isNullOrNil(paramIntent)) {
            this.vUq.addAll(bu.U(paramIntent.split(",")));
          }
          paramIntent = this.vUq.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.vUs.aNV((String)localObject1);
          }
          Zv();
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Contact");
        } while (bu.isNullOrNil(paramIntent));
        iL(bu.U(paramIntent.split(",")));
        AppMethodBeat.o(38021);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!bu.isNullOrNil(paramIntent)) {
        iL(bu.U(new String[] { paramIntent }));
      }
      AppMethodBeat.o(38021);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (bu.isNullOrNil(paramIntent))
      {
        ae.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38021);
        return;
      }
      ae.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      if (u.hasAttr(this.KLn, 64))
      {
        paramIntent = paramIntent.split(",");
        paramInt2 = paramIntent.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject1 = paramIntent[paramInt1];
          if (this.vUq.add(localObject1)) {
            this.vUs.aNT((String)localObject1);
          }
          paramInt1 += 1;
        }
        Zv();
        fMv().notifyDataSetChanged();
        AppMethodBeat.o(38021);
        return;
      }
      iL(bu.U(new String[] { paramIntent }));
      AppMethodBeat.o(38021);
      return;
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("Select_Contact");
        localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
        if (bu.isNullOrNil(str1))
        {
          paramIntent = null;
          if (!bu.isNullOrNil((String)localObject1)) {
            break label642;
          }
          localObject1 = null;
        }
        Object localObject2;
        for (;;)
        {
          if (paramIntent != null)
          {
            if (this.vUs != null)
            {
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  String str2 = (String)((Iterator)localObject2).next();
                  if (!this.vUq.contains(str2))
                  {
                    this.vUs.aNT(str2);
                    continue;
                    paramIntent = bu.lV(str1, ",");
                    break;
                    localObject1 = bu.lV((String)localObject1, ",");
                    break label563;
                  }
                }
              }
            }
            this.vUq.addAll(paramIntent);
          }
        }
        if (localObject1 != null)
        {
          if (this.vUs != null)
          {
            paramIntent = ((List)localObject1).iterator();
            while (paramIntent.hasNext())
            {
              localObject2 = (String)paramIntent.next();
              this.vUs.aNT((String)localObject2);
            }
          }
          this.vUq.removeAll((Collection)localObject1);
        }
        fMv().notifyDataSetChanged();
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
          iL(bu.U(new String[] { str1 }));
        }
      }
      Zv();
      AppMethodBeat.o(38021);
      return;
    } while (paramIntent == null);
    label642:
    this.KLU = paramIntent.getIntExtra("select_record_msg_num", 0);
    this.KLV = this.KLU;
    this.KMb = paramIntent.getStringArrayListExtra("key_select_record_msg_black_list");
    this.KMa = null;
    this.KLX = false;
    if (this.KLU == 0)
    {
      this.KLW = false;
      fMN();
    }
    for (;;)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.a.dQt();
      long l = this.KLV;
      paramIntent.yRY.ehq = l;
      ae.i("MicroMsg.SelectContactUI", "GET_SELECT_RECORD_MSG selectMsgNum:%s actualSelectMsgNum:%s msgId:%s direct:%s", new Object[] { Integer.valueOf(this.KLU), Integer.valueOf(this.KLV), this.KLZ.first, this.KLZ.second });
      break;
      this.KLW = true;
      this.KgW = paramIntent.getLongExtra("select_record_min_msg_id", -1L);
      if ((com.tencent.mm.ui.chatting.l.fFo() > 0) && (com.tencent.mm.ui.chatting.l.fFo() < this.KLU)) {
        this.KLV = com.tencent.mm.ui.chatting.l.fFo();
      }
      fMN();
      com.tencent.mm.plugin.selectrecord.b.a.dQt().ySg = ch.aDa();
      this.KLZ = com.tencent.mm.ui.chatting.l.c(this, "msginfo@fakeuser", true, this.fRo);
      if (!((Boolean)this.KLZ.second).booleanValue()) {
        this.KMg.alive();
      } else {
        fMQ();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.SelectContactUI", "create!");
    bc.ajj().a(30, this);
    bc.ajj().a(138, this);
    if (!bu.isNullOrNil(this.nhq)) {
      setMMSubTitle(this.nhq);
    }
    int i;
    if (u.hasAttr(this.KLn, 64))
    {
      if (this.KLK == 1)
      {
        this.KLL.setVisibility(8);
        addTextOptionMenu(1, getString(2131755835), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(187966);
            boolean bool = SelectContactUI.r(SelectContactUI.this);
            AppMethodBeat.o(187966);
            return bool;
          }
        }, null, s.b.JwA);
      }
    }
    else
    {
      Zv();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187973);
          SelectContactUI.this.hideVKB();
          SelectContactUI.this.finish();
          if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            ar.o(SelectContactUI.c(SelectContactUI.this), 80L);
          }
          AppMethodBeat.o(187973);
          return true;
        }
      });
      if ((this.KFT != 15) && (this.vUs != null)) {
        this.vUs.hn(this.vUq);
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
      w.KKD = i;
      ae.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(37995);
      return;
      this.KLL.setVisibility(0);
      this.KLS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187969);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (SelectContactUI.s(SelectContactUI.this))
          {
            com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(2131767122), "", SelectContactUI.this.getString(2131766205), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(187967);
                ae.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                AppMethodBeat.o(187967);
              }
            });
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
            paramAnonymousView.ySk += 1;
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(187969);
            return;
            if (SelectContactUI.t(SelectContactUI.this))
            {
              com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(2131767121), "", SelectContactUI.this.getString(2131766205), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(187968);
                  ae.i("MicroMsg.SelectContactUI", "initMenu(upload fail) click i know");
                  AppMethodBeat.o(187968);
                }
              });
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.dQt();
              paramAnonymousView.ySl += 1;
              com.tencent.mm.plugin.selectrecord.b.a.dQt().dQx();
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
    this.KMg.dead();
    bc.ajj().b(30, this);
    bc.ajj().b(138, this);
    aeZ(1);
    w.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(187985);
    super.onPause();
    if (this.fSZ != null) {
      this.fSZ.close();
    }
    AppMethodBeat.o(187985);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(187983);
    super.onResume();
    if (this.fSZ != null) {
      this.fSZ.start();
    }
    AppMethodBeat.o(187983);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(38013);
    if (this.fOC != null)
    {
      this.fOC.dismiss();
      this.fOC = null;
    }
    if (!bu.jn(this))
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
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!bu.isNullOrNil(paramString))) {
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
      fMv().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(187984);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.fSZ != null) {
      this.fSZ.start();
    }
    AppMethodBeat.o(187984);
  }
  
  public final void rj(int paramInt)
  {
    AppMethodBeat.i(37998);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      ae.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(37998);
      return;
    }
    Object localObject1 = fMv().aeW(i);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37998);
      return;
    }
    if ((localObject1 instanceof k))
    {
      if (u.hasAttr(this.KLn, 16384))
      {
        ae.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
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
    ae.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { localObject1 });
    if (u.hasAttr(this.KLn, 64))
    {
      Object localObject2;
      if ((x.wb((String)localObject1)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        localObject2 = new Intent(this, ChattingUI.class);
        ((Intent)localObject2).addFlags(67108864);
        ((Intent)localObject2).putExtra("Chat_User", (String)localObject1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
        com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        aeZ(3);
        AppMethodBeat.o(37998);
        return;
      }
      if ((u.hasAttr(this.KLn, 131072)) && (this.vUq.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.KLD.contains(localObject1))
        {
          fMC();
          if (!this.vUq.contains(localObject1)) {
            break label481;
          }
          this.vUs.aNT((String)localObject1);
          this.vUq.remove(localObject1);
        }
      }
      for (;;)
      {
        Zv();
        fMM();
        fMw().notifyDataSetChanged();
        AppMethodBeat.o(37998);
        return;
        label481:
        localObject2 = getIntent().getStringExtra("too_many_member_tip_string");
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2)) {
          localObject1 = getString(2131762994, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), (String)localObject1, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        aYw((String)localObject1);
      }
    }
    iL(bu.U(new String[] { localObject1 }));
    AppMethodBeat.o(37998);
  }
  
  public final void u(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187987);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.KMi == paramBoolean; paramBoolean = false)
    {
      ae.d("MicroMsg.SelectContactUI", "onKeyboardHeightChanged repeat");
      AppMethodBeat.o(187987);
      return;
    }
    if (this.uNI == 0) {
      this.uNI = paramInt;
    }
    if (paramBoolean) {
      if (this.KLL.getTranslationY() != 0.0F) {
        this.KLL.setTranslationY(0.0F);
      }
    }
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.KLL, "translationY", new float[] { this.KLL.getTranslationY(), this.KLL.getTranslationY() - this.uNI });; localObjectAnimator = ObjectAnimator.ofFloat(this.KLL, "translationY", new float[] { this.KLL.getTranslationY(), this.KLL.getTranslationY() + this.uNI }))
    {
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setInterpolator(new android.support.v4.view.b.b());
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(187962);
          ae.i("MicroMsg.SelectContactUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(187962);
        }
      });
      localObjectAnimator.start();
      this.KMi = paramBoolean;
      ae.i("MicroMsg.SelectContactUI", "height:%s moveHeight:%s isKeyboardShow:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.uNI), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(187987);
      return;
    }
  }
  
  static final class a
  {
    private AlphaAnimation KMw;
    private AlphaAnimation KMx;
    boolean KMy = false;
    TextView mdu;
    
    final void bm(Activity paramActivity)
    {
      AppMethodBeat.i(37989);
      if (this.mdu == null) {
        this.mdu = ((TextView)paramActivity.findViewById(2131304506));
      }
      if (this.mdu.getVisibility() == 8)
      {
        AppMethodBeat.o(37989);
        return;
      }
      if (this.KMx == null)
      {
        this.KMx = new AlphaAnimation(1.0F, 0.0F);
        this.KMx.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(37987);
            SelectContactUI.a.this.mdu.setVisibility(8);
            AppMethodBeat.o(37987);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      this.KMx.setDuration(300L);
      if (this.KMw != null) {
        this.KMw.cancel();
      }
      this.mdu.startAnimation(this.KMx);
      AppMethodBeat.o(37989);
    }
    
    public final void e(final Activity paramActivity, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37988);
      if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.KMy))
      {
        if (this.mdu == null) {
          this.mdu = ((TextView)paramActivity.findViewById(2131304506));
        }
        if (this.mdu.getVisibility() != 0)
        {
          this.mdu.setText(2131762573);
          this.mdu.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37986);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              SelectContactUI.a.this.KMy = true;
              SelectContactUI.a.this.bm(paramActivity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37986);
            }
          });
          if (this.KMw == null) {
            this.KMw = new AlphaAnimation(0.0F, 1.0F);
          }
          this.KMw.setDuration(300L);
          if (this.KMx != null) {
            this.KMx.cancel();
          }
          this.mdu.setVisibility(0);
          this.mdu.startAnimation(this.KMw);
        }
        AppMethodBeat.o(37988);
        return;
      }
      if (paramInt1 < paramInt2)
      {
        bm(paramActivity);
        this.KMy = false;
      }
      AppMethodBeat.o(37988);
    }
  }
  
  static final class b
    implements Runnable
  {
    private WeakReference<SelectContactUI> cyH;
    
    private b(SelectContactUI paramSelectContactUI)
    {
      AppMethodBeat.i(37990);
      this.cyH = new WeakReference(paramSelectContactUI);
      AppMethodBeat.o(37990);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37991);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cyH.get();
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
    private ArrayList<String> KMA;
    private WeakReference<SelectContactUI> cyH;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.cyH = new WeakReference(paramSelectContactUI);
      this.KMA = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cyH.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = com.tencent.mm.model.v.aAC();
      Iterator localIterator = this.KMA.iterator();
      int i = 0;
      Object localObject1 = null;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        ae.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (x.wb((String)localObject2))
        {
          j = 1;
          label94:
          i += j;
          o.e locale = com.tencent.mm.modelmulti.o.a(o.d.iiQ).pn(4);
          locale.dzZ = str;
          locale.toUser = ((String)localObject2);
          locale.iey = localSelectContactUI.getIntent().getStringExtra("shareImagePath");
          locale.icr = 0;
          locale.iiW = null;
          locale.dyw = 0;
          locale.icA = "";
          locale.thumbPath = "";
          locale.iiZ = true;
          locale.iiY = 2131231564;
          locale.thumbPath = ((String)localObject1);
          locale.iiV = 11;
          localObject2 = locale.aJO();
          ((o.b)localObject2).execute();
          localObject2 = (com.tencent.mm.av.n)((o.b)localObject2).iiO;
          if (((com.tencent.mm.av.n)localObject2).aIJ() == null) {
            break label332;
          }
          localObject1 = ((com.tencent.mm.av.n)localObject2).aIJ().field_imgPath;
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
        ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.KMA);
        localSelectContactUI.setResult(-1, (Intent)localObject1);
        com.tencent.mm.plugin.report.service.g.yxI.f(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.KMA.size() - i), Integer.valueOf(i) });
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