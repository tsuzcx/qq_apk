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
  f lZC;
  private ImageView xBY;
  private ImageView xBZ;
  private ImageView xCa;
  List<String> xCb;
  
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
    this.xCb = null;
    setLayoutResource(2131495812);
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
    if ((this.xBY != null) && (this.xBY.getTag() != null) && (paramString.equals((String)this.xBY.getTag())))
    {
      this.xBY.post(new Runnable()
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
    if ((this.xBZ != null) && (this.xBZ.getTag() != null) && (paramString.equals((String)this.xBZ.getTag())))
    {
      this.xBZ.post(new Runnable()
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
    if ((this.xCa != null) && (this.xCa.getTag() != null) && (paramString.equals((String)this.xCa.getTag()))) {
      this.xCa.post(new Runnable()
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
    this.xBY = ((ImageView)paramView.findViewById(2131305794));
    this.xBZ = ((ImageView)paramView.findViewById(2131305795));
    this.xCa = ((ImageView)paramView.findViewById(2131305796));
    if (this.xCb != null)
    {
      if (this.xCb.size() <= 0)
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.xCb.get(0));
      this.xBY.setTag(paramView.aNn());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.xBY.setImageBitmap(paramView);
      }
      this.xBY.setVisibility(0);
      if (1 >= this.xCb.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.xCb.get(1));
      this.xBZ.setTag(paramView.aNn());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.xBZ.setImageBitmap(paramView);
      }
      this.xBZ.setVisibility(0);
      if (2 >= this.xCb.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new b((String)this.xCb.get(2));
      this.xCa.setTag(paramView.aNn());
      paramView = u.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.xCa.setImageBitmap(paramView);
      }
      this.xCa.setVisibility(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference
 * JD-Core Version:    0.7.0.1
 */