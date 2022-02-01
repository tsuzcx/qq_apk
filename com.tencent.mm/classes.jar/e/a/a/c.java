package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String Gdt;
  public String GeU;
  public LinkedList<i> GeV;
  public int GeW;
  public a GeX;
  public int NPf;
  public int NPg;
  public int NPh;
  public f NPi;
  public String NPj;
  public b NPk;
  public d NPl;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.GeV = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GeV);
      paramVarArgs.aS(2, this.NPf);
      if (this.Gdt != null) {
        paramVarArgs.d(3, this.Gdt);
      }
      paramVarArgs.aS(4, this.GeW);
      if (this.GeX != null)
      {
        paramVarArgs.lC(5, this.GeX.computeSize());
        this.GeX.writeFields(paramVarArgs);
      }
      if (this.GeU != null) {
        paramVarArgs.d(6, this.GeU);
      }
      paramVarArgs.aS(7, this.NPg);
      paramVarArgs.aS(8, this.NPh);
      if (this.NPi != null)
      {
        paramVarArgs.lC(9, this.NPi.computeSize());
        this.NPi.writeFields(paramVarArgs);
      }
      if (this.NPj != null) {
        paramVarArgs.d(10, this.NPj);
      }
      if (this.NPk != null)
      {
        paramVarArgs.lC(11, this.NPk.computeSize());
        this.NPk.writeFields(paramVarArgs);
      }
      if (this.NPl != null)
      {
        paramVarArgs.lC(12, this.NPl.computeSize());
        this.NPl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GeV) + 0 + f.a.a.b.b.a.bz(2, this.NPf);
      paramInt = i;
      if (this.Gdt != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gdt);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GeW);
      paramInt = i;
      if (this.GeX != null) {
        paramInt = i + f.a.a.a.lB(5, this.GeX.computeSize());
      }
      i = paramInt;
      if (this.GeU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GeU);
      }
      i = i + f.a.a.b.b.a.bz(7, this.NPg) + f.a.a.b.b.a.bz(8, this.NPh);
      paramInt = i;
      if (this.NPi != null) {
        paramInt = i + f.a.a.a.lB(9, this.NPi.computeSize());
      }
      i = paramInt;
      if (this.NPj != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.NPj);
      }
      paramInt = i;
      if (this.NPk != null) {
        paramInt = i + f.a.a.a.lB(11, this.NPk.computeSize());
      }
      i = paramInt;
      if (this.NPl != null) {
        i = paramInt + f.a.a.a.lB(12, this.NPl.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GeV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91741);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.GeV.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.NPf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.Gdt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.GeW = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.GeX = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.GeU = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.NPg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.NPh = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.NPi = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.NPj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.NPk = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localc.NPl = ((d)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    AppMethodBeat.o(91741);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.c
 * JD-Core Version:    0.7.0.1
 */