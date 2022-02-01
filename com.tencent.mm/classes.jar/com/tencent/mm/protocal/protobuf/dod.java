package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dod
  extends com.tencent.mm.bw.a
{
  public LinkedList<doe> FnH;
  public boolean kfb;
  public int kfc;
  public int kfd;
  public String kfe;
  public String kff;
  public String kfg;
  public String kfh;
  
  public dod()
  {
    AppMethodBeat.i(123670);
    this.FnH = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FnH);
      paramVarArgs.bl(2, this.kfb);
      paramVarArgs.aR(3, this.kfc);
      paramVarArgs.aR(4, this.kfd);
      if (this.kfe != null) {
        paramVarArgs.d(5, this.kfe);
      }
      if (this.kff != null) {
        paramVarArgs.d(6, this.kff);
      }
      if (this.kfg != null) {
        paramVarArgs.d(7, this.kfg);
      }
      if (this.kfh != null) {
        paramVarArgs.d(8, this.kfh);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FnH) + 0 + (f.a.a.b.b.a.fK(2) + 1) + f.a.a.b.b.a.bx(3, this.kfc) + f.a.a.b.b.a.bx(4, this.kfd);
      paramInt = i;
      if (this.kfe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.kfe);
      }
      i = paramInt;
      if (this.kff != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.kff);
      }
      paramInt = i;
      if (this.kfg != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.kfg);
      }
      i = paramInt;
      if (this.kfh != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.kfh);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FnH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dod localdod = (dod)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new doe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((doe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdod.FnH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localdod.kfb = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localdod.kfc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localdod.kfd = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localdod.kfe = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localdod.kff = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localdod.kfg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localdod.kfh = ((f.a.a.a.a)localObject1).LVo.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dod
 * JD-Core Version:    0.7.0.1
 */