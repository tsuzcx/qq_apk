package com.tencent.mm.plugin.secdata.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kiss.WxPresenterActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.Set;
import kotlin.a.ak;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/secdata/ui/WxPresenterSecDataActivity;", "Lcom/tencent/mm/kiss/WxPresenterActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "ui-sec-data_release"})
public abstract class WxPresenterSecDataActivity
  extends WxPresenterActivity
{
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    return ak.setOf(SecDataUIC.class);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.secdata.ui.WxPresenterSecDataActivity
 * JD-Core Version:    0.7.0.1
 */