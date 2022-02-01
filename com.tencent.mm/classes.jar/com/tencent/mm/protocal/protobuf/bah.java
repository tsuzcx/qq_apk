package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bah
  extends com.tencent.mm.bx.a
{
  public int FKN;
  public int GwK;
  public cvb Gxp;
  public boolean Gxv;
  public boolean Gxw;
  public String Gxx;
  public int dqI;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(175245);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.dqI);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      paramVarArgs.aS(4, this.GwK);
      paramVarArgs.aS(5, this.FKN);
      paramVarArgs.bt(6, this.Gxv);
      paramVarArgs.bt(7, this.Gxw);
      if (this.Gxp != null)
      {
        paramVarArgs.lC(20, this.Gxp.computeSize());
        this.Gxp.writeFields(paramVarArgs);
      }
      if (this.Gxx != null) {
        paramVarArgs.d(21, this.Gxx);
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dqI) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GwK) + f.a.a.b.b.a.bz(5, this.FKN) + f.a.a.b.b.a.alV(6) + f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.Gxp != null) {
        paramInt = i + f.a.a.a.lB(20, this.Gxp.computeSize());
      }
      i = paramInt;
      if (this.Gxx != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Gxx);
      }
      AppMethodBeat.o(175245);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(175245);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bah localbah = (bah)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        AppMethodBeat.o(175245);
        return -1;
      case 1: 
        localbah.dqI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(175245);
        return 0;
      case 2: 
        localbah.url = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 3: 
        localbah.md5 = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(175245);
        return 0;
      case 4: 
        localbah.GwK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(175245);
        return 0;
      case 5: 
        localbah.FKN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(175245);
        return 0;
      case 6: 
        localbah.Gxv = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(175245);
        return 0;
      case 7: 
        localbah.Gxw = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(175245);
        return 0;
      case 20: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cvb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cvb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbah.Gxp = ((cvb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(175245);
        return 0;
      }
      localbah.Gxx = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(175245);
      return 0;
    }
    AppMethodBeat.o(175245);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bah
 * JD-Core Version:    0.7.0.1
 */