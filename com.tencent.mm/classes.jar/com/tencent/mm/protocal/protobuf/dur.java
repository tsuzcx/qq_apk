package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dur
  extends com.tencent.mm.bw.a
{
  public LinkedList<dus> HqQ;
  public boolean kDe;
  public int kDf;
  public int kDg;
  public String kDh;
  public String kDi;
  public String kDj;
  public String kDk;
  
  public dur()
  {
    AppMethodBeat.i(123670);
    this.HqQ = new LinkedList();
    AppMethodBeat.o(123670);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123671);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.HqQ);
      paramVarArgs.bC(2, this.kDe);
      paramVarArgs.aS(3, this.kDf);
      paramVarArgs.aS(4, this.kDg);
      if (this.kDh != null) {
        paramVarArgs.d(5, this.kDh);
      }
      if (this.kDi != null) {
        paramVarArgs.d(6, this.kDi);
      }
      if (this.kDj != null) {
        paramVarArgs.d(7, this.kDj);
      }
      if (this.kDk != null) {
        paramVarArgs.d(8, this.kDk);
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.HqQ) + 0 + f.a.a.b.b.a.amF(2) + f.a.a.b.b.a.bz(3, this.kDf) + f.a.a.b.b.a.bz(4, this.kDg);
      paramInt = i;
      if (this.kDh != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.kDh);
      }
      i = paramInt;
      if (this.kDi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.kDi);
      }
      paramInt = i;
      if (this.kDj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.kDj);
      }
      i = paramInt;
      if (this.kDk != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.kDk);
      }
      AppMethodBeat.o(123671);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HqQ.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(123671);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dur localdur = (dur)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123671);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dus();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dus)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdur.HqQ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123671);
        return 0;
      case 2: 
        localdur.kDe = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(123671);
        return 0;
      case 3: 
        localdur.kDf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123671);
        return 0;
      case 4: 
        localdur.kDg = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(123671);
        return 0;
      case 5: 
        localdur.kDh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 6: 
        localdur.kDi = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123671);
        return 0;
      case 7: 
        localdur.kDj = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(123671);
        return 0;
      }
      localdur.kDk = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(123671);
      return 0;
    }
    AppMethodBeat.o(123671);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dur
 * JD-Core Version:    0.7.0.1
 */