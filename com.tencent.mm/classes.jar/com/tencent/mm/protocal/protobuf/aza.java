package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aza
  extends dop
{
  public aov LBM;
  public LinkedList<Long> LIX;
  public int dYx;
  public String finderUsername;
  
  public aza()
  {
    AppMethodBeat.i(209606);
    this.LIX = new LinkedList();
    AppMethodBeat.o(209606);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209607);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dYx);
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      paramVarArgs.e(4, 3, this.LIX);
      if (this.LBM != null)
      {
        paramVarArgs.ni(5, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209607);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label629;
      }
    }
    label629:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dYx);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      i = paramInt + g.a.a.a.c(4, 3, this.LIX);
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(5, this.LBM.computeSize());
      }
      AppMethodBeat.o(209607);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LIX.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209607);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aza localaza = (aza)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209607);
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
            localaza.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209607);
          return 0;
        case 2: 
          localaza.dYx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209607);
          return 0;
        case 3: 
          localaza.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209607);
          return 0;
        case 4: 
          localaza.LIX.add(Long.valueOf(((g.a.a.a.a)localObject1).UbS.zl()));
          AppMethodBeat.o(209607);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aov();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaza.LBM = ((aov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209607);
        return 0;
      }
      AppMethodBeat.o(209607);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aza
 * JD-Core Version:    0.7.0.1
 */