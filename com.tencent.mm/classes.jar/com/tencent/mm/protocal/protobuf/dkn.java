package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dkn
  extends dyy
{
  public String SYW;
  public String SYX;
  public String TRN;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91607);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91607);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SYW != null) {
        paramVarArgs.f(2, this.SYW);
      }
      if (this.SYX != null) {
        paramVarArgs.f(3, this.SYX);
      }
      if (this.TRN != null) {
        paramVarArgs.f(4, this.TRN);
      }
      if (this.vhu != null) {
        paramVarArgs.f(5, this.vhu);
      }
      AppMethodBeat.o(91607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SYW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SYW);
      }
      i = paramInt;
      if (this.SYX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SYX);
      }
      paramInt = i;
      if (this.TRN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TRN);
      }
      i = paramInt;
      if (this.vhu != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.vhu);
      }
      AppMethodBeat.o(91607);
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
          AppMethodBeat.o(91607);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dkn localdkn = (dkn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91607);
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
            localdkn.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(91607);
          return 0;
        case 2: 
          localdkn.SYW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 3: 
          localdkn.SYX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91607);
          return 0;
        case 4: 
          localdkn.TRN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91607);
          return 0;
        }
        localdkn.vhu = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91607);
        return 0;
      }
      AppMethodBeat.o(91607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkn
 * JD-Core Version:    0.7.0.1
 */