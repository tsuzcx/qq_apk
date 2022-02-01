package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ced
  extends cld
{
  public String Aar;
  public caz CFv;
  public String Eak;
  public LinkedList<ie> Eal;
  public int ntx;
  public String nty;
  
  public ced()
  {
    AppMethodBeat.i(72553);
    this.Eal = new LinkedList();
    AppMethodBeat.o(72553);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72554);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72554);
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
      if (this.Eak != null) {
        paramVarArgs.d(4, this.Eak);
      }
      paramVarArgs.e(5, 8, this.Eal);
      if (this.CFv != null)
      {
        paramVarArgs.kX(6, this.CFv.computeSize());
        this.CFv.writeFields(paramVarArgs);
      }
      if (this.Aar != null) {
        paramVarArgs.d(7, this.Aar);
      }
      AppMethodBeat.o(72554);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.ntx);
      paramInt = i;
      if (this.nty != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nty);
      }
      i = paramInt;
      if (this.Eak != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Eak);
      }
      i += f.a.a.a.c(5, 8, this.Eal);
      paramInt = i;
      if (this.CFv != null) {
        paramInt = i + f.a.a.a.kW(6, this.CFv.computeSize());
      }
      i = paramInt;
      if (this.Aar != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Aar);
      }
      AppMethodBeat.o(72554);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eal.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72554);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72554);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ced localced = (ced)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72554);
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
            localced.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 2: 
          localced.ntx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(72554);
          return 0;
        case 3: 
          localced.nty = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 4: 
          localced.Eak = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(72554);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ie();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localced.Eal.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localced.CFv = ((caz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72554);
          return 0;
        }
        localced.Aar = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(72554);
        return 0;
      }
      AppMethodBeat.o(72554);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ced
 * JD-Core Version:    0.7.0.1
 */