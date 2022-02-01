package e.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class f
  extends com.tencent.mm.cd.a
{
  public b Scj;
  public String abEN;
  public String abEO;
  public String abEP;
  public String abEQ;
  public String abER;
  public int abES;
  public e abET;
  public b abEU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91744);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.abEN != null) {
        paramVarArgs.f(1, this.abEN);
      }
      if (this.abEO != null) {
        paramVarArgs.f(2, this.abEO);
      }
      if (this.abEP != null) {
        paramVarArgs.f(3, this.abEP);
      }
      if (this.abEQ != null) {
        paramVarArgs.f(4, this.abEQ);
      }
      if (this.abER != null) {
        paramVarArgs.f(5, this.abER);
      }
      paramVarArgs.aY(6, this.abES);
      if (this.abET != null)
      {
        paramVarArgs.oE(7, this.abET.computeSize());
        this.abET.writeFields(paramVarArgs);
      }
      if (this.abEU != null) {
        paramVarArgs.c(8, this.abEU);
      }
      if (this.Scj != null) {
        paramVarArgs.c(9, this.Scj);
      }
      AppMethodBeat.o(91744);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abEN == null) {
        break label760;
      }
    }
    label760:
    for (int i = g.a.a.b.b.a.g(1, this.abEN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abEO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.abEO);
      }
      i = paramInt;
      if (this.abEP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.abEP);
      }
      paramInt = i;
      if (this.abEQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.abEQ);
      }
      i = paramInt;
      if (this.abER != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.abER);
      }
      i += g.a.a.b.b.a.bM(6, this.abES);
      paramInt = i;
      if (this.abET != null) {
        paramInt = i + g.a.a.a.oD(7, this.abET.computeSize());
      }
      i = paramInt;
      if (this.abEU != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.abEU);
      }
      paramInt = i;
      if (this.Scj != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.Scj);
      }
      AppMethodBeat.o(91744);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91744);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91744);
          return -1;
        case 1: 
          localf.abEN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 2: 
          localf.abEO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 3: 
          localf.abEP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 4: 
          localf.abEQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 5: 
          localf.abER = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91744);
          return 0;
        case 6: 
          localf.abES = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91744);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            e locale = new e();
            if ((localObject != null) && (localObject.length > 0)) {
              locale.parseFrom((byte[])localObject);
            }
            localf.abET = locale;
            paramInt += 1;
          }
          AppMethodBeat.o(91744);
          return 0;
        case 8: 
          localf.abEU = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(91744);
          return 0;
        }
        localf.Scj = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(91744);
        return 0;
      }
      AppMethodBeat.o(91744);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     e.a.a.f
 * JD-Core Version:    0.7.0.1
 */