package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fax
  extends erp
{
  public gol YKa;
  public gol YKb;
  public gol YLa;
  public int abAS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YLa == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(32441);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YLa != null)
      {
        paramVarArgs.qD(2, this.YLa.computeSize());
        this.YLa.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abAS);
      if (this.YKa != null)
      {
        paramVarArgs.qD(4, this.YKa.computeSize());
        this.YKa.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(5, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label785;
      }
    }
    label785:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YLa != null) {
        i = paramInt + i.a.a.a.qC(2, this.YLa.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.abAS);
      paramInt = i;
      if (this.YKa != null) {
        paramInt = i + i.a.a.a.qC(4, this.YKa.computeSize());
      }
      i = paramInt;
      if (this.YKb != null) {
        i = paramInt + i.a.a.a.qC(5, this.YKb.computeSize());
      }
      AppMethodBeat.o(32441);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YLa == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(32441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fax localfax = (fax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32441);
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
            localfax.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32441);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfax.YLa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32441);
          return 0;
        case 3: 
          localfax.abAS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32441);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfax.YKa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32441);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localfax.YKb = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32441);
        return 0;
      }
      AppMethodBeat.o(32441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fax
 * JD-Core Version:    0.7.0.1
 */