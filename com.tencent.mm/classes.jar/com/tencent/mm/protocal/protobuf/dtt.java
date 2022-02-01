package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtt
  extends com.tencent.mm.bx.a
{
  public sc YOA;
  public dts YOB;
  public dal YOz;
  public int aaZs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133180);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOz != null)
      {
        paramVarArgs.qD(1, this.YOz.computeSize());
        this.YOz.writeFields(paramVarArgs);
      }
      if (this.YOB != null)
      {
        paramVarArgs.qD(2, this.YOB.computeSize());
        this.YOB.writeFields(paramVarArgs);
      }
      if (this.YOA != null)
      {
        paramVarArgs.qD(3, this.YOA.computeSize());
        this.YOA.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.aaZs);
      AppMethodBeat.o(133180);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YOz == null) {
        break label592;
      }
    }
    label592:
    for (int i = i.a.a.a.qC(1, this.YOz.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YOB != null) {
        paramInt = i + i.a.a.a.qC(2, this.YOB.computeSize());
      }
      i = paramInt;
      if (this.YOA != null) {
        i = paramInt + i.a.a.a.qC(3, this.YOA.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.aaZs);
      AppMethodBeat.o(133180);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133180);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dtt localdtt = (dtt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133180);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dal)localObject2).parseFrom((byte[])localObject1);
            }
            localdtt.YOz = ((dal)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dts();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dts)localObject2).parseFrom((byte[])localObject1);
            }
            localdtt.YOB = ((dts)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sc)localObject2).parseFrom((byte[])localObject1);
            }
            localdtt.YOA = ((sc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133180);
          return 0;
        }
        localdtt.aaZs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133180);
        return 0;
      }
      AppMethodBeat.o(133180);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtt
 * JD-Core Version:    0.7.0.1
 */