package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class aob
  extends com.tencent.mm.bx.a
{
  public String Dpj;
  public int Dpk;
  public int Dpl;
  public long Dpm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dpj != null) {
        paramVarArgs.d(1, this.Dpj);
      }
      paramVarArgs.aR(2, this.Dpk);
      paramVarArgs.aR(3, this.Dpl);
      paramVarArgs.aG(99, this.Dpm);
      AppMethodBeat.o(152542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dpj == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dpj) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.Dpk);
      int j = f.a.a.b.b.a.bA(3, this.Dpl);
      int k = f.a.a.b.b.a.q(99, this.Dpm);
      AppMethodBeat.o(152542);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152542);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aob localaob = (aob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152542);
          return -1;
        case 1: 
          localaob.Dpj = locala.KhF.readString();
          AppMethodBeat.o(152542);
          return 0;
        case 2: 
          localaob.Dpk = locala.KhF.xS();
          AppMethodBeat.o(152542);
          return 0;
        case 3: 
          localaob.Dpl = locala.KhF.xS();
          AppMethodBeat.o(152542);
          return 0;
        }
        localaob.Dpm = locala.KhF.xT();
        AppMethodBeat.o(152542);
        return 0;
      }
      AppMethodBeat.o(152542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aob
 * JD-Core Version:    0.7.0.1
 */