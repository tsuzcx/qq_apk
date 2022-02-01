package com.tencent.mm.plugin.webwx.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.a;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.abn;
import com.tencent.mm.autogen.a.zy;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.plugin.messenger.b.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.cas;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxLinearLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceListUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/model/IOnUserStatusChange;", "Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceViewHolder$IDeviceListener;", "()V", "deviceContainerRv", "Landroidx/recyclerview/widget/RecyclerView;", "getDeviceContainerRv", "()Landroidx/recyclerview/widget/RecyclerView;", "deviceContainerRv$delegate", "Lkotlin/Lazy;", "dlg", "Landroid/app/ProgressDialog;", "iUpdateExtDeviceListener", "com/tencent/mm/plugin/webwx/ui/LoginDeviceListUI$iUpdateExtDeviceListener$1", "Lcom/tencent/mm/plugin/webwx/ui/LoginDeviceListUI$iUpdateExtDeviceListener$1;", "localOnlineInfoArrayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/messenger/extdevice/NetSceneGetOnlineInfo$LocalOnlineInfo;", "Lkotlin/collections/ArrayList;", "needSync", "", "onlineversion", "", "statusNotifyFunctionListener", "Lcom/tencent/mm/sdk/event/IListener;", "finish", "", "finishUI", "getLayoutId", "initView", "logoutDevice", "targetDeviceType", "targetClientVersion", "exitConfirm", "", "notifyDataSetChanged", "showPos", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNotifyUserStatusChange", "onPause", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setNeedSync", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LoginDeviceListUI
  extends MMActivity
  implements com.tencent.mm.am.h, bd, b.a
{
  public static final LoginDeviceListUI.a Xxs;
  private final ArrayList<a.a> KPM;
  private ProgressDialog PqL;
  private final IListener<?> QvD;
  private boolean XwX;
  private int Xxt;
  private final kotlin.j Xxu;
  private final iUpdateExtDeviceListener.1 Xxv;
  
  static
  {
    AppMethodBeat.i(265389);
    Xxs = new LoginDeviceListUI.a((byte)0);
    AppMethodBeat.o(265389);
  }
  
  public LoginDeviceListUI()
  {
    AppMethodBeat.i(265369);
    this.Xxu = kotlin.k.cm((kotlin.g.a.a)new LoginDeviceListUI.b(this));
    this.KPM = new ArrayList();
    this.Xxv = new IListener(com.tencent.mm.app.f.hfK) {};
    this.QvD = ((IListener)new IListener(com.tencent.mm.app.f.hfK) {});
    AppMethodBeat.o(265369);
  }
  
  private static final void a(int paramInt1, int paramInt2, LoginDeviceListUI paramLoginDeviceListUI, DialogInterface paramDialogInterface, int paramInt3)
  {
    AppMethodBeat.i(265382);
    kotlin.g.b.s.u(paramLoginDeviceListUI, "this$0");
    paramDialogInterface = new af(1, paramInt1, paramInt2);
    bh.aZW().a((p)paramDialogInterface, 0);
    Context localContext = (Context)paramLoginDeviceListUI.getContext();
    paramLoginDeviceListUI.getString(R.l.app_tip);
    paramLoginDeviceListUI.PqL = ((ProgressDialog)com.tencent.mm.ui.base.k.a(localContext, paramLoginDeviceListUI.getString(R.l.app_waiting), true, new LoginDeviceListUI..ExternalSyntheticLambda0(paramDialogInterface, paramLoginDeviceListUI)));
    AppMethodBeat.o(265382);
  }
  
  private static final void a(af paramaf, LoginDeviceListUI paramLoginDeviceListUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(265377);
    kotlin.g.b.s.u(paramaf, "$scene");
    kotlin.g.b.s.u(paramLoginDeviceListUI, "this$0");
    bh.aZW().a((p)paramaf);
    paramaf = paramLoginDeviceListUI.PqL;
    if (paramaf != null) {
      paramaf.cancel();
    }
    AppMethodBeat.o(265377);
  }
  
  private static final boolean a(LoginDeviceListUI paramLoginDeviceListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(265375);
    kotlin.g.b.s.u(paramLoginDeviceListUI, "this$0");
    paramLoginDeviceListUI.finish();
    AppMethodBeat.o(265375);
    return true;
  }
  
  private RecyclerView iDy()
  {
    AppMethodBeat.i(265372);
    Object localObject = this.Xxu.getValue();
    kotlin.g.b.s.s(localObject, "<get-deviceContainerRv>(...)");
    localObject = (RecyclerView)localObject;
    AppMethodBeat.o(265372);
    return localObject;
  }
  
  public final void Y(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(265429);
    kotlin.g.b.s.u(paramString, "exitConfirm");
    if (this.Xxt == com.tencent.mm.plugin.messenger.b.a.gaP())
    {
      com.tencent.mm.ui.base.k.b((Context)getContext(), paramString, getString(R.l.app_tip), getString(R.l.gYV), getString(R.l.app_cancel), new LoginDeviceListUI..ExternalSyntheticLambda1(paramInt1, paramInt2, this), null);
      AppMethodBeat.o(265429);
      return;
    }
    finish();
    AppMethodBeat.o(265429);
  }
  
  public final void apL(int paramInt)
  {
    AppMethodBeat.i(265419);
    Object localObject = iDy().getAdapter();
    if ((localObject instanceof a)) {}
    for (localObject = (a)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        Log.i("MicroMsg.LoginDeviceAdapter", "setSelection:" + paramInt + ", oriSelection:" + ((a)localObject).dyx);
        if (((a)localObject).dyx != paramInt)
        {
          ((a)localObject).dyx = paramInt;
          ((RecyclerView.a)localObject).bZE.notifyChanged();
        }
      }
      AppMethodBeat.o(265419);
      return;
    }
  }
  
  public final void dmh()
  {
    AppMethodBeat.i(265425);
    finish();
    AppMethodBeat.o(265425);
  }
  
  public void finish()
  {
    AppMethodBeat.i(265413);
    super.finish();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    AppMethodBeat.o(265413);
  }
  
  public int getLayoutId()
  {
    return R.i.glp;
  }
  
  public final void iDz()
  {
    this.XwX = true;
  }
  
  public void initView()
  {
    AppMethodBeat.i(265405);
    setMMTitle(R.l.gMH);
    setBackBtn(new LoginDeviceListUI..ExternalSyntheticLambda2(this), R.k.actionbar_icon_close_black);
    hideActionbarLine();
    this.KPM.addAll((Collection)com.tencent.mm.plugin.messenger.b.a.gaL());
    Object localObject = iDy();
    ArrayList localArrayList = this.KPM;
    if (this.KPM.size() == 1) {}
    for (int i = 0;; i = -1)
    {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)new a(localArrayList, i, (b.a)this));
      localObject = new WxLinearLayoutManager((Context)getContext());
      ((WxLinearLayoutManager)localObject).setOrientation(1);
      iDy().setLayoutManager((RecyclerView.LayoutManager)localObject);
      if (!com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adhN, false))
      {
        ((TextView)findViewById(R.h.fXL)).setVisibility(0);
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adhN, Boolean.TRUE);
      }
      AppMethodBeat.o(265405);
      return;
    }
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(265421);
    RecyclerView.a locala = iDy().getAdapter();
    if (locala != null) {
      locala.bZE.notifyChanged();
    }
    AppMethodBeat.o(265421);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265400);
    super.onCreate(paramBundle);
    if (getIntent() != null) {
      this.Xxt = getIntent().getIntExtra("intent.key.online_version", 0);
    }
    initView();
    overridePendingTransition(R.a.push_up_in, R.a.anim_not_change);
    bh.aZW().a(281, (com.tencent.mm.am.h)this);
    bh.aZW().a(792, (com.tencent.mm.am.h)this);
    bh.aZW().a(526, (com.tencent.mm.am.h)this);
    this.Xxv.alive();
    bh.bCz();
    c.a((bd)this);
    this.QvD.alive();
    AppMethodBeat.o(265400);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(265410);
    super.onDestroy();
    overridePendingTransition(R.a.anim_not_change, R.a.push_down_out);
    bh.aZW().b(281, (com.tencent.mm.am.h)this);
    bh.aZW().b(792, (com.tencent.mm.am.h)this);
    bh.aZW().b(526, (com.tencent.mm.am.h)this);
    bh.bCz();
    c.b((bd)this);
    this.Xxv.dead();
    this.QvD.dead();
    AppMethodBeat.o(265410);
  }
  
  public void onNotifyUserStatusChange()
  {
    AppMethodBeat.i(265417);
    bh.bCz();
    if (!c.bzw())
    {
      finish();
      AppMethodBeat.o(265417);
      return;
    }
    if (com.tencent.mm.plugin.messenger.b.a.gaO())
    {
      Log.d("MicroMsg.LoginDeviceListUI", "extDevice remote lock");
      notifyDataSetChanged();
    }
    AppMethodBeat.o(265417);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(265407);
    super.onPause();
    cas localcas;
    if ((this.XwX) && (bh.baz()))
    {
      localcas = new cas();
      localcas.aajJ = 27;
      if (!z.aRx()) {
        break label90;
      }
    }
    label90:
    for (int i = 1;; i = 2)
    {
      localcas.NkL = i;
      bh.bCz();
      c.bzz().d((k.b)new k.a(23, (com.tencent.mm.bx.a)localcas));
      this.XwX = false;
      AppMethodBeat.o(265407);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(265415);
    kotlin.g.b.s.u(paramp, "scene");
    paramString = this.PqL;
    if (paramString != null) {
      paramString.dismiss();
    }
    this.PqL = null;
    if (paramp.getType() == 281)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        Toast.makeText((Context)this, R.l.gYW, 1).show();
      }
      finish();
      AppMethodBeat.o(265415);
      return;
    }
    if (paramp.getType() == 526)
    {
      this.KPM.clear();
      this.KPM.addAll((Collection)com.tencent.mm.plugin.messenger.b.a.gaL());
      notifyDataSetChanged();
    }
    AppMethodBeat.o(265415);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.ui.LoginDeviceListUI
 * JD-Core Version:    0.7.0.1
 */