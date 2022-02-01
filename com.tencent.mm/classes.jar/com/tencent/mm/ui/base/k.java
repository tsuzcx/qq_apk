package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class k
  extends AlertDialog
{
  public AdapterView.OnItemClickListener FBJ;
  private CharSequence Hd;
  private View iFK;
  private Context mContext;
  private ListView mListView;
  public BaseAdapter oKk;
  
  public k(Context paramContext)
  {
    super(paramContext, 2131821723);
    AppMethodBeat.i(142033);
    this.mContext = paramContext;
    if (a.ir(this.mContext)) {}
    for (this.iFK = View.inflate(this.mContext, 2131494799, null);; this.iFK = View.inflate(this.mContext, 2131494798, null))
    {
      this.mListView = ((ListView)this.iFK.findViewById(2131301443));
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
      ae.e("MicroMsg.MMListDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(142036);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(142034);
    super.onCreate(paramBundle);
    setContentView(this.iFK);
    AppMethodBeat.o(142034);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Hd = paramCharSequence;
      return;
    }
    this.Hd = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(142035);
    if (this.Hd != null) {
      this.Hd.length();
    }
    if (this.FBJ != null) {
      this.mListView.setOnItemClickListener(this.FBJ);
    }
    if (this.oKk != null) {
      this.mListView.setAdapter(this.oKk);
    }
    super.show();
    AppMethodBeat.o(142035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */