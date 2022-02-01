package com.tencent.mm.plugin.textstatus.util;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ap;
import com.tencent.mm.plugin.textstatus.proto.aq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/util/TextStatusIconSpanV2;", "Lcom/tencent/mm/ui/widget/FixImageSpan;", "attachView", "Landroid/view/View;", "d", "Landroid/graphics/drawable/Drawable;", "iconId", "", "verticalAlignment", "", "item", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "iconSize", "extraPadding", "(Landroid/view/View;Landroid/graphics/drawable/Drawable;Ljava/lang/String;ILcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;II)V", "TAG", "getD", "()Landroid/graphics/drawable/Drawable;", "setD", "(Landroid/graphics/drawable/Drawable;)V", "getExtraPadding", "()I", "getIconColor", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "getIconId", "()Ljava/lang/String;", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getIconSize", "setIconSize", "(I)V", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "isUpdate", "", "getItem", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "vRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/api/IRefreshContent;", "attach", "", "v", "draw", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getDrawable", "getSize", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "onClick", "view", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends com.tencent.mm.ui.widget.a
{
  public static final j.a TBr;
  private static final int TBu;
  private final String TAG;
  final a.a TAR;
  Drawable TBs;
  private WeakReference<com.tencent.mm.plugin.textstatus.a.h> TBt;
  final a.c Tnd;
  private final a.b Tne;
  private final com.tencent.mm.plugin.textstatus.h.f.b Tnj;
  private final int TvP;
  final String iconId;
  int iconSize;
  private boolean onE;
  
  static
  {
    AppMethodBeat.i(290456);
    TBr = new j.a((byte)0);
    TBu = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(290456);
  }
  
  public j(View paramView, Drawable paramDrawable, String paramString, com.tencent.mm.plugin.textstatus.h.f.b paramb, a.b paramb1, a.c paramc, a.a parama, int paramInt1, int paramInt2)
  {
    super(paramDrawable, 1);
    AppMethodBeat.i(290410);
    this.TBs = paramDrawable;
    this.iconId = paramString;
    this.Tnj = paramb;
    this.Tne = paramb1;
    this.Tnd = paramc;
    this.TAR = parama;
    this.iconSize = paramInt1;
    this.TvP = paramInt2;
    this.TAG = s.X("MicroMsg.TextStatus.TSIconSpan2@", Integer.valueOf(hashCode()));
    fj(paramView);
    AppMethodBeat.o(290410);
  }
  
  public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    AppMethodBeat.i(290488);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat + this.TvP, paramInt3, paramInt4, paramInt5, paramPaint);
    AppMethodBeat.o(290488);
  }
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(290472);
    if ((paramView instanceof com.tencent.mm.plugin.textstatus.a.h))
    {
      paramView = (com.tencent.mm.plugin.textstatus.a.h)paramView;
      if (paramView != null)
      {
        localObject1 = paramView.getView();
        if (localObject1 != null) {
          break label145;
        }
        localObject1 = null;
        label34:
        if (!an.hF(localObject1)) {
          break label156;
        }
      }
    }
    label145:
    label156:
    for (Object localObject1 = (Set)localObject1;; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = (Set)new HashSet();
      }
      ((Set)localObject2).add(this.iconId);
      localObject1 = paramView.getView();
      if (localObject1 != null) {
        ((View)localObject1).setTag(a.e.TdV, localObject2);
      }
      this.TBt = new WeakReference(paramView);
      AppMethodBeat.o(290472);
      return;
      if (((paramView instanceof TextView)) || ((paramView instanceof NoMeasuredTextView)))
      {
        paramView = (com.tencent.mm.plugin.textstatus.a.h)new b(paramView);
        break;
      }
      paramView = null;
      break;
      localObject1 = ((View)localObject1).getTag(a.e.TdV);
      break label34;
    }
  }
  
  public final Drawable getDrawable()
  {
    String str = null;
    AppMethodBeat.i(290511);
    int i;
    try
    {
      if (this.onE) {
        break label126;
      }
      localObject1 = (CharSequence)this.iconId;
      if (localObject1 == null) {
        break label222;
      }
      if (!n.bp((CharSequence)localObject1)) {
        break label138;
      }
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        label101:
        label126:
        Log.printErrStackTrace(this.TAG, localThrowable, "getDrawable err", new Object[0]);
        label138:
        label143:
        label198:
        continue;
        label222:
        i = 1;
      }
    }
    if (i == 0)
    {
      localObject1 = g.TBm;
      localObject1 = h.a(g.hKu(), this.iconId);
      if (localObject1 != null) {
        break label143;
      }
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        localObject1 = this.Tnj;
        if (localObject1 == null)
        {
          localObject1 = null;
          break label227;
          Object localObject2 = (CharSequence)str;
          if (localObject2 == null) {
            break label234;
          }
          if (!n.bp((CharSequence)localObject2)) {
            break label198;
          }
          break label234;
          if (i == 0)
          {
            localObject2 = g.TBm;
            g.u(str, (kotlin.g.a.b)new c(this, (aq)localObject1));
          }
          localObject1 = this.TBs;
          AppMethodBeat.o(290511);
          return localObject1;
          i = 0;
          break;
          localObject1 = h.a((ap)localObject1);
          continue;
        }
        localObject1 = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          localObject1 = ((TextStatusTopicInfo)localObject1).iconActions;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = h.ly((List)localObject1);
          }
        }
      }
    }
    label227:
    label234:
    label240:
    for (;;)
    {
      str = ((aq)localObject1).url;
      break;
      i = 0;
      break label101;
      for (;;)
      {
        if (localThrowable != null) {
          break label240;
        }
        break;
        i = 1;
        break label101;
      }
    }
  }
  
  public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    AppMethodBeat.i(290481);
    s.u(paramPaint, "paint");
    paramInt1 = super.getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, paramFontMetricsInt);
    paramInt2 = this.TvP;
    AppMethodBeat.o(290481);
    return paramInt1 + paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(290495);
    com.tencent.mm.plugin.textstatus.h.f.b localb = this.Tnj;
    Object localObject = this.Tne;
    if ((localb != null) && (localObject != null) && (localObject == a.b.ThG) && (s.p(localb.field_IconID, "2021")))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("Contact_User", localb.field_UserName);
      if (paramView != null) {
        break label88;
      }
    }
    label88:
    for (paramView = null;; paramView = paramView.getContext())
    {
      c.b(paramView, "profile", ".ui.ContactInfoUI", (Intent)localObject);
      AppMethodBeat.o(290495);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/util/TextStatusIconSpanV2$attach$attachView$1", "Lcom/tencent/mm/plugin/textstatus/api/IRefreshContent;", "getView", "Landroid/view/View;", "refreshContent", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.plugin.textstatus.a.h
  {
    b(View paramView) {}
    
    public final View getView()
    {
      return this.$v;
    }
    
    public final void hsT()
    {
      AppMethodBeat.i(290338);
      this.$v.invalidate();
      AppMethodBeat.o(290338);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "bitmap", "Landroid/graphics/Bitmap;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Bitmap, ah>
  {
    c(j paramj, aq paramaq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.util.j
 * JD-Core Version:    0.7.0.1
 */