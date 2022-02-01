package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String LXU;
  public String UaZ;
  public String Uba;
  public int Ubb;
  public g Ubc;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91743);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UaZ != null) {
        paramVarArgs.e(1, this.UaZ);
      }
      if (this.Uba != null) {
        paramVarArgs.e(2, this.Uba);
      }
      paramVarArgs.aM(3, this.Ubb);
      if (this.LXU != null) {
        paramVarArgs.e(4, this.LXU);
      }
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.Ubc != null)
      {
        paramVarArgs.ni(6, this.Ubc.computeSize());
        this.Ubc.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UaZ == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.b.b.a.f(1, this.UaZ) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Uba != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Uba);
      }
      i += g.a.a.b.b.a.bu(3, this.Ubb);
      paramInt = i;
      if (this.LXU != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LXU);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.url);
      }
      paramInt = i;
      if (this.Ubc != null) {
        paramInt = i + g.a.a.a.nh(6, this.Ubc.computeSize());
      }
      AppMethodBeat.o(91743);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91743);
          return -1;
        case 1: 
          locale.UaZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 2: 
          locale.Uba = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 3: 
          locale.Ubb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91743);
          return 0;
        case 4: 
          locale.LXU = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 5: 
          locale.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91743);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.Ubc = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      AppMethodBeat.o(91743);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.e
 * JD-Core Version:    0.7.0.1
 */