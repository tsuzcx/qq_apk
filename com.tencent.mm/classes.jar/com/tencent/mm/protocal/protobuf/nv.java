package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class nv
  extends com.tencent.mm.bw.a
{
  public int EdM;
  public int EdN;
  public LinkedList<nw> EdO;
  public int type;
  public int uin;
  public int version;
  
  public nv()
  {
    AppMethodBeat.i(124455);
    this.EdO = new LinkedList();
    AppMethodBeat.o(124455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124456);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.EdM);
      paramVarArgs.aR(3, this.EdN);
      paramVarArgs.e(4, 8, this.EdO);
      paramVarArgs.aR(5, this.version);
      paramVarArgs.aR(6, this.type);
      AppMethodBeat.o(124456);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.uin);
      i = f.a.a.b.b.a.bx(2, this.EdM);
      int j = f.a.a.b.b.a.bx(3, this.EdN);
      int k = f.a.a.a.c(4, 8, this.EdO);
      int m = f.a.a.b.b.a.bx(5, this.version);
      int n = f.a.a.b.b.a.bx(6, this.type);
      AppMethodBeat.o(124456);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EdO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(124456);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      nv localnv = (nv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124456);
        return -1;
      case 1: 
        localnv.uin = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124456);
        return 0;
      case 2: 
        localnv.EdM = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124456);
        return 0;
      case 3: 
        localnv.EdN = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124456);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new nw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((nw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localnv.EdO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124456);
        return 0;
      case 5: 
        localnv.version = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(124456);
        return 0;
      }
      localnv.type = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(124456);
      return 0;
    }
    AppMethodBeat.o(124456);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nv
 * JD-Core Version:    0.7.0.1
 */