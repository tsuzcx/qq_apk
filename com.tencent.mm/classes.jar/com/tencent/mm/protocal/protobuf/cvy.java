package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvy
  extends com.tencent.mm.bw.a
{
  public String EJi;
  public long EJj;
  public boolean FGA;
  public LinkedList<bju> FGB;
  public String dnh;
  public int index;
  public boolean rAJ;
  
  public cvy()
  {
    AppMethodBeat.i(177411);
    this.index = -1;
    this.FGA = false;
    this.dnh = "";
    this.EJj = -1L;
    this.EJi = "";
    this.FGB = new LinkedList();
    this.rAJ = false;
    AppMethodBeat.o(177411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.index);
      paramVarArgs.bl(2, this.FGA);
      if (this.dnh != null) {
        paramVarArgs.d(3, this.dnh);
      }
      paramVarArgs.aO(4, this.EJj);
      if (this.EJi != null) {
        paramVarArgs.d(5, this.EJi);
      }
      paramVarArgs.e(6, 8, this.FGB);
      paramVarArgs.bl(7, this.rAJ);
      AppMethodBeat.o(177412);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.index) + 0 + (f.a.a.b.b.a.fK(2) + 1);
      paramInt = i;
      if (this.dnh != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dnh);
      }
      i = paramInt + f.a.a.b.b.a.p(4, this.EJj);
      paramInt = i;
      if (this.EJi != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EJi);
      }
      i = f.a.a.a.c(6, 8, this.FGB);
      int j = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(177412);
      return paramInt + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FGB.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(177412);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvy localcvy = (cvy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(177412);
        return -1;
      case 1: 
        localcvy.index = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(177412);
        return 0;
      case 2: 
        localcvy.FGA = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(177412);
        return 0;
      case 3: 
        localcvy.dnh = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 4: 
        localcvy.EJj = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(177412);
        return 0;
      case 5: 
        localcvy.EJi = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(177412);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bju();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bju)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcvy.FGB.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(177412);
        return 0;
      }
      localcvy.rAJ = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(177412);
      return 0;
    }
    AppMethodBeat.o(177412);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvy
 * JD-Core Version:    0.7.0.1
 */