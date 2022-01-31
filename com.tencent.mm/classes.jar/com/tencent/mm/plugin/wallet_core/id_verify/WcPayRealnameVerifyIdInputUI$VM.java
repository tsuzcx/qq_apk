package com.tencent.mm.plugin.wallet_core.id_verify;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;

public class WcPayRealnameVerifyIdInputUI$VM
  extends ViewModel
{
  public MutableLiveData<String> udE;
  public MutableLiveData<Integer> udF;
  public MutableLiveData<String> udG;
  public MutableLiveData<Boolean> udH;
  public MutableLiveData<String> udI;
  public MutableLiveData<String> udJ;
  public MutableLiveData<String> udK;
  public MutableLiveData<String> udL;
  public MutableLiveData<Profession> udM;
  public MutableLiveData<Boolean> udN;
  public MutableLiveData<String> udO;
  public MutableLiveData<Integer> udP;
  public MutableLiveData<String> udQ;
  public MutableLiveData<String> udR;
  public MutableLiveData<String> udS;
  
  public WcPayRealnameVerifyIdInputUI$VM()
  {
    AppMethodBeat.i(142441);
    this.udE = new MutableLiveData();
    this.udF = new MutableLiveData();
    this.udG = new MutableLiveData();
    this.udH = new MutableLiveData();
    this.udI = new MutableLiveData();
    this.udJ = new MutableLiveData();
    this.udK = new MutableLiveData();
    this.udL = new MutableLiveData();
    this.udM = new MutableLiveData();
    this.udN = new MutableLiveData();
    this.udO = new MutableLiveData();
    this.udP = new MutableLiveData();
    this.udQ = new MutableLiveData();
    this.udR = new MutableLiveData();
    this.udS = new MutableLiveData();
    this.udF.setValue(Integer.valueOf(1));
    this.udP.setValue(Integer.valueOf(0));
    WcPayRealnameVerifyIdInputUI.VM.1 local1 = new WcPayRealnameVerifyIdInputUI.VM.1(this);
    this.udE.observeForever(local1);
    this.udG.observeForever(local1);
    this.udM.observeForever(local1);
    this.udI.observeForever(local1);
    this.udJ.observeForever(local1);
    this.udK.observeForever(local1);
    this.udO.observeForever(local1);
    this.udP.observeForever(local1);
    this.udR.observeForever(local1);
    this.udS.observeForever(local1);
    this.udQ.observeForever(local1);
    AppMethodBeat.o(142441);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(142442);
    this.udO.setValue("");
    this.udP.setValue(Integer.valueOf(0));
    this.udQ.setValue("");
    this.udR.setValue("");
    this.udS.setValue("");
    AppMethodBeat.o(142442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WcPayRealnameVerifyIdInputUI.VM
 * JD-Core Version:    0.7.0.1
 */