package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class br
  extends com.tencent.mm.bx.a
{
  public float Cwt;
  public float Cwu;
  public float Cwv;
  public long Cww;
  public long Cwx;
  public long Cwy;
  public long Cwz;
  public long endTime;
  public long startTime;
  public int wxB;
  public int wxC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.wxB);
      paramVarArgs.aR(2, this.wxC);
      paramVarArgs.x(3, this.Cwt);
      paramVarArgs.x(4, this.Cwu);
      paramVarArgs.x(5, this.Cwv);
      paramVarArgs.aG(6, this.startTime);
      paramVarArgs.aG(7, this.endTime);
      paramVarArgs.aG(8, this.Cww);
      paramVarArgs.aG(9, this.Cwx);
      paramVarArgs.aG(10, this.Cwy);
      paramVarArgs.aG(11, this.Cwz);
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.wxB);
      int i = f.a.a.b.b.a.bA(2, this.wxC);
      int j = f.a.a.b.b.a.fY(3);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.q(6, this.startTime);
      int i1 = f.a.a.b.b.a.q(7, this.endTime);
      int i2 = f.a.a.b.b.a.q(8, this.Cww);
      int i3 = f.a.a.b.b.a.q(9, this.Cwx);
      int i4 = f.a.a.b.b.a.q(10, this.Cwy);
      int i5 = f.a.a.b.b.a.q(11, this.Cwz);
      AppMethodBeat.o(125698);
      return paramInt + 0 + i + (j + 4) + (k + 4) + (m + 4) + n + i1 + i2 + i3 + i4 + i5;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125698);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      br localbr = (br)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125698);
        return -1;
      case 1: 
        localbr.wxB = locala.KhF.xS();
        AppMethodBeat.o(125698);
        return 0;
      case 2: 
        localbr.wxC = locala.KhF.xS();
        AppMethodBeat.o(125698);
        return 0;
      case 3: 
        localbr.Cwt = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125698);
        return 0;
      case 4: 
        localbr.Cwu = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125698);
        return 0;
      case 5: 
        localbr.Cwv = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(125698);
        return 0;
      case 6: 
        localbr.startTime = locala.KhF.xT();
        AppMethodBeat.o(125698);
        return 0;
      case 7: 
        localbr.endTime = locala.KhF.xT();
        AppMethodBeat.o(125698);
        return 0;
      case 8: 
        localbr.Cww = locala.KhF.xT();
        AppMethodBeat.o(125698);
        return 0;
      case 9: 
        localbr.Cwx = locala.KhF.xT();
        AppMethodBeat.o(125698);
        return 0;
      case 10: 
        localbr.Cwy = locala.KhF.xT();
        AppMethodBeat.o(125698);
        return 0;
      }
      localbr.Cwz = locala.KhF.xT();
      AppMethodBeat.o(125698);
      return 0;
    }
    AppMethodBeat.o(125698);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.br
 * JD-Core Version:    0.7.0.1
 */