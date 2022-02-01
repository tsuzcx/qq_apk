package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bw.a
{
  public String LjW;
  public int Ubo;
  public String Ubp;
  public String Ubq;
  public String Ubr;
  public long Ubs;
  public int Ubt;
  public h Ubu;
  public String Ubv;
  public String Ubw;
  public String Ubx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Ubo);
      if (this.Ubp != null) {
        paramVarArgs.e(2, this.Ubp);
      }
      if (this.Ubq != null) {
        paramVarArgs.e(3, this.Ubq);
      }
      if (this.Ubr != null) {
        paramVarArgs.e(5, this.Ubr);
      }
      paramVarArgs.bb(6, this.Ubs);
      if (this.LjW != null) {
        paramVarArgs.e(7, this.LjW);
      }
      paramVarArgs.aM(8, this.Ubt);
      if (this.Ubu != null)
      {
        paramVarArgs.ni(9, this.Ubu.computeSize());
        this.Ubu.writeFields(paramVarArgs);
      }
      if (this.Ubv != null) {
        paramVarArgs.e(10, this.Ubv);
      }
      if (this.Ubw != null) {
        paramVarArgs.e(11, this.Ubw);
      }
      if (this.Ubx != null) {
        paramVarArgs.e(12, this.Ubx);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.Ubo) + 0;
      paramInt = i;
      if (this.Ubp != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Ubp);
      }
      i = paramInt;
      if (this.Ubq != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ubq);
      }
      paramInt = i;
      if (this.Ubr != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Ubr);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.Ubs);
      paramInt = i;
      if (this.LjW != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LjW);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.Ubt);
      paramInt = i;
      if (this.Ubu != null) {
        paramInt = i + g.a.a.a.nh(9, this.Ubu.computeSize());
      }
      i = paramInt;
      if (this.Ubv != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.Ubv);
      }
      paramInt = i;
      if (this.Ubw != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Ubw);
      }
      i = paramInt;
      if (this.Ubx != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Ubx);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(91742);
        return -1;
      case 1: 
        locald.Ubo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.Ubp = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.Ubq = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.Ubr = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.Ubs = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.LjW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.Ubt = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new h();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((h)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locald.Ubu = ((h)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.Ubv = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.Ubw = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.Ubx = ((g.a.a.a.a)localObject1).UbS.readString();
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