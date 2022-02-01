package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmi
  extends com.tencent.mm.bw.a
{
  public String ddJ;
  public String djF;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djF != null) {
        paramVarArgs.d(1, this.djF);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(2, this.ddJ);
      }
      paramVarArgs.aR(3, this.scene);
      AppMethodBeat.o(181514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djF == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.djF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ddJ != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ddJ);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.scene);
      AppMethodBeat.o(181514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(181514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dmi localdmi = (dmi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181514);
          return -1;
        case 1: 
          localdmi.djF = locala.LVo.readString();
          AppMethodBeat.o(181514);
          return 0;
        case 2: 
          localdmi.ddJ = locala.LVo.readString();
          AppMethodBeat.o(181514);
          return 0;
        }
        localdmi.scene = locala.LVo.xF();
        AppMethodBeat.o(181514);
        return 0;
      }
      AppMethodBeat.o(181514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmi
 * JD-Core Version:    0.7.0.1
 */