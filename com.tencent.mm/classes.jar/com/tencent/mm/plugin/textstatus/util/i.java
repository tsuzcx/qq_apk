package com.tencent.mm.plugin.textstatus.util;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.h.f.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Landroid/graphics/drawable/Drawable;ILcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Landroid/view/View;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.ui.widget.a
{
  private static final int TAI;
  public static final i.a TBq;
  private final a.b Tne;
  private final b Tnj;
  
  static
  {
    AppMethodBeat.i(290369);
    TBq = new i.a((byte)0);
    TAI = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(290369);
  }
  
  public i(Drawable paramDrawable, b paramb, a.b paramb1)
  {
    super(paramDrawable, 1);
    this.Tnj = paramb;
    this.Tne = paramb1;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(290381);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat + TAI, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(290381);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(290375);
    s.u(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = TAI;
    AppMethodBeat.o(290375);
    return paramInt1 + paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290390);
    b localb = this.Tnj;
    Object localObject = this.Tne;
    if ((localb != null) && (localObject != null) && (localObject == a.b.ThG) && (s.p(localb.field_IconID, "2021")))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", localb.field_UserName);
      if (paramView != null) {
        break label82;
      }
    }
    label82:
    for (paramView = null;; paramView = paramView.getContext())
    {
      c.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      AppMethodBeat.o(290390);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.i
 * JD-Core Version:    0.7.0.1
 */