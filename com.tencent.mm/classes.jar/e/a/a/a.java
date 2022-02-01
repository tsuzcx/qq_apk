package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
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
    AppMethodBeat.i(91738);
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
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      if (this.Ubc != null)
      {
        paramVarArgs.ni(5, this.Ubc.computeSize());
        this.Ubc.writeFields(paramVarArgs);
      }
      if (this.LXU != null) {
        paramVarArgs.e(6, this.LXU);
      }
      AppMethodBeat.o(91738);
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
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt;
      if (this.Ubc != null) {
        i = paramInt + g.a.a.a.nh(5, this.Ubc.computeSize());
      }
      paramInt = i;
      if (this.LXU != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LXU);
      }
      AppMethodBeat.o(91738);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91738);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91738);
          return -1;
        case 1: 
          locala.UaZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 2: 
          locala.Uba = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 3: 
          locala.Ubb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91738);
          return 0;
        case 4: 
          locala.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            locala.Ubc = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91738);
          return 0;
        }
        locala.LXU = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91738);
        return 0;
      }
      AppMethodBeat.o(91738);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.a
 * JD-Core Version:    0.7.0.1
 */