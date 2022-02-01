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
import com.tencent.mm.ah.a.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.a.j;

public final class m
  extends j
{
  private int JWY;
  private TextView adRh;
  public Button lDJ;
  Context mContext;
  private ImageView nkq;
  public EditText qiI;
  public TextView titleTv;
  
  public m(Context paramContext)
  {
    super(paramContext, 0, 0, false);
    AppMethodBeat.i(251373);
    this.JWY = 36;
    this.mContext = paramContext;
    aFf(a.h.half_bottom_edit_dlg_layout);
    this.titleTv = ((TextView)this.rootView.findViewById(com.tencent.mm.ah.a.g.tips_title));
    this.qiI = ((EditText)this.rootView.findViewById(com.tencent.mm.ah.a.g.edittext));
    this.lDJ = ((Button)this.rootView.findViewById(com.tencent.mm.ah.a.g.next_btn));
    this.adRh = ((TextView)this.rootView.findViewById(com.tencent.mm.ah.a.g.error_tips));
    this.nkq = ((ImageView)this.rootView.findViewById(com.tencent.mm.ah.a.g.dlg_close));
    this.nkq.setImageDrawable(bb.m(paramContext, a.j.icons_filled_close, this.mContext.getResources().getColor(a.d.black_color)));
    this.nkq.setContentDescription(paramContext.getResources().getString(a.k.close_btn));
    this.nkq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251484);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/base/MMHalfBottomEditDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        m.this.cyW();
        a.a(this, "com/tencent/mm/ui/base/MMHalfBottomEditDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251484);
      }
    });
    this.agfS.setVisibility(0);
    this.lDJ.setTextColor(this.mContext.getResources().getColor(a.d.BW_0_Alpha_0_2));
    this.lDJ.setBackground(this.mContext.getDrawable(a.f.btn_solid_white));
    this.lDJ.setEnabled(false);
    this.agfS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251485);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/base/MMHalfBottomEditDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        m.this.cyW();
        a.a(this, "com/tencent/mm/ui/base/MMHalfBottomEditDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(251485);
      }
    });
    this.qiI.setFilters(new InputFilter[] { new InputFilter.LengthFilter(this.JWY), new b() });
    this.qiI.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(251482);
        m.this.qiI.removeTextChangedListener(this);
        if (paramAnonymousEditable != null)
        {
          paramAnonymousEditable = paramAnonymousEditable.toString();
          if (!Util.isNullOrNil(paramAnonymousEditable))
          {
            int i = g.bCx(paramAnonymousEditable);
            if (i > 0)
            {
              m localm = m.this;
              localm.lDJ.setEnabled(true);
              localm.lDJ.setTextColor(localm.mContext.getResources().getColor(a.d.color_btn_text_selector));
              localm.lDJ.setBackground(localm.mContext.getDrawable(a.f.btn_solid_green));
              g.ek(m.a(m.this), paramAnonymousEditable);
              if (i <= m.a(m.this)) {
                break label293;
              }
              i = g.ei(m.a(m.this), paramAnonymousEditable);
              if ((i <= 0) || (i >= m.a(m.this)) || (i >= paramAnonymousEditable.length())) {
                break label279;
              }
              m.this.qiI.setText(paramAnonymousEditable.substring(0, i + 1));
              m.this.qiI.setSelection(m.this.qiI.getText().length());
              m.b(m.this).setVisibility(0);
              ax.jlo();
              m.b(m.this).setText(m.this.qiI.getContext().getString(a.k.label_text_max_input, new Object[] { Integer.valueOf(m.a(m.this) / 2) }));
            }
          }
        }
        for (;;)
        {
          m.this.qiI.addTextChangedListener(this);
          AppMethodBeat.o(251482);
          return;
          m.this.jmp();
          break;
          label279:
          m.b(m.this).setVisibility(4);
          continue;
          label293:
          m.b(m.this).setVisibility(4);
          continue;
          m.b(m.this).setVisibility(4);
          m.this.jmp();
          continue;
          m.b(m.this).setVisibility(4);
          m.this.jmp();
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    jHS();
    AppMethodBeat.o(251373);
  }
  
  public final int getLayoutId()
  {
    return com.tencent.mm.ck.a.g.mm_half_bottom_custom_outside_dialog;
  }
  
  protected final void jmp()
  {
    AppMethodBeat.i(251384);
    this.lDJ.setEnabled(false);
    this.lDJ.setTextColor(this.mContext.getResources().getColor(a.d.BW_0_Alpha_0_2));
    this.lDJ.setBackground(this.mContext.getDrawable(a.f.btn_solid_white));
    AppMethodBeat.o(251384);
  }
  
  public static abstract interface a
  {
    public abstract void am(CharSequence paramCharSequence);
  }
  
  final class b
    implements InputFilter
  {
    public final char[] JXg;
    
    b()
    {
      AppMethodBeat.i(251409);
      this.JXg = new char[] { 10, 44, 59, 12289, -244, -229 };
      AppMethodBeat.o(251409);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(251414);
      Log.d("MicroMsg.MMHalfBottomDialog", "on create tag filter, %s [%d, %d) %s [%d, %d),", new Object[] { paramCharSequence, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSpanned, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      paramInt4 = paramInt1;
      while (paramInt4 < paramInt2)
      {
        paramSpanned = new char[paramInt2 - paramInt1];
        TextUtils.getChars(paramCharSequence, paramInt1, paramInt2, paramSpanned, 0);
        int j = this.JXg.length;
        int i = 0;
        while (i < j)
        {
          if ((paramSpanned[paramInt4] == ' ') && (paramInt3 == 0) && (paramInt4 == 0))
          {
            AppMethodBeat.o(251414);
            return "";
          }
          if (paramSpanned[paramInt4] == this.JXg[i])
          {
            Log.i("MicroMsg.MMHalfBottomDialog", "MMInputFilter, showInvaildMsg.");
            m.b(m.this).setVisibility(0);
            m.b(m.this).setText(m.c(m.this).getResources().getString(a.k.add_label_invaild_msg_dialog));
            ax.jlo();
            AppMethodBeat.o(251414);
            return "";
          }
          i += 1;
        }
        paramInt4 += 1;
      }
      AppMethodBeat.o(251414);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.m
 * JD-Core Version:    0.7.0.1
 */