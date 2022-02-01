package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cho
  extends com.tencent.mm.bx.a
{
  public String FrW;
  public String HaZ;
  public String Hba;
  public String Hbb;
  public int Hbc;
  public LinkedList<ss> Hbd;
  public String Hbe;
  public String Hbf;
  
  public cho()
  {
    AppMethodBeat.i(114047);
    this.Hbd = new LinkedList();
    AppMethodBeat.o(114047);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114048);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FrW != null) {
        paramVarArgs.d(1, this.FrW);
      }
      if (this.HaZ != null) {
        paramVarArgs.d(2, this.HaZ);
      }
      if (this.Hba != null) {
        paramVarArgs.d(3, this.Hba);
      }
      if (this.Hbb != null) {
        paramVarArgs.d(4, this.Hbb);
      }
      paramVarArgs.aS(5, this.Hbc);
      paramVarArgs.e(6, 8, this.Hbd);
      if (this.Hbe != null) {
        paramVarArgs.d(7, this.Hbe);
      }
      if (this.Hbf != null) {
        paramVarArgs.d(8, this.Hbf);
      }
      AppMethodBeat.o(114048);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FrW == null) {
        break label706;
      }
    }
    label706:
    for (int i = f.a.a.b.b.a.e(1, this.FrW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HaZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HaZ);
      }
      i = paramInt;
      if (this.Hba != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hba);
      }
      paramInt = i;
      if (this.Hbb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hbb);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Hbc) + f.a.a.a.c(6, 8, this.Hbd);
      paramInt = i;
      if (this.Hbe != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hbe);
      }
      i = paramInt;
      if (this.Hbf != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Hbf);
      }
      AppMethodBeat.o(114048);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hbd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114048);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cho localcho = (cho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114048);
          return -1;
        case 1: 
          localcho.FrW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 2: 
          localcho.HaZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 3: 
          localcho.Hba = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 4: 
          localcho.Hbb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114048);
          return 0;
        case 5: 
          localcho.Hbc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114048);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ss();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ss)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcho.Hbd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114048);
          return 0;
        case 7: 
          localcho.Hbe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114048);
          return 0;
        }
        localcho.Hbf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(114048);
        return 0;
      }
      AppMethodBeat.o(114048);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cho
 * JD-Core Version:    0.7.0.1
 */