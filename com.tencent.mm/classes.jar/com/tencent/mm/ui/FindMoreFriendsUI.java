package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gz;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.g.a.ic.a;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.je;
import com.tencent.mm.g.a.lq;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.ng.a;
import com.tencent.mm.g.a.oo;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qh;
import com.tencent.mm.g.a.qw;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.qz.b;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.g.a.wa;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.game.api.b.a;
import com.tencent.mm.plugin.websearch.api.ac;
import com.tencent.mm.plugin.websearch.api.am.a;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.pluginsdk.p.b;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreferenceFragment;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FindMoreFriendsUI
  extends AbstractTabChildPreference
  implements ar, as, k.a, n.b
{
  private boolean cwK;
  private long kRf;
  private ak mHandler;
  private com.tencent.mm.sdk.b.c<wa> mYh;
  private CheckBox pcL;
  private com.tencent.mm.ui.widget.b.c pcN;
  private int qIO;
  com.tencent.mm.sdk.b.c rhr;
  private int status;
  private com.tencent.mm.pluginsdk.c.a waI;
  private com.tencent.mm.pluginsdk.c.a yWA;
  private com.tencent.mm.pluginsdk.c.a yWB;
  private com.tencent.mm.sdk.b.c yWC;
  private String yWD;
  private FindMoreFriendsUI.a yWE;
  private com.tencent.mm.plugin.messenger.foundation.a.o yWF;
  private com.tencent.mm.sdk.b.c<hp> yWG;
  com.tencent.mm.at.p.a yWH;
  private long yWi;
  private com.tencent.mm.ui.base.preference.h yWj;
  private View yWk;
  private String yWl;
  private int yWm;
  private String yWn;
  private String yWo;
  private String yWp;
  private String yWq;
  private boolean yWr;
  private boolean yWs;
  private boolean yWt;
  private int yWu;
  private View yWv;
  private TextView yWw;
  private com.tencent.mm.sdk.b.c<qf> yWx;
  com.tencent.mm.sdk.b.c yWy;
  com.tencent.mm.sdk.b.c yWz;
  
  public FindMoreFriendsUI()
  {
    AppMethodBeat.i(29251);
    this.pcN = null;
    this.yWl = "";
    this.yWm = 0;
    this.yWn = null;
    this.yWo = null;
    this.yWp = null;
    this.yWq = null;
    this.yWr = false;
    this.yWs = false;
    this.yWt = true;
    this.cwK = false;
    this.mHandler = new FindMoreFriendsUI.1(this, Looper.getMainLooper());
    this.yWx = new FindMoreFriendsUI.12(this);
    this.waI = new FindMoreFriendsUI.20(this);
    this.rhr = new FindMoreFriendsUI.21(this);
    this.yWy = new FindMoreFriendsUI.22(this);
    this.yWz = new FindMoreFriendsUI.23(this);
    this.yWA = new FindMoreFriendsUI.24(this);
    this.yWB = new FindMoreFriendsUI.25(this);
    this.yWC = new FindMoreFriendsUI.26(this);
    this.yWE = FindMoreFriendsUI.a.yWW;
    this.yWF = new FindMoreFriendsUI.2(this);
    this.mYh = new FindMoreFriendsUI.6(this);
    this.yWG = new FindMoreFriendsUI.7(this);
    this.yWH = new FindMoreFriendsUI.9(this);
    AppMethodBeat.o(29251);
  }
  
  private boolean Dc(int paramInt)
  {
    return (this.kRf & paramInt) != 0L;
  }
  
  /* Error */
  private void a(final ng paramng1, final IconPreference paramIconPreference, final ng paramng2, final String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: sipush 29265
    //   5: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   12: getfield 218	com/tencent/mm/g/a/ng$a:cDz	Ljava/lang/String;
    //   15: astore 7
    //   17: aload_1
    //   18: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   21: getfield 221	com/tencent/mm/g/a/ng$a:cDA	I
    //   24: istore 5
    //   26: aload_1
    //   27: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   30: getfield 224	com/tencent/mm/g/a/ng$a:cDB	I
    //   33: istore 6
    //   35: aload 7
    //   37: invokestatic 230	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   40: ifne +14 -> 54
    //   43: aload_2
    //   44: ifnull +10 -> 54
    //   47: aload_2
    //   48: invokevirtual 236	com/tencent/mm/ui/base/preference/IconPreference:dEK	()Landroid/widget/ImageView;
    //   51: ifnonnull +12 -> 63
    //   54: sipush 29265
    //   57: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: ldc 238
    //   65: ldc 240
    //   67: iconst_3
    //   68: anewarray 242	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload 7
    //   75: aastore
    //   76: dup
    //   77: iconst_1
    //   78: iload 5
    //   80: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: aastore
    //   84: dup
    //   85: iconst_2
    //   86: iload 6
    //   88: invokestatic 248	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   91: aastore
    //   92: invokestatic 253	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: iload 5
    //   97: ifle +28 -> 125
    //   100: iload 6
    //   102: ifle +23 -> 125
    //   105: aload_2
    //   106: invokestatic 259	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   109: iload 5
    //   111: invokestatic 265	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   114: invokestatic 259	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   117: iload 5
    //   119: invokestatic 265	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   122: invokevirtual 269	com/tencent/mm/ui/base/preference/IconPreference:hC	(II)V
    //   125: aload_3
    //   126: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   129: getfield 272	com/tencent/mm/g/a/ng$a:cDC	Ljava/lang/String;
    //   132: astore_1
    //   133: aload_3
    //   134: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   137: getfield 275	com/tencent/mm/g/a/ng$a:appId	Ljava/lang/String;
    //   140: astore 8
    //   142: aload_3
    //   143: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   146: getfield 278	com/tencent/mm/g/a/ng$a:msgType	I
    //   149: istore 5
    //   151: aload_3
    //   152: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   155: getfield 281	com/tencent/mm/g/a/ng$a:cnG	Ljava/lang/String;
    //   158: astore 9
    //   160: aload_3
    //   161: getfield 213	com/tencent/mm/g/a/ng:cDy	Lcom/tencent/mm/g/a/ng$a;
    //   164: getfield 284	com/tencent/mm/g/a/ng$a:showType	I
    //   167: istore 6
    //   169: new 286	com/tencent/mm/g/a/ha
    //   172: dup
    //   173: invokespecial 287	com/tencent/mm/g/a/ha:<init>	()V
    //   176: astore_3
    //   177: aload_3
    //   178: getfield 291	com/tencent/mm/g/a/ha:cvX	Lcom/tencent/mm/g/a/ha$a;
    //   181: iconst_1
    //   182: putfield 296	com/tencent/mm/g/a/ha$a:vA	I
    //   185: aload_3
    //   186: getfield 291	com/tencent/mm/g/a/ha:cvX	Lcom/tencent/mm/g/a/ha$a;
    //   189: aload 7
    //   191: putfield 299	com/tencent/mm/g/a/ha$a:url	Ljava/lang/String;
    //   194: getstatic 305	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   197: aload_3
    //   198: invokevirtual 309	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   201: pop
    //   202: aload_3
    //   203: getfield 313	com/tencent/mm/g/a/ha:cvY	Lcom/tencent/mm/g/a/ha$b;
    //   206: getfield 318	com/tencent/mm/g/a/ha$b:cwa	Z
    //   209: ifeq +109 -> 318
    //   212: new 320	java/lang/StringBuilder
    //   215: dup
    //   216: invokespecial 321	java/lang/StringBuilder:<init>	()V
    //   219: aload_3
    //   220: getfield 313	com/tencent/mm/g/a/ha:cvY	Lcom/tencent/mm/g/a/ha$b;
    //   223: getfield 324	com/tencent/mm/g/a/ha$b:cvZ	Ljava/lang/String;
    //   226: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload 7
    //   231: invokevirtual 334	java/lang/String:getBytes	()[B
    //   234: invokestatic 340	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   237: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: astore 10
    //   245: new 346	com/tencent/mm/at/a/a/c$a
    //   248: dup
    //   249: invokespecial 347	com/tencent/mm/at/a/a/c$a:<init>	()V
    //   252: astore 11
    //   254: aload 11
    //   256: iconst_1
    //   257: putfield 350	com/tencent/mm/at/a/a/c$a:eNM	Z
    //   260: aload 11
    //   262: aload 10
    //   264: putfield 353	com/tencent/mm/at/a/a/c$a:eNO	Ljava/lang/String;
    //   267: aload 11
    //   269: invokevirtual 357	com/tencent/mm/at/a/a/c$a:ahY	()Lcom/tencent/mm/at/a/a/c;
    //   272: astore 10
    //   274: invokestatic 363	com/tencent/mm/at/o:ahG	()Lcom/tencent/mm/at/a/a;
    //   277: aload 7
    //   279: aload_2
    //   280: invokevirtual 236	com/tencent/mm/ui/base/preference/IconPreference:dEK	()Landroid/widget/ImageView;
    //   283: aload 10
    //   285: new 16	com/tencent/mm/ui/FindMoreFriendsUI$14
    //   288: dup
    //   289: aload_0
    //   290: aload_3
    //   291: invokespecial 366	com/tencent/mm/ui/FindMoreFriendsUI$14:<init>	(Lcom/tencent/mm/ui/FindMoreFriendsUI;Lcom/tencent/mm/g/a/ha;)V
    //   294: new 18	com/tencent/mm/ui/FindMoreFriendsUI$15
    //   297: dup
    //   298: aload_0
    //   299: aload_3
    //   300: aload_2
    //   301: iload 6
    //   303: aload 8
    //   305: iload 5
    //   307: aload_1
    //   308: aload 9
    //   310: aload 4
    //   312: invokespecial 369	com/tencent/mm/ui/FindMoreFriendsUI$15:<init>	(Lcom/tencent/mm/ui/FindMoreFriendsUI;Lcom/tencent/mm/g/a/ha;Lcom/tencent/mm/ui/base/preference/IconPreference;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   315: invokevirtual 374	com/tencent/mm/at/a/a:a	(Ljava/lang/String;Landroid/widget/ImageView;Lcom/tencent/mm/at/a/a/c;Lcom/tencent/mm/at/a/c/i;Lcom/tencent/mm/at/a/c/g;)V
    //   318: sipush 29265
    //   321: invokestatic 191	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   324: goto -264 -> 60
    //   327: astore_1
    //   328: aload_0
    //   329: monitorexit
    //   330: aload_1
    //   331: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	this	FindMoreFriendsUI
    //   0	332	1	paramng1	ng
    //   0	332	2	paramIconPreference	IconPreference
    //   0	332	3	paramng2	ng
    //   0	332	4	paramString	String
    //   24	282	5	i	int
    //   33	269	6	j	int
    //   15	263	7	str1	String
    //   140	164	8	str2	String
    //   158	151	9	str3	String
    //   243	41	10	localObject	Object
    //   252	16	11	locala	com.tencent.mm.at.a.a.c.a
    // Exception table:
    //   from	to	target	type
    //   2	43	327	finally
    //   47	54	327	finally
    //   54	60	327	finally
    //   63	95	327	finally
    //   105	125	327	finally
    //   125	318	327	finally
    //   318	324	327	finally
  }
  
  private void a(am.a parama, IconPreference paramIconPreference)
  {
    AppMethodBeat.i(138177);
    com.tencent.mm.sdk.platformtools.al.d(new FindMoreFriendsUI.4(this, paramIconPreference, parama));
    AppMethodBeat.o(138177);
  }
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(29269);
    paramIconPreference.OL(paramInt1);
    paramIconPreference.ON(paramInt2);
    paramIconPreference.OM(paramInt3);
    paramIconPreference.qI(paramBoolean);
    paramIconPreference.OQ(paramInt4);
    paramIconPreference.OP(paramInt5);
    paramIconPreference.OR(paramInt6);
    AppMethodBeat.o(29269);
  }
  
  private static void a(IconPreference paramIconPreference, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(29255);
    paramIconPreference.ON(paramInt1);
    paramIconPreference.OM(paramInt2);
    paramIconPreference.qI(paramBoolean);
    paramIconPreference.OQ(paramInt3);
    paramIconPreference.OP(paramInt4);
    paramIconPreference.OR(paramInt5);
    AppMethodBeat.o(29255);
  }
  
  private void aMi()
  {
    AppMethodBeat.i(29257);
    this.yWu = 0;
    this.yWi = System.currentTimeMillis();
    if (this.yWv != null) {
      this.yWv.setVisibility(8);
    }
    if ((!this.zrV) || (!isAdded()))
    {
      AppMethodBeat.o(29257);
      return;
    }
    ab.i("MicroMsg.FindMoreFriendsUI", "status %d (%d), extStatus %d (%d), pluginFlag %d (%d)", new Object[] { Integer.valueOf(this.status), Integer.valueOf(r.Zr()), Long.valueOf(this.kRf), Long.valueOf(r.Zs()), Integer.valueOf(this.qIO), Integer.valueOf(r.Zy()) });
    dBx();
    boolean bool2 = Dc(1048576);
    boolean bool3 = com.tencent.mm.bq.d.ahR("scanner");
    label216:
    label242:
    Object localObject1;
    if (!bool2)
    {
      bool1 = true;
      ab.i("MicroMsg.FindMoreFriendsUI", "openScan %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break label1418;
      }
      this.yWj.cl("find_friends_by_qrcode", true);
      if (!dBr()) {
        com.tencent.mm.plugin.report.service.h.qsU.j(953L, 1L, 1L);
      }
      dBy();
      dBz();
      dBA();
      bool2 = Dc(4194304);
      if (bool2) {
        break label1494;
      }
      bool1 = true;
      ab.i("MicroMsg.FindMoreFriendsUI", "openShoppingEntry %s", new Object[] { Boolean.valueOf(bool1) });
      if (bool2) {
        break label1499;
      }
      qf(false);
      label270:
      localObject1 = b.a.bEX();
      if (localObject1 == null) {
        break label2037;
      }
      getContext();
    }
    label309:
    label369:
    label1140:
    label2037:
    for (boolean bool1 = ((com.tencent.mm.plugin.game.api.b)localObject1).bEM();; bool1 = false)
    {
      bool3 = Dc(8388608);
      label507:
      Object localObject2;
      if (!bool3)
      {
        bool2 = true;
        ab.i("MicroMsg.FindMoreFriendsUI", "shouldShowGame %s, openGameEntry %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!bool1) || (bool3)) {
          break label1538;
        }
        this.yWj.cl("more_tab_game_recommend", false);
        dBw();
        this.yWu += 1;
        localObject1 = new qz();
        ((qz)localObject1).cHs.cHu = true;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        bool2 = ((qz)localObject1).cHt.cHv;
        bool3 = Dc(16777216);
        if (bool3) {
          break label1572;
        }
        bool1 = true;
        ab.i("MicroMsg.FindMoreFriendsUI", "shouldShowMiniProgram %s, openMiniProgramEntry %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((bool2) && (!bool3)) {
          break label1577;
        }
        this.yWj.cl("app_brand_entrance", true);
        if (!dBr()) {
          com.tencent.mm.plugin.report.service.h.qsU.j(953L, 9L, 1L);
        }
        bool2 = com.tencent.mm.plugin.ipcall.d.bIT();
        bool3 = Dc(33554432);
        if (bool3) {
          break label1695;
        }
        bool1 = true;
        ab.i("MicroMsg.FindMoreFriendsUI", "showShowWeChatOut %s, openWeChatOutEntry %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
        if ((!bool2) || (bool3)) {
          break label1731;
        }
        this.yWu += 1;
        this.yWj.cl("ip_call_entrance", false);
        localObject1 = (IconPreference)this.yWj.atx("ip_call_entrance");
        aw.aaz();
        if (((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yAq, Integer.valueOf(0))).intValue() >= com.tencent.mm.m.g.Nq().getInt("WCOEntranceRedDot", 0)) {
          break label1700;
        }
        ((IconPreference)localObject1).OL(0);
        ((IconPreference)localObject1).eN(getString(2131297012), 2130839787);
        label635:
        ((IconPreference)localObject1).OQ(8);
        aw.aaz();
        if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAs, Boolean.FALSE)).booleanValue() != true) {
          break label1710;
        }
        ((IconPreference)localObject1).qI(true);
        ((IconPreference)localObject1).OL(8);
        i = 1;
        aw.aaz();
        localObject2 = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAr, "");
        ((IconPreference)localObject1).aG((String)localObject2, -1, -7566196);
        if (!bo.isNullOrNil((String)localObject2)) {
          i = 1;
        }
        if (i == 0) {
          break label1721;
        }
        ((IconPreference)localObject1).OM(0);
        localObject1 = new PreferenceSmallCategory(getContext());
        this.yWj.a((Preference)localObject1, -1);
        label757:
        dBs();
        bool1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).ajx("labs_nearbylife");
        ab.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isInExperiment: ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label2032;
        }
        bool1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).yi("labs_nearbylife");
        ab.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance isOpen: ".concat(String.valueOf(bool1)));
        if (!bool1) {
          break label2032;
        }
      }
      for (int i = 1;; i = 0)
      {
        Object localObject3;
        if (i != 0)
        {
          i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lWf, 0);
          ab.d("MicroMsg.FindMoreFriendsUI", "life around preload, preload: %d.", new Object[] { Integer.valueOf(i) });
          if (1 == i)
          {
            ((com.tencent.mm.plugin.appbrand.service.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.d.class)).aut();
            localObject1 = (IconPreference)this.yWj.atx("my_life_around");
            ((IconPreference)localObject1).setTitle(getString(2131296328));
            this.yWu += 1;
            bool1 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKR, Boolean.TRUE)).booleanValue();
            ab.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance showNewRedDot %s.", new Object[] { Boolean.valueOf(bool1) });
            if (bool1)
            {
              this.yWE = FindMoreFriendsUI.a.yXb;
              ((IconPreference)localObject1).OL(0);
              ((IconPreference)localObject1).eN(getString(2131297012), 2130839787);
            }
            bool1 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKQ, Boolean.FALSE)).booleanValue();
            ab.i("MicroMsg.FindMoreFriendsUI", "updateMyLifeAroundEntrance showRedDot %s.", new Object[] { Boolean.valueOf(bool1) });
            if (!bool1) {
              break label1988;
            }
            localObject3 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKT, "");
            localObject2 = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKU, "");
            iw((String)localObject3, (String)localObject2);
            switch (FindMoreFriendsUI.19.yWU[this.yWE.ordinal()])
            {
            default: 
              this.yWj.cl("my_life_around", false);
              com.tencent.mm.plugin.report.service.h.qsU.e(17065, new Object[] { Integer.valueOf(0), Long.valueOf(bo.aox()), Integer.valueOf(this.yWE.ordinal()), com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKU, ""), com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKT, ""), com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKS, "0") });
              com.tencent.mm.au.b.aif();
              this.yWj.cl("find_friends_by_facebook", true);
              this.yWj.cl("settings_emoji_store", true);
              if (this.yWu == 0)
              {
                localObject1 = (ViewGroup)findViewById(16908298).getParent();
                if (this.yWv != null) {
                  break label2021;
                }
                this.yWv = getContext().getLayoutInflater().inflate(2130969591, null);
                this.yWw = ((TextView)this.yWv.findViewById(2131824154));
                this.yWw.setOnClickListener(new FindMoreFriendsUI.8(this));
                localObject2 = new RelativeLayout.LayoutParams(-1, -1);
                ((ViewGroup)localObject1).addView(this.yWv, (ViewGroup.LayoutParams)localObject2);
              }
              break;
            }
          }
        }
        for (;;)
        {
          this.yWj.notifyDataSetChanged();
          if (!dBr()) {
            com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yLn, Long.valueOf(this.yWi));
          }
          AppMethodBeat.o(29257);
          return;
          bool1 = false;
          break;
          this.yWj.cl("find_friends_by_qrcode", false);
          this.yWu += 1;
          if (com.tencent.mm.x.c.PJ().b(ac.a.yKC, ac.a.yKB))
          {
            ((NormalIconPreference)this.yWj.atx("find_friends_by_qrcode")).ON(0);
            break label216;
          }
          ((NormalIconPreference)this.yWj.atx("find_friends_by_qrcode")).ON(4);
          break label216;
          bool1 = false;
          break label242;
          this.yWj.cl("jd_market_entrance", true);
          if (dBr()) {
            break label270;
          }
          com.tencent.mm.plugin.report.service.h.qsU.j(953L, 7L, 1L);
          break label270;
          bool2 = false;
          break label309;
          this.yWj.cl("more_tab_game_recommend", true);
          if (dBr()) {
            break label369;
          }
          com.tencent.mm.plugin.report.service.h.qsU.j(953L, 8L, 1L);
          break label369;
          bool1 = false;
          break label421;
          ((com.tencent.mm.plugin.appbrand.service.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.d.class)).auu();
          this.yWu += 1;
          this.yWj.cl("app_brand_entrance", false);
          localObject2 = (IconPreference)this.yWj.atx("app_brand_entrance");
          if (((qz)localObject1).cHt.cHx)
          {
            i = 0;
            ((IconPreference)localObject2).OL(i);
            ((IconPreference)localObject2).eN(getString(2131297012), 2130839787);
            if (!((qz)localObject1).cHt.cHw) {
              break label1689;
            }
          }
          for (i = 0;; i = 8)
          {
            ((IconPreference)localObject2).ON(i);
            break;
            i = 8;
            break label1640;
          }
          bool1 = false;
          break label507;
          ((IconPreference)localObject1).OL(8);
          break label635;
          ((IconPreference)localObject1).qI(false);
          i = 0;
          break label683;
          ((IconPreference)localObject1).OM(8);
          break label734;
          this.yWj.cl("ip_call_entrance", true);
          break label757;
          if (2 != i) {
            break label898;
          }
          ((com.tencent.mm.plugin.appbrand.service.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.d.class)).aut();
          break label898;
          com.tencent.mm.at.o.ahB();
          Bitmap localBitmap = com.tencent.mm.at.c.lK((String)localObject2);
          if (localBitmap != null)
          {
            this.yWD = null;
            ((IconPreference)localObject1).ap(com.tencent.mm.sdk.platformtools.d.a(localBitmap, false, localBitmap.getWidth() * 0.1F));
          }
          for (;;)
          {
            ((IconPreference)localObject1).aG((String)localObject3, -1, Color.parseColor("#8c8c8c"));
            a((IconPreference)localObject1, 8, 0, false, 0, 0, 0);
            break;
            this.yWD = ((String)localObject2);
            com.tencent.mm.at.o.ahF().a((String)localObject2, this.yWH);
          }
          com.tencent.mm.at.o.ahB();
          localObject3 = com.tencent.mm.at.c.lK((String)localObject2);
          if (localObject3 != null)
          {
            this.yWD = null;
            ((IconPreference)localObject1).ap(com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject3, false, ((Bitmap)localObject3).getWidth() * 0.1F));
          }
          for (;;)
          {
            a((IconPreference)localObject1, 8, 8, false, 0, 0, 0);
            break;
            this.yWD = ((String)localObject2);
            com.tencent.mm.at.o.ahF().a((String)localObject2, this.yWH);
          }
          ((IconPreference)localObject1).aG((String)localObject3, -1, Color.parseColor("#8c8c8c"));
          a((IconPreference)localObject1, 8, 0, true, 8, 8, 8);
          break label1140;
          a((IconPreference)localObject1, 0, 8, false, 8, 8, 8);
          break label1140;
          a((IconPreference)localObject1, 8, 8, false, 8, 8, 8);
          break label1140;
          this.yWj.cl("my_life_around", true);
          break label1246;
          this.yWv.setVisibility(0);
        }
      }
    }
  }
  
  private static void b(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    AppMethodBeat.i(29266);
    com.tencent.mm.kernel.g.RM();
    Object localObject = (String)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yIz, "");
    if ((paramString2 != null) && (!paramString2.equals(localObject)))
    {
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yIz, paramString2);
      localObject = new oq();
      ((oq)localObject).cFi.scene = 9;
      ((oq)localObject).cFi.cFj = 901;
      ((oq)localObject).cFi.action = 1;
      ((oq)localObject).cFi.appId = paramString1;
      ((oq)localObject).cFi.msgType = paramInt1;
      ((oq)localObject).cFi.cDC = paramString2;
      ((oq)localObject).cFi.cnG = paramString3;
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
          ((oq)localObject).cFi.cFk = paramString1;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 2L, 1L, false);
          AppMethodBeat.o(29266);
          return;
          paramString2 = paramString2;
          ab.e("MicroMsg.FindMoreFriendsUI", paramString2.getMessage());
        }
      }
      catch (UnsupportedEncodingException paramString2)
      {
        for (;;)
        {
          paramString1 = "";
          ab.e("MicroMsg.FindMoreFriendsUI", paramString2.getMessage());
        }
      }
    }
  }
  
  private void dBA()
  {
    AppMethodBeat.i(29277);
    if ((this.qIO & 0x200) == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = com.tencent.mm.bq.d.ahR("nearby");
      ab.i("MicroMsg.FindMoreFriendsUI", "openNearby %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        break;
      }
      this.yWj.cl("find_friends_by_near", true);
      if (!dBr()) {
        com.tencent.mm.plugin.report.service.h.qsU.j(953L, 5L, 1L);
      }
      AppMethodBeat.o(29277);
      return;
    }
    this.yWu += 1;
    this.yWj.cl("find_friends_by_near", false);
    IconPreference localIconPreference = (IconPreference)this.yWj.atx("find_friends_by_near");
    if (localIconPreference != null)
    {
      if (com.tencent.mm.app.plugin.b.Cb()) {
        localIconPreference.OP(8);
      }
      int i;
      for (;;)
      {
        i = com.tencent.mm.bi.d.alj().bbZ();
        if (!com.tencent.mm.bo.a.dkM()) {
          break label227;
        }
        if (i <= 0) {
          break;
        }
        localIconPreference.ON(0);
        AppMethodBeat.o(29277);
        return;
        localIconPreference.OP(0);
        localIconPreference.OO(2130839653);
        localIconPreference.hC(-2, -2);
      }
      localIconPreference.ON(8);
      AppMethodBeat.o(29277);
      return;
      label227:
      if (i > 0)
      {
        localIconPreference.OL(0);
        localIconPreference.eN(String.valueOf(i), com.tencent.mm.ui.tools.t.iF(getContext()));
        AppMethodBeat.o(29277);
        return;
      }
      localIconPreference.OL(8);
      localIconPreference.eN("", -1);
    }
    AppMethodBeat.o(29277);
  }
  
  private void dBB()
  {
    AppMethodBeat.i(29278);
    qh localqh = new qh();
    localqh.cGV.cwK = this.cwK;
    com.tencent.mm.sdk.b.a.ymk.l(localqh);
    AppMethodBeat.o(29278);
  }
  
  private boolean dBr()
  {
    AppMethodBeat.i(29252);
    if (bo.N(com.tencent.mm.kernel.g.RL().Ru().a(ac.a.yLn, 0L), this.yWi))
    {
      AppMethodBeat.o(29252);
      return true;
    }
    AppMethodBeat.o(29252);
    return false;
  }
  
  private void dBs()
  {
    boolean bool = true;
    AppMethodBeat.i(29253);
    ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility");
    if ((!this.zrV) || (!isAdded()))
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility preference not add");
      AppMethodBeat.o(29253);
      return;
    }
    label287:
    for (;;)
    {
      IconPreference localIconPreference;
      try
      {
        Object localObject = ac.agv("discoverRecommendEntry");
        if (!Dc(67108864))
        {
          if (!com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null))) {
            break label287;
          }
          ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility EuropeanUnionCountry");
          bool = false;
          ab.i("MicroMsg.FindMoreFriendsUI", "showLookEntry %s", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label249;
          }
          localObject = ((JSONObject)localObject).optString("wording");
          localIconPreference = (IconPreference)this.yWj.atx("find_friends_by_look");
          if (!bo.isNullOrNil((String)localObject)) {
            break label241;
          }
          localIconPreference.setTitle(getString(2131299915));
          this.yWu += 1;
          this.yWj.cl("find_friends_by_look", false);
          com.tencent.mm.sdk.platformtools.al.d(new FindMoreFriendsUI.3(this, localIconPreference));
          ((com.tencent.mm.plugin.topstory.ui.b)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.topstory.ui.b.class)).tryToCreateTopStoryWebView();
          AppMethodBeat.o(29253);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.FindMoreFriendsUI", bo.l(localException));
        AppMethodBeat.o(29253);
        return;
      }
      ab.i("MicroMsg.FindMoreFriendsUI", "checkLookVisibility in experiment but not open");
      bool = false;
      continue;
      label241:
      localIconPreference.setTitle(localException);
      continue;
      label249:
      this.yWj.cl("find_friends_by_look", true);
      if (!dBr()) {
        com.tencent.mm.plugin.report.service.h.qsU.j(953L, 3L, 1L);
      }
      AppMethodBeat.o(29253);
      return;
    }
  }
  
  private static int dBt()
  {
    AppMethodBeat.i(29259);
    int j = 1;
    int i = j;
    com.tencent.mm.plugin.subapp.jdbiz.c localc;
    if (com.tencent.mm.pluginsdk.f.f.vMG != null)
    {
      localc = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGJ();
      com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
      i = j;
      if (com.tencent.mm.plugin.subapp.jdbiz.d.cGF())
      {
        i = j;
        if (localc.isStart())
        {
          i = j;
          if (!localc.bzK())
          {
            if ((!"3".equals(localc.sWA)) || (bo.isNullOrNil(localc.jumpUrl))) {
              break label87;
            }
            i = 6;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29259);
      return i;
      label87:
      if (!bo.isNullOrNil(localc.sWE))
      {
        i = 3;
      }
      else
      {
        i = j;
        if (localc.sWD) {
          i = 2;
        }
      }
    }
  }
  
  private void dBv()
  {
    AppMethodBeat.i(29263);
    if (this.yWk == null)
    {
      this.yWk = View.inflate(getContext(), 2130969978, null);
      this.pcL = ((CheckBox)this.yWk.findViewById(2131825412));
      this.pcL.setChecked(false);
    }
    if (this.pcN == null)
    {
      this.pcN = com.tencent.mm.ui.base.h.a(getContext(), getString(2131297087), this.yWk, new FindMoreFriendsUI.11(this), null);
      AppMethodBeat.o(29263);
      return;
    }
    this.pcN.show();
    AppMethodBeat.o(29263);
  }
  
  private void dBw()
  {
    AppMethodBeat.i(29264);
    if ((IconPreference)this.yWj.atx("more_tab_game_recommend") == null)
    {
      AppMethodBeat.o(29264);
      return;
    }
    com.tencent.mm.sdk.g.d.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29225);
        ng localng = new ng();
        com.tencent.mm.sdk.b.a.ymk.l(localng);
        com.tencent.mm.sdk.platformtools.al.d(new FindMoreFriendsUI.13.1(this, localng));
        AppMethodBeat.o(29225);
      }
    }, "updateGame");
    AppMethodBeat.o(29264);
  }
  
  private void dBx()
  {
    AppMethodBeat.i(29275);
    boolean bool2;
    if ((this.qIO & 0x8000) == 0)
    {
      bool1 = true;
      bool2 = com.tencent.mm.bq.d.ahR("sns");
      ab.i("MicroMsg.FindMoreFriendsUI", "openSns %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if (!bool1)
      {
        if (com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yLm, 0) != 1) {
          break label141;
        }
        ab.w("MicroMsg.FindMoreFriendsUI", "opened sns entry recently");
        com.tencent.mm.plugin.report.service.h.qsU.cT(150, 71);
      }
    }
    for (;;)
    {
      if ((bool1) && (bool2)) {
        break label180;
      }
      this.yWj.cl("album_dyna_photo_ui_title", true);
      if (!dBr()) {
        com.tencent.mm.plugin.report.service.h.qsU.j(953L, 0L, 1L);
      }
      AppMethodBeat.o(29275);
      return;
      bool1 = false;
      break;
      label141:
      if (com.tencent.mm.kernel.g.RL().Ru().getInt(ac.a.yLm, 0) == -1)
      {
        ab.i("MicroMsg.FindMoreFriendsUI", "closed sns entry recently");
        com.tencent.mm.plugin.report.service.h.qsU.cT(150, 70);
      }
    }
    label180:
    this.yWu += 1;
    this.yWj.cl("album_dyna_photo_ui_title", false);
    FriendSnsPreference localFriendSnsPreference = (FriendSnsPreference)this.yWj.atx("album_dyna_photo_ui_title");
    localFriendSnsPreference.drawable = com.tencent.mm.cb.a.k(getContext(), 2131231497);
    aw.aaz();
    boolean bool1 = bo.e((Boolean)com.tencent.mm.model.c.Ru().get(48, null));
    localFriendSnsPreference.OL(8);
    localFriendSnsPreference.OR(8);
    if (bool1)
    {
      localFriendSnsPreference.OL(0);
      localFriendSnsPreference.eN(getString(2131297012), 2130839787);
    }
    aw.aaz();
    this.yWl = ((String)com.tencent.mm.model.c.Ru().get(68377, null));
    if ((!bo.isNullOrNil(this.yWl)) && (LauncherUI.dCf() == 2))
    {
      aw.aaz();
      if (com.tencent.mm.model.c.Ru().getInt(68419, 0) == 0)
      {
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.plugin.sns.i.f.l(2, (String)com.tencent.mm.kernel.g.RL().Ru().get(68418, ""), this.yWm);
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(68419, Integer.valueOf(1));
      }
    }
    Object localObject = com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKn, null);
    long l;
    int i;
    if (localObject == null)
    {
      l = 0L;
      ab.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", new Object[] { bo.bf(this.yWl, "") });
      localFriendSnsPreference.OQ(0);
      if (bo.isNullOrNil(this.yWl)) {
        break label615;
      }
      localFriendSnsPreference.OP(0);
      aw.aaz();
      if (!bo.a((Boolean)com.tencent.mm.model.c.Ru().get(68384, null), true)) {
        break label609;
      }
      i = 0;
      label486:
      localFriendSnsPreference.OR(i);
      localFriendSnsPreference.atm(this.yWl);
    }
    for (;;)
    {
      if (com.tencent.mm.plugin.sns.b.n.raS != null) {
        this.yWm = com.tencent.mm.plugin.sns.b.n.raS.bbZ();
      }
      if (this.yWm != 0)
      {
        localFriendSnsPreference.OL(0);
        localFriendSnsPreference.eN(this.yWm, com.tencent.mm.ui.tools.t.iF(getContext()));
      }
      localFriendSnsPreference.ON(8);
      localFriendSnsPreference.OM(8);
      com.tencent.mm.sdk.b.a.ymk.l(new ub());
      AppMethodBeat.o(29275);
      return;
      l = ((Long)localObject).longValue();
      break;
      label609:
      i = 8;
      break label486;
      label615:
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(589825, Boolean.FALSE)).booleanValue())
      {
        localFriendSnsPreference.OO(2131231762);
        localFriendSnsPreference.OP(0);
        localFriendSnsPreference.OR(8);
      }
      else if ((l != 0L) && (((com.tencent.mm.plugin.sns.b.m)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.sns.b.m.class)).lh(l)))
      {
        localFriendSnsPreference.OP(0);
        localFriendSnsPreference.OR(0);
        localFriendSnsPreference.ou(l);
      }
      else
      {
        localFriendSnsPreference.OP(8);
      }
    }
  }
  
  private void dBy()
  {
    AppMethodBeat.i(29276);
    if ((this.qIO & 0x100) == 0) {}
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = com.tencent.mm.bq.d.ahR("shake");
      ab.i("MicroMsg.FindMoreFriendsUI", "openShake %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) && (bool2)) {
        break;
      }
      this.yWj.cl("find_friends_by_shake", true);
      if (!dBr()) {
        com.tencent.mm.plugin.report.service.h.qsU.j(953L, 2L, 1L);
      }
      AppMethodBeat.o(29276);
      return;
    }
    this.yWu += 1;
    this.yWj.cl("find_friends_by_shake", false);
    IconPreference localIconPreference = (IconPreference)this.yWj.atx("find_friends_by_shake");
    int i = com.tencent.mm.bi.d.alk().bbZ() + com.tencent.mm.pluginsdk.p.a.dkR().clg();
    if (i > 0)
    {
      localIconPreference.OL(0);
      localIconPreference.eN(String.valueOf(i), 2130840638);
      localIconPreference.OP(8);
      com.tencent.mm.pluginsdk.p.a.dkR().clh();
      if (!com.tencent.mm.pluginsdk.p.a.dkR().cli()) {
        break label561;
      }
    }
    label516:
    label547:
    label561:
    for (bool1 = com.tencent.mm.x.c.PJ().cd(262154, 266258);; bool1 = false)
    {
      Object localObject;
      if (bool1)
      {
        aw.aaz();
        localObject = (String)com.tencent.mm.model.c.Ru().get(ac.a.yxG, "");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localIconPreference.ON(8);
          localIconPreference.OL(0);
          localIconPreference.eN(String.valueOf(localObject), 2130840638);
        }
      }
      int j;
      for (;;)
      {
        aw.aaz();
        localObject = bo.bf((String)com.tencent.mm.model.c.Ru().get(ac.a.yBb, null), "");
        aw.aaz();
        bool2 = bo.a((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBd, null), false);
        aw.aaz();
        j = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yAZ, Integer.valueOf(0))).intValue();
        if ((!Boolean.valueOf(bool2).booleanValue()) || (localObject == null) || (((String)localObject).equals("")) || (i > 0) || (bool1)) {
          break label547;
        }
        if (j != 0) {
          break label516;
        }
        localIconPreference.ON(8);
        localIconPreference.OM(0);
        localObject = ((String)localObject).split(",");
        if (localObject.length > 0) {
          localIconPreference.aG(localObject[0], -1, Color.parseColor("#8c8c8c"));
        }
        localIconPreference.qI(true);
        localIconPreference.OQ(8);
        AppMethodBeat.o(29276);
        return;
        localIconPreference.OL(8);
        localIconPreference.eN("", -1);
        break;
        if (i > 0)
        {
          localIconPreference.ON(0);
        }
        else
        {
          localIconPreference.ON(0);
          localIconPreference.OL(8);
          localIconPreference.eN("", -1);
          continue;
          localIconPreference.ON(8);
        }
      }
      if (j == 1)
      {
        localIconPreference.OM(8);
        localIconPreference.OL(0);
        localIconPreference.zrf = true;
        AppMethodBeat.o(29276);
        return;
        localIconPreference.OM(8);
      }
      AppMethodBeat.o(29276);
      return;
    }
  }
  
  private void dBz()
  {
    AppMethodBeat.i(138178);
    boolean bool2 = Dc(2097152);
    boolean bool3 = com.tencent.mm.bq.d.ahR("search");
    if (!bool2) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "openSearch %s, plugin installed %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3) });
      if ((!bool2) && (bool3)) {
        break;
      }
      this.yWj.cl("find_friends_by_search", true);
      if (!dBr()) {
        com.tencent.mm.plugin.report.service.h.qsU.j(953L, 4L, 1L);
      }
      AppMethodBeat.o(138178);
      return;
    }
    this.yWu += 1;
    this.yWj.cl("find_friends_by_search", false);
    try
    {
      Object localObject = ac.agv("discoverSearchEntry");
      String str = ((JSONObject)localObject).optString("wording");
      ((JSONObject)localObject).optString("androidIcon");
      localObject = (IconPreference)this.yWj.atx("find_friends_by_search");
      if (bo.isNullOrNil(str)) {
        ((IconPreference)localObject).setTitle(getString(2131299919));
      }
      for (;;)
      {
        ((IconPreference)localObject).OL(8);
        a(com.tencent.mm.plugin.websearch.api.am.cZF().uKa, (IconPreference)localObject);
        if (LauncherUI.dCf() == 2) {
          com.tencent.mm.plugin.websearch.api.am.cZF().Jt(1);
        }
        com.tencent.mm.plugin.websearch.api.aa.cZq();
        AppMethodBeat.o(138178);
        return;
        ((IconPreference)localObject).setTitle(str);
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.FindMoreFriendsUI", localException, "update search entry exception!", new Object[0]);
      AppMethodBeat.o(138178);
    }
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(156099);
    int j = am.di(getContext());
    int i = am.K(getContext(), -1);
    View localView = getView().getRootView().findViewById(2131820956);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool = LauncherUI.getInstance().isInMultiWindowMode();; bool = false)
    {
      if (bool) {
        if (localView == null) {
          break label110;
        }
      }
      label110:
      for (i = localView.getTop();; i = 0)
      {
        ab.i("MicroMsg.FindMoreFriendsUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
        AppMethodBeat.o(156099);
        return i + j;
      }
    }
  }
  
  private boolean iw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29254);
    int i;
    int j;
    if (!bo.isNullOrNil(paramString1))
    {
      i = 1;
      if (bo.isNullOrNil(paramString2)) {
        break label90;
      }
      j = 1;
      label25:
      if ((i == 0) || (j == 0)) {
        break label96;
      }
      paramString1 = FindMoreFriendsUI.a.yXa;
    }
    for (;;)
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "new type: %s, now type: %s.", new Object[] { paramString1, this.yWE });
      if (paramString1.compareTo(this.yWE) < 0) {
        break label126;
      }
      this.yWE = paramString1;
      AppMethodBeat.o(29254);
      return true;
      i = 0;
      break;
      label90:
      j = 0;
      break label25;
      label96:
      if (j != 0) {
        paramString1 = FindMoreFriendsUI.a.yWZ;
      } else if (i != 0) {
        paramString1 = FindMoreFriendsUI.a.yWY;
      } else {
        paramString1 = FindMoreFriendsUI.a.yWX;
      }
    }
    label126:
    AppMethodBeat.o(29254);
    return false;
  }
  
  private String ix(String paramString1, String paramString2)
  {
    AppMethodBeat.i(29268);
    if (!bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(29268);
      return paramString1;
    }
    paramString1 = com.tencent.mm.pluginsdk.model.app.g.t(getContext(), paramString2);
    AppMethodBeat.o(29268);
    return paramString1;
  }
  
  private void qf(boolean paramBoolean)
  {
    AppMethodBeat.i(29258);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.pluginsdk.f.f.vMG != null) {
      if (com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGM())
      {
        this.yWu += 1;
        localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGJ();
        localObject2 = (IconPreference)this.yWj.atx("jd_market_entrance");
        com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
        ((IconPreference)localObject2).setTitle(com.tencent.mm.plugin.subapp.jdbiz.d.cGN());
        ((IconPreference)localObject2).OL(8);
        ((IconPreference)localObject2).ON(8);
        ((IconPreference)localObject2).OM(8);
        ((IconPreference)localObject2).qI(false);
        ((IconPreference)localObject2).OQ(8);
        com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
        if ((com.tencent.mm.plugin.subapp.jdbiz.d.cGF()) && (((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).isStart()) && (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).bzK()))
        {
          if (!bo.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWE))
          {
            ((IconPreference)localObject2).OL(8);
            ((IconPreference)localObject2).ON(8);
            ((IconPreference)localObject2).aG(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWE, -1, -7566196);
            ((IconPreference)localObject2).OM(0);
          }
          if (bo.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWF)) {
            break label352;
          }
          com.tencent.mm.at.o.ahB();
          Bitmap localBitmap = com.tencent.mm.at.c.lK(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWF);
          ((IconPreference)localObject2).OQ(0);
          ((IconPreference)localObject2).OP(0);
          ((IconPreference)localObject2).OR(0);
          ((IconPreference)localObject2).qI(false);
          if (localBitmap != null)
          {
            this.yWq = null;
            ((IconPreference)localObject2).ap(localBitmap);
          }
        }
        else
        {
          if (paramBoolean) {
            this.yWj.notifyDataSetChanged();
          }
          if (!dBr())
          {
            localObject2 = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGQ().username;
            localObject1 = localObject2;
            if (bo.isNullOrNil((String)localObject2)) {
              localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGP();
            }
            com.tencent.mm.plugin.report.service.h.qsU.cT(931, 12);
            com.tencent.mm.plugin.report.service.h.qsU.e(11178, new Object[] { localObject1, com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGJ().sWB, Integer.valueOf(dBt()) });
          }
        }
      }
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.yWj.cl("jd_market_entrance", paramBoolean);
      AppMethodBeat.o(29258);
      return;
      com.tencent.mm.at.o.ahF().a(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWF, this.yWH);
      this.yWq = ((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWF;
      break;
      label352:
      if (!bo.isNullOrNil(((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWE))
      {
        ((IconPreference)localObject2).qI(true);
        break;
      }
      if (!((com.tencent.mm.plugin.subapp.jdbiz.c)localObject1).sWD) {
        break;
      }
      ((IconPreference)localObject2).ON(0);
      ((IconPreference)localObject2).eN("", -1);
      ((IconPreference)localObject2).OL(8);
      break;
      com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
      localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.cGN();
      com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
      localObject2 = com.tencent.mm.plugin.subapp.jdbiz.d.cGO();
      if ((!dBr()) && (com.tencent.mm.sdk.platformtools.aa.dsD()))
      {
        if (bo.isNullOrNil((String)localObject1)) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(931, 2);
        }
        if (bo.isNullOrNil((String)localObject2)) {
          com.tencent.mm.plugin.report.service.h.qsU.cT(931, 4);
        }
      }
    }
  }
  
  private static void qg(boolean paramBoolean)
  {
    AppMethodBeat.i(29267);
    b.a.bEX().hY(paramBoolean);
    AppMethodBeat.o(29267);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    int i = 1;
    AppMethodBeat.i(29287);
    ab.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorageEx)");
    if (LauncherUI.dCf() == 2)
    {
      paramInt = 0;
      if (this.status != r.Zr())
      {
        this.status = r.Zr();
        paramInt = 1;
      }
      if (this.kRf != r.Zs())
      {
        this.kRf = r.Zs();
        paramInt = 1;
      }
      if (this.qIO == r.Zy()) {
        break label114;
      }
      this.qIO = r.Zy();
      paramInt = i;
    }
    label114:
    for (;;)
    {
      if (paramInt != 0) {
        aMi();
      }
      if ((paramn instanceof com.tencent.mm.storage.al)) {
        this.yWj.notifyDataSetChanged();
      }
      AppMethodBeat.o(29287);
      return;
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    int j = 1;
    AppMethodBeat.i(29286);
    ab.i("MicroMsg.FindMoreFriendsUI", "onNotifyChange(MStorage)");
    int i;
    if (LauncherUI.dCf() == 2)
    {
      i = 0;
      if (this.status != r.Zr())
      {
        this.status = r.Zr();
        i = 1;
      }
      if (this.kRf != r.Zs())
      {
        this.kRf = r.Zs();
        i = 1;
      }
      if (this.qIO == r.Zy()) {
        break label100;
      }
      this.qIO = r.Zy();
      i = j;
    }
    label100:
    for (;;)
    {
      if (i != 0) {
        aMi();
      }
      AppMethodBeat.o(29286);
      return;
    }
  }
  
  public final void aam()
  {
    AppMethodBeat.i(29270);
    if ((r.Zy() & 0x8000) != 0)
    {
      AppMethodBeat.o(29270);
      return;
    }
    this.yWm += 1;
    dBx();
    this.yWj.notifyDataSetChanged();
    AppMethodBeat.o(29270);
  }
  
  public final void aan()
  {
    AppMethodBeat.i(29271);
    if ((r.Zy() & 0x8000) != 0)
    {
      AppMethodBeat.o(29271);
      return;
    }
    dBx();
    this.yWj.notifyDataSetChanged();
    AppMethodBeat.o(29271);
  }
  
  public final void aao() {}
  
  public final void aap()
  {
    AppMethodBeat.i(29290);
    ab.i("MicroMsg.FindMoreFriendsUI", "notify comment change");
    if ((r.Zy() & 0x8000) != 0)
    {
      AppMethodBeat.o(29290);
      return;
    }
    if (com.tencent.mm.plugin.sns.b.n.raS != null) {
      this.yWm = com.tencent.mm.plugin.sns.b.n.raS.bbZ();
    }
    dBx();
    this.yWj.notifyDataSetChanged();
    AppMethodBeat.o(29290);
  }
  
  public final void aaq()
  {
    AppMethodBeat.i(29272);
    if (this.yWj == null)
    {
      AppMethodBeat.o(29272);
      return;
    }
    this.status = r.Zr();
    aMi();
    AppMethodBeat.o(29272);
  }
  
  protected final void dAA()
  {
    AppMethodBeat.i(29279);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().a("lifeappreddot", this.yWF);
    AppMethodBeat.o(29279);
  }
  
  protected final void dAB()
  {
    AppMethodBeat.i(29280);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
    this.cwK = false;
    dBB();
    if (aw.RG())
    {
      com.tencent.mm.pluginsdk.c.a.b(je.class.getName(), this.waI);
      com.tencent.mm.pluginsdk.c.a.b(gz.class.getName(), this.yWA);
      com.tencent.mm.pluginsdk.c.a.b(qw.class.getName(), this.yWB);
      com.tencent.mm.sdk.b.a.ymk.d(this.yWy);
      com.tencent.mm.sdk.b.a.ymk.d(this.yWx);
      com.tencent.mm.sdk.b.a.ymk.d(this.yWz);
      com.tencent.mm.sdk.b.a.ymk.d(this.rhr);
      com.tencent.mm.sdk.b.a.ymk.d(this.yWC);
      com.tencent.mm.sdk.b.a.ymk.d(this.mYh);
      com.tencent.mm.sdk.b.a.ymk.d(this.yWG);
      com.tencent.mm.bi.d.alk().remove(this);
      aw.aaz();
      com.tencent.mm.model.c.YF().b(this);
      aw.aaz();
      com.tencent.mm.model.c.b(this);
      aw.aaz();
      com.tencent.mm.model.c.Ru().b(this);
      if (this.yWq != null) {
        com.tencent.mm.at.o.ahB().sU(this.yWq);
      }
    }
    if (com.tencent.mm.plugin.sns.b.n.raU != null) {
      com.tencent.mm.plugin.sns.b.n.raU.b(this);
    }
    AppMethodBeat.o(29280);
  }
  
  protected final void dAC()
  {
    AppMethodBeat.i(29281);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    AppMethodBeat.o(29281);
  }
  
  protected final void dAD()
  {
    AppMethodBeat.i(29282);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    ((com.tencent.mm.plugin.messenger.foundation.a.p)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.messenger.foundation.a.p.class)).getSysCmdMsgExtension().b("lifeappreddot", this.yWF);
    AppMethodBeat.o(29282);
  }
  
  public final void dAF()
  {
    AppMethodBeat.i(29283);
    ab.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    AppMethodBeat.o(29283);
  }
  
  public final void dAG()
  {
    AppMethodBeat.i(29284);
    ab.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    AppMethodBeat.o(29284);
  }
  
  public final void dAI()
  {
    AppMethodBeat.i(29285);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    AppMethodBeat.o(29285);
  }
  
  protected final void dAy()
  {
    AppMethodBeat.i(29273);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab create");
    this.yWj = ((com.tencent.mm.ui.base.preference.h)this.adapter);
    this.status = r.Zr();
    this.qIO = r.Zy();
    this.kRf = r.Zs();
    View localView = getView().getRootView().findViewById(2131820634);
    int i = am.di(getContext());
    int j = am.K(getContext(), -1);
    FindMoreFriendsUI.5 local5 = new FindMoreFriendsUI.5(this, localView);
    if (j <= 0) {
      getView().post(local5);
    }
    for (;;)
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
      AppMethodBeat.o(29273);
      return;
      int k = getTopHeight();
      getView().setPadding(0, k, 0, localView.getHeight());
      ab.i("MicroMsg.FindMoreFriendsUI", "[trySetParentViewPadding] actionBarHeight:%s actionBarHeight:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
      getView().postDelayed(local5, 100L);
    }
  }
  
  protected final void dAz()
  {
    AppMethodBeat.i(29274);
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
    this.cwK = true;
    dBB();
    com.tencent.mm.pluginsdk.c.a.a(je.class.getName(), this.waI);
    com.tencent.mm.pluginsdk.c.a.a(gz.class.getName(), this.yWA);
    com.tencent.mm.pluginsdk.c.a.a(qw.class.getName(), this.yWB);
    com.tencent.mm.sdk.b.a.ymk.c(this.yWy);
    com.tencent.mm.sdk.b.a.ymk.c(this.yWx);
    com.tencent.mm.sdk.b.a.ymk.c(this.yWz);
    com.tencent.mm.sdk.b.a.ymk.c(this.rhr);
    com.tencent.mm.sdk.b.a.ymk.c(this.yWC);
    com.tencent.mm.sdk.b.a.ymk.b(this.mYh);
    com.tencent.mm.sdk.b.a.ymk.c(this.yWG);
    com.tencent.mm.bi.d.alk().add(this);
    aw.aaz();
    com.tencent.mm.model.c.YF().a(this);
    aw.aaz();
    com.tencent.mm.model.c.a(this);
    aw.aaz();
    com.tencent.mm.model.c.Ru().a(this);
    if (com.tencent.mm.plugin.sns.b.n.raU != null) {
      com.tencent.mm.plugin.sns.b.n.raU.a(this);
    }
    View localView = findViewById(2131828467);
    if ((localView != null) && (localView.getVisibility() != 8)) {
      new ak(Looper.getMainLooper()).post(new FindMoreFriendsUI.16(this, localView));
    }
    if (isAdded()) {
      com.tencent.mm.blink.b.HP().o(new FindMoreFriendsUI.17(this));
    }
    ab.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
    AppMethodBeat.o(29274);
  }
  
  public final void dBC()
  {
    AppMethodBeat.i(29288);
    ab.v("MicroMsg.FindMoreFriendsUI", "on tab switch in");
    this.cwK = true;
    dBB();
    com.tencent.mm.blink.b.HP().o(new FindMoreFriendsUI.18(this));
    ac.Jq(20);
    AppMethodBeat.o(29288);
  }
  
  public final void dBD()
  {
    AppMethodBeat.i(29289);
    ab.v("MicroMsg.FindMoreFriendsUI", "on tab switch out");
    this.cwK = false;
    dBB();
    AppMethodBeat.o(29289);
  }
  
  public final void dBu()
  {
    AppMethodBeat.i(29262);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(10958, "4");
    aw.aaz();
    if (!bo.e((Boolean)com.tencent.mm.model.c.Ru().get(4103, null)))
    {
      com.tencent.mm.bq.d.H(getContext(), "nearby", ".ui.NearbyFriendsIntroUI");
      AppMethodBeat.o(29262);
      return;
    }
    Object localObject = bp.abb();
    if (localObject == null)
    {
      com.tencent.mm.bq.d.H(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      AppMethodBeat.o(29262);
      return;
    }
    String str = bo.nullAsNil(((bp)localObject).getProvince());
    int i = bo.a(Integer.valueOf(((bp)localObject).dqC), 0);
    if ((bo.isNullOrNil(str)) || (i == 0))
    {
      com.tencent.mm.bq.d.H(getContext(), "nearby", ".ui.NearbyPersonalInfoUI");
      AppMethodBeat.o(29262);
      return;
    }
    aw.aaz();
    localObject = (Boolean)com.tencent.mm.model.c.Ru().get(4104, null);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      localObject = (LauncherUI)getContext();
      if (localObject != null) {
        ((LauncherUI)localObject).yYT.getMainTabUI().atp("tab_find_friend");
      }
      com.tencent.mm.bo.a.fF(getContext());
      AppMethodBeat.o(29262);
      return;
    }
    dBv();
    AppMethodBeat.o(29262);
  }
  
  public final int getResourceId()
  {
    return 2131165240;
  }
  
  public boolean noActionBar()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(29256);
    super.onActivityCreated(paramBundle);
    ab.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
    AppMethodBeat.o(29256);
  }
  
  public final boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference)
  {
    AppMethodBeat.i(29261);
    boolean bool1;
    if ("album_dyna_photo_ui_title".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.g.Cx(10);
      aw.aaz();
      this.yWl = ((String)com.tencent.mm.model.c.Ru().get(68377, null));
      paramf = new Intent();
      paramPreference = new com.tencent.mm.modelsns.b(701, 1);
      if (!bo.isNullOrNil(this.yWl))
      {
        bool1 = true;
        paramPreference.de(bool1);
        paramPreference.uv(this.yWm);
        paramf.putExtra("sns_timeline_NeedFirstLoadint", true);
        paramf.putExtra("is_from_find_more", true);
        if ((bo.isNullOrNil(this.yWl)) && (this.yWm <= 0)) {
          break label458;
        }
      }
      label458:
      for (bool1 = true;; bool1 = false)
      {
        paramf.putExtra("enter_by_red", bool1);
        aw.aaz();
        paramf.putExtra("is_sns_notify_open", bo.a((Boolean)com.tencent.mm.model.c.Ru().get(68384, null), true));
        paramf.putExtra("sns_unread_count", com.tencent.mm.plugin.sns.b.n.raS.bbZ());
        if (!bo.isNullOrNil(this.yWl))
        {
          aw.aaz();
          paramf.putExtra("new_feed_id", bo.bf((String)com.tencent.mm.model.c.Ru().get(68418, null), ""));
          aw.aaz();
          com.tencent.mm.plugin.sns.i.f.l(3, (String)com.tencent.mm.model.c.Ru().get(68418, ""), this.yWm);
        }
        paramPreference.b(paramf, "enter_log");
        paramPreference = new ic();
        com.tencent.mm.sdk.b.a.ymk.l(paramPreference);
        boolean bool2 = true;
        bool1 = true;
        if (!paramPreference.cxr.isResume)
        {
          if (!bo.isNullOrNil(this.yWl)) {
            bool1 = false;
          }
          bool2 = bool1;
          if (com.tencent.mm.plugin.sns.b.n.raS != null)
          {
            this.yWm = com.tencent.mm.plugin.sns.b.n.raS.bbZ();
            bool2 = bool1;
            if (this.yWm > 0) {
              bool2 = false;
            }
          }
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(68377, "");
        }
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(589825, Boolean.FALSE);
        paramf.putExtra("sns_resume_state", bool2);
        com.tencent.mm.bq.d.b(getContext(), "sns", ".ui.SnsTimeLineUI", paramf);
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10958, "1");
        new ak().postDelayed(new FindMoreFriendsUI.10(this), 500L);
        AppMethodBeat.o(29261);
        return true;
        bool1 = false;
        break;
      }
    }
    if ("find_friends_by_near".equals(paramPreference.mKey))
    {
      if (com.tencent.mm.au.b.tM((String)com.tencent.mm.kernel.g.RL().Ru().get(274436, null)))
      {
        if (!com.tencent.mm.pluginsdk.permission.b.o(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION"))
        {
          if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKH, Boolean.FALSE)).booleanValue()) {
            com.tencent.mm.plugin.account.a.b.a.b(thisActivity(), getString(2131306183, new Object[] { com.tencent.mm.sdk.platformtools.aa.dsG() }), 30764, true);
          }
          for (;;)
          {
            AppMethodBeat.o(29261);
            return true;
            com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66);
          }
        }
      }
      else
      {
        bool1 = com.tencent.mm.pluginsdk.permission.b.a(thisActivity(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null);
        ab.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", new Object[] { Boolean.valueOf(bool1) });
        if (!bool1)
        {
          AppMethodBeat.o(29261);
          return true;
        }
      }
      dBu();
      AppMethodBeat.o(29261);
      return true;
    }
    if ("find_friends_by_shake".equals(paramPreference.mKey))
    {
      if ((!this.yWr) && (r.ZU().booleanValue()))
      {
        paramf = (IconPreference)paramf.atx("find_friends_by_shake");
        if (paramf != null)
        {
          paramf.ON(8);
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(340231, Boolean.TRUE);
          aw.aaz();
          com.tencent.mm.model.c.Ru().dww();
          com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(232L, 4L, 1L, false);
        }
      }
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10958, "3");
      aw.aaz();
      paramf = bo.bf((String)com.tencent.mm.model.c.Ru().get(ac.a.yBb, null), "");
      aw.aaz();
      if ((bo.a((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yBd, null), false)) && (paramf != null) && (!paramf.equals(""))) {}
      for (paramf = Boolean.TRUE;; paramf = Boolean.FALSE)
      {
        if (paramf.booleanValue()) {
          com.tencent.mm.plugin.report.service.h.qsU.e(12653, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
        }
        com.tencent.mm.sdk.b.a.ymk.l(new oo());
        com.tencent.mm.bq.d.H(getContext(), "shake", ".ui.ShakeReportUI");
        AppMethodBeat.o(29261);
        return true;
      }
    }
    if ("find_friends_by_qrcode".equals(paramPreference.mKey))
    {
      com.tencent.mm.x.c.PJ().c(ac.a.yKC, ac.a.yKB);
      if (!com.tencent.mm.r.a.bN(getContext()))
      {
        getContext();
        if (!com.tencent.mm.bg.e.alb()) {}
      }
      else
      {
        AppMethodBeat.o(29261);
        return true;
      }
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10958, "2");
      paramf = new Intent();
      paramf.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
      paramf.putExtra("key_scan_entry_scene", 2);
      com.tencent.mm.plugin.report.service.h.qsU.e(11265, new Object[] { Integer.valueOf(2) });
      com.tencent.mm.bq.d.b(getContext(), "scanner", ".ui.BaseScanUI", paramf);
      AppMethodBeat.o(29261);
      return true;
    }
    Object localObject1;
    if (paramPreference.mKey.equals("more_tab_game_recommend"))
    {
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10958, "6");
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(848L, 2L, 1L, false);
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.ii(getContext());
        AppMethodBeat.o(29261);
        return true;
      }
      paramPreference = new Intent();
      paramPreference.putExtra("from_find_more_friend", this.yWt);
      paramPreference.putExtra("game_report_from_scene", 901);
      if (this.yWt)
      {
        localObject1 = new ng();
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        paramf = (IconPreference)paramf.atx("more_tab_game_recommend");
        if ((((ng)localObject1).cDy.cDz != null) && (paramf != null)) {
          com.tencent.mm.at.o.ahG().b(((ng)localObject1).cDy.cDz, paramf.dEK());
        }
      }
      ab.i("MicroMsg.FindMoreFriendsUI", "start game center index, time : " + System.currentTimeMillis());
      paramPreference.putExtra("start_time", System.currentTimeMillis());
      com.tencent.mm.bq.d.b(getContext(), "game", ".ui.GameCenterUI", paramPreference);
      AppMethodBeat.o(29261);
      return true;
    }
    if ("find_friends_by_micromsg".equals(paramPreference.mKey))
    {
      com.tencent.mm.bq.d.b(getContext(), "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
      AppMethodBeat.o(29261);
      return true;
    }
    if ("find_friends_by_mobile".equals(paramPreference.mKey))
    {
      if (com.tencent.mm.plugin.account.friend.a.l.aqq() != l.a.gxB)
      {
        paramf = new Intent(getContext(), BindMContactIntroUI.class);
        paramf.putExtra("key_upload_scene", 6);
        MMWizardActivity.J(getContext(), paramf);
        AppMethodBeat.o(29261);
        return true;
      }
      startActivity(new Intent(getContext(), MobileFriendUI.class));
      AppMethodBeat.o(29261);
      return true;
    }
    if ("find_friends_by_facebook".equals(paramPreference.mKey))
    {
      startActivity(new Intent(getContext(), FacebookFriendUI.class));
      AppMethodBeat.o(29261);
      return true;
    }
    if ("settings_mm_card_package".equals(paramPreference.mKey))
    {
      ab.i("MicroMsg.FindMoreFriendsUI", "enter to cardhome");
      paramf = new il();
      paramf.cxQ.context = getContext();
      com.tencent.mm.sdk.b.a.ymk.l(paramf);
      AppMethodBeat.o(29261);
      return true;
    }
    if (paramPreference.mKey.equals("jd_market_entrance"))
    {
      com.tencent.mm.pluginsdk.wallet.j.Mx(9);
      if (com.tencent.mm.pluginsdk.f.f.vMG != null)
      {
        paramf = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGP();
        localObject1 = com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGQ();
        ab.i("MicroMsg.FindMoreFriendsUI", "jumpUrl %s, jumpWeapp %s", new Object[] { paramf, localObject1 });
        com.tencent.mm.plugin.report.service.h.qsU.e(11179, new Object[] { paramf, com.tencent.mm.plugin.subapp.jdbiz.d.cGE().cGJ().sWB, Integer.valueOf(dBt()) });
        com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
        com.tencent.mm.plugin.subapp.jdbiz.d.cGI();
        com.tencent.mm.plugin.subapp.jdbiz.d.cGE();
        com.tencent.mm.plugin.subapp.jdbiz.d.cGH();
        ((IconPreference)paramPreference).eN("", -1);
        if (((com.tencent.mm.plugin.subapp.jdbiz.b)localObject1).isValid())
        {
          ab.i("MicroMsg.FindMoreFriendsUI", "jump to jd weapp %s", new Object[] { paramf });
          paramf = new AppBrandStatObject();
          paramf.scene = 1112;
          ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(getContext(), ((com.tencent.mm.plugin.subapp.jdbiz.b)localObject1).username, "", 0, ((com.tencent.mm.plugin.subapp.jdbiz.b)localObject1).version, ((com.tencent.mm.plugin.subapp.jdbiz.b)localObject1).path, paramf);
          AppMethodBeat.o(29261);
          return true;
        }
        if (!bo.isNullOrNil(paramf))
        {
          ab.i("MicroMsg.FindMoreFriendsUI", "jump to jd webview %s", new Object[] { paramf });
          paramPreference = new Intent();
          paramPreference.putExtra("rawUrl", paramf);
          paramPreference.putExtra("useJs", true);
          paramPreference.putExtra("vertical_scroll", true);
          paramPreference.putExtra("minimize_secene", 1);
          paramPreference.putExtra("KPublisherId", "jd_store");
          com.tencent.mm.bq.d.b(getContext(), "webview", ".ui.tools.WebViewUI", paramPreference);
        }
      }
      AppMethodBeat.o(29261);
      return true;
    }
    int i;
    if ("ip_call_entrance".equals(paramPreference.mKey))
    {
      paramf = (IconPreference)paramf.atx("ip_call_entrance");
      paramf.ON(8);
      paramf.OM(8);
      paramf.qI(false);
      paramf.OQ(8);
      i = 0;
      aw.aaz();
      paramf = (String)com.tencent.mm.model.c.Ru().get(ac.a.yAr, "");
      aw.aaz();
      if (((Boolean)com.tencent.mm.model.c.Ru().get(ac.a.yAs, Boolean.FALSE)).booleanValue() == true)
      {
        com.tencent.mm.plugin.ipcall.a.e.i.Y(1, -1, -1);
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAs, Boolean.FALSE);
        i = 1;
      }
      aw.aaz();
      if (((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yAq, Integer.valueOf(0))).intValue() < com.tencent.mm.m.g.Nq().getInt("WCOEntranceRedDot", 0))
      {
        i = 1;
        com.tencent.mm.plugin.report.service.h.qsU.e(13254, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1) });
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAq, Integer.valueOf(com.tencent.mm.m.g.Nq().getInt("WCOEntranceRedDot", 0)));
      }
      if (!bo.isNullOrNil(paramf))
      {
        aw.aaz();
        com.tencent.mm.model.c.Ru().set(ac.a.yAr, "");
      }
      if (i != 0) {
        com.tencent.mm.sdk.b.a.ymk.l(new ub());
      }
      if (com.tencent.mm.r.a.Ok()) {
        com.tencent.mm.ui.base.h.a(getContext(), 2131301679, 0, null, null);
      }
      for (;;)
      {
        AppMethodBeat.o(29261);
        return true;
        com.tencent.mm.plugin.report.service.h.qsU.e(12061, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        com.tencent.mm.bq.d.b(getContext(), "ipcall", ".ui.IPCallAddressUI", new Intent());
      }
    }
    if ("app_brand_entrance".equals(paramPreference.mKey))
    {
      ((com.tencent.mm.plugin.appbrand.service.l)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.l.class)).c(getContext(), 1, false);
      AppMethodBeat.o(29261);
      return true;
    }
    Object localObject2;
    if ("find_friends_by_search".equals(paramPreference.mKey))
    {
      if (!com.tencent.mm.plugin.websearch.api.aa.Je(0)) {
        ab.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
      }
      for (;;)
      {
        AppMethodBeat.o(29261);
        return true;
        paramf = ac.agv("discoverSearchEntry").optString("wording");
        if (bo.isNullOrNil(paramf))
        {
          ab.e("MicroMsg.FindMoreFriendsUI", "empty title");
        }
        else
        {
          com.tencent.mm.plugin.websearch.api.am.cZF().Jt(2);
          paramPreference = com.tencent.mm.plugin.websearch.api.am.cZF();
          paramPreference.uKa = new am.a();
          paramPreference.save();
          ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
          an.m("", 0, 0, 20);
          paramPreference = com.tencent.mm.plugin.websearch.api.aa.IZ(20);
          localObject1 = com.tencent.mm.plugin.webview.modeltools.g.dcB().day();
          localObject2 = new HashMap();
          ((Map)localObject2).put("sessionId", paramPreference);
          ((Map)localObject2).put("inputMarginTop", "32");
          ((Map)localObject2).put("inputMarginLeftRight", "24");
          ((Map)localObject2).put("inputHeight", "48");
          if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
            ((Map)localObject2).put("educationTab", Uri.encode((String)localObject1));
          }
          ((Map)localObject2).put("clickType", "0");
          ((com.tencent.mm.plugin.websearch.api.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.websearch.api.j.class)).b(getContext(), 20, "", paramPreference, (Map)localObject2, paramf);
          ((com.tencent.mm.plugin.boots.a.c)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.boots.a.c.class)).rQ(com.tencent.mm.plugin.boots.a.b.jRG);
        }
      }
    }
    if ("find_friends_by_look".equals(paramPreference.mKey))
    {
      if (!com.tencent.mm.plugin.websearch.api.aa.Je(1)) {
        ab.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
      }
      for (;;)
      {
        AppMethodBeat.o(29261);
        return true;
        paramf = ac.agv("discoverRecommendEntry").optString("wording");
        if (bo.isNullOrNil(paramf))
        {
          ab.e("MicroMsg.FindMoreFriendsUI", "empty query");
        }
        else
        {
          ab.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
          com.tencent.mm.plugin.topstory.ui.d.Y(getContext(), 21);
          ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
          paramPreference = new lq();
          paramPreference.cBH.scene = 0;
          com.tencent.mm.sdk.b.a.ymk.l(paramPreference);
          an.bz(21, paramf);
          an.reportIdKey649ForLook(21, 0);
          if (com.tencent.mm.plugin.websearch.api.aa.Jf(1) > com.tencent.mm.plugin.websearch.api.aa.Jd(1)) {
            an.reportIdKey649ForLook(21, 15);
          } else {
            an.reportIdKey649ForLook(21, 14);
          }
        }
      }
    }
    if ("my_life_around".equals(paramPreference.mKey))
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(17065, new Object[] { Integer.valueOf(1), Long.valueOf(bo.aox()), Integer.valueOf(this.yWE.ordinal()), com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKU, ""), com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKT, ""), com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKS, "0") });
      if (this.yWE.equals(FindMoreFriendsUI.a.yXb))
      {
        com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yKR, Boolean.FALSE);
        this.yWE = FindMoreFriendsUI.a.yWW;
        paramf = (IconPreference)this.yWj.atx("my_life_around");
        paramf.OL(8);
        paramf.eN("", -1);
      }
      bool1 = ((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yKQ, Boolean.FALSE)).booleanValue();
      ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_nearbylife");
      localObject1 = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).ajy("labs_nearbylife");
      i = ((com.tencent.mm.plugin.welab.a.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.welab.a.a.a.class)).ajz("labs_nearbylife");
      localObject2 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject2).scene = 1112;
      paramPreference = null;
      int j = com.tencent.mm.m.g.Nq().getInt("LifeAppEntranceBringRedDot", 0);
      ab.d("MicroMsg.FindMoreFriendsUI", "withRedTag: %d.", new Object[] { Integer.valueOf(j) });
      paramf = paramPreference;
      if (j != 0)
      {
        paramf = paramPreference;
        if (bool1) {
          paramf = "?hasRedDot=true";
        }
      }
      ((com.tencent.mm.plugin.appbrand.service.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.j.class)).a(getContext(), (String)localObject1, null, i, 0, paramf, (AppBrandStatObject)localObject2);
      AppMethodBeat.o(29261);
      return true;
    }
    AppMethodBeat.o(29261);
    return false;
  }
  
  public final boolean onPreferenceTreeLongClick(com.tencent.mm.ui.base.preference.f paramf, Preference paramPreference, View paramView)
  {
    AppMethodBeat.i(29260);
    if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) && ("app_brand_entrance".equals(paramPreference.mKey)))
    {
      ((com.tencent.mm.plugin.appbrand.service.l)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.l.class)).c(getContext(), 1, true);
      AppMethodBeat.o(29260);
      return true;
    }
    boolean bool = super.onPreferenceTreeLongClick(paramf, paramPreference, paramView);
    AppMethodBeat.o(29260);
    return bool;
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.FindMoreFriendsUI
 * JD-Core Version:    0.7.0.1
 */