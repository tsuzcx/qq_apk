package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class arf
  extends com.tencent.mm.bw.a
{
  public String EKj;
  public int EKk;
  public int EKl;
  public long EKm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EKj != null) {
        paramVarArgs.d(1, this.EKj);
      }
      paramVarArgs.aR(2, this.EKk);
      paramVarArgs.aR(3, this.EKl);
      paramVarArgs.aO(99, this.EKm);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EKj == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.EKj) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.EKk);
      int j = f.a.a.b.b.a.bx(3, this.EKl);
      int k = f.a.a.b.b.a.p(99, this.EKm);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        arf localarf = (arf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localarf.EKj = locala.LVo.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localarf.EKk = locala.LVo.xF();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localarf.EKl = locala.LVo.xF();
          AppMethodBeat.o(152542);
          return 0;
        }
        localarf.EKm = locala.LVo.xG();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arf
 * JD-Core Version:    0.7.0.1
 */