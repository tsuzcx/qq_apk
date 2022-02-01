package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.bx.a
{
  public b Zab;
  public String ajFQ;
  public String ajFR;
  public String ajFS;
  public String ajFT;
  public String ajFU;
  public int ajFV;
  public e ajFW;
  public b ajFX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ajFQ != null) {
        paramVarArgs.g(1, this.ajFQ);
      }
      if (this.ajFR != null) {
        paramVarArgs.g(2, this.ajFR);
      }
      if (this.ajFS != null) {
        paramVarArgs.g(3, this.ajFS);
      }
      if (this.ajFT != null) {
        paramVarArgs.g(4, this.ajFT);
      }
      if (this.ajFU != null) {
        paramVarArgs.g(5, this.ajFU);
      }
      paramVarArgs.bS(6, this.ajFV);
      if (this.ajFW != null)
      {
        paramVarArgs.qD(7, this.ajFW.computeSize());
        this.ajFW.writeFields(paramVarArgs);
      }
      if (this.ajFX != null) {
        paramVarArgs.d(8, this.ajFX);
      }
      if (this.Zab != null) {
        paramVarArgs.d(9, this.Zab);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ajFQ == null) {
        break label756;
      }
    }
    label756:
    for (int i = i.a.a.b.b.a.h(1, this.ajFQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ajFR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ajFR);
      }
      i = paramInt;
      if (this.ajFS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ajFS);
      }
      paramInt = i;
      if (this.ajFT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ajFT);
      }
      i = paramInt;
      if (this.ajFU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ajFU);
      }
      i += i.a.a.b.b.a.cJ(6, this.ajFV);
      paramInt = i;
      if (this.ajFW != null) {
        paramInt = i + i.a.a.a.qC(7, this.ajFW.computeSize());
      }
      i = paramInt;
      if (this.ajFX != null) {
        i = paramInt + i.a.a.b.b.a.c(8, this.ajFX);
      }
      paramInt = i;
      if (this.Zab != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.Zab);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91744);
          return -1;
        case 1: 
          localf.ajFQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.ajFR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.ajFS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.ajFT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.ajFU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.ajFV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            localf.ajFW = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.ajFX = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.Zab = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.f
 * JD-Core Version:    0.7.0.1
 */