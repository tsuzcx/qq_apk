package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class add
  extends esc
{
  public fgv ZlH;
  public fgv ZlI;
  public int ZlJ;
  public int hAV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257803);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZlH != null)
      {
        paramVarArgs.qD(2, this.ZlH.computeSize());
        this.ZlH.writeFields(paramVarArgs);
      }
      if (this.ZlI != null)
      {
        paramVarArgs.qD(3, this.ZlI.computeSize());
        this.ZlI.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.hAV);
      paramVarArgs.bS(5, this.ZlJ);
      AppMethodBeat.o(257803);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label640;
      }
    }
    label640:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZlH != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZlH.computeSize());
      }
      i = paramInt;
      if (this.ZlI != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZlI.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.hAV);
      int j = i.a.a.b.b.a.cJ(5, this.ZlJ);
      AppMethodBeat.o(257803);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257803);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        add localadd = (add)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257803);
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
            localadd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257803);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgv)localObject2).parseFrom((byte[])localObject1);
            }
            localadd.ZlH = ((fgv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257803);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fgv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fgv)localObject2).parseFrom((byte[])localObject1);
            }
            localadd.ZlI = ((fgv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257803);
          return 0;
        case 4: 
          localadd.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257803);
          return 0;
        }
        localadd.ZlJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257803);
        return 0;
      }
      AppMethodBeat.o(257803);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.add
 * JD-Core Version:    0.7.0.1
 */