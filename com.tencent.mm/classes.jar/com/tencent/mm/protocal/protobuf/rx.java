package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class rx
  extends com.tencent.mm.bx.a
{
  public int FOg;
  public int FOh;
  public int FOi;
  public int FOj;
  public LinkedList<cwt> FOk;
  public String FOl;
  public SKBuiltinBuffer_t FOm;
  public int FOn;
  public int FOo;
  public LinkedList<cwt> FOp;
  public LinkedList<ry> FOq;
  public LinkedList<ry> FOr;
  public int FOs;
  public int FOt;
  public int qdX;
  
  public rx()
  {
    AppMethodBeat.i(133162);
    this.FOk = new LinkedList();
    this.FOp = new LinkedList();
    this.FOq = new LinkedList();
    this.FOr = new LinkedList();
    AppMethodBeat.o(133162);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133163);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOm == null)
      {
        paramVarArgs = new b("Not all required fields were included: AuthKey");
        AppMethodBeat.o(133163);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.FOg);
      paramVarArgs.aS(2, this.qdX);
      paramVarArgs.aS(3, this.FOh);
      paramVarArgs.aS(4, this.FOi);
      paramVarArgs.aS(5, this.FOj);
      paramVarArgs.e(6, 8, this.FOk);
      if (this.FOl != null) {
        paramVarArgs.d(7, this.FOl);
      }
      if (this.FOm != null)
      {
        paramVarArgs.lC(8, this.FOm.computeSize());
        this.FOm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.FOn);
      paramVarArgs.aS(10, this.FOo);
      paramVarArgs.e(11, 8, this.FOp);
      paramVarArgs.e(12, 8, this.FOq);
      paramVarArgs.e(13, 8, this.FOr);
      paramVarArgs.aS(14, this.FOs);
      paramVarArgs.aS(15, this.FOt);
      AppMethodBeat.o(133163);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FOg) + 0 + f.a.a.b.b.a.bz(2, this.qdX) + f.a.a.b.b.a.bz(3, this.FOh) + f.a.a.b.b.a.bz(4, this.FOi) + f.a.a.b.b.a.bz(5, this.FOj) + f.a.a.a.c(6, 8, this.FOk);
      paramInt = i;
      if (this.FOl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FOl);
      }
      i = paramInt;
      if (this.FOm != null) {
        i = paramInt + f.a.a.a.lB(8, this.FOm.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(9, this.FOn);
      int j = f.a.a.b.b.a.bz(10, this.FOo);
      int k = f.a.a.a.c(11, 8, this.FOp);
      int m = f.a.a.a.c(12, 8, this.FOq);
      int n = f.a.a.a.c(13, 8, this.FOr);
      int i1 = f.a.a.b.b.a.bz(14, this.FOs);
      int i2 = f.a.a.b.b.a.bz(15, this.FOt);
      AppMethodBeat.o(133163);
      return i + paramInt + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FOk.clear();
      this.FOp.clear();
      this.FOq.clear();
      this.FOr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FOm == null)
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
      rx localrx = (rx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133163);
        return -1;
      case 1: 
        localrx.FOg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 2: 
        localrx.qdX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 3: 
        localrx.FOh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 4: 
        localrx.FOi = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 5: 
        localrx.FOj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrx.FOk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 7: 
        localrx.FOl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(133163);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrx.FOm = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 9: 
        localrx.FOn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 10: 
        localrx.FOo = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrx.FOp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 12: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ry();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrx.FOq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ry();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localrx.FOr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133163);
        return 0;
      case 14: 
        localrx.FOs = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(133163);
        return 0;
      }
      localrx.FOt = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(133163);
      return 0;
    }
    AppMethodBeat.o(133163);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rx
 * JD-Core Version:    0.7.0.1
 */