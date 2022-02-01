package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class xf
  extends cwj
{
  public long GoT;
  public long GoU;
  public String GoV;
  public String GoW;
  public int oGt;
  public String oGu;
  public String pqW;
  public String vvw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72458);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72458);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      paramVarArgs.aZ(4, this.GoT);
      paramVarArgs.aZ(5, this.GoU);
      if (this.GoV != null) {
        paramVarArgs.d(6, this.GoV);
      }
      if (this.GoW != null) {
        paramVarArgs.d(7, this.GoW);
      }
      if (this.vvw != null) {
        paramVarArgs.d(8, this.vvw);
      }
      if (this.pqW != null) {
        paramVarArgs.d(9, this.pqW);
      }
      AppMethodBeat.o(72458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.GoT) + f.a.a.b.b.a.p(5, this.GoU);
      paramInt = i;
      if (this.GoV != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GoV);
      }
      i = paramInt;
      if (this.GoW != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GoW);
      }
      paramInt = i;
      if (this.vvw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.vvw);
      }
      i = paramInt;
      if (this.pqW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.pqW);
      }
      AppMethodBeat.o(72458);
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
          AppMethodBeat.o(72458);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        xf localxf = (xf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72458);
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
            localxf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72458);
          return 0;
        case 2: 
          localxf.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72458);
          return 0;
        case 3: 
          localxf.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 4: 
          localxf.GoT = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72458);
          return 0;
        case 5: 
          localxf.GoU = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72458);
          return 0;
        case 6: 
          localxf.GoV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 7: 
          localxf.GoW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 8: 
          localxf.vvw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72458);
          return 0;
        }
        localxf.pqW = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72458);
        return 0;
      }
      AppMethodBeat.o(72458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xf
 * JD-Core Version:    0.7.0.1
 */