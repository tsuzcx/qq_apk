package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agc
  extends com.tencent.mm.bw.a
{
  public LinkedList<agb> Gwk;
  public String qXW;
  public int qXZ;
  public int qYa;
  public int qYb;
  public int qYd;
  public int qYe;
  public int qYf;
  public int qYg;
  public String qYh;
  public String script;
  
  public agc()
  {
    AppMethodBeat.i(196250);
    this.Gwk = new LinkedList();
    AppMethodBeat.o(196250);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196251);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qXW != null) {
        paramVarArgs.d(1, this.qXW);
      }
      paramVarArgs.aS(2, this.qXZ);
      paramVarArgs.aS(3, this.qYa);
      paramVarArgs.aS(4, this.qYb);
      paramVarArgs.e(5, 8, this.Gwk);
      paramVarArgs.aS(6, this.qYd);
      paramVarArgs.aS(7, this.qYg);
      if (this.script != null) {
        paramVarArgs.d(8, this.script);
      }
      if (this.qYh != null) {
        paramVarArgs.d(9, this.qYh);
      }
      paramVarArgs.aS(10, this.qYf);
      paramVarArgs.aS(11, this.qYe);
      AppMethodBeat.o(196251);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qXW == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.b.b.a.e(1, this.qXW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qXZ) + f.a.a.b.b.a.bz(3, this.qYa) + f.a.a.b.b.a.bz(4, this.qYb) + f.a.a.a.c(5, 8, this.Gwk) + f.a.a.b.b.a.bz(6, this.qYd) + f.a.a.b.b.a.bz(7, this.qYg);
      paramInt = i;
      if (this.script != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.script);
      }
      i = paramInt;
      if (this.qYh != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.qYh);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.qYf);
      int j = f.a.a.b.b.a.bz(11, this.qYe);
      AppMethodBeat.o(196251);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gwk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(196251);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agc localagc = (agc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196251);
          return -1;
        case 1: 
          localagc.qXW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196251);
          return 0;
        case 2: 
          localagc.qXZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196251);
          return 0;
        case 3: 
          localagc.qYa = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196251);
          return 0;
        case 4: 
          localagc.qYb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196251);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new agb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((agb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagc.Gwk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196251);
          return 0;
        case 6: 
          localagc.qYd = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196251);
          return 0;
        case 7: 
          localagc.qYg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196251);
          return 0;
        case 8: 
          localagc.script = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196251);
          return 0;
        case 9: 
          localagc.qYh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(196251);
          return 0;
        case 10: 
          localagc.qYf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(196251);
          return 0;
        }
        localagc.qYe = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(196251);
        return 0;
      }
      AppMethodBeat.o(196251);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agc
 * JD-Core Version:    0.7.0.1
 */