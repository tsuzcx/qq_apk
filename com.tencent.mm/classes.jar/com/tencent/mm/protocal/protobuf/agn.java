package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class agn
  extends com.tencent.mm.bx.a
{
  public int FuX;
  public String GeA;
  public int GeB;
  public int GeC;
  public String GeD;
  public String Gew;
  public String Gex;
  public String Gey;
  public String Gez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104780);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gew == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegWord");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Gex == null)
      {
        paramVarArgs = new b("Not all required fields were included: BegPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Gey == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
        AppMethodBeat.o(104780);
        throw paramVarArgs;
      }
      if (this.Gew != null) {
        paramVarArgs.d(1, this.Gew);
      }
      if (this.Gex != null) {
        paramVarArgs.d(2, this.Gex);
      }
      if (this.Gey != null) {
        paramVarArgs.d(3, this.Gey);
      }
      if (this.Gez != null) {
        paramVarArgs.d(4, this.Gez);
      }
      if (this.GeA != null) {
        paramVarArgs.d(5, this.GeA);
      }
      paramVarArgs.aS(6, this.GeB);
      paramVarArgs.aS(7, this.GeC);
      if (this.GeD != null) {
        paramVarArgs.d(8, this.GeD);
      }
      paramVarArgs.aS(9, this.FuX);
      AppMethodBeat.o(104780);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gew == null) {
        break label798;
      }
    }
    label798:
    for (int i = f.a.a.b.b.a.e(1, this.Gew) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gex != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gex);
      }
      i = paramInt;
      if (this.Gey != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gey);
      }
      paramInt = i;
      if (this.Gez != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gez);
      }
      i = paramInt;
      if (this.GeA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GeA);
      }
      i = i + f.a.a.b.b.a.bz(6, this.GeB) + f.a.a.b.b.a.bz(7, this.GeC);
      paramInt = i;
      if (this.GeD != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GeD);
      }
      i = f.a.a.b.b.a.bz(9, this.FuX);
      AppMethodBeat.o(104780);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gew == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegWord");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.Gex == null)
        {
          paramVarArgs = new b("Not all required fields were included: BegPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        if (this.Gey == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThanksPicUrl");
          AppMethodBeat.o(104780);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104780);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agn localagn = (agn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104780);
          return -1;
        case 1: 
          localagn.Gew = locala.NPN.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 2: 
          localagn.Gex = locala.NPN.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 3: 
          localagn.Gey = locala.NPN.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 4: 
          localagn.Gez = locala.NPN.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 5: 
          localagn.GeA = locala.NPN.readString();
          AppMethodBeat.o(104780);
          return 0;
        case 6: 
          localagn.GeB = locala.NPN.zc();
          AppMethodBeat.o(104780);
          return 0;
        case 7: 
          localagn.GeC = locala.NPN.zc();
          AppMethodBeat.o(104780);
          return 0;
        case 8: 
          localagn.GeD = locala.NPN.readString();
          AppMethodBeat.o(104780);
          return 0;
        }
        localagn.FuX = locala.NPN.zc();
        AppMethodBeat.o(104780);
        return 0;
      }
      AppMethodBeat.o(104780);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agn
 * JD-Core Version:    0.7.0.1
 */