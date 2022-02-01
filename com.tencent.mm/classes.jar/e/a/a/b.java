package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public int Exg;
  public g KgR;
  public String KgS;
  public String KgT;
  public String KgU;
  public String KgV;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.KgR != null)
      {
        paramVarArgs.kX(1, this.KgR.computeSize());
        this.KgR.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.KgS != null) {
        paramVarArgs.d(3, this.KgS);
      }
      if (this.KgT != null) {
        paramVarArgs.d(4, this.KgT);
      }
      paramVarArgs.aR(5, this.Exg);
      if (this.KgU != null) {
        paramVarArgs.d(6, this.KgU);
      }
      if (this.KgV != null) {
        paramVarArgs.d(7, this.KgV);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KgR == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.kW(1, this.KgR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.KgS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.KgS);
      }
      paramInt = i;
      if (this.KgT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.KgT);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Exg);
      paramInt = i;
      if (this.KgU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.KgU);
      }
      i = paramInt;
      if (this.KgV != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.KgV);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91739);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.KgR = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.KgS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.KgT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.Exg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.KgU = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.KgV = ((f.a.a.a.a)localObject1).KhF.readString();
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