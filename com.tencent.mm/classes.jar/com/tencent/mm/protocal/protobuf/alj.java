package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alj
  extends dop
{
  public String Lum;
  public double latitude;
  public double longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lum != null) {
        paramVarArgs.e(2, this.Lum);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      AppMethodBeat.o(91450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label464;
      }
    }
    label464:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Lum != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Lum);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.fS(4);
      AppMethodBeat.o(91450);
      return i + (paramInt + 8) + (j + 8);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        alj localalj = (alj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91450);
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
            localalj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91450);
          return 0;
        case 2: 
          localalj.Lum = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91450);
          return 0;
        case 3: 
          localalj.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(91450);
          return 0;
        }
        localalj.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
        AppMethodBeat.o(91450);
        return 0;
      }
      AppMethodBeat.o(91450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alj
 * JD-Core Version:    0.7.0.1
 */