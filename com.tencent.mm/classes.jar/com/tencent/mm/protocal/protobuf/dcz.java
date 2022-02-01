package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dcz
  extends cvp
{
  public LinkedList<dcx> HrI;
  public int HrJ;
  public int Ret;
  public int nDi;
  public String wMs;
  
  public dcz()
  {
    AppMethodBeat.i(32442);
    this.HrI = new LinkedList();
    AppMethodBeat.o(32442);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32443);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32443);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.nDi);
      paramVarArgs.e(3, 8, this.HrI);
      if (this.wMs != null) {
        paramVarArgs.d(4, this.wMs);
      }
      paramVarArgs.aS(5, this.HrJ);
      paramVarArgs.aS(6, this.Ret);
      AppMethodBeat.o(32443);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nDi) + f.a.a.a.c(3, 8, this.HrI);
      paramInt = i;
      if (this.wMs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wMs);
      }
      i = f.a.a.b.b.a.bz(5, this.HrJ);
      int j = f.a.a.b.b.a.bz(6, this.Ret);
      AppMethodBeat.o(32443);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HrI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32443);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32443);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcz localdcz = (dcz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32443);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 2: 
          localdcz.nDi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32443);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcz.HrI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32443);
          return 0;
        case 4: 
          localdcz.wMs = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32443);
          return 0;
        case 5: 
          localdcz.HrJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32443);
          return 0;
        }
        localdcz.Ret = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32443);
        return 0;
      }
      AppMethodBeat.o(32443);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcz
 * JD-Core Version:    0.7.0.1
 */