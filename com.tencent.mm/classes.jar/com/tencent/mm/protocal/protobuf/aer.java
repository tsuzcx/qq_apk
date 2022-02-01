package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aer
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> DeT;
  public boolean DeU;
  public String DeV;
  public int DeW;
  public long duration;
  public int hcj;
  public int mDz;
  public boolean vfa;
  public boolean vhR;
  public boolean vhS;
  public String vhT;
  public String vhU;
  public boolean yXQ;
  
  public aer()
  {
    AppMethodBeat.i(75026);
    this.DeT = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.duration);
      paramVarArgs.e(2, 2, this.DeT);
      paramVarArgs.aR(3, this.hcj);
      paramVarArgs.bg(4, this.DeU);
      paramVarArgs.bg(5, this.yXQ);
      paramVarArgs.bg(6, this.vhR);
      paramVarArgs.bg(7, this.vhS);
      if (this.vhT != null) {
        paramVarArgs.d(8, this.vhT);
      }
      if (this.vhU != null) {
        paramVarArgs.d(9, this.vhU);
      }
      if (this.DeV != null) {
        paramVarArgs.d(10, this.DeV);
      }
      paramVarArgs.bg(11, this.vfa);
      paramVarArgs.aR(12, this.DeW);
      paramVarArgs.aR(13, this.mDz);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.duration) + 0 + f.a.a.a.c(2, 2, this.DeT) + f.a.a.b.b.a.bA(3, this.hcj) + (f.a.a.b.b.a.fY(4) + 1) + (f.a.a.b.b.a.fY(5) + 1) + (f.a.a.b.b.a.fY(6) + 1) + (f.a.a.b.b.a.fY(7) + 1);
      paramInt = i;
      if (this.vhT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.vhT);
      }
      i = paramInt;
      if (this.vhU != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.vhU);
      }
      paramInt = i;
      if (this.DeV != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DeV);
      }
      i = f.a.a.b.b.a.fY(11);
      int j = f.a.a.b.b.a.bA(12, this.DeW);
      int k = f.a.a.b.b.a.bA(13, this.mDz);
      AppMethodBeat.o(75027);
      return paramInt + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DeT.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aer localaer = (aer)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localaer.duration = locala.KhF.xT();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localaer.DeT.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localaer.hcj = locala.KhF.xS();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localaer.DeU = locala.KhF.fHu();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localaer.yXQ = locala.KhF.fHu();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localaer.vhR = locala.KhF.fHu();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localaer.vhS = locala.KhF.fHu();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localaer.vhT = locala.KhF.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localaer.vhU = locala.KhF.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localaer.DeV = locala.KhF.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localaer.vfa = locala.KhF.fHu();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localaer.DeW = locala.KhF.xS();
        AppMethodBeat.o(75027);
        return 0;
      }
      localaer.mDz = locala.KhF.xS();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aer
 * JD-Core Version:    0.7.0.1
 */