package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class d
  extends com.tencent.mm.bx.a
{
  public String Zjn;
  public int ajFG;
  public String ajFH;
  public String ajFI;
  public String ajFJ;
  public long ajFK;
  public int ajFL;
  public h ajFM;
  public String ajFN;
  public String ajFO;
  public String ajFP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91742);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ajFG);
      if (this.ajFH != null) {
        paramVarArgs.g(2, this.ajFH);
      }
      if (this.ajFI != null) {
        paramVarArgs.g(3, this.ajFI);
      }
      if (this.ajFJ != null) {
        paramVarArgs.g(5, this.ajFJ);
      }
      paramVarArgs.bv(6, this.ajFK);
      if (this.Zjn != null) {
        paramVarArgs.g(7, this.Zjn);
      }
      paramVarArgs.bS(8, this.ajFL);
      if (this.ajFM != null)
      {
        paramVarArgs.qD(9, this.ajFM.computeSize());
        this.ajFM.writeFields(paramVarArgs);
      }
      if (this.ajFN != null) {
        paramVarArgs.g(10, this.ajFN);
      }
      if (this.ajFO != null) {
        paramVarArgs.g(11, this.ajFO);
      }
      if (this.ajFP != null) {
        paramVarArgs.g(12, this.ajFP);
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ajFG) + 0;
      paramInt = i;
      if (this.ajFH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ajFH);
      }
      i = paramInt;
      if (this.ajFI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ajFI);
      }
      paramInt = i;
      if (this.ajFJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ajFJ);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.ajFK);
      paramInt = i;
      if (this.Zjn != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zjn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.ajFL);
      paramInt = i;
      if (this.ajFM != null) {
        paramInt = i + i.a.a.a.qC(9, this.ajFM.computeSize());
      }
      i = paramInt;
      if (this.ajFN != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ajFN);
      }
      paramInt = i;
      if (this.ajFO != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ajFO);
      }
      i = paramInt;
      if (this.ajFP != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ajFP);
      }
      AppMethodBeat.o(91742);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91742);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 4: 
      default: 
        AppMethodBeat.o(91742);
        return -1;
      case 1: 
        locald.ajFG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91742);
        return 0;
      case 2: 
        locald.ajFH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 3: 
        locald.ajFI = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 5: 
        locald.ajFJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 6: 
        locald.ajFK = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(91742);
        return 0;
      case 7: 
        locald.Zjn = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 8: 
        locald.ajFL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91742);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          h localh = new h();
          if ((localObject != null) && (localObject.length > 0)) {
            localh.parseFrom((byte[])localObject);
          }
          locald.ajFM = localh;
          paramInt += 1;
        }
        AppMethodBeat.o(91742);
        return 0;
      case 10: 
        locald.ajFN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91742);
        return 0;
      case 11: 
        locald.ajFO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91742);
        return 0;
      }
      locald.ajFP = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(91742);
      return 0;
    }
    AppMethodBeat.o(91742);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.d
 * JD-Core Version:    0.7.0.1
 */