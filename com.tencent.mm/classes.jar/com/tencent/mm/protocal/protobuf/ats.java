package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ats
  extends erp
{
  public String Azl;
  public long ZEj;
  public bkr ZEk;
  public String ZEl;
  public String hAR;
  public int opType;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258224);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Azl != null) {
        paramVarArgs.g(2, this.Azl);
      }
      if (this.hAR != null) {
        paramVarArgs.g(3, this.hAR);
      }
      paramVarArgs.bS(4, this.opType);
      paramVarArgs.bv(5, this.ZEj);
      if (this.ZEk != null)
      {
        paramVarArgs.qD(6, this.ZEk.computeSize());
        this.ZEk.writeFields(paramVarArgs);
      }
      if (this.ZEl != null) {
        paramVarArgs.g(7, this.ZEl);
      }
      paramVarArgs.bS(8, this.scene);
      AppMethodBeat.o(258224);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Azl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Azl);
      }
      i = paramInt;
      if (this.hAR != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAR);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.opType) + i.a.a.b.b.a.q(5, this.ZEj);
      paramInt = i;
      if (this.ZEk != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZEk.computeSize());
      }
      i = paramInt;
      if (this.ZEl != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZEl);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.scene);
      AppMethodBeat.o(258224);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258224);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ats localats = (ats)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258224);
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
            localats.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258224);
          return 0;
        case 2: 
          localats.Azl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258224);
          return 0;
        case 3: 
          localats.hAR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258224);
          return 0;
        case 4: 
          localats.opType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258224);
          return 0;
        case 5: 
          localats.ZEj = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258224);
          return 0;
        case 6: 
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
            localats.ZEk = ((bkr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258224);
          return 0;
        case 7: 
          localats.ZEl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258224);
          return 0;
        }
        localats.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258224);
        return 0;
      }
      AppMethodBeat.o(258224);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ats
 * JD-Core Version:    0.7.0.1
 */