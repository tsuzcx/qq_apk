package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class ayp
  extends dyl
{
  public aqe RLM;
  public String RLN;
  public b RLO;
  public LinkedList<Integer> SKz;
  public long klE;
  public long object_id;
  public int scene;
  
  public ayp()
  {
    AppMethodBeat.i(231069);
    this.SKz = new LinkedList();
    AppMethodBeat.o(231069);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231078);
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
      paramVarArgs.e(4, 2, this.SKz);
      paramVarArgs.aY(5, this.scene);
      if (this.RLO != null) {
        paramVarArgs.c(6, this.RLO);
      }
      paramVarArgs.bm(7, this.klE);
      paramVarArgs.bm(8, this.object_id);
      AppMethodBeat.o(231078);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label741;
      }
    }
    label741:
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
      i = i + g.a.a.a.c(4, 2, this.SKz) + g.a.a.b.b.a.bM(5, this.scene);
      paramInt = i;
      if (this.RLO != null) {
        paramInt = i + g.a.a.b.b.a.b(6, this.RLO);
      }
      i = g.a.a.b.b.a.p(7, this.klE);
      int j = g.a.a.b.b.a.p(8, this.object_id);
      AppMethodBeat.o(231078);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SKz.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231078);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ayp localayp = (ayp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231078);
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
            localayp.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231078);
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
            localayp.RLM = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231078);
          return 0;
        case 3: 
          localayp.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(231078);
          return 0;
        case 4: 
          localayp.SKz.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(231078);
          return 0;
        case 5: 
          localayp.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(231078);
          return 0;
        case 6: 
          localayp.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231078);
          return 0;
        case 7: 
          localayp.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231078);
          return 0;
        }
        localayp.object_id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(231078);
        return 0;
      }
      AppMethodBeat.o(231078);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayp
 * JD-Core Version:    0.7.0.1
 */