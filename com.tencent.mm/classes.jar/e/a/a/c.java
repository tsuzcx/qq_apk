package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String EvX;
  public String Exr;
  public LinkedList<i> Exs;
  public int Ext;
  public a Exu;
  public int LUG;
  public int LUH;
  public int LUI;
  public f LUJ;
  public String LUK;
  public b LUL;
  public d LUM;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.Exs = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Exs);
      paramVarArgs.aR(2, this.LUG);
      if (this.EvX != null) {
        paramVarArgs.d(3, this.EvX);
      }
      paramVarArgs.aR(4, this.Ext);
      if (this.Exu != null)
      {
        paramVarArgs.ln(5, this.Exu.computeSize());
        this.Exu.writeFields(paramVarArgs);
      }
      if (this.Exr != null) {
        paramVarArgs.d(6, this.Exr);
      }
      paramVarArgs.aR(7, this.LUH);
      paramVarArgs.aR(8, this.LUI);
      if (this.LUJ != null)
      {
        paramVarArgs.ln(9, this.LUJ.computeSize());
        this.LUJ.writeFields(paramVarArgs);
      }
      if (this.LUK != null) {
        paramVarArgs.d(10, this.LUK);
      }
      if (this.LUL != null)
      {
        paramVarArgs.ln(11, this.LUL.computeSize());
        this.LUL.writeFields(paramVarArgs);
      }
      if (this.LUM != null)
      {
        paramVarArgs.ln(12, this.LUM.computeSize());
        this.LUM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.Exs) + 0 + f.a.a.b.b.a.bx(2, this.LUG);
      paramInt = i;
      if (this.EvX != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EvX);
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Ext);
      paramInt = i;
      if (this.Exu != null) {
        paramInt = i + f.a.a.a.lm(5, this.Exu.computeSize());
      }
      i = paramInt;
      if (this.Exr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Exr);
      }
      i = i + f.a.a.b.b.a.bx(7, this.LUH) + f.a.a.b.b.a.bx(8, this.LUI);
      paramInt = i;
      if (this.LUJ != null) {
        paramInt = i + f.a.a.a.lm(9, this.LUJ.computeSize());
      }
      i = paramInt;
      if (this.LUK != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.LUK);
      }
      paramInt = i;
      if (this.LUL != null) {
        paramInt = i + f.a.a.a.lm(11, this.LUL.computeSize());
      }
      i = paramInt;
      if (this.LUM != null) {
        i = paramInt + f.a.a.a.lm(12, this.LUM.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Exs.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Exs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.LUG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.EvX = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.Ext = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Exu = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.Exr = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.LUH = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.LUI = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.LUJ = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.LUK = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.LUL = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localc.LUM = ((d)localObject1);
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