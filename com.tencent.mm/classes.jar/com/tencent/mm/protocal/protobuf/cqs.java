package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqs
  extends com.tencent.mm.cd.a
{
  public dcf Tyj;
  public LinkedList<cqr> Tyk;
  public cqp Tyl;
  
  public cqs()
  {
    AppMethodBeat.i(249995);
    this.Tyk = new LinkedList();
    AppMethodBeat.o(249995);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249997);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Tyj != null)
      {
        paramVarArgs.oE(1, this.Tyj.computeSize());
        this.Tyj.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Tyk);
      if (this.Tyl != null)
      {
        paramVarArgs.oE(3, this.Tyl.computeSize());
        this.Tyl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(249997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Tyj == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.Tyj.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Tyk);
      paramInt = i;
      if (this.Tyl != null) {
        paramInt = i + g.a.a.a.oD(3, this.Tyl.computeSize());
      }
      AppMethodBeat.o(249997);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tyk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqs localcqs = (cqs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249997);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcf)localObject2).parseFrom((byte[])localObject1);
            }
            localcqs.Tyj = ((dcf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249997);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqr)localObject2).parseFrom((byte[])localObject1);
            }
            localcqs.Tyk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(249997);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cqp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cqp)localObject2).parseFrom((byte[])localObject1);
          }
          localcqs.Tyl = ((cqp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(249997);
        return 0;
      }
      AppMethodBeat.o(249997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqs
 * JD-Core Version:    0.7.0.1
 */