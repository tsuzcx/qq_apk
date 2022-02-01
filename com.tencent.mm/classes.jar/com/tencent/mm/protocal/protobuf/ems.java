package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ems
  extends dop
{
  public int KXC;
  public int NkO;
  public int NkP;
  public int NkQ;
  public int bDZ;
  public int scene;
  public String session_id;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123664);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.scene);
      paramVarArgs.aM(3, this.NkO);
      paramVarArgs.aM(4, this.KXC);
      paramVarArgs.aM(5, this.NkP);
      paramVarArgs.aM(6, this.NkQ);
      if (this.username != null) {
        paramVarArgs.e(7, this.username);
      }
      paramVarArgs.aM(8, this.bDZ);
      if (this.session_id != null) {
        paramVarArgs.e(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.scene) + g.a.a.b.b.a.bu(3, this.NkO) + g.a.a.b.b.a.bu(4, this.KXC) + g.a.a.b.b.a.bu(5, this.NkP) + g.a.a.b.b.a.bu(6, this.NkQ);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.username);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.bDZ);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.session_id);
      }
      AppMethodBeat.o(123664);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ems localems = (ems)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123664);
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
            localems.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123664);
          return 0;
        case 2: 
          localems.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123664);
          return 0;
        case 3: 
          localems.NkO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123664);
          return 0;
        case 4: 
          localems.KXC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123664);
          return 0;
        case 5: 
          localems.NkP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123664);
          return 0;
        case 6: 
          localems.NkQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123664);
          return 0;
        case 7: 
          localems.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123664);
          return 0;
        case 8: 
          localems.bDZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123664);
          return 0;
        }
        localems.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123664);
        return 0;
      }
      AppMethodBeat.o(123664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ems
 * JD-Core Version:    0.7.0.1
 */