package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aj;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;

public final class u
  extends r
  implements Serializable
{
  protected aj QQj;
  
  public u(Context paramContext, aj paramaj, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaj, paramViewGroup);
    AppMethodBeat.i(307121);
    this.QQj = paramaj;
    this.QPl.mx("emotionProductId", Util.nullAsNil(this.QQj.hBT));
    AppMethodBeat.o(307121);
  }
  
  protected final void hac()
  {
    AppMethodBeat.i(307126);
    try
    {
      Object localObject3 = hjn().hiC();
      Object localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        Log.i("MicroMsg.AdLandingPageEmojiBtnComp", "doBtnClick, updatedUxInfo==null, src=" + hjn().source + ", originSource=" + hjn().QLu);
        localObject1 = hjn().uxInfo;
      }
      localObject3 = this.context;
      String str = this.QQj.hBT;
      Log.i("MicroMsg.AdLandingPageEmojiBtnComp", "jumpEmojiDetail, productID=" + str + ", uxinfo=" + (String)localObject1);
      if (!TextUtils.isEmpty(str))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("preceding_scence", 22);
        localIntent.putExtra("download_entrance_scene", 33);
        localIntent.putExtra("extra_id", str);
        localIntent.putExtra("ad_uxInfo", (String)localObject1);
        c.b((Context)localObject3, "emoji", ".ui.EmojiStoreDetailUI", localIntent);
      }
      AppMethodBeat.o(307126);
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdLandingPageEmojiBtnComp", "doBtnClick, exp=" + localObject2.toString());
      AppMethodBeat.o(307126);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u
 * JD-Core Version:    0.7.0.1
 */