package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int NkQ;
  public g Ubc;
  public String Ubd;
  public String Ube;
  public String Ubf;
  public String Ubg;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Ubc != null)
      {
        paramVarArgs.ni(1, this.Ubc.computeSize());
        this.Ubc.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.Ubd != null) {
        paramVarArgs.e(3, this.Ubd);
      }
      if (this.Ube != null) {
        paramVarArgs.e(4, this.Ube);
      }
      paramVarArgs.aM(5, this.NkQ);
      if (this.Ubf != null) {
        paramVarArgs.e(6, this.Ubf);
      }
      if (this.Ubg != null) {
        paramVarArgs.e(7, this.Ubg);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ubc == null) {
        break label658;
      }
    }
    label658:
    for (int i = g.a.a.a.nh(1, this.Ubc.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.Ubd != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Ubd);
      }
      paramInt = i;
      if (this.Ube != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Ube);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.NkQ);
      paramInt = i;
      if (this.Ubf != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Ubf);
      }
      i = paramInt;
      if (this.Ubg != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.Ubg);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91739);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.Ubc = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.Ubd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.Ube = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.NkQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.Ubf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.Ubg = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91739);
        return 0;
      }
      AppMethodBeat.o(91739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.b
 * JD-Core Version:    0.7.0.1
 */