package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.b.c;

final class AppChooserUI$e
{
  DialogInterface.OnDismissListener NX;
  public c gNn;
  BaseAdapter krV;
  Context mContext;
  String mTitle;
  DialogInterface.OnClickListener wdI;
  ListViewInScrollView wdU;
  AdapterView.OnItemClickListener wdV;
  DialogInterface.OnClickListener wdW;
  
  public AppChooserUI$e(AppChooserUI paramAppChooserUI, Context paramContext)
  {
    AppMethodBeat.i(125874);
    this.mContext = paramContext;
    this.wdU = ((ListViewInScrollView)View.inflate(this.mContext, 2130968753, null));
    AppMethodBeat.o(125874);
  }
  
  public final void pv(boolean paramBoolean)
  {
    AppMethodBeat.i(125875);
    if (this.gNn != null)
    {
      if (!paramBoolean)
      {
        this.gNn.a(2131297099, null);
        this.gNn.b(2131297098, null);
        AppMethodBeat.o(125875);
        return;
      }
      this.gNn.a(2131297099, this.wdI);
      this.gNn.b(2131297098, this.wdW);
    }
    AppMethodBeat.o(125875);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.AppChooserUI.e
 * JD-Core Version:    0.7.0.1
 */