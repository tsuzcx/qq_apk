package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfh
  extends com.tencent.mm.bw.a
{
  public String HVY;
  public String HVZ;
  public String HWa;
  public long LOR;
  public int LOS;
  public double LOT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91470);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.LOR);
      paramVarArgs.aM(2, this.LOS);
      paramVarArgs.e(3, this.LOT);
      if (this.HVY != null) {
        paramVarArgs.e(4, this.HVY);
      }
      if (this.HVZ != null) {
        paramVarArgs.e(5, this.HVZ);
      }
      if (this.HWa != null) {
        paramVarArgs.e(6, this.HWa);
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.LOR) + 0 + g.a.a.b.b.a.bu(2, this.LOS) + (g.a.a.b.b.a.fS(3) + 8);
      paramInt = i;
      if (this.HVY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HVY);
      }
      i = paramInt;
      if (this.HVZ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.HVZ);
      }
      paramInt = i;
      if (this.HWa != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HWa);
      }
      AppMethodBeat.o(91470);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91470);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bfh localbfh = (bfh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91470);
        return -1;
      case 1: 
        localbfh.LOR = locala.UbS.zl();
        AppMethodBeat.o(91470);
        return 0;
      case 2: 
        localbfh.LOS = locala.UbS.zi();
        AppMethodBeat.o(91470);
        return 0;
      case 3: 
        localbfh.LOT = Double.longBitsToDouble(locala.UbS.zn());
        AppMethodBeat.o(91470);
        return 0;
      case 4: 
        localbfh.HVY = locala.UbS.readString();
        AppMethodBeat.o(91470);
        return 0;
      case 5: 
        localbfh.HVZ = locala.UbS.readString();
        AppMethodBeat.o(91470);
        return 0;
      }
      localbfh.HWa = locala.UbS.readString();
      AppMethodBeat.o(91470);
      return 0;
    }
    AppMethodBeat.o(91470);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfh
 * JD-Core Version:    0.7.0.1
 */