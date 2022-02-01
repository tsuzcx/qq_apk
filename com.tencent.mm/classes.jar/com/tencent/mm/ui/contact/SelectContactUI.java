package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.f.a.sb;
import com.tencent.mm.f.b.a.kk;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.aa.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.w.b;
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
  implements com.tencent.mm.an.i, com.tencent.mm.ui.tools.h
{
  private List<String> ETN;
  private String EdH;
  private ObjectAnimator EeU;
  private long WNr;
  private int XpC;
  private TextView XvA;
  private TextView XvB;
  private List<String> XvC;
  private Map<String, Integer> XvD;
  private boolean XvE;
  private boolean XvF;
  private String XvG;
  private String XvH;
  private boolean XvI;
  private int XvJ;
  private RelativeLayout XvK;
  private LinearLayout XvL;
  private ImageView XvM;
  private ImageView XvN;
  private ImageView XvO;
  private ProgressBar XvP;
  private TextView XvQ;
  private Button XvR;
  private boolean XvS;
  private int XvT;
  private int XvU;
  private boolean XvV;
  private boolean XvW;
  private boolean XvX;
  private Pair<Long, Boolean> XvY;
  private com.tencent.mm.i.d XvZ;
  private int Xvg;
  private boolean Xvh;
  private SelectContactUI.a Xvi;
  private TextView Xvw;
  private TextView Xvx;
  private TextView Xvy;
  private TextView Xvz;
  private ArrayList<String> Xwa;
  private boolean Xwb;
  private boolean Xwc;
  private boolean Xwd;
  private String Xwe;
  private IListener<sb> Xwf;
  private SelectContactUI.b Xwg;
  private boolean Xwh;
  private HashMap<String, String> Xwi;
  private ProgressDialog iXX;
  private String jaK;
  private com.tencent.mm.ui.tools.i jij;
  private List<String> jkb;
  private int requestCode;
  private String rsw;
  private String title;
  private g.a wvt;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.XvD = new HashMap();
    this.XvT = 0;
    this.XvU = 0;
    this.XvV = false;
    this.XvW = false;
    this.XvX = true;
    this.XvY = new Pair(Long.valueOf(-1L), Boolean.FALSE);
    this.WNr = -1L;
    this.Xwa = null;
    this.Xvh = true;
    this.Xwd = false;
    this.Xwf = new IListener() {};
    this.Xwg = new SelectContactUI.b(this, (byte)0);
    this.EeU = null;
    this.Xwh = false;
    this.Xwi = new HashMap();
    this.wvt = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(291974);
        if (paramAnonymousInt == -21005)
        {
          Log.i("MicroMsg.SelectContactUI", "ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(291974);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd);
          SelectContactUI.a(SelectContactUI.this, false);
          Log.i("MicroMsg.SelectContactUI", "sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] result:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(com.tencent.mm.vfs.u.deleteFile((String)SelectContactUI.E(SelectContactUI.this).get(paramAnonymousString))) });
          SelectContactUI.k(SelectContactUI.this);
          com.tencent.mm.plugin.selectrecord.b.a.fFx().Qa(cm.bfC());
          AppMethodBeat.o(291974);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.w("MicroMsg.SelectContactUI", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd.field_retCode, "cdn ret error");
          AppMethodBeat.o(291974);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.SelectContactUI", "start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, 0, "cdn start error");
          AppMethodBeat.o(291974);
          return 0;
        }
        Log.i("MicroMsg.SelectContactUI", "on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.SelectContactUI", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
        }
        AppMethodBeat.o(291974);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.Xvi = new SelectContactUI.a();
    AppMethodBeat.o(37994);
  }
  
  private void GN(boolean paramBoolean)
  {
    AppMethodBeat.i(289377);
    RelativeLayout localRelativeLayout = this.XvK;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      if (this.Hpw != null) {
        this.XvK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204392);
            int i = SelectContactUI.m(SelectContactUI.this).getHeight();
            RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)SelectContactUI.this.Hpw.getLayoutParams();
            localLayoutParams.bottomMargin = i;
            SelectContactUI.this.Hpw.setLayoutParams(localLayoutParams);
            AppMethodBeat.o(204392);
          }
        });
      }
      AppMethodBeat.o(289377);
      return;
    }
  }
  
  private void GO(boolean paramBoolean)
  {
    AppMethodBeat.i(289389);
    if (this.XvJ == 1)
    {
      enableOptionMenu(1, paramBoolean);
      AppMethodBeat.o(289389);
      return;
    }
    this.XvR.setEnabled(paramBoolean);
    AppMethodBeat.o(289389);
  }
  
  private ArrayList<String> GP(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.ETN.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (ab.Qj((String)localObject)))
      {
        localObject = com.tencent.mm.model.v.Pt((String)localObject);
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
  
  private ArrayList<String> GQ(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.ETN.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (ab.Qj((String)localObject)))
      {
        localObject = com.tencent.mm.model.v.Pt((String)localObject);
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
    localHashSet.addAll(this.XvC);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  private static List<String> S(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!bh.aHB())
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
      bh.beI();
      as localas = com.tencent.mm.model.c.bbL().RG(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.jxt != 0) {
          paramList = localas.ays();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = ad.kS(this).inflate(R.i.ehv, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(R.h.content_tv);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    AppMethodBeat.o(38003);
    return paramOnClickListener;
  }
  
  private void a(final com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(38011);
    parama.d(new com.tencent.mm.roomsdk.a.b.c() {});
    parama.a(this, getString(R.l.app_tip), getString(R.l.eKL), true, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(291548);
        SelectContactUI.D(SelectContactUI.this);
        parama.cancel();
        AppMethodBeat.o(291548);
      }
    });
    awP(2);
    AppMethodBeat.o(38011);
  }
  
  private com.tencent.mm.i.g aHf(String paramString)
  {
    AppMethodBeat.i(289399);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.gbt = true;
    localg.iUG = this.wvt;
    localg.field_mediaId = azD(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.iTU;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 0;
    localg.field_bzScene = 0;
    this.Xwi.put(localg.field_mediaId, localg.field_fullpath);
    AppMethodBeat.o(289399);
    return localg;
  }
  
  private void ad(int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(289402);
    Log.i("MicroMsg.SelectContactUI", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString1, "") });
    this.XvW = true;
    this.XvV = false;
    hVp();
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(286578);
        SelectContactUI localSelectContactUI = SelectContactUI.this;
        if (Util.isNullOrNil(paramString2)) {}
        for (String str = SelectContactUI.this.getString(R.l.record_msg_upload_net_fail_tips);; str = paramString2)
        {
          com.tencent.mm.ui.base.h.a(localSelectContactUI, str, "", SelectContactUI.this.getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(246376);
              Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
              AppMethodBeat.o(246376);
            }
          });
          AppMethodBeat.o(286578);
          return;
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.fFx().Qa(cm.bfC());
    com.tencent.mm.plugin.selectrecord.b.a.fFx().fFB();
    AppMethodBeat.o(289402);
  }
  
  private void atk()
  {
    AppMethodBeat.i(38006);
    if ((w.hasAttr(this.Xvg, 64)) && (this.ETN.size() > 0))
    {
      bAe(getString(R.l.app_finish) + "(" + this.ETN.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((w.hasAttr(this.Xvg, 262144)) && (this.ETN.size() < i))
      {
        GO(false);
        AppMethodBeat.o(38006);
        return;
      }
      GO(true);
      AppMethodBeat.o(38006);
      return;
    }
    if ((w.hasAttr(this.Xvg, 64)) && (w.hasAttr(this.Xvg, 4194304)))
    {
      bAe(getString(R.l.app_finish));
      GO(true);
      AppMethodBeat.o(38006);
      return;
    }
    bAe(getString(R.l.app_finish));
    GO(false);
    AppMethodBeat.o(38006);
  }
  
  private void awP(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.Xwh)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.Xwh = true;
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
        localObject = this.ETN.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.XvD.containsKey(str)) {
          switch (((Integer)this.XvD.get(str)).intValue())
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
      Log.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(hUP().hUm()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.IzE.a(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(hUP().hUm()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.XvC);
      ((List)localObject).addAll(this.ETN);
      y.kI((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private static String azD(String paramString)
  {
    AppMethodBeat.i(289400);
    paramString = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + paramString).getBytes());
    AppMethodBeat.o(289400);
    return paramString;
  }
  
  private void bAe(String paramString)
  {
    AppMethodBeat.i(289390);
    if (this.XvJ == 1)
    {
      updateOptionMenuText(1, paramString);
      AppMethodBeat.o(289390);
      return;
    }
    this.XvR.setText(paramString);
    AppMethodBeat.o(289390);
  }
  
  private void bAf(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.XvC.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.ETN.contains(paramString))
    {
      this.ETN.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (hUP() == hUQ()) {
          break label311;
        }
        ((c)hUQ()).Xqt.reset();
        hUQ().ate();
        this.Xti.cWP();
        hideVKB();
      }
      label108:
      if (!(hUP() instanceof x)) {
        break label339;
      }
      String str = ((x)hUP()).hUL();
      if (this.ETP != null) {
        this.ETP.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.ETP.bqR(paramString);
      AppMethodBeat.o(38018);
      return;
      this.ETN.add(paramString);
      if ((hUP() instanceof x))
      {
        if (((x)hUP()).hVk())
        {
          this.XvD.put(paramString, Integer.valueOf(((x)hUP()).bzZ(paramString)));
          i = 0;
          break;
        }
        this.XvD.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (hUP() == hUQ())
      {
        if (((c)hUQ()).bzQ(paramString))
        {
          this.XvD.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.XvD.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label311:
      if ((i == 0) && (!((c)hUQ()).bzQ(paramString))) {
        break label108;
      }
      hUQ().ate();
      break label108;
      label339:
      hUZ();
    }
  }
  
  private static String bAg(String paramString)
  {
    AppMethodBeat.i(289398);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.SelectContactUI", "xml is null");
      AppMethodBeat.o(289398);
      return null;
    }
    String str = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
    if (!com.tencent.mm.vfs.u.agG(str)) {
      com.tencent.mm.vfs.u.bBD(str);
    }
    try
    {
      str = str + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      if (com.tencent.mm.vfs.u.agG(str)) {
        com.tencent.mm.vfs.u.deleteFile(str);
      }
      com.tencent.mm.vfs.u.H(str, paramString.getBytes());
      paramString = com.tencent.mm.plugin.selectrecord.b.a.fFx();
      long l = com.tencent.mm.vfs.u.bBQ(str);
      paramString.Jcu.gNq = l;
      AppMethodBeat.o(289398);
      return str;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SelectContactUI", paramString, "", new Object[0]);
      AppMethodBeat.o(289398);
    }
    return null;
  }
  
  private void dn(int paramInt, String paramString)
  {
    AppMethodBeat.i(289401);
    ad(paramInt, paramString, "");
    AppMethodBeat.o(289401);
  }
  
  private boolean hVn()
  {
    AppMethodBeat.i(289378);
    boolean bool = getIntent().getBooleanExtra("KForceDarkMode", false);
    AppMethodBeat.o(289378);
    return bool;
  }
  
  private void hVo()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.Xvh) && ((this.XpC == 1) || (this.XpC == 0))) {
      if (this.XvC == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.XvC.size();; i = 0)
    {
      if (this.ETN != null) {
        j = this.ETN.size();
      }
      int k = Util.safeParseInt(com.tencent.mm.n.h.axc().getValue("ChatRoomInviteStartCount"));
      this.Xvi.e(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void hVp()
  {
    AppMethodBeat.i(289392);
    com.tencent.e.h.ZvG.bc(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(287847);
        if (SelectContactUI.u(SelectContactUI.this))
        {
          if (SelectContactUI.v(SelectContactUI.this) == 0)
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(8);
            SelectContactUI.y(SelectContactUI.this).setVisibility(8);
            SelectContactUI.z(SelectContactUI.this).setVisibility(0);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.FG_1));
            SelectContactUI.A(SelectContactUI.this).setText(R.l.select_record_msg_hint);
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_empty_selector));
            AppMethodBeat.o(287847);
            return;
          }
          if (SelectContactUI.t(SelectContactUI.this))
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(0);
            SelectContactUI.y(SelectContactUI.this).setVisibility(8);
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.Brand_100));
            SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(R.l.select_record_msg_tips, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_selector));
            AppMethodBeat.o(287847);
            return;
          }
          if (SelectContactUI.s(SelectContactUI.this))
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(8);
            SelectContactUI.y(SelectContactUI.this).setVisibility(0);
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.Brand_100));
            SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(R.l.select_record_msg_tips, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_selector));
            AppMethodBeat.o(287847);
            return;
          }
          SelectContactUI.w(SelectContactUI.this).setVisibility(0);
          SelectContactUI.x(SelectContactUI.this).setVisibility(8);
          SelectContactUI.y(SelectContactUI.this).setVisibility(8);
          SelectContactUI.z(SelectContactUI.this).setVisibility(8);
          SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.Brand_100));
          SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(R.l.select_record_msg_tips, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
          SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_selector));
        }
        AppMethodBeat.o(287847);
      }
    });
    AppMethodBeat.o(289392);
  }
  
  private void hVq()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = GP(true);
    localArrayList.remove(z.bcZ());
    if (localArrayList.size() > 0)
    {
      this.iXX = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.eLv), false, null);
      bh.aHJ().postToWorker(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void hVr()
  {
    AppMethodBeat.i(38010);
    Object localObject = GP(false);
    ((ArrayList)localObject).remove(z.bcZ());
    final String str = Util.listToString((List)localObject, ",");
    if (!Util.isNullOrNil((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(R.l.label_selected_contact_save_label), "", getString(R.l.label_selected_contact_save_btn), getString(R.l.label_selected_contact_cancel_btn), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(288252);
          Log.i("MicroMsg.SelectContactUI", "return the result,and create new label");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(288252);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(251583);
          Log.i("MicroMsg.SelectContactUI", "return the result");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(251583);
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
  
  private void hVs()
  {
    AppMethodBeat.i(289397);
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXml");
    bh.beI();
    Object localObject = com.tencent.mm.model.c.bbO().Oq(((Long)this.XvY.first).longValue());
    if (((et)localObject).field_content == null)
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXml msgInfo.getContent() is null");
      AppMethodBeat.o(289397);
      return;
    }
    localObject = bAg(((et)localObject).field_content);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXml filePath is null");
      AppMethodBeat.o(289397);
      return;
    }
    com.tencent.mm.i.g localg = aHf((String)localObject);
    if (!com.tencent.mm.aq.f.bkg().f(localg))
    {
      Log.e("MicroMsg.SelectContactUI", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
      dn(0, "add to cdn failed");
    }
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXml filePath：%s", new Object[] { localObject });
    AppMethodBeat.o(289397);
  }
  
  private boolean kJ(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    Log.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (w.hasAttr(this.Xvg, 65536))
    {
      String str = kL(paramList);
      this.Xwc = true;
      com.tencent.mm.ui.base.h.a(getContext(), str, null, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(288307);
          SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, paramList));
          AppMethodBeat.o(288307);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(290815);
          SelectContactUI.b(SelectContactUI.this, false);
          AppMethodBeat.o(290815);
        }
      });
      bool = this.Xwc;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = kK(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean kK(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (Util.isNullOrNil(this.XvG)) {
        this.XvG = Util.listToString(paramList, ",");
      }
      for (;;)
      {
        bool = ab.Lj(this.XvH);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.XvG);
        paramList.putExtra("received_card_name", this.XvH);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!Util.isNullOrNil(this.XvH)) {
          break;
        }
        this.XvH = Util.listToString(paramList, ",");
      }
      Log.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.XvG, this.XvH });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      Log.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = GP(false);
      ((ArrayList)localObject).remove(z.bcZ());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (Util.isNullOrNil(str)) {
          break label887;
        }
        if ((((ArrayList)localObject).contains(str)) || (z.bcZ().equals(str))) {
          break label228;
        }
        bh.beI();
        as localas = com.tencent.mm.model.c.bbL().RG(str);
        if ((localas == null) || ((int)localas.jxt == 0) || (!com.tencent.mm.contact.d.rk(localas.field_type))) {
          break label887;
        }
        bAf(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label667:
    label887:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        atk();
        hUP().notifyDataSetChanged();
        break;
      }
      hVr();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        Log.i("MicroMsg.SelectContactUI", "Recommend Friends");
        af.a(getContext(), this.XvH, paramList);
        break;
      }
      if (w.hasAttr(this.Xvg, 16384))
      {
        Log.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = Util.listToString(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        if ((hUP() instanceof c)) {
          ((Intent)localObject).putExtra("show_all_select_contact_count", ((c)hUP()).getContactCount());
        }
        if (this.XvZ != null)
        {
          paramList = new ChatroomInfoUI.LocalHistoryInfo();
          paramList.fileid = this.XvZ.field_fileId;
          paramList.aeskey = this.XvZ.field_aesKey;
          paramList.filemd5 = this.XvZ.field_filemd5;
          paramList.iZc = ((int)this.XvZ.field_fileLength);
          paramList.iZd = this.XvU;
          ((Intent)localObject).putExtra("select_record_msg_info", paramList);
          if (this.XvY == null) {
            break label667;
          }
        }
        for (long l = ((Long)this.XvY.first).longValue();; l = 0L)
        {
          ((Intent)localObject).putExtra("select_record_fake_msg_id", l);
          ((Intent)localObject).putExtra("label_source", this.EdH);
          if (this.requestCode == 1) {
            bool = true;
          }
          ((Intent)localObject).putExtra("Is_Chatroom", bool);
          ((Intent)localObject).putExtra("scene_from", 13);
          setResult(-1, (Intent)localObject);
          finish();
          break;
        }
      }
      if (getIntent().getBooleanExtra("shareImage", false))
      {
        Log.i("MicroMsg.SelectContactUI", "Share Image");
        hVq();
        break;
      }
      if (paramList.size() > 0)
      {
        Log.i("MicroMsg.SelectContactUI", "Launch ChattingUI: users=%s", new Object[] { paramList.toString() });
        finish();
        localObject = new Intent();
        ((Intent)localObject).setClass(this, ChattingUI.class);
        ((Intent)localObject).putExtra("Chat_User", (String)paramList.get(0));
        ((Intent)localObject).addFlags(67108864);
        paramList = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramList.aFh(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        awP(3);
        break;
      }
      Log.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String kL(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(R.l.eRQ, new Object[] { aa.PJ((String)paramList.get(0)) });
    }
    label62:
    do
    {
      AppMethodBeat.o(38019);
      return localObject;
      localObject = localStringBuilder;
    } while (paramList.size() <= 1);
    localObject = getString(R.l.eoR);
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
        localObject = getString(R.l.eRQ, new Object[] { localStringBuilder.toString() });
        break;
      }
      localStringBuilder.append(aa.PJ((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(289386);
    Log.i("MicroMsg.SelectContactUI", "height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.EeU != null) && (this.EeU.isRunning())) {
      this.EeU.cancel();
    }
    if (paramInt > 0) {
      if (this.XvK.getTranslationY() != 0.0F) {
        this.XvK.setTranslationY(0.0F);
      }
    }
    for (this.EeU = ObjectAnimator.ofFloat(this.XvK, "translationY", new float[] { 0.0F, -paramInt });; this.EeU = ObjectAnimator.ofFloat(this.XvK, "translationY", new float[] { this.XvK.getTranslationY(), 0.0F }))
    {
      this.EeU.setDuration(200L);
      this.EeU.setInterpolator(new androidx.f.a.a.b());
      this.EeU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(246734);
          Log.i("MicroMsg.SelectContactUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(246734);
        }
      });
      this.EeU.start();
      AppMethodBeat.o(289386);
      return;
    }
  }
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(289384);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(289384);
      return;
    }
    paramView = hUP().awM(i);
    if (paramView == null)
    {
      AppMethodBeat.o(289384);
      return;
    }
    if ((paramView instanceof com.tencent.mm.ui.contact.a.m))
    {
      if (w.hasAttr(this.Xvg, 16384))
      {
        Log.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
        paramView = new Intent();
        paramView.putExtra("Select_Contact", "");
        paramView.putExtra("Select_Conv_User", "");
        paramView.putExtra("Select_Contact", "");
        setResult(-1, paramView);
        finish();
      }
      AppMethodBeat.o(289384);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(289384);
      return;
    }
    if (paramView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(289384);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { paramView });
    if (w.hasAttr(this.Xvg, 64))
    {
      Object localObject;
      if ((ab.Lj(paramView)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        localObject = new Intent(this, ChattingUI.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("Chat_User", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aFh(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        awP(3);
        AppMethodBeat.o(289384);
        return;
      }
      if ((w.hasAttr(this.Xvg, 131072)) && (this.ETN.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.XvC.contains(paramView))
        {
          hUZ();
          if (!this.ETN.contains(paramView)) {
            break label488;
          }
          this.ETP.bqR(paramView);
          this.ETN.remove(paramView);
        }
      }
      for (;;)
      {
        atk();
        hVo();
        if (hUQ() == null) {
          break;
        }
        hUQ().notifyDataSetChanged();
        AppMethodBeat.o(289384);
        return;
        label488:
        localObject = getIntent().getStringExtra("too_many_member_tip_string");
        paramView = (View)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramView = getString(R.l.eRS, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), paramView, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        bAf(paramView);
      }
    }
    kJ(Util.stringsToList(new String[] { paramView }));
    AppMethodBeat.o(289384);
  }
  
  public final void V(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.ETN.remove(paramString);
      if (!(hUP() instanceof x)) {
        break label65;
      }
      paramString = ((x)hUP()).hUL();
      this.ETP.getInputText().setText(paramString);
    }
    for (;;)
    {
      atk();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((hUP() instanceof c)) {
        hUQ().ate();
      } else {
        hUP().notifyDataSetChanged();
      }
    }
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(38002);
    super.a(paramListView, paramInt);
    Object localObject;
    final int k;
    int j;
    final int i;
    label334:
    int m;
    if (w.hasAttr(this.Xvg, 256))
    {
      if (this.Xvw == null)
      {
        SelectContactUI.23 local23 = new SelectContactUI.23(this);
        if (this.XpC == 14)
        {
          localObject = getString(R.l.enO);
          this.Xvw = a(paramListView, local23, (String)localObject);
        }
      }
      else
      {
        this.Xvw.setVisibility(paramInt);
      }
    }
    else
    {
      if (w.hasAttr(this.Xvg, 512))
      {
        if (this.Xvx == null) {
          this.Xvx = a(paramListView, new SelectContactUI.24(this), getString(R.l.eFc));
        }
        this.Xvx.setVisibility(paramInt);
      }
      if (w.hasAttr(this.Xvg, 1024))
      {
        if (this.Xvy == null) {
          this.Xvy = a(paramListView, new SelectContactUI.25(this), getString(R.l.enB));
        }
        this.Xvy.setVisibility(paramInt);
      }
      if (w.hasAttr(this.Xvg, 2048))
      {
        if (this.XvA == null) {
          this.XvA = a(paramListView, new SelectContactUI.26(this), getString(R.l.enM));
        }
        this.XvA.setVisibility(paramInt);
        this.XvA.setTextSize(16.0F * com.tencent.mm.ci.a.ez(this.XvA.getContext()));
      }
      if (w.hasAttr(this.Xvg, 524288)) {
        if (this.Xvz == null)
        {
          localObject = "";
          k = getIntent().getIntExtra("topstory_import_type", 0);
          j = R.l.enF;
          i = R.l.enG;
          if (k != 1) {
            break label642;
          }
          localObject = com.tencent.mm.plugin.sns.b.p.JPf.Qs(5L);
          if (!Util.isNullOrNil((List)localObject)) {
            break label631;
          }
          i = 0;
          localObject = Util.listToString((List)localObject, ",");
          j = R.l.enF;
          m = R.l.enG;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.Xvz = a(paramListView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200182);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          com.tencent.mm.ui.base.h.c(SelectContactUI.this, SelectContactUI.this.getString(i, new Object[] { Integer.valueOf(k) }), "", SelectContactUI.this.getString(R.l.enC), SelectContactUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(286369);
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.2.this.Xwl);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(286369);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200182);
        }
      }, getString(j));
      this.Xvz.setTag(Integer.valueOf(k));
      localObject = this.Xvz.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.Xvz.setVisibility(8);
      }
      for (;;)
      {
        if (w.hasAttr(this.Xvg, 16777216))
        {
          if (this.XvB == null)
          {
            bh.beI();
            localObject = com.tencent.mm.model.c.bbL().hyk();
            Log.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.XvB = a(paramListView, new SelectContactUI.4(this), "");
              paramListView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a("3552365301", "openim_acct_type_title", a.a.mxX);
              this.XvB.setVisibility(paramInt);
              this.XvB.setText(paramListView);
            }
          }
          if (this.XvB != null) {
            this.XvB.setVisibility(paramInt);
          }
        }
        if ((!w.hasAttr(this.Xvg, 16777216)) || (this.XvB == null)) {
          break label714;
        }
        this.XvB.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
        AppMethodBeat.o(38002);
        return;
        localObject = getString(R.l.enA);
        break;
        label631:
        i = ((List)localObject).size();
        break label334;
        label642:
        if (k != 2) {
          break label862;
        }
        localObject = com.tencent.mm.pluginsdk.j.a.hhW();
        if (Util.isNullOrNil((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = Util.listToString((List)localObject, ",");
          j = R.l.enD;
          m = R.l.enE;
          k = i;
          i = m;
          break;
        }
        this.Xvz.setVisibility(paramInt);
      }
      label714:
      if (w.hasAttr(this.Xvg, 2048))
      {
        if (this.XvA != null)
        {
          this.XvA.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          AppMethodBeat.o(38002);
        }
      }
      else if (w.hasAttr(this.Xvg, 1024))
      {
        if (this.Xvy != null)
        {
          this.Xvy.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          AppMethodBeat.o(38002);
        }
      }
      else if (w.hasAttr(this.Xvg, 512))
      {
        if (this.Xvx != null)
        {
          this.Xvx.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          AppMethodBeat.o(38002);
        }
      }
      else if ((w.hasAttr(this.Xvg, 256)) && (this.Xvw != null)) {
        this.Xvw.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
      }
      AppMethodBeat.o(38002);
      return;
      label862:
      k = 0;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38014);
    boolean bool;
    if ((parama.XsX) && (parama.contact != null))
    {
      bool = this.ETN.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.XsY) && (parama.contact != null))
    {
      bool = this.ETN.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof com.tencent.mm.ui.contact.a.m))
    {
      bool = this.ETN.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final void aOd(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.h.IzE.a(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(GP(w.hasAttr(this.Xvg, 8192)));
    paramString.addAll(this.XvC);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    if (w.hasAttr(this.Xvg, 64))
    {
      localIntent.putExtra("list_attr", w.P(new int[] { 16384, 64, 131072 }));
      if (this.XpC == 14) {
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
  
  protected final void ata()
  {
    AppMethodBeat.i(37997);
    super.ata();
    this.Xvg = getIntent().getIntExtra("list_attr", w.XtJ);
    this.title = getIntent().getStringExtra("titile");
    this.rsw = getIntent().getStringExtra("sub_title");
    this.XpC = getIntent().getIntExtra("list_type", -1);
    this.Xvh = getIntent().getBooleanExtra("show_too_many_member", true);
    this.EdH = getIntent().getStringExtra("label_source");
    if ((w.hasAttr(this.Xvg, 256)) && (ab.bdX().size() == 0)) {
      w.mC(this.Xvg, 256);
    }
    this.XvE = getIntent().getBooleanExtra("Add_SendCard", false);
    this.XvF = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.XvE) || (this.XvF))
    {
      this.XvG = Util.nullAs(getIntent().getStringExtra("be_send_card_name"), "");
      this.XvH = Util.nullAs(getIntent().getStringExtra("received_card_name"), "");
    }
    this.XvI = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.XvS = getIntent().getBooleanExtra("is_select_record_msg_mode", false);
    this.XvJ = getIntent().getIntExtra("menu_mode", 1);
    this.jaK = getIntent().getStringExtra("chatroomName");
    Log.i("MicroMsg.SelectContactUI", "mRoomId：%s", new Object[] { Util.nullAs(this.jaK, "") });
    this.jkb = new ArrayList();
    this.ETN = new LinkedList();
    this.XvC = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.XvC.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.ETN.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(w.hVh());
    ((HashSet)localObject).addAll(w.hVi());
    if (!w.hasAttr(this.Xvg, 268435456)) {
      ((HashSet)localObject).add(z.bcZ());
    }
    if (this.XvE) {
      ((HashSet)localObject).removeAll(w.hVh());
    }
    this.jkb.add("gh_3dfda90e39d6");
    this.jkb.add("gh_b4af18eac3d5");
    this.jkb.addAll((Collection)localObject);
    hVo();
    AppMethodBeat.o(37997);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38015);
    if ((parama.XsX) && (parama.contact != null))
    {
      if (w.hasAttr(this.Xvg, 536870912))
      {
        bool = parama.contact.ayk();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.XvC.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  protected final boolean bwH()
  {
    return false;
  }
  
  protected final boolean bwI()
  {
    return true;
  }
  
  protected final String bwJ()
  {
    return this.title;
  }
  
  protected final r bwK()
  {
    boolean bool2 = true;
    label396:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(38000);
        Object localObject1 = new c.a();
        ((c.a)localObject1).Xqx = w.hasAttr(this.Xvg, 16);
        ((c.a)localObject1).Xqw = w.hasAttr(this.Xvg, 32);
        ((c.a)localObject1).XqA = getIntent().getBooleanExtra("create_group_recommend", false);
        if (!w.hasAttr(this.Xvg, 4))
        {
          bool1 = true;
          ((c.a)localObject1).Xqy = bool1;
          if (!w.hasAttr(this.Xvg, 1))
          {
            bool1 = true;
            ((c.a)localObject1).Xqz = bool1;
            ((c.a)localObject1).XqB = w.hasAttr(this.Xvg, 128);
            ((c.a)localObject1).XqC = w.hasAttr(this.Xvg, 1048576);
            ((c.a)localObject1).XqG = w.hasAttr(this.Xvg, 256);
            if (((c.a)localObject1).XqG) {
              ((c.a)localObject1).XqH = getIntent().getStringExtra("custom_contact");
            }
            if (((c.a)localObject1).XqB)
            {
              this.Xwd = true;
              ((c.a)localObject1).XqE = getIntent().getStringExtra("wechat_sport_contact");
              ((c.a)localObject1).XqF = getIntent().getStringExtra("wechat_sport_recent_like");
              this.Xwe = ((c.a)localObject1).XqE;
            }
            if (!w.hVj()) {
              continue;
            }
            ((c.a)localObject1).XoS = "@all.contact.without.chatroom.without.openim";
            if ((this.scene == 6) || (this.scene == 5)) {
              ((c.a)localObject1).XoS = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
              ((c.a)localObject1).XoS = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            List localList1 = this.XvC;
            List localList2 = this.ETN;
            List localList3 = this.jkb;
            boolean bool3 = w.hasAttr(this.Xvg, 1);
            boolean bool4 = w.hasAttr(this.Xvg, 64);
            if (this.XpC != 15) {
              break label396;
            }
            bool1 = bool2;
            localObject1 = new c(this, localList1, localList2, localList3, bool3, bool4, (c.a)localObject1, bool1, hVn());
            AppMethodBeat.o(38000);
            return localObject1;
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        boolean bool1 = false;
        continue;
        ((c.a)localObject1).XoS = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        continue;
        bool1 = false;
      }
      finally {}
    }
  }
  
  protected final p bwL()
  {
    AppMethodBeat.i(38001);
    if (this.Xwd)
    {
      localObject = new v(this, this.jkb, w.hasAttr(this.Xvg, 64), this.Xwe);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new x(this, this.XvC, this.ETN, this.jkb, w.hasAttr(this.Xvg, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new u(this, this.jkb, w.hasAttr(this.Xvg, 64), this.scene, hVn());
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  public final int[] dvA()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!w.hasAttr(this.Xvg, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!w.hasAttr(this.Xvg, 4)) {
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
  
  protected final boolean eRT()
  {
    return !this.Xwd;
  }
  
  public final q hUP()
  {
    AppMethodBeat.i(289379);
    q localq = super.hUP();
    Object localObject = localq;
    if (localq == null)
    {
      localObject = bwK();
      a((r)localObject);
      Log.i("MicroMsg.SelectContactUI", "getAdapter is null");
    }
    AppMethodBeat.o(289379);
    return localObject;
  }
  
  public final r hUQ()
  {
    AppMethodBeat.i(289381);
    r localr2 = super.hUQ();
    r localr1 = localr2;
    if (localr2 == null)
    {
      localr1 = bwK();
      getContentLV().setAdapter(localr1);
      Log.i("MicroMsg.SelectContactUI", "getInitAdapter is null");
    }
    AppMethodBeat.o(289381);
    return localr1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(289375);
    super.initView();
    this.XvK = ((RelativeLayout)findViewById(R.h.select_record_msg_ll));
    this.XvL = ((LinearLayout)findViewById(R.h.select_record_msg_bt));
    this.XvR = ((Button)findViewById(R.h.finish_button));
    this.XvM = ((ImageView)findViewById(R.h.select_record_msg_success_iv));
    this.XvN = ((ImageView)findViewById(R.h.select_record_msg_warn_iv));
    this.XvO = ((ImageView)findViewById(R.h.select_record_msg_right_arrow_iv));
    this.XvP = ((ProgressBar)findViewById(R.h.record_msg_upload_progress));
    this.XvQ = ((TextView)findViewById(R.h.select_record_msg_tips));
    this.XvL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37978);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.SelectContactUI", "click selectRecordMsgBt %s", new Object[] { Util.nullAs(SelectContactUI.d(SelectContactUI.this), "") });
        SelectContactUI.this.hideVKB();
        paramAnonymousView = new Intent().putExtra("Chat_User", SelectContactUI.d(SelectContactUI.this)).putExtra("finish_direct", true).putExtra("key_record_msg_select", true).putExtra("key_record_msg_select_introduce", SelectContactUI.g(SelectContactUI.this)).putExtra("key_record_select_min_msg_id", SelectContactUI.f(SelectContactUI.this)).putExtra("key_record_select_msg_num", SelectContactUI.e(SelectContactUI.this));
        if (SelectContactUI.h(SelectContactUI.this) != null) {
          paramAnonymousView.putStringArrayListExtra("key_record_select_msg_black_list", SelectContactUI.h(SelectContactUI.this));
        }
        com.tencent.mm.by.c.d(SelectContactUI.this, ".ui.chatting.ChattingUI", paramAnonymousView, 6);
        SelectContactUI.i(SelectContactUI.this);
        com.tencent.mm.plugin.selectrecord.b.a.fFx().Jcu.gNb = 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37978);
      }
    });
    this.XvN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.SelectContactUI", "click warn to retry");
        SelectContactUI.a(SelectContactUI.this, null);
        SelectContactUI.j(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, true);
        SelectContactUI.k(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, l.m(SelectContactUI.this, "msginfo@fakeuser", true));
        if (!((Boolean)SelectContactUI.a(SelectContactUI.this).second).booleanValue()) {
          SelectContactUI.l(SelectContactUI.this).alive();
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
          paramAnonymousView.JcE += 1;
          Log.i("MicroMsg.SelectContactUI", "click warn to retry, msgId:%s direct:%s", new Object[] { SelectContactUI.a(SelectContactUI.this).first, SelectContactUI.a(SelectContactUI.this).second });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37979);
          return;
          SelectContactUI.b(SelectContactUI.this);
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.fFy();
    Object localObject = com.tencent.mm.plugin.selectrecord.b.a.fFx();
    String str = this.jaK;
    kk localkk = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).Jcu;
    localkk.gMR = localkk.z("RoomId", str, true);
    localObject = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).Jcu;
    int i;
    if (ab.PT(str))
    {
      i = 1;
      ((kk)localObject).gNt = i;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWv, 0);
      Log.d("MicroMsg.recordSelect.SelectRecordConfig", "canSelectRecordInAddRoomMembers() sw:%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label451;
      }
      i = 1;
      label250:
      if ((i == 0) || (!ab.PP(this.jaK)) || (ab.PT(this.jaK)) || (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().aPh(this.jaK) <= 0L)) {
        break label456;
      }
      this.XvL.setVisibility(0);
      com.tencent.mm.plugin.selectrecord.b.a.fFx().xL(true);
    }
    for (;;)
    {
      if (this.XvJ == 2)
      {
        this.jij = new com.tencent.mm.ui.tools.i(this);
        this.jij.XSx = this;
      }
      if (hVn())
      {
        setTheme(R.m.AppTheme_DarkMode);
        setActionbarColor(getResources().getColor(R.e.Dark_0));
        setNavigationbarColor(getResources().getColor(R.e.Dark_0));
        hUU();
        hUV();
        this.Hpw.setBackgroundResource(R.e.Dark_2);
        this.XsZ.setTextColor(getResources().getColor(R.e.BW_100_Alpha_0_2));
        this.XsZ.setBackgroundColor(getResources().getColor(R.e.finder_live_logo_color));
      }
      AppMethodBeat.o(289375);
      return;
      i = 0;
      break;
      label451:
      i = 0;
      break label250;
      label456:
      this.XvL.setVisibility(8);
      com.tencent.mm.plugin.selectrecord.b.a.fFx().xL(false);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38021);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.requestCode = paramInt1;
    Log.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
          } while (Util.isNullOrNil(paramIntent));
          kJ(Util.stringsToList(new String[] { paramIntent }));
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          localObject1 = this.ETN.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            this.ETP.bqS(str1);
          }
          this.ETN.clear();
          if (!Util.isNullOrNil(paramIntent)) {
            this.ETN.addAll(Util.stringsToList(paramIntent.split(",")));
          }
          paramIntent = this.ETN.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.ETP.bqT((String)localObject1);
          }
          atk();
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Contact");
        } while (Util.isNullOrNil(paramIntent));
        kJ(Util.stringsToList(paramIntent.split(",")));
        AppMethodBeat.o(38021);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil(paramIntent)) {
        kJ(Util.stringsToList(new String[] { paramIntent }));
      }
      AppMethodBeat.o(38021);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (Util.isNullOrNil(paramIntent))
      {
        Log.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS return usernames is null or empty");
        AppMethodBeat.o(38021);
        return;
      }
      Log.i("MicroMsg.SelectContactUI", "GET_LABEL_USERS select username=%s", new Object[] { paramIntent });
      if (w.hasAttr(this.Xvg, 64))
      {
        paramIntent = paramIntent.split(",");
        paramInt2 = paramIntent.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject1 = paramIntent[paramInt1];
          if (this.ETN.add(localObject1)) {
            this.ETP.bqR((String)localObject1);
          }
          paramInt1 += 1;
        }
        atk();
        hUP().notifyDataSetChanged();
        AppMethodBeat.o(38021);
        return;
      }
      kJ(Util.stringsToList(new String[] { paramIntent }));
      AppMethodBeat.o(38021);
      return;
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("Select_Contact");
        localObject1 = paramIntent.getStringExtra("Cancel_Select_Contact");
        if (Util.isNullOrNil(str1))
        {
          paramIntent = null;
          if (!Util.isNullOrNil((String)localObject1)) {
            break label642;
          }
          localObject1 = null;
        }
        Object localObject2;
        for (;;)
        {
          if (paramIntent != null)
          {
            if (this.ETP != null)
            {
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  String str2 = (String)((Iterator)localObject2).next();
                  if (!this.ETN.contains(str2))
                  {
                    this.ETP.bqR(str2);
                    continue;
                    paramIntent = Util.stringToList(str1, ",");
                    break;
                    localObject1 = Util.stringToList((String)localObject1, ",");
                    break label563;
                  }
                }
              }
            }
            this.ETN.addAll(paramIntent);
          }
        }
        if (localObject1 != null)
        {
          if (this.ETP != null)
          {
            paramIntent = ((List)localObject1).iterator();
            while (paramIntent.hasNext())
            {
              localObject2 = (String)paramIntent.next();
              this.ETP.bqR((String)localObject2);
            }
          }
          this.ETN.removeAll((Collection)localObject1);
        }
        hUP().notifyDataSetChanged();
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
          kJ(Util.stringsToList(new String[] { str1 }));
        }
      }
      atk();
      AppMethodBeat.o(38021);
      return;
    } while (paramIntent == null);
    label642:
    this.XvT = paramIntent.getIntExtra("select_record_msg_num", 0);
    this.XvU = this.XvT;
    this.Xwa = paramIntent.getStringArrayListExtra("key_select_record_msg_black_list");
    this.XvZ = null;
    this.XvW = false;
    if (this.XvT == 0)
    {
      this.XvV = false;
      hVp();
    }
    for (;;)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.a.fFx();
      long l = this.XvU;
      paramIntent.Jcu.gHM = l;
      Log.i("MicroMsg.SelectContactUI", "GET_SELECT_RECORD_MSG selectMsgNum:%s actualSelectMsgNum:%s msgId:%s direct:%s", new Object[] { Integer.valueOf(this.XvT), Integer.valueOf(this.XvU), this.XvY.first, this.XvY.second });
      break;
      this.XvV = true;
      this.WNr = paramIntent.getLongExtra("select_record_min_msg_id", -1L);
      if ((l.hMF() > 0) && (l.hMF() < this.XvT)) {
        this.XvU = l.hMF();
      }
      hVp();
      com.tencent.mm.plugin.selectrecord.b.a.fFx().JcC = cm.bfC();
      this.XvY = l.c(this, "msginfo@fakeuser", true, this.jaK);
      if (!((Boolean)this.XvY.second).booleanValue()) {
        this.Xwf.alive();
      } else {
        hVs();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectContactUI", "create!");
    bh.aGY().a(30, this);
    bh.aGY().a(138, this);
    if (!Util.isNullOrNil(this.rsw)) {
      setMMSubTitle(this.rsw);
    }
    label121:
    int i;
    if (w.hasAttr(this.Xvg, 64))
    {
      if (this.XvJ != 1) {
        break label260;
      }
      GN(false);
      String str = getString(R.l.app_ok);
      MenuItem.OnMenuItemClickListener local7 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(278999);
          boolean bool = SelectContactUI.r(SelectContactUI.this);
          AppMethodBeat.o(278999);
          return bool;
        }
      };
      if (hVn())
      {
        paramBundle = w.b.WaE;
        addTextOptionMenu(1, str, local7, null, paramBundle);
      }
    }
    else
    {
      atk();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(271722);
          SelectContactUI.this.hideVKB();
          SelectContactUI.this.finish();
          if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            MMHandlerThread.postToMainThreadDelayed(SelectContactUI.c(SelectContactUI.this), 80L);
          }
          AppMethodBeat.o(271722);
          return true;
        }
      });
      if ((this.XpC != 15) && (this.ETP != null)) {
        this.ETP.jk(this.ETN);
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
      y.Xux = i;
      Log.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(37995);
      return;
      paramBundle = w.b.Wao;
      break;
      label260:
      GN(true);
      this.XvR.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(274423);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (SelectContactUI.s(SelectContactUI.this))
          {
            com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(R.l.record_msg_upload_tips), "", SelectContactUI.this.getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(275928);
                Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                AppMethodBeat.o(275928);
              }
            });
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
            paramAnonymousView.JcG += 1;
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(274423);
            return;
            if (SelectContactUI.t(SelectContactUI.this))
            {
              com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(R.l.record_msg_upload_net_fail_tips), "", SelectContactUI.this.getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(196197);
                  Log.i("MicroMsg.SelectContactUI", "initMenu(upload fail) click i know");
                  AppMethodBeat.o(196197);
                }
              });
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.fFx();
              paramAnonymousView.JcH += 1;
              com.tencent.mm.plugin.selectrecord.b.a.fFx().fFB();
            }
            else
            {
              SelectContactUI.r(SelectContactUI.this);
            }
          }
        }
      });
      break label121;
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
    this.Xwf.dead();
    bh.aGY().b(30, this);
    bh.aGY().b(138, this);
    awP(1);
    y.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(289374);
    super.onPause();
    if (this.jij != null) {
      this.jij.close();
    }
    AppMethodBeat.o(289374);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(289372);
    super.onResume();
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(289372);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(38013);
    if (this.iXX != null)
    {
      this.iXX.dismiss();
      this.iXX = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if (ac.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      if ((paramInt1 == 4) && (paramInt2 == -24) && (!Util.isNullOrNil(paramString))) {
        Toast.makeText(this, paramString, 1).show();
      }
      AppMethodBeat.o(38013);
      return;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38013);
      return;
      hUP().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(289373);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.jij != null) {
      this.jij.start();
    }
    AppMethodBeat.o(289373);
  }
  
  static final class c
    implements Runnable
  {
    private ArrayList<String> Xwx;
    private WeakReference<SelectContactUI> cNB;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.cNB = new WeakReference(paramSelectContactUI);
      this.Xwx = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cNB.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = z.bcZ();
      Iterator localIterator = this.Xwx.iterator();
      int i = 0;
      Object localObject1 = null;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Log.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (ab.Lj((String)localObject2))
        {
          j = 1;
          label94:
          i += j;
          o.e locale = o.a(o.d.lUk).wb(4);
          locale.fLi = str;
          locale.toUser = ((String)localObject2);
          locale.lPO = localSelectContactUI.getIntent().getStringExtra("shareImagePath");
          locale.lNK = 0;
          locale.lUr = null;
          locale.fJu = 0;
          locale.lNS = "";
          locale.thumbPath = "";
          locale.lUu = true;
          locale.lUt = R.g.chat_img_template;
          locale.thumbPath = ((String)localObject1);
          locale.lUq = 11;
          localObject2 = locale.bnl();
          ((o.b)localObject2).aEv();
          localObject2 = (com.tencent.mm.ay.n)((o.b)localObject2).lUi;
          if (((com.tencent.mm.ay.n)localObject2).blT() == null) {
            break label333;
          }
          localObject1 = ((com.tencent.mm.ay.n)localObject2).blT().field_imgPath;
        }
      }
      label333:
      for (;;)
      {
        break;
        j = 0;
        break label94;
        SelectContactUI.C(localSelectContactUI).dismiss();
        localObject1 = new Intent();
        ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.Xwx);
        localSelectContactUI.setResult(-1, (Intent)localObject1);
        com.tencent.mm.plugin.report.service.h.IzE.a(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.Xwx.size() - i), Integer.valueOf(i) });
        localSelectContactUI.finish();
        AppMethodBeat.o(37993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */