package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class bkp
  extends cwj
{
  public int FRO;
  public String GXS;
  public String GXT;
  public LinkedList<String> GXU;
  
  public bkp()
  {
    AppMethodBeat.i(147767);
    this.GXU = new LinkedList();
    AppMethodBeat.o(147767);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147768);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147768);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.GXS != null) {
        paramVarArgs.d(2, this.GXS);
      }
      paramVarArgs.aS(3, this.FRO);
      if (this.GXT != null) {
        paramVarArgs.d(4, this.GXT);
      }
      paramVarArgs.e(5, 1, this.GXU);
      AppMethodBeat.o(147768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GXS != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GXS);
      }
      i += f.a.a.b.b.a.bz(3, this.FRO);
      paramInt = i;
      if (this.GXT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GXT);
      }
      i = f.a.a.a.c(5, 1, this.GXU);
      AppMethodBeat.o(147768);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(147768);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147768);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkp localbkp = (bkp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147768);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147768);
          return 0;
        case 2: 
          localbkp.GXS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147768);
          return 0;
        case 3: 
          localbkp.FRO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(147768);
          return 0;
        case 4: 
          localbkp.GXT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(147768);
          return 0;
        }
        localbkp.GXU.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(147768);
        return 0;
      }
      AppMethodBeat.o(147768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkp
 * JD-Core Version:    0.7.0.1
 */