package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class gx
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public long klE;
  public long object_id;
  public int scene;
  public String xal;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(230654);
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
      paramVarArgs.bm(4, this.object_id);
      paramVarArgs.bm(5, this.klE);
      if (this.xal != null) {
        paramVarArgs.f(6, this.xal);
      }
      if (this.RLO != null) {
        paramVarArgs.c(7, this.RLO);
      }
      paramVarArgs.aY(8, this.scene);
      AppMethodBeat.o(230654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
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
      i = i + g.a.a.b.b.a.p(4, this.object_id) + g.a.a.b.b.a.p(5, this.klE);
      paramInt = i;
      if (this.xal != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.xal);
      }
      i = paramInt;
      if (this.RLO != null) {
        i = paramInt + g.a.a.b.b.a.b(7, this.RLO);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.scene);
      AppMethodBeat.o(230654);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(230654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gx localgx = (gx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(230654);
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
            localgx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230654);
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
            localgx.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(230654);
          return 0;
        case 3: 
          localgx.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230654);
          return 0;
        case 4: 
          localgx.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230654);
          return 0;
        case 5: 
          localgx.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(230654);
          return 0;
        case 6: 
          localgx.xal = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(230654);
          return 0;
        case 7: 
          localgx.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(230654);
          return 0;
        }
        localgx.scene = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(230654);
        return 0;
      }
      AppMethodBeat.o(230654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gx
 * JD-Core Version:    0.7.0.1
 */