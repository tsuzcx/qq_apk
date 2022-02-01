package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String aciT;
  public String aciU;
  public String aciV;
  public LinkedList<String> aciW;
  
  public d()
  {
    AppMethodBeat.i(259691);
    this.aciW = new LinkedList();
    AppMethodBeat.o(259691);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259698);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aciT != null) {
        paramVarArgs.g(1, this.aciT);
      }
      if (this.aciU != null) {
        paramVarArgs.g(2, this.aciU);
      }
      if (this.aciV != null) {
        paramVarArgs.g(3, this.aciV);
      }
      paramVarArgs.e(4, 1, this.aciW);
      AppMethodBeat.o(259698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aciT == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.aciT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aciU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aciU);
      }
      i = paramInt;
      if (this.aciV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aciV);
      }
      paramInt = i.a.a.a.c(4, 1, this.aciW);
      AppMethodBeat.o(259698);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aciW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259698);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259698);
          return -1;
        case 1: 
          locald.aciT = locala.ajGk.readString();
          AppMethodBeat.o(259698);
          return 0;
        case 2: 
          locald.aciU = locala.ajGk.readString();
          AppMethodBeat.o(259698);
          return 0;
        case 3: 
          locald.aciV = locala.ajGk.readString();
          AppMethodBeat.o(259698);
          return 0;
        }
        locald.aciW.add(locala.ajGk.readString());
        AppMethodBeat.o(259698);
        return 0;
      }
      AppMethodBeat.o(259698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.d
 * JD-Core Version:    0.7.0.1
 */