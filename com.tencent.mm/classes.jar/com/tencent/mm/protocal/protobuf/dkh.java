package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dkh
  extends com.tencent.mm.bx.a
{
  public LinkedList<dki> CUw;
  public String DYO;
  public int EtE;
  public String dlB;
  public String doh;
  public int version;
  
  public dkh()
  {
    AppMethodBeat.i(176154);
    this.CUw = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CUw);
      if (this.doh != null) {
        paramVarArgs.d(2, this.doh);
      }
      paramVarArgs.aR(3, this.EtE);
      if (this.DYO != null) {
        paramVarArgs.d(4, this.DYO);
      }
      if (this.dlB != null) {
        paramVarArgs.d(5, this.dlB);
      }
      paramVarArgs.aR(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.CUw) + 0;
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.doh);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.EtE);
      paramInt = i;
      if (this.DYO != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DYO);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dlB);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CUw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkh localdkh = (dkh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dki();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dki)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkh.CUw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localdkh.doh = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localdkh.EtE = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localdkh.DYO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localdkh.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localdkh.version = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkh
 * JD-Core Version:    0.7.0.1
 */