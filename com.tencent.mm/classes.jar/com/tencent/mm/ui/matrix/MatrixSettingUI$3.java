package com.tencent.mm.ui.matrix;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MatrixSettingUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MatrixSettingUI$3(MatrixSettingUI paramMatrixSettingUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(38888);
    Object localObject = new Intent(this.afxK, MatrixReportUI.class);
    ((Intent)localObject).addFlags(67108864);
    paramMenuItem = this.afxK;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/matrix/MatrixSettingUI$3", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/ui/matrix/MatrixSettingUI$3", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(38888);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixSettingUI.3
 * JD-Core Version:    0.7.0.1
 */