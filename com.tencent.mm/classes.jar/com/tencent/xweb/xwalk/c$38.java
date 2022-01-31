package com.tencent.xweb.xwalk;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$38
  extends AsyncTask<Void, Void, Boolean>
{
  private ProgressDialog nSa = null;
  
  c$38(c paramc, String paramString) {}
  
  protected final void onPreExecute()
  {
    AppMethodBeat.i(139572);
    this.nSa = new ProgressDialog(this.BIO.BDH);
    this.nSa.setProgressStyle(0);
    this.nSa.setMessage("安装中");
    this.nSa.setCancelable(false);
    this.nSa.setCanceledOnTouchOutside(false);
    this.nSa.setButton(-2, "取消", new c.38.1(this));
    this.nSa.setButton(-1, "重启", new c.38.2(this));
    this.nSa.show();
    this.nSa.getButton(-2).setVisibility(8);
    this.nSa.getButton(-1).setVisibility(8);
    AppMethodBeat.o(139572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.38
 * JD-Core Version:    0.7.0.1
 */