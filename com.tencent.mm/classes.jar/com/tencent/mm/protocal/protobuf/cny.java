package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cny
  extends com.tencent.mm.bw.a
{
  public int Evo;
  public String Evp;
  public String Evq;
  public int Evr;
  public int Evs;
  public int Evt;
  public int Evx;
  public int Evy;
  public dqz FBc;
  public dqz FBd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115848);
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
      if (this.FBc != null)
      {
        paramVarArgs.ln(7, this.FBc.computeSize());
        this.FBc.writeFields(paramVarArgs);
      }
      if (this.FBd != null)
      {
        paramVarArgs.ln(8, this.FBd.computeSize());
        this.FBd.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.Evx);
      paramVarArgs.aR(10, this.Evy);
      AppMethodBeat.o(115848);
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
      if (this.FBc != null) {
        paramInt = i + f.a.a.a.lm(7, this.FBc.computeSize());
      }
      i = paramInt;
      if (this.FBd != null) {
        i = paramInt + f.a.a.a.lm(8, this.FBd.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(9, this.Evx);
      int j = f.a.a.b.b.a.bx(10, this.Evy);
      AppMethodBeat.o(115848);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(115848);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cny localcny = (cny)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(115848);
        return -1;
      case 1: 
        localcny.Evo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115848);
        return 0;
      case 2: 
        localcny.Evp = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 3: 
        localcny.Evq = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(115848);
        return 0;
      case 4: 
        localcny.Evr = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115848);
        return 0;
      case 5: 
        localcny.Evs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115848);
        return 0;
      case 6: 
        localcny.Evt = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115848);
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
          localcny.FBc = ((dqz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcny.FBd = ((dqz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115848);
        return 0;
      case 9: 
        localcny.Evx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(115848);
        return 0;
      }
      localcny.Evy = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(115848);
      return 0;
    }
    AppMethodBeat.o(115848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cny
 * JD-Core Version:    0.7.0.1
 */