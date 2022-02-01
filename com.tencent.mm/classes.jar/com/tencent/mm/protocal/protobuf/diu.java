package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class diu
  extends com.tencent.mm.bw.a
{
  public String HQw;
  public boolean HQx;
  public boolean HQy;
  public String appName;
  public int cbX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116816);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQw != null) {
        paramVarArgs.d(1, this.HQw);
      }
      if (this.appName != null) {
        paramVarArgs.d(2, this.appName);
      }
      paramVarArgs.aS(3, this.cbX);
      paramVarArgs.bC(4, this.HQx);
      paramVarArgs.bC(5, this.HQy);
      AppMethodBeat.o(116816);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQw == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.HQw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appName != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.appName);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.cbX);
      int j = f.a.a.b.b.a.amF(4);
      int k = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(116816);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(116816);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        diu localdiu = (diu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116816);
          return -1;
        case 1: 
          localdiu.HQw = locala.OmT.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 2: 
          localdiu.appName = locala.OmT.readString();
          AppMethodBeat.o(116816);
          return 0;
        case 3: 
          localdiu.cbX = locala.OmT.zc();
          AppMethodBeat.o(116816);
          return 0;
        case 4: 
          localdiu.HQx = locala.OmT.gvY();
          AppMethodBeat.o(116816);
          return 0;
        }
        localdiu.HQy = locala.OmT.gvY();
        AppMethodBeat.o(116816);
        return 0;
      }
      AppMethodBeat.o(116816);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diu
 * JD-Core Version:    0.7.0.1
 */