package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class brx
  extends com.tencent.mm.bx.a
{
  public String GMM;
  public String GMN;
  public String GMO;
  public String GMP;
  public String lYC;
  public int uxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uxt);
      if (this.lYC != null) {
        paramVarArgs.d(2, this.lYC);
      }
      if (this.GMM != null) {
        paramVarArgs.d(3, this.GMM);
      }
      if (this.GMN != null) {
        paramVarArgs.d(4, this.GMN);
      }
      if (this.GMO != null) {
        paramVarArgs.d(5, this.GMO);
      }
      if (this.GMP != null) {
        paramVarArgs.d(6, this.GMP);
      }
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.uxt) + 0;
      paramInt = i;
      if (this.lYC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.lYC);
      }
      i = paramInt;
      if (this.GMM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GMM);
      }
      paramInt = i;
      if (this.GMN != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GMN);
      }
      i = paramInt;
      if (this.GMO != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GMO);
      }
      paramInt = i;
      if (this.GMP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GMP);
      }
      AppMethodBeat.o(108147);
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
      AppMethodBeat.o(108147);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      brx localbrx = (brx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(108147);
        return -1;
      case 1: 
        localbrx.uxt = locala.NPN.zc();
        AppMethodBeat.o(108147);
        return 0;
      case 2: 
        localbrx.lYC = locala.NPN.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 3: 
        localbrx.GMM = locala.NPN.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 4: 
        localbrx.GMN = locala.NPN.readString();
        AppMethodBeat.o(108147);
        return 0;
      case 5: 
        localbrx.GMO = locala.NPN.readString();
        AppMethodBeat.o(108147);
        return 0;
      }
      localbrx.GMP = locala.NPN.readString();
      AppMethodBeat.o(108147);
      return 0;
    }
    AppMethodBeat.o(108147);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brx
 * JD-Core Version:    0.7.0.1
 */