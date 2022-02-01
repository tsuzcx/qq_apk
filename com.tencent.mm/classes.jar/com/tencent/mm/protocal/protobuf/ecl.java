package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class ecl
  extends com.tencent.mm.bw.a
{
  public String NcC;
  public String NcD;
  public String NcE;
  public String NcF;
  public int jll;
  public int jlm;
  public int jln;
  public int jlo;
  public int opType;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NcC == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.NcD == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.NcE == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.NcF == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.aM(1, this.opType);
      paramVarArgs.aM(2, this.jlo);
      paramVarArgs.aM(3, this.jll);
      paramVarArgs.bb(4, this.timeStamp);
      paramVarArgs.aM(5, this.jlm);
      paramVarArgs.aM(6, this.jln);
      if (this.NcC != null) {
        paramVarArgs.e(7, this.NcC);
      }
      if (this.NcD != null) {
        paramVarArgs.e(8, this.NcD);
      }
      if (this.NcE != null) {
        paramVarArgs.e(9, this.NcE);
      }
      if (this.NcF != null) {
        paramVarArgs.e(10, this.NcF);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.opType) + 0 + g.a.a.b.b.a.bu(2, this.jlo) + g.a.a.b.b.a.bu(3, this.jll) + g.a.a.b.b.a.r(4, this.timeStamp) + g.a.a.b.b.a.bu(5, this.jlm) + g.a.a.b.b.a.bu(6, this.jln);
      paramInt = i;
      if (this.NcC != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.NcC);
      }
      i = paramInt;
      if (this.NcD != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.NcD);
      }
      paramInt = i;
      if (this.NcE != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.NcE);
      }
      i = paramInt;
      if (this.NcF != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.NcF);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.NcC == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.NcD == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.NcE == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.NcF == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ecl localecl = (ecl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localecl.opType = locala.UbS.zi();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localecl.jlo = locala.UbS.zi();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localecl.jll = locala.UbS.zi();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localecl.timeStamp = locala.UbS.zl();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localecl.jlm = locala.UbS.zi();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localecl.jln = locala.UbS.zi();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localecl.NcC = locala.UbS.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localecl.NcD = locala.UbS.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localecl.NcE = locala.UbS.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localecl.NcF = locala.UbS.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecl
 * JD-Core Version:    0.7.0.1
 */