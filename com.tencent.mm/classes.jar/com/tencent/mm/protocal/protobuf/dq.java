package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dq
  extends com.tencent.mm.cd.a
{
  public ejd RIZ;
  public eaf RJa;
  public int RJb;
  public dwf RJc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.RIZ != null)
      {
        paramVarArgs.oE(1, this.RIZ.computeSize());
        this.RIZ.writeFields(paramVarArgs);
      }
      if (this.RJa != null)
      {
        paramVarArgs.oE(2, this.RJa.computeSize());
        this.RJa.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.RJb);
      if (this.RJc != null)
      {
        paramVarArgs.oE(4, this.RJc.computeSize());
        this.RJc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIZ == null) {
        break label644;
      }
    }
    label644:
    for (paramInt = g.a.a.a.oD(1, this.RIZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RJa != null) {
        i = paramInt + g.a.a.a.oD(2, this.RJa.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.RJb);
      paramInt = i;
      if (this.RJc != null) {
        paramInt = i + g.a.a.a.oD(4, this.RJc.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RIZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: SnsADObject");
          AppMethodBeat.o(125705);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dq localdq = (dq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejd)localObject2).parseFrom((byte[])localObject1);
            }
            localdq.RIZ = ((ejd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localdq.RJa = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localdq.RJb = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwf)localObject2).parseFrom((byte[])localObject1);
          }
          localdq.RJc = ((dwf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125705);
        return 0;
      }
      AppMethodBeat.o(125705);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dq
 * JD-Core Version:    0.7.0.1
 */