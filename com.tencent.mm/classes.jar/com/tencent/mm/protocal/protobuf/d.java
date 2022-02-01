package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends dyl
{
  public String RDi;
  public String RDj;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91313);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RDi != null) {
        paramVarArgs.f(2, this.RDi);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.RDj != null) {
        paramVarArgs.f(4, this.RDj);
      }
      AppMethodBeat.o(91313);
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
      int i = paramInt;
      if (this.RDi != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.RDi);
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.RDj != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RDj);
      }
      AppMethodBeat.o(91313);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91313);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        d locald = (d)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91313);
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
            locald.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91313);
          return 0;
        case 2: 
          locald.RDi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91313);
          return 0;
        case 3: 
          locald.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91313);
          return 0;
        }
        locald.RDj = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91313);
        return 0;
      }
      AppMethodBeat.o(91313);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.d
 * JD-Core Version:    0.7.0.1
 */