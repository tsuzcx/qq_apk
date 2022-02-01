package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhj
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> FQF;
  public int FQG;
  public LinkedList<byg> FvH;
  public String FvI;
  public String djj;
  public String dlQ;
  public int version;
  
  public dhj()
  {
    AppMethodBeat.i(176151);
    this.FQF = new LinkedList();
    this.FvH = new LinkedList();
    AppMethodBeat.o(176151);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176152);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.FQF);
      paramVarArgs.e(2, 8, this.FvH);
      if (this.dlQ != null) {
        paramVarArgs.d(3, this.dlQ);
      }
      paramVarArgs.aR(4, this.FQG);
      if (this.FvI != null) {
        paramVarArgs.d(5, this.FvI);
      }
      if (this.djj != null) {
        paramVarArgs.d(6, this.djj);
      }
      paramVarArgs.aR(7, this.version);
      AppMethodBeat.o(176152);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 1, this.FQF) + 0 + f.a.a.a.c(2, 8, this.FvH);
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.dlQ);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.FQG);
      paramInt = i;
      if (this.FvI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FvI);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.djj);
      }
      paramInt = f.a.a.b.b.a.bx(7, this.version);
      AppMethodBeat.o(176152);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FQF.clear();
      this.FvH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(176152);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dhj localdhj = (dhj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176152);
        return -1;
      case 1: 
        localdhj.FQF.add(((f.a.a.a.a)localObject1).LVo.readString());
        AppMethodBeat.o(176152);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new byg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((byg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdhj.FvH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176152);
        return 0;
      case 3: 
        localdhj.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 4: 
        localdhj.FQG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(176152);
        return 0;
      case 5: 
        localdhj.FvI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176152);
        return 0;
      case 6: 
        localdhj.djj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176152);
        return 0;
      }
      localdhj.version = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(176152);
      return 0;
    }
    AppMethodBeat.o(176152);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhj
 * JD-Core Version:    0.7.0.1
 */