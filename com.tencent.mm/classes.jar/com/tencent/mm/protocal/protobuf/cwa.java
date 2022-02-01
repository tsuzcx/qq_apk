package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cwa
  extends cwj
{
  public int HGN;
  public int HGO;
  public String HsF;
  public int HsH;
  public String HsS;
  public String tsf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91672);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91672);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.tsf != null) {
        paramVarArgs.d(2, this.tsf);
      }
      if (this.HsF != null) {
        paramVarArgs.d(3, this.HsF);
      }
      paramVarArgs.aS(4, this.HGN);
      paramVarArgs.aS(5, this.HGO);
      paramVarArgs.aS(6, this.HsH);
      if (this.HsS != null) {
        paramVarArgs.d(7, this.HsS);
      }
      AppMethodBeat.o(91672);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tsf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tsf);
      }
      i = paramInt;
      if (this.HsF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HsF);
      }
      i = i + f.a.a.b.b.a.bz(4, this.HGN) + f.a.a.b.b.a.bz(5, this.HGO) + f.a.a.b.b.a.bz(6, this.HsH);
      paramInt = i;
      if (this.HsS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HsS);
      }
      AppMethodBeat.o(91672);
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
          AppMethodBeat.o(91672);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91672);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwa localcwa = (cwa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91672);
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
            localcwa.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91672);
          return 0;
        case 2: 
          localcwa.tsf = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 3: 
          localcwa.HsF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91672);
          return 0;
        case 4: 
          localcwa.HGN = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91672);
          return 0;
        case 5: 
          localcwa.HGO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91672);
          return 0;
        case 6: 
          localcwa.HsH = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91672);
          return 0;
        }
        localcwa.HsS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91672);
        return 0;
      }
      AppMethodBeat.o(91672);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwa
 * JD-Core Version:    0.7.0.1
 */