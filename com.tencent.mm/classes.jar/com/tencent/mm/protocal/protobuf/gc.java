package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class gc
  extends com.tencent.mm.cd.a
{
  public int RLe;
  public int RLf;
  public int RLg;
  public gh RLh;
  public gb RLi;
  public String lVG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32118);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.lVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.RLe);
      if (this.lVG != null) {
        paramVarArgs.f(2, this.lVG);
      }
      paramVarArgs.aY(3, this.RLf);
      paramVarArgs.aY(4, this.RLg);
      if (this.RLh != null)
      {
        paramVarArgs.oE(5, this.RLh.computeSize());
        this.RLh.writeFields(paramVarArgs);
      }
      if (this.RLi != null)
      {
        paramVarArgs.oE(6, this.RLi.computeSize());
        this.RLi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RLe) + 0;
      paramInt = i;
      if (this.lVG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.lVG);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.RLf) + g.a.a.b.b.a.bM(4, this.RLg);
      paramInt = i;
      if (this.RLh != null) {
        paramInt = i + g.a.a.a.oD(5, this.RLh.computeSize());
      }
      i = paramInt;
      if (this.RLi != null) {
        i = paramInt + g.a.a.a.oD(6, this.RLi.computeSize());
      }
      AppMethodBeat.o(32118);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      if (this.lVG == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32118);
        throw paramVarArgs;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      gc localgc = (gc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32118);
        return -1;
      case 1: 
        localgc.RLe = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32118);
        return 0;
      case 2: 
        localgc.lVG = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32118);
        return 0;
      case 3: 
        localgc.RLf = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32118);
        return 0;
      case 4: 
        localgc.RLg = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(32118);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gh)localObject2).parseFrom((byte[])localObject1);
          }
          localgc.RLh = ((gh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32118);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new gb();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((gb)localObject2).parseFrom((byte[])localObject1);
        }
        localgc.RLi = ((gb)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(32118);
      return 0;
    }
    AppMethodBeat.o(32118);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gc
 * JD-Core Version:    0.7.0.1
 */