package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aps
  extends com.tencent.mm.bw.a
{
  public String EIJ;
  public long EIK;
  public int dfm;
  public String id;
  public int srd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32213);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      paramVarArgs.aR(2, this.srd);
      if (this.EIJ != null) {
        paramVarArgs.d(3, this.EIJ);
      }
      paramVarArgs.aO(4, this.EIK);
      paramVarArgs.aR(5, this.dfm);
      AppMethodBeat.o(32213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label421;
      }
    }
    label421:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.srd);
      paramInt = i;
      if (this.EIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EIJ);
      }
      i = f.a.a.b.b.a.p(4, this.EIK);
      int j = f.a.a.b.b.a.bx(5, this.dfm);
      AppMethodBeat.o(32213);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32213);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aps localaps = (aps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32213);
          return -1;
        case 1: 
          localaps.id = locala.LVo.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 2: 
          localaps.srd = locala.LVo.xF();
          AppMethodBeat.o(32213);
          return 0;
        case 3: 
          localaps.EIJ = locala.LVo.readString();
          AppMethodBeat.o(32213);
          return 0;
        case 4: 
          localaps.EIK = locala.LVo.xG();
          AppMethodBeat.o(32213);
          return 0;
        }
        localaps.dfm = locala.LVo.xF();
        AppMethodBeat.o(32213);
        return 0;
      }
      AppMethodBeat.o(32213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aps
 * JD-Core Version:    0.7.0.1
 */