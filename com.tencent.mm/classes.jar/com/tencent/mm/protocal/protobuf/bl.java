package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bl
  extends com.tencent.mm.cd.a
{
  public String RGA = "";
  public String RGB = "";
  public long RGC = 0L;
  public int RGD = 0;
  public esj RGy;
  public String RGz = "";
  public int flags = -1;
  public int state = -1;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122482);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RGy != null)
      {
        paramVarArgs.oE(1, this.RGy.computeSize());
        this.RGy.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.flags);
      paramVarArgs.aY(3, this.state);
      if (this.RGz != null) {
        paramVarArgs.f(4, this.RGz);
      }
      if (this.RGA != null) {
        paramVarArgs.f(5, this.RGA);
      }
      if (this.RGB != null) {
        paramVarArgs.f(6, this.RGB);
      }
      paramVarArgs.bm(7, this.RGC);
      paramVarArgs.aY(8, this.RGD);
      AppMethodBeat.o(122482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RGy == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = g.a.a.a.oD(1, this.RGy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.flags) + g.a.a.b.b.a.bM(3, this.state);
      paramInt = i;
      if (this.RGz != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RGz);
      }
      i = paramInt;
      if (this.RGA != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RGA);
      }
      paramInt = i;
      if (this.RGB != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.RGB);
      }
      i = g.a.a.b.b.a.p(7, this.RGC);
      int j = g.a.a.b.b.a.bM(8, this.RGD);
      AppMethodBeat.o(122482);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(122482);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bl localbl = (bl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122482);
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
            localbl.RGy = localesj;
            paramInt += 1;
          }
          AppMethodBeat.o(122482);
          return 0;
        case 2: 
          localbl.flags = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122482);
          return 0;
        case 3: 
          localbl.state = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(122482);
          return 0;
        case 4: 
          localbl.RGz = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 5: 
          localbl.RGA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 6: 
          localbl.RGB = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(122482);
          return 0;
        case 7: 
          localbl.RGC = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(122482);
          return 0;
        }
        localbl.RGD = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(122482);
        return 0;
      }
      AppMethodBeat.o(122482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bl
 * JD-Core Version:    0.7.0.1
 */