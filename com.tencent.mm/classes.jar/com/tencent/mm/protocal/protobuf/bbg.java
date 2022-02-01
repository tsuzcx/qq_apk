package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbg
  extends esc
{
  public epc BbC;
  public long Bbb;
  public bxv ZLU;
  public int ZLX;
  public efb ZLY;
  public bxt bgmInfo;
  public int continueFlag;
  public com.tencent.mm.bx.b lastBuffer;
  public LinkedList<FinderObject> object;
  public btc preloadInfo;
  
  public bbg()
  {
    AppMethodBeat.i(168991);
    this.object = new LinkedList();
    AppMethodBeat.o(168991);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168992);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(168992);
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
      paramVarArgs.bv(5, this.Bbb);
      if (this.ZLU != null)
      {
        paramVarArgs.qD(6, this.ZLU.computeSize());
        this.ZLU.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.ZLX);
      if (this.BbC != null)
      {
        paramVarArgs.qD(8, this.BbC.computeSize());
        this.BbC.writeFields(paramVarArgs);
      }
      if (this.ZLY != null)
      {
        paramVarArgs.qD(9, this.ZLY.computeSize());
        this.ZLY.writeFields(paramVarArgs);
      }
      if (this.preloadInfo != null)
      {
        paramVarArgs.qD(10, this.preloadInfo.computeSize());
        this.preloadInfo.writeFields(paramVarArgs);
      }
      if (this.bgmInfo != null)
      {
        paramVarArgs.qD(11, this.bgmInfo.computeSize());
        this.bgmInfo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168992);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1316;
      }
    }
    label1316:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.lastBuffer);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.continueFlag) + i.a.a.b.b.a.q(5, this.Bbb);
      paramInt = i;
      if (this.ZLU != null) {
        paramInt = i + i.a.a.a.qC(6, this.ZLU.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.ZLX);
      paramInt = i;
      if (this.BbC != null) {
        paramInt = i + i.a.a.a.qC(8, this.BbC.computeSize());
      }
      i = paramInt;
      if (this.ZLY != null) {
        i = paramInt + i.a.a.a.qC(9, this.ZLY.computeSize());
      }
      paramInt = i;
      if (this.preloadInfo != null) {
        paramInt = i + i.a.a.a.qC(10, this.preloadInfo.computeSize());
      }
      i = paramInt;
      if (this.bgmInfo != null) {
        i = paramInt + i.a.a.a.qC(11, this.bgmInfo.computeSize());
      }
      AppMethodBeat.o(168992);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(168992);
          throw paramVarArgs;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bbg localbbg = (bbg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168992);
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
            localbbg.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
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
            localbbg.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 3: 
          localbbg.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168992);
          return 0;
        case 4: 
          localbbg.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168992);
          return 0;
        case 5: 
          localbbg.Bbb = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168992);
          return 0;
        case 6: 
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
            localbbg.ZLU = ((bxv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 7: 
          localbbg.ZLX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168992);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epc)localObject2).parseFrom((byte[])localObject1);
            }
            localbbg.BbC = ((epc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new efb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((efb)localObject2).parseFrom((byte[])localObject1);
            }
            localbbg.ZLY = ((efb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        case 10: 
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
            localbbg.preloadInfo = ((btc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168992);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bxt();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bxt)localObject2).parseFrom((byte[])localObject1);
          }
          localbbg.bgmInfo = ((bxt)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168992);
        return 0;
      }
      AppMethodBeat.o(168992);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbg
 * JD-Core Version:    0.7.0.1
 */