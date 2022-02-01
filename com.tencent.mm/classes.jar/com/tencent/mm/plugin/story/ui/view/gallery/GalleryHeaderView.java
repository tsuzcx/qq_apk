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
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "setNickNameTv", "(Landroid/widget/TextView;)V", "setUserName", "", "user", "", "plugin-story_release"})
public final class GalleryHeaderView
  extends RelativeLayout
{
  private ImageView gyr;
  private TextView kcZ;
  
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
    View.inflate(paramContext, 2131496597, (ViewGroup)this);
    this.gyr = ((ImageView)findViewById(2131297134));
    this.kcZ = ((TextView)findViewById(2131305440));
    setPadding(0, 0, 0, au.aD(paramContext));
    AppMethodBeat.o(120333);
  }
  
  public final ImageView getAvatarIv()
  {
    return this.gyr;
  }
  
  public final TextView getNickNameTv()
  {
    return this.kcZ;
  }
  
  public final void setAvatarIv(ImageView paramImageView)
  {
    this.gyr = paramImageView;
  }
  
  public final void setNickNameTv(TextView paramTextView)
  {
    this.kcZ = paramTextView;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(120332);
    if (paramString != null)
    {
      Object localObject = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
      p.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)localObject).aSN().Kn(paramString);
      TextView localTextView = this.kcZ;
      if (localTextView != null)
      {
        Context localContext = getContext();
        p.g(localObject, "contact");
        localTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)((as)localObject).arJ(), localTextView.getTextSize()));
      }
      a.b.d(this.gyr, paramString, 0.5F);
    }
    AppMethodBeat.o(120332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHeaderView
 * JD-Core Version:    0.7.0.1
 */