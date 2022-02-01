package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwj
  extends com.tencent.mm.bw.a
{
  public dwz Hjn;
  public atk Hjo;
  public dwz Hjp;
  public int dez;
  public int height;
  public int hwE;
  public int retryCount;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hjn != null)
      {
        paramVarArgs.lJ(1, this.Hjn.computeSize());
        this.Hjn.writeFields(paramVarArgs);
      }
      if (this.Hjo != null)
      {
        paramVarArgs.lJ(2, this.Hjo.computeSize());
        this.Hjo.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.dez);
      paramVarArgs.aS(4, this.hwE);
      paramVarArgs.aS(5, this.width);
      paramVarArgs.aS(6, this.height);
      if (this.Hjp != null)
      {
        paramVarArgs.lJ(7, this.Hjp.computeSize());
        this.Hjp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.retryCount);
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hjn == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.a.lI(1, this.Hjn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hjo != null) {
        i = paramInt + f.a.a.a.lI(2, this.Hjo.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(3, this.dez) + f.a.a.b.b.a.bz(4, this.hwE) + f.a.a.b.b.a.bz(5, this.width) + f.a.a.b.b.a.bz(6, this.height);
      paramInt = i;
      if (this.Hjp != null) {
        paramInt = i + f.a.a.a.lI(7, this.Hjp.computeSize());
      }
      i = f.a.a.b.b.a.bz(8, this.retryCount);
      AppMethodBeat.o(169087);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bwj localbwj = (bwj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwj.Hjn = ((dwz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new atk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((atk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwj.Hjo = ((atk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localbwj.dez = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localbwj.hwE = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localbwj.width = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localbwj.height = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbwj.Hjp = ((dwz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        }
        localbwj.retryCount = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwj
 * JD-Core Version:    0.7.0.1
 */