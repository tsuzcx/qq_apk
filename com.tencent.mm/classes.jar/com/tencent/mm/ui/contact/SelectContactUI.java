package com.tencent.mm.ui.contact;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.n;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI.LocalHistoryInfo;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.g.b.a.id;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o.b;
import com.tencent.mm.modelmulti.o.d;
import com.tencent.mm.modelmulti.o.e;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.PluginMessenger;
import com.tencent.mm.pluginsdk.ui.MultiSelectContactView;
import com.tencent.mm.pluginsdk.ui.applet.aa.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.k;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.z.a;
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
  implements com.tencent.mm.ak.i, com.tencent.mm.ui.tools.g
{
  private boolean AxH;
  private int PSP;
  private TextView PYA;
  private TextView PYB;
  private TextView PYC;
  private TextView PYD;
  private List<String> PYE;
  private Map<String, Integer> PYF;
  private boolean PYG;
  private boolean PYH;
  private String PYI;
  private String PYJ;
  private boolean PYK;
  private int PYL;
  private RelativeLayout PYM;
  private LinearLayout PYN;
  private ImageView PYO;
  private ImageView PYP;
  private ImageView PYQ;
  private ProgressBar PYR;
  private TextView PYS;
  private Button PYT;
  private boolean PYU;
  private int PYV;
  private int PYW;
  private boolean PYX;
  private boolean PYY;
  private boolean PYZ;
  private int PYo;
  private boolean PYp;
  private SelectContactUI.a PYq;
  private TextView PYy;
  private TextView PYz;
  private Pair<Long, Boolean> PZa;
  private com.tencent.mm.i.d PZb;
  private ArrayList<String> PZc;
  private boolean PZd;
  private boolean PZe;
  private boolean PZf;
  private String PZg;
  private IListener<rb> PZh;
  private SelectContactUI.b PZi;
  private boolean PZj;
  private HashMap<String, String> PZk;
  private long PsQ;
  private ProgressDialog gtM;
  private String gwx;
  private com.tencent.mm.ui.tools.h gyh;
  private List<String> gzY;
  private String oqZ;
  private int requestCode;
  private g.a sPz;
  private String title;
  private String yCr;
  private int ygg;
  private List<String> zow;
  
  public SelectContactUI()
  {
    AppMethodBeat.i(37994);
    this.PYF = new HashMap();
    this.PYV = 0;
    this.PYW = 0;
    this.PYX = false;
    this.PYY = false;
    this.PYZ = true;
    this.PZa = new Pair(Long.valueOf(-1L), Boolean.FALSE);
    this.PsQ = -1L;
    this.PZc = null;
    this.PYp = true;
    this.PZf = false;
    this.PZh = new IListener() {};
    this.PZi = new SelectContactUI.b(this, (byte)0);
    this.AxH = false;
    this.PZj = false;
    this.PZk = new HashMap();
    this.sPz = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234036);
        if (paramAnonymousInt == -21005)
        {
          Log.i("MicroMsg.SelectContactUI", "ERR_CNDCOM_MEDIA_IS_UPLOADING cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          AppMethodBeat.o(234036);
          return 0;
        }
        if ((paramAnonymousd != null) && (paramAnonymousd.field_retCode == 0))
        {
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd);
          SelectContactUI.a(SelectContactUI.this, false);
          Log.i("MicroMsg.SelectContactUI", "sceneResult.field_retCode == 0 cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s] result:%s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(com.tencent.mm.vfs.s.deleteFile((String)SelectContactUI.E(SelectContactUI.this).get(paramAnonymousString))) });
          SelectContactUI.k(SelectContactUI.this);
          com.tencent.mm.plugin.selectrecord.b.a.eSu().IG(cl.aWy());
          AppMethodBeat.o(234036);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          Log.w("MicroMsg.SelectContactUI", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, paramAnonymousd.field_retCode, "cdn ret error");
          AppMethodBeat.o(234036);
          return 0;
        }
        if (paramAnonymousInt != 0)
        {
          Log.w("MicroMsg.SelectContactUI", "start error!; cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
          SelectContactUI.a(SelectContactUI.this, 0, "cdn start error");
          AppMethodBeat.o(234036);
          return 0;
        }
        Log.i("MicroMsg.SelectContactUI", "on process, cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd });
        if (paramAnonymousc != null) {
          Log.d("MicroMsg.SelectContactUI", "cdn process: %f", new Object[] { Double.valueOf(paramAnonymousc.field_finishedLength / paramAnonymousc.field_toltalLength) });
        }
        AppMethodBeat.o(234036);
        return 0;
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.PYq = new SelectContactUI.a();
    AppMethodBeat.o(37994);
  }
  
  private void Cr(boolean paramBoolean)
  {
    AppMethodBeat.i(234050);
    if (this.PYL == 1)
    {
      enableOptionMenu(1, paramBoolean);
      AppMethodBeat.o(234050);
      return;
    }
    this.PYT.setEnabled(paramBoolean);
    AppMethodBeat.o(234050);
  }
  
  private ArrayList<String> Cs(boolean paramBoolean)
  {
    AppMethodBeat.i(38007);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.zow.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (ab.IQ((String)localObject)))
      {
        localObject = com.tencent.mm.model.v.Id((String)localObject);
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
  
  private ArrayList<String> Ct(boolean paramBoolean)
  {
    AppMethodBeat.i(38008);
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.zow.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if ((!paramBoolean) && (ab.IQ((String)localObject)))
      {
        localObject = com.tencent.mm.model.v.Id((String)localObject);
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
    localHashSet.addAll(this.PYE);
    localArrayList.addAll(localHashSet);
    AppMethodBeat.o(38008);
    return localArrayList;
  }
  
  private static List<String> V(List<String> paramList)
  {
    AppMethodBeat.i(38020);
    LinkedList localLinkedList = new LinkedList();
    if (!bg.aAc())
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
      bg.aVF();
      as localas = com.tencent.mm.model.c.aSN().Kn(str);
      paramList = str;
      if (localas != null)
      {
        paramList = str;
        if ((int)localas.gMZ != 0) {
          paramList = localas.arJ();
        }
      }
      localLinkedList.add(paramList);
    }
    AppMethodBeat.o(38020);
    return localLinkedList;
  }
  
  private void Z(int paramInt, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(234058);
    Log.i("MicroMsg.SelectContactUI", "triggerErrorCallback errCode:%s errMsg:%s", new Object[] { Integer.valueOf(paramInt), Util.nullAs(paramString1, "") });
    this.PYY = true;
    this.PYX = false;
    gVh();
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234038);
        SelectContactUI localSelectContactUI = SelectContactUI.this;
        if (Util.isNullOrNil(paramString2)) {}
        for (String str = SelectContactUI.this.getString(2131764291);; str = paramString2)
        {
          com.tencent.mm.ui.base.h.a(localSelectContactUI, str, "", SelectContactUI.this.getString(2131768713), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(234037);
              Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
              AppMethodBeat.o(234037);
            }
          });
          AppMethodBeat.o(234038);
          return;
        }
      }
    });
    com.tencent.mm.plugin.selectrecord.b.a.eSu().IG(cl.aWy());
    com.tencent.mm.plugin.selectrecord.b.a.eSu().eSy();
    AppMethodBeat.o(234058);
  }
  
  private TextView a(ListView paramListView, View.OnClickListener paramOnClickListener, String paramString)
  {
    AppMethodBeat.i(38003);
    View localView = com.tencent.mm.ui.aa.jQ(this).inflate(2131494993, null);
    localView.setOnClickListener(paramOnClickListener);
    paramOnClickListener = (TextView)localView.findViewById(2131299223);
    paramOnClickListener.setText(paramString);
    paramListView.addHeaderView(localView);
    AppMethodBeat.o(38003);
    return paramOnClickListener;
  }
  
  private void a(com.tencent.mm.roomsdk.a.c.a parama)
  {
    AppMethodBeat.i(38011);
    parama.d(new SelectContactUI.13(this, parama));
    parama.a(this, getString(2131755998), getString(2131762206), true, true, new SelectContactUI.14(this, parama));
    anK(2);
    AppMethodBeat.o(38011);
  }
  
  private void anK(int paramInt)
  {
    AppMethodBeat.i(38012);
    if (this.PZj)
    {
      AppMethodBeat.o(38012);
      return;
    }
    this.PZj = true;
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
        localObject = this.zow.iterator();
        j = 0;
        label107:
        if (!((Iterator)localObject).hasNext()) {
          break label257;
        }
        String str = (String)((Iterator)localObject).next();
        if (this.PYF.containsKey(str)) {
          switch (((Integer)this.PYF.get(str)).intValue())
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
      Log.d("MicroMsg.SelectContactUI", "report_17535, scene:%d, SelectCount:%d, SearchCount:%d, RecommendCount:%d, RecommendGroupCount:%d, ExitType:%d, TokenSearchCount:%d, TokenRecommendCount:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(gUP().gUt()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      com.tencent.mm.plugin.report.service.h.CyF.a(17535, new Object[] { Integer.valueOf(i), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(gUP().gUt()), Integer.valueOf(paramInt), Integer.valueOf(i1), Integer.valueOf(j) });
      Object localObject = new LinkedList();
      ((List)localObject).addAll(this.PYE);
      ((List)localObject).addAll(this.zow);
      w.jN((List)localObject);
    }
    AppMethodBeat.o(38012);
  }
  
  private void ani()
  {
    AppMethodBeat.i(38006);
    if ((u.hasAttr(this.PYo, 64)) && (this.zow.size() > 0))
    {
      bnz(getString(2131755858) + "(" + this.zow.size() + ")");
      int i = getIntent().getIntExtra("min_limit_num", 0);
      if ((u.hasAttr(this.PYo, 262144)) && (this.zow.size() < i))
      {
        Cr(false);
        AppMethodBeat.o(38006);
        return;
      }
      Cr(true);
      AppMethodBeat.o(38006);
      return;
    }
    if ((u.hasAttr(this.PYo, 64)) && (u.hasAttr(this.PYo, 4194304)))
    {
      bnz(getString(2131755858));
      Cr(true);
      AppMethodBeat.o(38006);
      return;
    }
    bnz(getString(2131755858));
    Cr(false);
    AppMethodBeat.o(38006);
  }
  
  private static String arC(String paramString)
  {
    AppMethodBeat.i(234056);
    paramString = com.tencent.mm.b.g.getMessageDigest((Util.currentTicks() + ", " + paramString).getBytes());
    AppMethodBeat.o(234056);
    return paramString;
  }
  
  private com.tencent.mm.i.g axk(String paramString)
  {
    AppMethodBeat.i(234055);
    com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
    localg.ehd = true;
    localg.gqy = this.sPz;
    localg.field_mediaId = arC(paramString);
    localg.field_fullpath = paramString;
    localg.field_thumbpath = "";
    localg.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
    localg.field_talker = "";
    localg.field_priority = com.tencent.mm.i.a.gpM;
    localg.field_needStorage = false;
    localg.field_isStreamMedia = false;
    localg.field_appType = 0;
    localg.field_bzScene = 0;
    this.PZk.put(localg.field_mediaId, localg.field_fullpath);
    AppMethodBeat.o(234055);
    return localg;
  }
  
  private void bnA(String paramString)
  {
    AppMethodBeat.i(38018);
    if (this.PYE.contains(paramString))
    {
      AppMethodBeat.o(38018);
      return;
    }
    int i;
    if (this.zow.contains(paramString))
    {
      this.zow.remove(paramString);
      i = 1;
      if (getIntent().getBooleanExtra("create_group_recommend", false))
      {
        if (gUP() == gUQ()) {
          break label311;
        }
        ((c)gUQ()).PTI.reset();
        gUQ().and();
        this.PWs.cIi();
        hideVKB();
      }
      label108:
      if (!(gUP() instanceof v)) {
        break label339;
      }
      String str = ((v)gUP()).gUO();
      if (this.zoy != null) {
        this.zoy.getInputText().setText(str);
      }
    }
    for (;;)
    {
      this.zoy.bev(paramString);
      AppMethodBeat.o(38018);
      return;
      this.zow.add(paramString);
      if ((gUP() instanceof v))
      {
        if (((v)gUP()).gVe())
        {
          this.PYF.put(paramString, Integer.valueOf(((v)gUP()).bnw(paramString)));
          i = 0;
          break;
        }
        this.PYF.put(paramString, Integer.valueOf(1));
        i = 0;
        break;
      }
      if (gUP() == gUQ())
      {
        if (((c)gUQ()).bnq(paramString))
        {
          this.PYF.put(paramString, Integer.valueOf(2));
          i = 0;
          break;
        }
        this.PYF.put(paramString, Integer.valueOf(0));
      }
      i = 0;
      break;
      label311:
      if ((i == 0) && (!((c)gUQ()).bnq(paramString))) {
        break label108;
      }
      gUQ().and();
      break label108;
      label339:
      gUW();
    }
  }
  
  private static String bnB(String paramString)
  {
    AppMethodBeat.i(234054);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.SelectContactUI", "xml is null");
      AppMethodBeat.o(234054);
      return null;
    }
    String str = PluginMessenger.getAccSelectRecordPath() + "uploadcache/";
    if (!com.tencent.mm.vfs.s.YS(str)) {
      com.tencent.mm.vfs.s.boN(str);
    }
    try
    {
      str = str + com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
      if (com.tencent.mm.vfs.s.YS(str)) {
        com.tencent.mm.vfs.s.deleteFile(str);
      }
      paramString = paramString.getBytes();
      com.tencent.mm.vfs.s.f(str, paramString, paramString.length);
      paramString = com.tencent.mm.plugin.selectrecord.b.a.eSu();
      long l = com.tencent.mm.vfs.s.boW(str);
      paramString.CWO.eNm = l;
      AppMethodBeat.o(234054);
      return str;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SelectContactUI", paramString, "", new Object[0]);
      AppMethodBeat.o(234054);
    }
    return null;
  }
  
  private void bnz(String paramString)
  {
    AppMethodBeat.i(234051);
    if (this.PYL == 1)
    {
      updateOptionMenuText(1, paramString);
      AppMethodBeat.o(234051);
      return;
    }
    this.PYT.setText(paramString);
    AppMethodBeat.o(234051);
  }
  
  private void jdMethod_do(int paramInt, String paramString)
  {
    AppMethodBeat.i(234057);
    Z(paramInt, paramString, "");
    AppMethodBeat.o(234057);
  }
  
  private void gVg()
  {
    int j = 0;
    AppMethodBeat.i(37999);
    if ((this.PYp) && ((this.PSP == 1) || (this.PSP == 0))) {
      if (this.PYE == null) {
        break label96;
      }
    }
    label96:
    for (int i = this.PYE.size();; i = 0)
    {
      if (this.zow != null) {
        j = this.zow.size();
      }
      int k = Util.safeParseInt(com.tencent.mm.n.h.aqJ().getValue("ChatRoomInviteStartCount"));
      this.PYq.e(this, i + j, k);
      AppMethodBeat.o(37999);
      return;
    }
  }
  
  private void gVh()
  {
    AppMethodBeat.i(234052);
    com.tencent.f.h.RTc.aV(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234029);
        if (SelectContactUI.u(SelectContactUI.this))
        {
          if (SelectContactUI.v(SelectContactUI.this) == 0)
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(8);
            SelectContactUI.y(SelectContactUI.this).setVisibility(8);
            SelectContactUI.z(SelectContactUI.this).setVisibility(0);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099748));
            SelectContactUI.A(SelectContactUI.this).setText(2131765157);
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131234760));
            AppMethodBeat.o(234029);
            return;
          }
          if (SelectContactUI.t(SelectContactUI.this))
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(0);
            SelectContactUI.y(SelectContactUI.this).setVisibility(8);
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099711));
            SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(2131765165, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131234761));
            AppMethodBeat.o(234029);
            return;
          }
          if (SelectContactUI.s(SelectContactUI.this))
          {
            SelectContactUI.w(SelectContactUI.this).setVisibility(8);
            SelectContactUI.x(SelectContactUI.this).setVisibility(8);
            SelectContactUI.y(SelectContactUI.this).setVisibility(0);
            SelectContactUI.z(SelectContactUI.this).setVisibility(8);
            SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099711));
            SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(2131765165, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
            SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131234761));
            AppMethodBeat.o(234029);
            return;
          }
          SelectContactUI.w(SelectContactUI.this).setVisibility(0);
          SelectContactUI.x(SelectContactUI.this).setVisibility(8);
          SelectContactUI.y(SelectContactUI.this).setVisibility(8);
          SelectContactUI.z(SelectContactUI.this).setVisibility(8);
          SelectContactUI.A(SelectContactUI.this).setTextColor(SelectContactUI.this.getResources().getColor(2131099711));
          SelectContactUI.A(SelectContactUI.this).setText(SelectContactUI.this.getString(2131765165, new Object[] { Integer.toString(SelectContactUI.v(SelectContactUI.this)) }));
          SelectContactUI.B(SelectContactUI.this).setBackground(SelectContactUI.this.getResources().getDrawable(2131234761));
        }
        AppMethodBeat.o(234029);
      }
    });
    AppMethodBeat.o(234052);
  }
  
  private void gVi()
  {
    AppMethodBeat.i(38009);
    ArrayList localArrayList = Cs(true);
    localArrayList.remove(z.aTY());
    if (localArrayList.size() > 0)
    {
      this.gtM = com.tencent.mm.ui.base.h.a(getContext(), getString(2131762861), false, null);
      bg.aAk().postToWorker(new c(this, localArrayList, (byte)0));
    }
    AppMethodBeat.o(38009);
  }
  
  private void gVj()
  {
    AppMethodBeat.i(38010);
    Object localObject = Cs(false);
    ((ArrayList)localObject).remove(z.aTY());
    final String str = Util.listToString((List)localObject, ",");
    if (!Util.isNullOrNil((List)localObject))
    {
      com.tencent.mm.ui.base.h.a(getContext(), true, getString(2131762133), "", getString(2131762132), getString(2131762131), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234030);
          Log.i("MicroMsg.SelectContactUI", "return the result,and create new label");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Contacts_To_Create_New_Label", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(234030);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234031);
          Log.i("MicroMsg.SelectContactUI", "return the result");
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          paramAnonymousDialogInterface.putExtra("Select_Conv_User", str);
          paramAnonymousDialogInterface.putExtra("Select_Contact", str);
          SelectContactUI.this.setResult(-1, paramAnonymousDialogInterface);
          SelectContactUI.this.finish();
          AppMethodBeat.o(234031);
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
  
  private void gVk()
  {
    AppMethodBeat.i(234053);
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXml");
    bg.aVF();
    Object localObject = com.tencent.mm.model.c.aSQ().Hb(((Long)this.PZa.first).longValue());
    if (((eo)localObject).field_content == null)
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXml msgInfo.getContent() is null");
      AppMethodBeat.o(234053);
      return;
    }
    localObject = bnB(((eo)localObject).field_content);
    if (Util.isNullOrNil((String)localObject))
    {
      Log.e("MicroMsg.SelectContactUI", "uploadRecordXml filePath is null");
      AppMethodBeat.o(234053);
      return;
    }
    com.tencent.mm.i.g localg = axk((String)localObject);
    if (!com.tencent.mm.an.f.baQ().f(localg))
    {
      Log.e("MicroMsg.SelectContactUI", "hy: cdntra addSendTask failed. clientid:%s", new Object[] { localg.field_mediaId });
      jdMethod_do(0, "add to cdn failed");
    }
    Log.i("MicroMsg.SelectContactUI", "uploadRecordXml filePath：%s", new Object[] { localObject });
    AppMethodBeat.o(234053);
  }
  
  private boolean jO(final List<String> paramList)
  {
    AppMethodBeat.i(38004);
    Log.i("MicroMsg.SelectContactUI", "handleSelect %s", new Object[] { paramList });
    if (u.hasAttr(this.PYo, 65536))
    {
      String str = jQ(paramList);
      this.PZe = true;
      com.tencent.mm.ui.base.h.a(getContext(), str, null, true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234023);
          SelectContactUI.b(SelectContactUI.this, SelectContactUI.a(SelectContactUI.this, paramList));
          AppMethodBeat.o(234023);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(234024);
          SelectContactUI.b(SelectContactUI.this, false);
          AppMethodBeat.o(234024);
        }
      });
      bool = this.PZe;
      AppMethodBeat.o(38004);
      return bool;
    }
    boolean bool = jP(paramList);
    AppMethodBeat.o(38004);
    return bool;
  }
  
  private boolean jP(List<String> paramList)
  {
    boolean bool = false;
    AppMethodBeat.i(38005);
    if (getIntent().getBooleanExtra("Add_SendCard", false))
    {
      if (Util.isNullOrNil(this.PYI)) {
        this.PYI = Util.listToString(paramList, ",");
      }
      for (;;)
      {
        bool = ab.Eq(this.PYJ);
        paramList = new Intent();
        paramList.putExtra("be_send_card_name", this.PYI);
        paramList.putExtra("received_card_name", this.PYJ);
        paramList.putExtra("Is_Chatroom", bool);
        setResult(-1, paramList);
        finish();
        AppMethodBeat.o(38005);
        return true;
        if (!Util.isNullOrNil(this.PYJ)) {
          break;
        }
        this.PYJ = Util.listToString(paramList, ",");
      }
      Log.e("MicroMsg.SelectContactUI", "send card occur error: send:%s | receive:%s", new Object[] { this.PYI, this.PYJ });
      AppMethodBeat.o(38005);
      return false;
    }
    Object localObject;
    int i;
    if (getIntent().getBooleanExtra("snsPostWhoCanSee", false))
    {
      Log.i("MicroMsg.SelectContactUI", "sns post who can see scene,users=%s", new Object[] { paramList.toString() });
      localObject = Cs(false);
      ((ArrayList)localObject).remove(z.aTY());
      paramList = paramList.iterator();
      for (i = 0; paramList.hasNext(); i = 1)
      {
        label228:
        String str = (String)paramList.next();
        if (Util.isNullOrNil(str)) {
          break label847;
        }
        if ((((ArrayList)localObject).contains(str)) || (z.aTY().equals(str))) {
          break label228;
        }
        bg.aVF();
        as localas = com.tencent.mm.model.c.aSN().Kn(str);
        if ((localas == null) || ((int)localas.gMZ == 0) || (!com.tencent.mm.contact.c.oR(localas.field_type))) {
          break label847;
        }
        bnA(str);
        ((ArrayList)localObject).add(str);
      }
    }
    label847:
    for (;;)
    {
      break label228;
      if (i != 0)
      {
        ani();
        gUP().notifyDataSetChanged();
        break;
      }
      gVj();
      break;
      if (getIntent().getBooleanExtra("recommend_friends", false))
      {
        Log.i("MicroMsg.SelectContactUI", "Recommend Friends");
        ad.a(getContext(), this.PYJ, paramList);
        break;
      }
      if (u.hasAttr(this.PYo, 16384))
      {
        Log.i("MicroMsg.SelectContactUI", "return the result");
        localObject = new Intent();
        paramList = Util.listToString(paramList, ",");
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        ((Intent)localObject).putExtra("Select_Conv_User", paramList);
        ((Intent)localObject).putExtra("Select_Contact", paramList);
        if (this.PZb != null)
        {
          paramList = new ChatroomInfoUI.LocalHistoryInfo();
          paramList.fileid = this.PZb.field_fileId;
          paramList.aeskey = this.PZb.field_aesKey;
          paramList.filemd5 = this.PZb.field_filemd5;
          paramList.guR = ((int)this.PZb.field_fileLength);
          paramList.guS = this.PYW;
          ((Intent)localObject).putExtra("select_record_msg_info", paramList);
          if (this.PZa == null) {
            break label627;
          }
        }
        label627:
        for (long l = ((Long)this.PZa.first).longValue();; l = 0L)
        {
          ((Intent)localObject).putExtra("select_record_fake_msg_id", l);
          ((Intent)localObject).putExtra("label_source", this.yCr);
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
        Log.i("MicroMsg.SelectContactUI", "Share Image");
        gVi();
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
        paramList = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramList.axQ(), "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramList.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "dohandleSelect", "(Ljava/util/List;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        anK(3);
        break;
      }
      Log.e("MicroMsg.SelectContactUI", "unkown action: User=%s", new Object[] { paramList.toString() });
      break;
    }
  }
  
  private String jQ(List<String> paramList)
  {
    AppMethodBeat.i(38019);
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (paramList != null)
    {
      if (paramList.size() != 1) {
        break label62;
      }
      localObject = getString(2131765117, new Object[] { com.tencent.mm.model.aa.getDisplayName((String)paramList.get(0)) });
    }
    label62:
    do
    {
      AppMethodBeat.o(38019);
      return localObject;
      localObject = localStringBuilder;
    } while (paramList.size() <= 1);
    localObject = getString(2131755980);
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
        localObject = getString(2131765117, new Object[] { localStringBuilder.toString() });
        break;
      }
      localStringBuilder.append(com.tencent.mm.model.aa.getDisplayName((String)paramList.get(i)));
      if (i < paramList.size() - 1) {
        localStringBuilder.append((String)localObject);
      }
      i += 1;
    }
  }
  
  public final void M(View paramView, int paramInt)
  {
    AppMethodBeat.i(234048);
    int i = paramInt - getContentLV().getHeaderViewsCount();
    if (i < 0)
    {
      Log.i("MicroMsg.SelectContactUI", "offsetPosition is Smaller than 0, offsetPosition=%d | position=%s", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
      AppMethodBeat.o(234048);
      return;
    }
    paramView = gUP().anH(i);
    if (paramView == null)
    {
      AppMethodBeat.o(234048);
      return;
    }
    if ((paramView instanceof k))
    {
      if (u.hasAttr(this.PYo, 16384))
      {
        Log.i("MicroMsg.SelectContactUI", "handleClickNonSelect, return the result");
        paramView = new Intent();
        paramView.putExtra("Select_Contact", "");
        paramView.putExtra("Select_Conv_User", "");
        paramView.putExtra("Select_Contact", "");
        setResult(-1, paramView);
        finish();
      }
      AppMethodBeat.o(234048);
      return;
    }
    if (paramView.contact == null)
    {
      AppMethodBeat.o(234048);
      return;
    }
    if (paramView.contact.field_deleteFlag == 1)
    {
      AppMethodBeat.o(234048);
      return;
    }
    paramView = paramView.contact.field_username;
    Log.i("MicroMsg.SelectContactUI", "ClickUser=%s", new Object[] { paramView });
    if (u.hasAttr(this.PYo, 64))
    {
      Object localObject;
      if ((ab.Eq(paramView)) && (getIntent().getBooleanExtra("create_group_recommend", false)))
      {
        localObject = new Intent(this, ChattingUI.class);
        ((Intent)localObject).addFlags(67108864);
        ((Intent)localObject).putExtra("Chat_User", paramView);
        paramView = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, paramView.axQ(), "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent)paramView.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI", "handleItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        finish();
        anK(3);
        AppMethodBeat.o(234048);
        return;
      }
      if ((u.hasAttr(this.PYo, 131072)) && (this.zow.size() >= getIntent().getIntExtra("max_limit_num", 2147483647))) {
        if (!this.PYE.contains(paramView))
        {
          gUW();
          if (!this.zow.contains(paramView)) {
            break label488;
          }
          this.zoy.bev(paramView);
          this.zow.remove(paramView);
        }
      }
      for (;;)
      {
        ani();
        gVg();
        if (gUQ() == null) {
          break;
        }
        gUQ().notifyDataSetChanged();
        AppMethodBeat.o(234048);
        return;
        label488:
        localObject = getIntent().getStringExtra("too_many_member_tip_string");
        paramView = (View)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          paramView = getString(2131765131, new Object[] { Integer.valueOf(getIntent().getIntExtra("max_limit_num", 10)) });
        }
        com.tencent.mm.ui.base.h.d(getContext(), paramView, "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        });
        continue;
        bnA(paramView);
      }
    }
    jO(Util.stringsToList(new String[] { paramView }));
    AppMethodBeat.o(234048);
  }
  
  public final void T(int paramInt, String paramString)
  {
    AppMethodBeat.i(38017);
    if (paramInt == 1)
    {
      this.zow.remove(paramString);
      if (!(gUP() instanceof v)) {
        break label65;
      }
      paramString = ((v)gUP()).gUO();
      this.zoy.getInputText().setText(paramString);
    }
    for (;;)
    {
      ani();
      AppMethodBeat.o(38017);
      return;
      label65:
      if ((gUP() instanceof c)) {
        gUQ().and();
      } else {
        gUP().notifyDataSetChanged();
      }
    }
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
    if (u.hasAttr(this.PYo, 256))
    {
      if (this.PYy == null)
      {
        SelectContactUI.23 local23 = new SelectContactUI.23(this);
        if (this.PSP == 14)
        {
          localObject = getString(2131755258);
          this.PYy = a(paramListView, local23, (String)localObject);
        }
      }
      else
      {
        this.PYy.setVisibility(paramInt);
      }
    }
    else
    {
      if (u.hasAttr(this.PYo, 512))
      {
        if (this.PYz == null) {
          this.PYz = a(paramListView, new SelectContactUI.24(this), getString(2131759433));
        }
        this.PYz.setVisibility(paramInt);
      }
      if (u.hasAttr(this.PYo, 1024))
      {
        if (this.PYA == null) {
          this.PYA = a(paramListView, new SelectContactUI.25(this), getString(2131755238));
        }
        this.PYA.setVisibility(paramInt);
      }
      if (u.hasAttr(this.PYo, 2048))
      {
        if (this.PYC == null) {
          this.PYC = a(paramListView, new SelectContactUI.26(this), getString(2131755252));
        }
        this.PYC.setVisibility(paramInt);
        this.PYC.setTextSize(16.0F * com.tencent.mm.cb.a.ez(this.PYC.getContext()));
      }
      if (u.hasAttr(this.PYo, 524288)) {
        if (this.PYB == null)
        {
          localObject = "";
          i = getIntent().getIntExtra("topstory_import_type", 0);
          j = 2131755242;
          if (i != 1) {
            break label636;
          }
          localObject = com.tencent.mm.plugin.sns.b.o.DCP.IZ(5L);
          if (!Util.isNullOrNil((List)localObject)) {
            break label625;
          }
          i = 0;
          localObject = Util.listToString((List)localObject, ",");
          j = 2131755242;
          m = 2131755243;
          k = i;
          i = m;
        }
      }
    }
    for (;;)
    {
      this.PYB = a(paramListView, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(234020);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          com.tencent.mm.ui.base.h.c(SelectContactUI.this, SelectContactUI.this.getString(i, new Object[] { Integer.valueOf(k) }), "", SelectContactUI.this.getString(2131755239), SelectContactUI.this.getString(2131755761), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(234019);
              paramAnonymous2DialogInterface = new Intent();
              paramAnonymous2DialogInterface.putExtra("Select_Contact", SelectContactUI.2.this.PZo);
              paramAnonymous2DialogInterface.putExtra("App_MsgId", "fromSns");
              SelectContactUI.this.setResult(-1, paramAnonymous2DialogInterface);
              SelectContactUI.this.finish();
              AppMethodBeat.o(234019);
            }
          }, null);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234020);
        }
      }, getString(j));
      this.PYB.setTag(Integer.valueOf(k));
      localObject = this.PYB.getTag();
      if ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() <= 0)) {
        this.PYB.setVisibility(8);
      }
      for (;;)
      {
        if (u.hasAttr(this.PYo, 16777216))
        {
          if (this.PYD == null)
          {
            bg.aVF();
            localObject = com.tencent.mm.model.c.aSN().gBY();
            Log.i("MicroMsg.SelectContactUI", "setOpenIMHeaderView %s", new Object[] { Integer.valueOf(((List)localObject).size()) });
            if (((List)localObject).size() != 0)
            {
              this.PYD = a(paramListView, new SelectContactUI.4(this), "");
              paramListView = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).a("3552365301", "openim_acct_type_title", a.a.jGS);
              this.PYD.setVisibility(paramInt);
              this.PYD.setText(paramListView);
            }
          }
          if (this.PYD != null) {
            this.PYD.setVisibility(paramInt);
          }
        }
        if ((!u.hasAttr(this.PYo, 16777216)) || (this.PYD == null)) {
          break label707;
        }
        this.PYD.setBackgroundResource(2131231901);
        AppMethodBeat.o(38002);
        return;
        localObject = getString(2131755237);
        break;
        label625:
        i = ((List)localObject).size();
        break label328;
        label636:
        if (i != 2) {
          break label855;
        }
        localObject = com.tencent.mm.pluginsdk.i.a.gnq();
        if (Util.isNullOrNil((List)localObject)) {}
        for (i = 0;; i = ((List)localObject).size())
        {
          localObject = Util.listToString((List)localObject, ",");
          j = 2131755240;
          m = 2131755241;
          k = i;
          i = m;
          break;
        }
        this.PYB.setVisibility(paramInt);
      }
      label707:
      if (u.hasAttr(this.PYo, 2048))
      {
        if (this.PYC != null)
        {
          this.PYC.setBackgroundResource(2131231901);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.PYo, 1024))
      {
        if (this.PYA != null)
        {
          this.PYA.setBackgroundResource(2131231901);
          AppMethodBeat.o(38002);
        }
      }
      else if (u.hasAttr(this.PYo, 512))
      {
        if (this.PYz != null)
        {
          this.PYz.setBackgroundResource(2131231901);
          AppMethodBeat.o(38002);
        }
      }
      else if ((u.hasAttr(this.PYo, 256)) && (this.PYy != null)) {
        this.PYy.setBackgroundResource(2131231901);
      }
      AppMethodBeat.o(38002);
      return;
      label855:
      i = 2131755243;
      k = 0;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38014);
    boolean bool;
    if ((parama.PWh) && (parama.contact != null))
    {
      bool = this.zow.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama.PWi) && (parama.contact != null))
    {
      bool = this.zow.contains(parama.contact.field_username);
      AppMethodBeat.o(38014);
      return bool;
    }
    if ((parama instanceof k))
    {
      bool = this.zow.isEmpty();
      AppMethodBeat.o(38014);
      return bool;
    }
    AppMethodBeat.o(38014);
    return false;
  }
  
  protected final void aDT(String paramString)
  {
    AppMethodBeat.i(38022);
    com.tencent.mm.plugin.report.service.h.CyF.a(11225, new Object[] { Integer.valueOf(1), Integer.valueOf(0) });
    Intent localIntent = new Intent();
    localIntent.setClassName(this, "com.tencent.mm.ui.contact.SelectLabelContactUI");
    localIntent.putExtra("label", paramString);
    paramString = new HashSet();
    paramString.addAll(Cs(u.hasAttr(this.PYo, 8192)));
    paramString.addAll(this.PYE);
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    localIntent.putExtra("always_select_contact", Util.listToString(new ArrayList(paramString), ","));
    if (u.hasAttr(this.PYo, 64))
    {
      localIntent.putExtra("list_attr", u.Q(new int[] { 16384, 64, 131072 }));
      if (this.PSP == 14) {
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
  
  protected final void amZ()
  {
    AppMethodBeat.i(37997);
    super.amZ();
    this.PYo = getIntent().getIntExtra("list_attr", u.PWR);
    this.title = getIntent().getStringExtra("titile");
    this.oqZ = getIntent().getStringExtra("sub_title");
    this.PSP = getIntent().getIntExtra("list_type", -1);
    this.PYp = getIntent().getBooleanExtra("show_too_many_member", true);
    this.yCr = getIntent().getStringExtra("label_source");
    if ((u.hasAttr(this.PYo, 256)) && (ab.aUV().size() == 0)) {
      u.ll(this.PYo, 256);
    }
    this.PYG = getIntent().getBooleanExtra("Add_SendCard", false);
    this.PYH = getIntent().getBooleanExtra("recommend_friends", false);
    if ((this.PYG) || (this.PYH))
    {
      this.PYI = Util.nullAs(getIntent().getStringExtra("be_send_card_name"), "");
      this.PYJ = Util.nullAs(getIntent().getStringExtra("received_card_name"), "");
    }
    this.PYK = getIntent().getBooleanExtra("Forbid_SelectChatRoom", false);
    this.PYU = getIntent().getBooleanExtra("is_select_record_msg_mode", false);
    this.PYL = getIntent().getIntExtra("menu_mode", 1);
    this.gwx = getIntent().getStringExtra("chatroomName");
    Log.i("MicroMsg.SelectContactUI", "mRoomId：%s", new Object[] { Util.nullAs(this.gwx, "") });
    this.gzY = new ArrayList();
    this.zow = new LinkedList();
    this.PYE = new LinkedList();
    Object localObject = getIntent().getStringExtra("always_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.PYE.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = getIntent().getStringExtra("already_select_contact");
    if (!Util.isNullOrNil((String)localObject)) {
      this.zow.addAll(Util.stringsToList(((String)localObject).split(",")));
    }
    localObject = new HashSet();
    String str = getIntent().getStringExtra("block_contact");
    if (!Util.isNullOrNil(str)) {
      ((HashSet)localObject).addAll(Util.stringsToList(str.split(",")));
    }
    localObject = new HashSet((Collection)localObject);
    ((HashSet)localObject).addAll(u.gVb());
    ((HashSet)localObject).addAll(u.gVc());
    if (!u.hasAttr(this.PYo, 268435456)) {
      ((HashSet)localObject).add(z.aTY());
    }
    if (this.PYG) {
      ((HashSet)localObject).removeAll(u.gVb());
    }
    this.gzY.add("gh_3dfda90e39d6");
    this.gzY.addAll((Collection)localObject);
    gVg();
    AppMethodBeat.o(37997);
  }
  
  public final boolean b(com.tencent.mm.ui.contact.a.a parama)
  {
    AppMethodBeat.i(38015);
    if ((parama.PWh) && (parama.contact != null))
    {
      if (u.hasAttr(this.PYo, 536870912))
      {
        bool = parama.contact.arD();
        AppMethodBeat.o(38015);
        return bool;
      }
      boolean bool = this.PYE.contains(parama.contact.field_username);
      AppMethodBeat.o(38015);
      return bool;
    }
    AppMethodBeat.o(38015);
    return false;
  }
  
  protected final boolean bmA()
  {
    return true;
  }
  
  protected final String bmB()
  {
    return this.title;
  }
  
  protected final q bmC()
  {
    boolean bool2 = true;
    label392:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(38000);
        Object localObject1 = new c.a();
        ((c.a)localObject1).PTM = u.hasAttr(this.PYo, 16);
        ((c.a)localObject1).PTL = u.hasAttr(this.PYo, 32);
        ((c.a)localObject1).PTP = getIntent().getBooleanExtra("create_group_recommend", false);
        if (!u.hasAttr(this.PYo, 4))
        {
          bool1 = true;
          ((c.a)localObject1).PTN = bool1;
          if (!u.hasAttr(this.PYo, 1))
          {
            bool1 = true;
            ((c.a)localObject1).PTO = bool1;
            ((c.a)localObject1).PTQ = u.hasAttr(this.PYo, 128);
            ((c.a)localObject1).PTR = u.hasAttr(this.PYo, 1048576);
            ((c.a)localObject1).PTV = u.hasAttr(this.PYo, 256);
            if (((c.a)localObject1).PTV) {
              ((c.a)localObject1).PTW = getIntent().getStringExtra("custom_contact");
            }
            if (((c.a)localObject1).PTQ)
            {
              this.PZf = true;
              ((c.a)localObject1).PTT = getIntent().getStringExtra("wechat_sport_contact");
              ((c.a)localObject1).PTU = getIntent().getStringExtra("wechat_sport_recent_like");
              this.PZg = ((c.a)localObject1).PTT;
            }
            if (!u.gVd()) {
              continue;
            }
            ((c.a)localObject1).PSf = "@all.contact.without.chatroom.without.openim";
            if ((this.scene == 6) || (this.scene == 5)) {
              ((c.a)localObject1).PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            if (getIntent().getBooleanExtra("KBlockOpenImFav", false)) {
              ((c.a)localObject1).PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
            }
            List localList1 = this.PYE;
            List localList2 = this.zow;
            List localList3 = this.gzY;
            boolean bool3 = u.hasAttr(this.PYo, 1);
            boolean bool4 = u.hasAttr(this.PYo, 64);
            if (this.PSP != 15) {
              break label392;
            }
            bool1 = bool2;
            localObject1 = new c(this, localList1, localList2, localList3, bool3, bool4, (c.a)localObject1, bool1);
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
        ((c.a)localObject1).PSf = "@all.contact.without.chatroom.without.openim.without.openimfavour";
        continue;
        bool1 = false;
      }
      finally {}
    }
  }
  
  protected final o bmD()
  {
    AppMethodBeat.i(38001);
    if (this.PZf)
    {
      localObject = new t(this, this.gzY, u.hasAttr(this.PYo, 64), this.PZg);
      AppMethodBeat.o(38001);
      return localObject;
    }
    if (getIntent().getBooleanExtra("create_group_recommend", false))
    {
      localObject = new v(this, this.PYE, this.zow, this.gzY, u.hasAttr(this.PYo, 64), this.scene);
      AppMethodBeat.o(38001);
      return localObject;
    }
    Object localObject = new s(this, this.gzY, u.hasAttr(this.PYo, 64), this.scene);
    AppMethodBeat.o(38001);
    return localObject;
  }
  
  protected final boolean bmz()
  {
    return false;
  }
  
  public final int[] egI()
  {
    AppMethodBeat.i(38016);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(131072));
    if (!getIntent().getBooleanExtra("without_openim", false)) {
      localArrayList.add(Integer.valueOf(131081));
    }
    if (!u.hasAttr(this.PYo, 1)) {
      localArrayList.add(Integer.valueOf(131076));
    }
    if (!u.hasAttr(this.PYo, 4)) {
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
  
  protected final boolean eim()
  {
    return !this.PZf;
  }
  
  public final p gUP()
  {
    AppMethodBeat.i(234046);
    p localp = super.gUP();
    Object localObject = localp;
    if (localp == null)
    {
      localObject = bmC();
      getContentLV().setAdapter((ListAdapter)localObject);
      Log.i("MicroMsg.SelectContactUI", "getAdapter is null");
    }
    AppMethodBeat.o(234046);
    return localObject;
  }
  
  public final q gUQ()
  {
    AppMethodBeat.i(234047);
    q localq2 = super.gUQ();
    q localq1 = localq2;
    if (localq2 == null)
    {
      localq1 = bmC();
      getContentLV().setAdapter(localq1);
      Log.i("MicroMsg.SelectContactUI", "getInitAdapter is null");
    }
    AppMethodBeat.o(234047);
    return localq1;
  }
  
  public void initView()
  {
    AppMethodBeat.i(234045);
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sox, 0);
    boolean bool;
    if ((com.tencent.mm.protocal.d.KyR) || (i == 1))
    {
      bool = true;
      this.PWx = bool;
      super.initView();
      this.PYM = ((RelativeLayout)findViewById(2131307549));
      this.PYN = ((LinearLayout)findViewById(2131307548));
      this.PYT = ((Button)findViewById(2131301538));
      this.PYO = ((ImageView)findViewById(2131307551));
      this.PYP = ((ImageView)findViewById(2131307553));
      this.PYQ = ((ImageView)findViewById(2131307550));
      this.PYR = ((ProgressBar)findViewById(2131306732));
      this.PYS = ((TextView)findViewById(2131307552));
      this.PYN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37978);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.SelectContactUI", "click selectRecordMsgBt %s", new Object[] { Util.nullAs(SelectContactUI.d(SelectContactUI.this), "") });
          SelectContactUI.this.hideVKB();
          paramAnonymousView = new Intent().putExtra("Chat_User", SelectContactUI.d(SelectContactUI.this)).putExtra("finish_direct", true).putExtra("key_record_msg_select", true).putExtra("key_record_msg_select_introduce", SelectContactUI.g(SelectContactUI.this)).putExtra("key_record_select_min_msg_id", SelectContactUI.f(SelectContactUI.this)).putExtra("key_record_select_msg_num", SelectContactUI.e(SelectContactUI.this));
          if (SelectContactUI.h(SelectContactUI.this) != null) {
            paramAnonymousView.putStringArrayListExtra("key_record_select_msg_black_list", SelectContactUI.h(SelectContactUI.this));
          }
          com.tencent.mm.br.c.c(SelectContactUI.this, ".ui.chatting.ChattingUI", paramAnonymousView, 6);
          SelectContactUI.i(SelectContactUI.this);
          com.tencent.mm.plugin.selectrecord.b.a.eSu().CWO.eMX = 1;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37978);
        }
      });
      this.PYP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(37979);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.SelectContactUI", "click warn to retry");
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
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
            paramAnonymousView.CWY += 1;
            Log.i("MicroMsg.SelectContactUI", "click warn to retry, msgId:%s direct:%s", new Object[] { SelectContactUI.a(SelectContactUI.this).first, SelectContactUI.a(SelectContactUI.this).second });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37979);
            return;
            SelectContactUI.b(SelectContactUI.this);
          }
        }
      });
      com.tencent.mm.plugin.selectrecord.b.a.eSv();
      Object localObject = com.tencent.mm.plugin.selectrecord.b.a.eSu();
      String str = this.gwx;
      id localid = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).CWO;
      localid.eMN = localid.x("RoomId", str, true);
      localObject = ((com.tencent.mm.plugin.selectrecord.b.a)localObject).CWO;
      if (!ab.IB(str)) {
        break label422;
      }
      i = 1;
      label240:
      ((id)localObject).eNp = i;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.slI, 0);
      Log.d("MicroMsg.recordSelect.SelectRecordConfig", "canSelectRecordInAddRoomMembers() sw:%s", new Object[] { Integer.valueOf(i) });
      if (i != 1) {
        break label427;
      }
      i = 1;
      label292:
      if ((i == 0) || (!ab.Ix(this.gwx)) || (ab.IB(this.gwx)) || (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aEX(this.gwx) <= 0L)) {
        break label432;
      }
      this.PYN.setVisibility(0);
      com.tencent.mm.plugin.selectrecord.b.a.eSu().un(true);
      if (this.Bvb != null) {
        this.PYM.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234039);
            int i = SelectContactUI.m(SelectContactUI.this).getHeight();
            if (i > 0)
            {
              RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)SelectContactUI.this.Bvb.getLayoutParams();
              localLayoutParams.bottomMargin = i;
              SelectContactUI.this.Bvb.setLayoutParams(localLayoutParams);
            }
            AppMethodBeat.o(234039);
          }
        });
      }
    }
    for (;;)
    {
      if (this.PYL == 2)
      {
        this.gyh = new com.tencent.mm.ui.tools.h(this);
        this.gyh.Quk = this;
      }
      AppMethodBeat.o(234045);
      return;
      bool = false;
      break;
      label422:
      i = 0;
      break label240;
      label427:
      i = 0;
      break label292;
      label432:
      this.PYN.setVisibility(8);
      com.tencent.mm.plugin.selectrecord.b.a.eSu().un(false);
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
          jO(Util.stringsToList(new String[] { paramIntent }));
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Conv_User");
          localObject1 = this.zow.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            str1 = (String)((Iterator)localObject1).next();
            this.zoy.bew(str1);
          }
          this.zow.clear();
          if (!Util.isNullOrNil(paramIntent)) {
            this.zow.addAll(Util.stringsToList(paramIntent.split(",")));
          }
          paramIntent = this.zow.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (String)paramIntent.next();
            this.zoy.bex((String)localObject1);
          }
          ani();
          AppMethodBeat.o(38021);
          return;
          paramIntent = paramIntent.getStringExtra("Select_Contact");
        } while (Util.isNullOrNil(paramIntent));
        jO(Util.stringsToList(paramIntent.split(",")));
        AppMethodBeat.o(38021);
        return;
      } while (paramIntent == null);
      paramIntent = paramIntent.getStringExtra("Select_Contact");
      if (!Util.isNullOrNil(paramIntent)) {
        jO(Util.stringsToList(new String[] { paramIntent }));
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
      if (u.hasAttr(this.PYo, 64))
      {
        paramIntent = paramIntent.split(",");
        paramInt2 = paramIntent.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          localObject1 = paramIntent[paramInt1];
          if (this.zow.add(localObject1)) {
            this.zoy.bev((String)localObject1);
          }
          paramInt1 += 1;
        }
        ani();
        gUP().notifyDataSetChanged();
        AppMethodBeat.o(38021);
        return;
      }
      jO(Util.stringsToList(new String[] { paramIntent }));
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
            if (this.zoy != null)
            {
              localObject2 = paramIntent.iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  String str2 = (String)((Iterator)localObject2).next();
                  if (!this.zow.contains(str2))
                  {
                    this.zoy.bev(str2);
                    continue;
                    paramIntent = Util.stringToList(str1, ",");
                    break;
                    localObject1 = Util.stringToList((String)localObject1, ",");
                    break label563;
                  }
                }
              }
            }
            this.zow.addAll(paramIntent);
          }
        }
        if (localObject1 != null)
        {
          if (this.zoy != null)
          {
            paramIntent = ((List)localObject1).iterator();
            while (paramIntent.hasNext())
            {
              localObject2 = (String)paramIntent.next();
              this.zoy.bev((String)localObject2);
            }
          }
          this.zow.removeAll((Collection)localObject1);
        }
        gUP().notifyDataSetChanged();
        if (getIntent().getBooleanExtra("Add_SendCard", false)) {
          jO(Util.stringsToList(new String[] { str1 }));
        }
      }
      ani();
      AppMethodBeat.o(38021);
      return;
    } while (paramIntent == null);
    label642:
    this.PYV = paramIntent.getIntExtra("select_record_msg_num", 0);
    this.PYW = this.PYV;
    this.PZc = paramIntent.getStringArrayListExtra("key_select_record_msg_black_list");
    this.PZb = null;
    this.PYY = false;
    if (this.PYV == 0)
    {
      this.PYX = false;
      gVh();
    }
    for (;;)
    {
      paramIntent = com.tencent.mm.plugin.selectrecord.b.a.eSu();
      long l = this.PYW;
      paramIntent.CWO.eJj = l;
      Log.i("MicroMsg.SelectContactUI", "GET_SELECT_RECORD_MSG selectMsgNum:%s actualSelectMsgNum:%s msgId:%s direct:%s", new Object[] { Integer.valueOf(this.PYV), Integer.valueOf(this.PYW), this.PZa.first, this.PZa.second });
      break;
      this.PYX = true;
      this.PsQ = paramIntent.getLongExtra("select_record_min_msg_id", -1L);
      if ((com.tencent.mm.ui.chatting.l.gNw() > 0) && (com.tencent.mm.ui.chatting.l.gNw() < this.PYV)) {
        this.PYW = com.tencent.mm.ui.chatting.l.gNw();
      }
      gVh();
      com.tencent.mm.plugin.selectrecord.b.a.eSu().CWW = cl.aWy();
      this.PZa = com.tencent.mm.ui.chatting.l.c(this, "msginfo@fakeuser", true, this.gwx);
      if (!((Boolean)this.PZa.second).booleanValue()) {
        this.PZh.alive();
      } else {
        gVk();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37995);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.SelectContactUI", "create!");
    bg.azz().a(30, this);
    bg.azz().a(138, this);
    if (!Util.isNullOrNil(this.oqZ)) {
      setMMSubTitle(this.oqZ);
    }
    int i;
    if (u.hasAttr(this.PYo, 64))
    {
      if (this.PYL == 1)
      {
        this.PYM.setVisibility(8);
        addTextOptionMenu(1, getString(2131755921), new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(234025);
            boolean bool = SelectContactUI.r(SelectContactUI.this);
            AppMethodBeat.o(234025);
            return bool;
          }
        }, null, t.b.OGU);
      }
    }
    else
    {
      ani();
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(234032);
          SelectContactUI.this.hideVKB();
          SelectContactUI.this.finish();
          if (!SelectContactUI.this.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            MMHandlerThread.postToMainThreadDelayed(SelectContactUI.c(SelectContactUI.this), 80L);
          }
          AppMethodBeat.o(234032);
          return true;
        }
      });
      if ((this.PSP != 15) && (this.zoy != null)) {
        this.zoy.it(this.zow);
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
      w.PXE = i;
      Log.d("MicroMsg.NewGroupRecommendDetailReporter", "scene:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(37995);
      return;
      this.PYM.setVisibility(0);
      this.PYT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(234028);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (SelectContactUI.s(SelectContactUI.this))
          {
            com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(2131764292), "", SelectContactUI.this.getString(2131768713), new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(234026);
                Log.i("MicroMsg.SelectContactUI", "initMenu(uploading) click i know");
                AppMethodBeat.o(234026);
              }
            });
            paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
            paramAnonymousView.CXa += 1;
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/SelectContactUI$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(234028);
            return;
            if (SelectContactUI.t(SelectContactUI.this))
            {
              com.tencent.mm.ui.base.h.a(SelectContactUI.this, SelectContactUI.this.getString(2131764291), "", SelectContactUI.this.getString(2131768713), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(234027);
                  Log.i("MicroMsg.SelectContactUI", "initMenu(upload fail) click i know");
                  AppMethodBeat.o(234027);
                }
              });
              paramAnonymousView = com.tencent.mm.plugin.selectrecord.b.a.eSu();
              paramAnonymousView.CXb += 1;
              com.tencent.mm.plugin.selectrecord.b.a.eSu().eSy();
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
    this.PZh.dead();
    bg.azz().b(30, this);
    bg.azz().b(138, this);
    anK(1);
    w.reset();
    super.onDestroy();
    AppMethodBeat.o(37996);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(234044);
    super.onPause();
    if (this.gyh != null) {
      this.gyh.close();
    }
    AppMethodBeat.o(234044);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(234042);
    super.onResume();
    if (this.gyh != null) {
      this.gyh.start();
    }
    AppMethodBeat.o(234042);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(38013);
    if (this.gtM != null)
    {
      this.gtM.dismiss();
      this.gtM = null;
    }
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(38013);
      return;
    }
    if (z.a.a(this, paramInt1, paramInt2, paramString, 4))
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
      gUP().notifyDataSetChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(234043);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.gyh != null) {
      this.gyh.start();
    }
    AppMethodBeat.o(234043);
  }
  
  public final void y(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(234049);
    if (paramInt > 0) {}
    for (paramBoolean = true; this.AxH == paramBoolean; paramBoolean = false)
    {
      Log.d("MicroMsg.SelectContactUI", "onKeyboardHeightChanged repeat");
      AppMethodBeat.o(234049);
      return;
    }
    if (this.ygg == 0) {
      this.ygg = paramInt;
    }
    if (paramBoolean) {
      if (this.PYM.getTranslationY() != 0.0F) {
        this.PYM.setTranslationY(0.0F);
      }
    }
    for (ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.PYM, "translationY", new float[] { this.PYM.getTranslationY(), this.PYM.getTranslationY() - this.ygg });; localObjectAnimator = ObjectAnimator.ofFloat(this.PYM, "translationY", new float[] { this.PYM.getTranslationY(), this.PYM.getTranslationY() + this.ygg }))
    {
      localObjectAnimator.setDuration(200L);
      localObjectAnimator.setInterpolator(new android.support.v4.view.b.b());
      localObjectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(234021);
          Log.i("MicroMsg.SelectContactUI", "onAnimationUpdate %s", new Object[] { Float.valueOf(((Float)paramAnonymousValueAnimator.getAnimatedValue("translationY")).floatValue()) });
          AppMethodBeat.o(234021);
        }
      });
      localObjectAnimator.start();
      this.AxH = paramBoolean;
      Log.i("MicroMsg.SelectContactUI", "height:%s moveHeight:%s isKeyboardShow:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.ygg), Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(234049);
      return;
    }
  }
  
  static final class c
    implements Runnable
  {
    private ArrayList<String> PZA;
    private WeakReference<SelectContactUI> cMO;
    
    private c(SelectContactUI paramSelectContactUI, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(37992);
      this.cMO = new WeakReference(paramSelectContactUI);
      this.PZA = paramArrayList;
      AppMethodBeat.o(37992);
    }
    
    public final void run()
    {
      AppMethodBeat.i(37993);
      SelectContactUI localSelectContactUI = (SelectContactUI)this.cMO.get();
      if (localSelectContactUI == null)
      {
        AppMethodBeat.o(37993);
        return;
      }
      String str = z.aTY();
      Iterator localIterator = this.PZA.iterator();
      int i = 0;
      Object localObject1 = null;
      int j;
      if (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Log.d("MicroMsg.SelectContactUI", "toSend, %s", new Object[] { localObject2 });
        if (ab.Eq((String)localObject2))
        {
          j = 1;
          label94:
          i += j;
          o.e locale = com.tencent.mm.modelmulti.o.a(o.d.jdL).tc(4);
          locale.dRL = str;
          locale.toUser = ((String)localObject2);
          locale.iZt = localSelectContactUI.getIntent().getStringExtra("shareImagePath");
          locale.iXp = 0;
          locale.jdS = null;
          locale.dQd = 0;
          locale.iXy = "";
          locale.thumbPath = "";
          locale.jdV = true;
          locale.jdU = 2131231628;
          locale.thumbPath = ((String)localObject1);
          locale.jdR = 11;
          localObject2 = locale.bdQ();
          ((o.b)localObject2).execute();
          localObject2 = (n)((o.b)localObject2).jdJ;
          if (((n)localObject2).bcD() == null) {
            break label332;
          }
          localObject1 = ((n)localObject2).bcD().field_imgPath;
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
        ((Intent)localObject1).putStringArrayListExtra("Select_Contact", this.PZA);
        localSelectContactUI.setResult(-1, (Intent)localObject1);
        com.tencent.mm.plugin.report.service.h.CyF.a(11048, new Object[] { Integer.valueOf(1), Integer.valueOf(this.PZA.size() - i), Integer.valueOf(i) });
        localSelectContactUI.finish();
        AppMethodBeat.o(37993);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SelectContactUI
 * JD-Core Version:    0.7.0.1
 */