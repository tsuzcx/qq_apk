package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ens
  extends com.tencent.mm.bx.a
{
  public String absh;
  public String absi;
  public String absj;
  public String background_color;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259743);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      if (this.absh != null) {
        paramVarArgs.g(2, this.absh);
      }
      if (this.background_color != null) {
        paramVarArgs.g(3, this.background_color);
      }
      if (this.absi != null) {
        paramVarArgs.g(4, this.absi);
      }
      if (this.absj != null) {
        paramVarArgs.g(5, this.absj);
      }
      AppMethodBeat.o(259743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.wording) + 0;; i = 0)
    {
      paramInt = i;
      if (this.absh != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.absh);
      }
      i = paramInt;
      if (this.background_color != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.background_color);
      }
      paramInt = i;
      if (this.absi != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.absi);
      }
      i = paramInt;
      if (this.absj != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.absj);
      }
      AppMethodBeat.o(259743);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259743);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ens localens = (ens)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259743);
          return -1;
        case 1: 
          localens.wording = locala.ajGk.readString();
          AppMethodBeat.o(259743);
          return 0;
        case 2: 
          localens.absh = locala.ajGk.readString();
          AppMethodBeat.o(259743);
          return 0;
        case 3: 
          localens.background_color = locala.ajGk.readString();
          AppMethodBeat.o(259743);
          return 0;
        case 4: 
          localens.absi = locala.ajGk.readString();
          AppMethodBeat.o(259743);
          return 0;
        }
        localens.absj = locala.ajGk.readString();
        AppMethodBeat.o(259743);
        return 0;
      }
      AppMethodBeat.o(259743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ens
 * JD-Core Version:    0.7.0.1
 */