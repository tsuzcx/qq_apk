package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhv
  extends com.tencent.mm.bx.a
{
  public int FYc;
  public int GeI;
  public int HwA;
  public int Hwq;
  public int Hwr;
  public int Hws;
  public int Hwt;
  public int Hwu;
  public LinkedList<Integer> Hwv;
  public int Hww;
  public int Hwx;
  public LinkedList<Integer> Hwy;
  public int Hwz;
  
  public dhv()
  {
    AppMethodBeat.i(115853);
    this.Hwv = new LinkedList();
    this.Hwy = new LinkedList();
    AppMethodBeat.o(115853);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115854);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GeI);
      paramVarArgs.aS(2, this.Hwq);
      paramVarArgs.aS(3, this.FYc);
      paramVarArgs.aS(4, this.Hwr);
      paramVarArgs.aS(5, this.Hws);
      paramVarArgs.aS(6, this.Hwt);
      paramVarArgs.aS(7, this.Hwu);
      paramVarArgs.e(8, 2, this.Hwv);
      paramVarArgs.aS(9, this.Hww);
      paramVarArgs.aS(10, this.Hwx);
      paramVarArgs.e(11, 2, this.Hwy);
      paramVarArgs.aS(12, this.Hwz);
      paramVarArgs.aS(13, this.HwA);
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.GeI);
      int i = f.a.a.b.b.a.bz(2, this.Hwq);
      int j = f.a.a.b.b.a.bz(3, this.FYc);
      int k = f.a.a.b.b.a.bz(4, this.Hwr);
      int m = f.a.a.b.b.a.bz(5, this.Hws);
      int n = f.a.a.b.b.a.bz(6, this.Hwt);
      int i1 = f.a.a.b.b.a.bz(7, this.Hwu);
      int i2 = f.a.a.a.c(8, 2, this.Hwv);
      int i3 = f.a.a.b.b.a.bz(9, this.Hww);
      int i4 = f.a.a.b.b.a.bz(10, this.Hwx);
      int i5 = f.a.a.a.c(11, 2, this.Hwy);
      int i6 = f.a.a.b.b.a.bz(12, this.Hwz);
      int i7 = f.a.a.b.b.a.bz(13, this.HwA);
      AppMethodBeat.o(115854);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hwv.clear();
      this.Hwy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(115854);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhv localdhv = (dhv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115854);
        return -1;
      case 1: 
        localdhv.GeI = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 2: 
        localdhv.Hwq = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 3: 
        localdhv.FYc = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 4: 
        localdhv.Hwr = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 5: 
        localdhv.Hws = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 6: 
        localdhv.Hwt = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 7: 
        localdhv.Hwu = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 8: 
        localdhv.Hwv.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(115854);
        return 0;
      case 9: 
        localdhv.Hww = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 10: 
        localdhv.Hwx = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      case 11: 
        localdhv.Hwy.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(115854);
        return 0;
      case 12: 
        localdhv.Hwz = locala.NPN.zc();
        AppMethodBeat.o(115854);
        return 0;
      }
      localdhv.HwA = locala.NPN.zc();
      AppMethodBeat.o(115854);
      return 0;
    }
    AppMethodBeat.o(115854);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhv
 * JD-Core Version:    0.7.0.1
 */