package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bdh
  extends dyy
{
  public String OAl;
  public b SFa;
  public boolean wvU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.co(2, this.wvU);
      if (this.OAl != null) {
        paramVarArgs.f(3, this.OAl);
      }
      if (this.SFa != null) {
        paramVarArgs.c(4, this.SFa);
      }
      AppMethodBeat.o(229681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 1);
      paramInt = i;
      if (this.OAl != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.OAl);
      }
      i = paramInt;
      if (this.SFa != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.SFa);
      }
      AppMethodBeat.o(229681);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229681);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bdh localbdh = (bdh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229681);
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
            localbdh.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(229681);
          return 0;
        case 2: 
          localbdh.wvU = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(229681);
          return 0;
        case 3: 
          localbdh.OAl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(229681);
          return 0;
        }
        localbdh.SFa = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(229681);
        return 0;
      }
      AppMethodBeat.o(229681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdh
 * JD-Core Version:    0.7.0.1
 */