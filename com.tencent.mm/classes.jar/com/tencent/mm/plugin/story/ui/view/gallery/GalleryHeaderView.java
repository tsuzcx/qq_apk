package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.ap;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "setNickNameTv", "(Landroid/widget/TextView;)V", "setUserName", "", "user", "", "plugin-story_release"})
public final class GalleryHeaderView
  extends RelativeLayout
{
  private ImageView fxQ;
  private TextView iIU;
  
  public GalleryHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120334);
    AppMethodBeat.o(120334);
  }
  
  public GalleryHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120333);
    View.inflate(paramContext, 2131495692, (ViewGroup)this);
    this.fxQ = ((ImageView)findViewById(2131297008));
    this.iIU = ((TextView)findViewById(2131302867));
    setPadding(0, 0, 0, ap.ej(paramContext));
    AppMethodBeat.o(120333);
  }
  
  public final ImageView getAvatarIv()
  {
    return this.fxQ;
  }
  
  public final TextView getNickNameTv()
  {
    return this.iIU;
  }
  
  public final void setAvatarIv(ImageView paramImageView)
  {
    this.fxQ = paramImageView;
  }
  
  public final void setNickNameTv(TextView paramTextView)
  {
    this.iIU = paramTextView;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(120332);
    if (paramString != null)
    {
      Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(paramString);
      TextView localTextView = this.iIU;
      if (localTextView != null)
      {
        Context localContext = getContext();
        d.g.b.k.g(localObject, "contact");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)((ai)localObject).aaS(), localTextView.getTextSize()));
      }
      a.b.d(this.fxQ, paramString, 0.5F);
    }
    AppMethodBeat.o(120332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHeaderView
 * JD-Core Version:    0.7.0.1
 */