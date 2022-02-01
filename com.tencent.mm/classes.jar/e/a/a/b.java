package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public int HEW;
  public g NPa;
  public String NPb;
  public String NPc;
  public String NPd;
  public String NPe;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.NPa != null)
      {
        paramVarArgs.lC(1, this.NPa.computeSize());
        this.NPa.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.NPb != null) {
        paramVarArgs.d(3, this.NPb);
      }
      if (this.NPc != null) {
        paramVarArgs.d(4, this.NPc);
      }
      paramVarArgs.aS(5, this.HEW);
      if (this.NPd != null) {
        paramVarArgs.d(6, this.NPd);
      }
      if (this.NPe != null) {
        paramVarArgs.d(7, this.NPe);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NPa == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lB(1, this.NPa.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.NPb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.NPb);
      }
      paramInt = i;
      if (this.NPc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.NPc);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HEW);
      paramInt = i;
      if (this.NPd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.NPd);
      }
      i = paramInt;
      if (this.NPe != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.NPe);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
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
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new g();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((g)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.NPa = ((g)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.NPb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.NPc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.HEW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.NPd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.NPe = ((f.a.a.a.a)localObject1).NPN.readString();
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