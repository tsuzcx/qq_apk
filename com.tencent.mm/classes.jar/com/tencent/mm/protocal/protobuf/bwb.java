package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwb
  extends com.tencent.mm.bx.a
{
  public bwh aaeb;
  public bav aaec;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258739);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.aaeb != null)
      {
        paramVarArgs.qD(2, this.aaeb.computeSize());
        this.aaeb.writeFields(paramVarArgs);
      }
      if (this.aaec != null)
      {
        paramVarArgs.qD(3, this.aaec.computeSize());
        this.aaec.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258739);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.aaeb != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaeb.computeSize());
      }
      i = paramInt;
      if (this.aaec != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaec.computeSize());
      }
      AppMethodBeat.o(258739);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258739);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bwb localbwb = (bwb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258739);
        return -1;
      case 1: 
        localbwb.type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258739);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bwh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bwh)localObject2).parseFrom((byte[])localObject1);
          }
          localbwb.aaeb = ((bwh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258739);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bav();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bav)localObject2).parseFrom((byte[])localObject1);
        }
        localbwb.aaec = ((bav)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258739);
      return 0;
    }
    AppMethodBeat.o(258739);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwb
 * JD-Core Version:    0.7.0.1
 */