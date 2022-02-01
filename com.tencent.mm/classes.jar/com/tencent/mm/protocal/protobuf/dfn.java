package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dfn
  extends com.tencent.mm.bx.a
{
  public int aaLm;
  public String mut;
  public String muu;
  public String muv;
  public String muw;
  public String mux;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116336);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mut != null) {
        paramVarArgs.g(1, this.mut);
      }
      if (this.muu != null) {
        paramVarArgs.g(2, this.muu);
      }
      if (this.muv != null) {
        paramVarArgs.g(3, this.muv);
      }
      if (this.muw != null) {
        paramVarArgs.g(4, this.muw);
      }
      if (this.mux != null) {
        paramVarArgs.g(5, this.mux);
      }
      paramVarArgs.bS(6, this.aaLm);
      AppMethodBeat.o(116336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mut == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.mut) + 0;; i = 0)
    {
      paramInt = i;
      if (this.muu != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.muu);
      }
      i = paramInt;
      if (this.muv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.muv);
      }
      paramInt = i;
      if (this.muw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.muw);
      }
      i = paramInt;
      if (this.mux != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mux);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.aaLm);
      AppMethodBeat.o(116336);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116336);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dfn localdfn = (dfn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116336);
          return -1;
        case 1: 
          localdfn.mut = locala.ajGk.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 2: 
          localdfn.muu = locala.ajGk.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 3: 
          localdfn.muv = locala.ajGk.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 4: 
          localdfn.muw = locala.ajGk.readString();
          AppMethodBeat.o(116336);
          return 0;
        case 5: 
          localdfn.mux = locala.ajGk.readString();
          AppMethodBeat.o(116336);
          return 0;
        }
        localdfn.aaLm = locala.ajGk.aar();
        AppMethodBeat.o(116336);
        return 0;
      }
      AppMethodBeat.o(116336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfn
 * JD-Core Version:    0.7.0.1
 */