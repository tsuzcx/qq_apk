package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxm
  extends com.tencent.mm.bx.a
{
  public String Desc;
  public String FKf;
  public String GKJ;
  public int HoV;
  public String HoW;
  public String mlF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKf != null) {
        paramVarArgs.d(1, this.FKf);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aS(3, this.HoV);
      if (this.mlF != null) {
        paramVarArgs.d(4, this.mlF);
      }
      if (this.GKJ != null) {
        paramVarArgs.d(5, this.GKJ);
      }
      if (this.HoW != null) {
        paramVarArgs.d(6, this.HoW);
      }
      AppMethodBeat.o(123643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FKf == null) {
        break label502;
      }
    }
    label502:
    for (paramInt = f.a.a.b.b.a.e(1, this.FKf) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bz(3, this.HoV);
      paramInt = i;
      if (this.mlF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mlF);
      }
      i = paramInt;
      if (this.GKJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKJ);
      }
      paramInt = i;
      if (this.HoW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HoW);
      }
      AppMethodBeat.o(123643);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123643);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cxm localcxm = (cxm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123643);
          return -1;
        case 1: 
          localcxm.FKf = locala.NPN.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 2: 
          localcxm.Desc = locala.NPN.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 3: 
          localcxm.HoV = locala.NPN.zc();
          AppMethodBeat.o(123643);
          return 0;
        case 4: 
          localcxm.mlF = locala.NPN.readString();
          AppMethodBeat.o(123643);
          return 0;
        case 5: 
          localcxm.GKJ = locala.NPN.readString();
          AppMethodBeat.o(123643);
          return 0;
        }
        localcxm.HoW = locala.NPN.readString();
        AppMethodBeat.o(123643);
        return 0;
      }
      AppMethodBeat.o(123643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxm
 * JD-Core Version:    0.7.0.1
 */