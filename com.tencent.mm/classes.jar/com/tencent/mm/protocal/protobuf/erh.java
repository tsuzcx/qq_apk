package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class erh
  extends erp
{
  public int IJG;
  public int abve;
  public LinkedList<etl> abvf;
  public etl abvg;
  public etl abvh;
  
  public erh()
  {
    AppMethodBeat.i(148654);
    this.abvf = new LinkedList();
    AppMethodBeat.o(148654);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148655);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abve);
      paramVarArgs.e(3, 8, this.abvf);
      if (this.abvg != null)
      {
        paramVarArgs.qD(4, this.abvg.computeSize());
        this.abvg.writeFields(paramVarArgs);
      }
      if (this.abvh != null)
      {
        paramVarArgs.qD(5, this.abvh.computeSize());
        this.abvh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.IJG);
      AppMethodBeat.o(148655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abve) + i.a.a.a.c(3, 8, this.abvf);
      paramInt = i;
      if (this.abvg != null) {
        paramInt = i + i.a.a.a.qC(4, this.abvg.computeSize());
      }
      i = paramInt;
      if (this.abvh != null) {
        i = paramInt + i.a.a.a.qC(5, this.abvh.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.IJG);
      AppMethodBeat.o(148655);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abvf.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(148655);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        erh localerh = (erh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(148655);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localerh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148655);
          return 0;
        case 2: 
          localerh.abve = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(148655);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localerh.abvf.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148655);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localerh.abvg = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148655);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localerh.abvh = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(148655);
          return 0;
        }
        localerh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(148655);
        return 0;
      }
      AppMethodBeat.o(148655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erh
 * JD-Core Version:    0.7.0.1
 */