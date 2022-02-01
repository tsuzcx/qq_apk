package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.ah.a.h;
import com.tencent.mm.ah.a.l;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class n
  extends AlertDialog
{
  public AdapterView.OnItemClickListener Ruo;
  private CharSequence cZ;
  private Context mContext;
  private ListView mListView;
  private View mrI;
  public BaseAdapter ttU;
  
  public n(Context paramContext)
  {
    super(paramContext, a.l.mmalertdialog);
    AppMethodBeat.i(142033);
    this.mContext = paramContext;
    if (a.ko(this.mContext)) {}
    for (this.mrI = View.inflate(this.mContext, a.h.mm_list_dialog_large, null);; this.mrI = View.inflate(this.mContext, a.h.mm_list_dialog, null))
    {
      this.mListView = ((ListView)this.mrI.findViewById(a.g.list));
      AppMethodBeat.o(142033);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(142036);
    try
    {
      super.dismiss();
      AppMethodBeat.o(142036);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.MMListDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142036);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142034);
    super.onCreate(paramBundle);
    setContentView(this.mrI);
    AppMethodBeat.o(142034);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.cZ = paramCharSequence;
      return;
    }
    this.cZ = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(142035);
    if (this.cZ != null) {
      this.cZ.length();
    }
    if (this.Ruo != null) {
      this.mListView.setOnItemClickListener(this.Ruo);
    }
    if (this.ttU != null) {
      this.mListView.setAdapter(this.ttU);
    }
    super.show();
    AppMethodBeat.o(142035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.base.n
 * JD-Core Version:    0.7.0.1
 */