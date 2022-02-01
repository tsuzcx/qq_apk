package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class gn
  extends dyy
{
  public String RLA;
  public iv RLz;
  public int fwx;
  public String tVo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72418);
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
      if (this.RLz != null)
      {
        paramVarArgs.oE(4, this.RLz.computeSize());
        this.RLz.writeFields(paramVarArgs);
      }
      if (this.RLA != null) {
        paramVarArgs.f(5, this.RLA);
      }
      AppMethodBeat.o(72418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label634;
      }
    }
    label634:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt;
      if (this.RLz != null) {
        i = paramInt + g.a.a.a.oD(4, this.RLz.computeSize());
      }
      paramInt = i;
      if (this.RLA != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RLA);
      }
      AppMethodBeat.o(72418);
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
          AppMethodBeat.o(72418);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72418);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gn localgn = (gn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72418);
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
            localgn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72418);
          return 0;
        case 2: 
          localgn.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72418);
          return 0;
        case 3: 
          localgn.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72418);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new iv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((iv)localObject2).parseFrom((byte[])localObject1);
            }
            localgn.RLz = ((iv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72418);
          return 0;
        }
        localgn.RLA = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(72418);
        return 0;
      }
      AppMethodBeat.o(72418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gn
 * JD-Core Version:    0.7.0.1
 */