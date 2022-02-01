package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;

public final class k
  extends com.tencent.mm.ui.widget.a.g
{
  private int Efk;
  public Button jbJ;
  private ImageView kHA;
  Context mContext;
  public EditText nlz;
  public TextView titleTv;
  
  public k(Context paramContext)
  {
    super(paramContext, 0, 0, false);
    AppMethodBeat.i(196143);
    this.Efk = 36;
    this.mContext = paramContext;
    ayv(a.h.half_bottom_edit_dlg_layout);
    this.titleTv = ((TextView)this.oFW.findViewById(com.tencent.mm.ah.a.g.tips_title));
    this.nlz = ((EditText)this.oFW.findViewById(com.tencent.mm.ah.a.g.edittext));
    this.jbJ = ((Button)this.oFW.findViewById(com.tencent.mm.ah.a.g.next_btn));
    this.kHA = ((ImageView)this.oFW.findViewById(com.tencent.mm.ah.a.g.dlg_close));
    this.kHA.setImageDrawable(au.o(paramContext, a.j.icons_filled_close, this.mContext.getResources().getColor(a.d.black_color)));
    this.kHA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(191148);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/base/MMHalfBottomEditDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        k.this.bYF();
        a.a(this, "com/tencent/mm/ui/base/MMHalfBottomEditDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(191148);
      }
    });
    this.YnG.setVisibility(0);
    this.jbJ.setTextColor(this.mContext.getResources().getColor(a.d.BW_0_Alpha_0_2));
    this.jbJ.setBackground(this.mContext.getDrawable(a.f.btn_solid_white));
    this.jbJ.setEnabled(false);
    this.YnG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(203407);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/base/MMHalfBottomEditDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        k.this.bYF();
        a.a(this, "com/tencent/mm/ui/base/MMHalfBottomEditDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203407);
      }
    });
    if (this.nlz != null) {
      this.nlz.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.Efk), new b() });
    }
    this.nlz.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(190907);
        k.this.nlz.removeTextChangedListener(this);
        if (paramAnonymousEditable != null)
        {
          paramAnonymousEditable = paramAnonymousEditable.toString();
          if (!Util.isNullOrNil(paramAnonymousEditable))
          {
            int i = com.tencent.mm.ui.tools.g.bAB(paramAnonymousEditable);
            if (i > 0)
            {
              k localk = k.this;
              localk.jbJ.setEnabled(true);
              localk.jbJ.setTextColor(localk.mContext.getResources().getColor(a.d.color_btn_text_selector));
              localk.jbJ.setBackground(localk.mContext.getDrawable(a.f.btn_solid_green));
              com.tencent.mm.ui.tools.g.dr(k.a(k.this), paramAnonymousEditable);
              if (i > k.a(k.this))
              {
                i = com.tencent.mm.ui.tools.g.dp(k.a(k.this), paramAnonymousEditable);
                if ((i > 0) && (i < k.a(k.this)) && (i < paramAnonymousEditable.length()))
                {
                  k.this.nlz.setText(paramAnonymousEditable.substring(0, i + 1));
                  k.this.nlz.setSelection(k.this.nlz.getText().length());
                }
              }
            }
          }
        }
        for (;;)
        {
          k.this.nlz.addTextChangedListener(this);
          AppMethodBeat.o(190907);
          return;
          k.this.hJI();
          break;
          k.this.hJI();
          continue;
          k.this.hJI();
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    icG();
    AppMethodBeat.o(196143);
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.cr.a.g.mm_half_bottom_custom_outside_dialog;
  }
  
  protected final void hJI()
  {
    AppMethodBeat.i(196146);
    this.jbJ.setEnabled(false);
    this.jbJ.setTextColor(this.mContext.getResources().getColor(a.d.BW_0_Alpha_0_2));
    this.jbJ.setBackground(this.mContext.getDrawable(a.f.btn_solid_white));
    AppMethodBeat.o(196146);
  }
  
  public static abstract interface a
  {
    public abstract void ad(CharSequence paramCharSequence);
  }
  
  final class b
    implements InputFilter
  {
    public final char[] Efs;
    
    b()
    {
      AppMethodBeat.i(189039);
      this.Efs = new char[] { 10, 44, 59, 12289, -244, -229 };
      AppMethodBeat.o(189039);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(189042);
      Log.d("MicroMsg.MMHalfBottomDialog", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      paramInt4 = paramInt1;
      while (paramInt4 < paramInt2)
      {
        paramSpanned = new char[paramInt2 - paramInt1];
        TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, paramSpanned, 0);
        int j = this.Efs.length;
        int i = 0;
        while (i < j)
        {
          if ((paramSpanned[paramInt4] == ' ') && (paramInt3 == 0) && (paramInt4 == 0))
          {
            AppMethodBeat.o(189042);
            return "";
          }
          if (paramSpanned[paramInt4] == this.Efs[i])
          {
            Log.i("MicroMsg.MMHalfBottomDialog", "MMInputFilter, showInvaildMsg.");
            AppMethodBeat.o(189042);
            return "";
          }
          i += 1;
        }
        paramInt4 += 1;
      }
      AppMethodBeat.o(189042);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */