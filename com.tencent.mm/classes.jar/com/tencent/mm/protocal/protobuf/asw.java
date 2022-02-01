package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class asw
  extends com.tencent.mm.bx.a
{
  public int GlJ;
  public int GlK;
  public int GqP;
  public int GqQ;
  public int GqR;
  public int GqS;
  public aqu Gqk;
  public int count;
  public String hDQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.count);
      paramVarArgs.aS(2, this.GlJ);
      paramVarArgs.aS(3, this.GlK);
      paramVarArgs.aS(4, this.GqP);
      if (this.hDQ != null) {
        paramVarArgs.d(5, this.hDQ);
      }
      if (this.Gqk != null)
      {
        paramVarArgs.lC(6, this.Gqk.computeSize());
        this.Gqk.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GqQ);
      paramVarArgs.aS(8, this.GqR);
      paramVarArgs.aS(9, this.GqS);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.count) + 0 + f.a.a.b.b.a.bz(2, this.GlJ) + f.a.a.b.b.a.bz(3, this.GlK) + f.a.a.b.b.a.bz(4, this.GqP);
      paramInt = i;
      if (this.hDQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hDQ);
      }
      i = paramInt;
      if (this.Gqk != null) {
        i = paramInt + f.a.a.a.lB(6, this.Gqk.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.GqQ);
      int j = f.a.a.b.b.a.bz(8, this.GqR);
      int k = f.a.a.b.b.a.bz(9, this.GqS);
      AppMethodBeat.o(169077);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      asw localasw = (asw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localasw.count = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localasw.GlJ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localasw.GlK = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localasw.GqP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localasw.hDQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aqu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aqu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localasw.Gqk = ((aqu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localasw.GqQ = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 8: 
        localasw.GqR = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(169077);
        return 0;
      }
      localasw.GqS = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asw
 * JD-Core Version:    0.7.0.1
 */