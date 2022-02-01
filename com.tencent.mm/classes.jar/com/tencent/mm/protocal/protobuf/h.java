package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class h
  extends dyy
{
  public String RDi;
  public String RDk;
  public ac RDu;
  public a RDv;
  public int fwx = 268513600;
  public String tVo = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91317);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91317);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      if (this.RDi != null) {
        paramVarArgs.f(4, this.RDi);
      }
      if (this.RDk != null) {
        paramVarArgs.f(5, this.RDk);
      }
      if (this.RDu != null)
      {
        paramVarArgs.oE(6, this.RDu.computeSize());
        this.RDu.writeFields(paramVarArgs);
      }
      if (this.RDv != null)
      {
        paramVarArgs.oE(7, this.RDv.computeSize());
        this.RDv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label828;
      }
    }
    label828:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.RDi != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RDi);
      }
      paramInt = i;
      if (this.RDk != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RDk);
      }
      i = paramInt;
      if (this.RDu != null) {
        i = paramInt + g.a.a.a.oD(6, this.RDu.computeSize());
      }
      paramInt = i;
      if (this.RDv != null) {
        paramInt = i + g.a.a.a.oD(7, this.RDv.computeSize());
      }
      AppMethodBeat.o(91317);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91317);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        h localh = (h)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91317);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localh.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91317);
          return 0;
        case 2: 
          localh.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91317);
          return 0;
        case 3: 
          localh.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 4: 
          localh.RDi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 5: 
          localh.RDk = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91317);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ac();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ac)localObject2).parseFrom((byte[])localObject1);
            }
            localh.RDu = ((ac)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91317);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new a();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((a)localObject2).parseFrom((byte[])localObject1);
          }
          localh.RDv = ((a)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91317);
        return 0;
      }
      AppMethodBeat.o(91317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.h
 * JD-Core Version:    0.7.0.1
 */