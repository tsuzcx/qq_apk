package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deu
  extends dyl
{
  public int RLe;
  public int TMu;
  public LinkedList<fcu> TMv;
  
  public deu()
  {
    AppMethodBeat.i(32364);
    this.TMv = new LinkedList();
    AppMethodBeat.o(32364);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32365);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      paramVarArgs.aY(3, this.TMu);
      paramVarArgs.e(4, 8, this.TMv);
      AppMethodBeat.o(32365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RLe);
      int j = g.a.a.b.b.a.bM(3, this.TMu);
      int k = g.a.a.a.c(4, 8, this.TMv);
      AppMethodBeat.o(32365);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TMv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        deu localdeu = (deu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32365);
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
            localdeu.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32365);
          return 0;
        case 2: 
          localdeu.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32365);
          return 0;
        case 3: 
          localdeu.TMu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32365);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fcu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fcu)localObject2).parseFrom((byte[])localObject1);
          }
          localdeu.TMv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32365);
        return 0;
      }
      AppMethodBeat.o(32365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deu
 * JD-Core Version:    0.7.0.1
 */