package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gr
  extends com.tencent.mm.bx.a
{
  public gq CBD;
  public aov CBE;
  public String CBF;
  public String CBG;
  public String CBH;
  public cmz CBI;
  public gy CBJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123544);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBD != null)
      {
        paramVarArgs.kX(1, this.CBD.computeSize());
        this.CBD.writeFields(paramVarArgs);
      }
      if (this.CBE != null)
      {
        paramVarArgs.kX(2, this.CBE.computeSize());
        this.CBE.writeFields(paramVarArgs);
      }
      if (this.CBF != null) {
        paramVarArgs.d(3, this.CBF);
      }
      if (this.CBG != null) {
        paramVarArgs.d(4, this.CBG);
      }
      if (this.CBH != null) {
        paramVarArgs.d(5, this.CBH);
      }
      if (this.CBI != null)
      {
        paramVarArgs.kX(6, this.CBI.computeSize());
        this.CBI.writeFields(paramVarArgs);
      }
      if (this.CBJ != null)
      {
        paramVarArgs.kX(7, this.CBJ.computeSize());
        this.CBJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123544);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CBD == null) {
        break label958;
      }
    }
    label958:
    for (int i = f.a.a.a.kW(1, this.CBD.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBE != null) {
        paramInt = i + f.a.a.a.kW(2, this.CBE.computeSize());
      }
      i = paramInt;
      if (this.CBF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CBF);
      }
      paramInt = i;
      if (this.CBG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CBG);
      }
      i = paramInt;
      if (this.CBH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CBH);
      }
      paramInt = i;
      if (this.CBI != null) {
        paramInt = i + f.a.a.a.kW(6, this.CBI.computeSize());
      }
      i = paramInt;
      if (this.CBJ != null) {
        i = paramInt + f.a.a.a.kW(7, this.CBJ.computeSize());
      }
      AppMethodBeat.o(123544);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        gr localgr = (gr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123544);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgr.CBD = ((gq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgr.CBE = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        case 3: 
          localgr.CBF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 4: 
          localgr.CBG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 5: 
          localgr.CBH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(123544);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localgr.CBI = ((cmz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123544);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localgr.CBJ = ((gy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123544);
        return 0;
      }
      AppMethodBeat.o(123544);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gr
 * JD-Core Version:    0.7.0.1
 */