package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public class egp
  extends com.tencent.mm.bx.a
{
  public int AcJ;
  public int ablP;
  public boolean ablQ;
  public boolean ablR;
  public boolean ablS;
  public boolean ablT;
  public boolean ablU;
  public boolean ablV;
  public int id;
  public String mXG = "";
  public int nQm;
  public String url;
  public int vAZ;
  public int vST;
  public boolean vSc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259165);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(259165);
        throw paramVarArgs;
      }
      if (this.mXG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(259165);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.id);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      paramVarArgs.bS(3, this.nQm);
      paramVarArgs.bS(4, this.vST);
      paramVarArgs.bS(5, this.vAZ);
      paramVarArgs.bS(6, this.AcJ);
      paramVarArgs.bS(7, this.ablP);
      if (this.mXG != null) {
        paramVarArgs.g(8, this.mXG);
      }
      paramVarArgs.di(9, this.ablQ);
      paramVarArgs.di(10, this.ablR);
      paramVarArgs.di(11, this.ablS);
      paramVarArgs.di(12, this.ablT);
      paramVarArgs.di(13, this.ablU);
      paramVarArgs.di(14, this.vSc);
      paramVarArgs.di(15, this.ablV);
      AppMethodBeat.o(259165);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.nQm) + i.a.a.b.b.a.cJ(4, this.vST) + i.a.a.b.b.a.cJ(5, this.vAZ) + i.a.a.b.b.a.cJ(6, this.AcJ) + i.a.a.b.b.a.cJ(7, this.ablP);
      paramInt = i;
      if (this.mXG != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.mXG);
      }
      i = i.a.a.b.b.a.ko(9);
      int j = i.a.a.b.b.a.ko(10);
      int k = i.a.a.b.b.a.ko(11);
      int m = i.a.a.b.b.a.ko(12);
      int n = i.a.a.b.b.a.ko(13);
      int i1 = i.a.a.b.b.a.ko(14);
      int i2 = i.a.a.b.b.a.ko(15);
      AppMethodBeat.o(259165);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1) + (i1 + 1) + (i2 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(259165);
        throw paramVarArgs;
      }
      if (this.mXG == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(259165);
        throw paramVarArgs;
      }
      AppMethodBeat.o(259165);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      egp localegp = (egp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259165);
        return -1;
      case 1: 
        localegp.id = locala.ajGk.aar();
        AppMethodBeat.o(259165);
        return 0;
      case 2: 
        localegp.url = locala.ajGk.readString();
        AppMethodBeat.o(259165);
        return 0;
      case 3: 
        localegp.nQm = locala.ajGk.aar();
        AppMethodBeat.o(259165);
        return 0;
      case 4: 
        localegp.vST = locala.ajGk.aar();
        AppMethodBeat.o(259165);
        return 0;
      case 5: 
        localegp.vAZ = locala.ajGk.aar();
        AppMethodBeat.o(259165);
        return 0;
      case 6: 
        localegp.AcJ = locala.ajGk.aar();
        AppMethodBeat.o(259165);
        return 0;
      case 7: 
        localegp.ablP = locala.ajGk.aar();
        AppMethodBeat.o(259165);
        return 0;
      case 8: 
        localegp.mXG = locala.ajGk.readString();
        AppMethodBeat.o(259165);
        return 0;
      case 9: 
        localegp.ablQ = locala.ajGk.aai();
        AppMethodBeat.o(259165);
        return 0;
      case 10: 
        localegp.ablR = locala.ajGk.aai();
        AppMethodBeat.o(259165);
        return 0;
      case 11: 
        localegp.ablS = locala.ajGk.aai();
        AppMethodBeat.o(259165);
        return 0;
      case 12: 
        localegp.ablT = locala.ajGk.aai();
        AppMethodBeat.o(259165);
        return 0;
      case 13: 
        localegp.ablU = locala.ajGk.aai();
        AppMethodBeat.o(259165);
        return 0;
      case 14: 
        localegp.vSc = locala.ajGk.aai();
        AppMethodBeat.o(259165);
        return 0;
      }
      localegp.ablV = locala.ajGk.aai();
      AppMethodBeat.o(259165);
      return 0;
    }
    AppMethodBeat.o(259165);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egp
 * JD-Core Version:    0.7.0.1
 */