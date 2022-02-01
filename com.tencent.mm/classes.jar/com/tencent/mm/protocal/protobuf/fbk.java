package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fbk
  extends esc
{
  public int abBm;
  public LinkedList<fbi> nUC;
  public long seq;
  public int wwi;
  
  public fbk()
  {
    AppMethodBeat.i(114076);
    this.nUC = new LinkedList();
    AppMethodBeat.o(114076);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114077);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114077);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.nUC);
      paramVarArgs.bS(3, this.abBm);
      paramVarArgs.bv(4, this.seq);
      paramVarArgs.bS(5, this.wwi);
      AppMethodBeat.o(114077);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.nUC);
      int j = i.a.a.b.b.a.cJ(3, this.abBm);
      int k = i.a.a.b.b.a.q(4, this.seq);
      int m = i.a.a.b.b.a.cJ(5, this.wwi);
      AppMethodBeat.o(114077);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.nUC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114077);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114077);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fbk localfbk = (fbk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114077);
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
            localfbk.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114077);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbi)localObject2).parseFrom((byte[])localObject1);
            }
            localfbk.nUC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(114077);
          return 0;
        case 3: 
          localfbk.abBm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(114077);
          return 0;
        case 4: 
          localfbk.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(114077);
          return 0;
        }
        localfbk.wwi = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(114077);
        return 0;
      }
      AppMethodBeat.o(114077);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbk
 * JD-Core Version:    0.7.0.1
 */