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
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/StoryAvatarItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "dp_2", "nameTv", "Landroid/widget/TextView;", "unreadTip", "setAvatar", "", "username", "", "setTipCount", "count", "plugin-story_release"})
public final class StoryAvatarItemView
  extends RelativeLayout
{
  private final int LVE;
  private TextView LVF;
  private TextView jbF;
  private ImageView jiu;
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(120084);
    this.LVE = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), a.e.LCG, (ViewGroup)this);
    paramContext = findViewById(a.d.LAp);
    p.j(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.jiu = ((ImageView)paramContext);
    paramContext = findViewById(a.d.LAq);
    p.j(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.jbF = ((TextView)paramContext);
    paramContext = findViewById(a.d.LAr);
    p.j(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.LVF = ((TextView)paramContext);
    AppMethodBeat.o(120084);
  }
  
  public StoryAvatarItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120085);
    this.LVE = a.fromDPToPix(getContext(), 2);
    View.inflate(getContext(), a.e.LCG, (ViewGroup)this);
    paramContext = findViewById(a.d.LAp);
    p.j(paramContext, "findViewById(R.id.story_avatar_item_iv)");
    this.jiu = ((ImageView)paramContext);
    paramContext = findViewById(a.d.LAq);
    p.j(paramContext, "findViewById(R.id.story_avatar_item_name_tv)");
    this.jbF = ((TextView)paramContext);
    paramContext = findViewById(a.d.LAr);
    p.j(paramContext, "findViewById(R.id.story_avatar_item_unread_tip)");
    this.LVF = ((TextView)paramContext);
    AppMethodBeat.o(120085);
  }
  
  public final void setAvatar(String paramString)
  {
    AppMethodBeat.i(120082);
    p.k(paramString, "username");
    a.b.d(this.jiu, paramString, 0.5F);
    this.jiu.setBackground(getResources().getDrawable(a.c.Lzl));
    this.jiu.setPadding(this.LVE, this.LVE, this.LVE, this.LVE);
    Object localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    paramString = ((n)localObject).bbL().RG(paramString);
    localObject = getContext();
    if (paramString != null)
    {
      paramString = paramString.ays();
      if (paramString == null) {}
    }
    for (paramString = (CharSequence)paramString;; paramString = (CharSequence)"")
    {
      paramString = com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject, paramString, this.jbF.getTextSize());
      this.jbF.setText((CharSequence)paramString);
      AppMethodBeat.o(120082);
      return;
    }
  }
  
  public final void setTipCount(int paramInt)
  {
    AppMethodBeat.i(120083);
    if (paramInt <= 0)
    {
      this.LVF.setVisibility(8);
      AppMethodBeat.o(120083);
      return;
    }
    this.LVF.setText((CharSequence)String.valueOf(paramInt));
    this.LVF.setVisibility(0);
    AppMethodBeat.o(120083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.StoryAvatarItemView
 * JD-Core Version:    0.7.0.1
 */