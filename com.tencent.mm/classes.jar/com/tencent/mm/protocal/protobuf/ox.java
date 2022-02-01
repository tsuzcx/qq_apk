package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ox
  extends dyl
{
  public int ROx;
  public b RSg;
  public String RSh;
  public int RXj;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118407);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RSg != null) {
        paramVarArgs.c(2, this.RSg);
      }
      paramVarArgs.aY(3, this.source);
      paramVarArgs.aY(4, this.RXj);
      if (this.RSh != null) {
        paramVarArgs.f(5, this.RSh);
      }
      paramVarArgs.aY(6, this.ROx);
      AppMethodBeat.o(118407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RSg != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.RSg);
      }
      i = i + g.a.a.b.b.a.bM(3, this.source) + g.a.a.b.b.a.bM(4, this.RXj);
      paramInt = i;
      if (this.RSh != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RSh);
      }
      i = g.a.a.b.b.a.bM(6, this.ROx);
      AppMethodBeat.o(118407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ox localox = (ox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118407);
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
            localox.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(118407);
          return 0;
        case 2: 
          localox.RSg = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(118407);
          return 0;
        case 3: 
          localox.source = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118407);
          return 0;
        case 4: 
          localox.RXj = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(118407);
          return 0;
        case 5: 
          localox.RSh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118407);
          return 0;
        }
        localox.ROx = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(118407);
        return 0;
      }
      AppMethodBeat.o(118407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ox
 * JD-Core Version:    0.7.0.1
 */