package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class awp
  extends cwj
{
  public bqc GOk;
  public bqd GOl;
  public int dxd;
  public String dxe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72477);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72477);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dxd);
      if (this.dxe != null) {
        paramVarArgs.d(3, this.dxe);
      }
      if (this.GOk != null)
      {
        paramVarArgs.lJ(4, this.GOk.computeSize());
        this.GOk.writeFields(paramVarArgs);
      }
      if (this.GOl != null)
      {
        paramVarArgs.lJ(5, this.GOl.computeSize());
        this.GOl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72477);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label770;
      }
    }
    label770:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dxd);
      paramInt = i;
      if (this.dxe != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dxe);
      }
      i = paramInt;
      if (this.GOk != null) {
        i = paramInt + f.a.a.a.lI(4, this.GOk.computeSize());
      }
      paramInt = i;
      if (this.GOl != null) {
        paramInt = i + f.a.a.a.lI(5, this.GOl.computeSize());
      }
      AppMethodBeat.o(72477);
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
          AppMethodBeat.o(72477);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        awp localawp = (awp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72477);
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
            localawp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        case 2: 
          localawp.dxd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(72477);
          return 0;
        case 3: 
          localawp.dxe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72477);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bqc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bqc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localawp.GOk = ((bqc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72477);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bqd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bqd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localawp.GOl = ((bqd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72477);
        return 0;
      }
      AppMethodBeat.o(72477);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awp
 * JD-Core Version:    0.7.0.1
 */