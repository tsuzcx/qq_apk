package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fma
  extends erp
{
  public int IJG;
  public int abMq;
  public LinkedList<flz> abMr;
  
  public fma()
  {
    AppMethodBeat.i(32468);
    this.abMr = new LinkedList();
    AppMethodBeat.o(32468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32469);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abMq);
      paramVarArgs.e(3, 8, this.abMr);
      paramVarArgs.bS(4, this.IJG);
      AppMethodBeat.o(32469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abMq);
      int j = i.a.a.a.c(3, 8, this.abMr);
      int k = i.a.a.b.b.a.cJ(4, this.IJG);
      AppMethodBeat.o(32469);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abMr.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fma localfma = (fma)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32469);
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
            localfma.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32469);
          return 0;
        case 2: 
          localfma.abMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32469);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new flz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((flz)localObject2).parseFrom((byte[])localObject1);
            }
            localfma.abMr.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32469);
          return 0;
        }
        localfma.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(32469);
        return 0;
      }
      AppMethodBeat.o(32469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fma
 * JD-Core Version:    0.7.0.1
 */