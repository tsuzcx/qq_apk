package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.webview.jsapi.a.c;
import com.tencent.mm.protocal.protobuf.ddl;
import com.tencent.mm.protocal.protobuf.hv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoSettingJsApiUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoSettingUI$OnPreferenceTreeClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "appId", "", "effectiveAuthScopeItemNum", "", "nickname", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "settingMainUI", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoSettingUI;", "getSettingMainUI", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoSettingUI;", "settingMainUI$delegate", "Lkotlin/Lazy;", "username", "addJumpSecondManagePref", "", "resp", "Lcom/tencent/mm/protocal/protobuf/JSAPIGetAllUseUserInfoResponse;", "addScopeItems", "dismissProgressDlg", "handleModCgi", "screen", "Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;", "pref", "Lcom/tencent/mm/ui/base/preference/Preference;", "state", "hideIfNotContact", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFinished", "setEmptyTipsVisibility", "visible", "", "showProgressDlg", "isContainJSApiScope", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AuthScopeItem;", "targetScope", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements NewBizInfoSettingUI.a
{
  public static final a.a NbT;
  private static ddl NbW;
  private int NbU;
  private final j NbV;
  private String appId;
  private String nickname;
  private w psR;
  private String username;
  
  static
  {
    AppMethodBeat.i(305775);
    NbT = new a.a((byte)0);
    AppMethodBeat.o(305775);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305724);
    this.NbV = kotlin.k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    AppMethodBeat.o(305724);
  }
  
  private static final void B(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(305767);
    try
    {
      paramDialogInterface.dismiss();
      AppMethodBeat.o(305767);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      Log.e("NewBizInfoSettingJsApiUIC", "showProgressDlg onCancel exp: %s ", new Object[] { paramDialogInterface.getLocalizedMessage() });
      AppMethodBeat.o(305767);
    }
  }
  
  private static final ah a(a parama, b.a parama1)
  {
    AppMethodBeat.i(305755);
    s.u(parama, "this$0");
    if (parama.getActivity().isFinishing())
    {
      Log.i("NewBizInfoSettingJsApiUIC", "activity.isFinishing");
      parama = ah.aiuX;
      AppMethodBeat.o(305755);
      return parama;
    }
    Log.i("NewBizInfoSettingJsApiUIC", "checkUpdate: cgi result: " + parama1.errType + ", " + parama1.errCode);
    if ((parama1.errType != 0) || (parama1.errCode != 0) || (parama1.ott == null))
    {
      if (parama1.ott == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("NewBizInfoSettingJsApiUIC", s.X("it.resp == null? : ", Boolean.valueOf(bool)));
        if (!d.rs(parama.gCs().contact.field_type)) {
          parama.a(true, parama.gCs().screen);
        }
        parama = ah.aiuX;
        AppMethodBeat.o(305755);
        return parama;
      }
    }
    if (ab.isNullOrNil(parama.appId)) {
      parama.appId = ((ddl)parama1.ott).appid;
    }
    NbW = (ddl)parama1.ott;
    parama.a((ddl)parama1.ott);
    parama1 = (ddl)parama1.ott;
    if (parama1 == null) {
      Log.i("NewBizInfoSettingJsApiUIC", "resp == null");
    }
    for (;;)
    {
      parama1 = parama.gCs();
      parama = (NewBizInfoSettingUI.a)parama;
      parama1.Nca.add(parama);
      parama = ah.aiuX;
      AppMethodBeat.o(305755);
      return parama;
      if (parama1.aaJd.size() == 0)
      {
        Log.i("NewBizInfoSettingJsApiUIC", "privacy_scope_item_list.size == 0");
      }
      else
      {
        parama1 = new PreferenceSmallCategory((Context)parama.getContext());
        parama.gCs().screen.c((Preference)parama1);
        parama1 = new Preference((Context)parama.getContext());
        parama1.setLayoutResource(R.i.mm_preference);
        parama1.setTitle((CharSequence)parama.getResources().getString(R.l.gAS));
        parama1.setKey("NewBizInfoAuthMainUI");
        parama.gCs().screen.c(parama1);
      }
    }
  }
  
  private static final ah a(ah.a parama, a parama1, Preference paramPreference, boolean paramBoolean, b.a parama2)
  {
    AppMethodBeat.i(305762);
    s.u(parama, "$cgiHasReturned");
    s.u(parama1, "this$0");
    parama.aiwY = true;
    parama1.ddd();
    if (parama1.getActivity().isFinishing())
    {
      Log.i("NewBizInfoSettingJsApiUIC", "activity.isFinishing");
      parama = ah.aiuX;
      AppMethodBeat.o(305762);
      return parama;
    }
    Log.i("NewBizInfoSettingJsApiUIC", "mode: cgi result: " + parama2.errType + ", " + parama2.errCode);
    if ((parama2.errCode != 0) || (parama2.errType != 0))
    {
      com.tencent.mm.ui.base.aa.dc((Context)parama1.getContext(), parama1.getContext().getResources().getString(R.l.contact_info_biz_network_failed));
      parama = (CheckBoxPreference)paramPreference;
      if (paramBoolean) {
        break label163;
      }
    }
    label163:
    for (paramBoolean = true;; paramBoolean = false)
    {
      parama.Hy(paramBoolean);
      parama = ah.aiuX;
      AppMethodBeat.o(305762);
      return parama;
    }
  }
  
  private final void a(ddl paramddl)
  {
    AppMethodBeat.i(305741);
    if (paramddl == null)
    {
      Log.i("NewBizInfoSettingJsApiUIC", "resp == null");
      AppMethodBeat.o(305741);
      return;
    }
    Object localObject1 = paramddl.aaJc;
    Log.i("NewBizInfoSettingJsApiUIC", s.X("scopeList.size = ", Integer.valueOf(((LinkedList)localObject1).size())));
    Object localObject2 = ((LinkedList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((hv)((Iterator)localObject2).next()).state != 0) {
        this.NbU += 1;
      }
    }
    Log.i("NewBizInfoSettingJsApiUIC", s.X("effectiveAuthScopeItemNum = ", Integer.valueOf(this.NbU)));
    if (this.NbU > 0)
    {
      int i = 0;
      while (i < 4)
      {
        paramddl = new PreferenceSmallCategory((Context)getContext());
        gCs().screen.c((Preference)paramddl);
        i += 1;
      }
      paramddl = new Preference((Context)getContext());
      paramddl.setLayoutResource(R.i.gii);
      localObject2 = am.aixg;
      localObject2 = getResources().getString(R.l.gAQ);
      s.s(localObject2, "resources.getString(R.st…o_biz_jsapi_bizinfo_desc)");
      localObject2 = String.format((String)localObject2, Arrays.copyOf(new Object[] { this.nickname }, 1));
      s.s(localObject2, "java.lang.String.format(format, *args)");
      paramddl.setTitle((CharSequence)localObject2);
      gCs().screen.c(paramddl);
      s.s(localObject1, "scopeList");
      paramddl = ((Iterable)localObject1).iterator();
      while (paramddl.hasNext())
      {
        localObject1 = (hv)paramddl.next();
        if (((hv)localObject1).state != 0)
        {
          localObject2 = new CheckBoxPreference((Context)getContext());
          ((CheckBoxPreference)localObject2).setTitle((CharSequence)((hv)localObject1).desc);
          if (((hv)localObject1).state == 1) {}
          for (boolean bool = true;; bool = false)
          {
            ((CheckBoxPreference)localObject2).setChecked(bool);
            ((CheckBoxPreference)localObject2).setKey(((hv)localObject1).scope);
            ((Preference)localObject2).adZV = false;
            gCs().screen.c((Preference)localObject2);
            Log.i("NewBizInfoSettingJsApiUIC", "add preference: %s", new Object[] { ((hv)localObject1).desc });
            break;
          }
        }
      }
      a(false, gCs().screen);
      AppMethodBeat.o(305741);
      return;
    }
    if ((this.NbU == 0) && (paramddl.aaJd.size() == 0) && (!d.rs(gCs().contact.field_type))) {
      a(true, gCs().screen);
    }
    AppMethodBeat.o(305741);
  }
  
  private static final void a(ah.a parama, a parama1)
  {
    AppMethodBeat.i(305757);
    s.u(parama, "$cgiHasReturned");
    s.u(parama1, "this$0");
    if ((!parama.aiwY) && (!parama1.getActivity().isFinishing()))
    {
      parama1.ddd();
      parama1.psR = com.tencent.mm.ui.base.k.a((Context)parama1.getContext(), parama1.getString(R.l.app_waiting), true, a..ExternalSyntheticLambda0.INSTANCE);
    }
    AppMethodBeat.o(305757);
  }
  
  private final void a(boolean paramBoolean, com.tencent.mm.ui.base.preference.f paramf)
  {
    AppMethodBeat.i(305732);
    if (paramBoolean)
    {
      Preference localPreference = new Preference((Context)getContext());
      localPreference.adZV = false;
      localPreference.setKey("preference_key_tip");
      localPreference.setLayoutResource(R.i.app_brand_authorize_none);
      Object localObject = am.aixg;
      localObject = getContext().getResources().getString(R.l.gAR);
      s.s(localObject, "context.resources.getStr…jsapi_bizinfo_no_any_use)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { this.nickname }, 1));
      s.s(localObject, "java.lang.String.format(format, *args)");
      localPreference.setTitle((CharSequence)localObject);
      if (paramf != null) {
        paramf.bAk("preference_key_tip");
      }
      if (paramf != null) {
        paramf.c(localPreference);
      }
      if (paramf != null)
      {
        paramf.notifyDataSetChanged();
        AppMethodBeat.o(305732);
      }
    }
    else
    {
      if (paramf != null) {
        paramf.bAk("preference_key_tip");
      }
      if (paramf != null) {
        paramf.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(305732);
  }
  
  private final void ddd()
  {
    AppMethodBeat.i(305744);
    if (this.psR == null)
    {
      AppMethodBeat.o(305744);
      return;
    }
    w localw = this.psR;
    if (localw != null) {
      localw.dismiss();
    }
    this.psR = null;
    AppMethodBeat.o(305744);
  }
  
  private final NewBizInfoSettingUI gCs()
  {
    AppMethodBeat.i(305727);
    NewBizInfoSettingUI localNewBizInfoSettingUI = (NewBizInfoSettingUI)this.NbV.getValue();
    AppMethodBeat.o(305727);
    return localNewBizInfoSettingUI;
  }
  
  public final void a(Preference paramPreference)
  {
    Object localObject2 = null;
    AppMethodBeat.i(305822);
    Object localObject1 = NbW;
    int i;
    if (localObject1 != null)
    {
      Object localObject3 = ((ddl)localObject1).aaJc;
      if (localObject3 != null) {
        if (paramPreference == null)
        {
          localObject1 = null;
          localObject3 = ((Iterable)localObject3).iterator();
          i = 0;
          label52:
          if (!((Iterator)localObject3).hasNext()) {
            break label97;
          }
          if (!((hv)((Iterator)localObject3).next()).scope.equals(localObject1)) {
            break label342;
          }
          i = 1;
        }
      }
    }
    label150:
    label155:
    label342:
    for (;;)
    {
      break label52;
      localObject1 = paramPreference.mKey;
      break;
      label97:
      if (i == 1)
      {
        i = 1;
        if ((i == 0) || (!(paramPreference instanceof CheckBoxPreference))) {
          break label243;
        }
        if (!((CheckBoxPreference)paramPreference).isChecked()) {
          break label150;
        }
      }
      for (i = 1;; i = 2)
      {
        if ((paramPreference != null) && ((paramPreference instanceof CheckBoxPreference))) {
          break label155;
        }
        AppMethodBeat.o(305822);
        return;
        i = 0;
        break;
      }
      localObject1 = new ah.a();
      boolean bool = ((CheckBoxPreference)paramPreference).isChecked();
      h.ahAA.o(new a..ExternalSyntheticLambda3((ah.a)localObject1, this), 800L);
      new a.c(2, this.appId, "", ((CheckBoxPreference)paramPreference).mKey, i).bFJ().g(new a..ExternalSyntheticLambda2((ah.a)localObject1, this, paramPreference, bool));
      AppMethodBeat.o(305822);
      return;
      label243:
      if (paramPreference == null) {}
      for (paramPreference = localObject2;; paramPreference = paramPreference.mKey)
      {
        if (n.T(paramPreference, "NewBizInfoAuthMainUI", false))
        {
          paramPreference = new Intent();
          paramPreference.putExtra("Contact_User", this.username);
          paramPreference.putExtra("Contact_Nick", this.nickname);
          paramPreference.putExtra("key_add_contact_openim_appid", this.appId);
          Log.i("NewBizInfoSettingJsApiUIC", "go to JSAPI Auth UI");
          com.tencent.mm.br.c.g((Context)getContext(), "com.tencent.mm.plugin.profile.ui.newbizinfo.auth.NewBizInfoAuthMainUI", paramPreference);
        }
        AppMethodBeat.o(305822);
        return;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305808);
    super.onCreate(paramBundle);
    Log.i("NewBizInfoSettingJsApiUIC", "create");
    if (!d.rs(gCs().contact.field_type)) {
      gCs().screen.removeAll();
    }
    if ((gCs().MVg != null) && (!ab.isNullOrNil(gCs().MVg.field_appId))) {
      this.appId = gCs().MVg.field_appId;
    }
    this.username = getIntent().getStringExtra("Contact_User");
    this.nickname = getIntent().getStringExtra("Contact_Nick");
    if (this.nickname == null) {
      this.nickname = com.tencent.mm.model.aa.getDisplayName(this.username);
    }
    new com.tencent.mm.plugin.webview.jsapi.a.b(this.username).bFJ().g(new a..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(305808);
  }
  
  public final void onFinished()
  {
    AppMethodBeat.i(305813);
    super.onFinished();
    Log.i("NewBizInfoSettingJsApiUIC", "finish");
    NbW = null;
    AppMethodBeat.o(305813);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/NewBizInfoSettingUI;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<NewBizInfoSettingUI>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.a
 * JD-Core Version:    0.7.0.1
 */