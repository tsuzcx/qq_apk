package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ou
  extends com.tencent.mm.bw.a
{
  public LinkedList<aie> EeI;
  public LinkedList<aid> EeJ;
  public String EeK;
  public String EeL;
  public String EeM;
  
  public ou()
  {
    AppMethodBeat.i(91368);
    this.EeI = new LinkedList();
    this.EeJ = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.EeI);
      paramVarArgs.e(2, 8, this.EeJ);
      if (this.EeK != null) {
        paramVarArgs.d(3, this.EeK);
      }
      if (this.EeL != null) {
        paramVarArgs.d(4, this.EeL);
      }
      if (this.EeM != null) {
        paramVarArgs.d(5, this.EeM);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.EeI) + 0 + f.a.a.a.c(2, 8, this.EeJ);
      paramInt = i;
      if (this.EeK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EeK);
      }
      i = paramInt;
      if (this.EeL != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EeL);
      }
      paramInt = i;
      if (this.EeM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EeM);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EeI.clear();
      this.EeJ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ou localou = (ou)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aie();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localou.EeI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aid();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aid)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localou.EeJ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localou.EeK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localou.EeL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localou.EeM = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ou
 * JD-Core Version:    0.7.0.1
 */