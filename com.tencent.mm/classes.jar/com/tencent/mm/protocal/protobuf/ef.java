package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ef
  extends com.tencent.mm.bx.a
{
  public fdk YGn;
  public etl YGo;
  public int YGp;
  public epj YGq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125705);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGn == null)
      {
        paramVarArgs = new b("Not all required fields were included: SnsADObject");
        AppMethodBeat.o(125705);
        throw paramVarArgs;
      }
      if (this.YGn != null)
      {
        paramVarArgs.qD(1, this.YGn.computeSize());
        this.YGn.writeFields(paramVarArgs);
      }
      if (this.YGo != null)
      {
        paramVarArgs.qD(2, this.YGo.computeSize());
        this.YGo.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YGp);
      if (this.YGq != null)
      {
        paramVarArgs.qD(4, this.YGq.computeSize());
        this.YGq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125705);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGn == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = i.a.a.a.qC(1, this.YGn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YGo != null) {
        i = paramInt + i.a.a.a.qC(2, this.YGo.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.YGp);
      paramInt = i;
      if (this.YGq != null) {
        paramInt = i + i.a.a.a.qC(4, this.YGq.computeSize());
      }
      AppMethodBeat.o(125705);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YGn == null)
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
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ef localef = (ef)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125705);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fdk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fdk)localObject2).parseFrom((byte[])localObject1);
            }
            localef.YGn = ((fdk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localef.YGo = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125705);
          return 0;
        case 3: 
          localef.YGp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(125705);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epj)localObject2).parseFrom((byte[])localObject1);
          }
          localef.YGq = ((epj)localObject2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ef
 * JD-Core Version:    0.7.0.1
 */