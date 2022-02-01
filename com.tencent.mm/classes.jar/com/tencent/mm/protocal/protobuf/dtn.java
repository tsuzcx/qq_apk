package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtn
  extends cwj
{
  public String GnN;
  public String GnO;
  public String HZf;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152718);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.xsB);
      paramVarArgs.aS(3, this.xsC);
      if (this.HZf != null) {
        paramVarArgs.d(4, this.HZf);
      }
      if (this.GnN != null) {
        paramVarArgs.d(5, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(6, this.GnO);
      }
      AppMethodBeat.o(152718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsB) + f.a.a.b.b.a.bz(3, this.xsC);
      paramInt = i;
      if (this.HZf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HZf);
      }
      i = paramInt;
      if (this.GnN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GnN);
      }
      paramInt = i;
      if (this.GnO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GnO);
      }
      AppMethodBeat.o(152718);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtn localdtn = (dtn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152718);
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
            localdtn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152718);
          return 0;
        case 2: 
          localdtn.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152718);
          return 0;
        case 3: 
          localdtn.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152718);
          return 0;
        case 4: 
          localdtn.HZf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152718);
          return 0;
        case 5: 
          localdtn.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152718);
          return 0;
        }
        localdtn.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(152718);
        return 0;
      }
      AppMethodBeat.o(152718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtn
 * JD-Core Version:    0.7.0.1
 */