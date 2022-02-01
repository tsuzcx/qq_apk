package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class act
  extends com.tencent.mm.bw.a
{
  public int Evo;
  public String Evp;
  public String Evq;
  public int Evr;
  public int Evs;
  public int Evt;
  public dqz Evu;
  public int Evv;
  public LinkedList<dsn> Evw;
  public int Evx;
  public int Evy;
  
  public act()
  {
    AppMethodBeat.i(115835);
    this.Evw = new LinkedList();
    AppMethodBeat.o(115835);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115836);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Evo);
      if (this.Evp != null) {
        paramVarArgs.d(2, this.Evp);
      }
      if (this.Evq != null) {
        paramVarArgs.d(3, this.Evq);
      }
      paramVarArgs.aR(4, this.Evr);
      paramVarArgs.aR(5, this.Evs);
      paramVarArgs.aR(6, this.Evt);
      if (this.Evu != null)
      {
        paramVarArgs.ln(7, this.Evu.computeSize());
        this.Evu.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(8, this.Evv);
      paramVarArgs.e(9, 8, this.Evw);
      paramVarArgs.aR(10, this.Evx);
      paramVarArgs.aR(11, this.Evy);
      AppMethodBeat.o(115836);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Evo) + 0;
      paramInt = i;
      if (this.Evp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Evp);
      }
      i = paramInt;
      if (this.Evq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Evq);
      }
      i = i + f.a.a.b.b.a.bx(4, this.Evr) + f.a.a.b.b.a.bx(5, this.Evs) + f.a.a.b.b.a.bx(6, this.Evt);
      paramInt = i;
      if (this.Evu != null) {
        paramInt = i + f.a.a.a.lm(7, this.Evu.computeSize());
      }
      i = f.a.a.b.b.a.bx(8, this.Evv);
      int j = f.a.a.a.c(9, 8, this.Evw);
      int k = f.a.a.b.b.a.bx(10, this.Evx);
      int m = f.a.a.b.b.a.bx(11, this.Evy);
      AppMethodBeat.o(115836);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Evw.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115836);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      act localact = (act)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115836);
        return -1;
      case 1: 
        localact.Evo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115836);
        return 0;
      case 2: 
        localact.Evp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 3: 
        localact.Evq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(115836);
        return 0;
      case 4: 
        localact.Evr = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115836);
        return 0;
      case 5: 
        localact.Evs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115836);
        return 0;
      case 6: 
        localact.Evt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115836);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localact.Evu = ((dqz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 8: 
        localact.Evv = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115836);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dsn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dsn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localact.Evw.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115836);
        return 0;
      case 10: 
        localact.Evx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115836);
        return 0;
      }
      localact.Evy = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(115836);
      return 0;
    }
    AppMethodBeat.o(115836);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.act
 * JD-Core Version:    0.7.0.1
 */