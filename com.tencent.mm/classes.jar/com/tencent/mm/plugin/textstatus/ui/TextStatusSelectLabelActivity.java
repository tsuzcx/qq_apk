package com.tencent.mm.plugin.textstatus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusSelectLabelActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "rgVisibleGroup", "Landroid/widget/RadioGroup;", "getRgVisibleGroup", "()Landroid/widget/RadioGroup;", "setRgVisibleGroup", "(Landroid/widget/RadioGroup;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusSelectLabelActivity
  extends MMActivity
{
  public static final TextStatusSelectLabelActivity.a TAo;
  private RadioGroup TAp;
  
  static
  {
    AppMethodBeat.i(291216);
    TAo = new TextStatusSelectLabelActivity.a((byte)0);
    AppMethodBeat.o(291216);
  }
  
  private static final void a(TextStatusSelectLabelActivity paramTextStatusSelectLabelActivity, RadioGroup paramRadioGroup, int paramInt)
  {
    AppMethodBeat.i(291211);
    s.u(paramTextStatusSelectLabelActivity, "this$0");
    paramRadioGroup = new Intent();
    paramRadioGroup.putExtra("SELECT_VISIBILITY", paramInt);
    paramTextStatusSelectLabelActivity.setResult(-1, paramRadioGroup);
    paramTextStatusSelectLabelActivity.finish();
    AppMethodBeat.o(291211);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.TfJ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291233);
    super.onCreate(paramBundle);
    setMMTitle(a.h.Thj);
    this.TAp = ((RadioGroup)findViewById(a.e.TdP));
    paramBundle = this.TAp;
    if (paramBundle != null) {
      paramBundle.setOnCheckedChangeListener(new TextStatusSelectLabelActivity..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(291233);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusSelectLabelActivity
 * JD-Core Version:    0.7.0.1
 */