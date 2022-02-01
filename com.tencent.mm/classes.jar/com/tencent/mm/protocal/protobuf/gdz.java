package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gdz
  extends com.tencent.mm.bx.a
{
  public String aakc;
  public String abQJ;
  public String acbF;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.aakc != null) {
        paramVarArgs.g(2, this.aakc);
      }
      if (this.abQJ != null) {
        paramVarArgs.g(3, this.abQJ);
      }
      if (this.acbF != null) {
        paramVarArgs.g(4, this.acbF);
      }
      AppMethodBeat.o(91726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aakc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aakc);
      }
      i = paramInt;
      if (this.abQJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abQJ);
      }
      paramInt = i;
      if (this.acbF != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.acbF);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gdz localgdz = (gdz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localgdz.title = locala.ajGk.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localgdz.aakc = locala.ajGk.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localgdz.abQJ = locala.ajGk.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localgdz.acbF = locala.ajGk.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdz
 * JD-Core Version:    0.7.0.1
 */