package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emj
  extends com.tencent.mm.cd.a
{
  public String SXs;
  public String SXu;
  public boolean SXv = false;
  public esj TqR;
  public esj TqS;
  public String TqT;
  public String TqU;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TqR != null)
      {
        paramVarArgs.oE(1, this.TqR.computeSize());
        this.TqR.writeFields(paramVarArgs);
      }
      if (this.TqS != null)
      {
        paramVarArgs.oE(2, this.TqS.computeSize());
        this.TqS.writeFields(paramVarArgs);
      }
      paramVarArgs.co(3, this.SXv);
      if (this.SXs != null) {
        paramVarArgs.f(4, this.SXs);
      }
      paramVarArgs.aY(5, this.flags);
      if (this.SXu != null) {
        paramVarArgs.f(6, this.SXu);
      }
      if (this.TqT != null) {
        paramVarArgs.f(7, this.TqT);
      }
      if (this.TqU != null) {
        paramVarArgs.f(8, this.TqU);
      }
      paramVarArgs.bm(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TqR == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = g.a.a.a.oD(1, this.TqR.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TqS != null) {
        i = paramInt + g.a.a.a.oD(2, this.TqS.computeSize());
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.SXs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SXs);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.flags);
      paramInt = i;
      if (this.SXu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.SXu);
      }
      i = paramInt;
      if (this.TqT != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TqT);
      }
      paramInt = i;
      if (this.TqU != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TqU);
      }
      i = g.a.a.b.b.a.p(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        emj localemj = (emj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        esj localesj;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localesj = new esj();
            if ((localObject != null) && (localObject.length > 0)) {
              localesj.parseFrom((byte[])localObject);
            }
            localemj.TqR = localesj;
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localesj = new esj();
            if ((localObject != null) && (localObject.length > 0)) {
              localesj.parseFrom((byte[])localObject);
            }
            localemj.TqS = localesj;
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localemj.SXv = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localemj.SXs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localemj.flags = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localemj.SXu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localemj.TqT = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localemj.TqU = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localemj.timestamp = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emj
 * JD-Core Version:    0.7.0.1
 */