package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dub
  extends esc
{
  public int YAT;
  public int YYp;
  public int aaZA;
  public int aaZB;
  public LinkedList<adw> aaZC;
  public gol aaZy;
  public gol aaZz;
  
  public dub()
  {
    AppMethodBeat.i(133182);
    this.aaZC = new LinkedList();
    AppMethodBeat.o(133182);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133183);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.aaZy == null)
      {
        paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.aaZz == null)
      {
        paramVarArgs = new b("Not all required fields were included: MaxSynckey");
        AppMethodBeat.o(133183);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaZy != null)
      {
        paramVarArgs.qD(2, this.aaZy.computeSize());
        this.aaZy.writeFields(paramVarArgs);
      }
      if (this.aaZz != null)
      {
        paramVarArgs.qD(3, this.aaZz.computeSize());
        this.aaZz.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.YYp);
      paramVarArgs.bS(5, this.aaZA);
      paramVarArgs.bS(6, this.aaZB);
      paramVarArgs.e(7, 8, this.aaZC);
      paramVarArgs.bS(8, this.YAT);
      AppMethodBeat.o(133183);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1002;
      }
    }
    label1002:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaZy != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaZy.computeSize());
      }
      i = paramInt;
      if (this.aaZz != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaZz.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YYp);
      int j = i.a.a.b.b.a.cJ(5, this.aaZA);
      int k = i.a.a.b.b.a.cJ(6, this.aaZB);
      int m = i.a.a.a.c(7, 8, this.aaZC);
      int n = i.a.a.b.b.a.cJ(8, this.YAT);
      AppMethodBeat.o(133183);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaZC.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.aaZy == null)
        {
          paramVarArgs = new b("Not all required fields were included: CurrentSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        if (this.aaZz == null)
        {
          paramVarArgs = new b("Not all required fields were included: MaxSynckey");
          AppMethodBeat.o(133183);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133183);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dub localdub = (dub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133183);
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
            localdub.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 2: 
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
            localdub.aaZy = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
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
            localdub.aaZz = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        case 4: 
          localdub.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133183);
          return 0;
        case 5: 
          localdub.aaZA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133183);
          return 0;
        case 6: 
          localdub.aaZB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133183);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adw)localObject2).parseFrom((byte[])localObject1);
            }
            localdub.aaZC.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133183);
          return 0;
        }
        localdub.YAT = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133183);
        return 0;
      }
      AppMethodBeat.o(133183);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dub
 * JD-Core Version:    0.7.0.1
 */