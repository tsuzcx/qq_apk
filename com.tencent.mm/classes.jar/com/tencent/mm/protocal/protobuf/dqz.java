package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqz
  extends com.tencent.mm.bw.a
{
  public String HXY;
  public String HXZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125849);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HXY != null) {
        paramVarArgs.d(1, this.HXY);
      }
      if (this.HXZ != null) {
        paramVarArgs.d(2, this.HXZ);
      }
      AppMethodBeat.o(125849);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HXY == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.HXY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HXZ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HXZ);
      }
      AppMethodBeat.o(125849);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125849);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dqz localdqz = (dqz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125849);
          return -1;
        case 1: 
          localdqz.HXY = locala.OmT.readString();
          AppMethodBeat.o(125849);
          return 0;
        }
        localdqz.HXZ = locala.OmT.readString();
        AppMethodBeat.o(125849);
        return 0;
      }
      AppMethodBeat.o(125849);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqz
 * JD-Core Version:    0.7.0.1
 */