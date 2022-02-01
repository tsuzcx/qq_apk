package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwg
  extends com.tencent.mm.bx.a
{
  public LinkedList<byg> BGy;
  public long FCY;
  public LinkedList<agd> GPp;
  public cbu HIK;
  public LinkedList<dmn> HIL;
  
  public dwg()
  {
    AppMethodBeat.i(110917);
    this.HIL = new LinkedList();
    this.GPp = new LinkedList();
    this.BGy = new LinkedList();
    AppMethodBeat.o(110917);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FCY);
      if (this.HIK != null)
      {
        paramVarArgs.lC(2, this.HIK.computeSize());
        this.HIK.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.HIL);
      paramVarArgs.e(4, 8, this.GPp);
      paramVarArgs.e(5, 8, this.BGy);
      AppMethodBeat.o(110918);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FCY) + 0;
      paramInt = i;
      if (this.HIK != null) {
        paramInt = i + f.a.a.a.lB(2, this.HIK.computeSize());
      }
      i = f.a.a.a.c(3, 8, this.HIL);
      int j = f.a.a.a.c(4, 8, this.GPp);
      int k = f.a.a.a.c(5, 8, this.BGy);
      AppMethodBeat.o(110918);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HIL.clear();
      this.GPp.clear();
      this.BGy.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dwg localdwg = (dwg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110918);
        return -1;
      case 1: 
        localdwg.FCY = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110918);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cbu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cbu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwg.HIK = ((cbu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dmn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dmn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwg.HIL.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new agd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((agd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdwg.GPp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110918);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new byg();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((byg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdwg.BGy.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(110918);
      return 0;
    }
    AppMethodBeat.o(110918);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwg
 * JD-Core Version:    0.7.0.1
 */