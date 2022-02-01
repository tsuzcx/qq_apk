package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ffa
  extends com.tencent.mm.bx.a
{
  public float ReY;
  public int ReZ;
  public float abEJ;
  public float abEK;
  public float abEL;
  public float abEM;
  public int abEN;
  public long abEO;
  public long abEP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.abEJ);
      paramVarArgs.l(2, this.abEK);
      paramVarArgs.l(3, this.abEL);
      paramVarArgs.l(4, this.abEM);
      paramVarArgs.bS(5, this.abEN);
      paramVarArgs.bv(6, this.abEO);
      paramVarArgs.bv(7, this.abEP);
      paramVarArgs.l(8, this.ReY);
      paramVarArgs.bS(9, this.ReZ);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.cJ(5, this.abEN);
      int n = i.a.a.b.b.a.q(6, this.abEO);
      int i1 = i.a.a.b.b.a.q(7, this.abEP);
      int i2 = i.a.a.b.b.a.ko(8);
      int i3 = i.a.a.b.b.a.cJ(9, this.ReZ);
      AppMethodBeat.o(125812);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + (i2 + 4) + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ffa localffa = (ffa)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localffa.abEJ = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localffa.abEK = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localffa.abEL = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localffa.abEM = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localffa.abEN = locala.ajGk.aar();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localffa.abEO = locala.ajGk.aaw();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localffa.abEP = locala.ajGk.aaw();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localffa.ReY = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(125812);
        return 0;
      }
      localffa.ReZ = locala.ajGk.aar();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffa
 * JD-Core Version:    0.7.0.1
 */