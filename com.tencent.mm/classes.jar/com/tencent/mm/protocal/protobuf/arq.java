package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arq
  extends com.tencent.mm.bx.a
{
  public int YFt;
  public int YFu;
  public int YFv;
  public int YFw;
  public String YFz;
  public int vhk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127470);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YFt);
      paramVarArgs.bS(2, this.vhk);
      if (this.YFz != null) {
        paramVarArgs.g(3, this.YFz);
      }
      paramVarArgs.bS(4, this.YFu);
      paramVarArgs.bS(5, this.YFv);
      paramVarArgs.bS(6, this.YFw);
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YFt) + 0 + i.a.a.b.b.a.cJ(2, this.vhk);
      paramInt = i;
      if (this.YFz != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YFz);
      }
      i = i.a.a.b.b.a.cJ(4, this.YFu);
      int j = i.a.a.b.b.a.cJ(5, this.YFv);
      int k = i.a.a.b.b.a.cJ(6, this.YFw);
      AppMethodBeat.o(127470);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127470);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      arq localarq = (arq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127470);
        return -1;
      case 1: 
        localarq.YFt = locala.ajGk.aar();
        AppMethodBeat.o(127470);
        return 0;
      case 2: 
        localarq.vhk = locala.ajGk.aar();
        AppMethodBeat.o(127470);
        return 0;
      case 3: 
        localarq.YFz = locala.ajGk.readString();
        AppMethodBeat.o(127470);
        return 0;
      case 4: 
        localarq.YFu = locala.ajGk.aar();
        AppMethodBeat.o(127470);
        return 0;
      case 5: 
        localarq.YFv = locala.ajGk.aar();
        AppMethodBeat.o(127470);
        return 0;
      }
      localarq.YFw = locala.ajGk.aar();
      AppMethodBeat.o(127470);
      return 0;
    }
    AppMethodBeat.o(127470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arq
 * JD-Core Version:    0.7.0.1
 */