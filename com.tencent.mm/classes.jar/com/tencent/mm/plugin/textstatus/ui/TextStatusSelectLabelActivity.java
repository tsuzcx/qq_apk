package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "rgVisibleGroup", "Landroid/widget/RadioGroup;", "getRgVisibleGroup", "()Landroid/widget/RadioGroup;", "setRgVisibleGroup", "(Landroid/widget/RadioGroup;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSelectLabelActivity
  extends MMActivity
{
  public static final a GfL;
  private RadioGroup GfK;
  
  static
  {
    AppMethodBeat.i(216662);
    GfL = new a((byte)0);
    AppMethodBeat.o(216662);
  }
  
  public final int getLayoutId()
  {
    return 2131496700;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216661);
    super.onCreate(paramBundle);
    setMMTitle(2131766750);
    this.GfK = ((RadioGroup)findViewById(2131307072));
    paramBundle = this.GfK;
    if (paramBundle != null)
    {
      paramBundle.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)new b(this));
      AppMethodBeat.o(216661);
      return;
    }
    AppMethodBeat.o(216661);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity$Companion;", "", "()V", "startForResult", "", "context", "Landroid/app/Activity;", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"})
  static final class b
    implements RadioGroup.OnCheckedChangeListener
  {
    b(TextStatusSelectLabelActivity paramTextStatusSelectLabelActivity) {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      AppMethodBeat.i(216660);
      paramRadioGroup = new Intent();
      paramRadioGroup.putExtra("SELECT_VISIBILITY", paramInt);
      this.GfM.setResult(-1, paramRadioGroup);
      this.GfM.finish();
      AppMethodBeat.o(216660);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSelectLabelActivity
 * JD-Core Version:    0.7.0.1
 */