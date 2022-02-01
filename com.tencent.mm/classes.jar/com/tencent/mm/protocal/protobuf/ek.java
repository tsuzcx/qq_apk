package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ek
  extends com.tencent.mm.bw.a
{
  public String DQV;
  public String DQW;
  public String DQX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125710);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DQV != null) {
        paramVarArgs.d(1, this.DQV);
      }
      if (this.DQW != null) {
        paramVarArgs.d(2, this.DQW);
      }
      if (this.DQX != null) {
        paramVarArgs.d(3, this.DQX);
      }
      AppMethodBeat.o(125710);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DQV == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.DQV) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DQW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DQW);
      }
      i = paramInt;
      if (this.DQX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DQX);
      }
      AppMethodBeat.o(125710);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125710);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ek localek = (ek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125710);
          return -1;
        case 1: 
          localek.DQV = locala.LVo.readString();
          AppMethodBeat.o(125710);
          return 0;
        case 2: 
          localek.DQW = locala.LVo.readString();
          AppMethodBeat.o(125710);
          return 0;
        }
        localek.DQX = locala.LVo.readString();
        AppMethodBeat.o(125710);
        return 0;
      }
      AppMethodBeat.o(125710);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ek
 * JD-Core Version:    0.7.0.1
 */