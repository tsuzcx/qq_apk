package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bcx
  extends cwj
{
  public int GSu;
  public int GSv;
  public LinkedList<bso> GSw;
  public String GSx;
  
  public bcx()
  {
    AppMethodBeat.i(196267);
    this.GSw = new LinkedList();
    AppMethodBeat.o(196267);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196268);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(196268);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GSu);
      paramVarArgs.aS(3, this.GSv);
      paramVarArgs.e(4, 8, this.GSw);
      if (this.GSx != null) {
        paramVarArgs.d(5, this.GSx);
      }
      AppMethodBeat.o(196268);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.GSu) + f.a.a.b.b.a.bz(3, this.GSv) + f.a.a.a.c(4, 8, this.GSw);
      paramInt = i;
      if (this.GSx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GSx);
      }
      AppMethodBeat.o(196268);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GSw.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(196268);
          throw paramVarArgs;
        }
        AppMethodBeat.o(196268);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcx localbcx = (bcx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196268);
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
            localbcx.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196268);
          return 0;
        case 2: 
          localbcx.GSu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196268);
          return 0;
        case 3: 
          localbcx.GSv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196268);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bso();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bso)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcx.GSw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196268);
          return 0;
        }
        localbcx.GSx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(196268);
        return 0;
      }
      AppMethodBeat.o(196268);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcx
 * JD-Core Version:    0.7.0.1
 */