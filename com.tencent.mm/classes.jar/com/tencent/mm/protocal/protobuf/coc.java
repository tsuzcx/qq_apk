package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coc
  extends com.tencent.mm.bx.a
{
  public int Hha;
  public boolean Hhb;
  public String Hhc;
  public int Hhd;
  public int Hhe;
  public LinkedList<cob> Hhf;
  public String dHX;
  
  public coc()
  {
    AppMethodBeat.i(114057);
    this.Hhf = new LinkedList();
    AppMethodBeat.o(114057);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114058);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX != null) {
        paramVarArgs.d(1, this.dHX);
      }
      paramVarArgs.aS(2, this.Hha);
      paramVarArgs.bt(3, this.Hhb);
      if (this.Hhc != null) {
        paramVarArgs.d(4, this.Hhc);
      }
      paramVarArgs.aS(5, this.Hhd);
      paramVarArgs.aS(6, this.Hhe);
      paramVarArgs.e(7, 8, this.Hhf);
      AppMethodBeat.o(114058);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dHX == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.b.b.a.e(1, this.dHX) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hha) + f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.Hhc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hhc);
      }
      i = f.a.a.b.b.a.bz(5, this.Hhd);
      int j = f.a.a.b.b.a.bz(6, this.Hhe);
      int k = f.a.a.a.c(7, 8, this.Hhf);
      AppMethodBeat.o(114058);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hhf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114058);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coc localcoc = (coc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114058);
          return -1;
        case 1: 
          localcoc.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 2: 
          localcoc.Hha = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114058);
          return 0;
        case 3: 
          localcoc.Hhb = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(114058);
          return 0;
        case 4: 
          localcoc.Hhc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114058);
          return 0;
        case 5: 
          localcoc.Hhd = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114058);
          return 0;
        case 6: 
          localcoc.Hhe = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114058);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cob();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcoc.Hhf.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coc
 * JD-Core Version:    0.7.0.1
 */