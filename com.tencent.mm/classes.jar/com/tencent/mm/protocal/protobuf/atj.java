package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atj
  extends com.tencent.mm.cd.a
{
  public aqe RLM;
  public String SGm;
  public LinkedList<dcz> jmy;
  public int num;
  public int scene;
  
  public atj()
  {
    AppMethodBeat.i(205033);
    this.jmy = new LinkedList();
    AppMethodBeat.o(205033);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(205036);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RLM != null)
      {
        paramVarArgs.oE(1, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.scene);
      if (this.SGm != null) {
        paramVarArgs.f(3, this.SGm);
      }
      paramVarArgs.aY(4, this.num);
      paramVarArgs.e(5, 8, this.jmy);
      AppMethodBeat.o(205036);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RLM == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.a.oD(1, this.RLM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.scene);
      paramInt = i;
      if (this.SGm != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.SGm);
      }
      i = g.a.a.b.b.a.bM(4, this.num);
      int j = g.a.a.a.c(5, 8, this.jmy);
      AppMethodBeat.o(205036);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jmy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(205036);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atj localatj = (atj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(205036);
          return -1;
        case 1: 
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
            localatj.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(205036);
          return 0;
        case 2: 
          localatj.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205036);
          return 0;
        case 3: 
          localatj.SGm = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(205036);
          return 0;
        case 4: 
          localatj.num = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(205036);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcz)localObject2).parseFrom((byte[])localObject1);
          }
          localatj.jmy.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(205036);
        return 0;
      }
      AppMethodBeat.o(205036);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atj
 * JD-Core Version:    0.7.0.1
 */