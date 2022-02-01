package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afq
  extends com.tencent.mm.bw.a
{
  public boolean AlF;
  public LinkedList<Integer> ExZ;
  public boolean Eya;
  public String Eyb;
  public int Eyc;
  public long duration;
  public int hCL;
  public int nfG;
  public boolean wnN;
  public boolean wqD;
  public boolean wqE;
  public String wqF;
  public String wqG;
  
  public afq()
  {
    AppMethodBeat.i(75026);
    this.ExZ = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.duration);
      paramVarArgs.e(2, 2, this.ExZ);
      paramVarArgs.aR(3, this.hCL);
      paramVarArgs.bl(4, this.Eya);
      paramVarArgs.bl(5, this.AlF);
      paramVarArgs.bl(6, this.wqD);
      paramVarArgs.bl(7, this.wqE);
      if (this.wqF != null) {
        paramVarArgs.d(8, this.wqF);
      }
      if (this.wqG != null) {
        paramVarArgs.d(9, this.wqG);
      }
      if (this.Eyb != null) {
        paramVarArgs.d(10, this.Eyb);
      }
      paramVarArgs.bl(11, this.wnN);
      paramVarArgs.aR(12, this.Eyc);
      paramVarArgs.aR(13, this.nfG);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.duration) + 0 + f.a.a.a.c(2, 2, this.ExZ) + f.a.a.b.b.a.bx(3, this.hCL) + (f.a.a.b.b.a.fK(4) + 1) + (f.a.a.b.b.a.fK(5) + 1) + (f.a.a.b.b.a.fK(6) + 1) + (f.a.a.b.b.a.fK(7) + 1);
      paramInt = i;
      if (this.wqF != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.wqF);
      }
      i = paramInt;
      if (this.wqG != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.wqG);
      }
      paramInt = i;
      if (this.Eyb != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Eyb);
      }
      i = f.a.a.b.b.a.fK(11);
      int j = f.a.a.b.b.a.bx(12, this.Eyc);
      int k = f.a.a.b.b.a.bx(13, this.nfG);
      AppMethodBeat.o(75027);
      return paramInt + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ExZ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afq localafq = (afq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localafq.duration = locala.LVo.xG();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localafq.ExZ.add(Integer.valueOf(locala.LVo.xF()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localafq.hCL = locala.LVo.xF();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localafq.Eya = locala.LVo.fZX();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localafq.AlF = locala.LVo.fZX();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localafq.wqD = locala.LVo.fZX();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localafq.wqE = locala.LVo.fZX();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localafq.wqF = locala.LVo.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localafq.wqG = locala.LVo.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localafq.Eyb = locala.LVo.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localafq.wnN = locala.LVo.fZX();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localafq.Eyc = locala.LVo.xF();
        AppMethodBeat.o(75027);
        return 0;
      }
      localafq.nfG = locala.LVo.xF();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afq
 * JD-Core Version:    0.7.0.1
 */