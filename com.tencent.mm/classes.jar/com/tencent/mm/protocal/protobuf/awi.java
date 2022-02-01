package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awi
  extends cld
{
  public int DsQ;
  public qt DvD;
  public qy DvG;
  public qv DvH;
  public String DvI;
  public int ntx;
  public String nty;
  public int ocT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192654);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(192654);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.ntx);
      if (this.nty != null) {
        paramVarArgs.d(3, this.nty);
      }
      if (this.DvG != null)
      {
        paramVarArgs.kX(4, this.DvG.computeSize());
        this.DvG.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.ocT);
      paramVarArgs.aR(6, this.DsQ);
      if (this.DvH != null)
      {
        paramVarArgs.kX(7, this.DvH.computeSize());
        this.DvH.writeFields(paramVarArgs);
      }
      if (this.DvD != null)
      {
        paramVarArgs.kX(8, this.DvD.computeSize());
        this.DvD.writeFields(paramVarArgs);
      }
      if (this.DvI != null) {
        paramVarArgs.d(9, this.DvI);
      }
      AppMethodBeat.o(192654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.DvG != null) {
        i = paramInt + f.a.a.a.kW(4, this.DvG.computeSize());
      }
      i = i + f.a.a.b.b.a.bA(5, this.ocT) + f.a.a.b.b.a.bA(6, this.DsQ);
      paramInt = i;
      if (this.DvH != null) {
        paramInt = i + f.a.a.a.kW(7, this.DvH.computeSize());
      }
      i = paramInt;
      if (this.DvD != null) {
        i = paramInt + f.a.a.a.kW(8, this.DvD.computeSize());
      }
      paramInt = i;
      if (this.DvI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DvI);
      }
      AppMethodBeat.o(192654);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(192654);
          throw paramVarArgs;
        }
        AppMethodBeat.o(192654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awi localawi = (awi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(192654);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192654);
          return 0;
        case 2: 
          localawi.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192654);
          return 0;
        case 3: 
          localawi.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(192654);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawi.DvG = ((qy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192654);
          return 0;
        case 5: 
          localawi.ocT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192654);
          return 0;
        case 6: 
          localawi.DsQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(192654);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawi.DvH = ((qv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192654);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawi.DvD = ((qt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(192654);
          return 0;
        }
        localawi.DvI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(192654);
        return 0;
      }
      AppMethodBeat.o(192654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awi
 * JD-Core Version:    0.7.0.1
 */