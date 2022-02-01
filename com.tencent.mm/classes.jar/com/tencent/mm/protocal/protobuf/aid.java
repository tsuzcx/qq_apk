package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aid
  extends com.tencent.mm.bw.a
{
  public String ECs;
  public long ECt;
  public long ECu;
  public String ECv;
  public long ECw;
  public LinkedList<aie> EeI;
  public String Enm;
  public String wJS;
  
  public aid()
  {
    AppMethodBeat.i(91458);
    this.EeI = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ECs != null) {
        paramVarArgs.d(1, this.ECs);
      }
      paramVarArgs.e(2, 8, this.EeI);
      paramVarArgs.aO(3, this.ECt);
      paramVarArgs.aO(4, this.ECu);
      if (this.ECv != null) {
        paramVarArgs.d(5, this.ECv);
      }
      if (this.wJS != null) {
        paramVarArgs.d(6, this.wJS);
      }
      paramVarArgs.aO(7, this.ECw);
      if (this.Enm != null) {
        paramVarArgs.d(8, this.Enm);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ECs == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.ECs) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.EeI) + f.a.a.b.b.a.p(3, this.ECt) + f.a.a.b.b.a.p(4, this.ECu);
      paramInt = i;
      if (this.ECv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ECv);
      }
      i = paramInt;
      if (this.wJS != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wJS);
      }
      i += f.a.a.b.b.a.p(7, this.ECw);
      paramInt = i;
      if (this.Enm != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Enm);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EeI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aid localaid = (aid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localaid.ECs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aie();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aie)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaid.EeI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localaid.ECt = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localaid.ECu = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localaid.ECv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localaid.wJS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localaid.ECw = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91459);
          return 0;
        }
        localaid.Enm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aid
 * JD-Core Version:    0.7.0.1
 */