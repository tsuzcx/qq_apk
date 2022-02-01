package com.tencent.mm.plugin.sns.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.b.c;
import com.tencent.mm.plugin.sns.ui.as.a;
import com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class a
{
  public String dAg;
  public String dGD;
  public bq hKP;
  public Context mContext;
  private e mIQ;
  public an pSY;
  public p tipDialog;
  public as.a zsE;
  public b.c zsF;
  public int zsG;
  public com.tencent.mm.plugin.sns.data.c zsH;
  public boolean zsI;
  public String zsJ;
  
  private void hA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(219221);
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
        ((JSONObject)localObject).put("uxinfo", this.dGD);
        ((JSONObject)localObject).put("snsid", this.dAg);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", this.zsJ);
        localObject = ((JSONObject)localObject).toString();
        k.jm("timeline_ad_half_screen_quickly_add_brand_result", (String)localObject);
        ae.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_result, content=".concat(String.valueOf(localObject)));
        AppMethodBeat.o(219221);
        return;
      }
      catch (Exception localException)
      {
        ae.e("HalfScreenAddBrandController", "addBrandReport exp:" + localException.toString());
        AppMethodBeat.o(219221);
      }
      if (paramInt1 == 182) {
        paramInt1 = 3;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final void C(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(219219);
    if (this.mContext == null)
    {
      ae.i("HalfScreenAddBrandController", "context is null");
      AppMethodBeat.o(219219);
      return;
    }
    if ((paramBoolean) && (!bu.isNullOrNil(paramString)))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("Chat_User", paramString);
      ((Intent)localObject).putExtra("key_has_add_contact", true);
      ((Intent)localObject).putExtra("finish_direct", true);
      ((Intent)localObject).setClassName(this.mContext, "com.tencent.mm.ui.chatting.ChattingUI");
      paramString = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(219219);
      return;
    }
    Toast.makeText(this.mContext, this.mContext.getString(2131755166), 1).show();
    AppMethodBeat.o(219219);
  }
  
  public final void dWd()
  {
    AppMethodBeat.i(219218);
    this.mIQ = new e(this.mContext, true, 0);
    HalfScreenAddBrandView localHalfScreenAddBrandView = new HalfScreenAddBrandView(this.mContext);
    Object localObject = this.zsH;
    int i = this.zsG;
    localHalfScreenAddBrandView.zsH = ((com.tencent.mm.plugin.sns.data.c)localObject);
    localHalfScreenAddBrandView.zsG = i;
    localHalfScreenAddBrandView.zUG = this;
    localHalfScreenAddBrandView.ASP.setText(localHalfScreenAddBrandView.zsH.dpI);
    localHalfScreenAddBrandView.ASQ.setText(localHalfScreenAddBrandView.zsH.ztg);
    localObject = localHalfScreenAddBrandView.zsH.ztf;
    if (!TextUtils.equals((String)localHalfScreenAddBrandView.ASO.getTag(2131304927), (CharSequence)localObject))
    {
      localHalfScreenAddBrandView.ASO.setImageDrawable(null);
      com.tencent.mm.plugin.sns.a.c.j((String)localObject, localHalfScreenAddBrandView.ASO);
    }
    if ((this.zsG == 182) && (this.zsI)) {
      localHalfScreenAddBrandView.AST.setText(localHalfScreenAddBrandView.zsH.zth);
    }
    this.mIQ.P(localHalfScreenAddBrandView, true);
    this.mIQ.fQw();
    this.mIQ.cPF();
    AppMethodBeat.o(219218);
  }
  
  public final void dWe()
  {
    AppMethodBeat.i(219220);
    if ((this.mIQ != null) && (this.mIQ.isShowing())) {
      this.mIQ.bqD();
    }
    AppMethodBeat.o(219220);
  }
  
  public final class a
    implements f
  {
    Context context;
    int doj;
    p tipDialog;
    
    private a(Context paramContext, int paramInt, p paramp)
    {
      this.context = paramContext;
      this.doj = paramInt;
      this.tipDialog = paramp;
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final n paramn)
    {
      AppMethodBeat.i(219217);
      if (((paramn instanceof com.tencent.mm.openim.b.b)) || ((paramn instanceof o)))
      {
        if ((paramn.getType() != 30) && (paramn.getType() != 667))
        {
          ae.w("HalfScreenAddBrandController", "not expected scene,  type = " + paramn.getType());
          AppMethodBeat.o(219217);
          return;
        }
        if (((paramn instanceof o)) && (((o)paramn).dto != 1))
        {
          ae.e("HalfScreenAddBrandController", "not opcode addcontact!");
          AppMethodBeat.o(219217);
          return;
        }
        com.tencent.mm.plugin.sns.model.b.e(this);
        ae.i("HalfScreenAddBrandController", "catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219216);
            if (a.a.this.tipDialog != null)
            {
              a.a.this.tipDialog.dismiss();
              a.a.this.tipDialog = null;
            }
            String str2 = "";
            String str1 = str2;
            if (paramInt1 == 0)
            {
              str1 = str2;
              if (paramInt2 == 0)
              {
                if (paramn.getType() != 30) {
                  break label120;
                }
                str1 = ((o)paramn).fdt();
              }
            }
            for (;;)
            {
              a.a(a.this, a.a.this.context, paramInt1, paramInt2, paramString, a.a.this.doj, str1);
              AppMethodBeat.o(219216);
              return;
              label120:
              str1 = str2;
              if (paramn.getType() == 667) {
                str1 = ((com.tencent.mm.openim.b.b)paramn).iKt;
              }
            }
          }
        });
      }
      AppMethodBeat.o(219217);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */