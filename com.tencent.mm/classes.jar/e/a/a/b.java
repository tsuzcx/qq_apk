package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.cd.a
{
  public int SLl;
  public g abEr;
  public String abEs;
  public String abEt;
  public String abEu;
  public String abEv;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91739);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.abEr != null)
      {
        paramVarArgs.oE(1, this.abEr.computeSize());
        this.abEr.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.f(2, this.url);
      }
      if (this.abEs != null) {
        paramVarArgs.f(3, this.abEs);
      }
      if (this.abEt != null) {
        paramVarArgs.f(4, this.abEt);
      }
      paramVarArgs.aY(5, this.SLl);
      if (this.abEu != null) {
        paramVarArgs.f(6, this.abEu);
      }
      if (this.abEv != null) {
        paramVarArgs.f(7, this.abEv);
      }
      AppMethodBeat.o(91739);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abEr == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.a.oD(1, this.abEr.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.url);
      }
      i = paramInt;
      if (this.abEs != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.abEs);
      }
      paramInt = i;
      if (this.abEt != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.abEt);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.SLl);
      paramInt = i;
      if (this.abEu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.abEu);
      }
      i = paramInt;
      if (this.abEv != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.abEv);
      }
      AppMethodBeat.o(91739);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91739);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91739);
          return -1;
        case 1: 
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
            localb.abEr = localg;
            paramInt += 1;
          }
          AppMethodBeat.o(91739);
          return 0;
        case 2: 
          localb.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 3: 
          localb.abEs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 4: 
          localb.abEt = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91739);
          return 0;
        case 5: 
          localb.SLl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91739);
          return 0;
        case 6: 
          localb.abEu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91739);
          return 0;
        }
        localb.abEv = ((g.a.a.a.a)localObject).abFh.readString();
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