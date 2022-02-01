package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bqd
  extends com.tencent.mm.bw.a
{
  public String HdE;
  public String HdI;
  public String HdJ;
  public String HdK;
  public chv HdL;
  public int dDH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HdE == null)
      {
        paramVarArgs = new b("Not all required fields were included: session_data");
        AppMethodBeat.o(72508);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.dDH);
      if (this.HdE != null) {
        paramVarArgs.d(2, this.HdE);
      }
      if (this.HdI != null) {
        paramVarArgs.d(3, this.HdI);
      }
      if (this.HdJ != null) {
        paramVarArgs.d(4, this.HdJ);
      }
      if (this.HdK != null) {
        paramVarArgs.d(5, this.HdK);
      }
      if (this.HdL != null)
      {
        paramVarArgs.lJ(6, this.HdL.computeSize());
        this.HdL.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.dDH) + 0;
      paramInt = i;
      if (this.HdE != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HdE);
      }
      i = paramInt;
      if (this.HdI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HdI);
      }
      paramInt = i;
      if (this.HdJ != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HdJ);
      }
      i = paramInt;
      if (this.HdK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HdK);
      }
      paramInt = i;
      if (this.HdL != null) {
        paramInt = i + f.a.a.a.lI(6, this.HdL.computeSize());
      }
      AppMethodBeat.o(72508);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.HdE == null)
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
      bqd localbqd = (bqd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72508);
        return -1;
      case 1: 
        localbqd.dDH = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(72508);
        return 0;
      case 2: 
        localbqd.HdE = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 3: 
        localbqd.HdI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 4: 
        localbqd.HdJ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72508);
        return 0;
      case 5: 
        localbqd.HdK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(72508);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new chv();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((chv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbqd.HdL = ((chv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(72508);
      return 0;
    }
    AppMethodBeat.o(72508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqd
 * JD-Core Version:    0.7.0.1
 */