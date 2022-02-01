package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bx.a
{
  public int YAN;
  public g ajFu;
  public String ajFv;
  public String ajFw;
  public String ajFx;
  public String ajFy;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ajFu != null)
      {
        paramVarArgs.qD(1, this.ajFu.computeSize());
        this.ajFu.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.ajFv != null) {
        paramVarArgs.g(3, this.ajFv);
      }
      if (this.ajFw != null) {
        paramVarArgs.g(4, this.ajFw);
      }
      paramVarArgs.bS(5, this.YAN);
      if (this.ajFx != null) {
        paramVarArgs.g(6, this.ajFx);
      }
      if (this.ajFy != null) {
        paramVarArgs.g(7, this.ajFy);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ajFu == null) {
        break label632;
      }
    }
    label632:
    for (int i = i.a.a.a.qC(1, this.ajFu.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.ajFv != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ajFv);
      }
      paramInt = i;
      if (this.ajFw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ajFw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YAN);
      paramInt = i;
      if (this.ajFx != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ajFx);
      }
      i = paramInt;
      if (this.ajFy != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ajFy);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91739);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            g localg = new g();
            if ((localObject != null) && (localObject.length > 0)) {
              localg.parseFrom((byte[])localObject);
            }
            localb.ajFu = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.ajFv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.ajFw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.YAN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.ajFx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.ajFy = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91739);
        return 0;
      }
      AppMethodBeat.o(91739);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.b
 * JD-Core Version:    0.7.0.1
 */