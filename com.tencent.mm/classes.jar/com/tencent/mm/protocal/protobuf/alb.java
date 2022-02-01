package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alb
  extends com.tencent.mm.bx.a
{
  public String DlE;
  public float dpb;
  public float dqQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DlE != null) {
        paramVarArgs.d(1, this.DlE);
      }
      paramVarArgs.x(2, this.dqQ);
      paramVarArgs.x(3, this.dpb);
      AppMethodBeat.o(164044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DlE == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = f.a.a.b.b.a.e(1, this.DlE) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      AppMethodBeat.o(164044);
      return paramInt + (i + 4) + (j + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(164044);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        alb localalb = (alb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(164044);
          return -1;
        case 1: 
          localalb.DlE = locala.KhF.readString();
          AppMethodBeat.o(164044);
          return 0;
        case 2: 
          localalb.dqQ = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(164044);
          return 0;
        }
        localalb.dpb = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(164044);
        return 0;
      }
      AppMethodBeat.o(164044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alb
 * JD-Core Version:    0.7.0.1
 */