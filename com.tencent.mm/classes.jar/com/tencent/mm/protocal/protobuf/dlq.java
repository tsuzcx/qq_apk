package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlq
  extends com.tencent.mm.bw.a
{
  public String dQx;
  public int number;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72576);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.e(1, this.type);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      paramVarArgs.aM(3, this.number);
      AppMethodBeat.o(72576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dQx != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dQx);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.number);
      AppMethodBeat.o(72576);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72576);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dlq localdlq = (dlq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72576);
          return -1;
        case 1: 
          localdlq.type = locala.UbS.readString();
          AppMethodBeat.o(72576);
          return 0;
        case 2: 
          localdlq.dQx = locala.UbS.readString();
          AppMethodBeat.o(72576);
          return 0;
        }
        localdlq.number = locala.UbS.zi();
        AppMethodBeat.o(72576);
        return 0;
      }
      AppMethodBeat.o(72576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlq
 * JD-Core Version:    0.7.0.1
 */