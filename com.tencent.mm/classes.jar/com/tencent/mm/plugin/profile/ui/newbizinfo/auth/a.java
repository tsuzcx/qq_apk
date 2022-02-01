package com.tencent.mm.plugin.profile.ui.newbizinfo.auth;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelavatar.d;
import com.tencent.mm.plugin.brandservice.ui.b.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthHeaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "avatarIv", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getAvatarIv", "()Landroid/widget/ImageView;", "avatarIv$delegate", "Lkotlin/Lazy;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "descTv$delegate", "mainUI", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "getMainUI", "()Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;", "mainUI$delegate", "nicknameTv", "getNicknameTv", "nicknameTv$delegate", "initHeaderView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  public static final a.a Nce;
  private final j DkO;
  private final j FdQ;
  private final j FdY;
  private final j Ncf;
  
  static
  {
    AppMethodBeat.i(305784);
    Nce = new a.a((byte)0);
    AppMethodBeat.o(305784);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(305777);
    this.FdQ = k.cm((kotlin.g.a.a)new b(paramAppCompatActivity));
    this.DkO = k.cm((kotlin.g.a.a)new e(paramAppCompatActivity));
    this.FdY = k.cm((kotlin.g.a.a)new c(paramAppCompatActivity));
    this.Ncf = k.cm((kotlin.g.a.a)new d(paramAppCompatActivity));
    AppMethodBeat.o(305777);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(305792);
    super.onCreate(paramBundle);
    String str = getIntent().getStringExtra("Contact_Nick");
    paramBundle = ((NewBizInfoAuthMainUI)this.Ncf.getValue()).username;
    if (paramBundle != null) {}
    for (;;)
    {
      paramBundle = d.a(paramBundle, false, -1, null);
      if (paramBundle != null)
      {
        paramBundle = BitmapUtil.getRoundedCornerBitmap(paramBundle, false, 0.5F * paramBundle.getWidth());
        ((ImageView)this.FdQ.getValue()).setImageBitmap(paramBundle);
      }
      paramBundle = e.vYK;
      e.l((TextView)this.FdY.getValue());
      ((TextView)this.DkO.getValue()).setText((CharSequence)str);
      AppMethodBeat.o(305792);
      return;
      s.bIx("username");
      paramBundle = null;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    b(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<TextView>
  {
    c(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/profile/ui/newbizinfo/auth/NewBizInfoAuthMainUI;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<NewBizInfoAuthMainUI>
  {
    d(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.newbizinfo.auth.a
 * JD-Core Version:    0.7.0.1
 */