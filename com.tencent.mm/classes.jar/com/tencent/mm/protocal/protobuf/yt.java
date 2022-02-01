package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yt
  extends com.tencent.mm.bx.a
  implements deo
{
  public int FYj;
  public int FYk;
  public int FYl;
  public LinkedList<dkg> FYm;
  public LinkedList<dkg> FYn;
  public LinkedList<dkg> FYo;
  public int FYp;
  public int FYq;
  public int FYr;
  public bny FYs;
  public int Ret;
  
  public yt()
  {
    AppMethodBeat.i(143969);
    this.FYm = new LinkedList();
    this.FYn = new LinkedList();
    this.FYo = new LinkedList();
    AppMethodBeat.o(143969);
  }
  
  public final int getRet()
  {
    return this.Ret;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Ret);
      paramVarArgs.aS(2, this.FYj);
      paramVarArgs.aS(3, this.FYk);
      paramVarArgs.aS(4, this.FYl);
      paramVarArgs.e(5, 8, this.FYm);
      paramVarArgs.e(6, 8, this.FYn);
      paramVarArgs.e(7, 8, this.FYo);
      paramVarArgs.aS(8, this.FYp);
      paramVarArgs.aS(9, this.FYq);
      paramVarArgs.aS(10, this.FYr);
      if (this.FYs != null)
      {
        paramVarArgs.lC(11, this.FYs.computeSize());
        this.FYs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Ret) + 0 + f.a.a.b.b.a.bz(2, this.FYj) + f.a.a.b.b.a.bz(3, this.FYk) + f.a.a.b.b.a.bz(4, this.FYl) + f.a.a.a.c(5, 8, this.FYm) + f.a.a.a.c(6, 8, this.FYn) + f.a.a.a.c(7, 8, this.FYo) + f.a.a.b.b.a.bz(8, this.FYp) + f.a.a.b.b.a.bz(9, this.FYq) + f.a.a.b.b.a.bz(10, this.FYr);
      paramInt = i;
      if (this.FYs != null) {
        paramInt = i + f.a.a.a.lB(11, this.FYs.computeSize());
      }
      AppMethodBeat.o(143970);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FYm.clear();
      this.FYn.clear();
      this.FYo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yt localyt = (yt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143970);
        return -1;
      case 1: 
        localyt.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 2: 
        localyt.FYj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 3: 
        localyt.FYk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 4: 
        localyt.FYl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyt.FYm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyt.FYn.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dkg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyt.FYo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143970);
        return 0;
      case 8: 
        localyt.FYp = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 9: 
        localyt.FYq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      case 10: 
        localyt.FYr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143970);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bny();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyt.FYs = ((bny)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143970);
      return 0;
    }
    AppMethodBeat.o(143970);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yt
 * JD-Core Version:    0.7.0.1
 */