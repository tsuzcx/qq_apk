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
import com.tencent.mm.plugin.wallet_core.model.t;
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
      paramView.CFw = ((ImageView)localView.findViewById(2131297121));
      paramView.CFs = ((TextView)localView.findViewById(2131297130));
      paramView.CFt = ((TextView)localView.findViewById(2131297177));
      paramView.CFr = ((TextView)localView.findViewById(2131297159));
      paramView.CFx = ((TextView)localView.findViewById(2131297158));
      paramView.CFu = ((ViewGroup)localView.findViewById(2131306688));
      paramView.CFv = ((ImageView)localView.findViewById(2131297168));
      paramView.CFy = ((TextView)localView.findViewById(2131297153));
      paramView.DlX = ((ViewGroup)localView.findViewById(2131297155));
      paramView.DlY = ((TextView)localView.findViewById(2131297140));
      paramView.DlZ = ((ImageView)localView.findViewById(2131297169));
      paramView.Dma = ((TextView)localView.findViewById(2131297173));
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
      parama.CFx.setVisibility(0);
      if (!paramBoolean) {
        break label195;
      }
      parama.Dma.setText(paramContext.getString(2131765063));
      parama.Dma.setVisibility(0);
      label47:
      parama.CFs.setVisibility(0);
      parama.CFs.setText(paramBankcard.field_bankName);
      if (!u.aAB()) {
        break label239;
      }
      parama.CFt.setVisibility(8);
      label81:
      if (parama.CFr != null) {
        parama.CFr.setText(paramBankcard.field_bankcardTail);
      }
      if ((bt.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (parama.DlY == null)) {
        break label313;
      }
      parama.DlY.setText(paramBankcard.field_card_bottom_wording);
      parama.DlX.setVisibility(0);
    }
    for (;;)
    {
      parama1.a(paramContext, paramBankcard, parama.CFw, parama.CFu, parama.CFv, parama.Dma);
      if (parama.CFy != null)
      {
        t.eFy();
        parama.CFy.setVisibility(8);
      }
      AppMethodBeat.o(71479);
      return;
      parama.CFx.setVisibility(8);
      break;
      label195:
      if (!bt.isNullOrNil(paramBankcard.field_card_state_name))
      {
        parama.Dma.setText(paramBankcard.field_card_state_name);
        parama.Dma.setVisibility(0);
        break label47;
      }
      parama.Dma.setVisibility(8);
      break label47;
      label239:
      if (!bt.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        parama.CFt.setText(paramBankcard.field_bankcardTypeName);
        break label81;
      }
      if (paramBankcard.eEQ())
      {
        parama.CFt.setText(2131765997);
        break label81;
      }
      if (paramBankcard.eET())
      {
        parama.CFt.setText(2131765221);
        break label81;
      }
      parama.CFt.setText(2131765241);
      break label81;
      label313:
      parama.DlX.setVisibility(8);
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
    public TextView CFr = null;
    public TextView CFs = null;
    public TextView CFt = null;
    public ViewGroup CFu = null;
    public ImageView CFv = null;
    public ImageView CFw = null;
    public TextView CFx = null;
    public TextView CFy = null;
    public TextView CFz = null;
    public e DlW;
    public ViewGroup DlX = null;
    public TextView DlY = null;
    public ImageView DlZ = null;
    public TextView Dma = null;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("MicroMsg.BankcardListAdapter", bool);
        if (this.DlW != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.DlW.wqa)) {
        this.CFw.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.CFw.setImageBitmap(paramBitmap);
            b.a.this.CFu.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.DlW.CVf)) && (this.CFv != null)) {
        this.CFv.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.CFv.setImageBitmap(paramBitmap);
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