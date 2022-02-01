package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ayv
  extends dop
{
  public String LAt;
  public aov LBM;
  public long LIT;
  public long object_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209602);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LBM != null)
      {
        paramVarArgs.ni(2, this.LBM.computeSize());
        this.LBM.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(3, this.LIT);
      paramVarArgs.aM(4, this.scene);
      paramVarArgs.bb(5, this.object_id);
      if (this.LAt != null) {
        paramVarArgs.e(6, this.LAt);
      }
      AppMethodBeat.o(209602);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LBM != null) {
        i = paramInt + g.a.a.a.nh(2, this.LBM.computeSize());
      }
      i = i + g.a.a.b.b.a.r(3, this.LIT) + g.a.a.b.b.a.bu(4, this.scene) + g.a.a.b.b.a.r(5, this.object_id);
      paramInt = i;
      if (this.LAt != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LAt);
      }
      AppMethodBeat.o(209602);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209602);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ayv localayv = (ayv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209602);
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
            localayv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209602);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localayv.LBM = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209602);
          return 0;
        case 3: 
          localayv.LIT = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209602);
          return 0;
        case 4: 
          localayv.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209602);
          return 0;
        case 5: 
          localayv.object_id = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209602);
          return 0;
        }
        localayv.LAt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209602);
        return 0;
      }
      AppMethodBeat.o(209602);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayv
 * JD-Core Version:    0.7.0.1
 */