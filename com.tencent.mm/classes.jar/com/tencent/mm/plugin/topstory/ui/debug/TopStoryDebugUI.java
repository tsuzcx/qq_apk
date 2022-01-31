package com.tencent.mm.plugin.topstory.ui.debug;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.ui.MMActivity;

public class TopStoryDebugUI
  extends MMActivity
{
  private TextView pDN;
  
  protected final int getLayoutId()
  {
    return b.e.top_story_debug_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(b.g.top_story_debug_title);
    setBackBtn(new TopStoryDebugUI.1(this));
    paramBundle = aa.Bn(1);
    this.pDN = ((TextView)findViewById(b.d.version_tv));
    this.pDN.setText(getString(b.g.top_story_debug_h5_verison, new Object[] { String.valueOf(paramBundle.NA()) }));
    findViewById(b.d.compare_js_btn).setOnClickListener(new TopStoryDebugUI.2(this, paramBundle));
    findViewById(b.d.clear_template_btn).setOnClickListener(new TopStoryDebugUI.3(this, paramBundle));
    findViewById(b.d.print_btn).setOnClickListener(new TopStoryDebugUI.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.debug.TopStoryDebugUI
 * JD-Core Version:    0.7.0.1
 */