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
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends AlertDialog
{
  private CharSequence Cv;
  private View iCk;
  public BaseAdapter krV;
  private Context mContext;
  private ListView mListView;
  public AdapterView.OnItemClickListener wdV;
  
  public k(Context paramContext)
  {
    super(paramContext, 2131493881);
    AppMethodBeat.i(106682);
    this.mContext = paramContext;
    if (a.gt(this.mContext)) {}
    for (this.iCk = View.inflate(this.mContext, 2130970174, null);; this.iCk = View.inflate(this.mContext, 2130970173, null))
    {
      this.mListView = ((ListView)this.iCk.findViewById(2131821002));
      AppMethodBeat.o(106682);
      return;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(106685);
    try
    {
      super.dismiss();
      AppMethodBeat.o(106685);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MMListDialog", "dismiss exception, e = " + localException.getMessage());
      AppMethodBeat.o(106685);
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106683);
    super.onCreate(paramBundle);
    setContentView(this.iCk);
    AppMethodBeat.o(106683);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.Cv = paramCharSequence;
      return;
    }
    this.Cv = null;
  }
  
  public final void show()
  {
    AppMethodBeat.i(106684);
    if (this.Cv != null) {
      this.Cv.length();
    }
    if (this.wdV != null) {
      this.mListView.setOnItemClickListener(this.wdV);
    }
    if (this.krV != null) {
      this.mListView.setAdapter(this.krV);
    }
    super.show();
    AppMethodBeat.o(106684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */