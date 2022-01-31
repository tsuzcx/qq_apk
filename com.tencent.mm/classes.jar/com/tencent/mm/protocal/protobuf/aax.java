package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aax
  extends com.tencent.mm.bv.a
{
  public String wRk;
  public String wRv;
  public LinkedList<String> wRw;
  public boolean wRx;
  
  public aax()
  {
    AppMethodBeat.i(28399);
    this.wRw = new LinkedList();
    AppMethodBeat.o(28399);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28400);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wRk == null)
      {
        paramVarArgs = new b("Not all required fields were included: LoginUrl");
        AppMethodBeat.o(28400);
        throw paramVarArgs;
      }
      if (this.wRk != null) {
        paramVarArgs.e(1, this.wRk);
      }
      if (this.wRv != null) {
        paramVarArgs.e(2, this.wRv);
      }
      paramVarArgs.e(3, 1, this.wRw);
      paramVarArgs.aS(4, this.wRx);
      AppMethodBeat.o(28400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wRk == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = e.a.a.b.b.a.f(1, this.wRk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wRv != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wRv);
      }
      paramInt = e.a.a.a.c(3, 1, this.wRw);
      int j = e.a.a.b.b.a.eW(4);
      AppMethodBeat.o(28400);
      return i + paramInt + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wRw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wRk == null)
        {
          paramVarArgs = new b("Not all required fields were included: LoginUrl");
          AppMethodBeat.o(28400);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28400);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        aax localaax = (aax)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28400);
          return -1;
        case 1: 
          localaax.wRk = locala.CLY.readString();
          AppMethodBeat.o(28400);
          return 0;
        case 2: 
          localaax.wRv = locala.CLY.readString();
          AppMethodBeat.o(28400);
          return 0;
        case 3: 
          localaax.wRw.add(locala.CLY.readString());
          AppMethodBeat.o(28400);
          return 0;
        }
        localaax.wRx = locala.CLY.emu();
        AppMethodBeat.o(28400);
        return 0;
      }
      AppMethodBeat.o(28400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aax
 * JD-Core Version:    0.7.0.1
 */