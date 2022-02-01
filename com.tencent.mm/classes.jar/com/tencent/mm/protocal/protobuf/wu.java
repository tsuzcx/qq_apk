package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wu
  extends dop
{
  public boolean LhR;
  public boolean LhS;
  public LinkedList<Integer> Lhn;
  public String desc;
  
  public wu()
  {
    AppMethodBeat.i(72444);
    this.Lhn = new LinkedList();
    AppMethodBeat.o(72444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72445);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.Lhn);
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      paramVarArgs.cc(4, this.LhR);
      paramVarArgs.cc(5, this.LhS);
      AppMethodBeat.o(72445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label517;
      }
    }
    label517:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 2, this.Lhn);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.desc);
      }
      i = g.a.a.b.b.a.fS(4);
      int j = g.a.a.b.b.a.fS(5);
      AppMethodBeat.o(72445);
      return paramInt + (i + 1) + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lhn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wu localwu = (wu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72445);
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
            localwu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72445);
          return 0;
        case 2: 
          localwu.Lhn.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(72445);
          return 0;
        case 3: 
          localwu.desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72445);
          return 0;
        case 4: 
          localwu.LhR = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(72445);
          return 0;
        }
        localwu.LhS = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(72445);
        return 0;
      }
      AppMethodBeat.o(72445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wu
 * JD-Core Version:    0.7.0.1
 */