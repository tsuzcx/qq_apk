package com.tencent.mm.plugin.recordvideo.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.h;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/accessibility/FinderRecordAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MMBaseAccessibilityConfig
{
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279339);
    AppMethodBeat.o(279339);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(279352);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(b.e.finder_record_layout);
    localConfigHelper.view(b.e.close_btn_accessibility_anchor).desc(b.e.close_plugin).clickAs(b.e.close_plugin).disableChildren();
    localConfigHelper.view(b.e.close_plugin).disable();
    localConfigHelper.view(b.e.right_icon_parent).desc((b)a.a.NDc).disableChildren();
    localConfigHelper.view(b.e.delete_sub_video_container).desc(b.h.finder_delete_sub_video_desc).disableChildren();
    localConfigHelper.view(b.e.record_button).desc((b)new b(this));
    localConfigHelper = root(b.e.story_audio_panel);
    localConfigHelper.view(b.e.story_editor_audio_mute_music).desc((b)new c(this));
    localConfigHelper.view(b.e.story_editor_audio_mute_origin).desc((b)new d(this));
    localConfigHelper.view(b.e.story_editor_audio_lyrics).desc((b)new e(this));
    localConfigHelper.view(b.e.story_item_audio_container).desc(b.h.finder_audio);
    root(b.e.story_editor_audio_search_root).view(b.e.story_item_audio_search_result_container).desc((b)new f(this));
    AppMethodBeat.o(279352);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<View, String>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<View, String>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<View, String>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<View, String>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<View, String>
  {
    f(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.a
 * JD-Core Version:    0.7.0.1
 */