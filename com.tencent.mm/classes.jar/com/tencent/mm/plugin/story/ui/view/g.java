package com.tencent.mm.plugin.story.ui.view;

import a.f.b.j;
import a.l;
import a.y;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/UserGuideView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "clickListener", "Lkotlin/Function0;", "", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "plugin-story_release"})
public final class g
  extends RelativeLayout
{
  private a.f.a.a<y> sNy;
  
  public g(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(110471);
    View.inflate(paramContext, 2130970973, (ViewGroup)this);
    setBackgroundColor(-13421773);
    Object localObject = findViewById(2131828456);
    j.p(localObject, "findViewById(R.id.story_user_guide_content_2)");
    localObject = (TextView)localObject;
    String str = paramContext.getString(2131304198);
    SpannableString localSpannableString = new SpannableString((CharSequence)str);
    Drawable localDrawable = getResources().getDrawable(2131231103);
    int i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 10);
    localDrawable.setBounds(0, 0, i, i);
    localSpannableString.setSpan(new com.tencent.mm.ui.widget.a(localDrawable), str.length() - 3, str.length() - 2, 17);
    ((TextView)localObject).setText((CharSequence)localSpannableString);
    setOnClickListener((View.OnClickListener)g.1.sNz);
    findViewById(2131828457).setOnClickListener((View.OnClickListener)new g.2(this));
    AppMethodBeat.o(110471);
  }
  
  public final a.f.a.a<y> getClickListener()
  {
    return this.sNy;
  }
  
  public final void setClickListener(a.f.a.a<y> parama)
  {
    this.sNy = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.g
 * JD-Core Version:    0.7.0.1
 */