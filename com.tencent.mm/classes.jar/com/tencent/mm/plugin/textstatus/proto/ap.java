package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ap
  extends com.tencent.mm.bx.a
{
  public String ToD;
  public LinkedList<aq> sXD;
  public int show_type;
  
  public ap()
  {
    AppMethodBeat.i(289989);
    this.sXD = new LinkedList();
    AppMethodBeat.o(289989);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289997);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ToD != null) {
        paramVarArgs.g(1, this.ToD);
      }
      paramVarArgs.bS(2, this.show_type);
      paramVarArgs.e(3, 8, this.sXD);
      AppMethodBeat.o(289997);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ToD == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = i.a.a.b.b.a.h(1, this.ToD) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.show_type);
      int j = i.a.a.a.c(3, 8, this.sXD);
      AppMethodBeat.o(289997);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sXD.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289997);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289997);
          return -1;
        case 1: 
          localap.ToD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289997);
          return 0;
        case 2: 
          localap.show_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289997);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          aq localaq = new aq();
          if ((localObject != null) && (localObject.length > 0)) {
            localaq.parseFrom((byte[])localObject);
          }
          localap.sXD.add(localaq);
          paramInt += 1;
        }
        AppMethodBeat.o(289997);
        return 0;
      }
      AppMethodBeat.o(289997);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.ap
 * JD-Core Version:    0.7.0.1
 */