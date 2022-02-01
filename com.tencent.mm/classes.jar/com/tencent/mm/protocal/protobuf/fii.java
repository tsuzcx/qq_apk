package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fii
  extends dyl
{
  public int Pyz;
  public double UIg;
  public double UIh;
  public String UIi;
  public LinkedList<ezm> UIj;
  public int scene;
  public String sessionId;
  
  public fii()
  {
    AppMethodBeat.i(121112);
    this.UIj = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, this.UIg);
      paramVarArgs.e(3, this.UIh);
      if (this.UIi != null) {
        paramVarArgs.f(4, this.UIi);
      }
      paramVarArgs.aY(5, this.Pyz);
      if (this.sessionId != null) {
        paramVarArgs.f(6, this.sessionId);
      }
      paramVarArgs.aY(7, this.scene);
      paramVarArgs.e(8, 8, this.UIj);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (g.a.a.b.b.a.gL(2) + 8) + (g.a.a.b.b.a.gL(3) + 8);
      paramInt = i;
      if (this.UIi != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.UIi);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Pyz);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.sessionId);
      }
      i = g.a.a.b.b.a.bM(7, this.scene);
      int j = g.a.a.a.c(8, 8, this.UIj);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UIj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fii localfii = (fii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfii.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localfii.UIg = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localfii.UIh = Double.longBitsToDouble(((g.a.a.a.a)localObject1).abFh.AP());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localfii.UIi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localfii.Pyz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localfii.sessionId = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localfii.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ezm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ezm)localObject2).parseFrom((byte[])localObject1);
          }
          localfii.UIj.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fii
 * JD-Core Version:    0.7.0.1
 */