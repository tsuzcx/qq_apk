package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class wi
  extends cwj
{
  public String FRb;
  public int dmy;
  public String phe;
  public String yis;
  public String yit;
  public String yiu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dmy);
      if (this.phe != null) {
        paramVarArgs.d(3, this.phe);
      }
      if (this.yis != null) {
        paramVarArgs.d(4, this.yis);
      }
      if (this.yit != null) {
        paramVarArgs.d(5, this.yit);
      }
      if (this.yiu != null) {
        paramVarArgs.d(6, this.yiu);
      }
      if (this.FRb != null) {
        paramVarArgs.d(7, this.FRb);
      }
      AppMethodBeat.o(72453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.yis != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.yis);
      }
      paramInt = i;
      if (this.yit != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yit);
      }
      i = paramInt;
      if (this.yiu != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.yiu);
      }
      paramInt = i;
      if (this.FRb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FRb);
      }
      AppMethodBeat.o(72453);
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
          AppMethodBeat.o(72453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wi localwi = (wi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72453);
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
            localwi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72453);
          return 0;
        case 2: 
          localwi.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72453);
          return 0;
        case 3: 
          localwi.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 4: 
          localwi.yis = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 5: 
          localwi.yit = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72453);
          return 0;
        case 6: 
          localwi.yiu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72453);
          return 0;
        }
        localwi.FRb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72453);
        return 0;
      }
      AppMethodBeat.o(72453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wi
 * JD-Core Version:    0.7.0.1
 */