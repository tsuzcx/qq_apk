package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class rs
  extends com.tencent.mm.cd.a
{
  public String GIM;
  public String SaD;
  public String SaE;
  public String SaF;
  public int SaG;
  public String SaH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SaD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.GIM == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.SaE == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.SaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.SaD != null) {
        paramVarArgs.f(1, this.SaD);
      }
      if (this.GIM != null) {
        paramVarArgs.f(2, this.GIM);
      }
      if (this.SaE != null) {
        paramVarArgs.f(3, this.SaE);
      }
      if (this.SaF != null) {
        paramVarArgs.f(4, this.SaF);
      }
      paramVarArgs.aY(5, this.SaG);
      if (this.SaH != null) {
        paramVarArgs.f(6, this.SaH);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SaD == null) {
        break label694;
      }
    }
    label694:
    for (int i = g.a.a.b.b.a.g(1, this.SaD) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GIM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.GIM);
      }
      i = paramInt;
      if (this.SaE != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SaE);
      }
      paramInt = i;
      if (this.SaF != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SaF);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SaG);
      paramInt = i;
      if (this.SaH != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SaH);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SaD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.GIM == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.SaE == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.SaF == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerUserName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117847);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        rs localrs = (rs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localrs.SaD = locala.abFh.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localrs.GIM = locala.abFh.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localrs.SaE = locala.abFh.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localrs.SaF = locala.abFh.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localrs.SaG = locala.abFh.AK();
          AppMethodBeat.o(117847);
          return 0;
        }
        localrs.SaH = locala.abFh.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rs
 * JD-Core Version:    0.7.0.1
 */