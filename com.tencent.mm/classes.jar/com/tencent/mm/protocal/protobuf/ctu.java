package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctu
  extends com.tencent.mm.bx.a
{
  public awr YGg;
  public fom YGh;
  public String YGi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258021);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGg != null)
      {
        paramVarArgs.qD(1, this.YGg.computeSize());
        this.YGg.writeFields(paramVarArgs);
      }
      if (this.YGh != null)
      {
        paramVarArgs.qD(2, this.YGh.computeSize());
        this.YGh.writeFields(paramVarArgs);
      }
      if (this.YGi != null) {
        paramVarArgs.g(3, this.YGi);
      }
      AppMethodBeat.o(258021);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YGg == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.YGg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGh != null) {
        paramInt = i + i.a.a.a.qC(2, this.YGh.computeSize());
      }
      i = paramInt;
      if (this.YGi != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YGi);
      }
      AppMethodBeat.o(258021);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258021);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ctu localctu = (ctu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258021);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new awr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((awr)localObject2).parseFrom((byte[])localObject1);
            }
            localctu.YGg = ((awr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258021);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fom();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fom)localObject2).parseFrom((byte[])localObject1);
            }
            localctu.YGh = ((fom)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258021);
          return 0;
        }
        localctu.YGi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258021);
        return 0;
      }
      AppMethodBeat.o(258021);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctu
 * JD-Core Version:    0.7.0.1
 */