package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdj
  extends dyl
{
  public long Svv;
  public long TVZ;
  public long Urf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(2, this.Urf);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.bm(4, this.TVZ);
      AppMethodBeat.o(125496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.Urf);
      int j = g.a.a.b.b.a.p(3, this.Svv);
      int k = g.a.a.b.b.a.p(4, this.TVZ);
      AppMethodBeat.o(125496);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(125496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fdj localfdj = (fdj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125496);
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
            localfdj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125496);
          return 0;
        case 2: 
          localfdj.Urf = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125496);
          return 0;
        case 3: 
          localfdj.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125496);
          return 0;
        }
        localfdj.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(125496);
        return 0;
      }
      AppMethodBeat.o(125496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdj
 * JD-Core Version:    0.7.0.1
 */