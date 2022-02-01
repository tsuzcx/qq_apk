package com.tencent.mm.plugin.sns.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public LinkedList<e> QCA;
  public LinkedList<e> QCB;
  public LinkedList<d> QCw;
  public LinkedList<d> QCx;
  public LinkedList<d> QCy;
  public LinkedList<d> QCz;
  
  public c()
  {
    AppMethodBeat.i(96154);
    this.QCw = new LinkedList();
    this.QCx = new LinkedList();
    this.QCy = new LinkedList();
    this.QCz = new LinkedList();
    this.QCA = new LinkedList();
    this.QCB = new LinkedList();
    AppMethodBeat.o(96154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96155);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.QCw);
      paramVarArgs.e(2, 8, this.QCx);
      paramVarArgs.e(3, 8, this.QCy);
      paramVarArgs.e(4, 8, this.QCz);
      paramVarArgs.e(5, 8, this.QCA);
      paramVarArgs.e(6, 8, this.QCB);
      AppMethodBeat.o(96155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.QCw);
      i = i.a.a.a.c(2, 8, this.QCx);
      int j = i.a.a.a.c(3, 8, this.QCy);
      int k = i.a.a.a.c(4, 8, this.QCz);
      int m = i.a.a.a.c(5, 8, this.QCA);
      int n = i.a.a.a.c(6, 8, this.QCB);
      AppMethodBeat.o(96155);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.QCw.clear();
      this.QCx.clear();
      this.QCy.clear();
      this.QCz.clear();
      this.QCA.clear();
      this.QCB.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(96155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(96155);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          localc.QCw.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          localc.QCx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          localc.QCy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new d();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((d)localObject2).parseFrom((byte[])localObject1);
          }
          localc.QCz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new e();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((e)localObject2).parseFrom((byte[])localObject1);
          }
          localc.QCA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(96155);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new e();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((e)localObject2).parseFrom((byte[])localObject1);
        }
        localc.QCB.add(localObject2);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.k.c
 * JD-Core Version:    0.7.0.1
 */