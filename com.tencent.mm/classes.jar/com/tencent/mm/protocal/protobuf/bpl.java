package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpl
  extends com.tencent.mm.bx.a
{
  public String GKd;
  public String GKh;
  public String GKi;
  public String GKj;
  public chb GKk;
  public int dCC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.dCC);
      if (this.GKd != null) {
        paramVarArgs.d(2, this.GKd);
      }
      if (this.GKh != null) {
        paramVarArgs.d(3, this.GKh);
      }
      if (this.GKi != null) {
        paramVarArgs.d(4, this.GKi);
      }
      if (this.GKj != null) {
        paramVarArgs.d(5, this.GKj);
      }
      if (this.GKk != null)
      {
        paramVarArgs.lC(6, this.GKk.computeSize());
        this.GKk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dCC) + 0;
      paramInt = i;
      if (this.GKd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GKd);
      }
      i = paramInt;
      if (this.GKh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GKh);
      }
      paramInt = i;
      if (this.GKi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKi);
      }
      i = paramInt;
      if (this.GKj != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GKj);
      }
      paramInt = i;
      if (this.GKk != null) {
        paramInt = i + f.a.a.a.lB(6, this.GKk.computeSize());
      }
      AppMethodBeat.o(72508);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.GKd == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bpl localbpl = (bpl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localbpl.dCC = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localbpl.GKd = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localbpl.GKh = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localbpl.GKi = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localbpl.GKj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new chb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((chb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbpl.GKk = ((chb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpl
 * JD-Core Version:    0.7.0.1
 */