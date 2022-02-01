package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cij
  extends dyy
{
  public eqi TjY;
  public String Tpm;
  public String Tpn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(227252);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(227252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TjY != null)
      {
        paramVarArgs.oE(2, this.TjY.computeSize());
        this.TjY.writeFields(paramVarArgs);
      }
      if (this.Tpm != null) {
        paramVarArgs.f(3, this.Tpm);
      }
      if (this.Tpn != null) {
        paramVarArgs.f(4, this.Tpn);
      }
      AppMethodBeat.o(227252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TjY != null) {
        paramInt = i + g.a.a.a.oD(2, this.TjY.computeSize());
      }
      i = paramInt;
      if (this.Tpm != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Tpm);
      }
      paramInt = i;
      if (this.Tpn != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tpn);
      }
      AppMethodBeat.o(227252);
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
          AppMethodBeat.o(227252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(227252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cij localcij = (cij)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(227252);
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
            localcij.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(227252);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eqi)localObject2).parseFrom((byte[])localObject1);
            }
            localcij.TjY = ((eqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(227252);
          return 0;
        case 3: 
          localcij.Tpm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(227252);
          return 0;
        }
        localcij.Tpn = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(227252);
        return 0;
      }
      AppMethodBeat.o(227252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cij
 * JD-Core Version:    0.7.0.1
 */