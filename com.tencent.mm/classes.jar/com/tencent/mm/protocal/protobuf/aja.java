package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class aja
  extends cwj
{
  public int GyF;
  public int dmy;
  public String phe;
  public String qlv;
  public String vwq;
  public String vxL;
  public String vxM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91455);
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
      if (this.vwq != null) {
        paramVarArgs.d(4, this.vwq);
      }
      if (this.qlv != null) {
        paramVarArgs.d(5, this.qlv);
      }
      paramVarArgs.aS(6, this.GyF);
      if (this.vxM != null) {
        paramVarArgs.d(7, this.vxM);
      }
      if (this.vxL != null) {
        paramVarArgs.d(8, this.vxL);
      }
      AppMethodBeat.o(91455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dmy);
      paramInt = i;
      if (this.phe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.phe);
      }
      i = paramInt;
      if (this.vwq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.vwq);
      }
      paramInt = i;
      if (this.qlv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.qlv);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GyF);
      paramInt = i;
      if (this.vxM != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vxM);
      }
      i = paramInt;
      if (this.vxL != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vxL);
      }
      AppMethodBeat.o(91455);
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
          AppMethodBeat.o(91455);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aja localaja = (aja)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91455);
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
            localaja.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91455);
          return 0;
        case 2: 
          localaja.dmy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91455);
          return 0;
        case 3: 
          localaja.phe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 4: 
          localaja.vwq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 5: 
          localaja.qlv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91455);
          return 0;
        case 6: 
          localaja.GyF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91455);
          return 0;
        case 7: 
          localaja.vxM = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91455);
          return 0;
        }
        localaja.vxL = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91455);
        return 0;
      }
      AppMethodBeat.o(91455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aja
 * JD-Core Version:    0.7.0.1
 */