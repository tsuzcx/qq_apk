package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anu
  extends com.tencent.mm.bx.a
{
  public long Zvs;
  public String Zvt;
  public LinkedList<ant> Zvu;
  
  public anu()
  {
    AppMethodBeat.i(260104);
    this.Zvu = new LinkedList();
    AppMethodBeat.o(260104);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260107);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Zvs);
      if (this.Zvt != null) {
        paramVarArgs.g(2, this.Zvt);
      }
      paramVarArgs.e(3, 8, this.Zvu);
      AppMethodBeat.o(260107);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.Zvs) + 0;
      paramInt = i;
      if (this.Zvt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zvt);
      }
      i = i.a.a.a.c(3, 8, this.Zvu);
      AppMethodBeat.o(260107);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zvu.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260107);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      anu localanu = (anu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260107);
        return -1;
      case 1: 
        localanu.Zvs = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(260107);
        return 0;
      case 2: 
        localanu.Zvt = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260107);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        ant localant = new ant();
        if ((localObject != null) && (localObject.length > 0)) {
          localant.parseFrom((byte[])localObject);
        }
        localanu.Zvu.add(localant);
        paramInt += 1;
      }
      AppMethodBeat.o(260107);
      return 0;
    }
    AppMethodBeat.o(260107);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anu
 * JD-Core Version:    0.7.0.1
 */