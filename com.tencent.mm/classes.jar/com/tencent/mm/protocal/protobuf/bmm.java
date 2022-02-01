package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmm
  extends com.tencent.mm.bx.a
{
  public dkt DJU;
  public alw DJV;
  public dkt DJW;
  public int cUL;
  public int gBm;
  public int height;
  public int retryCount;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DJU != null)
      {
        paramVarArgs.kX(1, this.DJU.computeSize());
        this.DJU.writeFields(paramVarArgs);
      }
      if (this.DJV != null)
      {
        paramVarArgs.kX(2, this.DJV.computeSize());
        this.DJV.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.cUL);
      paramVarArgs.aR(4, this.gBm);
      paramVarArgs.aR(5, this.width);
      paramVarArgs.aR(6, this.height);
      if (this.DJW != null)
      {
        paramVarArgs.kX(7, this.DJW.computeSize());
        this.DJW.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.retryCount);
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DJU == null) {
        break label838;
      }
    }
    label838:
    for (paramInt = f.a.a.a.kW(1, this.DJU.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DJV != null) {
        i = paramInt + f.a.a.a.kW(2, this.DJV.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(3, this.cUL) + f.a.a.b.b.a.bA(4, this.gBm) + f.a.a.b.b.a.bA(5, this.width) + f.a.a.b.b.a.bA(6, this.height);
      paramInt = i;
      if (this.DJW != null) {
        paramInt = i + f.a.a.a.kW(7, this.DJW.computeSize());
      }
      i = f.a.a.b.b.a.bA(8, this.retryCount);
      AppMethodBeat.o(169087);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bmm localbmm = (bmm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmm.DJU = ((dkt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmm.DJV = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localbmm.cUL = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localbmm.gBm = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localbmm.width = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localbmm.height = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbmm.DJW = ((dkt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        }
        localbmm.retryCount = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmm
 * JD-Core Version:    0.7.0.1
 */