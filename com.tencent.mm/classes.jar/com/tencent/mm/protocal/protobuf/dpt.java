package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpt
  extends com.tencent.mm.bx.a
{
  public String EFF;
  public qb EFG;
  public boolean EFH;
  public String EFI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91731);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EFF != null) {
        paramVarArgs.d(1, this.EFF);
      }
      if (this.EFG != null)
      {
        paramVarArgs.kX(2, this.EFG.computeSize());
        this.EFG.writeFields(paramVarArgs);
      }
      paramVarArgs.bg(3, this.EFH);
      if (this.EFI != null) {
        paramVarArgs.d(4, this.EFI);
      }
      AppMethodBeat.o(91731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EFF == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.b.b.a.e(1, this.EFF) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.EFG != null) {
        i = paramInt + f.a.a.a.kW(2, this.EFG.computeSize());
      }
      i += f.a.a.b.b.a.fY(3) + 1;
      paramInt = i;
      if (this.EFI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EFI);
      }
      AppMethodBeat.o(91731);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpt localdpt = (dpt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91731);
          return -1;
        case 1: 
          localdpt.EFF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91731);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((qb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpt.EFG = ((qb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91731);
          return 0;
        case 3: 
          localdpt.EFH = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(91731);
          return 0;
        }
        localdpt.EFI = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91731);
        return 0;
      }
      AppMethodBeat.o(91731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpt
 * JD-Core Version:    0.7.0.1
 */