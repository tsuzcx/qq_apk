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
import com.tencent.mm.cc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "dp_2", "nameTv", "Landroid/widget/TextView;", "unreadTip", "setAvatar", "", "username", "", "setTipCount", "count", "plugin-story_release"})
public final class StoryAvatarItemView
  extends RelativeLayout
{
  private final int AZp;
  private TextView AZq;
  private TextView fQd;
  private ImageView fRd;
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120084);
    this.AZp = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), 2131495660, (ViewGroup)this);
    paramContext = findViewById(2131305264);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.fRd = ((ImageView)paramContext);
    paramContext = findViewById(2131305265);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.fQd = ((TextView)paramContext);
    paramContext = findViewById(2131305266);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.AZq = ((TextView)paramContext);
    AppMethodBeat.o(120084);
  }
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120085);
    this.AZp = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), 2131495660, (ViewGroup)this);
    paramContext = findViewById(2131305264);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.fRd = ((ImageView)paramContext);
    paramContext = findViewById(2131305265);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.fQd = ((TextView)paramContext);
    paramContext = findViewById(2131305266);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.AZq = ((TextView)paramContext);
    AppMethodBeat.o(120085);
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(120082);
    p.h(paramString, "username");
    a.b.d(this.fRd, paramString, 0.5F);
    this.fRd.setBackground(getResources().getDrawable(2131234224));
    this.fRd.setPadding(this.AZp, this.AZp, this.AZp, this.AZp);
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).azp().Bf(paramString);
    localObject = getContext();
    if (paramString != null)
    {
      paramString = paramString.adv();
      if (paramString == null) {}
    }
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      paramString = k.b((Context)localObject, paramString, this.fQd.getTextSize());
      this.fQd.setText((CharSequence)paramString);
      AppMethodBeat.o(120082);
      return;
    }
  }
  
  public final void setTipCount(int paramInt)
  {
    AppMethodBeat.i(120083);
    if (paramInt <= 0)
    {
      this.AZq.setVisibility(8);
      AppMethodBeat.o(120083);
      return;
    }
    this.AZq.setText((CharSequence)String.valueOf(paramInt));
    this.AZq.setVisibility(0);
    AppMethodBeat.o(120083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView
 * JD-Core Version:    0.7.0.1
 */