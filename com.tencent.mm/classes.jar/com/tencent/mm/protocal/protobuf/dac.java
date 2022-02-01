package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dac
  extends com.tencent.mm.bx.a
{
  public String Krl;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259935);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.Krl != null) {
        paramVarArgs.g(3, this.Krl);
      }
      AppMethodBeat.o(259935);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.Krl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Krl);
      }
      AppMethodBeat.o(259935);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259935);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dac localdac = (dac)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259935);
          return -1;
        case 1: 
          localdac.title = locala.ajGk.readString();
          AppMethodBeat.o(259935);
          return 0;
        case 2: 
          localdac.desc = locala.ajGk.readString();
          AppMethodBeat.o(259935);
          return 0;
        }
        localdac.Krl = locala.ajGk.readString();
        AppMethodBeat.o(259935);
        return 0;
      }
      AppMethodBeat.o(259935);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dac
 * JD-Core Version:    0.7.0.1
 */