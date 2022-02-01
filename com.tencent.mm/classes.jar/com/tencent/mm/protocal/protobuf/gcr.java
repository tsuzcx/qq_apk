package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gcr
  extends com.tencent.mm.bx.a
{
  public gbv acaF;
  public int acaG;
  public LinkedList<gce> acaw;
  
  public gcr()
  {
    AppMethodBeat.i(147806);
    this.acaw = new LinkedList();
    AppMethodBeat.o(147806);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147807);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acaF == null)
      {
        paramVarArgs = new b("Not all required fields were included: base_request");
        AppMethodBeat.o(147807);
        throw paramVarArgs;
      }
      if (this.acaF != null)
      {
        paramVarArgs.qD(1, this.acaF.computeSize());
        this.acaF.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.acaw);
      paramVarArgs.bS(3, this.acaG);
      AppMethodBeat.o(147807);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acaF == null) {
        break label498;
      }
    }
    label498:
    for (paramInt = i.a.a.a.qC(1, this.acaF.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.acaw);
      int j = i.a.a.b.b.a.cJ(3, this.acaG);
      AppMethodBeat.o(147807);
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
        if (this.acaF == null)
        {
          paramVarArgs = new b("Not all required fields were included: base_request");
          AppMethodBeat.o(147807);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gcr localgcr = (gcr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147807);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbv)localObject2).parseFrom((byte[])localObject1);
            }
            localgcr.acaF = ((gbv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147807);
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
            localgcr.acaw.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147807);
          return 0;
        }
        localgcr.acaG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(147807);
        return 0;
      }
      AppMethodBeat.o(147807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcr
 * JD-Core Version:    0.7.0.1
 */