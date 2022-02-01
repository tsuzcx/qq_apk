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
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
{
  public static View a(Context paramContext, View paramView, Bankcard paramBankcard, int paramInt, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(71478);
    View localView;
    Object localObject;
    if ((paramView == null) || (paramView.getTag() == null))
    {
      localView = View.inflate(paramContext, paramInt, null);
      paramView = new a();
      paramView.zMN = ((ImageView)localView.findViewById(2131297121));
      paramView.zMJ = ((TextView)localView.findViewById(2131297130));
      paramView.zMK = ((TextView)localView.findViewById(2131297177));
      paramView.zMI = ((TextView)localView.findViewById(2131297159));
      paramView.zMO = ((TextView)localView.findViewById(2131297158));
      paramView.zML = ((ViewGroup)localView.findViewById(2131306688));
      paramView.zMM = ((ImageView)localView.findViewById(2131297168));
      paramView.zMP = ((TextView)localView.findViewById(2131297153));
      paramView.Atl = ((ViewGroup)localView.findViewById(2131297155));
      paramView.Atm = ((TextView)localView.findViewById(2131297140));
      paramView.Atn = ((ImageView)localView.findViewById(2131297169));
      paramView.Ato = ((TextView)localView.findViewById(2131297173));
      localView.setTag(paramView);
      localObject = paramView;
    }
    for (;;)
    {
      a(paramContext, (a)localObject, paramBankcard, parama, paramBoolean);
      AppMethodBeat.o(71478);
      return localView;
      localObject = (a)paramView.getTag();
      localView = paramView;
    }
  }
  
  private static void a(Context paramContext, a parama, Bankcard paramBankcard, a parama1, boolean paramBoolean)
  {
    AppMethodBeat.i(71479);
    if (paramBankcard.field_bankcardState == 1)
    {
      parama.zMO.setVisibility(0);
      if (!paramBoolean) {
        break label195;
      }
      parama.Ato.setText(paramContext.getString(2131765063));
      parama.Ato.setVisibility(0);
      label47:
      parama.zMJ.setVisibility(0);
      parama.zMJ.setText(paramBankcard.field_bankName);
      if (!u.aqV()) {
        break label239;
      }
      parama.zMK.setVisibility(8);
      label81:
      if (parama.zMI != null) {
        parama.zMI.setText(paramBankcard.field_bankcardTail);
      }
      if ((bt.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (parama.Atm == null)) {
        break label313;
      }
      parama.Atm.setText(paramBankcard.field_card_bottom_wording);
      parama.Atl.setVisibility(0);
    }
    for (;;)
    {
      parama1.a(paramContext, paramBankcard, parama.zMN, parama.zML, parama.zMM, parama.Ato);
      if (parama.zMP != null)
      {
        s.ecc();
        parama.zMP.setVisibility(8);
      }
      AppMethodBeat.o(71479);
      return;
      parama.zMO.setVisibility(8);
      break;
      label195:
      if (!bt.isNullOrNil(paramBankcard.field_card_state_name))
      {
        parama.Ato.setText(paramBankcard.field_card_state_name);
        parama.Ato.setVisibility(0);
        break label47;
      }
      parama.Ato.setVisibility(8);
      break label47;
      label239:
      if (!bt.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        parama.zMK.setText(paramBankcard.field_bankcardTypeName);
        break label81;
      }
      if (paramBankcard.ebu())
      {
        parama.zMK.setText(2131765997);
        break label81;
      }
      if (paramBankcard.ebx())
      {
        parama.zMK.setText(2131765221);
        break label81;
      }
      parama.zMK.setText(2131765241);
      break label81;
      label313:
      parama.Atl.setVisibility(8);
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
      ad.f("MicroMsg.BankcardListAdapter", paramContext.getMessage());
      ad.printErrStackTrace("MicroMsg.BankcardListAdapter", paramContext, "", new Object[0]);
      AppMethodBeat.o(71480);
    }
    return null;
  }
  
  static final class a
    implements u.a
  {
    public e Atk;
    public ViewGroup Atl = null;
    public TextView Atm = null;
    public ImageView Atn = null;
    public TextView Ato = null;
    public TextView zMI = null;
    public TextView zMJ = null;
    public TextView zMK = null;
    public ViewGroup zML = null;
    public ImageView zMM = null;
    public ImageView zMN = null;
    public TextView zMO = null;
    public TextView zMP = null;
    public TextView zMQ = null;
    
    public final void l(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.BankcardListAdapter", bool);
        if (this.Atk != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.Atk.dct)) {
        this.zMN.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.zMN.setImageBitmap(paramBitmap);
            b.a.this.zML.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.Atk.Acw)) && (this.zMM != null)) {
        this.zMM.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.zMM.setImageBitmap(paramBitmap);
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