package com.tencent.mm.ui.transmit;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ak;

public final class MsgRetransmitUI$a
  extends AsyncTask<Object, Object, String>
{
  public boolean AzG;
  public String AzH;
  public boolean AzI;
  public boolean AzJ;
  public boolean AzK;
  public cii AzL;
  public MsgRetransmitUI.b AzM;
  public boolean Aza;
  public int Azc;
  public String cGU;
  public Context context;
  public String dns;
  public int fVF;
  public int fXx;
  public String fileName;
  public Dialog gKM;
  private ak mHandler;
  public String userName;
  
  public MsgRetransmitUI$a()
  {
    AppMethodBeat.i(35087);
    this.AzI = true;
    this.AzJ = false;
    this.Aza = false;
    this.AzK = true;
    this.AzL = null;
    this.AzM = null;
    this.mHandler = new ak();
    AppMethodBeat.o(35087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.MsgRetransmitUI.a
 * JD-Core Version:    0.7.0.1
 */