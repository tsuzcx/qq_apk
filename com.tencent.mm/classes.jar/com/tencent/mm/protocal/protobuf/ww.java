package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ww
  extends cwj
{
  public String GoA;
  public String Goy;
  public String Goz;
  public String uvF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124470);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124470);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Goy != null) {
        paramVarArgs.d(2, this.Goy);
      }
      if (this.uvF != null) {
        paramVarArgs.d(3, this.uvF);
      }
      if (this.Goz != null) {
        paramVarArgs.d(4, this.Goz);
      }
      if (this.GoA != null) {
        paramVarArgs.d(5, this.GoA);
      }
      AppMethodBeat.o(124470);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Goy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Goy);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvF);
      }
      paramInt = i;
      if (this.Goz != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Goz);
      }
      i = paramInt;
      if (this.GoA != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GoA);
      }
      AppMethodBeat.o(124470);
      return i;
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
          AppMethodBeat.o(124470);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124470);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ww localww = (ww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124470);
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
            localww.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124470);
          return 0;
        case 2: 
          localww.Goy = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124470);
          return 0;
        case 3: 
          localww.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124470);
          return 0;
        case 4: 
          localww.Goz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(124470);
          return 0;
        }
        localww.GoA = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124470);
        return 0;
      }
      AppMethodBeat.o(124470);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ww
 * JD-Core Version:    0.7.0.1
 */