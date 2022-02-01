package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cmn
  extends dop
{
  public int MrK;
  public int MrL;
  public String eaO;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114044);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.eaO != null) {
        paramVarArgs.e(2, this.eaO);
      }
      paramVarArgs.aM(3, this.MrK);
      paramVarArgs.aM(4, this.MrL);
      paramVarArgs.aM(5, this.scene);
      AppMethodBeat.o(114044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.eaO != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.eaO);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.MrK);
      int j = g.a.a.b.b.a.bu(4, this.MrL);
      int k = g.a.a.b.b.a.bu(5, this.scene);
      AppMethodBeat.o(114044);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114044);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cmn localcmn = (cmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114044);
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
            localcmn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114044);
          return 0;
        case 2: 
          localcmn.eaO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114044);
          return 0;
        case 3: 
          localcmn.MrK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114044);
          return 0;
        case 4: 
          localcmn.MrL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114044);
          return 0;
        }
        localcmn.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114044);
        return 0;
      }
      AppMethodBeat.o(114044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmn
 * JD-Core Version:    0.7.0.1
 */