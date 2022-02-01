package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bc
  extends com.tencent.mm.bw.a
{
  public String KEq;
  public String KEr;
  public String KEs;
  public String jfi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125688);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jfi != null) {
        paramVarArgs.e(1, this.jfi);
      }
      if (this.KEq != null) {
        paramVarArgs.e(2, this.KEq);
      }
      if (this.KEr != null) {
        paramVarArgs.e(3, this.KEr);
      }
      if (this.KEs != null) {
        paramVarArgs.e(4, this.KEs);
      }
      AppMethodBeat.o(125688);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jfi == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.jfi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KEq != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KEq);
      }
      i = paramInt;
      if (this.KEr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KEr);
      }
      paramInt = i;
      if (this.KEs != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KEs);
      }
      AppMethodBeat.o(125688);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125688);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bc localbc = (bc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125688);
          return -1;
        case 1: 
          localbc.jfi = locala.UbS.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 2: 
          localbc.KEq = locala.UbS.readString();
          AppMethodBeat.o(125688);
          return 0;
        case 3: 
          localbc.KEr = locala.UbS.readString();
          AppMethodBeat.o(125688);
          return 0;
        }
        localbc.KEs = locala.UbS.readString();
        AppMethodBeat.o(125688);
        return 0;
      }
      AppMethodBeat.o(125688);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bc
 * JD-Core Version:    0.7.0.1
 */