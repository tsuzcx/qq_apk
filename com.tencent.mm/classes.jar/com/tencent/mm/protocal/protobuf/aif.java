package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aif
  extends com.tencent.mm.bx.a
{
  public boolean BDq;
  public LinkedList<Integer> GfG;
  public boolean GfH;
  public String GfI;
  public int GfJ;
  public long duration;
  public int hVq;
  public int nGc;
  public boolean xvD;
  public boolean xyu;
  public boolean xyv;
  public String xyw;
  public String xyx;
  
  public aif()
  {
    AppMethodBeat.i(75026);
    this.GfG = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.duration);
      paramVarArgs.e(2, 2, this.GfG);
      paramVarArgs.aS(3, this.hVq);
      paramVarArgs.bt(4, this.GfH);
      paramVarArgs.bt(5, this.BDq);
      paramVarArgs.bt(6, this.xyu);
      paramVarArgs.bt(7, this.xyv);
      if (this.xyw != null) {
        paramVarArgs.d(8, this.xyw);
      }
      if (this.xyx != null) {
        paramVarArgs.d(9, this.xyx);
      }
      if (this.GfI != null) {
        paramVarArgs.d(10, this.GfI);
      }
      paramVarArgs.bt(11, this.xvD);
      paramVarArgs.aS(12, this.GfJ);
      paramVarArgs.aS(13, this.nGc);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.duration) + 0 + f.a.a.a.c(2, 2, this.GfG) + f.a.a.b.b.a.bz(3, this.hVq) + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.alV(5) + f.a.a.b.b.a.alV(6) + f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.xyw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xyw);
      }
      i = paramInt;
      if (this.xyx != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.xyx);
      }
      paramInt = i;
      if (this.GfI != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GfI);
      }
      i = f.a.a.b.b.a.alV(11);
      int j = f.a.a.b.b.a.bz(12, this.GfJ);
      int k = f.a.a.b.b.a.bz(13, this.nGc);
      AppMethodBeat.o(75027);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GfG.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aif localaif = (aif)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localaif.duration = locala.NPN.zd();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localaif.GfG.add(Integer.valueOf(locala.NPN.zc()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localaif.hVq = locala.NPN.zc();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localaif.GfH = locala.NPN.grw();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localaif.BDq = locala.NPN.grw();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localaif.xyu = locala.NPN.grw();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localaif.xyv = locala.NPN.grw();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localaif.xyw = locala.NPN.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localaif.xyx = locala.NPN.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localaif.GfI = locala.NPN.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localaif.xvD = locala.NPN.grw();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localaif.GfJ = locala.NPN.zc();
        AppMethodBeat.o(75027);
        return 0;
      }
      localaif.nGc = locala.NPN.zc();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aif
 * JD-Core Version:    0.7.0.1
 */