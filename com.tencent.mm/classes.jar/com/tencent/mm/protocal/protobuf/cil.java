package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cil
  extends com.tencent.mm.cd.a
{
  public cik TfM;
  public boolean Tpq;
  public String icon;
  public int qJt;
  public String tpo;
  public String tsf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72496);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.tpo != null) {
        paramVarArgs.f(1, this.tpo);
      }
      if (this.tsf != null) {
        paramVarArgs.f(2, this.tsf);
      }
      if (this.icon != null) {
        paramVarArgs.f(3, this.icon);
      }
      paramVarArgs.co(4, this.Tpq);
      paramVarArgs.aY(5, this.qJt);
      if (this.TfM != null)
      {
        paramVarArgs.oE(6, this.TfM.computeSize());
        this.TfM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tpo == null) {
        break label556;
      }
    }
    label556:
    for (int i = g.a.a.b.b.a.g(1, this.tpo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tsf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.tsf);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.icon);
      }
      i = i + (g.a.a.b.b.a.gL(4) + 1) + g.a.a.b.b.a.bM(5, this.qJt);
      paramInt = i;
      if (this.TfM != null) {
        paramInt = i + g.a.a.a.oD(6, this.TfM.computeSize());
      }
      AppMethodBeat.o(72496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cil localcil = (cil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72496);
          return -1;
        case 1: 
          localcil.tpo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 2: 
          localcil.tsf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 3: 
          localcil.icon = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 4: 
          localcil.Tpq = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(72496);
          return 0;
        case 5: 
          localcil.qJt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(72496);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cik localcik = new cik();
          if ((localObject != null) && (localObject.length > 0)) {
            localcik.parseFrom((byte[])localObject);
          }
          localcil.TfM = localcik;
          paramInt += 1;
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      AppMethodBeat.o(72496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cil
 * JD-Core Version:    0.7.0.1
 */