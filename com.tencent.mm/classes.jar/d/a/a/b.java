package d.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public g CLk;
  public String CLl;
  public String CLm;
  public String CLn;
  public String CLo;
  public String url;
  public int xWC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(57006);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.CLk != null)
      {
        paramVarArgs.iQ(1, this.CLk.computeSize());
        this.CLk.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.CLl != null) {
        paramVarArgs.e(3, this.CLl);
      }
      if (this.CLm != null) {
        paramVarArgs.e(4, this.CLm);
      }
      paramVarArgs.aO(5, this.xWC);
      if (this.CLn != null) {
        paramVarArgs.e(6, this.CLn);
      }
      if (this.CLo != null) {
        paramVarArgs.e(7, this.CLo);
      }
      AppMethodBeat.o(57006);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CLk == null) {
        break label658;
      }
    }
    label658:
    for (int i = e.a.a.a.iP(1, this.CLk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.CLl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.CLl);
      }
      paramInt = i;
      if (this.CLm != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.CLm);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.xWC);
      paramInt = i;
      if (this.CLn != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.CLn);
      }
      i = paramInt;
      if (this.CLo != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.CLo);
      }
      AppMethodBeat.o(57006);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(57006);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(57006);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.CLk = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(57006);
          return 0;
        case 2: 
          localb.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57006);
          return 0;
        case 3: 
          localb.CLl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57006);
          return 0;
        case 4: 
          localb.CLm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57006);
          return 0;
        case 5: 
          localb.xWC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(57006);
          return 0;
        case 6: 
          localb.CLn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(57006);
          return 0;
        }
        localb.CLo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(57006);
        return 0;
      }
      AppMethodBeat.o(57006);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     d.a.a.b
 * JD-Core Version:    0.7.0.1
 */