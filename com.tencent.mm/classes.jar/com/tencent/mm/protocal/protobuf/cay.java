package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cay
  extends com.tencent.mm.bx.a
{
  public String Idi;
  public String aakb;
  public String aakc;
  public String aakd;
  public String description;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258493);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Idi != null) {
        paramVarArgs.g(1, this.Idi);
      }
      if (this.aakb != null) {
        paramVarArgs.g(2, this.aakb);
      }
      if (this.aakc != null) {
        paramVarArgs.g(3, this.aakc);
      }
      if (this.description != null) {
        paramVarArgs.g(4, this.description);
      }
      if (this.aakd != null) {
        paramVarArgs.g(5, this.aakd);
      }
      AppMethodBeat.o(258493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Idi == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.Idi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aakb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aakb);
      }
      i = paramInt;
      if (this.aakc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aakc);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.description);
      }
      i = paramInt;
      if (this.aakd != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aakd);
      }
      AppMethodBeat.o(258493);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258493);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cay localcay = (cay)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258493);
          return -1;
        case 1: 
          localcay.Idi = locala.ajGk.readString();
          AppMethodBeat.o(258493);
          return 0;
        case 2: 
          localcay.aakb = locala.ajGk.readString();
          AppMethodBeat.o(258493);
          return 0;
        case 3: 
          localcay.aakc = locala.ajGk.readString();
          AppMethodBeat.o(258493);
          return 0;
        case 4: 
          localcay.description = locala.ajGk.readString();
          AppMethodBeat.o(258493);
          return 0;
        }
        localcay.aakd = locala.ajGk.readString();
        AppMethodBeat.o(258493);
        return 0;
      }
      AppMethodBeat.o(258493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cay
 * JD-Core Version:    0.7.0.1
 */