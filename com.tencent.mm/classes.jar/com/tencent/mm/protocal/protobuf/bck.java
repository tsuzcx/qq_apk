package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bck
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public b SDI;
  public long klE;
  public long object_id;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229416);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(2, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(3, this.RLN);
      }
      if (this.RLO != null) {
        paramVarArgs.c(4, this.RLO);
      }
      paramVarArgs.bm(5, this.klE);
      paramVarArgs.bm(6, this.object_id);
      if (this.query != null) {
        paramVarArgs.f(7, this.query);
      }
      if (this.SDI != null) {
        paramVarArgs.c(8, this.SDI);
      }
      AppMethodBeat.o(229416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RLM != null) {
        paramInt = i + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RLN);
      }
      paramInt = i;
      if (this.RLO != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RLO);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.klE) + g.a.a.b.b.a.p(6, this.object_id);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.query);
      }
      i = paramInt;
      if (this.SDI != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.SDI);
      }
      AppMethodBeat.o(229416);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(229416);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bck localbck = (bck)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(229416);
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
            localbck.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229416);
          return 0;
        case 2: 
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
            localbck.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(229416);
          return 0;
        case 3: 
          localbck.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229416);
          return 0;
        case 4: 
          localbck.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(229416);
          return 0;
        case 5: 
          localbck.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229416);
          return 0;
        case 6: 
          localbck.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(229416);
          return 0;
        case 7: 
          localbck.query = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(229416);
          return 0;
        }
        localbck.SDI = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(229416);
        return 0;
      }
      AppMethodBeat.o(229416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bck
 * JD-Core Version:    0.7.0.1
 */