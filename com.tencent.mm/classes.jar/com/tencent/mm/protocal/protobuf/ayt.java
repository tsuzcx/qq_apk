package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayt
  extends esc
{
  public int EzH;
  public btc ZDZ;
  public int ZJC;
  public int continueFlag;
  public int lNX;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public LinkedList<bxv> usualTopics;
  
  public ayt()
  {
    AppMethodBeat.i(259253);
    this.object = new LinkedList();
    this.usualTopics = new LinkedList();
    AppMethodBeat.o(259253);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259256);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259256);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.lastBuffer != null) {
        paramVarArgs.d(3, this.lastBuffer);
      }
      paramVarArgs.bS(4, this.continueFlag);
      paramVarArgs.bS(5, this.lNX);
      paramVarArgs.bS(6, this.EzH);
      paramVarArgs.bS(7, this.ZJC);
      if (this.ZDZ != null)
      {
        paramVarArgs.qD(8, this.ZDZ.computeSize());
        this.ZDZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(9, 8, this.usualTopics);
      AppMethodBeat.o(259256);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label938;
      }
    }
    label938:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.continueFlag) + i.a.a.b.b.a.cJ(5, this.lNX) + i.a.a.b.b.a.cJ(6, this.EzH) + i.a.a.b.b.a.cJ(7, this.ZJC);
      paramInt = i;
      if (this.ZDZ != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZDZ.computeSize());
      }
      i = i.a.a.a.c(9, 8, this.usualTopics);
      AppMethodBeat.o(259256);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        this.usualTopics.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(259256);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259256);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayt localayt = (ayt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259256);
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
            localayt.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259256);
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
            localayt.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259256);
          return 0;
        case 3: 
          localayt.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259256);
          return 0;
        case 4: 
          localayt.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259256);
          return 0;
        case 5: 
          localayt.lNX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259256);
          return 0;
        case 6: 
          localayt.EzH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259256);
          return 0;
        case 7: 
          localayt.ZJC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259256);
          return 0;
        case 8: 
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
            localayt.ZDZ = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259256);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bxv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bxv)localObject2).parseFrom((byte[])localObject1);
          }
          localayt.usualTopics.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259256);
        return 0;
      }
      AppMethodBeat.o(259256);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayt
 * JD-Core Version:    0.7.0.1
 */