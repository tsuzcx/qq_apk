package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aip
  extends com.tencent.mm.bw.a
{
  public boolean BUO;
  public LinkedList<Integer> Gyo;
  public boolean Gyp;
  public String Gyq;
  public int Gyr;
  public long duration;
  public int hYi;
  public int nLC;
  public boolean xLA;
  public boolean xOq;
  public boolean xOr;
  public String xOs;
  public String xOt;
  
  public aip()
  {
    AppMethodBeat.i(75026);
    this.Gyo = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.duration);
      paramVarArgs.e(2, 2, this.Gyo);
      paramVarArgs.aS(3, this.hYi);
      paramVarArgs.bC(4, this.Gyp);
      paramVarArgs.bC(5, this.BUO);
      paramVarArgs.bC(6, this.xOq);
      paramVarArgs.bC(7, this.xOr);
      if (this.xOs != null) {
        paramVarArgs.d(8, this.xOs);
      }
      if (this.xOt != null) {
        paramVarArgs.d(9, this.xOt);
      }
      if (this.Gyq != null) {
        paramVarArgs.d(10, this.Gyq);
      }
      paramVarArgs.bC(11, this.xLA);
      paramVarArgs.aS(12, this.Gyr);
      paramVarArgs.aS(13, this.nLC);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.duration) + 0 + f.a.a.a.c(2, 2, this.Gyo) + f.a.a.b.b.a.bz(3, this.hYi) + f.a.a.b.b.a.amF(4) + f.a.a.b.b.a.amF(5) + f.a.a.b.b.a.amF(6) + f.a.a.b.b.a.amF(7);
      paramInt = i;
      if (this.xOs != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.xOs);
      }
      i = paramInt;
      if (this.xOt != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.xOt);
      }
      paramInt = i;
      if (this.Gyq != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Gyq);
      }
      i = f.a.a.b.b.a.amF(11);
      int j = f.a.a.b.b.a.bz(12, this.Gyr);
      int k = f.a.a.b.b.a.bz(13, this.nLC);
      AppMethodBeat.o(75027);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gyo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aip localaip = (aip)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localaip.duration = locala.OmT.zd();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localaip.Gyo.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localaip.hYi = locala.OmT.zc();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localaip.Gyp = locala.OmT.gvY();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localaip.BUO = locala.OmT.gvY();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localaip.xOq = locala.OmT.gvY();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localaip.xOr = locala.OmT.gvY();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localaip.xOs = locala.OmT.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localaip.xOt = locala.OmT.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localaip.Gyq = locala.OmT.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localaip.xLA = locala.OmT.gvY();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localaip.Gyr = locala.OmT.zc();
        AppMethodBeat.o(75027);
        return 0;
      }
      localaip.nLC = locala.OmT.zc();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aip
 * JD-Core Version:    0.7.0.1
 */