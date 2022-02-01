package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aso
  extends dpc
{
  public baw LAF;
  public int LDq;
  public LinkedList<FinderObject> LDv;
  public String LDw;
  public int continueFlag;
  public int gAZ;
  public com.tencent.mm.bw.b lastBuffer;
  public int uKM;
  
  public aso()
  {
    AppMethodBeat.i(168986);
    this.LDv = new LinkedList();
    AppMethodBeat.o(168986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168987);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168987);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.LDv);
      if (this.lastBuffer != null) {
        paramVarArgs.c(3, this.lastBuffer);
      }
      paramVarArgs.aM(4, this.continueFlag);
      paramVarArgs.aM(5, this.gAZ);
      if (this.LDw != null) {
        paramVarArgs.e(6, this.LDw);
      }
      paramVarArgs.aM(7, this.uKM);
      paramVarArgs.aM(8, this.LDq);
      if (this.LAF != null)
      {
        paramVarArgs.ni(9, this.LAF.computeSize());
        this.LAF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168987);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.LDv);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.lastBuffer);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.b.b.a.bu(5, this.gAZ);
      paramInt = i;
      if (this.LDw != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LDw);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.uKM) + g.a.a.b.b.a.bu(8, this.LDq);
      paramInt = i;
      if (this.LAF != null) {
        paramInt = i + g.a.a.a.nh(9, this.LAF.computeSize());
      }
      AppMethodBeat.o(168987);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDv.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168987);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168987);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aso localaso = (aso)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168987);
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
            localaso.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaso.LDv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 3: 
          localaso.lastBuffer = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(168987);
          return 0;
        case 4: 
          localaso.continueFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168987);
          return 0;
        case 5: 
          localaso.gAZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168987);
          return 0;
        case 6: 
          localaso.LDw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(168987);
          return 0;
        case 7: 
          localaso.uKM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168987);
          return 0;
        case 8: 
          localaso.LDq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(168987);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new baw();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((baw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaso.LAF = ((baw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168987);
        return 0;
      }
      AppMethodBeat.o(168987);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aso
 * JD-Core Version:    0.7.0.1
 */