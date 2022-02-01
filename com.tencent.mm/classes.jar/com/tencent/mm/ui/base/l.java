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
import com.tencent.mm.sdk.platformtools.Log;

public final class l
  extends AlertDialog
{
  private CharSequence Hn;
  public AdapterView.OnItemClickListener Kth;
  private View jBN;
  private Context mContext;
  private ListView mListView;
  public BaseAdapter pXY;
  
  public l(Context paramContext)
  {
    super(paramContext, 2131821772);
    AppMethodBeat.i(142033);
    this.mContext = paramContext;
    if (a.jk(this.mContext)) {}
    for (this.jBN = View.inflate(this.mContext, 2131495533, null);; this.jBN = View.inflate(this.mContext, 2131495532, null))
    {
      this.mListView = ((ListView)this.jBN.findViewById(2131303226));
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
    setContentView(this.jBN);
    AppMethodBeat.o(142034);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Hn = paramCharSequence;
      return;
    }
    this.Hn = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(142035);
    if (this.Hn != null) {
      this.Hn.length();
    }
    if (this.Kth != null) {
      this.mListView.setOnItemClickListener(this.Kth);
    }
    if (this.pXY != null) {
      this.mListView.setAdapter(this.pXY);
    }
    super.show();
    AppMethodBeat.o(142035);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.l
 * JD-Core Version:    0.7.0.1
 */