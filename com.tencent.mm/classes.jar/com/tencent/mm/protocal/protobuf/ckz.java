package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ckz
  extends esc
{
  public int aasY;
  public int aasZ;
  public LinkedList<dez> aata;
  public String aatb;
  
  public ckz()
  {
    AppMethodBeat.i(257973);
    this.aata = new LinkedList();
    AppMethodBeat.o(257973);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257979);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257979);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aasY);
      paramVarArgs.bS(3, this.aasZ);
      paramVarArgs.e(4, 8, this.aata);
      if (this.aatb != null) {
        paramVarArgs.g(5, this.aatb);
      }
      AppMethodBeat.o(257979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aasY) + i.a.a.b.b.a.cJ(3, this.aasZ) + i.a.a.a.c(4, 8, this.aata);
      paramInt = i;
      if (this.aatb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aatb);
      }
      AppMethodBeat.o(257979);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aata.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257979);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257979);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ckz localckz = (ckz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257979);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localckz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257979);
          return 0;
        case 2: 
          localckz.aasY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257979);
          return 0;
        case 3: 
          localckz.aasZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257979);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dez)localObject2).parseFrom((byte[])localObject1);
            }
            localckz.aata.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257979);
          return 0;
        }
        localckz.aatb = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257979);
        return 0;
      }
      AppMethodBeat.o(257979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckz
 * JD-Core Version:    0.7.0.1
 */