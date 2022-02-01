package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehp
  extends com.tencent.mm.bx.a
{
  public String ZQe;
  public int abmK;
  public String url;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104374);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.ZQe != null) {
        paramVarArgs.g(3, this.ZQe);
      }
      paramVarArgs.bS(4, this.abmK);
      AppMethodBeat.o(104374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.ZQe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZQe);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.abmK);
      AppMethodBeat.o(104374);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104374);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ehp localehp = (ehp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104374);
          return -1;
        case 1: 
          localehp.wording = locala.ajGk.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 2: 
          localehp.url = locala.ajGk.readString();
          AppMethodBeat.o(104374);
          return 0;
        case 3: 
          localehp.ZQe = locala.ajGk.readString();
          AppMethodBeat.o(104374);
          return 0;
        }
        localehp.abmK = locala.ajGk.aar();
        AppMethodBeat.o(104374);
        return 0;
      }
      AppMethodBeat.o(104374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehp
 * JD-Core Version:    0.7.0.1
 */