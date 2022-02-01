package com.tencent.mm.plugin.profile;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.R.o;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.tu;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.la;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.openim.api.g.a;
import com.tencent.mm.openim.api.g.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.bv;
import com.tencent.mm.plugin.findersdk.a.ca;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.plugin.profile.logic.OpenIMPreference;
import com.tencent.mm.plugin.profile.ui.MultiButtonPreference;
import com.tencent.mm.plugin.profile.ui.MultiSummaryPreference;
import com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI;
import com.tencent.mm.plugin.profile.ui.PermissionSettingUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI2;
import com.tencent.mm.plugin.profile.ui.SayHiWithSnsPermissionUI3;
import com.tencent.mm.plugin.profile.ui.r;
import com.tencent.mm.plugin.sns.c.k.a;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.story.api.AbsStoryPreference;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.pluginsdk.ui.preference.FinderPreference;
import com.tencent.mm.pluginsdk.ui.preference.FinderRecentLikePreference;
import com.tencent.mm.pluginsdk.ui.preference.LabelPreference;
import com.tencent.mm.pluginsdk.ui.preference.PhoneNumPreference;
import com.tencent.mm.pluginsdk.ui.preference.ProfileDescribePreference;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.coy;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.fvk;
import com.tencent.mm.protocal.protobuf.fvm;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cr;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.preference.TextPreference.a;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.f.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a
  implements k.a, com.tencent.mm.plugin.story.api.d, com.tencent.mm.pluginsdk.c.b
{
  public static boolean MTT = false;
  private boolean MTM;
  private boolean MTN;
  private boolean MTO;
  private boolean MTP;
  private com.tencent.mm.plugin.profile.logic.b MTQ;
  private boolean MTR;
  private final List<String> MTS;
  boolean MTV;
  private MultiButtonPreference MTW;
  private com.tencent.mm.ui.widget.a.f MTX;
  private String MTY;
  IListener<com.tencent.mm.autogen.a.bo> MTZ;
  private boolean MUa;
  private long lastUpdateTime;
  private String lyn;
  private aj lzy;
  private int mScene;
  private com.tencent.mm.ui.base.preference.f pkD;
  private boolean readOnly;
  private MMActivity wry;
  private au xVS;
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(26836);
    this.readOnly = false;
    this.MTM = false;
    this.MTN = false;
    this.MTO = false;
    this.MTP = false;
    this.MTS = new LinkedList();
    this.MTV = false;
    this.MTY = null;
    this.MTZ = new NewContactWidgetNormal.17(this, com.tencent.mm.app.f.hfK);
    this.MUa = false;
    this.lastUpdateTime = 0L;
    this.wry = paramMMActivity;
    AppMethodBeat.o(26836);
  }
  
  private static void a(Activity paramActivity, au paramau, int paramInt, String paramString1, String paramString2, long paramLong, String paramString3)
  {
    AppMethodBeat.i(305457);
    String str = paramActivity.getIntent().getStringExtra("room_name");
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
    int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
    SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
    Object localObject;
    if ((!au.bwO(paramau.field_username)) && (i == 1))
    {
      localObject = SayHiWithSnsPermissionUI2.class;
      localObject = new Intent(paramActivity, (Class)localObject);
      ((Intent)localObject).putExtra("Contact_User", paramau.field_username);
      ((Intent)localObject).putExtra("Contact_Nick", paramau.field_nickname);
      ((Intent)localObject).putExtra("Contact_RemarkName", paramau.field_conRemark);
      if ((paramInt != 14) && (paramInt != 8)) {
        break label393;
      }
      ((Intent)localObject).putExtra("Contact_RoomNickname", paramActivity.getIntent().getStringExtra("Contact_RoomNickname"));
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("Contact_Scene", paramInt);
      ((Intent)localObject).putExtra("Contact_Source_Add", paramActivity.getIntent().getIntExtra("Contact_Source_Add", -1));
      ((Intent)localObject).putExtra("room_name", str);
      ((Intent)localObject).putExtra("source_from_user_name", paramString1);
      ((Intent)localObject).putExtra("source_from_nick_name", paramString2);
      ((Intent)localObject).putExtra("sayhi_with_sns_perm_send_verify", true);
      ((Intent)localObject).putExtra("sayhi_with_sns_perm_add_remark", true);
      ((Intent)localObject).putExtra("sayhi_with_sns_perm_set_label", false);
      ((Intent)localObject).putExtra(f.e.adwe, paramString3);
      ((Intent)localObject).putExtra("sayhi_verify_add_errcode", -1);
      ((Intent)localObject).putExtra("key_msg_id", paramLong);
      paramau = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramau.aYi(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramau.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "gotoSayHiPage", "(Landroid/app/Activity;Lcom/tencent/mm/storage/Contact;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(305457);
      return;
      localObject = localSayHiWithSnsPermissionUI;
      if (au.bwO(paramau.field_username)) {
        break;
      }
      localObject = localSayHiWithSnsPermissionUI;
      if (i != 2) {
        break;
      }
      localObject = localSayHiWithSnsPermissionUI;
      if (ab.bBW() < j) {
        break;
      }
      localObject = SayHiWithSnsPermissionUI3.class;
      break;
      label393:
      if (paramInt == 17) {
        ((Intent)localObject).putExtra("key_msg_id", paramActivity.getIntent().getLongExtra("key_msg_id", 0L));
      }
    }
  }
  
  private void a(final au paramau, final Context paramContext)
  {
    AppMethodBeat.i(26850);
    this.MTX = new com.tencent.mm.ui.widget.a.f(this.wry, 1, false);
    this.MTX.Vtg = new u.g()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymouss)
      {
        AppMethodBeat.i(305421);
        paramAnonymouss.bx(2, R.l.app_field_voip, R.k.sharemore_videovoip);
        paramAnonymouss.bx(1, R.l.app_field_voipaudio, R.k.sharemore_voipvoice);
        AppMethodBeat.o(305421);
      }
    };
    this.MTX.GAC = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(305412);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(305412);
          return;
          a.c(paramau, paramContext);
          AppMethodBeat.o(305412);
          return;
          a.b(paramau, paramContext);
        }
      }
    };
    this.MTX.dDn();
    AppMethodBeat.o(26850);
  }
  
  private static void a(com.tencent.mm.ui.base.preference.f paramf, Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(26853);
    Log.i("MicroMsg.NewContactWidgetNormal", "[showInviterView] inviter:%s inviterDisplayName:%s", new Object[] { paramString1, paramString2 });
    KeyValuePreference localKeyValuePreference = (KeyValuePreference)paramf.bAi("contact_info_invite_source");
    paramf.eh("contact_info_invite_source", false);
    paramf = new SpannableString(com.tencent.mm.pluginsdk.ui.span.p.b(paramActivity, paramActivity.getResources().getString(R.l.gBt, new Object[] { paramString2 })));
    paramf.setSpan(new ForegroundColorSpan(paramActivity.getResources().getColor(R.e.brand_text_color)), 0, paramString2.length(), 33);
    localKeyValuePreference.aBm(2);
    localKeyValuePreference.adZa = false;
    localKeyValuePreference.aS(paramf);
    localKeyValuePreference.getExtras().putString("inviter", paramString1);
    paramActivity.getIntent().putExtra("inviteer", paramString1);
    AppMethodBeat.o(26853);
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(26838);
    boolean bool1;
    if (gAH())
    {
      paramf.eh("contact_profile_setting_desc", true);
      paramf.eh("contact_profile_setting_permission", true);
      paramf.eh("contact_profile_phone", true);
      paramf.eh("contact_profile_info_more", true);
      paramf.eh("contact_profile_sns", au.bwO(paramau.field_username));
      if ((z.bAR() & 0x10000000) != 0L)
      {
        bool1 = true;
        boolean bool2 = u.y(this.wry, "com.tencent.wework");
        bh.bCz();
        Object localObject = (Integer)com.tencent.mm.model.c.ban().get(at.a.acIG, Integer.valueOf(0));
        Log.i("MicroMsg.NewContactWidgetNormal", "ExtStatus:%s openAddByWework:%s isInstallWework:%s", new Object[] { Long.valueOf(z.bAR()), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((!Util.isEqual(((Integer)localObject).intValue(), 1)) && ((!bool1) || (!u.y(this.wry, "com.tencent.wework")))) {
          break label334;
        }
        paramf.eh("contact_profile_accept_contact_by_wework", false);
        localObject = r.a(this.wry, paramau, this.mScene);
        if ((localObject == null) || (localObject.length <= 0)) {
          break label443;
        }
      }
    }
    label443:
    for (paramau = r.b(this.wry, paramau, this.mScene);; paramau = "")
    {
      if (com.tencent.mm.plugin.profile.a.e.aRT(this.xVS.field_username)) {
        ((ButtonPreference)paramf.bAi("contact_profile_accept_contact_by_wework")).iN(this.wry.getString(R.l.contact_info_goto_wework_send_msg), this.wry.getResources().getColor(R.e.brand_text_color));
      }
      if ((!Util.isNullOrNil(paramau)) && (com.tencent.mm.plugin.profile.a.e.aRS(paramau) == 2) && (paramBoolean)) {
        paramf.eh("contact_profile_accept_contact", true);
      }
      AppMethodBeat.o(26838);
      return;
      bool1 = false;
      break;
      label334:
      if (this.wry.getIntent().getBooleanExtra("isVerifyExpired", false))
      {
        paramau = (ButtonPreference)paramf.bAi("contact_profile_accept_contact");
        paramau.iN(this.wry.getString(R.l.gqz), this.wry.getResources().getColor(R.e.disable_text_color));
        paramau.setEnabled(false);
      }
      paramf.eh("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
      paramf.eh("contact_profile_accept_contact", true);
      paramf.eh("contact_profile_accept_contact_by_wework", true);
      AppMethodBeat.o(26838);
      return;
    }
  }
  
  private void a(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    AppMethodBeat.i(305460);
    if ((paramObject instanceof fvk))
    {
      paramf = (NormalProfileHeaderPreference)paramf.bAi("contact_profile_header_normal");
      if (paramf != null)
      {
        paramf.MYm = ((fvk)paramObject).contact;
        this.pkD.notifyDataSetChanged();
      }
      AppMethodBeat.o(305460);
      return;
    }
    paramf = (NormalProfileHeaderPreference)paramf.bAi("contact_profile_header_normal");
    if (paramf != null)
    {
      paramf.MYm = null;
      this.pkD.notifyDataSetChanged();
    }
    AppMethodBeat.o(305460);
  }
  
  public static void b(au paramau, Context paramContext)
  {
    AppMethodBeat.i(305456);
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, "android.permission.CAMERA", 19, "");
    Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), paramContext });
    if (!bool)
    {
      AppMethodBeat.o(305456);
      return;
    }
    bool = com.tencent.mm.pluginsdk.permission.b.a((Activity)paramContext, "android.permission.RECORD_AUDIO", 19, "");
    Log.i("MicroMsg.NewContactWidgetNormal", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), paramContext });
    if (!bool)
    {
      AppMethodBeat.o(305456);
      return;
    }
    acn localacn = new acn();
    localacn.ifU.hId = 5;
    localacn.ifU.talker = paramau.field_username;
    localacn.ifU.context = paramContext;
    localacn.ifU.ifQ = 2;
    localacn.publish();
    AppMethodBeat.o(305456);
  }
  
  private void b(com.tencent.mm.ui.base.preference.f paramf)
  {
    AppMethodBeat.i(305428);
    if ((this.MTW == null) || (paramf == null))
    {
      AppMethodBeat.o(305428);
      return;
    }
    if (!paramf.bAj("contact_profile_multi_button")) {
      paramf.eh("line3", true);
    }
    AppMethodBeat.o(305428);
  }
  
  private void b(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    AppMethodBeat.i(305462);
    Object localObject;
    FinderPreference localFinderPreference;
    if ((paramObject instanceof fvk))
    {
      localObject = (fvk)paramObject;
      localFinderPreference = (FinderPreference)paramf.bAi(FinderPreference.NAME);
      if (localFinderPreference == null)
      {
        Log.e("MicroMsg.NewContactWidgetNormal", "preference is null!");
        AppMethodBeat.o(305462);
        return;
      }
      if (((fvk)localObject).contact == null)
      {
        paramf.eh(FinderPreference.NAME, true);
        d.cD(this.xVS.field_username, this.MUa);
        d.b(this.wry.getIntent(), 33, 1, this.xVS.field_username);
      }
    }
    for (;;)
    {
      a(paramf, paramObject);
      AppMethodBeat.o(305462);
      return;
      if (!this.MUa) {
        com.tencent.mm.plugin.report.service.h.OAn.b(21908, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(1) });
      }
      paramf.eh(FinderPreference.NAME, false);
      localFinderPreference.a((fvk)localObject);
      this.MUa = true;
      if (!this.MTM) {
        break;
      }
      localObject = paramf.bAi("openim_pref_key_info");
      if (!(localObject instanceof OpenIMPreference)) {
        break;
      }
      ((OpenIMPreference)localObject).MUA = true;
      paramf.notifyDataSetChanged();
      break;
      paramf.eh(FinderPreference.NAME, true);
    }
  }
  
  private void b(String paramString, au paramau)
  {
    AppMethodBeat.i(26849);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.NewContactWidgetNormal", "view stranger remark, username is null");
      AppMethodBeat.o(26849);
      return;
    }
    paramString = new Intent();
    paramString.putExtra("Contact_Scene", this.mScene);
    paramString.putExtra("Contact_mode_name_type", 0);
    paramString.putExtra("Contact_ModStrangerRemark", true);
    paramString.putExtra("Contact_User", paramau.field_username);
    paramString.putExtra("Contact_Nick", paramau.field_nickname);
    paramString.putExtra("Contact_RemarkName", paramau.field_conRemark);
    paramString.putExtra("Contact_RoomNickname", this.wry.getIntent().getStringExtra("Contact_RoomNickname"));
    int i = this.wry.getIntent().getIntExtra("key_label_click_source", 0);
    if (i != 0) {
      paramString.putExtra("CONTACT_INFO_UI_SOURCE", i);
    }
    b.pFn.l(paramString, this.wry);
    AppMethodBeat.o(26849);
  }
  
  private static String c(aj paramaj, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(26854);
    if (paramaj == null)
    {
      AppMethodBeat.o(26854);
      return null;
    }
    bh.bCz();
    au localau = com.tencent.mm.model.c.bzA().JE(paramString);
    Object localObject1 = localObject2;
    if (localau != null)
    {
      localObject1 = localObject2;
      if ((int)localau.maN > 0) {
        localObject1 = localau.field_conRemark;
      }
    }
    localObject2 = localObject1;
    if (Util.isNullOrNil((String)localObject1)) {
      localObject2 = paramaj.getDisplayName(paramString);
    }
    paramaj = (aj)localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      paramaj = (aj)localObject2;
      if (localau != null) {
        paramaj = localau.aSU();
      }
    }
    AppMethodBeat.o(26854);
    return paramaj;
  }
  
  private void c(com.tencent.mm.ui.base.preference.f paramf, Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(305465);
    if (((paramObject instanceof fvk)) && (!this.MTM) && (!this.MTN))
    {
      paramObject = (fvk)paramObject;
      if (paramObject.aahj == 1)
      {
        paramf.eh("contact_profile_finder_recent_like", false);
        FinderRecentLikePreference localFinderRecentLikePreference = (FinderRecentLikePreference)paramf.bAi("contact_profile_finder_recent_like");
        if (!paramf.bAj(FinderPreference.NAME))
        {
          paramf = localObject;
          if (paramObject.aahk != null)
          {
            paramf = localObject;
            if (!Util.isNullOrNil(paramObject.aahk.ZJE))
            {
              paramf = new fvm();
              paramf.ZIQ.addAll(paramObject.aahk.ZJE);
            }
          }
          localFinderRecentLikePreference.a(paramf);
          AppMethodBeat.o(305465);
          return;
        }
        localFinderRecentLikePreference.a(null);
        AppMethodBeat.o(305465);
        return;
      }
    }
    paramf.eh("contact_profile_finder_recent_like", true);
    AppMethodBeat.o(305465);
  }
  
  private void gAC()
  {
    boolean bool2 = true;
    AppMethodBeat.i(305427);
    if (!this.pkD.bAj("contact_profile_add_contact"))
    {
      Log.i("MicroMsg.NewContactWidgetNormal", "updateAddContactPrefenceState, prefence no show. ");
      AppMethodBeat.o(305427);
      return;
    }
    ButtonPreference localButtonPreference = (ButtonPreference)this.pkD.bAi("contact_profile_add_contact");
    bn localbn = com.tencent.mm.modelverify.d.bNI().aLu(this.xVS.field_username);
    long l = com.tencent.mm.k.i.aRC().getInt("VerifyUserTicketTimeExceed", 259200);
    if ((localbn != null) && (localbn.field_state == 2) && (com.tencent.mm.model.cn.bDv() - localbn.field_lastModifiedTime < l * 1000L))
    {
      bool1 = true;
      this.MTO = bool1;
      bool1 = this.wry.getIntent().getBooleanExtra("Contact_ToProfilePageFromSource", false);
      if ((!this.MTO) || (!bool1)) {
        break label238;
      }
    }
    label238:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.MTO = bool1;
      if (localButtonPreference == null) {
        break label300;
      }
      if (!this.MTO) {
        break label243;
      }
      localButtonPreference.setTitle(this.wry.getResources().getString(R.l.gqA));
      localButtonPreference.iN(this.wry.getResources().getString(R.l.gqA), this.wry.getResources().getColor(R.e.FG_2));
      localButtonPreference.aBd(R.g.white_bg);
      AppMethodBeat.o(305427);
      return;
      bool1 = false;
      break;
    }
    label243:
    localButtonPreference.iN(this.wry.getResources().getString(R.l.gSB), this.wry.getResources().getColor(R.e.brand_text_color));
    localButtonPreference.setTitle(this.wry.getResources().getString(R.l.gSB));
    localButtonPreference.aBd(R.g.settings_line);
    label300:
    AppMethodBeat.o(305427);
  }
  
  private boolean gAD()
  {
    AppMethodBeat.i(26842);
    String[] arrayOfString = ab.oko;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equalsIgnoreCase(this.xVS.field_username))
      {
        AppMethodBeat.o(26842);
        return true;
      }
      i += 1;
    }
    boolean bool = gAE();
    AppMethodBeat.o(26842);
    return bool;
  }
  
  private boolean gAE()
  {
    AppMethodBeat.i(26843);
    boolean bool = au.bws(this.xVS.field_username);
    AppMethodBeat.o(26843);
    return bool;
  }
  
  private boolean gAF()
  {
    AppMethodBeat.i(305434);
    boolean bool = ((bp)com.tencent.mm.kernel.h.ax(bp.class)).aAy(this.xVS.field_username);
    AppMethodBeat.o(305434);
    return bool;
  }
  
  private boolean gAG()
  {
    AppMethodBeat.i(26844);
    boolean bool = au.bwS(this.xVS.field_username);
    AppMethodBeat.o(26844);
    return bool;
  }
  
  private boolean gAH()
  {
    AppMethodBeat.i(26845);
    if ((!com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (this.wry.getIntent().getBooleanExtra("User_Verify", false)))
    {
      AppMethodBeat.o(26845);
      return true;
    }
    AppMethodBeat.o(26845);
    return false;
  }
  
  private boolean gAI()
  {
    AppMethodBeat.i(26846);
    if (this.wry.getIntent().getIntExtra("Contact_Scene", -1) == 14)
    {
      AppMethodBeat.o(26846);
      return true;
    }
    AppMethodBeat.o(26846);
    return false;
  }
  
  private boolean gAJ()
  {
    AppMethodBeat.i(26847);
    if (this.wry.getIntent().getIntExtra("Contact_Scene", 0) == 18)
    {
      AppMethodBeat.o(26847);
      return true;
    }
    AppMethodBeat.o(26847);
    return false;
  }
  
  private boolean gAK()
  {
    AppMethodBeat.i(26848);
    int i = this.wry.getIntent().getIntExtra("Contact_Scene", 0);
    if ((26 <= i) && (i <= 29))
    {
      AppMethodBeat.o(26848);
      return true;
    }
    AppMethodBeat.o(26848);
    return false;
  }
  
  private boolean gAL()
  {
    return this.xVS.field_deleteFlag == 1;
  }
  
  private boolean gAM()
  {
    AppMethodBeat.i(305449);
    if ((this.xVS != null) && (au.bwQ(this.xVS.field_username)))
    {
      AppMethodBeat.o(305449);
      return true;
    }
    AppMethodBeat.o(305449);
    return false;
  }
  
  private void gAN()
  {
    AppMethodBeat.i(305458);
    Object localObject2 = this.wry.getIntent().getStringExtra("Contact_Mobile_MD5");
    Object localObject1 = this.wry.getIntent().getStringExtra("Contact_full_Mobile_MD5");
    String str = Util.nullAsNil((String)localObject2);
    localObject1 = Util.nullAsNil((String)localObject1);
    if ((!str.equals("")) || (!((String)localObject1).equals("")))
    {
      localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(str);
      if (localObject2 != null) {
        break label111;
      }
      localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject1);
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(305458);
        return;
      }
      com.tencent.mm.plugin.account.b.getAddrUploadStg().a((String)localObject1, (com.tencent.mm.plugin.account.friend.model.a)localObject2);
      AppMethodBeat.o(305458);
      return;
      label111:
      localObject1 = str;
    }
  }
  
  protected final void a(final MMActivity paramMMActivity, final au paramau, final int paramInt)
  {
    AppMethodBeat.i(305560);
    if ((paramInt == 17) && (this.MTR))
    {
      com.tencent.mm.ui.base.k.a(this.wry, this.wry.getString(R.l.gSh), "", this.wry.getString(R.l.welcome_i_know), null);
      AppMethodBeat.o(305560);
      return;
    }
    if ((int)paramau.maN == 0)
    {
      bh.bCz();
      if (com.tencent.mm.model.c.bzA().aC(paramau) != -1)
      {
        bh.bCz();
        paramau = com.tencent.mm.model.c.bzA().JE(paramau.field_username);
      }
    }
    for (;;)
    {
      gAN();
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(Integer.valueOf(paramInt));
      final String str2 = paramMMActivity.getIntent().getStringExtra("source_from_user_name");
      final String str3 = paramMMActivity.getIntent().getStringExtra("source_from_nick_name");
      final long l = paramMMActivity.getIntent().getLongExtra("key_msg_id", 0L);
      final String str1 = paramMMActivity.getIntent().getStringExtra("room_name");
      if (this.MTM)
      {
        final com.tencent.mm.pluginsdk.ui.applet.a locala = new com.tencent.mm.pluginsdk.ui.applet.a(this.wry, new a.a()
        {
          public final void canAddContact(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
          {
            AppMethodBeat.i(305415);
            if (paramAnonymousBoolean1)
            {
              a.a(a.this, paramau, paramInt, paramAnonymousString1);
              AppMethodBeat.o(305415);
              return;
            }
            if (paramAnonymousBoolean2)
            {
              com.tencent.mm.modelverify.d.bNI().fP(paramAnonymousString1, 2);
              com.tencent.mm.plugin.account.friend.model.ar.br(paramau.field_encryptUsername, 1);
              paramAnonymousString1 = new tu();
              paramAnonymousString1.hXJ.username = paramau.field_encryptUsername;
              paramAnonymousString1.hXJ.type = 1;
              paramAnonymousString1.publish();
              AppMethodBeat.o(305415);
              return;
            }
            Log.e("MicroMsg.NewContactWidgetNormal", "canAddContact fail, maybe interrupt by IOnNeedSentVerify, username = ".concat(String.valueOf(paramAnonymousString1)));
            AppMethodBeat.o(305415);
          }
        });
        locala.pk(str2, str3);
        locala.YaM = new com.tencent.mm.pluginsdk.ui.applet.a.b()
        {
          public final boolean n(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2)
          {
            AppMethodBeat.i(305420);
            String str = paramMMActivity.getIntent().getStringExtra("room_name");
            int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
            int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
            SayHiWithSnsPermissionUI localSayHiWithSnsPermissionUI = SayHiWithSnsPermissionUI.class;
            if ((!au.bwO(paramau.field_username)) && (i == 1))
            {
              paramAnonymousString2 = SayHiWithSnsPermissionUI2.class;
              paramAnonymousString2 = new Intent(paramMMActivity, paramAnonymousString2);
              paramAnonymousString2.putExtra("Contact_User", paramau.field_username);
              paramAnonymousString2.putExtra("Contact_Nick", paramau.field_nickname);
              paramAnonymousString2.putExtra("Contact_RemarkName", paramau.field_conRemark);
              if ((paramInt != 14) && (paramInt != 8)) {
                break label385;
              }
              paramAnonymousString2.putExtra("Contact_RoomNickname", paramMMActivity.getIntent().getStringExtra("Contact_RoomNickname"));
            }
            for (;;)
            {
              paramAnonymousString2.putExtra("Contact_Scene", paramInt);
              paramAnonymousString2.putExtra("room_name", str);
              paramAnonymousString2.putExtra("source_from_user_name", str2);
              paramAnonymousString2.putExtra("source_from_nick_name", str3);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_send_verify", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_add_remark", true);
              paramAnonymousString2.putExtra("sayhi_with_sns_perm_set_label", false);
              paramAnonymousString2.putExtra(f.e.adwe, paramAnonymousString1);
              paramAnonymousString2.putExtra("sayhi_verify_add_errcode", paramAnonymousInt);
              paramAnonymousString2.putExtra("key_msg_id", l);
              paramAnonymousString1 = paramMMActivity;
              paramAnonymousString2 = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousString2);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousString1, paramAnonymousString2.aYi(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal$11", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousString1.startActivity((Intent)paramAnonymousString2.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousString1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$11", "onNeedSentVerify", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(305420);
              return true;
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (au.bwO(paramau.field_username)) {
                break;
              }
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (i != 2) {
                break;
              }
              paramAnonymousString2 = localSayHiWithSnsPermissionUI;
              if (ab.bBW() < j) {
                break;
              }
              paramAnonymousString2 = SayHiWithSnsPermissionUI3.class;
              break;
              label385:
              if (paramInt == 17) {
                paramAnonymousString2.putExtra("key_msg_id", paramMMActivity.getIntent().getLongExtra("key_msg_id", 0L));
              }
            }
          }
        };
        paramMMActivity = paramMMActivity.getIntent().getStringExtra(f.e.adwe);
        if (!TextUtils.isEmpty(paramMMActivity))
        {
          locala.bqM(paramMMActivity);
          locala.d(paramau.field_username, "", (LinkedList)localObject);
        }
        for (;;)
        {
          if (com.tencent.mm.plugin.messenger.g.a.sr(l)) {
            com.tencent.mm.plugin.messenger.g.a.aq(l, 3);
          }
          AppMethodBeat.o(305560);
          return;
          if (TextUtils.isEmpty(str1))
          {
            locala.bqM(paramau.kas);
            locala.i(paramau.field_username, (LinkedList)localObject);
          }
          else if (!TextUtils.isEmpty(locala.pPi))
          {
            locala.d(paramau.field_username, str1, (LinkedList)localObject);
          }
          else
          {
            bh.bCz();
            paramMMActivity = com.tencent.mm.model.c.bzA().JE(paramau.field_username);
            if (paramMMActivity != null) {}
            for (paramMMActivity = Util.nullAs(paramMMActivity.kas, "");; paramMMActivity = "")
            {
              Log.i("MicroMsg.NewContactWidgetNormal", "dkverify footer add:%s chat:%s ticket:%s", new Object[] { paramau.field_username, str1, paramMMActivity });
              if (TextUtils.isEmpty(paramMMActivity)) {
                break label443;
              }
              locala.bqM(paramMMActivity);
              locala.d(paramau.field_username, str1, (LinkedList)localObject);
              break;
            }
            label443:
            this.MTS.add(paramau.field_username);
            az.a.okP.a(paramau.field_username, str1, new az.b.a()
            {
              public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
              {
                AppMethodBeat.i(26823);
                bh.bCz();
                paramAnonymousString = com.tencent.mm.model.c.bzA().JE(paramau.field_username);
                if (paramAnonymousString != null) {}
                for (paramAnonymousString = Util.nullAs(paramAnonymousString.kas, "");; paramAnonymousString = "")
                {
                  locala.bqM(paramAnonymousString);
                  locala.d(paramau.field_username, str1, this.MUh);
                  AppMethodBeat.o(26823);
                  return;
                }
              }
            });
          }
        }
      }
      localObject = paramMMActivity.getIntent().getStringExtra(f.e.adwe);
      if (com.tencent.mm.plugin.messenger.g.a.sr(l)) {
        com.tencent.mm.plugin.messenger.g.a.aq(l, 3);
      }
      a(paramMMActivity, paramau, paramInt, str2, str3, l, (String)localObject);
      c(3L, this.wry);
      AppMethodBeat.o(305560);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean1, int paramInt, com.tencent.mm.plugin.sns.c.b paramb, boolean paramBoolean2) {}
  
  public final void a(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb)
  {
    AppMethodBeat.i(26851);
    paramString = (com.tencent.mm.ui.base.preference.g)this.pkD.bAi("contact_profile_sns");
    if ((paramString != null) && (q.Qki != null))
    {
      paramString.bro(this.xVS.field_username);
      com.tencent.mm.plugin.sns.statistics.j.QFS.QGh.jiy = paramString.iNI();
      if (q.Qkn != null) {
        q.Qkn.a(this, 3);
      }
      this.pkD.notifyDataSetChanged();
      if (paramb.hdZ())
      {
        Log.d("MicroMsg.NewContactWidgetNormal", "bg Change!");
        if (q.Qkn != null) {
          q.Qkn.aWX(this.xVS.field_username);
        }
      }
    }
    AppMethodBeat.o(26851);
  }
  
  public final boolean a(final com.tencent.mm.ui.base.preference.f paramf, final au paramau, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26837);
    this.readOnly = this.readOnly;
    this.pkD = paramf;
    this.xVS = paramau;
    this.mScene = paramInt;
    this.lyn = this.wry.getIntent().getStringExtra("room_name");
    bh.bCz();
    this.lzy = com.tencent.mm.model.c.bzK().Ju(this.lyn);
    this.MTR = this.wry.getIntent().getBooleanExtra("key_forward_flag", false);
    if (this.MTQ == null)
    {
      this.MTQ = new com.tencent.mm.plugin.profile.logic.b(this.wry, paramau);
      localObject1 = this.MTQ;
      ((com.tencent.mm.plugin.profile.logic.b)localObject1).pVV.addIconOptionMenu(0, R.l.app_more, R.k.icons_outlined_more, (MenuItem.OnMenuItemClickListener)localObject1);
    }
    Log.i("MicroMsg.NewContactWidgetNormal", "[onAttach] username:%s", new Object[] { paramau.field_username });
    paramf.removeAll();
    paramf.aBe(R.o.hbj);
    Object localObject2 = (NormalProfileHeaderPreference)paramf.bAi("contact_profile_header_normal");
    ((NormalProfileHeaderPreference)localObject2).MYn = new com.tencent.mm.pluginsdk.ui.preference.a.b()
    {
      public final void gAP()
      {
        AppMethodBeat.i(305402);
        a.this.a(a.a(a.this), a.b(a.this), a.c(a.this));
        AppMethodBeat.o(305402);
      }
      
      public final void gAQ()
      {
        AppMethodBeat.i(305407);
        a.this.c(2L, a.a(a.this));
        AppMethodBeat.o(305407);
      }
    };
    ((NormalProfileHeaderPreference)localObject2).pkD = paramf;
    ((NormalProfileHeaderPreference)localObject2).a(paramau, paramInt, paramBoolean, this.MTQ);
    Object localObject1 = (ButtonPreference)paramf.bAi("contact_profile_send");
    if (localObject1 != null) {
      ((ButtonPreference)localObject1).adXJ = R.h.contact_profile_send_msg_layout;
    }
    Object localObject3 = (ButtonPreference)paramf.bAi("contact_profile_add_contact");
    label292:
    label320:
    Object localObject5;
    int k;
    int j;
    label401:
    Object localObject6;
    Object localObject7;
    int m;
    if ((au.bwO(paramau.field_username)) && (paramau.kau != 0))
    {
      paramBoolean = true;
      this.MTM = paramBoolean;
      if ((!gAM()) || (paramau.kau == 0)) {
        break label835;
      }
      paramBoolean = true;
      this.MTN = paramBoolean;
      paramf.eh("contact_info_category_1", this.MTM);
      if (this.MTM) {
        break label840;
      }
      paramBoolean = true;
      paramf.eh("contact_info_category_1_openim", paramBoolean);
      localObject4 = this.wry;
      localObject5 = this.xVS;
      if (((!au.bwO(((az)localObject5).field_username)) && (!au.bwQ(((az)localObject5).field_username))) || (((az)localObject5).kau == 0)) {
        break label1075;
      }
      k = -1;
      i = paramf.cs("contact_info_category_1_openim");
      if (!au.bwQ(((az)localObject5).field_username)) {
        break label845;
      }
      j = 1;
      localObject6 = ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(((az)localObject5).field_openImAppid, "openim_custom_info_header", e.a.prb, j);
      j = k;
      if (!TextUtils.isEmpty((CharSequence)localObject6))
      {
        localObject7 = new PreferenceTitleCategory((Context)localObject4);
        ((PreferenceTitleCategory)localObject7).setKey("openim_company_info_title");
        ((PreferenceTitleCategory)localObject7).setLayoutResource(a.h.mm_preference_info_smalltext);
        ((PreferenceTitleCategory)localObject7).setTitle((CharSequence)localObject6);
        paramf.a((Preference)localObject7, i);
        ((Preference)localObject7).adZO = new com.tencent.mm.plugin.profile.logic.a.1();
        j = i;
      }
      localObject6 = new com.tencent.mm.openim.api.g();
      if (!Util.isNullOrNil(((az)localObject5).kav)) {
        ((com.tencent.mm.openim.api.g)localObject6).RH(((az)localObject5).kav);
      }
      Log.v("MicroMsg.Profile.OpenIMProfileLogic", "handleProfileLogic customInfoDetail: %s", new Object[] { ((az)localObject5).kav });
      localObject6 = ((com.tencent.mm.openim.api.g)localObject6).aYV.iterator();
      m = 0;
      k = i;
      i = m;
    }
    label835:
    label840:
    label845:
    label1017:
    for (;;)
    {
      if (!((Iterator)localObject6).hasNext()) {
        break label1020;
      }
      localObject7 = (g.a)((Iterator)localObject6).next();
      Iterator localIterator = ((g.a)localObject7).pre.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1017;
        }
        g.b localb = (g.b)localIterator.next();
        int n = k + 1;
        OpenIMPreference localOpenIMPreference = new OpenIMPreference((Context)localObject4);
        localOpenIMPreference.MUz = localb;
        localOpenIMPreference.JAf = ((g.a)localObject7).title;
        localOpenIMPreference.aBm(2);
        localOpenIMPreference.adZa = false;
        localOpenIMPreference.aS(com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, localb.RI(((az)localObject5).field_openImAppid)));
        Log.v("MicroMsg.Profile.OpenIMProfileLogic", "handleProfileLogic rawDesc: %s", new Object[] { localb.desc });
        m = i;
        if (i == 0)
        {
          m = i;
          if (localb.desc.contains("@im"))
          {
            m = 1;
            localOpenIMPreference.setKey("openim_pref_key_info");
            Log.v("MicroMsg.Profile.OpenIMProfileLogic", "handleProfileLogic foundCompanyInfo pos: %s", new Object[] { Integer.valueOf(n) });
          }
        }
        paramf.a(localOpenIMPreference, n);
        if ((localb.action == 0) || (localb.action == 1))
        {
          localOpenIMPreference.setEnabled(true);
          localOpenIMPreference.aBq(8);
          i = m;
          k = n;
          continue;
          paramBoolean = false;
          break;
          paramBoolean = false;
          break label292;
          paramBoolean = false;
          break label320;
          j = 0;
          break label401;
        }
        if (localb.action == 2)
        {
          localOpenIMPreference.adZO = new com.tencent.mm.plugin.profile.logic.a.2(localb, (au)localObject5, (g.a)localObject7, (Context)localObject4);
          i = m;
          k = n;
        }
        else if (localb.action == 3)
        {
          localOpenIMPreference.adZO = new com.tencent.mm.plugin.profile.logic.a.3(localb, (au)localObject5, (g.a)localObject7, (Context)localObject4);
          i = m;
          k = n;
        }
        else if (localb.action == 4)
        {
          localOpenIMPreference.adZO = new com.tencent.mm.plugin.profile.logic.a.4((Context)localObject4, localb, (au)localObject5, (g.a)localObject7);
          i = m;
          k = n;
        }
        else
        {
          i = m;
          k = n;
          if (localb.action == 5)
          {
            localOpenIMPreference.adZO = new com.tencent.mm.plugin.profile.logic.a.5(localb, (au)localObject5, (g.a)localObject7);
            i = m;
            k = n;
          }
        }
      }
    }
    label1020:
    if ((i == 0) && (j != -1))
    {
      localObject4 = paramf.bAi("openim_company_info_title");
      if (localObject4 != null)
      {
        paramf.bAk("openim_company_info_title");
        ((Preference)localObject4).setKey("openim_pref_key_info");
        paramf.a((Preference)localObject4, j);
      }
    }
    label1075:
    if (gAE())
    {
      paramf.removeAll();
      paramf.c((Preference)localObject2);
      paramf.c(new PreferenceSmallCategory(this.wry));
      paramau = new KeyValuePreference(this.wry);
      paramau.setTitle(R.l.gBu);
      paramau.aBk(R.l.gDf);
      paramau.aBm(2147483647);
      paramau.adZa = false;
      paramau.aBq(8);
      paramf.c(paramau);
      paramf.c(new PreferenceSmallCategory(this.wry));
      if (com.tencent.mm.contact.d.rs(this.xVS.field_type)) {
        paramf.c((Preference)localObject1);
      }
      for (;;)
      {
        this.MTQ.pVV.removeAllOptionMenu();
        AppMethodBeat.o(26837);
        return true;
        paramf.c((Preference)localObject3);
      }
    }
    Object localObject4 = this.xVS;
    int i = this.wry.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
    long l = this.wry.getIntent().getLongExtra("Contact_KSnsBgId", -1L);
    localObject1 = Util.nullAs(this.wry.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
    localObject2 = new ffs();
    ((ffs)localObject2).pSq = i;
    ((ffs)localObject2).pSs = l;
    ((ffs)localObject2).pSr = ((String)localObject1);
    localObject1 = localObject2;
    if (q.Qki != null) {
      localObject1 = q.Qki.b(((az)localObject4).field_username, (ffs)localObject2);
    }
    bh.bCz();
    final boolean bool1 = com.tencent.mm.model.c.bzA().bxr(((az)localObject4).field_username);
    boolean bool3 = z.bAM().equals(((az)localObject4).field_username);
    label1449:
    boolean bool2;
    if (au.bwO(((az)localObject4).field_username)) {
      if ((bool1) || ((localObject4 != null) && (com.tencent.mm.contact.d.rs(((az)localObject4).field_type))))
      {
        bool1 = true;
        com.tencent.mm.kernel.h.baF();
        if ((((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getSnsFlagStg().RV(((az)localObject4).field_username) & 1L) <= 0L) {
          break label4846;
        }
        paramBoolean = true;
        bool2 = paramBoolean;
        if (MTT)
        {
          Log.i("MicroMsg.NewContactWidgetNormal", "debugOpenAlbum, origin:%s", new Object[] { Boolean.valueOf(paramBoolean) });
          bool2 = true;
        }
        Log.i("MicroMsg.NewContactWidgetNormal", "isFriend:%s isSelf:%s openAlbum:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        d.cC(((az)localObject4).field_username, bool2);
        if (((au.bwM(((az)localObject4).field_username)) || (!bool2)) && (!gAH()) && (!bool3)) {
          break label4871;
        }
        this.pkD.eh("contact_profile_sns", false);
        localObject1 = (com.tencent.mm.ui.base.preference.g)this.pkD.bAi("contact_profile_sns");
        if (q.Qkn != null)
        {
          q.Qkn.a(3, ((az)localObject4).field_username, this);
          i = this.wry.getIntent().getIntExtra("Sns_from_Scene", 0);
          q.Qkn.a(2, ((az)localObject4).field_username, bool3, i);
        }
        ((com.tencent.mm.ui.base.preference.g)localObject1).bro(((az)localObject4).field_username);
        label1654:
        localObject2 = paramf.bAi("contact_profile_setting_desc");
        if (!au.bwO(this.xVS.field_username)) {
          break label4888;
        }
        localObject1 = this.wry.getText(R.l.gDi).toString();
        label1695:
        ((Preference)localObject2).setTitle((CharSequence)localObject1);
        localObject1 = (MultiSummaryPreference)paramf.bAi("contact_profile_setting_permission");
        ((MultiSummaryPreference)localObject1).title = this.wry.getString(R.l.gRp);
        if (!this.xVS.aSN()) {
          break label4908;
        }
        ((MultiSummaryPreference)localObject1).MYg = new String[] { this.wry.getString(R.l.gSt) };
        localObject1 = (KeyValuePreference)paramf.bAi("contact_profile_source");
        paramInt = this.wry.getIntent().getIntExtra("Contact_Source_FMessage", paramInt);
        localObject2 = NormalProfileHeaderPreference.a(this.wry, this.xVS, paramInt, this.xVS.field_username, gAH());
        ((KeyValuePreference)localObject1).aS((CharSequence)localObject2);
        ((KeyValuePreference)localObject1).aBm(2);
        ((KeyValuePreference)localObject1).adZa = false;
        ((KeyValuePreference)localObject1).xBL = (com.tencent.mm.cd.a.K(this.wry, (int)this.wry.getResources().getDimension(R.f.NormalTextSize)) * com.tencent.mm.cd.a.getScaleSize(this.wry));
        ((KeyValuePreference)localObject1).aBq(8);
        if ((!com.tencent.mm.contact.d.rs(paramau.field_type)) && (!Util.isNullOrNil((CharSequence)localObject2)) && ((!gAI()) || (gAH()))) {
          break label5170;
        }
        paramBoolean = true;
        label1915:
        paramf.eh("contact_profile_source", paramBoolean);
        localObject1 = (LabelPreference)paramf.bAi("contact_profile_label");
        ((LabelPreference)localObject1).xVS = paramau;
        if (!com.tencent.mm.contact.d.rs(((LabelPreference)localObject1).xVS.field_type))
        {
          localObject2 = ((LabelPreference)localObject1).xVS.field_encryptUsername;
          if (!Util.isNullOrNil((String)localObject2))
          {
            bh.bCz();
            ((LabelPreference)localObject1).NsP = com.tencent.mm.model.c.bzB().aMi((String)localObject2);
          }
          if ((((LabelPreference)localObject1).NsP != null) && (((LabelPreference)localObject1).NsP.systemRowid < 0L))
          {
            bh.bCz();
            ((LabelPreference)localObject1).NsP = com.tencent.mm.model.c.bzB().aMi(((LabelPreference)localObject1).xVS.field_username);
          }
        }
        if ((!com.tencent.mm.contact.d.rs(((LabelPreference)localObject1).xVS.field_type)) || (Util.isNullOrNil(((LabelPreference)localObject1).xVS.field_contactLabelIds))) {
          break label5175;
        }
        paramInt = 1;
        label2074:
        if (paramInt != 0) {
          break label5209;
        }
        paramBoolean = true;
        label2081:
        paramf.eh("contact_profile_label", paramBoolean);
        localObject4 = (PhoneNumPreference)paramf.bAi("contact_profile_phone");
        ((PhoneNumPreference)localObject4).pkD = paramf;
        localObject5 = this.wry.getIntent();
        ((PhoneNumPreference)localObject4).xVS = paramau;
        ((PhoneNumPreference)localObject4).intent = ((Intent)localObject5);
        Log.i("MicroMsg.PhoneNumPreference", "isCancelMatchPhoneMD5 %s", new Object[] { paramau.aSR() });
        if (!paramau.aSR())
        {
          localObject1 = null;
          localObject2 = ((Intent)localObject5).getStringExtra("Contact_Mobile_MD5");
          localObject5 = ((Intent)localObject5).getStringExtra("Contact_full_Mobile_MD5");
          if ((!Util.isNullOrNil((String)localObject2)) || (!Util.isNullOrNil((String)localObject5))) {
            break label5222;
          }
          if (!Util.isNullOrNil(paramau.field_username))
          {
            localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramau.field_username);
            localObject5 = paramau.field_username;
            if (localObject2 != null) {
              break label5214;
            }
            localObject1 = "true";
            label2251:
            Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject5, localObject1 });
            localObject1 = localObject2;
          }
          label2278:
          if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).getMd5())))
          {
            ((PhoneNumPreference)localObject4).XZt = Util.nullAsNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).bWN()).replace(" ", "");
            Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s", new Object[] { paramau.field_username, ((PhoneNumPreference)localObject4).XZt });
          }
          ((PhoneNumPreference)localObject4).iNH();
        }
        ((PhoneNumPreference)localObject4).XZu = PhoneNumPreference.c(((PhoneNumPreference)localObject4).XZt, paramau);
        ((PhoneNumPreference)localObject4).pkD.eh("contact_profile_phone", true);
        ((PhoneNumPreference)localObject4).iNH();
        ((PhoneNumPreference)localObject4).aBq(8);
        localObject1 = (ProfileDescribePreference)paramf.bAi("contact_profile_desc");
        ((ProfileDescribePreference)localObject1).xVS = paramau;
        if (!com.tencent.mm.contact.d.rs(((ProfileDescribePreference)localObject1).xVS.field_type))
        {
          localObject2 = ((ProfileDescribePreference)localObject1).xVS.field_encryptUsername;
          if (!Util.isNullOrNil((String)localObject2))
          {
            bh.bCz();
            ((ProfileDescribePreference)localObject1).NsP = com.tencent.mm.model.c.bzB().aMi((String)localObject2);
          }
          if ((((ProfileDescribePreference)localObject1).NsP != null) && (((ProfileDescribePreference)localObject1).NsP.systemRowid < 0L))
          {
            bh.bCz();
            ((ProfileDescribePreference)localObject1).NsP = com.tencent.mm.model.c.bzB().aMi(((ProfileDescribePreference)localObject1).xVS.field_username);
          }
        }
        if (com.tencent.mm.contact.d.rs(((ProfileDescribePreference)localObject1).xVS.field_type)) {
          break label5364;
        }
        if ((((ProfileDescribePreference)localObject1).NsP == null) || (Util.isNullOrNil(((ProfileDescribePreference)localObject1).NsP.field_conDescription))) {
          break label5358;
        }
        paramInt = 1;
        label2546:
        if (paramInt != 0) {
          break label5418;
        }
        paramBoolean = true;
        label2553:
        paramf.eh("contact_profile_desc", paramBoolean);
        if ((com.tencent.mm.contact.d.rs(paramau.field_type)) || (Util.isNullOrNil(paramau.signature))) {
          break label5423;
        }
        localObject1 = (KeyValuePreference)paramf.bAi("contact_info_signature");
        if (localObject1 != null)
        {
          ((KeyValuePreference)localObject1).xBL = (com.tencent.mm.cd.a.K(this.wry, (int)this.wry.getResources().getDimension(R.f.NormalTextSize)) * com.tencent.mm.cd.a.getScaleSize(this.wry));
          ((KeyValuePreference)localObject1).adZa = false;
          ((KeyValuePreference)localObject1).setTitle(this.wry.getString(R.l.gCg));
          ((KeyValuePreference)localObject1).aS(com.tencent.mm.pluginsdk.ui.span.p.b(this.wry, paramau.signature));
          ((KeyValuePreference)localObject1).LG(false);
          ((KeyValuePreference)localObject1).aBm(5);
          ((KeyValuePreference)localObject1).aBq(8);
        }
        label2694:
        if ((paramf.bAl("contact_profile_desc") >= 0) || (paramf.bAl("contact_profile_label") >= 0)) {
          break label5436;
        }
        paramf.eh("contact_profile_setting_desc", false);
        label2729:
        if (!com.tencent.mm.contact.d.rs(paramau.field_type)) {
          paramf.eh("contact_profile_setting_desc", false);
        }
        paramf.eh("contact_profile_set_des_category", true);
        if ((!au.bwO(this.xVS.field_username)) || (!Util.isNullOrNil(this.xVS.field_conRemark))) {
          break label5450;
        }
        paramf.eh("contact_profile_setting_desc", false);
        paramf.eh("contact_profile_set_des_category", true);
        label2809:
        paramf.bAi("contact_profile_info_more").setTitle(this.wry.getText(R.l.gBC).toString());
        ((TextPreference)paramf.bAi("contact_profile_hint")).aT(this.wry.getText(R.l.gBG));
        if (!paramau.aSF()) {
          break label5495;
        }
        paramf.eh("contact_profile_hint", false);
        label2879:
        this.MTW = ((MultiButtonPreference)paramf.bAi("contact_profile_multi_button"));
        if (!gAF()) {
          break label5509;
        }
        this.MTW.b(this.wry.getString(R.l.contact_info_finder_in_blacklist), new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26828);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26828);
          }
        });
        label2927:
        if ((gAD()) || ((com.tencent.mm.contact.d.rs(paramau.field_type)) && (!paramau.aSF())) || ((!gAH()) && (gAI())))
        {
          paramf.eh("contact_profile_multi_button", true);
          b(paramf);
        }
        if ((com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (!gAH()) && (!gAL()) && (!gAG())) {
          break label5713;
        }
        paramf.eh("contact_profile_send", true);
        paramf.eh("contact_profile_voip", true);
        label3037:
        if ((!com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (!gAH()) && (!gAL()) && (!gAK()) && (!gAJ()) && (!z.bAM().equals(this.xVS.field_username)) && (!gAM())) {
          break label5744;
        }
        paramf.eh("contact_profile_add_contact", true);
        label3112:
        a(paramf, paramau, false);
        if ((gAH()) || (com.tencent.mm.contact.d.rs(paramau.field_type)) || ((!gAG()) && (!gAK()) && (!gAJ()))) {
          break label5833;
        }
        paramf.eh("contact_profile_info_more", true);
        paramf.eh("contact_profile_say_hi", false);
        label3179:
        if (z.Iy(this.xVS.field_username))
        {
          paramf.eh("contact_profile_multi_button", true);
          b(paramf);
          paramf.eh("contact_profile_info_more", Util.isNullOrNil(paramau.signature));
          paramf.eh("contact_profile_setting_desc", true);
          paramf.eh("contact_profile_setting_permission", true);
          paramf.eh("contact_profile_voip", true);
          this.MTQ.pVV.removeAllOptionMenu();
        }
        localObject2 = this.xVS;
        paramf.eh("contact_info_invite_source", true);
        if (this.lzy != null) {
          break label5882;
        }
        paramBoolean = this.wry.getIntent().getBooleanExtra("Is_RoomOwner", false);
        label3307:
        if ((this.mScene == 14) && (paramBoolean) && (this.lzy != null) && (!((az)localObject2).field_username.equals(this.lzy.field_roomowner))) {
          break label5899;
        }
        paramInt = this.mScene;
        if (this.lzy != null) {
          break label5893;
        }
        bool1 = true;
        label3361:
        Log.i("MicroMsg.NewContactWidgetNormal", "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
        paramf.eh("contact_info_invite_source", true);
        label3408:
        this.pkD.eh("contact_profile_story", true);
        bh.bCz();
        paramBoolean = com.tencent.mm.model.c.bzA().bxr(paramau.field_username);
        bool1 = z.bAM().equals(paramau.field_username);
        if (((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).getStoryBasicConfig().huP())
        {
          Log.i("MicroMsg.NewContactWidgetNormal", "updateStoryVisible isFriend:%s isSelf:%s ", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool1) });
          if (((!au.bwM(paramau.field_username)) && (paramBoolean)) || (bool1))
          {
            localObject1 = (AbsStoryPreference)this.pkD.bAi("contact_profile_story");
            ((AbsStoryPreference)localObject1).onCreate(paramau.field_username);
            ((AbsStoryPreference)localObject1).a(this);
            ((AbsStoryPreference)localObject1).huK();
            ((AbsStoryPreference)localObject1).huJ();
          }
        }
        localObject1 = this.pkD;
        if (!gAF()) {
          break label6185;
        }
        Log.i("MicroMsg.NewContactWidgetNormal", "isFinder, hide all");
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_add_contact", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_accept_contact_by_wework", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_setting_desc", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_send", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_voip", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_say_hi", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_info_more", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_setting_permission", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_voip", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_multi_button", false);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_set_des_category", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_category_1", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line1", false);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line2", false);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line3", false);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line4", false);
        this.MTQ.pVV.removeAllOptionMenu();
        label3786:
        localObject1 = this.wry;
        localObject4 = this.pkD;
        if ((this.MTM) || (this.MTN))
        {
          ((com.tencent.mm.ui.base.preference.f)localObject4).bAk(FinderPreference.NAME);
          paramInt = ((com.tencent.mm.ui.base.preference.f)localObject4).cs("openim_pref_key_info");
          localObject2 = new FinderPreference((Context)localObject1);
          ((FinderPreference)localObject2).setKey(FinderPreference.NAME);
          ((FinderPreference)localObject2).mTitle = ((Context)localObject1).getString(R.l.find_friends_by_finder);
          ((FinderPreference)localObject2).maT = true;
          if (paramInt == -1) {
            break label6200;
          }
          ((com.tencent.mm.ui.base.preference.f)localObject4).a((Preference)localObject2, paramInt + 1);
        }
        label3892:
        if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("FinderWxNameCardFinderAndRecentLikeFinderClose", 0) != 1) {
          break label6214;
        }
        paramBoolean = true;
        label3919:
        bool1 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderSwitchApi().ffH();
        Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, dontRequestCgi:" + paramBoolean + ", switchC:" + bool1);
        bool2 = ((com.tencent.mm.plugin.teenmode.a.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).aBu();
        if (!paramBoolean) {
          if ((!this.MTM) && (!this.MTN))
          {
            if (paramau != null) {
              break label6219;
            }
            paramInt = 1;
            label4015:
            if (paramInt != 0) {}
          }
          else
          {
            if (!bool2) {
              break label6367;
            }
          }
        }
        ((com.tencent.mm.ui.base.preference.f)localObject4).eh(FinderPreference.NAME, true);
        ((com.tencent.mm.ui.base.preference.f)localObject4).eh("contact_profile_finder_recent_like", true);
        label4049:
        localObject1 = this.pkD;
        if (gAM())
        {
          Log.i("MicroMsg.NewContactWidgetNormal", "isOpenIMKefuContact, hide all");
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_add_contact", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_accept_contact", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_accept_contact_by_wework", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_setting_desc", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_send", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_voip", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_say_hi", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_info_more", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_setting_permission", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_multi_button", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_set_des_category", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_hint", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_profile_source", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_invite_source", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_signature", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_introduce", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("contact_info_category_1", false);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line1", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line2", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line3", true);
          ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line4", true);
        }
        localObject1 = this.xVS;
        if ((!paramf.bAj("contact_profile_add_contact")) && (!paramf.bAj("contact_profile_accept_contact"))) {
          break label6777;
        }
        paramBoolean = true;
        label4355:
        bool3 = ab.bBX();
        if (((au)localObject1).iZF())
        {
          if ((bool3) || (!((au)localObject1).iZE())) {
            break label6782;
          }
          this.MTV = true;
        }
        label4386:
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQD, 0) != 1) {
          break label6803;
        }
        bool1 = true;
        label4410:
        if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yQE, 0) != 1) {
          break label6809;
        }
        bool2 = true;
        label4434:
        Log.i("MicroMsg.NewContactWidgetNormal", "needShowWechatTip = " + this.MTV + ", addWechatUser = " + bool1 + ", profileWechat = " + bool2 + ", contact.getExtFlag = " + ((az)localObject1).extFlag + ", isSelfWechatUser = " + bool3 + ", contact.isWeChatContact() = " + ((au)localObject1).iZE() + ", contact.isContactExtflagHasOverseaInfo() = " + ((au)localObject1).iZF() + "， isaddContact = " + paramBoolean);
        if (this.MTV)
        {
          if (!paramBoolean) {
            break label6823;
          }
          if (!bool1) {
            break label6815;
          }
          this.MTV = true;
          label4566:
          if ((this.wry != null) && (this.wry.getIntent().hasExtra("Contact_Ext_Flag")) && (!com.tencent.mm.contact.d.rs(((az)localObject1).field_type))) {
            paramf.eh("line5", true);
          }
        }
        localObject1 = this.pkD;
        if (this.MTV)
        {
          localObject2 = (TextPreference)((com.tencent.mm.ui.base.preference.f)localObject1).bAi("contact_profile_wechat_info");
          localObject3 = this.wry.getResources().getString(R.l.know_more_about_wechat);
          localObject4 = new StringBuilder();
          localObject5 = this.wry.getResources();
          paramInt = R.l.contact_info_user_type;
          if (paramau.iZE()) {
            break label6844;
          }
        }
      }
    }
    label4871:
    label4888:
    label4908:
    label5170:
    label5175:
    label5436:
    label6844:
    for (paramf = this.wry.getString(R.l.common_app_domestic);; paramf = this.wry.getString(R.l.common_app_oversea))
    {
      paramf = ((Resources)localObject5).getString(paramInt, new Object[] { paramf }) + "  " + (String)localObject3;
      paramau = new ArrayList();
      paramau.add(localObject3);
      ((TextPreference)localObject2).aeat = new TextPreference.a()
      {
        public final void D(TextView paramAnonymousTextView)
        {
          AppMethodBeat.i(305419);
          TextPreference localTextPreference = this.MUn;
          String str = paramf;
          a.a(a.this).getResources().getDimension(R.f.Edge_0_5_A);
          localTextPreference.aU(str);
          com.tencent.mm.pluginsdk.ui.span.p.a(a.a(a.this), a.gAO(), paramf, paramau, paramAnonymousTextView);
          AppMethodBeat.o(305419);
        }
      };
      if (!((com.tencent.mm.ui.base.preference.f)localObject1).bAj("contact_profile_hint"))
      {
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line2", true);
        ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line4", true);
      }
      b((com.tencent.mm.ui.base.preference.f)localObject1);
      gAC();
      if (!this.MTP)
      {
        c(4L, this.wry);
        this.MTP = true;
      }
      AppMethodBeat.o(26837);
      return true;
      bool1 = false;
      break;
      label4846:
      paramBoolean = false;
      break label1449;
      if ((((ffs)localObject1).pSq & 0x1) > 0)
      {
        paramBoolean = true;
        break label1449;
      }
      paramBoolean = false;
      break label1449;
      this.pkD.eh("contact_profile_sns", true);
      break label1654;
      localObject1 = this.wry.getText(R.l.gDh).toString();
      break label1695;
      paramBoolean = paramau.aSL();
      bool1 = q.Qkl.aRZ(paramau.field_username);
      localObject2 = new LinkedList();
      j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 0);
      if (paramBoolean)
      {
        if (j != 0) {
          break label5072;
        }
        localObject4 = this.wry;
        if (paramau.sex == 2)
        {
          i = R.l.gSn;
          label4983:
          ((List)localObject2).add(((MMActivity)localObject4).getString(i));
        }
      }
      else if (bool1)
      {
        if (j != 0) {
          break label5125;
        }
        localObject4 = this.wry;
        if (paramau.sex != 2) {
          break label5117;
        }
      }
      label5072:
      label5117:
      for (i = R.l.gSj;; i = R.l.gSl)
      {
        ((List)localObject2).add(((MMActivity)localObject4).getString(i));
        ((MultiSummaryPreference)localObject1).MYg = ((String[])((List)localObject2).toArray(new String[0]));
        break;
        i = R.l.gSp;
        break label4983;
        localObject4 = this.wry;
        if (paramau.sex == 2) {}
        for (i = R.l.gSo;; i = R.l.gSq)
        {
          ((List)localObject2).add(((MMActivity)localObject4).getString(i));
          break;
        }
      }
      localObject4 = this.wry;
      if (paramau.sex == 2) {}
      for (i = R.l.gSk;; i = R.l.gSm)
      {
        ((List)localObject2).add(((MMActivity)localObject4).getString(i));
        break;
      }
      paramBoolean = false;
      break label1915;
      if ((((LabelPreference)localObject1).NsP != null) && (!Util.isNullOrNil(((LabelPreference)localObject1).NsP.field_contactLabels)))
      {
        paramInt = 1;
        break label2074;
      }
      paramInt = 0;
      break label2074;
      label5209:
      paramBoolean = false;
      break label2081;
      label5214:
      localObject1 = "false";
      break label2251;
      label5222:
      if ((Util.isNullOrNil((String)localObject2)) && (Util.isNullOrNil((String)localObject5))) {
        break label2278;
      }
      Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[] { paramau.field_username, localObject2, localObject5 });
      localObject2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject2);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject2).getMd5())) {}
      }
      else
      {
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU((String)localObject5);
      }
      localObject5 = paramau.field_username;
      if (localObject1 == null) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        Log.i("MicroMsg.PhoneNumPreference", "Contact name: %s AddrUpload IS NULL? %s", new Object[] { localObject5, localObject2 });
        break;
      }
      label5358:
      paramInt = 0;
      break label2546;
      label5364:
      if (!Util.isNullOrNil(((ProfileDescribePreference)localObject1).xVS.kam)) {}
      for (paramInt = 1;; paramInt = 0)
      {
        if ((Util.isNullOrNil(((ProfileDescribePreference)localObject1).xVS.kal)) && (paramInt == 0)) {
          break label5412;
        }
        paramInt = 1;
        break;
      }
      paramInt = 0;
      break label2546;
      paramBoolean = false;
      break label2553;
      paramf.bAk("contact_info_signature");
      break label2694;
      paramf.eh("contact_profile_setting_desc", true);
      break label2729;
      label5450:
      if ((!au.bwO(this.xVS.field_username)) && (!gAF())) {
        break label2809;
      }
      paramf.eh("contact_profile_setting_desc", true);
      paramf.eh("contact_profile_set_des_category", true);
      break label2809;
      label5495:
      paramf.eh("contact_profile_hint", true);
      break label2879;
      if (!gAH())
      {
        if ((!com.tencent.mm.contact.d.rs(this.xVS.field_type)) && (this.wry.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) == 2))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break label5664;
          }
        }
      }
      else
      {
        localObject2 = this.MTW;
        if (!this.xVS.aSF()) {
          break label5649;
        }
      }
      for (localObject1 = this.wry.getString(R.l.contact_info_moveout_blacklist);; localObject1 = this.wry.getString(R.l.contact_info_movein_blacklist))
      {
        ((MultiButtonPreference)localObject2).b((String)localObject1, new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(26829);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            a.d(a.this).Ar(true);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(26829);
          }
        });
        localObject1 = this.MTW;
        localObject2 = this.wry.getString(R.l.biz_report_text);
        localObject4 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(305425);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            a.d(a.this).gBe();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(305425);
          }
        };
        ((MultiButtonPreference)localObject1).MYb = ((String)localObject2);
        ((MultiButtonPreference)localObject1).MYe = ((View.OnClickListener)localObject4);
        break;
        paramInt = 0;
        break label5550;
      }
      if ((!paramau.aSF()) && (!gAK()) && (!gAJ())) {
        break label2927;
      }
      this.MTW.b(this.wry.getString(R.l.biz_report_text), new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(305418);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/profile/NewContactWidgetNormal$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          a.d(a.this).gBe();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/NewContactWidgetNormal$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(305418);
        }
      });
      break label2927;
      label5713:
      paramf.eh("contact_profile_send", false);
      paramf.eh("contact_profile_voip", this.xVS.aSF());
      break label3037;
      label5744:
      paramf.eh("contact_profile_add_contact", false);
      paramf.eh("contact_profile_setting_desc", false);
      paramf.eh("contact_profile_setting_permission", true);
      paramf.eh("contact_profile_phone", true);
      paramf.eh("contact_profile_info_more", true);
      if (localObject3 == null) {
        break label3112;
      }
      if (this.MTO)
      {
        ((ButtonPreference)localObject3).aBd(R.g.white_bg);
        break label3112;
      }
      ((ButtonPreference)localObject3).aBd(R.g.settings_line);
      break label3112;
      label5833:
      paramf.eh("contact_profile_say_hi", true);
      if (!com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        paramf.eh("contact_profile_info_more", true);
        break label3179;
      }
      paramf.eh("contact_profile_info_more", false);
      break label3179;
      label5882:
      paramBoolean = this.lzy.aMF();
      break label3307;
      bool1 = false;
      break label3361;
      this.MTY = this.wry.getIntent().getStringExtra("inviteer");
      if (Util.isNullOrNil(this.MTY))
      {
        localObject1 = this.lzy.bvJ(((az)localObject2).field_username);
        if (localObject1 != null) {
          break label6070;
        }
      }
      for (localObject1 = "";; localObject1 = Util.nullAs(((com.tencent.mm.h.a.a.b)localObject1).lPO, ""))
      {
        this.MTY = ((String)localObject1);
        if (Util.isNullOrNil(this.MTY)) {
          this.MTY = v.aS(((az)localObject2).field_username, this.lyn);
        }
        if (!Util.isNullOrNil(this.MTY)) {
          break label6086;
        }
        Log.w("MicroMsg.NewContactWidgetNormal", "mRoomId:%s member:%s , inviter is null!", new Object[] { this.lyn, ((az)localObject2).field_username });
        this.MTZ.alive();
        this.MTS.add(((az)localObject2).field_username);
        az.a.okP.a(((az)localObject2).field_username, this.lyn, new az.b.a()
        {
          public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(305394);
            Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.e(a.this), Boolean.valueOf(paramAnonymousBoolean) });
            a.this.MTZ.dead();
            AppMethodBeat.o(305394);
          }
        });
        break;
      }
      label6086:
      this.wry.getIntent().putExtra("inviteer", this.MTY);
      localObject1 = c(this.lzy, this.MTY);
      if (Util.isNullOrNil((String)localObject1))
      {
        this.MTS.add(((az)localObject2).field_username);
        az.a.okP.a(((az)localObject2).field_username, "", new az.b.a()
        {
          public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(305395);
            Log.i("MicroMsg.NewContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[] { paramAnonymousString, a.e(a.this), Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              bh.bCz();
              paramAnonymousString = com.tencent.mm.model.c.bzA().JE(paramAnonymousString).aSU();
              com.tencent.mm.ui.base.preference.f localf = paramf;
              MMActivity localMMActivity = a.a(a.this);
              String str = a.f(a.this);
              a.g(a.this);
              a.b(localf, localMMActivity, str, paramAnonymousString);
            }
            AppMethodBeat.o(305395);
          }
        });
        break label3408;
      }
      a(paramf, this.wry, this.MTY, (String)localObject1);
      break label3408;
      ((com.tencent.mm.ui.base.preference.f)localObject1).eh("line4", true);
      break label3786;
      ((com.tencent.mm.ui.base.preference.f)localObject4).a((Preference)localObject2, paramInt);
      break label3892;
      label6214:
      paramBoolean = false;
      break label3919;
      label6219:
      paramInt = this.wry.getIntent().getIntExtra("Contact_Scene", -1);
      i = this.wry.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", -1);
      bh.bCz();
      paramBoolean = com.tencent.mm.model.c.bzA().bxr(paramau.field_username);
      Log.i("MicroMsg.NewContactWidgetNormal", "isFinderGone, isFriend:" + paramBoolean + ", scene:" + paramInt + ", uiSource： " + i);
      if (!paramBoolean)
      {
        if ((paramInt == 14) || (paramInt == 18) || ((paramInt == 9) && ((i == 2) || (i == 4))))
        {
          paramInt = 0;
          break label4015;
        }
        paramInt = 1;
        break label4015;
      }
      paramInt = 0;
      break label4015;
      label6367:
      l = com.tencent.mm.model.cn.bDu();
      if (l - this.lastUpdateTime < 1000L)
      {
        Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview, lastUpdateTime:" + this.lastUpdateTime + ", curTime:" + l);
        break label4049;
      }
      this.lastUpdateTime = l;
      if ((this.MTM) || (this.MTN))
      {
        localObject2 = "";
        localObject3 = this.wry.getIntent();
        localObject1 = ((Intent)localObject3).getStringExtra("key_add_contact_openim_finder_username");
        if (Util.isNullOrNil((String)localObject1)) {
          if (((Intent)localObject3).hasExtra("key_add_contact_openim_finder_username"))
          {
            localObject1 = "";
            Log.i("MicroMsg.NewContactWidgetNormal", "FinderUsername from intent, use empty value");
            label6503:
            Log.i("MicroMsg.NewContactWidgetNormal", "updateFinderPreview isOpenIM: %s, isOpenIMKefu: %s, wxUsername: %s, openimFinderUsername: %s", new Object[] { Boolean.valueOf(this.MTM), Boolean.valueOf(this.MTN), localObject2, localObject1 });
            localObject1 = ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().a((String)localObject2, (String)localObject1, this.wry, new ca.a()new ca.a
            {
              public final void onCallback(Object paramAnonymousObject)
              {
                AppMethodBeat.i(305393);
                if (bool1) {
                  a.a(a.this, this.tYG, paramAnonymousObject);
                }
                a.b(a.this, this.tYG, paramAnonymousObject);
                AppMethodBeat.o(305393);
              }
            }, new ca.a() {});
            if (!bool1) {
              break label6762;
            }
            b((com.tencent.mm.ui.base.preference.f)localObject4, localObject1);
          }
        }
      }
      for (;;)
      {
        c((com.tencent.mm.ui.base.preference.f)localObject4, localObject1);
        break;
        com.tencent.mm.kernel.h.baF();
        localObject3 = ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getFinderInfoStg();
        localObject5 = paramau.field_username;
        localObject1 = "";
        localObject5 = ((com.tencent.mm.openim.e.h)localObject3).omV.rawQuery("select finder_username from OpenIMFinderInfoNew where openIMUsername=? ", new String[] { localObject5 }, 2);
        if (((Cursor)localObject5).moveToFirst())
        {
          localObject3 = ((Cursor)localObject5).getString(0);
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
        }
        ((Cursor)localObject5).close();
        Log.i("MicroMsg.NewContactWidgetNormal", "FinderUsername from intent is empty, use db value");
        break label6503;
        Log.i("MicroMsg.NewContactWidgetNormal", "use FinderUsername from intent, ".concat(String.valueOf(localObject1)));
        break label6503;
        localObject2 = paramau.field_username;
        localObject1 = "";
        break label6503;
        label6762:
        ((com.tencent.mm.ui.base.preference.f)localObject4).eh(FinderPreference.NAME, true);
      }
      label6777:
      paramBoolean = false;
      break label4355;
      label6782:
      if ((!bool3) || (((au)localObject1).iZE())) {
        break label4386;
      }
      this.MTV = true;
      break label4386;
      bool1 = false;
      break label4410;
      bool2 = false;
      break label4434;
      this.MTV = false;
      break label4566;
      if (bool2)
      {
        this.MTV = true;
        break label4566;
      }
      this.MTV = false;
      break label4566;
    }
  }
  
  public final boolean aXx()
  {
    return false;
  }
  
  public final boolean anl(final String paramString)
  {
    AppMethodBeat.i(26840);
    if (paramString.equals("contact_profile_sns"))
    {
      bh.bCz();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        aa.j(this.wry, null);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26840);
      return true;
      d.b(this.wry.getIntent(), 3, 1, this.xVS.field_username);
      int i;
      if (this.wry.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0) != 12)
      {
        i = 1;
        label82:
        paramString = this.wry.getIntent();
        paramString.putExtra("sns_source", this.wry.getIntent().getIntExtra("Sns_from_Scene", 0));
        if (au.bwO(this.xVS.field_username))
        {
          com.tencent.mm.kernel.h.baF();
          if ((((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getSnsFlagStg().RV(this.xVS.field_username) & 0x2) <= 0L) {}
        }
        else
        {
          paramString.putExtra("sns_signature", this.xVS.signature);
        }
        paramString.putExtra("sns_nickName", this.xVS.aSU());
        paramString.putExtra("sns_title", this.xVS.aSV());
        paramString.putExtra("sns_rpt_scene", d.bo(this.wry.getIntent()));
        if ((q.Qkn == null) || (i == 0)) {
          break label305;
        }
        paramString = q.Qkn.h(paramString, this.xVS.field_username);
        label250:
        if (paramString != null) {
          break label323;
        }
        this.wry.finish();
      }
      for (;;)
      {
        paramString = (com.tencent.mm.ui.base.preference.g)this.pkD.bAi("contact_profile_sns");
        if (paramString == null) {
          break;
        }
        com.tencent.mm.plugin.sns.statistics.j.QFS.QGh.jiy = paramString.iNI();
        break;
        i = 0;
        break label82;
        label305:
        paramString.putExtra("sns_userName", this.xVS.field_username);
        break label250;
        label323:
        com.tencent.mm.br.c.b(this.wry, "sns", ".ui.SnsUserUI", paramString);
        if ((paramString.getFlags() & 0x4000000) != 0) {
          this.wry.finish();
        }
      }
      Object localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramString.equals("contact_profile_label")) || (paramString.equals("contact_profile_desc")) || (paramString.equals("contact_profile_phone")) || (paramString.equals("contact_profile_setting_desc")))
      {
        localObject1 = this.xVS;
        if (localObject1 == null) {
          Log.e("MicroMsg.NewContactWidgetNormal", "contact is null");
        }
        for (;;)
        {
          if (!paramString.equals("contact_profile_setting_desc")) {
            break label624;
          }
          d.b(this.wry.getIntent(), 2, 1, this.xVS.field_username);
          break;
          if (!com.tencent.mm.contact.d.rs(((az)localObject1).field_type))
          {
            if (!Util.isNullOrNil(((az)localObject1).field_encryptUsername)) {
              b(((az)localObject1).field_encryptUsername, (au)localObject1);
            } else {
              b(((az)localObject1).field_username, (au)localObject1);
            }
          }
          else
          {
            localObject2 = (PhoneNumPreference)this.pkD.bAi("contact_profile_phone");
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("Contact_Scene", this.mScene);
            ((Intent)localObject3).putExtra("Contact_User", ((az)localObject1).field_username);
            ((Intent)localObject3).putExtra("Contact_RoomNickname", this.wry.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Intent)localObject3).putExtra("view_mode", true);
            ((Intent)localObject3).putExtra("contact_phone_number_by_md5", ((PhoneNumPreference)localObject2).XZt);
            ((Intent)localObject3).putExtra("contact_phone_number_list", ((az)localObject1).kar);
            b.pFn.k((Intent)localObject3, this.wry);
          }
        }
      }
      else
      {
        label624:
        if (paramString.equals("contact_profile_setting_permission"))
        {
          i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 0);
          localObject1 = this.wry;
          if (i == 0) {}
          for (paramString = PermissionSettingUI.class;; paramString = PermissionSettingUI2.class)
          {
            localObject1 = new Intent((Context)localObject1, paramString);
            ((Intent)localObject1).putExtra("sns_permission_userName", this.xVS.field_username);
            ((Intent)localObject1).putExtra("CONTACT_INFO_UI_SOURCE", this.wry.getIntent().getIntExtra("CONTACT_INFO_UI_SOURCE", 0));
            ((Intent)localObject1).putExtra("sns_permission_anim", true);
            ((Intent)localObject1).putExtra("sns_permission_block_scene", 1);
            paramString = this.wry;
            localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
            com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "handleEvent", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            break;
          }
        }
        if (paramString.equals("contact_profile_power"))
        {
          if (this.MTQ != null) {
            this.MTQ.gAX();
          }
        }
        else
        {
          if (paramString.equals("contact_profile_send"))
          {
            localObject1 = this.xVS;
            if (Util.nullAs(Boolean.valueOf(ab.IQ(((az)localObject1).field_username)), false))
            {
              localObject1 = ((az)localObject1).field_username;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", (String)localObject1);
                paramString.putExtra("Chat_Mode", 1);
                this.wry.setResult(-1, paramString);
              }
            }
            for (;;)
            {
              d.b(this.wry.getIntent(), 4, 1, this.xVS.field_username);
              break;
              paramString.putExtra("Chat_User", (String)localObject1);
              paramString.putExtra("Chat_Mode", 1);
              paramString.setClassName(this.wry, "com.tencent.mm.ui.chatting.ChattingUI");
              localObject1 = this.wry;
              paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
              com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aYi(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((MMActivity)localObject1).startActivity((Intent)paramString.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendToGroupCardEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              continue;
              paramString = new Intent();
              paramString.addFlags(67108864);
              if (this.readOnly)
              {
                paramString.putExtra("Chat_User", ((az)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                this.wry.setResult(-1, paramString);
              }
              else
              {
                paramString.putExtra("Chat_User", ((az)localObject1).field_username);
                paramString.putExtra("Chat_Mode", 1);
                paramString.setClassName(this.wry, "com.tencent.mm.ui.chatting.ChattingUI");
                localObject1 = this.wry;
                paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
                com.tencent.mm.hellhoundlib.a.a.b(localObject1, paramString.aYi(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((MMActivity)localObject1).startActivity((Intent)paramString.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "dealSendEvent", "(Lcom/tencent/mm/storage/Contact;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
            }
          }
          if (paramString.equals("contact_profile_voip"))
          {
            paramString = this.xVS;
            localObject1 = new acm();
            ((acm)localObject1).publish();
            d.b(this.wry.getIntent(), 5, 1, this.xVS.field_username);
            if ((!paramString.field_username.equals(((acm)localObject1).ifS.talker)) && ((((acm)localObject1).ifS.hzJ) || (((acm)localObject1).ifS.hzK)))
            {
              if (((acm)localObject1).ifS.ifT) {}
              for (i = R.l.cannot_use_voip_bcz_video_talking;; i = R.l.cannot_use_voip_bcz_voice_talking)
              {
                Toast.makeText(this.wry, i, 0).show();
                Log.i("MicroMsg.NewContactWidgetNormal", "voip is running, can't do this");
                break;
              }
            }
            if ((!com.tencent.mm.n.a.dl(this.wry)) && (!com.tencent.mm.n.a.dp(this.wry)) && (!com.tencent.mm.n.a.q(this.wry, true)))
            {
              localObject1 = new aaq();
              ((aaq)localObject1).ieg.iei = true;
              ((aaq)localObject1).publish();
              localObject1 = ((aaq)localObject1).ieh.iek;
              if (!Util.isNullOrNil((String)localObject1))
              {
                Log.v("MicroMsg.NewContactWidgetNormal", "Talkroom is on: ".concat(String.valueOf(localObject1)));
                com.tencent.mm.ui.base.k.b(this.wry, this.wry.getString(R.l.gWJ), "", this.wry.getString(R.l.app_ok), this.wry.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(305413);
                    Object localObject = new aaq();
                    ((aaq)localObject).ieg.iej = true;
                    ((aaq)localObject).publish();
                    localObject = new gg();
                    ((gg)localObject).hGt.username = com.tencent.mm.bd.d.oXO.bNG();
                    ((gg)localObject).publish();
                    a.a(a.this, paramString, a.a(a.this));
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(305413);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    AppMethodBeat.i(305399);
                    paramAnonymousDialogInterface.dismiss();
                    AppMethodBeat.o(305399);
                  }
                });
              }
              else
              {
                a(paramString, this.wry);
              }
            }
          }
          else
          {
            boolean bool;
            if (paramString.equals("contact_profile_add_contact"))
            {
              bool = this.wry.getIntent().getBooleanExtra("Contact_Conversation_IsExpireTimeAndOpenIm", false);
              Log.i("MicroMsg.NewContactWidgetNormal", "needShowExpiredTimeToast = %s, showVerfying = %s.", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.MTO) });
              if (bool) {
                Toast.makeText(this.wry, this.wry.getResources().getString(R.l.gRj), 0).show();
              } else if (!this.MTO) {
                a(this.wry, this.xVS, this.mScene);
              }
            }
            else
            {
              if (paramString.equals("contact_profile_accept_contact"))
              {
                localObject2 = this.wry;
                localObject3 = this.xVS;
                ((MMActivity)localObject2).getIntent().removeExtra("Accept_NewFriend_FromOutside");
                i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpi, 2);
                int j = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpl, 5000);
                localObject1 = SayHiWithSnsPermissionUI.class;
                if ((!au.bwO(((az)localObject3).field_username)) && (i == 1)) {
                  paramString = SayHiWithSnsPermissionUI2.class;
                }
                for (;;)
                {
                  paramString = new Intent((Context)localObject2, paramString);
                  paramString.putExtra("Contact_User", ((az)localObject3).field_username);
                  paramString.putExtra("room_name", this.lyn);
                  paramString.putExtra("Contact_Nick", ((az)localObject3).field_nickname);
                  paramString.putExtra("Contact_RemarkName", ((az)localObject3).field_conRemark);
                  if ((this.mScene == 14) || (this.mScene == 8)) {
                    paramString.putExtra("Contact_RoomNickname", ((MMActivity)localObject2).getIntent().getStringExtra("Contact_RoomNickname"));
                  }
                  paramString.putExtra("Contact_Scene", this.mScene);
                  paramString.putExtra("Verify_ticket", Util.nullAsNil(((Activity)localObject2).getIntent().getStringExtra("Verify_ticket")));
                  paramString.putExtra("sayhi_with_sns_perm_send_verify", false);
                  paramString.putExtra("sayhi_with_sns_perm_add_remark", true);
                  paramString.putExtra("sayhi_with_sns_perm_set_label", true);
                  paramString.putExtra("sayhi_with_sns_permission", ((au)localObject3).aSL());
                  paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
                  com.tencent.mm.hellhoundlib.a.a.b(localObject2, paramString.aYi(), "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  ((Context)localObject2).startActivity((Intent)paramString.sb(0));
                  com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/profile/NewContactWidgetNormal", "acceptContact", "(Landroid/content/Context;Lcom/tencent/mm/storage/Contact;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                  d.b(this.wry.getIntent(), 30, 1, this.xVS.field_username);
                  c(1L, this.wry);
                  break;
                  paramString = (String)localObject1;
                  if (!au.bwO(((az)localObject3).field_username))
                  {
                    paramString = (String)localObject1;
                    if (i == 2)
                    {
                      paramString = (String)localObject1;
                      if (ab.bBW() >= j) {
                        paramString = SayHiWithSnsPermissionUI3.class;
                      }
                    }
                  }
                }
              }
              if (paramString.equals("contact_profile_say_hi"))
              {
                d.b(this.wry.getIntent(), 27, 1, this.xVS.field_username);
                paramString = this.xVS;
                localObject1 = new Intent();
                ((Intent)localObject1).putExtra("Contact_User", paramString.field_username);
                ((Intent)localObject1).putExtra("Contact_Scene", this.mScene);
                ((Intent)localObject1).putExtra("Contact_RoomNickname", this.wry.getIntent().getStringExtra("Contact_RoomNickname"));
                ((Intent)localObject1).putExtra(f.e.adwe, paramString.kas);
                b.pFn.a((Intent)localObject1, this.wry);
              }
              else if (paramString.equals("contact_profile_info_more"))
              {
                if (this.MTQ != null)
                {
                  com.tencent.mm.plugin.profile.logic.b.a(this.wry, this.xVS);
                  d.b(this.wry.getIntent(), 6, 1, this.xVS.field_username);
                }
              }
              else if (paramString.equals("contact_info_invite_source"))
              {
                paramString = ((KeyValuePreference)this.pkD.bAi("contact_info_invite_source")).getExtras().getString("inviter");
                if (!Util.isNullOrNil(paramString))
                {
                  localObject1 = c(this.lzy, paramString);
                  localObject2 = new Intent();
                  ((Intent)localObject2).putExtra("Contact_User", paramString);
                  ((Intent)localObject2).putExtra("Contact_RemarkName", (String)localObject1);
                  ((Intent)localObject2).putExtra("Contact_RoomNickname", (String)localObject1);
                  ((Intent)localObject2).putExtra("Contact_RoomMember", true);
                  ((Intent)localObject2).putExtra("room_name", this.lyn);
                  bh.bCz();
                  ((Intent)localObject2).putExtra("Contact_Nick", com.tencent.mm.model.c.bzA().JE(paramString).field_nickname);
                  ((Intent)localObject2).putExtra("Contact_Scene", 14);
                  ((Intent)localObject2).putExtra("Is_RoomOwner", true);
                  ((Intent)localObject2).putExtra("Contact_ChatRoomId", this.lyn);
                  b.pFn.c((Intent)localObject2, this.wry);
                }
              }
              else if (paramString.equals("contact_profile_accept_contact_by_wework"))
              {
                localObject2 = this.xVS;
                localObject3 = Util.nullAsNil(this.wry.getIntent().getStringExtra("Verify_ticket"));
                com.tencent.mm.pluginsdk.ui.preference.b[] arrayOfb = r.a(this.wry, (au)localObject2, this.mScene);
                localObject1 = "";
                paramString = "";
                if (arrayOfb.length > 0)
                {
                  localObject1 = arrayOfb[(arrayOfb.length - 1)].nUO;
                  paramString = r.b(this.wry, (au)localObject2, this.mScene);
                }
                new com.tencent.mm.plugin.profile.a.a(((az)localObject2).field_username, (String)localObject3, paramString, (String)localObject1).doScene(com.tencent.mm.kernel.h.baD().mCm.oun, new com.tencent.mm.am.h()
                {
                  public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
                  {
                    AppMethodBeat.i(305424);
                    paramAnonymousp.setHasCallbackToQueue(true);
                    paramAnonymousString = (com.tencent.mm.plugin.profile.a.a)paramAnonymousp;
                    if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
                    {
                      if (paramAnonymousString.MUM == null) {
                        paramAnonymousString.MUM = ((coy)c.c.b(paramAnonymousString.rr.otC));
                      }
                      String str = paramAnonymousString.MUM.aavQ;
                      paramAnonymousString = null;
                      try
                      {
                        paramAnonymousp = Uri.parse(str);
                        paramAnonymousString = paramAnonymousp;
                      }
                      catch (Exception paramAnonymousp)
                      {
                        for (;;)
                        {
                          Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() Exception:%s", new Object[] { paramAnonymousp.getMessage() });
                        }
                      }
                      paramAnonymousString = new Intent("android.intent.action.VIEW", paramAnonymousString);
                      a.a(a.this).startActivityForResult(paramAnonymousString, 111);
                      Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() success! openurl:%s", new Object[] { str });
                      AppMethodBeat.o(305424);
                      return;
                    }
                    Log.i("MicroMsg.NewContactWidgetNormal", "goToWework() fail!");
                    if (paramAnonymousString.MUM == null) {
                      paramAnonymousString.MUM = ((coy)c.c.b(paramAnonymousString.rr.otC));
                    }
                    if ((paramAnonymousString.MUM.BaseResponse != null) && (paramAnonymousString.MUM.BaseResponse.akjO != null)) {}
                    for (paramAnonymousString = Util.nullAsNil(paramAnonymousString.MUM.BaseResponse.akjO.abwM);; paramAnonymousString = paramAnonymousString.errMsg)
                    {
                      paramAnonymousp = paramAnonymousString;
                      if (Util.isNullOrNil(paramAnonymousString)) {
                        paramAnonymousp = a.a(a.this).getString(R.l.gRk);
                      }
                      com.tencent.mm.ui.base.k.c(a.a(a.this), paramAnonymousp, a.a(a.this).getString(R.l.tip_title), false);
                      AppMethodBeat.o(305424);
                      return;
                    }
                  }
                });
                d.b(this.wry.getIntent(), 31, 1, this.xVS.field_username);
              }
              else if (paramString.equals("contact_profile_story"))
              {
                paramString = (AbsStoryPreference)this.pkD.bAi("contact_profile_story");
                if (paramString != null) {
                  paramString.huL();
                }
              }
              else
              {
                if (paramString.equals(FinderPreference.NAME))
                {
                  paramString = (FinderPreference)this.pkD.bAi(FinderPreference.NAME);
                  if ((paramString.Ymy != null) && (paramString.Ymy.contact != null))
                  {
                    localObject2 = paramString.Ymy.contact.username;
                    if (!Util.isNullOrNil((String)localObject2))
                    {
                      localObject1 = new Intent();
                      ((Intent)localObject1).putExtra("finder_username", (String)localObject2);
                      ((Intent)localObject1).putExtra("key_enter_profile_type", 14);
                      localObject3 = new StringBuilder("{\"is_openimcontact\":");
                      if (!paramString.maT) {
                        break label2958;
                      }
                      i = 1;
                      label2745:
                      ((Intent)localObject1).putExtra("key_extra_info", i + "}");
                      bool = ((String)localObject2).equals(z.bAW());
                      localObject2 = (com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class);
                      if (!bool) {
                        break label2963;
                      }
                    }
                  }
                  label2958:
                  label2963:
                  for (i = 33;; i = 32)
                  {
                    ((com.tencent.mm.plugin.findersdk.a.cn)localObject2).fillContextIdToIntent(14, 2, i, (Intent)localObject1);
                    ((Intent)localObject1).putExtra("KEY_FINDER_SELF_FLAG", bool);
                    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).enterFinderProfileUI(paramString.mContext, (Intent)localObject1);
                    com.tencent.mm.plugin.report.service.h.OAn.p(1585L, 2L, 1L);
                    ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().aBY(this.xVS.field_username);
                    d.b(this.wry.getIntent(), 24, 1, this.xVS.field_username);
                    com.tencent.mm.plugin.report.service.h.OAn.b(21908, new Object[] { Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(2) });
                    if (!this.MTN) {
                      break;
                    }
                    com.tencent.mm.openim.d.a.bm(this.xVS.field_username, 14);
                    break;
                    i = 0;
                    break label2745;
                  }
                }
                if (paramString.equals("contact_profile_finder_recent_like"))
                {
                  ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().e(this.wry, this.xVS.field_username, this.xVS.field_nickname, 79);
                  d.b(this.wry.getIntent(), 25, 1, this.xVS.field_username);
                  ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).getFinderUtilApi().aBY(this.xVS.field_username);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void b(String paramString, boolean paramBoolean, int paramInt, com.tencent.mm.plugin.sns.c.b paramb) {}
  
  public final void c(final long paramLong, final Context paramContext)
  {
    AppMethodBeat.i(305572);
    com.tencent.threadpool.h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        long l2 = 1L;
        AppMethodBeat.i(305426);
        Intent localIntent = new Intent();
        if ((paramContext instanceof Activity)) {
          localIntent = ((Activity)paramContext).getIntent();
        }
        if (!localIntent.hasExtra("Contact_Conversation_IsFromNewFriendToProfile"))
        {
          Log.i("MicroMsg.NewContactWidgetNormal", "doReportClick , is no from new friend add.");
          AppMethodBeat.o(305426);
          return;
        }
        la localla = new la();
        localla.ila = paramLong;
        if (localIntent.getBooleanExtra("Contact_Conversation_IsSelfSendAdd", false))
        {
          l1 = 1L;
          localla.iYC = l1;
          if (!localIntent.getBooleanExtra("Contact_Conversation_Isexpired", false)) {
            break label247;
          }
          l1 = 2L;
          label113:
          localla.iYE = l1;
          localla.iYF = localIntent.getIntExtra("Contact_Scene", 0);
          if (!localIntent.getBooleanExtra("Contact_Conversation_IsContact", false)) {
            break label252;
          }
        }
        label247:
        label252:
        for (long l1 = l2;; l1 = 2L)
        {
          localla.iYD = l1;
          localla.bMH();
          Log.i("MicroMsg.NewContactWidgetNormal", "24723 type_ = " + localla.iYC + ",status_ = " + localla.iYD + ",is_expired_ = " + localla.iYE + ",source_ = " + localla.iYF + ",action = " + paramLong);
          AppMethodBeat.o(305426);
          return;
          l1 = 2L;
          break;
          l1 = 1L;
          break label113;
        }
      }
    });
    AppMethodBeat.o(305572);
  }
  
  public final boolean dvq()
  {
    AppMethodBeat.i(26839);
    this.pkD.bAi("contact_profile_sns");
    if (q.Qkn != null) {
      q.Qkn.a(this, 3);
    }
    Object localObject = (NormalProfileHeaderPreference)this.pkD.bAi("contact_profile_header_normal");
    if (localObject != null) {
      ((NormalProfileHeaderPreference)localObject).onDetach();
    }
    localObject = (AbsStoryPreference)this.pkD.bAi("contact_profile_story");
    if (localObject != null) {
      ((AbsStoryPreference)localObject).onDestroy();
    }
    this.MTZ.dead();
    if (this.MTQ != null) {
      this.MTQ.destroy();
    }
    localObject = this.MTS.iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      az.a.okP.Jq(str);
    }
    AppMethodBeat.o(26839);
    return false;
  }
  
  public final void jt(List paramList)
  {
    AppMethodBeat.i(26852);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish hideStoryPreference");
      this.pkD.eh("contact_profile_story", true);
      AppMethodBeat.o(26852);
      return;
    }
    Log.d("MicroMsg.NewContactWidgetNormal", "onLoadFavStoryFinish showStoryPreference");
    this.pkD.eh("contact_profile_story", false);
    AppMethodBeat.o(26852);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26841);
    a(this.pkD, this.xVS, true);
    AppMethodBeat.o(26841);
  }
  
  public final boolean onCreate()
  {
    return false;
  }
  
  public final void onPause() {}
  
  public final void onResume()
  {
    AppMethodBeat.i(305569);
    gAC();
    AppMethodBeat.o(305569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.a
 * JD-Core Version:    0.7.0.1
 */