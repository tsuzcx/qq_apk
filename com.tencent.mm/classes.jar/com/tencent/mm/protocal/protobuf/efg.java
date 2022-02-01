package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class efg
  extends com.tencent.mm.bx.a
{
  public String OkP;
  public int action;
  public String url;
  public String username;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259654);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wording != null) {
        paramVarArgs.g(1, this.wording);
      }
      paramVarArgs.bS(2, this.action);
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      if (this.username != null) {
        paramVarArgs.g(4, this.username);
      }
      if (this.OkP != null) {
        paramVarArgs.g(5, this.OkP);
      }
      AppMethodBeat.o(259654);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.action);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.username);
      }
      paramInt = i;
      if (this.OkP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.OkP);
      }
      AppMethodBeat.o(259654);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259654);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        efg localefg = (efg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259654);
          return -1;
        case 1: 
          localefg.wording = locala.ajGk.readString();
          AppMethodBeat.o(259654);
          return 0;
        case 2: 
          localefg.action = locala.ajGk.aar();
          AppMethodBeat.o(259654);
          return 0;
        case 3: 
          localefg.url = locala.ajGk.readString();
          AppMethodBeat.o(259654);
          return 0;
        case 4: 
          localefg.username = locala.ajGk.readString();
          AppMethodBeat.o(259654);
          return 0;
        }
        localefg.OkP = locala.ajGk.readString();
        AppMethodBeat.o(259654);
        return 0;
      }
      AppMethodBeat.o(259654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efg
 * JD-Core Version:    0.7.0.1
 */