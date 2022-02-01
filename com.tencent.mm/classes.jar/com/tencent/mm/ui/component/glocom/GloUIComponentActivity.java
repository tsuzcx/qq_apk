package com.tencent.mm.ui.component.glocom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/component/glocom/GloUIComponentActivity;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class GloUIComponentActivity
  extends UIComponentActivity
{
  public void _$_clearFindViewByIdCache() {}
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(250389);
    Set localSet = ar.setOf(a.class);
    AppMethodBeat.o(250389);
    return localSet;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.component.glocom.GloUIComponentActivity
 * JD-Core Version:    0.7.0.1
 */