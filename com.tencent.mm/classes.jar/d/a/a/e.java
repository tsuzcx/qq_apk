package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public String CLh;
  public String CLi;
  public int CLj;
  public g CLk;
  public String url;
  public String xcU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57009);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.CLh != null) {
        paramVarArgs.e(1, this.CLh);
      }
      if (this.CLi != null) {
        paramVarArgs.e(2, this.CLi);
      }
      paramVarArgs.aO(3, this.CLj);
      if (this.xcU != null) {
        paramVarArgs.e(4, this.xcU);
      }
      if (this.url != null) {
        paramVarArgs.e(5, this.url);
      }
      if (this.CLk != null)
      {
        paramVarArgs.iQ(6, this.CLk.computeSize());
        this.CLk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(57009);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLh == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = e.a.a.b.b.a.f(1, this.CLh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CLi != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.CLi);
      }
      i += e.a.a.b.b.a.bl(3, this.CLj);
      paramInt = i;
      if (this.xcU != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xcU);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.url);
      }
      paramInt = i;
      if (this.CLk != null) {
        paramInt = i + e.a.a.a.iP(6, this.CLk.computeSize());
      }
      AppMethodBeat.o(57009);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(57009);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(57009);
          return -1;
        case 1: 
          locale.CLh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57009);
          return 0;
        case 2: 
          locale.CLi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57009);
          return 0;
        case 3: 
          locale.CLj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(57009);
          return 0;
        case 4: 
          locale.xcU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57009);
          return 0;
        case 5: 
          locale.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57009);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new g();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locale.CLk = ((g)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(57009);
        return 0;
      }
      AppMethodBeat.o(57009);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     d.a.a.e
 * JD-Core Version:    0.7.0.1
 */