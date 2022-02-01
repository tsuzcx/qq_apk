package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bj
  extends com.tencent.mm.bx.a
{
  public dno Fti;
  public String Ftj = "";
  public String Ftk = "";
  public String Ftl = "";
  public long Ftm = 0L;
  public int Ftn = 0;
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fti != null)
      {
        paramVarArgs.lC(1, this.Fti.computeSize());
        this.Fti.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.flags);
      paramVarArgs.aS(3, this.state);
      if (this.Ftj != null) {
        paramVarArgs.d(4, this.Ftj);
      }
      if (this.Ftk != null) {
        paramVarArgs.d(5, this.Ftk);
      }
      if (this.Ftl != null) {
        paramVarArgs.d(6, this.Ftl);
      }
      paramVarArgs.aY(7, this.Ftm);
      paramVarArgs.aS(8, this.Ftn);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fti == null) {
        break label674;
      }
    }
    label674:
    for (paramInt = f.a.a.a.lB(1, this.Fti.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.flags) + f.a.a.b.b.a.bz(3, this.state);
      paramInt = i;
      if (this.Ftj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ftj);
      }
      i = paramInt;
      if (this.Ftk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Ftk);
      }
      paramInt = i;
      if (this.Ftl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Ftl);
      }
      i = f.a.a.b.b.a.p(7, this.Ftm);
      int j = f.a.a.b.b.a.bz(8, this.Ftn);
      AppMethodBeat.o(122482);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bj localbj = (bj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbj.Fti = ((dno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbj.flags = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbj.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbj.Ftj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbj.Ftk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbj.Ftl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 7: 
          localbj.Ftm = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbj.Ftn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bj
 * JD-Core Version:    0.7.0.1
 */