package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmq
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> ECA;
  public int ECB;
  public LinkedList<Integer> ECC;
  public String ECD;
  public String ECE;
  public int ECo;
  public int ECp;
  public int ECq;
  public int ECr;
  public int ECs;
  public int ECt;
  public int ECu;
  public int ECv;
  public int ECw;
  public int ECx;
  public LinkedList<Integer> ECy;
  public int ECz;
  
  public dmq()
  {
    AppMethodBeat.i(115892);
    this.ECy = new LinkedList();
    this.ECA = new LinkedList();
    this.ECC = new LinkedList();
    AppMethodBeat.o(115892);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ECo);
      paramVarArgs.aR(2, this.ECp);
      paramVarArgs.aR(3, this.ECq);
      paramVarArgs.aR(4, this.ECr);
      paramVarArgs.aR(5, this.ECs);
      paramVarArgs.aR(6, this.ECt);
      paramVarArgs.aR(7, this.ECu);
      paramVarArgs.aR(8, this.ECv);
      paramVarArgs.aR(9, this.ECw);
      paramVarArgs.aR(10, this.ECx);
      paramVarArgs.e(11, 2, this.ECy);
      paramVarArgs.aR(12, this.ECz);
      paramVarArgs.e(13, 2, this.ECA);
      paramVarArgs.aR(14, this.ECB);
      paramVarArgs.e(15, 2, this.ECC);
      if (this.ECD != null) {
        paramVarArgs.d(16, this.ECD);
      }
      if (this.ECE != null) {
        paramVarArgs.d(17, this.ECE);
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.ECo) + 0 + f.a.a.b.b.a.bA(2, this.ECp) + f.a.a.b.b.a.bA(3, this.ECq) + f.a.a.b.b.a.bA(4, this.ECr) + f.a.a.b.b.a.bA(5, this.ECs) + f.a.a.b.b.a.bA(6, this.ECt) + f.a.a.b.b.a.bA(7, this.ECu) + f.a.a.b.b.a.bA(8, this.ECv) + f.a.a.b.b.a.bA(9, this.ECw) + f.a.a.b.b.a.bA(10, this.ECx) + f.a.a.a.c(11, 2, this.ECy) + f.a.a.b.b.a.bA(12, this.ECz) + f.a.a.a.c(13, 2, this.ECA) + f.a.a.b.b.a.bA(14, this.ECB) + f.a.a.a.c(15, 2, this.ECC);
      paramInt = i;
      if (this.ECD != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.ECD);
      }
      i = paramInt;
      if (this.ECE != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.ECE);
      }
      AppMethodBeat.o(115893);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ECy.clear();
      this.ECA.clear();
      this.ECC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115893);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmq localdmq = (dmq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115893);
        return -1;
      case 1: 
        localdmq.ECo = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 2: 
        localdmq.ECp = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 3: 
        localdmq.ECq = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 4: 
        localdmq.ECr = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 5: 
        localdmq.ECs = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 6: 
        localdmq.ECt = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 7: 
        localdmq.ECu = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 8: 
        localdmq.ECv = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 9: 
        localdmq.ECw = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 10: 
        localdmq.ECx = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 11: 
        localdmq.ECy.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(115893);
        return 0;
      case 12: 
        localdmq.ECz = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 13: 
        localdmq.ECA.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(115893);
        return 0;
      case 14: 
        localdmq.ECB = locala.KhF.xS();
        AppMethodBeat.o(115893);
        return 0;
      case 15: 
        localdmq.ECC.add(Integer.valueOf(locala.KhF.xS()));
        AppMethodBeat.o(115893);
        return 0;
      case 16: 
        localdmq.ECD = locala.KhF.readString();
        AppMethodBeat.o(115893);
        return 0;
      }
      localdmq.ECE = locala.KhF.readString();
      AppMethodBeat.o(115893);
      return 0;
    }
    AppMethodBeat.o(115893);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmq
 * JD-Core Version:    0.7.0.1
 */