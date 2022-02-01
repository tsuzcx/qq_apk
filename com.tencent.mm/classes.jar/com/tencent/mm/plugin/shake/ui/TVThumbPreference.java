package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.platformtools.u.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference
  extends Preference
  implements u.a
{
  private ImageView DlJ;
  private ImageView DlK;
  private ImageView DlL;
  List<String> DlM;
  f nRm;
  
  public TVThumbPreference(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TVThumbPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TVThumbPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(28608);
    this.DlM = null;
    setLayoutResource(2131496770);
    setWidgetLayoutResource(0);
    u.a(this);
    AppMethodBeat.o(28608);
  }
  
  public final void k(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28611);
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(28611);
      return;
    }
    if ((this.DlJ != null) && (this.DlJ.getTag() != null) && (paramString.equals((String)this.DlJ.getTag())))
    {
      this.DlJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28605);
          TVThumbPreference.a(TVThumbPreference.this).setImageBitmap(paramBitmap);
          if (TVThumbPreference.b(TVThumbPreference.this) != null) {
            TVThumbPreference.b(TVThumbPreference.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(28605);
        }
      });
      AppMethodBeat.o(28611);
      return;
    }
    if ((this.DlK != null) && (this.DlK.getTag() != null) && (paramString.equals((String)this.DlK.getTag())))
    {
      this.DlK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28606);
          TVThumbPreference.c(TVThumbPreference.this).setImageBitmap(paramBitmap);
          if (TVThumbPreference.b(TVThumbPreference.this) != null) {
            TVThumbPreference.b(TVThumbPreference.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(28606);
        }
      });
      AppMethodBeat.o(28611);
      return;
    }
    if ((this.DlL != null) && (this.DlL.getTag() != null) && (paramString.equals((String)this.DlL.getTag()))) {
      this.DlL.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(28607);
          TVThumbPreference.d(TVThumbPreference.this).setImageBitmap(paramBitmap);
          if (TVThumbPreference.b(TVThumbPreference.this) != null) {
            TVThumbPreference.b(TVThumbPreference.this).notifyDataSetChanged();
          }
          AppMethodBeat.o(28607);
        }
      });
    }
    AppMethodBeat.o(28611);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(28610);
    super.onBindView(paramView);
    this.DlJ = ((ImageView)paramView.findViewById(2131309069));
    this.DlK = ((ImageView)paramView.findViewById(2131309070));
    this.DlL = ((ImageView)paramView.findViewById(2131309071));
    if (this.DlM != null)
    {
      if (this.DlM.size() <= 0)
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.DlM.get(0));
      this.DlJ.setTag(paramView.blC());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.DlJ.setImageBitmap(paramView);
      }
      this.DlJ.setVisibility(0);
      if (1 >= this.DlM.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.DlM.get(1));
      this.DlK.setTag(paramView.blC());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.DlK.setImageBitmap(paramView);
      }
      this.DlK.setVisibility(0);
      if (2 >= this.DlM.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.DlM.get(2));
      this.DlL.setTag(paramView.blC());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.DlL.setImageBitmap(paramView);
      }
      this.DlL.setVisibility(0);
    }
    AppMethodBeat.o(28610);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28609);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(28609);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference
 * JD-Core Version:    0.7.0.1
 */