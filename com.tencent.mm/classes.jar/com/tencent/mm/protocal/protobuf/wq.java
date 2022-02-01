package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class wq
  extends erp
{
  public int ZdC;
  public gol ZdD;
  public dgx ZdE;
  public int ZdF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(93330);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(93330);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZdC);
      if (this.ZdD != null)
      {
        paramVarArgs.qD(3, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      if (this.ZdE != null)
      {
        paramVarArgs.qD(4, this.ZdE.computeSize());
        this.ZdE.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.ZdF);
      AppMethodBeat.o(93330);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label684;
      }
    }
    label684:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZdC);
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZdD.computeSize());
      }
      i = paramInt;
      if (this.ZdE != null) {
        i = paramInt + i.a.a.a.qC(4, this.ZdE.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.ZdF);
      AppMethodBeat.o(93330);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZdD == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(93330);
          throw paramVarArgs;
        }
        AppMethodBeat.o(93330);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        wq localwq = (wq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(93330);
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
            localwq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        case 2: 
          localwq.ZdC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(93330);
          return 0;
        case 3: 
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
            localwq.ZdD = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgx)localObject2).parseFrom((byte[])localObject1);
            }
            localwq.ZdE = ((dgx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(93330);
          return 0;
        }
        localwq.ZdF = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(93330);
        return 0;
      }
      AppMethodBeat.o(93330);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wq
 * JD-Core Version:    0.7.0.1
 */