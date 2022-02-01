package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tk
  extends com.tencent.mm.bx.a
{
  public String FRd;
  public String FRe;
  public String FRf;
  public int FRg;
  public String FRh;
  public tg FRi;
  public String FRj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113968);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FRd != null) {
        paramVarArgs.d(1, this.FRd);
      }
      if (this.FRe != null) {
        paramVarArgs.d(2, this.FRe);
      }
      if (this.FRf != null) {
        paramVarArgs.d(3, this.FRf);
      }
      paramVarArgs.aS(4, this.FRg);
      if (this.FRh != null) {
        paramVarArgs.d(5, this.FRh);
      }
      if (this.FRi != null)
      {
        paramVarArgs.lC(6, this.FRi.computeSize());
        this.FRi.writeFields(paramVarArgs);
      }
      if (this.FRj != null) {
        paramVarArgs.d(7, this.FRj);
      }
      AppMethodBeat.o(113968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FRd == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.FRd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FRe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FRe);
      }
      i = paramInt;
      if (this.FRf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FRf);
      }
      i += f.a.a.b.b.a.bz(4, this.FRg);
      paramInt = i;
      if (this.FRh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FRh);
      }
      i = paramInt;
      if (this.FRi != null) {
        i = paramInt + f.a.a.a.lB(6, this.FRi.computeSize());
      }
      paramInt = i;
      if (this.FRj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FRj);
      }
      AppMethodBeat.o(113968);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tk localtk = (tk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113968);
          return -1;
        case 1: 
          localtk.FRd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 2: 
          localtk.FRe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 3: 
          localtk.FRf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 4: 
          localtk.FRg = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113968);
          return 0;
        case 5: 
          localtk.FRh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113968);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((tg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtk.FRi = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113968);
          return 0;
        }
        localtk.FRj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(113968);
        return 0;
      }
      AppMethodBeat.o(113968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tk
 * JD-Core Version:    0.7.0.1
 */