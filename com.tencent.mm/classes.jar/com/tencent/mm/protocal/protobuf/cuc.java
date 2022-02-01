package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuc
  extends dop
{
  public String KUC;
  public String Mzp;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82460);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Mzp != null) {
        paramVarArgs.e(2, this.Mzp);
      }
      if (this.KUC != null) {
        paramVarArgs.e(3, this.KUC);
      }
      paramVarArgs.aM(4, this.scene);
      AppMethodBeat.o(82460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mzp != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mzp);
      }
      i = paramInt;
      if (this.KUC != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KUC);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.scene);
      AppMethodBeat.o(82460);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82460);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cuc localcuc = (cuc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82460);
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
            localcuc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82460);
          return 0;
        case 2: 
          localcuc.Mzp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82460);
          return 0;
        case 3: 
          localcuc.KUC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(82460);
          return 0;
        }
        localcuc.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(82460);
        return 0;
      }
      AppMethodBeat.o(82460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuc
 * JD-Core Version:    0.7.0.1
 */