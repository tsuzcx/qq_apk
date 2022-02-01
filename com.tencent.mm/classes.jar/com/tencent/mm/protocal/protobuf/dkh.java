package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dkh
  extends com.tencent.mm.bx.a
{
  public long NYV;
  public fxy Zbl;
  public LinkedList<dki> aaQp;
  
  public dkh()
  {
    AppMethodBeat.i(140928);
    this.aaQp = new LinkedList();
    AppMethodBeat.o(140928);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(140929);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140929);
        throw paramVarArgs;
      }
      paramVarArgs.e(1, 8, this.aaQp);
      if (this.Zbl != null)
      {
        paramVarArgs.qD(2, this.Zbl.computeSize());
        this.Zbl.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.NYV);
      AppMethodBeat.o(140929);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aaQp) + 0;
      paramInt = i;
      if (this.Zbl != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zbl.computeSize());
      }
      i = i.a.a.b.b.a.q(3, this.NYV);
      AppMethodBeat.o(140929);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaQp.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.Zbl == null)
      {
        paramVarArgs = new b("Not all required fields were included: matrix");
        AppMethodBeat.o(140929);
        throw paramVarArgs;
      }
      AppMethodBeat.o(140929);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dkh localdkh = (dkh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(140929);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dki();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dki)localObject2).parseFrom((byte[])localObject1);
          }
          localdkh.aaQp.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(140929);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fxy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fxy)localObject2).parseFrom((byte[])localObject1);
          }
          localdkh.Zbl = ((fxy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(140929);
        return 0;
      }
      localdkh.NYV = ((i.a.a.a.a)localObject1).ajGk.aaw();
      AppMethodBeat.o(140929);
      return 0;
    }
    AppMethodBeat.o(140929);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkh
 * JD-Core Version:    0.7.0.1
 */