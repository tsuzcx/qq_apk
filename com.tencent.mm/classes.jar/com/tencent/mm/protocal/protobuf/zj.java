package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zj
  extends com.tencent.mm.bx.a
{
  public int ILB;
  public String Zid;
  public double Zie;
  public double Zif;
  public double Zig;
  public double Zih;
  public double Zii;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(87874);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zid != null) {
        paramVarArgs.g(1, this.Zid);
      }
      paramVarArgs.d(2, this.Zie);
      paramVarArgs.d(3, this.Zif);
      paramVarArgs.d(4, this.Zig);
      paramVarArgs.d(5, this.Zih);
      paramVarArgs.d(6, this.Zii);
      paramVarArgs.bS(7, this.ILB);
      AppMethodBeat.o(87874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zid == null) {
        break label501;
      }
    }
    label501:
    for (paramInt = i.a.a.b.b.a.h(1, this.Zid) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      int j = i.a.a.b.b.a.ko(3);
      int k = i.a.a.b.b.a.ko(4);
      int m = i.a.a.b.b.a.ko(5);
      int n = i.a.a.b.b.a.ko(6);
      int i1 = i.a.a.b.b.a.cJ(7, this.ILB);
      AppMethodBeat.o(87874);
      return paramInt + (i + 8) + (j + 8) + (k + 8) + (m + 8) + (n + 8) + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(87874);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        zj localzj = (zj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(87874);
          return -1;
        case 1: 
          localzj.Zid = locala.ajGk.readString();
          AppMethodBeat.o(87874);
          return 0;
        case 2: 
          localzj.Zie = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(87874);
          return 0;
        case 3: 
          localzj.Zif = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(87874);
          return 0;
        case 4: 
          localzj.Zig = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(87874);
          return 0;
        case 5: 
          localzj.Zih = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(87874);
          return 0;
        case 6: 
          localzj.Zii = Double.longBitsToDouble(locala.ajGk.aay());
          AppMethodBeat.o(87874);
          return 0;
        }
        localzj.ILB = locala.ajGk.aar();
        AppMethodBeat.o(87874);
        return 0;
      }
      AppMethodBeat.o(87874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zj
 * JD-Core Version:    0.7.0.1
 */