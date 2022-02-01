package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dxp
  extends dop
{
  public LinkedList<Integer> KOn;
  public String MXp;
  public int Scene;
  public int oTz;
  
  public dxp()
  {
    AppMethodBeat.i(127502);
    this.KOn = new LinkedList();
    AppMethodBeat.o(127502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127503);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MXp != null) {
        paramVarArgs.e(2, this.MXp);
      }
      paramVarArgs.aM(3, this.Scene);
      paramVarArgs.aM(4, this.oTz);
      paramVarArgs.f(5, 2, this.KOn);
      AppMethodBeat.o(127503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label537;
      }
    }
    label537:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MXp != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.MXp);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.Scene);
      int j = g.a.a.b.b.a.bu(4, this.oTz);
      int k = g.a.a.a.d(5, 2, this.KOn);
      AppMethodBeat.o(127503);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KOn.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxp localdxp = (dxp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127503);
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
            localdxp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127503);
          return 0;
        case 2: 
          localdxp.MXp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(127503);
          return 0;
        case 3: 
          localdxp.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127503);
          return 0;
        case 4: 
          localdxp.oTz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(127503);
          return 0;
        }
        localdxp.KOn = new g.a.a.a.a(((g.a.a.a.a)localObject1).UbS.hPo().zy, unknownTagHandler).UbS.hPm();
        AppMethodBeat.o(127503);
        return 0;
      }
      AppMethodBeat.o(127503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxp
 * JD-Core Version:    0.7.0.1
 */