package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekc
  extends dpc
{
  public String HHX;
  public boolean HIl;
  public String dQx;
  public int pTZ;
  public boolean pTt;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72601);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.cc(4, this.pTt);
      paramVarArgs.cc(5, this.HIl);
      if (this.HHX != null) {
        paramVarArgs.e(6, this.HHX);
      }
      if (this.dQx != null) {
        paramVarArgs.e(7, this.dQx);
      }
      AppMethodBeat.o(72601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label622;
      }
    }
    label622:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + (g.a.a.b.b.a.fS(4) + 1) + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.HHX != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.HHX);
      }
      i = paramInt;
      if (this.dQx != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.dQx);
      }
      AppMethodBeat.o(72601);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekc localekc = (ekc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72601);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localekc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72601);
          return 0;
        case 2: 
          localekc.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72601);
          return 0;
        case 3: 
          localekc.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72601);
          return 0;
        case 4: 
          localekc.pTt = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72601);
          return 0;
        case 5: 
          localekc.HIl = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72601);
          return 0;
        case 6: 
          localekc.HHX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72601);
          return 0;
        }
        localekc.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72601);
        return 0;
      }
      AppMethodBeat.o(72601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekc
 * JD-Core Version:    0.7.0.1
 */