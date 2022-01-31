package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class ng
  extends com.tencent.mm.bv.a
{
  public String Title;
  public String Url;
  public String wCe;
  public String wCf;
  public int wCg;
  public String wCh;
  public int wCi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124298);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(124298);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(124298);
        throw paramVarArgs;
      }
      if (this.wCe == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(124298);
        throw paramVarArgs;
      }
      if (this.wCf == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(124298);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      if (this.wCe != null) {
        paramVarArgs.e(3, this.wCe);
      }
      if (this.wCf != null) {
        paramVarArgs.e(4, this.wCf);
      }
      paramVarArgs.aO(5, this.wCg);
      if (this.wCh != null) {
        paramVarArgs.e(6, this.wCh);
      }
      paramVarArgs.aO(7, this.wCi);
      AppMethodBeat.o(124298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label738;
      }
    }
    label738:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Url);
      }
      i = paramInt;
      if (this.wCe != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wCe);
      }
      paramInt = i;
      if (this.wCf != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wCf);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wCg);
      paramInt = i;
      if (this.wCh != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wCh);
      }
      i = e.a.a.b.b.a.bl(7, this.wCi);
      AppMethodBeat.o(124298);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.Title == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(124298);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(124298);
          throw paramVarArgs;
        }
        if (this.wCe == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(124298);
          throw paramVarArgs;
        }
        if (this.wCf == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(124298);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124298);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ng localng = (ng)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124298);
          return -1;
        case 1: 
          localng.Title = locala.CLY.readString();
          AppMethodBeat.o(124298);
          return 0;
        case 2: 
          localng.Url = locala.CLY.readString();
          AppMethodBeat.o(124298);
          return 0;
        case 3: 
          localng.wCe = locala.CLY.readString();
          AppMethodBeat.o(124298);
          return 0;
        case 4: 
          localng.wCf = locala.CLY.readString();
          AppMethodBeat.o(124298);
          return 0;
        case 5: 
          localng.wCg = locala.CLY.sl();
          AppMethodBeat.o(124298);
          return 0;
        case 6: 
          localng.wCh = locala.CLY.readString();
          AppMethodBeat.o(124298);
          return 0;
        }
        localng.wCi = locala.CLY.sl();
        AppMethodBeat.o(124298);
        return 0;
      }
      AppMethodBeat.o(124298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ng
 * JD-Core Version:    0.7.0.1
 */