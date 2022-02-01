package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chp
  extends com.tencent.mm.bx.a
{
  public int GTN;
  public String Hbg;
  public String Hbh;
  public String Hbi;
  public String Hbj;
  public tg Hbk;
  public String Hbl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hbg != null) {
        paramVarArgs.d(1, this.Hbg);
      }
      if (this.Hbh != null) {
        paramVarArgs.d(2, this.Hbh);
      }
      if (this.Hbi != null) {
        paramVarArgs.d(3, this.Hbi);
      }
      paramVarArgs.aS(4, this.GTN);
      if (this.Hbj != null) {
        paramVarArgs.d(5, this.Hbj);
      }
      if (this.Hbk != null)
      {
        paramVarArgs.lC(6, this.Hbk.computeSize());
        this.Hbk.writeFields(paramVarArgs);
      }
      if (this.Hbl != null) {
        paramVarArgs.d(7, this.Hbl);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hbg == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.b.b.a.e(1, this.Hbg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hbh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hbh);
      }
      i = paramInt;
      if (this.Hbi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hbi);
      }
      i += f.a.a.b.b.a.bz(4, this.GTN);
      paramInt = i;
      if (this.Hbj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hbj);
      }
      i = paramInt;
      if (this.Hbk != null) {
        i = paramInt + f.a.a.a.lB(6, this.Hbk.computeSize());
      }
      paramInt = i;
      if (this.Hbl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hbl);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        chp localchp = (chp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localchp.Hbg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localchp.Hbh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localchp.Hbi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localchp.GTN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localchp.Hbj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114049);
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
            localchp.Hbk = ((tg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localchp.Hbl = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chp
 * JD-Core Version:    0.7.0.1
 */