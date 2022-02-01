package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtn
  extends com.tencent.mm.bx.a
{
  public dbk YZa;
  public fmp ZoM;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91551);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YZa != null)
      {
        paramVarArgs.qD(1, this.YZa.computeSize());
        this.YZa.writeFields(paramVarArgs);
      }
      if (this.ZoM != null)
      {
        paramVarArgs.qD(2, this.ZoM.computeSize());
        this.ZoM.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.type);
      AppMethodBeat.o(91551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YZa == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.a.qC(1, this.YZa.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZoM != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZoM.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.type);
      AppMethodBeat.o(91551);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dtn localdtn = (dtn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91551);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbk)localObject2).parseFrom((byte[])localObject1);
            }
            localdtn.YZa = ((dbk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91551);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fmp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fmp)localObject2).parseFrom((byte[])localObject1);
            }
            localdtn.ZoM = ((fmp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91551);
          return 0;
        }
        localdtn.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91551);
        return 0;
      }
      AppMethodBeat.o(91551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtn
 * JD-Core Version:    0.7.0.1
 */