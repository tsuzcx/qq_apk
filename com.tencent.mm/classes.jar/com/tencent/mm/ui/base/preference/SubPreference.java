package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public class SubPreference
  extends Preference
{
  private View contentView;
  
  public SubPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SubPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(251504);
    super.onBindView(paramView);
    this.contentView = paramView.findViewById(a.g.root_content);
    if (this.adZO != null) {
      this.contentView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251508);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/base/preference/SubPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          SubPreference.this.adZO.gAW();
          a.a(this, "com/tencent/mm/ui/base/preference/SubPreference$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251508);
        }
      });
    }
    if (this.adZP != null) {
      paramView.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251509);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/base/preference/SubPreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
          boolean bool = SubPreference.this.adZP.gCr();
          a.a(bool, this, "com/tencent/mm/ui/base/preference/SubPreference$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(251509);
          return bool;
        }
      });
    }
    AppMethodBeat.o(251504);
  }
  
  protected final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(251503);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(a.g.content);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(a.h.mm_sub_preference, localViewGroup);
    AppMethodBeat.o(251503);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.preference.SubPreference
 * JD-Core Version:    0.7.0.1
 */