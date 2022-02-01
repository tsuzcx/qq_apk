package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekk
  extends dpc
{
  public LinkedList<cfz> NjC;
  public cfl Njs;
  public int Nju;
  public int pTZ;
  public String pUa;
  
  public ekk()
  {
    AppMethodBeat.i(72610);
    this.NjC = new LinkedList();
    AppMethodBeat.o(72610);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72611);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.Nju);
      paramVarArgs.e(5, 8, this.NjC);
      if (this.Njs != null)
      {
        paramVarArgs.ni(6, this.Njs.computeSize());
        this.Njs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72611);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Nju) + g.a.a.a.c(5, 8, this.NjC);
      paramInt = i;
      if (this.Njs != null) {
        paramInt = i + g.a.a.a.nh(6, this.Njs.computeSize());
      }
      AppMethodBeat.o(72611);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NjC.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72611);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekk localekk = (ekk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72611);
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
            localekk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72611);
          return 0;
        case 2: 
          localekk.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72611);
          return 0;
        case 3: 
          localekk.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72611);
          return 0;
        case 4: 
          localekk.Nju = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72611);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localekk.NjC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72611);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfl();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localekk.Njs = ((cfl)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72611);
        return 0;
      }
      AppMethodBeat.o(72611);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekk
 * JD-Core Version:    0.7.0.1
 */