package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dju
  extends com.tencent.mm.bx.a
{
  public fyb aaPJ;
  public byz aaPK;
  public fyb aaPL;
  public String editId;
  public int endTime;
  public int height;
  public int retryCount;
  public int startTime;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169087);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaPJ != null)
      {
        paramVarArgs.qD(1, this.aaPJ.computeSize());
        this.aaPJ.writeFields(paramVarArgs);
      }
      if (this.aaPK != null)
      {
        paramVarArgs.qD(2, this.aaPK.computeSize());
        this.aaPK.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.startTime);
      paramVarArgs.bS(4, this.endTime);
      paramVarArgs.bS(5, this.width);
      paramVarArgs.bS(6, this.height);
      if (this.aaPL != null)
      {
        paramVarArgs.qD(7, this.aaPL.computeSize());
        this.aaPL.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.retryCount);
      if (this.editId != null) {
        paramVarArgs.g(9, this.editId);
      }
      AppMethodBeat.o(169087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaPJ == null) {
        break label832;
      }
    }
    label832:
    for (paramInt = i.a.a.a.qC(1, this.aaPJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaPK != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaPK.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(3, this.startTime) + i.a.a.b.b.a.cJ(4, this.endTime) + i.a.a.b.b.a.cJ(5, this.width) + i.a.a.b.b.a.cJ(6, this.height);
      paramInt = i;
      if (this.aaPL != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaPL.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.retryCount);
      paramInt = i;
      if (this.editId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.editId);
      }
      AppMethodBeat.o(169087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(169087);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dju localdju = (dju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169087);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fyb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fyb)localObject2).parseFrom((byte[])localObject1);
            }
            localdju.aaPJ = ((fyb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new byz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((byz)localObject2).parseFrom((byte[])localObject1);
            }
            localdju.aaPK = ((byz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 3: 
          localdju.startTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169087);
          return 0;
        case 4: 
          localdju.endTime = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169087);
          return 0;
        case 5: 
          localdju.width = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169087);
          return 0;
        case 6: 
          localdju.height = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169087);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fyb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fyb)localObject2).parseFrom((byte[])localObject1);
            }
            localdju.aaPL = ((fyb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169087);
          return 0;
        case 8: 
          localdju.retryCount = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(169087);
          return 0;
        }
        localdju.editId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(169087);
        return 0;
      }
      AppMethodBeat.o(169087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dju
 * JD-Core Version:    0.7.0.1
 */