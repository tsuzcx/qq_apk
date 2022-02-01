package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwb
  extends dop
{
  public int Lcr;
  public String MbW;
  public String MbX;
  public int MbY;
  public int MbZ = 4;
  public String dNI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123580);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.MbW != null) {
        paramVarArgs.e(3, this.MbW);
      }
      if (this.MbX != null) {
        paramVarArgs.e(4, this.MbX);
      }
      paramVarArgs.aM(5, this.Lcr);
      paramVarArgs.aM(6, this.MbY);
      paramVarArgs.aM(7, this.MbZ);
      AppMethodBeat.o(123580);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.MbW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MbW);
      }
      paramInt = i;
      if (this.MbX != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MbX);
      }
      i = g.a.a.b.b.a.bu(5, this.Lcr);
      int j = g.a.a.b.b.a.bu(6, this.MbY);
      int k = g.a.a.b.b.a.bu(7, this.MbZ);
      AppMethodBeat.o(123580);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123580);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwb localbwb = (bwb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123580);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbwb.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123580);
          return 0;
        case 2: 
          localbwb.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 3: 
          localbwb.MbW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 4: 
          localbwb.MbX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123580);
          return 0;
        case 5: 
          localbwb.Lcr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123580);
          return 0;
        case 6: 
          localbwb.MbY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123580);
          return 0;
        }
        localbwb.MbZ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(123580);
        return 0;
      }
      AppMethodBeat.o(123580);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwb
 * JD-Core Version:    0.7.0.1
 */