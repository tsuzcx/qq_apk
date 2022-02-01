package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dkg
  extends com.tencent.mm.bx.a
{
  public String aaQn;
  public String aaQo;
  public int jump_type;
  public String ttL;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259568);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      paramVarArgs.bS(2, this.jump_type);
      if (this.ttL != null) {
        paramVarArgs.g(3, this.ttL);
      }
      if (this.aaQn != null) {
        paramVarArgs.g(4, this.aaQn);
      }
      if (this.aaQo != null) {
        paramVarArgs.g(5, this.aaQo);
      }
      AppMethodBeat.o(259568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wording == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.wording) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.jump_type);
      paramInt = i;
      if (this.ttL != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ttL);
      }
      i = paramInt;
      if (this.aaQn != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aaQn);
      }
      paramInt = i;
      if (this.aaQo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaQo);
      }
      AppMethodBeat.o(259568);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259568);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dkg localdkg = (dkg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259568);
          return -1;
        case 1: 
          localdkg.wording = locala.ajGk.readString();
          AppMethodBeat.o(259568);
          return 0;
        case 2: 
          localdkg.jump_type = locala.ajGk.aar();
          AppMethodBeat.o(259568);
          return 0;
        case 3: 
          localdkg.ttL = locala.ajGk.readString();
          AppMethodBeat.o(259568);
          return 0;
        case 4: 
          localdkg.aaQn = locala.ajGk.readString();
          AppMethodBeat.o(259568);
          return 0;
        }
        localdkg.aaQo = locala.ajGk.readString();
        AppMethodBeat.o(259568);
        return 0;
      }
      AppMethodBeat.o(259568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkg
 * JD-Core Version:    0.7.0.1
 */