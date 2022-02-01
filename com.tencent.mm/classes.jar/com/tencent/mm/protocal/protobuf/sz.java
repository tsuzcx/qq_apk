package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class sz
  extends dop
{
  public b LaW;
  public b LaX;
  public int LaY;
  public int LaZ;
  public int Lba;
  public int jlm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218975);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LaW != null) {
        paramVarArgs.c(2, this.LaW);
      }
      paramVarArgs.aM(3, this.jlm);
      if (this.LaX != null) {
        paramVarArgs.c(4, this.LaX);
      }
      paramVarArgs.aM(5, this.LaY);
      paramVarArgs.aM(6, this.LaZ);
      paramVarArgs.aM(7, this.Lba);
      AppMethodBeat.o(218975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LaW != null) {
        i = paramInt + g.a.a.b.b.a.b(2, this.LaW);
      }
      i += g.a.a.b.b.a.bu(3, this.jlm);
      paramInt = i;
      if (this.LaX != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LaX);
      }
      i = g.a.a.b.b.a.bu(5, this.LaY);
      int j = g.a.a.b.b.a.bu(6, this.LaZ);
      int k = g.a.a.b.b.a.bu(7, this.Lba);
      AppMethodBeat.o(218975);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(218975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        sz localsz = (sz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(218975);
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
            localsz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(218975);
          return 0;
        case 2: 
          localsz.LaW = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(218975);
          return 0;
        case 3: 
          localsz.jlm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(218975);
          return 0;
        case 4: 
          localsz.LaX = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(218975);
          return 0;
        case 5: 
          localsz.LaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(218975);
          return 0;
        case 6: 
          localsz.LaZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(218975);
          return 0;
        }
        localsz.Lba = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(218975);
        return 0;
      }
      AppMethodBeat.o(218975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sz
 * JD-Core Version:    0.7.0.1
 */