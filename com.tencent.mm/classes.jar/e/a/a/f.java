package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bw.a
{
  public b LaX;
  public String UbA;
  public String UbB;
  public String UbC;
  public int UbD;
  public e UbE;
  public b UbF;
  public String Uby;
  public String Ubz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uby != null) {
        paramVarArgs.e(1, this.Uby);
      }
      if (this.Ubz != null) {
        paramVarArgs.e(2, this.Ubz);
      }
      if (this.UbA != null) {
        paramVarArgs.e(3, this.UbA);
      }
      if (this.UbB != null) {
        paramVarArgs.e(4, this.UbB);
      }
      if (this.UbC != null) {
        paramVarArgs.e(5, this.UbC);
      }
      paramVarArgs.aM(6, this.UbD);
      if (this.UbE != null)
      {
        paramVarArgs.ni(7, this.UbE.computeSize());
        this.UbE.writeFields(paramVarArgs);
      }
      if (this.UbF != null) {
        paramVarArgs.c(8, this.UbF);
      }
      if (this.LaX != null) {
        paramVarArgs.c(9, this.LaX);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uby == null) {
        break label782;
      }
    }
    label782:
    for (int i = g.a.a.b.b.a.f(1, this.Uby) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ubz != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Ubz);
      }
      i = paramInt;
      if (this.UbA != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.UbA);
      }
      paramInt = i;
      if (this.UbB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.UbB);
      }
      i = paramInt;
      if (this.UbC != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.UbC);
      }
      i += g.a.a.b.b.a.bu(6, this.UbD);
      paramInt = i;
      if (this.UbE != null) {
        paramInt = i + g.a.a.a.nh(7, this.UbE.computeSize());
      }
      i = paramInt;
      if (this.UbF != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.UbF);
      }
      paramInt = i;
      if (this.LaX != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.LaX);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91744);
          return -1;
        case 1: 
          localf.Uby = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.Ubz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.UbA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.UbB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.UbC = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.UbD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localf.UbE = ((e)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.UbF = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.LaX = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.7.0.1
 */