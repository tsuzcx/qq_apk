package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ud
  extends com.tencent.mm.cd.a
{
  public String Seu;
  public String Sev;
  public String Sew;
  public int Sex;
  public up Sey;
  public int Sez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113953);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Seu != null) {
        paramVarArgs.f(1, this.Seu);
      }
      if (this.Sev != null) {
        paramVarArgs.f(2, this.Sev);
      }
      if (this.Sew != null) {
        paramVarArgs.f(3, this.Sew);
      }
      paramVarArgs.aY(4, this.Sex);
      if (this.Sey != null)
      {
        paramVarArgs.oE(5, this.Sey.computeSize());
        this.Sey.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.Sez);
      AppMethodBeat.o(113953);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Seu == null) {
        break label560;
      }
    }
    label560:
    for (int i = g.a.a.b.b.a.g(1, this.Seu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sev != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Sev);
      }
      i = paramInt;
      if (this.Sew != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Sew);
      }
      i += g.a.a.b.b.a.bM(4, this.Sex);
      paramInt = i;
      if (this.Sey != null) {
        paramInt = i + g.a.a.a.oD(5, this.Sey.computeSize());
      }
      i = g.a.a.b.b.a.bM(6, this.Sez);
      AppMethodBeat.o(113953);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113953);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ud localud = (ud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113953);
          return -1;
        case 1: 
          localud.Seu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 2: 
          localud.Sev = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 3: 
          localud.Sew = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113953);
          return 0;
        case 4: 
          localud.Sex = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113953);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            up localup = new up();
            if ((localObject != null) && (localObject.length > 0)) {
              localup.parseFrom((byte[])localObject);
            }
            localud.Sey = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(113953);
          return 0;
        }
        localud.Sez = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(113953);
        return 0;
      }
      AppMethodBeat.o(113953);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ud
 * JD-Core Version:    0.7.0.1
 */