package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awy
  extends erp
{
  public atz ZEc;
  public LinkedList<aps> ZIn;
  public int actionType;
  public String finderUsername;
  
  public awy()
  {
    AppMethodBeat.i(260007);
    this.ZIn = new LinkedList();
    AppMethodBeat.o(260007);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260011);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.g(2, this.finderUsername);
      }
      paramVarArgs.bS(3, this.actionType);
      paramVarArgs.e(4, 8, this.ZIn);
      if (this.ZEc != null)
      {
        paramVarArgs.qD(5, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260011);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.finderUsername);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.actionType) + i.a.a.a.c(4, 8, this.ZIn);
      paramInt = i;
      if (this.ZEc != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZEc.computeSize());
      }
      AppMethodBeat.o(260011);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZIn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260011);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awy localawy = (awy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260011);
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
            localawy.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260011);
          return 0;
        case 2: 
          localawy.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260011);
          return 0;
        case 3: 
          localawy.actionType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(260011);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aps();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aps)localObject2).parseFrom((byte[])localObject1);
            }
            localawy.ZIn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260011);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new atz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((atz)localObject2).parseFrom((byte[])localObject1);
          }
          localawy.ZEc = ((atz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260011);
        return 0;
      }
      AppMethodBeat.o(260011);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awy
 * JD-Core Version:    0.7.0.1
 */