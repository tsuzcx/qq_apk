package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class pm
  extends com.tencent.mm.bw.a
{
  public long EfR;
  public int EfS;
  public LinkedList<String> EfT;
  public String EfU;
  public int EfV;
  public String Title;
  public int ndl;
  public LinkedList<pt> tiT;
  
  public pm()
  {
    AppMethodBeat.i(117842);
    this.EfT = new LinkedList();
    this.tiT = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EfU == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.EfR);
      paramVarArgs.aR(2, this.EfS);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      paramVarArgs.e(4, 1, this.EfT);
      paramVarArgs.e(5, 8, this.tiT);
      paramVarArgs.aR(6, this.ndl);
      if (this.EfU != null) {
        paramVarArgs.d(7, this.EfU);
      }
      paramVarArgs.aR(8, this.EfV);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.EfR) + 0 + f.a.a.b.b.a.bx(2, this.EfS);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt + f.a.a.a.c(4, 1, this.EfT) + f.a.a.a.c(5, 8, this.tiT) + f.a.a.b.b.a.bx(6, this.ndl);
      paramInt = i;
      if (this.EfU != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EfU);
      }
      i = f.a.a.b.b.a.bx(8, this.EfV);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EfT.clear();
      this.tiT.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      if (this.EfU == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117843);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      pm localpm = (pm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localpm.EfR = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localpm.EfS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localpm.Title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localpm.EfT.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new pt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((pt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localpm.tiT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localpm.ndl = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localpm.EfU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localpm.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pm
 * JD-Core Version:    0.7.0.1
 */