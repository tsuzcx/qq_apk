package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beg
  extends dop
{
  public aov LAI;
  public int LOa;
  public int type;
  public String url;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209715);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.e(3, this.username);
      }
      paramVarArgs.aM(4, this.type);
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      paramVarArgs.aM(6, this.LOa);
      AppMethodBeat.o(209715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.username);
      }
      i += g.a.a.b.b.a.bu(4, this.type);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.url);
      }
      i = g.a.a.b.b.a.bu(6, this.LOa);
      AppMethodBeat.o(209715);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209715);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        beg localbeg = (beg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209715);
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
            localbeg.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209715);
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
            localbeg.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209715);
          return 0;
        case 3: 
          localbeg.username = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209715);
          return 0;
        case 4: 
          localbeg.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209715);
          return 0;
        case 5: 
          localbeg.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209715);
          return 0;
        }
        localbeg.LOa = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(209715);
        return 0;
      }
      AppMethodBeat.o(209715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beg
 * JD-Core Version:    0.7.0.1
 */