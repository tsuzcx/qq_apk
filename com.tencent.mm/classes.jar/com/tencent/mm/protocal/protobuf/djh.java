package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class djh
  extends com.tencent.mm.bx.a
{
  public String Gdd;
  public int HxF;
  public djs HxW;
  public LinkedList<Integer> Hyj;
  public long Id;
  
  public djh()
  {
    AppMethodBeat.i(118447);
    this.Hyj = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Id);
      if (this.Gdd != null) {
        paramVarArgs.d(2, this.Gdd);
      }
      if (this.HxW != null)
      {
        paramVarArgs.lC(3, this.HxW.computeSize());
        this.HxW.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HxF);
      paramVarArgs.f(5, 2, this.Hyj);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.Gdd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gdd);
      }
      i = paramInt;
      if (this.HxW != null) {
        i = paramInt + f.a.a.a.lB(3, this.HxW.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HxF);
      int j = f.a.a.a.d(5, 2, this.Hyj);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hyj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      djh localdjh = (djh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localdjh.Id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localdjh.Gdd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((djs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjh.HxW = ((djs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localdjh.HxF = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(118448);
        return 0;
      }
      localdjh.Hyj = new f.a.a.a.a(((f.a.a.a.a)localObject1).NPN.gxI().zr, unknownTagHandler).NPN.gxG();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djh
 * JD-Core Version:    0.7.0.1
 */