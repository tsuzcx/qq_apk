package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aj
  extends com.tencent.mm.bw.a
{
  public String name;
  public String path;
  public long size;
  public int state;
  public String tBd;
  public long vVK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122801);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
        paramVarArgs.d(1, this.path);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.aO(3, this.size);
      paramVarArgs.aR(4, this.state);
      paramVarArgs.aO(5, this.vVK);
      if (this.tBd != null) {
        paramVarArgs.d(6, this.tBd);
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
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.name);
      }
      i = i + f.a.a.b.b.a.p(3, this.size) + f.a.a.b.b.a.bx(4, this.state) + f.a.a.b.b.a.p(5, this.vVK);
      paramInt = i;
      if (this.tBd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.tBd);
      }
      AppMethodBeat.o(122801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aj localaj = (aj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122801);
          return -1;
        case 1: 
          localaj.path = locala.LVo.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 2: 
          localaj.name = locala.LVo.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 3: 
          localaj.size = locala.LVo.xG();
          AppMethodBeat.o(122801);
          return 0;
        case 4: 
          localaj.state = locala.LVo.xF();
          AppMethodBeat.o(122801);
          return 0;
        case 5: 
          localaj.vVK = locala.LVo.xG();
          AppMethodBeat.o(122801);
          return 0;
        }
        localaj.tBd = locala.LVo.readString();
        AppMethodBeat.o(122801);
        return 0;
      }
      AppMethodBeat.o(122801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.aj
 * JD-Core Version:    0.7.0.1
 */