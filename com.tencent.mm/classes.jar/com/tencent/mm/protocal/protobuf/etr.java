package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class etr
  extends com.tencent.mm.bx.a
{
  public String aawr;
  public String abmy;
  public String abmz;
  public int vgN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91678);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aawr != null) {
        paramVarArgs.g(1, this.aawr);
      }
      if (this.abmz != null) {
        paramVarArgs.g(2, this.abmz);
      }
      paramVarArgs.bS(3, this.vgN);
      if (this.abmy != null) {
        paramVarArgs.g(4, this.abmy);
      }
      AppMethodBeat.o(91678);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aawr == null) {
        break label374;
      }
    }
    label374:
    for (paramInt = i.a.a.b.b.a.h(1, this.aawr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abmz != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abmz);
      }
      i += i.a.a.b.b.a.cJ(3, this.vgN);
      paramInt = i;
      if (this.abmy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abmy);
      }
      AppMethodBeat.o(91678);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91678);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        etr localetr = (etr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91678);
          return -1;
        case 1: 
          localetr.aawr = locala.ajGk.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 2: 
          localetr.abmz = locala.ajGk.readString();
          AppMethodBeat.o(91678);
          return 0;
        case 3: 
          localetr.vgN = locala.ajGk.aar();
          AppMethodBeat.o(91678);
          return 0;
        }
        localetr.abmy = locala.ajGk.readString();
        AppMethodBeat.o(91678);
        return 0;
      }
      AppMethodBeat.o(91678);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.etr
 * JD-Core Version:    0.7.0.1
 */