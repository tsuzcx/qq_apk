package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjz
  extends cwj
{
  public LinkedList<cjn> HwA;
  public int HwB;
  public ckc Hwy;
  public cjo Hwz;
  public int qkQ;
  public String qkR;
  
  public cjz()
  {
    AppMethodBeat.i(91591);
    this.HwA = new LinkedList();
    AppMethodBeat.o(91591);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91592);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91592);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.qkQ);
      if (this.qkR != null) {
        paramVarArgs.d(3, this.qkR);
      }
      if (this.Hwy != null)
      {
        paramVarArgs.lJ(4, this.Hwy.computeSize());
        this.Hwy.writeFields(paramVarArgs);
      }
      if (this.Hwz != null)
      {
        paramVarArgs.lJ(5, this.Hwz.computeSize());
        this.Hwz.writeFields(paramVarArgs);
      }
      paramVarArgs.e(6, 8, this.HwA);
      paramVarArgs.aS(7, this.HwB);
      AppMethodBeat.o(91592);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label962;
      }
    }
    label962:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qkQ);
      paramInt = i;
      if (this.qkR != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.qkR);
      }
      i = paramInt;
      if (this.Hwy != null) {
        i = paramInt + f.a.a.a.lI(4, this.Hwy.computeSize());
      }
      paramInt = i;
      if (this.Hwz != null) {
        paramInt = i + f.a.a.a.lI(5, this.Hwz.computeSize());
      }
      i = f.a.a.a.c(6, 8, this.HwA);
      int j = f.a.a.b.b.a.bz(7, this.HwB);
      AppMethodBeat.o(91592);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HwA.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91592);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91592);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjz localcjz = (cjz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91592);
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
            localcjz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 2: 
          localcjz.qkQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91592);
          return 0;
        case 3: 
          localcjz.qkR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91592);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjz.Hwy = ((ckc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjz.Hwz = ((cjo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjz.HwA.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91592);
          return 0;
        }
        localcjz.HwB = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91592);
        return 0;
      }
      AppMethodBeat.o(91592);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjz
 * JD-Core Version:    0.7.0.1
 */