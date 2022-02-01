package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qt
  extends com.tencent.mm.bw.a
{
  public long GeP;
  public int GeQ;
  public LinkedList<String> GeR;
  public String GeS;
  public int GeT;
  public String Title;
  public int nJd;
  public LinkedList<ra> usl;
  
  public qt()
  {
    AppMethodBeat.i(117842);
    this.GeR = new LinkedList();
    this.usl = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GeS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.aZ(1, this.GeP);
      paramVarArgs.aS(2, this.GeQ);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      paramVarArgs.e(4, 1, this.GeR);
      paramVarArgs.e(5, 8, this.usl);
      paramVarArgs.aS(6, this.nJd);
      if (this.GeS != null) {
        paramVarArgs.d(7, this.GeS);
      }
      paramVarArgs.aS(8, this.GeT);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.GeP) + 0 + f.a.a.b.b.a.bz(2, this.GeQ);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt + f.a.a.a.c(4, 1, this.GeR) + f.a.a.a.c(5, 8, this.usl) + f.a.a.b.b.a.bz(6, this.nJd);
      paramInt = i;
      if (this.GeS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GeS);
      }
      i = f.a.a.b.b.a.bz(8, this.GeT);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GeR.clear();
      this.usl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.GeS == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117843);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qt localqt = (qt)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localqt.GeP = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localqt.GeQ = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localqt.Title = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localqt.GeR.add(((f.a.a.a.a)localObject1).OmT.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ra();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ra)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqt.usl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localqt.nJd = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localqt.GeS = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localqt.GeT = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qt
 * JD-Core Version:    0.7.0.1
 */