package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class uk
  extends com.tencent.mm.cd.a
{
  public String SeW;
  public String SeX;
  public String SeY;
  public int SeZ;
  public String Sfa;
  public up Sfb;
  public String Sfc;
  public int Sfd;
  public int Sfe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SeW != null) {
        paramVarArgs.f(1, this.SeW);
      }
      if (this.SeX != null) {
        paramVarArgs.f(2, this.SeX);
      }
      if (this.SeY != null) {
        paramVarArgs.f(3, this.SeY);
      }
      paramVarArgs.aY(4, this.SeZ);
      if (this.Sfa != null) {
        paramVarArgs.f(5, this.Sfa);
      }
      if (this.Sfb != null)
      {
        paramVarArgs.oE(6, this.Sfb.computeSize());
        this.Sfb.writeFields(paramVarArgs);
      }
      if (this.Sfc != null) {
        paramVarArgs.f(7, this.Sfc);
      }
      paramVarArgs.aY(8, this.Sfd);
      paramVarArgs.aY(9, this.Sfe);
      AppMethodBeat.o(113959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SeW == null) {
        break label732;
      }
    }
    label732:
    for (int i = g.a.a.b.b.a.g(1, this.SeW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SeX != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SeX);
      }
      i = paramInt;
      if (this.SeY != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.SeY);
      }
      i += g.a.a.b.b.a.bM(4, this.SeZ);
      paramInt = i;
      if (this.Sfa != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.Sfa);
      }
      i = paramInt;
      if (this.Sfb != null) {
        i = paramInt + g.a.a.a.oD(6, this.Sfb.computeSize());
      }
      paramInt = i;
      if (this.Sfc != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.Sfc);
      }
      i = g.a.a.b.b.a.bM(8, this.Sfd);
      int j = g.a.a.b.b.a.bM(9, this.Sfe);
      AppMethodBeat.o(113959);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(113959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        uk localuk = (uk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113959);
          return -1;
        case 1: 
          localuk.SeW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 2: 
          localuk.SeX = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 3: 
          localuk.SeY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 4: 
          localuk.SeZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113959);
          return 0;
        case 5: 
          localuk.Sfa = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 6: 
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
            localuk.Sfb = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(113959);
          return 0;
        case 7: 
          localuk.Sfc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(113959);
          return 0;
        case 8: 
          localuk.Sfd = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(113959);
          return 0;
        }
        localuk.Sfe = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(113959);
        return 0;
      }
      AppMethodBeat.o(113959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uk
 * JD-Core Version:    0.7.0.1
 */