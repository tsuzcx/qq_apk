package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dzl
  extends com.tencent.mm.bx.a
{
  public String ZTx;
  public String abeE;
  public String abeF;
  public String name;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257407);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      if (this.ZTx != null) {
        paramVarArgs.g(3, this.ZTx);
      }
      if (this.abeE != null) {
        paramVarArgs.g(4, this.abeE);
      }
      if (this.abeF != null) {
        paramVarArgs.g(5, this.abeF);
      }
      AppMethodBeat.o(257407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt;
      if (this.ZTx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZTx);
      }
      paramInt = i;
      if (this.abeE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abeE);
      }
      i = paramInt;
      if (this.abeF != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abeF);
      }
      AppMethodBeat.o(257407);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257407);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzl localdzl = (dzl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257407);
          return -1;
        case 1: 
          localdzl.title = locala.ajGk.readString();
          AppMethodBeat.o(257407);
          return 0;
        case 2: 
          localdzl.name = locala.ajGk.readString();
          AppMethodBeat.o(257407);
          return 0;
        case 3: 
          localdzl.ZTx = locala.ajGk.readString();
          AppMethodBeat.o(257407);
          return 0;
        case 4: 
          localdzl.abeE = locala.ajGk.readString();
          AppMethodBeat.o(257407);
          return 0;
        }
        localdzl.abeF = locala.ajGk.readString();
        AppMethodBeat.o(257407);
        return 0;
      }
      AppMethodBeat.o(257407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzl
 * JD-Core Version:    0.7.0.1
 */