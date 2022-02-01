package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class qv
  extends com.tencent.mm.bx.a
{
  public String FMA;
  public int FMB;
  public String FMC;
  public int FMD;
  public String FMz;
  public String Title;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
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
      if (this.FMz == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.FMA == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.FMz != null) {
        paramVarArgs.d(3, this.FMz);
      }
      if (this.FMA != null) {
        paramVarArgs.d(4, this.FMA);
      }
      paramVarArgs.aS(5, this.FMB);
      if (this.FMC != null) {
        paramVarArgs.d(6, this.FMC);
      }
      paramVarArgs.aS(7, this.FMD);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.FMz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FMz);
      }
      paramInt = i;
      if (this.FMA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FMA);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FMB);
      paramInt = i;
      if (this.FMC != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FMC);
      }
      i = f.a.a.b.b.a.bz(7, this.FMD);
      AppMethodBeat.o(117846);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
        if (this.FMz == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.FMA == null)
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        qv localqv = (qv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localqv.Title = locala.NPN.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localqv.Url = locala.NPN.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localqv.FMz = locala.NPN.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localqv.FMA = locala.NPN.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localqv.FMB = locala.NPN.zc();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localqv.FMC = locala.NPN.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localqv.FMD = locala.NPN.zc();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qv
 * JD-Core Version:    0.7.0.1
 */