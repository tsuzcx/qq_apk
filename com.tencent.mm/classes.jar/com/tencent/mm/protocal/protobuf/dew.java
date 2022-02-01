package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dew
  extends com.tencent.mm.bx.a
{
  public String Kuf;
  public LinkedList<czo> aaKS;
  public String error_msg;
  public int ret;
  
  public dew()
  {
    AppMethodBeat.i(258448);
    this.aaKS = new LinkedList();
    AppMethodBeat.o(258448);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258450);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ret);
      if (this.error_msg != null) {
        paramVarArgs.g(2, this.error_msg);
      }
      if (this.Kuf != null) {
        paramVarArgs.g(3, this.Kuf);
      }
      paramVarArgs.e(4, 8, this.aaKS);
      AppMethodBeat.o(258450);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ret) + 0;
      paramInt = i;
      if (this.error_msg != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.error_msg);
      }
      i = paramInt;
      if (this.Kuf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Kuf);
      }
      paramInt = i.a.a.a.c(4, 8, this.aaKS);
      AppMethodBeat.o(258450);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaKS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258450);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      dew localdew = (dew)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258450);
        return -1;
      case 1: 
        localdew.ret = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258450);
        return 0;
      case 2: 
        localdew.error_msg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258450);
        return 0;
      case 3: 
        localdew.Kuf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258450);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        czo localczo = new czo();
        if ((localObject != null) && (localObject.length > 0)) {
          localczo.parseFrom((byte[])localObject);
        }
        localdew.aaKS.add(localczo);
        paramInt += 1;
      }
      AppMethodBeat.o(258450);
      return 0;
    }
    AppMethodBeat.o(258450);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dew
 * JD-Core Version:    0.7.0.1
 */