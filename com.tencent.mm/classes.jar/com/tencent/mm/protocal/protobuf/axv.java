package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axv
  extends com.tencent.mm.bx.a
{
  public LinkedList<axb> lPK;
  public long oEj;
  public String username;
  
  public axv()
  {
    AppMethodBeat.i(168968);
    this.lPK = new LinkedList();
    AppMethodBeat.o(168968);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168969);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.lPK);
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bv(3, this.oEj);
      AppMethodBeat.o(168969);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.lPK) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = i.a.a.b.b.a.q(3, this.oEj);
      AppMethodBeat.o(168969);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.lPK.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(168969);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      axv localaxv = (axv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(168969);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          axb localaxb = new axb();
          if ((localObject != null) && (localObject.length > 0)) {
            localaxb.parseFrom((byte[])localObject);
          }
          localaxv.lPK.add(localaxb);
          paramInt += 1;
        }
        AppMethodBeat.o(168969);
        return 0;
      case 2: 
        localaxv.username = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(168969);
        return 0;
      }
      localaxv.oEj = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(168969);
      return 0;
    }
    AppMethodBeat.o(168969);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axv
 * JD-Core Version:    0.7.0.1
 */