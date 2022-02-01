package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bjr
  extends cwj
{
  public int GXf;
  public LinkedList<crf> GXg;
  public int GXh;
  public int GXi;
  public int GXj;
  public bmx GXk;
  public LinkedList<bl> uuD;
  public LinkedList<bmy> uug;
  
  public bjr()
  {
    AppMethodBeat.i(152598);
    this.GXg = new LinkedList();
    this.uuD = new LinkedList();
    this.uug = new LinkedList();
    AppMethodBeat.o(152598);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152599);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152599);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GXf);
      paramVarArgs.e(3, 8, this.GXg);
      paramVarArgs.aS(4, this.GXh);
      paramVarArgs.aS(5, this.GXi);
      paramVarArgs.e(6, 8, this.uuD);
      paramVarArgs.aS(7, this.GXj);
      paramVarArgs.e(8, 8, this.uug);
      if (this.GXk != null)
      {
        paramVarArgs.lJ(9, this.GXk.computeSize());
        this.GXk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152599);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1102;
      }
    }
    label1102:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GXf) + f.a.a.a.c(3, 8, this.GXg) + f.a.a.b.b.a.bz(4, this.GXh) + f.a.a.b.b.a.bz(5, this.GXi) + f.a.a.a.c(6, 8, this.uuD) + f.a.a.b.b.a.bz(7, this.GXj) + f.a.a.a.c(8, 8, this.uug);
      paramInt = i;
      if (this.GXk != null) {
        paramInt = i + f.a.a.a.lI(9, this.GXk.computeSize());
      }
      AppMethodBeat.o(152599);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXg.clear();
        this.uuD.clear();
        this.uug.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152599);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjr localbjr = (bjr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152599);
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
            localbjr.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 2: 
          localbjr.GXf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjr.GXg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 4: 
          localbjr.GXh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 5: 
          localbjr.GXi = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bl();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjr.uuD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        case 7: 
          localbjr.GXj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152599);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bmy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bmy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjr.uug.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152599);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjr.GXk = ((bmx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152599);
        return 0;
      }
      AppMethodBeat.o(152599);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjr
 * JD-Core Version:    0.7.0.1
 */