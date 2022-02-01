package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blz
  extends dop
{
  public int Leq;
  public int Ler;
  public double latitude;
  public double longitude;
  public int offset;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201337);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.offset);
      paramVarArgs.aM(3, this.Ler);
      paramVarArgs.e(4, this.latitude);
      paramVarArgs.e(5, this.longitude);
      paramVarArgs.aM(6, this.scene);
      paramVarArgs.aM(7, this.Leq);
      AppMethodBeat.o(201337);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label592;
      }
    }
    label592:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.offset);
      int j = g.a.a.b.b.a.bu(3, this.Ler);
      int k = g.a.a.b.b.a.fS(4);
      int m = g.a.a.b.b.a.fS(5);
      int n = g.a.a.b.b.a.bu(6, this.scene);
      int i1 = g.a.a.b.b.a.bu(7, this.Leq);
      AppMethodBeat.o(201337);
      return paramInt + i + j + (k + 8) + (m + 8) + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(201337);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        blz localblz = (blz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201337);
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
            localblz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201337);
          return 0;
        case 2: 
          localblz.offset = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201337);
          return 0;
        case 3: 
          localblz.Ler = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201337);
          return 0;
        case 4: 
          localblz.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(201337);
          return 0;
        case 5: 
          localblz.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(201337);
          return 0;
        case 6: 
          localblz.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201337);
          return 0;
        }
        localblz.Leq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(201337);
        return 0;
      }
      AppMethodBeat.o(201337);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blz
 * JD-Core Version:    0.7.0.1
 */