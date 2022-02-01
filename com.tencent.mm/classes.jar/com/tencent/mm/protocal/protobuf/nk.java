package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nk
  extends com.tencent.mm.bx.a
{
  public int FGA;
  public int FGB;
  public int FHq;
  public int FHr;
  public int FHs;
  public aak FHt;
  public int FHu;
  public int FHv;
  public int FHw = 0;
  public int FHx;
  public int FxD;
  public String FxE;
  public String content;
  public String hzB;
  public String pjK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103203);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FHq);
      paramVarArgs.aS(2, this.FxD);
      if (this.FxE != null) {
        paramVarArgs.d(3, this.FxE);
      }
      if (this.pjK != null) {
        paramVarArgs.d(4, this.pjK);
      }
      if (this.hzB != null) {
        paramVarArgs.d(5, this.hzB);
      }
      if (this.content != null) {
        paramVarArgs.d(6, this.content);
      }
      paramVarArgs.aS(7, this.FHr);
      paramVarArgs.aS(8, this.FHs);
      paramVarArgs.aS(9, this.FGA);
      paramVarArgs.aS(10, this.FGB);
      if (this.FHt != null)
      {
        paramVarArgs.lC(11, this.FHt.computeSize());
        this.FHt.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(12, this.FHu);
      paramVarArgs.aS(13, this.FHv);
      paramVarArgs.aS(14, this.FHw);
      paramVarArgs.aS(15, this.FHx);
      AppMethodBeat.o(103203);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FHq) + 0 + f.a.a.b.b.a.bz(2, this.FxD);
      paramInt = i;
      if (this.FxE != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FxE);
      }
      i = paramInt;
      if (this.pjK != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.pjK);
      }
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hzB);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.content);
      }
      i = i + f.a.a.b.b.a.bz(7, this.FHr) + f.a.a.b.b.a.bz(8, this.FHs) + f.a.a.b.b.a.bz(9, this.FGA) + f.a.a.b.b.a.bz(10, this.FGB);
      paramInt = i;
      if (this.FHt != null) {
        paramInt = i + f.a.a.a.lB(11, this.FHt.computeSize());
      }
      i = f.a.a.b.b.a.bz(12, this.FHu);
      int j = f.a.a.b.b.a.bz(13, this.FHv);
      int k = f.a.a.b.b.a.bz(14, this.FHw);
      int m = f.a.a.b.b.a.bz(15, this.FHx);
      AppMethodBeat.o(103203);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(103203);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nk localnk = (nk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(103203);
        return -1;
      case 1: 
        localnk.FHq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 2: 
        localnk.FxD = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 3: 
        localnk.FxE = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 4: 
        localnk.pjK = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 5: 
        localnk.hzB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 6: 
        localnk.content = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103203);
        return 0;
      case 7: 
        localnk.FHr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 8: 
        localnk.FHs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 9: 
        localnk.FGA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 10: 
        localnk.FGB = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aak();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aak)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnk.FHt = ((aak)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(103203);
        return 0;
      case 12: 
        localnk.FHu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 13: 
        localnk.FHv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      case 14: 
        localnk.FHw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103203);
        return 0;
      }
      localnk.FHx = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(103203);
      return 0;
    }
    AppMethodBeat.o(103203);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nk
 * JD-Core Version:    0.7.0.1
 */