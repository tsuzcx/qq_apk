package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqr
  extends com.tencent.mm.bx.a
{
  public String Doi;
  public long Doj;
  public boolean EjC;
  public LinkedList<bgc> EjD;
  public String dpw;
  public int index;
  public boolean qHI;
  
  public cqr()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.EjC = false;
    this.dpw = "";
    this.Doj = -1L;
    this.Doi = "";
    this.EjD = new LinkedList();
    this.qHI = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.index);
      paramVarArgs.bg(2, this.EjC);
      if (this.dpw != null) {
        paramVarArgs.d(3, this.dpw);
      }
      paramVarArgs.aG(4, this.Doj);
      if (this.Doi != null) {
        paramVarArgs.d(5, this.Doi);
      }
      paramVarArgs.e(6, 8, this.EjD);
      paramVarArgs.bg(7, this.qHI);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.index) + 0 + (f.a.a.b.b.a.fY(2) + 1);
      paramInt = i;
      if (this.dpw != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dpw);
      }
      i = paramInt + f.a.a.b.b.a.q(4, this.Doj);
      paramInt = i;
      if (this.Doi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Doi);
      }
      i = f.a.a.a.c(6, 8, this.EjD);
      int j = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(177412);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EjD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cqr localcqr = (cqr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localcqr.index = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localcqr.EjC = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localcqr.dpw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localcqr.Doj = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localcqr.Doi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bgc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bgc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcqr.EjD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localcqr.qHI = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqr
 * JD-Core Version:    0.7.0.1
 */