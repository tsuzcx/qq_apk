package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dps
  extends com.tencent.mm.bw.a
{
  public String FWW;
  public String FaK;
  public String Fbl;
  public String cJz;
  public String djj;
  public String ofa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123678);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      if (this.cJz != null) {
        paramVarArgs.d(2, this.cJz);
      }
      if (this.Fbl != null) {
        paramVarArgs.d(3, this.Fbl);
      }
      if (this.FWW != null) {
        paramVarArgs.d(4, this.FWW);
      }
      if (this.ofa != null) {
        paramVarArgs.d(5, this.ofa);
      }
      if (this.FaK != null) {
        paramVarArgs.d(6, this.FaK);
      }
      AppMethodBeat.o(123678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label518;
      }
    }
    label518:
    for (int i = f.a.a.b.b.a.e(1, this.djj) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cJz != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cJz);
      }
      i = paramInt;
      if (this.Fbl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fbl);
      }
      paramInt = i;
      if (this.FWW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FWW);
      }
      i = paramInt;
      if (this.ofa != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ofa);
      }
      paramInt = i;
      if (this.FaK != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FaK);
      }
      AppMethodBeat.o(123678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123678);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dps localdps = (dps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123678);
          return -1;
        case 1: 
          localdps.djj = locala.LVo.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 2: 
          localdps.cJz = locala.LVo.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 3: 
          localdps.Fbl = locala.LVo.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 4: 
          localdps.FWW = locala.LVo.readString();
          AppMethodBeat.o(123678);
          return 0;
        case 5: 
          localdps.ofa = locala.LVo.readString();
          AppMethodBeat.o(123678);
          return 0;
        }
        localdps.FaK = locala.LVo.readString();
        AppMethodBeat.o(123678);
        return 0;
      }
      AppMethodBeat.o(123678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dps
 * JD-Core Version:    0.7.0.1
 */