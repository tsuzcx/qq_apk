package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dyi
  extends cwj
{
  public int Gxq;
  public long Gxr;
  public int Idk;
  public int Idt;
  public dzx Idu;
  public int Idv;
  public int Idw;
  public int Idx;
  public int Idy;
  public SKBuiltinBuffer_t Idz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115859);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(115859);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.Idt);
      if (this.Idu != null)
      {
        paramVarArgs.lJ(5, this.Idu.computeSize());
        this.Idu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.Idk);
      paramVarArgs.aS(7, this.Idv);
      paramVarArgs.aS(8, this.Idw);
      paramVarArgs.aS(9, this.Idx);
      paramVarArgs.aS(10, this.Idy);
      if (this.Idz != null)
      {
        paramVarArgs.lJ(11, this.Idz.computeSize());
        this.Idz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115859);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1018;
      }
    }
    label1018:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Gxq) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.b.b.a.bz(4, this.Idt);
      paramInt = i;
      if (this.Idu != null) {
        paramInt = i + f.a.a.a.lI(5, this.Idu.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Idk) + f.a.a.b.b.a.bz(7, this.Idv) + f.a.a.b.b.a.bz(8, this.Idw) + f.a.a.b.b.a.bz(9, this.Idx) + f.a.a.b.b.a.bz(10, this.Idy);
      paramInt = i;
      if (this.Idz != null) {
        paramInt = i + f.a.a.a.lI(11, this.Idz.computeSize());
      }
      AppMethodBeat.o(115859);
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
          AppMethodBeat.o(115859);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyi localdyi = (dyi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115859);
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
            localdyi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 2: 
          localdyi.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 3: 
          localdyi.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115859);
          return 0;
        case 4: 
          localdyi.Idt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyi.Idu = ((dzx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115859);
          return 0;
        case 6: 
          localdyi.Idk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 7: 
          localdyi.Idv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 8: 
          localdyi.Idw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 9: 
          localdyi.Idx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
          return 0;
        case 10: 
          localdyi.Idy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115859);
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
          localdyi.Idz = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115859);
        return 0;
      }
      AppMethodBeat.o(115859);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyi
 * JD-Core Version:    0.7.0.1
 */