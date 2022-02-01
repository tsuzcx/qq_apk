package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ckc
  extends com.tencent.mm.bw.a
{
  public String HdI;
  public int HwG;
  public String HwH;
  public int HwI;
  public String HwJ;
  public int HwK;
  public String HwL;
  public long HwM;
  public LinkedList<cjr> HwN;
  public String ieZ;
  public String wSq;
  public String yoZ;
  
  public ckc()
  {
    AppMethodBeat.i(91593);
    this.HwN = new LinkedList();
    AppMethodBeat.o(91593);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91594);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HwG);
      if (this.HwH != null) {
        paramVarArgs.d(2, this.HwH);
      }
      if (this.HdI != null) {
        paramVarArgs.d(3, this.HdI);
      }
      paramVarArgs.aS(4, this.HwI);
      if (this.wSq != null) {
        paramVarArgs.d(5, this.wSq);
      }
      if (this.HwJ != null) {
        paramVarArgs.d(6, this.HwJ);
      }
      if (this.yoZ != null) {
        paramVarArgs.d(7, this.yoZ);
      }
      paramVarArgs.aS(8, this.HwK);
      if (this.ieZ != null) {
        paramVarArgs.d(9, this.ieZ);
      }
      if (this.HwL != null) {
        paramVarArgs.d(10, this.HwL);
      }
      paramVarArgs.aZ(11, this.HwM);
      paramVarArgs.e(12, 8, this.HwN);
      AppMethodBeat.o(91594);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HwG) + 0;
      paramInt = i;
      if (this.HwH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HwH);
      }
      i = paramInt;
      if (this.HdI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HdI);
      }
      i += f.a.a.b.b.a.bz(4, this.HwI);
      paramInt = i;
      if (this.wSq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.wSq);
      }
      i = paramInt;
      if (this.HwJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HwJ);
      }
      paramInt = i;
      if (this.yoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.yoZ);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.HwK);
      paramInt = i;
      if (this.ieZ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ieZ);
      }
      i = paramInt;
      if (this.HwL != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HwL);
      }
      paramInt = f.a.a.b.b.a.p(11, this.HwM);
      int j = f.a.a.a.c(12, 8, this.HwN);
      AppMethodBeat.o(91594);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HwN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ckc localckc = (ckc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91594);
        return -1;
      case 1: 
        localckc.HwG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91594);
        return 0;
      case 2: 
        localckc.HwH = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 3: 
        localckc.HdI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 4: 
        localckc.HwI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91594);
        return 0;
      case 5: 
        localckc.wSq = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 6: 
        localckc.HwJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 7: 
        localckc.yoZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 8: 
        localckc.HwK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91594);
        return 0;
      case 9: 
        localckc.ieZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 10: 
        localckc.HwL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91594);
        return 0;
      case 11: 
        localckc.HwM = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91594);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cjr();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cjr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localckc.HwN.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91594);
      return 0;
    }
    AppMethodBeat.o(91594);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckc
 * JD-Core Version:    0.7.0.1
 */