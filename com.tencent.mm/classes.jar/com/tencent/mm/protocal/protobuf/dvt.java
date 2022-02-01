package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvt
  extends erp
{
  public String Id;
  public bi Zbi;
  public int abbu;
  public String pRM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91556);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abbu);
      if (this.Id != null) {
        paramVarArgs.g(3, this.Id);
      }
      if (this.pRM != null) {
        paramVarArgs.g(4, this.pRM);
      }
      if (this.Zbi != null)
      {
        paramVarArgs.qD(5, this.Zbi.computeSize());
        this.Zbi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91556);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abbu);
      paramInt = i;
      if (this.Id != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Id);
      }
      i = paramInt;
      if (this.pRM != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.pRM);
      }
      paramInt = i;
      if (this.Zbi != null) {
        paramInt = i + i.a.a.a.qC(5, this.Zbi.computeSize());
      }
      AppMethodBeat.o(91556);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dvt localdvt = (dvt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91556);
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
            localdvt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91556);
          return 0;
        case 2: 
          localdvt.abbu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91556);
          return 0;
        case 3: 
          localdvt.Id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91556);
          return 0;
        case 4: 
          localdvt.pRM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91556);
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
          localdvt.Zbi = ((bi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91556);
        return 0;
      }
      AppMethodBeat.o(91556);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvt
 * JD-Core Version:    0.7.0.1
 */