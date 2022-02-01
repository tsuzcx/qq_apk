package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.lm;
import com.tencent.mm.plugin.sns.ad.d.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.Serializable;

public final class w
  extends r
  implements Serializable
{
  protected h QQn;
  protected boolean QQo;
  protected AdLandingPagesProxy.e QQp;
  private IListener<lm> QQq;
  
  public w(Context paramContext, h paramh, ViewGroup paramViewGroup)
  {
    super(paramContext, paramh, paramViewGroup);
    AppMethodBeat.i(96577);
    this.QQo = false;
    this.QQp = new AdLandingPagesProxy.e()
    {
      public final void h(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(96573);
        int i = ((Integer)paramAnonymousObject).intValue();
        Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "onCallback, errType=" + paramAnonymousInt1 + ", errNo=" + paramAnonymousInt2 + ", state=" + i);
        if (i == 0)
        {
          paramAnonymousObject = w.this.QQn.hNo + AdLandingPagesProxy.getInstance().getUin();
          if (!TextUtils.isEmpty(paramAnonymousObject))
          {
            MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).edit().putString(paramAnonymousObject, "0").commit();
            Log.d("AdLandingPageSp", "saveString, key=" + paramAnonymousObject + ", value=" + "0");
          }
          paramAnonymousObject = new lm();
          paramAnonymousObject.hNn.hNo = w.this.QQn.hNo;
          paramAnonymousObject.hNn.state = i;
          paramAnonymousObject.publish();
        }
        AppMethodBeat.o(96573);
      }
      
      public final void onCallback(Object paramAnonymousObject) {}
    };
    this.QQq = new AdLandingPageGetHBCoverBtnComp.2(this, f.hfK);
    this.QQn = paramh;
    this.QQq.alive();
    AppMethodBeat.o(96577);
  }
  
  public static boolean ald(int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(96581);
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 16) {
        if (paramInt != 2) {
          break label66;
        }
      }
    }
    label66:
    for (bool1 = bool2;; bool1 = false)
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "isFromSourcesSupportHbCover, source=" + paramInt + ", ret=" + bool1);
      AppMethodBeat.o(96581);
      return bool1;
    }
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96580);
    super.had();
    if (!ald(hjn().source))
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, from source unSupport");
      hjv();
      AppMethodBeat.o(96580);
      return;
    }
    String str2 = this.QQn.hNo + AdLandingPagesProxy.getInstance().getUin();
    String str1;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    for (;;)
    {
      boolean bool = "0".equals(str1);
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, hasGetHbCober=".concat(String.valueOf(bool)));
      if (!bool) {
        break;
      }
      this.QPn.setText(this.QQn.QJz);
      hjv();
      AppMethodBeat.o(96580);
      return;
      str1 = MMApplicationContext.getContext().getSharedPreferences("adLandingPageSp", 0).getString(str2, "");
      Log.d("AdLandingPageSp", "getString, key=" + str2 + ", value=" + str1);
    }
    if (!this.QQn.isExpired())
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "fillItem, doGetHbCoverState");
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.QQn.hNo, this.QQp);
    }
    AppMethodBeat.o(96580);
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96579);
    super.hao();
    if (this.QQo)
    {
      Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillAppear, isClicked=true, doGetHbCoverState");
      this.QQo = false;
      AdLandingPagesProxy.getInstance().doGetHbCoverState(this.QQn.hNo, this.QQp);
    }
    AppMethodBeat.o(96579);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96583);
    super.has();
    this.QQq.dead();
    Log.i("MicroMsg.AdLandingPageGetHBCoverBtnComp", "viewWillDestroy");
    AppMethodBeat.o(96583);
  }
  
  protected final void hiZ()
  {
    AppMethodBeat.i(96578);
    super.hiZ();
    this.QQo = true;
    AppMethodBeat.o(96578);
  }
  
  public final void hjv()
  {
    AppMethodBeat.i(96582);
    this.QPn.setEnabled(false);
    this.QPn.setTextColor(Color.parseColor("#33000000"));
    this.QPn.setBackgroundColor(Color.parseColor("#0d000000"));
    k.a(this.context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r)this.QOV, this.QPn);
    AppMethodBeat.o(96582);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w
 * JD-Core Version:    0.7.0.1
 */