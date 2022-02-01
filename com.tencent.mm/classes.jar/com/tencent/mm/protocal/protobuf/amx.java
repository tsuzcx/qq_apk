package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amx
  extends dyl
{
  public String SwW;
  public String SwX;
  public int jUk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.jUk);
      if (this.SwW != null) {
        paramVarArgs.f(3, this.SwW);
      }
      if (this.SwX != null) {
        paramVarArgs.f(4, this.SwX);
      }
      AppMethodBeat.o(155405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label452;
      }
    }
    label452:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.jUk);
      paramInt = i;
      if (this.SwW != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SwW);
      }
      i = paramInt;
      if (this.SwX != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.SwX);
      }
      AppMethodBeat.o(155405);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        amx localamx = (amx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155405);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localamx.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(155405);
          return 0;
        case 2: 
          localamx.jUk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(155405);
          return 0;
        case 3: 
          localamx.SwW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155405);
          return 0;
        }
        localamx.SwX = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(155405);
        return 0;
      }
      AppMethodBeat.o(155405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amx
 * JD-Core Version:    0.7.0.1
 */