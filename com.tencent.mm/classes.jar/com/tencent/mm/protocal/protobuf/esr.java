package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class esr
  extends com.tencent.mm.bx.a
{
  public etg YCV;
  public String YMe;
  public fmp ZoM;
  public int abwk;
  public int abwl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91674);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abwk);
      paramVarArgs.bS(2, this.abwl);
      if (this.YCV != null)
      {
        paramVarArgs.qD(3, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      if (this.ZoM != null)
      {
        paramVarArgs.qD(4, this.ZoM.computeSize());
        this.ZoM.writeFields(paramVarArgs);
      }
      if (this.YMe != null) {
        paramVarArgs.g(5, this.YMe);
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.abwk) + 0 + i.a.a.b.b.a.cJ(2, this.abwl);
      paramInt = i;
      if (this.YCV != null) {
        paramInt = i + i.a.a.a.qC(3, this.YCV.computeSize());
      }
      i = paramInt;
      if (this.ZoM != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZoM.computeSize());
      }
      paramInt = i;
      if (this.YMe != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YMe);
      }
      AppMethodBeat.o(91674);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91674);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      esr localesr = (esr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91674);
        return -1;
      case 1: 
        localesr.abwk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91674);
        return 0;
      case 2: 
        localesr.abwl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(91674);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new etg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((etg)localObject2).parseFrom((byte[])localObject1);
          }
          localesr.YCV = ((etg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      case 4: 
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
          localesr.ZoM = ((fmp)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91674);
        return 0;
      }
      localesr.YMe = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(91674);
      return 0;
    }
    AppMethodBeat.o(91674);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esr
 * JD-Core Version:    0.7.0.1
 */