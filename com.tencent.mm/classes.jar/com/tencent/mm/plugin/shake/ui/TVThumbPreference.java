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
  f lxI;
  private ImageView wqH;
  private ImageView wqI;
  private ImageView wqJ;
  List<String> wqK;
  
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
    this.wqK = null;
    setLayoutResource(2131495812);
    setWidgetLayoutResource(0);
    u.a(this);
    AppMethodBeat.o(28608);
  }
  
  public final void l(String paramString, final Bitmap paramBitmap)
  {
    AppMethodBeat.i(28611);
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(28611);
      return;
    }
    if ((this.wqH != null) && (this.wqH.getTag() != null) && (paramString.equals((String)this.wqH.getTag())))
    {
      this.wqH.post(new Runnable()
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
    if ((this.wqI != null) && (this.wqI.getTag() != null) && (paramString.equals((String)this.wqI.getTag())))
    {
      this.wqI.post(new Runnable()
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
    if ((this.wqJ != null) && (this.wqJ.getTag() != null) && (paramString.equals((String)this.wqJ.getTag()))) {
      this.wqJ.post(new Runnable()
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
    this.wqH = ((ImageView)paramView.findViewById(2131305794));
    this.wqI = ((ImageView)paramView.findViewById(2131305795));
    this.wqJ = ((ImageView)paramView.findViewById(2131305796));
    if (this.wqK != null)
    {
      if (this.wqK.size() <= 0)
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.wqK.get(0));
      this.wqH.setTag(paramView.aGA());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.wqH.setImageBitmap(paramView);
      }
      this.wqH.setVisibility(0);
      if (1 >= this.wqK.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.wqK.get(1));
      this.wqI.setTag(paramView.aGA());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.wqI.setImageBitmap(paramView);
      }
      this.wqI.setVisibility(0);
      if (2 >= this.wqK.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.wqK.get(2));
      this.wqJ.setTag(paramView.aGA());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.wqJ.setImageBitmap(paramView);
      }
      this.wqJ.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference
 * JD-Core Version:    0.7.0.1
 */