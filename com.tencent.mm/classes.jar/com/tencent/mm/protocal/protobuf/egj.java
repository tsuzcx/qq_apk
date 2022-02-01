package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egj
  extends com.tencent.mm.bx.a
{
  public int FFN;
  public LinkedList<efg> GFD;
  public LinkedList<tw> GbD;
  public int HRu;
  public String HRv;
  public String HRw;
  public int HRx;
  public fv HRy;
  
  public egj()
  {
    AppMethodBeat.i(123694);
    this.GbD = new LinkedList();
    this.GFD = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FFN);
      paramVarArgs.aS(2, this.HRu);
      if (this.HRv != null) {
        paramVarArgs.d(3, this.HRv);
      }
      if (this.HRw != null) {
        paramVarArgs.d(4, this.HRw);
      }
      paramVarArgs.aS(5, this.HRx);
      paramVarArgs.e(6, 8, this.GbD);
      if (this.HRy != null)
      {
        paramVarArgs.lC(7, this.HRy.computeSize());
        this.HRy.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.GFD);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FFN) + 0 + f.a.a.b.b.a.bz(2, this.HRu);
      paramInt = i;
      if (this.HRv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HRv);
      }
      i = paramInt;
      if (this.HRw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HRw);
      }
      i = i + f.a.a.b.b.a.bz(5, this.HRx) + f.a.a.a.c(6, 8, this.GbD);
      paramInt = i;
      if (this.HRy != null) {
        paramInt = i + f.a.a.a.lB(7, this.HRy.computeSize());
      }
      i = f.a.a.a.c(36, 8, this.GFD);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GbD.clear();
      this.GFD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      egj localegj = (egj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localegj.FFN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localegj.HRu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localegj.HRv = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localegj.HRw = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localegj.HRx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new tw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((tw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegj.GbD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new fv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((fv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localegj.HRy = ((fv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new efg();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((efg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localegj.GFD.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egj
 * JD-Core Version:    0.7.0.1
 */