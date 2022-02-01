package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.cd.a
{
  public LinkedList<e> KeS;
  public LinkedList<e> KeT;
  public LinkedList<e> KeU;
  public LinkedList<e> KeV;
  public LinkedList<f> KeW;
  public LinkedList<f> KeX;
  
  public d()
  {
    AppMethodBeat.i(96154);
    this.KeS = new LinkedList();
    this.KeT = new LinkedList();
    this.KeU = new LinkedList();
    this.KeV = new LinkedList();
    this.KeW = new LinkedList();
    this.KeX = new LinkedList();
    AppMethodBeat.o(96154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96155);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.KeS);
      paramVarArgs.e(2, 8, this.KeT);
      paramVarArgs.e(3, 8, this.KeU);
      paramVarArgs.e(4, 8, this.KeV);
      paramVarArgs.e(5, 8, this.KeW);
      paramVarArgs.e(6, 8, this.KeX);
      AppMethodBeat.o(96155);
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
      AppMethodBeat.o(96155);
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
      AppMethodBeat.o(96155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96155);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new e();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((e)localObject2).parseFrom((byte[])localObject1);
          }
          locald.KeS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new e();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((e)localObject2).parseFrom((byte[])localObject1);
          }
          locald.KeT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new e();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((e)localObject2).parseFrom((byte[])localObject1);
          }
          locald.KeU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new e();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((e)localObject2).parseFrom((byte[])localObject1);
          }
          locald.KeV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new f();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((f)localObject2).parseFrom((byte[])localObject1);
          }
          locald.KeW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new f();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((f)localObject2).parseFrom((byte[])localObject1);
        }
        locald.KeX.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(96155);
      return 0;
    }
    AppMethodBeat.o(96155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.d
 * JD-Core Version:    0.7.0.1
 */