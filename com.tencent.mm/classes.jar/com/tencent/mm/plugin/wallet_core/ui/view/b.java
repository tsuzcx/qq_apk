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
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

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
      paramView.CXc = ((ImageView)localView.findViewById(2131297121));
      paramView.CWY = ((TextView)localView.findViewById(2131297130));
      paramView.CWZ = ((TextView)localView.findViewById(2131297177));
      paramView.CWX = ((TextView)localView.findViewById(2131297159));
      paramView.CXd = ((TextView)localView.findViewById(2131297158));
      paramView.CXa = ((ViewGroup)localView.findViewById(2131306688));
      paramView.CXb = ((ImageView)localView.findViewById(2131297168));
      paramView.CXe = ((TextView)localView.findViewById(2131297153));
      paramView.DDB = ((ViewGroup)localView.findViewById(2131297155));
      paramView.DDC = ((TextView)localView.findViewById(2131297140));
      paramView.DDD = ((ImageView)localView.findViewById(2131297169));
      paramView.DDE = ((TextView)localView.findViewById(2131297173));
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
      parama.CXd.setVisibility(0);
      if (!paramBoolean) {
        break label195;
      }
      parama.DDE.setText(paramContext.getString(2131765063));
      parama.DDE.setVisibility(0);
      label47:
      parama.CWY.setVisibility(0);
      parama.CWY.setText(paramBankcard.field_bankName);
      if (!v.aAR()) {
        break label239;
      }
      parama.CWZ.setVisibility(8);
      label81:
      if (parama.CWX != null) {
        parama.CWX.setText(paramBankcard.field_bankcardTail);
      }
      if ((bu.isNullOrNil(paramBankcard.field_card_bottom_wording)) || (parama.DDC == null)) {
        break label313;
      }
      parama.DDC.setText(paramBankcard.field_card_bottom_wording);
      parama.DDB.setVisibility(0);
    }
    for (;;)
    {
      parama1.a(paramContext, paramBankcard, parama.CXc, parama.CXa, parama.CXb, parama.DDE);
      if (parama.CXe != null)
      {
        t.eJf();
        parama.CXe.setVisibility(8);
      }
      AppMethodBeat.o(71479);
      return;
      parama.CXd.setVisibility(8);
      break;
      label195:
      if (!bu.isNullOrNil(paramBankcard.field_card_state_name))
      {
        parama.DDE.setText(paramBankcard.field_card_state_name);
        parama.DDE.setVisibility(0);
        break label47;
      }
      parama.DDE.setVisibility(8);
      break label47;
      label239:
      if (!bu.isNullOrNil(paramBankcard.field_bankcardTypeName))
      {
        parama.CWZ.setText(paramBankcard.field_bankcardTypeName);
        break label81;
      }
      if (paramBankcard.eIx())
      {
        parama.CWZ.setText(2131765997);
        break label81;
      }
      if (paramBankcard.eIA())
      {
        parama.CWZ.setText(2131765221);
        break label81;
      }
      parama.CWZ.setText(2131765241);
      break label81;
      label313:
      parama.DDB.setVisibility(8);
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
      ae.f("MicroMsg.BankcardListAdapter", paramContext.getMessage());
      ae.printErrStackTrace("MicroMsg.BankcardListAdapter", paramContext, "", new Object[0]);
      AppMethodBeat.o(71480);
    }
    return null;
  }
  
  static final class a
    implements u.a
  {
    public TextView CWX = null;
    public TextView CWY = null;
    public TextView CWZ = null;
    public ViewGroup CXa = null;
    public ImageView CXb = null;
    public ImageView CXc = null;
    public TextView CXd = null;
    public TextView CXe = null;
    public TextView CXf = null;
    public e DDA;
    public ViewGroup DDB = null;
    public TextView DDC = null;
    public ImageView DDD = null;
    public TextView DDE = null;
    
    public final void k(String paramString, final Bitmap paramBitmap)
    {
      AppMethodBeat.i(71477);
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(", bitmap = ");
      if (paramBitmap == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("MicroMsg.BankcardListAdapter", bool);
        if (this.DDA != null) {
          break;
        }
        AppMethodBeat.o(71477);
        return;
      }
      if (paramString.equals(this.DDA.wFJ)) {
        this.CXc.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71475);
            b.a.this.CXc.setImageBitmap(paramBitmap);
            b.a.this.CXa.invalidate();
            AppMethodBeat.o(71475);
          }
        });
      }
      if ((paramString.equals(this.DDA.DmL)) && (this.CXb != null)) {
        this.CXb.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(71476);
            b.a.this.CXb.setImageBitmap(paramBitmap);
            AppMethodBeat.o(71476);
          }
        });
      }
      AppMethodBeat.o(71477);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.b
 * JD-Core Version:    0.7.0.1
 */