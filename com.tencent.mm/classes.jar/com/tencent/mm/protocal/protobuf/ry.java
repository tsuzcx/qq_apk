package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ry
  extends com.tencent.mm.bw.a
{
  public String KZp;
  public String KZq;
  public int KZr;
  public String KZs;
  public int KZt;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
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
      if (this.KZp == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.KZq == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      if (this.KZp != null) {
        paramVarArgs.e(3, this.KZp);
      }
      if (this.KZq != null) {
        paramVarArgs.e(4, this.KZq);
      }
      paramVarArgs.aM(5, this.KZr);
      if (this.KZs != null) {
        paramVarArgs.e(6, this.KZs);
      }
      paramVarArgs.aM(7, this.KZt);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label738;
      }
    }
    label738:
    for (int i = g.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt;
      if (this.KZp != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KZp);
      }
      paramInt = i;
      if (this.KZq != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KZq);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KZr);
      paramInt = i;
      if (this.KZs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KZs);
      }
      i = g.a.a.b.b.a.bu(7, this.KZt);
      AppMethodBeat.o(117846);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Title == null)
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
        if (this.KZp == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.KZq == null)
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
        ry localry = (ry)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localry.Title = locala.UbS.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localry.Url = locala.UbS.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localry.KZp = locala.UbS.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localry.KZq = locala.UbS.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localry.KZr = locala.UbS.zi();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localry.KZs = locala.UbS.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localry.KZt = locala.UbS.zi();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ry
 * JD-Core Version:    0.7.0.1
 */