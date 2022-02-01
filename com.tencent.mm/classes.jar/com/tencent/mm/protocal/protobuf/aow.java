package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aow
  extends com.tencent.mm.cd.a
{
  public csh AAM;
  public cso SBW;
  public FinderFeedReportObject SBX;
  public bgw SBY;
  public arw SBZ;
  public cso SCa;
  public cso SCb;
  public csc SCc;
  public int mVu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207812);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.mVu);
      if (this.AAM != null)
      {
        paramVarArgs.oE(2, this.AAM.computeSize());
        this.AAM.writeFields(paramVarArgs);
      }
      if (this.SBW != null)
      {
        paramVarArgs.oE(3, this.SBW.computeSize());
        this.SBW.writeFields(paramVarArgs);
      }
      if (this.SBX != null)
      {
        paramVarArgs.oE(4, this.SBX.computeSize());
        this.SBX.writeFields(paramVarArgs);
      }
      if (this.SBY != null)
      {
        paramVarArgs.oE(5, this.SBY.computeSize());
        this.SBY.writeFields(paramVarArgs);
      }
      if (this.SBZ != null)
      {
        paramVarArgs.oE(6, this.SBZ.computeSize());
        this.SBZ.writeFields(paramVarArgs);
      }
      if (this.SCa != null)
      {
        paramVarArgs.oE(7, this.SCa.computeSize());
        this.SCa.writeFields(paramVarArgs);
      }
      if (this.SCb != null)
      {
        paramVarArgs.oE(8, this.SCb.computeSize());
        this.SCb.writeFields(paramVarArgs);
      }
      if (this.SCc != null)
      {
        paramVarArgs.oE(9, this.SCc.computeSize());
        this.SCc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207812);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.mVu) + 0;
      paramInt = i;
      if (this.AAM != null) {
        paramInt = i + g.a.a.a.oD(2, this.AAM.computeSize());
      }
      i = paramInt;
      if (this.SBW != null) {
        i = paramInt + g.a.a.a.oD(3, this.SBW.computeSize());
      }
      paramInt = i;
      if (this.SBX != null) {
        paramInt = i + g.a.a.a.oD(4, this.SBX.computeSize());
      }
      i = paramInt;
      if (this.SBY != null) {
        i = paramInt + g.a.a.a.oD(5, this.SBY.computeSize());
      }
      paramInt = i;
      if (this.SBZ != null) {
        paramInt = i + g.a.a.a.oD(6, this.SBZ.computeSize());
      }
      i = paramInt;
      if (this.SCa != null) {
        i = paramInt + g.a.a.a.oD(7, this.SCa.computeSize());
      }
      paramInt = i;
      if (this.SCb != null) {
        paramInt = i + g.a.a.a.oD(8, this.SCb.computeSize());
      }
      i = paramInt;
      if (this.SCc != null) {
        i = paramInt + g.a.a.a.oD(9, this.SCc.computeSize());
      }
      AppMethodBeat.o(207812);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207812);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aow localaow = (aow)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207812);
        return -1;
      case 1: 
        localaow.mVu = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(207812);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new csh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((csh)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.AAM = ((csh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cso();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cso)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.SBW = ((cso)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderFeedReportObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderFeedReportObject)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.SBX = ((FinderFeedReportObject)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bgw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bgw)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.SBY = ((bgw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new arw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((arw)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.SBZ = ((arw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cso();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cso)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.SCa = ((cso)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      case 8: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cso();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cso)localObject2).parseFrom((byte[])localObject1);
          }
          localaow.SCb = ((cso)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207812);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new csc();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((csc)localObject2).parseFrom((byte[])localObject1);
        }
        localaow.SCc = ((csc)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(207812);
      return 0;
    }
    AppMethodBeat.o(207812);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aow
 * JD-Core Version:    0.7.0.1
 */