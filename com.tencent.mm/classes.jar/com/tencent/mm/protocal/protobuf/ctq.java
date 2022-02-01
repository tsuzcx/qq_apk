package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ctq
  extends dyy
{
  public String PUo;
  public int PUp;
  public String sign;
  public String ueW;
  public String ueX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82454);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82454);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.PUo != null) {
        paramVarArgs.f(2, this.PUo);
      }
      if (this.ueW != null) {
        paramVarArgs.f(3, this.ueW);
      }
      if (this.ueX != null) {
        paramVarArgs.f(4, this.ueX);
      }
      if (this.sign != null) {
        paramVarArgs.f(5, this.sign);
      }
      paramVarArgs.aY(6, this.PUp);
      AppMethodBeat.o(82454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label624;
      }
    }
    label624:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.PUo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.PUo);
      }
      i = paramInt;
      if (this.ueW != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ueW);
      }
      paramInt = i;
      if (this.ueX != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ueX);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.sign);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.PUp);
      AppMethodBeat.o(82454);
      return i + paramInt;
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
          AppMethodBeat.o(82454);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ctq localctq = (ctq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82454);
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
            localctq.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(82454);
          return 0;
        case 2: 
          localctq.PUo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 3: 
          localctq.ueW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 4: 
          localctq.ueX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 5: 
          localctq.sign = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(82454);
          return 0;
        }
        localctq.PUp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(82454);
        return 0;
      }
      AppMethodBeat.o(82454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctq
 * JD-Core Version:    0.7.0.1
 */