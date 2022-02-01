package com.tencent.mm.plugin.story.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "dp_2", "nameTv", "Landroid/widget/TextView;", "unreadTip", "setAvatar", "", "username", "", "setTipCount", "count", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryAvatarItemView
  extends RelativeLayout
{
  private final int Sxx;
  private TextView Sxy;
  private TextView lDF;
  private ImageView lKK;
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120084);
    this.Sxx = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), a.e.Sgr, (ViewGroup)this);
    paramContext = findViewById(a.d.Sec);
    s.s(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.lKK = ((ImageView)paramContext);
    paramContext = findViewById(a.d.Sed);
    s.s(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(a.d.See);
    s.s(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.Sxy = ((TextView)paramContext);
    AppMethodBeat.o(120084);
  }
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120085);
    this.Sxx = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), a.e.Sgr, (ViewGroup)this);
    paramContext = findViewById(a.d.Sec);
    s.s(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.lKK = ((ImageView)paramContext);
    paramContext = findViewById(a.d.Sed);
    s.s(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(a.d.See);
    s.s(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.Sxy = ((TextView)paramContext);
    AppMethodBeat.o(120085);
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(120082);
    s.u(paramString, "username");
    a.b.a(this.lKK, paramString, 0.5F, false);
    this.lKK.setBackground(getResources().getDrawable(a.c.ScY));
    this.lKK.setPadding(this.Sxx, this.Sxx, this.Sxx, this.Sxx);
    paramString = ((n)h.ax(n.class)).bzA().JE(paramString);
    Context localContext = getContext();
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      paramString = p.b(localContext, (CharSequence)paramString, this.lDF.getTextSize());
      this.lDF.setText((CharSequence)paramString);
      AppMethodBeat.o(120082);
      return;
      String str = paramString.aSV();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
  }
  
  public final void setTipCount(int paramInt)
  {
    AppMethodBeat.i(120083);
    if (paramInt <= 0)
    {
      this.Sxy.setVisibility(8);
      AppMethodBeat.o(120083);
      return;
    }
    this.Sxy.setText((CharSequence)String.valueOf(paramInt));
    this.Sxy.setVisibility(0);
    AppMethodBeat.o(120083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView
 * JD-Core Version:    0.7.0.1
 */