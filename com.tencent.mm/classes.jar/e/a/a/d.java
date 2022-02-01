package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String CWQ;
  public int Khd;
  public String Khe;
  public String Khf;
  public String Khg;
  public long Khh;
  public int Khi;
  public h Khj;
  public String Khk;
  public String Khl;
  public String Khm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Khd);
      if (this.Khe != null) {
        paramVarArgs.d(2, this.Khe);
      }
      if (this.Khf != null) {
        paramVarArgs.d(3, this.Khf);
      }
      if (this.Khg != null) {
        paramVarArgs.d(5, this.Khg);
      }
      paramVarArgs.aG(6, this.Khh);
      if (this.CWQ != null) {
        paramVarArgs.d(7, this.CWQ);
      }
      paramVarArgs.aR(8, this.Khi);
      if (this.Khj != null)
      {
        paramVarArgs.kX(9, this.Khj.computeSize());
        this.Khj.writeFields(paramVarArgs);
      }
      if (this.Khk != null) {
        paramVarArgs.d(10, this.Khk);
      }
      if (this.Khl != null) {
        paramVarArgs.d(11, this.Khl);
      }
      if (this.Khm != null) {
        paramVarArgs.d(12, this.Khm);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Khd) + 0;
      paramInt = i;
      if (this.Khe != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Khe);
      }
      i = paramInt;
      if (this.Khf != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Khf);
      }
      paramInt = i;
      if (this.Khg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Khg);
      }
      i = paramInt + f.a.a.b.b.a.q(6, this.Khh);
      paramInt = i;
      if (this.CWQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CWQ);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.Khi);
      paramInt = i;
      if (this.Khj != null) {
        paramInt = i + f.a.a.a.kW(9, this.Khj.computeSize());
      }
      i = paramInt;
      if (this.Khk != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Khk);
      }
      paramInt = i;
      if (this.Khl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Khl);
      }
      i = paramInt;
      if (this.Khm != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Khm);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(91742);
        return -1;
      case 1: 
        locald.Khd = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.Khe = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.Khf = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.Khg = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.Khh = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.CWQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.Khi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locald.Khj = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.Khk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.Khl = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.Khm = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91742);
      return 0;
    }
    AppMethodBeat.o(91742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.d
 * JD-Core Version:    0.7.0.1
 */