package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public String EQP;
  public int LUA;
  public g LUB;
  public String LUy;
  public String LUz;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91743);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.LUy != null) {
        paramVarArgs.d(1, this.LUy);
      }
      if (this.LUz != null) {
        paramVarArgs.d(2, this.LUz);
      }
      paramVarArgs.aR(3, this.LUA);
      if (this.EQP != null) {
        paramVarArgs.d(4, this.EQP);
      }
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.LUB != null)
      {
        paramVarArgs.ln(6, this.LUB.computeSize());
        this.LUB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LUy == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.LUy) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LUz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.LUz);
      }
      i += f.a.a.b.b.a.bx(3, this.LUA);
      paramInt = i;
      if (this.EQP != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EQP);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.url);
      }
      paramInt = i;
      if (this.LUB != null) {
        paramInt = i + f.a.a.a.lm(6, this.LUB.computeSize());
      }
      AppMethodBeat.o(91743);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91743);
          return -1;
        case 1: 
          locale.LUy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 2: 
          locale.LUz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 3: 
          locale.LUA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91743);
          return 0;
        case 4: 
          locale.EQP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 5: 
          locale.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91743);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.LUB = ((g)localObject1);
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