package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xn
  extends com.tencent.mm.bw.a
{
  public String Gpn;
  public String Gpo;
  public String Gpp;
  public String Gpq;
  public String Gpr;
  public String Gps;
  public int Scene;
  public int nJA;
  public String uQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Scene);
      paramVarArgs.aS(2, this.nJA);
      if (this.Gpn != null) {
        paramVarArgs.d(3, this.Gpn);
      }
      if (this.Gpo != null) {
        paramVarArgs.d(4, this.Gpo);
      }
      if (this.uQx != null) {
        paramVarArgs.d(5, this.uQx);
      }
      if (this.Gpp != null) {
        paramVarArgs.d(6, this.Gpp);
      }
      if (this.Gpq != null) {
        paramVarArgs.d(7, this.Gpq);
      }
      if (this.Gpr != null) {
        paramVarArgs.d(8, this.Gpr);
      }
      if (this.Gps != null) {
        paramVarArgs.d(9, this.Gps);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Scene) + 0 + f.a.a.b.b.a.bz(2, this.nJA);
      paramInt = i;
      if (this.Gpn != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gpn);
      }
      i = paramInt;
      if (this.Gpo != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Gpo);
      }
      paramInt = i;
      if (this.uQx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.uQx);
      }
      i = paramInt;
      if (this.Gpp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Gpp);
      }
      paramInt = i;
      if (this.Gpq != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gpq);
      }
      i = paramInt;
      if (this.Gpr != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Gpr);
      }
      paramInt = i;
      if (this.Gps != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Gps);
      }
      AppMethodBeat.o(127628);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      xn localxn = (xn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localxn.Scene = locala.OmT.zc();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localxn.nJA = locala.OmT.zc();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localxn.Gpn = locala.OmT.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localxn.Gpo = locala.OmT.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localxn.uQx = locala.OmT.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localxn.Gpp = locala.OmT.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localxn.Gpq = locala.OmT.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localxn.Gpr = locala.OmT.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localxn.Gps = locala.OmT.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xn
 * JD-Core Version:    0.7.0.1
 */