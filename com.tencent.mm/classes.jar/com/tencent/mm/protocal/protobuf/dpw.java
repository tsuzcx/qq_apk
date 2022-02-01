package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpw
  extends cwj
{
  public cru Gmp;
  public int HWT;
  public ctz HWU;
  public String dyI;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72589);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.oGt);
      if (this.oGu != null) {
        paramVarArgs.d(3, this.oGu);
      }
      if (this.Gmp != null)
      {
        paramVarArgs.lJ(4, this.Gmp.computeSize());
        this.Gmp.writeFields(paramVarArgs);
      }
      if (this.HWU != null)
      {
        paramVarArgs.lJ(5, this.HWU.computeSize());
        this.HWU.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.HWT);
      if (this.dyI != null) {
        paramVarArgs.d(7, this.dyI);
      }
      AppMethodBeat.o(72589);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.Gmp != null) {
        i = paramInt + f.a.a.a.lI(4, this.Gmp.computeSize());
      }
      paramInt = i;
      if (this.HWU != null) {
        paramInt = i + f.a.a.a.lI(5, this.HWU.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HWT);
      paramInt = i;
      if (this.dyI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.dyI);
      }
      AppMethodBeat.o(72589);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72589);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpw localdpw = (dpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72589);
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
            localdpw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 2: 
          localdpw.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72589);
          return 0;
        case 3: 
          localdpw.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72589);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cru();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpw.Gmp = ((cru)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ctz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ctz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpw.HWU = ((ctz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72589);
          return 0;
        case 6: 
          localdpw.HWT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72589);
          return 0;
        }
        localdpw.dyI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72589);
        return 0;
      }
      AppMethodBeat.o(72589);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpw
 * JD-Core Version:    0.7.0.1
 */