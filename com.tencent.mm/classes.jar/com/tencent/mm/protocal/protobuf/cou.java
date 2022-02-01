package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cou
  extends esc
{
  public dxl aavJ;
  public String aavK;
  public int xld;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259536);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aavJ != null)
      {
        paramVarArgs.qD(2, this.aavJ.computeSize());
        this.aavJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.xld);
      if (this.aavK != null) {
        paramVarArgs.g(4, this.aavK);
      }
      AppMethodBeat.o(259536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aavJ != null) {
        i = paramInt + i.a.a.a.qC(2, this.aavJ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.xld);
      paramInt = i;
      if (this.aavK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aavK);
      }
      AppMethodBeat.o(259536);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cou localcou = (cou)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259536);
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
            localcou.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259536);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxl)localObject2).parseFrom((byte[])localObject1);
            }
            localcou.aavJ = ((dxl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259536);
          return 0;
        case 3: 
          localcou.xld = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259536);
          return 0;
        }
        localcou.aavK = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259536);
        return 0;
      }
      AppMethodBeat.o(259536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cou
 * JD-Core Version:    0.7.0.1
 */