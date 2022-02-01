package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bzj
  extends dyy
{
  public String RES;
  public b Til;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152579);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Til != null) {
        paramVarArgs.c(2, this.Til);
      }
      if (this.RES != null) {
        paramVarArgs.f(3, this.RES);
      }
      AppMethodBeat.o(152579);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label408;
      }
    }
    label408:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Til != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Til);
      }
      i = paramInt;
      if (this.RES != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RES);
      }
      AppMethodBeat.o(152579);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152579);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bzj localbzj = (bzj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152579);
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
            localbzj.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(152579);
          return 0;
        case 2: 
          localbzj.Til = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(152579);
          return 0;
        }
        localbzj.RES = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152579);
        return 0;
      }
      AppMethodBeat.o(152579);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzj
 * JD-Core Version:    0.7.0.1
 */