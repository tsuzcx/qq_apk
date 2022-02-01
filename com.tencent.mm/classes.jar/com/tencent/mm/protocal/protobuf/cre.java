package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cre
  extends dyl
{
  public int Saq;
  public int Typ;
  public int rVx;
  public LinkedList<chr> rVy;
  
  public cre()
  {
    AppMethodBeat.i(155429);
    this.rVy = new LinkedList();
    AppMethodBeat.o(155429);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155430);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.rVy);
      paramVarArgs.aY(4, this.Saq);
      paramVarArgs.aY(5, this.Typ);
      AppMethodBeat.o(155430);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.c(3, 8, this.rVy);
      int k = g.a.a.b.b.a.bM(4, this.Saq);
      int m = g.a.a.b.b.a.bM(5, this.Typ);
      AppMethodBeat.o(155430);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rVy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155430);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cre localcre = (cre)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155430);
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
            localcre.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155430);
          return 0;
        case 2: 
          localcre.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155430);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new chr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((chr)localObject2).parseFrom((byte[])localObject1);
            }
            localcre.rVy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155430);
          return 0;
        case 4: 
          localcre.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155430);
          return 0;
        }
        localcre.Typ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(155430);
        return 0;
      }
      AppMethodBeat.o(155430);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cre
 * JD-Core Version:    0.7.0.1
 */