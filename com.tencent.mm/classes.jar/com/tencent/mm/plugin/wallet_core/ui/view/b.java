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
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class b
{
  private static final String Ous;
  private static final String Out;
  private static final String Ouu;
  private static final String Ouv;
  private static final String Ouw;
  private static final String Oux;
  
  static
  {
    AppMethodBeat.i(187049);
    Ous = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_bule_bg.9_v2.png";
    Out = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_red_bg.9_v2.png";
    Ouu = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_yellow_bg.9_v2.png";
    Ouv = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_hbule_bg.9_v2.png";
    Ouw = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_green_bg.9_v2.png";
    Oux = "http://" + WeChatHosts.domainString(a.i.host_res_wx_qq_com) + "/zh_CN/htmledition/images/mmpaybanklogo/wallet_bankcard_purple_bg.9_v2.png";
    AppMethodBeat.o(187049);
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
      paramView.OuK = ((ImageView)localView.findViewById(a.f.bank_logo));
      paramView.OuG = ((TextView)localView.findViewById(a.f.bank_name));
      paramView.OuH = ((TextView)localView.findViewById(a.f.bankcard_type));
      paramView.OuF = ((TextView)localView.findViewById(a.f.bankcard_id));
      paramView.OuF.setTextSize(1, 32.0F);
      paramView.OuL = ((TextView)localView.findViewById(a.f.bankcard_expired));
      paramView.OuI = ((ViewGroup)localView.findViewById(a.f.wallet_bankcard_rl));
      paramView.OuJ = ((ImageView)localView.findViewById(a.f.bankcard_mask));
      paramView.OuM = ((TextView)localView.findViewById(a.f.bankcard_default));
      paramView.Pff = ((ViewGroup)localView.findViewById(a.f.bankcard_desc_ll));
      paramView.Pfg = ((TextView)localView.findViewById(a.f.bankcard_bottom_desc_tv));
      paramView.Pfh = ((ImageView)localView.findViewById(a.f.bankcard_new));
      paramView.Pfi = ((TextView)localView.findViewById(a.f.bankcard_state_tv));
      localView.setTag(paramView);
      localObject = paramView;
      if (paramBankcard.field_bankcardState != 1) {
        break label445;
      }
      ((a)localObject).OuL.setVisibility(0);
      label248:
      if (!paramBoolean) {
        break label458;
      }
      ((a)localObject).Pfi.setText(paramContext.getString(a.i.wallet_bankcard_new_icon));
      ((a)localObject).Pfi.setVisibility(0);
      label277:
      ((a)localObject).OuG.setVisibility(0);
      ((a)localObject).OuG.setText(paramBankcard.field_bankName);
      if (!z.bdq()) {
        break label505;
      }
      ((a)localObject).OuH.setVisibility(8);
      label314:
      if (((a)localObject).OuF != null) {
        ((a)localObject).OuF.setText(paramBankcard.field_bankcardTail);
      }
      if ((Util.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (((a)localObject).Pfg == null)) {
        break label586;
      }
      ((a)localObject).Pfg.setText(paramBankcard.field_card_bottom_wording);
      ((a)localObject).Pff.setVisibility(0);
    }
    for (;;)
    {
      parama.a(paramContext, paramBankcard, ((a)localObject).OuK, ((a)localObject).OuI, ((a)localObject).OuJ, ((a)localObject).Pfi);
      if (((a)localObject).OuM != null)
      {
        u.gJo();
        ((a)localObject).OuM.setVisibility(8);
      }
      AppMethodBeat.o(71478);
      return localView;
      localObject = (a)paramView.getTag();
      localView = paramView;
      break;
      label445:
      ((a)localObject).OuL.setVisibility(8);
      break label248;
      label458:
      if (!Util.isNullOrNil(paramBankcard.field_card_state_name))
      {
        ((a)localObject).Pfi.setText(paramBankcard.field_card_state_name);
        ((a)localObject).Pfi.setVisibility(0);
        break label277;
      }
      ((a)localObject).Pfi.setVisibility(8);
      break label277;
      label505:
      if (!Util.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        ((a)localObject).OuH.setText(paramBankcard.field_bankcardTypeName);
        break label314;
      }
      if (paramBankcard.gIG())
      {
        ((a)localObject).OuH.setText(a.i.wallet_wxcredit_card);
        break label314;
      }
      if (paramBankcard.gIJ())
      {
        ((a)localObject).OuH.setText(a.i.wallet_credit_card);
        break label314;
      }
      ((a)localObject).OuH.setText(a.i.wallet_deposit_card);
      break label314;
      label586:
      ((a)localObject).Pff.setVisibility(8);
    }
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
  
  public static int bhF(String paramString)
  {
    AppMethodBeat.i(187047);
    int i;
    if (Ous.equals(paramString))
    {
      i = a.e.wallet_bankcard_bule_bg;
      AppMethodBeat.o(187047);
      return i;
    }
    if (Ouw.equals(paramString))
    {
      i = a.e.wallet_bankcard_green_bg;
      AppMethodBeat.o(187047);
      return i;
    }
    if (Ouv.equals(paramString))
    {
      i = a.e.wallet_bankcard_hbule_bg;
      AppMethodBeat.o(187047);
      return i;
    }
    if (Oux.equals(paramString))
    {
      i = a.e.wallet_bankcard_purple_bg;
      AppMethodBeat.o(187047);
      return i;
    }
    if (Out.equals(paramString))
    {
      i = a.e.wallet_bankcard_red_bg;
      AppMethodBeat.o(187047);
      return i;
    }
    if (Ouu.equals(paramString))
    {
      i = a.e.wallet_bankcard_yellow_bg;
      AppMethodBeat.o(187047);
      return i;
    }
    AppMethodBeat.o(187047);
    return -1;
  }
  
  static final class a
    implements u.a
  {
    public TextView OuF = null;
    public TextView OuG = null;
    public TextView OuH = null;
    public ViewGroup OuI = null;
    public ImageView OuJ = null;
    public ImageView OuK = null;
    public TextView OuL = null;
    public TextView OuM = null;
    public TextView OuN = null;
    public e Pfe;
    public ViewGroup Pff = null;
    public TextView Pfg = null;
    public ImageView Pfh = null;
    public TextView Pfi = null;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("MicroMsg.BankcardListAdapter", bool);
        if (this.Pfe != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.Pfe.GtW)) {
        this.OuK.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.OuK.setImageBitmap(paramBitmap);
            b.a.this.OuI.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.Pfe.OOd)) && (this.OuJ != null)) {
        this.OuJ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.OuJ.setImageBitmap(paramBitmap);
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