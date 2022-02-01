package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcf
  extends cwj
{
  public long GNP;
  public String GRZ;
  public qw GSa;
  public cv GSb;
  public int GSc;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.aZ(3, this.GNP);
      if (this.GSb != null)
      {
        paramVarArgs.lJ(4, this.GSb.computeSize());
        this.GSb.writeFields(paramVarArgs);
      }
      if (this.GRZ != null) {
        paramVarArgs.d(5, this.GRZ);
      }
      paramVarArgs.aS(6, this.GSc);
      if (this.GSa != null)
      {
        paramVarArgs.lJ(7, this.GSa.computeSize());
        this.GSa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.p(3, this.GNP);
      paramInt = i;
      if (this.GSb != null) {
        paramInt = i + f.a.a.a.lI(4, this.GSb.computeSize());
      }
      i = paramInt;
      if (this.GRZ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GRZ);
      }
      i += f.a.a.b.b.a.bz(6, this.GSc);
      paramInt = i;
      if (this.GSa != null) {
        paramInt = i + f.a.a.a.lI(7, this.GSa.computeSize());
      }
      AppMethodBeat.o(114788);
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
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcf localbcf = (bcf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
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
            localbcf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localbcf.OpCode = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localbcf.GNP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcf.GSb = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localbcf.GRZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localbcf.GSc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbcf.GSa = ((qw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcf
 * JD-Core Version:    0.7.0.1
 */