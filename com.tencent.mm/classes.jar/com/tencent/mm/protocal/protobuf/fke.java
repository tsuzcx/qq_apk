package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class fke
  extends com.tencent.mm.cd.a
{
  public int CPw;
  public String MD5;
  public String RUd;
  public String SaD;
  public String Ueg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32557);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ueg == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.RUd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Text");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.MD5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: MD5");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.SaD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(32557);
        throw paramVarArgs;
      }
      if (this.Ueg != null) {
        paramVarArgs.f(1, this.Ueg);
      }
      if (this.RUd != null) {
        paramVarArgs.f(2, this.RUd);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(3, this.MD5);
      }
      if (this.SaD != null) {
        paramVarArgs.f(4, this.SaD);
      }
      paramVarArgs.aY(5, this.CPw);
      AppMethodBeat.o(32557);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ueg == null) {
        break label649;
      }
    }
    label649:
    for (int i = g.a.a.b.b.a.g(1, this.Ueg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RUd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RUd);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MD5);
      }
      paramInt = i;
      if (this.SaD != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SaD);
      }
      i = g.a.a.b.b.a.bM(5, this.CPw);
      AppMethodBeat.o(32557);
      return paramInt + i;
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
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.RUd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Text");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.MD5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: MD5");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        if (this.SaD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(32557);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32557);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        fke localfke = (fke)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32557);
          return -1;
        case 1: 
          localfke.Ueg = locala.abFh.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 2: 
          localfke.RUd = locala.abFh.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 3: 
          localfke.MD5 = locala.abFh.readString();
          AppMethodBeat.o(32557);
          return 0;
        case 4: 
          localfke.SaD = locala.abFh.readString();
          AppMethodBeat.o(32557);
          return 0;
        }
        localfke.CPw = locala.abFh.AK();
        AppMethodBeat.o(32557);
        return 0;
      }
      AppMethodBeat.o(32557);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fke
 * JD-Core Version:    0.7.0.1
 */