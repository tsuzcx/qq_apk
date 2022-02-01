package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public int HYJ;
  public g Omg;
  public String Omh;
  public String Omi;
  public String Omj;
  public String Omk;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Omg != null)
      {
        paramVarArgs.lJ(1, this.Omg.computeSize());
        this.Omg.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.Omh != null) {
        paramVarArgs.d(3, this.Omh);
      }
      if (this.Omi != null) {
        paramVarArgs.d(4, this.Omi);
      }
      paramVarArgs.aS(5, this.HYJ);
      if (this.Omj != null) {
        paramVarArgs.d(6, this.Omj);
      }
      if (this.Omk != null) {
        paramVarArgs.d(7, this.Omk);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Omg == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lI(1, this.Omg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.Omh != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Omh);
      }
      paramInt = i;
      if (this.Omi != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Omi);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HYJ);
      paramInt = i;
      if (this.Omj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Omj);
      }
      i = paramInt;
      if (this.Omk != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Omk);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.Omg = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.Omh = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.Omi = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.HYJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.Omj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.Omk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91739);
        return 0;
      }
      AppMethodBeat.o(91739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     e.a.a.b
 * JD-Core Version:    0.7.0.1
 */