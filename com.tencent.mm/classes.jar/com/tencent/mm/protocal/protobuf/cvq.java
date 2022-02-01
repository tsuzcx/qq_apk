package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvq
  extends com.tencent.mm.bx.a
{
  public float Enn;
  public float Eno;
  public float Enp;
  public float Enq;
  public int Enr;
  public long Ens;
  public long Ent;
  public float bQL;
  public int xoi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125812);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.Enn);
      paramVarArgs.x(2, this.Eno);
      paramVarArgs.x(3, this.Enp);
      paramVarArgs.x(4, this.Enq);
      paramVarArgs.aR(5, this.Enr);
      paramVarArgs.aG(6, this.Ens);
      paramVarArgs.aG(7, this.Ent);
      paramVarArgs.x(8, this.bQL);
      paramVarArgs.aR(9, this.xoi);
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fY(1);
      int i = f.a.a.b.b.a.fY(2);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.bA(5, this.Enr);
      int n = f.a.a.b.b.a.q(6, this.Ens);
      int i1 = f.a.a.b.b.a.q(7, this.Ent);
      int i2 = f.a.a.b.b.a.fY(8);
      int i3 = f.a.a.b.b.a.bA(9, this.xoi);
      AppMethodBeat.o(125812);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + (i2 + 4) + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125812);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cvq localcvq = (cvq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125812);
        return -1;
      case 1: 
        localcvq.Enn = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125812);
        return 0;
      case 2: 
        localcvq.Eno = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125812);
        return 0;
      case 3: 
        localcvq.Enp = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125812);
        return 0;
      case 4: 
        localcvq.Enq = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125812);
        return 0;
      case 5: 
        localcvq.Enr = locala.KhF.xS();
        AppMethodBeat.o(125812);
        return 0;
      case 6: 
        localcvq.Ens = locala.KhF.xT();
        AppMethodBeat.o(125812);
        return 0;
      case 7: 
        localcvq.Ent = locala.KhF.xT();
        AppMethodBeat.o(125812);
        return 0;
      case 8: 
        localcvq.bQL = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125812);
        return 0;
      }
      localcvq.xoi = locala.KhF.xS();
      AppMethodBeat.o(125812);
      return 0;
    }
    AppMethodBeat.o(125812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvq
 * JD-Core Version:    0.7.0.1
 */