package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfn
  extends com.tencent.mm.bx.a
{
  public int ZPu;
  public int ZPv;
  public int ZPw;
  public String background_color;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258352);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bS(2, this.ZPu);
      paramVarArgs.bS(3, this.ZPv);
      if (this.background_color != null) {
        paramVarArgs.g(4, this.background_color);
      }
      paramVarArgs.bS(5, this.ZPw);
      AppMethodBeat.o(258352);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZPu) + i.a.a.b.b.a.cJ(3, this.ZPv);
      paramInt = i;
      if (this.background_color != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.background_color);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZPw);
      AppMethodBeat.o(258352);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258352);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bfn localbfn = (bfn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258352);
          return -1;
        case 1: 
          localbfn.id = locala.ajGk.readString();
          AppMethodBeat.o(258352);
          return 0;
        case 2: 
          localbfn.ZPu = locala.ajGk.aar();
          AppMethodBeat.o(258352);
          return 0;
        case 3: 
          localbfn.ZPv = locala.ajGk.aar();
          AppMethodBeat.o(258352);
          return 0;
        case 4: 
          localbfn.background_color = locala.ajGk.readString();
          AppMethodBeat.o(258352);
          return 0;
        }
        localbfn.ZPw = locala.ajGk.aar();
        AppMethodBeat.o(258352);
        return 0;
      }
      AppMethodBeat.o(258352);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfn
 * JD-Core Version:    0.7.0.1
 */