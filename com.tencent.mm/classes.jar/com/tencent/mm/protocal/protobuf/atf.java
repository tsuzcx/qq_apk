package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class atf
  extends dop
{
  public String LAt;
  public aov LBM;
  public b LDs;
  public long LDu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.LDu);
      if (this.LAt != null) {
        paramVarArgs.e(3, this.LAt);
      }
      if (this.LDs != null) {
        paramVarArgs.c(4, this.LDs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(5, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.LDu);
      paramInt = i;
      if (this.LAt != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LAt);
      }
      i = paramInt;
      if (this.LDs != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.LDs);
      }
      paramInt = i;
      if (this.LBM != null) {
        paramInt = i + g.a.a.a.nh(5, this.LBM.computeSize());
      }
      AppMethodBeat.o(209439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        atf localatf = (atf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209439);
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
            localatf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209439);
          return 0;
        case 2: 
          localatf.LDu = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209439);
          return 0;
        case 3: 
          localatf.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209439);
          return 0;
        case 4: 
          localatf.LDs = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209439);
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
          localatf.LBM = ((aov)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209439);
        return 0;
      }
      AppMethodBeat.o(209439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atf
 * JD-Core Version:    0.7.0.1
 */