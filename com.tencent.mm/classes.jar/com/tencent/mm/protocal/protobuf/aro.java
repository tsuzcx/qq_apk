package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aro
  extends com.tencent.mm.bx.a
{
  public String DCX;
  public long Gpl;
  public String Gpm;
  public int Gpn;
  public LinkedList<Integer> Gpo;
  public b Gpp;
  public LinkedList<FinderObject> object;
  
  public aro()
  {
    AppMethodBeat.i(209358);
    this.object = new LinkedList();
    this.Gpo = new LinkedList();
    AppMethodBeat.o(209358);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209359);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Gpl);
      if (this.DCX != null) {
        paramVarArgs.d(2, this.DCX);
      }
      if (this.Gpm != null) {
        paramVarArgs.d(3, this.Gpm);
      }
      paramVarArgs.aS(4, this.Gpn);
      paramVarArgs.e(5, 8, this.object);
      paramVarArgs.e(6, 2, this.Gpo);
      if (this.Gpp != null) {
        paramVarArgs.c(7, this.Gpp);
      }
      AppMethodBeat.o(209359);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Gpl) + 0;
      paramInt = i;
      if (this.DCX != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DCX);
      }
      i = paramInt;
      if (this.Gpm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gpm);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Gpn) + f.a.a.a.c(5, 8, this.object) + f.a.a.a.c(6, 2, this.Gpo);
      paramInt = i;
      if (this.Gpp != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Gpp);
      }
      AppMethodBeat.o(209359);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.object.clear();
      this.Gpo.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209359);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aro localaro = (aro)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(209359);
        return -1;
      case 1: 
        localaro.Gpl = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(209359);
        return 0;
      case 2: 
        localaro.DCX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209359);
        return 0;
      case 3: 
        localaro.Gpm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(209359);
        return 0;
      case 4: 
        localaro.Gpn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209359);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaro.object.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209359);
        return 0;
      case 6: 
        localaro.Gpo.add(Integer.valueOf(((f.a.a.a.a)localObject1).NPN.zc()));
        AppMethodBeat.o(209359);
        return 0;
      }
      localaro.Gpp = ((f.a.a.a.a)localObject1).NPN.gxI();
      AppMethodBeat.o(209359);
      return 0;
    }
    AppMethodBeat.o(209359);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aro
 * JD-Core Version:    0.7.0.1
 */