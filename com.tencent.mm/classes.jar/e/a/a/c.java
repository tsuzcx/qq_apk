package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bx.a
{
  public String DcQ;
  public String Del;
  public LinkedList<i> Dem;
  public int Den;
  public a Deo;
  public int KgW;
  public int KgX;
  public int KgY;
  public f KgZ;
  public String Kha;
  public b Khb;
  public d Khc;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.Dem = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Dem);
      paramVarArgs.aR(2, this.KgW);
      if (this.DcQ != null) {
        paramVarArgs.d(3, this.DcQ);
      }
      paramVarArgs.aR(4, this.Den);
      if (this.Deo != null)
      {
        paramVarArgs.kX(5, this.Deo.computeSize());
        this.Deo.writeFields(paramVarArgs);
      }
      if (this.Del != null) {
        paramVarArgs.d(6, this.Del);
      }
      paramVarArgs.aR(7, this.KgX);
      paramVarArgs.aR(8, this.KgY);
      if (this.KgZ != null)
      {
        paramVarArgs.kX(9, this.KgZ.computeSize());
        this.KgZ.writeFields(paramVarArgs);
      }
      if (this.Kha != null) {
        paramVarArgs.d(10, this.Kha);
      }
      if (this.Khb != null)
      {
        paramVarArgs.kX(11, this.Khb.computeSize());
        this.Khb.writeFields(paramVarArgs);
      }
      if (this.Khc != null)
      {
        paramVarArgs.kX(12, this.Khc.computeSize());
        this.Khc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Dem) + 0 + f.a.a.b.b.a.bA(2, this.KgW);
      paramInt = i;
      if (this.DcQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DcQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(4, this.Den);
      paramInt = i;
      if (this.Deo != null) {
        paramInt = i + f.a.a.a.kW(5, this.Deo.computeSize());
      }
      i = paramInt;
      if (this.Del != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Del);
      }
      i = i + f.a.a.b.b.a.bA(7, this.KgX) + f.a.a.b.b.a.bA(8, this.KgY);
      paramInt = i;
      if (this.KgZ != null) {
        paramInt = i + f.a.a.a.kW(9, this.KgZ.computeSize());
      }
      i = paramInt;
      if (this.Kha != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Kha);
      }
      paramInt = i;
      if (this.Khb != null) {
        paramInt = i + f.a.a.a.kW(11, this.Khb.computeSize());
      }
      i = paramInt;
      if (this.Khc != null) {
        i = paramInt + f.a.a.a.kW(12, this.Khc.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dem.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Dem.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.KgW = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.DcQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.Den = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Deo = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.Del = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.KgX = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.KgY = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.KgZ = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.Kha = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Khb = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localc.Khc = ((d)localObject1);
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