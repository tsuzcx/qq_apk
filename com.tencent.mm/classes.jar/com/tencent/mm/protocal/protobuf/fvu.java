package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fvu
  extends com.tencent.mm.bx.a
{
  public long FsW;
  public int QXQ;
  public int abTW;
  public long abTX;
  public long abTY;
  public long abTZ;
  public long abUa;
  public long abUb;
  public int abUc;
  public long ork;
  public long zIy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169092);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abTW);
      paramVarArgs.bS(2, this.QXQ);
      paramVarArgs.bv(3, this.zIy);
      paramVarArgs.bv(4, this.abTX);
      paramVarArgs.bv(5, this.abTY);
      paramVarArgs.bv(6, this.abTZ);
      paramVarArgs.bv(7, this.ork);
      paramVarArgs.bv(8, this.abUa);
      paramVarArgs.bv(9, this.FsW);
      paramVarArgs.bv(10, this.abUb);
      paramVarArgs.bS(11, this.abUc);
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.abTW);
      int i = i.a.a.b.b.a.cJ(2, this.QXQ);
      int j = i.a.a.b.b.a.q(3, this.zIy);
      int k = i.a.a.b.b.a.q(4, this.abTX);
      int m = i.a.a.b.b.a.q(5, this.abTY);
      int n = i.a.a.b.b.a.q(6, this.abTZ);
      int i1 = i.a.a.b.b.a.q(7, this.ork);
      int i2 = i.a.a.b.b.a.q(8, this.abUa);
      int i3 = i.a.a.b.b.a.q(9, this.FsW);
      int i4 = i.a.a.b.b.a.q(10, this.abUb);
      int i5 = i.a.a.b.b.a.cJ(11, this.abUc);
      AppMethodBeat.o(169092);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169092);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fvu localfvu = (fvu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169092);
        return -1;
      case 1: 
        localfvu.abTW = locala.ajGk.aar();
        AppMethodBeat.o(169092);
        return 0;
      case 2: 
        localfvu.QXQ = locala.ajGk.aar();
        AppMethodBeat.o(169092);
        return 0;
      case 3: 
        localfvu.zIy = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 4: 
        localfvu.abTX = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 5: 
        localfvu.abTY = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 6: 
        localfvu.abTZ = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 7: 
        localfvu.ork = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 8: 
        localfvu.abUa = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 9: 
        localfvu.FsW = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      case 10: 
        localfvu.abUb = locala.ajGk.aaw();
        AppMethodBeat.o(169092);
        return 0;
      }
      localfvu.abUc = locala.ajGk.aar();
      AppMethodBeat.o(169092);
      return 0;
    }
    AppMethodBeat.o(169092);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvu
 * JD-Core Version:    0.7.0.1
 */