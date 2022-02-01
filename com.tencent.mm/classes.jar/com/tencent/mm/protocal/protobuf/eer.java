package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class eer
  extends com.tencent.mm.bx.a
{
  public int aahn;
  public int aaho;
  public int abkh;
  public int abki;
  public int abkj;
  public String abkk;
  public String abkl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259828);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abkh);
      paramVarArgs.bS(2, this.abki);
      paramVarArgs.bS(3, this.abkj);
      paramVarArgs.bS(4, this.aahn);
      paramVarArgs.bS(5, this.aaho);
      if (this.abkk != null) {
        paramVarArgs.g(6, this.abkk);
      }
      if (this.abkl != null) {
        paramVarArgs.g(7, this.abkl);
      }
      AppMethodBeat.o(259828);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abkh) + 0 + i.a.a.b.b.a.cJ(2, this.abki) + i.a.a.b.b.a.cJ(3, this.abkj) + i.a.a.b.b.a.cJ(4, this.aahn) + i.a.a.b.b.a.cJ(5, this.aaho);
      paramInt = i;
      if (this.abkk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abkk);
      }
      i = paramInt;
      if (this.abkl != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abkl);
      }
      AppMethodBeat.o(259828);
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
      AppMethodBeat.o(259828);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eer localeer = (eer)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259828);
        return -1;
      case 1: 
        localeer.abkh = locala.ajGk.aar();
        AppMethodBeat.o(259828);
        return 0;
      case 2: 
        localeer.abki = locala.ajGk.aar();
        AppMethodBeat.o(259828);
        return 0;
      case 3: 
        localeer.abkj = locala.ajGk.aar();
        AppMethodBeat.o(259828);
        return 0;
      case 4: 
        localeer.aahn = locala.ajGk.aar();
        AppMethodBeat.o(259828);
        return 0;
      case 5: 
        localeer.aaho = locala.ajGk.aar();
        AppMethodBeat.o(259828);
        return 0;
      case 6: 
        localeer.abkk = locala.ajGk.readString();
        AppMethodBeat.o(259828);
        return 0;
      }
      localeer.abkl = locala.ajGk.readString();
      AppMethodBeat.o(259828);
      return 0;
    }
    AppMethodBeat.o(259828);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eer
 * JD-Core Version:    0.7.0.1
 */