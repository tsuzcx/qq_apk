package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqd
  extends dop
{
  public int LXV;
  public LinkedList<cpb> LXW;
  public int LXX;
  public LinkedList<cko> LXY;
  public String MD5;
  public int Scene;
  public int him;
  
  public bqd()
  {
    AppMethodBeat.i(155408);
    this.LXW = new LinkedList();
    this.LXY = new LinkedList();
    AppMethodBeat.o(155408);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155409);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.him);
      if (this.MD5 != null) {
        paramVarArgs.e(3, this.MD5);
      }
      paramVarArgs.aM(4, this.LXV);
      paramVarArgs.e(5, 8, this.LXW);
      paramVarArgs.aM(6, this.LXX);
      paramVarArgs.e(7, 8, this.LXY);
      paramVarArgs.aM(8, this.Scene);
      AppMethodBeat.o(155409);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.him);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MD5);
      }
      i = g.a.a.b.b.a.bu(4, this.LXV);
      int j = g.a.a.a.c(5, 8, this.LXW);
      int k = g.a.a.b.b.a.bu(6, this.LXX);
      int m = g.a.a.a.c(7, 8, this.LXY);
      int n = g.a.a.b.b.a.bu(8, this.Scene);
      AppMethodBeat.o(155409);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LXW.clear();
        this.LXY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(155409);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqd localbqd = (bqd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155409);
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
            localbqd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 2: 
          localbqd.him = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155409);
          return 0;
        case 3: 
          localbqd.MD5 = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(155409);
          return 0;
        case 4: 
          localbqd.LXV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155409);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cpb();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cpb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqd.LXW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        case 6: 
          localbqd.LXX = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(155409);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cko();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cko)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqd.LXY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155409);
          return 0;
        }
        localbqd.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(155409);
        return 0;
      }
      AppMethodBeat.o(155409);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqd
 * JD-Core Version:    0.7.0.1
 */