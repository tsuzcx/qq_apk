package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amo
  extends com.tencent.mm.bx.a
{
  public FinderObject Gmf;
  public int Gmg;
  public apw Gmh;
  public int dataType;
  public long id;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168953);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      paramVarArgs.aY(2, this.id);
      if (this.Gmf != null)
      {
        paramVarArgs.lC(3, this.Gmf.computeSize());
        this.Gmf.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.Gmg);
      if (this.Gmh != null)
      {
        paramVarArgs.lC(5, this.Gmh.computeSize());
        this.Gmh.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.dataType);
      AppMethodBeat.o(168953);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0 + f.a.a.b.b.a.p(2, this.id);
      paramInt = i;
      if (this.Gmf != null) {
        paramInt = i + f.a.a.a.lB(3, this.Gmf.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.Gmg);
      paramInt = i;
      if (this.Gmh != null) {
        paramInt = i + f.a.a.a.lB(5, this.Gmh.computeSize());
      }
      i = f.a.a.b.b.a.bz(6, this.dataType);
      AppMethodBeat.o(168953);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(168953);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      amo localamo = (amo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168953);
        return -1;
      case 1: 
        localamo.type = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168953);
        return 0;
      case 2: 
        localamo.id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(168953);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamo.Gmf = ((FinderObject)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      case 4: 
        localamo.Gmg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(168953);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new apw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((apw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localamo.Gmh = ((apw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168953);
        return 0;
      }
      localamo.dataType = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(168953);
      return 0;
    }
    AppMethodBeat.o(168953);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amo
 * JD-Core Version:    0.7.0.1
 */