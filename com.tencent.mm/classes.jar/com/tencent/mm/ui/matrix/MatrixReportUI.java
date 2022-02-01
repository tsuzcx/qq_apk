package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.d;
import com.tencent.matrix.report.f;
import com.tencent.matrix.report.k;
import com.tencent.matrix.report.k.b;
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
  private JSONArray XKM;
  
  public MatrixReportUI()
  {
    AppMethodBeat.i(38877);
    this.XKM = new JSONArray();
    AppMethodBeat.o(38877);
  }
  
  public int getLayoutId()
  {
    return R.i.eiE;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38878);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(R.l.eLL));
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
    paramBundle = d.cQA.cQB.dar.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (k.b)paramBundle.next();
      this.XKM.put(((f)localObject).cZZ);
    }
    paramBundle = (JsonRecyclerView)findViewById(R.h.dKu);
    Object localObject = new com.tencent.mm.ui.matrix.recyclerview.b(this.XKM);
    paramBundle.setAdapter((RecyclerView.a)localObject);
    ((com.tencent.mm.ui.matrix.recyclerview.b)localObject).wOt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/ui/matrix/MatrixReportUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
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