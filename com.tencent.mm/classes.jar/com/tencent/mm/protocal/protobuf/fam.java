package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fam
  extends dpc
{
  public int KZk;
  public String MaZ;
  public int NwM;
  public dkh NwN;
  public dkf NwO;
  public int NwP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117949);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.NwM);
      paramVarArgs.aM(3, this.KZk);
      if (this.MaZ != null) {
        paramVarArgs.e(4, this.MaZ);
      }
      if (this.NwN != null)
      {
        paramVarArgs.ni(5, this.NwN.computeSize());
        this.NwN.writeFields(paramVarArgs);
      }
      if (this.NwO != null)
      {
        paramVarArgs.ni(6, this.NwO.computeSize());
        this.NwO.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.NwP);
      AppMethodBeat.o(117949);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.NwM) + g.a.a.b.b.a.bu(3, this.KZk);
      paramInt = i;
      if (this.MaZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MaZ);
      }
      i = paramInt;
      if (this.NwN != null) {
        i = paramInt + g.a.a.a.nh(5, this.NwN.computeSize());
      }
      paramInt = i;
      if (this.NwO != null) {
        paramInt = i + g.a.a.a.nh(6, this.NwO.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.NwP);
      AppMethodBeat.o(117949);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117949);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fam localfam = (fam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117949);
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
            localfam.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 2: 
          localfam.NwM = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117949);
          return 0;
        case 3: 
          localfam.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117949);
          return 0;
        case 4: 
          localfam.MaZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117949);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkh();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfam.NwN = ((dkh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dkf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dkf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfam.NwO = ((dkf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117949);
          return 0;
        }
        localfam.NwP = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117949);
        return 0;
      }
      AppMethodBeat.o(117949);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fam
 * JD-Core Version:    0.7.0.1
 */