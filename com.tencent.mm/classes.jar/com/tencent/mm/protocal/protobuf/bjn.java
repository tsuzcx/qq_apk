package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjn
  extends dyl
{
  public aqo SCW;
  public LinkedList<emr> SFB;
  public long STF;
  public cwb STG;
  public String finderUsername;
  public aqe yjp;
  
  public bjn()
  {
    AppMethodBeat.i(169053);
    this.SFB = new LinkedList();
    AppMethodBeat.o(169053);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169054);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SFB);
      if (this.finderUsername != null) {
        paramVarArgs.f(3, this.finderUsername);
      }
      if (this.yjp != null)
      {
        paramVarArgs.oE(4, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.SCW != null)
      {
        paramVarArgs.oE(5, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(7, this.STF);
      if (this.STG != null)
      {
        paramVarArgs.oE(8, this.STG.computeSize());
        this.STG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169054);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label916;
      }
    }
    label916:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SFB);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.finderUsername);
      }
      i = paramInt;
      if (this.yjp != null) {
        i = paramInt + g.a.a.a.oD(4, this.yjp.computeSize());
      }
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(5, this.SCW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(7, this.STF);
      paramInt = i;
      if (this.STG != null) {
        paramInt = i + g.a.a.a.oD(8, this.STG.computeSize());
      }
      AppMethodBeat.o(169054);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SFB.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjn localbjn = (bjn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(169054);
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
            localbjn.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emr)localObject2).parseFrom((byte[])localObject1);
            }
            localbjn.SFB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 3: 
          localbjn.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(169054);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localbjn.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localbjn.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(169054);
          return 0;
        case 7: 
          localbjn.STF = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(169054);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cwb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cwb)localObject2).parseFrom((byte[])localObject1);
          }
          localbjn.STG = ((cwb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(169054);
        return 0;
      }
      AppMethodBeat.o(169054);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjn
 * JD-Core Version:    0.7.0.1
 */