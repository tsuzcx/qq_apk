package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class ai
  extends com.tencent.mm.bx.a
{
  public long Bjl;
  public String name;
  public String path;
  public long size;
  public int state;
  public String svrId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122801);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(122801);
        throw paramVarArgs;
      }
      if (this.name == null)
      {
        paramVarArgs = new b("Not all required fields were included: name");
        AppMethodBeat.o(122801);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.g(1, this.path);
      }
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.bv(3, this.size);
      paramVarArgs.bS(4, this.state);
      paramVarArgs.bv(5, this.Bjl);
      if (this.svrId != null) {
        paramVarArgs.g(6, this.svrId);
      }
      AppMethodBeat.o(122801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.b.b.a.h(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.name);
      }
      i = i + i.a.a.b.b.a.q(3, this.size) + i.a.a.b.b.a.cJ(4, this.state) + i.a.a.b.b.a.q(5, this.Bjl);
      paramInt = i;
      if (this.svrId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.svrId);
      }
      AppMethodBeat.o(122801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(122801);
          throw paramVarArgs;
        }
        if (this.name == null)
        {
          paramVarArgs = new b("Not all required fields were included: name");
          AppMethodBeat.o(122801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122801);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122801);
          return -1;
        case 1: 
          localai.path = locala.ajGk.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 2: 
          localai.name = locala.ajGk.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 3: 
          localai.size = locala.ajGk.aaw();
          AppMethodBeat.o(122801);
          return 0;
        case 4: 
          localai.state = locala.ajGk.aar();
          AppMethodBeat.o(122801);
          return 0;
        case 5: 
          localai.Bjl = locala.ajGk.aaw();
          AppMethodBeat.o(122801);
          return 0;
        }
        localai.svrId = locala.ajGk.readString();
        AppMethodBeat.o(122801);
        return 0;
      }
      AppMethodBeat.o(122801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ai
 * JD-Core Version:    0.7.0.1
 */