package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ke
  extends dyl
{
  public LinkedList<Integer> RPj;
  public int rVx;
  
  public ke()
  {
    AppMethodBeat.i(127436);
    this.RPj = new LinkedList();
    AppMethodBeat.o(127436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.f(3, 2, this.RPj);
      AppMethodBeat.o(127437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label407;
      }
    }
    label407:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.d(3, 2, this.RPj);
      AppMethodBeat.o(127437);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RPj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(127437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ke localke = (ke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127437);
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
            localke.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(127437);
          return 0;
        case 2: 
          localke.rVx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127437);
          return 0;
        }
        localke.RPj = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(127437);
        return 0;
      }
      AppMethodBeat.o(127437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ke
 * JD-Core Version:    0.7.0.1
 */