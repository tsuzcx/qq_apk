package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class eas
  extends erp
{
  public String abfZ;
  public eau abga;
  public int abgb;
  public b abgc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258400);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abfZ != null) {
        paramVarArgs.g(2, this.abfZ);
      }
      if (this.abga != null)
      {
        paramVarArgs.qD(3, this.abga.computeSize());
        this.abga.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.abgb);
      if (this.abgc != null) {
        paramVarArgs.d(5, this.abgc);
      }
      AppMethodBeat.o(258400);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abfZ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abfZ);
      }
      i = paramInt;
      if (this.abga != null) {
        i = paramInt + i.a.a.a.qC(3, this.abga.computeSize());
      }
      i += i.a.a.b.b.a.cJ(4, this.abgb);
      paramInt = i;
      if (this.abgc != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.abgc);
      }
      AppMethodBeat.o(258400);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258400);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eas localeas = (eas)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258400);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localeas.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258400);
          return 0;
        case 2: 
          localeas.abfZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258400);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eau();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eau)localObject2).parseFrom((byte[])localObject1);
            }
            localeas.abga = ((eau)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258400);
          return 0;
        case 4: 
          localeas.abgb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258400);
          return 0;
        }
        localeas.abgc = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(258400);
        return 0;
      }
      AppMethodBeat.o(258400);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eas
 * JD-Core Version:    0.7.0.1
 */