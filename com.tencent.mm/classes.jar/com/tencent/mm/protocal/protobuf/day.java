package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class day
  extends dyy
{
  public LinkedList<Integer> TIt;
  public LinkedList<Integer> TIu;
  
  public day()
  {
    AppMethodBeat.i(226649);
    this.TIt = new LinkedList();
    this.TIu = new LinkedList();
    AppMethodBeat.o(226649);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(226653);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.TIt);
      paramVarArgs.e(3, 2, this.TIu);
      AppMethodBeat.o(226653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 2, this.TIt);
      int j = g.a.a.a.c(3, 2, this.TIu);
      AppMethodBeat.o(226653);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TIt.clear();
        this.TIu.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(226653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        day localday = (day)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(226653);
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
            localday.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(226653);
          return 0;
        case 2: 
          localday.TIt.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
          AppMethodBeat.o(226653);
          return 0;
        }
        localday.TIu.add(Integer.valueOf(((g.a.a.a.a)localObject).abFh.AK()));
        AppMethodBeat.o(226653);
        return 0;
      }
      AppMethodBeat.o(226653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.day
 * JD-Core Version:    0.7.0.1
 */