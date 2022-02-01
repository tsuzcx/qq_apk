package com.tencent.mm.plugin.sns.g;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.w;
import org.json.JSONObject;

public final class a
{
  public AdClickActionInfo PZL;
  public c.a Qku;
  public com.tencent.mm.plugin.sns.data.f Qkv;
  public boolean Qkw;
  public String adExtInfo;
  public String hQX;
  public Context mContext;
  public bx onc;
  public w tipDialog;
  private com.tencent.mm.ui.widget.a.f ucS;
  public String uxInfo;
  public int xOq;
  public au xVS;
  
  private void ll(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(307293);
    if (paramInt1 == 0) {
      paramInt1 = 1;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("enterType", paramInt1);
        localJSONObject.put("result", paramInt2);
        ((JSONObject)localObject).put("extInfo", localJSONObject);
        ((JSONObject)localObject).put("uxinfo", this.uxInfo);
        ((JSONObject)localObject).put("snsid", this.hQX);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", this.adExtInfo);
        localObject = ((JSONObject)localObject).toString();
        m.lU("timeline_ad_half_screen_quickly_add_brand_result", (String)localObject);
        Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_result, content=".concat(String.valueOf(localObject)));
        AppMethodBeat.o(307293);
        return;
      }
      catch (Exception localException)
      {
        Log.e("HalfScreenAddBrandController", "addBrandReport exp:" + localException.toString());
        AppMethodBeat.o(307293);
      }
      if (paramInt1 == 182) {
        paramInt1 = 3;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final void ax(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(307311);
    if (this.mContext == null)
    {
      Log.i("HalfScreenAddBrandController", "context is null");
      AppMethodBeat.o(307311);
      return;
    }
    if ((paramBoolean) && (!Util.isNullOrNil(paramString)))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("Chat_User", paramString);
      ((Intent)localObject).putExtra("key_has_add_contact", true);
      ((Intent)localObject).putExtra("finish_direct", true);
      ((Intent)localObject).setClassName(this.mContext, "com.tencent.mm.ui.chatting.ChattingUI");
      paramString = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(307311);
      return;
    }
    Toast.makeText(this.mContext, this.mContext.getString(b.j.addcontact_fail), 1).show();
    AppMethodBeat.o(307311);
  }
  
  public final void hel()
  {
    AppMethodBeat.i(307301);
    this.ucS = new com.tencent.mm.ui.widget.a.f(this.mContext, true, 0);
    HalfScreenAddBrandView localHalfScreenAddBrandView = new HalfScreenAddBrandView(this.mContext);
    localHalfScreenAddBrandView.a(this.Qkv, this.xOq, this);
    if ((this.xOq == 182) && (this.Qkw)) {
      localHalfScreenAddBrandView.hsB();
    }
    this.ucS.af(localHalfScreenAddBrandView, true);
    this.ucS.uR(true);
    this.ucS.dDn();
    AppMethodBeat.o(307301);
  }
  
  public final void hem()
  {
    AppMethodBeat.i(307312);
    if ((this.ucS != null) && (this.ucS.isShowing())) {
      this.ucS.cyW();
    }
    AppMethodBeat.o(307312);
  }
  
  public final class a
    implements h
  {
    private Context context;
    private int source;
    private w tipDialog;
    
    private a(Context paramContext, int paramInt, w paramw)
    {
      this.context = paramContext;
      this.source = paramInt;
      this.tipDialog = paramw;
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final p paramp)
    {
      AppMethodBeat.i(307321);
      if (((paramp instanceof com.tencent.mm.openim.model.b)) || ((paramp instanceof v)))
      {
        if ((paramp.getType() != 30) && (paramp.getType() != 667))
        {
          Log.w("HalfScreenAddBrandController", "not expected scene,  type = " + paramp.getType());
          AppMethodBeat.o(307321);
          return;
        }
        if (((paramp instanceof v)) && (((v)paramp).hId != 1))
        {
          Log.e("HalfScreenAddBrandController", "not opcode addcontact!");
          AppMethodBeat.o(307321);
          return;
        }
        com.tencent.mm.plugin.sns.model.b.d(this);
        Log.i("HalfScreenAddBrandController", "catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(307304);
            if (a.a.a(a.a.this) != null)
            {
              a.a.a(a.a.this).dismiss();
              a.a.b(a.a.this);
            }
            String str2 = "";
            String str1 = str2;
            if (paramInt1 == 0)
            {
              str1 = str2;
              if (paramInt2 == 0)
              {
                if (paramp.getType() != 30) {
                  break label120;
                }
                str1 = ((v)paramp).iIc();
              }
            }
            for (;;)
            {
              a.a(a.this, a.a.c(a.a.this), paramInt1, paramInt2, paramString, a.a.d(a.a.this), str1);
              AppMethodBeat.o(307304);
              return;
              label120:
              str1 = str2;
              if (paramp.getType() == 667) {
                str1 = ((com.tencent.mm.openim.model.b)paramp).psp;
              }
            }
          }
        });
      }
      AppMethodBeat.o(307321);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.a
 * JD-Core Version:    0.7.0.1
 */