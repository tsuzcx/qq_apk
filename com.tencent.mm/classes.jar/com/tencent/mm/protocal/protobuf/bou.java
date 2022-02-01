package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bou
  extends com.tencent.mm.bx.a
{
  public bot GJA;
  public boy GJB;
  public boz GJC;
  public int GJw;
  public box GJx;
  public bow GJy;
  public bov GJz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GJw);
      if (this.GJx != null)
      {
        paramVarArgs.lC(2, this.GJx.computeSize());
        this.GJx.writeFields(paramVarArgs);
      }
      if (this.GJy != null)
      {
        paramVarArgs.lC(3, this.GJy.computeSize());
        this.GJy.writeFields(paramVarArgs);
      }
      if (this.GJz != null)
      {
        paramVarArgs.lC(4, this.GJz.computeSize());
        this.GJz.writeFields(paramVarArgs);
      }
      if (this.GJA != null)
      {
        paramVarArgs.lC(5, this.GJA.computeSize());
        this.GJA.writeFields(paramVarArgs);
      }
      if (this.GJB != null)
      {
        paramVarArgs.lC(6, this.GJB.computeSize());
        this.GJB.writeFields(paramVarArgs);
      }
      if (this.GJC != null)
      {
        paramVarArgs.lC(7, this.GJC.computeSize());
        this.GJC.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GJw) + 0;
      paramInt = i;
      if (this.GJx != null) {
        paramInt = i + f.a.a.a.lB(2, this.GJx.computeSize());
      }
      i = paramInt;
      if (this.GJy != null) {
        i = paramInt + f.a.a.a.lB(3, this.GJy.computeSize());
      }
      paramInt = i;
      if (this.GJz != null) {
        paramInt = i + f.a.a.a.lB(4, this.GJz.computeSize());
      }
      i = paramInt;
      if (this.GJA != null) {
        i = paramInt + f.a.a.a.lB(5, this.GJA.computeSize());
      }
      paramInt = i;
      if (this.GJB != null) {
        paramInt = i + f.a.a.a.lB(6, this.GJB.computeSize());
      }
      i = paramInt;
      if (this.GJC != null) {
        i = paramInt + f.a.a.a.lB(7, this.GJC.computeSize());
      }
      AppMethodBeat.o(32324);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bou localbou = (bou)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32324);
        return -1;
      case 1: 
        localbou.GJw = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32324);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new box();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((box)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbou.GJx = ((box)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bow();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bow)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbou.GJy = ((bow)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bov();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbou.GJz = ((bov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bot();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bot)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbou.GJA = ((bot)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbou.GJB = ((boy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32324);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new boz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbou.GJC = ((boz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32324);
      return 0;
    }
    AppMethodBeat.o(32324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bou
 * JD-Core Version:    0.7.0.1
 */