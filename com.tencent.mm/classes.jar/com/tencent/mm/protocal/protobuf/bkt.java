package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkt
  extends dop
{
  public String LTF;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114022);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.latitude);
      paramVarArgs.e(3, this.longitude);
      paramVarArgs.aM(4, this.scene);
      if (this.LTF != null) {
        paramVarArgs.e(5, this.LTF);
      }
      AppMethodBeat.o(114022);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label504;
      }
    }
    label504:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.fS(2) + 8) + (g.a.a.b.b.a.fS(3) + 8) + g.a.a.b.b.a.bu(4, this.scene);
      paramInt = i;
      if (this.LTF != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LTF);
      }
      AppMethodBeat.o(114022);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114022);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkt localbkt = (bkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114022);
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
            localbkt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114022);
          return 0;
        case 2: 
          localbkt.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114022);
          return 0;
        case 3: 
          localbkt.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114022);
          return 0;
        case 4: 
          localbkt.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114022);
          return 0;
        }
        localbkt.LTF = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(114022);
        return 0;
      }
      AppMethodBeat.o(114022);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */