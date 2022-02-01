package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String LrG;
  public String Ltl;
  public LinkedList<i> Ltm;
  public int Ltn;
  public a Lto;
  public int Ubh;
  public int Ubi;
  public int Ubj;
  public f Ubk;
  public String Ubl;
  public b Ubm;
  public d Ubn;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.Ltm = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Ltm);
      paramVarArgs.aM(2, this.Ubh);
      if (this.LrG != null) {
        paramVarArgs.e(3, this.LrG);
      }
      paramVarArgs.aM(4, this.Ltn);
      if (this.Lto != null)
      {
        paramVarArgs.ni(5, this.Lto.computeSize());
        this.Lto.writeFields(paramVarArgs);
      }
      if (this.Ltl != null) {
        paramVarArgs.e(6, this.Ltl);
      }
      paramVarArgs.aM(7, this.Ubi);
      paramVarArgs.aM(8, this.Ubj);
      if (this.Ubk != null)
      {
        paramVarArgs.ni(9, this.Ubk.computeSize());
        this.Ubk.writeFields(paramVarArgs);
      }
      if (this.Ubl != null) {
        paramVarArgs.e(10, this.Ubl);
      }
      if (this.Ubm != null)
      {
        paramVarArgs.ni(11, this.Ubm.computeSize());
        this.Ubm.writeFields(paramVarArgs);
      }
      if (this.Ubn != null)
      {
        paramVarArgs.ni(12, this.Ubn.computeSize());
        this.Ubn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Ltm) + 0 + g.a.a.b.b.a.bu(2, this.Ubh);
      paramInt = i;
      if (this.LrG != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LrG);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.Ltn);
      paramInt = i;
      if (this.Lto != null) {
        paramInt = i + g.a.a.a.nh(5, this.Lto.computeSize());
      }
      i = paramInt;
      if (this.Ltl != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Ltl);
      }
      i = i + g.a.a.b.b.a.bu(7, this.Ubi) + g.a.a.b.b.a.bu(8, this.Ubj);
      paramInt = i;
      if (this.Ubk != null) {
        paramInt = i + g.a.a.a.nh(9, this.Ubk.computeSize());
      }
      i = paramInt;
      if (this.Ubl != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Ubl);
      }
      paramInt = i;
      if (this.Ubm != null) {
        paramInt = i + g.a.a.a.nh(11, this.Ubm.computeSize());
      }
      i = paramInt;
      if (this.Ubn != null) {
        i = paramInt + g.a.a.a.nh(12, this.Ubn.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Ltm.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localc.Ltm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.Ubh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.LrG = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.Ltn = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localc.Lto = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.Ltl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.Ubi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.Ubj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localc.Ubk = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.Ubl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localc.Ubm = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localc.Ubn = ((d)localObject1);
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