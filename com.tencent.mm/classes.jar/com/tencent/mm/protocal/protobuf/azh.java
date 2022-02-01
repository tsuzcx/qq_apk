package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azh
  extends esc
{
  public int EzH;
  public btc ZDZ;
  public int ZJC;
  public LinkedList<FinderObject> ZJE;
  public String ZJF;
  public int continueFlag;
  public int lNX;
  public com.tencent.mm.bx.b lastBuffer;
  
  public azh()
  {
    AppMethodBeat.i(168986);
    this.ZJE = new LinkedList();
    AppMethodBeat.o(168986);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168987);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168987);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZJE);
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      paramVarArgs.bS(5, this.lNX);
      if (this.ZJF != null) {
        paramVarArgs.g(6, this.ZJF);
      }
      paramVarArgs.bS(7, this.EzH);
      paramVarArgs.bS(8, this.ZJC);
      if (this.ZDZ != null)
      {
        paramVarArgs.qD(9, this.ZDZ.computeSize());
        this.ZDZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168987);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label884;
      }
    }
    label884:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZJE);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.continueFlag) + i.a.a.b.b.a.cJ(5, this.lNX);
      paramInt = i;
      if (this.ZJF != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZJF);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.EzH) + i.a.a.b.b.a.cJ(8, this.ZJC);
      paramInt = i;
      if (this.ZDZ != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZDZ.computeSize());
      }
      AppMethodBeat.o(168987);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJE.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168987);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168987);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azh localazh = (azh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168987);
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
            localazh.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localazh.ZJE.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168987);
          return 0;
        case 3: 
          localazh.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168987);
          return 0;
        case 4: 
          localazh.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168987);
          return 0;
        case 5: 
          localazh.lNX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168987);
          return 0;
        case 6: 
          localazh.ZJF = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168987);
          return 0;
        case 7: 
          localazh.EzH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168987);
          return 0;
        case 8: 
          localazh.ZJC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168987);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btc)localObject2).parseFrom((byte[])localObject1);
          }
          localazh.ZDZ = ((btc)localObject2);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azh
 * JD-Core Version:    0.7.0.1
 */