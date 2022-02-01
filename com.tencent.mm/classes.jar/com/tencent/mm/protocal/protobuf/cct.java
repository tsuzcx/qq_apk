package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cct
  extends com.tencent.mm.bx.a
{
  public long YNE;
  public LinkedList<fyd> aamh;
  public String debug_info;
  
  public cct()
  {
    AppMethodBeat.i(110898);
    this.aamh = new LinkedList();
    AppMethodBeat.o(110898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110899);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YNE);
      paramVarArgs.e(2, 8, this.aamh);
      if (this.debug_info != null) {
        paramVarArgs.g(3, this.debug_info);
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YNE) + 0 + i.a.a.a.c(2, 8, this.aamh);
      paramInt = i;
      if (this.debug_info != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.debug_info);
      }
      AppMethodBeat.o(110899);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aamh.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      cct localcct = (cct)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110899);
        return -1;
      case 1: 
        localcct.YNE = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(110899);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fyd localfyd = new fyd();
          if ((localObject != null) && (localObject.length > 0)) {
            localfyd.parseFrom((byte[])localObject);
          }
          localcct.aamh.add(localfyd);
          paramInt += 1;
        }
        AppMethodBeat.o(110899);
        return 0;
      }
      localcct.debug_info = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(110899);
      return 0;
    }
    AppMethodBeat.o(110899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cct
 * JD-Core Version:    0.7.0.1
 */