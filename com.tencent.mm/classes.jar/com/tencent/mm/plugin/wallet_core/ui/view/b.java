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
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public static View a(Context paramContext, View paramView, Bankcard paramBankcard, int paramInt1, a parama, boolean paramBoolean, int paramInt2)
  {
    b.a locala;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = View.inflate(paramContext, paramInt1, null);
      locala = new b.a();
      locala.qjF = ((ImageView)paramView.findViewById(a.f.bank_logo));
      locala.qjB = ((TextView)paramView.findViewById(a.f.bank_name));
      locala.qjC = ((TextView)paramView.findViewById(a.f.bankcard_type));
      locala.qjA = ((TextView)paramView.findViewById(a.f.bankcard_id));
      locala.qjG = ((TextView)paramView.findViewById(a.f.bankcard_expired));
      locala.qHD = ((ViewGroup)paramView.findViewById(a.f.wallet_bankcard_rl));
      locala.qjE = ((ImageView)paramView.findViewById(a.f.bankcard_mask));
      locala.qjH = ((TextView)paramView.findViewById(a.f.bankcard_default));
      locala.qHF = ((ViewGroup)paramView.findViewById(a.f.bankcard_desc_ll));
      locala.qHG = ((TextView)paramView.findViewById(a.f.bankcard_bottom_desc_tv));
      locala.qHH = ((ImageView)paramView.findViewById(a.f.bankcard_new));
      locala.qHI = ((TextView)paramView.findViewById(a.f.bankcard_state_tv));
      paramView.setTag(locala);
      if (paramBankcard.field_bankcardState != 1) {
        break label418;
      }
      locala.qjG.setVisibility(0);
      label230:
      if (!paramBoolean) {
        break label431;
      }
      locala.qHI.setText(paramContext.getString(a.i.wallet_bankcard_new_icon));
      locala.qHI.setVisibility(0);
      label259:
      if (1 != paramInt2) {
        break label478;
      }
      locala.qjB.setVisibility(8);
      label275:
      if (!q.Gw()) {
        break label502;
      }
      locala.qjC.setVisibility(8);
      label291:
      if (locala.qjA != null) {
        locala.qjA.setText(paramBankcard.field_bankcardTail);
      }
      if ((bk.bl(paramBankcard.field_card_bottom_wording)) || (locala.qHG == null)) {
        break label583;
      }
      locala.qHG.setText(paramBankcard.field_card_bottom_wording);
      locala.qHF.setVisibility(0);
    }
    for (;;)
    {
      parama.a(paramContext, paramBankcard, locala.qjF, locala.qHD, locala.qjE, locala.qHI);
      if (locala.qjH != null)
      {
        o.bVs();
        paramContext = paramBankcard.field_bindSerial;
        locala.qjH.setVisibility(8);
      }
      return paramView;
      locala = (b.a)paramView.getTag();
      break;
      label418:
      locala.qjG.setVisibility(8);
      break label230;
      label431:
      if (!bk.bl(paramBankcard.field_card_state_name))
      {
        locala.qHI.setText(paramBankcard.field_card_state_name);
        locala.qHI.setVisibility(0);
        break label259;
      }
      locala.qHI.setVisibility(8);
      break label259;
      label478:
      locala.qjB.setVisibility(0);
      locala.qjB.setText(paramBankcard.field_bankName);
      break label275;
      label502:
      if (!bk.bl(paramBankcard.field_bankcardTypeName))
      {
        locala.qjC.setText(paramBankcard.field_bankcardTypeName);
        break label291;
      }
      if (paramBankcard.bUP())
      {
        locala.qjC.setText(a.i.wallet_wxcredit_card);
        break label291;
      }
      if (paramBankcard.bUS())
      {
        locala.qjC.setText(a.i.wallet_credit_card);
        break label291;
      }
      locala.qjC.setText(a.i.wallet_deposit_card);
      break label291;
      label583:
      locala.qHF.setVisibility(8);
    }
  }
  
  public static Drawable b(Context paramContext, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if (NinePatch.isNinePatchChunk(arrayOfByte))
      {
        paramContext = new NinePatchDrawable(paramContext.getResources(), paramBitmap, arrayOfByte, new Rect(), null);
        paramContext.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      y.f("MicroMsg.BankcardListAdapter", paramContext.getMessage());
      y.printErrStackTrace("MicroMsg.BankcardListAdapter", paramContext, "", new Object[0]);
      return null;
    }
    paramContext = new BitmapDrawable(paramBitmap);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b
 * JD-Core Version:    0.7.0.1
 */