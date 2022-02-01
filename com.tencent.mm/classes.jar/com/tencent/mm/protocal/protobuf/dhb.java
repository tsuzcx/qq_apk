package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhb
  extends com.tencent.mm.bw.a
{
  public int HOa;
  public dif HOb;
  public cqp HOc;
  public aec HOd;
  public cmt HOe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HOa);
      if (this.HOb != null)
      {
        paramVarArgs.lJ(2, this.HOb.computeSize());
        this.HOb.writeFields(paramVarArgs);
      }
      if (this.HOc != null)
      {
        paramVarArgs.lJ(3, this.HOc.computeSize());
        this.HOc.writeFields(paramVarArgs);
      }
      if (this.HOd != null)
      {
        paramVarArgs.lJ(4, this.HOd.computeSize());
        this.HOd.writeFields(paramVarArgs);
      }
      if (this.HOe != null)
      {
        paramVarArgs.lJ(5, this.HOe.computeSize());
        this.HOe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.HOa) + 0;
      paramInt = i;
      if (this.HOb != null) {
        paramInt = i + f.a.a.a.lI(2, this.HOb.computeSize());
      }
      i = paramInt;
      if (this.HOc != null) {
        i = paramInt + f.a.a.a.lI(3, this.HOc.computeSize());
      }
      paramInt = i;
      if (this.HOd != null) {
        paramInt = i + f.a.a.a.lI(4, this.HOd.computeSize());
      }
      i = paramInt;
      if (this.HOe != null) {
        i = paramInt + f.a.a.a.lI(5, this.HOe.computeSize());
      }
      AppMethodBeat.o(125802);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dhb localdhb = (dhb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125802);
        return -1;
      case 1: 
        localdhb.HOa = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125802);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dif();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dif)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhb.HOb = ((dif)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cqp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cqp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhb.HOc = ((cqp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aec();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aec)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhb.HOd = ((aec)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125802);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cmt();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((cmt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdhb.HOe = ((cmt)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125802);
      return 0;
    }
    AppMethodBeat.o(125802);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhb
 * JD-Core Version:    0.7.0.1
 */