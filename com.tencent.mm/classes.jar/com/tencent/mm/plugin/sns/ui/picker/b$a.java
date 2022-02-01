package com.tencent.mm.plugin.sns.ui.picker;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerGridItemDecoration$Builder;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mColor", "", "mHorizonSpan", "mIgnoreItemTypeSet", "", "mResources", "Landroid/content/res/Resources;", "mShowLastLine", "", "mVerticalSpan", "addIgnoreItemViewType", "itemViewType", "build", "Lcom/tencent/mm/plugin/sns/ui/picker/SnsAlbumPickerGridItemDecoration;", "setColor", "color", "setColorResource", "resource", "setHorizontalSpan", "horizontal", "", "setIgnoreItemViewType", "ignoreTypeSet", "", "setShowLastLine", "show", "setVerticalSpan", "mVertical", "vertical", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  boolean HNS;
  int HNT;
  int HNU;
  Set<Integer> RRo;
  int mColor;
  private final Context mContext;
  final Resources mResources;
  
  public b$a(Context paramContext)
  {
    AppMethodBeat.i(308633);
    this.mContext = paramContext;
    paramContext = this.mContext.getResources();
    s.s(paramContext, "mContext.resources");
    this.mResources = paramContext;
    this.HNS = true;
    this.mColor = -16777216;
    this.RRo = ((Set)new LinkedHashSet());
    AppMethodBeat.o(308633);
  }
  
  public final a amw(int paramInt)
  {
    AppMethodBeat.i(308637);
    this.RRo.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(308637);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.picker.b.a
 * JD-Core Version:    0.7.0.1
 */