package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvn
  extends com.tencent.mm.bx.a
{
  public LinkedList<bvo> GPG;
  public LinkedList<bvo> GPH;
  public bvo GPI;
  public int GPJ;
  public long dAY;
  public String key;
  public int uBz;
  
  public bvn()
  {
    AppMethodBeat.i(192555);
    this.GPG = new LinkedList();
    this.GPH = new LinkedList();
    AppMethodBeat.o(192555);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192556);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GPG);
      paramVarArgs.e(2, 8, this.GPH);
      if (this.GPI != null)
      {
        paramVarArgs.lC(3, this.GPI.computeSize());
        this.GPI.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.uBz);
      paramVarArgs.aS(5, this.GPJ);
      paramVarArgs.aY(6, this.dAY);
      if (this.key != null) {
        paramVarArgs.d(7, this.key);
      }
      AppMethodBeat.o(192556);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GPG) + 0 + f.a.a.a.c(2, 8, this.GPH);
      paramInt = i;
      if (this.GPI != null) {
        paramInt = i + f.a.a.a.lB(3, this.GPI.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.uBz) + f.a.a.b.b.a.bz(5, this.GPJ) + f.a.a.b.b.a.p(6, this.dAY);
      paramInt = i;
      if (this.key != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.key);
      }
      AppMethodBeat.o(192556);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GPG.clear();
      this.GPH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(192556);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bvn localbvn = (bvn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(192556);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvn.GPG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192556);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvn.GPH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192556);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvo();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bvo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvn.GPI = ((bvo)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(192556);
        return 0;
      case 4: 
        localbvn.uBz = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(192556);
        return 0;
      case 5: 
        localbvn.GPJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(192556);
        return 0;
      case 6: 
        localbvn.dAY = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(192556);
        return 0;
      }
      localbvn.key = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(192556);
      return 0;
    }
    AppMethodBeat.o(192556);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvn
 * JD-Core Version:    0.7.0.1
 */