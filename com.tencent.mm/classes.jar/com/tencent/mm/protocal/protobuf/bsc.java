package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsc
  extends dop
{
  public String LZf;
  public int LZg;
  public LinkedList<dqi> LZh;
  public int LZi;
  public String xNU;
  
  public bsc()
  {
    AppMethodBeat.i(91494);
    this.LZh = new LinkedList();
    AppMethodBeat.o(91494);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LZf != null) {
        paramVarArgs.e(2, this.LZf);
      }
      paramVarArgs.aM(3, this.LZg);
      paramVarArgs.e(4, 8, this.LZh);
      if (this.xNU != null) {
        paramVarArgs.e(5, this.xNU);
      }
      paramVarArgs.aM(6, this.LZi);
      AppMethodBeat.o(91495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LZf != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LZf);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LZg) + g.a.a.a.c(4, 8, this.LZh);
      paramInt = i;
      if (this.xNU != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.xNU);
      }
      i = g.a.a.b.b.a.bu(6, this.LZi);
      AppMethodBeat.o(91495);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LZh.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91495);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bsc localbsc = (bsc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91495);
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
            localbsc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 2: 
          localbsc.LZf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91495);
          return 0;
        case 3: 
          localbsc.LZg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91495);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbsc.LZh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91495);
          return 0;
        case 5: 
          localbsc.xNU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91495);
          return 0;
        }
        localbsc.LZi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91495);
        return 0;
      }
      AppMethodBeat.o(91495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsc
 * JD-Core Version:    0.7.0.1
 */