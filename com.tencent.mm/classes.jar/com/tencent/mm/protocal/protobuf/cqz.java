package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cqz
  extends erp
{
  public int IJG;
  public b aaxD;
  public eni aaxE;
  public qa aaxF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258870);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.IJG);
      if (this.aaxD != null) {
        paramVarArgs.d(3, this.aaxD);
      }
      if (this.aaxE != null)
      {
        paramVarArgs.qD(4, this.aaxE.computeSize());
        this.aaxE.writeFields(paramVarArgs);
      }
      if (this.aaxF != null)
      {
        paramVarArgs.qD(5, this.aaxF.computeSize());
        this.aaxF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258870);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.IJG);
      paramInt = i;
      if (this.aaxD != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aaxD);
      }
      i = paramInt;
      if (this.aaxE != null) {
        i = paramInt + i.a.a.a.qC(4, this.aaxE.computeSize());
      }
      paramInt = i;
      if (this.aaxF != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaxF.computeSize());
      }
      AppMethodBeat.o(258870);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258870);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqz localcqz = (cqz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258870);
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
            localcqz.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258870);
          return 0;
        case 2: 
          localcqz.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258870);
          return 0;
        case 3: 
          localcqz.aaxD = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258870);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eni();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eni)localObject2).parseFrom((byte[])localObject1);
            }
            localcqz.aaxE = ((eni)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258870);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new qa();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((qa)localObject2).parseFrom((byte[])localObject1);
          }
          localcqz.aaxF = ((qa)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258870);
        return 0;
      }
      AppMethodBeat.o(258870);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqz
 * JD-Core Version:    0.7.0.1
 */