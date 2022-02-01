package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwa
  extends com.tencent.mm.bw.a
{
  public String EJi;
  public long EJj;
  public LinkedList<cvw> FGD;
  public int index;
  public String qon;
  public boolean rAJ;
  public int type;
  
  public cwa()
  {
    AppMethodBeat.i(169384);
    this.FGD = new LinkedList();
    this.rAJ = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qon != null) {
        paramVarArgs.d(1, this.qon);
      }
      paramVarArgs.aO(2, this.EJj);
      paramVarArgs.e(3, 8, this.FGD);
      if (this.EJi != null) {
        paramVarArgs.d(4, this.EJi);
      }
      paramVarArgs.bl(5, this.rAJ);
      paramVarArgs.aR(6, this.type);
      paramVarArgs.aR(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qon == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.qon) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.EJj) + f.a.a.a.c(3, 8, this.FGD);
      paramInt = i;
      if (this.EJi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EJi);
      }
      i = f.a.a.b.b.a.fK(5);
      int j = f.a.a.b.b.a.bx(6, this.type);
      int k = f.a.a.b.b.a.bx(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + (i + 1) + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FGD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cwa localcwa = (cwa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localcwa.qon = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localcwa.EJj = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cvw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcwa.FGD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localcwa.EJi = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localcwa.rAJ = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localcwa.type = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169385);
          return 0;
        }
        localcwa.index = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwa
 * JD-Core Version:    0.7.0.1
 */