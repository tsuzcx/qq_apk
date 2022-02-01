package com.tencent.mm.plugin.textstatus.k;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "d", "Landroid/graphics/drawable/Drawable;", "verticalAlignment", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Landroid/graphics/drawable/Drawable;ILcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Landroid/view/View;", "Companion", "plugin-textstatus_release"})
public final class k
  extends com.tencent.mm.ui.widget.a
{
  private static final int MMY;
  public static final a MOQ;
  private final a.b MDD;
  private final com.tencent.mm.plugin.textstatus.g.e.a MDH;
  
  static
  {
    AppMethodBeat.i(233875);
    MOQ = new a((byte)0);
    MMY = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(233875);
  }
  
  public k(Drawable paramDrawable, com.tencent.mm.plugin.textstatus.g.e.a parama, a.b paramb)
  {
    super(paramDrawable, 1);
    this.MDH = parama;
    this.MDD = paramb;
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(233867);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat + MMY, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(233867);
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(233866);
    p.k(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = MMY;
    AppMethodBeat.o(233866);
    return paramInt1 + paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(233870);
    com.tencent.mm.plugin.textstatus.g.e.a locala = this.MDH;
    Object localObject = this.MDD;
    if ((locala != null) && (localObject != null) && (localObject == a.b.MzC) && (p.h(locala.field_IconID, "2021")))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", locala.field_UserName);
      if (paramView == null) {
        break label85;
      }
    }
    label85:
    for (paramView = paramView.getContext();; paramView = null)
    {
      c.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      AppMethodBeat.o(233870);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpan$Companion;", "", "()V", "PADDING", "", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.k
 * JD-Core Version:    0.7.0.1
 */