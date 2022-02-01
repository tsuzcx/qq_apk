package com.tencent.mm.plugin.ringtone.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.ringtone.b.a;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/widget/RingtonePlayIcon;", "", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mContext", "Landroid/content/Context;", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;Landroid/content/Context;)V", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "responseEnable", "", "enable", "", "responsePlaying", "responseStop", "setOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setVisibility", "visibility", "", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private WeImageView Bqk;
  private Context mContext;
  
  public d(WeImageView paramWeImageView, Context paramContext)
  {
    AppMethodBeat.i(273100);
    this.Bqk = paramWeImageView;
    this.mContext = paramContext;
    paramWeImageView = this.Bqk;
    paramContext = this.mContext;
    int k = b.e.icons_filled_specialplay;
    Object localObject = this.mContext;
    int i;
    if (localObject == null)
    {
      i = -16777216;
      paramWeImageView.setImageDrawable(bb.m(paramContext, k, i));
      paramWeImageView = this.Bqk;
      paramContext = this.mContext;
      if (paramContext != null) {
        break label127;
      }
      i = j;
    }
    for (;;)
    {
      paramWeImageView.setIconColor(i);
      AppMethodBeat.o(273100);
      return;
      localObject = ((Context)localObject).getResources();
      if (localObject == null)
      {
        i = -16777216;
        break;
      }
      i = ((Resources)localObject).getColor(b.a.FG_0);
      break;
      label127:
      paramContext = paramContext.getResources();
      i = j;
      if (paramContext != null) {
        i = paramContext.getColor(b.a.FG_0);
      }
    }
  }
  
  public final void BU(boolean paramBoolean)
  {
    AppMethodBeat.i(273125);
    WeImageView localWeImageView = this.Bqk;
    Context localContext = this.mContext;
    if (paramBoolean) {}
    for (int i = b.a.FG_0;; i = b.a.FG_4)
    {
      localWeImageView.setIconColor(a.w(localContext, i));
      AppMethodBeat.o(273125);
      return;
    }
  }
  
  public final void gPh()
  {
    int j = -16777216;
    AppMethodBeat.i(273108);
    WeImageView localWeImageView = this.Bqk;
    Object localObject1 = this.mContext;
    int k = b.e.icons_filled_pause;
    Object localObject2 = this.mContext;
    int i;
    if (localObject2 == null)
    {
      i = -16777216;
      localWeImageView.setImageDrawable(bb.m((Context)localObject1, k, i));
      localWeImageView = this.Bqk;
      localObject1 = this.mContext;
      if (localObject1 != null) {
        break label111;
      }
      i = j;
    }
    for (;;)
    {
      localWeImageView.setIconColor(i);
      AppMethodBeat.o(273108);
      return;
      localObject2 = ((Context)localObject2).getResources();
      if (localObject2 == null)
      {
        i = -16777216;
        break;
      }
      i = ((Resources)localObject2).getColor(b.a.FG_0);
      break;
      label111:
      localObject1 = ((Context)localObject1).getResources();
      i = j;
      if (localObject1 != null) {
        i = ((Resources)localObject1).getColor(b.a.FG_0);
      }
    }
  }
  
  public final void gPi()
  {
    int j = -16777216;
    AppMethodBeat.i(273114);
    WeImageView localWeImageView = this.Bqk;
    Object localObject1 = this.mContext;
    int k = b.e.icons_filled_specialplay;
    Object localObject2 = this.mContext;
    int i;
    if (localObject2 == null)
    {
      i = -16777216;
      localWeImageView.setImageDrawable(bb.m((Context)localObject1, k, i));
      localWeImageView = this.Bqk;
      localObject1 = this.mContext;
      if (localObject1 != null) {
        break label111;
      }
      i = j;
    }
    for (;;)
    {
      localWeImageView.setIconColor(i);
      AppMethodBeat.o(273114);
      return;
      localObject2 = ((Context)localObject2).getResources();
      if (localObject2 == null)
      {
        i = -16777216;
        break;
      }
      i = ((Resources)localObject2).getColor(b.a.FG_0);
      break;
      label111:
      localObject1 = ((Context)localObject1).getResources();
      i = j;
      if (localObject1 != null) {
        i = ((Resources)localObject1).getColor(b.a.FG_0);
      }
    }
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(273132);
    s.u(paramOnClickListener, "listener");
    this.Bqk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(273132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.widget.d
 * JD-Core Version:    0.7.0.1
 */