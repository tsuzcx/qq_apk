package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fil
  extends esc
{
  public int YYp;
  public int aaiS;
  public int abIQ;
  public LinkedList<fiz> abJi;
  public long abJj;
  
  public fil()
  {
    AppMethodBeat.i(118445);
    this.abJi = new LinkedList();
    AppMethodBeat.o(118445);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118446);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118446);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abIQ);
      paramVarArgs.e(3, 8, this.abJi);
      paramVarArgs.bv(4, this.abJj);
      paramVarArgs.bS(5, this.YYp);
      paramVarArgs.bS(6, this.aaiS);
      AppMethodBeat.o(118446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abIQ);
      int j = i.a.a.a.c(3, 8, this.abJi);
      int k = i.a.a.b.b.a.q(4, this.abJj);
      int m = i.a.a.b.b.a.cJ(5, this.YYp);
      int n = i.a.a.b.b.a.cJ(6, this.aaiS);
      AppMethodBeat.o(118446);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abJi.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fil localfil = (fil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118446);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localfil.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 2: 
          localfil.abIQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118446);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fiz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fiz)localObject2).parseFrom((byte[])localObject1);
            }
            localfil.abJi.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118446);
          return 0;
        case 4: 
          localfil.abJj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(118446);
          return 0;
        case 5: 
          localfil.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(118446);
          return 0;
        }
        localfil.aaiS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(118446);
        return 0;
      }
      AppMethodBeat.o(118446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fil
 * JD-Core Version:    0.7.0.1
 */