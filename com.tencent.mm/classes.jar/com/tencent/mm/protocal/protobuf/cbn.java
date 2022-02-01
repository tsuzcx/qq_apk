package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cbn
  extends com.tencent.mm.bx.a
{
  public String IcT;
  public String ZCY;
  public String aakM;
  public String aakN;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258172);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.oOI != null) {
        paramVarArgs.g(1, this.oOI);
      }
      if (this.IcT != null) {
        paramVarArgs.g(2, this.IcT);
      }
      if (this.ZCY != null) {
        paramVarArgs.g(3, this.ZCY);
      }
      if (this.aakM != null) {
        paramVarArgs.g(4, this.aakM);
      }
      if (this.aakN != null) {
        paramVarArgs.g(5, this.aakN);
      }
      AppMethodBeat.o(258172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oOI == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.oOI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IcT != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IcT);
      }
      i = paramInt;
      if (this.ZCY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZCY);
      }
      paramInt = i;
      if (this.aakM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aakM);
      }
      i = paramInt;
      if (this.aakN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aakN);
      }
      AppMethodBeat.o(258172);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258172);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        cbn localcbn = (cbn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258172);
          return -1;
        case 1: 
          localcbn.oOI = locala.ajGk.readString();
          AppMethodBeat.o(258172);
          return 0;
        case 2: 
          localcbn.IcT = locala.ajGk.readString();
          AppMethodBeat.o(258172);
          return 0;
        case 3: 
          localcbn.ZCY = locala.ajGk.readString();
          AppMethodBeat.o(258172);
          return 0;
        case 4: 
          localcbn.aakM = locala.ajGk.readString();
          AppMethodBeat.o(258172);
          return 0;
        }
        localcbn.aakN = locala.ajGk.readString();
        AppMethodBeat.o(258172);
        return 0;
      }
      AppMethodBeat.o(258172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbn
 * JD-Core Version:    0.7.0.1
 */