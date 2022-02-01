package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gln
  extends com.tencent.mm.bx.a
{
  public int acgZ;
  public int acha;
  public int achb;
  public int achc;
  public int achd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50122);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.acgZ);
      paramVarArgs.bS(2, this.acha);
      paramVarArgs.bS(3, this.achb);
      paramVarArgs.bS(4, this.achc);
      paramVarArgs.bS(5, this.achd);
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.acgZ);
      int i = i.a.a.b.b.a.cJ(2, this.acha);
      int j = i.a.a.b.b.a.cJ(3, this.achb);
      int k = i.a.a.b.b.a.cJ(4, this.achc);
      int m = i.a.a.b.b.a.cJ(5, this.achd);
      AppMethodBeat.o(50122);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50122);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gln localgln = (gln)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50122);
        return -1;
      case 1: 
        localgln.acgZ = locala.ajGk.aar();
        AppMethodBeat.o(50122);
        return 0;
      case 2: 
        localgln.acha = locala.ajGk.aar();
        AppMethodBeat.o(50122);
        return 0;
      case 3: 
        localgln.achb = locala.ajGk.aar();
        AppMethodBeat.o(50122);
        return 0;
      case 4: 
        localgln.achc = locala.ajGk.aar();
        AppMethodBeat.o(50122);
        return 0;
      }
      localgln.achd = locala.ajGk.aar();
      AppMethodBeat.o(50122);
      return 0;
    }
    AppMethodBeat.o(50122);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gln
 * JD-Core Version:    0.7.0.1
 */