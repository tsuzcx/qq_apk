package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eoe
  extends com.tencent.mm.bx.a
{
  public int number;
  public String type;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72576);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.type != null) {
        paramVarArgs.g(1, this.type);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.bS(3, this.number);
      AppMethodBeat.o(72576);
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wording);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.number);
      AppMethodBeat.o(72576);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72576);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eoe localeoe = (eoe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72576);
          return -1;
        case 1: 
          localeoe.type = locala.ajGk.readString();
          AppMethodBeat.o(72576);
          return 0;
        case 2: 
          localeoe.wording = locala.ajGk.readString();
          AppMethodBeat.o(72576);
          return 0;
        }
        localeoe.number = locala.ajGk.aar();
        AppMethodBeat.o(72576);
        return 0;
      }
      AppMethodBeat.o(72576);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoe
 * JD-Core Version:    0.7.0.1
 */