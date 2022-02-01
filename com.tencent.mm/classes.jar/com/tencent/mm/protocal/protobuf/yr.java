package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yr
  extends com.tencent.mm.bx.a
{
  public int FCf;
  public int FYc;
  public String gsM;
  public String gsN;
  public String gsO;
  public String gsP;
  public String gsQ;
  public int nEk;
  public int qdX;
  public LinkedList<bsh> ugO;
  
  public yr()
  {
    AppMethodBeat.i(143965);
    this.ugO = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.qdX);
      if (this.gsO != null) {
        paramVarArgs.d(7, this.gsO);
      }
      paramVarArgs.aS(2, this.FCf);
      paramVarArgs.aS(3, this.FYc);
      paramVarArgs.e(4, 8, this.ugO);
      if (this.gsM != null) {
        paramVarArgs.d(5, this.gsM);
      }
      if (this.gsN != null) {
        paramVarArgs.d(6, this.gsN);
      }
      if (this.gsP != null) {
        paramVarArgs.d(8, this.gsP);
      }
      if (this.gsQ != null) {
        paramVarArgs.d(9, this.gsQ);
      }
      paramVarArgs.aS(10, this.nEk);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.qdX) + 0;
      paramInt = i;
      if (this.gsO != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.gsO);
      }
      i = paramInt + f.a.a.b.b.a.bz(2, this.FCf) + f.a.a.b.b.a.bz(3, this.FYc) + f.a.a.a.c(4, 8, this.ugO);
      paramInt = i;
      if (this.gsM != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gsM);
      }
      i = paramInt;
      if (this.gsN != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.gsN);
      }
      paramInt = i;
      if (this.gsP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.gsP);
      }
      i = paramInt;
      if (this.gsQ != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.gsQ);
      }
      paramInt = f.a.a.b.b.a.bz(10, this.nEk);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ugO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      yr localyr = (yr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localyr.qdX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localyr.gsO = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localyr.FCf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localyr.FYc = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bsh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localyr.ugO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localyr.gsM = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localyr.gsN = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localyr.gsP = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localyr.gsQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localyr.nEk = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yr
 * JD-Core Version:    0.7.0.1
 */