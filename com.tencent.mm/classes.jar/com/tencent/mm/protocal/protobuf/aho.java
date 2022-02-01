package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aho
  extends com.tencent.mm.cd.a
{
  public String Ssk;
  public String Ssl;
  public String model;
  public String oeB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(256717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.oeB != null) {
        paramVarArgs.f(1, this.oeB);
      }
      if (this.model != null) {
        paramVarArgs.f(2, this.model);
      }
      if (this.Ssk != null) {
        paramVarArgs.f(3, this.Ssk);
      }
      if (this.Ssl != null) {
        paramVarArgs.f(4, this.Ssl);
      }
      AppMethodBeat.o(256717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oeB == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.g(1, this.oeB) + 0;; i = 0)
    {
      paramInt = i;
      if (this.model != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.model);
      }
      i = paramInt;
      if (this.Ssk != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ssk);
      }
      paramInt = i;
      if (this.Ssl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Ssl);
      }
      AppMethodBeat.o(256717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(256717);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aho localaho = (aho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(256717);
          return -1;
        case 1: 
          localaho.oeB = locala.abFh.readString();
          AppMethodBeat.o(256717);
          return 0;
        case 2: 
          localaho.model = locala.abFh.readString();
          AppMethodBeat.o(256717);
          return 0;
        case 3: 
          localaho.Ssk = locala.abFh.readString();
          AppMethodBeat.o(256717);
          return 0;
        }
        localaho.Ssl = locala.abFh.readString();
        AppMethodBeat.o(256717);
        return 0;
      }
      AppMethodBeat.o(256717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aho
 * JD-Core Version:    0.7.0.1
 */