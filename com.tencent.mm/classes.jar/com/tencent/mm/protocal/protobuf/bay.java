package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bay
  extends ckq
{
  public int DyI;
  public int rZJ;
  public String sbA;
  public LinkedList<cmf> sch;
  public int scx;
  public int scy;
  
  public bay()
  {
    AppMethodBeat.i(152596);
    this.sch = new LinkedList();
    AppMethodBeat.o(152596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152597);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.rZJ);
      paramVarArgs.aR(3, this.scx);
      paramVarArgs.aR(4, this.scy);
      if (this.sbA != null) {
        paramVarArgs.d(5, this.sbA);
      }
      paramVarArgs.aR(6, this.DyI);
      paramVarArgs.e(7, 8, this.sch);
      AppMethodBeat.o(152597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.rZJ) + f.a.a.b.b.a.bA(3, this.scx) + f.a.a.b.b.a.bA(4, this.scy);
      paramInt = i;
      if (this.sbA != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.sbA);
      }
      i = f.a.a.b.b.a.bA(6, this.DyI);
      int j = f.a.a.a.c(7, 8, this.sch);
      AppMethodBeat.o(152597);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sch.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bay localbay = (bay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152597);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbay.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152597);
          return 0;
        case 2: 
          localbay.rZJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152597);
          return 0;
        case 3: 
          localbay.scx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152597);
          return 0;
        case 4: 
          localbay.scy = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152597);
          return 0;
        case 5: 
          localbay.sbA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152597);
          return 0;
        case 6: 
          localbay.DyI = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152597);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbay.sch.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      AppMethodBeat.o(152597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bay
 * JD-Core Version:    0.7.0.1
 */