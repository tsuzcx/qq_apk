package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class c
  extends com.tencent.mm.bw.a
{
  public String Gwa;
  public String GxC;
  public LinkedList<i> GxD;
  public int GxE;
  public a GxF;
  public int Oml;
  public int Omm;
  public int Omn;
  public f Omo;
  public String Omp;
  public b Omq;
  public d Omr;
  
  public c()
  {
    AppMethodBeat.i(91740);
    this.GxD = new LinkedList();
    AppMethodBeat.o(91740);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91741);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.GxD);
      paramVarArgs.aS(2, this.Oml);
      if (this.Gwa != null) {
        paramVarArgs.d(3, this.Gwa);
      }
      paramVarArgs.aS(4, this.GxE);
      if (this.GxF != null)
      {
        paramVarArgs.lJ(5, this.GxF.computeSize());
        this.GxF.writeFields(paramVarArgs);
      }
      if (this.GxC != null) {
        paramVarArgs.d(6, this.GxC);
      }
      paramVarArgs.aS(7, this.Omm);
      paramVarArgs.aS(8, this.Omn);
      if (this.Omo != null)
      {
        paramVarArgs.lJ(9, this.Omo.computeSize());
        this.Omo.writeFields(paramVarArgs);
      }
      if (this.Omp != null) {
        paramVarArgs.d(10, this.Omp);
      }
      if (this.Omq != null)
      {
        paramVarArgs.lJ(11, this.Omq.computeSize());
        this.Omq.writeFields(paramVarArgs);
      }
      if (this.Omr != null)
      {
        paramVarArgs.lJ(12, this.Omr.computeSize());
        this.Omr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.GxD) + 0 + f.a.a.b.b.a.bz(2, this.Oml);
      paramInt = i;
      if (this.Gwa != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gwa);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GxE);
      paramInt = i;
      if (this.GxF != null) {
        paramInt = i + f.a.a.a.lI(5, this.GxF.computeSize());
      }
      i = paramInt;
      if (this.GxC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GxC);
      }
      i = i + f.a.a.b.b.a.bz(7, this.Omm) + f.a.a.b.b.a.bz(8, this.Omn);
      paramInt = i;
      if (this.Omo != null) {
        paramInt = i + f.a.a.a.lI(9, this.Omo.computeSize());
      }
      i = paramInt;
      if (this.Omp != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Omp);
      }
      paramInt = i;
      if (this.Omq != null) {
        paramInt = i + f.a.a.a.lI(11, this.Omq.computeSize());
      }
      i = paramInt;
      if (this.Omr != null) {
        i = paramInt + f.a.a.a.lI(12, this.Omr.computeSize());
      }
      AppMethodBeat.o(91741);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GxD.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new i();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((i)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.GxD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 2: 
        localc.Oml = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 3: 
        localc.Gwa = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 4: 
        localc.GxE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new a();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((a)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.GxF = ((a)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 6: 
        localc.GxC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 7: 
        localc.Omm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 8: 
        localc.Omn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91741);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new f();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Omo = ((f)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      case 10: 
        localc.Omp = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91741);
        return 0;
      case 11: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new b();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((b)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localc.Omq = ((b)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91741);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new d();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localc.Omr = ((d)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91741);
      return 0;
    }
    AppMethodBeat.o(91741);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.c
 * JD-Core Version:    0.7.0.1
 */