package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akf
  extends com.tencent.mm.bx.a
{
  public String Zrs;
  public String Zrt;
  public String model;
  public String rig;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258390);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.rig != null) {
        paramVarArgs.g(1, this.rig);
      }
      if (this.model != null) {
        paramVarArgs.g(2, this.model);
      }
      if (this.Zrs != null) {
        paramVarArgs.g(3, this.Zrs);
      }
      if (this.Zrt != null) {
        paramVarArgs.g(4, this.Zrt);
      }
      AppMethodBeat.o(258390);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rig == null) {
        break label390;
      }
    }
    label390:
    for (int i = i.a.a.b.b.a.h(1, this.rig) + 0;; i = 0)
    {
      paramInt = i;
      if (this.model != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.model);
      }
      i = paramInt;
      if (this.Zrs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zrs);
      }
      paramInt = i;
      if (this.Zrt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zrt);
      }
      AppMethodBeat.o(258390);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258390);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        akf localakf = (akf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258390);
          return -1;
        case 1: 
          localakf.rig = locala.ajGk.readString();
          AppMethodBeat.o(258390);
          return 0;
        case 2: 
          localakf.model = locala.ajGk.readString();
          AppMethodBeat.o(258390);
          return 0;
        case 3: 
          localakf.Zrs = locala.ajGk.readString();
          AppMethodBeat.o(258390);
          return 0;
        }
        localakf.Zrt = locala.ajGk.readString();
        AppMethodBeat.o(258390);
        return 0;
      }
      AppMethodBeat.o(258390);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akf
 * JD-Core Version:    0.7.0.1
 */