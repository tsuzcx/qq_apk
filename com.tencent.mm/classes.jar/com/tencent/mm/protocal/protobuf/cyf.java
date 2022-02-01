package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cyf
  extends cld
{
  public int CNq;
  public int Ctq;
  public int EpS;
  public LinkedList<cyt> Eqk;
  public long Eql;
  
  public cyf()
  {
    AppMethodBeat.i(118445);
    this.Eqk = new LinkedList();
    AppMethodBeat.o(118445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118446);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.EpS);
      paramVarArgs.e(3, 8, this.Eqk);
      paramVarArgs.aG(4, this.Eql);
      paramVarArgs.aR(5, this.CNq);
      paramVarArgs.aR(6, this.Ctq);
      AppMethodBeat.o(118446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.EpS);
      int j = f.a.a.a.c(3, 8, this.Eqk);
      int k = f.a.a.b.b.a.q(4, this.Eql);
      int m = f.a.a.b.b.a.bA(5, this.CNq);
      int n = f.a.a.b.b.a.bA(6, this.Ctq);
      AppMethodBeat.o(118446);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Eqk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyf localcyf = (cyf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118446);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 2: 
          localcyf.EpS = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118446);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyf.Eqk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 4: 
          localcyf.Eql = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(118446);
          return 0;
        case 5: 
          localcyf.CNq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(118446);
          return 0;
        }
        localcyf.Ctq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(118446);
        return 0;
      }
      AppMethodBeat.o(118446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyf
 * JD-Core Version:    0.7.0.1
 */