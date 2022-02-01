package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bwz
  extends dop
{
  public LinkedList<dqi> KGP;
  public int LUu;
  public int Scene;
  public String hik;
  
  public bwz()
  {
    AppMethodBeat.i(32274);
    this.KGP = new LinkedList();
    AppMethodBeat.o(32274);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32275);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hik != null) {
        paramVarArgs.e(2, this.hik);
      }
      paramVarArgs.aM(3, this.LUu);
      paramVarArgs.e(4, 8, this.KGP);
      paramVarArgs.aM(5, this.Scene);
      AppMethodBeat.o(32275);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label613;
      }
    }
    label613:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hik != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.hik);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.LUu);
      int j = g.a.a.a.c(4, 8, this.KGP);
      int k = g.a.a.b.b.a.bu(5, this.Scene);
      AppMethodBeat.o(32275);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KGP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32275);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwz localbwz = (bwz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32275);
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
            localbwz.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        case 2: 
          localbwz.hik = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32275);
          return 0;
        case 3: 
          localbwz.LUu = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32275);
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
            localbwz.KGP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32275);
          return 0;
        }
        localbwz.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32275);
        return 0;
      }
      AppMethodBeat.o(32275);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwz
 * JD-Core Version:    0.7.0.1
 */