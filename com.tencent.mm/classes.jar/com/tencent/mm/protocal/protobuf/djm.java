package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djm
  extends com.tencent.mm.bx.a
{
  public int GPx;
  public long GTk;
  public int GTo;
  public int Hyr;
  public djk Hys;
  public String Hyt;
  public boolean Hyu;
  public String hCW;
  public int hfV;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hCW != null) {
        paramVarArgs.d(1, this.hCW);
      }
      paramVarArgs.aS(2, this.hfV);
      paramVarArgs.aY(3, this.GTk);
      paramVarArgs.aS(4, this.GTo);
      if (this.md5 != null) {
        paramVarArgs.d(5, this.md5);
      }
      paramVarArgs.aS(6, this.GPx);
      paramVarArgs.aS(7, this.Hyr);
      if (this.Hys != null)
      {
        paramVarArgs.lC(8, this.Hys.computeSize());
        this.Hys.writeFields(paramVarArgs);
      }
      if (this.Hyt != null) {
        paramVarArgs.d(9, this.Hyt);
      }
      paramVarArgs.bt(10, this.Hyu);
      AppMethodBeat.o(118455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hCW == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.b.b.a.e(1, this.hCW) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.hfV) + f.a.a.b.b.a.p(3, this.GTk) + f.a.a.b.b.a.bz(4, this.GTo);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.md5);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.GPx) + f.a.a.b.b.a.bz(7, this.Hyr);
      paramInt = i;
      if (this.Hys != null) {
        paramInt = i + f.a.a.a.lB(8, this.Hys.computeSize());
      }
      i = paramInt;
      if (this.Hyt != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Hyt);
      }
      paramInt = f.a.a.b.b.a.alV(10);
      AppMethodBeat.o(118455);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djm localdjm = (djm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118455);
          return -1;
        case 1: 
          localdjm.hCW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 2: 
          localdjm.hfV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 3: 
          localdjm.GTk = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(118455);
          return 0;
        case 4: 
          localdjm.GTo = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 5: 
          localdjm.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118455);
          return 0;
        case 6: 
          localdjm.GPx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 7: 
          localdjm.Hyr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118455);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((djk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjm.Hys = ((djk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118455);
          return 0;
        case 9: 
          localdjm.Hyt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118455);
          return 0;
        }
        localdjm.Hyu = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(118455);
        return 0;
      }
      AppMethodBeat.o(118455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djm
 * JD-Core Version:    0.7.0.1
 */