package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asj
  extends dyl
{
  public aqe SDi;
  public LinkedList<amd> SFO;
  public int actionType;
  public String finderUsername;
  
  public asj()
  {
    AppMethodBeat.i(200467);
    this.SFO = new LinkedList();
    AppMethodBeat.o(200467);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200487);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.f(2, this.finderUsername);
      }
      paramVarArgs.aY(3, this.actionType);
      paramVarArgs.e(4, 8, this.SFO);
      if (this.SDi != null)
      {
        paramVarArgs.oE(5, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(200487);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.finderUsername);
      }
      i = i + g.a.a.b.b.a.bM(3, this.actionType) + g.a.a.a.c(4, 8, this.SFO);
      paramInt = i;
      if (this.SDi != null) {
        paramInt = i + g.a.a.a.oD(5, this.SDi.computeSize());
      }
      AppMethodBeat.o(200487);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SFO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200487);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        asj localasj = (asj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200487);
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
            localasj.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200487);
          return 0;
        case 2: 
          localasj.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(200487);
          return 0;
        case 3: 
          localasj.actionType = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(200487);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new amd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((amd)localObject2).parseFrom((byte[])localObject1);
            }
            localasj.SFO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200487);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqe)localObject2).parseFrom((byte[])localObject1);
          }
          localasj.SDi = ((aqe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(200487);
        return 0;
      }
      AppMethodBeat.o(200487);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asj
 * JD-Core Version:    0.7.0.1
 */