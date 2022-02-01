package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecm
  extends com.tencent.mm.bw.a
{
  public String GhW;
  public String GhX;
  public LinkedList<cbx> GhY;
  public String GhZ;
  public int Gia;
  public String Title;
  
  public ecm()
  {
    AppMethodBeat.i(50125);
    this.GhY = new LinkedList();
    AppMethodBeat.o(50125);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50126);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GhW != null) {
        paramVarArgs.d(1, this.GhW);
      }
      if (this.GhX != null) {
        paramVarArgs.d(2, this.GhX);
      }
      paramVarArgs.e(3, 8, this.GhY);
      if (this.GhZ != null) {
        paramVarArgs.d(4, this.GhZ);
      }
      paramVarArgs.aR(5, this.Gia);
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GhW == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.b.b.a.e(1, this.GhW) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GhX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GhX);
      }
      i += f.a.a.a.c(3, 8, this.GhY);
      paramInt = i;
      if (this.GhZ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GhZ);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.Gia);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Title);
      }
      AppMethodBeat.o(50126);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GhY.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(50126);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ecm localecm = (ecm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(50126);
          return -1;
        case 1: 
          localecm.GhW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 2: 
          localecm.GhX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cbx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localecm.GhY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50126);
          return 0;
        case 4: 
          localecm.GhZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(50126);
          return 0;
        case 5: 
          localecm.Gia = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(50126);
          return 0;
        }
        localecm.Title = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(50126);
        return 0;
      }
      AppMethodBeat.o(50126);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecm
 * JD-Core Version:    0.7.0.1
 */