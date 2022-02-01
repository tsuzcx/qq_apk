package g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String aauB;
  public String ajFr;
  public String ajFs;
  public int ajFt;
  public g ajFu;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91743);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ajFr != null) {
        paramVarArgs.g(1, this.ajFr);
      }
      if (this.ajFs != null) {
        paramVarArgs.g(2, this.ajFs);
      }
      paramVarArgs.bS(3, this.ajFt);
      if (this.aauB != null) {
        paramVarArgs.g(4, this.aauB);
      }
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      if (this.ajFu != null)
      {
        paramVarArgs.qD(6, this.ajFu.computeSize());
        this.ajFu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ajFr == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.b.b.a.h(1, this.ajFr) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ajFs != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ajFs);
      }
      i += i.a.a.b.b.a.cJ(3, this.ajFt);
      paramInt = i;
      if (this.aauB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aauB);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.url);
      }
      paramInt = i;
      if (this.ajFu != null) {
        paramInt = i + i.a.a.a.qC(6, this.ajFu.computeSize());
      }
      AppMethodBeat.o(91743);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91743);
          return -1;
        case 1: 
          locale.ajFr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 2: 
          locale.ajFs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 3: 
          locale.ajFt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91743);
          return 0;
        case 4: 
          locale.aauB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 5: 
          locale.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91743);
          return 0;
        }
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
          locale.ajFu = localg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     g.a.a.e
 * JD-Core Version:    0.7.0.1
 */