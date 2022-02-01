package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvv
  extends dop
{
  public int MbN;
  public int xIV;
  public LinkedList<dqi> xLF;
  public int xLV;
  public int xLW;
  public String xLl;
  
  public bvv()
  {
    AppMethodBeat.i(152596);
    this.xLF = new LinkedList();
    AppMethodBeat.o(152596);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152597);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xIV);
      paramVarArgs.aM(3, this.xLV);
      paramVarArgs.aM(4, this.xLW);
      if (this.xLl != null) {
        paramVarArgs.e(5, this.xLl);
      }
      paramVarArgs.aM(6, this.MbN);
      paramVarArgs.e(7, 8, this.xLF);
      AppMethodBeat.o(152597);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xIV) + g.a.a.b.b.a.bu(3, this.xLV) + g.a.a.b.b.a.bu(4, this.xLW);
      paramInt = i;
      if (this.xLl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xLl);
      }
      i = g.a.a.b.b.a.bu(6, this.MbN);
      int j = g.a.a.a.c(7, 8, this.xLF);
      AppMethodBeat.o(152597);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xLF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvv localbvv = (bvv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152597);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbvv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152597);
          return 0;
        case 2: 
          localbvv.xIV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152597);
          return 0;
        case 3: 
          localbvv.xLV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152597);
          return 0;
        case 4: 
          localbvv.xLW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152597);
          return 0;
        case 5: 
          localbvv.xLl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152597);
          return 0;
        case 6: 
          localbvv.MbN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152597);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqi();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbvv.xLF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152597);
        return 0;
      }
      AppMethodBeat.o(152597);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvv
 * JD-Core Version:    0.7.0.1
 */