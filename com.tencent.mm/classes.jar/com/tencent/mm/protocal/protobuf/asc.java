package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class asc
  extends com.tencent.mm.bw.a
{
  public int DQO;
  public int ELJ;
  public String hOf;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hOf != null) {
        paramVarArgs.d(1, this.hOf);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.DQO);
      paramVarArgs.aR(4, this.ELJ);
      AppMethodBeat.o(123572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hOf == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.hOf) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bx(2, this.ndI);
      int j = f.a.a.b.b.a.bx(3, this.DQO);
      int k = f.a.a.b.b.a.bx(4, this.ELJ);
      AppMethodBeat.o(123572);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123572);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        asc localasc = (asc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123572);
          return -1;
        case 1: 
          localasc.hOf = locala.LVo.readString();
          AppMethodBeat.o(123572);
          return 0;
        case 2: 
          localasc.ndI = locala.LVo.xF();
          AppMethodBeat.o(123572);
          return 0;
        case 3: 
          localasc.DQO = locala.LVo.xF();
          AppMethodBeat.o(123572);
          return 0;
        }
        localasc.ELJ = locala.LVo.xF();
        AppMethodBeat.o(123572);
        return 0;
      }
      AppMethodBeat.o(123572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asc
 * JD-Core Version:    0.7.0.1
 */