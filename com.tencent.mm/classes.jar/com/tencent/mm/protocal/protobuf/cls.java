package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cls
  extends com.tencent.mm.bw.a
{
  public String CZP;
  public String GVe;
  public int GZU;
  public String GvO;
  public String HxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GVe != null) {
        paramVarArgs.d(1, this.GVe);
      }
      if (this.HxM != null) {
        paramVarArgs.d(2, this.HxM);
      }
      if (this.CZP != null) {
        paramVarArgs.d(3, this.CZP);
      }
      if (this.GvO != null) {
        paramVarArgs.d(4, this.GvO);
      }
      paramVarArgs.aS(5, this.GZU);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GVe == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.GVe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HxM != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HxM);
      }
      i = paramInt;
      if (this.CZP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CZP);
      }
      paramInt = i;
      if (this.GvO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GvO);
      }
      i = f.a.a.b.b.a.bz(5, this.GZU);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cls localcls = (cls)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localcls.GVe = locala.OmT.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localcls.HxM = locala.OmT.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localcls.CZP = locala.OmT.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localcls.GvO = locala.OmT.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localcls.GZU = locala.OmT.zc();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cls
 * JD-Core Version:    0.7.0.1
 */