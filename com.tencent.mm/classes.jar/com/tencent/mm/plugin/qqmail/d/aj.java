package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class aj
  extends com.tencent.mm.bw.a
{
  public String name;
  public String path;
  public long size;
  public int state;
  public String uPr;
  public long xsF;
  
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
      paramVarArgs.aZ(3, this.size);
      paramVarArgs.aS(4, this.state);
      paramVarArgs.aZ(5, this.xsF);
      if (this.uPr != null) {
        paramVarArgs.d(6, this.uPr);
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
      i = i + f.a.a.b.b.a.p(3, this.size) + f.a.a.b.b.a.bz(4, this.state) + f.a.a.b.b.a.p(5, this.xsF);
      paramInt = i;
      if (this.uPr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uPr);
      }
      AppMethodBeat.o(122801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          localaj.path = locala.OmT.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 2: 
          localaj.name = locala.OmT.readString();
          AppMethodBeat.o(122801);
          return 0;
        case 3: 
          localaj.size = locala.OmT.zd();
          AppMethodBeat.o(122801);
          return 0;
        case 4: 
          localaj.state = locala.OmT.zc();
          AppMethodBeat.o(122801);
          return 0;
        case 5: 
          localaj.xsF = locala.OmT.zd();
          AppMethodBeat.o(122801);
          return 0;
        }
        localaj.uPr = locala.OmT.readString();
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