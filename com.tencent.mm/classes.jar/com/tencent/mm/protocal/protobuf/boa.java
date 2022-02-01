package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class boa
  extends dyy
{
  public String SYW;
  public String SYX;
  public fhv SZc;
  public int vht;
  public String vhu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91474);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91474);
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
      paramVarArgs.aY(4, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(5, this.vhu);
      }
      if (this.SZc != null)
      {
        paramVarArgs.oE(6, this.SZc.computeSize());
        this.SZc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91474);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label694;
      }
    }
    label694:
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
      i += g.a.a.b.b.a.bM(4, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.vhu);
      }
      i = paramInt;
      if (this.SZc != null) {
        i = paramInt + g.a.a.a.oD(6, this.SZc.computeSize());
      }
      AppMethodBeat.o(91474);
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
          AppMethodBeat.o(91474);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        boa localboa = (boa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91474);
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
            localboa.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91474);
          return 0;
        case 2: 
          localboa.SYW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 3: 
          localboa.SYX = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91474);
          return 0;
        case 4: 
          localboa.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91474);
          return 0;
        case 5: 
          localboa.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91474);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fhv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fhv)localObject2).parseFrom((byte[])localObject1);
          }
          localboa.SZc = ((fhv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91474);
        return 0;
      }
      AppMethodBeat.o(91474);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boa
 * JD-Core Version:    0.7.0.1
 */