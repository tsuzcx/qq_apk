package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dmb
  extends dpc
{
  public String KOu;
  public LinkedList<eox> MPF;
  public ejg MPG;
  public int MlI;
  public int oTz;
  
  public dmb()
  {
    AppMethodBeat.i(56260);
    this.MPF = new LinkedList();
    AppMethodBeat.o(56260);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56261);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56261);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oTz);
      paramVarArgs.e(3, 8, this.MPF);
      if (this.KOu != null) {
        paramVarArgs.e(4, this.KOu);
      }
      paramVarArgs.aM(5, this.MlI);
      if (this.MPG != null)
      {
        paramVarArgs.ni(6, this.MPG.computeSize());
        this.MPG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.MPF);
      paramInt = i;
      if (this.KOu != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KOu);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MlI);
      paramInt = i;
      if (this.MPG != null) {
        paramInt = i + g.a.a.a.nh(6, this.MPG.computeSize());
      }
      AppMethodBeat.o(56261);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MPF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56261);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dmb localdmb = (dmb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56261);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmb.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 2: 
          localdmb.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56261);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eox();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eox)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdmb.MPF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56261);
          return 0;
        case 4: 
          localdmb.KOu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(56261);
          return 0;
        case 5: 
          localdmb.MlI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(56261);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejg();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ejg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdmb.MPG = ((ejg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56261);
        return 0;
      }
      AppMethodBeat.o(56261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmb
 * JD-Core Version:    0.7.0.1
 */