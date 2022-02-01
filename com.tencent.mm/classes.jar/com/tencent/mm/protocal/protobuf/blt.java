package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class blt
  extends dop
{
  public LinkedList<dqi> KGP;
  public dqi LUA;
  public int LUu;
  public int LUv;
  public LinkedList<dqi> LUw;
  public int LUx;
  public LinkedList<dqi> LUy;
  public int LUz;
  
  public blt()
  {
    AppMethodBeat.i(32232);
    this.KGP = new LinkedList();
    this.LUw = new LinkedList();
    this.LUy = new LinkedList();
    AppMethodBeat.o(32232);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32233);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LUu);
      paramVarArgs.e(3, 8, this.KGP);
      paramVarArgs.aM(4, this.LUv);
      paramVarArgs.e(5, 8, this.LUw);
      paramVarArgs.aM(6, this.LUx);
      paramVarArgs.e(7, 8, this.LUy);
      paramVarArgs.aM(8, this.LUz);
      if (this.LUA != null)
      {
        paramVarArgs.ni(9, this.LUA.computeSize());
        this.LUA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32233);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1069;
      }
    }
    label1069:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LUu) + g.a.a.a.c(3, 8, this.KGP) + g.a.a.b.b.a.bu(4, this.LUv) + g.a.a.a.c(5, 8, this.LUw) + g.a.a.b.b.a.bu(6, this.LUx) + g.a.a.a.c(7, 8, this.LUy) + g.a.a.b.b.a.bu(8, this.LUz);
      paramInt = i;
      if (this.LUA != null) {
        paramInt = i + g.a.a.a.nh(9, this.LUA.computeSize());
      }
      AppMethodBeat.o(32233);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGP.clear();
        this.LUw.clear();
        this.LUy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        blt localblt = (blt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32233);
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
            localblt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 2: 
          localblt.LUu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32233);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblt.KGP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 4: 
          localblt.LUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32233);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblt.LUw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 6: 
          localblt.LUx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32233);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localblt.LUy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32233);
          return 0;
        case 8: 
          localblt.LUz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32233);
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
          localblt.LUA = ((dqi)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32233);
        return 0;
      }
      AppMethodBeat.o(32233);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blt
 * JD-Core Version:    0.7.0.1
 */