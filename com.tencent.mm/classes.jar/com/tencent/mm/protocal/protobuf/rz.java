package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class rz
  extends com.tencent.mm.bw.a
{
  public int GgF;
  public int GgG;
  public int GgH;
  public int GgI;
  public LinkedList<cxn> GgJ;
  public String GgK;
  public SKBuiltinBuffer_t GgL;
  public int GgM;
  public int GgN;
  public LinkedList<cxn> GgO;
  public LinkedList<sa> GgP;
  public LinkedList<sa> GgQ;
  public int GgR;
  public int GgS;
  public int qkC;
  
  public rz()
  {
    AppMethodBeat.i(133162);
    this.GgJ = new LinkedList();
    this.GgO = new LinkedList();
    this.GgP = new LinkedList();
    this.GgQ = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.GgF);
      paramVarArgs.aS(2, this.qkC);
      paramVarArgs.aS(3, this.GgG);
      paramVarArgs.aS(4, this.GgH);
      paramVarArgs.aS(5, this.GgI);
      paramVarArgs.e(6, 8, this.GgJ);
      if (this.GgK != null) {
        paramVarArgs.d(7, this.GgK);
      }
      if (this.GgL != null)
      {
        paramVarArgs.lJ(8, this.GgL.computeSize());
        this.GgL.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.GgM);
      paramVarArgs.aS(10, this.GgN);
      paramVarArgs.e(11, 8, this.GgO);
      paramVarArgs.e(12, 8, this.GgP);
      paramVarArgs.e(13, 8, this.GgQ);
      paramVarArgs.aS(14, this.GgR);
      paramVarArgs.aS(15, this.GgS);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GgF) + 0 + f.a.a.b.b.a.bz(2, this.qkC) + f.a.a.b.b.a.bz(3, this.GgG) + f.a.a.b.b.a.bz(4, this.GgH) + f.a.a.b.b.a.bz(5, this.GgI) + f.a.a.a.c(6, 8, this.GgJ);
      paramInt = i;
      if (this.GgK != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GgK);
      }
      i = paramInt;
      if (this.GgL != null) {
        i = paramInt + f.a.a.a.lI(8, this.GgL.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(9, this.GgM);
      int j = f.a.a.b.b.a.bz(10, this.GgN);
      int k = f.a.a.a.c(11, 8, this.GgO);
      int m = f.a.a.a.c(12, 8, this.GgP);
      int n = f.a.a.a.c(13, 8, this.GgQ);
      int i1 = f.a.a.b.b.a.bz(14, this.GgR);
      int i2 = f.a.a.b.b.a.bz(15, this.GgS);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GgJ.clear();
      this.GgO.clear();
      this.GgP.clear();
      this.GgQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GgL == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133163);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      rz localrz = (rz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localrz.GgF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localrz.qkC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localrz.GgG = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localrz.GgH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localrz.GgI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrz.GgJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localrz.GgK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrz.GgL = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localrz.GgM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localrz.GgN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrz.GgO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrz.GgP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrz.GgQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localrz.GgR = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(133163);
        return 0;
      }
      localrz.GgS = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rz
 * JD-Core Version:    0.7.0.1
 */