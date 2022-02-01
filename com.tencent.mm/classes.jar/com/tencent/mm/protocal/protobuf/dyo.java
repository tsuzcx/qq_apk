package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyo
  extends dyl
{
  public int EtI;
  public String EtJ;
  public long InT;
  public int RDl;
  public int Uec;
  public int Ued;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91671);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.aY(3, this.EtI);
      paramVarArgs.aY(4, this.RDl);
      paramVarArgs.bm(5, this.InT);
      paramVarArgs.aY(6, this.Uec);
      if (this.EtJ != null) {
        paramVarArgs.f(7, this.EtJ);
      }
      paramVarArgs.aY(8, this.Ued);
      AppMethodBeat.o(91671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label628;
      }
    }
    label628:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      i = i + g.a.a.b.b.a.bM(3, this.EtI) + g.a.a.b.b.a.bM(4, this.RDl) + g.a.a.b.b.a.p(5, this.InT) + g.a.a.b.b.a.bM(6, this.Uec);
      paramInt = i;
      if (this.EtJ != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.EtJ);
      }
      i = g.a.a.b.b.a.bM(8, this.Ued);
      AppMethodBeat.o(91671);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dyo localdyo = (dyo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91671);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdyo.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91671);
          return 0;
        case 2: 
          localdyo.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91671);
          return 0;
        case 3: 
          localdyo.EtI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91671);
          return 0;
        case 4: 
          localdyo.RDl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91671);
          return 0;
        case 5: 
          localdyo.InT = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(91671);
          return 0;
        case 6: 
          localdyo.Uec = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91671);
          return 0;
        case 7: 
          localdyo.EtJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91671);
          return 0;
        }
        localdyo.Ued = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(91671);
        return 0;
      }
      AppMethodBeat.o(91671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyo
 * JD-Core Version:    0.7.0.1
 */