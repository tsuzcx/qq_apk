package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class byu
  extends dyy
{
  public String ThP;
  public String ThQ;
  public String ThR;
  public int ThS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229633);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(229633);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ThP != null) {
        paramVarArgs.f(2, this.ThP);
      }
      if (this.ThQ != null) {
        paramVarArgs.f(3, this.ThQ);
      }
      paramVarArgs.aY(4, this.ThS);
      if (this.ThR != null) {
        paramVarArgs.f(5, this.ThR);
      }
      AppMethodBeat.o(229633);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label560;
      }
    }
    label560:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ThP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ThP);
      }
      i = paramInt;
      if (this.ThQ != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThQ);
      }
      i += g.a.a.b.b.a.bM(4, this.ThS);
      paramInt = i;
      if (this.ThR != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ThR);
      }
      AppMethodBeat.o(229633);
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
          AppMethodBeat.o(229633);
          throw paramVarArgs;
        }
        AppMethodBeat.o(229633);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        byu localbyu = (byu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229633);
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
            localbyu.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(229633);
          return 0;
        case 2: 
          localbyu.ThP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229633);
          return 0;
        case 3: 
          localbyu.ThQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229633);
          return 0;
        case 4: 
          localbyu.ThS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(229633);
          return 0;
        }
        localbyu.ThR = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(229633);
        return 0;
      }
      AppMethodBeat.o(229633);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byu
 * JD-Core Version:    0.7.0.1
 */