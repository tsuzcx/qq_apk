package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dew
  extends com.tencent.mm.bx.a
{
  public String Ewv;
  public String Eww;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125849);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ewv != null) {
        paramVarArgs.d(1, this.Ewv);
      }
      if (this.Eww != null) {
        paramVarArgs.d(2, this.Eww);
      }
      AppMethodBeat.o(125849);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ewv == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.Ewv) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eww != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eww);
      }
      AppMethodBeat.o(125849);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125849);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dew localdew = (dew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125849);
          return -1;
        case 1: 
          localdew.Ewv = locala.KhF.readString();
          AppMethodBeat.o(125849);
          return 0;
        }
        localdew.Eww = locala.KhF.readString();
        AppMethodBeat.o(125849);
        return 0;
      }
      AppMethodBeat.o(125849);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dew
 * JD-Core Version:    0.7.0.1
 */