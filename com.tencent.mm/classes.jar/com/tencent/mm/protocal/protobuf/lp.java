package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lp
  extends dyl
{
  public int RNt;
  public String RQy;
  public int RQz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155392);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RNt);
      if (this.RQy != null) {
        paramVarArgs.f(3, this.RQy);
      }
      paramVarArgs.aY(4, this.RQz);
      AppMethodBeat.o(155392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNt);
      paramInt = i;
      if (this.RQy != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RQy);
      }
      i = g.a.a.b.b.a.bM(4, this.RQz);
      AppMethodBeat.o(155392);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155392);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        lp locallp = (lp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155392);
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
            locallp.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(155392);
          return 0;
        case 2: 
          locallp.RNt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(155392);
          return 0;
        case 3: 
          locallp.RQy = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(155392);
          return 0;
        }
        locallp.RQz = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(155392);
        return 0;
      }
      AppMethodBeat.o(155392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lp
 * JD-Core Version:    0.7.0.1
 */