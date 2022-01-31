package com.tencent.mm.ui.base;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.l;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends AlertDialog
{
  private CharSequence BM;
  private ListView Nn;
  private View ipf;
  public BaseAdapter iqN;
  private Context mContext;
  public AdapterView.OnItemClickListener slt;
  
  public k(Context paramContext)
  {
    super(paramContext, a.l.mmalertdialog);
    this.mContext = paramContext;
    if (a.fh(this.mContext)) {}
    for (this.ipf = View.inflate(this.mContext, a.h.mm_list_dialog_large, null);; this.ipf = View.inflate(this.mContext, a.h.mm_list_dialog, null))
    {
      this.Nn = ((ListView)this.ipf.findViewById(a.g.list));
      return;
    }
  }
  
  public final void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MMListDialog", "dismiss exception, e = " + localException.getMessage());
    }
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(this.ipf);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null)
    {
      this.BM = paramCharSequence;
      return;
    }
    this.BM = null;
  }
  
  public final void show()
  {
    if (this.BM != null) {
      this.BM.length();
    }
    if (this.slt != null) {
      this.Nn.setOnItemClickListener(this.slt);
    }
    if (this.iqN != null) {
      this.Nn.setAdapter(this.iqN);
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.k
 * JD-Core Version:    0.7.0.1
 */