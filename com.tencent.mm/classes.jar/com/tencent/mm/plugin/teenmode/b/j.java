package com.tencent.mm.plugin.teenmode.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.view.custom.dialog.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.plugin.teenmode.a.d.a;
import com.tencent.mm.plugin.teenmode.a.g;
import com.tencent.mm.plugin.teenmode.ui.AuthorizationDetailUI;
import com.tencent.mm.plugin.teenmode.ui.AuthorizationRequestUI;
import com.tencent.mm.plugin.teenmode.ui.BindGuardianMsgUI;
import com.tencent.mm.pluginsdk.ui.applet.y.b;
import com.tencent.mm.protocal.protobuf.abs;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class j
  implements d
{
  private int SYS;
  private Set<g> SYT;
  private Map<Integer, com.tencent.mm.plugin.teenmode.a.a> SYU;
  private HashMap<Integer, b> SYV;
  public String hFb;
  public int qfP;
  
  private j()
  {
    AppMethodBeat.i(278889);
    this.SYS = 0;
    this.SYT = new CopyOnWriteArraySet();
    this.qfP = 1;
    this.SYU = new HashMap();
    this.SYV = new HashMap();
    AppMethodBeat.o(278889);
  }
  
  private boolean a(final Activity paramActivity, final int paramInt1, final int paramInt2, final String paramString, final DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(278875);
    if (!((d)com.tencent.mm.kernel.h.ax(d.class)).aBu())
    {
      AppMethodBeat.o(278875);
      return false;
    }
    final w localw = k.a(paramActivity, "", false, null);
    new f().bFJ().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(278875);
    return true;
  }
  
  public static void b(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(278902);
    Intent localIntent = new Intent(paramActivity, AuthorizationRequestUI.class);
    localIntent.putExtra("intent_extra_type", paramInt2);
    localIntent.putExtra("intent_extra_key", paramString1);
    localIntent.putExtra("intent_extra_title", paramString2);
    localIntent.putExtra("intent_extra_digest", paramString3);
    localIntent.putExtra("intent_extra_content", paramString4);
    localIntent.putExtra("intent_extra_can_auth", paramBoolean);
    paramString2 = a.SYz;
    a.a(paramInt2, paramString1, parama);
    if (paramInt1 > 0)
    {
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt1, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/plugin/teenmode/model/TeenModeService", "doJumpToSendAuthorizationReqUI", "(Landroid/app/Activity;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mm/plugin/teenmode/api/ITeenModeService$AuthorizationReqResultCallback;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(278902);
      return;
    }
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramString1.aYi(), "com/tencent/mm/plugin/teenmode/model/TeenModeService", "doJumpToSendAuthorizationReqUI", "(Landroid/app/Activity;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mm/plugin/teenmode/api/ITeenModeService$AuthorizationReqResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/teenmode/model/TeenModeService", "doJumpToSendAuthorizationReqUI", "(Landroid/app/Activity;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/tencent/mm/plugin/teenmode/api/ITeenModeService$AuthorizationReqResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(278902);
  }
  
  public static j hEy()
  {
    return a.SZd;
  }
  
  public final <T extends com.tencent.mm.plugin.teenmode.a.a> void a(int paramInt, T paramT)
  {
    AppMethodBeat.i(279059);
    this.SYU.put(Integer.valueOf(paramInt), paramT);
    AppMethodBeat.o(279059);
  }
  
  public final void a(int paramInt, b paramb)
  {
    AppMethodBeat.i(279084);
    this.SYV.put(Integer.valueOf(paramInt), paramb);
    AppMethodBeat.o(279084);
  }
  
  public final void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, d.a parama)
  {
    AppMethodBeat.i(279008);
    b(paramActivity, paramInt1, paramInt2, paramString1, paramString2, paramString3, paramString4, paramBoolean, parama);
    AppMethodBeat.o(279008);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, String paramString4, Boolean paramBoolean)
  {
    AppMethodBeat.i(279016);
    Intent localIntent = new Intent(paramContext, AuthorizationDetailUI.class);
    localIntent.putExtra("intent_extra_msg_content", paramString3);
    localIntent.putExtra("intent_extra_cdn_img_path", paramString4);
    localIntent.putExtra("intent_extra_guardian_username", paramString1);
    localIntent.putExtra("intent_extra_ward_username", paramString2);
    localIntent.putExtra("intent_extra_request_time", paramLong1);
    localIntent.putExtra("intent_extra_msg_svrid", paramLong2);
    localIntent.putExtra("intent_extra_need_anim", paramBoolean);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/teenmode/model/TeenModeService", "jumpToAuthorizationMsgUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/teenmode/model/TeenModeService", "jumpToAuthorizationMsgUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(279016);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    AppMethodBeat.i(278999);
    Intent localIntent = new Intent(paramContext, BindGuardianMsgUI.class);
    localIntent.putExtra("intent_extra_bind_guardian_username", paramString1);
    localIntent.putExtra("intent_extra_bind_ward_username", paramString2);
    localIntent.putExtra("intent_extra_bind_ticket", paramString3);
    localIntent.putExtra("intent_extra_request_time", paramLong);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramString1.aYi(), "com/tencent/mm/plugin/teenmode/model/TeenModeService", "jumpToBindGuardianUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/teenmode/model/TeenModeService", "jumpToBindGuardianUI", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(278999);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(278966);
    if (paramg != null) {
      this.SYT.add(paramg);
    }
    AppMethodBeat.o(278966);
  }
  
  public final boolean a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, y.b paramb, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(279078);
    boolean bool;
    if (paramInt1 == 1)
    {
      bool = a(paramActivity, 0, paramInt2, paramString1, paramOnDismissListener);
      AppMethodBeat.o(279078);
      return bool;
    }
    if (paramInt1 == 2)
    {
      bool = a(paramActivity, paramInt2, paramString1, paramString2, paramString3, paramString4, paramArrayOfByte, paramb);
      AppMethodBeat.o(279078);
      return bool;
    }
    AppMethodBeat.o(279078);
    return false;
  }
  
  public final boolean a(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, y.b paramb)
  {
    AppMethodBeat.i(279026);
    au localau = hEu();
    if (localau == null)
    {
      AppMethodBeat.o(279026);
      return false;
    }
    a.a locala = new a.a(paramContext);
    locala.fI(localau.field_username).aCJ(paramContext.getString(a.g.teen_mode_authorization_prefix) + paramString2).x(Boolean.TRUE).UL(a.g.app_send);
    locala.a(new j.3(this, paramString2, paramString3, paramInt, paramString1, paramString4, localau, paramArrayOfByte, paramContext, paramb));
    locala.pRv.show();
    AppMethodBeat.o(279026);
    return true;
  }
  
  public final boolean aBu()
  {
    AppMethodBeat.i(278923);
    boolean bool = Util.nullAsFalse(Boolean.valueOf(com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.acQt, false)));
    Log.d("MicroMsg.TeenModeService", "isTeenMode:%s", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(278923);
    return bool;
  }
  
  public final com.tencent.mm.plugin.teenmode.a.a aoi(int paramInt)
  {
    AppMethodBeat.i(279066);
    com.tencent.mm.plugin.teenmode.a.a locala = (com.tencent.mm.plugin.teenmode.a.a)this.SYU.get(Integer.valueOf(paramInt));
    if (locala != null)
    {
      AppMethodBeat.o(279066);
      return locala;
    }
    locala = (com.tencent.mm.plugin.teenmode.a.a)this.SYU.get(Integer.valueOf(2147483647));
    AppMethodBeat.o(279066);
    return locala;
  }
  
  public final b aoj(int paramInt)
  {
    AppMethodBeat.i(279092);
    b localb = (b)this.SYV.get(Integer.valueOf(paramInt));
    Object localObject = localb;
    if (localb == null) {
      localObject = c.SYG;
    }
    AppMethodBeat.o(279092);
    return localObject;
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(278975);
    if (paramg != null) {
      this.SYT.remove(paramg);
    }
    AppMethodBeat.o(278975);
  }
  
  public final boolean bdk(String paramString)
  {
    AppMethodBeat.i(279042);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().ayT(536870912);
    au localau;
    do
    {
      if (!localCursor.moveToNext()) {
        break;
      }
      localau = new au();
      localau.convertFrom(localCursor);
    } while (!localau.field_username.equalsIgnoreCase(paramString));
    for (paramString = localau;; paramString = null)
    {
      localCursor.close();
      if (paramString != null)
      {
        AppMethodBeat.o(279042);
        return true;
      }
      AppMethodBeat.o(279042);
      return false;
    }
  }
  
  public final boolean jdMethod_do(int paramInt, String paramString)
  {
    AppMethodBeat.i(279053);
    com.tencent.mm.plugin.teenmode.b.a.e locale = com.tencent.mm.plugin.teenmode.b.a.e.SZq;
    paramString = com.tencent.mm.plugin.teenmode.b.a.e.hEB().b(paramInt, paramString, 0L);
    if ((!aoj(paramInt).aE(paramString.field_time, cn.bDu())) && (z.bAM().equals(paramString.field_wardUserName)))
    {
      AppMethodBeat.o(279053);
      return true;
    }
    AppMethodBeat.o(279053);
    return false;
  }
  
  public final int eZD()
  {
    AppMethodBeat.i(278932);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acQu, 2);
    Log.d("MicroMsg.TeenModeService", "getFinderOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(278932);
    return i;
  }
  
  public final void hEp()
  {
    AppMethodBeat.i(278927);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQt, Boolean.FALSE);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acQs, Boolean.TRUE);
    ((d)com.tencent.mm.kernel.h.ax(d.class)).hEs();
    ((d)com.tencent.mm.kernel.h.ax(d.class)).rG(4);
    cas localcas = new cas();
    localcas.aajJ = 59;
    localcas.NkL = 2;
    if (this.hFb != null)
    {
      localcas.aajK = new gol();
      localcas.aajK.df(this.hFb.getBytes());
    }
    localcas.aajL = this.qfP;
    ((n)com.tencent.mm.kernel.h.ax(n.class)).bzz().d(new k.a(23, localcas));
    AppMethodBeat.o(278927);
  }
  
  public final int hEq()
  {
    AppMethodBeat.i(278939);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acQv, 0);
    Log.d("MicroMsg.TeenModeService", "getBizAcctOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(278939);
    return i;
  }
  
  public final int hEr()
  {
    AppMethodBeat.i(278941);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.acQw, 0);
    Log.d("MicroMsg.TeenModeService", "getMiniProgramOption, option:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(278941);
    return i;
  }
  
  public final void hEs()
  {
    AppMethodBeat.i(278985);
    Log.d("MicroMsg.TeenModeService", "notifyTeenModeDataChanged %d", new Object[] { Integer.valueOf(this.SYT.size()) });
    Iterator localIterator = this.SYT.iterator();
    while (localIterator.hasNext()) {
      ((g)localIterator.next()).onDataChanged();
    }
    AppMethodBeat.o(278985);
  }
  
  public final boolean hEt()
  {
    AppMethodBeat.i(278961);
    String str = (String)com.tencent.mm.kernel.h.baE().ban().d(274436, null);
    if ((!Util.isNullOrNil(str)) && (str.toUpperCase().equals("CN"))) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, not in china, hide entrance.");
      AppMethodBeat.o(278961);
      return true;
    }
    str = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue("ShowTeenagerMode");
    if (Util.isNullOrNil(str))
    {
      Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, ShowTeenagerMode is null");
      AppMethodBeat.o(278961);
      return false;
    }
    i = Integer.parseInt(str);
    Log.i("MicroMsg.TeenModeService", "isHideTeenModeEntrance, val is %s", new Object[] { Integer.valueOf(i) });
    if ((str != null) && (1 == i))
    {
      AppMethodBeat.o(278961);
      return true;
    }
    AppMethodBeat.o(278961);
    return false;
  }
  
  public final au hEu()
  {
    AppMethodBeat.i(279033);
    Cursor localCursor = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().ayT(1073741824);
    au localau = null;
    while (localCursor.moveToNext())
    {
      localau = new au();
      localau.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(279033);
    return localau;
  }
  
  public final HashMap<Integer, String> hEv()
  {
    AppMethodBeat.i(279073);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1), MMApplicationContext.getString(a.g.SYj));
    if (hEu() != null) {
      localHashMap.put(Integer.valueOf(2), MMApplicationContext.getString(a.g.SWS));
    }
    AppMethodBeat.o(279073);
    return localHashMap;
  }
  
  public final void kg(Context paramContext)
  {
    AppMethodBeat.i(278947);
    aa.y(paramContext, paramContext.getString(a.g.SXR), a.f.icons_outlined_umbrella);
    AppMethodBeat.o(278947);
  }
  
  public final void kh(final Context paramContext)
  {
    AppMethodBeat.i(278980);
    boolean bool = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
    ((d)com.tencent.mm.kernel.h.ax(d.class)).setScene(1);
    ((d)com.tencent.mm.kernel.h.ax(d.class)).rG(1);
    this.hFb = null;
    this.qfP = 1;
    if (!bool)
    {
      com.tencent.mm.br.c.b(paramContext, "teenmode", ".ui.SettingsTeenModeIntro", new Intent());
      AppMethodBeat.o(278980);
      return;
    }
    final w localw = k.a(paramContext, paramContext.getString(a.g.loading_tips_1), false, null);
    new f().bFJ().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(278980);
  }
  
  public final void n(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(278988);
    a(paramActivity, paramInt, 0, null, null);
    AppMethodBeat.o(278988);
  }
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(278951);
    com.tencent.mm.plugin.report.service.h.OAn.b(20917, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.SYS) });
    AppMethodBeat.o(278951);
  }
  
  public final void setScene(int paramInt)
  {
    this.SYS = paramInt;
  }
  
  static final class a
  {
    public static j SZd;
    
    static
    {
      AppMethodBeat.i(278928);
      SZd = new j((byte)0);
      AppMethodBeat.o(278928);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.j
 * JD-Core Version:    0.7.0.1
 */