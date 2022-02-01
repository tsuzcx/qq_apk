package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enb
  extends com.tencent.mm.cd.a
{
  public LinkedList<enk> KeS;
  public LinkedList<enk> KeT;
  public LinkedList<enk> KeU;
  public LinkedList<enk> KeV;
  public LinkedList<eoa> KeW;
  public LinkedList<eoa> KeX;
  
  public enb()
  {
    AppMethodBeat.i(118432);
    this.KeS = new LinkedList();
    this.KeT = new LinkedList();
    this.KeU = new LinkedList();
    this.KeV = new LinkedList();
    this.KeW = new LinkedList();
    this.KeX = new LinkedList();
    AppMethodBeat.o(118432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118433);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KeS);
      paramVarArgs.e(2, 8, this.KeT);
      paramVarArgs.e(3, 8, this.KeU);
      paramVarArgs.e(4, 8, this.KeV);
      paramVarArgs.e(5, 8, this.KeW);
      paramVarArgs.e(6, 8, this.KeX);
      AppMethodBeat.o(118433);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = g.a.a.a.c(1, 8, this.KeS);
      i = g.a.a.a.c(2, 8, this.KeT);
      int j = g.a.a.a.c(3, 8, this.KeU);
      int k = g.a.a.a.c(4, 8, this.KeV);
      int m = g.a.a.a.c(5, 8, this.KeW);
      int n = g.a.a.a.c(6, 8, this.KeX);
      AppMethodBeat.o(118433);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KeS.clear();
      this.KeT.clear();
      this.KeU.clear();
      this.KeV.clear();
      this.KeW.clear();
      this.KeX.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(118433);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      enb localenb = (enb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118433);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new enk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((enk)localObject2).parseFrom((byte[])localObject1);
          }
          localenb.KeS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118433);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new enk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((enk)localObject2).parseFrom((byte[])localObject1);
          }
          localenb.KeT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118433);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new enk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((enk)localObject2).parseFrom((byte[])localObject1);
          }
          localenb.KeU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118433);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new enk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((enk)localObject2).parseFrom((byte[])localObject1);
          }
          localenb.KeV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118433);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eoa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eoa)localObject2).parseFrom((byte[])localObject1);
          }
          localenb.KeW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118433);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eoa();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eoa)localObject2).parseFrom((byte[])localObject1);
        }
        localenb.KeX.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(118433);
      return 0;
    }
    AppMethodBeat.o(118433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enb
 * JD-Core Version:    0.7.0.1
 */