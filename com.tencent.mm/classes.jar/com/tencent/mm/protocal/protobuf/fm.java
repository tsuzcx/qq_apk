package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fm
  extends dpc
{
  public LinkedList<of> KIN;
  public boolean KIO;
  public int KIP;
  public int enabled;
  public int qGg;
  
  public fm()
  {
    AppMethodBeat.i(103190);
    this.KIN = new LinkedList();
    AppMethodBeat.o(103190);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103191);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103191);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.KIN);
      paramVarArgs.cc(3, this.KIO);
      paramVarArgs.aM(4, this.KIP);
      paramVarArgs.aM(5, this.enabled);
      paramVarArgs.aM(6, this.qGg);
      AppMethodBeat.o(103191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.KIN);
      int j = g.a.a.b.b.a.fS(3);
      int k = g.a.a.b.b.a.bu(4, this.KIP);
      int m = g.a.a.b.b.a.bu(5, this.enabled);
      int n = g.a.a.b.b.a.bu(6, this.qGg);
      AppMethodBeat.o(103191);
      return paramInt + i + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KIN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103191);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103191);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fm localfm = (fm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103191);
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
            localfm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new of();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((of)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfm.KIN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 3: 
          localfm.KIO = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(103191);
          return 0;
        case 4: 
          localfm.KIP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103191);
          return 0;
        case 5: 
          localfm.enabled = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103191);
          return 0;
        }
        localfm.qGg = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103191);
        return 0;
      }
      AppMethodBeat.o(103191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fm
 * JD-Core Version:    0.7.0.1
 */