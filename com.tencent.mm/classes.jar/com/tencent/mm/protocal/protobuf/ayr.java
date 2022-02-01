package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ayr
  extends esc
{
  public b BgS;
  public long GQt;
  public LinkedList<FinderContact> ZIt;
  public LinkedList<axc> ZJB;
  public int continueFlag;
  
  public ayr()
  {
    AppMethodBeat.i(168977);
    this.ZIt = new LinkedList();
    this.ZJB = new LinkedList();
    AppMethodBeat.o(168977);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168978);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ZIt);
      paramVarArgs.bS(3, this.continueFlag);
      paramVarArgs.bv(4, this.GQt);
      if (this.BgS != null) {
        paramVarArgs.d(5, this.BgS);
      }
      paramVarArgs.e(6, 8, this.ZJB);
      AppMethodBeat.o(168978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label668;
      }
    }
    label668:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.ZIt) + i.a.a.b.b.a.cJ(3, this.continueFlag) + i.a.a.b.b.a.q(4, this.GQt);
      paramInt = i;
      if (this.BgS != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.BgS);
      }
      i = i.a.a.a.c(6, 8, this.ZJB);
      AppMethodBeat.o(168978);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZIt.clear();
        this.ZJB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ayr localayr = (ayr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168978);
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
            localayr.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderContact();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderContact)localObject2).parseFrom((byte[])localObject1);
            }
            localayr.ZIt.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168978);
          return 0;
        case 3: 
          localayr.continueFlag = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168978);
          return 0;
        case 4: 
          localayr.GQt = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168978);
          return 0;
        case 5: 
          localayr.BgS = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(168978);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new axc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((axc)localObject2).parseFrom((byte[])localObject1);
          }
          localayr.ZJB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168978);
        return 0;
      }
      AppMethodBeat.o(168978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayr
 * JD-Core Version:    0.7.0.1
 */