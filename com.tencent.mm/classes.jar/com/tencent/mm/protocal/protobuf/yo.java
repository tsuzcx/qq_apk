package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yo
  extends com.tencent.mm.bw.a
{
  public yp AmP;
  public yn AmQ;
  public boolean AnX;
  public LinkedList<dix> Esk;
  public long Esl;
  public long Esm;
  public boolean Esn;
  public String gUk;
  
  public yo()
  {
    AppMethodBeat.i(206856);
    this.Esk = new LinkedList();
    AppMethodBeat.o(206856);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(206857);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Esk);
      paramVarArgs.aO(2, this.Esl);
      paramVarArgs.aO(3, this.Esm);
      paramVarArgs.bl(4, this.AnX);
      if (this.gUk != null) {
        paramVarArgs.d(5, this.gUk);
      }
      if (this.AmP != null)
      {
        paramVarArgs.ln(6, this.AmP.computeSize());
        this.AmP.writeFields(paramVarArgs);
      }
      paramVarArgs.bl(7, this.Esn);
      if (this.AmQ != null)
      {
        paramVarArgs.ln(8, this.AmQ.computeSize());
        this.AmQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(206857);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Esk) + 0 + f.a.a.b.b.a.p(2, this.Esl) + f.a.a.b.b.a.p(3, this.Esm) + (f.a.a.b.b.a.fK(4) + 1);
      paramInt = i;
      if (this.gUk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gUk);
      }
      i = paramInt;
      if (this.AmP != null) {
        i = paramInt + f.a.a.a.lm(6, this.AmP.computeSize());
      }
      i += f.a.a.b.b.a.fK(7) + 1;
      paramInt = i;
      if (this.AmQ != null) {
        paramInt = i + f.a.a.a.lm(8, this.AmQ.computeSize());
      }
      AppMethodBeat.o(206857);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Esk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(206857);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yo localyo = (yo)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(206857);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dix();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dix)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyo.Esk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(206857);
        return 0;
      case 2: 
        localyo.Esl = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(206857);
        return 0;
      case 3: 
        localyo.Esm = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(206857);
        return 0;
      case 4: 
        localyo.AnX = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(206857);
        return 0;
      case 5: 
        localyo.gUk = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(206857);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyo.AmP = ((yp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(206857);
        return 0;
      case 7: 
        localyo.Esn = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(206857);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new yn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((yn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localyo.AmQ = ((yn)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(206857);
      return 0;
    }
    AppMethodBeat.o(206857);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yo
 * JD-Core Version:    0.7.0.1
 */