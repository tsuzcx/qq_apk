package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bkf
  extends cwj
{
  public int GXA;
  public LinkedList<cxn> GXB;
  public String GXC;
  public int GXD;
  public String GXE;
  public int GXF;
  public SKBuiltinBuffer_t GXG;
  public int GXw;
  public String GXx;
  public int GXy;
  public String GXz;
  
  public bkf()
  {
    AppMethodBeat.i(152605);
    this.GXB = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GXw);
      if (this.GXx != null) {
        paramVarArgs.d(3, this.GXx);
      }
      paramVarArgs.aS(4, this.GXy);
      if (this.GXz != null) {
        paramVarArgs.d(5, this.GXz);
      }
      paramVarArgs.aS(6, this.GXA);
      paramVarArgs.e(7, 8, this.GXB);
      if (this.GXC != null) {
        paramVarArgs.d(8, this.GXC);
      }
      paramVarArgs.aS(9, this.GXD);
      if (this.GXE != null) {
        paramVarArgs.d(10, this.GXE);
      }
      paramVarArgs.aS(11, this.GXF);
      if (this.GXG != null)
      {
        paramVarArgs.lJ(12, this.GXG.computeSize());
        this.GXG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1126;
      }
    }
    label1126:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GXw);
      paramInt = i;
      if (this.GXx != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GXx);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GXy);
      paramInt = i;
      if (this.GXz != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GXz);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GXA) + f.a.a.a.c(7, 8, this.GXB);
      paramInt = i;
      if (this.GXC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GXC);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.GXD);
      paramInt = i;
      if (this.GXE != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GXE);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GXF);
      paramInt = i;
      if (this.GXG != null) {
        paramInt = i + f.a.a.a.lI(12, this.GXG.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkf localbkf = (bkf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
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
            localbkf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localbkf.GXw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localbkf.GXx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localbkf.GXy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localbkf.GXz = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localbkf.GXA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbkf.GXB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localbkf.GXC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localbkf.GXD = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localbkf.GXE = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localbkf.GXF = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152606);
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
          localbkf.GXG = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkf
 * JD-Core Version:    0.7.0.1
 */