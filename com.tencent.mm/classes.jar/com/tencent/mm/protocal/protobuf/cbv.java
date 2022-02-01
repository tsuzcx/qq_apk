package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbv
  extends com.tencent.mm.bx.a
{
  public String GAC;
  public int GVI;
  public String GVJ;
  public int GVK;
  public String GVL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GAC != null) {
        paramVarArgs.d(1, this.GAC);
      }
      paramVarArgs.aS(2, this.GVI);
      if (this.GVJ != null) {
        paramVarArgs.d(3, this.GVJ);
      }
      paramVarArgs.aS(4, this.GVK);
      if (this.GVL != null) {
        paramVarArgs.d(5, this.GVL);
      }
      AppMethodBeat.o(115847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GAC == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.GAC) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GVI);
      paramInt = i;
      if (this.GVJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GVJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GVK);
      paramInt = i;
      if (this.GVL != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GVL);
      }
      AppMethodBeat.o(115847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(115847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cbv localcbv = (cbv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115847);
          return -1;
        case 1: 
          localcbv.GAC = locala.NPN.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 2: 
          localcbv.GVI = locala.NPN.zc();
          AppMethodBeat.o(115847);
          return 0;
        case 3: 
          localcbv.GVJ = locala.NPN.readString();
          AppMethodBeat.o(115847);
          return 0;
        case 4: 
          localcbv.GVK = locala.NPN.zc();
          AppMethodBeat.o(115847);
          return 0;
        }
        localcbv.GVL = locala.NPN.readString();
        AppMethodBeat.o(115847);
        return 0;
      }
      AppMethodBeat.o(115847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbv
 * JD-Core Version:    0.7.0.1
 */