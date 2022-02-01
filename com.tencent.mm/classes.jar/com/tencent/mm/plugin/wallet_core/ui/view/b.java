package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b
{
  private static final String HCA;
  private static final String HCB;
  private static final String HCC;
  private static final String HCD;
  private static final String HCE;
  private static final String HCz;
  
  static
  {
    AppMethodBeat.i(214249);
    HCz = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    HCA = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    HCB = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    HCC = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    HCD = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    HCE = "http://" + WeChatHosts.domainString(2131761736) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    AppMethodBeat.o(214249);
  }
  
  public static View a(Context paramContext, View paramView, Bankcard paramBankcard, int paramInt, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71478);
    View localView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(paramContext, paramInt, null);
      paramView = new a();
      paramView.HCR = ((ImageView)localView.findViewById(2131297265));
      paramView.HCN = ((TextView)localView.findViewById(2131297274));
      paramView.HCO = ((TextView)localView.findViewById(2131297321));
      paramView.HCM = ((TextView)localView.findViewById(2131297303));
      paramView.HCM.setTextSize(1, 32.0F);
      paramView.HCS = ((TextView)localView.findViewById(2131297302));
      paramView.HCP = ((ViewGroup)localView.findViewById(2131310148));
      paramView.HCQ = ((ImageView)localView.findViewById(2131297312));
      paramView.HCT = ((TextView)localView.findViewById(2131297297));
      paramView.ImN = ((ViewGroup)localView.findViewById(2131297299));
      paramView.ImO = ((TextView)localView.findViewById(2131297284));
      paramView.ImP = ((ImageView)localView.findViewById(2131297313));
      paramView.ImQ = ((TextView)localView.findViewById(2131297317));
      localView.setTag(paramView);
      localObject = paramView;
      if (paramBankcard.field_bankcardState != 1) {
        break label432;
      }
      ((a)localObject).HCS.setVisibility(0);
      label236:
      if (!paramBoolean) {
        break label445;
      }
      ((a)localObject).ImQ.setText(paramContext.getString(2131767506));
      ((a)localObject).ImQ.setVisibility(0);
      label264:
      ((a)localObject).HCN.setVisibility(0);
      ((a)localObject).HCN.setText(paramBankcard.field_bankName);
      if (!z.aUo()) {
        break label492;
      }
      ((a)localObject).HCO.setVisibility(8);
      label301:
      if (((a)localObject).HCM != null) {
        ((a)localObject).HCM.setText(paramBankcard.field_bankcardTail);
      }
      if ((Util.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (((a)localObject).ImO == null)) {
        break label570;
      }
      ((a)localObject).ImO.setText(paramBankcard.field_card_bottom_wording);
      ((a)localObject).ImN.setVisibility(0);
    }
    for (;;)
    {
      parama.a(paramContext, paramBankcard, ((a)localObject).HCR, ((a)localObject).HCP, ((a)localObject).HCQ, ((a)localObject).ImQ);
      if (((a)localObject).HCT != null)
      {
        t.fQI();
        ((a)localObject).HCT.setVisibility(8);
      }
      AppMethodBeat.o(71478);
      return localView;
      localObject = (a)paramView.getTag();
      localView = paramView;
      break;
      label432:
      ((a)localObject).HCS.setVisibility(8);
      break label236;
      label445:
      if (!Util.isNullOrNil(paramBankcard.field_card_state_name))
      {
        ((a)localObject).ImQ.setText(paramBankcard.field_card_state_name);
        ((a)localObject).ImQ.setVisibility(0);
        break label264;
      }
      ((a)localObject).ImQ.setVisibility(8);
      break label264;
      label492:
      if (!Util.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        ((a)localObject).HCO.setText(paramBankcard.field_bankcardTypeName);
        break label301;
      }
      if (paramBankcard.fQa())
      {
        ((a)localObject).HCO.setText(2131768450);
        break label301;
      }
      if (paramBankcard.fQd())
      {
        ((a)localObject).HCO.setText(2131767664);
        break label301;
      }
      ((a)localObject).HCO.setText(2131767684);
      break label301;
      label570:
      ((a)localObject).ImN.setVisibility(8);
    }
  }
  
  public static int aVW(String paramString)
  {
    AppMethodBeat.i(214248);
    if (HCz.equals(paramString))
    {
      AppMethodBeat.o(214248);
      return 2131235580;
    }
    if (HCD.equals(paramString))
    {
      AppMethodBeat.o(214248);
      return 2131235584;
    }
    if (HCC.equals(paramString))
    {
      AppMethodBeat.o(214248);
      return 2131235586;
    }
    if (HCE.equals(paramString))
    {
      AppMethodBeat.o(214248);
      return 2131235592;
    }
    if (HCA.equals(paramString))
    {
      AppMethodBeat.o(214248);
      return 2131235593;
    }
    if (HCB.equals(paramString))
    {
      AppMethodBeat.o(214248);
      return 2131235599;
    }
    AppMethodBeat.o(214248);
    return -1;
  }
  
  public static Drawable b(Context paramContext, Bitmap paramBitmap)
  {
    AppMethodBeat.i(71480);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(71480);
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if (NinePatch.isNinePatchChunk(arrayOfByte))
      {
        paramContext = new NinePatchDrawable(paramContext.getResources(), paramBitmap, arrayOfByte, new Rect(), null);
        paramContext.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        AppMethodBeat.o(71480);
        return paramContext;
      }
      paramContext = new BitmapDrawable(paramBitmap);
      AppMethodBeat.o(71480);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.f("MicroMsg.BankcardListAdapter", paramContext.getMessage());
      Log.printErrStackTrace("MicroMsg.BankcardListAdapter", paramContext, "", new Object[0]);
      AppMethodBeat.o(71480);
    }
    return null;
  }
  
  static final class a
    implements u.a
  {
    public TextView HCM = null;
    public TextView HCN = null;
    public TextView HCO = null;
    public ViewGroup HCP = null;
    public ImageView HCQ = null;
    public ImageView HCR = null;
    public TextView HCS = null;
    public TextView HCT = null;
    public TextView HCU = null;
    public e ImM;
    public ViewGroup ImN = null;
    public TextView ImO = null;
    public ImageView ImP = null;
    public TextView ImQ = null;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.BankcardListAdapter", bool);
        if (this.ImM != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.ImM.AAU)) {
        this.HCR.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.HCR.setImageBitmap(paramBitmap);
            b.a.this.HCP.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.ImM.HWd)) && (this.HCQ != null)) {
        this.HCQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.HCQ.setImageBitmap(paramBitmap);
            AppMethodBeat.o(71476);
          }
        });
      }
      AppMethodBeat.o(71477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b
 * JD-Core Version:    0.7.0.1
 */