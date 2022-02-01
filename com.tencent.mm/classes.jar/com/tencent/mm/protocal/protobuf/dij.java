package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dij
  extends com.tencent.mm.bw.a
{
  public int DxL;
  public int FRp;
  public String FRq;
  public int FRr;
  public int FRs;
  public LinkedList<dio> FRt;
  public boolean FRu;
  public boolean daU;
  
  public dij()
  {
    AppMethodBeat.i(153003);
    this.FRt = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FRp);
      if (this.FRq != null) {
        paramVarArgs.d(2, this.FRq);
      }
      paramVarArgs.aR(3, this.DxL);
      paramVarArgs.aR(4, this.FRr);
      paramVarArgs.aR(5, this.FRs);
      paramVarArgs.e(6, 8, this.FRt);
      paramVarArgs.bl(7, this.FRu);
      paramVarArgs.bl(8, this.daU);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FRp) + 0;
      paramInt = i;
      if (this.FRq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FRq);
      }
      i = f.a.a.b.b.a.bx(3, this.DxL);
      int j = f.a.a.b.b.a.bx(4, this.FRr);
      int k = f.a.a.b.b.a.bx(5, this.FRs);
      int m = f.a.a.a.c(6, 8, this.FRt);
      int n = f.a.a.b.b.a.fK(7);
      int i1 = f.a.a.b.b.a.fK(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FRt.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dij localdij = (dij)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localdij.FRp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localdij.FRq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localdij.DxL = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localdij.FRr = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localdij.FRs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dio();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dio)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdij.FRt.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localdij.FRu = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(153004);
        return 0;
      }
      localdij.daU = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dij
 * JD-Core Version:    0.7.0.1
 */