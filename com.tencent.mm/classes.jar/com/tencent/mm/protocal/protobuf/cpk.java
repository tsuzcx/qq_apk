package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpk
  extends cwj
{
  public String CPZ;
  public int HAV;
  public String HAW;
  public String HAX;
  public bno HAY;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91642);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91642);
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
      paramVarArgs.aS(4, this.HAV);
      if (this.HAW != null) {
        paramVarArgs.d(5, this.HAW);
      }
      if (this.HAX != null) {
        paramVarArgs.d(6, this.HAX);
      }
      if (this.HAY != null)
      {
        paramVarArgs.lJ(7, this.HAY.computeSize());
        this.HAY.writeFields(paramVarArgs);
      }
      if (this.CPZ != null) {
        paramVarArgs.d(100, this.CPZ);
      }
      AppMethodBeat.o(91642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HAV);
      paramInt = i;
      if (this.HAW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HAW);
      }
      i = paramInt;
      if (this.HAX != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HAX);
      }
      paramInt = i;
      if (this.HAY != null) {
        paramInt = i + f.a.a.a.lI(7, this.HAY.computeSize());
      }
      i = paramInt;
      if (this.CPZ != null) {
        i = paramInt + f.a.a.b.b.a.e(100, this.CPZ);
      }
      AppMethodBeat.o(91642);
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
          AppMethodBeat.o(91642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpk localcpk = (cpk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91642);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        case 2: 
          localcpk.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91642);
          return 0;
        case 3: 
          localcpk.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 4: 
          localcpk.HAV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91642);
          return 0;
        case 5: 
          localcpk.HAW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 6: 
          localcpk.HAX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpk.HAY = ((bno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        }
        localcpk.CPZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91642);
        return 0;
      }
      AppMethodBeat.o(91642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpk
 * JD-Core Version:    0.7.0.1
 */