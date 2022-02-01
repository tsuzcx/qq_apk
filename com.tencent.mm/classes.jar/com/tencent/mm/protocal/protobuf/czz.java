package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class czz
  extends com.tencent.mm.bx.a
{
  public long Njv;
  public String UserName;
  public String YHk;
  public long aaFu;
  public int aasS;
  public String oPp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258775);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Njv);
      paramVarArgs.bv(2, this.aaFu);
      if (this.oPp != null) {
        paramVarArgs.g(3, this.oPp);
      }
      paramVarArgs.bS(4, this.aasS);
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      if (this.YHk != null) {
        paramVarArgs.g(6, this.YHk);
      }
      AppMethodBeat.o(258775);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Njv) + 0 + i.a.a.b.b.a.q(2, this.aaFu);
      paramInt = i;
      if (this.oPp != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.oPp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.aasS);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.UserName);
      }
      i = paramInt;
      if (this.YHk != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YHk);
      }
      AppMethodBeat.o(258775);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258775);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      czz localczz = (czz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258775);
        return -1;
      case 1: 
        localczz.Njv = locala.ajGk.aaw();
        AppMethodBeat.o(258775);
        return 0;
      case 2: 
        localczz.aaFu = locala.ajGk.aaw();
        AppMethodBeat.o(258775);
        return 0;
      case 3: 
        localczz.oPp = locala.ajGk.readString();
        AppMethodBeat.o(258775);
        return 0;
      case 4: 
        localczz.aasS = locala.ajGk.aar();
        AppMethodBeat.o(258775);
        return 0;
      case 5: 
        localczz.UserName = locala.ajGk.readString();
        AppMethodBeat.o(258775);
        return 0;
      }
      localczz.YHk = locala.ajGk.readString();
      AppMethodBeat.o(258775);
      return 0;
    }
    AppMethodBeat.o(258775);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czz
 * JD-Core Version:    0.7.0.1
 */