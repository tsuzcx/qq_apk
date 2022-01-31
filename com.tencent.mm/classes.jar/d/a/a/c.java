package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bv.a
{
  public int CLp;
  public int CLq;
  public int CLr;
  public f CLs;
  public String CLt;
  public b CLu;
  public d CLv;
  public String wPV;
  public String wQY;
  public LinkedList<i> wQZ;
  public int wRa;
  public a wRb;
  
  public c()
  {
    AppMethodBeat.i(57007);
    this.wQZ = new LinkedList();
    AppMethodBeat.o(57007);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57008);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.wQZ);
      paramVarArgs.aO(2, this.CLp);
      if (this.wPV != null) {
        paramVarArgs.e(3, this.wPV);
      }
      paramVarArgs.aO(4, this.wRa);
      if (this.wRb != null)
      {
        paramVarArgs.iQ(5, this.wRb.computeSize());
        this.wRb.writeFields(paramVarArgs);
      }
      if (this.wQY != null) {
        paramVarArgs.e(6, this.wQY);
      }
      paramVarArgs.aO(7, this.CLq);
      paramVarArgs.aO(8, this.CLr);
      if (this.CLs != null)
      {
        paramVarArgs.iQ(9, this.CLs.computeSize());
        this.CLs.writeFields(paramVarArgs);
      }
      if (this.CLt != null) {
        paramVarArgs.e(10, this.CLt);
      }
      if (this.CLu != null)
      {
        paramVarArgs.iQ(11, this.CLu.computeSize());
        this.CLu.writeFields(paramVarArgs);
      }
      if (this.CLv != null)
      {
        paramVarArgs.iQ(12, this.CLv.computeSize());
        this.CLv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(57008);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.a.c(1, 8, this.wQZ) + 0 + e.a.a.b.b.a.bl(2, this.CLp);
      paramInt = i;
      if (this.wPV != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wPV);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.wRa);
      paramInt = i;
      if (this.wRb != null) {
        paramInt = i + e.a.a.a.iP(5, this.wRb.computeSize());
      }
      i = paramInt;
      if (this.wQY != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wQY);
      }
      i = i + e.a.a.b.b.a.bl(7, this.CLq) + e.a.a.b.b.a.bl(8, this.CLr);
      paramInt = i;
      if (this.CLs != null) {
        paramInt = i + e.a.a.a.iP(9, this.CLs.computeSize());
      }
      i = paramInt;
      if (this.CLt != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.CLt);
      }
      paramInt = i;
      if (this.CLu != null) {
        paramInt = i + e.a.a.a.iP(11, this.CLu.computeSize());
      }
      i = paramInt;
      if (this.CLv != null) {
        i = paramInt + e.a.a.a.iP(12, this.CLv.computeSize());
      }
      AppMethodBeat.o(57008);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wQZ.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(57008);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(57008);
        return -1;
      case 1: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.wQZ.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(57008);
        return 0;
      case 2: 
        localc.CLp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(57008);
        return 0;
      case 3: 
        localc.wPV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(57008);
        return 0;
      case 4: 
        localc.wRa = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(57008);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.wRb = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(57008);
        return 0;
      case 6: 
        localc.wQY = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(57008);
        return 0;
      case 7: 
        localc.CLq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(57008);
        return 0;
      case 8: 
        localc.CLr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(57008);
        return 0;
      case 9: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.CLs = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(57008);
        return 0;
      case 10: 
        localc.CLt = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(57008);
        return 0;
      case 11: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localc.CLu = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(57008);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localc.CLv = ((d)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(57008);
      return 0;
    }
    AppMethodBeat.o(57008);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     d.a.a.c
 * JD-Core Version:    0.7.0.1
 */