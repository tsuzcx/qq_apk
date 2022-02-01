package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dtb
  extends cwj
{
  public int CreateTime;
  public String HYL;
  public String ikm;
  public String ikp;
  public String nIJ;
  public int xsB;
  public int xsC;
  public int xsD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32485);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32485);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      if (this.ikp != null) {
        paramVarArgs.d(3, this.ikp);
      }
      if (this.HYL != null) {
        paramVarArgs.d(4, this.HYL);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(5, this.nIJ);
      }
      paramVarArgs.aS(6, this.xsB);
      paramVarArgs.aS(7, this.xsC);
      paramVarArgs.aS(8, this.xsD);
      paramVarArgs.aS(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label805;
      }
    }
    label805:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ikm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ikm);
      }
      i = paramInt;
      if (this.ikp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ikp);
      }
      paramInt = i;
      if (this.HYL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HYL);
      }
      i = paramInt;
      if (this.nIJ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.nIJ);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.xsB);
      int j = f.a.a.b.b.a.bz(7, this.xsC);
      int k = f.a.a.b.b.a.bz(8, this.xsD);
      int m = f.a.a.b.b.a.bz(9, this.CreateTime);
      AppMethodBeat.o(32485);
      return i + paramInt + j + k + m;
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
          AppMethodBeat.o(32485);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dtb localdtb = (dtb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32485);
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
            localdtb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32485);
          return 0;
        case 2: 
          localdtb.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 3: 
          localdtb.ikp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 4: 
          localdtb.HYL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 5: 
          localdtb.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32485);
          return 0;
        case 6: 
          localdtb.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32485);
          return 0;
        case 7: 
          localdtb.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32485);
          return 0;
        case 8: 
          localdtb.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32485);
          return 0;
        }
        localdtb.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32485);
        return 0;
      }
      AppMethodBeat.o(32485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtb
 * JD-Core Version:    0.7.0.1
 */