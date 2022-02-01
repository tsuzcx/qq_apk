package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdo
  extends com.tencent.mm.bw.a
{
  public String Hqx;
  public String Hqy;
  public String Hqz;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218183);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hqx != null) {
        paramVarArgs.d(1, this.Hqx);
      }
      if (this.Hqy != null) {
        paramVarArgs.d(2, this.Hqy);
      }
      if (this.Hqz != null) {
        paramVarArgs.d(3, this.Hqz);
      }
      paramVarArgs.aS(4, this.action);
      AppMethodBeat.o(218183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hqx == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Hqx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hqy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hqy);
      }
      i = paramInt;
      if (this.Hqz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hqz);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.action);
      AppMethodBeat.o(218183);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218183);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdo localcdo = (cdo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(218183);
          return -1;
        case 1: 
          localcdo.Hqx = locala.OmT.readString();
          AppMethodBeat.o(218183);
          return 0;
        case 2: 
          localcdo.Hqy = locala.OmT.readString();
          AppMethodBeat.o(218183);
          return 0;
        case 3: 
          localcdo.Hqz = locala.OmT.readString();
          AppMethodBeat.o(218183);
          return 0;
        }
        localcdo.action = locala.OmT.zc();
        AppMethodBeat.o(218183);
        return 0;
      }
      AppMethodBeat.o(218183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdo
 * JD-Core Version:    0.7.0.1
 */