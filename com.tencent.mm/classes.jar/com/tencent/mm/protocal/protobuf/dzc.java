package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzc
  extends cwj
{
  public long Gxr;
  public long HSD;
  public int Iee;
  public int Ief;
  public int Ieg;
  public int Ieh;
  public com.tencent.mm.bw.b Iei;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.HSD);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.Iee);
      paramVarArgs.aS(5, this.Ief);
      paramVarArgs.aS(6, this.Ieg);
      paramVarArgs.aS(7, this.Ieh);
      if (this.Iei != null) {
        paramVarArgs.c(8, this.Iei);
      }
      AppMethodBeat.o(125510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.HSD) + f.a.a.b.b.a.p(3, this.Gxr) + f.a.a.b.b.a.bz(4, this.Iee) + f.a.a.b.b.a.bz(5, this.Ief) + f.a.a.b.b.a.bz(6, this.Ieg) + f.a.a.b.b.a.bz(7, this.Ieh);
      paramInt = i;
      if (this.Iei != null) {
        paramInt = i + f.a.a.b.b.a.b(8, this.Iei);
      }
      AppMethodBeat.o(125510);
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
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzc localdzc = (dzc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
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
            localdzc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localdzc.HSD = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localdzc.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localdzc.Iee = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localdzc.Ief = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localdzc.Ieg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localdzc.Ieh = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125510);
          return 0;
        }
        localdzc.Iei = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzc
 * JD-Core Version:    0.7.0.1
 */