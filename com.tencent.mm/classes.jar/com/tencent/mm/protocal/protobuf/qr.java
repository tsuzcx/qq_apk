package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class qr
  extends com.tencent.mm.bx.a
{
  public long FMq;
  public int FMr;
  public LinkedList<String> FMs;
  public String FMt;
  public int FMu;
  public String Title;
  public int nDI;
  public LinkedList<qy> ugO;
  
  public qr()
  {
    AppMethodBeat.i(117842);
    this.FMs = new LinkedList();
    this.ugO = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FMt == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.aY(1, this.FMq);
      paramVarArgs.aS(2, this.FMr);
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      paramVarArgs.e(4, 1, this.FMs);
      paramVarArgs.e(5, 8, this.ugO);
      paramVarArgs.aS(6, this.nDI);
      if (this.FMt != null) {
        paramVarArgs.d(7, this.FMt);
      }
      paramVarArgs.aS(8, this.FMu);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FMq) + 0 + f.a.a.b.b.a.bz(2, this.FMr);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Title);
      }
      i = paramInt + f.a.a.a.c(4, 1, this.FMs) + f.a.a.a.c(5, 8, this.ugO) + f.a.a.b.b.a.bz(6, this.nDI);
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FMt);
      }
      i = f.a.a.b.b.a.bz(8, this.FMu);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FMs.clear();
      this.ugO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.FMt == null)
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
      qr localqr = (qr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localqr.FMq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localqr.FMr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localqr.Title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localqr.FMs.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((qy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqr.ugO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localqr.nDI = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localqr.FMt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localqr.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qr
 * JD-Core Version:    0.7.0.1
 */