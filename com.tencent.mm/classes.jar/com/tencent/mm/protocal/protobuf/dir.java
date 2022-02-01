package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dir
  extends com.tencent.mm.bx.a
{
  public String aaNt;
  public int aaNu;
  public String content;
  public String lMk;
  public int msg_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260244);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaNt != null) {
        paramVarArgs.g(1, this.aaNt);
      }
      if (this.lMk != null) {
        paramVarArgs.g(2, this.lMk);
      }
      paramVarArgs.bS(3, this.msg_type);
      if (this.content != null) {
        paramVarArgs.g(4, this.content);
      }
      paramVarArgs.bS(5, this.aaNu);
      AppMethodBeat.o(260244);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaNt == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaNt) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.lMk != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.lMk);
      }
      i += i.a.a.b.b.a.cJ(3, this.msg_type);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.content);
      }
      i = i.a.a.b.b.a.cJ(5, this.aaNu);
      AppMethodBeat.o(260244);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260244);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dir localdir = (dir)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260244);
          return -1;
        case 1: 
          localdir.aaNt = locala.ajGk.readString();
          AppMethodBeat.o(260244);
          return 0;
        case 2: 
          localdir.lMk = locala.ajGk.readString();
          AppMethodBeat.o(260244);
          return 0;
        case 3: 
          localdir.msg_type = locala.ajGk.aar();
          AppMethodBeat.o(260244);
          return 0;
        case 4: 
          localdir.content = locala.ajGk.readString();
          AppMethodBeat.o(260244);
          return 0;
        }
        localdir.aaNu = locala.ajGk.aar();
        AppMethodBeat.o(260244);
        return 0;
      }
      AppMethodBeat.o(260244);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dir
 * JD-Core Version:    0.7.0.1
 */