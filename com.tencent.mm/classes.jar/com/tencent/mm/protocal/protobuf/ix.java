package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ix
  extends com.tencent.mm.cd.a
{
  public String ROL;
  public String ROM;
  public String RON;
  public String ROO;
  public String ROP;
  public String jump_url;
  public String ufC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124392);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROL != null) {
        paramVarArgs.f(1, this.ROL);
      }
      if (this.ROM != null) {
        paramVarArgs.f(2, this.ROM);
      }
      if (this.RON != null) {
        paramVarArgs.f(3, this.RON);
      }
      if (this.ufC != null) {
        paramVarArgs.f(4, this.ufC);
      }
      if (this.jump_url != null) {
        paramVarArgs.f(5, this.jump_url);
      }
      if (this.ROO != null) {
        paramVarArgs.f(6, this.ROO);
      }
      if (this.ROP != null) {
        paramVarArgs.f(7, this.ROP);
      }
      AppMethodBeat.o(124392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROL == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.b.b.a.g(1, this.ROL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ROM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ROM);
      }
      i = paramInt;
      if (this.RON != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RON);
      }
      paramInt = i;
      if (this.ufC != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ufC);
      }
      i = paramInt;
      if (this.jump_url != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jump_url);
      }
      paramInt = i;
      if (this.ROO != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.ROO);
      }
      i = paramInt;
      if (this.ROP != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.ROP);
      }
      AppMethodBeat.o(124392);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124392);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ix localix = (ix)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124392);
          return -1;
        case 1: 
          localix.ROL = locala.abFh.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 2: 
          localix.ROM = locala.abFh.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 3: 
          localix.RON = locala.abFh.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 4: 
          localix.ufC = locala.abFh.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 5: 
          localix.jump_url = locala.abFh.readString();
          AppMethodBeat.o(124392);
          return 0;
        case 6: 
          localix.ROO = locala.abFh.readString();
          AppMethodBeat.o(124392);
          return 0;
        }
        localix.ROP = locala.abFh.readString();
        AppMethodBeat.o(124392);
        return 0;
      }
      AppMethodBeat.o(124392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ix
 * JD-Core Version:    0.7.0.1
 */