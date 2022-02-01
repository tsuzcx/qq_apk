package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aho
  extends com.tencent.mm.bx.a
{
  public int ZqC;
  public String ZqD;
  public String ZqE;
  public boolean enable;
  public String rDm;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259252);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.enable);
      paramVarArgs.bS(2, this.ZqC);
      if (this.rDm != null) {
        paramVarArgs.g(3, this.rDm);
      }
      if (this.ZqD != null) {
        paramVarArgs.g(4, this.ZqD);
      }
      if (this.ZqE != null) {
        paramVarArgs.g(5, this.ZqE);
      }
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      AppMethodBeat.o(259252);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0 + i.a.a.b.b.a.cJ(2, this.ZqC);
      paramInt = i;
      if (this.rDm != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.rDm);
      }
      i = paramInt;
      if (this.ZqD != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZqD);
      }
      paramInt = i;
      if (this.ZqE != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZqE);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.title);
      }
      AppMethodBeat.o(259252);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259252);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aho localaho = (aho)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259252);
        return -1;
      case 1: 
        localaho.enable = locala.ajGk.aai();
        AppMethodBeat.o(259252);
        return 0;
      case 2: 
        localaho.ZqC = locala.ajGk.aar();
        AppMethodBeat.o(259252);
        return 0;
      case 3: 
        localaho.rDm = locala.ajGk.readString();
        AppMethodBeat.o(259252);
        return 0;
      case 4: 
        localaho.ZqD = locala.ajGk.readString();
        AppMethodBeat.o(259252);
        return 0;
      case 5: 
        localaho.ZqE = locala.ajGk.readString();
        AppMethodBeat.o(259252);
        return 0;
      }
      localaho.title = locala.ajGk.readString();
      AppMethodBeat.o(259252);
      return 0;
    }
    AppMethodBeat.o(259252);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aho
 * JD-Core Version:    0.7.0.1
 */