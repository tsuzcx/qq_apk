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
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "dp_2", "nameTv", "Landroid/widget/TextView;", "unreadTip", "setAvatar", "", "username", "", "setTipCount", "count", "plugin-story_release"})
public final class StoryAvatarItemView
  extends RelativeLayout
{
  private TextView fwQ;
  private ImageView fxQ;
  private final int zHO;
  private TextView zHP;
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120084);
    this.zHO = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), 2131495660, (ViewGroup)this);
    paramContext = findViewById(2131305264);
    d.g.b.k.g(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.fxQ = ((ImageView)paramContext);
    paramContext = findViewById(2131305265);
    d.g.b.k.g(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.fwQ = ((TextView)paramContext);
    paramContext = findViewById(2131305266);
    d.g.b.k.g(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.zHP = ((TextView)paramContext);
    AppMethodBeat.o(120084);
  }
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120085);
    this.zHO = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), 2131495660, (ViewGroup)this);
    paramContext = findViewById(2131305264);
    d.g.b.k.g(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.fxQ = ((ImageView)paramContext);
    paramContext = findViewById(2131305265);
    d.g.b.k.g(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.fwQ = ((TextView)paramContext);
    paramContext = findViewById(2131305266);
    d.g.b.k.g(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.zHP = ((TextView)paramContext);
    AppMethodBeat.o(120085);
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(120082);
    d.g.b.k.h(paramString, "username");
    a.b.d(this.fxQ, paramString, 0.5F);
    this.fxQ.setBackground(getResources().getDrawable(2131234224));
    this.fxQ.setPadding(this.zHO, this.zHO, this.zHO, this.zHO);
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramString);
    localObject = getContext();
    if (paramString != null)
    {
      paramString = paramString.aaS();
      if (paramString == null) {}
    }
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      paramString = com.tencent.mm.pluginsdk.ui.span.k.b((Context)localObject, paramString, this.fwQ.getTextSize());
      this.fwQ.setText((CharSequence)paramString);
      AppMethodBeat.o(120082);
      return;
    }
  }
  
  public final void setTipCount(int paramInt)
  {
    AppMethodBeat.i(120083);
    if (paramInt <= 0)
    {
      this.zHP.setVisibility(8);
      AppMethodBeat.o(120083);
      return;
    }
    this.zHP.setText((CharSequence)String.valueOf(paramInt));
    this.zHP.setVisibility(0);
    AppMethodBeat.o(120083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView
 * JD-Core Version:    0.7.0.1
 */