package com.tencent.mm.plugin.recordvideo.a;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig.ConfigHelper;
import com.tencent.mm.accessibility.base.ViewSetter;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.h;
import kotlin.Metadata;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/accessibility/RecordAccessibility;", "Lcom/tencent/mm/accessibility/base/MMBaseAccessibilityConfig;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initConfig", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MMBaseAccessibilityConfig
{
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279333);
    AppMethodBeat.o(279333);
  }
  
  public final void initConfig()
  {
    AppMethodBeat.i(279343);
    MMBaseAccessibilityConfig.ConfigHelper localConfigHelper = root(b.f.story_audio_panel);
    localConfigHelper.view(b.e.story_esitor_search_btn).desc(b.h.aging_audio_panel_search);
    localConfigHelper.view(b.e.story_editor_audio_mute_music).desc((kotlin.g.a.b)new a(this));
    localConfigHelper.view(b.e.story_editor_audio_mute_origin).desc((kotlin.g.a.b)new b(this));
    localConfigHelper.view(b.e.story_editor_audio_lyrics).desc((kotlin.g.a.b)new c(this));
    root(b.e.story_editor_audio_search_edit).view(b.e.story_editor_audio_search_edit).desc(b.h.finder_audio_search_edit_desc);
    root(b.f.video_edit_plugin_layout_new).view(b.e.editor_crop_bar).desc(b.h.aging_click_crop_video_bar);
    root(b.e.editor_control_icons_layout).view(b.e.editor_add_audio_group).desc((kotlin.g.a.b)new d(this)).disableChildren();
    localConfigHelper = root(b.e.change_text_root);
    localConfigHelper.disable(b.e.story_editor_input_color);
    localConfigHelper.disable(b.e.editor_input_font);
    AppMethodBeat.o(279343);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<View, String>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<View, String>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<View, String>
  {
    c(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<View, String>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.a.b
 * JD-Core Version:    0.7.0.1
 */