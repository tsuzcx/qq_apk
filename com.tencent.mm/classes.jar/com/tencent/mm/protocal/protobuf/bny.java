package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bny
  extends dop
{
  public int BsF;
  public int BsG;
  public int LWm;
  public int LWn;
  public String LWo;
  public int LWp;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      paramVarArgs.aM(3, this.LWm);
      paramVarArgs.aM(4, this.LWn);
      if (this.LWo != null) {
        paramVarArgs.e(5, this.LWo);
      }
      paramVarArgs.aM(6, this.BsF);
      paramVarArgs.aM(7, this.BsG);
      paramVarArgs.aM(8, this.LWp);
      AppMethodBeat.o(152570);
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
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = i + g.a.a.b.b.a.bu(3, this.LWm) + g.a.a.b.b.a.bu(4, this.LWn);
      paramInt = i;
      if (this.LWo != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LWo);
      }
      i = g.a.a.b.b.a.bu(6, this.BsF);
      int j = g.a.a.b.b.a.bu(7, this.BsG);
      int k = g.a.a.b.b.a.bu(8, this.LWp);
      AppMethodBeat.o(152570);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bny localbny = (bny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152570);
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
            localbny.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152570);
          return 0;
        case 2: 
          localbny.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 3: 
          localbny.LWm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152570);
          return 0;
        case 4: 
          localbny.LWn = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152570);
          return 0;
        case 5: 
          localbny.LWo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152570);
          return 0;
        case 6: 
          localbny.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152570);
          return 0;
        case 7: 
          localbny.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152570);
          return 0;
        }
        localbny.LWp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152570);
        return 0;
      }
      AppMethodBeat.o(152570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bny
 * JD-Core Version:    0.7.0.1
 */