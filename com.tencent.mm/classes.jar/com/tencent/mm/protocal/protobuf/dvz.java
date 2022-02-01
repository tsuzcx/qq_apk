package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dvz
  extends dyl
{
  public int UbU;
  public fct UbV;
  public int UbW;
  public int rWs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32412);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UbV == null)
      {
        paramVarArgs = new b("Not all required fields were included: PieceData");
        AppMethodBeat.o(32412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWs);
      paramVarArgs.aY(3, this.UbU);
      if (this.UbV != null)
      {
        paramVarArgs.oE(4, this.UbV.computeSize());
        this.UbV.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.UbW);
      AppMethodBeat.o(32412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWs) + g.a.a.b.b.a.bM(3, this.UbU);
      paramInt = i;
      if (this.UbV != null) {
        paramInt = i + g.a.a.a.oD(4, this.UbV.computeSize());
      }
      i = g.a.a.b.b.a.bM(5, this.UbW);
      AppMethodBeat.o(32412);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UbV == null)
        {
          paramVarArgs = new b("Not all required fields were included: PieceData");
          AppMethodBeat.o(32412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dvz localdvz = (dvz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32412);
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
            localdvz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        case 2: 
          localdvz.rWs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32412);
          return 0;
        case 3: 
          localdvz.UbU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32412);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fct();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fct)localObject2).parseFrom((byte[])localObject1);
            }
            localdvz.UbV = ((fct)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32412);
          return 0;
        }
        localdvz.UbW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32412);
        return 0;
      }
      AppMethodBeat.o(32412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvz
 * JD-Core Version:    0.7.0.1
 */