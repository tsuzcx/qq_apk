package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dic
  extends com.tencent.mm.cd.a
{
  public int TEI;
  public String TPn;
  public String TPo;
  public String TPp;
  public String TPq;
  public up TPr;
  public String TPs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114049);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TPn != null) {
        paramVarArgs.f(1, this.TPn);
      }
      if (this.TPo != null) {
        paramVarArgs.f(2, this.TPo);
      }
      if (this.TPp != null) {
        paramVarArgs.f(3, this.TPp);
      }
      paramVarArgs.aY(4, this.TEI);
      if (this.TPq != null) {
        paramVarArgs.f(5, this.TPq);
      }
      if (this.TPr != null)
      {
        paramVarArgs.oE(6, this.TPr.computeSize());
        this.TPr.writeFields(paramVarArgs);
      }
      if (this.TPs != null) {
        paramVarArgs.f(7, this.TPs);
      }
      AppMethodBeat.o(114049);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TPn == null) {
        break label636;
      }
    }
    label636:
    for (int i = g.a.a.b.b.a.g(1, this.TPn) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TPo != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TPo);
      }
      i = paramInt;
      if (this.TPp != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TPp);
      }
      i += g.a.a.b.b.a.bM(4, this.TEI);
      paramInt = i;
      if (this.TPq != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TPq);
      }
      i = paramInt;
      if (this.TPr != null) {
        i = paramInt + g.a.a.a.oD(6, this.TPr.computeSize());
      }
      paramInt = i;
      if (this.TPs != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TPs);
      }
      AppMethodBeat.o(114049);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(114049);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dic localdic = (dic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114049);
          return -1;
        case 1: 
          localdic.TPn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 2: 
          localdic.TPo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 3: 
          localdic.TPp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114049);
          return 0;
        case 4: 
          localdic.TEI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(114049);
          return 0;
        case 5: 
          localdic.TPq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(114049);
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
            localdic.TPr = localup;
            paramInt += 1;
          }
          AppMethodBeat.o(114049);
          return 0;
        }
        localdic.TPs = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(114049);
        return 0;
      }
      AppMethodBeat.o(114049);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dic
 * JD-Core Version:    0.7.0.1
 */