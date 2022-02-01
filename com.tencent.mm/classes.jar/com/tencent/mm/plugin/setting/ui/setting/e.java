package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDelAuthUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "callbackId", "", "mDelAuthCallback", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDelAuthUIC$DelAuthCallback;", "delUserAuth", "", "appId", "", "scene", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setDelAuthCallback", "callback", "Companion", "DelAuthCallback", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a PrW;
  b PrX;
  private int ror;
  
  static
  {
    AppMethodBeat.i(298736);
    PrW = new a((byte)0);
    AppMethodBeat.o(298736);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(298730);
    AppMethodBeat.o(298730);
  }
  
  public final void aVD(String paramString)
  {
    AppMethodBeat.i(298748);
    kotlin.g.b.s.u(paramString, "appId");
    paramString = new com.tencent.mm.plugin.setting.model.e(paramString);
    this.ror = paramString.hashCode();
    Log.i("MicroMsg.SettingsAuthDataUIC", "delUserAuth scene: %d, callbackId: %s", new Object[] { Integer.valueOf(1), Integer.valueOf(this.ror) });
    com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
    AppMethodBeat.o(298748);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298739);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(1127, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(298739);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(298743);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(1127, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(298743);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    Object localObject = null;
    int i = 1;
    AppMethodBeat.i(298754);
    StringBuilder localStringBuilder = new StringBuilder("delUserAuth onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(", type: ");
    if (paramp == null)
    {
      paramString = null;
      localStringBuilder = localStringBuilder.append(paramString).append(", callback: ");
      if (paramp != null) {
        break label167;
      }
      paramString = localObject;
      label77:
      Log.i("MicroMsg.SettingsAuthDataUIC", paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label184;
      }
      if ((paramp == null) || (paramp.getType() != 1127)) {
        break label179;
      }
      paramInt1 = i;
    }
    for (;;)
    {
      if ((paramInt1 != 0) && (paramp.hashCode() == this.ror))
      {
        paramString = this.PrX;
        if (paramString != null)
        {
          paramString.onSuccess();
          AppMethodBeat.o(298754);
          return;
          paramString = Integer.valueOf(paramp.getType());
          break;
          label167:
          paramString = Integer.valueOf(paramp.hashCode());
          break label77;
          label179:
          paramInt1 = 0;
          continue;
          label184:
          if ((paramp == null) || (paramp.getType() != 1127)) {
            break label239;
          }
        }
      }
    }
    label239:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if ((paramInt1 != 0) && (paramp.hashCode() == this.ror))
      {
        paramString = this.PrX;
        if (paramString != null) {
          paramString.gVE();
        }
      }
      AppMethodBeat.o(298754);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDelAuthUIC$Companion;", "", "()V", "TAG", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDelAuthUIC$DelAuthCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void gVE();
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.e
 * JD-Core Version:    0.7.0.1
 */