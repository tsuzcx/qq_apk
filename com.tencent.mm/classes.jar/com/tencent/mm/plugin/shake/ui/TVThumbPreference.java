package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference
  extends Preference
  implements x.a
{
  f iLA;
  private ImageView qRR;
  private ImageView qRS;
  private ImageView qRT;
  List<String> qRU;
  
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
    AppMethodBeat.i(24939);
    this.qRU = null;
    setLayoutResource(2130971047);
    setWidgetLayoutResource(0);
    x.a(this);
    AppMethodBeat.o(24939);
  }
  
  public final void m(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(24942);
    if ((paramString == null) || (paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(24942);
      return;
    }
    if ((this.qRR != null) && (this.qRR.getTag() != null) && (paramString.equals((String)this.qRR.getTag())))
    {
      this.qRR.post(new TVThumbPreference.1(this, paramBitmap));
      AppMethodBeat.o(24942);
      return;
    }
    if ((this.qRS != null) && (this.qRS.getTag() != null) && (paramString.equals((String)this.qRS.getTag())))
    {
      this.qRS.post(new TVThumbPreference.2(this, paramBitmap));
      AppMethodBeat.o(24942);
      return;
    }
    if ((this.qRT != null) && (this.qRT.getTag() != null) && (paramString.equals((String)this.qRT.getTag()))) {
      this.qRT.post(new TVThumbPreference.3(this, paramBitmap));
    }
    AppMethodBeat.o(24942);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(24941);
    super.onBindView(paramView);
    this.qRR = ((ImageView)paramView.findViewById(2131828652));
    this.qRS = ((ImageView)paramView.findViewById(2131828653));
    this.qRT = ((ImageView)paramView.findViewById(2131828654));
    if (this.qRU != null)
    {
      if (this.qRU.size() <= 0)
      {
        AppMethodBeat.o(24941);
        return;
      }
      paramView = new b((String)this.qRU.get(0));
      this.qRR.setTag(paramView.aop());
      paramView = x.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.qRR.setImageBitmap(paramView);
      }
      this.qRR.setVisibility(0);
      if (1 >= this.qRU.size())
      {
        AppMethodBeat.o(24941);
        return;
      }
      paramView = new b((String)this.qRU.get(1));
      this.qRS.setTag(paramView.aop());
      paramView = x.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.qRS.setImageBitmap(paramView);
      }
      this.qRS.setVisibility(0);
      if (2 >= this.qRU.size())
      {
        AppMethodBeat.o(24941);
        return;
      }
      paramView = new b((String)this.qRU.get(2));
      this.qRT.setTag(paramView.aop());
      paramView = x.a(paramView);
      if ((paramView != null) && (!paramView.isRecycled())) {
        this.qRT.setImageBitmap(paramView);
      }
      this.qRT.setVisibility(0);
    }
    AppMethodBeat.o(24941);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24940);
    paramViewGroup = super.onCreateView(paramViewGroup);
    AppMethodBeat.o(24940);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.ui.TVThumbPreference
 * JD-Core Version:    0.7.0.1
 */