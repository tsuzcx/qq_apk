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
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "dp_2", "nameTv", "Landroid/widget/TextView;", "unreadTip", "setAvatar", "", "username", "", "setTipCount", "count", "plugin-story_release"})
public final class StoryAvatarItemView
  extends RelativeLayout
{
  private final int FBA;
  private TextView FBB;
  private TextView gxs;
  private ImageView gyr;
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120084);
    this.FBA = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), 2131496565, (ViewGroup)this);
    paramContext = findViewById(2131308469);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.gyr = ((ImageView)paramContext);
    paramContext = findViewById(2131308470);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.gxs = ((TextView)paramContext);
    paramContext = findViewById(2131308471);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.FBB = ((TextView)paramContext);
    AppMethodBeat.o(120084);
  }
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120085);
    this.FBA = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), 2131496565, (ViewGroup)this);
    paramContext = findViewById(2131308469);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.gyr = ((ImageView)paramContext);
    paramContext = findViewById(2131308470);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.gxs = ((TextView)paramContext);
    paramContext = findViewById(2131308471);
    p.g(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.FBB = ((TextView)paramContext);
    AppMethodBeat.o(120085);
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(120082);
    p.h(paramString, "username");
    a.b.d(this.gyr, paramString, 0.5F);
    this.gyr.setBackground(getResources().getDrawable(2131235100));
    this.gyr.setPadding(this.FBA, this.FBA, this.FBA, this.FBA);
    Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(paramString);
    localObject = getContext();
    if (paramString != null)
    {
      paramString = paramString.arJ();
      if (paramString == null) {}
    }
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      paramString = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject, paramString, this.gxs.getTextSize());
      this.gxs.setText((CharSequence)paramString);
      AppMethodBeat.o(120082);
      return;
    }
  }
  
  public final void setTipCount(int paramInt)
  {
    AppMethodBeat.i(120083);
    if (paramInt <= 0)
    {
      this.FBB.setVisibility(8);
      AppMethodBeat.o(120083);
      return;
    }
    this.FBB.setText((CharSequence)String.valueOf(paramInt));
    this.FBB.setVisibility(0);
    AppMethodBeat.o(120083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView
 * JD-Core Version:    0.7.0.1
 */