package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class diw
  extends com.tencent.mm.bw.a
{
  public div HQA;
  public div HQB;
  public int HQC;
  public div HQz;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123655);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HQz != null)
      {
        paramVarArgs.lJ(1, this.HQz.computeSize());
        this.HQz.writeFields(paramVarArgs);
      }
      if (this.HQA != null)
      {
        paramVarArgs.lJ(2, this.HQA.computeSize());
        this.HQA.writeFields(paramVarArgs);
      }
      if (this.HQB != null)
      {
        paramVarArgs.lJ(3, this.HQB.computeSize());
        this.HQB.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.scene);
      paramVarArgs.aS(5, this.HQC);
      AppMethodBeat.o(123655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HQz == null) {
        break label710;
      }
    }
    label710:
    for (int i = f.a.a.a.lI(1, this.HQz.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HQA != null) {
        paramInt = i + f.a.a.a.lI(2, this.HQA.computeSize());
      }
      i = paramInt;
      if (this.HQB != null) {
        i = paramInt + f.a.a.a.lI(3, this.HQB.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.scene);
      int j = f.a.a.b.b.a.bz(5, this.HQC);
      AppMethodBeat.o(123655);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123655);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        diw localdiw = (diw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123655);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new div();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((div)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiw.HQz = ((div)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new div();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((div)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiw.HQA = ((div)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new div();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((div)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdiw.HQB = ((div)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 4: 
          localdiw.scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(123655);
          return 0;
        }
        localdiw.HQC = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123655);
        return 0;
      }
      AppMethodBeat.o(123655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.diw
 * JD-Core Version:    0.7.0.1
 */