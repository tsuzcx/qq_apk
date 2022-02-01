package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.ui.MMActivity;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "rgVisibleGroup", "Landroid/widget/RadioGroup;", "getRgVisibleGroup", "()Landroid/widget/RadioGroup;", "setRgVisibleGroup", "(Landroid/widget/RadioGroup;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"})
public final class TextStatusSelectLabelActivity
  extends MMActivity
{
  public static final a MOf;
  private RadioGroup MOe;
  
  static
  {
    AppMethodBeat.i(234511);
    MOf = new a((byte)0);
    AppMethodBeat.o(234511);
  }
  
  public final int getLayoutId()
  {
    return b.f.Myf;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(234510);
    super.onCreate(paramBundle);
    setMMTitle(b.h.Mzj);
    this.MOe = ((RadioGroup)findViewById(b.e.Mwz));
    paramBundle = this.MOe;
    if (paramBundle != null)
    {
      paramBundle.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)new b(this));
      AppMethodBeat.o(234510);
      return;
    }
    AppMethodBeat.o(234510);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity$Companion;", "", "()V", "startForResult", "", "context", "Landroid/app/Activity;", "plugin-textstatus_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "group", "Landroid/widget/RadioGroup;", "kotlin.jvm.PlatformType", "checkedId", "", "onCheckedChanged"})
  static final class b
    implements RadioGroup.OnCheckedChangeListener
  {
    b(TextStatusSelectLabelActivity paramTextStatusSelectLabelActivity) {}
    
    public final void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
    {
      AppMethodBeat.i(235262);
      paramRadioGroup = new Intent();
      paramRadioGroup.putExtra("SELECT_VISIBILITY", paramInt);
      this.MOg.setResult(-1, paramRadioGroup);
      this.MOg.finish();
      AppMethodBeat.o(235262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSelectLabelActivity
 * JD-Core Version:    0.7.0.1
 */