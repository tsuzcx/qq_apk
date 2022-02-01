package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bg
  extends com.tencent.mm.bx.a
{
  public bh CvC;
  public bh CvD;
  public bh CvE;
  public bh CvF;
  public bh CvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CvC != null)
      {
        paramVarArgs.kX(1, this.CvC.computeSize());
        this.CvC.writeFields(paramVarArgs);
      }
      if (this.CvD != null)
      {
        paramVarArgs.kX(2, this.CvD.computeSize());
        this.CvD.writeFields(paramVarArgs);
      }
      if (this.CvE != null)
      {
        paramVarArgs.kX(3, this.CvE.computeSize());
        this.CvE.writeFields(paramVarArgs);
      }
      if (this.CvF != null)
      {
        paramVarArgs.kX(4, this.CvF.computeSize());
        this.CvF.writeFields(paramVarArgs);
      }
      if (this.CvG != null)
      {
        paramVarArgs.kX(5, this.CvG.computeSize());
        this.CvG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CvC == null) {
        break label926;
      }
    }
    label926:
    for (int i = f.a.a.a.kW(1, this.CvC.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CvD != null) {
        paramInt = i + f.a.a.a.kW(2, this.CvD.computeSize());
      }
      i = paramInt;
      if (this.CvE != null) {
        i = paramInt + f.a.a.a.kW(3, this.CvE.computeSize());
      }
      paramInt = i;
      if (this.CvF != null) {
        paramInt = i + f.a.a.a.kW(4, this.CvF.computeSize());
      }
      i = paramInt;
      if (this.CvG != null) {
        i = paramInt + f.a.a.a.kW(5, this.CvG.computeSize());
      }
      AppMethodBeat.o(122481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bg localbg = (bg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122481);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbg.CvC = ((bh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbg.CvD = ((bh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbg.CvE = ((bh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbg.CvF = ((bh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122481);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbg.CvG = ((bh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122481);
        return 0;
      }
      AppMethodBeat.o(122481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bg
 * JD-Core Version:    0.7.0.1
 */