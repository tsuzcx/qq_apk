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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

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
      paramView.Bfh = ((ImageView)localView.findViewById(2131297121));
      paramView.Bfd = ((TextView)localView.findViewById(2131297130));
      paramView.Bfe = ((TextView)localView.findViewById(2131297177));
      paramView.Bfc = ((TextView)localView.findViewById(2131297159));
      paramView.Bfi = ((TextView)localView.findViewById(2131297158));
      paramView.Bff = ((ViewGroup)localView.findViewById(2131306688));
      paramView.Bfg = ((ImageView)localView.findViewById(2131297168));
      paramView.Bfj = ((TextView)localView.findViewById(2131297153));
      paramView.BLF = ((ViewGroup)localView.findViewById(2131297155));
      paramView.BLG = ((TextView)localView.findViewById(2131297140));
      paramView.BLH = ((ImageView)localView.findViewById(2131297169));
      paramView.BLI = ((TextView)localView.findViewById(2131297173));
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
      parama.Bfi.setVisibility(0);
      if (!paramBoolean) {
        break label195;
      }
      parama.BLI.setText(paramContext.getString(2131765063));
      parama.BLI.setVisibility(0);
      label47:
      parama.Bfd.setVisibility(0);
      parama.Bfd.setText(paramBankcard.field_bankName);
      if (!u.axL()) {
        break label239;
      }
      parama.Bfe.setVisibility(8);
      label81:
      if (parama.Bfc != null) {
        parama.Bfc.setText(paramBankcard.field_bankcardTail);
      }
      if ((bs.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (parama.BLG == null)) {
        break label313;
      }
      parama.BLG.setText(paramBankcard.field_card_bottom_wording);
      parama.BLF.setVisibility(0);
    }
    for (;;)
    {
      parama1.a(paramContext, paramBankcard, parama.Bfh, parama.Bff, parama.Bfg, parama.BLI);
      if (parama.Bfj != null)
      {
        s.ery();
        parama.Bfj.setVisibility(8);
      }
      AppMethodBeat.o(71479);
      return;
      parama.Bfi.setVisibility(8);
      break;
      label195:
      if (!bs.isNullOrNil(paramBankcard.field_card_state_name))
      {
        parama.BLI.setText(paramBankcard.field_card_state_name);
        parama.BLI.setVisibility(0);
        break label47;
      }
      parama.BLI.setVisibility(8);
      break label47;
      label239:
      if (!bs.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        parama.Bfe.setText(paramBankcard.field_bankcardTypeName);
        break label81;
      }
      if (paramBankcard.eqQ())
      {
        parama.Bfe.setText(2131765997);
        break label81;
      }
      if (paramBankcard.eqT())
      {
        parama.Bfe.setText(2131765221);
        break label81;
      }
      parama.Bfe.setText(2131765241);
      break label81;
      label313:
      parama.BLF.setVisibility(8);
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
      ac.f("MicroMsg.BankcardListAdapter", paramContext.getMessage());
      ac.printErrStackTrace("MicroMsg.BankcardListAdapter", paramContext, "", new Object[0]);
      AppMethodBeat.o(71480);
    }
    return null;
  }
  
  static final class a
    implements u.a
  {
    public e BLE;
    public ViewGroup BLF = null;
    public TextView BLG = null;
    public ImageView BLH = null;
    public TextView BLI = null;
    public TextView Bfc = null;
    public TextView Bfd = null;
    public TextView Bfe = null;
    public ViewGroup Bff = null;
    public ImageView Bfg = null;
    public ImageView Bfh = null;
    public TextView Bfi = null;
    public TextView Bfj = null;
    public TextView Bfk = null;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("MicroMsg.BankcardListAdapter", bool);
        if (this.BLE != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.BLE.vkI)) {
        this.Bfh.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.Bfh.setImageBitmap(paramBitmap);
            b.a.this.Bff.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.BLE.BuQ)) && (this.Bfg != null)) {
        this.Bfg.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.Bfg.setImageBitmap(paramBitmap);
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