package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cpi
  extends cwj
{
  public bpf GSB;
  public ru GSz;
  public String Hxq;
  public String Hxr;
  public int oGt;
  public String oGu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.GSB != null)
      {
        paramVarArgs.lJ(4, this.GSB.computeSize());
        this.GSB.writeFields(paramVarArgs);
      }
      if (this.Hxq != null) {
        paramVarArgs.d(5, this.Hxq);
      }
      if (this.Hxr != null) {
        paramVarArgs.d(6, this.Hxr);
      }
      if (this.GSz != null)
      {
        paramVarArgs.lJ(7, this.GSz.computeSize());
        this.GSz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.oGt);
      paramInt = i;
      if (this.oGu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGu);
      }
      i = paramInt;
      if (this.GSB != null) {
        i = paramInt + f.a.a.a.lI(4, this.GSB.computeSize());
      }
      paramInt = i;
      if (this.Hxq != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hxq);
      }
      i = paramInt;
      if (this.Hxr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hxr);
      }
      paramInt = i;
      if (this.GSz != null) {
        paramInt = i + f.a.a.a.lI(7, this.GSz.computeSize());
      }
      AppMethodBeat.o(72563);
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
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpi localcpi = (cpi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localcpi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localcpi.oGt = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localcpi.oGu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpi.GSB = ((bpf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localcpi.Hxq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localcpi.Hxr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ru();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ru)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcpi.GSz = ((ru)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpi
 * JD-Core Version:    0.7.0.1
 */