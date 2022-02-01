package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class rr
  extends com.tencent.mm.cd.a
{
  public int SaA;
  public String SaB;
  public int SaC;
  public String Say;
  public String Saz;
  public String Url;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fwr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Say == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Saz == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.fwr != null) {
        paramVarArgs.f(1, this.fwr);
      }
      if (this.Url != null) {
        paramVarArgs.f(2, this.Url);
      }
      if (this.Say != null) {
        paramVarArgs.f(3, this.Say);
      }
      if (this.Saz != null) {
        paramVarArgs.f(4, this.Saz);
      }
      paramVarArgs.aY(5, this.SaA);
      if (this.SaB != null) {
        paramVarArgs.f(6, this.SaB);
      }
      paramVarArgs.aY(7, this.SaC);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fwr == null) {
        break label738;
      }
    }
    label738:
    for (int i = g.a.a.b.b.a.g(1, this.fwr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Url);
      }
      i = paramInt;
      if (this.Say != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Say);
      }
      paramInt = i;
      if (this.Saz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Saz);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SaA);
      paramInt = i;
      if (this.SaB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SaB);
      }
      i = g.a.a.b.b.a.bM(7, this.SaC);
      AppMethodBeat.o(117846);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fwr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Say == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Saz == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117846);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        rr localrr = (rr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localrr.fwr = locala.abFh.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localrr.Url = locala.abFh.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localrr.Say = locala.abFh.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localrr.Saz = locala.abFh.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localrr.SaA = locala.abFh.AK();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localrr.SaB = locala.abFh.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localrr.SaC = locala.abFh.AK();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rr
 * JD-Core Version:    0.7.0.1
 */