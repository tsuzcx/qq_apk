package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ag
  extends com.tencent.mm.bw.a
{
  public String DLZ;
  public int DMa;
  public int DMb;
  public int DMc;
  public int DMd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DLZ != null) {
        paramVarArgs.d(1, this.DLZ);
      }
      paramVarArgs.aR(2, this.DMa);
      paramVarArgs.aR(3, this.DMb);
      paramVarArgs.aR(4, this.DMc);
      paramVarArgs.aR(5, this.DMd);
      AppMethodBeat.o(143961);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DLZ == null) {
        break label398;
      }
    }
    label398:
    for (paramInt = f.a.a.b.b.a.e(1, this.DLZ) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.DMa);
      int j = f.a.a.b.b.a.bx(3, this.DMb);
      int k = f.a.a.b.b.a.bx(4, this.DMc);
      int m = f.a.a.b.b.a.bx(5, this.DMd);
      AppMethodBeat.o(143961);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(143961);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ag localag = (ag)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(143961);
          return -1;
        case 1: 
          localag.DLZ = locala.LVo.readString();
          AppMethodBeat.o(143961);
          return 0;
        case 2: 
          localag.DMa = locala.LVo.xF();
          AppMethodBeat.o(143961);
          return 0;
        case 3: 
          localag.DMb = locala.LVo.xF();
          AppMethodBeat.o(143961);
          return 0;
        case 4: 
          localag.DMc = locala.LVo.xF();
          AppMethodBeat.o(143961);
          return 0;
        }
        localag.DMd = locala.LVo.xF();
        AppMethodBeat.o(143961);
        return 0;
      }
      AppMethodBeat.o(143961);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ag
 * JD-Core Version:    0.7.0.1
 */