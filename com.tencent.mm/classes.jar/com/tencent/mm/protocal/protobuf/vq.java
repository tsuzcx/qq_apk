package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vq
  extends com.tencent.mm.bx.a
{
  public String YAb;
  public LinkedList<ags> Zbo;
  public int Zbp;
  public String Zbq;
  public String name;
  
  public vq()
  {
    AppMethodBeat.i(32155);
    this.Zbo = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Zbo);
      if (this.YAb != null) {
        paramVarArgs.g(2, this.YAb);
      }
      paramVarArgs.bS(3, this.Zbp);
      if (this.Zbq != null) {
        paramVarArgs.g(4, this.Zbq);
      }
      if (this.name != null) {
        paramVarArgs.g(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.Zbo) + 0;
      paramInt = i;
      if (this.YAb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YAb);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.Zbp);
      paramInt = i;
      if (this.Zbq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zbq);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zbo.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      vq localvq = (vq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ags localags = new ags();
          if ((localObject != null) && (localObject.length > 0)) {
            localags.parseFrom((byte[])localObject);
          }
          localvq.Zbo.add(localags);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localvq.YAb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localvq.Zbp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localvq.Zbq = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localvq.name = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vq
 * JD-Core Version:    0.7.0.1
 */