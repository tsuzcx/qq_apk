package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.r.a;
import com.tencent.mm.plugin.shake.d.c;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference
  extends Preference
  implements r.a
{
  private ImageView PEJ;
  private ImageView PEK;
  private ImageView PEL;
  List<String> PEM;
  f pkD;
  
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
    this.PEM = null;
    setLayoutResource(R.i.goI);
    aBp(0);
    r.a(this);
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
    if ((this.PEJ != null) && (this.PEJ.getTag() != null) && (paramString.equals((String)this.PEJ.getTag())))
    {
      this.PEJ.post(new Runnable()
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
    if ((this.PEK != null) && (this.PEK.getTag() != null) && (paramString.equals((String)this.PEK.getTag())))
    {
      this.PEK.post(new Runnable()
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
    if ((this.PEL != null) && (this.PEL.getTag() != null) && (paramString.equals((String)this.PEL.getTag()))) {
      this.PEL.post(new Runnable()
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
    this.PEJ = ((ImageView)paramView.findViewById(R.h.fZA));
    this.PEK = ((ImageView)paramView.findViewById(R.h.fZB));
    this.PEL = ((ImageView)paramView.findViewById(R.h.fZC));
    if (this.PEM != null)
    {
      if (this.PEM.size() <= 0)
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new c((String)this.PEM.get(0));
      this.PEJ.setTag(paramView.bTE());
      paramView = r.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.PEJ.setImageBitmap(paramView);
      }
      this.PEJ.setVisibility(0);
      if (1 >= this.PEM.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new c((String)this.PEM.get(1));
      this.PEK.setTag(paramView.bTE());
      paramView = r.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.PEK.setImageBitmap(paramView);
      }
      this.PEK.setVisibility(0);
      if (2 >= this.PEM.size())
      {
        AppMethodBeat.o(28610);
        return;
      }
      paramView = new c((String)this.PEM.get(2));
      this.PEL.setTag(paramView.bTE());
      paramView = r.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.PEL.setImageBitmap(paramView);
      }
      this.PEL.setVisibility(0);
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