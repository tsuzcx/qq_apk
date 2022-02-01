package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import g.a.a.b;
import java.util.LinkedList;

public final class e
  extends dyy
{
  public String HlA;
  public int HlD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250523);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(250523);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HlA != null) {
        paramVarArgs.f(2, this.HlA);
      }
      paramVarArgs.aY(3, this.HlD);
      AppMethodBeat.o(250523);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HlA != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.HlA);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.HlD);
      AppMethodBeat.o(250523);
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
          AppMethodBeat.o(250523);
          throw paramVarArgs;
        }
        AppMethodBeat.o(250523);
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
          AppMethodBeat.o(250523);
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
          AppMethodBeat.o(250523);
          return 0;
        case 2: 
          locale.HlA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(250523);
          return 0;
        }
        locale.HlD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(250523);
        return 0;
      }
      AppMethodBeat.o(250523);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.e
 * JD-Core Version:    0.7.0.1
 */