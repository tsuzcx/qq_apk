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
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
{
  public static View a(Context paramContext, View paramView, Bankcard paramBankcard, int paramInt, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(142572);
    View localView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(paramContext, paramInt, null);
      paramView = new b.a();
      paramView.tSF = ((ImageView)localView.findViewById(2131828979));
      paramView.tSB = ((TextView)localView.findViewById(2131828980));
      paramView.tSC = ((TextView)localView.findViewById(2131828981));
      paramView.tSA = ((TextView)localView.findViewById(2131828985));
      paramView.tSG = ((TextView)localView.findViewById(2131828987));
      paramView.uwo = ((ViewGroup)localView.findViewById(2131828977));
      paramView.tSE = ((ImageView)localView.findViewById(2131828978));
      paramView.tSH = ((TextView)localView.findViewById(2131828988));
      paramView.uwq = ((ViewGroup)localView.findViewById(2131828990));
      paramView.uwr = ((TextView)localView.findViewById(2131828991));
      paramView.uws = ((ImageView)localView.findViewById(2131828986));
      paramView.uwt = ((TextView)localView.findViewById(2131828989));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      a(paramContext, (b.a)localObject, paramBankcard, parama, paramBoolean);
      AppMethodBeat.o(142572);
      return localView;
      localObject = (b.a)paramView.getTag();
      localView = paramView;
    }
  }
  
  private static void a(Context paramContext, b.a parama, Bankcard paramBankcard, a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(142573);
    if (paramBankcard.field_bankcardState == 1)
    {
      parama.tSG.setVisibility(0);
      if (!paramBoolean) {
        break label195;
      }
      parama.uwt.setText(paramContext.getString(2131304876));
      parama.uwt.setVisibility(0);
      label47:
      parama.tSB.setVisibility(0);
      parama.tSB.setText(paramBankcard.field_bankName);
      if (!r.ZB()) {
        break label239;
      }
      parama.tSC.setVisibility(8);
      label81:
      if (parama.tSA != null) {
        parama.tSA.setText(paramBankcard.field_bankcardTail);
      }
      if ((bo.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (parama.uwr == null)) {
        break label313;
      }
      parama.uwr.setText(paramBankcard.field_card_bottom_wording);
      parama.uwq.setVisibility(0);
    }
    for (;;)
    {
      parama1.a(paramContext, paramBankcard, parama.tSF, parama.uwo, parama.tSE, parama.uwt);
      if (parama.tSH != null)
      {
        t.cTN();
        parama.tSH.setVisibility(8);
      }
      AppMethodBeat.o(142573);
      return;
      parama.tSG.setVisibility(8);
      break;
      label195:
      if (!bo.isNullOrNil(paramBankcard.field_card_state_name))
      {
        parama.uwt.setText(paramBankcard.field_card_state_name);
        parama.uwt.setVisibility(0);
        break label47;
      }
      parama.uwt.setVisibility(8);
      break label47;
      label239:
      if (!bo.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        parama.tSC.setText(paramBankcard.field_bankcardTypeName);
        break label81;
      }
      if (paramBankcard.cTe())
      {
        parama.tSC.setText(2131305777);
        break label81;
      }
      if (paramBankcard.cTh())
      {
        parama.tSC.setText(2131305029);
        break label81;
      }
      parama.tSC.setText(2131305049);
      break label81;
      label313:
      parama.uwq.setVisibility(8);
    }
  }
  
  public static Drawable b(Context paramContext, Bitmap paramBitmap)
  {
    AppMethodBeat.i(47878);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(47878);
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
      if (NinePatch.isNinePatchChunk(arrayOfByte))
      {
        paramContext = new NinePatchDrawable(paramContext.getResources(), paramBitmap, arrayOfByte, new Rect(), null);
        paramContext.setBounds(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        AppMethodBeat.o(47878);
        return paramContext;
      }
      paramContext = new BitmapDrawable(paramBitmap);
      AppMethodBeat.o(47878);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      ab.f("MicroMsg.BankcardListAdapter", paramContext.getMessage());
      ab.printErrStackTrace("MicroMsg.BankcardListAdapter", paramContext, "", new Object[0]);
      AppMethodBeat.o(47878);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b
 * JD-Core Version:    0.7.0.1
 */