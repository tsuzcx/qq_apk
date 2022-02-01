package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmn
  extends com.tencent.mm.cd.a
{
  public esj SXr;
  public String SXs = "";
  public int SXt = 0;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SXr != null)
      {
        paramVarArgs.oE(1, this.SXr.computeSize());
        this.SXr.writeFields(paramVarArgs);
      }
      if (this.SXs != null) {
        paramVarArgs.f(2, this.SXs);
      }
      paramVarArgs.bm(3, this.timestamp);
      paramVarArgs.aY(4, this.SXt);
      AppMethodBeat.o(122492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SXr == null) {
        break label440;
      }
    }
    label440:
    for (paramInt = g.a.a.a.oD(1, this.SXr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SXs != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SXs);
      }
      paramInt = g.a.a.b.b.a.p(3, this.timestamp);
      int j = g.a.a.b.b.a.bM(4, this.SXt);
      AppMethodBeat.o(122492);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bmn localbmn = (bmn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122492);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            esj localesj = new esj();
            if ((localObject != null) && (localObject.length > 0)) {
              localesj.parseFrom((byte[])localObject);
            }
            localbmn.SXr = localesj;
            paramInt += 1;
          }
          AppMethodBeat.o(122492);
          return 0;
        case 2: 
          localbmn.SXs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122492);
          return 0;
        case 3: 
          localbmn.timestamp = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122492);
          return 0;
        }
        localbmn.SXt = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(122492);
        return 0;
      }
      AppMethodBeat.o(122492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmn
 * JD-Core Version:    0.7.0.1
 */