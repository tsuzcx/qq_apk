package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class afn
  extends cwj
{
  public String ikm;
  public String ikp;
  public String nIJ;
  public int xsB;
  public int xsC;
  public int xsD;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9591);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(9591);
        throw paramVarArgs;
      }
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(9591);
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
      if (this.nIJ != null) {
        paramVarArgs.d(4, this.nIJ);
      }
      paramVarArgs.aS(5, this.xsB);
      paramVarArgs.aS(6, this.xsC);
      paramVarArgs.aS(7, this.xsD);
      if (this.xsE != null)
      {
        paramVarArgs.lJ(8, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(9591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label892;
      }
    }
    label892:
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
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.nIJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.xsB) + f.a.a.b.b.a.bz(6, this.xsC) + f.a.a.b.b.a.bz(7, this.xsD);
      paramInt = i;
      if (this.xsE != null) {
        paramInt = i + f.a.a.a.lI(8, this.xsE.computeSize());
      }
      AppMethodBeat.o(9591);
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
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(9591);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afn localafn = (afn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9591);
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
            localafn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9591);
          return 0;
        case 2: 
          localafn.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 3: 
          localafn.ikp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 4: 
          localafn.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(9591);
          return 0;
        case 5: 
          localafn.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9591);
          return 0;
        case 6: 
          localafn.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9591);
          return 0;
        case 7: 
          localafn.xsD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(9591);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafn.xsE = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(9591);
        return 0;
      }
      AppMethodBeat.o(9591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afn
 * JD-Core Version:    0.7.0.1
 */