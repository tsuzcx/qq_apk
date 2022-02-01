package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class akf
  extends com.tencent.mm.cd.a
{
  public String CRn;
  public String SuY;
  public String VHM;
  public String VHN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104779);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.CRn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Label");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.VHM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Number");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.SuY == null)
      {
        paramVarArgs = new b("Not all required fields were included: Type");
        AppMethodBeat.o(104779);
        throw paramVarArgs;
      }
      if (this.CRn != null) {
        paramVarArgs.f(1, this.CRn);
      }
      if (this.VHM != null) {
        paramVarArgs.f(2, this.VHM);
      }
      if (this.SuY != null) {
        paramVarArgs.f(3, this.SuY);
      }
      if (this.VHN != null) {
        paramVarArgs.f(4, this.VHN);
      }
      AppMethodBeat.o(104779);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CRn == null) {
        break label538;
      }
    }
    label538:
    for (int i = g.a.a.b.b.a.g(1, this.CRn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.VHM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.VHM);
      }
      i = paramInt;
      if (this.SuY != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SuY);
      }
      paramInt = i;
      if (this.VHN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.VHN);
      }
      AppMethodBeat.o(104779);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.CRn == null)
        {
          paramVarArgs = new b("Not all required fields were included: Label");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        if (this.VHM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Number");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        if (this.SuY == null)
        {
          paramVarArgs = new b("Not all required fields were included: Type");
          AppMethodBeat.o(104779);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104779);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        akf localakf = (akf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104779);
          return -1;
        case 1: 
          localakf.CRn = locala.abFh.readString();
          AppMethodBeat.o(104779);
          return 0;
        case 2: 
          localakf.VHM = locala.abFh.readString();
          AppMethodBeat.o(104779);
          return 0;
        case 3: 
          localakf.SuY = locala.abFh.readString();
          AppMethodBeat.o(104779);
          return 0;
        }
        localakf.VHN = locala.abFh.readString();
        AppMethodBeat.o(104779);
        return 0;
      }
      AppMethodBeat.o(104779);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akf
 * JD-Core Version:    0.7.0.1
 */