package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvx
  extends com.tencent.mm.cd.a
{
  public String TEF;
  public String TEG;
  public String TEH;
  public int TEI;
  public String TEJ;
  public up TEK;
  public String TEL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249321);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TEF != null) {
        paramVarArgs.f(1, this.TEF);
      }
      if (this.TEG != null) {
        paramVarArgs.f(2, this.TEG);
      }
      if (this.TEH != null) {
        paramVarArgs.f(3, this.TEH);
      }
      paramVarArgs.aY(4, this.TEI);
      if (this.TEJ != null) {
        paramVarArgs.f(5, this.TEJ);
      }
      if (this.TEK != null)
      {
        paramVarArgs.oE(6, this.TEK.computeSize());
        this.TEK.writeFields(paramVarArgs);
      }
      if (this.TEL != null) {
        paramVarArgs.f(7, this.TEL);
      }
      AppMethodBeat.o(249321);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TEF == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.b.b.a.g(1, this.TEF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TEG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TEG);
      }
      i = paramInt;
      if (this.TEH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TEH);
      }
      i += g.a.a.b.b.a.bM(4, this.TEI);
      paramInt = i;
      if (this.TEJ != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TEJ);
      }
      i = paramInt;
      if (this.TEK != null) {
        i = paramInt + g.a.a.a.oD(6, this.TEK.computeSize());
      }
      paramInt = i;
      if (this.TEL != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TEL);
      }
      AppMethodBeat.o(249321);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249321);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cvx localcvx = (cvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249321);
          return -1;
        case 1: 
          localcvx.TEF = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249321);
          return 0;
        case 2: 
          localcvx.TEG = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249321);
          return 0;
        case 3: 
          localcvx.TEH = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249321);
          return 0;
        case 4: 
          localcvx.TEI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(249321);
          return 0;
        case 5: 
          localcvx.TEJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249321);
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
            localcvx.TEK = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(249321);
          return 0;
        }
        localcvx.TEL = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(249321);
        return 0;
      }
      AppMethodBeat.o(249321);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvx
 * JD-Core Version:    0.7.0.1
 */