package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnb
  extends com.tencent.mm.bx.a
{
  public boolean GHc;
  public bna Gza;
  public String dDH;
  public int mrl;
  public String oBP;
  public String ozd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72496);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ozd != null) {
        paramVarArgs.d(1, this.ozd);
      }
      if (this.oBP != null) {
        paramVarArgs.d(2, this.oBP);
      }
      if (this.dDH != null) {
        paramVarArgs.d(3, this.dDH);
      }
      paramVarArgs.bt(4, this.GHc);
      paramVarArgs.aS(5, this.mrl);
      if (this.Gza != null)
      {
        paramVarArgs.lC(6, this.Gza.computeSize());
        this.Gza.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ozd == null) {
        break label574;
      }
    }
    label574:
    for (int i = f.a.a.b.b.a.e(1, this.ozd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oBP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.oBP);
      }
      i = paramInt;
      if (this.dDH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dDH);
      }
      i = i + f.a.a.b.b.a.alV(4) + f.a.a.b.b.a.bz(5, this.mrl);
      paramInt = i;
      if (this.Gza != null) {
        paramInt = i + f.a.a.a.lB(6, this.Gza.computeSize());
      }
      AppMethodBeat.o(72496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnb localbnb = (bnb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72496);
          return -1;
        case 1: 
          localbnb.ozd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 2: 
          localbnb.oBP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 3: 
          localbnb.dDH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 4: 
          localbnb.GHc = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72496);
          return 0;
        case 5: 
          localbnb.mrl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72496);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bna();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bna)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnb.Gza = ((bna)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      AppMethodBeat.o(72496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnb
 * JD-Core Version:    0.7.0.1
 */