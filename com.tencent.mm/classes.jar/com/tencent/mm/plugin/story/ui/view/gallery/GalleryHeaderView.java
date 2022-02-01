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
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.ap;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "setNickNameTv", "(Landroid/widget/TextView;)V", "setUserName", "", "user", "", "plugin-story_release"})
public final class GalleryHeaderView
  extends RelativeLayout
{
  private ImageView fuj;
  private TextView iiN;
  
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
    this.fuj = ((ImageView)findViewById(2131297008));
    this.iiN = ((TextView)findViewById(2131302867));
    setPadding(0, 0, 0, ap.eb(paramContext));
    AppMethodBeat.o(120333);
  }
  
  public final ImageView getAvatarIv()
  {
    return this.fuj;
  }
  
  public final TextView getNickNameTv()
  {
    return this.iiN;
  }
  
  public final void setAvatarIv(ImageView paramImageView)
  {
    this.fuj = paramImageView;
  }
  
  public final void setNickNameTv(TextView paramTextView)
  {
    this.iiN = paramTextView;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(120332);
    if (paramString != null)
    {
      Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
      d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(paramString);
      TextView localTextView = this.iiN;
      if (localTextView != null)
      {
        Context localContext = getContext();
        d.g.b.k.g(localObject, "contact");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)((af)localObject).ZX(), localTextView.getTextSize()));
      }
      a.b.d(this.fuj, paramString, 0.5F);
    }
    AppMethodBeat.o(120332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHeaderView
 * JD-Core Version:    0.7.0.1
 */