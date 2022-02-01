package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ya;
import com.tencent.mm.autogen.a.ya.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

class AdLandingPageQRCodeBtnComp$3
  extends IListener<ya>
{
  AdLandingPageQRCodeBtnComp$3(ah paramah, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(307036);
    this.__eventId = ya.class.getName().hashCode();
    AppMethodBeat.o(307036);
  }
  
  private boolean a(ya paramya)
  {
    AppMethodBeat.i(307043);
    for (;;)
    {
      try
      {
        localah = this.QRw;
        if ((paramya != null) && (paramya.ibv != null))
        {
          localObject = localah.QRq;
          if (localObject != null) {
            continue;
          }
        }
      }
      finally
      {
        ah localah;
        Object localObject;
        String str1;
        int i;
        String str2;
        continue;
      }
      AppMethodBeat.o(307043);
      return false;
      str1 = paramya.ibv.ibw;
      localObject = paramya.ibv.ibx;
      i = paramya.ibv.ibz;
      str2 = localah.QOV.QKG;
      Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, from " + str1 + "; self is " + str2 + "; type is " + i);
      if ((!Util.isEqual(str1, str2)) && (!TextUtils.isEmpty(paramya.ibv.iby)))
      {
        paramya = paramya.ibv.iby;
        Log.d("SnsAd.AdLandingPageQRCodeBtnComp", "onDownloadEventFromOthers is called, the path is ".concat(String.valueOf(paramya)));
        if (i == 0)
        {
          if ((Util.isEqual((String)localObject, localah.QRq.QKX)) && (TextUtils.isEmpty(localah.QRr))) {
            localah.QRr = paramya;
          }
        }
        else if ((i == 1) && (Util.isEqual((String)localObject, localah.QRs)) && (TextUtils.isEmpty(localah.QRt))) {
          localah.QRt = paramya;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.AdLandingPageQRCodeBtnComp.3
 * JD-Core Version:    0.7.0.1
 */