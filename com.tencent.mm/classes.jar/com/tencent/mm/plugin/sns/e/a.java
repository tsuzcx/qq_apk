package com.tencent.mm.plugin.sns.e;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.contact.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sns.ad.adxml.AdClickActionInfo;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.c.a;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView;
import com.tencent.mm.pluginsdk.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class a
{
  public int JCO;
  public AdClickActionInfo JIJ;
  public c.a JPl;
  public f JPm;
  public boolean JPn;
  public String adExtInfo;
  public String fLp;
  public bv lvF;
  public Context mContext;
  private e qXn;
  public s tipDialog;
  public as uNk;
  public String uxInfo;
  
  private void jB(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(268847);
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
        ((JSONObject)localObject).put("snsid", this.fLp);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", this.adExtInfo);
        localObject = ((JSONObject)localObject).toString();
        m.ks("timeline_ad_half_screen_quickly_add_brand_result", (String)localObject);
        Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_result, content=".concat(String.valueOf(localObject)));
        AppMethodBeat.o(268847);
        return;
      }
      catch (Exception localException)
      {
        Log.e("HalfScreenAddBrandController", "addBrandReport exp:" + localException.toString());
        AppMethodBeat.o(268847);
      }
      if (paramInt1 == 182) {
        paramInt1 = 3;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final void I(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(268843);
    if (this.mContext == null)
    {
      Log.i("HalfScreenAddBrandController", "context is null");
      AppMethodBeat.o(268843);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(268843);
      return;
    }
    Toast.makeText(this.mContext, this.mContext.getString(i.j.addcontact_fail), 1).show();
    AppMethodBeat.o(268843);
  }
  
  public final void fNf()
  {
    AppMethodBeat.i(268840);
    this.qXn = new e(this.mContext, true, 0);
    HalfScreenAddBrandView localHalfScreenAddBrandView = new HalfScreenAddBrandView(this.mContext);
    localHalfScreenAddBrandView.a(this.JPm, this.JCO, this);
    if ((this.JCO == 182) && (this.JPn)) {
      localHalfScreenAddBrandView.fZn();
    }
    this.qXn.Z(localHalfScreenAddBrandView, true);
    this.qXn.rn(true);
    this.qXn.eik();
    AppMethodBeat.o(268840);
  }
  
  public final void fNg()
  {
    AppMethodBeat.i(268845);
    if ((this.qXn != null) && (this.qXn.isShowing())) {
      this.qXn.bYF();
    }
    AppMethodBeat.o(268845);
  }
  
  public final class a
    implements i
  {
    private Context context;
    private int source;
    private s tipDialog;
    
    private a(Context paramContext, int paramInt, s params)
    {
      this.context = paramContext;
      this.source = paramInt;
      this.tipDialog = params;
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final q paramq)
    {
      AppMethodBeat.i(209566);
      if (((paramq instanceof com.tencent.mm.openim.b.b)) || ((paramq instanceof t)))
      {
        if ((paramq.getType() != 30) && (paramq.getType() != 667))
        {
          Log.w("HalfScreenAddBrandController", "not expected scene,  type = " + paramq.getType());
          AppMethodBeat.o(209566);
          return;
        }
        if (((paramq instanceof t)) && (((t)paramq).fDn != 1))
        {
          Log.e("HalfScreenAddBrandController", "not opcode addcontact!");
          AppMethodBeat.o(209566);
          return;
        }
        com.tencent.mm.plugin.sns.model.b.d(this);
        Log.i("HalfScreenAddBrandController", "catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216725);
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
                if (paramq.getType() != 30) {
                  break label120;
                }
                str1 = ((t)paramq).hhc();
              }
            }
            for (;;)
            {
              a.a(a.this, a.a.c(a.a.this), paramInt1, paramInt2, paramString, a.a.d(a.a.this), str1);
              AppMethodBeat.o(216725);
              return;
              label120:
              str1 = str2;
              if (paramq.getType() == 667) {
                str1 = ((com.tencent.mm.openim.b.b)paramq).myd;
              }
            }
          }
        });
      }
      AppMethodBeat.o(209566);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */