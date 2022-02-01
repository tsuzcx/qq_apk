package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cit
  extends com.tencent.mm.cd.a
{
  public esb TpH;
  public dqj TpI;
  public dqj TpJ;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TpH != null)
      {
        paramVarArgs.oE(1, this.TpH.computeSize());
        this.TpH.writeFields(paramVarArgs);
      }
      if (this.wording != null) {
        paramVarArgs.f(2, this.wording);
      }
      if (this.TpI != null)
      {
        paramVarArgs.oE(3, this.TpI.computeSize());
        this.TpI.writeFields(paramVarArgs);
      }
      if (this.TpJ != null)
      {
        paramVarArgs.oE(4, this.TpJ.computeSize());
        this.TpJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TpH == null) {
        break label612;
      }
    }
    label612:
    for (int i = g.a.a.a.oD(1, this.TpH.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.wording);
      }
      i = paramInt;
      if (this.TpI != null) {
        i = paramInt + g.a.a.a.oD(3, this.TpI.computeSize());
      }
      paramInt = i;
      if (this.TpJ != null) {
        paramInt = i + g.a.a.a.oD(4, this.TpJ.computeSize());
      }
      AppMethodBeat.o(259718);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(259718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cit localcit = (cit)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259718);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new esb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((esb)localObject2).parseFrom((byte[])localObject1);
            }
            localcit.TpH = ((esb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259718);
          return 0;
        case 2: 
          localcit.wording = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(259718);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dqj)localObject2).parseFrom((byte[])localObject1);
            }
            localcit.TpI = ((dqj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259718);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dqj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dqj)localObject2).parseFrom((byte[])localObject1);
          }
          localcit.TpJ = ((dqj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259718);
        return 0;
      }
      AppMethodBeat.o(259718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cit
 * JD-Core Version:    0.7.0.1
 */