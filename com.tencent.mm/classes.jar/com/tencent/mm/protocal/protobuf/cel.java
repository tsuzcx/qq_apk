package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cel
  extends cld
{
  public String DWS;
  public String DWT;
  public bgl DuB;
  public pu Duz;
  public int ntx;
  public String nty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.DuB != null)
      {
        paramVarArgs.kX(4, this.DuB.computeSize());
        this.DuB.writeFields(paramVarArgs);
      }
      if (this.DWS != null) {
        paramVarArgs.d(5, this.DWS);
      }
      if (this.DWT != null) {
        paramVarArgs.d(6, this.DWT);
      }
      if (this.Duz != null)
      {
        paramVarArgs.kX(7, this.Duz.computeSize());
        this.Duz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.DuB != null) {
        i = paramInt + f.a.a.a.kW(4, this.DuB.computeSize());
      }
      paramInt = i;
      if (this.DWS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DWS);
      }
      i = paramInt;
      if (this.DWT != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DWT);
      }
      paramInt = i;
      if (this.Duz != null) {
        paramInt = i + f.a.a.a.kW(7, this.Duz.computeSize());
      }
      AppMethodBeat.o(72563);
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
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cel localcel = (cel)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localcel.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localcel.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localcel.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bgl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bgl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcel.DuB = ((bgl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localcel.DWS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localcel.DWT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((pu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcel.Duz = ((pu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cel
 * JD-Core Version:    0.7.0.1
 */