package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dto
  extends cvw
{
  public int FQT;
  public int FQW;
  public int GeT;
  public String HZg;
  public int HZh;
  public int HZi;
  public int ijY;
  public String nIJ;
  public SKBuiltinBuffer_t xsE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.xsE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(148657);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nIJ != null) {
        paramVarArgs.d(2, this.nIJ);
      }
      if (this.xsE != null)
      {
        paramVarArgs.lJ(3, this.xsE.computeSize());
        this.xsE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GeT);
      if (this.HZg != null) {
        paramVarArgs.d(5, this.HZg);
      }
      paramVarArgs.aS(6, this.ijY);
      paramVarArgs.aS(7, this.HZh);
      paramVarArgs.aS(8, this.FQW);
      paramVarArgs.aS(9, this.HZi);
      paramVarArgs.aS(10, this.FQT);
      AppMethodBeat.o(148657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label914;
      }
    }
    label914:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nIJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nIJ);
      }
      i = paramInt;
      if (this.xsE != null) {
        i = paramInt + f.a.a.a.lI(3, this.xsE.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.GeT);
      paramInt = i;
      if (this.HZg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HZg);
      }
      i = f.a.a.b.b.a.bz(6, this.ijY);
      int j = f.a.a.b.b.a.bz(7, this.HZh);
      int k = f.a.a.b.b.a.bz(8, this.FQW);
      int m = f.a.a.b.b.a.bz(9, this.HZi);
      int n = f.a.a.b.b.a.bz(10, this.FQT);
      AppMethodBeat.o(148657);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.xsE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(148657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(148657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dto localdto = (dto)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148657);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdto.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 2: 
          localdto.nIJ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148657);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdto.xsE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(148657);
          return 0;
        case 4: 
          localdto.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148657);
          return 0;
        case 5: 
          localdto.HZg = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(148657);
          return 0;
        case 6: 
          localdto.ijY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148657);
          return 0;
        case 7: 
          localdto.HZh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148657);
          return 0;
        case 8: 
          localdto.FQW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148657);
          return 0;
        case 9: 
          localdto.HZi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(148657);
          return 0;
        }
        localdto.FQT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(148657);
        return 0;
      }
      AppMethodBeat.o(148657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dto
 * JD-Core Version:    0.7.0.1
 */