package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int FUi;
  public g LUB;
  public String LUC;
  public String LUD;
  public String LUE;
  public String LUF;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LUB != null)
      {
        paramVarArgs.ln(1, this.LUB.computeSize());
        this.LUB.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.LUC != null) {
        paramVarArgs.d(3, this.LUC);
      }
      if (this.LUD != null) {
        paramVarArgs.d(4, this.LUD);
      }
      paramVarArgs.aR(5, this.FUi);
      if (this.LUE != null) {
        paramVarArgs.d(6, this.LUE);
      }
      if (this.LUF != null) {
        paramVarArgs.d(7, this.LUF);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LUB == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lm(1, this.LUB.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.LUC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LUC);
      }
      paramInt = i;
      if (this.LUD != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.LUD);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.FUi);
      paramInt = i;
      if (this.LUE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.LUE);
      }
      i = paramInt;
      if (this.LUF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.LUF);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.LUB = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.LUC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.LUD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.FUi = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.LUE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.LUF = ((f.a.a.a.a)localObject1).LVo.readString();
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