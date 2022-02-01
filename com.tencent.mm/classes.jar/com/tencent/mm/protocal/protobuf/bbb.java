package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbb
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public aqt SML;
  public long klE;
  public long object_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231098);
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
      paramVarArgs.bm(3, this.object_id);
      paramVarArgs.bm(4, this.klE);
      if (this.SML != null)
      {
        paramVarArgs.oE(5, this.SML.computeSize());
        this.SML.writeFields(paramVarArgs);
      }
      if (this.RLN != null) {
        paramVarArgs.f(6, this.RLN);
      }
      AppMethodBeat.o(231098);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label700;
      }
    }
    label700:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLM != null) {
        i = paramInt + g.a.a.a.oD(2, this.RLM.computeSize());
      }
      i = i + g.a.a.b.b.a.p(3, this.object_id) + g.a.a.b.b.a.p(4, this.klE);
      paramInt = i;
      if (this.SML != null) {
        paramInt = i + g.a.a.a.oD(5, this.SML.computeSize());
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RLN);
      }
      AppMethodBeat.o(231098);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231098);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bbb localbbb = (bbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231098);
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
            localbbb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231098);
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
            localbbb.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231098);
          return 0;
        case 3: 
          localbbb.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231098);
          return 0;
        case 4: 
          localbbb.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231098);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqt)localObject2).parseFrom((byte[])localObject1);
            }
            localbbb.SML = ((aqt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231098);
          return 0;
        }
        localbbb.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(231098);
        return 0;
      }
      AppMethodBeat.o(231098);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbb
 * JD-Core Version:    0.7.0.1
 */