package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fkd
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String MD5;
  public String SaD;
  public String Ueg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32556);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.SaD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32556);
        throw paramVarArgs;
      }
      if (this.Ueg != null) {
        paramVarArgs.f(1, this.Ueg);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(2, this.MD5);
      }
      if (this.SaD != null) {
        paramVarArgs.f(3, this.SaD);
      }
      paramVarArgs.aY(4, this.CPw);
      AppMethodBeat.o(32556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ueg == null) {
        break label540;
      }
    }
    label540:
    for (int i = g.a.a.b.b.a.g(1, this.Ueg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.MD5);
      }
      i = paramInt;
      if (this.SaD != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SaD);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.CPw);
      AppMethodBeat.o(32556);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Ueg == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        if (this.SaD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32556);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32556);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fkd localfkd = (fkd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32556);
          return -1;
        case 1: 
          localfkd.Ueg = locala.abFh.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 2: 
          localfkd.MD5 = locala.abFh.readString();
          AppMethodBeat.o(32556);
          return 0;
        case 3: 
          localfkd.SaD = locala.abFh.readString();
          AppMethodBeat.o(32556);
          return 0;
        }
        localfkd.CPw = locala.abFh.AK();
        AppMethodBeat.o(32556);
        return 0;
      }
      AppMethodBeat.o(32556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkd
 * JD-Core Version:    0.7.0.1
 */