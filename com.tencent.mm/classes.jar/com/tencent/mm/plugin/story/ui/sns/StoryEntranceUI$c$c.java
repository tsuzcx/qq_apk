package com.tencent.mm.plugin.story.ui.sns;

import a.l;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewUserHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter$EntranceViewHolder;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$EntranceAdapter;Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "contentTv", "Landroid/widget/TextView;", "getContentTv", "()Landroid/widget/TextView;", "onBind", "", "position", "", "data", "Lcom/tencent/mm/plugin/story/ui/sns/StoryEntranceUI$DataObject;", "plugin-story_release"})
public final class StoryEntranceUI$c$c
  extends StoryEntranceUI.c.a
{
  private final TextView gMp;
  private final ImageView gxs;
  
  public StoryEntranceUI$c$c(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(110252);
    paramView = localObject.findViewById(2131821210);
    a.f.b.j.p(paramView, "itemView.findViewById(R.id.avatar_iv)");
    this.gxs = ((ImageView)paramView);
    paramView = localObject.findViewById(2131826331);
    a.f.b.j.p(paramView, "itemView.findViewById(R.id.user_name_tv)");
    this.gMp = ((TextView)paramView);
    localObject.setOnClickListener((View.OnClickListener)new StoryEntranceUI.c.c.1(this));
    AppMethodBeat.o(110252);
  }
  
  public final void a(StoryEntranceUI.b paramb)
  {
    AppMethodBeat.i(110251);
    a.f.b.j.q(paramb, "data");
    a.b.c(this.gxs, paramb.userName);
    Object localObject = g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class);
    a.f.b.j.p(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)localObject).YA().arw(paramb.userName);
    if (localObject != null)
    {
      String str = ((ad)localObject).Of();
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = paramb.userName;
    }
    localObject = com.tencent.mm.pluginsdk.ui.d.j.b(this.gMp.getContext(), (CharSequence)localObject, this.gMp.getTextSize());
    if (StoryEntranceUI.a(this.sKA.sKz).contains(paramb.userName)) {
      this.gMp.setTextColor(this.sKA.sKz.getContext().getResources().getColor(2131689483));
    }
    for (;;)
    {
      this.gMp.setText((CharSequence)localObject);
      AppMethodBeat.o(110251);
      return;
      this.gMp.setTextColor(this.sKA.sKz.getContext().getResources().getColor(2131689763));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.sns.StoryEntranceUI.c.c
 * JD-Core Version:    0.7.0.1
 */