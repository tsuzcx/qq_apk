package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iz
  extends com.tencent.mm.cd.a
{
  public eae RMa;
  public eae RMb;
  public String RMg;
  public eae ROR;
  public fhd ROS;
  public fmx ROT;
  public int ROU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ROR != null)
      {
        paramVarArgs.oE(1, this.ROR.computeSize());
        this.ROR.writeFields(paramVarArgs);
      }
      if (this.ROS != null)
      {
        paramVarArgs.oE(2, this.ROS.computeSize());
        this.ROS.writeFields(paramVarArgs);
      }
      if (this.ROT != null)
      {
        paramVarArgs.oE(3, this.ROT.computeSize());
        this.ROT.writeFields(paramVarArgs);
      }
      if (this.RMa != null)
      {
        paramVarArgs.oE(4, this.RMa.computeSize());
        this.RMa.writeFields(paramVarArgs);
      }
      if (this.RMb != null)
      {
        paramVarArgs.oE(5, this.RMb.computeSize());
        this.RMb.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.ROU);
      if (this.RMg != null) {
        paramVarArgs.f(7, this.RMg);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ROR == null) {
        break label924;
      }
    }
    label924:
    for (int i = g.a.a.a.oD(1, this.ROR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ROS != null) {
        paramInt = i + g.a.a.a.oD(2, this.ROS.computeSize());
      }
      i = paramInt;
      if (this.ROT != null) {
        i = paramInt + g.a.a.a.oD(3, this.ROT.computeSize());
      }
      paramInt = i;
      if (this.RMa != null) {
        paramInt = i + g.a.a.a.oD(4, this.RMa.computeSize());
      }
      i = paramInt;
      if (this.RMb != null) {
        i = paramInt + g.a.a.a.oD(5, this.RMb.computeSize());
      }
      i += g.a.a.b.b.a.bM(6, this.ROU);
      paramInt = i;
      if (this.RMg != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RMg);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        iz localiz = (iz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localiz.ROR = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhd)localObject2).parseFrom((byte[])localObject1);
            }
            localiz.ROS = ((fhd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmx)localObject2).parseFrom((byte[])localObject1);
            }
            localiz.ROT = ((fmx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localiz.RMa = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localiz.RMb = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localiz.ROU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133155);
          return 0;
        }
        localiz.RMg = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iz
 * JD-Core Version:    0.7.0.1
 */