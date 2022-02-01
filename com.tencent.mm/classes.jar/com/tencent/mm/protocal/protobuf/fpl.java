package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fpl
  extends esc
{
  public epk abPn;
  public String abPs;
  public String abPt;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72591);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.abPs != null) {
        paramVarArgs.g(4, this.abPs);
      }
      if (this.abPt != null) {
        paramVarArgs.g(5, this.abPt);
      }
      if (this.abPn != null)
      {
        paramVarArgs.qD(6, this.abPn.computeSize());
        this.abPn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label642;
      }
    }
    label642:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.abPs != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abPs);
      }
      paramInt = i;
      if (this.abPt != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abPt);
      }
      i = paramInt;
      if (this.abPn != null) {
        i = paramInt + i.a.a.a.qC(6, this.abPn.computeSize());
      }
      AppMethodBeat.o(72591);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fpl localfpl = (fpl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72591);
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
            localfpl.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72591);
          return 0;
        case 2: 
          localfpl.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72591);
          return 0;
        case 3: 
          localfpl.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 4: 
          localfpl.abPs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 5: 
          localfpl.abPt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72591);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new epk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((epk)localObject2).parseFrom((byte[])localObject1);
          }
          localfpl.abPn = ((epk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      AppMethodBeat.o(72591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fpl
 * JD-Core Version:    0.7.0.1
 */