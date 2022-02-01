package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azs
  extends erp
{
  public String YSS;
  public bkr ZEk;
  public String ZKq;
  public int ZKr;
  public int order;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259042);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YSS != null) {
        paramVarArgs.g(2, this.YSS);
      }
      if (this.ZEk != null)
      {
        paramVarArgs.qD(3, this.ZEk.computeSize());
        this.ZEk.writeFields(paramVarArgs);
      }
      if (this.ZKq != null) {
        paramVarArgs.g(4, this.ZKq);
      }
      paramVarArgs.bS(5, this.ZKr);
      paramVarArgs.bS(6, this.order);
      AppMethodBeat.o(259042);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YSS != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YSS);
      }
      i = paramInt;
      if (this.ZEk != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZEk.computeSize());
      }
      paramInt = i;
      if (this.ZKq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZKq);
      }
      i = i.a.a.b.b.a.cJ(5, this.ZKr);
      int j = i.a.a.b.b.a.cJ(6, this.order);
      AppMethodBeat.o(259042);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259042);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azs localazs = (azs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259042);
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
            localazs.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259042);
          return 0;
        case 2: 
          localazs.YSS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259042);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bkr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bkr)localObject2).parseFrom((byte[])localObject1);
            }
            localazs.ZEk = ((bkr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259042);
          return 0;
        case 4: 
          localazs.ZKq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259042);
          return 0;
        case 5: 
          localazs.ZKr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259042);
          return 0;
        }
        localazs.order = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259042);
        return 0;
      }
      AppMethodBeat.o(259042);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azs
 * JD-Core Version:    0.7.0.1
 */