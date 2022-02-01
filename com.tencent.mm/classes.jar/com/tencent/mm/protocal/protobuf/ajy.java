package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajy
  extends dop
{
  public String LsY;
  public int LsZ;
  public long Lta;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32193);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.LsZ);
      paramVarArgs.bb(3, this.Lta);
      if (this.LsY != null) {
        paramVarArgs.e(4, this.LsY);
      }
      paramVarArgs.aM(5, this.Scene);
      AppMethodBeat.o(32193);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label513;
      }
    }
    label513:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta);
      paramInt = i;
      if (this.LsY != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LsY);
      }
      i = g.a.a.b.b.a.bu(5, this.Scene);
      AppMethodBeat.o(32193);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32193);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajy localajy = (ajy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32193);
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
            localajy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32193);
          return 0;
        case 2: 
          localajy.LsZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32193);
          return 0;
        case 3: 
          localajy.Lta = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(32193);
          return 0;
        case 4: 
          localajy.LsY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32193);
          return 0;
        }
        localajy.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32193);
        return 0;
      }
      AppMethodBeat.o(32193);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajy
 * JD-Core Version:    0.7.0.1
 */