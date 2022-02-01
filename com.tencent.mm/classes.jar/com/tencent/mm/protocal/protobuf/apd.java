package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apd
  extends dop
{
  public String LBj;
  public String finderUsername;
  public long hFK;
  public long liveId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209347);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.liveId);
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      paramVarArgs.bb(4, this.hFK);
      if (this.LBj != null) {
        paramVarArgs.e(5, this.LBj);
      }
      paramVarArgs.aM(6, this.scene);
      AppMethodBeat.o(209347);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.liveId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.r(4, this.hFK);
      paramInt = i;
      if (this.LBj != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LBj);
      }
      i = g.a.a.b.b.a.bu(6, this.scene);
      AppMethodBeat.o(209347);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209347);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        apd localapd = (apd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209347);
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
            localapd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209347);
          return 0;
        case 2: 
          localapd.liveId = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209347);
          return 0;
        case 3: 
          localapd.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209347);
          return 0;
        case 4: 
          localapd.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(209347);
          return 0;
        case 5: 
          localapd.LBj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209347);
          return 0;
        }
        localapd.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209347);
        return 0;
      }
      AppMethodBeat.o(209347);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apd
 * JD-Core Version:    0.7.0.1
 */