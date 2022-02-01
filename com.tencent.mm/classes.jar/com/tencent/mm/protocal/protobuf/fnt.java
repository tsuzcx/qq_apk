package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fnt
  extends com.tencent.mm.cd.a
{
  public int RTb;
  public LinkedList<vf> Sri;
  public LinkedList<fmg> TnE;
  public int UMh;
  public String UMi;
  public String UMj;
  public int UMk;
  public fw UMl;
  
  public fnt()
  {
    AppMethodBeat.i(123694);
    this.Sri = new LinkedList();
    this.TnE = new LinkedList();
    AppMethodBeat.o(123694);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123695);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RTb);
      paramVarArgs.aY(2, this.UMh);
      if (this.UMi != null) {
        paramVarArgs.f(3, this.UMi);
      }
      if (this.UMj != null) {
        paramVarArgs.f(4, this.UMj);
      }
      paramVarArgs.aY(5, this.UMk);
      paramVarArgs.e(6, 8, this.Sri);
      if (this.UMl != null)
      {
        paramVarArgs.oE(7, this.UMl.computeSize());
        this.UMl.writeFields(paramVarArgs);
      }
      paramVarArgs.e(36, 8, this.TnE);
      AppMethodBeat.o(123695);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.RTb) + 0 + g.a.a.b.b.a.bM(2, this.UMh);
      paramInt = i;
      if (this.UMi != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UMi);
      }
      i = paramInt;
      if (this.UMj != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UMj);
      }
      i = i + g.a.a.b.b.a.bM(5, this.UMk) + g.a.a.a.c(6, 8, this.Sri);
      paramInt = i;
      if (this.UMl != null) {
        paramInt = i + g.a.a.a.oD(7, this.UMl.computeSize());
      }
      i = g.a.a.a.c(36, 8, this.TnE);
      AppMethodBeat.o(123695);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sri.clear();
      this.TnE.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      fnt localfnt = (fnt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123695);
        return -1;
      case 1: 
        localfnt.RTb = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(123695);
        return 0;
      case 2: 
        localfnt.UMh = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(123695);
        return 0;
      case 3: 
        localfnt.UMi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 4: 
        localfnt.UMj = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(123695);
        return 0;
      case 5: 
        localfnt.UMk = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(123695);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new vf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((vf)localObject2).parseFrom((byte[])localObject1);
          }
          localfnt.Sri.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fw)localObject2).parseFrom((byte[])localObject1);
          }
          localfnt.UMl = ((fw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123695);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fmg();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fmg)localObject2).parseFrom((byte[])localObject1);
        }
        localfnt.TnE.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(123695);
      return 0;
    }
    AppMethodBeat.o(123695);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnt
 * JD-Core Version:    0.7.0.1
 */