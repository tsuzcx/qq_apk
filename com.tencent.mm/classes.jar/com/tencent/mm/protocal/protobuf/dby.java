package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dby
  extends com.tencent.mm.bx.a
{
  public String CAc;
  public String gGR;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124569);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CAc != null) {
        paramVarArgs.d(1, this.CAc);
      }
      if (this.gGR != null) {
        paramVarArgs.d(2, this.gGR);
      }
      paramVarArgs.aR(3, this.weight);
      AppMethodBeat.o(124569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CAc == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.CAc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.gGR != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.gGR);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.weight);
      AppMethodBeat.o(124569);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124569);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dby localdby = (dby)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124569);
          return -1;
        case 1: 
          localdby.CAc = locala.KhF.readString();
          AppMethodBeat.o(124569);
          return 0;
        case 2: 
          localdby.gGR = locala.KhF.readString();
          AppMethodBeat.o(124569);
          return 0;
        }
        localdby.weight = locala.KhF.xS();
        AppMethodBeat.o(124569);
        return 0;
      }
      AppMethodBeat.o(124569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dby
 * JD-Core Version:    0.7.0.1
 */