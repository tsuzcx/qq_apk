package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ehq
  extends dyl
{
  public int CPw;
  public LinkedList<Integer> RPj;
  public String UjK;
  public int rVx;
  
  public ehq()
  {
    AppMethodBeat.i(127502);
    this.RPj = new LinkedList();
    AppMethodBeat.o(127502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127503);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UjK != null) {
        paramVarArgs.f(2, this.UjK);
      }
      paramVarArgs.aY(3, this.CPw);
      paramVarArgs.aY(4, this.rVx);
      paramVarArgs.f(5, 2, this.RPj);
      AppMethodBeat.o(127503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label515;
      }
    }
    label515:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UjK != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UjK);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.CPw);
      int j = g.a.a.b.b.a.bM(4, this.rVx);
      int k = g.a.a.a.d(5, 2, this.RPj);
      AppMethodBeat.o(127503);
      return i + paramInt + j + k;
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
        AppMethodBeat.o(127503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ehq localehq = (ehq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127503);
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
            localehq.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(127503);
          return 0;
        case 2: 
          localehq.UjK = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(127503);
          return 0;
        case 3: 
          localehq.CPw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127503);
          return 0;
        case 4: 
          localehq.rVx = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(127503);
          return 0;
        }
        localehq.RPj = new g.a.a.a.a(((g.a.a.a.a)localObject).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
        AppMethodBeat.o(127503);
        return 0;
      }
      AppMethodBeat.o(127503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehq
 * JD-Core Version:    0.7.0.1
 */