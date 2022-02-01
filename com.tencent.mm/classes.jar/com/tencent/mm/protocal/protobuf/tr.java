package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tr
  extends dyl
{
  public String fUM;
  public String tnX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32153);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tnX != null) {
        paramVarArgs.f(2, this.tnX);
      }
      if (this.fUM != null) {
        paramVarArgs.f(3, this.fUM);
      }
      AppMethodBeat.o(32153);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label417;
      }
    }
    label417:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tnX != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tnX);
      }
      i = paramInt;
      if (this.fUM != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.fUM);
      }
      AppMethodBeat.o(32153);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32153);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        tr localtr = (tr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32153);
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
            localtr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32153);
          return 0;
        case 2: 
          localtr.tnX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32153);
          return 0;
        }
        localtr.fUM = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32153);
        return 0;
      }
      AppMethodBeat.o(32153);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tr
 * JD-Core Version:    0.7.0.1
 */