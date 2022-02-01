package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xk
  extends com.tencent.mm.bx.a
{
  public String FWO;
  public String FWP;
  public String FWQ;
  public String FWR;
  public String FWS;
  public String FWT;
  public int Scene;
  public int nEf;
  public String uEK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      paramVarArgs.aS(2, this.nEf);
      if (this.FWO != null) {
        paramVarArgs.d(3, this.FWO);
      }
      if (this.FWP != null) {
        paramVarArgs.d(4, this.FWP);
      }
      if (this.uEK != null) {
        paramVarArgs.d(5, this.uEK);
      }
      if (this.FWQ != null) {
        paramVarArgs.d(6, this.FWQ);
      }
      if (this.FWR != null) {
        paramVarArgs.d(7, this.FWR);
      }
      if (this.FWS != null) {
        paramVarArgs.d(8, this.FWS);
      }
      if (this.FWT != null) {
        paramVarArgs.d(9, this.FWT);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0 + f.a.a.b.b.a.bz(2, this.nEf);
      paramInt = i;
      if (this.FWO != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FWO);
      }
      i = paramInt;
      if (this.FWP != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FWP);
      }
      paramInt = i;
      if (this.uEK != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uEK);
      }
      i = paramInt;
      if (this.FWQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FWQ);
      }
      paramInt = i;
      if (this.FWR != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FWR);
      }
      i = paramInt;
      if (this.FWS != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FWS);
      }
      paramInt = i;
      if (this.FWT != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FWT);
      }
      AppMethodBeat.o(127628);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xk localxk = (xk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localxk.Scene = locala.NPN.zc();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localxk.nEf = locala.NPN.zc();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localxk.FWO = locala.NPN.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localxk.FWP = locala.NPN.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localxk.uEK = locala.NPN.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localxk.FWQ = locala.NPN.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localxk.FWR = locala.NPN.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localxk.FWS = locala.NPN.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localxk.FWT = locala.NPN.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xk
 * JD-Core Version:    0.7.0.1
 */