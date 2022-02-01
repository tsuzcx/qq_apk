package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efb
  extends com.tencent.mm.cd.a
{
  public efc UiA;
  public LinkedList<eff> UiB;
  public LinkedList<efd> Uiy;
  public LinkedList<efa> Uiz;
  public boolean jis;
  public boolean wNV;
  
  public efb()
  {
    AppMethodBeat.i(122527);
    this.jis = true;
    this.wNV = false;
    this.Uiy = new LinkedList();
    this.Uiz = new LinkedList();
    this.UiB = new LinkedList();
    AppMethodBeat.o(122527);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122528);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.co(1, this.jis);
      paramVarArgs.co(2, this.wNV);
      paramVarArgs.e(3, 8, this.Uiy);
      paramVarArgs.e(4, 8, this.Uiz);
      if (this.UiA != null)
      {
        paramVarArgs.oE(5, this.UiA.computeSize());
        this.UiA.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.UiB);
      AppMethodBeat.o(122528);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.gL(1) + 1 + 0 + (g.a.a.b.b.a.gL(2) + 1) + g.a.a.a.c(3, 8, this.Uiy) + g.a.a.a.c(4, 8, this.Uiz);
      paramInt = i;
      if (this.UiA != null) {
        paramInt = i + g.a.a.a.oD(5, this.UiA.computeSize());
      }
      i = g.a.a.a.c(6, 8, this.UiB);
      AppMethodBeat.o(122528);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Uiy.clear();
      this.Uiz.clear();
      this.UiB.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      efb localefb = (efb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122528);
        return -1;
      case 1: 
        localefb.jis = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(122528);
        return 0;
      case 2: 
        localefb.wNV = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(122528);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new efd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((efd)localObject2).parseFrom((byte[])localObject1);
          }
          localefb.Uiy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new efa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((efa)localObject2).parseFrom((byte[])localObject1);
          }
          localefb.Uiz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new efc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((efc)localObject2).parseFrom((byte[])localObject1);
          }
          localefb.UiA = ((efc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122528);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new eff();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((eff)localObject2).parseFrom((byte[])localObject1);
        }
        localefb.UiB.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(122528);
      return 0;
    }
    AppMethodBeat.o(122528);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efb
 * JD-Core Version:    0.7.0.1
 */