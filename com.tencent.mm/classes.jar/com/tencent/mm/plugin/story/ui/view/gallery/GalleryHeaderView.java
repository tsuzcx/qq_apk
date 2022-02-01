package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHeaderView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "setNickNameTv", "(Landroid/widget/TextView;)V", "setUserName", "", "user", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryHeaderView
  extends RelativeLayout
{
  private ImageView lKK;
  private TextView pRg;
  
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
    View.inflate(paramContext, a.e.SgH, (ViewGroup)this);
    this.lKK = ((ImageView)findViewById(a.d.avatar_iv));
    this.pRg = ((TextView)findViewById(a.d.nickname_tv));
    setPadding(0, 0, 0, bf.bk(paramContext));
    AppMethodBeat.o(120333);
  }
  
  public final ImageView getAvatarIv()
  {
    return this.lKK;
  }
  
  public final TextView getNickNameTv()
  {
    return this.pRg;
  }
  
  public final void setAvatarIv(ImageView paramImageView)
  {
    this.lKK = paramImageView;
  }
  
  public final void setNickNameTv(TextView paramTextView)
  {
    this.pRg = paramTextView;
  }
  
  public final void setUserName(String paramString)
  {
    AppMethodBeat.i(120332);
    if (paramString != null)
    {
      au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
      TextView localTextView = getNickNameTv();
      if (localTextView != null) {
        localTextView.setText((CharSequence)p.b(getContext(), (CharSequence)localau.aSV(), localTextView.getTextSize()));
      }
      a.b.a(getAvatarIv(), paramString, 0.5F, false);
    }
    AppMethodBeat.o(120332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHeaderView
 * JD-Core Version:    0.7.0.1
 */