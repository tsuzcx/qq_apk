package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class x
  extends dyy
{
  public String HmA;
  public String HmB;
  public String Hmz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249908);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(249908);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hmz != null) {
        paramVarArgs.f(2, this.Hmz);
      }
      if (this.HmA != null) {
        paramVarArgs.f(3, this.HmA);
      }
      if (this.HmB != null) {
        paramVarArgs.f(4, this.HmB);
      }
      AppMethodBeat.o(249908);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label516;
      }
    }
    label516:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hmz != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Hmz);
      }
      i = paramInt;
      if (this.HmA != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.HmA);
      }
      paramInt = i;
      if (this.HmB != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.HmB);
      }
      AppMethodBeat.o(249908);
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
          AppMethodBeat.o(249908);
          throw paramVarArgs;
        }
        AppMethodBeat.o(249908);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        x localx = (x)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249908);
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
            localx.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(249908);
          return 0;
        case 2: 
          localx.Hmz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249908);
          return 0;
        case 3: 
          localx.HmA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249908);
          return 0;
        }
        localx.HmB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(249908);
        return 0;
      }
      AppMethodBeat.o(249908);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.x
 * JD-Core Version:    0.7.0.1
 */