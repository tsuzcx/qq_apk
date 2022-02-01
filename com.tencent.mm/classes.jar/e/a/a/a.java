package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public String GAg;
  public String NOX;
  public String NOY;
  public int NOZ;
  public g NPa;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91738);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.NOX != null) {
        paramVarArgs.d(1, this.NOX);
      }
      if (this.NOY != null) {
        paramVarArgs.d(2, this.NOY);
      }
      paramVarArgs.aS(3, this.NOZ);
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.NPa != null)
      {
        paramVarArgs.lC(5, this.NPa.computeSize());
        this.NPa.writeFields(paramVarArgs);
      }
      if (this.GAg != null) {
        paramVarArgs.d(6, this.GAg);
      }
      AppMethodBeat.o(91738);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NOX == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.b.b.a.e(1, this.NOX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.NOY != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.NOY);
      }
      i += f.a.a.b.b.a.bz(3, this.NOZ);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.NPa != null) {
        i = paramInt + f.a.a.a.lB(5, this.NPa.computeSize());
      }
      paramInt = i;
      if (this.GAg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GAg);
      }
      AppMethodBeat.o(91738);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91738);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91738);
          return -1;
        case 1: 
          locala.NOX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 2: 
          locala.NOY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 3: 
          locala.NOZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91738);
          return 0;
        case 4: 
          locala.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91738);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            locala.NPa = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91738);
          return 0;
        }
        locala.GAg = ((f.a.a.a.a)localObject1).NPN.readString();
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