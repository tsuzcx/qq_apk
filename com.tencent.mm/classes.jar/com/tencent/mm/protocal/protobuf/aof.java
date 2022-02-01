package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aof
  extends erp
{
  public int OzH;
  public bi Zbi;
  public String ZvJ;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZvJ != null) {
        paramVarArgs.g(2, this.ZvJ);
      }
      if (this.oOI != null) {
        paramVarArgs.g(3, this.oOI);
      }
      paramVarArgs.bS(4, this.OzH);
      if (this.Zbi != null)
      {
        paramVarArgs.qD(5, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91441);
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
      if (this.ZvJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZvJ);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.oOI);
      }
      i += i.a.a.b.b.a.cJ(4, this.OzH);
      paramInt = i;
      if (this.Zbi != null) {
        paramInt = i + i.a.a.a.qC(5, this.Zbi.computeSize());
      }
      AppMethodBeat.o(91441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aof localaof = (aof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91441);
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
            localaof.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91441);
          return 0;
        case 2: 
          localaof.ZvJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91441);
          return 0;
        case 3: 
          localaof.oOI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91441);
          return 0;
        case 4: 
          localaof.OzH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91441);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bi)localObject2).parseFrom((byte[])localObject1);
          }
          localaof.Zbi = ((bi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91441);
        return 0;
      }
      AppMethodBeat.o(91441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aof
 * JD-Core Version:    0.7.0.1
 */