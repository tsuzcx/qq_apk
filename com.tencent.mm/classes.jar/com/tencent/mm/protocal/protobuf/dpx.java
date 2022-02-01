package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpx
  extends com.tencent.mm.bw.a
{
  public LinkedList<dpy> Eng;
  public int FQG;
  public String FvI;
  public String djj;
  public String dlQ;
  public int version;
  
  public dpx()
  {
    AppMethodBeat.i(176154);
    this.Eng = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Eng);
      if (this.dlQ != null) {
        paramVarArgs.d(2, this.dlQ);
      }
      paramVarArgs.aR(3, this.FQG);
      if (this.FvI != null) {
        paramVarArgs.d(4, this.FvI);
      }
      if (this.djj != null) {
        paramVarArgs.d(5, this.djj);
      }
      paramVarArgs.aR(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Eng) + 0;
      paramInt = i;
      if (this.dlQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlQ);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.FQG);
      paramInt = i;
      if (this.FvI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FvI);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.djj);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eng.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dpx localdpx = (dpx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dpy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dpy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpx.Eng.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localdpx.dlQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localdpx.FQG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localdpx.FvI = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localdpx.djj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localdpx.version = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpx
 * JD-Core Version:    0.7.0.1
 */