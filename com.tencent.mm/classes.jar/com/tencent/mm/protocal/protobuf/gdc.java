package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gdc
  extends com.tencent.mm.bx.a
{
  public gbw acaH;
  public int acaU;
  public LinkedList<gce> acaw;
  
  public gdc()
  {
    AppMethodBeat.i(147818);
    this.acaw = new LinkedList();
    AppMethodBeat.o(147818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147819);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaH == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_response");
        AppMethodBeat.o(147819);
        throw paramVarArgs;
      }
      if (this.acaH != null)
      {
        paramVarArgs.qD(1, this.acaH.computeSize());
        this.acaH.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.acaw);
      paramVarArgs.bS(3, this.acaU);
      AppMethodBeat.o(147819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaH == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.a.qC(1, this.acaH.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.acaw);
      int j = i.a.a.b.b.a.cJ(3, this.acaU);
      AppMethodBeat.o(147819);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acaw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.acaH == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_response");
          AppMethodBeat.o(147819);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gdc localgdc = (gdc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147819);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbw)localObject2).parseFrom((byte[])localObject1);
            }
            localgdc.acaH = ((gbw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147819);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gce();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gce)localObject2).parseFrom((byte[])localObject1);
            }
            localgdc.acaw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147819);
          return 0;
        }
        localgdc.acaU = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(147819);
        return 0;
      }
      AppMethodBeat.o(147819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gdc
 * JD-Core Version:    0.7.0.1
 */