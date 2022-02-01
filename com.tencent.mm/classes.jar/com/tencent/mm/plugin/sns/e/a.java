package com.tencent.mm.plugin.sns.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.sns.data.d;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.e;
import com.tencent.mm.plugin.sns.storage.ADXml.AdCardActionBtnInfo;
import com.tencent.mm.plugin.sns.ui.av.a;
import com.tencent.mm.plugin.sns.ui.view.HalfScreenAddBrandView;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.ui.widget.a.e;
import org.json.JSONObject;

public final class a
{
  public av.a DCV;
  public ADXml.AdCardActionBtnInfo DCW;
  public d DCX;
  public boolean DCY;
  public int DxM;
  public String adExtInfo;
  public String dRS;
  public bv iFD;
  public Context mContext;
  private e nVN;
  public as rjX;
  public com.tencent.mm.ui.base.q tipDialog;
  public String uxInfo;
  
  private void is(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202568);
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
        ((JSONObject)localObject).put("snsid", this.dRS);
        ((JSONObject)localObject).put("scene", 0);
        ((JSONObject)localObject).put("adExtInfo", this.adExtInfo);
        localObject = ((JSONObject)localObject).toString();
        k.jY("timeline_ad_half_screen_quickly_add_brand_result", (String)localObject);
        Log.i("HalfScreenAddBrandController", "addBrandReport timeline_ad_half_screen_quickly_add_brand_result, content=".concat(String.valueOf(localObject)));
        AppMethodBeat.o(202568);
        return;
      }
      catch (Exception localException)
      {
        Log.e("HalfScreenAddBrandController", "addBrandReport exp:" + localException.toString());
        AppMethodBeat.o(202568);
      }
      if (paramInt1 == 182) {
        paramInt1 = 3;
      } else {
        paramInt1 = 2;
      }
    }
  }
  
  public final void D(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(202566);
    if (this.mContext == null)
    {
      Log.i("HalfScreenAddBrandController", "context is null");
      AppMethodBeat.o(202566);
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
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/sns/controller/HalfScreenAddBrandController", "dealRet", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(202566);
      return;
    }
    Toast.makeText(this.mContext, this.mContext.getString(2131755184), 1).show();
    AppMethodBeat.o(202566);
  }
  
  public final void eZo()
  {
    AppMethodBeat.i(202565);
    this.nVN = new e(this.mContext, true, 0);
    HalfScreenAddBrandView localHalfScreenAddBrandView = new HalfScreenAddBrandView(this.mContext);
    Object localObject = this.DCX;
    int i = this.DxM;
    localHalfScreenAddBrandView.DCX = ((d)localObject);
    localHalfScreenAddBrandView.DxM = i;
    localHalfScreenAddBrandView.EcO = this;
    localHalfScreenAddBrandView.Fdv.setText(localHalfScreenAddBrandView.DCX.brandName);
    localHalfScreenAddBrandView.Fdw.setText(localHalfScreenAddBrandView.DCX.brandDesc);
    localObject = localHalfScreenAddBrandView.DCX.brandHead;
    if (!TextUtils.equals((String)localHalfScreenAddBrandView.Fdu.getTag(2131308065), (CharSequence)localObject))
    {
      localHalfScreenAddBrandView.Fdu.setImageDrawable(null);
      com.tencent.mm.plugin.sns.a.c.k((String)localObject, localHalfScreenAddBrandView.Fdu);
    }
    if ((this.DxM == 182) && (this.DCY)) {
      localHalfScreenAddBrandView.Fdz.setText(localHalfScreenAddBrandView.DCX.btnTitleAfterAddBrand);
    }
    this.nVN.V(localHalfScreenAddBrandView, true);
    this.nVN.Dm(true);
    this.nVN.dGm();
    AppMethodBeat.o(202565);
  }
  
  public final void eZp()
  {
    AppMethodBeat.i(202567);
    if ((this.nVN != null) && (this.nVN.isShowing())) {
      this.nVN.bMo();
    }
    AppMethodBeat.o(202567);
  }
  
  public final class a
    implements i
  {
    Context context;
    int source;
    com.tencent.mm.ui.base.q tipDialog;
    
    private a(Context paramContext, int paramInt, com.tencent.mm.ui.base.q paramq)
    {
      this.context = paramContext;
      this.source = paramInt;
      this.tipDialog = paramq;
    }
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.ak.q paramq)
    {
      AppMethodBeat.i(202564);
      if (((paramq instanceof com.tencent.mm.openim.b.b)) || ((paramq instanceof p)))
      {
        if ((paramq.getType() != 30) && (paramq.getType() != 667))
        {
          Log.w("HalfScreenAddBrandController", "not expected scene,  type = " + paramq.getType());
          AppMethodBeat.o(202564);
          return;
        }
        if (((paramq instanceof p)) && (((p)paramq).dKy != 1))
        {
          Log.e("HalfScreenAddBrandController", "not opcode addcontact!");
          AppMethodBeat.o(202564);
          return;
        }
        com.tencent.mm.plugin.sns.model.b.e(this);
        Log.i("HalfScreenAddBrandController", "catch add Contact errCode: %d && errMsg: %s", new Object[] { Integer.valueOf(paramInt2), paramString });
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(202563);
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
                if (paramq.getType() != 30) {
                  break label120;
                }
                str1 = ((p)paramq).gmD();
              }
            }
            for (;;)
            {
              a.a(a.this, a.a.this.context, paramInt1, paramInt2, paramString, a.a.this.source, str1);
              AppMethodBeat.o(202563);
              return;
              label120:
              str1 = str2;
              if (paramq.getType() == 667) {
                str1 = ((com.tencent.mm.openim.b.b)paramq).jGZ;
              }
            }
          }
        });
      }
      AppMethodBeat.o(202564);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.e.a
 * JD-Core Version:    0.7.0.1
 */