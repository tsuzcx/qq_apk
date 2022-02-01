package com.tencent.mm.ui.matrix;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.a;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.tencent.matrix.d;
import com.tencent.matrix.report.c;
import com.tencent.matrix.report.h;
import com.tencent.matrix.report.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.matrix.recyclerview.JsonRecyclerView;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;

public class MatrixReportUI
  extends MMActivity
{
  private JSONArray KXT;
  
  public MatrixReportUI()
  {
    AppMethodBeat.i(38877);
    this.KXT = new JSONArray();
    AppMethodBeat.o(38877);
  }
  
  public int getLayoutId()
  {
    return 2131494744;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38878);
    super.onCreate(paramBundle);
    setMMTitle(getContext().getResources().getString(2131761193));
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
    paramBundle = d.cBK.cBL.cFY.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (h.d)paramBundle.next();
      this.KXT.put(((c)localObject).cFG);
    }
    paramBundle = (JsonRecyclerView)findViewById(2131301234);
    Object localObject = new com.tencent.mm.ui.matrix.recyclerview.b(this.KXT);
    paramBundle.setAdapter((RecyclerView.a)localObject);
    ((com.tencent.mm.ui.matrix.recyclerview.b)localObject).rIu = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38876);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/matrix/MatrixReportUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (paramAnonymousView.getTag() != null)
        {
          ((ClipboardManager)ak.getContext().getSystemService("clipboard")).setText(paramAnonymousView.getTag().toString());
          Toast.makeText(ak.getContext(), MatrixReportUI.this.getContext().getResources().getString(2131755702), 0).show();
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