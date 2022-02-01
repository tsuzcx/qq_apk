package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aeu
  extends com.tencent.mm.bx.a
{
  public int GcK;
  public String GcL;
  public String GcM;
  public int GcN;
  public int GcO;
  public int GcP;
  public dwt GcQ;
  public int GcR;
  public LinkedList<dyh> GcS;
  public int GcT;
  public int GcU;
  
  public aeu()
  {
    AppMethodBeat.i(115835);
    this.GcS = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GcK);
      if (this.GcL != null) {
        paramVarArgs.d(2, this.GcL);
      }
      if (this.GcM != null) {
        paramVarArgs.d(3, this.GcM);
      }
      paramVarArgs.aS(4, this.GcN);
      paramVarArgs.aS(5, this.GcO);
      paramVarArgs.aS(6, this.GcP);
      if (this.GcQ != null)
      {
        paramVarArgs.lC(7, this.GcQ.computeSize());
        this.GcQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.GcR);
      paramVarArgs.e(9, 8, this.GcS);
      paramVarArgs.aS(10, this.GcT);
      paramVarArgs.aS(11, this.GcU);
      AppMethodBeat.o(115836);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GcK) + 0;
      paramInt = i;
      if (this.GcL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GcL);
      }
      i = paramInt;
      if (this.GcM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GcM);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GcN) + f.a.a.b.b.a.bz(5, this.GcO) + f.a.a.b.b.a.bz(6, this.GcP);
      paramInt = i;
      if (this.GcQ != null) {
        paramInt = i + f.a.a.a.lB(7, this.GcQ.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.GcR);
      int j = f.a.a.a.c(9, 8, this.GcS);
      int k = f.a.a.b.b.a.bz(10, this.GcT);
      int m = f.a.a.b.b.a.bz(11, this.GcU);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GcS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aeu localaeu = (aeu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localaeu.GcK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localaeu.GcL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localaeu.GcM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localaeu.GcN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localaeu.GcO = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localaeu.GcP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaeu.GcQ = ((dwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localaeu.GcR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dyh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dyh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaeu.GcS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localaeu.GcT = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(115836);
        return 0;
      }
      localaeu.GcU = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aeu
 * JD-Core Version:    0.7.0.1
 */