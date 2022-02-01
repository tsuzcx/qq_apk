package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ciq
  extends cwj
{
  public String AesKey;
  public String GCa;
  public String HuW;
  public int Hva;
  public String Hvb;
  public int Hvc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218929);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(218929);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HuW != null) {
        paramVarArgs.d(2, this.HuW);
      }
      if (this.GCa != null) {
        paramVarArgs.d(3, this.GCa);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(4, this.AesKey);
      }
      paramVarArgs.aS(6, this.Hva);
      if (this.Hvb != null) {
        paramVarArgs.d(8, this.Hvb);
      }
      paramVarArgs.aS(9, this.Hvc);
      AppMethodBeat.o(218929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label702;
      }
    }
    label702:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HuW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HuW);
      }
      i = paramInt;
      if (this.GCa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GCa);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.AesKey);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Hva);
      paramInt = i;
      if (this.Hvb != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hvb);
      }
      i = f.a.a.b.b.a.bz(9, this.Hvc);
      AppMethodBeat.o(218929);
      return paramInt + i;
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
          AppMethodBeat.o(218929);
          throw paramVarArgs;
        }
        AppMethodBeat.o(218929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ciq localciq = (ciq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        case 7: 
        default: 
          AppMethodBeat.o(218929);
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
            localciq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218929);
          return 0;
        case 2: 
          localciq.HuW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218929);
          return 0;
        case 3: 
          localciq.GCa = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218929);
          return 0;
        case 4: 
          localciq.AesKey = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218929);
          return 0;
        case 6: 
          localciq.Hva = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(218929);
          return 0;
        case 8: 
          localciq.Hvb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(218929);
          return 0;
        }
        localciq.Hvc = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(218929);
        return 0;
      }
      AppMethodBeat.o(218929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ciq
 * JD-Core Version:    0.7.0.1
 */