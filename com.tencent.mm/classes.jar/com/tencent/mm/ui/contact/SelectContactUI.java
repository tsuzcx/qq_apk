package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.R.m;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.tq;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.kx;
import com.tencent.mm.autogen.mmdata.rpt.nd;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.o;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelmulti.t.b;
import com.tencent.mm.modelmulti.t.d;
import com.tencent.mm.modelmulti.t.e;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.ab.b;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y.b;
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
import java.util.UUID;

public class SelectContactUI
  extends MMBaseSelectContactUI
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  private String JUF;
  private String JUG;
  private ObjectAnimator JWJ;
  private List<String> KOr;
  private long aevR;
  private int afbe;
  private String afhA;
  private boolean afhB;
  private int afhC;
  private RelativeLayout afhD;
  private LinearLayout afhE;
  private ImageView afhF;
  private ImageView afhG;
  private ImageView afhH;
  private ProgressBar afhI;
  private TextView afhJ;
  private Button afhK;
  private boolean afhL;
  private int afhM;
  private int afhN;
  private boolean afhO;
  private ArrayList<String> afhP;
  private boolean afhQ;
  private boolean afhR;
  private Pair<Long, Boolean> afhS;
  private com.tencent.mm.g.d afhT;
  private boolean afhU;
  private boolean afhV;
  private List<cc> afhW;
  private com.tencent.mm.g.d afhX;
  private boolean afhY;
  private boolean afhZ;
  private int afhe;
  private boolean afhf;
  private a afhg;
  private TextView afhp;
  private TextView afhq;
  private TextView afhr;
  private TextView afhs;
  private TextView afht;
  private TextView afhu;
  private List<String> afhv;
  private Map<String, Integer> afhw;
  private boolean afhx;
  private boolean afhy;
  private String afhz;
  private boolean afia;
  private boolean afib;
  private String afic;
  private String afid;
  private long afie;
  private IListener<tq> afif;
  private SelectContactUI.b afig;
  private boolean afih;
  private HashMap<String, String> afii;
  private HashMap<String, d> afij;
  private int hPm;
  private com.tencent.mm.ui.tools.i lKz;
  private List<String> lMF;
  private String lyn;
  private ProgressDialog lzP;
  private String qYC;
  private String title;
  private String uCW;
  private g.a zRy;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.afhw = new HashMap();
    this.afhM = 0;
    this.afhN = 0;
    this.afhO = true;
    this.afhP = null;
    this.aevR = -1L;
    this.afhQ = false;
    this.afhR = false;
    this.afhS = new Pair(Long.valueOf(-1L), Boolean.FALSE);
    this.afhU = false;
    this.afhV = false;
    this.afhW = new ArrayList();
    this.afhf = true;
    this.afia = false;
    this.afib = false;
    this.afid = "";
    this.qYC = UUID.randomUUID().toString();
    this.afie = 0L;
    this.afif = new IListener(com.tencent.mm.app.f.hfK) {};
    this.afig = new SelectContactUI.b(this, (byte)0);
    this.JWJ = null;
    this.afih = false;
    this.afii = new HashMap();
    this.afij = new HashMap();
    this.zRy = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(253031);
        if (paramAnonymousInt == -21005)
        {
          Log.i("MicroMsg.SelectContactUI", "ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(253031);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          SelectContactUI.d locald = (SelectContactUI.d)SelectContactUI.H(SelectContactUI.this).get(paramAnonymousString);
          if ((locald != null) && (locald.isNew))
          {
            SelectContactUI.b(SelectContactUI.this, paramAnonymousd);
            SelectContactUI.b(SelectContactUI.this, false);
          }
          for (;;)
          {
            Log.i("MicroMsg.SelectContactUI", "sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] result:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(com.tencent.mm.vfs.y.deleteFile(locald.filePath)) });
            SelectContactUI.l(SelectContactUI.this);
            com.tencent.mm.plugin.selectrecord.b.a.gUF().ue(cn.bDu());
            AppMethodBeat.o(253031);
            return 0;
            SelectContactUI.a(SelectContactUI.this, paramAnonymousd);
            SelectContactUI.a(SelectContactUI.this, false);
          }
        }
        if (paramAnonymousd != null)
        {
          Log.w("MicroMsg.SelectContactUI", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd.field_retCode, "cdn ret error");
          AppMethodBeat.o(253031);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.SelectContactUI", "start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, 0, "cdn start error");
          AppMethodBeat.o(253031);
          return 0;
        }
        Log.i("MicroMsg.SelectContactUI", "on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.SelectContactUI", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
        }
        AppMethodBeat.o(253031);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.afhg = new a();
    AppMethodBeat.o(37994);
  }
  
  private void MB(boolean paramBoolean)
  {
    AppMethodBeat.i(252859);
    RelativeLayout localRelativeLayout = this.afhD;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      if (this.Nnk != null) {
        this.afhD.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(253473);
            int i = SelectContactUI.n(SelectContactUI.this).getHeight();
            ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)SelectContactUI.this.Nnk.getLayoutParams();
            localMarginLayoutParams.bottomMargin = i;
            SelectContactUI.this.Nnk.setLayoutParams(localMarginLayoutParams);
            AppMethodBeat.o(253473);
          }
        });
      }
      AppMethodBeat.o(252859);
      return;
    }
  }
  
  private void MC(boolean paramBoolean)
  {
    AppMethodBeat.i(252901);
    if (this.afhC == 1)
    {
      enableOptionMenu(1, paramBoolean);
      AppMethodBeat.o(252901);
      return;
    }
    this.afhK.setEnabled(paramBoolean);
    AppMethodBeat.o(252901);
  }
  
  private ArrayList<String> MD(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.KOr.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (ab.IQ((String)localObject)))
      {
        localObject = com.tencent.mm.model.v.Im((String)localObject);
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
  
  private ArrayList<String> ME(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.KOr.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (ab.IQ((String)localObject)))
      {
        localObject = com.tencent.mm.model.v.Im((String)localObject);
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
    localHashSet.addAll(this.afhv);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = af.mU(this).inflate(R.i.gkq, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(R.h.content_tv);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    AppMethodBeat.o(38003);
    return paramOnClickListener;
  }
  
  private static String a(ze paramze)
  {
    AppMethodBeat.i(252941);
    if (paramze == null)
    {
      Log.e("MicroMsg.SelectContactUI", "historyMsgList is null");
      AppMethodBeat.o(252941);
      return null;
    }
    String str = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
    if (!com.tencent.mm.vfs.y.ZC(str)) {
      com.tencent.mm.vfs.y.bDX(str);
    }
    try
    {
      str = str + com.tencent.mm.b.g.getMessageDigest(paramze.toByteArray());
      if (com.tencent.mm.vfs.y.ZC(str)) {
        com.tencent.mm.vfs.y.deleteFile(str);
      }
      paramze = paramze.toByteArray();
      com.tencent.mm.vfs.y.f(str, paramze, paramze.length);
      com.tencent.mm.plugin.selectrecord.b.a.gUF().uf(com.tencent.mm.vfs.y.bEl(str));
      AppMethodBeat.o(252941);
      return str;
    }
    catch (Exception paramze)
    {
      Log.printErrStackTrace("MicroMsg.SelectContactUI", paramze, "", new Object[0]);
      AppMethodBeat.o(252941);
    }
    return null;
  }
  
  private void a(final com.tencent.mm.roomsdk.model.factory.a parama)
  {
    AppMethodBeat.i(38011);
    parama.d(new com.tencent.mm.roomsdk.model.b.c() {});
    parama.a(this, getString(R.l.app_tip), getString(R.l.gME), true, true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(253040);
        SelectContactUI.G(SelectContactUI.this);
        parama.cancel();
        AppMethodBeat.o(253040);
      }
    });
    aDw(2);
    AppMethodBeat.o(38011);
  }
  
  private void aDw(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.afih)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.afih = true;
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
        localObject = this.KOr.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.afhw.containsKey(str)) {
          switch (((Integer)this.afhw.get(str)).intValue())
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
      Log.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(jyE().jyc()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.OAn.b(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(jyE().jyc()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.afhv);
      ((List)localObject).addAll(this.KOr);
      y.nZ((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private void aNr()
  {
    AppMethodBeat.i(38006);
    if ((w.hasAttr(this.afhe, 64)) && (this.KOr.size() > 0))
    {
      bBX(getString(R.l.app_finish) + "(" + this.KOr.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((w.hasAttr(this.afhe, 262144)) && (this.KOr.size() < i))
      {
        MC(false);
        AppMethodBeat.o(38006);
        return;
      }
      MC(true);
      AppMethodBeat.o(38006);
      return;
    }
    if (w.hasAttr(this.afhe, 64)) {
      w.hasAttr(this.afhe, 4194304);
    }
    bBX(getString(R.l.app_finish));
    MC(true);
    AppMethodBeat.o(38006);
  }
  
  private void ag(int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(252952);
    Log.i("MicroMsg.SelectContactUI", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString1, "") });
    this.afhR = true;
    this.afhV = true;
    this.afhQ = false;
    this.afhU = false;
    jzj();
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(253032);
        SelectContactUI localSelectContactUI = SelectContactUI.this;
        if (Util.isNullOrNil(paramString2)) {}
        for (String str = SelectContactUI.this.getString(R.l.record_msg_upload_net_fail_tips);; str = paramString2)
        {
          com.tencent.mm.ui.base.k.a(localSelectContactUI, str, "", SelectContactUI.this.getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(252957);
              Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
              AppMethodBeat.o(252957);
            }
          });
          AppMethodBeat.o(253032);
          return;
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.gUF().ue(cn.bDu());
    com.tencent.mm.plugin.selectrecord.b.a.gUF().gUJ();
    AppMethodBeat.o(252952);
  }
  
  private static String atK(String paramString)
  {
    AppMethodBeat.i(252944);
    paramString = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + paramString).getBytes());
    AppMethodBeat.o(252944);
    return paramString;
  }
  
  private void bBX(String paramString)
  {
    AppMethodBeat.i(252907);
    if (this.afhC == 1)
    {
      updateOptionMenuText(1, paramString);
      AppMethodBeat.o(252907);
      return;
    }
    this.afhK.setText(paramString);
    AppMethodBeat.o(252907);
  }
  
  private void bBY(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.afhv.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.KOr.contains(paramString))
    {
      this.KOr.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (jyE() == jyF()) {
          break label311;
        }
        ((c)jyF()).afbU.reset();
        jyF().aNm();
        this.afeL.dCv();
        hideVKB();
      }
      label108:
      if (!(jyE() instanceof x)) {
        break label339;
      }
      String str = ((x)jyE()).jyC();
      if (this.KOt != null) {
        this.KOt.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.KOt.bqG(paramString);
      AppMethodBeat.o(38018);
      return;
      this.KOr.add(paramString);
      if ((jyE() instanceof x))
      {
        if (((x)jyE()).jyZ())
        {
          this.afhw.put(paramString, Integer.valueOf(((x)jyE()).bBO(paramString)));
          i = 0;
          break;
        }
        this.afhw.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (jyE() == jyF())
      {
        if (((c)jyF()).bBH(paramString))
        {
          this.afhw.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.afhw.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label311:
      if ((i == 0) && (!((c)jyF()).bBH(paramString))) {
        break label108;
      }
      jyF().aNm();
      break label108;
      label339:
      iKA();
    }
  }
  
  private static String bBZ(String paramString)
  {
    AppMethodBeat.i(252940);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.SelectContactUI", "xml is null");
      AppMethodBeat.o(252940);
      return null;
    }
    String str = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
    if (!com.tencent.mm.vfs.y.ZC(str)) {
      com.tencent.mm.vfs.y.bDX(str);
    }
    try
    {
      str = str + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      if (com.tencent.mm.vfs.y.ZC(str)) {
        com.tencent.mm.vfs.y.deleteFile(str);
      }
      paramString = paramString.getBytes();
      com.tencent.mm.vfs.y.f(str, paramString, paramString.length);
      com.tencent.mm.plugin.selectrecord.b.a.gUF().uf(com.tencent.mm.vfs.y.bEl(str));
      AppMethodBeat.o(252940);
      return str;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SelectContactUI", paramString, "", new Object[0]);
      AppMethodBeat.o(252940);
    }
    return null;
  }
  
  private static List<String> bs(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!bh.baz())
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
      bh.bCz();
      au localau = com.tencent.mm.model.c.bzA().JE(str);
      paramList = str;
      if (localau != null)
      {
        paramList = str;
        if ((int)localau.maN != 0) {
          paramList = localau.aSV();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private void ef(int paramInt, String paramString)
  {
    AppMethodBeat.i(252948);
    ag(paramInt, paramString, "");
    AppMethodBeat.o(252948);
  }
  
  private com.tencent.mm.g.g ep(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(252942);
    com.tencent.mm.g.g localg = new com.tencent.mm.g.g();
    localg.ihD = true;
    localg.lwL = this.zRy;
    localg.field_mediaId = atK(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.g.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.g.a.lvZ;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 0;
    localg.field_bzScene = 0;
    this.afii.put(localg.field_mediaId, localg.field_fullpath);
    this.afij.put(localg.field_mediaId, new d(localg.field_mediaId, localg.field_fullpath, paramBoolean));
    AppMethodBeat.o(252942);
    return localg;
  }
  
  private boolean jzh()
  {
    AppMethodBeat.i(252863);
    boolean bool = getIntent().getBooleanExtra("KForceDarkMode", false);
    AppMethodBeat.o(252863);
    return bool;
  }
  
  private void jzi()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.afhf) && ((this.afbe == 1) || (this.afbe == 0))) {
      if (this.afhv == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.afhv.size();; i = 0)
    {
      if (this.KOr != null) {
        j = this.KOr.size();
      }
      int k = Util.safeParseInt(com.tencent.mm.k.i.aRC().getValue("ChatRoomInviteStartCount"));
      this.afhg.f(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void jzj()
  {
    AppMethodBeat.i(252911);
    com.tencent.threadpool.h.ahAA.bk(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(252755);
        if (SelectContactUI.x(SelectContactUI.this))
        {
          if (SelectContactUI.y(SelectContactUI.this) == 0)
          {
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setVisibility(8);
            SelectContactUI.B(SelectContactUI.this).setVisibility(8);
            SelectContactUI.C(SelectContactUI.this).setVisibility(0);
            SelectContactUI.D(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.share_record_tips_text_color));
            SelectContactUI.D(SelectContactUI.this).setText(R.l.select_record_msg_hint);
            SelectContactUI.E(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_empty_selector_new));
            AppMethodBeat.o(252755);
            return;
          }
          if ((SelectContactUI.v(SelectContactUI.this)) || (SelectContactUI.w(SelectContactUI.this)))
          {
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setVisibility(0);
            SelectContactUI.B(SelectContactUI.this).setVisibility(8);
            SelectContactUI.C(SelectContactUI.this).setVisibility(8);
            SelectContactUI.D(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.Brand_100));
            SelectContactUI.D(SelectContactUI.this).setText(SelectContactUI.this.getString(R.l.select_record_msg_tips, new Object[] { Integer.toString(SelectContactUI.y(SelectContactUI.this)) }));
            SelectContactUI.E(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_selector));
            AppMethodBeat.o(252755);
            return;
          }
          if ((SelectContactUI.t(SelectContactUI.this)) || (SelectContactUI.u(SelectContactUI.this)))
          {
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setVisibility(8);
            SelectContactUI.B(SelectContactUI.this).setVisibility(0);
            SelectContactUI.C(SelectContactUI.this).setVisibility(8);
            SelectContactUI.D(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.Brand_100));
            SelectContactUI.D(SelectContactUI.this).setText(SelectContactUI.this.getString(R.l.select_record_msg_tips, new Object[] { Integer.toString(SelectContactUI.y(SelectContactUI.this)) }));
            SelectContactUI.E(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_selector));
            AppMethodBeat.o(252755);
            return;
          }
          SelectContactUI.z(SelectContactUI.this).setVisibility(0);
          SelectContactUI.A(SelectContactUI.this).setVisibility(8);
          SelectContactUI.B(SelectContactUI.this).setVisibility(8);
          SelectContactUI.C(SelectContactUI.this).setVisibility(8);
          SelectContactUI.D(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(R.e.Brand_100));
          SelectContactUI.D(SelectContactUI.this).setText(SelectContactUI.this.getString(R.l.select_record_msg_tips, new Object[] { Integer.toString(SelectContactUI.y(SelectContactUI.this)) }));
          SelectContactUI.E(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(R.g.select_contact_record_msg_selector));
        }
        AppMethodBeat.o(252755);
      }
    });
    AppMethodBeat.o(252911);
  }
  
  private void jzk()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = MD(true);
    localArrayList.remove(z.bAM());
    if (localArrayList.size() > 0)
    {
      this.lzP = com.tencent.mm.ui.base.k.a(getContext(), getString(R.l.gNp), false, null);
      bh.baH().postToWorker(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void jzl()
  {
    AppMethodBeat.i(38010);
    Object localObject = MD(false);
    ((ArrayList)localObject).remove(z.bAM());
    final String str = Util.listToString((List)localObject, ",");
    if (!Util.isNullOrNil((List)localObject))
    {
      com.tencent.mm.ui.base.k.a(getContext(), true, getString(R.l.label_selected_contact_save_label), "", getString(R.l.label_selected_contact_save_btn), getString(R.l.label_selected_contact_cancel_btn), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253060);
          Log.i("MicroMsg.SelectContactUI", "return the result,and create new label");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(253060);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(253061);
          Log.i("MicroMsg.SelectContactUI", "return the result");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(253061);
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
    setResult(-1, (Intent)localObject);
    finish();
    AppMethodBeat.o(38010);
  }
  
  private void jzm()
  {
    AppMethodBeat.i(252933);
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXml");
    jzn();
    jzo();
    AppMethodBeat.o(252933);
  }
  
  private void jzn()
  {
    AppMethodBeat.i(252936);
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXmlImp");
    bh.bCz();
    Object localObject = com.tencent.mm.model.c.bzD().sl(((Long)this.afhS.first).longValue());
    if (localObject == null)
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlImp msgInfo is null");
      AppMethodBeat.o(252936);
      return;
    }
    if (((fi)localObject).field_content == null)
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlImp msgInfo.getContent() is null");
      AppMethodBeat.o(252936);
      return;
    }
    localObject = bBZ(((fi)localObject).field_content);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlImp filePath is null");
      AppMethodBeat.o(252936);
      return;
    }
    com.tencent.mm.g.g localg = ep((String)localObject, false);
    if (!com.tencent.mm.modelcdntran.k.bHW().g(localg))
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlImp: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
      ef(0, "add to cdn failed");
    }
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXmlImp filePath：%s", new Object[] { localObject });
    AppMethodBeat.o(252936);
  }
  
  private void jzo()
  {
    AppMethodBeat.i(252938);
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXmlNewImp");
    Object localObject = com.tencent.mm.plugin.selectrecord.b.b.Pmz;
    localObject = com.tencent.mm.plugin.selectrecord.b.b.km(this.afhW);
    if (localObject == null)
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlNewImp historyMsgList is null");
      AppMethodBeat.o(252938);
      return;
    }
    if (((ze)localObject).PmC.isEmpty())
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlNewImp historyMsgList.msgList.isEmpty");
      AppMethodBeat.o(252938);
      return;
    }
    localObject = a((ze)localObject);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlNewImp filePath is null");
      AppMethodBeat.o(252938);
      return;
    }
    com.tencent.mm.g.g localg = ep((String)localObject, true);
    if (!com.tencent.mm.modelcdntran.k.bHW().g(localg))
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXmlNewImp: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
      ef(0, "add to cdn failed");
    }
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXmlNewImp filePath：%s", new Object[] { localObject });
    AppMethodBeat.o(252938);
  }
  
  private boolean oa(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    Log.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (w.hasAttr(this.afhe, 65536))
    {
      String str = oc(paramList);
      this.afhZ = true;
      com.tencent.mm.ui.base.k.a(getContext(), str, null, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(252773);
          SelectContactUI.c(SelectContactUI.this, SelectContactUI.b(SelectContactUI.this, paramList));
          AppMethodBeat.o(252773);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(252769);
          SelectContactUI.c(SelectContactUI.this, false);
          AppMethodBeat.o(252769);
        }
      });
      bool = this.afhZ;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = ob(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean ob(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (Util.isNullOrNil(this.afhz)) {
        this.afhz = Util.listToString(paramList, ",");
      }
      for (;;)
      {
        bool = au.bwE(this.afhA);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.afhz);
        paramList.putExtra("received_card_name", this.afhA);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!Util.isNullOrNil(this.afhA)) {
          break;
        }
        this.afhA = Util.listToString(paramList, ",");
      }
      Log.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.afhz, this.afhA });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    label228:
    String str;
    au localau;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      Log.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = MD(false);
      ((ArrayList)localObject).remove(z.bAM());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        str = (String)paramList.next();
        if (Util.isNullOrNil(str)) {
          break label1160;
        }
        if ((((ArrayList)localObject).contains(str)) || (z.bAM().equals(str))) {
          break label228;
        }
        bh.bCz();
        localau = com.tencent.mm.model.c.bzA().JE(str);
        if ((localau == null) || ((int)localau.maN == 0) || (!com.tencent.mm.contact.d.rs(localau.field_type))) {
          break label1160;
        }
        bBY(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label1160:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        aNr();
        jyE().notifyDataSetChanged();
        break;
      }
      jzl();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        Log.i("MicroMsg.SelectContactUI", "Recommend Friends");
        ak.a(getContext(), this.afhA, paramList);
        break;
      }
      if (this.afia)
      {
        Log.i("MicroMsg.SelectContactUI", "From Group choose");
        this.afia = false;
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          str = (String)((Iterator)localObject).next();
          if (!Util.isNullOrNil(paramList))
          {
            com.tencent.mm.kernel.h.baF();
            localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().bxu(str);
            if (localau != null)
            {
              if ((Util.isNullOrNil(localau.field_openImAppid)) && (com.tencent.mm.contact.d.rs(localau.field_type)) && ((Util.isNullOrNil(this.JUF)) || (!str.equals(this.JUF))) && (!this.KOr.contains(str))) {
                bBY(str);
              }
            }
            else {
              Log.e("MicroMsg.SelectContactUI", "contact is null");
            }
          }
          else
          {
            Log.e("MicroMsg.SelectContactUI", "userName isNull Or Nil");
          }
        }
        aNr();
        jzi();
        jyF().notifyDataSetChanged();
        break;
      }
      if (w.hasAttr(this.afhe, 16384))
      {
        Log.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = Util.listToString(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        if ((jyE() instanceof c)) {
          ((Intent)localObject).putExtra("show_all_select_contact_count", ((c)jyE()).getContactCount());
        }
        if ((this.afhT != null) || (this.afhX != null))
        {
          paramList = new ChatroomInfoUI.LocalHistoryInfo();
          if (this.afhT != null)
          {
            paramList.fileid = this.afhT.field_fileId;
            paramList.aeskey = this.afhT.field_aesKey;
            paramList.filemd5 = this.afhT.field_filemd5;
            paramList.lAT = ((int)this.afhT.field_fileLength);
            paramList.lAU = this.afhN;
          }
          if (this.afhX != null)
          {
            paramList.lAV = this.afhX.field_fileId;
            paramList.lAW = this.afhX.field_aesKey;
            paramList.lAX = this.afhX.field_filemd5;
            paramList.lAY = ((int)this.afhX.field_fileLength);
            paramList.lAZ = this.afhN;
          }
          ((Intent)localObject).putExtra("select_record_msg_info", paramList);
          if (this.afhS == null) {
            break label940;
          }
        }
        label940:
        for (long l = ((Long)this.afhS.first).longValue();; l = 0L)
        {
          ((Intent)localObject).putExtra("select_record_fake_msg_id", l);
          ((Intent)localObject).putExtra("label_source", this.JUG);
          if (this.hPm == 1) {
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
        jzk();
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
        paramList = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramList.aYi(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aDw(3);
        break;
      }
      Log.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String oc(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(R.l.gUw, new Object[] { aa.getDisplayName((String)paramList.get(0)) });
    }
    label62:
    do
    {
      AppMethodBeat.o(38019);
      return localObject;
      localObject = localStringBuilder;
    } while (paramList.size() <= 1);
    localObject = getString(R.l.grS);
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
        localObject = getString(R.l.gUw, new Object[] { localStringBuilder.toString() });
        break;
      }
      localStringBuilder.append(aa.getDisplayName((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  public final void a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(253647);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(253647);
      return;
    }
    paramAdapterView = jyE().aDt(i);
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(253647);
      return;
    }
    if ((paramAdapterView instanceof com.tencent.mm.ui.contact.a.n))
    {
      if (w.hasAttr(this.afhe, 16384))
      {
        Log.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
        paramAdapterView = new Intent();
        paramAdapterView.putExtra("Select_Contact", "");
        paramAdapterView.putExtra("Select_Conv_User", "");
        paramAdapterView.putExtra("Select_Contact", "");
        setResult(-1, paramAdapterView);
        finish();
      }
      AppMethodBeat.o(253647);
      return;
    }
    if (paramAdapterView.contact == null)
    {
      AppMethodBeat.o(253647);
      return;
    }
    if (paramAdapterView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(253647);
      return;
    }
    paramAdapterView = paramAdapterView.contact.field_username;
    Log.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { paramAdapterView });
    if (w.hasAttr(this.afhe, 64))
    {
      if ((au.bwE(paramAdapterView)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        paramView = new Intent(this, ChattingUI.class);
        paramView.addFlags(67108864);
        paramView.putExtra("Chat_User", paramAdapterView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
        com.tencent.mm.hellhoundlib.a.a.b(this, paramView.aYi(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        aDw(3);
      }
      if ((w.hasAttr(this.afhe, 131072)) && (this.KOr.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.afhv.contains(paramAdapterView))
        {
          iKA();
          if (!this.KOr.contains(paramAdapterView)) {
            break label478;
          }
          this.KOt.bqG(paramAdapterView);
          this.KOr.remove(paramAdapterView);
        }
      }
      for (;;)
      {
        aNr();
        jzi();
        if (jyF() == null) {
          break;
        }
        jyF().notifyDataSetChanged();
        AppMethodBeat.o(253647);
        return;
        label478:
        paramView = getIntent().getStringExtra("too_many_member_tip_string");
        paramAdapterView = paramView;
        if (Util.isNullOrNil(paramView)) {
          paramAdapterView = getString(R.l.gUz, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.k.d(getContext(), paramAdapterView, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        bBY(paramAdapterView);
      }
    }
    oa(Util.stringsToList(new String[] { paramAdapterView }));
    AppMethodBeat.o(253647);
  }
  
  protected final void a(ListView paramListView, int paramInt)
  {
    AppMethodBeat.i(38002);
    super.a(paramListView, paramInt);
    Object localObject;
    final int k;
    int j;
    final int i;
    label333:
    int m;
    if (w.hasAttr(this.afhe, 256))
    {
      if (this.afhp == null)
      {
        SelectContactUI.23 local23 = new SelectContactUI.23(this);
        if (this.afbe == 14)
        {
          localObject = getString(R.l.gqO);
          this.afhp = a(paramListView, local23, (String)localObject);
        }
      }
      else
      {
        this.afhp.setVisibility(paramInt);
      }
    }
    else
    {
      if (w.hasAttr(this.afhe, 512))
      {
        if (this.afhq == null) {
          this.afhq = a(paramListView, new SelectContactUI.24(this), getString(R.l.gHV));
        }
        this.afhq.setVisibility(paramInt);
      }
      if (w.hasAttr(this.afhe, 1024))
      {
        if (this.afhr == null) {
          this.afhr = a(paramListView, new SelectContactUI.25(this), getString(R.l.gqC));
        }
        this.afhr.setVisibility(paramInt);
      }
      if (w.hasAttr(this.afhe, 2048))
      {
        if (this.afht == null) {
          this.afht = a(paramListView, new SelectContactUI.26(this), getString(R.l.address_official_accounts_title));
        }
        this.afht.setVisibility(paramInt);
        this.afht.setTextSize(16.0F * com.tencent.mm.cd.a.getScaleSize(this.afht.getContext()));
      }
      if (w.hasAttr(this.afhe, 524288)) {
        if (this.afhs == null)
        {
          localObject = "";
          k = getIntent().getIntExtra("topstory_import_type", 0);
          j = R.l.gqG;
          i = R.l.gqH;
          if (k != 1) {
            break label640;
          }
          localObject = com.tencent.mm.plugin.sns.c.q.Qkl.ux(5L);
          if (!Util.isNullOrNil((List)localObject)) {
            break label629;
          }
          i = 0;
          localObject = Util.listToString((List)localObject, ",");
          j = R.l.gqG;
          m = R.l.gqH;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.afhs = a(paramListView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252753);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          com.tencent.mm.ui.base.k.b(SelectContactUI.this, SelectContactUI.this.getString(i, new Object[] { Integer.valueOf(k) }), "", SelectContactUI.this.getString(R.l.gqD), SelectContactUI.this.getString(R.l.app_cancel), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(253002);
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.2.this.afim);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(253002);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(252753);
        }
      }, getString(j));
      this.afhs.setTag(Integer.valueOf(k));
      localObject = this.afhs.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.afhs.setVisibility(8);
      }
      for (;;)
      {
        if (w.hasAttr(this.afhe, 16777216))
        {
          if (this.afhu == null)
          {
            bh.bCz();
            localObject = com.tencent.mm.model.c.bzA().iZS();
            Log.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.afhu = a(paramListView, new SelectContactUI.4(this), "");
              paramListView = ((e)com.tencent.mm.kernel.h.ax(e.class)).a("3552365301", "openim_acct_type_title", e.a.prb);
              this.afhu.setVisibility(paramInt);
              this.afhu.setText(paramListView);
            }
          }
          if (this.afhu != null) {
            this.afhu.setVisibility(paramInt);
          }
        }
        if ((!w.hasAttr(this.afhe, 16777216)) || (this.afhu == null)) {
          break label712;
        }
        this.afhu.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
        AppMethodBeat.o(38002);
        return;
        localObject = getString(R.l.gqB);
        break;
        label629:
        i = ((List)localObject).size();
        break label333;
        label640:
        if (k != 2) {
          break label860;
        }
        localObject = com.tencent.mm.pluginsdk.platformtools.a.iIX();
        if (Util.isNullOrNil((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = Util.listToString((List)localObject, ",");
          j = R.l.gqE;
          m = R.l.gqF;
          k = i;
          i = m;
          break;
        }
        this.afhs.setVisibility(paramInt);
      }
      label712:
      if (w.hasAttr(this.afhe, 2048))
      {
        if (this.afht != null)
        {
          this.afht.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          AppMethodBeat.o(38002);
        }
      }
      else if (w.hasAttr(this.afhe, 1024))
      {
        if (this.afhr != null)
        {
          this.afhr.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          AppMethodBeat.o(38002);
        }
      }
      else if (w.hasAttr(this.afhe, 512))
      {
        if (this.afhq != null)
        {
          this.afhq.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
          AppMethodBeat.o(38002);
        }
      }
      else if ((w.hasAttr(this.afhe, 256)) && (this.afhp != null)) {
        this.afhp.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
      }
      AppMethodBeat.o(38002);
      return;
      label860:
      k = 0;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38014);
    boolean bool;
    if ((parama.afey) && (parama.contact != null))
    {
      bool = this.KOr.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.afez) && (parama.contact != null))
    {
      bool = this.KOr.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof com.tencent.mm.ui.contact.a.n))
    {
      bool = this.KOr.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final void aLa(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.h.OAn.b(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(MD(w.hasAttr(this.afhe, 8192)));
    paramString.addAll(this.afhv);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("block_contact", getIntent().getStringExtra("block_contact"));
    if (w.hasAttr(this.afhe, 64))
    {
      localIntent.putExtra("list_attr", w.R(new int[] { 16384, 64, 131072 }));
      if (this.afbe == 14) {
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
  
  protected final void aNi()
  {
    AppMethodBeat.i(37997);
    super.aNi();
    this.afhe = getIntent().getIntExtra("list_attr", w.affn);
    this.title = getIntent().getStringExtra("titile");
    this.uCW = getIntent().getStringExtra("sub_title");
    this.afbe = getIntent().getIntExtra("list_type", -1);
    this.afhf = getIntent().getBooleanExtra("show_too_many_member", true);
    this.JUG = getIntent().getStringExtra("label_source");
    if ((w.hasAttr(this.afhe, 256)) && (ab.bBP().size() == 0)) {
      w.ow(this.afhe, 256);
    }
    this.afhx = getIntent().getBooleanExtra("Add_SendCard", false);
    this.afhy = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.afhx) || (this.afhy))
    {
      this.afhz = Util.nullAs(getIntent().getStringExtra("be_send_card_name"), "");
      this.afhA = Util.nullAs(getIntent().getStringExtra("received_card_name"), "");
    }
    this.afhB = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.afhL = getIntent().getBooleanExtra("is_select_record_msg_mode", false);
    this.afhC = getIntent().getIntExtra("menu_mode", 1);
    this.lyn = getIntent().getStringExtra("chatroomName");
    Log.i("MicroMsg.SelectContactUI", "mRoomId：%s", new Object[] { Util.nullAs(this.lyn, "") });
    this.lMF = new ArrayList();
    this.KOr = new LinkedList();
    this.afhv = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.afhv.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.KOr.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(w.jyV());
    ((HashSet)localObject).addAll(w.jyW());
    if (!w.hasAttr(this.afhe, 268435456)) {
      ((HashSet)localObject).add(z.bAM());
    }
    if (this.afhx) {
      ((HashSet)localObject).removeAll(w.jyV());
    }
    this.lMF.addAll(au.iZM());
    this.lMF.addAll((Collection)localObject);
    jzi();
    this.afid = ("SelectContactUI-" + this.afbe);
    AppMethodBeat.o(37997);
  }
  
  public final void ad(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.KOr.remove(paramString);
      if (!(jyE() instanceof x)) {
        break label65;
      }
      paramString = ((x)jyE()).jyC();
      this.KOt.getInputText().setText(paramString);
    }
    for (;;)
    {
      aNr();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((jyE() instanceof c)) {
        jyF().aNm();
      } else {
        jyE().notifyDataSetChanged();
      }
    }
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38015);
    if ((parama.afey) && (parama.contact != null))
    {
      if (w.hasAttr(this.afhe, 536870912))
      {
        bool = parama.contact.aSN();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.afhv.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  protected final r bVA()
  {
    boolean bool2 = true;
    label396:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(38000);
        Object localObject1 = new c.a();
        ((c.a)localObject1).afbY = w.hasAttr(this.afhe, 16);
        ((c.a)localObject1).afbX = w.hasAttr(this.afhe, 32);
        ((c.a)localObject1).afcb = getIntent().getBooleanExtra("create_group_recommend", false);
        if (!w.hasAttr(this.afhe, 4))
        {
          bool1 = true;
          ((c.a)localObject1).afbZ = bool1;
          if (!w.hasAttr(this.afhe, 1))
          {
            bool1 = true;
            ((c.a)localObject1).afca = bool1;
            ((c.a)localObject1).afcc = w.hasAttr(this.afhe, 128);
            ((c.a)localObject1).afcd = w.hasAttr(this.afhe, 1048576);
            ((c.a)localObject1).afch = w.hasAttr(this.afhe, 256);
            if (((c.a)localObject1).afch) {
              ((c.a)localObject1).afci = getIntent().getStringExtra("custom_contact");
            }
            if (((c.a)localObject1).afcc)
            {
              this.afib = true;
              ((c.a)localObject1).afcf = getIntent().getStringExtra("wechat_sport_contact");
              ((c.a)localObject1).afcg = getIntent().getStringExtra("wechat_sport_recent_like");
              this.afic = ((c.a)localObject1).afcf;
            }
            if (!w.jyX()) {
              continue;
            }
            ((c.a)localObject1).afau = "@all.contact.without.chatroom.without.openim";
            if ((this.scene == 6) || (this.scene == 5)) {
              ((c.a)localObject1).afau = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
              ((c.a)localObject1).afau = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            List localList1 = this.afhv;
            List localList2 = this.KOr;
            List localList3 = this.lMF;
            boolean bool3 = w.hasAttr(this.afhe, 1);
            boolean bool4 = w.hasAttr(this.afhe, 64);
            if (this.afbe != 15) {
              break label396;
            }
            bool1 = bool2;
            localObject1 = new c(this, localList1, localList2, localList3, bool3, bool4, (c.a)localObject1, bool1, jzh());
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
        ((c.a)localObject1).afau = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        continue;
        bool1 = false;
      }
      finally {}
    }
  }
  
  protected final p bVB()
  {
    AppMethodBeat.i(38001);
    if (this.afib)
    {
      localObject = new v(this, this.lMF, w.hasAttr(this.afhe, 64), this.afic);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new x(this, this.afhv, this.KOr, this.lMF, w.hasAttr(this.afhe, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new u(this, this.lMF, w.hasAttr(this.afhe, 64), this.scene, jzh());
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  protected final boolean bVx()
  {
    return false;
  }
  
  protected final boolean bVy()
  {
    return true;
  }
  
  protected final String bVz()
  {
    return this.title;
  }
  
  public final int[] efu()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!w.hasAttr(this.afhe, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!w.hasAttr(this.afhe, 4)) {
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
  
  protected final boolean gaC()
  {
    return !this.afib;
  }
  
  public int getCustomBounceId()
  {
    return R.h.select_contact_lv;
  }
  
  public void initView()
  {
    AppMethodBeat.i(253631);
    super.initView();
    this.afhD = ((RelativeLayout)findViewById(R.h.select_record_msg_ll));
    this.afhE = ((LinearLayout)findViewById(R.h.select_record_msg_bt));
    this.afhK = ((Button)findViewById(R.h.finish_button));
    this.afhF = ((ImageView)findViewById(R.h.select_record_msg_success_iv));
    this.afhG = ((ImageView)findViewById(R.h.select_record_msg_warn_iv));
    this.afhH = ((ImageView)findViewById(R.h.select_record_msg_right_arrow_iv));
    this.afhI = ((ProgressBar)findViewById(R.h.record_msg_upload_progress));
    this.afhJ = ((TextView)findViewById(R.h.select_record_msg_tips));
    this.afhE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37978);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.SelectContactUI", "click selectRecordMsgBt %s", new Object[] { Util.nullAs(SelectContactUI.d(SelectContactUI.this), "") });
        SelectContactUI.this.hideVKB();
        paramAnonymousView = new Intent().putExtra("Chat_User", SelectContactUI.d(SelectContactUI.this)).putExtra("finish_direct", true).putExtra("key_record_msg_select", true).putExtra("key_record_msg_select_introduce", SelectContactUI.g(SelectContactUI.this)).putExtra("key_record_select_min_msg_id", SelectContactUI.f(SelectContactUI.this)).putExtra("key_record_select_msg_num", SelectContactUI.e(SelectContactUI.this));
        if (SelectContactUI.h(SelectContactUI.this) != null) {
          paramAnonymousView.putStringArrayListExtra("key_record_select_msg_black_list", SelectContactUI.h(SelectContactUI.this));
        }
        com.tencent.mm.br.c.d(SelectContactUI.this, ".ui.chatting.ChattingUI", paramAnonymousView, 6);
        SelectContactUI.i(SelectContactUI.this);
        com.tencent.mm.plugin.selectrecord.b.a.gUF().Pmj.jdj = 1;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37978);
      }
    });
    this.afhG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37979);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.SelectContactUI", "click warn to retry");
        SelectContactUI.a(SelectContactUI.this, null);
        SelectContactUI.b(SelectContactUI.this, null);
        SelectContactUI.j(SelectContactUI.this);
        SelectContactUI.k(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, true);
        SelectContactUI.b(SelectContactUI.this, true);
        SelectContactUI.l(SelectContactUI.this);
        SelectContactUI.a(SelectContactUI.this, new ArrayList(com.tencent.mm.ui.chatting.n.jph()));
        SelectContactUI.a(SelectContactUI.this, com.tencent.mm.ui.chatting.n.m(SelectContactUI.this, "msginfo@fakeuser", true));
        if (!((Boolean)SelectContactUI.a(SelectContactUI.this).second).booleanValue()) {
          SelectContactUI.m(SelectContactUI.this).alive();
        }
        for (;;)
        {
          paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
          paramAnonymousView.Pmt += 1;
          Log.i("MicroMsg.SelectContactUI", "click warn to retry, msgId:%s direct:%s", new Object[] { SelectContactUI.a(SelectContactUI.this).first, SelectContactUI.a(SelectContactUI.this).second });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37979);
          return;
          SelectContactUI.b(SelectContactUI.this);
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.gUG();
    Object localObject = com.tencent.mm.plugin.selectrecord.b.a.gUF();
    String str = this.lyn;
    nd localnd = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).Pmj;
    localnd.jda = localnd.F("RoomId", str, true);
    localObject = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).Pmj;
    int i;
    if (ab.II(str))
    {
      i = 1;
      ((nd)localObject).jdB = i;
      if ((!au.bwG(this.lyn)) || (ab.II(this.lyn)) || (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().aMg(this.lyn) <= 0L)) {
        break label427;
      }
      this.afhE.setVisibility(0);
      com.tencent.mm.plugin.selectrecord.b.a.gUF().CC(true);
    }
    for (;;)
    {
      if (this.afhC == 2)
      {
        this.lKz = new com.tencent.mm.ui.tools.i(this);
        this.lKz.afIL = this;
      }
      if (jzh())
      {
        setTheme(R.m.AppTheme_DarkMode);
        setActionbarColor(getResources().getColor(R.e.Dark_0));
        setNavigationbarColor(getResources().getColor(R.e.Dark_0));
        jyI();
        jyJ();
        this.Nnk.setBackgroundResource(R.e.Dark_2);
        if (getBounceView() != null) {
          getBounceView().setBgColor(getResources().getColor(R.e.Dark_2));
        }
        this.afeA.setTextColor(getResources().getColor(R.e.BW_100_Alpha_0_2));
        this.afeA.setBackgroundColor(getResources().getColor(R.e.finder_live_logo_color));
      }
      AppMethodBeat.o(253631);
      return;
      i = 0;
      break;
      label427:
      this.afhE.setVisibility(8);
      com.tencent.mm.plugin.selectrecord.b.a.gUF().CC(false);
    }
  }
  
  public final q jyE()
  {
    AppMethodBeat.i(253635);
    q localq = super.jyE();
    Object localObject = localq;
    if (localq == null)
    {
      localObject = bVA();
      a((r)localObject);
      Log.i("MicroMsg.SelectContactUI", "getAdapter is null");
    }
    AppMethodBeat.o(253635);
    return localObject;
  }
  
  public final r jyF()
  {
    AppMethodBeat.i(253641);
    r localr2 = super.jyF();
    r localr1 = localr2;
    if (localr2 == null)
    {
      localr1 = bVA();
      getContentLV().setAdapter(localr1);
      Log.i("MicroMsg.SelectContactUI", "getInitAdapter is null");
    }
    AppMethodBeat.o(253641);
    return localr1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38021);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.hPm = paramInt1;
    Log.i("MicroMsg.SelectContactUI", "requestCode=%d | resultCode=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38021);
      return;
    }
    switch (paramInt1)
    {
    }
    label578:
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
          oa(Util.stringsToList(new String[] { paramIntent }));
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          localObject1 = this.KOr.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            this.KOt.bqH(str1);
          }
          this.KOr.clear();
          if (!Util.isNullOrNil(paramIntent)) {
            this.KOr.addAll(Util.stringsToList(paramIntent.split(",")));
          }
          paramIntent = this.KOr.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.KOt.bqI((String)localObject1);
          }
          aNr();
          AppMethodBeat.o(38021);
          return;
          localObject1 = paramIntent.getStringExtra("Select_Contact");
          this.afia = paramIntent.getBooleanExtra("Select_From_Group", false);
        } while (Util.isNullOrNil((String)localObject1));
        oa(Util.stringsToList(((String)localObject1).split(",")));
        AppMethodBeat.o(38021);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil(paramIntent)) {
        oa(Util.stringsToList(new String[] { paramIntent }));
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
      if (w.hasAttr(this.afhe, 64))
      {
        paramIntent = paramIntent.split(",");
        paramInt2 = paramIntent.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject1 = paramIntent[paramInt1];
          if (this.KOr.add(localObject1)) {
            this.KOt.bqG((String)localObject1);
          }
          paramInt1 += 1;
        }
        aNr();
        jyE().notifyDataSetChanged();
        AppMethodBeat.o(38021);
        return;
      }
      oa(Util.stringsToList(new String[] { paramIntent }));
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
            break label657;
          }
          localObject1 = null;
        }
        Object localObject2;
        for (;;)
        {
          if (paramIntent != null)
          {
            if (this.KOt != null)
            {
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  String str2 = (String)((Iterator)localObject2).next();
                  if (!this.KOr.contains(str2))
                  {
                    this.KOt.bqG(str2);
                    continue;
                    paramIntent = Util.stringToList(str1, ",");
                    break;
                    localObject1 = Util.stringToList((String)localObject1, ",");
                    break label578;
                  }
                }
              }
            }
            this.KOr.addAll(paramIntent);
          }
        }
        if (localObject1 != null)
        {
          if (this.KOt != null)
          {
            paramIntent = ((List)localObject1).iterator();
            while (paramIntent.hasNext())
            {
              localObject2 = (String)paramIntent.next();
              this.KOt.bqG((String)localObject2);
            }
          }
          this.KOr.removeAll((Collection)localObject1);
        }
        jyE().notifyDataSetChanged();
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
          oa(Util.stringsToList(new String[] { str1 }));
        }
      }
      aNr();
      AppMethodBeat.o(38021);
      return;
    } while (paramIntent == null);
    label657:
    this.afhM = paramIntent.getIntExtra("select_record_msg_num", 0);
    this.afhN = this.afhM;
    this.afhP = paramIntent.getStringArrayListExtra("key_select_record_msg_black_list");
    this.afhT = null;
    this.afhX = null;
    this.afhR = false;
    this.afhV = false;
    if (this.afhM == 0)
    {
      this.afhQ = false;
      this.afhU = false;
      jzj();
    }
    for (;;)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.a.gUF();
      long l = this.afhN;
      paramIntent.Pmj.iWe = l;
      Log.i("MicroMsg.SelectContactUI", "GET_SELECT_RECORD_MSG selectMsgNum:%s actualSelectMsgNum:%s msgId:%s direct:%s", new Object[] { Integer.valueOf(this.afhM), Integer.valueOf(this.afhN), this.afhS.first, this.afhS.second });
      break;
      this.afhQ = true;
      this.afhU = true;
      this.aevR = paramIntent.getLongExtra("select_record_min_msg_id", -1L);
      if ((com.tencent.mm.ui.chatting.n.jpg() > 0) && (com.tencent.mm.ui.chatting.n.jpg() < this.afhM)) {
        this.afhN = com.tencent.mm.ui.chatting.n.jpg();
      }
      jzj();
      com.tencent.mm.plugin.selectrecord.b.a.gUF().Pmr = cn.bDu();
      this.afhW = new ArrayList(com.tencent.mm.ui.chatting.n.jph());
      this.afhS = com.tencent.mm.ui.chatting.n.b(this, "msginfo@fakeuser", true, this.lyn);
      if (!((Boolean)this.afhS.second).booleanValue()) {
        this.afif.alive();
      } else {
        jzm();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    this.afie = cn.bDw();
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectContactUI", "create!");
    bh.aZW().a(30, this);
    bh.aZW().a(138, this);
    if (!Util.isNullOrNil(this.uCW)) {
      setMMSubTitle(this.uCW);
    }
    this.JUF = z.bAM();
    label135:
    int i;
    if (w.hasAttr(this.afhe, 64))
    {
      if (this.afhC != 1) {
        break label302;
      }
      MB(false);
      String str = getString(R.l.app_ok);
      MenuItem.OnMenuItemClickListener local7 = new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(252763);
          boolean bool = SelectContactUI.s(SelectContactUI.this);
          AppMethodBeat.o(252763);
          return bool;
        }
      };
      if (jzh())
      {
        paramBundle = y.b.adEZ;
        addTextOptionMenu(1, str, local7, null, paramBundle);
      }
    }
    else
    {
      aNr();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(253050);
          SelectContactUI.this.hideVKB();
          SelectContactUI.this.finish();
          if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            MMHandlerThread.postToMainThreadDelayed(SelectContactUI.c(SelectContactUI.this), 80L);
          }
          AppMethodBeat.o(253050);
          return true;
        }
      });
      if ((this.afbe != 15) && (this.KOt != null)) {
        this.KOt.mv(this.KOr);
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
      y.afgd = i;
      Log.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
      if (getBounceView() != null) {
        getBounceView().setBgColor(getResources().getColor(R.e.BG_2));
      }
      AppMethodBeat.o(37995);
      return;
      paramBundle = y.b.adEJ;
      break;
      label302:
      MB(true);
      this.afhK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(252762);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if ((SelectContactUI.t(SelectContactUI.this)) || (SelectContactUI.u(SelectContactUI.this)))
          {
            com.tencent.mm.ui.base.k.a(SelectContactUI.this, SelectContactUI.this.getString(R.l.record_msg_upload_tips), "", SelectContactUI.this.getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(252969);
                Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                AppMethodBeat.o(252969);
              }
            });
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
            paramAnonymousView.Pmv += 1;
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252762);
            return;
            if ((SelectContactUI.v(SelectContactUI.this)) || (SelectContactUI.w(SelectContactUI.this)))
            {
              com.tencent.mm.ui.base.k.a(SelectContactUI.this, SelectContactUI.this.getString(R.l.record_msg_upload_net_fail_tips), "", SelectContactUI.this.getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(252966);
                  Log.i("MicroMsg.SelectContactUI", "initMenu(upload fail) click i know");
                  AppMethodBeat.o(252966);
                }
              });
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.gUF();
              paramAnonymousView.Pmw += 1;
              com.tencent.mm.plugin.selectrecord.b.a.gUF().gUJ();
            }
            else
            {
              SelectContactUI.s(SelectContactUI.this);
            }
          }
        }
      });
      break label135;
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
    this.afif.dead();
    bh.aZW().b(30, this);
    bh.aZW().b(138, this);
    aDw(1);
    y.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(253680);
    Log.i("MicroMsg.SelectContactUI", "height:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((this.JWJ != null) && (this.JWJ.isRunning())) {
      this.JWJ.cancel();
    }
    if (paramInt > 0) {
      if (this.afhD.getTranslationY() != 0.0F) {
        this.afhD.setTranslationY(0.0F);
      }
    }
    for (this.JWJ = ObjectAnimator.ofFloat(this.afhD, "translationY", new float[] { 0.0F, -paramInt });; this.JWJ = ObjectAnimator.ofFloat(this.afhD, "translationY", new float[] { this.afhD.getTranslationY(), 0.0F }))
    {
      this.JWJ.setDuration(200L);
      this.JWJ.setInterpolator(new androidx.g.a.a.b());
      this.JWJ.addUpdateListener(new SelectContactUI.3(this));
      this.JWJ.start();
      AppMethodBeat.o(253680);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(253612);
    super.onPause();
    if (this.lKz != null) {
      this.lKz.close();
    }
    AppMethodBeat.o(253612);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(253603);
    super.onResume();
    if (this.lKz != null) {
      this.lKz.start();
    }
    if (!Util.isNullOrNil(this.qYC))
    {
      kx localkx = new kx();
      Object localObject = localkx.tS(this.afid).tT(this.qYC);
      ((kx)localObject).iYo = 0L;
      ((kx)localObject).ijA = (cn.bDw() - this.afie);
      ((kx)localObject).bMH();
      localObject = com.tencent.mm.util.c.agsX;
      com.tencent.mm.util.c.a(localkx);
      this.qYC = "";
    }
    AppMethodBeat.o(253603);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(38013);
    if (this.lzP != null)
    {
      this.lzP.dismiss();
      this.lzP = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if (ae.a.a(this, paramInt1, paramInt2, paramString, 4))
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
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38013);
      return;
      jyE().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(253607);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.lKz != null) {
      this.lKz.start();
    }
    AppMethodBeat.o(253607);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(253586);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.ui.mvvm.b.f.class);
    AppMethodBeat.o(253586);
  }
  
  static final class a
  {
    private AlphaAnimation afiu;
    private AlphaAnimation afiv;
    boolean afiw = false;
    TextView ttU;
    
    final void cc(Activity paramActivity)
    {
      AppMethodBeat.i(37989);
      if (this.ttU == null) {
        this.ttU = ((TextView)paramActivity.findViewById(R.h.select_contact_float_tips));
      }
      if (this.ttU.getVisibility() == 8)
      {
        AppMethodBeat.o(37989);
        return;
      }
      if (this.afiv == null)
      {
        this.afiv = new AlphaAnimation(1.0F, 0.0F);
        this.afiv.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(37987);
            SelectContactUI.a.this.ttU.setVisibility(8);
            AppMethodBeat.o(37987);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      this.afiv.setDuration(300L);
      if (this.afiu != null) {
        this.afiu.cancel();
      }
      this.ttU.startAnimation(this.afiv);
      AppMethodBeat.o(37989);
    }
    
    public final void f(final Activity paramActivity, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(37988);
      if ((paramInt2 > 0) && (paramInt1 == paramInt2 + 1) && (!this.afiw))
      {
        if (this.ttU == null) {
          this.ttU = ((TextView)paramActivity.findViewById(R.h.select_contact_float_tips));
        }
        if (this.ttU.getVisibility() != 0)
        {
          this.ttU.setText(R.l.gTm);
          this.ttU.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(37986);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              SelectContactUI.a.this.afiw = true;
              SelectContactUI.a.this.cc(paramActivity);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$AddTooManyMembersTips$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37986);
            }
          });
          if (this.afiu == null) {
            this.afiu = new AlphaAnimation(0.0F, 1.0F);
          }
          this.afiu.setDuration(300L);
          if (this.afiv != null) {
            this.afiv.cancel();
          }
          this.ttU.setVisibility(0);
          this.ttU.startAnimation(this.afiu);
        }
        AppMethodBeat.o(37988);
        return;
      }
      if (paramInt1 < paramInt2)
      {
        cc(paramActivity);
        this.afiw = false;
      }
      AppMethodBeat.o(37988);
    }
  }
  
  static final class c
    implements Runnable
  {
    private ArrayList<String> afiy;
    private WeakReference<SelectContactUI> eIW;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.eIW = new WeakReference(paramSelectContactUI);
      this.afiy = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.eIW.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = z.bAM();
      Iterator localIterator = this.afiy.iterator();
      int i = 0;
      Object localObject1 = null;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Log.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (au.bwE((String)localObject2))
        {
          j = 1;
          label94:
          i += j;
          t.e locale = t.a(t.d.oNd).wg(4);
          locale.hQQ = str;
          locale.toUser = ((String)localObject2);
          locale.oIx = localSelectContactUI.getIntent().getStringExtra("shareImagePath");
          locale.oGu = 0;
          locale.oNk = null;
          locale.hOX = 0;
          locale.oGC = "";
          locale.thumbPath = "";
          locale.oNn = true;
          locale.oNm = R.g.chat_img_template;
          locale.thumbPath = ((String)localObject1);
          locale.oNj = 11;
          localObject2 = locale.bKW();
          ((t.b)localObject2).aXz();
          localObject2 = (o)((t.b)localObject2).oNb;
          if (((o)localObject2).bJM() == null) {
            break label333;
          }
          localObject1 = ((o)localObject2).bJM().field_imgPath;
        }
      }
      label333:
      for (;;)
      {
        break;
        j = 0;
        break label94;
        SelectContactUI.F(localSelectContactUI).dismiss();
        localObject1 = new Intent();
        ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.afiy);
        localSelectContactUI.setResult(-1, (Intent)localObject1);
        com.tencent.mm.plugin.report.service.h.OAn.b(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.afiy.size() - i), Integer.valueOf(i) });
        localSelectContactUI.finish();
        AppMethodBeat.o(37993);
        return;
      }
    }
  }
  
  final class d
  {
    public String filePath;
    public boolean isNew = false;
    public String mediaId;
    
    public d(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.mediaId = paramString1;
      this.filePath = paramString2;
      this.isNew = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */