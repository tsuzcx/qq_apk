package com.tencent.mm.plugin.sns.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/accessibility/SnsCommentDetailUIAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(306258);
    AppMethodBeat.o(306258);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(306268);
    root(b.g.sns_comment_footer).view(b.f.album_comment_green_send_btn).talkOn(b.j.sns_send_over, (b)a.PKR);
    AppMethodBeat.o(306268);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<View, Boolean>
  {
    public static final a PKR;
    
    static
    {
      AppMethodBeat.i(306267);
      PKR = new a();
      AppMethodBeat.o(306267);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.a.a
 * JD-Core Version:    0.7.0.1
 */