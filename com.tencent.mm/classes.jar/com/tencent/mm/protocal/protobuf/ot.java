package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ot
  extends dyl
{
  public LinkedList<oq> RWS;
  public int RWT;
  public int RWU;
  public int RWV;
  public int RWW;
  public or RWX;
  public int scene;
  
  public ot()
  {
    AppMethodBeat.i(124438);
    this.RWS = new LinkedList();
    AppMethodBeat.o(124438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124439);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.RWS);
      paramVarArgs.aY(3, this.scene);
      paramVarArgs.aY(4, this.RWT);
      paramVarArgs.aY(7, this.RWU);
      paramVarArgs.aY(8, this.RWV);
      paramVarArgs.aY(9, this.RWW);
      if (this.RWX != null)
      {
        paramVarArgs.oE(10, this.RWX.computeSize());
        this.RWX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124439);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.RWS) + g.a.a.b.b.a.bM(3, this.scene) + g.a.a.b.b.a.bM(4, this.RWT) + g.a.a.b.b.a.bM(7, this.RWU) + g.a.a.b.b.a.bM(8, this.RWV) + g.a.a.b.b.a.bM(9, this.RWW);
      paramInt = i;
      if (this.RWX != null) {
        paramInt = i + g.a.a.a.oD(10, this.RWX.computeSize());
      }
      AppMethodBeat.o(124439);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RWS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(124439);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ot localot = (ot)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        default: 
          AppMethodBeat.o(124439);
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
            localot.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new oq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((oq)localObject2).parseFrom((byte[])localObject1);
            }
            localot.RWS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124439);
          return 0;
        case 3: 
          localot.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124439);
          return 0;
        case 4: 
          localot.RWT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124439);
          return 0;
        case 7: 
          localot.RWU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124439);
          return 0;
        case 8: 
          localot.RWV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124439);
          return 0;
        case 9: 
          localot.RWW = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124439);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new or();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((or)localObject2).parseFrom((byte[])localObject1);
          }
          localot.RWX = ((or)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124439);
        return 0;
      }
      AppMethodBeat.o(124439);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ot
 * JD-Core Version:    0.7.0.1
 */