package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class so
  extends dyl
{
  public LinkedList<Integer> SbO;
  public sm SbX;
  public int scene;
  
  public so()
  {
    AppMethodBeat.i(247714);
    this.SbO = new LinkedList();
    AppMethodBeat.o(247714);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(247717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.SbO);
      if (this.SbX != null)
      {
        paramVarArgs.oE(3, this.SbX.computeSize());
        this.SbX.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.scene);
      AppMethodBeat.o(247717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 2, this.SbO);
      paramInt = i;
      if (this.SbX != null) {
        paramInt = i + g.a.a.a.oD(3, this.SbX.computeSize());
      }
      i = g.a.a.b.b.a.bM(4, this.scene);
      AppMethodBeat.o(247717);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SbO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(247717);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(247717);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localso.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(247717);
          return 0;
        case 2: 
          localso.SbO.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(247717);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sm)localObject2).parseFrom((byte[])localObject1);
            }
            localso.SbX = ((sm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(247717);
          return 0;
        }
        localso.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(247717);
        return 0;
      }
      AppMethodBeat.o(247717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */