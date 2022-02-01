package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awm
  extends cld
{
  public int DsQ;
  public bya DvL;
  public byb DvM;
  public byb DvN;
  public int ntx;
  public String nty;
  public int ocT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114033);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114033);
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
      paramVarArgs.aR(4, this.ocT);
      paramVarArgs.aR(5, this.DsQ);
      if (this.DvL != null)
      {
        paramVarArgs.kX(6, this.DvL.computeSize());
        this.DvL.writeFields(paramVarArgs);
      }
      if (this.DvM != null)
      {
        paramVarArgs.kX(7, this.DvM.computeSize());
        this.DvM.writeFields(paramVarArgs);
      }
      if (this.DvN != null)
      {
        paramVarArgs.kX(8, this.DvN.computeSize());
        this.DvN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114033);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.ocT) + f.a.a.b.b.a.bA(5, this.DsQ);
      paramInt = i;
      if (this.DvL != null) {
        paramInt = i + f.a.a.a.kW(6, this.DvL.computeSize());
      }
      i = paramInt;
      if (this.DvM != null) {
        i = paramInt + f.a.a.a.kW(7, this.DvM.computeSize());
      }
      paramInt = i;
      if (this.DvN != null) {
        paramInt = i + f.a.a.a.kW(8, this.DvN.computeSize());
      }
      AppMethodBeat.o(114033);
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
          AppMethodBeat.o(114033);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awm localawm = (awm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114033);
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
            localawm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 2: 
          localawm.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114033);
          return 0;
        case 3: 
          localawm.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(114033);
          return 0;
        case 4: 
          localawm.ocT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114033);
          return 0;
        case 5: 
          localawm.DsQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(114033);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bya();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bya)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawm.DvL = ((bya)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawm.DvM = ((byb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114033);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((byb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawm.DvN = ((byb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114033);
        return 0;
      }
      AppMethodBeat.o(114033);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awm
 * JD-Core Version:    0.7.0.1
 */