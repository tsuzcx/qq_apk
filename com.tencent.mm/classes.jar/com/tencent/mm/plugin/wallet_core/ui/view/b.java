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
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b
{
  private static final String VVM;
  private static final String VVN;
  private static final String VVO;
  private static final String VVP;
  private static final String VVQ;
  private static final String VVR;
  private static final String VjG;
  private static final String VjH;
  private static final String VjI;
  private static final String VjJ;
  private static final String VjK;
  private static final String VjL;
  
  static
  {
    AppMethodBeat.i(301327);
    VjG = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    VVM = "https://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    VjH = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    VVN = "https://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    VjI = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    VVO = "https://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    VjJ = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    VVP = "https://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    VjK = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    VVQ = "https://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    VjL = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    VVR = "https://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    AppMethodBeat.o(301327);
  }
  
  public static View a(Context paramContext, View paramView, Bankcard paramBankcard, int paramInt, com.tencent.mm.plugin.wallet_core.utils.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(71478);
    View localView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(paramContext, paramInt, null);
      paramView = new a();
      paramView.VjY = ((ImageView)localView.findViewById(a.f.bank_logo));
      paramView.VjU = ((TextView)localView.findViewById(a.f.bank_name));
      paramView.VjV = ((TextView)localView.findViewById(a.f.bankcard_type));
      paramView.VjT = ((TextView)localView.findViewById(a.f.bankcard_id));
      paramView.VjT.setTextSize(1, 32.0F);
      paramView.VjZ = ((TextView)localView.findViewById(a.f.bankcard_expired));
      paramView.VjW = ((ViewGroup)localView.findViewById(a.f.wallet_bankcard_rl));
      paramView.VjX = ((ImageView)localView.findViewById(a.f.bankcard_mask));
      paramView.Vka = ((TextView)localView.findViewById(a.f.bankcard_default));
      paramView.VVT = ((ViewGroup)localView.findViewById(a.f.bankcard_desc_ll));
      paramView.VVU = ((TextView)localView.findViewById(a.f.bankcard_bottom_desc_tv));
      paramView.VVV = ((ImageView)localView.findViewById(a.f.bankcard_new));
      paramView.VVW = ((TextView)localView.findViewById(a.f.bankcard_state_tv));
      localView.setTag(paramView);
      localObject = paramView;
      if (paramBankcard.field_bankcardState != 1) {
        break label445;
      }
      ((a)localObject).VjZ.setVisibility(0);
      label248:
      if (!paramBoolean) {
        break label458;
      }
      ((a)localObject).VVW.setText(paramContext.getString(a.i.wallet_bankcard_new_icon));
      ((a)localObject).VVW.setVisibility(0);
      label277:
      ((a)localObject).VjU.setVisibility(0);
      ((a)localObject).VjU.setText(paramBankcard.field_bankName);
      if (!z.bBi()) {
        break label505;
      }
      ((a)localObject).VjV.setVisibility(8);
      label314:
      if (((a)localObject).VjT != null) {
        ((a)localObject).VjT.setText(paramBankcard.field_bankcardTail);
      }
      if ((Util.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (((a)localObject).VVU == null)) {
        break label586;
      }
      ((a)localObject).VVU.setText(paramBankcard.field_card_bottom_wording);
      ((a)localObject).VVT.setVisibility(0);
    }
    for (;;)
    {
      paramb.a(paramContext, paramBankcard, ((a)localObject).VjY, ((a)localObject).VjW, ((a)localObject).VjX, ((a)localObject).VVW);
      if (((a)localObject).Vka != null)
      {
        u.iiC();
        ((a)localObject).Vka.setVisibility(8);
      }
      AppMethodBeat.o(71478);
      return localView;
      localObject = (a)paramView.getTag();
      localView = paramView;
      break;
      label445:
      ((a)localObject).VjZ.setVisibility(8);
      break label248;
      label458:
      if (!Util.isNullOrNil(paramBankcard.field_card_state_name))
      {
        ((a)localObject).VVW.setText(paramBankcard.field_card_state_name);
        ((a)localObject).VVW.setVisibility(0);
        break label277;
      }
      ((a)localObject).VVW.setVisibility(8);
      break label277;
      label505:
      if (!Util.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        ((a)localObject).VjV.setText(paramBankcard.field_bankcardTypeName);
        break label314;
      }
      if (paramBankcard.ihU())
      {
        ((a)localObject).VjV.setText(a.i.wallet_wxcredit_card);
        break label314;
      }
      if (paramBankcard.ihX())
      {
        ((a)localObject).VjV.setText(a.i.wallet_credit_card);
        break label314;
      }
      ((a)localObject).VjV.setText(a.i.wallet_deposit_card);
      break label314;
      label586:
      ((a)localObject).VVT.setVisibility(8);
    }
  }
  
  public static int bho(String paramString)
  {
    AppMethodBeat.i(301326);
    int i;
    if ((VjG.equals(paramString)) || (VVM.equals(paramString)))
    {
      i = a.e.wallet_bankcard_bule_bg;
      AppMethodBeat.o(301326);
      return i;
    }
    if ((VjK.equals(paramString)) || (VVQ.equals(paramString)))
    {
      i = a.e.wallet_bankcard_green_bg;
      AppMethodBeat.o(301326);
      return i;
    }
    if ((VjJ.equals(paramString)) || (VVP.equals(paramString)))
    {
      i = a.e.wallet_bankcard_hbule_bg;
      AppMethodBeat.o(301326);
      return i;
    }
    if ((VjL.equals(paramString)) || (VVR.equals(paramString)))
    {
      i = a.e.wallet_bankcard_purple_bg;
      AppMethodBeat.o(301326);
      return i;
    }
    if ((VjH.equals(paramString)) || (VVN.equals(paramString)))
    {
      i = a.e.wallet_bankcard_red_bg;
      AppMethodBeat.o(301326);
      return i;
    }
    if ((VjI.equals(paramString)) || (VVO.equals(paramString)))
    {
      i = a.e.wallet_bankcard_yellow_bg;
      AppMethodBeat.o(301326);
      return i;
    }
    AppMethodBeat.o(301326);
    return -1;
  }
  
  public static Drawable e(Context paramContext, Bitmap paramBitmap)
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
    implements r.a
  {
    public e VVS;
    public ViewGroup VVT = null;
    public TextView VVU = null;
    public ImageView VVV = null;
    public TextView VVW = null;
    public TextView VjT = null;
    public TextView VjU = null;
    public TextView VjV = null;
    public ViewGroup VjW = null;
    public ImageView VjX = null;
    public ImageView VjY = null;
    public TextView VjZ = null;
    public TextView Vka = null;
    public TextView Vkb = null;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.BankcardListAdapter", bool);
        if (this.VVS != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.VVS.MpW)) {
        this.VjY.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.VjY.setImageBitmap(paramBitmap);
            b.a.this.VjW.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.VVS.VDX)) && (this.VjX != null)) {
        this.VjX.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.VjX.setImageBitmap(paramBitmap);
            AppMethodBeat.o(71476);
          }
        });
      }
      AppMethodBeat.o(71477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b
 * JD-Core Version:    0.7.0.1
 */