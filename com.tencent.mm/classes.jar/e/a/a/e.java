package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public String Thl;
  public String abEo;
  public String abEp;
  public int abEq;
  public g abEr;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91743);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.abEo != null) {
        paramVarArgs.f(1, this.abEo);
      }
      if (this.abEp != null) {
        paramVarArgs.f(2, this.abEp);
      }
      paramVarArgs.aY(3, this.abEq);
      if (this.Thl != null) {
        paramVarArgs.f(4, this.Thl);
      }
      if (this.url != null) {
        paramVarArgs.f(5, this.url);
      }
      if (this.abEr != null)
      {
        paramVarArgs.oE(6, this.abEr.computeSize());
        this.abEr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91743);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abEo == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.b.b.a.g(1, this.abEo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abEp != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.abEp);
      }
      i += g.a.a.b.b.a.bM(3, this.abEq);
      paramInt = i;
      if (this.Thl != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Thl);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.url);
      }
      paramInt = i;
      if (this.abEr != null) {
        paramInt = i + g.a.a.a.oD(6, this.abEr.computeSize());
      }
      AppMethodBeat.o(91743);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91743);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91743);
          return -1;
        case 1: 
          locale.abEo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 2: 
          locale.abEp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 3: 
          locale.abEq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91743);
          return 0;
        case 4: 
          locale.Thl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91743);
          return 0;
        case 5: 
          locale.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91743);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          g localg = new g();
          if ((localObject != null) && (localObject.length > 0)) {
            localg.parseFrom((byte[])localObject);
          }
          locale.abEr = localg;
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