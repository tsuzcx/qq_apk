package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dih
  extends com.tencent.mm.bx.a
{
  public dom ZFK;
  public diq ZFL;
  public long aaNg;
  public long aaNh;
  public cbm aaNi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257388);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaNg);
      paramVarArgs.bv(2, this.aaNh);
      if (this.aaNi != null)
      {
        paramVarArgs.qD(3, this.aaNi.computeSize());
        this.aaNi.writeFields(paramVarArgs);
      }
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
      AppMethodBeat.o(257388);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.aaNg) + 0 + i.a.a.b.b.a.q(2, this.aaNh);
      paramInt = i;
      if (this.aaNi != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaNi.computeSize());
      }
      i = paramInt;
      if (this.ZFK != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZFK.computeSize());
      }
      paramInt = i;
      if (this.ZFL != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZFL.computeSize());
      }
      AppMethodBeat.o(257388);
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
      AppMethodBeat.o(257388);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dih localdih = (dih)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257388);
        return -1;
      case 1: 
        localdih.aaNg = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257388);
        return 0;
      case 2: 
        localdih.aaNh = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257388);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cbm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cbm)localObject2).parseFrom((byte[])localObject1);
          }
          localdih.aaNi = ((cbm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257388);
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
          localdih.ZFK = ((dom)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257388);
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
        localdih.ZFL = ((diq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257388);
      return 0;
    }
    AppMethodBeat.o(257388);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dih
 * JD-Core Version:    0.7.0.1
 */