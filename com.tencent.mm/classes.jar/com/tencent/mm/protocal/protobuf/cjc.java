package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjc
  extends com.tencent.mm.bw.a
{
  public int FwV;
  public boolean FwW;
  public String FwX;
  public int FwY;
  public int FwZ;
  public LinkedList<cjb> Fxa;
  public String dvO;
  
  public cjc()
  {
    AppMethodBeat.i(114057);
    this.Fxa = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvO != null) {
        paramVarArgs.d(1, this.dvO);
      }
      paramVarArgs.aR(2, this.FwV);
      paramVarArgs.bl(3, this.FwW);
      if (this.FwX != null) {
        paramVarArgs.d(4, this.FwX);
      }
      paramVarArgs.aR(5, this.FwY);
      paramVarArgs.aR(6, this.FwZ);
      paramVarArgs.e(7, 8, this.Fxa);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvO == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvO) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.FwV) + (f.a.a.b.b.a.fK(3) + 1);
      paramInt = i;
      if (this.FwX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FwX);
      }
      i = f.a.a.b.b.a.bx(5, this.FwY);
      int j = f.a.a.b.b.a.bx(6, this.FwZ);
      int k = f.a.a.a.c(7, 8, this.Fxa);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fxa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjc localcjc = (cjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localcjc.dvO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localcjc.FwV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localcjc.FwW = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localcjc.FwX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localcjc.FwY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localcjc.FwZ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cjb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjc.Fxa.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      AppMethodBeat.o(114058);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjc
 * JD-Core Version:    0.7.0.1
 */