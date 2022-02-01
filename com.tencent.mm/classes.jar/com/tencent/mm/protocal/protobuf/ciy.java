package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ciy
  extends com.tencent.mm.bx.a
{
  public String ILD;
  public String akkx;
  public String akky;
  public String crp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104779);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ILD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Label");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.akkx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Number");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.crp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Type");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.ILD != null) {
        paramVarArgs.g(1, this.ILD);
      }
      if (this.akkx != null) {
        paramVarArgs.g(2, this.akkx);
      }
      if (this.crp != null) {
        paramVarArgs.g(3, this.crp);
      }
      if (this.akky != null) {
        paramVarArgs.g(4, this.akky);
      }
      AppMethodBeat.o(104779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ILD == null) {
        break label534;
      }
    }
    label534:
    for (int i = i.a.a.b.b.a.h(1, this.ILD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.akkx != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.akkx);
      }
      i = paramInt;
      if (this.crp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.crp);
      }
      paramInt = i;
      if (this.akky != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.akky);
      }
      AppMethodBeat.o(104779);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ILD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Label");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        if (this.akkx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Number");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        if (this.crp == null)
        {
          paramVarArgs = new b("Not all required fields were included: Type");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104779);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ciy localciy = (ciy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104779);
          return -1;
        case 1: 
          localciy.ILD = locala.ajGk.readString();
          AppMethodBeat.o(104779);
          return 0;
        case 2: 
          localciy.akkx = locala.ajGk.readString();
          AppMethodBeat.o(104779);
          return 0;
        case 3: 
          localciy.crp = locala.ajGk.readString();
          AppMethodBeat.o(104779);
          return 0;
        }
        localciy.akky = locala.ajGk.readString();
        AppMethodBeat.o(104779);
        return 0;
      }
      AppMethodBeat.o(104779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciy
 * JD-Core Version:    0.7.0.1
 */