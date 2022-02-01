package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.ao.af;
import com.tencent.mm.api.c.a;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.a.dy;
import com.tencent.mm.f.a.dy.b;
import com.tencent.mm.f.a.ec;
import com.tencent.mm.f.a.ec.b;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.j;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.profile.ui.ContactInfoUI;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.fam;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.nf;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.pb;
import com.tencent.mm.protocal.protobuf.pc;
import com.tencent.mm.protocal.protobuf.pd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;
import kotlin.g.b.p;

public class ContactWidgetNewBizInfo
  implements k, i, com.tencent.mm.pluginsdk.c.b
{
  private static final String GZd;
  private static String HdC;
  private static boolean HdD;
  private String BLy;
  private String GXB;
  com.tencent.mm.api.c GXj;
  boolean GXw;
  private List<WxaAttributes.WxaEntryInfo> GYU;
  private aez GYV;
  private int GYZ;
  private Bundle GZe;
  SnsAdClick GZf;
  private String GZg;
  private boolean HdA;
  private Parcelable HdB;
  ContactInfoUI Hdt;
  private pd Hdu;
  private com.tencent.mm.plugin.profile.ui.newbizinfo.b.b Hdv;
  private String Hdw;
  private boolean Hdx;
  private boolean Hdy;
  private boolean Hdz;
  as contact;
  private List<c.a> eZb;
  private c.b eZc;
  private String eZl;
  private long endTime;
  long enterTime;
  private boolean isLoading;
  int mXL;
  private IListener ozM;
  private IListener sCy;
  private com.tencent.mm.ui.base.preference.f screen;
  private s tipDialog;
  
  static
  {
    AppMethodBeat.i(222069);
    GZd = "https://" + WeChatHosts.domainString(R.l.host_mp_weixin_qq_com) + "/mp/infringement?username=%s&from=1#wechat_redirect";
    HdC = "crashFlag";
    HdD = false;
    AppMethodBeat.o(222069);
  }
  
  private void a(pd parampd)
  {
    AppMethodBeat.i(169758);
    if (parampd == null)
    {
      AppMethodBeat.o(169758);
      return;
    }
    int i;
    label87:
    Object localObject;
    if (parampd.RXA != null)
    {
      com.tencent.mm.plugin.brandservice.b.d.I(parampd.RXA.ThV, true);
      boolean bool = parampd.RXA.ThV;
      if (parampd.RXA.TVR != null)
      {
        i = parampd.RXA.TVR.size();
        Log.i("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo %b, size: %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) });
        if (parampd.RXu != null) {
          if (this.Hdv == null)
          {
            localObject = (com.tencent.mm.ui.base.preference.h)this.Hdt.getListView().getAdapter();
            if (localObject != null) {
              break label279;
            }
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "empty adapter");
          }
        }
      }
    }
    for (;;)
    {
      if (this.Hdv != null)
      {
        localObject = this.Hdv;
        op localop = parampd.RXu;
        dor localdor = parampd.RXA;
        p.k(localop, "msgList");
        ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.b)localObject).HeH.b(localop);
        ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.b)localObject).HeH.a(localdor);
        ((com.tencent.mm.plugin.profile.ui.newbizinfo.b.b)localObject).HeP.notifyDataSetChanged();
      }
      if ((!this.Hdx) && (parampd.RXA != null) && (parampd.RXA.TVR != null) && (parampd.RXA.TVR.size() > 0) && (com.tencent.mm.plugin.brandservice.b.d.cyZ()))
      {
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 1401, this.mXL, this.enterTime);
        this.Hdx = true;
      }
      AppMethodBeat.o(169758);
      return;
      i = -1;
      break;
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "alvinluo updateProfileInfo videochannel_notify_info is null");
      break label87;
      label279:
      this.Hdv = new com.tencent.mm.plugin.profile.ui.newbizinfo.b.b(this.Hdt, this, (com.tencent.mm.ui.base.preference.h)localObject, new String[] { "contact_info_biz_err_msg", "contact_info_footer_space" });
      ((com.tencent.mm.ui.base.preference.h)localObject).Wsh = this.Hdv;
    }
  }
  
  private static int aUU(String paramString)
  {
    int j = 10000;
    AppMethodBeat.i(27460);
    int i = j;
    if (!Util.isNullOrNil(paramString)) {}
    try
    {
      i = Util.getInt(Uri.parse(paramString).getQueryParameter("scene"), 10000);
      AppMethodBeat.o(27460);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  /* Error */
  private void ai(as paramas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 323
    //   5: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: ifnull +9 -> 18
    //   12: getstatic 134	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:HdD	Z
    //   15: ifeq +12 -> 27
    //   18: ldc_w 323
    //   21: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: iconst_1
    //   28: putstatic 134	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:HdD	Z
    //   31: ldc_w 325
    //   34: invokestatic 331	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getSingleMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   37: astore_2
    //   38: aload_2
    //   39: getstatic 132	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:HdC	Ljava/lang/String;
    //   42: iconst_0
    //   43: invokevirtual 335	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeBool	(Ljava/lang/String;Z)Z
    //   46: ifeq +30 -> 76
    //   49: ldc 181
    //   51: ldc_w 337
    //   54: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   60: ldc2_w 346
    //   63: lconst_0
    //   64: lconst_1
    //   65: iconst_0
    //   66: invokevirtual 351	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   69: aload_1
    //   70: getfield 268	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   73: invokestatic 356	com/tencent/mm/plugin/profile/ui/newbizinfo/a:clear	(Ljava/lang/String;)V
    //   76: aload_2
    //   77: getstatic 132	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:HdC	Ljava/lang/String;
    //   80: iconst_1
    //   81: invokevirtual 359	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
    //   84: pop
    //   85: ldc 181
    //   87: ldc_w 361
    //   90: invokestatic 339	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: getstatic 366	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   96: ifne +15 -> 111
    //   99: getstatic 369	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   102: ifne +9 -> 111
    //   105: invokestatic 374	com/tencent/mm/sdk/platformtools/WeChatEnvironment:hasDebugger	()Z
    //   108: ifeq +22 -> 130
    //   111: aload_2
    //   112: ldc_w 376
    //   115: iconst_0
    //   116: invokevirtual 379	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:decodeInt	(Ljava/lang/String;I)I
    //   119: iconst_1
    //   120: if_icmpne +10 -> 130
    //   123: ldc_w 381
    //   126: iconst_0
    //   127: invokestatic 387	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   130: getstatic 393	com/tencent/e/h:ZvG	Lcom/tencent/e/i;
    //   133: new 12	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$1
    //   136: dup
    //   137: aload_0
    //   138: aload_2
    //   139: invokespecial 396	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo$1:<init>	(Lcom/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo;Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;)V
    //   142: ldc2_w 397
    //   145: invokeinterface 403 4 0
    //   150: pop
    //   151: ldc_w 323
    //   154: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: goto -133 -> 24
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	ContactWidgetNewBizInfo
    //   0	165	1	paramas	as
    //   37	102	2	localMultiProcessMMKV	MultiProcessMMKV
    // Exception table:
    //   from	to	target	type
    //   2	8	160	finally
    //   12	18	160	finally
    //   18	24	160	finally
    //   27	76	160	finally
    //   76	111	160	finally
    //   111	130	160	finally
    //   130	157	160	finally
  }
  
  private void b(String paramString, final com.tencent.mm.cd.b paramb)
  {
    AppMethodBeat.i(27450);
    if (this.isLoading)
    {
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "not obtailBizInfoFromCgi, use cache");
      AppMethodBeat.o(27450);
      return;
    }
    this.isLoading = true;
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 2656;
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/bizattr/bizprofilev2";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    pc localpc = new pc();
    localpc.RTS = paramString;
    if (paramb != null)
    {
      localpc.RXp = 1;
      localpc.RXn = paramb;
      localpc.RXq = 20;
      localpc.CPw = this.mXL;
      localpc.RXr = com.tencent.mm.storage.ab.getSessionId();
      ((d.a)localObject).lBU = localpc;
      ((d.a)localObject).lBV = new pd();
      localObject = ((d.a)localObject).bgN();
      paramb = new aa.a()
      {
        public final int a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.d paramAnonymousd, com.tencent.mm.an.q paramAnonymousq)
        {
          AppMethodBeat.i(270031);
          Log.i("MicroMsg.ContactWidgetNewBizInfo", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          paramAnonymousString = (pd)d.c.b(paramAnonymousd.lBS);
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (paramAnonymousString != null))
          {
            paramAnonymousd = a.Hes;
            a.a(paramAnonymousString.RXu);
            if (paramb == null) {
              break label386;
            }
            if ((!paramb.equals(ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).RXu.RWD.RXn)) || (paramAnonymousString.RXu == null)) {
              break label376;
            }
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).RXu.RWC.addAll(paramAnonymousString.RXu.RWC);
            ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).RXu.RWD = paramAnonymousString.RXu.RWD;
            if (paramb == null) {
              break label422;
            }
            if ((ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this) != null) && (ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).RXu != null))
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this));
              com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username, 106, ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
            }
            label227:
            if ((paramAnonymousString.RUc & 0x4) == 0) {
              break label449;
            }
            paramAnonymousd = ContactWidgetNewBizInfo.d(4, paramAnonymousString.RXy);
            if (paramAnonymousd == null) {
              break label449;
            }
            paramAnonymousq = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).byG("contact_info_biz_err_msg");
            ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).dz("contact_info_biz_err_msg", false);
            paramAnonymousq.setErrMsg(paramAnonymousd);
          }
          for (;;)
          {
            for (;;)
            {
              if ((paramAnonymousString.RUc & 0x2) != 0)
              {
                paramAnonymousString = (NewBizInfoHeaderPreference)ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).byG("contact_info_header_newbizinfo");
                paramAnonymousString.HdU = true;
                if (paramAnonymousString.jiu != null)
                {
                  com.tencent.mm.plugin.brandservice.b.e.a(paramAnonymousString.jiu, paramAnonymousString.contact, "", true);
                  paramAnonymousString.jiu.setClickable(false);
                }
              }
              ContactWidgetNewBizInfo.n(ContactWidgetNewBizInfo.this);
              ContactWidgetNewBizInfo.o(ContactWidgetNewBizInfo.this);
              AppMethodBeat.o(270031);
              return 0;
              label376:
              Log.e("MicroMsg.ContactWidgetNewBizInfo", "drop err resp");
              break;
              try
              {
                label386:
                ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this).parseFrom(paramAnonymousString.toByteArray());
              }
              catch (IOException paramAnonymousd)
              {
                Log.printErrStackTrace("MicroMsg.ContactWidgetNewBizInfo", paramAnonymousd, "profileInfo.parseFrom", new Object[0]);
              }
            }
            break;
            label422:
            a.b(ContactWidgetNewBizInfo.k(ContactWidgetNewBizInfo.this));
            ContactWidgetNewBizInfo.l(ContactWidgetNewBizInfo.this);
            ContactWidgetNewBizInfo.m(ContactWidgetNewBizInfo.this);
            break label227;
            label449:
            if ((paramAnonymousString.RUc & 0x8) != 0)
            {
              paramAnonymousd = ContactWidgetNewBizInfo.d(8, paramAnonymousString.RXy);
              if (paramAnonymousd != null)
              {
                paramAnonymousq = (NewBizInfoErrMsgPreference)ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).byG("contact_info_biz_err_msg");
                ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).dz("contact_info_biz_err_msg", false);
                paramAnonymousq.setErrMsg(paramAnonymousd);
                continue;
              }
            }
            ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).dz("contact_info_biz_err_msg", true);
          }
        }
      };
      if (!(this.Hdt instanceof com.tencent.mm.vending.e.b)) {
        break label197;
      }
    }
    label197:
    for (paramString = this.Hdt;; paramString = null)
    {
      com.tencent.mm.an.aa.a((com.tencent.mm.an.d)localObject, paramb, false, paramString);
      AppMethodBeat.o(27450);
      return;
      localpc.RXp = 0;
      localpc.RXq = 5;
      break;
    }
  }
  
  private boolean cGn()
  {
    AppMethodBeat.i(27452);
    if ((this.Hdu != null) && (this.Hdu.RXs != null) && (this.Hdu.RXs.RRS == 0) && (!fqS()))
    {
      AppMethodBeat.o(27452);
      return true;
    }
    AppMethodBeat.o(27452);
    return false;
  }
  
  private void fqQ()
  {
    AppMethodBeat.i(27448);
    com.tencent.mm.api.c localc2 = com.tencent.mm.ao.g.gu(this.contact.field_username);
    this.eZb = null;
    this.eZc = null;
    this.GYU = null;
    com.tencent.mm.api.c localc1;
    if (localc2 != null)
    {
      localc1 = localc2;
      if (localc2.dc(false) != null) {}
    }
    else
    {
      localc1 = localc2;
      if (this.GYV != null)
      {
        localc1 = new com.tencent.mm.api.c();
        localc1.field_username = this.contact.field_username;
        localc1.field_brandFlag = this.GYV.mVM;
        localc1.field_brandIconURL = this.GYV.mVP;
        localc1.field_brandInfo = this.GYV.mVO;
        localc1.field_extInfo = this.GYV.mVN;
        localc1.field_type = localc1.dc(false).getServiceType();
      }
    }
    if ((localc1 != null) && (localc1.field_brandInfo == null) && (localc1.field_extInfo == null) && (this.GYV != null))
    {
      localc1.field_username = this.contact.field_username;
      localc1.field_brandFlag = this.GYV.mVM;
      localc1.field_brandIconURL = this.GYV.mVP;
      localc1.field_brandInfo = this.GYV.mVO;
      localc1.field_extInfo = this.GYV.mVN;
      localc1.field_type = localc1.dc(false).getServiceType();
    }
    if (localc1 != null)
    {
      this.GXj = localc1;
      this.eZb = localc1.Zg();
      this.eZc = localc1.dc(false);
      this.GYU = this.eZc.getWxaEntryInfoList();
      if ((this.eZc.Zk() != null) && (this.eZc.Zk().length() > 0)) {
        this.eZl = this.eZc.Zk();
      }
    }
    AppMethodBeat.o(27448);
  }
  
  private boolean fqS()
  {
    boolean bool1 = true;
    AppMethodBeat.i(27453);
    try
    {
      String str = this.eZc.Zn();
      boolean bool2 = Util.isNullOrNil(str);
      if (bool2)
      {
        AppMethodBeat.o(27453);
        return false;
      }
      long l = Util.getLong(str, 0L);
      if ((l > 0L) && (l - System.currentTimeMillis() / 1000L < 0L)) {}
      for (;;)
      {
        Log.d("MicroMsg.ContactWidgetNewBizInfo", "isBizAccountTimeExpired:%b", new Object[] { Boolean.valueOf(bool1) });
        AppMethodBeat.o(27453);
        return bool1;
        bool1 = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(27453);
    }
  }
  
  /* Error */
  private void fqT()
  {
    // Byte code:
    //   0: sipush 27459
    //   3: invokestatic 97	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 142	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:Hdt	Lcom/tencent/mm/plugin/profile/ui/ContactInfoUI;
    //   10: invokevirtual 644	com/tencent/mm/plugin/profile/ui/ContactInfoUI:getIntent	()Landroid/content/Intent;
    //   13: astore 13
    //   15: aload 13
    //   17: ldc_w 779
    //   20: iconst_0
    //   21: invokevirtual 782	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   24: invokestatic 788	com/tencent/mm/plugin/profile/ui/newbizinfo/b/f:abH	(I)I
    //   27: istore_1
    //   28: aload 13
    //   30: ldc_w 790
    //   33: invokevirtual 793	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 14
    //   38: aload 13
    //   40: ldc_w 795
    //   43: invokevirtual 793	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 15
    //   48: aload 13
    //   50: ldc_w 797
    //   53: iconst_0
    //   54: invokevirtual 782	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   57: aload 14
    //   59: invokestatic 801	com/tencent/mm/plugin/profile/ui/newbizinfo/b/f:bO	(ILjava/lang/String;)I
    //   62: istore_2
    //   63: aload 13
    //   65: ldc_w 521
    //   68: invokevirtual 793	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore 8
    //   73: aload 13
    //   75: ldc_w 803
    //   78: invokevirtual 793	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 12
    //   83: aload 13
    //   85: ldc_w 805
    //   88: invokevirtual 809	android/content/Intent:getBundleExtra	(Ljava/lang/String;)Landroid/os/Bundle;
    //   91: astore 10
    //   93: ldc_w 811
    //   96: astore 9
    //   98: aload 10
    //   100: ifnull +16 -> 116
    //   103: aload 10
    //   105: ldc_w 813
    //   108: ldc_w 811
    //   111: invokevirtual 819	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 9
    //   116: aload 13
    //   118: ldc_w 821
    //   121: iconst_m1
    //   122: invokevirtual 782	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   125: invokestatic 826	com/tencent/mm/ui/f$a:atF	(I)I
    //   128: istore_3
    //   129: aload_0
    //   130: getfield 263	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/as;
    //   133: getfield 268	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   136: astore 16
    //   138: aload 9
    //   140: invokestatic 303	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   143: ifne +433 -> 576
    //   146: aload 9
    //   148: invokestatic 829	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   151: ldc_w 831
    //   154: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   157: astore 9
    //   159: aload 8
    //   161: astore 10
    //   163: aload 8
    //   165: invokestatic 829	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   168: ldc_w 831
    //   171: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   174: astore 8
    //   176: aload 8
    //   178: astore 10
    //   180: aload 12
    //   182: invokestatic 829	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   185: ldc_w 831
    //   188: invokestatic 835	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   191: astore 11
    //   193: aload 11
    //   195: astore 10
    //   197: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   200: sipush 16232
    //   203: bipush 9
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: iload_1
    //   211: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: iload_2
    //   218: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   221: aastore
    //   222: dup
    //   223: iconst_2
    //   224: aload 14
    //   226: aastore
    //   227: dup
    //   228: iconst_3
    //   229: aload 15
    //   231: aastore
    //   232: dup
    //   233: iconst_4
    //   234: aload 8
    //   236: aastore
    //   237: dup
    //   238: iconst_5
    //   239: aload 10
    //   241: aastore
    //   242: dup
    //   243: bipush 6
    //   245: aload 9
    //   247: aastore
    //   248: dup
    //   249: bipush 7
    //   251: iload_3
    //   252: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   255: aastore
    //   256: dup
    //   257: bipush 8
    //   259: aload 16
    //   261: aastore
    //   262: invokevirtual 838	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   265: aload_0
    //   266: getfield 840	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:GZg	Ljava/lang/String;
    //   269: invokestatic 303	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   272: ifne +16 -> 288
    //   275: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   278: sipush 16697
    //   281: aload_0
    //   282: getfield 840	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:GZg	Ljava/lang/String;
    //   285: invokevirtual 844	com/tencent/mm/plugin/report/service/h:kvStat	(ILjava/lang/String;)V
    //   288: aload 13
    //   290: ldc_w 779
    //   293: iconst_0
    //   294: invokevirtual 782	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   297: istore_1
    //   298: invokestatic 770	java/lang/System:currentTimeMillis	()J
    //   301: ldc2_w 397
    //   304: ldiv
    //   305: l2i
    //   306: i2l
    //   307: lstore 4
    //   309: iload_1
    //   310: sipush 160
    //   313: if_icmpne +150 -> 463
    //   316: aload 13
    //   318: ldc_w 846
    //   321: lconst_0
    //   322: invokevirtual 849	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   325: lstore 6
    //   327: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   330: sipush 15721
    //   333: bipush 9
    //   335: anewarray 4	java/lang/Object
    //   338: dup
    //   339: iconst_0
    //   340: aload_0
    //   341: getfield 263	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/as;
    //   344: getfield 268	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   347: aastore
    //   348: dup
    //   349: iconst_1
    //   350: iconst_0
    //   351: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: aastore
    //   355: dup
    //   356: iconst_2
    //   357: bipush 14
    //   359: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: dup
    //   364: iconst_3
    //   365: lload 4
    //   367: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   370: aastore
    //   371: dup
    //   372: iconst_4
    //   373: invokestatic 453	com/tencent/mm/storage/ab:getSessionId	()I
    //   376: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: iconst_5
    //   382: iconst_0
    //   383: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   386: aastore
    //   387: dup
    //   388: bipush 6
    //   390: lload 6
    //   392: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   395: aastore
    //   396: dup
    //   397: bipush 7
    //   399: ldc_w 811
    //   402: aastore
    //   403: dup
    //   404: bipush 8
    //   406: iconst_1
    //   407: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   410: aastore
    //   411: invokevirtual 838	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   414: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   417: ldc2_w 855
    //   420: ldc2_w 857
    //   423: lconst_1
    //   424: iconst_0
    //   425: invokevirtual 351	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   428: sipush 27459
    //   431: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   434: return
    //   435: astore 10
    //   437: ldc_w 811
    //   440: astore 9
    //   442: ldc 181
    //   444: aload 10
    //   446: ldc_w 811
    //   449: iconst_0
    //   450: anewarray 4	java/lang/Object
    //   453: invokestatic 862	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: aload 12
    //   458: astore 10
    //   460: goto -263 -> 197
    //   463: iload_1
    //   464: sipush 174
    //   467: if_icmpne +89 -> 556
    //   470: getstatic 345	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   473: sipush 15721
    //   476: bipush 9
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: aload_0
    //   484: getfield 263	com/tencent/mm/plugin/profile/ui/newbizinfo/ContactWidgetNewBizInfo:contact	Lcom/tencent/mm/storage/as;
    //   487: getfield 268	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: iconst_0
    //   494: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: aastore
    //   498: dup
    //   499: iconst_2
    //   500: bipush 21
    //   502: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   505: aastore
    //   506: dup
    //   507: iconst_3
    //   508: lload 4
    //   510: invokestatic 854	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: aastore
    //   514: dup
    //   515: iconst_4
    //   516: invokestatic 453	com/tencent/mm/storage/ab:getSessionId	()I
    //   519: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   522: aastore
    //   523: dup
    //   524: iconst_5
    //   525: iconst_0
    //   526: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aastore
    //   530: dup
    //   531: bipush 6
    //   533: iconst_0
    //   534: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: dup
    //   539: bipush 7
    //   541: ldc_w 811
    //   544: aastore
    //   545: dup
    //   546: bipush 8
    //   548: iconst_3
    //   549: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   552: aastore
    //   553: invokevirtual 838	com/tencent/mm/plugin/report/service/h:a	(I[Ljava/lang/Object;)V
    //   556: sipush 27459
    //   559: invokestatic 137	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: return
    //   563: astore 11
    //   565: aload 10
    //   567: astore 8
    //   569: aload 11
    //   571: astore 10
    //   573: goto -131 -> 442
    //   576: ldc_w 811
    //   579: astore 9
    //   581: aload 12
    //   583: astore 10
    //   585: goto -388 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	this	ContactWidgetNewBizInfo
    //   27	441	1	i	int
    //   62	156	2	j	int
    //   128	124	3	k	int
    //   307	202	4	l1	long
    //   325	66	6	l2	long
    //   71	497	8	localObject1	Object
    //   96	484	9	str1	String
    //   91	149	10	localObject2	Object
    //   435	10	10	localUnsupportedEncodingException1	java.io.UnsupportedEncodingException
    //   458	126	10	localObject3	Object
    //   191	3	11	str2	String
    //   563	7	11	localUnsupportedEncodingException2	java.io.UnsupportedEncodingException
    //   81	501	12	str3	String
    //   13	304	13	localIntent	Intent
    //   36	189	14	str4	String
    //   46	184	15	str5	String
    //   136	124	16	str6	String
    // Exception table:
    //   from	to	target	type
    //   146	159	435	java/io/UnsupportedEncodingException
    //   163	176	563	java/io/UnsupportedEncodingException
    //   180	193	563	java/io/UnsupportedEncodingException
  }
  
  private void fqh()
  {
    AppMethodBeat.i(27451);
    cQX();
    fqQ();
    this.screen.removeAll();
    this.screen.auC(R.o.eXr);
    Object localObject = (NewBizInfoHeaderPreference)this.screen.byG("contact_info_header_newbizinfo");
    if ((localObject != null) && (!Util.isNullOrNil(this.contact.field_username)))
    {
      ((NewBizInfoHeaderPreference)localObject).a(this.contact, this.GXB, this.GXj, this.Hdu);
      this.HdA = true;
      if (this.Hdu == null) {
        break label598;
      }
      if (!com.tencent.mm.contact.d.rk(this.contact.field_type)) {
        break label567;
      }
      this.screen.dz("contact_info_biz_add", true);
      this.screen.dz("contact_info_biz_go_chatting", false);
      ((NewBizInfoFollowPreference)this.screen.byG("contact_info_biz_go_chatting")).GXu = this;
      label161:
      if ((this.Hdu != null) && (this.Hdu.RXs != null) && (this.Hdu.RXu != null) && (this.Hdu.RXu.RWD != null)) {
        a(this.Hdu);
      }
      if ((this.Hdu != null) && (!cGn()) && (!com.tencent.mm.contact.d.rk(this.contact.field_type))) {
        this.Hdt.showOptionMenu(false);
      }
      if ((this.Hdu == null) || (this.Hdu.RXx == null)) {
        break label643;
      }
      this.screen.dz("contact_info_biz_menu_newbizinfo", false);
      if (this.Hdu != null) {
        ((NewBizInfoMenuPreference)this.screen.byG("contact_info_biz_menu_newbizinfo")).a(this.Hdu.RXx, this.contact, this.mXL, this.enterTime);
      }
    }
    for (;;)
    {
      this.screen.dz("contact_info_biz_err_msg", true);
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "KIsardDevice(%b)", new Object[] { Boolean.valueOf(this.Hdt.getIntent().getBooleanExtra("KIsHardDevice", false)) });
      if ((this.Hdt.getIntent() == null) || (!this.Hdt.getIntent().getBooleanExtra("KIsHardDevice", false))) {
        break label681;
      }
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "Hard device biz...");
      boolean bool = fqk();
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "contact.isContact()(%b), isHarDeviceBound(%b)", new Object[] { Boolean.valueOf(com.tencent.mm.contact.d.rk(this.contact.field_type)), Boolean.valueOf(bool) });
      if ((com.tencent.mm.contact.d.rk(this.contact.field_type)) && (bool)) {
        break label674;
      }
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "%s is not my hard biz contact", new Object[] { this.contact.field_username });
      fqi();
      localObject = (NewBizInfoNotFollowPreference)this.screen.byG("contact_info_biz_add");
      this.screen.dz("contact_info_biz_add", false);
      if (localObject == null) {
        break label674;
      }
      if (!bool) {
        break label660;
      }
      ((NewBizInfoNotFollowPreference)localObject).setTitle(this.Hdt.getString(R.l.eyc));
      AppMethodBeat.o(27451);
      return;
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "head pref is null");
      this.screen.dz("contact_info_header_bizinfo", true);
      break;
      label567:
      this.screen.dz("contact_info_biz_add", false);
      this.screen.dz("contact_info_biz_go_chatting", true);
      break label161;
      label598:
      this.screen.dz("contact_info_biz_add", true);
      this.screen.dz("contact_info_biz_go_chatting", true);
      this.screen.dz("contact_info_biz_space", false);
      break label161;
      label643:
      this.screen.dz("contact_info_biz_menu_newbizinfo", true);
    }
    label660:
    ((NewBizInfoNotFollowPreference)localObject).setTitle(this.Hdt.getString(R.l.exU));
    label674:
    AppMethodBeat.o(27451);
    return;
    label681:
    if (fqS())
    {
      this.screen.dz("contact_info_biz_loading", false);
      this.screen.dz("contact_info_biz_add", true);
      this.screen.dz("contact_info_biz_go_chatting", true);
      this.screen.dz("contact_info_message_newbizinfo", true);
    }
    AppMethodBeat.o(27451);
  }
  
  private void fqi()
  {
    AppMethodBeat.i(27454);
    if ((this.contact != null) && ((com.tencent.mm.model.ab.QT(this.contact.field_username)) || (com.tencent.mm.model.ab.Rf(this.contact.field_username))) && (com.tencent.mm.contact.d.rk(this.contact.field_type)))
    {
      this.screen.dz("contact_info_biz_go_chatting", false);
      AppMethodBeat.o(27454);
      return;
    }
    this.screen.dz("contact_info_biz_go_chatting", true);
    AppMethodBeat.o(27454);
  }
  
  private void fqj()
  {
    AppMethodBeat.i(27458);
    if ((NewBizInfoHeaderPreference)this.screen.byG("contact_info_header_newbizinfo") != null) {
      NewBizInfoHeaderPreference.Pi(System.currentTimeMillis());
    }
    if ((this.Hdt.getIntent() != null) && (this.Hdt.getIntent().getBooleanExtra("KIsHardDevice", false)))
    {
      localObject1 = this.Hdt.getIntent().getStringExtra("KHardDeviceBindTicket");
      if (!Util.isNullOrNil((String)localObject1)) {
        break label334;
      }
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "bindTicket is null, means it is not switch from QRcode scan, just add contact");
    }
    label334:
    while (fqk())
    {
      localObject1 = new com.tencent.mm.pluginsdk.ui.applet.a(this.Hdt, new a.a()
      {
        public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(279249);
          as localas;
          if (paramAnonymousBoolean1)
          {
            com.tencent.mm.ui.base.h.cO(ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).getString(R.l.eya));
            ContactWidgetNewBizInfo.b(ContactWidgetNewBizInfo.this).dz("contact_info_time_expired", true);
            localas = ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this);
            if ((localas != null) && (!Util.isNullOrNil(paramAnonymousString1))) {
              break label380;
            }
            Log.e("MicroMsg.ContactWidgetNewBizInfo", "respUsername == " + paramAnonymousString1 + ", contact = " + localas);
            if (ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this) != null)
            {
              paramAnonymousString1 = new sr();
              ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this).maV = 4;
              paramAnonymousString1.fSb.fSc = ContactWidgetNewBizInfo.q(ContactWidgetNewBizInfo.this);
              EventCenter.instance.publish(paramAnonymousString1);
            }
            paramAnonymousString1 = af.bjv().Uo(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.field_status = 1;
            if ((!Util.isNullOrNil(paramAnonymousString1.field_extInfo)) || (Util.isNullOrNil(paramAnonymousString1.field_username)) || (ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this) == null) || (!paramAnonymousString1.field_username.equals(Util.nullAsNil(ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this).field_username)))) {
              break label668;
            }
            af.bjv().h(ContactWidgetNewBizInfo.r(ContactWidgetNewBizInfo.this));
            label241:
            paramAnonymousBoolean1 = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_biz_profile_stay_after_follow_op", false);
            paramAnonymousBoolean2 = ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).getIntent().getBooleanExtra("key_start_biz_profile_from_app_brand_profile", false);
            if (!paramAnonymousString1.YX()) {
              break label679;
            }
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("enterprise_biz_name", ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username);
            paramAnonymousString1.putExtra("enterprise_biz_display_name", com.tencent.mm.model.aa.PJ(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username));
            paramAnonymousString1.putExtra("enterprise_from_scene", 7);
            paramAnonymousString1.addFlags(67108864);
            com.tencent.mm.by.c.f(ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this), ".ui.conversation.EnterpriseConversationUI", paramAnonymousString1);
          }
          label609:
          for (;;)
          {
            label356:
            ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).finish();
            label380:
            do
            {
              ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this, 3);
              AppMethodBeat.o(279249);
              return;
              paramAnonymousString2 = null;
              if (com.tencent.mm.model.ab.Qk(localas.field_username))
              {
                String str = Util.nullAsNil(localas.field_username);
                paramAnonymousString2 = com.tencent.mm.ao.g.gu(str);
                if (paramAnonymousString2 != null) {
                  paramAnonymousString2.field_username = paramAnonymousString1;
                }
                af.bjv().Up(str);
                localas.Iy(str);
              }
              localas.setUsername(paramAnonymousString1);
              if ((int)localas.jxt == 0)
              {
                bh.beI();
                com.tencent.mm.model.c.bbL().aw(localas);
              }
              if ((int)localas.jxt <= 0)
              {
                Log.e("MicroMsg.ContactWidgetNewBizInfo", "addContact : insert contact failed");
                break;
              }
              com.tencent.mm.model.ab.H(localas);
              bh.beI();
              paramAnonymousString1 = com.tencent.mm.model.c.bbL().RG(localas.field_username);
              if (paramAnonymousString2 != null)
              {
                af.bjv().g(paramAnonymousString2);
                break;
              }
              paramAnonymousString2 = com.tencent.mm.ao.g.gu(paramAnonymousString1.field_username);
              if ((paramAnonymousString1.hxX()) && (com.tencent.mm.ao.a.biP())) {}
              for (int i = 1;; i = 0)
              {
                if ((paramAnonymousString2 != null) && ((!paramAnonymousString2.YR()) || (i != 0))) {
                  break label609;
                }
                Log.d("MicroMsg.ContactWidgetNewBizInfo", "shouldUpdate");
                az.a.ltq.aP(paramAnonymousString1.field_username, "");
                com.tencent.mm.am.d.TA(paramAnonymousString1.field_username);
                break;
              }
              if ((!paramAnonymousString1.hyb()) || (i != 0)) {
                break;
              }
              Log.d("MicroMsg.ContactWidgetNewBizInfo", "update contact, last check time=%d", new Object[] { Integer.valueOf(paramAnonymousString1.hDo) });
              az.a.ltq.aP(paramAnonymousString1.field_username, "");
              com.tencent.mm.am.d.TA(paramAnonymousString1.field_username);
              break;
              af.bjv().h(paramAnonymousString1);
              break label241;
              paramAnonymousString1 = new Intent();
              paramAnonymousString1.putExtra("Chat_User", ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username);
              paramAnonymousString1.putExtra("key_has_add_contact", true);
              paramAnonymousString1.putExtra("finish_direct", true);
              if (paramAnonymousBoolean2) {
                paramAnonymousString1.addFlags(268435456);
              }
              com.tencent.mm.storage.ab.bvv(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username);
              com.tencent.mm.plugin.profile.b.mIG.d(paramAnonymousString1, ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this));
              if (paramAnonymousBoolean1) {
                break label356;
              }
            } while (!paramAnonymousBoolean2);
          }
        }
      });
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(Integer.valueOf(this.mXL));
      if (this.eZl != null) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BAU = this.eZl;
      }
      if (!Util.isNullOrNil(this.BLy)) {
        ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).BLy = this.BLy;
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReN = true;
      String str = this.Hdt.getIntent().getStringExtra("url");
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReO = str;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).wGA = f.a.atF(this.Hdt.getIntent().getIntExtra("qbarScene", -1));
      fam localfam = new fam();
      localfam.RKI = this.Hdt.getIntent().getIntExtra("Contact_Sub_Scene", 0);
      localfam.SsR = this.Hdt.getIntent().getStringExtra("Contact_Scene_Note");
      if (!Util.isNullOrNil(str))
      {
        if (Util.isNullOrNil(localfam.SsR)) {
          localfam.SsR = str;
        }
        if (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(str)) {
          localfam.UAv = aUU(str);
        }
      }
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).ReP = localfam;
      ((com.tencent.mm.pluginsdk.ui.applet.a)localObject1).a(this.contact.field_username, (LinkedList)localObject2, this.GZg);
      fqT();
      AppMethodBeat.o(27458);
      return;
    }
    Log.d("MicroMsg.ContactWidgetNewBizInfo", "IsHardDevice, bindTicket = %s", new Object[] { localObject1 });
    bh.aGY().a(536, this);
    Object localObject2 = new dy();
    ((dy)localObject2).fzv.fzx = ((String)localObject1);
    ((dy)localObject2).fzv.opType = 1;
    EventCenter.instance.publish((IEvent)localObject2);
    Object localObject1 = ((dy)localObject2).fzw.fzz;
    localObject2 = this.Hdt;
    this.Hdt.getString(R.l.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject2, this.Hdt.getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(281574);
        bh.aGY().b(536, ContactWidgetNewBizInfo.this);
        paramAnonymousDialogInterface = new dy();
        paramAnonymousDialogInterface.fzv.opType = 2;
        paramAnonymousDialogInterface.fzv.fzz = this.ftz;
        EventCenter.instance.publish(paramAnonymousDialogInterface);
        AppMethodBeat.o(281574);
      }
    });
    AppMethodBeat.o(27458);
  }
  
  private boolean fqk()
  {
    AppMethodBeat.i(27462);
    if (this.Hdt.getIntent() == null)
    {
      AppMethodBeat.o(27462);
      return false;
    }
    String str1 = this.Hdt.getIntent().getStringExtra("device_id");
    String str2 = this.Hdt.getIntent().getStringExtra("device_type");
    ec localec = new ec();
    localec.fzH.fzB = str1;
    localec.fzH.fzF = str2;
    EventCenter.instance.publish(localec);
    boolean bool = localec.fzI.fzJ;
    AppMethodBeat.o(27462);
    return bool;
  }
  
  private void initActionBar()
  {
    AppMethodBeat.i(27445);
    this.Hdt.setMMTitle(Util.nullAsNil(this.contact.field_nickname));
    this.Hdt.setMMTitleColor(0);
    this.Hdt.setTitleDividerVis(false);
    this.Hdt.setIsDarkActionbarBg(false);
    this.Hdt.setActionbarColor(this.Hdt.getResources().getColor(R.e.BG_2));
    this.Hdt.hideActionbarLine();
    this.Hdt.setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(272168);
        ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).onBackPressed();
        AppMethodBeat.o(272168);
        return true;
      }
    }, R.k.actionbar_icon_dark_back);
    this.Hdt.removeAllOptionMenu();
    this.Hdt.addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(215856);
        ContactWidgetNewBizInfo.c(ContactWidgetNewBizInfo.this);
        AppMethodBeat.o(215856);
        return true;
      }
    });
    this.Hdt.addIconOptionMenu(0, "", R.k.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(27434);
        paramAnonymousMenuItem = new com.tencent.mm.ui.widget.a.e(ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this), 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(274432);
            if (com.tencent.mm.contact.d.rk(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_type)) {
              if (ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).ayn()) {
                if (com.tencent.mm.ao.g.Uz(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username)) {
                  paramAnonymous2o.mn(5, R.l.eyd);
                }
              }
            }
            for (;;)
            {
              paramAnonymous2o.mn(2, R.l.ezg);
              paramAnonymous2o.mn(6, R.l.euL);
              if (com.tencent.mm.contact.d.rk(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_type)) {
                paramAnonymous2o.mn(3, R.l.eyk);
              }
              AppMethodBeat.o(274432);
              return;
              paramAnonymous2o.mn(5, R.l.eLm);
              continue;
              if (com.tencent.mm.ao.g.Uz(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username))
              {
                paramAnonymous2o.mn(4, R.l.eyb);
              }
              else
              {
                paramAnonymous2o.mn(4, R.l.contact_info_stick_biz);
                continue;
                if ((int)ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).jxt <= 0) {
                  az.a.ltq.a(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username, "", new az.b.a()
                  {
                    public final void s(String paramAnonymous3String, boolean paramAnonymous3Boolean)
                    {
                      AppMethodBeat.i(233071);
                      Log.i("MicroMsg.ContactWidgetNewBizInfo", "onCreateMMMenu Fetch Contact username:%s, succ: %b", new Object[] { paramAnonymous3String, Boolean.valueOf(paramAnonymous3Boolean) });
                      AppMethodBeat.o(233071);
                    }
                  });
                }
              }
            }
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(285847);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              Log.w("MicroMsg.ContactWidgetNewBizInfo", "default onMMMenuItemSelected err");
            case 2: 
            case 3: 
            case 4: 
            case 5: 
              do
              {
                do
                {
                  AppMethodBeat.o(285847);
                  return;
                  ContactWidgetNewBizInfo.e(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(285847);
                  return;
                  ContactWidgetNewBizInfo.f(ContactWidgetNewBizInfo.this);
                  AppMethodBeat.o(285847);
                  return;
                  com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username, 903, ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
                  j.Pd(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username);
                  ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this);
                } while (!com.tencent.mm.ao.g.Ux(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username));
                com.tencent.mm.ui.base.h.cO(ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).getString(R.l.eLn));
                AppMethodBeat.o(285847);
                return;
                com.tencent.mm.model.ab.H(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username, true);
                com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username, 904, ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
                ContactWidgetNewBizInfo.i(ContactWidgetNewBizInfo.this);
              } while (!com.tencent.mm.ao.g.Ux(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username));
              com.tencent.mm.ui.base.h.cO(ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.a(ContactWidgetNewBizInfo.this).getString(R.l.esU));
              AppMethodBeat.o(285847);
              return;
            }
            ContactWidgetNewBizInfo.j(ContactWidgetNewBizInfo.this);
            AppMethodBeat.o(285847);
          }
        };
        paramAnonymousMenuItem.eik();
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(ContactWidgetNewBizInfo.d(ContactWidgetNewBizInfo.this).field_username, 600, ContactWidgetNewBizInfo.g(ContactWidgetNewBizInfo.this), ContactWidgetNewBizInfo.h(ContactWidgetNewBizInfo.this));
        AppMethodBeat.o(27434);
        return false;
      }
    });
    AppMethodBeat.o(27445);
  }
  
  public final boolean a(com.tencent.mm.ui.base.preference.f paramf, as paramas, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(27443);
    if (this.Hdt.isFinishing())
    {
      AppMethodBeat.o(27443);
      return true;
    }
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      if (Util.nullAsNil(paramas.field_username).length() <= 0) {
        break label421;
      }
      bool = true;
      label52:
      Assert.assertTrue(bool);
      if (paramf == null) {
        break label427;
      }
    }
    label421:
    label427:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      ai(paramas);
      this.screen = paramf;
      this.contact = paramas;
      this.GXw = paramBoolean;
      this.mXL = paramInt;
      this.GZf = ((SnsAdClick)this.Hdt.getIntent().getParcelableExtra("KSnsAdTag"));
      this.GZg = this.Hdt.getIntent().getStringExtra("key_add_contact_report_info");
      this.GYZ = this.Hdt.getIntent().getIntExtra("add_more_friend_search_scene", 0);
      this.GZe = this.Hdt.getIntent().getBundleExtra("Contact_Ext_Args");
      this.Hdw = this.Hdt.getIntent().getStringExtra("key_channel_session_id");
      if ((this.mXL != 78) && (this.mXL != 79)) {
        break label433;
      }
      this.Hdy = false;
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "updateBizTeenModeStatus addContactScene: %d not need to block", new Object[] { Integer.valueOf(this.mXL) });
      if (this.Hdz)
      {
        this.Hdz = false;
        initActionBar();
        this.Hdu = a.aUW(this.contact.field_username);
        fqh();
        b(paramas.field_username, null);
        paramf = this.Hdt.getIntent().getStringExtra("Contact_BIZ_PopupInfoMsg");
        if (!Util.isNullOrNil(paramf))
        {
          this.Hdt.getIntent().putExtra("Contact_BIZ_PopupInfoMsg", "");
          com.tencent.mm.ui.base.h.a(this.Hdt, paramf, "", this.Hdt.getString(R.l.app_ok), null);
        }
        if (paramas != null) {
          af.bjI().Ui(paramas.field_username);
        }
      }
      if (this.HdB != null)
      {
        paramf = this.Hdt.getListView();
        if (paramf != null) {
          paramf.onRestoreInstanceState(this.HdB);
        }
      }
      if ((this.Hdt instanceof FragmentActivity))
      {
        this.Hdt.getLifecycle().b(this);
        this.Hdt.getLifecycle().a(this);
      }
      AppMethodBeat.o(27443);
      return true;
      bool = false;
      break;
      bool = false;
      break label52;
    }
    label433:
    bool = ((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).ZN();
    if (!bool) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.Hdy = paramBoolean;
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "updateBizTeenModeStatus addContactScene: %d, blockAddContact: %b, isBizTeenModeAllowAll: %b", new Object[] { Integer.valueOf(this.mXL), Boolean.valueOf(this.Hdy), Boolean.valueOf(bool) });
      break;
    }
  }
  
  public final void aDi()
  {
    AppMethodBeat.i(27449);
    if ((this.HdA) && (this.Hdu.RXu != null) && (this.Hdu.RXu.RWD != null) && (this.Hdu.RXu.RWD.RXo == 0)) {
      b(this.contact.field_username, this.Hdu.RXu.RWD.RXn);
    }
    AppMethodBeat.o(27449);
  }
  
  public final boolean aEt()
  {
    AppMethodBeat.i(27465);
    if ((this.contact == null) || (this.GXj == null) || (this.Hdu == null) || (this.Hdu.RXt == null) || (this.Hdu.RXs == null))
    {
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportEnd fail, err");
      this.sCy.dead();
      this.ozM.dead();
      AppMethodBeat.o(27465);
      return false;
    }
    this.endTime = System.currentTimeMillis();
    String str = this.contact.field_username;
    int k = this.mXL;
    int m = this.GXj.field_type;
    long l1 = this.enterTime;
    long l2 = this.endTime;
    int i;
    label134:
    int n;
    int i1;
    if (com.tencent.mm.contact.d.rk(this.contact.field_type))
    {
      i = 1;
      n = this.Hdu.RXt.RTV;
      i1 = this.Hdu.RXt.RTW;
      if (this.GYU == null) {
        break label231;
      }
    }
    label231:
    for (int j = this.GYU.size();; j = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, k, m, l1, l2, i, n, i1, j, com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.c(this.Hdu.RXu), com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(this.Hdu.RXx), this.Hdu.RXs.UserName);
      break;
      i = 0;
      break label134;
    }
  }
  
  final void aby(int paramInt)
  {
    AppMethodBeat.i(27463);
    if ((this.GZe == null) || ((this.mXL != 39) && (this.mXL != 56) && (this.mXL != 35) && (this.mXL != 87) && (this.mXL != 88) && (this.mXL != 89) && (this.mXL != 85)))
    {
      Log.d("MicroMsg.ContactWidgetNewBizInfo", "mExtArgs is null or the add contact action is not from biz search.");
      AppMethodBeat.o(27463);
      return;
    }
    if (this.contact == null)
    {
      Log.i("MicroMsg.ContactWidgetNewBizInfo", "contact is null.");
      AppMethodBeat.o(27463);
      return;
    }
    String str2 = this.GZe.getString("Contact_Ext_Args_Search_Id");
    String str3 = Util.nullAsNil(this.GZe.getString("Contact_Ext_Args_Query_String"));
    int j = this.GZe.getInt("Contact_Ext_Args_Index");
    int i;
    switch (this.mXL)
    {
    default: 
      i = 0;
      str1 = Util.nullAsNil(this.GZe.getString("Contact_Ext_Extra_Params"));
      str2 = str3 + "," + paramInt + "," + Util.nullAsNil(this.contact.field_username) + "," + j + "," + System.currentTimeMillis() / 1000L + "," + str2 + "," + i;
      if (Util.isNullOrNil(null)) {
        break;
      }
    }
    for (String str1 = str2 + "," + null + "," + str1;; str1 = str2 + ",," + str1)
    {
      Log.v("MicroMsg.ContactWidgetNewBizInfo", "report 10866: %s", new Object[] { str1 });
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(10866, str1);
      AppMethodBeat.o(27463);
      return;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      i = 5;
      break;
    }
  }
  
  public final long amU()
  {
    return this.enterTime;
  }
  
  public final boolean atw(String paramString)
  {
    AppMethodBeat.i(27457);
    if (Util.isNullOrNil(paramString))
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key is null, return");
      AppMethodBeat.o(27457);
      return false;
    }
    Log.i("MicroMsg.ContactWidgetNewBizInfo", "handleEvent key:%s, blockAddContact: %b", new Object[] { paramString, Boolean.valueOf(this.Hdy) });
    if ("contact_info_biz_add".endsWith(paramString))
    {
      if (this.Hdy)
      {
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(this.Hdt);
        if ((this.contact != null) && (this.contact.field_username != null)) {
          ((com.tencent.mm.api.q)com.tencent.mm.kernel.h.ae(com.tencent.mm.api.q.class)).d(7, this.contact.field_username, this.contact.field_nickname);
        }
        AppMethodBeat.o(27457);
        return true;
      }
      if (!com.tencent.mm.model.gdpr.c.bgq()) {
        fqj();
      }
      for (;;)
      {
        if (this.GYZ != 0) {
          com.tencent.mm.plugin.report.service.h.IzE.a(11263, new Object[] { Integer.valueOf(this.GYZ), this.contact.field_username });
        }
        com.tencent.mm.plugin.profile.ui.newbizinfo.c.c.c(this.contact.field_username, 200, this.mXL, this.enterTime);
        AppMethodBeat.o(27457);
        return true;
        com.tencent.mm.model.gdpr.c.a(this.Hdt, com.tencent.mm.model.gdpr.a.lwP, this.contact.field_username, new com.tencent.mm.model.gdpr.b()
        {
          public final void vu(int paramAnonymousInt)
          {
            AppMethodBeat.i(272603);
            if (paramAnonymousInt == 0) {
              ContactWidgetNewBizInfo.p(ContactWidgetNewBizInfo.this);
            }
            AppMethodBeat.o(272603);
          }
        });
      }
    }
    AppMethodBeat.o(27457);
    return true;
  }
  
  public final boolean cQX()
  {
    AppMethodBeat.i(27455);
    if (this.screen == null)
    {
      AppMethodBeat.o(27455);
      return true;
    }
    Object localObject = (NewBizInfoHeaderPreference)this.screen.byG("contact_info_header_newbizinfo");
    if (localObject != null) {
      ((NewBizInfoHeaderPreference)localObject).onDetach();
    }
    localObject = this.Hdt.getListView();
    if (localObject != null) {
      this.HdB = ((ListView)localObject).onSaveInstanceState();
    }
    AppMethodBeat.o(27455);
    return true;
  }
  
  public final as fqR()
  {
    return this.contact;
  }
  
  public final int fqU()
  {
    return this.mXL;
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(27444);
    Log.i("MicroMsg.ContactWidgetNewBizInfo", "[onActivityDestroy]");
    cQX();
    AppMethodBeat.o(27444);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(27456);
    if (this.Hdt == null)
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "null == context");
      AppMethodBeat.o(27456);
      return;
    }
    Log.i("MicroMsg.ContactWidgetNewBizInfo", "onActivityResult, requestCode = %d, resultCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(27456);
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      String str1 = paramIntent.getStringExtra("be_send_card_name");
      String str2 = paramIntent.getStringExtra("received_card_name");
      boolean bool = paramIntent.getBooleanExtra("Is_Chatroom", false);
      paramIntent = paramIntent.getStringExtra("custom_send_text");
      com.tencent.mm.plugin.messenger.a.g.eRW().u(str1, str2, bool);
      com.tencent.mm.plugin.messenger.a.g.eRW().iQ(paramIntent, str2);
      com.tencent.mm.ui.widget.snackbar.b.r(this.Hdt, this.Hdt.getString(R.l.finish_sent));
      AppMethodBeat.o(27456);
      return;
    }
    AppMethodBeat.o(27456);
  }
  
  public final boolean onCreate()
  {
    AppMethodBeat.i(27464);
    Log.v("MicroMsg.ContactWidgetNewBizInfo", "alvinluo ContactWidgetNewBizInfo onCreate");
    if ((this.contact == null) || (this.GXj == null))
    {
      Log.w("MicroMsg.ContactWidgetNewBizInfo", "reportStart fail, err");
      this.sCy.alive();
      this.ozM.alive();
      AppMethodBeat.o(27464);
      return false;
    }
    String str = this.contact.field_username;
    int j = this.mXL;
    int k = this.GXj.field_type;
    long l = this.enterTime;
    if (com.tencent.mm.contact.d.rk(this.contact.field_type)) {}
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.profile.ui.newbizinfo.c.a.a(str, j, k, l, i, this.Hdw);
      break;
    }
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(27461);
    Log.d("MicroMsg.ContactWidgetNewBizInfo", "onSceneEnd errType = " + paramInt1 + ", errCode = " + paramInt2 + ",errMsg = " + paramString);
    if ((this.tipDialog != null) && (this.tipDialog.isShowing())) {
      this.tipDialog.dismiss();
    }
    if (paramq == null)
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "scene == null");
      AppMethodBeat.o(27461);
      return;
    }
    bh.aGY().b(paramq.getType(), this);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(27461);
      return;
    }
    Log.d("MicroMsg.ContactWidgetNewBizInfo", "scene.getType() = %s", new Object[] { Integer.valueOf(paramq.getType()) });
    if (paramq.getType() == 536)
    {
      bh.aGY().b(536, this);
      fqh();
    }
    AppMethodBeat.o(27461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.ContactWidgetNewBizInfo
 * JD-Core Version:    0.7.0.1
 */