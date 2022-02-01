package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class aj
  extends com.tencent.mm.bw.a
{
  public String name;
  public String path;
  public long size;
  public int state;
  public String svrId;
  public long ulj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122801);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
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
        paramVarArgs.e(1, this.path);
      }
      if (this.name != null) {
        paramVarArgs.e(2, this.name);
      }
      paramVarArgs.bb(3, this.size);
      paramVarArgs.aM(4, this.state);
      paramVarArgs.bb(5, this.ulj);
      if (this.svrId != null) {
        paramVarArgs.e(6, this.svrId);
      }
      AppMethodBeat.o(122801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.name);
      }
      i = i + g.a.a.b.b.a.r(3, this.size) + g.a.a.b.b.a.bu(4, this.state) + g.a.a.b.b.a.r(5, this.ulj);
      paramInt = i;
      if (this.svrId != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.svrId);
      }
      AppMethodBeat.o(122801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122801);
          return -1;
        case 1: 
          localaj.path = locala.UbS.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 2: 
          localaj.name = locala.UbS.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 3: 
          localaj.size = locala.UbS.zl();
          AppMethodBeat.o(122801);
          return 0;
        case 4: 
          localaj.state = locala.UbS.zi();
          AppMethodBeat.o(122801);
          return 0;
        case 5: 
          localaj.ulj = locala.UbS.zl();
          AppMethodBeat.o(122801);
          return 0;
        }
        localaj.svrId = locala.UbS.readString();
        AppMethodBeat.o(122801);
        return 0;
      }
      AppMethodBeat.o(122801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.aj
 * JD-Core Version:    0.7.0.1
 */