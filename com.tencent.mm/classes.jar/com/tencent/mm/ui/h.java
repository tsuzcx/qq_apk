package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.as.p.a;
import com.tencent.mm.h.a.gv;
import com.tencent.mm.h.a.hl;
import com.tencent.mm.h.a.hy;
import com.tencent.mm.h.a.hy.a;
import com.tencent.mm.h.a.iv;
import com.tencent.mm.h.a.ja;
import com.tencent.mm.h.a.ja.b;
import com.tencent.mm.h.a.lc;
import com.tencent.mm.h.a.ml;
import com.tencent.mm.h.a.ml.a;
import com.tencent.mm.h.a.no;
import com.tencent.mm.h.a.nq;
import com.tencent.mm.h.a.pa;
import com.tencent.mm.h.a.pc;
import com.tencent.mm.h.a.pp;
import com.tencent.mm.h.a.ps;
import com.tencent.mm.h.a.ps.b;
import com.tencent.mm.h.a.ri;
import com.tencent.mm.h.a.sj;
import com.tencent.mm.h.a.ue;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.game.a.a.a;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.an.a;
import com.tencent.mm.plugin.websearch.api.ao;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.pluginsdk.o.a;
import com.tencent.mm.pluginsdk.o.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bsx;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a
  implements ap, aq, j.a, m.b
{
  private boolean bPr = false;
  private long iKA;
  private com.tencent.mm.sdk.b.c<ue> kCl = new h.4(this);
  private CheckBox mCR;
  private com.tencent.mm.ui.widget.a.c mCT = null;
  private ah mHandler = new h.1(this, Looper.getMainLooper());
  private int nUJ;
  com.tencent.mm.sdk.b.c osA = new com.tencent.mm.sdk.b.c() {};
  private com.tencent.mm.pluginsdk.c.a sij = new com.tencent.mm.pluginsdk.c.a()
  {
    public final void j(com.tencent.mm.sdk.b.b paramAnonymousb)
    {
      y.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", new Object[] { paramAnonymousb });
      if ((paramAnonymousb instanceof iv))
      {
        h.d(h.this);
        if (h.a(h.this) != null) {
          h.a(h.this).notifyDataSetChanged();
        }
      }
    }
  };
  private int status;
  private com.tencent.mm.ui.base.preference.h uIJ;
  private View uIK;
  private boolean uIL = false;
  private String uIM = "";
  private int uIN = 0;
  private String uIO = null;
  private String uIP = null;
  private String uIQ = null;
  private String uIR = null;
  private String uIS = null;
  private boolean uIT = false;
  private boolean uIU = false;
  private boolean uIV = false;
  private boolean uIW = true;
  private int uIX;
  private View uIY;
  private TextView uIZ;
  private com.tencent.mm.sdk.b.c<pa> uJa = new h.12(this);
  com.tencent.mm.sdk.b.c uJb = new h.19(this);
  com.tencent.mm.sdk.b.c uJc = new h.20(this);
  private com.tencent.mm.pluginsdk.c.a uJd = new h.21(this);
  private com.tencent.mm.pluginsdk.c.a uJe = new h.22(this);
  private com.tencent.mm.sdk.b.c uJf = new h.23(this);
  private com.tencent.mm.sdk.b.c<hl> uJg = new h.5(this);
  p.a uJh = new h.7(this);
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6)
  {
    paramIconPreference.Gt(paramInt1);
    paramIconPreference.Gv(paramInt2);
    paramIconPreference.Gu(paramInt3);
    paramIconPreference.ne(paramBoolean);
    paramIconPreference.Gy(paramInt4);
    paramIconPreference.Gx(paramInt5);
    paramIconPreference.Gz(paramInt6);
  }
  
  /* Error */
  private void a(String paramString1, IconPreference paramIconPreference, ml paramml, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 293	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   6: ifne +18 -> 24
    //   9: aload_2
    //   10: ifnull +14 -> 24
    //   13: aload_2
    //   14: getfield 318	com/tencent/mm/ui/base/preference/IconPreference:lZf	Landroid/widget/ImageView;
    //   17: astore 7
    //   19: aload 7
    //   21: ifnonnull +6 -> 27
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: ldc_w 320
    //   30: ldc_w 322
    //   33: iconst_1
    //   34: anewarray 324	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: invokestatic 330	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: aload_3
    //   45: getfield 223	com/tencent/mm/h/a/ml:bVN	Lcom/tencent/mm/h/a/ml$a;
    //   48: getfield 228	com/tencent/mm/h/a/ml$a:bVP	Ljava/lang/String;
    //   51: astore 7
    //   53: aload_3
    //   54: getfield 223	com/tencent/mm/h/a/ml:bVN	Lcom/tencent/mm/h/a/ml$a;
    //   57: getfield 231	com/tencent/mm/h/a/ml$a:appId	Ljava/lang/String;
    //   60: astore 8
    //   62: aload_3
    //   63: getfield 223	com/tencent/mm/h/a/ml:bVN	Lcom/tencent/mm/h/a/ml$a;
    //   66: getfield 234	com/tencent/mm/h/a/ml$a:msgType	I
    //   69: istore 5
    //   71: aload_3
    //   72: getfield 223	com/tencent/mm/h/a/ml:bVN	Lcom/tencent/mm/h/a/ml$a;
    //   75: getfield 237	com/tencent/mm/h/a/ml$a:bGy	Ljava/lang/String;
    //   78: astore 9
    //   80: aload_3
    //   81: getfield 223	com/tencent/mm/h/a/ml:bVN	Lcom/tencent/mm/h/a/ml$a;
    //   84: getfield 240	com/tencent/mm/h/a/ml$a:showType	I
    //   87: istore 6
    //   89: new 332	com/tencent/mm/h/a/gw
    //   92: dup
    //   93: invokespecial 333	com/tencent/mm/h/a/gw:<init>	()V
    //   96: astore_3
    //   97: aload_3
    //   98: getfield 337	com/tencent/mm/h/a/gw:bOG	Lcom/tencent/mm/h/a/gw$a;
    //   101: iconst_1
    //   102: putfield 342	com/tencent/mm/h/a/gw$a:uC	I
    //   105: aload_3
    //   106: getfield 337	com/tencent/mm/h/a/gw:bOG	Lcom/tencent/mm/h/a/gw$a;
    //   109: aload_1
    //   110: putfield 345	com/tencent/mm/h/a/gw$a:url	Ljava/lang/String;
    //   113: getstatic 351	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   116: aload_3
    //   117: invokevirtual 355	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   120: pop
    //   121: aload_3
    //   122: getfield 359	com/tencent/mm/h/a/gw:bOH	Lcom/tencent/mm/h/a/gw$b;
    //   125: getfield 364	com/tencent/mm/h/a/gw$b:bOJ	Z
    //   128: ifeq -104 -> 24
    //   131: new 366	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   138: aload_3
    //   139: getfield 359	com/tencent/mm/h/a/gw:bOH	Lcom/tencent/mm/h/a/gw$b;
    //   142: getfield 370	com/tencent/mm/h/a/gw$b:bOI	Ljava/lang/String;
    //   145: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 380	java/lang/String:getBytes	()[B
    //   152: invokestatic 386	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   155: invokevirtual 374	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: invokevirtual 390	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: astore 10
    //   163: new 392	com/tencent/mm/as/a/a/c$a
    //   166: dup
    //   167: invokespecial 393	com/tencent/mm/as/a/a/c$a:<init>	()V
    //   170: astore 11
    //   172: aload 11
    //   174: iconst_1
    //   175: putfield 396	com/tencent/mm/as/a/a/c$a:erf	Z
    //   178: aload 11
    //   180: aload 10
    //   182: putfield 399	com/tencent/mm/as/a/a/c$a:erh	Ljava/lang/String;
    //   185: aload 11
    //   187: invokevirtual 403	com/tencent/mm/as/a/a/c$a:OV	()Lcom/tencent/mm/as/a/a/c;
    //   190: astore 10
    //   192: invokestatic 409	com/tencent/mm/as/o:ON	()Lcom/tencent/mm/as/a/a;
    //   195: aload_1
    //   196: aload_2
    //   197: getfield 318	com/tencent/mm/ui/base/preference/IconPreference:lZf	Landroid/widget/ImageView;
    //   200: aload 10
    //   202: new 411	com/tencent/mm/ui/h$11
    //   205: dup
    //   206: aload_0
    //   207: aload_3
    //   208: invokespecial 414	com/tencent/mm/ui/h$11:<init>	(Lcom/tencent/mm/ui/h;Lcom/tencent/mm/h/a/gw;)V
    //   211: new 416	com/tencent/mm/ui/h$13
    //   214: dup
    //   215: aload_0
    //   216: aload_3
    //   217: aload_2
    //   218: iload 6
    //   220: aload 8
    //   222: iload 5
    //   224: aload 7
    //   226: aload 9
    //   228: aload 4
    //   230: invokespecial 419	com/tencent/mm/ui/h$13:<init>	(Lcom/tencent/mm/ui/h;Lcom/tencent/mm/h/a/gw;Lcom/tencent/mm/ui/base/preference/IconPreference;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   233: invokevirtual 424	com/tencent/mm/as/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/as/a/a/c;Lcom/tencent/mm/as/a/c/i;Lcom/tencent/mm/as/a/c/g;)V
    //   236: goto -212 -> 24
    //   239: astore_1
    //   240: aload_0
    //   241: monitorexit
    //   242: aload_1
    //   243: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	h
    //   0	244	1	paramString1	String
    //   0	244	2	paramIconPreference	IconPreference
    //   0	244	3	paramml	ml
    //   0	244	4	paramString2	String
    //   69	154	5	i	int
    //   87	132	6	j	int
    //   17	208	7	localObject1	Object
    //   60	161	8	str1	String
    //   78	149	9	str2	String
    //   161	40	10	localObject2	Object
    //   170	16	11	locala	com.tencent.mm.as.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   2	9	239	finally
    //   13	19	239	finally
    //   27	236	239	finally
  }
  
  private void apa()
  {
    this.uIX = 0;
    if (this.uIY != null) {
      this.uIY.setVisibility(8);
    }
    if ((!this.vdv) || (!isAdded())) {
      return;
    }
    cyt();
    boolean bool2 = xe(1048576);
    boolean bool3 = com.tencent.mm.br.d.SP("scanner");
    label110:
    Object localObject1;
    if (!bool2)
    {
      bool1 = true;
      y.i("MicroMsg.FindMoreFriendsUI", "openScan %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break label845;
      }
      this.uIJ.bJ("find_friends_by_qrcode", true);
      cyu();
      bool2 = xe(2097152);
      bool3 = com.tencent.mm.br.d.SP("search");
      if (bool2) {
        break label921;
      }
      bool1 = true;
      label136:
      y.i("MicroMsg.FindMoreFriendsUI", "openSearch %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break label926;
      }
      this.uIJ.bJ("find_friends_by_search", true);
      cyv();
      cyw();
      bool2 = xe(4194304);
      if (bool2) {
        break label1199;
      }
      bool1 = true;
      label206:
      y.i("MicroMsg.FindMoreFriendsUI", "openShoppingEntry %s", new Object[] { Boolean.valueOf(bool1) });
      if (bool2) {
        break label1204;
      }
      mL(false);
      label235:
      localObject1 = a.a.aYi();
      if (localObject1 == null) {
        break label1406;
      }
      getContext();
    }
    label274:
    label334:
    label631:
    label1406:
    for (boolean bool1 = ((com.tencent.mm.plugin.game.a.a)localObject1).aXZ();; bool1 = false)
    {
      bool3 = xe(8388608);
      int i;
      Object localObject2;
      if (!bool3)
      {
        bool2 = true;
        y.i("MicroMsg.FindMoreFriendsUI", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bool1) || (bool3)) {
          break label1223;
        }
        this.uIJ.bJ("more_tab_game_recommend", false);
        cys();
        this.uIX += 1;
        localObject1 = new ps();
        ((ps)localObject1).bZh.bZj = true;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        bool2 = ((ps)localObject1).bZi.bZk;
        bool3 = xe(16777216);
        if (bool3) {
          break label1236;
        }
        bool1 = true;
        y.i("MicroMsg.FindMoreFriendsUI", "shouldShowMiniProgram %s, openMiniProgramEntry %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((bool2) && (!bool3)) {
          break label1241;
        }
        this.uIJ.bJ("app_brand_entrance", true);
        bool2 = com.tencent.mm.plugin.ipcall.d.bbM();
        bool3 = xe(33554432);
        if (bool3) {
          break label1345;
        }
        bool1 = true;
        y.i("MicroMsg.FindMoreFriendsUI", "showShowWeChatOut %s, openWeChatOutEntry %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!bool2) || (bool3)) {
          break label1381;
        }
        this.uIX += 1;
        this.uIJ.bJ("ip_call_entrance", false);
        localObject1 = (IconPreference)this.uIJ.add("ip_call_entrance");
        au.Hx();
        if (((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uqq, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.AA().getInt("WCOEntranceRedDot", 0)) {
          break label1350;
        }
        ((IconPreference)localObject1).Gt(0);
        ((IconPreference)localObject1).dD(getString(R.l.app_new), R.g.new_tips_bg);
        ((IconPreference)localObject1).Gy(8);
        au.Hx();
        if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqs, Boolean.valueOf(false))).booleanValue() != true) {
          break label1360;
        }
        ((IconPreference)localObject1).ne(true);
        ((IconPreference)localObject1).Gt(8);
        i = 1;
        au.Hx();
        localObject2 = (String)com.tencent.mm.model.c.Dz().get(ac.a.uqr, "");
        ((IconPreference)localObject1).ap((String)localObject2, -1, -7566196);
        if (!bk.bl((String)localObject2)) {
          i = 1;
        }
        if (i == 0) {
          break label1371;
        }
        ((IconPreference)localObject1).Gu(0);
        localObject1 = new PreferenceSmallCategory(getContext());
        this.uIJ.a((Preference)localObject1, -1);
        cyp();
        this.uIJ.bJ("find_friends_by_facebook", true);
        this.uIJ.bJ("settings_emoji_store", true);
        if (this.uIX == 0)
        {
          localObject1 = (ViewGroup)findViewById(16908298).getParent();
          if (this.uIY != null) {
            break label1395;
          }
          this.uIY = getContext().getLayoutInflater().inflate(R.i.findmore_ui_empty_jump_view, null);
          this.uIZ = ((TextView)this.uIY.findViewById(R.h.goto_manage_findmoreui));
          this.uIZ.setOnClickListener(new h.6(this));
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          ((ViewGroup)localObject1).addView(this.uIY, (ViewGroup.LayoutParams)localObject2);
        }
      }
      for (;;)
      {
        this.uIJ.notifyDataSetChanged();
        return;
        bool1 = false;
        break;
        this.uIJ.bJ("find_friends_by_qrcode", false);
        this.uIX += 1;
        if (com.tencent.mm.y.c.BS().b(ac.a.uzK, ac.a.uzJ))
        {
          ((NormalIconPreference)this.uIJ.add("find_friends_by_qrcode")).Gv(0);
          break label110;
        }
        ((NormalIconPreference)this.uIJ.add("find_friends_by_qrcode")).Gv(4);
        break label110;
        bool1 = false;
        break label136;
        this.uIX += 1;
        this.uIJ.bJ("find_friends_by_search", false);
        Bitmap localBitmap;
        for (;;)
        {
          IconPreference localIconPreference;
          try
          {
            localObject2 = ac.Ru("discoverSearchEntry");
            localObject1 = ((JSONObject)localObject2).optString("wording");
            localObject2 = ((JSONObject)localObject2).optString("androidIcon");
            localIconPreference = (IconPreference)this.uIJ.add("find_friends_by_search");
            if (!bk.bl((String)localObject1)) {
              break label1090;
            }
            localIconPreference.setTitle(getString(R.l.find_friends_search));
            if (!bk.bl((String)localObject2)) {
              break label1100;
            }
            localIconPreference.drawable = com.tencent.mm.cb.a.g(getContext(), R.k.find_more_friend_search);
            this.uIQ = null;
            localIconPreference.Gt(8);
            ai.d(new h.3(this, localIconPreference, an.bZJ().qUQ));
            aa.bZu();
          }
          catch (Exception localException)
          {
            y.printErrStackTrace("MicroMsg.FindMoreFriendsUI", localException, "update search entry exception!", new Object[0]);
          }
          break;
          localIconPreference.setTitle(localException);
          continue;
          o.OI();
          localBitmap = com.tencent.mm.as.c.jK((String)localObject2);
          if (localBitmap != null)
          {
            localIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
            this.uIQ = null;
          }
          else
          {
            y.i("MicroMsg.FindMoreFriendsUI", "load search icon from disk and net %s ", new Object[] { localObject2 });
            localIconPreference.drawable = com.tencent.mm.cb.a.g(getContext(), R.k.find_more_friend_search);
            o.OM().a((String)localObject2, this.uJh);
            this.uIQ = ((String)localObject2);
          }
        }
        bool1 = false;
        break label206;
        this.uIJ.bJ("jd_market_entrance", true);
        break label235;
        bool2 = false;
        break label274;
        this.uIJ.bJ("more_tab_game_recommend", true);
        break label334;
        bool1 = false;
        break label386;
        this.uIX += 1;
        this.uIJ.bJ("app_brand_entrance", false);
        localObject2 = (IconPreference)this.uIJ.add("app_brand_entrance");
        if (localBitmap.bZi.bZm)
        {
          i = 0;
          ((IconPreference)localObject2).Gt(i);
          ((IconPreference)localObject2).dD(getString(R.l.app_new), R.g.new_tips_bg);
          if (!localBitmap.bZi.bZl) {
            break label1339;
          }
        }
        for (i = 0;; i = 8)
        {
          ((IconPreference)localObject2).Gv(i);
          break;
          i = 8;
          break label1290;
        }
        bool1 = false;
        break label453;
        localBitmap.Gt(8);
        break label582;
        localBitmap.ne(false);
        i = 0;
        break label631;
        localBitmap.Gu(8);
        break label682;
        this.uIJ.bJ("ip_call_entrance", true);
        break label705;
        this.uIY.setVisibility(0);
      }
    }
  }
  
  private static void b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    com.tencent.mm.kernel.g.DQ();
    Object localObject = (String)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uyp, "");
    if ((paramString2 != null) && (!paramString2.equals(localObject)))
    {
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().c(ac.a.uyp, paramString2);
      localObject = new nq();
      ((nq)localObject).bXm.scene = 9;
      ((nq)localObject).bXm.bXn = 901;
      ((nq)localObject).bXm.action = 1;
      ((nq)localObject).bXm.appId = paramString1;
      ((nq)localObject).bXm.msgType = paramInt1;
      ((nq)localObject).bXm.bVP = paramString2;
      ((nq)localObject).bXm.bGy = paramString3;
      paramString1 = new JSONObject();
    }
    try
    {
      paramString1.put("function_type", "resource");
      paramString1.put("function_value", String.valueOf(paramInt2));
    }
    catch (JSONException paramString2)
    {
      try
      {
        for (;;)
        {
          paramString1 = URLEncoder.encode(paramString1.toString(), "utf-8");
          ((nq)localObject).bXm.bXo = paramString1;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
          com.tencent.mm.plugin.report.service.h.nFQ.a(858L, 2L, 1L, false);
          return;
          paramString2 = paramString2;
          y.e("MicroMsg.FindMoreFriendsUI", paramString2.getMessage());
        }
      }
      catch (UnsupportedEncodingException paramString2)
      {
        for (;;)
        {
          paramString1 = "";
          y.e("MicroMsg.FindMoreFriendsUI", paramString2.getMessage());
        }
      }
    }
  }
  
  private void cyp()
  {
    int k = 0;
    y.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
    if ((!this.vdv) || (!isAdded()))
    {
      y.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
      return;
    }
    for (;;)
    {
      Object localObject;
      IconPreference localIconPreference;
      try
      {
        localObject = ac.Ru("discoverRecommendEntry");
        if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Ul("labs_browse")) {
          break label316;
        }
        if (((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Uj("labs_browse"))
        {
          if (!((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).Uk("labs_browse")) {
            break label479;
          }
          j = 1;
          i = 1;
          if (!com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null))) {
            break label476;
          }
          y.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility EuropeanUnionCountry");
          i = k;
          if (i == 0) {
            break label464;
          }
          String str = ((JSONObject)localObject).optString("wording");
          localObject = ((JSONObject)localObject).optString("androidIcon");
          localIconPreference = (IconPreference)this.uIJ.add("find_friends_by_look");
          if (!bk.bl(str)) {
            break label332;
          }
          localIconPreference.setTitle(getString(R.l.find_friends_look));
          if (!bk.bl((String)localObject)) {
            break label342;
          }
          localIconPreference.drawable = com.tencent.mm.cb.a.g(getContext(), R.k.find_more_friend_look);
          this.uIP = null;
          this.uIX += 1;
          this.uIJ.bJ("find_friends_by_look", false);
          if (j == 0) {
            break label441;
          }
          localIconPreference.Gt(0);
          localIconPreference.dD(getString(R.l.app_new), R.g.new_tips_bg);
          ((com.tencent.mm.plugin.topstory.ui.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.topstory.ui.a.class)).tryToCreateTopStoryWebView();
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.FindMoreFriendsUI", bk.j(localException));
        return;
      }
      y.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility in experiment but not open");
      int i = 0;
      break label481;
      label316:
      y.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility not in experiment");
      int j = 0;
      i = 0;
      continue;
      label332:
      localIconPreference.setTitle(localException);
      continue;
      label342:
      o.OI();
      Bitmap localBitmap = com.tencent.mm.as.c.jK((String)localObject);
      if (localBitmap != null)
      {
        localIconPreference.drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
        this.uIP = null;
      }
      else
      {
        y.i("MicroMsg.FindMoreFriendsUI", "load look icon from disk and net %s ", new Object[] { localObject });
        localIconPreference.drawable = com.tencent.mm.cb.a.g(getContext(), R.k.find_more_friend_look);
        o.OM().a((String)localObject, this.uJh);
        this.uIP = ((String)localObject);
        continue;
        label441:
        localIconPreference.Gt(8);
        ai.d(new h.2(this, localIconPreference));
        continue;
        label464:
        this.uIJ.bJ("find_friends_by_look", true);
        return;
        label476:
        continue;
        label479:
        i = 1;
        label481:
        j = 0;
      }
    }
  }
  
  private static int cyq()
  {
    int j = 1;
    f.b localb = com.tencent.mm.pluginsdk.f.f.rVL;
    int i = j;
    f.a locala;
    if (localb != null)
    {
      locala = localb.bLU();
      i = j;
      if (localb.bLL())
      {
        i = j;
        if (locala.aiS())
        {
          i = j;
          if (!locala.bLD())
          {
            if ((!"3".equals(locala.bLI())) || (bk.bl(locala.bLJ()))) {
              break label84;
            }
            i = 6;
          }
        }
      }
    }
    label84:
    do
    {
      return i;
      if (!bk.bl(locala.bLG())) {
        return 3;
      }
      i = j;
    } while (!locala.bLH());
    return 2;
  }
  
  private void cys()
  {
    if ((IconPreference)this.uIJ.add("more_tab_game_recommend") == null) {
      return;
    }
    com.tencent.mm.sdk.f.e.post(new h.10(this), "updateGame");
  }
  
  private void cyt()
  {
    if ((this.nUJ & 0x8000) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.br.d.SP("sns");
      y.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      localObject1 = getSharedPreferences(ae.cqR(), 0);
      localObject2 = ((SharedPreferences)localObject1).getString(com.tencent.mm.model.q.Gj() + "_sns_entrance_disappear", "");
      if (!bool1) {
        break;
      }
      if (bk.bl((String)localObject2)) {
        ((SharedPreferences)localObject1).edit().putString(com.tencent.mm.model.q.Gj() + "_sns_entrance_disappear", "on").commit();
      }
      if ((bool1) && (bool2)) {
        break label507;
      }
      this.uIJ.bJ("album_dyna_photo_ui_title", true);
      return;
    }
    boolean bool3 = ((SharedPreferences)localObject1).getBoolean(com.tencent.mm.model.q.Gj() + "_has_mod_userinfo", false);
    if ((localObject2 != null) && (((String)localObject2).equals("on"))) {
      if (bool3)
      {
        i = 110;
        label226:
        com.tencent.mm.plugin.report.service.h.nFQ.a(150L, i, 1L, true);
        y.e("MicroMsg.FindMoreFriendsUI", "sns entrance disappear autoly, hasModUserInfo:%b", new Object[] { Boolean.valueOf(bool3) });
        com.tencent.mm.plugin.report.service.h.nFQ.f(15179, new Object[] { Integer.valueOf(i) });
      }
    }
    for (;;)
    {
      label280:
      if ((((SharedPreferences)localObject1).contains(com.tencent.mm.model.q.Gj() + "_has_mod_userinfo")) || (((SharedPreferences)localObject1).contains(com.tencent.mm.model.q.Gj() + "_sns_entrance_disappear")))
      {
        ((SharedPreferences)localObject1).edit().remove(com.tencent.mm.model.q.Gj() + "_has_mod_userinfo").remove(com.tencent.mm.model.q.Gj() + "_sns_entrance_disappear").commit();
        break;
        i = 111;
        break label226;
        if ((localObject2 != null) && (((String)localObject2).equals("on_close"))) {
          if (!bool3) {
            break label501;
          }
        }
      }
    }
    label501:
    for (int i = 112;; i = 113)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.a(150L, i, 1L, true);
      y.i("MicroMsg.FindMoreFriendsUI", "sns entrance close by user, hasModUserInfo:%b", new Object[] { Boolean.valueOf(bool3) });
      com.tencent.mm.plugin.report.service.h.nFQ.f(15179, new Object[] { Integer.valueOf(i) });
      break label280;
      break;
    }
    label507:
    this.uIX += 1;
    this.uIJ.bJ("album_dyna_photo_ui_title", false);
    Object localObject1 = (FriendSnsPreference)this.uIJ.add("album_dyna_photo_ui_title");
    ((IconPreference)localObject1).drawable = com.tencent.mm.cb.a.g(getContext(), R.k.find_more_friend_photograph_icon);
    au.Hx();
    bool1 = bk.d((Boolean)com.tencent.mm.model.c.Dz().get(48, null));
    ((FriendSnsPreference)localObject1).Gt(8);
    ((FriendSnsPreference)localObject1).Gz(8);
    if (bool1)
    {
      ((FriendSnsPreference)localObject1).Gt(0);
      ((FriendSnsPreference)localObject1).dD(getString(R.l.app_new), R.g.new_tips_bg);
    }
    au.Hx();
    this.uIM = ((String)com.tencent.mm.model.c.Dz().get(68377, null));
    if ((!bk.bl(this.uIM)) && (LauncherUI.cyY() == 2))
    {
      au.Hx();
      if (com.tencent.mm.model.c.Dz().getInt(68419, 0) == 0)
      {
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.plugin.sns.h.e.i(2, (String)com.tencent.mm.kernel.g.DP().Dz().get(68418, ""), this.uIN);
        au.Hx();
        com.tencent.mm.model.c.Dz().o(68419, Integer.valueOf(1));
      }
    }
    Object localObject2 = com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzz, null);
    long l;
    if (localObject2 == null)
    {
      l = 0L;
      y.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", new Object[] { bk.aM(this.uIM, "") });
      ((FriendSnsPreference)localObject1).Gy(0);
      if (bk.bl(this.uIM)) {
        break label977;
      }
      ((FriendSnsPreference)localObject1).Gx(0);
      au.Hx();
      if (!bk.a((Boolean)com.tencent.mm.model.c.Dz().get(68384, null), true)) {
        break label971;
      }
      i = 0;
      label814:
      ((FriendSnsPreference)localObject1).Gz(i);
      localObject2 = this.uIM;
      ((FriendSnsPreference)localObject1).uJy = null;
      ((FriendSnsPreference)localObject1).uGS = -1;
      ((FriendSnsPreference)localObject1).uJx = ((String)localObject2);
      ((FriendSnsPreference)localObject1).uJz = 0L;
      if (((FriendSnsPreference)localObject1).lZf != null) {
        a.b.a(((FriendSnsPreference)localObject1).lZf, (String)localObject2);
      }
    }
    for (;;)
    {
      if (n.omE != null) {
        this.uIN = n.omE.aAo();
      }
      if (this.uIN != 0)
      {
        ((FriendSnsPreference)localObject1).Gt(0);
        ((FriendSnsPreference)localObject1).dD(this.uIN, com.tencent.mm.ui.tools.q.hh(getContext()));
      }
      ((FriendSnsPreference)localObject1).Gv(8);
      ((FriendSnsPreference)localObject1).Gu(8);
      com.tencent.mm.sdk.b.a.udP.m(new sj());
      return;
      l = ((Long)localObject2).longValue();
      break;
      label971:
      i = 8;
      break label814;
      label977:
      au.Hx();
      if (((Boolean)com.tencent.mm.model.c.Dz().get(589825, Boolean.valueOf(false))).booleanValue())
      {
        ((FriendSnsPreference)localObject1).Gw(R.k.net_warn_icon);
        ((FriendSnsPreference)localObject1).Gx(0);
        ((FriendSnsPreference)localObject1).Gz(8);
      }
      else if ((l != 0L) && (((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sns.b.m.class)).fE(l)))
      {
        ((FriendSnsPreference)localObject1).Gx(0);
        ((FriendSnsPreference)localObject1).Gz(0);
        ((FriendSnsPreference)localObject1).uJx = null;
        ((FriendSnsPreference)localObject1).uJy = null;
        ((FriendSnsPreference)localObject1).uGS = -1;
        ((FriendSnsPreference)localObject1).uJz = l;
        if ((((FriendSnsPreference)localObject1).uJz != 0L) && (((FriendSnsPreference)localObject1).lZf != null)) {
          ((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.sns.b.m.class)).a(((FriendSnsPreference)localObject1).uJz, ((FriendSnsPreference)localObject1).lZf, ((Preference)localObject1).mContext.hashCode());
        }
      }
      else
      {
        ((FriendSnsPreference)localObject1).Gx(8);
      }
    }
  }
  
  private void cyu()
  {
    if ((this.nUJ & 0x100) == 0) {}
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = com.tencent.mm.br.d.SP("shake");
      y.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        break;
      }
      this.uIJ.bJ("find_friends_by_shake", true);
      return;
    }
    this.uIX += 1;
    this.uIJ.bJ("find_friends_by_shake", false);
    IconPreference localIconPreference = (IconPreference)this.uIJ.add("find_friends_by_shake");
    int i = com.tencent.mm.bh.d.Sa().aAo() + o.a.ckl().bzN();
    if (i > 0)
    {
      localIconPreference.Gt(0);
      localIconPreference.dD(String.valueOf(i), R.g.unread_count_shape);
      localIconPreference.Gx(8);
      o.a.ckl().bzO();
      if (!o.a.ckl().bzP()) {
        break label509;
      }
    }
    label476:
    label501:
    label509:
    for (bool1 = com.tencent.mm.y.c.BS().bc(262154, 266258);; bool1 = false)
    {
      Object localObject;
      if (bool1)
      {
        au.Hx();
        localObject = (String)com.tencent.mm.model.c.Dz().get(ac.a.unP, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localIconPreference.Gv(8);
          localIconPreference.Gt(0);
          localIconPreference.dD((String)localObject, R.g.unread_count_shape);
        }
      }
      int j;
      for (;;)
      {
        au.Hx();
        localObject = bk.aM((String)com.tencent.mm.model.c.Dz().get(ac.a.ura, null), "");
        au.Hx();
        bool2 = bk.a((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.urc, null), false);
        au.Hx();
        j = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uqY, Integer.valueOf(0))).intValue();
        if ((!Boolean.valueOf(bool2).booleanValue()) || (localObject == null) || (((String)localObject).equals("")) || (i > 0) || (bool1)) {
          break label501;
        }
        if (j != 0) {
          break label476;
        }
        localIconPreference.Gv(8);
        localIconPreference.Gu(0);
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0) {
          localIconPreference.ap(localObject[0], -1, Color.parseColor("#8c8c8c"));
        }
        localIconPreference.ne(true);
        localIconPreference.Gy(8);
        return;
        localIconPreference.Gt(8);
        localIconPreference.dD("", -1);
        break;
        if (i > 0)
        {
          localIconPreference.Gv(0);
        }
        else
        {
          localIconPreference.Gv(0);
          localIconPreference.Gt(8);
          localIconPreference.dD("", -1);
          continue;
          localIconPreference.Gv(8);
        }
      }
      if (j != 1) {
        break;
      }
      localIconPreference.Gu(8);
      localIconPreference.Gt(0);
      localIconPreference.vcF = true;
      return;
      localIconPreference.Gu(8);
      return;
    }
  }
  
  private void cyv()
  {
    boolean bool1;
    if ((this.nUJ & 0x200) == 0)
    {
      bool1 = true;
      boolean bool2 = com.tencent.mm.br.d.SP("nearby");
      y.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        break label72;
      }
      this.uIJ.bJ("find_friends_by_near", true);
    }
    label72:
    IconPreference localIconPreference;
    do
    {
      return;
      bool1 = false;
      break;
      this.uIX += 1;
      this.uIJ.bJ("find_friends_by_near", false);
      localIconPreference = (IconPreference)this.uIJ.add("find_friends_by_near");
    } while (localIconPreference == null);
    ja localja = new ja();
    localja.bRm.bMC = 7;
    com.tencent.mm.sdk.b.a.udP.m(localja);
    if (localja.bRn.bIe) {
      localIconPreference.Gx(8);
    }
    int i;
    for (;;)
    {
      i = com.tencent.mm.bh.d.RZ().aAo();
      if (!com.tencent.mm.bp.a.cki()) {
        break label217;
      }
      if (i <= 0) {
        break;
      }
      localIconPreference.Gv(0);
      return;
      localIconPreference.Gx(0);
      localIconPreference.Gw(R.g.mm_foot);
      localIconPreference.fw(-2, -2);
    }
    localIconPreference.Gv(8);
    return;
    label217:
    if (i > 0)
    {
      localIconPreference.Gt(0);
      localIconPreference.dD(String.valueOf(i), com.tencent.mm.ui.tools.q.hh(getContext()));
      return;
    }
    localIconPreference.Gt(8);
    localIconPreference.dD("", -1);
  }
  
  private void cyw()
  {
    boolean bool1;
    if ((this.nUJ & 0x40) == 0)
    {
      bool1 = true;
      boolean bool2 = com.tencent.mm.br.d.SP("bottle");
      y.i("MicroMsg.FindMoreFriendsUI", "openBottle %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        break label71;
      }
      this.uIJ.bJ("voice_bottle", true);
    }
    label71:
    IconPreference localIconPreference;
    do
    {
      return;
      bool1 = false;
      break;
      this.uIX += 1;
      this.uIJ.bJ("voice_bottle", false);
      localIconPreference = (IconPreference)this.uIJ.add("voice_bottle");
    } while (localIconPreference == null);
    int i = k.Gf();
    if (i > 0) {
      localIconPreference.dD(String.valueOf(i), com.tencent.mm.ui.tools.q.hh(getContext()));
    }
    if ((i > 0) && ((this.status & 0x8000) == 0))
    {
      localIconPreference.Gt(0);
      return;
    }
    localIconPreference.Gt(8);
  }
  
  private void cyx()
  {
    pc localpc = new pc();
    localpc.bYO.bPr = this.bPr;
    com.tencent.mm.sdk.b.a.udP.m(localpc);
  }
  
  private String gv(String paramString1, String paramString2)
  {
    if (!bk.bl(paramString1)) {
      return paramString1;
    }
    return com.tencent.mm.pluginsdk.model.app.g.n(getContext(), paramString2);
  }
  
  private void mL(boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    f.b localb;
    boolean bool1;
    String str;
    com.tencent.mm.plugin.subapp.jdbiz.b localb1;
    int i;
    label126:
    Object localObject3;
    if (x.cqG())
    {
      localObject1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigName");
      localObject2 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigIconUrl");
      localb = com.tencent.mm.pluginsdk.f.f.rVL;
      boolean bool2 = true;
      bool1 = bool2;
      if (localb != null)
      {
        str = localb.bLT();
        bool1 = bool2;
        if (!bk.bl((String)localObject1))
        {
          bool1 = bool2;
          if (!bk.bl((String)localObject2))
          {
            bool1 = bool2;
            if (!bk.bl(str))
            {
              this.uIX += 1;
              localb1 = (com.tencent.mm.plugin.subapp.jdbiz.b)localb.bLU();
              if (localb1.pvh >= System.currentTimeMillis() / 1000L) {
                break label558;
              }
              i = 1;
              localObject3 = localObject2;
              if (i == 0) {
                break label683;
              }
              if ((localb1.pvi == 0L) || (localb1.pvi >= System.currentTimeMillis() / 1000L)) {
                break label563;
              }
              i = 1;
              label162:
              localObject3 = localObject2;
              if (i != 0) {
                break label683;
              }
              if (!bk.bl(localb1.iconUrl)) {
                localObject2 = localb1.iconUrl;
              }
              localObject3 = localObject2;
              if (bk.bl(localb1.title)) {
                break label683;
              }
              localObject1 = localb1.title;
            }
          }
        }
      }
    }
    for (;;)
    {
      localObject3 = (IconPreference)this.uIJ.add("jd_market_entrance");
      o.OI();
      Bitmap localBitmap = com.tencent.mm.as.c.jK((String)localObject2);
      if (localBitmap != null)
      {
        ((IconPreference)localObject3).drawable = new BitmapDrawable(getContext().getResources(), localBitmap);
        this.uIO = null;
        label267:
        ((IconPreference)localObject3).setTitle((CharSequence)localObject1);
        ((IconPreference)localObject3).Gt(8);
        ((IconPreference)localObject3).Gv(8);
        ((IconPreference)localObject3).Gu(8);
        ((IconPreference)localObject3).ne(false);
        ((IconPreference)localObject3).Gy(8);
        if ((localb.bLL()) && (localb1.aiS()) && (!localb1.bLD()))
        {
          if (!bk.bl(localb1.pvd))
          {
            ((IconPreference)localObject3).Gt(8);
            ((IconPreference)localObject3).Gv(8);
            ((IconPreference)localObject3).ap(localb1.pvd, -1, -7566196);
            ((IconPreference)localObject3).Gu(0);
          }
          if (bk.bl(localb1.pve)) {
            break label631;
          }
          o.OI();
          localObject1 = com.tencent.mm.as.c.jK(localb1.pve);
          ((IconPreference)localObject3).Gy(0);
          ((IconPreference)localObject3).Gx(0);
          ((IconPreference)localObject3).Gz(0);
          ((IconPreference)localObject3).ne(false);
          if (localObject1 == null) {
            break label604;
          }
          this.uIS = null;
          ((IconPreference)localObject3).Z((Bitmap)localObject1);
        }
      }
      for (;;)
      {
        if (paramBoolean) {
          this.uIJ.notifyDataSetChanged();
        }
        if (!this.uIT)
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(11178, new Object[] { str, localb.bLU().bLF(), Integer.valueOf(cyq()) });
          this.uIT = true;
        }
        bool1 = false;
        this.uIJ.bJ("jd_market_entrance", bool1);
        return;
        if (x.cqH())
        {
          localObject1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigNameHKTW");
          break;
        }
        localObject1 = com.tencent.mm.m.g.AA().getValue("JDEntranceConfigNameEN");
        break;
        label558:
        i = 0;
        break label126;
        label563:
        i = 0;
        break label162;
        ((IconPreference)localObject3).drawable = com.tencent.mm.cb.a.g(getContext(), R.k.jd_entrance_icon);
        o.OM().a((String)localObject2, this.uJh);
        this.uIO = ((String)localObject2);
        break label267;
        label604:
        o.OM().a(localb1.pve, this.uJh);
        this.uIS = localb1.pve;
        continue;
        label631:
        if (!bk.bl(localb1.pvd))
        {
          ((IconPreference)localObject3).ne(true);
        }
        else if (localb1.pvc)
        {
          ((IconPreference)localObject3).Gv(0);
          ((IconPreference)localObject3).dD("", -1);
          ((IconPreference)localObject3).Gt(8);
        }
      }
      label683:
      localObject2 = localObject3;
    }
  }
  
  private static void mM(boolean paramBoolean)
  {
    a.a.aYi().gt(paramBoolean);
  }
  
  private boolean xe(int paramInt)
  {
    return (this.iKA & paramInt) != 0L;
  }
  
  public final void Hk()
  {
    if ((com.tencent.mm.model.q.Gu() & 0x8000) != 0) {
      return;
    }
    cyt();
    this.uIJ.notifyDataSetChanged();
  }
  
  public final void Hl() {}
  
  public final void Hm()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
    if ((com.tencent.mm.model.q.Gu() & 0x8000) != 0) {
      return;
    }
    if (n.omE != null) {
      this.uIN = n.omE.aAo();
    }
    cyt();
    this.uIJ.notifyDataSetChanged();
  }
  
  public final void Hn()
  {
    if (this.uIJ == null) {
      return;
    }
    this.status = com.tencent.mm.model.q.Gn();
    apa();
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    int i = 1;
    y.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
    if (LauncherUI.cyY() == 2)
    {
      paramInt = 0;
      if (this.status != com.tencent.mm.model.q.Gn())
      {
        this.status = com.tencent.mm.model.q.Gn();
        paramInt = 1;
      }
      if (this.iKA != com.tencent.mm.model.q.Go())
      {
        this.iKA = com.tencent.mm.model.q.Go();
        paramInt = 1;
      }
      if (this.nUJ == com.tencent.mm.model.q.Gu()) {
        break label107;
      }
      this.nUJ = com.tencent.mm.model.q.Gu();
      paramInt = i;
    }
    label107:
    for (;;)
    {
      if (paramInt != 0) {
        apa();
      }
      if ((paramm instanceof al))
      {
        cyw();
        this.uIJ.notifyDataSetChanged();
      }
      return;
    }
  }
  
  public final void a(bsx parambsx)
  {
    if ((com.tencent.mm.model.q.Gu() & 0x8000) != 0) {
      return;
    }
    this.uIN += 1;
    cyt();
    this.uIJ.notifyDataSetChanged();
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.l paraml)
  {
    int j = 1;
    y.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorage)");
    int i;
    if (LauncherUI.cyY() == 2)
    {
      i = 0;
      if (this.status != com.tencent.mm.model.q.Gn())
      {
        this.status = com.tencent.mm.model.q.Gn();
        i = 1;
      }
      if (this.iKA != com.tencent.mm.model.q.Go())
      {
        this.iKA = com.tencent.mm.model.q.Go();
        i = 1;
      }
      if (this.nUJ == com.tencent.mm.model.q.Gu()) {
        break label89;
      }
      this.nUJ = com.tencent.mm.model.q.Gu();
      i = j;
    }
    label89:
    for (;;)
    {
      if (i != 0) {
        apa();
      }
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    boolean bool1;
    label91:
    boolean bool2;
    if ("album_dyna_photo_ui_title".equals(paramPreference.mKey))
    {
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        s.gM(getContext());
        return true;
      }
      com.tencent.mm.plugin.report.service.g.wI(10);
      au.Hx();
      this.uIM = ((String)com.tencent.mm.model.c.Dz().get(68377, null));
      paramf = new Intent();
      paramPreference = new com.tencent.mm.modelsns.b(701, 1);
      if (!bk.bl(this.uIM))
      {
        bool1 = true;
        paramPreference.cb(bool1);
        paramPreference.ni(this.uIN);
        paramf.putExtra("sns_timeline_NeedFirstLoadint", true);
        paramf.putExtra("is_from_find_more", true);
        if ((bk.bl(this.uIM)) && (this.uIN <= 0)) {
          break label460;
        }
        bool1 = true;
        label158:
        paramf.putExtra("enter_by_red", bool1);
        au.Hx();
        paramf.putExtra("is_sns_notify_open", bk.a((Boolean)com.tencent.mm.model.c.Dz().get(68384, null), true));
        paramf.putExtra("sns_unread_count", n.omE.aAo());
        if (!bk.bl(this.uIM))
        {
          au.Hx();
          paramf.putExtra("new_feed_id", bk.aM((String)com.tencent.mm.model.c.Dz().get(68418, null), ""));
          au.Hx();
          com.tencent.mm.plugin.sns.h.e.i(3, (String)com.tencent.mm.model.c.Dz().get(68418, ""), this.uIN);
        }
        paramPreference.b(paramf, "enter_log");
        paramPreference = new hy();
        com.tencent.mm.sdk.b.a.udP.m(paramPreference);
        if (paramPreference.bPY.isResume) {
          break label2501;
        }
        if (bk.bl(this.uIM)) {
          break label2495;
        }
        bool1 = false;
        label326:
        bool2 = bool1;
        if (n.omE != null)
        {
          this.uIN = n.omE.aAo();
          bool2 = bool1;
          if (this.uIN > 0) {
            bool2 = false;
          }
        }
        au.Hx();
        com.tencent.mm.model.c.Dz().o(68377, "");
      }
    }
    for (;;)
    {
      au.Hx();
      com.tencent.mm.model.c.Dz().o(589825, Boolean.valueOf(false));
      paramf.putExtra("sns_resume_state", bool2);
      com.tencent.mm.br.d.b(getContext(), "sns", ".ui.SnsTimeLineUI", paramf);
      com.tencent.mm.plugin.report.service.h.nFQ.aC(10958, "1");
      new ah().postDelayed(new h.8(this), 500L);
      return true;
      bool1 = false;
      break label91;
      label460:
      bool1 = false;
      break label158;
      if ("find_friends_by_near".equals(paramPreference.mKey))
      {
        if (com.tencent.mm.at.b.mC((String)com.tencent.mm.kernel.g.DP().Dz().get(274436, null)))
        {
          if (!com.tencent.mm.pluginsdk.permission.a.j(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION"))
          {
            if (!((Boolean)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uzP, Boolean.valueOf(false))).booleanValue())
            {
              com.tencent.mm.plugin.account.a.b.a.b(thisActivity(), getString(R.l.location_use_scene_gdpr_url, new Object[] { x.cqJ() }), 30764, true);
              return true;
            }
            com.tencent.mm.pluginsdk.permission.a.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66);
            return true;
          }
        }
        else
        {
          bool1 = com.tencent.mm.pluginsdk.permission.a.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null);
          y.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool1) });
          if (!bool1) {
            break;
          }
        }
        cyr();
        return true;
      }
      if ("find_friends_by_shake".equals(paramPreference.mKey))
      {
        if ((!this.uIU) && (com.tencent.mm.model.q.GS().booleanValue()))
        {
          paramf = (IconPreference)paramf.add("find_friends_by_shake");
          if (paramf != null)
          {
            paramf.Gv(8);
            au.Hx();
            com.tencent.mm.model.c.Dz().o(340231, Boolean.valueOf(true));
            au.Hx();
            com.tencent.mm.model.c.Dz().mC(true);
            com.tencent.mm.plugin.report.service.h.nFQ.a(232L, 4L, 1L, false);
          }
        }
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10958, "3");
        au.Hx();
        paramf = bk.aM((String)com.tencent.mm.model.c.Dz().get(ac.a.ura, null), "");
        au.Hx();
        if ((Boolean.valueOf(bk.a((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.urc, null), false)).booleanValue()) && (paramf != null) && (!paramf.equals(""))) {}
        for (paramf = Boolean.valueOf(true);; paramf = Boolean.valueOf(false))
        {
          if (paramf.booleanValue()) {
            com.tencent.mm.plugin.report.service.h.nFQ.f(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          com.tencent.mm.sdk.b.a.udP.m(new no());
          com.tencent.mm.br.d.x(getContext(), "shake", ".ui.ShakeReportUI");
          return true;
        }
      }
      if ("voice_bottle".equals(paramPreference.mKey))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10958, "5");
        paramf = bn.Id();
        if ((bk.a(Integer.valueOf(paramf.sex), 0) <= 0) || (bk.bl(paramf.getProvince())))
        {
          com.tencent.mm.br.d.x(getContext(), "bottle", ".ui.BottleWizardStep1");
          return true;
        }
        com.tencent.mm.br.d.x(getContext(), "bottle", ".ui.BottleBeachUI");
        return true;
      }
      if ("find_friends_by_qrcode".equals(paramPreference.mKey))
      {
        com.tencent.mm.y.c.BS().c(ac.a.uzK, ac.a.uzJ);
        if (com.tencent.mm.r.a.bj(getContext())) {
          break;
        }
        getContext();
        if (com.tencent.mm.bf.e.RS()) {
          break;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10958, "2");
        paramf = new Intent();
        paramf.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
        com.tencent.mm.plugin.report.service.h.nFQ.f(11265, new Object[] { Integer.valueOf(2) });
        com.tencent.mm.br.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramf);
        return true;
      }
      Object localObject;
      if (paramPreference.mKey.equals("more_tab_game_recommend"))
      {
        com.tencent.mm.plugin.report.service.h.nFQ.aC(10958, "6");
        com.tencent.mm.plugin.report.service.h.nFQ.a(848L, 2L, 1L, false);
        au.Hx();
        if (!com.tencent.mm.model.c.isSDCardAvailable())
        {
          s.gM(getContext());
          return true;
        }
        paramPreference = new Intent();
        paramPreference.putExtra("from_find_more_friend", this.uIW);
        paramPreference.putExtra("game_report_from_scene", 901);
        if (this.uIW)
        {
          localObject = new ml();
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
          paramf = (IconPreference)paramf.add("more_tab_game_recommend");
          if ((((ml)localObject).bVN.bVO != null) && (paramf != null)) {
            o.ON().b(((ml)localObject).bVN.bVO, paramf.lZf);
          }
        }
        paramPreference.putExtra("start_time", System.currentTimeMillis());
        com.tencent.mm.br.d.b(getContext(), "game", ".ui.GameCenterUI", paramPreference);
        return true;
      }
      if ("find_friends_by_micromsg".equals(paramPreference.mKey))
      {
        com.tencent.mm.br.d.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
        return true;
      }
      if ("find_friends_by_mobile".equals(paramPreference.mKey))
      {
        if (com.tencent.mm.plugin.account.friend.a.l.WP() != l.a.ffT)
        {
          paramf = new Intent(getContext(), BindMContactIntroUI.class);
          paramf.putExtra("key_upload_scene", 6);
          MMWizardActivity.C(getContext(), paramf);
          return true;
        }
        startActivity(new Intent(getContext(), MobileFriendUI.class));
        return true;
      }
      if ("find_friends_by_facebook".equals(paramPreference.mKey))
      {
        startActivity(new Intent(getContext(), FacebookFriendUI.class));
        return true;
      }
      if ("settings_mm_card_package".equals(paramPreference.mKey))
      {
        y.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
        com.tencent.mm.br.d.x(getContext(), "card", ".ui.CardHomePageUI");
        return true;
      }
      if (paramPreference.mKey.equals("jd_market_entrance"))
      {
        com.tencent.mm.pluginsdk.wallet.i.Ez(9);
        paramf = com.tencent.mm.pluginsdk.f.f.rVL;
        if (paramf == null) {
          break label2490;
        }
        localObject = com.tencent.mm.pluginsdk.f.f.rVL.bLT();
        com.tencent.mm.plugin.report.service.h.nFQ.f(11179, new Object[] { localObject, paramf.bLU().bLF(), Integer.valueOf(cyq()) });
        paramf.bLO();
        paramf.bLN();
        ((IconPreference)paramPreference).dD("", -1);
        paramf = (com.tencent.mm.ui.base.preference.f)localObject;
        if (!bk.bl((String)localObject))
        {
          paramf = new Intent();
          paramf.putExtra("rawUrl", (String)localObject);
          paramf.putExtra("useJs", true);
          paramf.putExtra("vertical_scroll", true);
          paramf.putExtra("minimize_secene", 1);
          paramf.putExtra("KPublisherId", "jd_store");
          com.tencent.mm.br.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramf);
        }
      }
      label2485:
      label2490:
      for (paramf = (com.tencent.mm.ui.base.preference.f)localObject;; paramf = null)
      {
        y.i("MicroMsg.FindMoreFriendsUI", "jump to url: " + paramf);
        return true;
        if ("ip_call_entrance".equals(paramPreference.mKey))
        {
          paramf = (IconPreference)paramf.add("ip_call_entrance");
          paramf.Gv(8);
          paramf.Gu(8);
          paramf.ne(false);
          paramf.Gy(8);
          au.Hx();
          paramf = (String)com.tencent.mm.model.c.Dz().get(ac.a.uqr, "");
          au.Hx();
          if (((Boolean)com.tencent.mm.model.c.Dz().get(ac.a.uqs, Boolean.valueOf(false))).booleanValue() != true) {
            break label2485;
          }
          com.tencent.mm.plugin.ipcall.a.e.i.M(1, -1, -1);
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqs, Boolean.valueOf(false));
        }
        for (int i = 1;; i = 0)
        {
          au.Hx();
          if (((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uqq, Integer.valueOf(0))).intValue() < com.tencent.mm.m.g.AA().getInt("WCOEntranceRedDot", 0))
          {
            com.tencent.mm.plugin.report.service.h.nFQ.f(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
            au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.uqq, Integer.valueOf(com.tencent.mm.m.g.AA().getInt("WCOEntranceRedDot", 0)));
            i = 1;
          }
          if (!bk.bl(paramf))
          {
            au.Hx();
            com.tencent.mm.model.c.Dz().c(ac.a.uqr, "");
          }
          if (i != 0) {
            com.tencent.mm.sdk.b.a.udP.m(new sj());
          }
          if (com.tencent.mm.r.a.Bv())
          {
            com.tencent.mm.ui.base.h.a(getContext(), R.l.multitalk_in_tip, 0, null, null);
            return true;
          }
          com.tencent.mm.plugin.report.service.h.nFQ.f(12061, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
          com.tencent.mm.br.d.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
          return true;
          if ("app_brand_entrance".equals(paramPreference.mKey))
          {
            ((com.tencent.mm.plugin.appbrand.r.f)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.f.class)).b(getContext(), 1, false);
            return true;
          }
          if ("find_friends_by_search".equals(paramPreference.mKey))
          {
            if (!aa.Br(0))
            {
              y.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
              return true;
            }
            paramf = ac.Ru("discoverSearchEntry").optString("wording");
            if (bk.bl(paramf))
            {
              y.e("MicroMsg.FindMoreFriendsUI", "empty title");
              return true;
            }
            paramPreference = an.bZJ();
            paramPreference.qUQ = new an.a();
            paramPreference.save();
            ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
            ao.i("", 0, 0, 20);
            paramPreference = aa.Bm(20);
            localObject = com.tencent.mm.plugin.webview.modeltools.g.ccI().cay();
            HashMap localHashMap = new HashMap();
            localHashMap.put("sessionId", paramPreference);
            localHashMap.put("inputMarginTop", "32");
            localHashMap.put("inputMarginLeftRight", "24");
            localHashMap.put("inputHeight", "48");
            if ((localObject != null) && (!((String)localObject).isEmpty())) {
              localHashMap.put("educationTab", Uri.encode((String)localObject));
            }
            ((com.tencent.mm.plugin.websearch.api.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.websearch.api.j.class)).a(getContext(), 20, "", paramPreference, localHashMap, paramf);
            ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.boots.a.c.class)).oc(com.tencent.mm.plugin.boots.a.b.hXL);
            return true;
          }
          if ("find_friends_by_look".equals(paramPreference.mKey))
          {
            if (!aa.Br(1))
            {
              y.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
              return true;
            }
            paramf = ac.Ru("discoverRecommendEntry").optString("wording");
            if (bk.bl(paramf))
            {
              y.e("MicroMsg.FindMoreFriendsUI", "empty query");
              return true;
            }
            y.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
            com.tencent.mm.plugin.topstory.ui.d.L(getContext(), 21);
            ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
            paramPreference = new lc();
            paramPreference.bUc.scene = 0;
            com.tencent.mm.sdk.b.a.udP.m(paramPreference);
            ao.aT(21, paramf);
            ao.reportIdKey649ForLook(21, 0);
            if (aa.Bs(1) > aa.Bq(1))
            {
              ao.reportIdKey649ForLook(21, 15);
              return true;
            }
            ao.reportIdKey649ForLook(21, 14);
            return true;
          }
          return false;
        }
      }
      label2495:
      bool1 = true;
      break label326;
      label2501:
      bool2 = true;
    }
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    if ((com.tencent.mm.sdk.platformtools.d.IS_FLAVOR_RED) && ("app_brand_entrance".equals(paramPreference.mKey)))
    {
      ((com.tencent.mm.plugin.appbrand.r.f)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.appbrand.r.f.class)).b(getContext(), 1, true);
      return true;
    }
    return super.a(paramf, paramPreference, paramView);
  }
  
  protected final void cxD()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab create");
    this.uIJ = ((com.tencent.mm.ui.base.preference.h)this.vdd);
    this.status = com.tencent.mm.model.q.Gn();
    this.nUJ = com.tencent.mm.model.q.Gu();
    this.iKA = com.tencent.mm.model.q.Go();
    View localView = getView().getRootView().findViewById(R.h.launcher_ui_bottom_tabview);
    int i = com.tencent.mm.compatible.util.a.bh(getContext());
    getView().setPadding(0, i, 0, localView.getHeight());
    y.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
  }
  
  protected final void cxE()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
    this.bPr = true;
    cyx();
    com.tencent.mm.pluginsdk.c.a.a(iv.class.getName(), this.sij);
    com.tencent.mm.pluginsdk.c.a.a(gv.class.getName(), this.uJd);
    com.tencent.mm.pluginsdk.c.a.a(pp.class.getName(), this.uJe);
    com.tencent.mm.sdk.b.a.udP.c(this.uJb);
    com.tencent.mm.sdk.b.a.udP.c(this.uJa);
    com.tencent.mm.sdk.b.a.udP.c(this.uJc);
    com.tencent.mm.sdk.b.a.udP.c(this.osA);
    com.tencent.mm.sdk.b.a.udP.c(this.uJf);
    com.tencent.mm.sdk.b.a.udP.b(this.kCl);
    com.tencent.mm.sdk.b.a.udP.c(this.uJg);
    com.tencent.mm.bh.d.Sa().c(this);
    au.Hx();
    com.tencent.mm.model.c.FB().a(this);
    au.Hx();
    com.tencent.mm.model.c.a(this);
    au.Hx();
    com.tencent.mm.model.c.Dz().a(this);
    if (n.omG != null) {
      n.omG.a(this);
    }
    View localView = findViewById(R.h.loading_tips_area);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      new ah(Looper.getMainLooper()).post(new h.14(this, localView));
    }
    if (isAdded()) {
      com.tencent.mm.blink.b.vG().k(new h.15(this));
    }
    y.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
  }
  
  protected final void cxF()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab start");
  }
  
  protected final void cxG()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
    this.bPr = false;
    cyx();
    if (au.DK())
    {
      com.tencent.mm.pluginsdk.c.a.b(iv.class.getName(), this.sij);
      com.tencent.mm.pluginsdk.c.a.b(gv.class.getName(), this.uJd);
      com.tencent.mm.pluginsdk.c.a.b(pp.class.getName(), this.uJe);
      com.tencent.mm.sdk.b.a.udP.d(this.uJb);
      com.tencent.mm.sdk.b.a.udP.d(this.uJa);
      com.tencent.mm.sdk.b.a.udP.d(this.uJc);
      com.tencent.mm.sdk.b.a.udP.d(this.osA);
      com.tencent.mm.sdk.b.a.udP.d(this.uJf);
      com.tencent.mm.sdk.b.a.udP.d(this.kCl);
      com.tencent.mm.sdk.b.a.udP.d(this.uJg);
      com.tencent.mm.bh.d.Sa().d(this);
      au.Hx();
      com.tencent.mm.model.c.FB().b(this);
      au.Hx();
      com.tencent.mm.model.c.b(this);
      au.Hx();
      com.tencent.mm.model.c.Dz().b(this);
      if (this.uIO != null) {
        o.OI().lV(this.uIO);
      }
      if (this.uIS != null) {
        o.OI().lV(this.uIS);
      }
    }
    if (n.omG != null) {
      n.omG.b(this);
    }
  }
  
  protected final void cxH()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
  }
  
  protected final void cxI()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
  }
  
  public final void cxK()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
  }
  
  public final void cxL()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
  }
  
  public final void cxN()
  {
    y.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
  }
  
  public final void cyr()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.aC(10958, "4");
    au.Hx();
    if (!bk.d((Boolean)com.tencent.mm.model.c.Dz().get(4103, null)))
    {
      com.tencent.mm.br.d.x(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
      return;
    }
    Object localObject = bn.Ie();
    if (localObject == null)
    {
      com.tencent.mm.br.d.x(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      return;
    }
    String str = bk.pm(((bn)localObject).getProvince());
    int i = bk.a(Integer.valueOf(((bn)localObject).sex), 0);
    if ((bk.bl(str)) || (i == 0))
    {
      com.tencent.mm.br.d.x(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      return;
    }
    au.Hx();
    localObject = (Boolean)com.tencent.mm.model.c.Dz().get(4104, null);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).uKP.uKi.acW("tab_find_friend");
      }
      com.tencent.mm.bp.a.eF(getContext());
      return;
    }
    if (this.uIK == null)
    {
      this.uIK = View.inflate(getContext(), R.i.lbs_open_dialog_view, null);
      this.mCR = ((CheckBox)this.uIK.findViewById(R.h.lbs_open_dialog_cb));
      this.mCR.setChecked(false);
    }
    if (this.mCT == null)
    {
      this.mCT = com.tencent.mm.ui.base.h.a(getContext(), getString(R.l.app_tip), this.uIK, new h.9(this), null);
      return;
    }
    this.mCT.show();
  }
  
  public final void cyy()
  {
    y.v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
    this.bPr = true;
    cyx();
    com.tencent.mm.blink.b.vG().k(new h.16(this));
    ac.BC(20);
  }
  
  public final void cyz()
  {
    y.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
    this.bPr = false;
    cyx();
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    y.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  public final int xj()
  {
    return R.o.find_more_friends;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.h
 * JD-Core Version:    0.7.0.1
 */