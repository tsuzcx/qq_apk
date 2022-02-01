package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.protocal.protobuf.fun;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "mGetAuthDataCallback", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$GetAuthDataCallback;", "nextPageData", "", "getAuthData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setGetAuthDataCallback", "callback", "Companion", "GetAuthDataCallback", "SettingsAuthData", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a PrS;
  private byte[] PnI;
  b PrT;
  
  static
  {
    AppMethodBeat.i(298720);
    PrS = new a((byte)0);
    AppMethodBeat.o(298720);
  }
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(298710);
    AppMethodBeat.o(298710);
  }
  
  public static void ct(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(298715);
    Log.i("MicroMsg.SettingsAuthDataUIC", "getAuthData nextPageData: %s", new Object[] { paramArrayOfByte });
    paramArrayOfByte = new k(paramArrayOfByte, (byte)0);
    com.tencent.mm.kernel.h.aZW().a((p)paramArrayOfByte, 0);
    AppMethodBeat.o(298715);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(298723);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(1146, (com.tencent.mm.am.h)this);
    ct(null);
    AppMethodBeat.o(298723);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(298727);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(1146, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(298727);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 1;
    AppMethodBeat.i(298734);
    StringBuilder localStringBuilder = new StringBuilder("getUserAuthList onSceneEnd errType ").append(paramInt1).append(", errCode ").append(paramInt2).append(", errMsg ").append(paramString).append(", type: ");
    Object localObject;
    if (paramp == null)
    {
      localObject = null;
      Log.i("MicroMsg.SettingsAuthDataUIC", localObject);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label204;
      }
      if ((paramp == null) || (paramp.getType() != 1146)) {
        break label135;
      }
      paramInt1 = i;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.setting.model.NetSceneGetUserAuthList");
          AppMethodBeat.o(298734);
          throw paramString;
          localObject = Integer.valueOf(paramp.getType());
          break;
          label135:
          paramInt1 = 0;
          continue;
        }
        this.PnI = ((k)paramp).gUW();
        paramString = this.PrT;
        if (paramString != null)
        {
          paramString.a(new c(((k)paramp).gUX(), ((k)paramp).gUV(), ((k)paramp).gUW()));
          AppMethodBeat.o(298734);
          return;
          label204:
          if ((paramp == null) || (paramp.getType() != 1146)) {
            break label255;
          }
        }
      }
    }
    label255:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramp = this.PrT;
        if (paramp != null) {
          paramp.s(paramInt1, paramInt2, paramString);
        }
      }
      AppMethodBeat.o(298734);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$Companion;", "", "()V", "TAG", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$GetAuthDataCallback;", "", "onFailed", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "authData", "Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$SettingsAuthData;", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(d.c paramc);
    
    public abstract void s(int paramInt1, int paramInt2, String paramString);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/setting/ui/setting/SettingsAuthDataUIC$SettingsAuthData;", "", "requestNextPage", "", "authAppList", "", "Lcom/tencent/mm/protocal/protobuf/UserAuthApp;", "nextPageData", "", "(ZLjava/util/List;[B)V", "getAuthAppList", "()Ljava/util/List;", "getNextPageData", "()[B", "getRequestNextPage", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "plugin-setting_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final byte[] PnI;
    final boolean PrU;
    final List<fun> PrV;
    
    public c(boolean paramBoolean, List<fun> paramList, byte[] paramArrayOfByte)
    {
      this.PrU = paramBoolean;
      this.PrV = paramList;
      this.PnI = paramArrayOfByte;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(299292);
      if (this == paramObject)
      {
        AppMethodBeat.o(299292);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(299292);
        return false;
      }
      paramObject = (c)paramObject;
      if (this.PrU != paramObject.PrU)
      {
        AppMethodBeat.o(299292);
        return false;
      }
      if (!kotlin.g.b.s.p(this.PrV, paramObject.PrV))
      {
        AppMethodBeat.o(299292);
        return false;
      }
      if (!kotlin.g.b.s.p(this.PnI, paramObject.PnI))
      {
        AppMethodBeat.o(299292);
        return false;
      }
      AppMethodBeat.o(299292);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(299278);
      String str = "SettingsAuthData(requestNextPage=" + this.PrU + ", authAppList=" + this.PrV + ", nextPageData=" + Arrays.toString(this.PnI) + ')';
      AppMethodBeat.o(299278);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.d
 * JD-Core Version:    0.7.0.1
 */