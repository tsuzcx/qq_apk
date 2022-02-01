package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class e
  extends dyy
{
  public String RDk;
  public int fwx = 268513600;
  public String tVo = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91314);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91314);
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
      if (this.RDk != null) {
        paramVarArgs.f(4, this.RDk);
      }
      AppMethodBeat.o(91314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label500;
      }
    }
    label500:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.RDk != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RDk);
      }
      AppMethodBeat.o(91314);
      return i;
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
          AppMethodBeat.o(91314);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91314);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            locale.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91314);
          return 0;
        case 2: 
          locale.fwx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91314);
          return 0;
        case 3: 
          locale.tVo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91314);
          return 0;
        }
        locale.RDk = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91314);
        return 0;
      }
      AppMethodBeat.o(91314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.e
 * JD-Core Version:    0.7.0.1
 */