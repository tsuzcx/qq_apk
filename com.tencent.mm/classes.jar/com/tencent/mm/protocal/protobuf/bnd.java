package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnd
  extends dpc
{
  public LinkedList<ey> KKx;
  public int LVG;
  public int LVH;
  public LinkedList<Integer> LVI;
  public LinkedList<akl> LVJ;
  public int LVL;
  
  public bnd()
  {
    AppMethodBeat.i(122505);
    this.LVI = new LinkedList();
    this.LVJ = new LinkedList();
    this.KKx = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LVG);
      paramVarArgs.aM(3, this.LVH);
      paramVarArgs.e(4, 2, this.LVI);
      paramVarArgs.e(5, 8, this.LVJ);
      paramVarArgs.aM(6, this.LVL);
      paramVarArgs.e(7, 8, this.KKx);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.LVG);
      int j = g.a.a.b.b.a.bu(3, this.LVH);
      int k = g.a.a.a.c(4, 2, this.LVI);
      int m = g.a.a.a.c(5, 8, this.LVJ);
      int n = g.a.a.b.b.a.bu(6, this.LVL);
      int i1 = g.a.a.a.c(7, 8, this.KKx);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LVI.clear();
        this.LVJ.clear();
        this.KKx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnd localbnd = (bnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbnd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localbnd.LVG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localbnd.LVH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localbnd.LVI.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbnd.LVJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localbnd.LVL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ey();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ey)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbnd.KKx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnd
 * JD-Core Version:    0.7.0.1
 */