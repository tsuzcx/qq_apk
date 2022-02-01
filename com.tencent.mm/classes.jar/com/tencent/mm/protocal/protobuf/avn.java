package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class avn
  extends com.tencent.mm.bx.a
{
  public long ZFH;
  public int ZFI;
  public int ZFJ;
  public dom ZFK;
  public diq ZFL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257526);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZFH);
      paramVarArgs.bS(2, this.ZFI);
      paramVarArgs.bS(3, this.ZFJ);
      if (this.ZFK != null)
      {
        paramVarArgs.qD(4, this.ZFK.computeSize());
        this.ZFK.writeFields(paramVarArgs);
      }
      if (this.ZFL != null)
      {
        paramVarArgs.qD(5, this.ZFL.computeSize());
        this.ZFL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257526);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.ZFH) + 0 + i.a.a.b.b.a.cJ(2, this.ZFI) + i.a.a.b.b.a.cJ(3, this.ZFJ);
      paramInt = i;
      if (this.ZFK != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZFK.computeSize());
      }
      i = paramInt;
      if (this.ZFL != null) {
        i = paramInt + i.a.a.a.qC(5, this.ZFL.computeSize());
      }
      AppMethodBeat.o(257526);
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
      AppMethodBeat.o(257526);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      avn localavn = (avn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257526);
        return -1;
      case 1: 
        localavn.ZFH = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257526);
        return 0;
      case 2: 
        localavn.ZFI = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257526);
        return 0;
      case 3: 
        localavn.ZFJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257526);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dom();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dom)localObject2).parseFrom((byte[])localObject1);
          }
          localavn.ZFK = ((dom)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257526);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new diq();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((diq)localObject2).parseFrom((byte[])localObject1);
        }
        localavn.ZFL = ((diq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257526);
      return 0;
    }
    AppMethodBeat.o(257526);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avn
 * JD-Core Version:    0.7.0.1
 */