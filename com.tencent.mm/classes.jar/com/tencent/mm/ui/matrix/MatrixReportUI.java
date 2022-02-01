package com.tencent.mm.ui.matrix;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.e;
import com.tencent.matrix.report.g;
import com.tencent.matrix.report.l;
import com.tencent.matrix.report.l.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;

public class MatrixReportUI
  extends MMActivity
{
  private JSONArray afxB;
  
  public MatrixReportUI()
  {
    AppMethodBeat.i(38877);
    this.afxB = new JSONArray();
    AppMethodBeat.o(38877);
  }
  
  public int getLayoutId()
  {
    return R.i.glD;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38878);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(R.l.gNF));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(38875);
        MatrixReportUI.this.finish();
        AppMethodBeat.o(38875);
        return true;
      }
    });
    paramBundle = e.eLE.eLF.eYR.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (l.b)paramBundle.next();
      this.afxB.put(((g)localObject).eYz);
    }
    paramBundle = (JsonRecyclerView)findViewById(R.h.fLS);
    Object localObject = new com.tencent.mm.ui.matrix.recyclerview.b(this.afxB);
    paramBundle.setAdapter((RecyclerView.a)localObject);
    ((com.tencent.mm.ui.matrix.recyclerview.b)localObject).AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/ui/matrix/MatrixReportUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (paramAnonymousView.getTag() != null)
        {
          ClipboardHelper.setText(paramAnonymousView.getTag().toString());
          Toast.makeText(MMApplicationContext.getContext(), MatrixReportUI.this.getContext().getResources().getString(R.l.app_copy_ok), 0).show();
        }
        a.a(true, this, "com/tencent/mm/ui/matrix/MatrixReportUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(38876);
        return true;
      }
    };
    AppMethodBeat.o(38878);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38879);
    super.onDestroy();
    AppMethodBeat.o(38879);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.matrix.MatrixReportUI
 * JD-Core Version:    0.7.0.1
 */