package com.tencent.mm.plugin.textstatus.k;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ac;
import com.tencent.mm.plugin.textstatus.proto.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.g.a.b;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpanV2;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "attachView", "Landroid/view/View;", "d", "Landroid/graphics/drawable/Drawable;", "iconId", "", "verticalAlignment", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "iconSize", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;Ljava/lang/String;ILcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;I)V", "getD", "()Landroid/graphics/drawable/Drawable;", "setD", "(Landroid/graphics/drawable/Drawable;)V", "getIconColor", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconId", "()Ljava/lang/String;", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getIconSize", "()I", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "isUpdate", "", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "vRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/api/IRefreshContent;", "attach", "", "v", "draw", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getDrawable", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Companion", "plugin-textstatus_release"})
public final class l
  extends com.tencent.mm.ui.widget.a
{
  private static final int MMY;
  public static final l.a MOT;
  final a.c MDC;
  private final a.b MDD;
  private final com.tencent.mm.plugin.textstatus.g.e.a MDH;
  private WeakReference<f> MOR;
  Drawable MOS;
  final a.a MOr;
  final String iconId;
  final int iconSize;
  private boolean lwf;
  
  static
  {
    AppMethodBeat.i(236021);
    MOT = new l.a((byte)0);
    MMY = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(236021);
  }
  
  public l(View paramView, Drawable paramDrawable, String paramString, com.tencent.mm.plugin.textstatus.g.e.a parama, a.b paramb, a.c paramc, a.a parama1, int paramInt)
  {
    super(paramDrawable, 1);
    AppMethodBeat.i(236018);
    this.MOS = paramDrawable;
    this.iconId = paramString;
    this.MDH = parama;
    this.MDD = paramb;
    this.MDC = paramc;
    this.MOr = parama1;
    this.iconSize = paramInt;
    eo(paramView);
    AppMethodBeat.o(236018);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(236004);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat + MMY, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(236004);
  }
  
  public final void eo(View paramView)
  {
    Object localObject = null;
    AppMethodBeat.i(235997);
    f localf;
    if ((paramView instanceof f))
    {
      localf = (f)paramView;
      if (localf != null)
      {
        paramView = localf.getView();
        if (paramView == null) {
          break label152;
        }
        paramView = paramView.getTag(b.e.MwF);
        label42:
        if (ag.fh(paramView)) {
          break label157;
        }
        paramView = (View)localObject;
      }
    }
    label152:
    label157:
    for (;;)
    {
      localObject = (Set)paramView;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = (Set)new HashSet();
      }
      paramView.add(this.iconId);
      localObject = localf.getView();
      if (localObject != null) {
        ((View)localObject).setTag(b.e.MwF, paramView);
      }
      this.MOR = new WeakReference(localf);
      AppMethodBeat.o(235997);
      return;
      if (((paramView instanceof TextView)) || ((paramView instanceof NoMeasuredTextView)))
      {
        paramView = new b(paramView);
        break;
      }
      paramView = null;
      break;
      paramView = null;
      break label42;
    }
  }
  
  public final Drawable getDrawable()
  {
    String str = null;
    AppMethodBeat.i(236013);
    try
    {
      if (this.lwf) {
        break label153;
      }
      localObject1 = (CharSequence)this.iconId;
      if (localObject1 == null) {
        break label201;
      }
      if (!n.ba((CharSequence)localObject1)) {
        break label165;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        label97:
        Object localObject2;
        label153:
        label165:
        label170:
        label175:
        Log.printErrStackTrace("TextStatusIconSpanV2", localThrowable, "getDrawable err", new Object[0]);
        continue;
        continue;
        int i = 1;
        continue;
        i = 1;
      }
    }
    if (i == 0)
    {
      localObject1 = i.MOO;
      localObject1 = j.a(i.gnJ(), this.iconId);
      if (localObject1 != null)
      {
        localObject1 = j.a((ac)localObject1);
        if (localObject1 != null) {
          break label198;
        }
      }
      localObject1 = this.MDH;
      if (localObject1 == null) {
        break label170;
      }
      localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY().iconActions;
      if (localObject1 == null) {
        break label170;
      }
      localObject1 = j.is((List)localObject1);
      if (localObject1 != null) {
        str = ((ad)localObject1).url;
      }
      localObject2 = (CharSequence)str;
      if (localObject2 == null) {
        break label206;
      }
      if (!n.ba((CharSequence)localObject2)) {
        break label175;
      }
      break label206;
    }
    for (;;)
    {
      if (i == 0)
      {
        localObject2 = i.MOO;
        i.o(str, (b)new c(this, (ad)localObject1));
      }
      localObject1 = this.MOS;
      AppMethodBeat.o(236013);
      return localObject1;
      i = 0;
      break;
      localObject1 = null;
      break label97;
      i = 0;
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(236000);
    p.k(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = MMY;
    AppMethodBeat.o(236000);
    return paramInt1 + paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(236009);
    com.tencent.mm.plugin.textstatus.g.e.a locala = this.MDH;
    Object localObject = this.MDD;
    if ((locala != null) && (localObject != null) && (localObject == a.b.MzC) && (p.h(locala.field_IconID, "2021")))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", locala.field_UserName);
      if (paramView == null) {
        break label91;
      }
    }
    label91:
    for (paramView = paramView.getContext();; paramView = null)
    {
      c.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      AppMethodBeat.o(236009);
      return;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/util/TextStatusIconSpanV2$attach$attachView$1", "Lcom/tencent/mm/plugin/textstatus/api/IRefreshContent;", "getView", "Landroid/view/View;", "refreshContent", "", "plugin-textstatus_release"})
  public static final class b
    implements f
  {
    b(View paramView) {}
    
    public final void fZC()
    {
      AppMethodBeat.i(233164);
      this.jLx.invalidate();
      AppMethodBeat.o(233164);
    }
    
    public final View getView()
    {
      return this.jLx;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;", "invoke"})
  static final class c
    extends q
    implements b<Bitmap, x>
  {
    c(l paraml, ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.k.l
 * JD-Core Version:    0.7.0.1
 */