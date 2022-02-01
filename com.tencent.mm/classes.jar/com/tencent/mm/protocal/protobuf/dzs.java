package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzs
  extends dop
{
  public int BsF;
  public int BsG;
  public String MZo;
  public int MZp;
  public int oUv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125782);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.BsG);
      paramVarArgs.aM(3, this.BsF);
      if (this.MZo != null) {
        paramVarArgs.e(4, this.MZo);
      }
      paramVarArgs.aM(5, this.oUv);
      paramVarArgs.aM(6, this.MZp);
      AppMethodBeat.o(125782);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsG) + g.a.a.b.b.a.bu(3, this.BsF);
      paramInt = i;
      if (this.MZo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MZo);
      }
      i = g.a.a.b.b.a.bu(5, this.oUv);
      int j = g.a.a.b.b.a.bu(6, this.MZp);
      AppMethodBeat.o(125782);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125782);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dzs localdzs = (dzs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125782);
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
            localdzs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125782);
          return 0;
        case 2: 
          localdzs.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125782);
          return 0;
        case 3: 
          localdzs.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125782);
          return 0;
        case 4: 
          localdzs.MZo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125782);
          return 0;
        case 5: 
          localdzs.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125782);
          return 0;
        }
        localdzs.MZp = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125782);
        return 0;
      }
      AppMethodBeat.o(125782);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzs
 * JD-Core Version:    0.7.0.1
 */